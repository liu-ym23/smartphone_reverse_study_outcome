package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.config.nm0;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RecommendToFriendsAction extends OptionAction {
    public boolean e;
    public final long f;
    public final ActionsManager g;

    public static final class a implements ILiveRecommendToFriendsCallback {
        public final /* synthetic */ RecommendToFriendsAction a;

        public final void onFailed() {
            f2.b(2131922925, 0);
        }

        public a(RecommendToFriendsAction r1) {
            this.a = r1;
        }

        public final void onLiveRecommendSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            RecommendLiveHelper.l(this.a.f);
            if (RecommendLiveHelper.e() == false) goto L13;
            boolean r5 = !RecommendLiveHelper.f();
            xs2.b r6 = xs2.b.a();
            com.bytedance.android.livesdk.dislike.m r1 = this.a.g.c;
            if (r1 == null) goto L8;
            String r2 = r1.a();
            if (r2 == null) goto L8;
        L9:
            r6.post(new mt1.c(r5, r2));
            if (r5 == false) goto L25;
            RecommendLiveHelper.k();
            return;
        L25:
            return;
        L8:
            r2 = "long_press";
            goto L9
        L13:
            if (nm0.a.getValue().booleanValue() == true) goto L15;
            f2.b(2131922926, 0);
            return;
        L15:
            if (RecommendLiveHelper.f() == true) goto L20;
            String r7 = mm0.a.getValue().getFirstRecommendSuccessToast();
            if (r7 == null) goto L19;
            f2.c(r7, 0);
        L19:
            RecommendLiveHelper.k();
            return;
        L20:
            String r8 = mm0.a.getValue().getRecommendSuccessToast();
            if (r8 == null) goto L28;
            f2.c(r8, 0);
            return;
        }

        public final void onSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            RecommendLiveHelper.l(this.a.f);
            f2.b(2131922926, 0);
            long r5 = this.a.f;
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L6;
            r0.postRecommendEvent(r5, true);
            return;
        }
    }

    public static final class b implements ILiveRecommendToFriendsCallback {
        public final /* synthetic */ RecommendToFriendsAction a;

        public final void onFailed() {
            f2.b(2131922925, 0);
        }

        public b(RecommendToFriendsAction r1) {
            this.a = r1;
        }

        public final void onLiveRecommendSuccess(long r2) {
            int r3 = RecommendLiveHelper.a;
            long r4 = this.a.f;
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L5;
            r0.removeRoomRecommended(r4);
        L5:
            f2.b(2131922924, 0);
        }

        public final void onSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            long r5 = this.a.f;
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L5;
            r0.removeRoomRecommended(r5);
        L5:
            f2.b(2131922924, 0);
            long r1 = this.a.f;
            ILiveRecommendToFriendsService r6 = RecommendLiveHelper.d();
            if (r6 == null) goto L9;
            r6.postRecommendEvent(r1, false);
            return;
        }
    }

    public RecommendToFriendsAction(ActionsManager r3) {
        Intrinsics.checkNotNullParameter(r3, "actionsManager");
        super(r3);
        this.g = r3;
        Room r4 = this.b;
        if (r4 == null) goto L5;
        long r0 = r4.getRoomId();
    L6:
        this.f = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r13) {
        Intrinsics.checkNotNullParameter(r13, "v");
        if (com.bytedance.android.livesdk.config.setting.l.c() == false) goto L5;
        int r14 = RecommendLiveHelper.a;
        this.e = RecommendLiveHelper.g(this.f);
    L5:
        String r2 = "0";
        if (this.e == true) goto L32;
        int r15 = RecommendLiveHelper.a;
        ILiveRecommendToFriendsService r16 = RecommendLiveHelper.d();
        if (r16 == null) goto L10;
        boolean r17 = r16.isFirstRecommend();
    L11:
        if (r17 == false) goto L20;
        xs2.b r18 = xs2.b.a();
        long r1 = this.f;
        com.bytedance.android.livesdk.dislike.m r3 = this.g.c;
        if (r3 == null) goto L16;
        String r4 = r3.a();
        if (r4 == null) goto L16;
    L17:
        r18.post(new mt1.b(r1, r4));
        ILiveRecommendToFriendsService r19 = RecommendLiveHelper.d();
        if (r19 == null) goto L48;
        r19.setIsFirstRecommend();
        return;
    L48:
        return;
    L16:
        r4 = "long_press";
        goto L17
    L20:
        Room r110 = this.b;
        com.bytedance.android.livesdk.dislike.m r5 = this.g.c;
        if (r5 == null) goto L23;
        String r6 = r5.a();
    L24:
        RecommendLiveHelper.h(r110, "shared", null, r6, 4);
        long r7 = this.f;
        Room r111 = this.b;
        if (r111 == null) goto L30;
        String r112 = r111.getOwnerUserIdString();
        if (r112 == null) goto L30;
        String r8 = r112;
    L31:
        RecommendLiveHelper.j(r7, r8, new a(this), "RecommendToFriendsAction", RecommendLiveHelper.e(), this.g.f);
        return;
    L30:
        r8 = "0";
        goto L31
    L23:
        r6 = null;
        goto L24
    L10:
        r17 = true;
        goto L11
    L32:
        int r113 = RecommendLiveHelper.a;
        Room r114 = this.b;
        com.bytedance.android.livesdk.dislike.m r9 = this.g.c;
        if (r9 == null) goto L35;
        String r10 = r9.a();
    L36:
        RecommendLiveHelper.h(r114, "not_shared", null, r10, 4);
        Room r115 = this.g.d;
        if (r115 == null) goto L39;
        long r0 = r115.getRoomId();
    L40:
        Room r116 = this.b;
        if (r116 == null) goto L46;
        String r117 = r116.getOwnerUserIdString();
        if (r117 == null) goto L46;
        r2 = r117;
    L46:
        RecommendLiveHelper.a(r0, r2, new b(this), "RecommendToFriendsAction");
        return;
    L39:
        r0 = 0;
        goto L40
    L35:
        r10 = null;
        goto L36
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void d(Function1<? super Map<String, ? extends Object>, Unit> r4) {
        int r0 = RecommendLiveHelper.a;
        Disposable r5 = RecommendLiveHelper.c(this.f, new RecommendToFriendsAction$onShow$1(this, r4), "RecommendToFriendsAction");
        if (r5 == null) goto L5;
        RxUtilKt.c(r5, (CompositeDisposable) this.c.getValue());
    L5:
        Room r6 = this.b;
        if (RecommendLiveHelper.g(this.f) == false) goto L8;
        String r1 = "shared";
    L9:
        RecommendLiveHelper.i(r6, r1, "long_press", null);
        return;
    L8:
        r1 = "not_shared";
        goto L9
    }
}
