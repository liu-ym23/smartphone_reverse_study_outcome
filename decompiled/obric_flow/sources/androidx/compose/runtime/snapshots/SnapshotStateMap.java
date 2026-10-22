package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0001LB\u0005¢\u0006\u0002\u0010\u0005J1\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\u0080\bø\u0001\u0000¢\u0006\u0002\b+J1\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\u0080\bø\u0001\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\b\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u0002H90)H\u0082\b¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J1\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\u0080\bø\u0001\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000¢\u0006\u0004\bE\u00102J\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007J5\u0010G\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H0)H\u0082\bJ9\u0010I\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bJH\u0082\b¢\u0006\u0002\u0010;J9\u0010K\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bJH\u0082\b¢\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0080\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", STGroup.DICT_KEY, "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "toMap", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Stable
@SourceDebugExtension({"SMAP\nSnapshotStateMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotStateMap\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,360:1\n154#1:361\n121#1:362\n155#1,2:364\n125#1:366\n157#1,3:373\n162#1:379\n129#1,4:380\n133#1:385\n121#1:386\n134#1,7:388\n125#1:395\n141#1,6:401\n149#1,3:410\n129#1,4:413\n133#1:418\n121#1:419\n134#1,7:421\n125#1:428\n141#1,6:434\n149#1,3:443\n129#1,4:446\n133#1:451\n121#1:452\n134#1,7:454\n125#1:461\n141#1,6:467\n149#1,3:476\n129#1,4:482\n133#1:487\n121#1:488\n134#1,7:490\n125#1:497\n141#1,6:503\n149#1,3:512\n121#1:515\n121#1:528\n125#1:530\n121#1:541\n125#1:543\n2279#2:363\n2172#2,2:367\n1722#2:369\n2174#2,2:371\n2176#2,3:376\n2279#2:387\n2172#2,2:396\n1722#2:398\n2174#2,2:399\n2176#2,3:407\n2279#2:420\n2172#2,2:429\n1722#2:431\n2174#2,2:432\n2176#2,3:440\n2279#2:453\n2172#2,2:462\n1722#2:464\n2174#2,2:465\n2176#2,3:473\n2279#2:489\n2172#2,2:498\n1722#2:500\n2174#2,2:501\n2176#2,3:509\n2279#2:516\n2279#2:517\n2172#2,2:518\n1722#2:520\n2174#2,5:522\n2279#2:529\n2172#2,2:531\n1722#2:533\n2174#2,2:535\n2176#2,3:538\n2279#2:542\n2172#2,2:544\n1722#2:546\n2174#2,2:548\n2176#2,3:551\n70#3:370\n70#3:384\n70#3:417\n70#3:450\n70#3:486\n70#3:521\n70#3:527\n70#3:534\n70#3:537\n70#3:547\n70#3:550\n288#4,2:479\n1#5:481\n*S KotlinDebug\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotStateMap\n*L\n69#1:361\n69#1:362\n69#1:364,2\n69#1:366\n69#1:373,3\n69#1:379\n70#1:380,4\n70#1:385\n70#1:386\n70#1:388,7\n70#1:395\n70#1:401,6\n70#1:410,3\n71#1:413,4\n71#1:418\n71#1:419\n71#1:421,7\n71#1:428\n71#1:434,6\n71#1:443,3\n72#1:446,4\n72#1:451\n72#1:452\n72#1:454,7\n72#1:461\n72#1:467,6\n72#1:476,3\n85#1:482,4\n85#1:487\n85#1:488\n85#1:490,7\n85#1:497\n85#1:503,6\n85#1:512,3\n117#1:515\n133#1:528\n140#1:530\n154#1:541\n156#1:543\n69#1:363\n69#1:367,2\n69#1:369\n69#1:371,2\n69#1:376,3\n70#1:387\n70#1:396,2\n70#1:398\n70#1:399,2\n70#1:407,3\n71#1:420\n71#1:429,2\n71#1:431\n71#1:432,2\n71#1:440,3\n72#1:453\n72#1:462,2\n72#1:464\n72#1:465,2\n72#1:473,3\n85#1:489\n85#1:498,2\n85#1:500\n85#1:501,2\n85#1:509,3\n117#1:516\n121#1:517\n125#1:518,2\n125#1:520\n125#1:522,5\n133#1:529\n140#1:531,2\n140#1:533\n140#1:535,2\n140#1:538,3\n154#1:542\n156#1:544,2\n156#1:546\n156#1:548,2\n156#1:551,3\n69#1:370\n70#1:384\n71#1:417\n72#1:450\n85#1:486\n125#1:521\n132#1:527\n140#1:534\n141#1:537\n156#1:547\n157#1:550\n77#1:479,2\n*E\n"})
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    public static final int $stable = 0;
    private final Set<Map.Entry<K, V>> entries;
    private StateRecord firstStateRecord;
    private final Set<K> keys;
    private final Collection<V> values;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshotStateMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,360:1\n70#2:361\n*S KotlinDebug\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord\n*L\n174#1:361\n*E\n"})
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public StateMapStateRecord(PersistentMap<K, ? extends V> r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            this.map = r5;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            StateMapStateRecord r10 = (StateMapStateRecord) r5;
            Object r11 = SnapshotStateMapKt.access$getSync$p();
            monitor-enter(r11);
            this.map = r10.map;     // Catch: Throwable -> L7
            this.modification = r10.modification;     // Catch: Throwable -> L7
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r11);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }

        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.map = r5;
        }

        public final void setModification$runtime_release(int r5) {
            this.modification = r5;
        }
    }

    public SnapshotStateMap() {
        this.firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());
        this.entries = new SnapshotMapEntrySet(this);
        this.keys = new SnapshotMapKeySet(this);
        this.values = new SnapshotMapValueSet(this);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super Map<K, V>, ? extends R> r10) {
    L2:
        Object r5 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L40
        StateMapStateRecord r12 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r11);     // Catch: Throwable -> L40
        PersistentMap<K, V> r13 = r12.getMap$runtime_release();     // Catch: Throwable -> L40
        int r14 = r12.getModification$runtime_release();     // Catch: Throwable -> L40
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L40
        InlineMarker.finallyStart(1);
        monitor-exit(r5);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r13);
        PersistentMap.Builder<K, V> r16 = r13.builder();
        R r17 = r10.invoke(r16);
        PersistentMap<K, V> r18 = r16.build();
        if (Intrinsics.areEqual(r18, r13) == true) goto L39;
        StateRecord r19 = getFirstStateRecord();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r20 = (StateMapStateRecord) r19;
        SnapshotKt.getSnapshotInitializer();
        Object r21 = SnapshotKt.getLock();
        monitor-enter(r21);
        Snapshot r22 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L29
        StateMapStateRecord r23 = (StateMapStateRecord) SnapshotKt.writableRecord(r20, this, r22);     // Catch: Throwable -> L29
        Object r24 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L29
        monitor-enter(r24);     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L29
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L15:
        if (r23.getModification$runtime_release() != r14) goto L20;
        r23.setMap$runtime_release(r18);     // Catch: Throwable -> L18
        r23.setModification$runtime_release(r23.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
        boolean r25 = true;
    L21:
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L29
        monitor-exit(r24);     // Catch: Throwable -> L29
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L29
        InlineMarker.finallyStart(1);
        monitor-exit(r21);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r22, this);
        if (r25 == false) goto L2;
    L20:
        r25 = false;
    L29:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L39:
        return r17;
    L40:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final void update(Function1<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> r10) {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r11 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r5);
        PersistentMap<K, ? extends V> r12 = r10.invoke(r11.getMap$runtime_release());
        if (r12 == r11.getMap$runtime_release()) goto L27;
        StateRecord r13 = getFirstStateRecord();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r14 = (StateMapStateRecord) r13;
        SnapshotKt.getSnapshotInitializer();
        Object r15 = SnapshotKt.getLock();
        monitor-enter(r15);
        Snapshot r16 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L16
        StateMapStateRecord r17 = (StateMapStateRecord) SnapshotKt.writableRecord(r14, this, r16);     // Catch: Throwable -> L16
        Object r18 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L16
        monitor-enter(r18);     // Catch: Throwable -> L16
        r17.setMap$runtime_release(r12);     // Catch: Throwable -> L18
        r17.setModification$runtime_release(r17.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L16
        monitor-exit(r18);     // Catch: Throwable -> L16
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
        monitor-exit(r15);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r16, this);
        return;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L16
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> r5) {
        StateRecord r10 = getFirstStateRecord();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return r5.invoke(SnapshotKt.current((StateMapStateRecord) r10));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> r5) {
        StateRecord r10 = getFirstStateRecord();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r11 = (StateMapStateRecord) r10;
        SnapshotKt.getSnapshotInitializer();
        Object r12 = SnapshotKt.getLock();
        monitor-enter(r12);
        Snapshot r13 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r14 = r5.invoke(SnapshotKt.writableRecord(r11, this, r13));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r12);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r13, this);
        return r14;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final boolean all$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Iterator<E> r10 = ((ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r5.invoke((Map.Entry) r10.next()).booleanValue() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final boolean any$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Iterator<E> r10 = ((ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r5.invoke((Map.Entry) r10.next()).booleanValue() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Map
    public void clear() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r10 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r5);
        r10.getMap$runtime_release();
        PersistentMap<K, V> r11 = ExtensionsKt.persistentHashMapOf();
        if (r11 == r10.getMap$runtime_release()) goto L19;
        StateRecord r12 = getFirstStateRecord();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r13 = (StateMapStateRecord) r12;
        SnapshotKt.getSnapshotInitializer();
        Object r14 = SnapshotKt.getLock();
        monitor-enter(r14);
        Snapshot r15 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L12
        StateMapStateRecord r16 = (StateMapStateRecord) SnapshotKt.writableRecord(r13, this, r15);     // Catch: Throwable -> L12
        Object r17 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L12
        monitor-enter(r17);     // Catch: Throwable -> L12
        r16.setMap$runtime_release(r11);     // Catch: Throwable -> L14
        r16.setModification$runtime_release(r16.getModification$runtime_release() + 1);     // Catch: Throwable -> L14
        monitor-exit(r17);     // Catch: Throwable -> L12
        monitor-exit(r14);
        SnapshotKt.notifyWrite(r15, this);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(r5);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r5) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(r5);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public V get(Object r5) {
        return getReadable$runtime_release().getMap$runtime_release().get(r5);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    public final Map<K, V> getDebuggerDisplayValue() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r5)).getMap$runtime_release();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) r5, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    public Collection<V> getValues() {
        return this.values;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this.firstStateRecord = (StateMapStateRecord) r5;
    }

    @Override // java.util.Map
    public V put(K r10, V r11) {
    L2:
        Object r5 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r12 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L31
        StateMapStateRecord r13 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r12);     // Catch: Throwable -> L31
        PersistentMap<K, V> r14 = r13.getMap$runtime_release();     // Catch: Throwable -> L31
        int r15 = r13.getModification$runtime_release();     // Catch: Throwable -> L31
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        Intrinsics.checkNotNull(r14);
        PersistentMap.Builder<K, V> r17 = r14.builder();
        V r18 = r17.put(r10, r11);
        PersistentMap<K, V> r19 = r17.build();
        if (Intrinsics.areEqual(r19, r14) == true) goto L30;
        StateRecord r20 = getFirstStateRecord();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r21 = (StateMapStateRecord) r20;
        SnapshotKt.getSnapshotInitializer();
        Object r22 = SnapshotKt.getLock();
        monitor-enter(r22);
        Snapshot r23 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L24
        StateMapStateRecord r24 = (StateMapStateRecord) SnapshotKt.writableRecord(r21, this, r23);     // Catch: Throwable -> L24
        Object r25 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L24
        monitor-enter(r25);     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L13:
        if (r24.getModification$runtime_release() != r15) goto L18;
        r24.setMap$runtime_release(r19);     // Catch: Throwable -> L16
        boolean r26 = true;
        r24.setModification$runtime_release(r24.getModification$runtime_release() + 1);     // Catch: Throwable -> L16
    L19:
        monitor-exit(r25);     // Catch: Throwable -> L24
        monitor-exit(r22);
        SnapshotKt.notifyWrite(r23, this);
        if (r26 == false) goto L2;
    L18:
        r26 = false;
    L24:
        th = move-exception;
        throw th;
    L30:
        return r18;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "from");
    L3:
        Object r5 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L32
        StateMapStateRecord r12 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r11);     // Catch: Throwable -> L32
        PersistentMap<K, V> r13 = r12.getMap$runtime_release();     // Catch: Throwable -> L32
        int r14 = r12.getModification$runtime_release();     // Catch: Throwable -> L32
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r5);
        Intrinsics.checkNotNull(r13);
        PersistentMap.Builder<K, V> r16 = r13.builder();
        r16.putAll(r10);
        PersistentMap<K, V> r17 = r16.build();
        if (Intrinsics.areEqual(r17, r13) == true) goto L31;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r19 = (StateMapStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L25
        StateMapStateRecord r22 = (StateMapStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L25
        Object r23 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L25
        monitor-enter(r23);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (r22.getModification$runtime_release() != r14) goto L19;
        r22.setMap$runtime_release(r17);     // Catch: Throwable -> L17
        boolean r24 = true;
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L17
    L20:
        monitor-exit(r23);     // Catch: Throwable -> L25
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r24 == false) goto L3;
        return;
    L19:
        r24 = false;
    L25:
        th = move-exception;
        throw th;
    L31:
        return;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V remove(Object r10) {
    L2:
        Object r5 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L31
        StateMapStateRecord r12 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r11);     // Catch: Throwable -> L31
        PersistentMap<K, V> r13 = r12.getMap$runtime_release();     // Catch: Throwable -> L31
        int r14 = r12.getModification$runtime_release();     // Catch: Throwable -> L31
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        Intrinsics.checkNotNull(r13);
        PersistentMap.Builder<K, V> r16 = r13.builder();
        V r17 = r16.remove(r10);
        PersistentMap<K, V> r18 = r16.build();
        if (Intrinsics.areEqual(r18, r13) == true) goto L30;
        StateRecord r19 = getFirstStateRecord();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r20 = (StateMapStateRecord) r19;
        SnapshotKt.getSnapshotInitializer();
        Object r21 = SnapshotKt.getLock();
        monitor-enter(r21);
        Snapshot r22 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L24
        StateMapStateRecord r23 = (StateMapStateRecord) SnapshotKt.writableRecord(r20, this, r22);     // Catch: Throwable -> L24
        Object r24 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L24
        monitor-enter(r24);     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L13:
        if (r23.getModification$runtime_release() != r14) goto L18;
        r23.setMap$runtime_release(r18);     // Catch: Throwable -> L16
        boolean r25 = true;
        r23.setModification$runtime_release(r23.getModification$runtime_release() + 1);     // Catch: Throwable -> L16
    L19:
        monitor-exit(r24);     // Catch: Throwable -> L24
        monitor-exit(r21);
        SnapshotKt.notifyWrite(r22, this);
        if (r25 == false) goto L2;
    L18:
        r25 = false;
    L24:
        th = move-exception;
        throw th;
    L30:
        return r17;
    L31:
        th = move-exception;
        throw th;
    }

    public final boolean removeIf$runtime_release(Function1<? super Map.Entry<K, V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "predicate");
        boolean r5 = false;
    L3:
        Object r10 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r10);
        StateRecord r12 = getFirstStateRecord();     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L47
        StateMapStateRecord r13 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r12);     // Catch: Throwable -> L47
        PersistentMap<K, V> r14 = r13.getMap$runtime_release();     // Catch: Throwable -> L47
        int r15 = r13.getModification$runtime_release();     // Catch: Throwable -> L47
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L47
        InlineMarker.finallyStart(1);
        monitor-exit(r10);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r14);
        PersistentMap.Builder<K, V> r17 = r14.builder();
        Iterator<Map.Entry<K, V>> r18 = entrySet().iterator();
    L11:
        if (r18.hasNext() == false) goto L15;
        Map.Entry<K, V> r19 = r18.next();
        if (r11.invoke(r19).booleanValue() == false) goto L11;
        r17.remove(r19.getKey());
        r5 = true;
        goto L11
    L15:
        Unit r20 = Unit.INSTANCE;
        PersistentMap<K, V> r21 = r17.build();
        if (Intrinsics.areEqual(r21, r14) == true) goto L46;
        StateRecord r22 = getFirstStateRecord();
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r23 = (StateMapStateRecord) r22;
        SnapshotKt.getSnapshotInitializer();
        Object r24 = SnapshotKt.getLock();
        monitor-enter(r24);
        Snapshot r25 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L36
        StateMapStateRecord r26 = (StateMapStateRecord) SnapshotKt.writableRecord(r23, this, r25);     // Catch: Throwable -> L36
        Object r27 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L36
        monitor-enter(r27);     // Catch: Throwable -> L36
    L25:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L36
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L22:
        if (r26.getModification$runtime_release() != r15) goto L27;
        r26.setMap$runtime_release(r21);     // Catch: Throwable -> L25
        r26.setModification$runtime_release(r26.getModification$runtime_release() + 1);     // Catch: Throwable -> L25
        boolean r28 = true;
    L28:
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L36
        monitor-exit(r27);     // Catch: Throwable -> L36
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L36
        InlineMarker.finallyStart(1);
        monitor-exit(r24);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r25, this);
        if (r28 == false) goto L3;
    L27:
        r28 = false;
    L36:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L46:
        return r5;
    L47:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final boolean removeValue$runtime_release(V r5) {
        Iterator<T> r10 = entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((Map.Entry) r11).getValue(), r5) == false) goto L4;
    L9:
        Map.Entry r12 = (Map.Entry) r11;
        if (r12 == null) goto L12;
        remove(r12.getKey());
        return true;
    L12:
        return false;
    L8:
        r11 = null;
        goto L9
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public final Map<K, V> toMap() {
        return getReadable$runtime_release().getMap$runtime_release();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
