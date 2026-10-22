package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import com.squareup.javapoet.x;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b(\u0010'J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006HÆ\u0003¢\u0006\u0004\b)\u0010'J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003¢\u0006\u0004\b*\u0010'J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006HÆ\u0003¢\u0006\u0004\b+\u0010'J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003¢\u0006\u0004\b,\u0010'J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006HÆ\u0003¢\u0006\u0004\b-\u0010'J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006HÆ\u0003¢\u0006\u0004\b.\u0010'J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006HÆ\u0003¢\u0006\u0004\b/\u0010'J\u0012\u00100\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b0\u00101JÀ\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010;\u001a\u00020:2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b;\u0010<R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010=\u001a\u0004\b>\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010%R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010A\u001a\u0004\bB\u0010'R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010A\u001a\u0004\bC\u0010'R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010A\u001a\u0004\bD\u0010'R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010A\u001a\u0004\bE\u0010'R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010A\u001a\u0004\bF\u0010'R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010A\u001a\u0004\bG\u0010'R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010A\u001a\u0004\bH\u0010'R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010A\u001a\u0004\bI\u0010'R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010A\u001a\u0004\bJ\u0010'R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010K\u001a\u0004\bL\u00101R\u0018\u0010M\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020O8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR!\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010'R!\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010Q\u001a\u0004\b[\u0010'R\u001b\u0010_\u001a\u00020O8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010Q\u001a\u0004\b^\u0010S¨\u0006`"}, d2 = {"Landroidx/room/vo/Dao;", "", "Landroidx/room/compiler/processing/XTypeElement;", "element", "Landroidx/room/compiler/processing/XType;", "type", "", "Landroidx/room/vo/QueryMethod;", "queryMethods", "Landroidx/room/vo/RawQueryMethod;", "rawQueryMethods", "Landroidx/room/vo/InsertionMethod;", "insertionMethods", "Landroidx/room/vo/DeletionMethod;", "deletionMethods", "Landroidx/room/vo/UpdateMethod;", "updateMethods", "Landroidx/room/vo/UpsertionMethod;", "upsertionMethods", "Landroidx/room/vo/TransactionMethod;", "transactionMethods", "Landroidx/room/vo/KotlinBoxedPrimitiveMethodDelegate;", "delegatingMethods", "Landroidx/room/vo/KotlinDefaultMethodDelegate;", "kotlinDefaultMethodDelegates", "Lcom/squareup/javapoet/x;", "constructorParamType", "<init>", "(Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/squareup/javapoet/x;)V", "", "newSuffix", "", "setSuffix", "(Ljava/lang/String;)V", "component1", "()Landroidx/room/compiler/processing/XTypeElement;", "component2", "()Landroidx/room/compiler/processing/XType;", "component3", "()Ljava/util/List;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "()Lcom/squareup/javapoet/x;", "copy", "(Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/squareup/javapoet/x;)Landroidx/room/vo/Dao;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/compiler/processing/XTypeElement;", "getElement", "Landroidx/room/compiler/processing/XType;", "getType", "Ljava/util/List;", "getQueryMethods", "getRawQueryMethods", "getInsertionMethods", "getDeletionMethods", "getUpdateMethods", "getUpsertionMethods", "getTransactionMethods", "getDelegatingMethods", "getKotlinDefaultMethodDelegates", "Lcom/squareup/javapoet/x;", "getConstructorParamType", "suffix", "Ljava/lang/String;", "Landroidx/room/compiler/codegen/XClassName;", "typeName$delegate", "Lkotlin/Lazy;", "getTypeName", "()Landroidx/room/compiler/codegen/XClassName;", "typeName", "Landroidx/room/vo/DeleteOrUpdateShortcutMethod;", "deleteOrUpdateShortcutMethods$delegate", "getDeleteOrUpdateShortcutMethods", "deleteOrUpdateShortcutMethods", "Landroidx/room/vo/InsertOrUpsertShortcutMethod;", "insertOrUpsertShortcutMethods$delegate", "getInsertOrUpsertShortcutMethods", "insertOrUpsertShortcutMethods", "implTypeName$delegate", "getImplTypeName", "implTypeName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Dao {
    private final x constructorParamType;
    private final List<KotlinBoxedPrimitiveMethodDelegate> delegatingMethods;
    private final Lazy deleteOrUpdateShortcutMethods$delegate;
    private final List<DeletionMethod> deletionMethods;
    private final XTypeElement element;
    private final Lazy implTypeName$delegate;
    private final Lazy insertOrUpsertShortcutMethods$delegate;
    private final List<InsertionMethod> insertionMethods;
    private final List<KotlinDefaultMethodDelegate> kotlinDefaultMethodDelegates;
    private final List<QueryMethod> queryMethods;
    private final List<RawQueryMethod> rawQueryMethods;
    private String suffix;
    private final List<TransactionMethod> transactionMethods;
    private final XType type;
    private final Lazy typeName$delegate;
    private final List<UpdateMethod> updateMethods;
    private final List<UpsertionMethod> upsertionMethods;

    /* JADX WARN: Multi-variable type inference failed */
    public Dao(XTypeElement r5, XType r10, List<? extends QueryMethod> r11, List<RawQueryMethod> r12, List<InsertionMethod> r13, List<DeletionMethod> r14, List<UpdateMethod> r15, List<UpsertionMethod> r16, List<TransactionMethod> r17, List<KotlinBoxedPrimitiveMethodDelegate> r18, List<KotlinDefaultMethodDelegate> r19, x r110) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "queryMethods");
        Intrinsics.checkNotNullParameter(r12, "rawQueryMethods");
        Intrinsics.checkNotNullParameter(r13, "insertionMethods");
        Intrinsics.checkNotNullParameter(r14, "deletionMethods");
        Intrinsics.checkNotNullParameter(r15, "updateMethods");
        Intrinsics.checkNotNullParameter(r16, "upsertionMethods");
        Intrinsics.checkNotNullParameter(r17, "transactionMethods");
        Intrinsics.checkNotNullParameter(r18, "delegatingMethods");
        Intrinsics.checkNotNullParameter(r19, "kotlinDefaultMethodDelegates");
        this.element = r5;
        this.type = r10;
        this.queryMethods = r11;
        this.rawQueryMethods = r12;
        this.insertionMethods = r13;
        this.deletionMethods = r14;
        this.updateMethods = r15;
        this.upsertionMethods = r16;
        this.transactionMethods = r17;
        this.delegatingMethods = r18;
        this.kotlinDefaultMethodDelegates = r19;
        this.constructorParamType = r110;
        this.typeName$delegate = LazyKt.lazy(new Dao$typeName$2(this));
        this.deleteOrUpdateShortcutMethods$delegate = LazyKt.lazy(new Dao$deleteOrUpdateShortcutMethods$2(this));
        this.insertOrUpsertShortcutMethods$delegate = LazyKt.lazy(new Dao$insertOrUpsertShortcutMethods$2(this));
        this.implTypeName$delegate = LazyKt.lazy(new Dao$implTypeName$2(this));
    }

    public static final /* synthetic */ String access$getSuffix$p(Dao r5) {
        return r5.suffix;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Dao copy$default(Dao r13, XTypeElement r14, XType r15, List r16, List r17, List r18, List r19, List r20, List r21, List r22, List r23, List r24, x r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        XTypeElement r5 = r13.element;
    L7:
        if ((r26 & 2) == 0) goto L9;
        XType r10 = r13.type;
    L11:
        if ((r26 & 4) == 0) goto L13;
        List r11 = r13.queryMethods;
    L15:
        if ((r26 & 8) == 0) goto L17;
        List r12 = r13.rawQueryMethods;
    L19:
        if ((r26 & 16) == 0) goto L21;
        List r28 = r13.insertionMethods;
    L23:
        if ((r26 & 32) == 0) goto L25;
        List r29 = r13.deletionMethods;
    L27:
        if ((r26 & 64) == 0) goto L29;
        List r30 = r13.updateMethods;
    L31:
        if ((r26 & 128) == 0) goto L33;
        List r31 = r13.upsertionMethods;
    L35:
        if ((r26 & 256) == 0) goto L37;
        List r110 = r13.transactionMethods;
    L39:
        if ((r26 & 512) == 0) goto L41;
        List r111 = r13.delegatingMethods;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        List r112 = r13.kotlinDefaultMethodDelegates;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        x r32 = r13.constructorParamType;
    L51:
        return r13.copy(r5, r10, r11, r12, r28, r29, r30, r31, r110, r111, r112, r32);
    L49:
        r32 = r25;
        goto L51
    L45:
        r112 = r24;
        goto L47
    L41:
        r111 = r23;
        goto L43
    L37:
        r110 = r22;
        goto L39
    L33:
        r31 = r21;
        goto L35
    L29:
        r30 = r20;
        goto L31
    L25:
        r29 = r19;
        goto L27
    L21:
        r28 = r18;
        goto L23
    L17:
        r12 = r17;
        goto L19
    L13:
        r11 = r16;
        goto L15
    L9:
        r10 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final XTypeElement component1() {
        return this.element;
    }

    public final List<KotlinBoxedPrimitiveMethodDelegate> component10() {
        return this.delegatingMethods;
    }

    public final List<KotlinDefaultMethodDelegate> component11() {
        return this.kotlinDefaultMethodDelegates;
    }

    public final x component12() {
        return this.constructorParamType;
    }

    public final XType component2() {
        return this.type;
    }

    public final List<QueryMethod> component3() {
        return this.queryMethods;
    }

    public final List<RawQueryMethod> component4() {
        return this.rawQueryMethods;
    }

    public final List<InsertionMethod> component5() {
        return this.insertionMethods;
    }

    public final List<DeletionMethod> component6() {
        return this.deletionMethods;
    }

    public final List<UpdateMethod> component7() {
        return this.updateMethods;
    }

    public final List<UpsertionMethod> component8() {
        return this.upsertionMethods;
    }

    public final List<TransactionMethod> component9() {
        return this.transactionMethods;
    }

    public final Dao copy(XTypeElement r15, XType r16, List<? extends QueryMethod> r17, List<RawQueryMethod> r18, List<InsertionMethod> r19, List<DeletionMethod> r20, List<UpdateMethod> r21, List<UpsertionMethod> r22, List<TransactionMethod> r23, List<KotlinBoxedPrimitiveMethodDelegate> r24, List<KotlinDefaultMethodDelegate> r25, x r26) {
        Intrinsics.checkNotNullParameter(r15, "element");
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r17, "queryMethods");
        Intrinsics.checkNotNullParameter(r18, "rawQueryMethods");
        Intrinsics.checkNotNullParameter(r19, "insertionMethods");
        Intrinsics.checkNotNullParameter(r20, "deletionMethods");
        Intrinsics.checkNotNullParameter(r21, "updateMethods");
        Intrinsics.checkNotNullParameter(r22, "upsertionMethods");
        Intrinsics.checkNotNullParameter(r23, "transactionMethods");
        Intrinsics.checkNotNullParameter(r24, "delegatingMethods");
        Intrinsics.checkNotNullParameter(r25, "kotlinDefaultMethodDelegates");
        return new Dao(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Dao) == true) goto L8;
        return false;
    L8:
        Dao r10 = (Dao) r5;
        if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryMethods, r10.queryMethods) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rawQueryMethods, r10.rawQueryMethods) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.insertionMethods, r10.insertionMethods) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.deletionMethods, r10.deletionMethods) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.updateMethods, r10.updateMethods) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.upsertionMethods, r10.upsertionMethods) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.transactionMethods, r10.transactionMethods) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.delegatingMethods, r10.delegatingMethods) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.kotlinDefaultMethodDelegates, r10.kotlinDefaultMethodDelegates) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.constructorParamType, r10.constructorParamType) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final x getConstructorParamType() {
        return this.constructorParamType;
    }

    public final List<KotlinBoxedPrimitiveMethodDelegate> getDelegatingMethods() {
        return this.delegatingMethods;
    }

    public final List<DeleteOrUpdateShortcutMethod> getDeleteOrUpdateShortcutMethods() {
        return (List) this.deleteOrUpdateShortcutMethods$delegate.getValue();
    }

    public final List<DeletionMethod> getDeletionMethods() {
        return this.deletionMethods;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final XClassName getImplTypeName() {
        return (XClassName) this.implTypeName$delegate.getValue();
    }

    public final List<InsertOrUpsertShortcutMethod> getInsertOrUpsertShortcutMethods() {
        return (List) this.insertOrUpsertShortcutMethods$delegate.getValue();
    }

    public final List<InsertionMethod> getInsertionMethods() {
        return this.insertionMethods;
    }

    public final List<KotlinDefaultMethodDelegate> getKotlinDefaultMethodDelegates() {
        return this.kotlinDefaultMethodDelegates;
    }

    public final List<QueryMethod> getQueryMethods() {
        return this.queryMethods;
    }

    public final List<RawQueryMethod> getRawQueryMethods() {
        return this.rawQueryMethods;
    }

    public final List<TransactionMethod> getTransactionMethods() {
        return this.transactionMethods;
    }

    public final XType getType() {
        return this.type;
    }

    public final XClassName getTypeName() {
        return (XClassName) this.typeName$delegate.getValue();
    }

    public final List<UpdateMethod> getUpdateMethods() {
        return this.updateMethods;
    }

    public final List<UpsertionMethod> getUpsertionMethods() {
        return this.upsertionMethods;
    }

    public int hashCode() {
        int r5 = this.element.hashCode() * 31;
        int r10 = (this.type.hashCode() + r5) * 31;
        int r11 = androidx.constraintlayout.motion.widget.a.f(this.queryMethods, r10, 31);
        int r12 = androidx.constraintlayout.motion.widget.a.f(this.rawQueryMethods, r11, 31);
        int r13 = androidx.constraintlayout.motion.widget.a.f(this.insertionMethods, r12, 31);
        int r14 = androidx.constraintlayout.motion.widget.a.f(this.deletionMethods, r13, 31);
        int r15 = androidx.constraintlayout.motion.widget.a.f(this.updateMethods, r14, 31);
        int r16 = androidx.constraintlayout.motion.widget.a.f(this.upsertionMethods, r15, 31);
        int r17 = androidx.constraintlayout.motion.widget.a.f(this.transactionMethods, r16, 31);
        int r18 = androidx.constraintlayout.motion.widget.a.f(this.delegatingMethods, r17, 31);
        int r19 = androidx.constraintlayout.motion.widget.a.f(this.kotlinDefaultMethodDelegates, r18, 31);
        x r20 = this.constructorParamType;
        if (r20 != null) goto L5;
        int r21 = 0;
    L7:
        return r19 + r21;
    L5:
        r21 = r20.hashCode();
        goto L7
    }

    public final void setSuffix(String r5) {
        Intrinsics.checkNotNullParameter(r5, "newSuffix");
        if (this.suffix != null) goto L11;
        if (r5.length() <= 0) goto L9;
        this.suffix = j0.C("_", r5);
        return;
    L9:
        throw new IllegalArgumentException("suffix can't be empty");
    L11:
        throw new IllegalStateException("cannot set suffix twice");
    }

    public String toString() {
        return "Dao(element=" + this.element + ", type=" + this.type + ", queryMethods=" + this.queryMethods + ", rawQueryMethods=" + this.rawQueryMethods + ", insertionMethods=" + this.insertionMethods + ", deletionMethods=" + this.deletionMethods + ", updateMethods=" + this.updateMethods + ", upsertionMethods=" + this.upsertionMethods + ", transactionMethods=" + this.transactionMethods + ", delegatingMethods=" + this.delegatingMethods + ", kotlinDefaultMethodDelegates=" + this.kotlinDefaultMethodDelegates + ", constructorParamType=" + this.constructorParamType + ")";
    }
}
