package com.bytedance.android.ec.core.imagex.transform;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule;", "Ljava/io/Serializable;", "", "origin", "Lcom/bytedance/android/ec/core/imagex/transform/a;", "resizeConfig", "transform", "pattern", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "setPattern", "(Ljava/lang/String;)V", "", "sizeOption", "Ljava/lang/Integer;", "getSizeOption", "()Ljava/lang/Integer;", "setSizeOption", "(Ljava/lang/Integer;)V", "remakeType", "getRemakeType", "setRemakeType", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule$TemplateFormat;", "templateFormat", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule$TemplateFormat;", "getTemplateFormat", "()Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule$TemplateFormat;", "setTemplateFormat", "(Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule$TemplateFormat;)V", "", "templateGroupFormat", "Ljava/util/Map;", "getTemplateGroupFormat", "()Ljava/util/Map;", "setTemplateGroupFormat", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "TemplateFormat", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageUrlTransformRule implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("pattern")
    private String pattern;

    @SerializedName("remake_type")
    private Integer remakeType;

    @SerializedName("size_option")
    private Integer sizeOption;

    @SerializedName("template_format")
    private TemplateFormat templateFormat;

    @SerializedName("template_group_format")
    private Map<String, TemplateFormat> templateGroupFormat;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b'\u0010(J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR$\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule$TemplateFormat;", "Ljava/io/Serializable;", "", "matched", "Lcom/bytedance/android/ec/core/imagex/transform/a;", "resizeConfig", "replace", "", "replaceType", "Ljava/lang/Integer;", "getReplaceType", "()Ljava/lang/Integer;", "setReplaceType", "(Ljava/lang/Integer;)V", "resizeType", "getResizeType", "setResizeType", "scaleWidth", "getScaleWidth", "setScaleWidth", "scaleHeight", "getScaleHeight", "setScaleHeight", "specificScale", "getSpecificScale", "setSpecificScale", "replaceFormat", "Ljava/lang/String;", "getReplaceFormat", "()Ljava/lang/String;", "setReplaceFormat", "(Ljava/lang/String;)V", "", "fixedWidthOptions", "[I", "getFixedWidthOptions", "()[I", "setFixedWidthOptions", "([I)V", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TemplateFormat implements Serializable {
        public static final a Companion = null;
        public static int a = 0;
        private static final long serialVersionUID = 1;

        @SerializedName("fixed_width_options")
        private int[] fixedWidthOptions;

        @SerializedName("replace_format")
        private String replaceFormat;

        @SerializedName("replace_type")
        private Integer replaceType;

        @SerializedName("resize_type")
        private Integer resizeType;

        @SerializedName("scale_height")
        private Integer scaleHeight;

        @SerializedName("scale_width")
        private Integer scaleWidth;

        @SerializedName("specific_scale")
        private Integer specificScale;

        public static final class a {
            public a() {
            }
        }

        public TemplateFormat() {
        }

        static {
            Companion = new a();
            a = -1;
        }

        public final String a() {
            Integer r1 = this.scaleWidth;
            int r10 = -1;
            if (r1 == null) goto L5;
            int r11 = r1.intValue();
        L6:
            Integer r12 = this.scaleHeight;
            if (r12 == null) goto L9;
            int r13 = r12.intValue();
        L11:
            if (r11 < 0) goto L54;
            if (r13 >= 0) goto L14;
            return null;
        L14:
            if ((r11 + r13) > 0) goto L17;
            return null;
        L17:
            if (a > 0) goto L34;
            Context r14 = ECAppInfoService.e.getApplicationContext();
            if (r14 == null) goto L30;
            Resources r15 = r14.getResources();
            if (r15 == null) goto L30;
            DisplayMetrics r16 = INVOKEVIRTUAL_com_bytedance_android_ec_core_imagex_transform_ImageUrlTransformRule$TemplateFormat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r15);
            if (r16 == null) goto L30;
            Float r17 = Float.valueOf(r16.density);
            if (r17.floatValue() <= 0) goto L27;
            boolean r18 = true;
        L28:
            if (r18 == false) goto L30;
        L31:
            if (r17 == null) goto L33;
            r10 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (r17.floatValue() + 0.5f), 2), 3);
        L33:
            a = r10;
            goto L34
        L27:
            r18 = false;
        L30:
            r17 = null;
        L34:
            Integer r19 = this.specificScale;
            if (r19 != null) goto L37;
        L45:
            int r20 = a;
        L46:
            if (r20 < 1) goto L59;
            String r21 = this.replaceFormat;
            if (r21 == null) goto L56;
            String r110 = StringsKt.replace$default(r21, "#{resize_width}", String.valueOf(RangesKt.coerceAtLeast(r11 * r20, 0)), false, 4, null);
            if (r110 != null) goto L53;
            return null;
        L53:
            return StringsKt.replace$default(r110, "#{resize_height}", String.valueOf(RangesKt.coerceAtLeast(r13 * r20, 0)), false, 4, null);
        L56:
            return null;
        L59:
            return null;
        L37:
            if (r19.intValue() <= 0) goto L39;
            boolean r22 = true;
        L40:
            if (r22 == true) goto L43;
            r19 = null;
        L43:
            if (r19 == null) goto L45;
            r20 = r19.intValue();
            goto L46
        L39:
            r22 = false;
            goto L40
        L54:
            return null;
        L9:
            r13 = -1;
            goto L11
        L5:
            r11 = -1;
            goto L6
        }

        public final int[] getFixedWidthOptions() {
            return this.fixedWidthOptions;
        }

        public final String getReplaceFormat() {
            return this.replaceFormat;
        }

        public final Integer getReplaceType() {
            return this.replaceType;
        }

        public final Integer getResizeType() {
            return this.resizeType;
        }

        public final Integer getScaleHeight() {
            return this.scaleHeight;
        }

        public final Integer getScaleWidth() {
            return this.scaleWidth;
        }

        public final Integer getSpecificScale() {
            return this.specificScale;
        }

        public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ec_core_imagex_transform_ImageUrlTransformRule$TemplateFormat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
            return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        }

        public final void setFixedWidthOptions(int[] r1) {
            this.fixedWidthOptions = r1;
        }

        public final void setReplaceFormat(String r1) {
            this.replaceFormat = r1;
        }

        public final void setReplaceType(Integer r1) {
            this.replaceType = r1;
        }

        public final void setResizeType(Integer r1) {
            this.resizeType = r1;
        }

        public final void setScaleHeight(Integer r1) {
            this.scaleHeight = r1;
        }

        public final void setScaleWidth(Integer r1) {
            this.scaleWidth = r1;
        }

        public final void setSpecificScale(Integer r1) {
            this.specificScale = r1;
        }

        public final String replace(String r21, com.bytedance.android.ec.core.imagex.transform.a r22) {
            Intrinsics.checkNotNullParameter(r21, "matched");
            if (StringsKt.isBlank(r21) == false) goto L6;
            return null;
        L6:
            if (this.replaceType == null) goto L106;
            String r10 = this.replaceFormat;
            boolean r11 = false;
            if (r10 != null) goto L10;
        L13:
            boolean r12 = true;
        L14:
            if (r12 == true) goto L110;
            Integer r13 = this.resizeType;
            if (r13 != null) goto L20;
        L21:
            Integer r14 = this.resizeType;
            if (r14 != null) goto L25;
        L27:
            if (r14 != null) goto L30;
        L79:
            String r15 = null;
        L81:
            if (r15 != null) goto L83;
        L84:
            r11 = true;
        L85:
            if (r11 == false) goto L87;
            return null;
        L87:
            Integer r16 = this.replaceType;
            if (r16 != null) goto L91;
        L93:
            if (r16 != null) goto L96;
        L98:
            if (r16 != null) goto L101;
            return null;
        L101:
            if (r16.intValue() == 2) goto L103;
            return null;
        L103:
            return r15 + r21;
        L96:
            if (r16.intValue() != 1) goto L98;
            return r21 + r15;
        L91:
            if (r16.intValue() != 0) goto L93;
            return r15;
        L83:
            if (StringsKt.isBlank(r15) == false) goto L85;
        L30:
            if (r14.intValue() != 2) goto L79;
            if (r22 != null) goto L33;
        L78:
            r15 = a();
            goto L81
        L33:
            if (r22.a <= 0) goto L35;
        L38:
            boolean r17 = true;
        L39:
            if (r17 != true) goto L78;
            int[] r18 = this.fixedWidthOptions;
            if (r18 != null) goto L44;
        L52:
            r18 = (int[]) ImageUrlTransformRulesConfigCenter.a.getValue();
        L53:
            if (r18 == null) goto L79;
            if (r18.length != 0) goto L57;
            boolean r19 = true;
        L58:
            if (r19 == true) goto L79;
            int r20 = r18.length;
            int r23 = 0;
        L61:
            if (r23 >= r20) goto L69;
            int r110 = r18[r23];
            if (r110 < r22.a) goto L65;
            boolean r111 = true;
        L66:
            if (r111 == true) goto L67;
            r23 = r23 + 1;
            goto L61
        L67:
            Integer r24 = Integer.valueOf(r110);
        L70:
            if (r24 == null) goto L72;
            int r25 = r24.intValue();
        L73:
            String r26 = this.replaceFormat;
            if (r26 == null) goto L79;
            String r112 = StringsKt.replace$default(r26, "#{resize_width}", String.valueOf(RangesKt.coerceAtLeast(r25, 0)), false, 4, null);
            if (r112 == null) goto L79;
            r15 = StringsKt.replace$default(r112, "#{resize_height}", "0", false, 4, null);
            goto L81
        L72:
            r25 = ArraysKt.last(r18);
            goto L73
        L65:
            r111 = false;
            goto L66
        L69:
            r24 = null;
            goto L70
        L57:
            r19 = false;
            goto L58
        L44:
            if (r18.length != 0) goto L46;
            boolean r27 = true;
        L48:
            if ((!r27) == true) goto L51;
            r18 = null;
        L51:
            if (r18 != null) goto L53;
        L46:
            r27 = false;
            goto L48
        L35:
            if (r22.b > 0) goto L38;
            r17 = false;
            goto L39
        L25:
            if (r14.intValue() != 1) goto L27;
            r15 = a();
            goto L81
        L20:
            if (r13.intValue() != 0) goto L21;
            r15 = this.replaceFormat;
            goto L81
        L110:
            return null;
        L10:
            if (StringsKt.isBlank(r10) == true) goto L13;
            r12 = false;
            goto L14
        L106:
            return null;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageUrlTransformRule() {
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final Integer getRemakeType() {
        return this.remakeType;
    }

    public final Integer getSizeOption() {
        return this.sizeOption;
    }

    public final TemplateFormat getTemplateFormat() {
        return this.templateFormat;
    }

    public final Map<String, TemplateFormat> getTemplateGroupFormat() {
        return this.templateGroupFormat;
    }

    public final void setPattern(String r1) {
        this.pattern = r1;
    }

    public final void setRemakeType(Integer r1) {
        this.remakeType = r1;
    }

    public final void setSizeOption(Integer r1) {
        this.sizeOption = r1;
    }

    public final void setTemplateFormat(TemplateFormat r1) {
        this.templateFormat = r1;
    }

    public final void setTemplateGroupFormat(Map<String, TemplateFormat> r1) {
        this.templateGroupFormat = r1;
    }

    public final String a(MatchResult r12, com.bytedance.android.ec.core.imagex.transform.a r13) {
        Integer r0 = this.remakeType;
        if (r0 != null) goto L6;
    L11:
        if (r0 != null) goto L14;
    L64:
        return null;
    L14:
        if (r0.intValue() != 1) goto L64;
        Map<String, TemplateFormat> r1 = this.templateGroupFormat;
        if (r1 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
        return null;
    L24:
        ArrayList r11 = new ArrayList();
        MatchGroupCollection r14 = r12.getGroups();
        int r15 = r14.size();
        int r16 = 1;
    L25:
        if (r16 >= r15) goto L53;
        MatchGroup r17 = r14.get(r16);
        if (r17 == null) goto L29;
        String r18 = r17.getValue();
    L30:
        if (r18 != null) goto L32;
    L35:
        boolean r19 = true;
    L36:
        if (r19 == true) goto L51;
        Map<String, TemplateFormat> r20 = this.templateGroupFormat;
        if (r20 == null) goto L42;
        TemplateFormat r21 = r20.get(String.valueOf(r16));
        if (r21 == null) goto L42;
        Intrinsics.checkNotNull(r18);
        String r22 = r21.replace(r18, r13);
    L43:
        if (r22 != null) goto L45;
    L48:
        boolean r23 = true;
    L49:
        if (r23 == true) goto L51;
        Intrinsics.checkNotNull(r17);
        Intrinsics.checkNotNull(r22);
        ListProtector.add(r11, 0, new Pair(r17, r22));
        goto L51
    L45:
        if (StringsKt.isBlank(r22) == true) goto L48;
        r23 = false;
    L42:
        r22 = null;
    L51:
        r16 = r16 + 1;
        goto L25
    L32:
        if (StringsKt.isBlank(r18) == true) goto L35;
        r19 = false;
        goto L36
    L29:
        r18 = null;
        goto L30
    L53:
        if (r11.isEmpty() == false) goto L55;
        return null;
    L55:
        String r110 = r12.getValue();
        int r111 = r12.getRange().getFirst();
        Iterator r24 = r11.iterator();
    L57:
        if (r24.hasNext() == false) goto L63;
        Pair r25 = (Pair) r24.next();
        IntRange r26 = new IntRange(((MatchGroup) r25.getFirst()).getRange().getFirst() - r111, ((MatchGroup) r25.getFirst()).getRange().getLast() - r111);
        CharSequence r27 = (CharSequence) r25.getSecond();
        if (r110 == null) goto L62;
        r110 = StringsKt.replaceRange(r110, r26, r27).toString();
        goto L57
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L63:
        return r110;
    L18:
        if (r1.isEmpty() == true) goto L21;
        r10 = false;
        goto L22
    L6:
        if (r0.intValue() != 0) goto L11;
        TemplateFormat r28 = this.templateFormat;
        if (r28 != null) goto L10;
        return null;
    L10:
        return r28.replace(r12.getValue(), r13);
    }

    public final String transform(String r10, com.bytedance.android.ec.core.imagex.transform.a r11) {
        Intrinsics.checkNotNullParameter(r10, "origin");
        if (StringsKt.isBlank(r10) == true) goto L70;
        String r0 = this.pattern;
        boolean r12 = false;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L71;
        Integer r13 = this.sizeOption;
        if (r13 != null) goto L15;
        return null;
    L15:
        if (this.remakeType != null) goto L18;
        return null;
    L18:
        if (r13 != null) goto L21;
    L22:
        Integer r14 = this.sizeOption;
        if (r14 != null) goto L26;
    L29:
        Integer r15 = this.sizeOption;
        if (r15 != null) goto L33;
    L36:
        String r16 = this.pattern;
        Intrinsics.checkNotNull(r16);
        Regex r17 = new Regex(r16);
        MatchResult r18 = Regex.find$default(r17, r10, 0, 2, null);
        if (r18 != null) goto L68;
        return null;
    L68:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L52
        String r20 = a(r18, r11);     // Catch: Throwable -> L52
        if (r20 != null) goto L42;
    L45:
        boolean r21 = true;
    L47:
        if ((!r21) == true) goto L50;
        r20 = null;
    L50:
        Object r22 = Result.constructor-impl(r20);     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r22) == false) goto L57;
        r22 = null;
    L57:
        String r23 = (String) r22;
        if (r23 != null) goto L60;
        return null;
    L60:
        String r24 = r17.replace(r10, r23);
        if (StringsKt.isBlank(r24) == false) goto L63;
    L65:
        if (r12 == true) goto L67;
        return null;
    L67:
        return r24;
    L63:
        if ((!Intrinsics.areEqual(r24, r10)) == false) goto L65;
        r12 = true;
        goto L65
    L42:
        if (StringsKt.isBlank(r20) == true) goto L45;
        r21 = false;
    L52:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L33:
        if (r15.intValue() != 2) goto L36;
        if (r11 == null) goto L36;
        return null;
    L26:
        if (r14.intValue() != 1) goto L29;
        if (r11 != null) goto L29;
        return null;
    L21:
        if (r13.intValue() == 0) goto L36;
    L71:
        return null;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L70:
        return null;
    }
}
