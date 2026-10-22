package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestLinkReplyContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "", "<set-?>", "replyType$delegate", "Ljava/lang/Object;", "getReplyType", "()I", "setReplyType", "(I)V", "replyType", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "toast", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkReplyContentFlexImpl extends FlexModelBase<ILinkmicGuestLinkReplyContent> implements ILinkmicGuestLinkReplyContent, vh7.h {

    @SerializedName("reply_type")
    protected int _$$replyType;

    @SerializedName("toast")
    protected String _$$toast;

    public ILinkmicGuestLinkReplyContentFlexImpl() {
        super(ILinkmicGuestLinkReplyContent.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent
    public final int getReplyType() {
        return this._$$replyType;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent
    public final String getToast() {
        return this._$$toast;
    }

    public ILinkmicGuestLinkReplyContentFlexImpl(am3.g r6) {
        super(ILinkmicGuestLinkReplyContent.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$replyType = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$toast = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent
    public final void setReplyType(int r1) {
        this._$$replyType = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent
    public final void setToast(String r1) {
        this._$$toast = r1;
    }
}
