package com.obric.memorydata.memory.contextsync;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal;", "", "read", "Lkotlin/Function0;", "", "write", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "current", "Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Record;", "begin", "token", "restored", "prepared", "abortRestoring", "firstBatchConfirmed", "transition", "from", "Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Phase;", TypedValues.TransitionType.S_TO, "save", "record", "Phase", "Record", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryContextMigrationJournal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<String> f10087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<String, Boolean> f10088b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "RESTORING", "PREPARING", "FIRST_BATCH", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Phase[] $VALUES = null;
        public static final Phase FIRST_BATCH = null;
        public static final Phase PREPARING = null;
        public static final Phase RESTORING = null;

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{RESTORING, PREPARING, FIRST_BATCH};
        }

        static {
            RESTORING = new Phase("RESTORING", 0);
            PREPARING = new Phase("PREPARING", 1);
            FIRST_BATCH = new Phase("FIRST_BATCH", 2);
            Phase[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Phase(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String r2) {
            return (Phase) ZeusTransformUtils.preCheckCast(Enum.valueOf(Phase.class, r2), Phase.class, "com.obric.memorydata.plugin");
        }

        public static Phase[] values() {
            return (Phase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Phase[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Record;", "", "token", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Phase;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Phase;)V", "getToken", "()Ljava/lang/String;", "getPhase", "()Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal$Phase;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Phase f10090b;

        public a(String r2, Phase r3) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, TypedValues.CycleType.S_WAVE_PHASE);
            this.f10089a = r2;
            this.f10090b = r3;
        }

        public final String a() {
            return this.f10089a;
        }

        public final Phase b() {
            return this.f10090b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10089a, r6.f10089a) == true) goto L12;
            return false;
        L12:
            if (this.f10090b == r6.f10090b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10089a.hashCode() * 31) + this.f10090b.hashCode();
        }

        public String toString() {
            return "Record(token=" + this.f10089a + ", phase=" + this.f10090b + ')';
        }
    }

    public MemoryContextMigrationJournal(Function0<String> r3, Function1<? super String, Boolean> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Boolean> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "read");
        Intrinsics.checkNotNullParameter(r6, "write");
        this.f10087a = r5;
        this.f10088b = r6;
    }

    private final boolean a(a r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f10088b.invoke(r3.b().name() + '|' + r3.a()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final boolean a(String r5, Phase r6, Phase r7) {
        a r0 = a();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r0.a(), r5) == true) goto L9;
        return false;
    L9:
        if (r0.b() != r7) goto L12;
        return true;
    L12:
        if (r0.b() == r6) goto L14;
        return false;
    L14:
        if (a(new a(r5, r7)) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public final a a() {
        String r11 = (String) ZeusTransformUtils.preCheckCast(this.f10087a.invoke(), String.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r4 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        List r12 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'|'}, false, 2, 2, null);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(Phase.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        Object r5 = r1.next();
        if (Intrinsics.areEqual(((Phase) ZeusTransformUtils.preCheckCast(r5, Phase.class, "com.obric.memorydata.plugin")).name(), CollectionsKt.first(r12)) == false) goto L11;
        r4 = r5;
    L15:
        Phase r3 = (Phase) ZeusTransformUtils.preCheckCast(r4, Phase.class, "com.obric.memorydata.plugin");
        if (r12.size() != 2) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.get(1), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L20;
        r2 = true;
    L20:
        if (r2 == true) goto L28;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.get(1), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L26;
        r3 = Phase.RESTORING;
    L26:
        return new a(r13, r3);
    L28:
        return new a("", Phase.RESTORING);
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        return a(new a(r3, Phase.RESTORING));
    }

    public final boolean b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        return a(r3, Phase.RESTORING, Phase.PREPARING);
    }

    public final boolean c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        return a(r3, Phase.PREPARING, Phase.FIRST_BATCH);
    }

    public final boolean d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "token");
        if (Intrinsics.areEqual(a(), new a(r4, Phase.RESTORING)) == true) goto L7;
        return false;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f10088b.invoke(""), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "token");
        if (Intrinsics.areEqual(a(), new a(r4, Phase.FIRST_BATCH)) == true) goto L7;
        return false;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f10088b.invoke(""), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}
