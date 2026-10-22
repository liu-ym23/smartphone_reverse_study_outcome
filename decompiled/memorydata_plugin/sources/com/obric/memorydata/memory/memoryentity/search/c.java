package com.obric.memorydata.memory.memoryentity.search;

import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", TrackerImpl.PARAMS, "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "categoryOverride", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "<init>", "(Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;Ljava/util/List;Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;)V", "getEntity", "()Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getParams", "()Ljava/util/List;", EventBody.KEY_CATEGORY, "getCategory", "()Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f10328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<InAppSearchEntityParam> f10329b;
    private final MemorySearchResultCategory c;

    public c(d r3, List<InAppSearchEntityParam> r4, MemorySearchResultCategory r5) {
        List<InAppSearchEntityParam> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
        this.f10328a = r3;
        this.f10329b = r6;
        if (r5 != null) goto L5;
        r5 = MemorySearchResultCategory.Companion.a(r3);
    L5:
        this.c = r5;
    }

    public /* synthetic */ c(d r2, List r3, MemorySearchResultCategory r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r2, r7, r4);
    }

    public final d a() {
        return this.f10328a;
    }

    public final MemorySearchResultCategory b() {
        return this.c;
    }
}
