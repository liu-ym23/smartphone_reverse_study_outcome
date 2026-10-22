package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.ListEmojisResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TalkRoomEmojiListResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/k;", "", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/j;", "getEmojiList", "", "getSendLimitTime", "", "getSendLimitDesc", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/r;", "emojiList", "Ljava/util/List;", "sendLimitTime", "J", "_sendLimitDesc", "Ljava/lang/String;", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TalkRoomEmojiListResponse extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("time_control_text")
    public String _sendLimitDesc;

    @SerializedName("emoji")
    public List<r> emojiList;

    @SerializedName("millisecond_level_time_control")
    public long sendLimitTime;

    public TalkRoomEmojiListResponse() {
        super(k.class);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.k
    public List<j> getEmojiList() {
        return KotlinTypeUtilsKt.castToMutableElementType(this.emojiList);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.k
    public String getSendLimitDesc() {
        return this._sendLimitDesc;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.k
    public long getSendLimitTime() {
        return this.sendLimitTime;
    }

    public TalkRoomEmojiListResponse(am3.g r6) {
        super(k.class);
        this.emojiList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.emojiList.add(w.a(r6));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.sendLimitTime = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._sendLimitDesc = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }
}
