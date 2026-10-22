package com.bytedance.android.livesdk.gift.platform.business.dialog.v3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewConfigurationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ca0.p;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.GiftUserBehaviorComponent;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.GiftUserBehaviorPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DialogPause;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DialogResume;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.widget.GiftPanelWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.s0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.w1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.x1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.y1;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.l;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import e33.k;
import i12.m;
import i12.o;
import i12.q;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import mz0.n;
import org.json.JSONObject;
import zg1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/GiftDialogFragmentV3;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "<init>", "()V", "a", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftDialogFragmentV3 extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b {
    public static final /* synthetic */ int z = 0;
    public Context d;
    public LocateGiftInfo e;
    public Bundle f;
    public boolean g;
    public boolean h;
    public DataCenter i;
    public final Set<DialogInterface.OnDismissListener> j;
    public final CompositeDisposable k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public i12.e q;
    public q r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final GiftUserBehaviorComponent w;
    public int x;
    public boolean y;

    public static final class a {
    }

    public static final class b extends DataContext implements m {
        private final i12.d inst;

        public final void shareAsCurrent() {
            m.a r0 = m.e2;
            int r1 = com.bytedance.live.datacontext.d.a;
            Intrinsics.checkNotNullParameter(this, "self");
            com.bytedance.live.datacontext.b.a(this, r0);
        }

        @Override // i12.m
        public i12.d getInst() {
            return this.inst;
        }

        public b(i12.d r2) {
            Intrinsics.checkNotNullParameter(r2, "inst");
            this.inst = r2;
        }
    }

    public static final class c implements Runnable {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MatchRoomLandScapeAnimUtil.E.j("GiftDialogFragmentV3");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements LiveBottomSheetDialog.m {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class e implements LiveBottomSheetDialog.m {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }

        public final boolean disableDragDown() {
            return !((Boolean) nz1.a.j.getValue(null, nz1.a.a[8])).booleanValue();
        }
    }

    public static final class f implements com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.c {
        public final /* synthetic */ GiftDialogFragmentV3 a;

        public f(GiftDialogFragmentV3 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.c
        public final void a(MotionEvent r17, ViewGroup r18) {
            Intrinsics.checkNotNullParameter(r18, "container");
            GiftUserBehaviorComponent r9 = this.a.w;
            r9.getClass();
            if (r17 == null) goto L122;
            System.nanoTime();
            int r1 = r17.getAction() & 255;
            com.bytedance.android.livesdk.behavior.a r2 = null;
            if (r1 == 0) goto L90;
            if (r1 == 1) goto L67;
            if (r1 == 2) goto L42;
            if (r1 == 3) goto L67;
            if (r1 == 5) goto L32;
            if (r1 == 6) goto L17;
            return;
        L17:
            if (r9.e != r17.getPointerId(r17.getActionIndex())) goto L22;
            com.bytedance.android.livesdk.behavior.a r0 = r9.a;
            if (r0 == null) goto L107;
            r0.c(r17.getX(r17.getActionIndex()), r17.getY(r17.getActionIndex()), 0);
            return;
        L107:
            return;
        L22:
            if (r9.f != r17.getPointerId(r17.getActionIndex())) goto L27;
            com.bytedance.android.livesdk.behavior.a r3 = r9.a;
            if (r3 == null) goto L109;
            r3.c(r17.getX(r17.getActionIndex()), r17.getY(r17.getActionIndex()), 1);
            return;
        L109:
            return;
        L27:
            if (r9.g != r17.getPointerId(r17.getActionIndex())) goto L111;
            com.bytedance.android.livesdk.behavior.a r4 = r9.a;
            if (r4 == null) goto L112;
            r4.c(r17.getX(r17.getActionIndex()), r17.getY(r17.getActionIndex()), 2);
            return;
        L112:
            return;
        L111:
            return;
        L32:
            if (r9.f != 0) goto L37;
            r9.f = r17.getPointerId(r17.getActionIndex());
            com.bytedance.android.livesdk.behavior.a r5 = r9.a;
            if (r5 == null) goto L114;
            r5.b(r17.getX(r17.getActionIndex()), r17.getY(r17.getActionIndex()), 1);
            return;
        L114:
            return;
        L37:
            if (r9.g != 0) goto L116;
            r9.g = r17.getPointerId(r17.getActionIndex());
            com.bytedance.android.livesdk.behavior.a r6 = r9.a;
            if (r6 == null) goto L117;
            r6.b(r17.getX(r17.getActionIndex()), r17.getY(r17.getActionIndex()), 2);
            return;
        L117:
            return;
        L116:
            return;
        L42:
            if (r9.a != null) goto L54;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.b r7 = r9.b;
            if (r7 == null) goto L53;
            int r8 = r9.c;
            String r10 = r9.d;
            if (r18 == null) goto L48;
            int r11 = r18.getWidth();
        L49:
            if (r18 == null) goto L51;
            int r13 = r18.getHeight();
        L52:
            r2 = r7.a(r17, r8, r10, r11, r13, r9.k);
            goto L53
        L51:
            r13 = 0;
            goto L52
        L48:
            r11 = 0;
        L53:
            r9.a = r2;
        L54:
            com.bytedance.android.livesdk.behavior.a r14 = r9.a;
            if (r14 == null) goto L119;
            Intrinsics.checkNotNullParameter(r17, "ev");
            r14.g.addMovement(r17);
            float r15 = r17.getY() - ((Number) r14.a.getSecond()).floatValue();
            float r16 = r17.getX() - ((Number) r14.a.getFirst()).floatValue();
            if (r14.d == (-1)) goto L59;
        L66:
            r14.b = r17.getX();
            r14.c = r17.getY();
            return;
        L59:
            if (Math.abs(r16) < r14.j) goto L61;
        L62:
            int r19 = (int) Math.toDegrees(Math.atan2(r15, r16));
            r14.d = r19;
            if (r19 >= 0) goto L65;
            r14.d = r19 + 360;
        L65:
            r14.e.put("angle", String.valueOf(r14.d));
            goto L66
        L61:
            if (Math.abs(r15) < r14.j) goto L66;
        L119:
            return;
        L67:
            com.bytedance.android.livesdk.behavior.a r20 = r9.a;
            if (r20 == null) goto L88;
            Intrinsics.checkNotNullParameter(r17, "ev");
            if (r17.getAction() == 3) goto L72;
            r20.g.addMovement(r17);
            r20.c = r17.getY();
            r20.b = r17.getX();
        L78:
            r20.g.computeCurrentVelocity(IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            r20.e.put("duration", String.valueOf(System.currentTimeMillis() - r20.f));
            HashMap r21 = r20.e;
            StringBuilder r23 = new StringBuilder();
            r23.append(r20.b);
            r23.append(';');
            r23.append(r20.c);
            r21.put("upEv", r23.toString());
            r20.g.getXVelocity();
            r20.e.put("xVelocity", String.valueOf(r20.g.getXVelocity()));
            r20.g.getYVelocity();
            r20.getClass();
            r20.e.put("yVelocity", String.valueOf(r20.g.getYVelocity()));
            ((Number) r20.a.getFirst()).floatValue();
            r20.e.put("drayX", String.valueOf(r20.b - ((Number) r20.a.getFirst()).floatValue()));
            float r24 = r20.c;
            ((Number) r20.a.getSecond()).floatValue();
            r20.getClass();
            r20.e.put("drayY", String.valueOf(r20.c - ((Number) r20.a.getSecond()).floatValue()));
            r20.g.recycle();
            if (r20.i == false) goto L88;
            JSONObject r25 = new JSONObject();
            String[] r26 = r20.h;
            int r27 = r26.length;
            int r28 = 0;
            int r110 = 0;
        L81:
            if (r28 >= r27) goto L87;
            String r111 = r26[r28];
            int r112 = r110 + 1;
            if (StringsKt.endsWith$default(r111, ":", false, 2, null) == false) goto L85;
            r25.put("pointer_" + r110, r111 + r20.b + ';' + r20.c);
        L86:
            r28 = r28 + 1;
            r110 = r112;
            goto L81
        L85:
            r25.put("pointer_" + r110, r111);
            goto L86
        L87:
            r20.e.put("multPointer", r25.toString());
            goto L88
        L72:
            if (r20.d != (-1)) goto L78;
            int r29 = (int) Math.toDegrees(Math.atan2(r20.c - ((Number) r20.a.getSecond()).floatValue(), r20.b - ((Number) r20.a.getFirst()).floatValue()));
            r20.d = r29;
            if (r29 >= 0) goto L76;
            r20.d = r29 + 360;
        L76:
            r20.e.put("angle", String.valueOf(r20.d));
        L88:
            System.currentTimeMillis();
            r9.a = null;
            r9.e = 0;
            r9.f = 0;
            r9.g = 0;
            return;
        L90:
            if (r9.a != null) goto L102;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.b r30 = r9.b;
            if (r30 == null) goto L101;
            int r31 = r9.c;
            String r33 = r9.d;
            if (r18 == null) goto L96;
            int r34 = r18.getWidth();
        L97:
            if (r18 == null) goto L99;
            int r35 = r18.getHeight();
        L100:
            r2 = r30.a(r17, r31, r33, r34, r35, r9.k);
            goto L101
        L99:
            r35 = 0;
            goto L100
        L96:
            r34 = 0;
        L101:
            r9.a = r2;
        L102:
            r9.e = r17.getPointerId(0);
            return;
        }
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ GiftDialogFragmentV3 b;
        public final /* synthetic */ View c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GiftDialogFragmentV3 r0 = this.b;
            View r1 = this.a;
            View r2 = this.c;
            int r3 = GiftDialogFragmentV3.z;
            r0.U90(r1, r2);
        }

        public g(View r1, GiftDialogFragmentV3 r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final String getDegradeTag() {
        return com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL;
    }

    public final void T90() {
        if (this.y == false) goto L25;
        float r0 = nz1.a.q().c();
        View r1 = getView();
        if (r1 == null) goto L7;
        View r2 = r1.findViewById(2131373683);
    L9:
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L13;
        r3.width = (int) (i.a(375) * r0);
    L13:
        View r4 = getView();
        if (r4 == null) goto L26;
        View r5 = r4.findViewById(2131373682);
        if (r5 == null) goto L27;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L21;
        r6.width = (int) i.a(375);
    L21:
        if (r5.getHeight() <= 0) goto L23;
        U90(r5, r2);
        return;
    L23:
        r5.getViewTreeObserver().addOnGlobalLayoutListener(new g(r5, this, r2));
        return;
    L27:
        return;
    L26:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void dismiss() {
        if (((d51) com.bytedance.android.livesdk.gift.platform.core.g.m.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[10])).n() == false) goto L5;
        MatchRoomLandScapeAnimUtil.E.j("GiftDialogFragmentV3");
    L5:
        Context r0 = this.d;
        if (r0 == null) goto L17;
        DataCenter r1 = this.i;
        if (r1 == null) goto L17;
        r1.put("cmd_gift_dialog_switch", new f0((int) UIUtils.dip2Px(r0, 0.0f), false));
    L17:
        super.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void dismissAllowingStateLoss() {
        Object r3 = null;
        if (((d51) com.bytedance.android.livesdk.gift.platform.core.g.m.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[10])).n() == false) goto L5;
        MainThreadPostUtils.e(c.a);
    L5:
        Context r0 = this.d;
        if (r0 == null) goto L11;
        DataCenter r2 = this.i;
        if (r2 == null) goto L11;
        r2.put("cmd_gift_dialog_switch", new f0((int) UIUtils.dip2Px(r0, 0.0f), false));
    L11:
        if (this.o == true) goto L80;
        this.o = true;
        q r1 = this.r;
        if (r1 == null) goto L19;
        g1 r4 = (g1) com.bytedance.android.scope.m.e.d(r1, g1.class);
        if (r4 == null) goto L19;
        s0 r5 = r4.e;
        if (r5 == null) goto L19;
        long r6 = r5.a;
    L20:
        q r7 = this.r;
        if (r7 == null) goto L63;
        com.bytedance.android.scope.m r8 = com.bytedance.android.scope.m.e;
        GiftPanelMonitorService r9 = (GiftPanelMonitorService) r8.d(r7, GiftPanelMonitorService.class);
        if (r9 == null) goto L63;
        long r10 = this.m;
        long r11 = this.n;
        boolean r13 = r9.K.isAnchor();
        r9.i();
        LinkedHashMap r14 = new LinkedHashMap();
        String r15 = "1";
        String r16 = "0";
        if (r13 == false) goto L27;
        String r17 = "1";
    L28:
        r14.put("is_anchor", r17);
        if (v.e() == true) goto L32;
        r15 = "0";
    L32:
        r14.put("is_new_panel", r15);
        long r18 = r9.a;
        if (r18 <= 0) goto L35;
        r14.put("panel_trigger_time_gap", String.valueOf(r10 - r18));
    L35:
        r14.put("panel_render_duration", String.valueOf(r11 - r10));
        r14.put("panel_stay_duration", String.valueOf(System.currentTimeMillis() - r10));
        r14.put("widget_load_duration", String.valueOf(r9.d));
        r14.put("hit_view_cache", String.valueOf(r9.n));
        r14.put("gift_extra_cache", String.valueOf(r9.q));
        r14.put("icon_cache_miss_cnt", String.valueOf(r9.r));
        r14.put("lynx_init_duration", String.valueOf(r9.i));
        r14.put("lynx_load_duration", String.valueOf(r9.j));
        r14.put("panel_lynx_load_duration", String.valueOf(r9.k));
        r14.put("reduce_action_time", String.valueOf(r9.u));
        r14.put("reduce_action_cnt", String.valueOf(r9.t));
        r14.put("ui_task_time", String.valueOf(r9.w));
        r14.put("ui_task_cnt", String.valueOf(r9.v));
        r14.put("default_ui_task_time", String.valueOf(r9.y));
        r14.put("default_ui_task_cnt", String.valueOf(r9.x));
        r14.put("default_worker_task_time", String.valueOf(r9.A));
        r14.put("default_worker_task_cnt", String.valueOf(r9.z));
        r14.put("ui_action_gap_mills", String.valueOf(r9.B));
        r14.put("refresh_list_time", String.valueOf(r9.f));
        r14.put("first_interact_time", String.valueOf(r9.g));
        r14.put("ui_default_select_duration", String.valueOf(r9.l));
        r14.put("enter_room_to_open_duration", String.valueOf(r9.m));
        Pair<GiftContext, ? extends Disposable> r19 = r9.I.b;
        if (r19 == null) goto L38;
        GiftContext r20 = (GiftContext) r19.getFirst();
    L39:
        if (r20 == null) goto L41;
        r14.put("gift_image_render_duration", String.valueOf(((Number) r20.getFirstGiftImageRenderSucAt().getValue()).longValue() - r10));
        r14.put("default_select_duration", String.valueOf(((Number) r20.getDefaultGiftLocatedAt().getValue()).longValue() - r10));
        r14.put("content_first_render_duration", String.valueOf(((Number) r20.getGiftPanelFirstRenderTs().getValue()).longValue() - r9.e));
        r14.put("panel_first_screen_duration", String.valueOf(((Number) r20.getGiftPanelFirstRenderTs().getValue()).longValue() - r10));
    L41:
        i12.e r21 = o.b();
        if (r21 == null) goto L44;
        Object r23 = r8.d(r21, com.bytedance.android.livesdk.gift.platform.core.scope.service.f0.class);
    L45:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.f0 r24 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.f0) r23;
        i12.e r25 = o.b();
        if (r25 == null) goto L49;
        r3 = r8.d(r25, com.bytedance.android.livesdk.gift.platform.core.scope.service.f0.class);
    L49:
        if (((com.bytedance.android.livesdk.gift.platform.core.scope.service.f0) r3) == null) goto L51;
        r14.put("predict_duration", String.valueOf(r10 - 0));
    L51:
        r14.putAll(r9.s);
        w1 r26 = r9.L;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r14, "logMap");
        y1 r27 = r26.d;
        if (r27 == null) goto L54;
        r14.put("open_fps", String.valueOf(r27.a));
        r14.put("open_stall_rate", String.valueOf(r27.c));
        r14.put("open_stall_count", String.valueOf(r27.d));
        r14.put("open_stall_light_rate", String.valueOf(r27.f));
        r14.put("open_stall_medium_rate", String.valueOf(r27.i));
        r14.put("open_stall_serious_rate", String.valueOf(r27.l));
    L54:
        r9.a(r14);
        long r28 = r9.K.Hl();
        if (r28 <= 0) goto L57;
        r14.put("stay_room_duration", String.valueOf((r6 - r28) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
    L58:
        long r29 = r9.P.m;
        if (r29 <= 0) goto L61;
        r16 = String.valueOf((r10 - r29) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
    L61:
        r14.put("reopen_interval_time", r16);
        GiftDataStorageService r30 = r9.P;
        r30.getClass();
        r30.m = System.currentTimeMillis();
        r14.put("device_volume", String.valueOf(u.g()));
        r14.put("audience_cnt", String.valueOf(com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getCurrentAudienceCount()));
        jy0.b.a("ttlive_gift_panel_metrics", "panel closed, params=" + r14);
        n r31 = new n();
        Map r33 = r31.a;
        Intrinsics.checkNotNullParameter(r33, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r33.putAll(r14);
        mz0.m r34 = new mz0.m();
        r34.b(LogCommon.ROOM);
        r34.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r31.b).addAll(r34.a);
        cy0.e.a.getClass();
        Object r35 = com.bytedance.android.scope.m.b(cy0.e.a.a).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((f80.a) r35).w3("livesdk_gift_panel_show_end", r31.a, r31.b);
        goto L63
    L57:
        r14.put("stay_room_duration", "0");
        goto L58
    L44:
        r23 = null;
        goto L45
    L38:
        r20 = null;
        goto L39
    L27:
        r17 = "0";
    L63:
        if (this.v == true) goto L69;
        i12.e r36 = this.q;
        if (r36 == null) goto L69;
        GiftPanelViewPreloadService r37 = (GiftPanelViewPreloadService) com.bytedance.android.scope.m.e.d(r36, GiftPanelViewPreloadService.class);
        if (r37 == null) goto L69;
        r37.b.add(Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.c(r37)));
    L69:
        Iterator r38 = da0.a.a.iterator();
    L71:
        if (r38.hasNext() == false) goto L80;
        ((p) r38.next()).o();
    L19:
        r6 = System.currentTimeMillis();
    L80:
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L75
        return;
    L75:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r39 = DialogFragmentLancet.sLastShowStack;
        if (r39 == null) goto L82;
        com.bytedance.crash.d.d(r39, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onPause() {
        q r0 = this.r;
        if (r0 == null) goto L7;
        a2 r1 = (a2) com.bytedance.android.scope.m.e.d(r0, a2.class);
        if (r1 == null) goto L7;
        r1.g.a(new DialogPause());
    L7:
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public GiftDialogFragmentV3() {
        setNoTitleAndCancelOutside(true);
        LocateGiftInfo.Companion.getClass();
        this.e = LocateGiftInfo.a.a();
        this.j = new HashSet();
        this.k = new CompositeDisposable();
        this.p = true;
        this.w = new GiftUserBehaviorComponent();
        this.y = com.bytedance.android.livesdk.gift.util.c.c();
    }

    public final int getActualContentWidth() {
        if (com.bytedance.android.livesdk.gift.util.a.a() == false) goto L7;
        return i.b(375);
    L7:
        return i.b(398);
    }

    public final boolean onBackPressed() {
        if (v.c() == false) goto L14;
        q r0 = this.r;
        if (r0 == null) goto L7;
        GiftSearchDataStore r1 = (GiftSearchDataStore) com.bytedance.android.scope.m.e.d(r0, GiftSearchDataStore.class);
    L8:
        if (r1 == null) goto L14;
        if (r1.s() != true) goto L14;
        r1.back();
        return true;
    L7:
        r1 = null;
    L14:
        return super.onBackPressed();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.s == false) goto L6;
        vh6.c.b(tq2.a.class).exitCleanScreen(6);
    L6:
        if (this.k.isDisposed() == true) goto L8;
        this.k.dispose();
    L8:
        ((HashSet) this.j).clear();
        j r0 = this.r;
        if (r0 != null) goto L11;
        return;
    L11:
        if (l.b(r0) == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L18;
        l.c(r0);
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        if (nz1.a.n() == false) goto L12;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.b r0 = this.w.b;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.e.size() > 0) goto L9;
        return;
    L9:
        if (r0.e.size() <= 0) goto L15;
        r0.a.put("data", r0.e.toString());
        i0.h(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.a(r0.a));
        r0.e.clear();
        HashMap<String, String> r1 = new HashMap();
        r0.a = r1;
        r1.put("scene", String.valueOf(r0.b));
        r0.a.put("touchSlop", String.valueOf(r0.c));
        return;
    L15:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        GiftContext r1 = null;
        if (this.p == false) goto L5;
    L7:
        this.p = false;
        this.n = System.currentTimeMillis();
        q r0 = this.r;
        if (r0 == null) goto L14;
        g1 r2 = (g1) com.bytedance.android.scope.m.e.d(r0, g1.class);
        if (r2 == null) goto L14;
        s0 r3 = r2.e;
        if (r3 == null) goto L14;
        r3.e = System.currentTimeMillis();
    L14:
        q r4 = this.r;
        if (r4 == null) goto L22;
        a2 r5 = (a2) com.bytedance.android.scope.m.e.d(r4, a2.class);
        if (r5 == null) goto L22;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.d().E0() == true) goto L22;
        r5.g.a(new DialogResume());
    L22:
        q r6 = this.r;
        if (r6 == null) goto L47;
        GiftPanelMonitorService r7 = (GiftPanelMonitorService) com.bytedance.android.scope.m.e.d(r6, GiftPanelMonitorService.class);
        if (r7 == null) goto L48;
        long r8 = this.l;
        long r9 = this.m;
        long r10 = this.n;
        r7.a = r8;
        r7.b = r9;
        r7.c = r10;
        r7.p = r7.J.a.getIdString();
        Pair<GiftContext, ? extends Disposable> r11 = r7.I.b;
        if (r11 == null) goto L29;
        r1 = (GiftContext) r11.getFirst();
    L29:
        if (r1 == null) goto L49;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r13 = r1.getCurrentGiftEffect();
        if (r13 == null) goto L50;
        com.bytedance.android.livesdk.gift.platform.core.d r14 = (com.bytedance.android.livesdk.gift.platform.core.d) r13.getValue();
        if (r14 == null) goto L51;
        r7.G.put("effect_type", r14.getType());
        Map<String, String> r15 = r7.G;
        h2 r16 = r14.b;
        String r17 = "-1";
        if (r16 == null) goto L38;
        String r18 = String.valueOf(r16.getId());
        if (r18 == null) goto L38;
    L39:
        r15.put("effect_gift_id", r18);
        Map<String, String> r19 = r7.G;
        h2 r20 = r14.b;
        if (r20 == null) goto L45;
        String r21 = String.valueOf(r20.getDiamondCount());
        if (r21 == null) goto L45;
        r17 = r21;
    L45:
        r19.put("effect_price", r17);
        return;
    L38:
        r18 = "-1";
        goto L39
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L5:
        if (((Boolean) nz1.a.a0.getValue(null, nz1.a.a[51])).booleanValue() == false) goto L7;
    }

    public final boolean getEnableAdjustWidth() {
        return this.y;
    }

    public final void S90(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.onDismiss(r3);
        Iterator r0 = ((HashSet) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((DialogInterface.OnDismissListener) r0.next()).onDismiss(r3);
        goto L4
    L7:
        if (this.t == false) goto L11;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
        return;
    }

    public final void onActivityCreated(Bundle r8) {
        super.onActivityCreated(r8);
        Dialog r9 = getDialog();
        Integer r0 = null;
        if (r9 == null) goto L5;
        Window r10 = r9.getWindow();
    L7:
        if (r10 == null) goto L12;
        View r2 = r10.findViewById(2131389843);
        if (r2 == null) goto L12;
        r2.setImportantForAccessibility(2);
    L12:
        if (com.bytedance.android.livesdk.gift.util.a.b() == false) goto L30;
        if (r10 == null) goto L17;
        View r3 = r10.findViewById(2131373683);
        if (r3 == null) goto L17;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L19:
        if ((r4 instanceof FrameLayout.LayoutParams) == true) goto L21;
        r4 = null;
    L21:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r5 == null) goto L30;
        if (r10 == null) goto L27;
        View r1 = r10.findViewById(2131389843);
        if (r1 == null) goto L27;
        r0 = Integer.valueOf(r1.getHeight());
    L27:
        if (r0 == null) goto L29;
        r5.topMargin = s1.f(r5.height - r0.intValue());
    L29:
        r5.gravity = 80;
    L17:
        r4 = null;
    L30:
        if (r10 != null) goto L32;
    L63:
        setBottomSheetSlideProcessor(e.a);
        return;
    L32:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class)).a(isVertical(), this.g, DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), isVertical(), this.g)) == false) goto L34;
        r10.addFlags(1024);
    L36:
        if (isVertical() == false) goto L38;
        r10.setGravity(80);
    L39:
        r10.setSoftInputMode(48);
        if (PadConfigUtils.c() == false) goto L44;
        setBottomSheetSlideProcessor(d.a);
        return;
    L44:
        if (this.h == false) goto L54;
        r10.setLayout(-1, -2);
        WindowManager.LayoutParams r6 = r10.getAttributes();
        r6.width = s1.y();
        r6.height = s1.w();
        r10.setAttributes(r6);
        if (getView() == null) goto L63;
        View r11 = getView();
        Intrinsics.checkNotNull(r11);
        if ((r11.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        View r13 = getView();
        Intrinsics.checkNotNull(r13);
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L53;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        r15.height = s1.w();
        View r7 = getView();
        Intrinsics.checkNotNull(r7);
        r7.setLayoutParams(r15);
        goto L63
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        r10.setLayout(-1, -1);
        if (getView() == null) goto L63;
        View r16 = getView();
        Intrinsics.checkNotNull(r16);
        if ((r16.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        View r17 = getView();
        Intrinsics.checkNotNull(r17);
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L62;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.height = s1.s(getActivity());
        View r20 = getView();
        Intrinsics.checkNotNull(r20);
        r20.setLayoutParams(r19);
        goto L63
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        r10.setGravity(8388613);
        goto L39
    L34:
        r10.clearFlags(1024);
        goto L36
    L5:
        r10 = null;
        goto L7
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r3);
        if (nz1.a.n() == false) goto L16;
        GiftUserBehaviorComponent r0 = this.w;
        r0.getClass();
        if (r3 == null) goto L7;
        r0.j = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r3));
    L7:
        r0.k = BuildConfig.FLAVOR;
        GiftUserBehaviorComponent r4 = this.w;
        r4.getClass();
        r4.b = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior.b(r4.j);
        DataCenter r5 = this.i;
        if (r5 == null) goto L13;
        Long r6 = (Long) r5.get("data_room_id", 0L);
        if (r6 == null) goto L13;
        String r7 = String.valueOf(r6.longValue());
        if (r7 == null) goto L13;
    L14:
        GiftUserBehaviorComponent r1 = this.w;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "roomId");
        r1.d = r7;
        r1.c = 0;
        return;
    L13:
        r7 = "0";
        goto L14
    }

    public final void onCancel(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        if (this.u == false) goto L14;
        DataCenter r0 = this.i;
        if (r0 == null) goto L10;
        Long r1 = (Long) r0.get("data_room_id", 0L);
        if (r1 == null) goto L10;
        String r2 = String.valueOf(r1.longValue());
        if (r2 == null) goto L10;
    L11:
        nq2.a r3 = vh6.c.b(nq2.a.class);
        if (r3 == null) goto L14;
        r3.excActionBySetting(r2);
    L10:
        r2 = "0";
    L14:
        super.onCancel(r4);
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        if (FoldScreenUtils.f() == true) goto L5;
        return;
    L5:
        if (this.y == true) goto L7;
        return;
    L7:
        if (FoldScreenUtils.a() == 0) goto L24;
        View r5 = getView();
        if (r5 == null) goto L11;
        View r6 = r5.findViewById(2131373683);
    L12:
        if (r6 == null) goto L16;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L16;
        r0.width = -1;
    L16:
        View r1 = getView();
        if (r1 == null) goto L28;
        View r2 = r1.findViewById(2131373682);
        if (r2 == null) goto L29;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L23;
        r3.width = (int) i.a(375);
    L23:
        r2.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.b(r2, r6));
        return;
    L29:
        return;
    L28:
        return;
    L11:
        r6 = null;
        goto L12
    L24:
        T90();
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        int r0 = 2131954677;
        if (isVertical() == false) goto L13;
        GiftPanelBizBoostUtils r7 = GiftPanelBizBoostUtils.E;
        r7.getClass();
        boolean r8 = ((Boolean) GiftPanelBizBoostUtils.k.getValue(r7, GiftPanelBizBoostUtils.a[9])).booleanValue();
        if (this.h == false) goto L9;
        if (r8 == false) goto L8;
        r0 = 2131954682;
    L11:
        setStyle(1, r0);
        return;
    L8:
        r0 = 2131954681;
        goto L11
    L9:
        if (r8 == false) goto L11;
        r0 = 2131954680;
        goto L11
    L13:
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_DIALOG_LANDSCAPE_SINGLE_LIST, Boolean.FALSE)).booleanValue() == false) goto L15;
        ((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f();
        setStyle(1, 2131954677);
        return;
    L15:
        setStyle(1, 2131954679);
    }

    public final Dialog onCreateDialog(Bundle r8) {
        if (com.bytedance.android.livesdk.gift.util.a.b() == false) goto L9;
        Context r2 = getContext();
        if (r2 == null) goto L9;
        return new LiveStandardSheetDialog(r2, true, false, true, com.bytedance.android.livesdk.gift.util.c.c());
    L9:
        return super.onCreateDialog(r8);
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void setEnableAdjustWidth(boolean r1) {
        this.y = r1;
    }

    public final void U90(View r3, View r4) {
        float r0 = nz1.a.q().c();
        r3.setPivotX(0.0f);
        r3.setPivotY(r3.getHeight());
        r3.setScaleX(r0);
        r3.setScaleY(r0);
        if (v.e() == true) goto L5;
        return;
    L5:
        if (this.x > 0) goto L8;
        this.x = r3.getHeight();
    L8:
        if (this.x <= 0) goto L15;
        if (r4 == null) goto L16;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L17;
        r5.height = (int) (this.x * r0);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        if (((d51) com.bytedance.android.livesdk.gift.platform.core.g.m.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[10])).n() == false) goto L5;
        boolean r0 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y("GiftDialogFragmentV3", this, -1);
    L5:
        super.onViewCreated(r8, r9);
        if ((this.d instanceof FragmentActivity) == false) goto L68;
        i12.e r10 = this.q;
        if (r10 != null) goto L10;
    L39:
        final q r11 = this.r;
        if (r11 == null) goto L60;
        Pair r1 = com.bytedance.live.datacontext.d.a(new GiftDialogFragmentV3$onViewCreated$3$1(r11));
        b r2 = (b) r1.component1();
        this.k.add((Disposable) r1.component2());
        r2.shareAsCurrent();
        l.a(r11);
        com.bytedance.android.scope.m r3 = com.bytedance.android.scope.m.e;
        g1 r4 = (g1) r3.d(r11, g1.class);
        if (r4 == null) goto L46;
        s0 r5 = r4.e;
        if (r5 == null) goto L46;
        r5.a = System.currentTimeMillis();
    L46:
        w1 r13 = (w1) r3.d(r11, w1.class);
        if (r13 == null) goto L60;
        Dialog r6 = getDialog();
        if (r6 == null) goto L51;
        Window r7 = r6.getWindow();
    L52:
        w1.a r14 = w1.j;
        r14.getClass();
        ReadOnlyProperty r15 = w1.g;
        KProperty[] r16 = w1.a.a;
        if (((Boolean) r15.getValue(r14, r16[0])).booleanValue() == false) goto L60;
        if (((Boolean) w1.i.getValue(r14, r16[2])).booleanValue() == false) goto L58;
        r13.a.startMonitorFps("open_gift_panel", null);
    L59:
        r13.e = false;
        r13.b = SystemClock.uptimeMillis();
        r13.c = Observable.timer(((Number) w1.h.getValue(r14, r16[1])).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new x1(r13));
        goto L60
    L58:
        r13.a.startMonitorFps("open_gift_panel", r7);
        goto L59
    L51:
        r7 = null;
    L60:
        GiftPanelWidget r17 = new GiftPanelWidget(this.r);
        WidgetManager r18 = WidgetManager.of(this, getView());
        r18.setDataCenter(this.i);
        r18.setWidgetConfigHandler(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.a(this));
        GiftPanelBizBoostUtils.E.getClass();
        r18.load(2131373682, r17, true ^ GiftPanelBizBoostUtils.y);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.j(this.e));
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.LazyEvent(new GiftStateMachineConfig.Event.j(this.e.setLocateSecond()), GiftStateMachineConfig.e.b.class));
        T90();
        return;
    L10:
        if (l.b(r10) == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L39;
        LocateGiftInfo r19 = this.e;
        Bundle r20 = this.f;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r19, "mLocateGiftInfo");
        q r21 = new q(r10);
        Intrinsics.checkNotNullParameter(r21, "scope");
        Intrinsics.checkNotNullParameter(r19, "value");
        r21.e = r19;
        r21.f = r20;
        Object r23 = k.a;
        if (r19 != r23) goto L17;
        String r24 = "locateGiftInfo";
    L35:
        if (r24 != null) goto L38;
        this.r = r21;
        goto L39
    L38:
        throw new UninitializedPropertyAccessException(r24);
    L17:
        if (r20 != r23) goto L20;
        r24 = "giftLogExtra";
        goto L35
    L20:
        if (r21.g != r23) goto L23;
        r24 = "context";
        goto L35
    L23:
        if (r21.h != r23) goto L26;
        r24 = "dataCenter";
        goto L35
    L26:
        if (r21.i != r23) goto L29;
        r24 = "roomContext";
        goto L35
    L29:
        if (r21.j != r23) goto L32;
        r24 = "isInLive";
        goto L35
    L32:
        if (r21.k != r23) goto L34;
        r24 = "roomInstance";
        goto L35
    L34:
        r24 = null;
        goto L35
    L68:
        dismissAllowingStateLoss();     // Catch: Exception -> L63
        return;
    L63:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r25 = DialogFragmentLancet.sLastShowStack;
        if (r25 == null) goto L71;
        com.bytedance.crash.d.d(r25, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void show(FragmentManager r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "manager");
        ReadOnlyProperty r0 = h.D;
        KProperty[] r1 = h.a;
        boolean r2 = ((Boolean) r0.getValue(null, r1[28])).booleanValue();
        this.t = r2;
        if (r2 == false) goto L6;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).monitorPerformance("gift_panel_open");
        HashMap r3 = new HashMap();
        r3.put("tag", Intrinsics.stringPlus(r8, BuildConfig.FLAVOR));
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStart(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL, r3);
    L6:
        if (((Boolean) h.H.getValue(null, r1[32])).booleanValue() == true) goto L8;
    L10:
        boolean r4 = false;
    L11:
        this.s = r4;
        if (r4 == false) goto L14;
        vh6.c.b(tq2.a.class).enterCleanScreen(6);
    L14:
        this.m = System.currentTimeMillis();
        this.n = 0;
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L17;
        r5.getFirstGiftImageRenderSucAt().setValue(0L);
        r5.getDefaultGiftLocatedAt().setValue(0L);
        r5.getGiftPanelFirstRenderTs().setValue(0L);
        r5.getFirstViewHolderAttached().setValue(Boolean.FALSE);
    L17:
        GiftDataStorageService r6 = s.b();
        if (r6 == null) goto L22;
        r6.p++;
        GiftContext r9 = (GiftContext) r6.n.getValue();
        if (r9 == null) goto L22;
        r9.setPanelOpenTimes(r9.getPanelOpenTimes() + 1);
    L22:
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r8, r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, this, r10) == true) goto L31;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L26:
        super.show(r7, r8);
        return;
    L31:
        return;
    L8:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class).Jc() == true) goto L10;
        r4 = true;
        goto L11
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566121, r3, false);
        if (nz1.a.n() == false) goto L15;
        View r6 = null;
        if (r5 == null) goto L7;
        View r7 = r5.findViewById(2131373682);
    L9:
        if ((r7 instanceof GiftUserBehaviorPanel) == false) goto L12;
        r6 = r7;
    L12:
        GiftUserBehaviorPanel r8 = (GiftUserBehaviorPanel) r6;
        if (r8 == null) goto L15;
        r8.setTouchLisetner(new f(this));
        goto L15
    L7:
        r7 = null;
    L15:
        return r5;
    }
}
