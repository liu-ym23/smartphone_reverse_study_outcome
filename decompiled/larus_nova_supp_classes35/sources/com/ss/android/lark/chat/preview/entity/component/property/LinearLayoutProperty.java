package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.Justify;
import com.ss.android.lark.export.entity.Orientation;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.Align;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0000H\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006="}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/LinearLayoutProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "orientation", "Lcom/ss/android/lark/export/entity/Orientation;", "spacing", BuildConfig.FLAVOR, "wrapWidth", "padding", "mainAxisJustify", "Lcom/ss/android/lark/export/entity/Justify;", "crossAxisAlign", "Lcom/ss/android/lark/tangram/base/style/Align;", "sidePadding", "Lcom/ss/android/lark/export/entity/preview/Padding;", "<init>", "(Lcom/ss/android/lark/export/entity/Orientation;FFFLcom/ss/android/lark/export/entity/Justify;Lcom/ss/android/lark/tangram/base/style/Align;Lcom/ss/android/lark/export/entity/preview/Padding;)V", "getOrientation", "()Lcom/ss/android/lark/export/entity/Orientation;", "setOrientation", "(Lcom/ss/android/lark/export/entity/Orientation;)V", "getSpacing", "()F", "setSpacing", "(F)V", "getWrapWidth", "setWrapWidth", "getPadding", "setPadding", "getMainAxisJustify", "()Lcom/ss/android/lark/export/entity/Justify;", "setMainAxisJustify", "(Lcom/ss/android/lark/export/entity/Justify;)V", "getCrossAxisAlign", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setCrossAxisAlign", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "getSidePadding", "()Lcom/ss/android/lark/export/entity/preview/Padding;", "setSidePadding", "(Lcom/ss/android/lark/export/entity/preview/Padding;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinearLayoutProperty extends BaseProperty {
    private Align crossAxisAlign;
    private Justify mainAxisJustify;
    private Orientation orientation;
    private float padding;
    private Padding sidePadding;
    private float spacing;
    private float wrapWidth;

    public LinearLayoutProperty() {
        this(null, 0.0f, 0.0f, 0.0f, null, null, null, 127, null);
    }

    public static /* synthetic */ LinearLayoutProperty copy$default(LinearLayoutProperty r5, Orientation r6, float r7, float r8, float r9, Justify r10, Align r11, Padding r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.orientation;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.spacing;
    L8:
        float r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.wrapWidth;
    L11:
        float r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.padding;
    L14:
        float r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.mainAxisJustify;
    L17:
        Justify r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.crossAxisAlign;
    L20:
        Align r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.sidePadding;
    L23:
        Orientation r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Orientation component1() {
        return this.orientation;
    }

    public final float component2() {
        return this.spacing;
    }

    public final float component3() {
        return this.wrapWidth;
    }

    public final float component4() {
        return this.padding;
    }

    public final Justify component5() {
        return this.mainAxisJustify;
    }

    public final Align component6() {
        return this.crossAxisAlign;
    }

    public final Padding component7() {
        return this.sidePadding;
    }

    public final LinearLayoutProperty copy(Orientation r10, float r11, float r12, float r13, Justify r14, Align r15, Padding r16) {
        Intrinsics.checkNotNullParameter(r10, "orientation");
        Intrinsics.checkNotNullParameter(r14, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r15, "crossAxisAlign");
        return new LinearLayoutProperty(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LinearLayoutProperty) == true) goto L8;
        return false;
    L8:
        LinearLayoutProperty r6 = (LinearLayoutProperty) r5;
        if (this.orientation == r6.orientation) goto L12;
        return false;
    L12:
        if (Float.compare(this.spacing, r6.spacing) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.wrapWidth, r6.wrapWidth) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.padding, r6.padding) == 0) goto L21;
        return false;
    L21:
        if (this.mainAxisJustify == r6.mainAxisJustify) goto L24;
        return false;
    L24:
        if (this.crossAxisAlign == r6.crossAxisAlign) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sidePadding, r6.sidePadding) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = ((((((((((this.orientation.hashCode() * 31) + Float.floatToIntBits(this.spacing)) * 31) + Float.floatToIntBits(this.wrapWidth)) * 31) + Float.floatToIntBits(this.padding)) * 31) + this.mainAxisJustify.hashCode()) * 31) + this.crossAxisAlign.hashCode()) * 31;
        Padding r1 = this.sidePadding;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LinearLayoutProperty(orientation=" + this.orientation + ", spacing=" + this.spacing + ", wrapWidth=" + this.wrapWidth + ", padding=" + this.padding + ", mainAxisJustify=" + this.mainAxisJustify + ", crossAxisAlign=" + this.crossAxisAlign + ", sidePadding=" + this.sidePadding + ')';
    }

    public LinearLayoutProperty clone() {
        LinearLayoutProperty r8 = new LinearLayoutProperty(this.orientation, this.spacing, this.wrapWidth, this.padding, this.mainAxisJustify, this.crossAxisAlign, this.sidePadding);
        r8.setMarginLeft(getMarginLeft());
        r8.setMarginRight(getMarginRight());
        r8.setMarginTop(getMarginTop());
        r8.setMarginBottom(getMarginBottom());
        return r8;
    }

    public final Align getCrossAxisAlign() {
        return this.crossAxisAlign;
    }

    public final Justify getMainAxisJustify() {
        return this.mainAxisJustify;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final Padding getSidePadding() {
        return this.sidePadding;
    }

    public final float getSpacing() {
        return this.spacing;
    }

    public final float getWrapWidth() {
        return this.wrapWidth;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m664clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r7 = r6.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L62;
        Map.Entry<Integer, PreviewData> r0 = r7.next();
        int r1 = r0.getKey().intValue();
        int r3 = 0;
        if (r1 == ComponentAttribute.orientation.getValue()) goto L9;
        float r4 = 0.0f;
        if (r1 == ComponentAttribute.spacing.getValue()) goto L17;
        if (r1 == ComponentAttribute.wrap_width.getValue()) goto L25;
        if (r1 == ComponentAttribute.padding.getValue()) goto L33;
        if (r1 == ComponentAttribute.main_axis_justify.getValue()) goto L41;
        if (r1 == ComponentAttribute.cross_axis_align.getValue()) goto L49;
        if (r1 != ComponentAttribute.side_padding.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L60;
        Padding r5 = r2.getPadding();
    L61:
        this.sidePadding = r5;
        goto L6
    L60:
        r5 = null;
        goto L61
    L49:
        Align.a r8 = Align.Companion;
        PreviewData r9 = r0.getValue();
        if (r9 == null) goto L54;
        Integer r10 = r9.getInt();
        if (r10 == null) goto L54;
        r3 = r10.intValue();
    L54:
        r8.getClass();
        this.crossAxisAlign = Align.a.a(r3);
        goto L6
    L41:
        Justify.a r11 = Justify.Companion;
        PreviewData r12 = r0.getValue();
        if (r12 == null) goto L46;
        Integer r13 = r12.getInt();
        if (r13 == null) goto L46;
        r3 = r13.intValue();
    L46:
        r11.getClass();
        this.mainAxisJustify = Justify.a.a(r3);
        goto L6
    L33:
        PreviewData r14 = r0.getValue();
        if (r14 == null) goto L38;
        Float r15 = r14.getFloat();
        if (r15 == null) goto L38;
        r4 = r15.floatValue();
    L38:
        this.padding = r4;
        goto L6
    L25:
        PreviewData r16 = r0.getValue();
        if (r16 == null) goto L30;
        Float r17 = r16.getFloat();
        if (r17 == null) goto L30;
        r4 = r17.floatValue();
    L30:
        this.wrapWidth = r4;
        goto L6
    L17:
        PreviewData r18 = r0.getValue();
        if (r18 == null) goto L22;
        Float r19 = r18.getFloat();
        if (r19 == null) goto L22;
        r4 = r19.floatValue();
    L22:
        this.spacing = r4;
        goto L6
    L9:
        Orientation.a r20 = Orientation.Companion;
        PreviewData r21 = r0.getValue();
        if (r21 == null) goto L14;
        Integer r22 = r21.getInt();
        if (r22 == null) goto L14;
        r3 = r22.intValue();
    L14:
        r20.getClass();
        this.orientation = Orientation.a.a(r3);
        goto L6
    }

    public final void setCrossAxisAlign(Align r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.crossAxisAlign = r2;
    }

    public final void setMainAxisJustify(Justify r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mainAxisJustify = r2;
    }

    public final void setOrientation(Orientation r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.orientation = r2;
    }

    public final void setPadding(float r1) {
        this.padding = r1;
    }

    public final void setSidePadding(Padding r1) {
        this.sidePadding = r1;
    }

    public final void setSpacing(float r1) {
        this.spacing = r1;
    }

    public final void setWrapWidth(float r1) {
        this.wrapWidth = r1;
    }

    public LinearLayoutProperty(Orientation r2, float r3, float r4, float r5, Justify r6, Align r7, Padding r8) {
        Intrinsics.checkNotNullParameter(r2, "orientation");
        Intrinsics.checkNotNullParameter(r6, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r7, "crossAxisAlign");
        super(Type.LINEAR_LAYOUT);
        this.orientation = r2;
        this.spacing = r3;
        this.wrapWidth = r4;
        this.padding = r5;
        this.mainAxisJustify = r6;
        this.crossAxisAlign = r7;
        this.sidePadding = r8;
    }

    public /* synthetic */ LinearLayoutProperty(Orientation r6, float r7, float r8, float r9, Justify r10, Align r11, Padding r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r6 = Orientation.ROW;
    L5:
        float r0 = 0.0f;
        if ((r13 & 2) == 0) goto L8;
        float r15 = 0.0f;
    L10:
        if ((r13 & 4) == 0) goto L12;
        float r1 = 0.0f;
    L14:
        if ((r13 & 8) != 0) goto L18;
        r0 = r9;
    L18:
        if ((r13 & 16) == 0) goto L20;
        r10 = Justify.START;
    L20:
        Justify r2 = r10;
        if ((r13 & 32) == 0) goto L23;
        r11 = Align.TOP;
    L23:
        Align r3 = r11;
        if ((r13 & 64) == 0) goto L26;
        r12 = null;
    L26:
        Orientation r16 = r6;
        float r17 = r15;
        float r18 = r1;
        float r19 = r0;
        this(r16, r17, r18, r19, r2, r3, r12);
        return;
    L12:
        r1 = r8;
        goto L14
    L8:
        r15 = r7;
        goto L10
    }
}
