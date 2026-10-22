package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.EmojiCustomizedRandomResource")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR+\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/EmojiCustomizedRandomResourceFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/a;", "", "<set-?>", "type$delegate", "Ljava/lang/Object;", "getType", "()I", "setType", "(I)V", "type", "status$delegate", "getStatus", "setStatus", "status", "", "randomNum$delegate", "getRandomNum", "()J", "setRandomNum", "(J)V", "randomNum", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EmojiCustomizedRandomResourceFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("random_num")
    protected long _$$randomNum;

    @SerializedName("status")
    protected int _$$status;

    @SerializedName("type")
    protected int _$$type;

    public EmojiCustomizedRandomResourceFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public boolean isRandomEmoji() {
        if (getType() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public final long getRandomNum() {
        return this._$$randomNum;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public final int getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public final int getType() {
        return this._$$type;
    }

    public EmojiCustomizedRandomResourceFlexImpl(am3.g r6) {
        super(a.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$type = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$randomNum = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$status = r6.i();
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public final void setRandomNum(long r1) {
        this._$$randomNum = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public final void setStatus(int r1) {
        this._$$status = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.a
    public final void setType(int r1) {
        this._$$type = r1;
    }
}
