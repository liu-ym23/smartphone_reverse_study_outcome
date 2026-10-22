package com.larus.business.markdown.impl.markwon;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/SpannedIndex;", "", "span", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "(Ljava/lang/Object;II)V", "getEnd", "()I", "getSpan", "()Ljava/lang/Object;", "getStart", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f5256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5257b;
    private final int c;

    public h(Object r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "span");
        this.f5256a = r2;
        this.f5257b = r3;
        this.c = r4;
    }

    public final int a() {
        return this.f5257b;
    }

    public final int b() {
        return this.c;
    }
}
