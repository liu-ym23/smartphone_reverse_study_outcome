package com.larus.business.markdown.impl.common;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.larus.business.markdown.api.depend.i;
import com.larus.business.markdown.impl.common.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u00010\u0019JS\u00103\u001a\u00020!2K\u00104\u001aG\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110 ¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020!0\u001dJ\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020%R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cRR\u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001d2 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "", "()V", "astModifier", "Lcom/larus/business/markdown/impl/markwon/ASTModifier;", "getAstModifier", "()Lcom/larus/business/markdown/impl/markwon/ASTModifier;", "astModifier$delegate", "Lkotlin/Lazy;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "getDrawableLruPool", "()Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "drawableLruPool$delegate", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "getDrawablePool", "()Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawablePool$delegate", "imageSize", "Landroid/graphics/Rect;", "getImageSize", "()Landroid/graphics/Rect;", "imageSize$delegate", "<set-?>", "Lio/noties/markwon/inject/IInjectParser;", "injectMarkdownParser", "getInjectMarkdownParser", "()Lio/noties/markwon/inject/IInjectParser;", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "", "markdownLinkResolver", "getMarkdownLinkResolver", "()Lkotlin/jvm/functions/Function3;", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "markdownLinkResolverV2", "getMarkdownLinkResolverV2", "()Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "settings", "Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "getSettings", "()Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "settings$delegate", CommonConsts.APM_INNER_EVENT_COST_INIT, "config", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "registerInjectMarkdownParser", "injectParser", "registerLinkResolver", "resolver", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "link", "isFromWiki", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f5169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function3<? super View, ? super String, ? super Boolean, Unit> f5170b;
    private i c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private io.noties.markwon.b.a h;

    public a() {
        this.f5169a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownConfigManager$settings$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownConfigManager$drawablePool$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkdownConfigManager$drawableLruPool$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownConfigManager$imageSize$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownConfigManager$astModifier$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public final d a() {
        return (d) ZeusTransformUtils.preCheckCast(this.f5169a.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    public final void a(com.larus.business.markdown.api.depend.c r3) {
        com.larus.business.markdown.api.depend.c r4 = (com.larus.business.markdown.api.depend.c) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.depend.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "config");
        a().a(r4.a());
        g().a(a().b());
        g().b(a().a().a());
    }

    public final void a(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "resolver");
        this.c = r4;
    }

    public final void a(io.noties.markwon.b.a r3) {
        this.h = (io.noties.markwon.b.a) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.b.a.class, "com.obric.memorydata.plugin");
    }

    public final void a(Function3<? super View, ? super String, ? super Boolean, Unit> r3) {
        Function3<? super View, ? super String, ? super Boolean, Unit> r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "resolver");
        this.f5170b = r4;
    }

    public final Function3<View, String, Boolean, Unit> b() {
        return this.f5170b;
    }

    public final i c() {
        return this.c;
    }

    public final com.larus.business.markdown.api.b.c d() {
        return (com.larus.business.markdown.api.b.c) ZeusTransformUtils.preCheckCast(this.d.getValue(), com.larus.business.markdown.api.b.c.class, "com.obric.memorydata.plugin");
    }

    public final com.larus.business.markdown.api.b.b e() {
        return (com.larus.business.markdown.api.b.b) ZeusTransformUtils.preCheckCast(this.e.getValue(), com.larus.business.markdown.api.b.b.class, "com.obric.memorydata.plugin");
    }

    public final Rect f() {
        return (Rect) ZeusTransformUtils.preCheckCast(this.f.getValue(), Rect.class, "com.obric.memorydata.plugin");
    }

    public final com.larus.business.markdown.impl.markwon.a g() {
        return (com.larus.business.markdown.impl.markwon.a) ZeusTransformUtils.preCheckCast(this.g.getValue(), com.larus.business.markdown.impl.markwon.a.class, "com.obric.memorydata.plugin");
    }

    public final io.noties.markwon.b.a h() {
        return this.h;
    }
}
