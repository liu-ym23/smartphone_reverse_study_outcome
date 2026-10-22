package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J3\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "Ljava/io/Serializable;", "text", BuildConfig.FLAVOR, "numberOfLines", BuildConfig.FLAVOR, "fontSize", "fontWeight", "Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;", "<init>", "(Ljava/lang/String;IILcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "getFontSize", "setFontSize", "getFontWeight", "()Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;", "setFontWeight", "(Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "FontWeight", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverSizeTextProperty extends BaseProperty {
    private int fontSize;
    private FontWeight fontWeight;
    private int numberOfLines;
    private String text;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "REGULAR", "SEMI_BOLD", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FontWeight extends Enum<FontWeight> {
        public static final a Companion = null;
        public static final FontWeight REGULAR = null;
        public static final FontWeight SEMI_BOLD = null;
        public static final /* synthetic */ FontWeight[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FontWeight> getEntries() {
            return b;
        }

        static {
            FontWeight r0 = new FontWeight("REGULAR", 0, 0);
            REGULAR = r0;
            FontWeight r1 = new FontWeight("SEMI_BOLD", 1, 1);
            SEMI_BOLD = r1;
            FontWeight[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static FontWeight[] values() {
            return (FontWeight[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FontWeight valueOf(String r1) {
            return (FontWeight) r27.a.a(FontWeight.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public FontWeight(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public OverSizeTextProperty() {
        this(null, 0, 0, null, 15, null);
    }

    public static /* synthetic */ OverSizeTextProperty copy$default(OverSizeTextProperty r0, String r1, int r2, int r3, FontWeight r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.numberOfLines;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.fontSize;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.fontWeight;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.numberOfLines;
    }

    public final int component3() {
        return this.fontSize;
    }

    public final FontWeight component4() {
        return this.fontWeight;
    }

    public final OverSizeTextProperty copy(String r2, int r3, int r4, FontWeight r5) {
        Intrinsics.checkNotNullParameter(r5, "fontWeight");
        return new OverSizeTextProperty(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OverSizeTextProperty) == true) goto L8;
        return false;
    L8:
        OverSizeTextProperty r6 = (OverSizeTextProperty) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (this.numberOfLines == r6.numberOfLines) goto L15;
        return false;
    L15:
        if (this.fontSize == r6.fontSize) goto L18;
        return false;
    L18:
        if (this.fontWeight == r6.fontWeight) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        String r0 = this.text;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((r1 * 31) + this.numberOfLines) * 31) + this.fontSize) * 31) + this.fontWeight.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "OverSizeTextProperty(text=" + this.text + ", numberOfLines=" + this.numberOfLines + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ')';
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L47;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        if (r1 == ComponentAttribute.text.getValue()) goto L9;
        int r3 = 0;
        if (r1 == ComponentAttribute.number_of_lines.getValue()) goto L17;
        if (r1 == ComponentAttribute.font_size.getValue()) goto L25;
        if (r1 != ComponentAttribute.font_weight.getValue()) goto L6;
        FontWeight.a r2 = FontWeight.Companion;
        PreviewData r4 = r0.getValue();
        if (r4 == null) goto L39;
        Integer r7 = r4.getInt();
        if (r7 == null) goto L39;
        r3 = r7.intValue();
    L39:
        r2.getClass();
        if (r3 != 0) goto L42;
        FontWeight r8 = FontWeight.REGULAR;
    L46:
        this.fontWeight = r8;
        goto L6
    L42:
        if (r3 == 1) goto L44;
        r8 = FontWeight.REGULAR;
        goto L46
    L44:
        r8 = FontWeight.SEMI_BOLD;
        goto L46
    L25:
        PreviewData r9 = r0.getValue();
        if (r9 == null) goto L30;
        Integer r10 = r9.getInt();
        if (r10 == null) goto L30;
        int r11 = r10.intValue();
    L31:
        this.fontSize = r11;
    L30:
        r11 = 36;
        goto L31
    L17:
        PreviewData r12 = r0.getValue();
        if (r12 == null) goto L22;
        Integer r13 = r12.getInt();
        if (r13 == null) goto L22;
        r3 = r13.intValue();
    L22:
        this.numberOfLines = r3;
        goto L6
    L9:
        PreviewData r14 = r0.getValue();
        if (r14 == null) goto L13;
        String r15 = r14.getString();
        if (r15 == null) goto L13;
    L14:
        this.text = r15;
    L13:
        r15 = BuildConfig.FLAVOR;
        goto L14
    }

    public final void setFontSize(int r1) {
        this.fontSize = r1;
    }

    public final void setFontWeight(FontWeight r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fontWeight = r2;
    }

    public final void setNumberOfLines(int r1) {
        this.numberOfLines = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public OverSizeTextProperty(String r2, int r3, int r4, FontWeight r5) {
        Intrinsics.checkNotNullParameter(r5, "fontWeight");
        super(Type.OVERSIZED_TEXT);
        this.text = r2;
        this.numberOfLines = r3;
        this.fontSize = r4;
        this.fontWeight = r5;
    }

    public /* synthetic */ OverSizeTextProperty(String r1, int r2, int r3, FontWeight r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = BuildConfig.FLAVOR;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = 36;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = FontWeight.REGULAR;
    L14:
        this(r1, r2, r3, r4);
    }
}
