package com.larus.business.markdown.impl.markwon.custom.title;

import io.noties.markwon.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"TABLE_TITLE_END_INDEX", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getTABLE_TITLE_END_INDEX", "()Lio/noties/markwon/Prop;", "TABLE_TITLE_START_INDEX", "getTABLE_TITLE_START_INDEX", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q<Integer> f5240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q<Integer> f5241b = null;

    static {
        q<Integer> r0 = q.a("table-title-start-index");
        Intrinsics.checkNotNullExpressionValue(r0, "of<Int>(\"table-title-start-index\")");
        f5240a = r0;
        q<Integer> r1 = q.a("table-title-end-index");
        Intrinsics.checkNotNullExpressionValue(r1, "of<Int>(\"table-title-end-index\")");
        f5241b = r1;
    }

    public static final q<Integer> a() {
        return f5240a;
    }

    public static final q<Integer> b() {
        return f5241b;
    }
}
