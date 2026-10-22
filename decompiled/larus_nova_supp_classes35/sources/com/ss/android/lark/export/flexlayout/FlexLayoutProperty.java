package com.ss.android.lark.export.flexlayout;

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
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001FBY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0000H\u0016J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003J[\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010?\u001a\u00020\u00102\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020EHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006G"}, d2 = {"Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "orientation", "Lcom/ss/android/lark/export/entity/Orientation;", "flexWrap", "Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;", "mainAxisSpacing", BuildConfig.FLAVOR, "crossAxisSpacing", "padding", "Lcom/ss/android/lark/export/entity/preview/Padding;", "mainAxisJustify", "Lcom/ss/android/lark/export/entity/Justify;", "crossAxisAlign", "Lcom/ss/android/lark/tangram/base/style/Align;", "forceUseCompactMode", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/export/entity/Orientation;Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;FFLcom/ss/android/lark/export/entity/preview/Padding;Lcom/ss/android/lark/export/entity/Justify;Lcom/ss/android/lark/tangram/base/style/Align;Z)V", "getOrientation", "()Lcom/ss/android/lark/export/entity/Orientation;", "setOrientation", "(Lcom/ss/android/lark/export/entity/Orientation;)V", "getFlexWrap", "()Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;", "setFlexWrap", "(Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;)V", "getMainAxisSpacing", "()F", "setMainAxisSpacing", "(F)V", "getCrossAxisSpacing", "setCrossAxisSpacing", "getPadding", "()Lcom/ss/android/lark/export/entity/preview/Padding;", "setPadding", "(Lcom/ss/android/lark/export/entity/preview/Padding;)V", "getMainAxisJustify", "()Lcom/ss/android/lark/export/entity/Justify;", "setMainAxisJustify", "(Lcom/ss/android/lark/export/entity/Justify;)V", "getCrossAxisAlign", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setCrossAxisAlign", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "getForceUseCompactMode", "()Z", "setForceUseCompactMode", "(Z)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "FlexWrap", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlexLayoutProperty extends BaseProperty {
    private Align crossAxisAlign;
    private float crossAxisSpacing;
    private FlexWrap flexWrap;
    private boolean forceUseCompactMode;
    private Justify mainAxisJustify;
    private float mainAxisSpacing;
    private Orientation orientation;
    private Padding padding;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_WRAP", "WRAP", "WRAP_REVERSE", "LINEAR_WRAP", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FlexWrap extends Enum<FlexWrap> {
        public static final a Companion = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;
        public static final /* synthetic */ FlexWrap[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static FlexWrap a(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L18;
                if (r1 == 2) goto L17;
                if (r1 == 3) goto L16;
                return FlexWrap.NO_WRAP;
            L16:
                return FlexWrap.LINEAR_WRAP;
            L17:
                return FlexWrap.WRAP_REVERSE;
            L18:
                return FlexWrap.WRAP;
            L14:
                return FlexWrap.NO_WRAP;
            }
        }

        public static EnumEntries<FlexWrap> getEntries() {
            return b;
        }

        static {
            FlexWrap r0 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r0;
            FlexWrap r1 = new FlexWrap("WRAP", 1, 1);
            WRAP = r1;
            FlexWrap r3 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r3;
            FlexWrap r5 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r5;
            FlexWrap[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FlexWrap valueOf(String r1) {
            return (FlexWrap) r27.a.a(FlexWrap.class, r1);
        }

        public FlexWrap(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public FlexLayoutProperty() {
        this(null, null, 0.0f, 0.0f, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    public static /* synthetic */ FlexLayoutProperty copy$default(FlexLayoutProperty r9, Orientation r10, FlexWrap r11, float r12, float r13, Padding r14, Justify r15, Align r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Orientation r2 = r9.orientation;
    L7:
        if ((r18 & 2) == 0) goto L9;
        FlexWrap r3 = r9.flexWrap;
    L11:
        if ((r18 & 4) == 0) goto L13;
        float r4 = r9.mainAxisSpacing;
    L15:
        if ((r18 & 8) == 0) goto L17;
        float r5 = r9.crossAxisSpacing;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Padding r6 = r9.padding;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Justify r7 = r9.mainAxisJustify;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Align r8 = r9.crossAxisAlign;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.forceUseCompactMode;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Orientation component1() {
        return this.orientation;
    }

    public final FlexWrap component2() {
        return this.flexWrap;
    }

    public final float component3() {
        return this.mainAxisSpacing;
    }

    public final float component4() {
        return this.crossAxisSpacing;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final Justify component6() {
        return this.mainAxisJustify;
    }

    public final Align component7() {
        return this.crossAxisAlign;
    }

    public final boolean component8() {
        return this.forceUseCompactMode;
    }

    public final FlexLayoutProperty copy(Orientation r11, FlexWrap r12, float r13, float r14, Padding r15, Justify r16, Align r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "orientation");
        Intrinsics.checkNotNullParameter(r12, "flexWrap");
        Intrinsics.checkNotNullParameter(r16, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r17, "crossAxisAlign");
        return new FlexLayoutProperty(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlexLayoutProperty) == true) goto L8;
        return false;
    L8:
        FlexLayoutProperty r6 = (FlexLayoutProperty) r5;
        if (this.orientation == r6.orientation) goto L12;
        return false;
    L12:
        if (this.flexWrap == r6.flexWrap) goto L15;
        return false;
    L15:
        if (Float.compare(this.mainAxisSpacing, r6.mainAxisSpacing) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.crossAxisSpacing, r6.crossAxisSpacing) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.padding, r6.padding) == true) goto L24;
        return false;
    L24:
        if (this.mainAxisJustify == r6.mainAxisJustify) goto L27;
        return false;
    L27:
        if (this.crossAxisAlign == r6.crossAxisAlign) goto L30;
        return false;
    L30:
        if (this.forceUseCompactMode == r6.forceUseCompactMode) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = ((((((this.orientation.hashCode() * 31) + this.flexWrap.hashCode()) * 31) + Float.floatToIntBits(this.mainAxisSpacing)) * 31) + Float.floatToIntBits(this.crossAxisSpacing)) * 31;
        Padding r1 = this.padding;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.mainAxisJustify.hashCode()) * 31) + this.crossAxisAlign.hashCode()) * 31;
        if (this.forceUseCompactMode == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "FlexLayoutProperty(orientation=" + this.orientation + ", flexWrap=" + this.flexWrap + ", mainAxisSpacing=" + this.mainAxisSpacing + ", crossAxisSpacing=" + this.crossAxisSpacing + ", padding=" + this.padding + ", mainAxisJustify=" + this.mainAxisJustify + ", crossAxisAlign=" + this.crossAxisAlign + ", forceUseCompactMode=" + this.forceUseCompactMode + ')';
    }

    public FlexLayoutProperty clone() {
        FlexLayoutProperty r11 = new FlexLayoutProperty(null, null, 0.0f, 0.0f, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        r11.orientation = this.orientation;
        r11.flexWrap = this.flexWrap;
        r11.mainAxisSpacing = this.mainAxisSpacing;
        r11.crossAxisSpacing = this.crossAxisSpacing;
        r11.padding = this.padding;
        r11.mainAxisJustify = this.mainAxisJustify;
        r11.crossAxisAlign = this.crossAxisAlign;
        r11.forceUseCompactMode = this.forceUseCompactMode;
        return r11;
    }

    public final Align getCrossAxisAlign() {
        return this.crossAxisAlign;
    }

    public final float getCrossAxisSpacing() {
        return this.crossAxisSpacing;
    }

    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    public final boolean getForceUseCompactMode() {
        return this.forceUseCompactMode;
    }

    public final Justify getMainAxisJustify() {
        return this.mainAxisJustify;
    }

    public final float getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m1159clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r7 = r6.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L70;
        Map.Entry<Integer, PreviewData> r0 = r7.next();
        int r1 = r0.getKey().intValue();
        int r3 = 0;
        boolean r4 = false;
        r4 = false;
        int r5 = 0;
        r5 = 0;
        int r8 = 0;
        r8 = 0;
        int r9 = 0;
        r9 = 0;
        r3 = 0;
        if (r1 == ComponentAttribute.orientation.getValue()) goto L9;
        if (r1 == ComponentAttribute.flex_wrap.getValue()) goto L17;
        float r10 = 0.0f;
        if (r1 == ComponentAttribute.main_axis_spacing.getValue()) goto L25;
        if (r1 == ComponentAttribute.cross_axis_spacing.getValue()) goto L33;
        if (r1 == ComponentAttribute.padding.getValue()) goto L41;
        if (r1 == ComponentAttribute.main_axis_justify.getValue()) goto L48;
        if (r1 == ComponentAttribute.cross_axis_align.getValue()) goto L56;
        if (r1 != ComponentAttribute.force_use_compact_mode.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L69;
        Boolean r11 = r2.getBoolean();
        if (r11 == null) goto L69;
        r4 = r11.booleanValue();
    L69:
        this.forceUseCompactMode = r4;
        goto L6
    L56:
        Align.a r12 = Align.Companion;
        PreviewData r13 = r0.getValue();
        if (r13 == null) goto L61;
        Integer r14 = r13.getInt();
        if (r14 == null) goto L61;
        r5 = r14.intValue();
    L61:
        r12.getClass();
        this.crossAxisAlign = Align.a.a(r5);
        goto L6
    L48:
        Justify.a r15 = Justify.Companion;
        PreviewData r16 = r0.getValue();
        if (r16 == null) goto L53;
        Integer r17 = r16.getInt();
        if (r17 == null) goto L53;
        r8 = r17.intValue();
    L53:
        r15.getClass();
        this.mainAxisJustify = Justify.a.a(r8);
        goto L6
    L41:
        PreviewData r18 = r0.getValue();
        if (r18 == null) goto L44;
        Padding r19 = r18.getPadding();
    L45:
        this.padding = r19;
        goto L6
    L44:
        r19 = null;
        goto L45
    L33:
        PreviewData r20 = r0.getValue();
        if (r20 == null) goto L38;
        Float r21 = r20.getFloat();
        if (r21 == null) goto L38;
        r10 = r21.floatValue();
    L38:
        this.crossAxisSpacing = r10;
        goto L6
    L25:
        PreviewData r22 = r0.getValue();
        if (r22 == null) goto L30;
        Float r23 = r22.getFloat();
        if (r23 == null) goto L30;
        r10 = r23.floatValue();
    L30:
        this.mainAxisSpacing = r10;
        goto L6
    L17:
        FlexWrap.a r24 = FlexWrap.Companion;
        PreviewData r25 = r0.getValue();
        if (r25 == null) goto L22;
        Integer r26 = r25.getInt();
        if (r26 == null) goto L22;
        r9 = r26.intValue();
    L22:
        r24.getClass();
        this.flexWrap = FlexWrap.a.a(r9);
        goto L6
    L9:
        Orientation.a r27 = Orientation.Companion;
        PreviewData r28 = r0.getValue();
        if (r28 == null) goto L14;
        Integer r29 = r28.getInt();
        if (r29 == null) goto L14;
        r3 = r29.intValue();
    L14:
        r27.getClass();
        this.orientation = Orientation.a.a(r3);
        goto L6
    }

    public final void setCrossAxisAlign(Align r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.crossAxisAlign = r2;
    }

    public final void setCrossAxisSpacing(float r1) {
        this.crossAxisSpacing = r1;
    }

    public final void setFlexWrap(FlexWrap r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.flexWrap = r2;
    }

    public final void setForceUseCompactMode(boolean r1) {
        this.forceUseCompactMode = r1;
    }

    public final void setMainAxisJustify(Justify r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mainAxisJustify = r2;
    }

    public final void setMainAxisSpacing(float r1) {
        this.mainAxisSpacing = r1;
    }

    public final void setOrientation(Orientation r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.orientation = r2;
    }

    public final void setPadding(Padding r1) {
        this.padding = r1;
    }

    public FlexLayoutProperty(Orientation r2, FlexWrap r3, float r4, float r5, Padding r6, Justify r7, Align r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "orientation");
        Intrinsics.checkNotNullParameter(r3, "flexWrap");
        Intrinsics.checkNotNullParameter(r7, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r8, "crossAxisAlign");
        super(Type.FLEX_LAYOUT);
        this.orientation = r2;
        this.flexWrap = r3;
        this.mainAxisSpacing = r4;
        this.crossAxisSpacing = r5;
        this.padding = r6;
        this.mainAxisJustify = r7;
        this.crossAxisAlign = r8;
        this.forceUseCompactMode = r9;
    }

    public /* synthetic */ FlexLayoutProperty(Orientation r9, FlexWrap r10, float r11, float r12, Padding r13, Justify r14, Align r15, boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        Orientation r1 = Orientation.ROW;
    L7:
        if ((r17 & 2) == 0) goto L9;
        FlexWrap r2 = FlexWrap.NO_WRAP;
    L10:
        float r4 = 0.0f;
        if ((r17 & 4) == 0) goto L13;
        float r3 = 0.0f;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r4 = r12;
    L19:
        if ((r17 & 16) == 0) goto L21;
        Padding r5 = null;
    L23:
        if ((r17 & 32) == 0) goto L25;
        Justify r6 = Justify.START;
    L27:
        if ((r17 & 64) == 0) goto L29;
        Align r7 = Align.TOP;
    L31:
        if ((r17 & 128) == 0) goto L33;
        boolean r0 = false;
    L34:
        this(r1, r2, r3, r4, r5, r6, r7, r0);
        return;
    L33:
        r0 = r16;
        goto L34
    L29:
        r7 = r15;
        goto L31
    L25:
        r6 = r14;
        goto L27
    L21:
        r5 = r13;
        goto L23
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L10
    L5:
        r1 = r9;
        goto L7
    }
}
