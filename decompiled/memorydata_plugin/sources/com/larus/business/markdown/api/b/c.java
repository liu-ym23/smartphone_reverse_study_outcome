package com.larus.business.markdown.api.b;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bJ\f\u0010\u0012\u001a\u00020\n*\u00020\rH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "", "()V", "lastCreateIsDarkMode", "", "Ljava/lang/Boolean;", "pool", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lio/noties/markwon/image/AsyncDrawable;", "clear", "", "obtain", "context", "Landroid/content/Context;", "predict", "Lkotlin/Function1;", "recycle", "drawable", "updateCacheStatus", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<io.noties.markwon.a.a> f5146a;

    public c() {
        this.f5146a = new CopyOnWriteArrayList();
    }

    public final void a() {
        this.f5146a.clear();
    }

    public final void a(io.noties.markwon.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.f5146a.add(r2);
    }
}
