package com.obric.search.api.c;

import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/search/api/migration/AddFullTextSearchSchemaAction;", "Lcom/obric/search/api/migration/IMigrationAction;", "schemaList", "", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "(Ljava/util/List;)V", "getSchemaList", "()Ljava/util/List;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<FullTextSearchSchema> f14930a;

    public b(List<FullTextSearchSchema> r3) {
        List<FullTextSearchSchema> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "schemaList");
        this.f14930a = r4;
    }

    public final List<FullTextSearchSchema> a() {
        return this.f14930a;
    }
}
