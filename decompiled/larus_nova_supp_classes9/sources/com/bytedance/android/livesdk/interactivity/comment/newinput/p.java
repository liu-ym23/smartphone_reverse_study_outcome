package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.b0;
import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g {
    public int o;
    public final /* synthetic */ OGCFixedInputDialog p;

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g, z62.c
    public final void A(com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItem");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void B0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void D0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void G0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void I() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void L() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void O(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final InputSectionType Q() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final int W() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean l0() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean m0() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean n0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void q0(InputPanelSectionContainer.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void r0(TokenCert r2) {
        Intrinsics.checkNotNullParameter(r2, "cert");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void v0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void x0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void y0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void z0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void J() {
        this.p.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void K() {
        OGCFixedInputDialog r0 = this.p;
        r0.q = 1;
        r0.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final DataCenter R() {
        OGCFixedInputDialog r0 = this.p;
        int r1 = OGCFixedInputDialog.D;
        return r0.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final CommentFlowContext S() {
        OGCFixedInputDialog r0 = this.p;
        int r1 = OGCFixedInputDialog.D;
        return r0.h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final c V() {
        OGCFixedInputDialog r0 = this.p;
        int r1 = OGCFixedInputDialog.D;
        return r0.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final MeasureLinearLayout a0() {
        OGCFixedInputDialog r0 = this.p;
        int r1 = OGCFixedInputDialog.D;
        return r0.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public Activity getActivity() {
        return this.p.getActivity();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public Context getContext() {
        return this.p.getContext();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void p0() {
        this.p.Y90();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void t0() {
        this.p.aa0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final IBaseUser b0() {
        DataCenter r0 = R();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (IBaseUser) r0.get("data_user_in_room");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean k0() {
        DataCenter r0 = R();
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_anchor", Boolean.FALSE);
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final Fragment T() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final int X() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void u0(int r1) {
        this.o = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g, z62.d
    public final void b(BaseEmoji r13, String r14, EditText r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (r13 != null) goto L7;
        return;
    L7:
        if ((r13 instanceof com.bytedance.android.livesdk.interactivity.api.quickcomment.a) == false) goto L14;
        this.p.C = false;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.a r16 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.a) r13;
        long r1 = r16.id;
        ISendCommentEvent.Sender r17 = ISendCommentEvent.Sender.CommentWidget;
        if (y22.b.b(new c0(r1, 0, false, r17, new LinkedHashMap(), S(), null)) == false) goto L12;
        ALogger.i("OGCFixedInputDialog", "sendEmojiMessage true by flowContext:".concat(String.valueOf(S())));
        return;
    L12:
        LinkedHashMap r9 = new LinkedHashMap();
        xs2.b.a().post(new b0(r16.id, r17, r9, S()));
        J();
        return;
    }

    public p(OGCFixedInputDialog r14, x.a r15, DanmakuSectionProvider.c r16, x.a r17, DanmakuSectionProvider.c r18) {
        this.p = r14;
        super(null, null, r17, r18, null, null, null, null, null, null, IAssetsManager.DownloadAssetsSource.SOURCE_PREDICT_SEND_GIFT);
    }
}
