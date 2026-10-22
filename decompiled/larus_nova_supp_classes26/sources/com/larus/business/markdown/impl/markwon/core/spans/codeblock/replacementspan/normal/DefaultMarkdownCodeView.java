package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import lsc.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0002R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView;", "Landroid/widget/FrameLayout;", "", "getLanguage", "getCode", "", "getFinishState", "Landroid/widget/TextView;", "getMarkdownTextView", "Letc/b;", "b", "Lkotlin/Lazy;", "getHighlight", "()Letc/b;", "highlight", "d", "Ljava/lang/String;", "getCurrentCode", "()Ljava/lang/String;", "setCurrentCode", "(Ljava/lang/String;)V", "currentCode", "e", "getCurrentLanguage", "setCurrentLanguage", "currentLanguage", "f", "Z", "isFinish", "()Z", "setFinish", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultMarkdownCodeView extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public final TextView a;
    public final Lazy b;
    public final int c;
    public String d;
    public String e;
    public boolean f;
    public final CoroutineScope g;

    public static final class a {
    }

    static {
    }

    public DefaultMarkdownCodeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DefaultMarkdownCodeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final etc.b getHighlight() {
        return (etc.b) this.b.getValue();
    }

    private final TextView getMarkdownTextView() {
        return this.a;
    }

    public final String getCode() {
        return this.d;
    }

    public final String getCurrentCode() {
        return this.d;
    }

    public final String getCurrentLanguage() {
        return this.e;
    }

    public final boolean getFinishState() {
        return this.f;
    }

    public final String getLanguage() {
        return this.e;
    }

    public static final /* synthetic */ etc.b a(DefaultMarkdownCodeView r0) {
        return r0.getHighlight();
    }

    public final void setCurrentCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setCurrentLanguage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setFinish(boolean r1) {
        this.f = r1;
    }

    public final void b(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "code");
        Intrinsics.checkNotNullParameter(r8, "language");
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        setVisibility(8);
        return;
    L10:
        String r9 = StringsKt.substringBefore$default(r8, " ", null, 2, null);
        if (Intrinsics.areEqual(r9, "STDOUT") == false) goto L14;
        setVisibility(8);
        return;
    L14:
        setVisibility(0);
        this.d = r7;
        this.e = r9;
        this.f = true;
        int r10 = rw8.a.a;
        String r11 = rw8.a.a(r7, this.c);
        getMarkdownTextView().setText(new y(getHighlight().a(this.e, r11)).h());
        TextView r12 = getMarkdownTextView();
        if (this.f == false) goto L17;
        int r13 = 48;
    L19:
        if ((r12.getGravity() & 112) == r13) goto L22;
        r12.setGravity(r13 | (r12.getGravity() & 7));
        r12.requestLayout();
        return;
    L22:
        return;
    L17:
        r13 = 80;
        goto L19
    L5:
        r0 = false;
        goto L7
    }

    public DefaultMarkdownCodeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new TextView(r2);
        this.b = LazyKt.lazy(DefaultMarkdownCodeView$highlight$2.INSTANCE);
        ((Number) MarkdownDimensExtKt.T.getValue()).intValue();
        this.c = 20;
        this.d = "";
        this.e = "";
        this.g = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b())).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public /* synthetic */ DefaultMarkdownCodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
