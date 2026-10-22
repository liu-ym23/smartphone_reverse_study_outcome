package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.h;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020*J\b\u0010-\u001a\u00020#H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001e\u0010\u001b¨\u00060"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionDialog;", "Lcom/obric/oui/dialog/base/OBaseDialog;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialog$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/selection/OSelectionDialog$Modifier;)V", "bodyContainerView", "Landroid/view/ViewGroup;", "getBodyContainerView", "()Landroid/view/ViewGroup;", "bodyContainerView$delegate", "Lkotlin/Lazy;", "buttonContainerView", "getButtonContainerView", "buttonContainerView$delegate", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "positiveButton", "getPositiveButton", "positiveButton$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initBody", "", "initButtons", "setContainerView", "view", "Landroid/view/View;", "setSubtitleText", "message", "", "setTitleText", "title", "show", "Companion", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends com.obric.oui.dialog.base.b {
    public static final C0751a e = null;
    private final b f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.selection.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0751a {
        private C0751a() {
        }

        public /* synthetic */ C0751a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fR.\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionDialog$Modifier;", "", "title", "", "subtitle", "bodyCustomizer", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "parent", "Landroid/view/View;", "positiveButton", "Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "negativeButton", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;)V", "getBodyCustomizer", "()Lkotlin/jvm/functions/Function1;", "getNegativeButton", "()Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "getPositiveButton", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f13833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f13834b;
        private final Function1<ViewGroup, View> c;
        private final com.obric.oui.dialog.base.b.a d;
        private final com.obric.oui.dialog.base.b.a e;

        public b(CharSequence r3, CharSequence r4, Function1<? super ViewGroup, ? extends View> r5, com.obric.oui.dialog.base.b.a r6, com.obric.oui.dialog.base.b.a r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            Function1<ViewGroup, View> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "title");
            Intrinsics.checkNotNullParameter(r9, "subtitle");
            this.f13833a = r8;
            this.f13834b = r9;
            this.c = r10;
            this.d = r6;
            this.e = r7;
        }

        public final CharSequence a() {
            return this.f13833a;
        }

        public final CharSequence b() {
            return this.f13834b;
        }

        public final Function1<ViewGroup, View> c() {
            return this.c;
        }

        public final com.obric.oui.dialog.base.b.a d() {
            return this.d;
        }

        public final com.obric.oui.dialog.base.b.a e() {
            return this.e;
        }
    }

    static {
        e = new C0751a(null);
    }

    public a(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "modifier");
        super(r5);
        this.f = r4;
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OSelectionDialog$titleTextView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OSelectionDialog$subtitleTextView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OSelectionDialog$bodyContainerView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.j = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OSelectionDialog$buttonContainerView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OSelectionDialog$positiveButton$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OSelectionDialog$negativeButton$2(this), Function0.class, "com.obric.memorydata.plugin"));
        f().setIncludeFontPadding(true);
        g().setIncludeFontPadding(true);
        a(r4.a());
        b(r4.b());
        y();
        z();
    }

    private static final void a(a r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.f.d().b().invoke();
        if (r0.t() == false) goto L6;
        r0.dismiss();
        return;
    }

    private static final void b(a r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.f.e().b().invoke();
        if (r0.t() == false) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$HNyJDy4b3HdC-iyGuKs2cCcMf9I, reason: not valid java name */
    public static /* synthetic */ void m1289lambda$HNyJDy4b3HdCiyGuKs2cCcMf9I(a r0, View r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Hvn5Me6r66-nPSm69BSL6kROhKU, reason: not valid java name */
    public static /* synthetic */ void m1290lambda$Hvn5Me6r66nPSm69BSL6kROhKU(a r0, View r1) {
        a(r0, r1);
    }

    private final ViewGroup w() {
        Object r2 = this.i.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-bodyContainerView>(...)");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    private final ViewGroup x() {
        Object r2 = this.j.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-buttonContainerView>(...)");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    private final void y() {
        if (this.f.c() == null) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f.c().invoke(w()), View.class, "com.obric.memorydata.plugin");
        w().removeAllViews();
        w().addView(r0);
        return;
    }

    private final void z() {
        if (this.f.d() != null) goto L8;
        if (this.f.e() != null) goto L8;
        x().setVisibility(8);
        return;
    L8:
        if (this.f.d() == null) goto L16;
        u().setVisibility(0);
        u().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f.d().a(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (this.f.d().b() == null) goto L12;
        u().setOnClickListener(new $$Lambda$a$Hvn5Me6r66nPSm69BSL6kROhKU(this));
    L12:
        Function1<OButton, Unit> r0 = this.f.d().c();
        if (r0 == null) goto L18;
        r0.invoke(u());
    L18:
        if (this.f.e() == null) goto L26;
        v().setVisibility(0);
        v().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f.e().a(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (this.f.e().b() == null) goto L22;
        v().setOnClickListener(new $$Lambda$a$HNyJDy4b3HdCiyGuKs2cCcMf9I(this));
    L22:
        Function1<OButton, Unit> r1 = this.f.e().c();
        if (r1 == null) goto L30;
        r1.invoke(v());
        return;
    L30:
        return;
    L26:
        v().setVisibility(8);
        return;
    L16:
        u().setVisibility(8);
        goto L18
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int a() {
        return ZeusTransformUtils.mapRes(R.layout.o_selection_dialog, "layout", "o_selection_dialog");
    }

    public final void a(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "title");
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        f().setVisibility(8);
        ViewGroup.LayoutParams r5 = g().getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = 0;
        return;
    L9:
        OTextView r1 = f();
        r1.setVisibility(0);
        r1.setText(r7);
        ViewGroup.LayoutParams r8 = g().getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        r9.topMargin = h.a(r10, 8);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void b(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        OTextView r3 = g();
        if (r0 == false) goto L9;
        r3.setVisibility(8);
        return;
    L9:
        r3.setVisibility(0);
        r3.setText(r5);
        com.obric.oui.dialog.b.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final OTextView f() {
        Object r2 = this.g.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-titleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    public final OTextView g() {
        Object r2 = this.h.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        if (m() == false) goto L5;
        return;
    L5:
        super.show();
    }

    public final OButton u() {
        Object r2 = this.k.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-positiveButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
    }

    public final OButton v() {
        Object r2 = this.l.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-negativeButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
    }
}
