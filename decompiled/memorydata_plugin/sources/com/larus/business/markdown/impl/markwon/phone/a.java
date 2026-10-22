package com.larus.business.markdown.impl.markwon.phone;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.k;
import io.noties.markwon.n;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneNumberLinkPlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "phoneNumberConfig", "Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "isLoading", "Lkotlin/Function0;", "", "(Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lkotlin/jvm/functions/Function0;)V", "isHighlightEnabled", "()Z", "isHighlightEnabled$delegate", "Lkotlin/Lazy;", "configure", "", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "PhoneNumberMarker", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PhoneNumberConfig f5258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Boolean> f5259b;
    private final Lazy c;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.phone.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u008a\u0084\u0002"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneNumberLinkPlugin$PhoneNumberMarker;", "Lio/noties/markwon/core/CorePlugin$AdvancedOnTextAddedListener;", "phoneNumberConfig", "Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "isLoading", "Lkotlin/Function0;", "", "(Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lkotlin/jvm/functions/Function0;)V", "onTextAdded", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "node", "Lorg/commonmark/node/Text;", CommonConsts.APM_INNER_EVENT_COST_START, "", "markdown-impl_release", "factory", "Lio/noties/markwon/SpanFactory;"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class C0220a implements io.noties.markwon.core.a.InterfaceC0858a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PhoneNumberConfig f5260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function0<Boolean> f5261b;

        public C0220a(PhoneNumberConfig r3, Function0<Boolean> r4) {
            Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "isLoading");
            this.f5260a = r3;
            this.f5261b = r5;
        }

        private static final w a(Lazy<? extends w> r2) {
            return (w) ZeusTransformUtils.preCheckCast(((Lazy) ZeusTransformUtils.wrapperContextForParams(r2, Lazy.class, "com.obric.memorydata.plugin")).getValue(), w.class, "com.obric.memorydata.plugin");
        }

        @Override // io.noties.markwon.core.a.InterfaceC0858a
        public void a(n r9, Text r10, int r11) {
            final n r12 = (n) ZeusTransformUtils.wrapperContextForParams(r9, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "visitor");
            Intrinsics.checkNotNullParameter(r10, "node");
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.f5261b.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
            return;
        L5:
            PhoneNumberConfig r0 = this.f5260a;
            if (r0 == null) goto L24;
            Function1<String, String> r1 = r0.getLinkGenerator();
            if (r1 == null) goto L34;
            Node r2 = r10.parent;
        L11:
            if (r2 == null) goto L16;
            if (ZeusTransformUtils.instanceOf(r2, Link.class) == true) goto L14;
            r2 = r2.parent;
            goto L11
        L14:
            return;
        L16:
            Lazy r3 = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new PhoneNumberLinkPlugin$PhoneNumberMarker$onTextAdded$factory$2(r12), Function0.class, "com.obric.memorydata.plugin"));
            com.larus.business.markdown.impl.markwon.phone.b r4 = com.larus.business.markdown.impl.markwon.phone.b.f5263a;
            String r13 = r10.getLiteral();
            Intrinsics.checkNotNullExpressionValue(r13, "node.literal");
            Iterator<com.larus.business.markdown.impl.markwon.phone.b.a> r8 = r4.a(r13, this.f5260a.getPhoneRegex()).iterator();
        L18:
            if (r8.hasNext() == false) goto L35;
            com.larus.business.markdown.impl.markwon.phone.b.a r14 = (com.larus.business.markdown.impl.markwon.phone.b.a) ZeusTransformUtils.preCheckCast(r8.next(), com.larus.business.markdown.impl.markwon.phone.b.a.class, "com.obric.memorydata.plugin");
            int r5 = r14.a() + r11;
            int r6 = r14.b() + r11;
            String r15 = r14.c();
            CoreProps.g.b(r12.b(), r1.invoke(r15));
            io.noties.markwon.core.b.f16425a.a().b(r12.b(), r15);
            w r16 = a(r3);
            if (r16 == null) goto L18;
            Object r17 = r16.a(r12.a(), r12.b());
            if (r17 == null) goto L18;
            x.a(r12.c(), r17, r5, r6);
            goto L18
        L35:
            return;
        L34:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "corePlugin", "Lio/noties/markwon/core/CorePlugin;", "apply"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b<P extends k> implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f5262a;

        b(a r1) {
            this.f5262a = r1;
        }

        public final void a(io.noties.markwon.core.a r3) {
            Intrinsics.checkNotNullParameter(r3, "corePlugin");
            r3.a((io.noties.markwon.core.a.InterfaceC0858a) ZeusTransformUtils.preCheckCast(new C0220a(a.a(this.f5262a), a.b(this.f5262a)), io.noties.markwon.core.a.InterfaceC0858a.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.noties.markwon.k.a
        public /* synthetic */ void a(k r3) {
            a((io.noties.markwon.core.a) ZeusTransformUtils.preCheckCast((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin"), io.noties.markwon.core.a.class, "com.obric.memorydata.plugin"));
        }
    }

    public a(PhoneNumberConfig r3, Function0<Boolean> r4) {
        Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "isLoading");
        this.f5258a = r3;
        this.f5259b = r5;
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new PhoneNumberLinkPlugin$isHighlightEnabled$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ PhoneNumberConfig a(a r0) {
        return r0.f5258a;
    }

    private final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.c.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static final /* synthetic */ Function0 b(a r0) {
        return r0.f5259b;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(k.b r4) {
        k.b r5 = (k.b) ZeusTransformUtils.wrapperContextForParams(r4, k.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "registry");
        if (a() == true) goto L5;
        return;
    L5:
        r5.a(io.noties.markwon.core.a.class, (k.a) ZeusTransformUtils.preCheckCast(new b(this), k.a.class, "com.obric.memorydata.plugin"));
    }
}
