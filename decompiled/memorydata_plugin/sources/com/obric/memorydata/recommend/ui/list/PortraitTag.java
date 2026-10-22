package com.obric.memorydata.recommend.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0002&'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J0\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014R\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/PortraitTag;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", EventBody.KEY_VALUE, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setSelected", "", BuildConfig.FLAVOR, "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "Style", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PortraitTag extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12672a = null;
    private static final List<String> d = null;
    private static final String e = null;
    private static final String f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f12673b;
    private final TextView c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/PortraitTag$Style;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Rect", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style Default = null;
        public static final Style Rect = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{Default, Rect};
        }

        static {
            Default = new Style("Default", 0);
            Rect = new Style("Rect", 1);
            Style[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        public static Style valueOf(String r2) {
            return (Style) ZeusTransformUtils.preCheckCast(Enum.valueOf(Style.class, r2), Style.class, "com.obric.memorydata.plugin");
        }

        public static Style[] values() {
            return (Style[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Style[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/PortraitTag$Companion;", "", "<init>", "()V", "TAG", "", "tags", "", "getTags", "()Ljava/util/List;", "tagAll", "getTagAll", "()Ljava/lang/String;", "tagOthers", "getTagOthers", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final List<String> a() {
            return PortraitTag.a();
        }

        public final String b() {
            return PortraitTag.b();
        }

        public final String c() {
            return PortraitTag.c();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12674a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.Default.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Style.Rect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12674a = r0;
        }
    }

    static {
        f12672a = new a(null);
        d = AppSettingsManager.INSTANCE.getRecommendSettings().getProfileTag();
        e = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_portrait_tag_all, TypedValues.Custom.S_STRING, "recommend_memory_portrait_tag_all"));
        f = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_portrait_tag_others, TypedValues.Custom.S_STRING, "recommend_memory_portrait_tag_others"));
    }

    public PortraitTag(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PortraitTag(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public PortraitTag(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12, null, 8, null);
        View r15 = FrameLayout.inflate(r13, ZeusTransformUtils.mapRes(R.layout.item_recommend_portrait_tag, "layout", "item_recommend_portrait_tag"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.f12673b = r15;
        View r16 = r15.findViewById(ZeusTransformUtils.mapRes(R.id.chip_text, OaidModel.KEY_ID, "chip_text"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(...)");
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r16, TextView.class, "com.obric.memorydata.plugin");
        this.c = r17;
        TypedArray r18 = r13.obtainStyledAttributes(r14, R.styleable.PortraitTag);
        r17.setText(r18.getText(ZeusTransformUtils.mapRes(R.styleable.PortraitTag_text, "styleable", "PortraitTag_text")));
        int r0 = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.PortraitTag_text_color, "styleable", "PortraitTag_text_color"), -1);
        Style r1 = Style.values()[r18.getInt(ZeusTransformUtils.mapRes(R.styleable.PortraitTag_chip_style, "styleable", "PortraitTag_chip_style"), 0)];
        r18.recycle();
        setBackgroundColor(r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2")));
        r17.setTextColor(r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, TypedValues.Custom.S_COLOR, "oui_text_3")));
        if (r0 == (-1)) goto L5;
        r17.setTextColor(r0);
    L5:
        int r19 = b.f12674a[r1.ordinal()];
        if (r19 != 1) goto L8;
        int r110 = 99;
    L13:
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r110, Resources.getSystem().getDisplayMetrics())));
        setSelected(false);
        return;
    L8:
        if (r19 != 2) goto L11;
        r110 = 8;
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ PortraitTag(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ List a() {
        return d;
    }

    public static final /* synthetic */ String b() {
        return e;
    }

    public static final /* synthetic */ String c() {
        return f;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.c.getText();
        Intrinsics.checkNotNullExpressionValue(r1, "getText(...)");
        return r1;
    }

    public final TextView getTextView() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r5) {
        RunLog.INSTANCE.debug("PortraitTag", "setSelected: " + r5 + ", current state: " + isSelected());
        if (r5 == isSelected()) goto L10;
        super.setSelected(r5);
        if (isSelected() == false) goto L7;
        setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_b_blue_bg_light, TypedValues.Custom.S_COLOR, "oui_b_blue_bg_light")));
        TextView r6 = this.c;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r1 = R.color.oui_b_blue_fg;
        String r2 = "oui_b_blue_fg";
    L8:
        r6.setTextColor(r4.getColor(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_COLOR, r2)));
        return;
    L7:
        setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2")));
        r6 = this.c;
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r1 = R.color.oui_text_3;
        r2 = "oui_text_3";
        goto L8
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.c.setText(r4);
    }
}
