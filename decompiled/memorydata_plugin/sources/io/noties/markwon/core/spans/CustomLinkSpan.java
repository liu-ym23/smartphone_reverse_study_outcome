package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/noties/markwon/core/spans/CustomLinkSpan;", "Lio/noties/markwon/core/spans/LinkSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "link", "", "resolver", "Lio/noties/markwon/LinkResolver;", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;Lio/noties/markwon/LinkResolver;)V", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "enableLinkStyle", "", "needUnderLine", "getNeedUnderLine", "()Z", "resolverWithStyle", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CustomLinkSpan extends LinkSpan {
    private View.OnClickListener clickListener;
    private final boolean enableLinkStyle;
    private final boolean needUnderLine;
    private final com.larus.business.markdown.api.depend.i resolverWithStyle;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"io/noties/markwon/core/spans/CustomLinkSpan$resolverWithStyle$1", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "enableLinkStyle", "", "link", "", "needUnderline", "resolve", "", "view", "Landroid/view/View;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements com.larus.business.markdown.api.depend.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ io.noties.markwon.d f16443a;

        a(io.noties.markwon.d r3) {
            this.f16443a = (io.noties.markwon.d) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.d.class, "com.obric.memorydata.plugin");
        }

        @Override // com.larus.business.markdown.api.depend.i
        public void a(View r1, String r2, boolean r3) {
            com.larus.business.markdown.api.depend.i.a.a(this, r1, r2, r3);
        }

        @Override // com.larus.business.markdown.api.depend.i
        public boolean a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "link");
            return false;
        }

        @Override // com.larus.business.markdown.api.depend.i
        public boolean b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "link");
            return true;
        }

        @Override // com.larus.business.markdown.api.depend.i, io.noties.markwon.d
        public void resolve(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "link");
            this.f16443a.resolve(r2, r3);
        }
    }

    public CustomLinkSpan(io.noties.markwon.core.c r3, String r4, io.noties.markwon.d r5) {
        io.noties.markwon.d r6 = (io.noties.markwon.d) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.markwon.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "theme");
        Intrinsics.checkNotNullParameter(r4, "link");
        Intrinsics.checkNotNullParameter(r6, "resolver");
        super(r3, r4, r6);
        if (ZeusTransformUtils.instanceOf(r6, com.larus.business.markdown.api.depend.i.class) == false) goto L5;
        com.larus.business.markdown.api.depend.i r7 = (com.larus.business.markdown.api.depend.i) ZeusTransformUtils.preCheckCast(r6, com.larus.business.markdown.api.depend.i.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 != null) goto L8;
        r7 = (com.larus.business.markdown.api.depend.i) ZeusTransformUtils.preCheckCast(new a(r6), com.larus.business.markdown.api.depend.i.class, "com.obric.memorydata.plugin");
    L8:
        this.resolverWithStyle = r7;
        this.needUnderLine = r7.a(r4);
        this.enableLinkStyle = r7.b(r4);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public final boolean getNeedUnderLine() {
        return this.needUnderLine;
    }

    @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        View.OnClickListener r0 = this.clickListener;
        if (r0 == null) goto L5;
        r0.onClick(r4);
    L5:
        com.larus.business.markdown.api.depend.i r1 = this.resolverWithStyle;
        String r2 = getLink();
        Intrinsics.checkNotNullExpressionValue(r2, "link");
        r1.a(r4, r2, this.enableLinkStyle);
    }

    public final void setClickListener(View.OnClickListener r3) {
        this.clickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        if (this.enableLinkStyle == false) goto L6;
        super.updateDrawState(r2);
        return;
    }
}
