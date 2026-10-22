package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/BaseAdminLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/BaseGuestLinkWidget;", "Luf0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseAdminLinkWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends BaseGuestLinkWidget<T> implements uf0.a {
    public com.bytedance.android.live.liveinteract.plantform.core.e u;
    public boolean v;
    public final tf0.i w;

    @Override // uf0.a
    public final void Ba(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.s
    public final void G1(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // uf0.a
    public final void If() {
        this.v = false;
    }

    @Override // uf0.a
    public final void eo(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.s
    public final void kp(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // uf0.a
    public final void onPermitSuccess(String r1) {
    }

    @Override // uf0.a
    public final void vf(ILinkMicGuideMessageBridge r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public final boolean Fq() {
        boolean r0 = jc1.k.n(IMiddlewareUserService.class).user().c();
        if (r0 == false) goto L5;
    L8:
        return r0;
    L5:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L7;
        f2.b(2131914522, 0);
        goto L8
    L7:
        f2.b(2131917298, 0);
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        com.bytedance.android.live.liveinteract.plantform.core.e r0 = new com.bytedance.android.live.liveinteract.plantform.core.e(((Widget) this).dataCenter, this.w);
        this.u = r0;
        vlc.d r1 = r0.a;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.LINK_MIC.getKey(), r0);
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.e r2 = this.u;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L8:
        r2.a(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.liveinteract.plantform.core.e r0 = this.u;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L5:
        r0.g(this);
        com.bytedance.android.live.liveinteract.plantform.core.e r1 = this.u;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L8:
        r1.b();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget
    public final tf0.i yq() {
        return this.w;
    }

    public BaseAdminLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        super(r2);
        this.w = r2;
        new CompositeDisposable();
    }

    @Override // uf0.a
    public final void Ff(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        if (((com.bytedance.android.live.liveinteract.multianchor.model.b) r3.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getReplyType() == ReplyType.Reject.ordinal()) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(((com.bytedance.android.live.liveinteract.multianchor.model.b) r3.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getReplyPrompts()) == true) goto L7;
        f2.c(((com.bytedance.android.live.liveinteract.multianchor.model.b) r3.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getReplyPrompts(), 0);
        return;
    L7:
        f2.b(2131919242, 0);
    }

    @Override // uf0.a
    public final void L2(String r1, Throwable r2) {
        if ((r2 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    }

    @Override // uf0.a
    public final void k5(String r2, Throwable r3) {
        this.v = false;
        ExceptionUtils.handleException(getContext(), r3, 2131919333);
    }

    @Override // uf0.a
    public final void l(String r2, Throwable r3) {
        ExceptionUtils.handleException(((Widget) this).context, r3, 2131919334);
    }

    @Override // uf0.a
    public final void e6(String r1, IBaseUser r2, com.bytedance.android.livesdk.chatroom.interact.model.v r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "result");
        f2.b(2131918074, 0);
    }
}
