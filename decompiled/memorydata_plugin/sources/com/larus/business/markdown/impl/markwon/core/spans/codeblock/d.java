package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import io.noties.markwon.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"7\u0010\u0006\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00070\u00070\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\f0\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0005\"\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"CODE_BLOCK_END_INDEX", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getCODE_BLOCK_END_INDEX", "()Lio/noties/markwon/Prop;", "CODE_BLOCK_LINE_NUMBER_MAP", "", "getCODE_BLOCK_LINE_NUMBER_MAP", "CODE_BLOCK_MAX_LINE", "getCODE_BLOCK_MAX_LINE", "CODE_BLOCK_SCROLLABLE", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "getCODE_BLOCK_SCROLLABLE", "CODE_BLOCK_START_INDEX", "getCODE_BLOCK_START_INDEX", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q<Integer> f5206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q<Integer> f5207b = null;
    private static final q<io.noties.markwon.scrollable.b> c = null;
    private static final q<Integer> d = null;
    private static final q<Map<Integer, Integer>> e = null;

    static {
        q<Integer> r0 = q.a("code-block-start-index");
        Intrinsics.checkNotNullExpressionValue(r0, "of<Int>(\"code-block-start-index\")");
        f5206a = r0;
        q<Integer> r1 = q.a("code-block-end-index");
        Intrinsics.checkNotNullExpressionValue(r1, "of<Int>(\"code-block-end-index\")");
        f5207b = r1;
        q<io.noties.markwon.scrollable.b> r2 = q.a("code-block-scrollable");
        Intrinsics.checkNotNullExpressionValue(r2, "of<HorizontalScrollable>(\"code-block-scrollable\")");
        c = r2;
        q<Integer> r3 = q.a("code-block-max-line");
        Intrinsics.checkNotNullExpressionValue(r3, "of<Int>(\"code-block-max-line\")");
        d = r3;
        q<Map<Integer, Integer>> r4 = q.a("code-block-line-number-map");
        Intrinsics.checkNotNullExpressionValue(r4, "of<Map<Int, Int>>(\"code-block-line-number-map\")");
        e = r4;
    }

    public static final q<Integer> a() {
        return f5206a;
    }

    public static final q<Integer> b() {
        return f5207b;
    }

    public static final q<io.noties.markwon.scrollable.b> c() {
        return c;
    }

    public static final q<Integer> d() {
        return d;
    }

    public static final q<Map<Integer, Integer>> e() {
        return e;
    }
}
