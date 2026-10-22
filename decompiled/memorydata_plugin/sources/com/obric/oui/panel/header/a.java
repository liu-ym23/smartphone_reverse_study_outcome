package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.dumper.Scraps;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u000fJ\b\u0010\"\u001a\u00020\u000fH\u0016J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\b\b\u0001\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0005J+\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00100J\u0016\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00072\u0006\u00101\u001a\u00020(J\u0010\u00102\u001a\u00020$2\b\b\u0001\u0010'\u001a\u00020(J\u0016\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020(J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\nJ\r\u0010=\u001a\u00020$H\u0000¢\u0006\u0002\b>J+\u0010?\u001a\u00020$2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010(2\u0006\u0010B\u001a\u00020\n¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020$H\u0007J\b\u0010E\u001a\u00020$H\u0007J\b\u0010F\u001a\u00020$H\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "context", "Landroid/content/Context;", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "title", "", "(Landroid/content/Context;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;)V", "useAutoSwitchTheme", "", "(Landroid/content/Context;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;Z)V", "dividerView", "Lcom/obric/oui/divider/ODivider;", "grabberView", "Landroid/view/View;", "ivBack", "Landroid/widget/ImageView;", "ivClose", "Landroidx/appcompat/widget/AppCompatImageView;", "mainContentView", "rootView", "titleOnPad", "", "getTitleOnPad", "()Ljava/lang/String;", "setTitleOnPad", "(Ljava/lang/String;)V", "tvTitle", "Landroid/widget/TextView;", "getBackView", "getCloseView", "getGrabberView", "getMainContentView", "getView", "hideBackBtn", "", "removeBottomConstraint", "setHeaderBackgroundColor", TypedValues.Custom.S_COLOR, "", "setOnCloseClickListener", "listener", "setTitle", "charSequence", "drawable", "Landroid/graphics/drawable/Drawable;", "isBold", "(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;)V", "gravity", "setTitleColor", "setTitleSize", "size", "", Scraps.INNER_UNIT, "setTypeface", "typeface", "Landroid/graphics/Typeface;", "showBackBtn", "showDivider", "show", "showGrabberView", "showGrabberView$OUI_standardRelease", "switchIconStyle", "iconColor", "iconBgColor", "needBg", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "switchToBlackIconStyle", "switchToPadIconStyle", "switchToWhiteIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatImageView f14277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f14278b;
    private final ImageView c;
    private final ODivider d;
    private final View e;
    private final View f;
    private final View g;

    /* JADX INFO: renamed from: com.obric.oui.panel.header.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 6, 0})
    public static final class ViewOnAttachStateChangeListenerC0761a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f14279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f14280b;

        public ViewOnAttachStateChangeListenerC0761a(View r1, a r2) {
            this.f14279a = r1;
            this.f14280b = r2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r6) {
            Intrinsics.checkNotNullParameter(r6, "view");
            this.f14279a.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
            int r7 = h.a(r6, 44);
            o.a(a.a(this.f14280b), r7, r7, new View[]{(View) ZeusTransformUtils.preCheckCast(a.b(this.f14280b), View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(a.c(this.f14280b), View.class, "com.obric.memorydata.plugin")});
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
        }
    }

    public a(Context r3, View.OnClickListener r4, CharSequence r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        this(r6, r7, r8, false);
    }

    public /* synthetic */ a(Context r2, View.OnClickListener r3, CharSequence r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r9 = null;
    L8:
        this(r7, r8, r9);
    }

    public a(Context r10, View.OnClickListener r11, CharSequence r12, boolean r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, View.OnClickListener.class, "com.obric.memorydata.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r13, 0, 4, null);
        View r17 = ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r14, false, 2, null), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_basic_panel_normal_header, "layout", "o_basic_panel_normal_header"), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r17, "inflate(generateThemedCo…anel_normal_header, null)");
        this.g = r17;
        int r18 = com.obric.oui.common.util.b.f13500a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.oui_PanelDefaultHeaderHeight, "attr", "oui_PanelDefaultHeaderHeight"), ZeusTransformUtils.mapRes(R.dimen.oui_panel_default_header_height, "dimen", "oui_panel_default_header_height"));
        r17.setBackgroundColor(0);
        View r2 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.iv_close, OaidModel.KEY_ID, "iv_close"));
        Intrinsics.checkNotNullExpressionValue(r2, "rootView.findViewById(R.id.iv_close)");
        this.f14277a = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r2, AppCompatImageView.class, "com.obric.memorydata.plugin");
        View r3 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "rootView.findViewById(R.id.tv_title)");
        this.f14278b = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin");
        View r4 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.iv_back, OaidModel.KEY_ID, "iv_back"));
        Intrinsics.checkNotNullExpressionValue(r4, "rootView.findViewById(R.id.iv_back)");
        this.c = (ImageView) ZeusTransformUtils.preCheckCast(r4, ImageView.class, "com.obric.memorydata.plugin");
        View r5 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.divider, OaidModel.KEY_ID, "divider"));
        Intrinsics.checkNotNullExpressionValue(r5, "rootView.findViewById(R.id.divider)");
        this.d = (ODivider) ZeusTransformUtils.preCheckCast(r5, ODivider.class, "com.obric.memorydata.plugin");
        View r6 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.grabber, OaidModel.KEY_ID, "grabber"));
        Intrinsics.checkNotNullExpressionValue(r6, "rootView.findViewById(R.id.grabber)");
        this.e = r6;
        View r7 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.main_view, OaidModel.KEY_ID, "main_view"));
        Intrinsics.checkNotNullExpressionValue(r7, "rootView.findViewById(R.id.main_view)");
        this.f = r7;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r8.height = r18;
        r7.setLayoutParams(r8);
        if (r15 == null) goto L6;
        a(r15);
    L6:
        if (TextUtils.isEmpty(r16) == true) goto L9;
        Intrinsics.checkNotNull(r16);
        a(this, r16, null, null, 6, null);
    L9:
        if (ViewCompat.isAttachedToWindow(r17) == false) goto L11;
        int r19 = h.a(r17, 44);
        o.a(a(this), r19, r19, new View[]{(View) ZeusTransformUtils.preCheckCast(b(this), View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(c(this), View.class, "com.obric.memorydata.plugin")});
        return;
    L11:
        r17.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new ViewOnAttachStateChangeListenerC0761a(r17, this), View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ View a(a r0) {
        return r0.g;
    }

    public static /* synthetic */ void a(a r2, CharSequence r3, Drawable r4, Boolean r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
        if ((r6 & 2) == 0) goto L8;
        r4 = null;
    L8:
        if ((r6 & 4) == 0) goto L10;
        r5 = false;
    L10:
        r2.a(r8, r4, r5);
        return;
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
    }

    public static final /* synthetic */ ImageView b(a r0) {
        return r0.c;
    }

    public static final /* synthetic */ AppCompatImageView c(a r0) {
        return r0.f14277a;
    }

    @Override // com.obric.oui.panel.header.c
    public View a() {
        return this.g;
    }

    public final void a(View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.memorydata.plugin");
        o.a((View) ZeusTransformUtils.preCheckCast(this.f14277a, View.class, "com.obric.memorydata.plugin"), h.a((View) ZeusTransformUtils.preCheckCast(this.f14277a, View.class, "com.obric.memorydata.plugin"), 44));
        this.f14277a.setOnClickListener(r6);
    }

    public final void a(CharSequence r3, Drawable r4, Boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "charSequence");
        this.f14278b.setText(r6);
        if (r4 == null) goto L6;
        r4.setBounds(0, 0, 70, 70);
    L6:
        this.f14278b.setCompoundDrawables(r4, null, null, null);
        if (Intrinsics.areEqual(r5, true) == false) goto L10;
        this.f14278b.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }
}
