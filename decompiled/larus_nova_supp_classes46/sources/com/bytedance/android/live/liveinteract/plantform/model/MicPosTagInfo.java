package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b2\u00103J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u0006R\"\u0010\f\u001a\u00020\u000b8V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018¨\u00066"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "Ljava/io/Serializable;", "", PbRequest.SwitchType.OTHER, "", "equals", "", "hashCode", "isAnchorLabel", "", "tagType", "J", "getTagType", "()J", "setTagType", "(J)V", "", "positionTagName", "Ljava/lang/String;", "getPositionTagName", "()Ljava/lang/String;", "setPositionTagName", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "bgColor", "getBgColor", "setBgColor", "tagTypeId", "getTagTypeId", "setTagTypeId", "Lpy/k;", "bgColorImg", "Lpy/k;", "getBgColorImg", "()Lpy/k;", "setBgColorImg", "(Lpy/k;)V", "openTagDescPage", "Z", "getOpenTagDescPage", "()Z", "setOpenTagDescPage", "(Z)V", "schema", "getSchema", "setSchema", "<init>", "()V", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MicPosTagInfo extends FlexModelBase<g0> implements g0, vh7.h {
    public static final a Companion = null;
    private static final int HASH_CODE_37 = 37;
    public static final long TAG_TYPE_ANCHOR = 3;
    public static final long TAG_TYPE_HOST = 1;
    public static final long TAG_TYPE_RESIDENT_SINGER = 2;
    public static final long TYPE_ADVENTURE_AVTING = 11;
    public static final long TYPE_ADVENTURE_INVITING = 10;
    public static final long TYPE_ADVENTURE_TOAVT = 9;
    public static final long TYPE_HIGH_SCORE_SINGER = 4;
    public static final long TYPE_KSONG_GENERAL = 5;
    private static final long serialVersionUID = 0;

    @SerializedName("bg_color_value")
    protected String bgColor;

    @SerializedName("bg_color_img")
    protected py.k bgColorImg;

    @SerializedName("open_tag_desc_page")
    protected boolean openTagDescPage;

    @SerializedName("tag_name")
    protected String positionTagName;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("tag_type")
    @IgnoreProtoDecode
    private long tagType;

    @SerializedName("tag_type_id")
    protected long tagTypeId;

    @SerializedName("text_color_value")
    protected String textColor;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MicPosTagInfo() {
        super(g0.class);
        this.positionTagName = "";
        this.textColor = "";
        this.bgColor = "";
        this.schema = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public long getTagType() {
        return getTagTypeId();
    }

    public int hashCode() {
        long r0 = getTagType();
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 37;
        String r2 = getPositionTagName();
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 37;
        String r6 = getTextColor();
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 37;
        String r9 = getBgColor();
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final boolean isAnchorLabel() {
        if (getTagType() != 3) goto L5;
    L8:
        return true;
    L5:
        if (getTagTypeId() == 3) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public String getBgColor() {
        return this.bgColor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public py.k getBgColorImg() {
        return this.bgColorImg;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public boolean getOpenTagDescPage() {
        return this.openTagDescPage;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public String getPositionTagName() {
        return this.positionTagName;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public long getTagTypeId() {
        return this.tagTypeId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public String getTextColor() {
        return this.textColor;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public MicPosTagInfo(am3.g r5) {
        super(g0.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.schema = am3.h.c(r5);
        goto L3
    L9:
        this.openTagDescPage = am3.h.a(r5);
        goto L3
    L10:
        this.bgColorImg = vh7.f.a(r5, py.k.class);
        goto L3
    L11:
        this.tagTypeId = r5.j();
        goto L3
    L12:
        this.bgColor = am3.h.c(r5);
        goto L3
    L13:
        this.textColor = am3.h.c(r5);
        goto L3
    L14:
        this.positionTagName = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
        if (this.positionTagName != null) goto L19;
        this.positionTagName = "";
    L19:
        if (this.textColor != null) goto L22;
        this.textColor = "";
    L22:
        if (this.bgColor != null) goto L25;
        this.bgColor = "";
    L25:
        if (this.schema != null) goto L46;
        this.schema = "";
        return;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if ((!Intrinsics.areEqual(MicPosTagInfo.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r8 == null) goto L27;
        MicPosTagInfo r9 = (MicPosTagInfo) r8;
        if (getTagType() == r9.getTagType()) goto L16;
    L24:
        return false;
    L16:
        if (getTagTypeId() != r9.getTagTypeId()) goto L24;
        if (TextUtils.equals(getPositionTagName(), r9.getPositionTagName()) == false) goto L24;
        if (TextUtils.equals(getTextColor(), r9.getTextColor()) == false) goto L24;
        if (TextUtils.equals(getBgColor(), r9.getBgColor()) == false) goto L24;
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo");
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setBgColor(String r1) {
        this.bgColor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setBgColorImg(py.k r1) {
        this.bgColorImg = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setOpenTagDescPage(boolean r1) {
        this.openTagDescPage = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setPositionTagName(String r1) {
        this.positionTagName = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setSchema(String r1) {
        this.schema = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setTagType(long r1) {
        this.tagType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setTagTypeId(long r1) {
        this.tagTypeId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g0
    public void setTextColor(String r1) {
        this.textColor = r1;
    }
}
