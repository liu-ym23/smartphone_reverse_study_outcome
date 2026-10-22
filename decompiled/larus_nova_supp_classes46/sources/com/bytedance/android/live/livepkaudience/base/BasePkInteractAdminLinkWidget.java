package com.bytedance.android.live.livepkaudience.base;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractAdminLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractGuestWidget;", "Lcom/bytedance/android/live/livepkaudience/base/g;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePkInteractAdminLinkWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends BasePkInteractGuestWidget<T> implements g {
    public o n;
    public boolean o;

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Hl(if r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void nm(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    private static boolean Eq() {
        boolean r0 = jc1.k.n(IUserService.class).user().c();
        if (r0 == false) goto L5;
    L8:
        return r0;
    L5:
        if (jc1.k.n(IUserService.class).user().isAdmin() == false) goto L7;
        f2.b(2131914522, 0);
        goto L8
    L7:
        f2.b(2131917298, 0);
        goto L8
    }

    public BasePkInteractAdminLinkWidget() {
        new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public void onCreate() {
        super.onCreate();
        o r0 = new o(((Widget) this).dataCenter);
        this.n = r0;
        vlc.d r1 = r0.a;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.LINK_MIC.getIntType(), r0);
    L5:
        o r2 = this.n;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L8:
        r2.a(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public void onDestroy() {
        super.onDestroy();
        o r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L5:
        r0.f(this);
        o r1 = this.n;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L8:
        r1.b();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void Em(xe r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        if (r3.getReplyType() == ReplyType.Reject.ordinal()) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3.getReplyPrompts()) == true) goto L7;
        f2.c(r3.getReplyPrompts(), 0);
        return;
    L7:
        f2.b(2131919242, 0);
    }

    public final void Gq(User r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        if (Eq() == false) goto L9;
        o r0 = this.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L7:
        r0.e(r3.getIdStr(), r3.getCastSecUid());
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void L2(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void V6(String r2, LinkInviteResult r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "result");
        f2.b(2131918074, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void c7(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
        this.o = false;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void k5(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.o = false;
        ExceptionUtils.handleException(getContext(), r3, 2131919333);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void l(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        ExceptionUtils.handleException(((Widget) this).context, r3, 2131919334);
    }

    public final void Fq(long r10, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "uid");
        if (Eq() == false) goto L9;
        o r0 = this.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L7:
        o.c(r0, r10, r12, r13, 1, 0, 96);
        return;
    }

    public void kickOut(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r5, "reqFrom");
        if (Eq() == true) goto L6;
        return;
    L6:
        if (this.o == false) goto L8;
        return;
    L8:
        this.o = true;
        o r0 = this.n;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L11:
        r0.d(r3, r4, r5);
    }
}
