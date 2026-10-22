package com.obric.oui.common.util;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¨\u0006\r"}, d2 = {"makeLink", "", "Landroid/widget/TextView;", "linkText", "", "linkTextPadding", "", "spanColor", "", "clickActionOnLinkText", "Lkotlin/Function1;", "Landroid/view/View;", "clickActionOnOtherText", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class l {

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/oui/common/util/TextViewExtensionKt$makeLink$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<View, Unit> f13506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13507b;

        a(Function1<? super View, Unit> r3, int r4) {
            this.f13506a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            this.f13507b = r4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            this.f13506a.invoke(r2);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(this.f13507b);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/oui/common/util/TextViewExtensionKt$makeLink$2", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<View, Unit> f13508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f13509b;

        b(Function1<? super View, Unit> r3, TextView r4) {
            this.f13508a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            this.f13509b = r4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            this.f13508a.invoke(r2);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(this.f13509b.getCurrentTextColor());
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/oui/common/util/TextViewExtensionKt$makeLink$3", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<View, Unit> f13510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f13511b;

        c(Function1<? super View, Unit> r3, TextView r4) {
            this.f13510a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            this.f13511b = r4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            this.f13510a.invoke(r2);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(this.f13511b.getCurrentTextColor());
        }
    }

    public static final void a(TextView r9, String r10, float r11, int r12, Function1<? super View, Unit> r13, Function1<? super View, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "linkText");
        Intrinsics.checkNotNullParameter(r15, "clickActionOnLinkText");
        CharSequence r0 = r9.getText();
        SpannableString r8 = new SpannableString(r0);
        Intrinsics.checkNotNullExpressionValue(r0, "originText");
        int r2 = StringsKt.indexOf$default(r0, r10, 0, false, 6, null);
        if (r2 >= 0) goto L6;
        g.b("TextView.makeLink: Link text is not found in TextView.text");
        return;
    L6:
        int r17 = r10.length() + r2;
        r8.setSpan(new a(r15, r12), r2, r17, 33);
        r8.setSpan(new i(h.b((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), r11), r12), r2, r17, 33);
        if (r16 == null) goto L13;
        if (r2 <= 0) goto L11;
        r8.setSpan(new b(r16, r9), 0, r2, 33);
    L11:
        if (r17 >= r0.length()) goto L13;
        r8.setSpan(new c(r16, r9), r17, r0.length() - 1, 33);
    L13:
        r9.setMovementMethod(LinkMovementMethod.getInstance());
        r9.setHighlightColor(0);
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
