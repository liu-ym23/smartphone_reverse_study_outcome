package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "customEndContainer", "Landroid/widget/FrameLayout;", "tailIcon", "Landroid/widget/ImageView;", "titleTextView", "Landroid/widget/TextView;", "getCustomEndView", "Landroid/view/View;", "getEndDetail", "Lcom/obric/oui/text/OTextView;", "setCustomEndView", "", "view", "resId", "setDefaultCustomEndView", "defaultCustomEnd", "setDefaultTailIcon", "defaultTailIcon", "setDetailEndText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "setTailIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setTitleStyle", "setTitleText", "setTitleTextColor", TypedValues.Custom.S_COLOR, "setTitleTextSize", "size", "", "showCustomEnd", "show", "", "showTailIcon", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSectionTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14418a = null;
    private static final int f = 0;
    private static final int g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f14419b;
    private TextView c;
    private final FrameLayout d;
    private final ImageView e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar$Companion;", "", "()V", "CUSTOM_END_DETAIL", "", "getCUSTOM_END_DETAIL", "()I", "TAIL_ICON_ARROW", "getTAIL_ICON_ARROW", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14418a = new a(null);
    }

    public OSectionTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSectionTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSectionTitleBar(Context r19, AttributeSet r20, int r21) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r13, r21);
        setOrientation(0);
        ZeusTransformUtils.inflate(LayoutInflater.from(r11), ZeusTransformUtils.mapRes(R.layout.o_section_title_bar, "layout", "o_section_title_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.container, OaidModel.KEY_ID, "container"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.container)");
        this.f14419b = (LinearLayout) ZeusTransformUtils.preCheckCast(r1, LinearLayout.class, "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.titleTextView, OaidModel.KEY_ID, "titleTextView"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.titleTextView)");
        this.c = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, OaidModel.KEY_ID, "custom_end_container"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.custom_end_container)");
        this.d = (FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.tail_icon, OaidModel.KEY_ID, "tail_icon"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.tail_icon)");
        this.e = (ImageView) ZeusTransformUtils.preCheckCast(r4, ImageView.class, "com.obric.memorydata.plugin");
        TypedArray r5 = r11.getTheme().obtainStyledAttributes(r13, R.styleable.SectionTitleBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r5, "context.theme.obtainStyl…           0, 0\n        )");
    L32:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleText, "styleable", "SectionTitleBar_sectionTitle_titleText")) == false) goto L7;
        setTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleText, "styleable", "SectionTitleBar_sectionTitle_titleText")), CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L7:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleStyle, "styleable", "SectionTitleBar_sectionTitle_titleStyle")) == false) goto L10;
        setTitleStyle(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleStyle, "styleable", "SectionTitleBar_sectionTitle_titleStyle"), ZeusTransformUtils.mapRes(R.style.OSectionTitleBar_S, "style", "OSectionTitleBar_S")));     // Catch: Throwable -> L32
    L10:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_customEnd, "styleable", "SectionTitleBar_sectionTitle_customEnd")) == false) goto L13;
        setCustomEndView(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_customEnd, "styleable", "SectionTitleBar_sectionTitle_customEnd"), 0));     // Catch: Throwable -> L32
    L13:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultCustomEnd, "styleable", "SectionTitleBar_sectionTitle_defaultCustomEnd")) == false) goto L16;
        setDefaultCustomEndView(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultCustomEnd, "styleable", "SectionTitleBar_sectionTitle_defaultCustomEnd"), 0));     // Catch: Throwable -> L32
    L16:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_detailEndText, "styleable", "SectionTitleBar_sectionTitle_detailEndText")) == false) goto L19;
        setDetailEndText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_detailEndText, "styleable", "SectionTitleBar_sectionTitle_detailEndText")), CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L19:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showCustomEnd, "styleable", "SectionTitleBar_sectionTitle_showCustomEnd")) == false) goto L22;
        a(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showCustomEnd, "styleable", "SectionTitleBar_sectionTitle_showCustomEnd"), false));     // Catch: Throwable -> L32
    L22:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_tail, "styleable", "SectionTitleBar_sectionTitle_tail")) == false) goto L25;
        setTailIcon(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_tail, "styleable", "SectionTitleBar_sectionTitle_tail"), 0));     // Catch: Throwable -> L32
    L25:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultTail, "styleable", "SectionTitleBar_sectionTitle_defaultTail")) == false) goto L28;
        setDefaultTailIcon(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultTail, "styleable", "SectionTitleBar_sectionTitle_defaultTail"), 0));     // Catch: Throwable -> L32
    L28:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showTail, "styleable", "SectionTitleBar_sectionTitle_showTail")) == false) goto L30;
        b(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showTail, "styleable", "SectionTitleBar_sectionTitle_showTail"), false));     // Catch: Throwable -> L32
    L30:
        r5.recycle();
    }

    public /* synthetic */ OSectionTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public final void a(boolean r3) {
        int r0 = this.d.getChildCount();
        int r1 = 8;
        FrameLayout r2 = this.d;
        if (r0 == 0) goto L6;
        if (r3 == false) goto L6;
        r1 = 0;
    L6:
        r2.setVisibility(r1);
    }

    public final void b(boolean r3) {
        Drawable r0 = this.e.getDrawable();
        int r1 = 8;
        ImageView r2 = this.e;
        if (r0 == null) goto L6;
        if (r3 == false) goto L6;
        r1 = 0;
    L6:
        r2.setVisibility(r1);
    }

    public final View getCustomEndView() {
        if (this.d.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.d.getChildAt(0);
    }

    public final OTextView getEndDetail() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    public final void setCustomEndView(int r5) {
        this.d.removeAllViews();
        if (r5 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        LinearLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(this.d, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L8
    }

    public final void setCustomEndView(View r2) {
        this.d.removeAllViews();
        if (r2 == null) goto L5;
        this.d.addView(r2);
        return;
    L5:
        a(false);
    }

    public final void setDefaultCustomEndView(int r3) {
        this.d.removeAllViews();
        if (r3 != f) goto L5;
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_section_titlebar_custom_end_detail, "layout", "o_section_titlebar_custom_end_detail"));
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r4) {
        if (r4 != g) goto L5;
        setTailIcon(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_section_titlebar_tail_icon_arrow, "drawable", "o_section_titlebar_tail_icon_arrow")));
        return;
    L5:
        b(false);
    }

    public final void setDetailEndText(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        setDefaultCustomEndView(f);
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L6;
        View r3 = getCustomEndView();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) ZeusTransformUtils.preCheckCast(r3, OTextView.class, "com.obric.memorydata.plugin")).setText(r5);
        return;
    }

    public final void setTailIcon(int r2) {
        if (r2 == 0) goto L4;
        this.e.setImageResource(r2);
        return;
    L4:
        this.e.setImageDrawable(null);
        b(false);
    }

    public final void setTailIcon(Drawable r1) {
        if (r1 == null) goto L4;
        this.e.setImageDrawable(r1);
        return;
    L4:
        b(false);
    }

    public final void setTitleStyle(int r1) {
        this.c.setTextAppearance(r1);
    }

    public final void setTitleText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.c.setText(r4);
    }

    public final void setTitleTextColor(int r1) {
        this.c.setTextColor(r1);
    }

    public final void setTitleTextSize(float r1) {
        this.c.setTextSize(r1);
    }
}
