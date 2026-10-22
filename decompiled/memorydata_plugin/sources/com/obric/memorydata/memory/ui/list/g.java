package com.obric.memorydata.memory.ui.list;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/EntityIdentifier;", "", "type", "", "entityId", "", "<init>", "(ILjava/lang/String;)V", "getType", "()I", "getEntityId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11311b;
    private final String c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0001J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/EntityIdentifier$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/memory/ui/list/EntityIdentifier;", "entity", "metaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final g a(cu r2) {
            Intrinsics.checkNotNullParameter(r2, "metaInfo");
            return new g(r2.getType(), r2.a());
        }

        public final g a(Object r4) {
            Intrinsics.checkNotNullParameter(r4, "entity");
            if (ZeusTransformUtils.instanceOf(r4, MemoryEntity.class) == false) goto L6;
            return new g(NetError.ERR_INVALID_REDIRECT, ((MemoryEntity) ZeusTransformUtils.preCheckCast(r4, MemoryEntity.class, "com.obric.memorydata.plugin")).getId());
        L6:
            if (ZeusTransformUtils.instanceOf(r4, RawMemoryEntity.class) == false) goto L9;
            return new g(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        L9:
            if (ZeusTransformUtils.instanceOf(r4, EpisodicMemoryEntity.class) == false) goto L12;
            return new g(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r4, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r4, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        L12:
            if (ZeusTransformUtils.instanceOf(r4, fj.class) == false) goto L15;
            return new g(((fj) ZeusTransformUtils.preCheckCast(r4, fj.class, "com.obric.memorydata.plugin")).getType(), ((fj) ZeusTransformUtils.preCheckCast(r4, fj.class, "com.obric.memorydata.plugin")).getEntityId());
        L15:
            if (ZeusTransformUtils.instanceOf(r4, AutoMemoryProEntity.class) == true) goto L23;
            return null;
        L23:
            return new g(((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r4, AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getType(), ((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r4, AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        }
    }

    static {
        f11310a = new a(null);
    }

    public g(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        this.f11311b = r2;
        this.c = r3;
    }

    public static /* synthetic */ g a(g r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f11311b;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.c;
    L9:
        return r0.a(r1, r2);
    }

    public final g a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return new g(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (this.f11311b == r6.f11311b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getType() {
        return this.f11311b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f11311b) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "EntityIdentifier(type=" + this.f11311b + ", entityId=" + this.c + ')';
    }
}
