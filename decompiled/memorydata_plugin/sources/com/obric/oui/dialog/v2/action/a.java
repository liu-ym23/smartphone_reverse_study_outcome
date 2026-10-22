package com.obric.oui.dialog.v2.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020 R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0015\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/oui/dialog/v2/action/OActionDialog;", "Lcom/obric/oui/dialog/base/OBaseDialog;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/action/OActionDialog$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/action/OActionDialog$Modifier;)V", "bodyContainerView", "Landroid/view/ViewGroup;", "getBodyContainerView", "()Landroid/view/ViewGroup;", "bodyContainerView$delegate", "Lkotlin/Lazy;", "getModifier", "()Lcom/obric/oui/dialog/v2/action/OActionDialog$Modifier;", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initBody", "", "setContainerView", "view", "Landroid/view/View;", "setSubtitleText", "message", "", "setTitleText", "title", "Companion", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends com.obric.oui.dialog.base.b {
    public static final C0748a e = null;
    private final b f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.action.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/action/OActionDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0748a {
        private C0748a() {
        }

        public /* synthetic */ C0748a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fR.\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/dialog/v2/action/OActionDialog$Modifier;", "", "title", "", "subtitle", "bodyCustomizer", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "parent", "Landroid/view/View;", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "getBodyCustomizer", "()Lkotlin/jvm/functions/Function1;", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f13818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f13819b;
        private final Function1<ViewGroup, View> c;

        public b(CharSequence r3, CharSequence r4, Function1<? super ViewGroup, ? extends View> r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            Function1<ViewGroup, View> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "title");
            Intrinsics.checkNotNullParameter(r7, "subtitle");
            this.f13818a = r6;
            this.f13819b = r7;
            this.c = r8;
        }

        public final CharSequence a() {
            return this.f13818a;
        }

        public final CharSequence b() {
            return this.f13819b;
        }

        public final Function1<ViewGroup, View> c() {
            return this.c;
        }
    }

    static {
        e = new C0748a(null);
    }

    public a(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "modifier");
        super(r5);
        this.f = r4;
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OActionDialog$titleTextView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OActionDialog$subtitleTextView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OActionDialog$bodyContainerView$2(this), Function0.class, "com.obric.memorydata.plugin"));
        f().setIncludeFontPadding(true);
        g().setIncludeFontPadding(true);
        a(r4.a());
        b(r4.b());
        v();
        a(true);
    }

    private final ViewGroup u() {
        Object r2 = this.i.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-bodyContainerView>(...)");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    private final void v() {
        if (this.f.c() == null) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f.c().invoke(u()), View.class, "com.obric.memorydata.plugin");
        u().removeAllViews();
        u().addView(r0);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int a() {
        return ZeusTransformUtils.mapRes(R.layout.o_action_dialog, "layout", "o_action_dialog");
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
        OTextView r8 = g();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 8);
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
}
