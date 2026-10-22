package com.bytedance.android.live.profit.vip;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\"\u0010\u001f\u001a\u00020\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/vip/Emoji;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vip/model/a;", "", "id", "J", "getId", "()J", "setId", "(J)V", "Lpy/k;", "img", "Lpy/k;", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "emojiScaleType", "getEmojiScaleType", "setEmojiScaleType", "Lcom/bytedance/android/live/profit/vip/model/c;", "label", "Lcom/bytedance/android/live/profit/vip/model/c;", "getLabel", "()Lcom/bytedance/android/live/profit/vip/model/c;", "setLabel", "(Lcom/bytedance/android/live/profit/vip/model/c;)V", "type", "getType", "setType", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "canDelTime", "getCanDelTime", "setCanDelTime", "", "rejectReason", "Ljava/lang/String;", "getRejectReason", "()Ljava/lang/String;", "setRejectReason", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class Emoji extends FlexModelBase<com.bytedance.android.live.profit.vip.model.a> implements com.bytedance.android.live.profit.vip.model.a, vh7.h {
    public static final a Companion = null;
    public static final int STATUS_OFFLINE = 4;
    public static final int STATUS_PASS = 3;
    public static final int STATUS_REJECT = 2;
    public static final int STATUS_REVIEW = 1;
    public static final int STATUS_UNKNOWN = 0;

    @SerializedName("can_del_time")
    protected long canDelTime;

    @SerializedName("emoji_scale")
    protected long emojiScaleType;

    @SerializedName("id")
    protected long id;

    @SerializedName("img")
    protected py.k img;

    @SerializedName("label")
    protected com.bytedance.android.live.profit.vip.model.c label;

    @SerializedName("reject_reason")
    protected String rejectReason;

    @SerializedName("status")
    protected int status;

    @SerializedName("type")
    protected long type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Emoji() {
        super(com.bytedance.android.live.profit.vip.model.a.class);
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public long getCanDelTime() {
        return this.canDelTime;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public long getEmojiScaleType() {
        return this.emojiScaleType;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public long getId() {
        return this.id;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public py.k getImg() {
        return this.img;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public com.bytedance.android.live.profit.vip.model.c getLabel() {
        return this.label;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public String getRejectReason() {
        return this.rejectReason;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public int getStatus() {
        return this.status;
    }

    @Override // com.bytedance.android.live.profit.vip.model.a
    public long getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.profit.vip.model.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public Emoji(am3.g r5) {
        super(com.bytedance.android.live.profit.vip.model.a.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this.label = vh7.f.a(r5, com.bytedance.android.live.profit.vip.model.c.class);
        goto L3
    L9:
        this.emojiScaleType = r5.j();
        goto L3
    L10:
        this.rejectReason = am3.h.c(r5);
        goto L3
    L11:
        this.canDelTime = r5.j();
        goto L3
    L12:
        this.status = r5.i();
        goto L3
    L13:
        this.type = r5.j();
        goto L3
    L14:
        this.img = vh7.f.a(r5, py.k.class);
        goto L3
    L15:
        this.id = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
    }

    public void setCanDelTime(long r1) {
        this.canDelTime = r1;
    }

    public void setEmojiScaleType(long r1) {
        this.emojiScaleType = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setImg(py.k r1) {
        this.img = r1;
    }

    public void setLabel(com.bytedance.android.live.profit.vip.model.c r1) {
        this.label = r1;
    }

    public void setRejectReason(String r1) {
        this.rejectReason = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setType(long r1) {
        this.type = r1;
    }
}
