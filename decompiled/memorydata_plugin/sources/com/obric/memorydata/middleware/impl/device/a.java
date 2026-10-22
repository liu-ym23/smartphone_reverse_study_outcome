package com.obric.memorydata.middleware.impl.device;

import com.obric.capabilitykit.entity.app.EntityType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/device/SelfCollectionSupportedEntities;", "", "<init>", "()V", "ALL_SUPPORTED_ENTITY_TYPES", "", "", "getALL_SUPPORTED_ENTITY_TYPES", "()Ljava/util/Set;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Integer> f11710b = null;

    static {
        f11709a = new a();
        f11710b = SetsKt.setOf(new Integer[]{Integer.valueOf(EntityType.FILE), 301, 101, 201, 202, 402});
    }

    private a() {
    }

    public final Set<Integer> a() {
        return f11710b;
    }
}
