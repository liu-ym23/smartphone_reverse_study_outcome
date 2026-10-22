package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.ui.LoadMoreLayout;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.config.xj;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.w0;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.ChannelMemberManageUserDiffCallback;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListFooterViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListHeaderViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberSubTitleViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.l0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.service.ICleanScreenManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import r52.d4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChannelMemberManagerDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelMemberManagerDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int k0 = 0;
    public final int B;
    public MultiTypeAdapter C;
    public final List<Object> D;
    public boolean E;
    public List<ChannelLinkUserInfo> F;
    public List<ChannelLinkUserInfo> G;
    public List<ChannelLinkUserInfo> H;
    public final Set<String> I;
    public int J;
    public final CompositeDisposable K;
    public final CompositeDisposable L;
    public final CompositeDisposable M;
    public yo2.e N;
    public yo2.e O;
    public View P;
    public boolean Q;
    public final String R;
    public final String S;
    public final a T;
    public final e U;
    public final b V;
    public final DataCenter W;
    public final long X;
    public final s22.a Y;
    public final s22.e Z;

    public static final class a extends s22.e.a {
        public final /* synthetic */ ChannelMemberManagerDialog a;

        @Override // s22.e.a
        public final void a(s22.a r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "chatChannel");
        }

        public a(ChannelMemberManagerDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog, java.lang.Object] */
        @Override // s22.e.a
        public final void b(long r4) {
            if (this.a.Y.getChannelId() != r4) goto L21;
            ?? r5 = this.a;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r7 == null) goto L18;
            com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r6.getLooper()) goto L9;
            r6.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public static final class b implements ChannelMemberListItemViewBinder.a {
        public final /* synthetic */ ChannelMemberManagerDialog a;

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void d(ChannelLinkUserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "channelLinkUser");
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void g() {
            User r0 = (User) this.a.Y.getOwner().a;
            this.a.getClass();
        }

        public b(ChannelMemberManagerDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void a(ChannelLinkUserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "channelLinkUser");
            if (((Boolean) this.a.Y.v().a).booleanValue() == false) goto L6;
            this.a.getClass();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void b(ChannelLinkUserInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "channelLinkUser");
            int r0 = e62.d.a;
            User r4 = r3.a;
            Intrinsics.checkNotNullParameter(r4, "user");
            UserProfileEvent r1 = new UserProfileEvent(r4);
            r1.mSource = "room_channel_panel";
            r1.setForceSecret(!e62.d.a(r4));
            r1.fromRoomChannelType = 1;
            r1.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
            xs2.b.a().post(r1);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void c(ChannelLinkUserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "channelLinkUser");
            ChannelMemberManagerDialog r3 = this.a;
            int r0 = ChannelMemberManagerDialog.k0;
            r3.getClass();
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void e(ChannelLinkUserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "channelLinkUser");
            ChannelMemberManagerDialog r3 = this.a;
            int r0 = ChannelMemberManagerDialog.k0;
            r3.getClass();
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void f(ChannelLinkUserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "channelLinkUser");
            if (Intrinsics.areEqual(r2.a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b())) == false) goto L6;
            ChannelMemberManagerDialog r3 = this.a;
            int r0 = ChannelMemberManagerDialog.k0;
            r3.getClass();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void i(ChannelLinkUserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "channelLinkUser");
            if (Intrinsics.areEqual(r2.a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b())) == false) goto L6;
            ChannelMemberManagerDialog r3 = this.a;
            int r0 = ChannelMemberManagerDialog.k0;
            r3.getClass();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void h(ChannelLinkUserInfo r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r9, "targetLinkUser");
            boolean r11 = !(!r10);
            if (Intrinsics.areEqual(r9.a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b())) == false) goto L21;
            RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r13 == null) goto L11;
            com.bytedance.live.datacontext.n r14 = r13.getCurTabId();
            if (r14 == null) goto L11;
            Long r15 = (Long) r14.getValue();
            if (r15 == null) goto L11;
            long r0 = r15.longValue();
        L12:
            int r16 = o62.a.a;
            Intrinsics.checkNotNullParameter("panel", "location");
            HashMap r3 = new HashMap();
            String r4 = "0";
            if (r11 == false) goto L15;
            Object r6 = "0";
        L16:
            r3.put("previous_state", r6);
            r3.put("is_levitation_ball", "0");
            MultiTabType.Companion.getClass();
            r3.put("tab_type", MultiTabType.a.a(r0).getLogParam());
            if (r11 == true) goto L20;
            r4 = "1";
        L20:
            r3.put("micro_state", r4);
            r3.put("location", "panel");
            o62.a.a("livesdk_match_chat_voice_button_click", r3);
            goto L21
        L15:
            r6 = "1";
        L11:
            r0 = -1;
        L21:
            ChannelMemberManagerDialog r17 = this.a;
            int r18 = ChannelMemberManagerDialog.k0;
            r17.getClass();
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog] */
        /* JADX WARN: Type inference failed for: r2v11, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog] */
        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void j(HSImageView r13, final ChannelLinkUserInfo r14) {
            Intrinsics.checkNotNullParameter(r13, "anchorView");
            Intrinsics.checkNotNullParameter(r14, "data");
            if (Intrinsics.areEqual(r14.a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b())) == false) goto L6;
            final ?? r0 = this.a;
            int r2 = ChannelMemberManagerDialog.k0;
            View r3 = LayoutInflater.from(r0.getContext()).inflate(2131565747, null);
            r3.findViewById(2131377684).setOnClickListener(x0.a(new ChannelMemberManagerDialog$showSelfMoreDialog$1(r0)));
            yo2.e r10 = new yo2.e(r0.getContext());
            ((yo2.d) r10).d = r3;
            ((yo2.d) r10).e = 0;
            ((yo2.d) r10).j = 2131954633;
            ((yo2.d) r10).m = 0;
            ((yo2.d) r10).l = true;
            ChannelMemberManagerDialog.W0(r10, r13);
            r10.a();
            r0.N = r10;
            r10.i(r13, 4, 1, 0, s1.f(20.0f));
            return;
        L6:
            if (((Boolean) this.a.Y.v().a).booleanValue() == false) goto L13;
            final ?? r4 = this.a;
            View r9 = LayoutInflater.from(r4.getContext()).inflate(2131565746, null);
            if (r14.b.a != ChannelLinkUserInfo.ChannelUserRole.Audience) goto L10;
            UtilityKotlinExtentionsKt.w(r9.findViewById(2131376853));
            UtilityKotlinExtentionsKt.w(r9.findViewById(2131376852));
            r9.findViewById(2131376853).setOnClickListener(x0.a(new ChannelMemberManagerDialog$showOthersMoreDialog$1(r4, r14)));
        L10:
            r9.findViewById(2131376851).setOnClickListener(x0.a(new ChannelMemberManagerDialog$showOthersMoreDialog$2(r4, r14)));
            yo2.e r11 = new yo2.e(r4.getContext());
            ((yo2.d) r11).d = r9;
            ((yo2.d) r11).e = 0;
            ((yo2.d) r11).j = 2131954633;
            ((yo2.d) r11).m = 0;
            ((yo2.d) r11).l = true;
            ChannelMemberManagerDialog.W0(r11, r13);
            r11.a();
            r4.O = r11;
            r11.i(r13, 4, 1, 0, s1.f(20.0f));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ChannelMemberManagerDialog a;
        public final /* synthetic */ boolean b;

        public c(ChannelMemberManagerDialog r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r13) {
            Response r14 = (Response) r13;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h r0 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h) ((BaseResponse) r14).data;
            if (r0 == null) goto L77;
            List<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a> r1 = r0.b();
            if (r1 != null) goto L7;
            return;
        L7:
            if (this.b == false) goto L22;
            ChannelMemberManagerDialog r2 = this.a;
            int r6 = ChannelMemberManagerDialog.k0;
            r2.getClass();
            ArrayList r7 = new ArrayList();
            Iterator<T> r3 = r1.iterator();
        L10:
            if (r3.hasNext() == false) goto L21;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a r8 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a) r3.next();
            User r9 = r8.b();
            if (r9 == null) goto L10;
            Intrinsics.checkNotNullParameter(r8, "userInfo");
            if (r8.a() == false) goto L17;
            ChannelLinkUserInfo.ChannelUserRole r10 = ChannelLinkUserInfo.ChannelUserRole.GuestApplicant;
        L20:
            r7.add(new ChannelLinkUserInfo(r9, new ChannelLinkUserInfo.a(r10, r2.E)));
            String r11 = r9.getCastSecUid();
            r2.I.add(r11);
            goto L10
        L17:
            if (r8.c() == false) goto L19;
            r10 = ChannelLinkUserInfo.ChannelUserRole.Manager;
            goto L20
        L19:
            r10 = ChannelLinkUserInfo.ChannelUserRole.Guest;
            goto L20
        L21:
            r2.J = r2.I.size();
            r2.c1(r2.F, r2.G, r7);
        L57:
            ChannelMemberManagerDialog r4 = this.a;
            r4.Q = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h) ((BaseResponse) r14).data).a();
            if (((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h) ((BaseResponse) r14).data).a() == true) goto L60;
            ChannelMemberManagerDialog r15 = this.a;
            r15.P = r15.findViewById(2131380931);
            this.a.findViewById(2131378946).setFootView(this.a.findViewById(2131380931));
            ((LinearLayout) this.a.findViewById(2131379011)).setVisibility(8);
            ((TextView) this.a.findViewById(2131380931)).setVisibility(0);
        L60:
            this.a.findViewById(2131378946).setEnableLoadMore(true);
            return;
        L22:
            ChannelMemberManagerDialog r5 = this.a;
            int r16 = ChannelMemberManagerDialog.k0;
            r5.getClass();
            ArrayList r17 = new ArrayList();
            r17.addAll(r5.H);
            ArrayList r18 = new ArrayList();
            Iterator<T> r19 = r1.iterator();
        L24:
            if (r19.hasNext() == false) goto L39;
            T r20 = r19.next();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a r21 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a) r20;
            User r110 = r21.b();
            if (r110 != null) goto L28;
        L36:
            boolean r23 = false;
        L37:
            if (r23 == false) goto L24;
            r18.add(r20);
            goto L24
        L28:
            if (r110.getCastSecUid() == null) goto L36;
            if (r5.I.contains(r110.getCastSecUid()) == true) goto L36;
            if (((Boolean) r5.Y.v().a).booleanValue() == false) goto L34;
        L35:
            r23 = true;
            goto L37
        L34:
            if (r21.a() == true) goto L36;
        L39:
            Iterator r24 = r18.iterator();
        L41:
            if (r24.hasNext() == false) goto L52;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a r25 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a) r24.next();
            User r26 = r25.b();
            if (r26 == null) goto L41;
            Intrinsics.checkNotNullParameter(r25, "userInfo");
            if (r25.a() == false) goto L48;
            ChannelLinkUserInfo.ChannelUserRole r27 = ChannelLinkUserInfo.ChannelUserRole.GuestApplicant;
        L51:
            r17.add(new ChannelLinkUserInfo(r26, new ChannelLinkUserInfo.a(r27, r5.E)));
            r5.I.add(r26.getCastSecUid());
            goto L41
        L48:
            if (r25.c() == false) goto L50;
            r27 = ChannelLinkUserInfo.ChannelUserRole.Manager;
            goto L51
        L50:
            r27 = ChannelLinkUserInfo.ChannelUserRole.Guest;
            goto L51
        L52:
            r5.J = r5.I.size();
            r5.c1(r5.F, r5.G, r17);
            LoadMoreLayout r28 = this.a.findViewById(2131378946);
            r28.h = false;
            View r29 = r28.c;
            if (r29 == null) goto L57;
            if (r28.e == false) goto L57;
            r28.a(0, -r29.getMeasuredHeight());
            goto L57
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ChannelMemberManagerDialog a;

        public d(ChannelMemberManagerDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.findViewById(2131378946).setEnableLoadMore(true);
        }
    }

    public static final class e implements ChannelMemberTitleViewBinder.a {
        public final /* synthetic */ ChannelMemberManagerDialog a;
        public final /* synthetic */ Context b;

        /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog] */
        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder.a
        public final void a() {
            if (this.a.Y.k() == false) goto L29;
            ?? r0 = this.a;
            String r1 = r0.S;
            if (r1 == null) goto L42;
            int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.a;
            long r3 = r0.Y.getChannelId();
            Intrinsics.checkNotNullParameter(r1, "schema");
            Uri r4 = UriProtector.parse(r1);
            Uri.Builder r5 = r4.buildUpon();
            Set<String> r7 = r4.getQueryParameterNames();     // Catch: Exception -> L21 Throwable -> L31
            Uri.Builder r8 = r4.buildUpon().clearQuery();     // Catch: Exception -> L21 Throwable -> L31
            Iterator<String> r9 = r7.iterator();     // Catch: Exception -> L21 Throwable -> L31
        L9:
            if (r9.hasNext() == false) goto L20;
            String r10 = r9.next();     // Catch: Exception -> L21 Throwable -> L31
            if (Intrinsics.areEqual(r10, "url") == false) goto L17;
            String r11 = r4.getQueryParameter(r10);     // Catch: Exception -> L21 Throwable -> L31
            if (r11 == null) goto L16;
            int r13 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.a;     // Catch: Exception -> L21 Throwable -> L31
            String r14 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.b(r11, "channel_id", String.valueOf(r3));     // Catch: Exception -> L21 Throwable -> L31
        L18:
            r8.appendQueryParameter(r10, r14);     // Catch: Exception -> L21 Throwable -> L31
            goto L9
        L16:
            r14 = null;
            goto L18
        L17:
            r14 = r4.getQueryParameter(r10);     // Catch: Exception -> L21 Throwable -> L31
            goto L18
        L20:
            Uri r6 = r8.build();
        L24:
            String r15 = r6.toString();
            if (r15 == null) goto L39;
            IBaseLiveActionHandler r16 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r16 == null) goto L40;
            r16.handle(r0.getContext(), r15);
            return;
        L40:
            return;
        L39:
            return;
        L21:
            e = move-exception;
            SafetyGuard.a(null, e, "origin schema is " + r1);     // Catch: Throwable -> L31
        L23:
            r6 = r5.build();
            goto L24
        L42:
            return;
        L29:
            f2.b(2131915716, 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder.a
        public final void b() {
            if (((Boolean) this.a.Y.v().a).booleanValue() == false) goto L10;
            Context r1 = this.b;
            ChannelMemberManagerDialog r2 = this.a;
            ChatChannelOwnerSettingDialog r0 = new ChatChannelOwnerSettingDialog(r1, r2.X, r2.Y);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r0);
        L9:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_channel_set_icon_click", null);
            return;
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
        L8:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L9
        L10:
            Context r3 = this.b;
            ChannelMemberManagerDialog r4 = this.a;
            ChatChannelMemberSettingDialog r5 = new ChatChannelMemberSettingDialog(r3, r4.X, r4.Y);
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r5);
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L14:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder.a
        public final void c() {
            if (this.a.Y.w() == false) goto L5;
            this.a.Z.getWidgetManager().a(this.a.Y);
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.g("member_panel");
            return;
        L5:
            f2.b(2131915709, 0);
        }

        public e(ChannelMemberManagerDialog r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final boolean V0() {
        return true;
    }

    public final int getLayoutId() {
        return 2131567388;
    }

    public final void X0() {
        yo2.e r0 = this.O;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() != true) goto L11;
        yo2.e r1 = this.O;
        if (r1 == null) goto L12;
        r1.d();
        return;
    L12:
        return;
    }

    public final void Y0() {
        yo2.e r0 = this.N;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() != true) goto L11;
        yo2.e r1 = this.N;
        if (r1 == null) goto L12;
        r1.d();
        return;
    L12:
        return;
    }

    public final void a1() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.W, 0, 2);
        if (r0 != null) goto L6;
        return;
    L6:
        if (ChatChannelUtils.a(r0) == ContainerType.PublicScreen) goto L8;
        return;
    L8:
        if (ChatChannelUtils.j(r0) == false) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r1 = ChatChannelUtils.g(r0);
        if (r1 == null) goto L15;
        r1.tryChangePage(PublicScreenAreaPageType.ChatChannel, this.Y.getChannelId(), PublicScreenAreaPageChangeSource.ManageDialog);
        return;
    L15:
        return;
    }

    public final void show() {
        if (this.Y.s() == true) goto L7;
        f2.c((String) this.Y.r().a, 0);
        a1();
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(this);
    L11:
        s22.e r0 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.X, 1));
        if (r0 == null) goto L14;
        r0.addListener(this.T);
    L14:
        int r1 = l0.a;
        ICleanScreenManager r2 = jc1.k.f(ICleanScreenManager.class);
        if (r2 == null) goto L21;
        r2.enterCleanScreen(3);
        return;
    L21:
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L10:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.W.put("data_chat_channel_member_panel_close_event", Boolean.TRUE);
        s22.e r1 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.X, 1));
        if (r1 == null) goto L20;
        r1.removeListener(this.T);
    L20:
        this.M.clear();
        this.K.clear();
        this.L.clear();
        this.Z.recordChatChannelDialog(this.R, null);
        Y0();
        X0();
        int r2 = l0.a;
        ICleanScreenManager r3 = jc1.k.f(ICleanScreenManager.class);
        if (r3 == null) goto L29;
        r3.exitCleanScreen(3);
        return;
    L29:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void Z0(boolean r6) {
        if (this.Q == true) goto L10;
        LoadMoreLayout r7 = findViewById(2131378946);
        r7.h = false;
        View r0 = r7.c;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r7.e == false) goto L13;
        r7.a(0, -r0.getMeasuredHeight());
        return;
    L13:
        return;
    L10:
        findViewById(2131378946).setEnableLoadMore(false);
        Disposable r8 = this.Z.getChannelUserList(this.Y.getChannelId(), this.J, this.B).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r6), new d(this));
        this.K.add(r8);
    }

    public final void b1(boolean r5) {
        xj r0 = xj.a;
        Integer r1 = (Integer) r0.getValue();
        boolean r2 = false;
        if (r1 != null) goto L6;
    L7:
        Integer r3 = (Integer) r0.getValue();
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L18;
        if (r5 == false) goto L18;
        r2 = true;
    L18:
        this.E = r2;
        return;
    L11:
        if (r3.intValue() != 1) goto L13;
    L14:
        r4 = true;
        goto L15
    L6:
        if (r1.intValue() == 0) goto L14;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        int r13 = e62.a.a;
        Window r14 = getWindow();
        View r0 = findViewById(2131367728);
        RoomContext.a r1 = RoomContext.Companion;
        e62.a.a(r14, r0, RoomContext.a.c(r1, null, 0, 3));
        MultiTypeAdapter r15 = new MultiTypeAdapter(this.D);
        this.C = r15;
        r15.z2(ChannelMemberTitleViewBinder.b.class, new ChannelMemberTitleViewBinder(this.U));
        MultiTypeAdapter r16 = this.C;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r16.z2(ChannelMemberListHeaderViewBinder.a.class, new ChannelMemberListHeaderViewBinder());
        MultiTypeAdapter r17 = this.C;
        if (r17 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        r17.z2(ChannelMemberSubTitleViewBinder.a.class, new ChannelMemberSubTitleViewBinder());
        MultiTypeAdapter r18 = this.C;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        r18.z2(ChannelLinkUserInfo.class, new ChannelMemberListItemViewBinder(this.Y, this.V));
        MultiTypeAdapter r19 = this.C;
        if (r19 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L14:
        r19.z2(ChannelMemberListFooterViewBinder.a.class, new ChannelMemberListFooterViewBinder());
        RecyclerView r6 = findViewById(2131379850);
        MultiTypeAdapter r7 = this.C;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r6.setAdapter(r7);
        SSLinearLayoutManager r2 = new SSLinearLayoutManager(getContext());
        r2.setOrientation(1);
        findViewById(2131379850).setLayoutManager(r2);
        findViewById(2131379850).setItemAnimator(null);
        findViewById(2131378946).setLoadMoreCallback(new f(this));
        this.P = findViewById(2131379011);
        findViewById(2131378946).setFootView(findViewById(2131379011));
        b1(((Boolean) this.Y.d().a).booleanValue());
        Disposable r110 = RxUtilKt.h(this.Y.d()).subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.widget.e(this));
        this.M.add(r110);
        ArrayList r111 = new ArrayList();
        c1(this.F, this.G, r111);
        Z0(true);
        RxUtilKt.c(RxUtilKt.h(xs2.b.a().b(u22.m.class)).subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.widget.c(this)), this.M);
        RxUtilKt.c(this.Y.z().subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.widget.d(this)), this.M);
        if (PadConfigUtils.c() == false) goto L23;
        RoomContext r112 = RoomContext.a.c(r1, null, 0, 3);
        if (r112 == null) goto L23;
        RxUtilKt.c(r112.getPadOrientation().a().subscribe(new g(this)), this.M);
    L23:
        a1();
        int r113 = o62.a.a;
        long r3 = ((Number) this.Y.d0().a).longValue();
        Intrinsics.checkNotNullParameter("[]", "voiceFriendList");
        HashMap r114 = new HashMap();
        r114.put("member_number", String.valueOf(r3));
        r114.put("voice_number", String.valueOf(0));
        r114.put("friend_list", "[]");
        o62.a.a("livesdk_match_chat_member_panel_show", r114);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.h("member_panel");
        this.Z.recordChatChannelDialog(this.R, this);
    }

    public static void W0(yo2.e r3, HSImageView r4) {
        View r0 = new View(r4.getContext());
        r0.setFocusable(true);
        r0.setClickable(true);
        r3.c(r0, "关闭", true);
        HashMap r1 = new HashMap();
        r3.x = new com.bytedance.android.livesdk.interactivity.chatchannel.widget.a(r4, r1, r0);
        ((yo2.d) r3).k = new com.bytedance.android.livesdk.interactivity.chatchannel.widget.b(r4, r0, r1);
        ((yo2.d) r3).f = false;
    }

    public final void c1(List<ChannelLinkUserInfo> r11, List<ChannelLinkUserInfo> r13, List<ChannelLinkUserInfo> r14) {
        this.F = r11;
        this.G = r13;
        this.H = r14;
        ArrayList r15 = new ArrayList();
        r15.add(new ChannelMemberTitleViewBinder.b((String) this.Y.getChannelName().a, ((Number) this.Y.d0().a).longValue(), this.Y.getMaxMemberCount(), this.Y.w(), this.Y.k(), ((Boolean) this.Y.v().a).booleanValue()));
        r15.add(new ChannelMemberListHeaderViewBinder.a());
        if ((!this.F.isEmpty()) == true) goto L7;
        if ((!this.G.isEmpty()) == true) goto L7;
    L9:
        int r16 = -1;
    L11:
        if ((!this.F.isEmpty()) == false) goto L16;
        if (this.E == false) goto L16;
        r15.addAll(this.F);
    L16:
        if ((!this.G.isEmpty()) == false) goto L56;
        if (this.E == false) goto L56;
        List<ChannelLinkUserInfo> r0 = this.G;
        ArrayList r3 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L21:
        if (r1.hasNext() == false) goto L45;
        Object r4 = r1.next();
        ChannelLinkUserInfo r5 = (ChannelLinkUserInfo) r4;
        Iterator r6 = r15.iterator();
    L24:
        if (r6.hasNext() == false) goto L38;
        Object r7 = r6.next();
        if ((r7 instanceof ChannelLinkUserInfo) == true) goto L28;
        Object r8 = null;
    L29:
        ChannelLinkUserInfo r9 = (ChannelLinkUserInfo) r8;
        if (r9 == null) goto L34;
        User r10 = r9.a;
        if (r10 == null) goto L34;
        String r17 = r10.getCastSecUid();
    L36:
        if (Intrinsics.areEqual(r17, r5.a.getCastSecUid()) == false) goto L24;
    L39:
        if (r7 != null) goto L41;
        boolean r18 = true;
    L42:
        if (r18 == false) goto L21;
        r3.add(r4);
        goto L21
    L41:
        r18 = false;
    L34:
        r17 = null;
        goto L36
    L28:
        r8 = r7;
        goto L29
    L38:
        r7 = null;
        goto L39
    L45:
        if ((!r3.isEmpty()) == false) goto L56;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r19 = r3.iterator();
    L48:
        if (r19.hasNext() == false) goto L56;
        ChannelLinkUserInfo r20 = (ChannelLinkUserInfo) r19.next();
        if (r20.b.a != ChannelLinkUserInfo.ChannelUserRole.Manager) goto L53;
        if (r16 < 0) goto L53;
        ListProtector.add(r15, r16, r20);
        Unit r21 = Unit.INSTANCE;
    L54:
        r2.add(r21);
    L53:
        r21 = Boolean.valueOf(r15.add(r20));
    L56:
        if ((!this.H.isEmpty()) == false) goto L85;
        List<ChannelLinkUserInfo> r110 = this.H;
        ArrayList r23 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L59:
        if (r111.hasNext() == false) goto L83;
        Object r24 = r111.next();
        ChannelLinkUserInfo r25 = (ChannelLinkUserInfo) r24;
        Iterator r26 = r15.iterator();
    L62:
        if (r26.hasNext() == false) goto L76;
        Object r27 = r26.next();
        if ((r27 instanceof ChannelLinkUserInfo) == true) goto L66;
        Object r28 = null;
    L67:
        ChannelLinkUserInfo r29 = (ChannelLinkUserInfo) r28;
        if (r29 == null) goto L72;
        User r30 = r29.a;
        if (r30 == null) goto L72;
        String r31 = r30.getCastSecUid();
    L74:
        if (Intrinsics.areEqual(r31, r25.a.getCastSecUid()) == false) goto L62;
    L77:
        if (r27 != null) goto L79;
        boolean r33 = true;
    L80:
        if (r33 == false) goto L59;
        r23.add(r24);
        goto L59
    L79:
        r33 = false;
    L72:
        r31 = null;
        goto L74
    L66:
        r28 = r27;
        goto L67
    L76:
        r27 = null;
        goto L77
    L83:
        if ((!r23.isEmpty()) == false) goto L85;
        r15.add(new ChannelMemberSubTitleViewBinder.a(s1.B(2131922264)));
        r15.addAll(r23);
    L85:
        r15.add(new ChannelMemberListFooterViewBinder.a());
        DiffUtil.DiffResult r112 = DiffUtil.calculateDiff(new ChannelMemberManageUserDiffCallback(CollectionsKt.toList(this.D), r15));
        ((ArrayList) this.D).clear();
        ((ArrayList) this.D).addAll(r15);
        MultiTypeAdapter r113 = this.C;
        if (r113 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L88:
        r112.dispatchUpdatesTo(r113);
        return;
    L7:
        if (this.E == false) goto L9;
        r15.add(new ChannelMemberSubTitleViewBinder.a(s1.B(2131922265)));
        r16 = r15.size();
        goto L11
    }

    public ChannelMemberManagerDialog(Context r2, DataCenter r3, long r4, s22.a r6, s22.e r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "chatChannel");
        Intrinsics.checkNotNullParameter(r7, "chatChannelManager");
        super(r2, false);
        this.W = r3;
        this.X = r4;
        this.Y = r6;
        this.Z = r7;
        this.B = 10;
        this.D = new ArrayList();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new LinkedHashSet();
        this.K = new CompositeDisposable();
        this.L = new CompositeDisposable();
        this.M = new CompositeDisposable();
        this.Q = true;
        this.R = "ChannelMemberManagerDialog";
        this.S = ((w0) d4.a.getValue()).d();
        this.T = new a(this);
        this.U = new e(this, r2);
        this.V = new b(this);
    }
}
