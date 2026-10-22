package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.memorydata.database.entity.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem;", "", "<init>", "()V", "stableId", "", "getStableId", "()J", "DayTitle", "MemoryCard", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem$DayTitle;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem$MemoryCard;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class c {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem$DayTitle;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem;", "title", "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "stableId", "", "getStableId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10701a;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            super(null);
            this.f10701a = r2;
        }

        @Override // com.obric.memorydata.memory.ui.automemory.memorylist.c
        public long a() {
            return (((long) this.f10701a.hashCode()) & 2147483647L) - Long.MIN_VALUE;
        }

        public final String b() {
            return this.f10701a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10701a, r6.f10701a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10701a.hashCode();
        }

        public String toString() {
            return "DayTitle(title=" + this.f10701a + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem$MemoryCard;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem;", "entity", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "positionInGroup", "", "groupSize", "hasGroupBottomGap", "", "<init>", "(Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;IIZ)V", "getEntity", "()Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "getPositionInGroup", "()I", "getGroupSize", "getHasGroupBottomGap", "()Z", "stableId", "", "getStableId", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y f10702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10703b;
        private final int c;
        private final boolean d;

        public b(y r2, int r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "entity");
            super(null);
            this.f10702a = r2;
            this.f10703b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // com.obric.memorydata.memory.ui.automemory.memorylist.c
        public long a() {
            return this.f10702a.a();
        }

        public final y b() {
            return this.f10702a;
        }

        public final int c() {
            return this.f10703b;
        }

        public final int d() {
            return this.c;
        }

        public final boolean e() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10702a, r6.f10702a) == true) goto L12;
            return false;
        L12:
            if (this.f10703b == r6.f10703b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f10702a.hashCode() * 31) + Integer.hashCode(this.f10703b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "MemoryCard(entity=" + this.f10702a + ", positionInGroup=" + this.f10703b + ", groupSize=" + this.c + ", hasGroupBottomGap=" + this.d + ')';
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker r1) {
        this();
    }

    public abstract long a();
}
