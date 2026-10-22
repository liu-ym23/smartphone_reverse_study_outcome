package com.obric.memorydata.memory.ui.list;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "", "<init>", "()V", "Header", "Content", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Content;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Header;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class bc {

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J]\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001c¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Content;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", OaidModel.KEY_ID, "", "displayText", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "changeSeq", "", "cardPos", "", "logId", "categoryLabel", "isMock", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;JILjava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getDisplayText", "getMemoryEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getChangeSeq", "()J", "getCardPos", "()I", "getLogId", "getCategoryLabel", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends bc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11224b;
        private final MemoryEntity c;
        private final long d;
        private final int e;
        private final String f;
        private final String g;
        private final boolean h;

        public a(String r2, String r3, MemoryEntity r4, long r5, int r7, String r8, String r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r3, "displayText");
            Intrinsics.checkNotNullParameter(r4, "memoryEntity");
            super(null);
            this.f11223a = r2;
            this.f11224b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }

        public /* synthetic */ a(String r14, String r15, MemoryEntity r16, long r17, int r19, String r20, String r21, boolean r22, int r23, DefaultConstructorMarker r24) {
            if ((r23 & 16) == 0) goto L5;
            int r9 = 0;
        L7:
            if ((r23 & 32) == 0) goto L9;
            String r10 = null;
        L11:
            if ((r23 & 64) == 0) goto L13;
            String r11 = null;
        L15:
            if ((r23 & 128) == 0) goto L17;
            boolean r12 = false;
        L18:
            this(r14, r15, r16, r17, r9, r10, r11, r12);
            return;
        L17:
            r12 = r22;
            goto L18
        L13:
            r11 = r21;
            goto L15
        L9:
            r10 = r20;
            goto L11
        L5:
            r9 = r19;
            goto L7
        }

        public final String a() {
            return this.f11223a;
        }

        public final String b() {
            return this.f11224b;
        }

        public final MemoryEntity c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11223a, r10.f11223a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11224b, r10.f11224b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public int hashCode() {
            int r0 = ((((((((this.f11223a.hashCode() * 31) + this.f11224b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31;
            String r1 = this.f;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.g;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + Boolean.hashCode(this.h);
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Content(id=" + this.f11223a + ", displayText=" + this.f11224b + ", memoryEntity=" + this.c + ", changeSeq=" + this.d + ", cardPos=" + this.e + ", logId=" + this.f + ", categoryLabel=" + this.g + ", isMock=" + this.h + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Header;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "title", "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends bc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11225a;

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            super(null);
            this.f11225a = r2;
        }

        public final String a() {
            return this.f11225a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11225a, r6.f11225a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11225a.hashCode();
        }

        public String toString() {
            return "Header(title=" + this.f11225a + ')';
        }
    }

    private bc() {
    }

    public /* synthetic */ bc(DefaultConstructorMarker r1) {
        this();
    }
}
