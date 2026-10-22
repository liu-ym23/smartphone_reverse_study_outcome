package io.noties.markwon.ext.a;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.business.markdown.api.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.a.d;
import io.noties.markwon.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/ext/drawable/ReuseAsyncDrawablePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "clearDrawablePoolAfterRender", "", "(Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;Z)V", "afterRender", "", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "afterSetText", "textView", "Landroid/widget/TextView;", "beforeRender", "reuseCharSequence", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0861a f16488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f16489b;
    private final boolean c;

    /* JADX INFO: renamed from: io.noties.markwon.ext.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lio/noties/markwon/ext/drawable/ReuseAsyncDrawablePlugin$Companion;", "", "()V", "getAsyncDrawableSpans", "", "Lio/noties/markwon/image/AsyncDrawableSpan;", "cs", "", "(Ljava/lang/CharSequence;)[Lio/noties/markwon/image/AsyncDrawableSpan;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0861a {
        private C0861a() {
        }

        public /* synthetic */ C0861a(DefaultConstructorMarker r1) {
            this();
        }

        public final d[] a(CharSequence r4) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cs");
            if (r3.length() <= 0) goto L5;
            boolean r5 = true;
        L7:
            if (r5 == true) goto L9;
            Object r6 = ZeusTransformUtils.preCheckCast(null, d[].class, "com.obric.memorydata.plugin");
        L16:
            return (d[]) r6;
        L9:
            if (ZeusTransformUtils.instanceOf(r3, Spanned.class) == false) goto L11;
            Spanned r7 = (Spanned) ZeusTransformUtils.preCheckCast(r3, Spanned.class, "com.obric.memorydata.plugin");
        L12:
            if (r7 == null) goto L17;
            r6 = ZeusTransformUtils.preCheckCast(r7.getSpans(0, r3.length(), d.class), d[].class, "com.obric.memorydata.plugin");
            goto L16
        L17:
            return null;
        L11:
            r7 = null;
            goto L12
        L5:
            r5 = false;
            goto L7
        }
    }

    static {
        f16488a = new C0861a(null);
    }

    public a(c r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "drawablePool");
        this.f16489b = r2;
        this.c = r3;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        if (this.c == true) goto L6;
        this.f16489b.a();
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r5, Node r6) {
        Intrinsics.checkNotNullParameter(r6, "node");
        if (r5 == null) goto L9;
        C0861a r7 = f16488a;
        CharSequence r8 = r5.getText();
        Intrinsics.checkNotNullExpressionValue(r8, "textView.text");
        d[] r9 = r7.a(r8);
        if (r9 == null) goto L11;
        int r10 = r9.length;
        int r0 = 0;
    L7:
        if (r0 >= r10) goto L12;
        d r1 = r9[r0];
        c r2 = this.f16489b;
        io.noties.markwon.a.a r3 = r1.a();
        Intrinsics.checkNotNullExpressionValue(r3, "it.drawable");
        r2.a(r3);
        r0 = r0 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(CharSequence r5, Node r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "node");
        if (r7 == null) goto L9;
        d[] r8 = f16488a.a(r7);
        if (r8 == null) goto L11;
        int r9 = r8.length;
        int r0 = 0;
    L7:
        if (r0 >= r9) goto L12;
        d r1 = r8[r0];
        c r2 = this.f16489b;
        io.noties.markwon.a.a r3 = r1.a();
        Intrinsics.checkNotNullExpressionValue(r3, "it.drawable");
        r2.a(r3);
        r0 = r0 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // io.noties.markwon.a
    public void a(Node r3, n r4) {
        n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if (this.c == false) goto L6;
        this.f16489b.a();
        return;
    }
}
