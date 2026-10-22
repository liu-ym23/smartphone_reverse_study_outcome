package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0018\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010 \u001a\u00060\u0019j\u0002`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR&\u0010(\u001a\u00060\u0019j\u0002`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001e¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IRichText;", "Lvh7/c;", BuildConfig.FLAVOR, "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "type", BuildConfig.FLAVOR, "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "getImg$annotations", "img", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getFontSize", "()J", "setFontSize", "(J)V", "getFontSize$annotations", "fontSize", "getFontColor", "setFontColor", "getFontColor$annotations", "fontColor", "getWeight", "setWeight", "getWeight$annotations", "weight", "RichTextType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRichText extends vh7.c<IRichText> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IRichText$RichTextType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "setValue", "(I)V", "UnKnown", "Text", "Img", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RichTextType extends Enum<RichTextType> {
        public static final RichTextType Img = null;
        public static final RichTextType Text = null;
        public static final RichTextType UnKnown = null;
        public static final /* synthetic */ RichTextType[] a = null;
        private int value;

        static {
            RichTextType r1 = new RichTextType("UnKnown", 0, 0);
            UnKnown = r1;
            RichTextType r2 = new RichTextType("Text", 1, 1);
            Text = r2;
            RichTextType r3 = new RichTextType("Img", 2, 2);
            Img = r3;
            a = new RichTextType[]{r1, r2, r3};
        }

        public static RichTextType valueOf(String r1) {
            return (RichTextType) r27.a.a(RichTextType.class, r1);
        }

        public static RichTextType[] values() {
            return (RichTextType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public RichTextType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "font_size")
    long getFontSize();

    @FieldName(name = "img")
    py.k getImg();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "weight")
    long getWeight();

    @FieldName(name = "font_color#setter")
    void setFontColor(String r1);

    @FieldName(name = "font_size#setter")
    void setFontSize(long r1);

    @FieldName(name = "img#setter")
    void setImg(py.k r1);

    @FieldName(name = "text#setter")
    void setText(String r1);

    @FieldName(name = "type#setter")
    void setType(int r1);

    @FieldName(name = "weight#setter")
    void setWeight(long r1);
}
