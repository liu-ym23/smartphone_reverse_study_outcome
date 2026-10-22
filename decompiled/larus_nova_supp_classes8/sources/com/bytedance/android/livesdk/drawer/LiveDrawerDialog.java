package com.bytedance.android.livesdk.drawer;

import am2.x;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerUIManager;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.config.c00;
import com.bytedance.android.livesdk.config.d00;
import com.bytedance.android.livesdk.config.fp;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.config.lp;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.drawer.history.LiveHistoryFragment;
import com.bytedance.android.livesdk.drawer.history.LiveHistoryLynxFragment;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.k4;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdkapi.ILiveDrawerMultiTabView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import j40.b4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ut1.h;
import zg1.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveDrawerDialog extends BaseDialogFragment implements IVideoFloatManager.AutoFloatEnable, com.bytedance.android.live.matchroom.b {
    public static boolean R;
    public boolean A;
    public boolean B;
    public int C;
    public ViewGroup D;
    public ViewGroup E;
    public float F;
    public Boolean G;
    public Boolean H;
    public RelativeLayout I;
    public ut1.c J;
    public View K;
    public View L;
    public yo2.e M;
    public Boolean N;
    public boolean O;
    public ViewGroup P;
    public final g Q;
    public View d;
    public LiveDrawerLayout e;
    public View f;
    public View g;
    public Fragment h;
    public Fragment i;
    public Fragment j;
    public Fragment k;
    public View l;
    public View m;
    public DouyinLoadingLayout n;
    public View o;
    public List<DrawerLayout.DrawerListener> p;
    public Bundle q;
    public RelativeLayout r;
    public TextView s;
    public HSImageView t;
    public ViewGroup u;
    public ViewGroup v;
    public View w;
    public final Keva x;
    public DataCenter y;
    public SingleDrawViewModel z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerDialog a;

        public a(LiveDrawerDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveDrawerDialog r3 = this.a;
            r3.A = true;
            r3.aa0();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerDialog a;

        public b(LiveDrawerDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.aa0();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Room a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ float c;
        public final /* synthetic */ LiveDrawerDialog d;

        public class a extends ut1.a {
            public final /* synthetic */ c a;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.LiveDrawerDialog$c$a$a, reason: collision with other inner class name */
            public class C0119a implements IDrawerUIManager {
                public final /* synthetic */ a a;

                public final void initContentLayout(View r1) {
                }

                public final boolean needExtraItemPadding(List<? extends FeedItem> r1) {
                    return false;
                }

                public final void onDrawerDataChanged(List<? extends FeedItem> r1) {
                }

                public final void onScrollStateChanged(boolean r1, List<? extends FeedItem> r2, ViewGroup r3, int r4) {
                }

                public final void onTabSelect(boolean r1, List<? extends FeedItem> r2, ViewGroup r3) {
                }

                public final int panelSize() {
                    return this.a.a.d.P.getMeasuredWidth();
                }

                public C0119a(a r1) {
                    this.a = r1;
                }
            }

            @Override // ut1.a
            public final void closeDrawerDialog() {
                DrawerLayout r0 = this.a.d.e;
                if (r0 == null) goto L17;
                if (ViewCompat.isAttachedToWindow(r0) == false) goto L17;
                if (this.a.d.e.isDrawerOpen(8388613) == false) goto L17;
                LiveDrawerDialog r1 = this.a.d;
                r1.A = true;
                r1.e.closeDrawer(8388613);
                return;
            L17:
                this.a.d.dismiss();     // Catch: Exception -> L12
                return;
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r2 = DialogFragmentLancet.sLastShowStack;
                if (r2 == null) goto L20;
                com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }

            @Override // ut1.a
            public final void disableDrawerSlide() {
                LiveDrawerDialog r0 = this.a.d;
                DrawerLayout r1 = r0.e;
                if (r1 != null) goto L5;
                return;
            L5:
                if (ViewCompat.isAttachedToWindow(r1) == false) goto L9;
                r0.e.requestDisallowInterceptTouchEvent(true);
                return;
            }

            @Override // ut1.a
            public final void enterHistory() {
                LiveDrawerDialog.U90(this.a.d);
            }

            @Override // ut1.a
            public final void enterSearch() {
                pa1.a r0 = this.a.d.i;
                if ((r0 instanceof pa1.a) == false) goto L6;
                r0.OC(true);
                return;
            }

            @Override // ut1.a
            public final void feedEnd() {
                DouyinLoadingLayout r0 = this.a.d.n;
                if (r0 == null) goto L6;
                r0.setVisibility(8);
                return;
            }

            @Override // ut1.a
            public final IDrawerUIManager getDrawerUIManager() {
                return new C0119a(this);
            }

            public a(c r1) {
                this.a = r1;
            }

            @Override // ut1.a
            public final void historyShow(int r4) {
                LiveDrawerDialog r0 = this.a.d;
                boolean r1 = LiveDrawerDialog.R;
                r0.Z90(false, r4, true);
            }

            @Override // ut1.a
            public final void setBackgroundByTabType(int r2) {
                if (r2 != 5) goto L7;
                RelativeLayout r3 = this.a.d.I;
                if (r3 == null) goto L7;
                r3.setVisibility(0);
                return;
            L7:
                RelativeLayout r4 = this.a.d.I;
                if (r4 == null) goto L12;
                r4.setVisibility(4);
                return;
            }

            public final void setInterceptor(ILiveDrawerLayoutInterceptor r2) {
                LiveDrawerLayout r0 = this.a.d.e;
                if (r0 == null) goto L6;
                r0.setDrawerLayoutInterceptor(r2);
                return;
            }
        }

        public class b implements pa1.d {
            public final /* synthetic */ c a;

            public final void closeDrawerDialog() {
                DrawerLayout r0 = this.a.d.e;
                if (r0 == null) goto L22;
                if (ViewCompat.isAttachedToWindow(r0) == false) goto L22;
                if (this.a.d.e.isDrawerOpen(8388613) == false) goto L22;
                LiveDrawerDialog r1 = this.a.d;
                r1.A = true;
                r1.e.closeDrawer(8388613);
            L17:
                if (this.a.d.G.booleanValue() == false) goto L24;
                SingleDrawViewModel r2 = this.a.d.z;
                if (r2 == null) goto L25;
                r2.getCloseDialog().setValue(Boolean.TRUE);
                this.a.d.z.setOpenSearch(true);
                return;
            L25:
                return;
            L24:
                return;
            L22:
                this.a.d.dismiss();     // Catch: Exception -> L12
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r3 = DialogFragmentLancet.sLastShowStack;
                if (r3 == null) goto L17;
                com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                goto L17
            }

            public final int getContainerWidth() {
                return this.a.b.getWidth() - s1.f(this.a.c);
            }

            public b(c r1) {
                this.a = r1;
            }

            public final void a(boolean r2) {
                if (r2 == false) goto L5;
                LiveDrawerDialog r3 = this.a.d;
                LiveDrawerDialog.V90(r3, r3.i);
                return;
            L5:
                if (this.a.d.G.booleanValue() == false) goto L8;
                LiveDrawerDialog r4 = this.a.d;
                r4.G = Boolean.FALSE;
                closeDrawerDialog();
                return;
            L8:
                LiveDrawerDialog r5 = this.a.d;
                LiveDrawerDialog.V90(r5, r5.h);
            }

            public final void b(Bundle r3) {
                if (this.a.d.y == null) goto L5;
                r3.putInt("back_source", 6);
            L5:
                FragmentActivity r0 = this.a.d.getActivity();
                if (r0 == null) goto L9;
                com.bytedance.android.livesdk.chatroom.helper.a.b(r0, this.a.d.y, r3);
                r3.putBoolean("data_back_to_pre_room_countdown_dismiss", false);
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.LiveDrawerDialog$c$c, reason: collision with other inner class name */
        public class C0120c implements com.bytedance.android.livesdk.drawer.history.e {
            public final /* synthetic */ c a;

            @Override // com.bytedance.android.livesdk.drawer.history.e
            public final void c() {
                DrawerLayout r0 = this.a.d.e;
                if (r0 == null) goto L22;
                if (ViewCompat.isAttachedToWindow(r0) == false) goto L22;
                if (this.a.d.e.isDrawerOpen(8388613) == false) goto L22;
                LiveDrawerDialog r1 = this.a.d;
                r1.A = true;
                r1.e.closeDrawer(8388613);
            L17:
                if (this.a.d.H.booleanValue() == false) goto L24;
                SingleDrawViewModel r2 = this.a.d.z;
                if (r2 == null) goto L25;
                r2.getCloseDialog().setValue(Boolean.TRUE);
                this.a.d.z.setOpenHistory(true);
                return;
            L25:
                return;
            L24:
                return;
            L22:
                this.a.d.dismiss();     // Catch: Exception -> L12
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r3 = DialogFragmentLancet.sLastShowStack;
                if (r3 == null) goto L17;
                com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                goto L17
            }

            public C0120c(c r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.drawer.history.e
            public final void a(boolean r2) {
                if (r2 == false) goto L5;
                LiveDrawerDialog r3 = this.a.d;
                LiveDrawerDialog.V90(r3, r3.k);
                this.a.d.u.post(new ut1.e(this));
                return;
            L5:
                if (this.a.d.H.booleanValue() == false) goto L8;
                LiveDrawerDialog r4 = this.a.d;
                r4.H = Boolean.FALSE;
                c();
                return;
            L8:
                LiveDrawerDialog r5 = this.a.d;
                LiveDrawerDialog.V90(r5, r5.h);
                this.a.d.u.setVisibility(0);
            }
        }

        public class d implements com.bytedance.android.livesdk.drawer.history.e {
            public final /* synthetic */ c a;

            @Override // com.bytedance.android.livesdk.drawer.history.e
            public final void c() {
                DrawerLayout r0 = this.a.d.e;
                if (r0 == null) goto L22;
                if (ViewCompat.isAttachedToWindow(r0) == false) goto L22;
                if (this.a.d.e.isDrawerOpen(8388613) == false) goto L22;
                LiveDrawerDialog r1 = this.a.d;
                r1.A = true;
                r1.e.closeDrawer(8388613);
            L17:
                if (this.a.d.H.booleanValue() == false) goto L24;
                SingleDrawViewModel r2 = this.a.d.z;
                if (r2 == null) goto L25;
                r2.getCloseDialog().setValue(Boolean.TRUE);
                this.a.d.z.setOpenHistory(true);
                return;
            L25:
                return;
            L24:
                return;
            L22:
                this.a.d.dismiss();     // Catch: Exception -> L12
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r3 = DialogFragmentLancet.sLastShowStack;
                if (r3 == null) goto L17;
                com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                goto L17
            }

            public d(c r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.drawer.history.e
            public final void a(boolean r2) {
                if (r2 == false) goto L5;
                LiveDrawerDialog r3 = this.a.d;
                LiveDrawerDialog.V90(r3, r3.k);
                this.a.d.u.post(new ut1.f(this));
                return;
            L5:
                if (this.a.d.H.booleanValue() == false) goto L8;
                LiveDrawerDialog r4 = this.a.d;
                r4.H = Boolean.FALSE;
                c();
                return;
            L8:
                LiveDrawerDialog r5 = this.a.d;
                LiveDrawerDialog.V90(r5, r5.h);
                this.a.d.u.setVisibility(0);
            }
        }

        public final void a() {
            if (this.d.isVisible() == true) goto L5;
            return;
        L5:
            LiveDrawerLayout r0 = this.d.e;
            if (r0 == null) goto L12;
            r0.openDrawer(8388613);
            if (this.d.X90() == false) goto L12;
            if (this.d.W90() == true) goto L12;
            this.d.ca0();
        L12:
            LiveDrawerDialog r1 = this.d;
            boolean r3 = false;
            if (r1.h == null) goto L15;
        L26:
            ILiveSearchService r2 = k.f(ILiveSearchService.class);
            LiveDrawerDialog r4 = this.d;
            if (r4.h == null) goto L90;
            Bundle r5 = r4.q;
            if (r5 == null) goto L40;
            if (r2 != null) goto L32;
        L34:
            boolean r6 = false;
        L35:
            r5.putBoolean("live_drawer_support_search", r6);
            DataCenter r7 = this.d.y;
            if (r7 == null) goto L40;
            if (((Boolean) r7.get("data_more_entrance_follow", Boolean.FALSE)).booleanValue() == false) goto L40;
            this.d.q.putBoolean("switch_follow", true);
            goto L40
        L32:
            if (r2.supportSearch() == false) goto L34;
            r6 = true;
        L40:
            Bundle r8 = new Bundle();
            Bundle r9 = this.d.q;
            if (r9 == null) goto L43;
            r8.putAll(r9);
        L43:
            o r10 = u.l().c(x.class);
            if (r10.getMap().get("enter_from_merge") == null) goto L46;
            String r11 = (String) r10.getMap().get("enter_from_merge");
        L48:
            if (r10.getMap().get("enter_method") == null) goto L51;
            String r12 = (String) r10.getMap().get("enter_method");
        L51:
            if (LiveDrawerHelper.a(this.d.y, this.a) == true) goto L53;
        L88:
            this.d.h.setArguments(r8);
            goto L90
        L53:
            if (LiveDrawerHelper.d(r11) == false) goto L56;
        L65:
            boolean r13 = true;
        L68:
            if (r13 == true) goto L70;
            int r14 = c0.b().k;
            Room r15 = this.a;
            if (r15 == null) goto L88;
            VerticalTypeInfo r16 = r15.mVerticalTypeInfo;
            if (r16 == null) goto L88;
            if (r14 == 0) goto L85;
            long r17 = r14;
            if (r17 == r16.tabType.longValue()) goto L85;
            if (this.a.mVerticalTypeInfo.tabType != null) goto L85;
            r8.putLong("default_tab_type", r17);
        L85:
            Long r18 = this.a.mVerticalTypeInfo.tabType;
            if (r18 == null) goto L88;
            r8.putLong("default_tab_type", r18.longValue());
            goto L88
        L70:
            if (LiveDrawerHelper.d(r11) == false) goto L73;
            r8.putLong("default_tab_type", 2);
        L73:
            if (LiveDrawerHelper.c(r11) == false) goto L88;
            r8.putLong("default_tab_type", 3);
            goto L88
        L56:
            if (LiveDrawerHelper.c(r11) == true) goto L65;
            if (TextUtils.isEmpty(r11) == false) goto L61;
        L63:
            boolean r19 = false;
        L64:
            if (r19 == true) goto L65;
            r13 = false;
            goto L68
        L61:
            if (CollectionsKt.contains(LiveDrawerHelper.d, r11) == false) goto L63;
            r19 = true;
            goto L64
        L46:
            r11 = "";
        L90:
            if (this.d.i != null) goto L110;
            if (r2 == null) goto L110;
            if (r2.supportSearch() == false) goto L110;
            if (this.d.getContext() == null) goto L110;
            if (RoomContext.getShared() == null) goto L110;
            if (RoomContext.getShared().isVSRoom() == false) goto L103;
            if (RoomContext.getShared().isVSSpecialDrawer() == true) goto L110;
        L103:
            if (LiveDrawerHelper.e() == true) goto L105;
            this.d.r.setVisibility(0);
        L105:
            LiveDrawerDialog r20 = this.d;
            Context r21 = r20.getContext();
            if (LiveDrawerHelper.e() == false) goto L108;
            RelativeLayout r22 = null;
        L109:
            r20.i = r2.createSearchResultFragment(r21, r22, this.d.q, new b(this));
        L112:
            if (lp.a.getValue().booleanValue() == true) goto L114;
            this.d.v.setVisibility(8);
        L130:
            if (RoomContext.getShared() != null) goto L132;
        L136:
            Room r23 = this.a;
            if (r23 == null) goto L142;
            pa1.a r24 = this.d.i;
            if ((r24 instanceof pa1.a) == false) goto L142;
            r24.iV(r23.getId());
        L142:
            if (this.d.G.booleanValue() == true) goto L192;
            Room r25 = this.a;
            if (r25 == null) goto L149;
            if (r2 == null) goto L149;
            if (r2.shouldJumpToSearch(r25.getId(), this.d.getActivity()) == true) goto L192;
        L149:
            boolean r26 = LiveHistoryFragment.x;
            FragmentActivity r27 = this.d.getActivity();
            if (LiveHistoryFragment.x == false) goto L155;
            if (r27 != null) goto L153;
        L154:
            boolean r28 = true;
        L156:
            if (r28 == false) goto L158;
        L181:
            DouyinLoadingLayout r29 = this.d.n;
            if (r29 == null) goto L184;
            r29.setVisibility(8);
        L184:
            LiveHistoryFragment r30 = this.d.k;
            if ((r30 instanceof LiveHistoryFragment) == false) goto L203;
            LiveHistoryFragment r31 = r30;
            if (r31.i == true) goto L207;
            com.bytedance.android.livesdk.drawer.history.e r32 = r31.k;
            if (r32 == null) goto L204;
            r32.a(true);
            return;
        L204:
            return;
        L207:
            return;
        L203:
            return;
        L158:
            if (this.d.H.booleanValue() == true) goto L160;
        L162:
            boolean r33 = LiveHistoryLynxFragment.j;
            FragmentActivity r34 = this.d.getActivity();
            if (LiveHistoryLynxFragment.j == false) goto L168;
            if (r34 != null) goto L166;
        L167:
            r3 = true;
            goto L168
        L166:
            if (r34.hashCode() == LiveHistoryLynxFragment.k) goto L167;
        L168:
            if (r3 == false) goto L170;
        L175:
            DouyinLoadingLayout r35 = this.d.n;
            if (r35 == null) goto L178;
            r35.setVisibility(8);
        L178:
            LiveHistoryLynxFragment r36 = this.d.k;
            if ((r36 instanceof LiveHistoryLynxFragment) == false) goto L201;
            r36.S90();
            return;
        L201:
            return;
        L170:
            if (this.d.H.booleanValue() == true) goto L175;
            LiveDrawerDialog r37 = this.d;
            LiveDrawerDialog.V90(r37, r37.h);
            pa1.a r38 = this.d.i;
            if ((r38 instanceof pa1.a) == false) goto L199;
            r38.tl();
            return;
        L199:
            return;
        L160:
            if ((this.d.k instanceof LiveHistoryFragment) == false) goto L162;
        L153:
            if (r27.hashCode() == LiveHistoryFragment.y) goto L154;
        L155:
            r28 = false;
        L192:
            DouyinLoadingLayout r39 = this.d.n;
            if (r39 == null) goto L195;
            r39.setVisibility(8);
        L195:
            pa1.a r40 = this.d.i;
            if ((r40 instanceof pa1.a) == false) goto L206;
            r40.OC(false);
            return;
        L206:
            return;
        L132:
            if (RoomContext.getShared().isVSRoom() == false) goto L136;
            if (RoomContext.getShared().isVSSpecialDrawer() == false) goto L136;
            this.d.v.setVisibility(8);
            goto L136
        L114:
            if (LiveDrawerHelper.e() == false) goto L116;
        L121:
            this.d.v.setVisibility(8);
        L123:
            if (this.d.k != null) goto L130;
            if (c00.a.getValue().booleanValue() == false) goto L127;
            LiveDrawerDialog r41 = this.d;
            boolean r42 = LiveHistoryLynxFragment.j;
            C0120c r43 = new C0120c(this);
            Intrinsics.checkNotNullParameter(r43, "callBack");
            LiveHistoryLynxFragment r44 = new LiveHistoryLynxFragment();
            r44.d = r43;
            r41.k = r44;
            goto L130
        L127:
            LiveDrawerDialog r45 = this.d;
            boolean r46 = LiveHistoryFragment.x;
            d r47 = new d(this);
            Intrinsics.checkNotNullParameter(r47, "callBack");
            LiveHistoryFragment r48 = new LiveHistoryFragment();
            r48.k = r47;
            r45.k = r48;
            goto L130
        L116:
            if (gp.a.getValue().c() == true) goto L121;
            this.d.Z90(false, 0, false);
            this.d.v.setVisibility(0);
            this.d.w.setVisibility(0);
            if (this.d.x.getBoolean("yellow_keva", false) == false) goto L120;
            this.d.w.setVisibility(8);
        L120:
            this.d.v.setOnClickListener(new ut1.d(this));
            goto L123
        L108:
            r22 = this.d.r;
        L110:
            this.d.r.setVisibility(8);
            goto L112
        L15:
            if (r1.G.booleanValue() == true) goto L26;
            if (this.d.H.booleanValue() == true) goto L26;
            LiveDrawerDialog r49 = this.d;
            r49.n = (DouyinLoadingLayout) r49.d.findViewById(2131369262);
            if (tb1.c.a == true) goto L21;
            this.d.n.setVisibility(8);
        L22:
            IHostFeed r50 = k.f(IHostFeed.class);
            if (r50 != null) goto L25;
            return;
        L25:
            this.d.h = r50.createDrawerFeedFragment(new a(this), LiveDrawerHelper.e());
            goto L26
        L21:
            this.d.n.setVisibility(0);
            goto L22
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LiveDrawerDialog r1, Room r2, ViewGroup r3, float r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class d implements DialogInterface.OnKeyListener {
        public final /* synthetic */ LiveDrawerDialog a;

        public d(LiveDrawerDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (4 == r2) goto L5;
            return false;
        L5:
            if (1 == r3.getAction()) goto L7;
            return false;
        L7:
            return this.a.onBackPressed();
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerDialog a;

        public e(LiveDrawerDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveDrawerDialog r3 = this.a;
            r3.A = true;
            r3.aa0();
        }
    }

    public class f implements Consumer<g1> {
        public final /* synthetic */ LiveDrawerDialog a;

        public f(LiveDrawerDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r1) throws Exception {
            g1 r2 = (g1) r1;
            this.a.aa0();
        }
    }

    public class g implements DrawerLayout.DrawerListener {
        public final /* synthetic */ LiveDrawerDialog a;

        public g(LiveDrawerDialog r1) {
            this.a = r1;
        }

        public final void onDrawerClosed(View r3) {
            com.bytedance.android.livesdk.f.d().f();
        L11:
            e = move-exception;
            ALogger.e("LiveDrawerDialog", e);
        L14:
            if (lo2.a.d() == false) goto L16;
            lo2.a.e().getClass();
            lo2.a.h(null, false);
        L16:
            LiveDrawerDialog r4 = this.a;
            boolean r0 = LiveDrawerDialog.R;
            ILiveDrawerMultiTabView r1 = r4.h;
            if ((r1 instanceof ILiveDrawerMultiTabView) == false) goto L19;
            r1.dismissPopView();
            return;
        L19:
            yo2.e r2 = r4.M;
            if (r2 != null) goto L22;
            return;
        L22:
            if (r2.h() == false) goto L31;
            r4.M.d();
            return;
        L31:
            return;
        L25:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L6
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: IllegalStateException -> L11
            Throwable r5 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L11
            if (r5 == null) goto L14;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L11
            goto L14
        }

        public final void onDrawerOpened(View r11) {
            com.bytedance.android.livesdk.f.d().a();
            if (lo2.a.d() == false) goto L5;
            lo2.a r12 = lo2.a.e();
            Dialog r1 = this.a.getDialog();
            r12.getClass();
            lo2.a.h(r1, true);
        L5:
            LiveDrawerDialog r13 = this.a;
            boolean r2 = LiveDrawerDialog.R;
            r13.getClass();
            if (gp.a.getValue().c() == true) goto L32;
            d00 r3 = d00.a;
            if (r3.getValue() != null) goto L11;
            return;
        L11:
            if (r3.getValue().a() == false) goto L33;
            ILiveDrawerMultiTabView r4 = r13.h;
            if ((r4 instanceof ILiveDrawerMultiTabView) == false) goto L16;
            r4.showPopView();
            return;
        L16:
            Keva r5 = r13.x;
            if (r5 != null) goto L19;
        L21:
            r13.x.storeBoolean("pop_guide", true);
            View r6 = LayoutInflater.from(r13.getContext()).inflate(2131566857, null);
            TextView r7 = (TextView) r6.findViewById(2131388367);
            if (r7 != null) goto L24;
        L28:
            yo2.e r8 = new yo2.e(r13.getContext());
            int r9 = (int) UIUtils.dip2Px(r13.getContext(), 141.0f);
            int r10 = (int) UIUtils.dip2Px(r13.getContext(), 49.0f);
            ((yo2.d) r8).d = r6;
            ((yo2.d) r8).e = 0;
            ((yo2.d) r8).h = r9;
            ((yo2.d) r8).i = r10;
            ((yo2.d) r8).m = 50;
            ((yo2.d) r8).l = true;
            ((yo2.d) r8).g = false;
            r8.a();
            r13.M = r8;
            r8.i(r13.v, 2, 4, 0, 0);
            return;
        L24:
            if (r3.getValue() == null) goto L28;
            if (TextUtils.isEmpty(r3.getValue().b()) == true) goto L28;
            r7.setText(r3.getValue().b());
            goto L28
        L19:
            if (r5.getBoolean("pop_guide", false) == false) goto L21;
            return;
        L33:
            return;
        }

        public final void onDrawerStateChanged(int r2) {
            if (r2 != 0) goto L25;
            LiveDrawerLayout r3 = this.a.e;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.isDrawerOpen(8388613) == true) goto L27;
            this.a.e.closeDrawer(8388613);
        L16:
            e = move-exception;
            ALogger.e("LiveDrawerDialog", e);
            return;
        L22:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L11
        L19:
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: IllegalStateException -> L16
            Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L16
            if (r4 == null) goto L19;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L16
            goto L19
        L27:
            return;
        }

        public final void onDrawerSlide(View r1, float r2) {
            this.a.o.setAlpha(r2);
        }
    }

    public final String getRequestPage() {
        return "toplive";
    }

    public final boolean isAutoFloatEnable() {
        return true;
    }

    public final void aa0() {
        DrawerLayout r0 = this.e;
        if (r0 == null) goto L13;
        if (ViewCompat.isAttachedToWindow(r0) == false) goto L13;
        if (X90() == true) goto L9;
    L11:
        this.e.closeDrawer(8388613);
        goto L13
    L9:
        if (W90() == false) goto L11;
        MatchRoomLandScapeAnimUtil.E.j("LiveDrawerDialog");
    L13:
        if (X90() == true) goto L15;
        return;
    L15:
        if (W90() == true) goto L19;
        View r1 = this.K;
        ObjectAnimator.ofFloat(r1, "translationY", new float[]{0.0f, r1.getLayoutParams().height * (-1.0f)}).setDuration(200).start();
        View r2 = this.L;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "translationY", new float[]{0.0f, r2.getLayoutParams().height * 1.0f}).setDuration(500);
        r3.addListener(new ut1.g(this));
        r3.start();
        return;
    }

    public final void ca0() {
        this.K.setVisibility(0);
        this.L.setVisibility(0);
        View r0 = this.K;
        ObjectAnimator.ofFloat(r0, "translationY", new float[]{r0.getLayoutParams().height * (-1.0f), 0.0f}).setDuration(200).start();
        View r1 = this.L;
        ObjectAnimator.ofFloat(r1, "translationY", new float[]{r1.getLayoutParams().height * 1.0f, 0.0f}).setDuration(200).start();
    }

    public final boolean onBackPressed() {
        DrawerLayout r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
        return false;
    L7:
        if (this.e.isDrawerOpen(8388613) == false) goto L13;
        this.A = true;
        this.e.closeDrawer(8388613);
        return true;
    L13:
        return false;
    }

    public LiveDrawerDialog() {
        this.x = Keva.getRepo("draw_history", 0);
        this.A = false;
        this.B = false;
        this.C = -1;
        this.F = 50.0f;
        Boolean r0 = Boolean.FALSE;
        this.G = r0;
        this.H = r0;
        this.I = null;
        this.Q = new g(this);
    }

    public final boolean W90() {
        RoomContext r0 = RoomContext.getShared();
        if (X90() == false) goto L10;
        if (r0 == null) goto L10;
        if (r0.isVSRoom() == false) goto L10;
        if (oj1.a.getValue().d() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean X90() {
        RoomContext r0 = RoomContext.getShared();
        if (r0 == null) goto L9;
        if (r0.isVSRoom() == false) goto L9;
        return e5.n();
    L9:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L13;
        return false;
    L13:
        return e5.n();
    }

    public final boolean Y90() {
        if (FoldScreenUtils.f() == true) goto L5;
        return false;
    L5:
        Iterator<? extends String> r0 = fp.a.getValue().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (r0.next().equals(FoldScreenUtils.d()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final int da0() {
        int r0 = (int) (UIUtils.getScreenWidth(getContext()) - UIUtils.dip2Px(getContext(), this.F));
        if (Y90() == true) goto L5;
    L8:
        ViewGroup r1 = this.D;
        if (r1 == null) goto L28;
        if (r0 < 0) goto L28;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        RoomContext r3 = RoomContext.getShared();
        if (r3 != null) goto L15;
    L27:
        r2.width = r0;
        this.D.setLayoutParams(r2);
        ViewGroup.LayoutParams r4 = this.E.getLayoutParams();
        r4.width = UIUtils.getScreenWidth(getContext()) - r0;
        this.E.setLayoutParams(r4);
        goto L28
    L15:
        if (r3.isVSRoom() == false) goto L27;
        if (r3.isVSSpecialDrawer() == false) goto L27;
        if (PadConfigUtils.c() == false) goto L22;
        this.g.setVisibility(8);
        r0 = Math.min(s1.f(366.0f), r0);
        goto L27
    L22:
        if (X90() == false) goto L24;
        this.g.setVisibility(8);
        r0 = s1.f(375.0f);
        goto L27
    L24:
        View r5 = this.g;
        if (r5 == null) goto L27;
        r5.setVisibility(4);
    L28:
        return r0;
    L5:
        if (this.C != 0) goto L7;
        r0 = r0 / 2;
    L7:
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerDialog", "updatePanelContainerWidth: " + r0);
        goto L8
    }

    public final void dismissAllowingStateLoss() {
        if (W90() == false) goto L24;
        MatchRoomLandScapeAnimUtil.E.j("LiveDrawerDialog");
    L24:
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L12:
        if (this.B == true) goto L18;
        int r0 = h.a;
        if (this.A == false) goto L16;
        String r1 = "click";
    L17:
        h.a(r1);
        this.B = true;
        this.A = false;
        goto L18
    L16:
        r1 = "pull";
    L18:
        DataCenter r2 = this.y;
        if (r2 == null) goto L26;
        ut1.c r3 = this.J;
        if (r3 == null) goto L27;
        r2.removeObserver("data_is_portrait", r3);
        return;
    L27:
        return;
    L26:
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L12;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public final int getActualContentWidth() {
        return s1.f(375.0f);
    }

    public final void finish() {
        onBackPressed();
    }

    public static void U90(LiveDrawerDialog r4) {
        Fragment r0 = r4.k;
        if ((r0 instanceof LiveHistoryFragment) == false) goto L11;
        r4.Z90(true, 0, false);
        LiveHistoryFragment r5 = r4.k;
        if (r5.i == true) goto L27;
        com.bytedance.android.livesdk.drawer.history.e r6 = r5.k;
        if (r6 == null) goto L21;
        r6.a(true);
        return;
    L21:
        return;
    L27:
        return;
    L11:
        if ((r0 instanceof LiveHistoryLynxFragment) == false) goto L23;
        r4.Z90(true, 0, false);
        r4.k.S90();
        ILiveDrawerMultiTabView r1 = r4.h;
        if ((r1 instanceof ILiveDrawerMultiTabView) == false) goto L15;
        r1.dismissPopView();
        return;
    L15:
        yo2.e r2 = r4.M;
        if (r2 != null) goto L18;
        return;
    L18:
        if (r2.h() == false) goto L26;
        r4.M.d();
        return;
    L26:
        return;
    }

    public final float ba0(float r4) {
        if (PadConfigUtils.c() == false) goto L5;
        float r0 = (s1.G(s1.y()) - 378.0f) - r4;
    L7:
        if (r0 > 0.0f) goto L14;
        if (b4.a() == false) goto L14;
        if (k4.e(getActivity()) == false) goto L14;
        return r4;
    L14:
        return r0;
    L5:
        r0 = 0.0f;
        goto L7
    }

    public final void onActivityCreated(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r10);
        Window r11 = getDialog().getWindow();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L12:
        if (r11 == null) goto L19;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r11.addFlags(Integer.MIN_VALUE);
        r11.setNavigationBarColor(-16777216);
        r11.setLayout(-1, -1);
        if (getActivity() == null) goto L19;
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), true, false) == false) goto L19;
        r11.clearFlags(1024);
    L19:
        if (X90() == false) goto L34;
        t8.d(r11);
        View r12 = this.o;
        int r1 = s1.f(400.0f);
        int r2 = this.o.getLayoutParams().height;
        if ((r12.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L24;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        r3.width = r1;
        r3.height = r2;
        r3.gravity = 8388613;
        r12.setLayoutParams(r3);
    L24:
        DrawerLayout r13 = this.e;
        int r0 = s1.f(400.0f);
        int r4 = this.e.getLayoutParams().height;
        if ((r13.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L28;
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r13.getLayoutParams();
        r5.width = r0;
        r5.height = r4;
        r5.gravity = 8388613;
        r13.setLayoutParams(r5);
    L28:
        this.d.setOnClickListener(new e(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(g1.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(this));
        if (this.J != null) goto L35;
        Observer r14 = new ut1.c(this);
        this.J = r14;
        DataCenter r6 = this.y;
        if (r6 == null) goto L36;
        r6.observe("data_is_portrait", r14);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L5:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L12;
        r11.clearFlags(1024);
        View r7 = r11.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r8 = ThreadMethodProxy.currentThread();
        if (r8 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r8, "getDecorView");
    L11:
        com.bytedance.android.live.core.utils.statusbar.a.a r9 = com.bytedance.android.live.core.utils.statusbar.a.b;
        r9.a();
        r7.setSystemUiVisibility(1024);
        r9.a();
        r11.addFlags(Integer.MIN_VALUE);
        r11.setStatusBarColor(0);
        r11.setNavigationBarColor(-16777216);
        r11.setLayout(-1, -1);
        goto L19
    }

    public final void onConfigurationChanged(Configuration r5) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r5);
        if (b4.a() == false) goto L10;
        if (this.O == k4.e(getContext())) goto L10;
        this.O = k4.e(getContext());
        View r0 = this.d;
        if (r0 == null) goto L10;
        r0.post(new ut1.b(this));
    L10:
        if (b4.a() == false) goto L13;
        this.F = ba0(12.0f) + 12.0f;
        da0();
    L16:
        if (FoldScreenUtils.f() == false) goto L32;
        int r6 = FoldScreenUtils.c(r5);
        if (this.C == r6) goto L22;
        b0 r1 = b0.o();
        String r2 = "onConfigurationChanged: oldFoldScreenType: " + this.C + " newFoldScreenType: " + r6;
        r1.getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerDialog", r2);
        this.C = r6;
        if (Y90() == false) goto L33;
        da0();
        return;
    L33:
        return;
    L22:
        ViewGroup r7 = this.D;
        if (r7 != null) goto L25;
        return;
    L25:
        if (ViewCompat.isAttachedToWindow(r7) == true) goto L27;
        return;
    L27:
        if (this.D.getWidth() > UIUtils.getScreenWidth(getContext())) goto L29;
        return;
    L29:
        if (Y90() == false) goto L38;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerDialog", "onConfigurationChanged: enter workaround");
        da0();
        return;
    L38:
        return;
    L32:
        return;
    L13:
        if (PadConfigUtils.a() == false) goto L16;
        da0();
        goto L16
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131954391);
        if (PadConfigUtils.c() == false) goto L6;
        this.O = k4.e(getContext());
        return;
    }

    public static void V90(LiveDrawerDialog r6, Fragment r7) {
        if (r7 != null) goto L5;
        r6.getClass();
        return;
    L5:
        if (r7 == r6.h) goto L10;
        DouyinLoadingLayout r0 = r6.n;
        if (r0 == null) goto L10;
        r0.setVisibility(8);
    L10:
        if (r7 == r6.i) goto L12;
    L16:
        boolean r1 = true;
        if (RoomContext.getShared() != null) goto L19;
    L23:
        boolean r2 = false;
    L25:
        if (r7 == r6.h) goto L27;
    L36:
        ALogger.i("LiveDrawerDialog", "mCurrentFragment=" + r6.j + "   target=" + r7);
        if (r6.j == r7) goto L57;
        FragmentTransaction r3 = r6.getChildFragmentManager().beginTransaction();
        if (r7.isAdded() == true) goto L50;
        ALogger.i("LiveDrawerDialog", "!target.isAdded()");
        Fragment r4 = r6.j;
        if (r4 == null) goto L46;
        if (r4.isAdded() == false) goto L46;
        r3.hide(r6.j);
        ALogger.i("LiveDrawerDialog", "ft.hide( mCurrentFragment)");
    L46:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131381873) == true) goto L49;
        r3 = r3.add(2131381873, r7);
    L49:
        r3.commitAllowingStateLoss();
    L56:
        r6.j = r7;
        goto L57
    L50:
        ALogger.i("LiveDrawerDialog", "target.isAdded()");
        Fragment r5 = r6.j;
        if (r5 != null) goto L53;
    L55:
        r3.show(r7).commitAllowingStateLoss();
        goto L56
    L53:
        if (r5.isAdded() == false) goto L55;
        r3.hide(r6.j);
        ALogger.i("LiveDrawerDialog", "ft.hide( mCurrentFragment);");
    L57:
        Fragment r8 = r6.i;
        if ((r8 instanceof pa1.a) == false) goto L64;
        pa1.a r9 = (pa1.a) r8;
        if (r6.j != r8) goto L62;
        boolean r10 = true;
    L63:
        r9.Bp(r10);
        goto L64
    L62:
        r10 = false;
    L64:
        Fragment r11 = r6.k;
        if ((r11 instanceof LiveHistoryFragment) == false) goto L72;
        LiveHistoryFragment r12 = (LiveHistoryFragment) r11;
        if (r6.j != r11) goto L69;
        boolean r13 = true;
    L70:
        r12.i = r13;
        LiveHistoryFragment.x = r13;
        goto L72
    L69:
        r13 = false;
    L72:
        if ((r11 instanceof LiveHistoryLynxFragment) == false) goto L80;
        LiveHistoryLynxFragment r14 = (LiveHistoryLynxFragment) r11;
        if (r6.j == r11) goto L77;
        r1 = false;
    L77:
        r14.e = r1;
        LiveHistoryLynxFragment.j = r1;
        return;
    L80:
        return;
    L27:
        if (lp.a.getValue().booleanValue() == false) goto L36;
        if (gp.a.getValue().c() == true) goto L36;
        if (r6.v == null) goto L36;
        if (LiveDrawerHelper.e() == true) goto L36;
        if (r2 == true) goto L36;
        r6.v.setVisibility(0);
        goto L36
    L19:
        if (RoomContext.getShared().isVSRoom() == false) goto L23;
        if (RoomContext.getShared().isVSSpecialDrawer() == false) goto L23;
        r2 = true;
        goto L25
    L12:
        if (r6.v == null) goto L16;
        if (LiveDrawerHelper.e() == true) goto L16;
        r6.v.setVisibility(8);
        goto L16
    }

    public final void onViewCreated(View r19, Bundle r20) {
        if (W90() == false) goto L5;
        boolean r0 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y("LiveDrawerDialog", this, -1);
    L5:
        super.onViewCreated(r19, r20);
        if (FoldScreenUtils.f() == false) goto L8;
        this.C = FoldScreenUtils.a();
        b0 r1 = b0.o();
        String r4 = "current foldType is " + this.C;
        r1.getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerDialog", r4);
    L8:
        Bundle r2 = this.q;
        if (r2 == null) goto L12;
        this.G = Boolean.valueOf(r2.getBoolean("LIVE_DRAW_DIALOG_OPEN_SEARCH"));
        this.H = Boolean.valueOf(this.q.getBoolean("LIVE_DRAW_DIALOG_OPEN_HISTORY"));
    L12:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L14;
    L16:
        boolean r3 = false;
    L17:
        R = r3;
        DataCenter r5 = this.y;
        if (r5 == null) goto L20;
        Room r6 = (Room) r5.get("data_room", null);
    L21:
        this.e = (LiveDrawerLayout) this.d.findViewById(2131370241);
        this.f = this.d.findViewById(2131372250);
        this.g = this.d.findViewById(2131372248);
        ImageView r7 = (ImageView) this.d.findViewById(2131372249);
        this.l = this.d.findViewById(2131381899);
        TextView r8 = (TextView) this.d.findViewById(2131381900);
        this.m = this.d.findViewById(2131370230);
        this.u = (ViewGroup) this.d.findViewById(2131381879);
        this.r = (RelativeLayout) this.d.findViewById(2131385355);
        this.v = (ViewGroup) this.d.findViewById(2131374393);
        this.w = this.d.findViewById(2131393414);
        this.I = (RelativeLayout) this.d.findViewById(2131370235);
        this.o = this.d.findViewById(2131370244);
        this.s = (TextView) this.d.findViewById(2131381880);
        this.t = this.d.findViewById(2131370237);
        this.K = this.d.findViewById(2131370246);
        this.L = this.d.findViewById(2131370231);
        this.P = (ViewGroup) this.d.findViewById(2131381873);
        this.e.addDrawerListener(this.Q);
        if (Lists.notEmpty(this.p) == false) goto L28;
        Iterator<DrawerLayout.DrawerListener> r9 = this.p.iterator();
    L25:
        if (r9.hasNext() == false) goto L28;
        this.e.addDrawerListener(r9.next());
    L28:
        if (getActivity() == null) goto L30;
        this.z = ViewModelProviders.of(getActivity()).get(SingleDrawViewModel.class);
    L30:
        this.e.setScrimColor(0);
        this.D = (ViewGroup) this.d.findViewById(2131381878);
        this.E = (ViewGroup) this.d.findViewById(2131370236);
        ViewGroup r10 = (ViewGroup) this.d.findViewById(2131381877);
        this.N = Boolean.valueOf(this.x.getBoolean("pop_guide", false));
        ViewGroup r11 = (ViewGroup) this.d.findViewById(2131381854);
        if (LiveDrawerHelper.e() == false) goto L37;
        this.F = ba0(12.0f) + 12.0f;
        this.g.setVisibility(0);
        if (R == false) goto L35;
        r10.setPadding((int) UIUtils.dip2Px(getContext(), 8.0f), StatusBarUtil.getStatusBarHeight(getContext()), (int) UIUtils.dip2Px(getContext(), 8.0f), 0);
        this.I.setPadding(0, StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-2, -2);
        r12.setMargins(0, ((int) UIUtils.dip2Px(getContext(), 52.0f)) + StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        this.g.setLayoutParams(r12);
    L36:
        float r13 = ba0(this.F) + 32.0f;
        this.l.setVisibility(8);
        this.f.setVisibility(8);
        r11.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
    L51:
        r3.a(this.g, s1.B(2131918649));
        if (da0() > 0) goto L61;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("LiveDrawerDialog", "PanelContainerWidth invalid!");
        dismissAllowingStateLoss();     // Catch: Exception -> L56
        return;
    L56:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L125;
        com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L125:
        return;
    L61:
        this.g.setOnClickListener(new a(this));
        this.E.setOnClickListener(new b(this));
        r3.a(this.E, s1.B(2131916300));
        if (PadConfigUtils.c() == false) goto L65;
        r11.setBackgroundResource(2131249411);
        this.D.setPadding(0, s1.f(20.0f), s1.f(20.0f), s1.f(20.0f));
    L65:
        if (RoomContext.getShared() != null) goto L67;
    L71:
        boolean r15 = false;
    L73:
        if (X90() == false) goto L86;
        if (r15 == true) goto L86;
        float r16 = s1.w() * 1.0f;
        float r17 = Math.max(r16, s1.y() * 1.0f);
        if ((r17 / Math.min(r16, r17)) <= 1.7777777777777777d) goto L78;
        boolean r18 = true;
    L79:
        if (r18 == false) goto L81;
        int r21 = s1.f(34.0f);
    L82:
        int r22 = Math.max(r21, x1.f());
        DataCenter r110 = this.y;
        if (r110 == null) goto L85;
        r110.put("show_landscape_live_drawer_dialog", Boolean.TRUE);
    L85:
        ViewGroup r111 = this.D;
        int r112 = s1.f(256.0f) + r22;
        ViewGroup.LayoutParams r113 = r111.getLayoutParams();
        r113.width = r112;
        r113.height = -1;
        r111.setLayoutParams(r113);
        this.g.setVisibility(8);
        this.o.setBackground(s1.m(2131249351));
        r11.setBackgroundColor(0);
        r10.setPadding(0, 0, 0, 0);
        this.D.setPadding(0, 0, r22, 0);
        goto L86
    L81:
        r21 = s1.f(8.0f);
        goto L82
    L78:
        r18 = false;
    L86:
        if (r15 == false) goto L120;
        Room r23 = (Room) RoomContext.getShared().getRoom().getValue();
        this.s.setVisibility(0);
        TextView r24 = this.s;
        String r114 = com.bytedance.android.livesdk.utils.g1.a(r23);
        if (r24 == null) goto L90;
        r3.a r115 = new r3.a(r24);
        r115.a = r114;
        r115.h = true;
        ViewCompat.setAccessibilityDelegate(r24, r115);
    L90:
        this.s.setText(com.bytedance.android.livesdk.utils.g1.a(r23));
        this.r.setVisibility(8);
        UIUtils.setViewVisibility(this.t, 0);
        r10.setPadding(0, (int) UIUtils.dip2Px(getContext(), 32.0f), 0, 0);
        this.s.setPadding((int) UIUtils.dip2Px(getContext(), 12.0f), (int) UIUtils.dip2Px(getContext(), 11.0f), (int) UIUtils.dip2Px(getContext(), 12.0f), (int) UIUtils.dip2Px(getContext(), 11.0f));
        if (r23 == null) goto L99;
        EpisodeExtraInfo r25 = r23.getEpisodeExtra2();
        if (r25 == null) goto L99;
        VSConfigDrawer r26 = r25.getVsConfigDrawer();
        if (r26 == null) goto L99;
        MatchDrawer r27 = r26.drawer;
        if (r27 == null) goto L99;
        py.k r116 = r27.getDrawerBackground();
    L100:
        r11.setBackgroundColor(0);
        if (r116 == null) goto L107;
        if (PadConfigUtils.c() == false) goto L105;
        ImageUtil.loadImageWithRadius(this.t, r116, 2131249414, 8);
    L111:
        if (PadConfigUtils.c() == false) goto L114;
        this.g.setVisibility(8);
        this.D.setPadding(0, (int) UIUtils.dip2Px(getContext(), 20.0f), (int) UIUtils.dip2Px(getContext(), 20.0f), (int) UIUtils.dip2Px(getContext(), 20.0f));
    L118:
        if (W90() == false) goto L120;
        this.o.setVisibility(8);
        this.L.setVisibility(8);
        this.K.setVisibility(8);
        goto L120
    L114:
        if (X90() == false) goto L116;
        this.g.setVisibility(8);
        this.D.setPadding(0, 0, 0, 0);
        r10.setPadding(0, 0, (int) UIUtils.dip2Px(getContext(), 29.0f), 0);
        goto L118
    L116:
        this.g.setVisibility(4);
        goto L118
    L105:
        ImageUtil.loadImageWithRadii(this.t, r116, 2131249414, 8.0f, 0.0f, 0.0f, 8.0f);
        goto L111
    L107:
        if (PadConfigUtils.c() == false) goto L109;
        r11.setBackgroundResource(2131249415);
        goto L111
    L109:
        r11.setBackgroundResource(2131249414);
    L99:
        r116 = null;
    L120:
        this.e.post(new c(this, r6, r10, r13));
        getDialog().setOnKeyListener(new d(this));
        this.B = false;
        return;
    L67:
        if (RoomContext.getShared().isVSRoom() == false) goto L71;
        if (RoomContext.getShared().isVSSpecialDrawer() == false) goto L71;
        r15 = true;
        goto L73
    L35:
        r10.setPadding((int) UIUtils.dip2Px(getContext(), 8.0f), 0, (int) UIUtils.dip2Px(getContext(), 8.0f), 0);
        goto L36
    L37:
        this.F = ba0(12.0f) + 12.0f;
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        r13 = ba0(this.F) + 16.0f;
        ILiveSearchService r28 = k.f(ILiveSearchService.class);
        if (this.i != null) goto L45;
        if (r28 == null) goto L45;
        if (r28.supportSearch() == false) goto L45;
        if (getContext() == null) goto L45;
        float r29 = 16.0f;
    L47:
        if (R == false) goto L49;
        r10.setPadding((int) UIUtils.dip2Px(getContext(), 8.0f), ((int) UIUtils.dip2Px(getContext(), r29)) + StatusBarUtil.getStatusBarHeight(getContext()), (int) UIUtils.dip2Px(getContext(), 8.0f), 0);
        this.I.setPadding(0, ((int) UIUtils.dip2Px(getContext(), r29)) + StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(-2, -2);
        r30.setMargins(0, ((int) UIUtils.dip2Px(getContext(), 52.0f)) + StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        this.g.setLayoutParams(r30);
    L50:
        r11.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
        goto L51
    L49:
        r10.setPadding((int) UIUtils.dip2Px(getContext(), 8.0f), (int) UIUtils.dip2Px(getContext(), r29), (int) UIUtils.dip2Px(getContext(), 8.0f), 0);
        this.I.setPadding(0, (int) UIUtils.dip2Px(getContext(), r29), 0, 0);
    L45:
        r29 = 44.0f;
        goto L47
    L20:
        r6 = null;
        goto L21
    L14:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L16;
        r3 = true;
        goto L17
    }

    public final void Z90(boolean r5, int r6, boolean r7) {
        DataCenter r0 = this.y;
        Room r1 = null;
        if (r0 == null) goto L5;
        r1 = (Room) r0.get("data_room", null);
    L5:
        if (r1 != null) goto L7;
        return;
    L7:
        HashMap r2 = new HashMap();
        if (r1.getBaseOwner() == null) goto L10;
        r2.put("anchor_id", r1.getBaseOwner().getIdString());
    L10:
        r2.put("room_id", r1.getIdStr());
        r2.put("enter_from_merge", "drawer_hot");
        r2.put("enter_method", "drawer_cover");
        r2.put("action_type", "click");
        r2.put("request_id", r1.getRequestId());
        r2.put("log_pb", r1.getLog_pb());
        if (r7 == false) goto L14;
        r2.put("is_leading_show", String.valueOf(r6));
    L19:
        if (X90() == false) goto L21;
        String r8 = "landscape";
    L22:
        r2.put("screen_direction", r8);
        if (this.N.booleanValue() == true) goto L25;
        r2.put("is_bubble_leading_show", "1");
    L25:
        if (r5 == false) goto L27;
        u.l().sendLog("livesdk_history_button_click", r2, new Object[0]);
        return;
    L27:
        u.l().sendLog("livesdk_history_button_show", r2, new Object[0]);
        return;
    L21:
        r8 = "portrait";
        goto L22
    L14:
        if (this.x.getBoolean("yellow_keva", false) == false) goto L16;
        String r9 = "0";
    L17:
        r2.put("is_leading_show", r9);
        goto L19
    L16:
        r9 = "1";
        goto L17
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131565452, r3, false);
        this.d = r5;
        return r5;
    }
}
