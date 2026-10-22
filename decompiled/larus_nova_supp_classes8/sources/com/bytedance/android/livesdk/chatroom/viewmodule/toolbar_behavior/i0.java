package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.config.nm0;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public boolean a;
    public Disposable b;
    public TextView c;
    public View d;
    public DataCenter e;
    public boolean f;
    public final CompositeDisposable g;

    public static final class a implements ILiveRecommendToFriendsCallback {
        public final /* synthetic */ long a;

        public final void onFailed() {
            com.bytedance.android.live.core.utils.f2.b(2131922925, 0);
        }

        public a(long r1) {
            this.a = r1;
        }

        public final void onLiveRecommendSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            RecommendLiveHelper.l(this.a);
            if (RecommendLiveHelper.e() == false) goto L8;
            boolean r5 = !RecommendLiveHelper.f();
            xs2.b.a().post(new mt1.c(r5, "more_function"));
            if (r5 == false) goto L20;
            RecommendLiveHelper.k();
            return;
        L20:
            return;
        L8:
            if (nm0.a.getValue().booleanValue() == true) goto L10;
            com.bytedance.android.live.core.utils.f2.b(2131922926, 0);
            return;
        L10:
            if (RecommendLiveHelper.f() == true) goto L15;
            String r6 = mm0.a.getValue().getFirstRecommendSuccessToast();
            if (r6 == null) goto L14;
            com.bytedance.android.live.core.utils.f2.c(r6, 0);
        L14:
            RecommendLiveHelper.k();
            return;
        L15:
            String r7 = mm0.a.getValue().getRecommendSuccessToast();
            if (r7 == null) goto L23;
            com.bytedance.android.live.core.utils.f2.c(r7, 0);
            return;
        }

        public final void onSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            RecommendLiveHelper.l(this.a);
            com.bytedance.android.live.core.utils.f2.b(2131922926, 0);
            long r5 = this.a;
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L6;
            r0.postRecommendEvent(r5, true);
            return;
        }
    }

    public static final class b implements ILiveRecommendToFriendsCallback {
        public final /* synthetic */ long a;

        public final void onFailed() {
            com.bytedance.android.live.core.utils.f2.b(2131922925, 0);
        }

        public b(long r1) {
            this.a = r1;
        }

        public final void onLiveRecommendSuccess(long r2) {
            int r3 = RecommendLiveHelper.a;
            long r4 = this.a;
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L5;
            r0.removeRoomRecommended(r4);
        L5:
            com.bytedance.android.live.core.utils.f2.b(2131922924, 0);
        }

        public final void onSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            long r5 = this.a;
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L5;
            r0.removeRoomRecommended(r5);
        L5:
            com.bytedance.android.live.core.utils.f2.b(2131922924, 0);
            long r1 = this.a;
            ILiveRecommendToFriendsService r6 = RecommendLiveHelper.d();
            if (r6 == null) goto L9;
            r6.postRecommendEvent(r1, false);
            return;
        }
    }

    public static final class c implements ILiveRecommendToFriendsCallback {
        public final /* synthetic */ i0 a;

        public final void onFailed() {
        }

        public c(i0 r1) {
            this.a = r1;
        }

        public final void onLiveRecommendSuccess(long r3) {
            i0 r0 = this.a;
            int r1 = RecommendLiveHelper.a;
            r0.a = RecommendLiveHelper.b(r3);
            i0 r4 = this.a;
            r4.a(r4.a);
        }

        public final void onSuccess(long r3) {
            i0 r0 = this.a;
            int r1 = RecommendLiveHelper.a;
            r0.a = RecommendLiveHelper.b(r3);
            i0 r4 = this.a;
            r4.a(r4.a);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public i0() {
        this.g = new CompositeDisposable();
    }

    public final void a(boolean r3) {
        if (r3 == false) goto L4;
        TextView r0 = this.c;
        if (r0 == null) goto L13;
        r0.setText(2131921924);
    L13:
        View r1 = this.d;
        if (r1 == null) goto L17;
        r1.setSelected(r3);
        return;
    L17:
        return;
    L4:
        if (nm0.a.getValue().booleanValue() == false) goto L6;
        int r2 = 2131921933;
    L7:
        TextView r4 = this.c;
        if (r4 == null) goto L13;
        r4.setText(r2);
        goto L13
    L6:
        r2 = 2131921932;
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        DataCenter r12 = this.e;
        if (r12 == null) goto L7;
        Room r13 = com.bytedance.android.live.core.utils.z.o(r12);
        if (r13 == null) goto L7;
        long r0 = r13.getRoomId();
    L8:
        long r2 = r0;
        DataCenter r14 = this.e;
        if (r14 == null) goto L11;
        Room r15 = com.bytedance.android.live.core.utils.z.o(r14);
    L12:
        if (r15 == null) goto L15;
        String r1 = r15.getOwnerUserIdString();
        if (r1 == null) goto L15;
    L16:
        String r4 = r1;
        if (this.a == true) goto L27;
        int r3 = RecommendLiveHelper.a;
        ILiveRecommendToFriendsService r5 = RecommendLiveHelper.d();
        if (r5 == null) goto L21;
        boolean r6 = r5.isFirstRecommend();
    L22:
        if (r6 == false) goto L26;
        xs2.b r16 = xs2.b.a();
        mt1.b r7 = new mt1.b(r2, "more_panel");
        r7.a = true;
        Unit r8 = Unit.INSTANCE;
        r16.post(r7);
        ILiveRecommendToFriendsService r17 = RecommendLiveHelper.d();
        if (r17 == null) goto L28;
        r17.setIsFirstRecommend();
    L28:
        com.bytedance.android.livesdk.log.u.l().h("recommend_video_toast", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method", "live_click_more"), TuplesKt.to("action_type", "click")}), new Object[]{am2.x.class, Room.class});
        return;
    L26:
        RecommendLiveHelper.h(r15, "shared", "more_function", null, 8);
        RecommendLiveHelper.j(r2, r4, new a(r2), "FollowShareBehavior", RecommendLiveHelper.e(), this.e);
        goto L28
    L21:
        r6 = true;
        goto L22
    L27:
        int r9 = RecommendLiveHelper.a;
        RecommendLiveHelper.h(r15, "not_shared", "more_function", null, 8);
        RecommendLiveHelper.a(r2, r4, new b(r2), "FollowShareBehavior");
    L15:
        r1 = "0";
        goto L16
    L11:
        r15 = null;
    L7:
        r0 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (((Boolean) ev1.m.a.getValue()).booleanValue() == true) goto L14;
        Disposable r4 = this.b;
        if (r4 != null) goto L7;
    L12:
        this.b = null;
        return;
    L7:
        if ((!r4.isDisposed()) == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L12;
        r4.dispose();
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        this.f = false;
        this.e = r7;
        this.d = r6.findViewById(2131374718);
        this.c = (TextView) r6.findViewById(2131380593);
        DataCenter r8 = this.e;
        if (r8 == null) goto L7;
        Room r9 = com.bytedance.android.live.core.utils.z.o(r8);
        if (r9 == null) goto L7;
        long r1 = r9.getRoomId();
    L8:
        int r10 = RecommendLiveHelper.a;
        boolean r11 = RecommendLiveHelper.g(r1);
        this.a = r11;
        a(r11);
        if (((Boolean) ev1.m.a.getValue()).booleanValue() == true) goto L18;
        Disposable r12 = this.b;
        if (r12 == null) goto L18;
        if ((!r12.isDisposed()) == true) goto L16;
        r12 = null;
    L16:
        if (r12 == null) goto L18;
        r12.dispose();
    L18:
        Disposable r13 = RecommendLiveHelper.c(com.bytedance.android.live.core.utils.z.o(r7).getRoomId(), new c(this), "FollowerShareBehavior");
        if (r13 == null) goto L21;
        RxUtilKt.c(r13, this.g);
    L22:
        this.b = r13;
        if (this.f == true) goto L35;
        this.f = true;
        DataCenter r14 = this.e;
        if (r14 == null) goto L28;
        Room r15 = com.bytedance.android.live.core.utils.z.o(r14);
    L30:
        if (this.a == false) goto L32;
        String r16 = "shared";
    L33:
        RecommendLiveHelper.i(r15, r16, "more_function", null);
        com.bytedance.android.livesdk.log.u.l().h("recommend_video_toast", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method", "live_click_more"), TuplesKt.to("action_type", "show")}), new Object[]{am2.x.class, Room.class});
        return;
    L32:
        r16 = "not_shared";
        goto L33
    L28:
        r15 = null;
        goto L30
    L35:
        return;
    L21:
        r13 = null;
    L7:
        r1 = 0;
        goto L8
    }
}
