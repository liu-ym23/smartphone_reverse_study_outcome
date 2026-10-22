package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDerivedState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/DerivedSnapshotState\n+ 2 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 4 IdentityArrayMap.kt\nandroidx/compose/runtime/collection/IdentityArrayMap\n+ 5 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 6 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,385:1\n357#2,2:386\n359#2,2:399\n362#2,2:406\n357#2,2:408\n359#2,5:421\n460#3,11:388\n460#3,11:410\n153#4,5:401\n1722#5:426\n2279#5:428\n2279#5:429\n2279#5:430\n2279#5:431\n2279#5:432\n70#6:427\n*S KotlinDebug\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/DerivedSnapshotState\n*L\n172#1:386,2\n172#1:399,2\n172#1:406,2\n187#1:408,2\n187#1:421,5\n172#1:388,11\n187#1:410,11\n175#1:401,5\n209#1:426\n255#1:428\n262#1:429\n267#1:430\n278#1:431\n286#1:432\n209#1:427\n*E\n"})
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first;
    private final SnapshotMutationPolicy<T> policy;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 /*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001/B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u001a\u0010(\u001a\u00020)2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\b2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u00060"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "_dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "get_dependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "set_dependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "result", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDerivedState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/DerivedSnapshotState$ResultRecord\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 5 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 6 IdentityArrayMap.kt\nandroidx/compose/runtime/collection/IdentityArrayMap\n+ 7 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,385:1\n1722#2:386\n1722#2:388\n1722#2:390\n70#3:387\n70#3:389\n70#3:391\n357#4,2:392\n359#4,2:405\n362#4,2:412\n460#5,11:394\n153#6,5:407\n26#7:414\n*S KotlinDebug\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/DerivedSnapshotState$ResultRecord\n*L\n100#1:386\n107#1:388\n118#1:390\n100#1:387\n107#1:389\n118#1:391\n120#1:392,2\n120#1:405,2\n120#1:412,2\n120#1:394,11\n121#1:407,5\n150#1:414\n*E\n"})
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private static final Object Unset = null;
        private IdentityArrayMap<StateObject, Integer> _dependencies;
        private Object result;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final Object getUnset() {
                return ResultRecord.access$getUnset$cp();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
            Unset = new Object();
        }

        public ResultRecord() {
            this.result = Unset;
        }

        public static final /* synthetic */ Object access$getUnset$cp() {
            return Unset;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            ResultRecord r10 = (ResultRecord) r5;
            this._dependencies = r10._dependencies;
            this.result = r10.result;
            this.resultHash = r10.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object[] getDependencies() {
            IdentityArrayMap<StateObject, Integer> r5 = this._dependencies;
            if (r5 == null) goto L7;
            Object[] r10 = r5.getKeys();
            if (r10 == null) goto L7;
            return r10;
        L7:
            return new Object[0];
        }

        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final IdentityArrayMap<StateObject, Integer> get_dependencies() {
            return this._dependencies;
        }

        public final boolean isValid(DerivedState<?> r10, Snapshot r11) {
            Intrinsics.checkNotNullParameter(r10, "derivedState");
            Intrinsics.checkNotNullParameter(r11, "snapshot");
            Object r5 = SnapshotKt.getLock();
            monitor-enter(r5);
            boolean r12 = true;
            if (this.validSnapshotId != r11.getId()) goto L12;
            if (this.validSnapshotWriteCount != r11.getWriteCount$runtime_release()) goto L12;
            boolean r13 = false;
        L13:
            monitor-exit(r5);
            if (this.result == Unset) goto L20;
            if (r13 == true) goto L18;
        L21:
            if (r12 == false) goto L31;
            if (r13 == false) goto L31;
            Object r14 = SnapshotKt.getLock();
            monitor-enter(r14);
            this.validSnapshotId = r11.getId();     // Catch: Throwable -> L28
            this.validSnapshotWriteCount = r11.getWriteCount$runtime_release();     // Catch: Throwable -> L28
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L28
            monitor-exit(r14);
        L28:
            th = move-exception;
            throw th;
        L31:
            return r12;
        L18:
            if (this.resultHash == readableHash(r10, r11)) goto L21;
        L20:
            r12 = false;
        L12:
            r13 = true;
        L10:
            th = move-exception;
            throw th;
        }

        public final int readableHash(DerivedState<?> r10, Snapshot r11) {
            Intrinsics.checkNotNullParameter(r10, "derivedState");
            Intrinsics.checkNotNullParameter(r11, "snapshot");
            Object r5 = SnapshotKt.getLock();
            monitor-enter(r5);
            IdentityArrayMap<StateObject, Integer> r12 = this._dependencies;     // Catch: Throwable -> L41
            monitor-exit(r5);
            int r13 = 7;
            if (r12 == null) goto L40;
            MutableVector<DerivedStateObserver> r14 = SnapshotStateKt.derivedStateObservers();
            int r15 = r14.getSize();
            int r16 = 0;
            if (r15 <= 0) goto L46;
            DerivedStateObserver[] r17 = r14.getContent();
            int r18 = 0;
        L11:
            r17[r18].start(r10);
            r18 = r18 + 1;
            if (r18 < r15) goto L11;
        L46:
            int r19 = r12.getSize();     // Catch: Throwable -> L21
            int r20 = 0;
        L14:
            if (r20 >= r19) goto L26;
            Object r21 = r12.getKeys()[r20];     // Catch: Throwable -> L21
            Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");     // Catch: Throwable -> L21
            StateObject r22 = (StateObject) r21;     // Catch: Throwable -> L21
            if (((Number) r12.getValues()[r20]).intValue() == 1) goto L19;
        L25:
            r20 = r20 + 1;     // Catch: Throwable -> L21
            goto L14
        L19:
            if ((r22 instanceof DerivedSnapshotState) == false) goto L23;
            StateRecord r23 = ((DerivedSnapshotState) r22).current(r11);     // Catch: Throwable -> L21
        L24:
            r13 = (((r13 * 31) + ActualJvm_jvmKt.identityHashCode(r23)) * 31) + r23.getSnapshotId$runtime_release();     // Catch: Throwable -> L21
            goto L25
        L23:
            r23 = SnapshotKt.current(r22.getFirstStateRecord(), r11);     // Catch: Throwable -> L21
            goto L24
        L26:
            Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L21
            int r25 = r14.getSize();
            if (r25 <= 0) goto L40;
            DerivedStateObserver[] r110 = r14.getContent();
        L30:
            r110[r16].done(r10);
            r16 = r16 + 1;
            if (r16 < r25) goto L30;
        L21:
            th = move-exception;
            int r111 = r14.getSize();
            if (r111 <= 0) goto L39;
            DerivedStateObserver[] r26 = r14.getContent();
        L36:
            r26[r16].done(r10);
            r16 = r16 + 1;
            if (r16 < r111) goto L36;
        L39:
            throw th;
        L40:
            return r13;
        L41:
            th = move-exception;
            throw th;
        }

        public final void setResult(Object r5) {
            this.result = r5;
        }

        public final void setResultHash(int r5) {
            this.resultHash = r5;
        }

        public final void setValidSnapshotId(int r5) {
            this.validSnapshotId = r5;
        }

        public final void setValidSnapshotWriteCount(int r5) {
            this.validSnapshotWriteCount = r5;
        }

        public final void set_dependencies(IdentityArrayMap<StateObject, Integer> r5) {
            this._dependencies = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedSnapshotState(Function0<? extends T> r5, SnapshotMutationPolicy<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "calculation");
        this.calculation = r5;
        this.policy = r10;
        this.first = new ResultRecord();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> r10, Snapshot r11, boolean r12, Function0<? extends T> r13) {
        int r5 = 0;
        if (r10.isValid(this, r11) == false) goto L38;
        if (r12 == false) goto L37;
        MutableVector<DerivedStateObserver> r14 = SnapshotStateKt.derivedStateObservers();
        int r15 = r14.getSize();
        if (r15 <= 0) goto L82;
        DerivedStateObserver[] r16 = r14.getContent();
        int r17 = 0;
    L8:
        r16[r17].start(this);
        r17 = r17 + 1;
        if (r17 < r15) goto L8;
    L82:
        IdentityArrayMap<StateObject, Integer> r18 = r10.get_dependencies();     // Catch: Throwable -> L13
        Integer r19 = (Integer) SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();     // Catch: Throwable -> L13
        if (r19 == null) goto L15;
        int r20 = r19.intValue();     // Catch: Throwable -> L13
    L16:
        if (r18 == null) goto L23;
        int r21 = r18.getSize();     // Catch: Throwable -> L13
        int r22 = 0;
    L18:
        if (r22 >= r21) goto L23;
        Object r23 = r18.getKeys()[r22];     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");     // Catch: Throwable -> L13
        StateObject r24 = (StateObject) r23;     // Catch: Throwable -> L13
        SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(Integer.valueOf(((Number) r18.getValues()[r22]).intValue() + r20));     // Catch: Throwable -> L13
        Function1<Object, Unit> r25 = r11.getReadObserver$runtime_release();     // Catch: Throwable -> L13
        if (r25 == null) goto L22;
        r25.invoke(r24);     // Catch: Throwable -> L13
    L22:
        r22 = r22 + 1;     // Catch: Throwable -> L13
    L23:
        SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(Integer.valueOf(r20));     // Catch: Throwable -> L13
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L13
        int r111 = r14.getSize();
        if (r111 <= 0) goto L37;
        DerivedStateObserver[] r112 = r14.getContent();
    L27:
        r112[r5].done(this);
        r5 = r5 + 1;
        if (r5 < r111) goto L27;
    L15:
        r20 = 0;
    L13:
        th = move-exception;
        int r113 = r14.getSize();
        if (r113 <= 0) goto L36;
        DerivedStateObserver[] r114 = r14.getContent();
    L33:
        r114[r5].done(this);
        r5 = r5 + 1;
        if (r5 < r113) goto L33;
    L36:
        throw th;
    L37:
        return r10;
    L38:
        Integer r115 = (Integer) SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
        if (r115 == null) goto L41;
        final int r116 = r115.intValue();
    L42:
        final IdentityArrayMap<StateObject, Integer> r26 = new IdentityArrayMap(0, 1, null);
        MutableVector<DerivedStateObserver> r27 = SnapshotStateKt.derivedStateObservers();
        int r28 = r27.getSize();
        if (r28 <= 0) goto L79;
        DerivedStateObserver[] r29 = r27.getContent();
        int r30 = 0;
    L45:
        r29[r30].start(this);
        r30 = r30 + 1;
        if (r30 < r28) goto L45;
    L79:
        SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(Integer.valueOf(r116 + 1));     // Catch: Throwable -> L71
        Object r117 = Snapshot.Companion.observe(new DerivedSnapshotState$currentRecord$result$1$result$1(this, r26, r116), null, r13);     // Catch: Throwable -> L71
        SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(Integer.valueOf(r116));     // Catch: Throwable -> L71
        int r31 = r27.getSize();
        if (r31 <= 0) goto L53;
        DerivedStateObserver[] r32 = r27.getContent();
    L51:
        r32[r5].done(this);
        r5 = r5 + 1;
        if (r5 < r31) goto L51;
    L53:
        Object r33 = SnapshotKt.getLock();
        monitor-enter(r33);
        Snapshot.Companion r34 = Snapshot.Companion;     // Catch: Throwable -> L62
        Snapshot r35 = r34.getCurrent();     // Catch: Throwable -> L62
        if (r10.getResult() == ResultRecord.Companion.getUnset()) goto L64;
        SnapshotMutationPolicy<T> r36 = getPolicy();     // Catch: Throwable -> L62
        if (r36 == 0) goto L64;
        if (r36.equivalent(r117, r10.getResult()) != true) goto L64;
        r10.set_dependencies(r26);     // Catch: Throwable -> L62
        r10.setResultHash(r10.readableHash(this, r35));     // Catch: Throwable -> L62
        r10.setValidSnapshotId(r11.getId());     // Catch: Throwable -> L62
        r10.setValidSnapshotWriteCount(r11.getWriteCount$runtime_release());     // Catch: Throwable -> L62
    L65:
        monitor-exit(r33);
        if (r116 != 0) goto L68;
        r34.notifyObjectsInitialized();
    L68:
        return r10;
    L64:
        r10 = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, r35);     // Catch: Throwable -> L62
        r10.set_dependencies(r26);     // Catch: Throwable -> L62
        r10.setResultHash(r10.readableHash(this, r35));     // Catch: Throwable -> L62
        r10.setValidSnapshotId(r11.getId());     // Catch: Throwable -> L62
        r10.setValidSnapshotWriteCount(r11.getWriteCount$runtime_release());     // Catch: Throwable -> L62
        r10.setResult(r117);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;
    L71:
        th = move-exception;
        int r118 = r27.getSize();
        if (r118 <= 0) goto L78;
        DerivedStateObserver[] r119 = r27.getContent();
    L75:
        r119[r5].done(this);
        r5 = r5 + 1;
        if (r5 < r118) goto L75;
    L78:
        throw th;
    L41:
        r116 = 0;
        goto L42
    }

    private final String displayValue() {
        ResultRecord r5 = (ResultRecord) SnapshotKt.current(this.first);
        if (r5.isValid(this, Snapshot.Companion.getCurrent()) == true) goto L5;
        return "<Not calculated>";
    L5:
        return String.valueOf(r5.getResult());
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public final StateRecord current(Snapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, r5), r5, false, this.calculation);
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    public final T getDebuggerDisplayValue() {
        ResultRecord r5 = (ResultRecord) SnapshotKt.current(this.first);
        if (r5.isValid(this, Snapshot.Companion.getCurrent()) == true) goto L7;
        return null;
    L7:
        return (T) r5.getResult();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Snapshot.Companion r5 = Snapshot.Companion;
        Function1<Object, Unit> r10 = r5.getCurrent().getReadObserver$runtime_release();
        if (r10 == null) goto L6;
        r10.invoke(this);
    L6:
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), r5.getCurrent(), true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this.first = (ResultRecord) r5;
    }

    public String toString() {
        ResultRecord r5 = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }
}
