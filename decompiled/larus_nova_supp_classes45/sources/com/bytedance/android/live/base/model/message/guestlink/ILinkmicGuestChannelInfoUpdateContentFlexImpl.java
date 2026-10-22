package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestChannelInfoUpdateContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestChannelInfoUpdateContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/b;", "Lcom/bytedance/android/live/base/model/message/guestlink/a;", "<set-?>", "channelInfo$delegate", "Ljava/lang/Object;", "getChannelInfo", "()Lcom/bytedance/android/live/base/model/message/guestlink/a;", "setChannelInfo", "(Lcom/bytedance/android/live/base/model/message/guestlink/a;)V", "channelInfo", "", "currentTimeMs$delegate", "getCurrentTimeMs", "()J", "setCurrentTimeMs", "(J)V", "currentTimeMs", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestChannelInfoUpdateContentFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("channel_info")
    protected a _$$channelInfo;

    @SerializedName("current_time_ms")
    protected long _$$currentTimeMs;

    public ILinkmicGuestChannelInfoUpdateContentFlexImpl() {
        super(b.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.b
    public final a getChannelInfo() {
        return this._$$channelInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.b
    public final long getCurrentTimeMs() {
        return this._$$currentTimeMs;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.guestlink.a, java.lang.Object] */
    public ILinkmicGuestChannelInfoUpdateContentFlexImpl(am3.g r6) {
        super(b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$channelInfo = vh7.f.a(r6, a.class);
        goto L3
    L8:
        if (r2 != 3) goto L9;
        this._$$currentTimeMs = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.b
    public final void setChannelInfo(a r1) {
        this._$$channelInfo = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.b
    public final void setCurrentTimeMs(long r1) {
        this._$$currentTimeMs = r1;
    }
}
