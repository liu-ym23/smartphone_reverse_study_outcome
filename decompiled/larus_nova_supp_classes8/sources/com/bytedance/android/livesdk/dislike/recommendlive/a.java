package com.bytedance.android.livesdk.dislike.recommendlive;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsDialogListener;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livehostapi.business.depend.dislike.RecommendToFriendsParams;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.config.nm0;
import com.bytedance.android.livesdk.f;
import com.bytedance.ies.sdk.widgets.DataCenter;
import mt1.c;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ILiveRecommendToFriendsDialogListener {
    public final /* synthetic */ RecommendToFriendsParams a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DataCenter c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dislike.recommendlive.a$a, reason: collision with other inner class name */
    public static final class C0118a implements ILiveRecommendToFriendsCallback {
        public final /* synthetic */ a a;

        public final void onFailed() {
            f2.b(2131922925, 0);
        }

        public C0118a(a r1) {
            this.a = r1;
        }

        public final void onLiveRecommendSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            RecommendLiveHelper.l(this.a.a.getRoomId());
            if (RecommendLiveHelper.e() == false) goto L8;
            boolean r5 = !RecommendLiveHelper.f();
            b.a().post(new c(r5, this.a.b));
            if (r5 == false) goto L20;
            RecommendLiveHelper.k();
            return;
        L20:
            return;
        L8:
            if (nm0.a.getValue().booleanValue() == true) goto L10;
            f2.b(2131922926, 0);
            return;
        L10:
            if (RecommendLiveHelper.f() == true) goto L15;
            String r6 = mm0.a.getValue().getFirstRecommendSuccessToast();
            if (r6 == null) goto L14;
            f2.c(r6, 0);
        L14:
            RecommendLiveHelper.k();
            return;
        L15:
            String r7 = mm0.a.getValue().getRecommendSuccessToast();
            if (r7 == null) goto L23;
            f2.c(r7, 0);
            return;
        }

        public final void onSuccess(long r3) {
            int r4 = RecommendLiveHelper.a;
            RecommendLiveHelper.l(this.a.a.getRoomId());
            f2.b(2131922926, 0);
            long r5 = this.a.a.getRoomId();
            ILiveRecommendToFriendsService r0 = RecommendLiveHelper.d();
            if (r0 == null) goto L6;
            r0.postRecommendEvent(r5, true);
            return;
        }
    }

    public final void onConfirm() {
        int r0 = RecommendLiveHelper.a;
        RecommendLiveHelper.j(this.a.getRoomId(), this.a.getAnchorId(), new C0118a(this), "LivePromptDialog", RecommendLiveHelper.e(), this.c);
    }

    public final void onDismiss() {
        f.d().f();
    }

    public final void onShow() {
        f.d().a();
    }

    public a(RecommendToFriendsParams r1, String r2, DataCenter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
