package com.larus.business.markdown.api.b;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ)\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\u00020\u000b*\u00020\u000fH\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "", "maxSize", "", "(I)V", "lastCreateIsDarkMode", "", "Ljava/lang/Boolean;", "pool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawableLruCache;", "clear", "", "obtain", "Lio/noties/markwon/image/AsyncDrawable;", "context", "Landroid/content/Context;", "urlKey", "", "order", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)Lio/noties/markwon/image/AsyncDrawable;", "recycle", "drawable", "(Lio/noties/markwon/image/AsyncDrawable;Ljava/lang/Integer;)V", "updateCacheStatus", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5145a;

    public b() {
        this(0, 1, null);
    }

    public b(int r2) {
        this.f5145a = new a(r2);
    }

    public /* synthetic */ b(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 20;
    L5:
        this(r1);
    }

    public final void a() {
        this.f5145a.evictAll();
    }
}
