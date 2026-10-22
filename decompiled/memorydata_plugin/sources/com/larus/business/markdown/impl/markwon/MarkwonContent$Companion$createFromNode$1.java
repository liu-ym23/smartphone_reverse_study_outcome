package com.larus.business.markdown.impl.markwon;

import android.app.Application;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.ext.tables.k;
import io.noties.markwon.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class MarkwonContent$Companion$createFromNode$1 extends Lambda implements Function0<e> {
    final /* synthetic */ Function1<com.larus.business.markdown.api.model.i, Unit> $callBack;
    final /* synthetic */ com.larus.business.markdown.api.model.c $customMarkDownInfo;
    final /* synthetic */ boolean $finished;
    final /* synthetic */ com.larus.business.markdown.impl.common.a $markdownConfigManager;
    final /* synthetic */ com.larus.business.markdown.api.c.a.a $markdownTextView;
    final /* synthetic */ Node $node;
    final /* synthetic */ Map<String, Object> $payload;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016¨\u0006\t"}, d2 = {"com/larus/business/markdown/impl/markwon/MarkwonContent$Companion$createFromNode$1$markdownSpan$1", "Lio/noties/markwon/RenderCallback;", "handle", "", "nodeInfo", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<HashMap<String, Integer>> f5183a;

        a(Ref.ObjectRef<HashMap<String, Integer>> r1) {
            this.f5183a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.noties.markwon.s
        public void a(HashMap<String, Integer> r1) {
            this.f5183a.element = r1;
        }
    }

    MarkwonContent$Companion$createFromNode$1(com.larus.business.markdown.api.c.a.a r3, com.larus.business.markdown.impl.common.a r4, boolean r5, com.larus.business.markdown.api.model.c r6, Map<String, ? extends Object> r7, Node r8, Function1<? super com.larus.business.markdown.api.model.i, Unit> r9) {
        com.larus.business.markdown.api.c.a.a r10 = (com.larus.business.markdown.api.c.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.c.a.a.class, "com.obric.memorydata.plugin");
        Map<String, Object> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Function1<com.larus.business.markdown.api.model.i, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        this.$markdownTextView = r10;
        this.$markdownConfigManager = r4;
        this.$finished = r5;
        this.$customMarkDownInfo = r6;
        this.$payload = r11;
        this.$node = r8;
        this.$callBack = r12;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final e invoke() {
        com.larus.business.markdown.api.c.a.a r1 = this.$markdownTextView;
        Integer r2 = null;
        if (r1 == null) goto L5;
        TextView r3 = r1.asTextView();
    L7:
        if (r3 == null) goto L10;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
    L13:
        long r5 = System.currentTimeMillis();
        com.larus.business.markdown.api.c.a.a r7 = this.$markdownTextView;
        if (r7 == null) goto L19;
        TextView r8 = r7.asTextView();
        if (r8 == null) goto L19;
        r2 = Integer.valueOf((this.$markdownTextView.getMarkdownWidth() - r8.getPaddingStart()) - r8.getPaddingEnd());
    L19:
        if (this.$finished == false) goto L21;
        g r6 = f.a(r4, this.$markdownConfigManager, r2, this.$customMarkDownInfo, this.$payload);
    L22:
        long r9 = System.currentTimeMillis();
        io.noties.markwon.html.e.f16564a.a(false);
        e.a.a(e.f5244a, r3, this.$markdownConfigManager.f());
        if (this.$finished == true) goto L25;
        this.$markdownConfigManager.g().a(this.$node);
    L25:
        long r10 = System.currentTimeMillis();
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        Spanned r12 = r6.a().a(this.$node, r3, (s) ZeusTransformUtils.preCheckCast(new a(r11), s.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        SpannableStringBuilder r13 = (SpannableStringBuilder) ZeusTransformUtils.preCheckCast(r12, SpannableStringBuilder.class, "com.obric.memorydata.plugin");
        long r14 = System.currentTimeMillis();
        Function1<com.larus.business.markdown.api.model.i, Unit> r15 = this.$callBack;
        if (r15 == null) goto L29;
        r15.invoke(new com.larus.business.markdown.api.model.i(Long.valueOf(r9 - r5), null, Long.valueOf(r14 - r10), 2, null));
    L29:
        return new e(r13, e.a.a(e.f5244a, (Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin"), k.class), io.noties.markwon.html.e.f16564a.a(), e.a.a(e.f5244a, (Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin"), io.noties.markwon.core.spans.e.class), this.$node, (com.larus.business.markdown.api.model.e) ZeusTransformUtils.preCheckCast(r6, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin"), null, (HashMap) ZeusTransformUtils.preCheckCast(r11.element, HashMap.class, "com.obric.memorydata.plugin"), this.$finished);
    L21:
        r6 = f.b(r4, this.$markdownConfigManager, r2, this.$customMarkDownInfo, this.$payload);
    L10:
        Application r16 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.larus.business.markdown.api.a.f5138a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L30;
        r4 = (Context) ZeusTransformUtils.preCheckCast(r16, Context.class, "com.obric.memorydata.plugin");
        goto L13
    L30:
        com.larus.business.markdown.api.model.h r0 = e.f5244a.a(this.$markdownConfigManager, "");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.business.markdown.impl.markwon.MarkwonContent");
        return (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");
    L5:
        r3 = null;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ e invoke() {
        return invoke();
    }
}
