package com.obric.search.api.schema.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "sqLiteSearchEngine", "Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "(Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;)V", "getSqLiteSearchEngine", "()Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements com.obric.search.api.schema.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.search.storage.sqlite.a f14943a;

    public a(com.obric.search.storage.sqlite.a r2) {
        Intrinsics.checkNotNullParameter(r2, "sqLiteSearchEngine");
        this.f14943a = r2;
    }

    public final com.obric.search.storage.sqlite.a a() {
        return this.f14943a;
    }
}
