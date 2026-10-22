package com.obric.memorydata.memory.ui.data;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.memory.llm.SessionStatus;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0001\f\u001b\u001c\u001d\u001e\u001f !\"#$%&¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "", "type", "Lcom/obric/memorydata/memory/ui/data/MemoryCategoryType;", "keywords", "", "", "<init>", "(Lcom/obric/memorydata/memory/ui/data/MemoryCategoryType;Ljava/util/List;)V", "getType", "()Lcom/obric/memorydata/memory/ui/data/MemoryCategoryType;", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "Time", "RelationTitle", "TimeLine", ExifInterface.TAG_DATETIME, "EpisodicTopic", "ListEntity", "ObservationEntity", "AudioEntity", "AutoMemoryPro", "DetailEntity", "Footer", "Calendar", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$AudioEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$AutoMemoryPro;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DateTime;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DetailEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$EpisodicTopic;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Footer;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$RelationTitle;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Time;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryCategoryType f10773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f10774b;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.data.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$AudioEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "auditoryRecordingEntity", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "isPast", "", "keywords", "", "", "<init>", "(Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;ZLjava/util/List;)V", "getAuditoryRecordingEntity", "()Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "()Z", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0539a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fj f10775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10776b;
        private List<String> c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0539a(fj r4, boolean r5, List<String> r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "auditoryRecordingEntity");
            Intrinsics.checkNotNullParameter(r7, "keywords");
            super(MemoryCategoryType.MEMORY_AUDIO, null, 2, 0 == true ? 1 : 0);
            this.f10775a = r4;
            this.f10776b = r5;
            this.c = r7;
        }

        public /* synthetic */ C0539a(fj r2, boolean r3, List r4, int r5, DefaultConstructorMarker r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 4) == 0) goto L5;
            r7 = CollectionsKt.emptyList();
        L5:
            this(r2, r3, r7);
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public List<String> a() {
            return this.c;
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public void a(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.c = r4;
        }

        public final fj b() {
            return this.f10775a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0539a.class) == true) goto L8;
            return false;
        L8:
            C0539a r6 = (C0539a) ZeusTransformUtils.preCheckCast(r5, C0539a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10775a, r6.f10775a) == true) goto L12;
            return false;
        L12:
            if (this.f10776b == r6.f10776b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f10775a.hashCode() * 31) + Boolean.hashCode(this.f10776b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AudioEntity(auditoryRecordingEntity=" + this.f10775a + ", isPast=" + this.f10776b + ", keywords=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$AutoMemoryPro;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "autoMemoryProEntity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "keywords", "", "", "<init>", "(Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;Ljava/util/List;)V", "getAutoMemoryProEntity", "()Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AutoMemoryProEntity f10777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f10778b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(AutoMemoryProEntity r4, List<String> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "autoMemoryProEntity");
            Intrinsics.checkNotNullParameter(r6, "keywords");
            super(MemoryCategoryType.MEMORY_AUTO_MEMORY_PRO, null, 2, 0 == true ? 1 : 0);
            this.f10777a = r4;
            this.f10778b = r6;
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public List<String> a() {
            return this.f10778b;
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public void a(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.f10778b = r4;
        }

        public final AutoMemoryProEntity b() {
            return this.f10777a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10777a, r6.f10777a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10778b, r6.f10778b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10777a.hashCode() * 31) + this.f10778b.hashCode();
        }

        public String toString() {
            return "AutoMemoryPro(autoMemoryProEntity=" + this.f10777a + ", keywords=" + this.f10778b + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "pendingMemoryCalendar", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "<init>", "(Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;)V", "getPendingMemoryCalendar", "()Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PendingMemoryCalendar f10779a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(PendingMemoryCalendar r4) {
            Intrinsics.checkNotNullParameter(r4, "pendingMemoryCalendar");
            super(MemoryCategoryType.MEMORY_CALENDAR, null, 2, 0 == true ? 1 : 0);
            this.f10779a = r4;
        }

        public final PendingMemoryCalendar b() {
            return this.f10779a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10779a, r6.f10779a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10779a.hashCode();
        }

        public String toString() {
            return "Calendar(pendingMemoryCalendar=" + this.f10779a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$DateTime;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "date", "Ljava/time/LocalDate;", "<init>", "(Ljava/time/LocalDate;)V", "getDate", "()Ljava/time/LocalDate;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocalDate f10780a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(LocalDate r4) {
            Intrinsics.checkNotNullParameter(r4, "date");
            super(MemoryCategoryType.MEMORY_TIME, null, 2, 0 == true ? 1 : 0);
            this.f10780a = r4;
        }

        public final LocalDate b() {
            return this.f10780a;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u001b\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0003J\u001b\u00103\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\u0087\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u00072\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R,\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u0006<"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$DetailEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "hasCalendar", "", "keyInfoMap", "", "", "", "streamText", "streamStatus", "Lcom/obric/memorydata/memory/llm/SessionStatus;", "streamContentFlow", "Lkotlinx/coroutines/flow/StateFlow;", "streamKeyInfoMap", "resultStrMemory", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;ZLjava/util/Map;Ljava/lang/String;Lcom/obric/memorydata/memory/llm/SessionStatus;Lkotlinx/coroutines/flow/StateFlow;Ljava/util/Map;Ljava/lang/String;)V", "getMemoryEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getHasCalendar", "()Z", "setHasCalendar", "(Z)V", "getKeyInfoMap", "()Ljava/util/Map;", "setKeyInfoMap", "(Ljava/util/Map;)V", "getStreamText", "()Ljava/lang/String;", "setStreamText", "(Ljava/lang/String;)V", "getStreamStatus", "()Lcom/obric/memorydata/memory/llm/SessionStatus;", "setStreamStatus", "(Lcom/obric/memorydata/memory/llm/SessionStatus;)V", "getStreamContentFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "setStreamContentFlow", "(Lkotlinx/coroutines/flow/StateFlow;)V", "getStreamKeyInfoMap", "setStreamKeyInfoMap", "getResultStrMemory", "setResultStrMemory", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MemoryEntity f10781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f10782b;
        private Map<String, ? extends List<String>> c;
        private String d;
        private SessionStatus e;
        private ar<String> f;
        private Map<String, ? extends List<String>> g;
        private String h;

        /* JADX WARN: Multi-variable type inference failed */
        public e(MemoryEntity r4, boolean r5, Map<String, ? extends List<String>> r6, String r7, SessionStatus r8, ar<String> r9, Map<String, ? extends List<String>> r10, String r11) {
            Map<String, ? extends List<String>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            ar<String> r13 = (ar) ZeusTransformUtils.wrapperContextForParams(r9, ar.class, "com.obric.memorydata.plugin");
            Map<String, ? extends List<String>> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "memoryEntity");
            Intrinsics.checkNotNullParameter(r12, "keyInfoMap");
            Intrinsics.checkNotNullParameter(r7, "streamText");
            Intrinsics.checkNotNullParameter(r14, "streamKeyInfoMap");
            Intrinsics.checkNotNullParameter(r11, "resultStrMemory");
            super(MemoryCategoryType.MEMORY_DETAIL_ENTITY, null, 2, 0 == true ? 1 : 0);
            this.f10781a = r4;
            this.f10782b = r5;
            this.c = r12;
            this.d = r7;
            this.e = r8;
            this.f = r13;
            this.g = r14;
            this.h = r11;
        }

        public /* synthetic */ e(MemoryEntity r11, boolean r12, Map r13, String r14, SessionStatus r15, ar r16, Map r17, String r18, int r19, DefaultConstructorMarker r20) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
            ar r3 = (ar) ZeusTransformUtils.wrapperContextForParams(r16, ar.class, "com.obric.memorydata.plugin");
            Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
            if ((r19 & 2) == 0) goto L5;
            boolean r4 = false;
        L7:
            if ((r19 & 4) == 0) goto L9;
            r1 = MapsKt.emptyMap();
        L9:
            String r6 = "";
            if ((r19 & 8) == 0) goto L12;
            String r5 = "";
        L13:
            ar r8 = null;
            if ((r19 & 16) == 0) goto L16;
            SessionStatus r7 = null;
        L18:
            if ((r19 & 32) != 0) goto L22;
            r8 = r3;
        L22:
            if ((r19 & 64) == 0) goto L25;
            r2 = MapsKt.emptyMap();
        L25:
            if ((r19 & 128) != 0) goto L28;
            r6 = r18;
        L28:
            this(r11, r4, r1, r5, r7, r8, r2, r6);
            return;
        L16:
            r7 = r15;
            goto L18
        L12:
            r5 = r14;
            goto L13
        L5:
            r4 = r12;
            goto L7
        }

        public final void a(SessionStatus r1) {
            this.e = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.d = r2;
        }

        public final void a(Map<String, ? extends List<String>> r3) {
            Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.c = r4;
        }

        public final void a(ar<String> r3) {
            this.f = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
        }

        public final void a(boolean r1) {
            this.f10782b = r1;
        }

        public final MemoryEntity b() {
            return this.f10781a;
        }

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.h = r2;
        }

        public final void b(Map<String, ? extends List<String>> r3) {
            Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.g = r4;
        }

        public final boolean c() {
            return this.f10782b;
        }

        public final Map<String, List<String>> d() {
            return this.c;
        }

        public final String e() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10781a, r6.f10781a) == true) goto L12;
            return false;
        L12:
            if (this.f10782b == r6.f10782b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final SessionStatus f() {
            return this.e;
        }

        public final ar<String> g() {
            return this.f;
        }

        public final String h() {
            return this.h;
        }

        public int hashCode() {
            int r0 = ((((((this.f10781a.hashCode() * 31) + Boolean.hashCode(this.f10782b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            SessionStatus r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ar<String> r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "DetailEntity(memoryEntity=" + this.f10781a + ", hasCalendar=" + this.f10782b + ", keyInfoMap=" + this.c + ", streamText=" + this.d + ", streamStatus=" + this.e + ", streamContentFlow=" + this.f + ", streamKeyInfoMap=" + this.g + ", resultStrMemory=" + this.h + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$EpisodicTopic;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "topic", "Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryEntity;", "<init>", "(Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryEntity;)V", "getTopic", "()Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bp f10783a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(bp r4) {
            Intrinsics.checkNotNullParameter(r4, "topic");
            super(MemoryCategoryType.MEMORY_EPISODIC_TOPIC, null, 2, 0 == true ? 1 : 0);
            this.f10783a = r4;
        }

        public final bp b() {
            return this.f10783a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10783a, r6.f10783a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10783a.hashCode();
        }

        public String toString() {
            return "EpisodicTopic(topic=" + this.f10783a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$Footer;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10784a;

        /* JADX WARN: Multi-variable type inference failed */
        public g(String r4) {
            Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            super(MemoryCategoryType.MEMORY_FOOTER, null, 2, 0 == true ? 1 : 0);
            this.f10784a = r4;
        }

        public final String b() {
            return this.f10784a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10784a, r6.f10784a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10784a.hashCode();
        }

        public String toString() {
            return "Footer(text=" + this.f10784a + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "isPast", "", "hasRelation", "keywords", "", "", "logId", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;ZZLjava/util/List;Ljava/lang/String;)V", "getMemoryEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "()Z", "getHasRelation", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getLogId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MemoryEntity f10785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10786b;
        private final boolean c;
        private List<String> d;
        private final String e;

        /* JADX WARN: Multi-variable type inference failed */
        public h(MemoryEntity r4, boolean r5, boolean r6, List<String> r7, String r8) {
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "memoryEntity");
            Intrinsics.checkNotNullParameter(r9, "keywords");
            super(MemoryCategoryType.MEMORY_LIST_ENTITY, null, 2, 0 == true ? 1 : 0);
            this.f10785a = r4;
            this.f10786b = r5;
            this.c = r6;
            this.d = r9;
            this.e = r8;
        }

        public /* synthetic */ h(MemoryEntity r7, boolean r8, boolean r9, List r10, String r11, int r12, DefaultConstructorMarker r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 8) == 0) goto L5;
            r14 = CollectionsKt.emptyList();
        L5:
            List r4 = r14;
            if ((r12 & 16) == 0) goto L8;
            r11 = null;
        L8:
            this(r7, r8, r9, r4, r11);
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public List<String> a() {
            return this.d;
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public void a(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.d = r4;
        }

        public final MemoryEntity b() {
            return this.f10785a;
        }

        public final boolean c() {
            return this.f10786b;
        }

        public final boolean d() {
            return this.c;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10785a, r6.f10785a) == true) goto L12;
            return false;
        L12:
            if (this.f10786b == r6.f10786b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f10785a.hashCode() * 31) + Boolean.hashCode(this.f10786b)) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
            String r2 = this.e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "ListEntity(memoryEntity=" + this.f10785a + ", isPast=" + this.f10786b + ", hasRelation=" + this.c + ", keywords=" + this.d + ", logId=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "shortMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "keywords", "", "", "<init>", "(Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;Ljava/util/List;)V", "getShortMemoryEntity", "()Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EpisodicMemoryEntity f10787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f10788b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(EpisodicMemoryEntity r4, List<String> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "shortMemoryEntity");
            Intrinsics.checkNotNullParameter(r6, "keywords");
            super(MemoryCategoryType.MEMORY_OBSERVATION, null, 2, 0 == true ? 1 : 0);
            this.f10787a = r4;
            this.f10788b = r6;
        }

        public /* synthetic */ i(EpisodicMemoryEntity r2, List r3, int r4, DefaultConstructorMarker r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = CollectionsKt.emptyList();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public List<String> a() {
            return this.f10788b;
        }

        @Override // com.obric.memorydata.memory.ui.data.a
        public void a(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.f10788b = r4;
        }

        public final EpisodicMemoryEntity b() {
            return this.f10787a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10787a, r6.f10787a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10788b, r6.f10788b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10787a.hashCode() * 31) + this.f10788b.hashCode();
        }

        public String toString() {
            return "ObservationEntity(shortMemoryEntity=" + this.f10787a + ", keywords=" + this.f10788b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$RelationTitle;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class j extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10789a;

        /* JADX WARN: Multi-variable type inference failed */
        public j(String r4) {
            Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            super(MemoryCategoryType.MEMORY_RELATION_TEXT, null, 2, 0 == true ? 1 : 0);
            this.f10789a = r4;
        }

        public final String b() {
            return this.f10789a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$Time;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", OaidModel.KEY_TIME, "", "<init>", "(Ljava/lang/String;)V", "getTime", "()Ljava/lang/String;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class k extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10790a;

        public final String b() {
            return this.f10790a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", OaidModel.KEY_TIME, "", "isLast", "", "<init>", "(Ljava/lang/String;Z)V", "getTime", "()Ljava/lang/String;", "()Z", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class l extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10792b;

        /* JADX WARN: Multi-variable type inference failed */
        public l(String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, OaidModel.KEY_TIME);
            super(MemoryCategoryType.MEMORY_TIME, null, 2, 0 == true ? 1 : 0);
            this.f10791a = r4;
            this.f10792b = r5;
        }

        public final String b() {
            return this.f10791a;
        }

        public final boolean c() {
            return this.f10792b;
        }
    }

    private a(MemoryCategoryType r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f10773a = r3;
        this.f10774b = r5;
    }

    public /* synthetic */ a(MemoryCategoryType r2, List r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = CollectionsKt.emptyList();
    L5:
        this(r2, r6, null);
    }

    public /* synthetic */ a(MemoryCategoryType r2, List r3, DefaultConstructorMarker r4) {
        this(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public List<String> a() {
        return this.f10774b;
    }

    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f10774b = r4;
    }

    public MemoryCategoryType getType() {
        return this.f10773a;
    }
}
