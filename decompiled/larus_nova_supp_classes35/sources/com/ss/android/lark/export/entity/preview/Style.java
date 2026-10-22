package com.ss.android.lark.export.entity.preview;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.tangram.base.style.Align;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 I2\u00020\u0001:\u0002IJB³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107J\u001c\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0007J\u0017\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u0017J\u0006\u0010B\u001a\u00020\u0017J\b\u0010C\u001a\u00020\u0000H\u0016J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0002J\b\u0010H\u001a\u00020\u0014H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006K"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Style;", "Lcom/ss/android/lark/tangram/base/style/TCStyle;", "sizeLevel", "Lcom/ss/android/lark/export/entity/preview/SizeLevel;", "fontLevel", "Lcom/ss/android/lark/export/entity/preview/FontLevel;", "textColorV2", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "border", "Lcom/ss/android/lark/export/entity/preview/Border;", "backgroundColor", "Lcom/ss/android/lark/export/entity/preview/Gradient;", "width", "Lcom/ss/android/lark/tangram/base/style/Value;", "height", "minWidth", "minHeight", "maxWidth", "maxHeight", "growWeight", BuildConfig.FLAVOR, "shrinkWeight", "aspectRatio", BuildConfig.FLAVOR, "alignSelf", "Lcom/ss/android/lark/tangram/base/style/Align;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/SizeLevel;Lcom/ss/android/lark/export/entity/preview/FontLevel;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/Border;Lcom/ss/android/lark/export/entity/preview/Gradient;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;IIFLcom/ss/android/lark/tangram/base/style/Align;)V", "getSizeLevel", "()Lcom/ss/android/lark/export/entity/preview/SizeLevel;", "setSizeLevel", "(Lcom/ss/android/lark/export/entity/preview/SizeLevel;)V", "getFontLevel", "()Lcom/ss/android/lark/export/entity/preview/FontLevel;", "setFontLevel", "(Lcom/ss/android/lark/export/entity/preview/FontLevel;)V", "getTextColorV2", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setTextColorV2", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getBorder", "()Lcom/ss/android/lark/export/entity/preview/Border;", "setBorder", "(Lcom/ss/android/lark/export/entity/preview/Border;)V", "getBackgroundColor", "()Lcom/ss/android/lark/export/entity/preview/Gradient;", "setBackgroundColor", "(Lcom/ss/android/lark/export/entity/preview/Gradient;)V", "getAlignSelf", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setAlignSelf", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewStyleData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewStyleData;", "applyBackground", "view", "Landroid/view/View;", "mapper", "Lcom/ss/android/lark/export/entity/preview/IColorKeyResMapper;", "getOrientationFromAngle", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "angle", "(Ljava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable$Orientation;", "getWidth", "getHeight", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "Companion", "Builder", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Style extends TCStyle {
    public static final b Companion = null;
    private Align alignSelf;
    private Gradient backgroundColor;
    private Border border;
    private FontLevel fontLevel;
    private SizeLevel sizeLevel;
    private ThemeColor textColorV2;

    public static final class a extends TCStyle.a {
        public final SizeLevel j;

        public final Style a() {
            return new Style(this.j, null, null, null, null, ((TCStyle.a) this).a, ((TCStyle.a) this).b, ((TCStyle.a) this).e, ((TCStyle.a) this).f, ((TCStyle.a) this).g, ((TCStyle.a) this).h, 0, 0, 0.0f, null, 16384, null);
        }

        public a() {
            this.j = SizeLevel.NORMAL;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public Style() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, null, 32767, null);
    }

    public final void applyBackground(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        applyBackground$default(this, r3, null, 2, null);
    }

    @JvmStatic
    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final Style m1157default() {
        Companion.getClass();
        return new a().a();
    }

    public Style clone() {
        SizeLevel r2 = this.sizeLevel;
        FontLevel r1 = this.fontLevel;
        if (r1 == null) goto L5;
        FontLevel r4 = r1.clone();
    L6:
        ThemeColor r3 = this.textColorV2;
        if (r3 == null) goto L9;
        ThemeColor r5 = r3.clone();
    L10:
        Border r6 = this.border;
        if (r6 == null) goto L13;
        Border r7 = r6.clone();
    L14:
        Gradient r8 = this.backgroundColor;
        if (r8 == null) goto L17;
        Gradient r9 = r8.clone();
    L18:
        Value r10 = getWidth();
        if (r10 == null) goto L21;
        Value r11 = r10.clone();
    L22:
        Value r12 = getHeight();
        if (r12 == null) goto L25;
        Value r13 = r12.clone();
    L26:
        Value r14 = getMinWidth();
        if (r14 == null) goto L29;
        Value r15 = r14.clone();
    L30:
        Value r16 = getMinHeight();
        if (r16 == null) goto L33;
        Value r17 = r16.clone();
    L34:
        Value r18 = getMaxWidth();
        if (r18 == null) goto L37;
        Value r19 = r18.clone();
    L38:
        Value r20 = getMaxHeight();
        if (r20 == null) goto L41;
        Value r21 = r20.clone();
    L42:
        Style r110 = new Style(r2, r4, r5, r7, r9, r11, r13, r15, r17, r19, r21, getGrowWeight(), getShrinkWeight(), getAspectRatio(), null, 16384, null);
        r110.setScaleWidth(getScaleWidth().clone());
        r110.setScaleHeight(getScaleHeight().clone());
        return r110;
    L41:
        r21 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final float getHeight() {
        Value r0 = getHeight();
        if (r0 == null) goto L5;
        ValueType r1 = r0.getValueType();
    L7:
        if (r1 != ValueType.POINT) goto L14;
        Value r2 = getHeight();
        if (r2 == null) goto L15;
        Float r3 = r2.getValue();
        if (r3 != null) goto L13;
        return 0.0f;
    L13:
        return r3.floatValue();
    L15:
        return 0.0f;
    L14:
        return 0.0f;
    L5:
        r1 = null;
        goto L7
    }

    public final float getWidth() {
        Value r0 = getWidth();
        if (r0 == null) goto L5;
        ValueType r1 = r0.getValueType();
    L7:
        if (r1 != ValueType.POINT) goto L14;
        Value r2 = getWidth();
        if (r2 == null) goto L15;
        Float r3 = r2.getValue();
        if (r3 != null) goto L13;
        return 0.0f;
    L13:
        return r3.floatValue();
    L15:
        return 0.0f;
    L14:
        return 0.0f;
    L5:
        r1 = null;
        goto L7
    }

    public int hashCode() {
        int r0 = super.hashCode() * 31;
        SizeLevel r1 = this.sizeLevel;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        FontLevel r5 = this.fontLevel;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ThemeColor r8 = this.textColorV2;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        Border r11 = this.border;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        Gradient r14 = this.backgroundColor;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final Align getAlignSelf() {
        return this.alignSelf;
    }

    public final Gradient getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Border getBorder() {
        return this.border;
    }

    public final FontLevel getFontLevel() {
        return this.fontLevel;
    }

    public final SizeLevel getSizeLevel() {
        return this.sizeLevel;
    }

    public final ThemeColor getTextColorV2() {
        return this.textColorV2;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ TCStyle m1158clone() {
        return clone();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Style) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        Style r6 = (Style) r5;
        if (this.sizeLevel == r6.sizeLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fontLevel, r6.fontLevel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textColorV2, r6.textColorV2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.border, r6.border) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final void patchData(UrlPreviewStyleData r10) {
        if (r10 == null) goto L5;
        HashMap<Integer, PreviewData> r1 = r10.getPreviewStyleData();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Iterator<Map.Entry<Integer, PreviewData>> r11 = r10.getPreviewStyleData().entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L252;
        Map.Entry<Integer, PreviewData> r2 = r11.next();
        int r3 = r2.getKey().intValue();
        int r6 = 0;
        if (r3 == ComponentAttribute.size_level.getValue()) goto L13;
        if (r3 == ComponentAttribute.font_level.getValue()) goto L35;
        if (r3 == ComponentAttribute.theme_color.getValue()) goto L42;
        if (r3 == ComponentAttribute.border_width.getValue()) goto L49;
        if (r3 == ComponentAttribute.border_corner_radius.getValue()) goto L63;
        if (r3 == ComponentAttribute.border_theme_color.getValue()) goto L77;
        if (r3 == ComponentAttribute.background_type.getValue()) goto L91;
        if (r3 == ComponentAttribute.background_linear_deg.getValue()) goto L115;
        if (r3 == ComponentAttribute.background_linear_theme_colors.getValue()) goto L149;
        if (r3 == ComponentAttribute.width.getValue()) goto L187;
        if (r3 == ComponentAttribute.height.getValue()) goto L194;
        if (r3 == ComponentAttribute.max_width.getValue()) goto L201;
        if (r3 == ComponentAttribute.max_height.getValue()) goto L208;
        if (r3 == ComponentAttribute.min_width.getValue()) goto L215;
        if (r3 == ComponentAttribute.min_height.getValue()) goto L222;
        if (r3 == ComponentAttribute.grow_weight.getValue()) goto L229;
        if (r3 == ComponentAttribute.shrink_weight.getValue()) goto L237;
        if (r3 != ComponentAttribute.aspect_ratio.getValue()) goto L10;
        PreviewData r4 = r2.getValue();
        if (r4 == null) goto L250;
        Integer r5 = r4.getInt();
        if (r5 == null) goto L250;
        float r7 = r5.intValue() / 100.0f;
    L251:
        setAspectRatio(r7);
    L250:
        r7 = 0.0f;
        goto L251
    L237:
        PreviewData r8 = r2.getValue();
        if (r8 == null) goto L242;
        Integer r9 = r8.getInt();
        if (r9 == null) goto L242;
        r6 = r9.intValue();
    L242:
        setShrinkWeight(r6);
        goto L10
    L229:
        PreviewData r12 = r2.getValue();
        if (r12 == null) goto L234;
        Integer r13 = r12.getInt();
        if (r13 == null) goto L234;
        r6 = r13.intValue();
    L234:
        setGrowWeight(r6);
        goto L10
    L222:
        PreviewData r14 = r2.getValue();
        if (r14 == null) goto L225;
        Value r15 = r14.getLayoutValue();
    L226:
        setMinHeight(r15);
        goto L10
    L225:
        r15 = null;
        goto L226
    L215:
        PreviewData r16 = r2.getValue();
        if (r16 == null) goto L218;
        Value r17 = r16.getLayoutValue();
    L219:
        setMinWidth(r17);
        goto L10
    L218:
        r17 = null;
        goto L219
    L208:
        PreviewData r18 = r2.getValue();
        if (r18 == null) goto L211;
        Value r19 = r18.getLayoutValue();
    L212:
        setMaxHeight(r19);
        goto L10
    L211:
        r19 = null;
        goto L212
    L201:
        PreviewData r20 = r2.getValue();
        if (r20 == null) goto L204;
        Value r21 = r20.getLayoutValue();
    L205:
        setMaxWidth(r21);
        goto L10
    L204:
        r21 = null;
        goto L205
    L194:
        PreviewData r22 = r2.getValue();
        if (r22 == null) goto L197;
        Value r23 = r22.getLayoutValue();
    L198:
        setHeight(r23);
        goto L10
    L197:
        r23 = null;
        goto L198
    L187:
        PreviewData r24 = r2.getValue();
        if (r24 == null) goto L190;
        Value r25 = r24.getLayoutValue();
    L191:
        setWidth(r25);
        goto L10
    L190:
        r25 = null;
        goto L191
    L149:
        Gradient r26 = this.backgroundColor;
        if (r26 == null) goto L151;
        if (r26.getContent() == null) goto L160;
        Gradient r27 = this.backgroundColor;
        if (r27 == null) goto L172;
        Gradient.Content r28 = r27.getContent();
    L174:
        if ((r28 instanceof Gradient.Linear) == false) goto L176;
        Gradient.Linear r29 = (Gradient.Linear) r28;
    L177:
        if (r29 == null) goto L10;
        PreviewData r30 = r2.getValue();
        if (r30 == null) goto L183;
        ThemeColors r31 = r30.getThemeColors();
        if (r31 == null) goto L183;
        ArrayList<ThemeColor> r32 = r31.getThemecolors();
    L184:
        r29.setThemeColors(r32);
    L183:
        r32 = null;
        goto L184
    L176:
        r29 = null;
        goto L177
    L172:
        r28 = null;
        goto L174
    L160:
        Gradient r33 = this.backgroundColor;
        if (r33 == null) goto L10;
        PreviewData r34 = r2.getValue();
        if (r34 == null) goto L167;
        ThemeColors r35 = r34.getThemeColors();
        if (r35 == null) goto L167;
        ArrayList<ThemeColor> r36 = r35.getThemecolors();
    L168:
        r33.setContent(new Gradient.Linear(null, r36, 1, null));
    L167:
        r36 = null;
        goto L168
    L151:
        PreviewData r37 = r2.getValue();
        if (r37 == null) goto L156;
        ThemeColors r38 = r37.getThemeColors();
        if (r38 == null) goto L156;
        ArrayList<ThemeColor> r39 = r38.getThemecolors();
    L157:
        this.backgroundColor = new Gradient(null, new Gradient.Linear(null, r39, 1, null), 1, null);
    L156:
        r39 = null;
        goto L157
    L115:
        Gradient r40 = this.backgroundColor;
        if (r40 == null) goto L117;
        if (r40.getContent() == null) goto L125;
        Gradient r41 = this.backgroundColor;
        if (r41 == null) goto L136;
        Gradient.Content r42 = r41.getContent();
    L138:
        if ((r42 instanceof Gradient.Linear) == false) goto L140;
        Gradient.Linear r43 = (Gradient.Linear) r42;
    L141:
        if (r43 == null) goto L10;
        PreviewData r44 = r2.getValue();
        if (r44 == null) goto L145;
        Integer r45 = r44.getInt();
    L146:
        r43.setDeg(r45);
        goto L10
    L145:
        r45 = null;
        goto L146
    L140:
        r43 = null;
        goto L141
    L136:
        r42 = null;
        goto L138
    L125:
        Gradient r46 = this.backgroundColor;
        if (r46 == null) goto L10;
        PreviewData r47 = r2.getValue();
        if (r47 == null) goto L132;
        Integer r48 = r47.getInt();
        if (r48 == null) goto L132;
        r6 = r48.intValue();
    L132:
        r46.setContent(new Gradient.Linear(Integer.valueOf(r6), null, 2, null));
        goto L10
    L117:
        PreviewData r49 = r2.getValue();
        if (r49 == null) goto L122;
        Integer r50 = r49.getInt();
        if (r50 == null) goto L122;
        r6 = r50.intValue();
    L122:
        this.backgroundColor = new Gradient(null, new Gradient.Linear(Integer.valueOf(r6), null, 2, null), 1, null);
        goto L10
    L91:
        Gradient r51 = this.backgroundColor;
        if (r51 == null) goto L93;
        Gradient.GradientType.a r52 = Gradient.GradientType.Companion;
        PreviewData r53 = r2.getValue();
        if (r53 == null) goto L108;
        Integer r54 = r53.getInt();
        if (r54 == null) goto L108;
        r6 = r54.intValue();
    L108:
        r52.getClass();
        if (r6 != 0) goto L111;
        Gradient.GradientType r55 = Gradient.GradientType.LINEAR;
    L112:
        r51.setType(r55);
        goto L10
    L111:
        r55 = Gradient.GradientType.LINEAR;
        goto L112
    L93:
        Gradient.GradientType.a r56 = Gradient.GradientType.Companion;
        PreviewData r57 = r2.getValue();
        if (r57 == null) goto L98;
        Integer r58 = r57.getInt();
        if (r58 == null) goto L98;
        r6 = r58.intValue();
    L98:
        r56.getClass();
        if (r6 != 0) goto L101;
        Gradient.GradientType r59 = Gradient.GradientType.LINEAR;
    L102:
        this.backgroundColor = new Gradient(r59, null, 2, null);
        goto L10
    L101:
        r59 = Gradient.GradientType.LINEAR;
        goto L102
    L77:
        Border r60 = this.border;
        if (r60 == null) goto L79;
        PreviewData r61 = r2.getValue();
        if (r61 == null) goto L87;
        ThemeColor r62 = r61.getThemeColor();
    L88:
        r60.setThemeColor(r62);
        goto L10
    L87:
        r62 = null;
        goto L88
    L79:
        PreviewData r63 = r2.getValue();
        if (r63 == null) goto L82;
        ThemeColor r64 = r63.getThemeColor();
    L83:
        this.border = new Border(null, null, r64, 3, null);
        goto L10
    L82:
        r64 = null;
        goto L83
    L63:
        Border r65 = this.border;
        if (r65 == null) goto L65;
        PreviewData r66 = r2.getValue();
        if (r66 == null) goto L73;
        Float r67 = r66.getFloat();
    L74:
        r65.setCornerRadius(r67);
        goto L10
    L73:
        r67 = null;
        goto L74
    L65:
        PreviewData r68 = r2.getValue();
        if (r68 == null) goto L68;
        Float r69 = r68.getFloat();
    L69:
        this.border = new Border(null, r69, null, 5, null);
        goto L10
    L68:
        r69 = null;
        goto L69
    L49:
        Border r70 = this.border;
        if (r70 == null) goto L51;
        PreviewData r71 = r2.getValue();
        if (r71 == null) goto L59;
        Float r72 = r71.getFloat();
    L60:
        r70.setWidth(r72);
        goto L10
    L59:
        r72 = null;
        goto L60
    L51:
        PreviewData r73 = r2.getValue();
        if (r73 == null) goto L54;
        Float r74 = r73.getFloat();
    L55:
        this.border = new Border(r74, null, null, 6, null);
        goto L10
    L54:
        r74 = null;
        goto L55
    L42:
        PreviewData r75 = r2.getValue();
        if (r75 == null) goto L45;
        ThemeColor r76 = r75.getThemeColor();
    L46:
        this.textColorV2 = r76;
        goto L10
    L45:
        r76 = null;
        goto L46
    L35:
        PreviewData r77 = r2.getValue();
        if (r77 == null) goto L38;
        FontLevel r78 = r77.getFontLevel();
    L39:
        this.fontLevel = r78;
        goto L10
    L38:
        r78 = null;
        goto L39
    L13:
        PreviewData r79 = r2.getValue();
        if (r79 == null) goto L16;
        Integer r80 = r79.getInt();
    L17:
        if (r80 != null) goto L19;
        SizeLevel r81 = null;
    L32:
        this.sizeLevel = r81;
        goto L10
    L19:
        SizeLevel.a r82 = SizeLevel.Companion;
        PreviewData r83 = r2.getValue();
        if (r83 == null) goto L24;
        Integer r84 = r83.getInt();
        if (r84 == null) goto L24;
        r6 = r84.intValue();
    L24:
        r82.getClass();
        if (r6 == 0) goto L31;
        if (r6 == 1) goto L30;
        if (r6 == 2) goto L29;
        r81 = SizeLevel.NORMAL;
        goto L32
    L29:
        r81 = SizeLevel.LARGE;
        goto L32
    L30:
        r81 = SizeLevel.SMALL;
        goto L32
    L31:
        r81 = SizeLevel.NORMAL;
        goto L32
    L16:
        r80 = null;
        goto L17
    L252:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setAlignSelf(Align r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.alignSelf = r2;
    }

    public final void setBackgroundColor(Gradient r1) {
        this.backgroundColor = r1;
    }

    public final void setBorder(Border r1) {
        this.border = r1;
    }

    public final void setFontLevel(FontLevel r1) {
        this.fontLevel = r1;
    }

    public final void setSizeLevel(SizeLevel r1) {
        this.sizeLevel = r1;
    }

    public final void setTextColorV2(ThemeColor r1) {
        this.textColorV2 = r1;
    }

    public final void applyBackground(View r9, ycb.a r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        r9.setBackground(null);
        Gradient r0 = this.backgroundColor;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getType() != Gradient.GradientType.LINEAR) goto L62;
        Gradient.Content r1 = r0.getContent();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
        Gradient.Linear r2 = (Gradient.Linear) r1;
        ArrayList<ThemeColor> r3 = r2.getThemeColors();
        if (r3 == null) goto L63;
        int[] r4 = new int[r3.size()];
        int r5 = r3.size();
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L11;
        r4[r6] = com.ss.android.lark.export.entity.preview.a.a((ThemeColor) ListProtector.get(r3, r6), r9.getContext(), r10);
        r6 = r6 + 1;
        goto L9
    L11:
        GradientDrawable r7 = new GradientDrawable();
        if (r3.size() != 1) goto L15;
        r7.setColor(r4[0]);
    L45:
        Border r8 = this.border;
        if (r8 == null) goto L58;
        Float r11 = r8.getCornerRadius();
        if (r11 == null) goto L50;
        r7.setCornerRadius(UIHelper.dp2px(r11.floatValue()));
    L50:
        ThemeColor r12 = r8.getThemeColor();
        Float r13 = r8.getWidth();
        if (r13 == null) goto L53;
        float r14 = r13.floatValue();
    L54:
        if (r12 == null) goto L58;
        if (r14 <= 0.0f) goto L58;
        r7.setStroke(UIHelper.dp2px(r14), com.ss.android.lark.export.entity.preview.a.a(r12, r9.getContext(), r10));
        goto L58
    L53:
        r14 = 0.0f;
    L58:
        r9.setBackground(r7);
        return;
    L15:
        if (r3.size() <= 1) goto L45;
        Integer r15 = r2.getDeg();
        if (r15 == null) goto L43;
        int r16 = Math.abs(r15.intValue()) % 360;
        if (r16 != 0) goto L21;
        GradientDrawable.Orientation r17 = GradientDrawable.Orientation.BOTTOM_TOP;
    L44:
        r7.setOrientation(r17);
        r7.setColors(r4);
        goto L45
    L21:
        if (r16 != 45) goto L23;
        r17 = GradientDrawable.Orientation.BL_TR;
        goto L44
    L23:
        if (r16 != 90) goto L25;
        r17 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L44
    L25:
        if (r16 != 135) goto L27;
        r17 = GradientDrawable.Orientation.TL_BR;
        goto L44
    L27:
        if (r16 != 180) goto L29;
        r17 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L44
    L29:
        if (r16 != 225) goto L31;
        r17 = GradientDrawable.Orientation.TR_BL;
        goto L44
    L31:
        if (r16 != 270) goto L33;
        r17 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L44
    L33:
        if (r16 == 315) goto L35;
        r17 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L44
    L35:
        r17 = GradientDrawable.Orientation.BR_TL;
        goto L44
    L43:
        r17 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L44
    L63:
        return;
    }

    public static /* synthetic */ void applyBackground$default(Style r0, View r1, ycb.a r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.applyBackground(r1, r2);
    }

    public Style(SizeLevel r18, FontLevel r19, ThemeColor r20, Border r21, Gradient r22, Value r23, Value r24, Value r25, Value r26, Value r27, Value r28, int r29, int r30, float r31, Align r32) {
        Intrinsics.checkNotNullParameter(r32, "alignSelf");
        super(r23, r24, r25, r26, r27, r28, r29, r30, r31, null, null, r32, 1536, null);
        this.sizeLevel = r18;
        this.fontLevel = r19;
        this.textColorV2 = r20;
        this.border = r21;
        this.backgroundColor = r22;
        this.alignSelf = r32;
    }

    public /* synthetic */ Style(SizeLevel r16, FontLevel r17, ThemeColor r18, Border r19, Gradient r20, Value r21, Value r22, Value r23, Value r24, Value r25, Value r26, int r27, int r28, float r29, Align r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 1) == 0) goto L5;
        SizeLevel r1 = SizeLevel.NORMAL;
    L6:
        Value r3 = null;
        if ((r31 & 2) == 0) goto L9;
        FontLevel r2 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        ThemeColor r4 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        Border r5 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Gradient r6 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        Value r7 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        Value r8 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        Value r9 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        Value r10 = null;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Value r11 = null;
    L43:
        if ((r31 & ChameleonContainerUtils.MAX_URL_LENGTH) != 0) goto L46;
        r3 = r26;
    L46:
        int r13 = 0;
        if ((r31 & 2048) == 0) goto L49;
        int r12 = 0;
    L51:
        if ((r31 & 4096) != 0) goto L55;
        r13 = r28;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        float r14 = 0.0f;
    L59:
        if ((r31 & 16384) == 0) goto L61;
        Align r0 = Align.TOP;
    L62:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r3, r12, r13, r14, r0);
        return;
    L61:
        r0 = r30;
        goto L62
    L57:
        r14 = r29;
        goto L59
    L49:
        r12 = r27;
        goto L51
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L6
    }
}
