package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.depend.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lsc.i;
import lw8.h;
import lw8.l;
import ow8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000f\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Low8/a;", "Llw8/l;", "content", "", "setMarkdown", "", "getSelectedColor", "d", "I", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markdownWidth", "getMarkdownContent", "()Llw8/l;", "markdownContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class MarkdownTextView extends UnderlineTextView implements a {
    public int d;
    public MarkwonContent e;

    public MarkdownTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MarkdownTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // ow8.a
    public int getSelectedColor() {
        return 1719254015;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ow8.a
    public final TextView o() {
        return this;
    }

    @Override // ow8.a
    public final boolean q(int r1, int r2) {
        return false;
    }

    @Override // ow8.a
    public l getMarkdownContent() {
        return this.e;
    }

    @Override // ow8.a
    public int getMarkdownWidth() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMarkdown(l r5) {
        if (r5 == null) goto L11;
        if ((r5 instanceof MarkwonContent) == true) goto L11;
        d r1 = IMarkdownLoggerKt.a();
        if (r1 == null) goto L13;
        r1.e("mark_down", "unsupport markdown: " + r5);
    L13:
        MarkwonContent r6 = null;
    L14:
        this.e = r6;
        if (r6 == null) goto L25;
        SpannableStringBuilder r2 = r6.a;
        if (r2 == null) goto L28;
        h r7 = r6.f;
        if (r7 == null) goto L26;
        i r8 = r7.a();
        if (r8 == null) goto L27;
        r8.d(this, r2, null);
        return;
    L27:
        return;
    L26:
        return;
    L28:
        return;
    L25:
        return;
    L11:
        if ((r5 instanceof MarkwonContent) == false) goto L13;
        r6 = (MarkwonContent) r5;
        goto L14
    }

    public void setMarkdownWidth(int r1) {
        this.d = r1;
    }

    public MarkdownTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ MarkdownTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
