package androidx.room.processor;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.SkipQueryVerification;
import androidx.room.Update;
import androidx.room.Upsert;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.log.RLog;
import androidx.room.preconditions.Checks;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.vo.Dao;
import androidx.room.vo.KotlinBoxedPrimitiveMethodDelegate;
import androidx.room.vo.Warning;
import com.squareup.javapoet.x;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0015H\u0002R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Landroidx/room/processor/DaoProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "dbType", "Landroidx/room/compiler/processing/XType;", "dbVerifier", "Landroidx/room/verifier/DatabaseVerifier;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/compiler/processing/XType;Landroidx/room/verifier/DatabaseVerifier;)V", "context", "getContext", "()Landroidx/room/processor/Context;", "getDbType", "()Landroidx/room/compiler/processing/XType;", "getDbVerifier", "()Landroidx/room/verifier/DatabaseVerifier;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "matchKotlinBoxedPrimitiveMethods", "", "Landroidx/room/vo/KotlinBoxedPrimitiveMethodDelegate;", "unannotatedMethods", "Landroidx/room/compiler/processing/XMethodElement;", "annotatedMethods", "process", "Landroidx/room/vo/Dao;", "validateEmptyConstructor", "", "constructors", "Landroidx/room/compiler/processing/XConstructorElement;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DaoProcessor {
    public static final Companion Companion = null;
    private static final List<KClass<? extends Annotation>> PROCESSED_ANNOTATIONS = null;
    private final Context context;
    private final XType dbType;
    private final DatabaseVerifier dbVerifier;
    private final XTypeElement element;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/processor/DaoProcessor$Companion;", "", "()V", "PROCESSED_ANNOTATIONS", "", "Lkotlin/reflect/KClass;", "", "getPROCESSED_ANNOTATIONS", "()Ljava/util/List;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<KClass<? extends Annotation>> getPROCESSED_ANNOTATIONS() {
            return DaoProcessor.access$getPROCESSED_ANNOTATIONS$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        PROCESSED_ANNOTATIONS = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Insert.class), Reflection.getOrCreateKotlinClass(Delete.class), Reflection.getOrCreateKotlinClass(Query.class), Reflection.getOrCreateKotlinClass(Update.class), Reflection.getOrCreateKotlinClass(Upsert.class), Reflection.getOrCreateKotlinClass(RawQuery.class)});
    }

    public DaoProcessor(Context r5, XTypeElement r10, XType r11, DatabaseVerifier r12) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "dbType");
        this.element = r10;
        this.dbType = r11;
        this.dbVerifier = r12;
        this.context = Context.fork$default(r5, r10, null, 2, null);
    }

    public static final /* synthetic */ List access$getPROCESSED_ANNOTATIONS$cp() {
        return PROCESSED_ANNOTATIONS;
    }

    private final List<KotlinBoxedPrimitiveMethodDelegate> matchKotlinBoxedPrimitiveMethods(List<? extends XMethodElement> r11, List<? extends XMethodElement> r12) {
        ArrayList r10 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L33;
        XMethodElement r5 = (XMethodElement) r13.next();
        Iterator<T> r14 = r12.iterator();
    L6:
        KotlinBoxedPrimitiveMethodDelegate r15 = null;
        if (r14.hasNext() == false) goto L27;
        Object r16 = r14.next();
        XMethodElement r17 = (XMethodElement) r16;
        if (Intrinsics.areEqual(r17.getJvmName(), r5.getJvmName()) == false) goto L6;
        if (r17.getParameters().size() != r5.getParameters().size()) goto L6;
        XType r18 = r17.getEnclosingElement().getType();
        if (r18 != null) goto L17;
        XMethodType r19 = r5.getExecutableType();
    L19:
        if (r17.getReturnType().boxed().isSameType(r19.getReturnType().boxed()) == false) goto L6;
        int r20 = r17.getParameters().size();
        int r21 = 0;
    L22:
        if (r21 >= r20) goto L28;
        if (Intrinsics.areEqual(r17.getParameters().get(r21).getType().boxed(), r19.getParameterTypes().get(r21).boxed()) == false) goto L6;
        r21 = r21 + 1;
    L28:
        XMethodElement r22 = (XMethodElement) r16;
        if (r22 == null) goto L31;
        r15 = new KotlinBoxedPrimitiveMethodDelegate(r5, r22);
    L31:
        if (r15 == null) goto L4;
        r10.add(r15);
        goto L4
    L17:
        r19 = r5.asMemberOf(r18);
        goto L19
    L27:
        r16 = null;
        goto L28
    L33:
        return r10;
    }

    private final void validateEmptyConstructor(List<? extends XConstructorElement> r5) {
        if (r5.isEmpty() == true) goto L19;
        if (r5 != null) goto L6;
    L8:
        Iterator<T> r10 = r5.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        if (((XConstructorElement) r10.next()).getParameters().isEmpty() == false) goto L10;
        return;
    L14:
        RLog r11 = this.context.getLogger();
        XTypeElement r12 = this.element;
        r11.e(r12, ProcessorErrors.INSTANCE.daoMustHaveMatchingConstructor(r12.getQualifiedName(), this.dbType.getTypeName().toString()), new Object[0]);
        return;
    L6:
        if (r5.isEmpty() == false) goto L8;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XType getDbType() {
        return this.dbType;
    }

    public final DatabaseVerifier getDbVerifier() {
        return this.dbVerifier;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final Dao process() {
        if (this.element.validate() == true) goto L6;
        this.context.reportMissingTypeReference(this.element.getQualifiedName());
        XTypeElement r5 = this.element;
        return new Dao(r5, r5.getType(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null);
    L6:
        Checks r10 = this.context.getChecker();
        XTypeElement r11 = this.element;
        KClass<? extends Annotation> r12 = Reflection.getOrCreateKotlinClass(androidx.room.Dao.class);
        ProcessorErrors r13 = ProcessorErrors.INSTANCE;
        r10.hasAnnotation(r11, r12, r13.getDAO_MUST_BE_ANNOTATED_WITH_DAO(), new Object[0]);
        Checks r14 = this.context.getChecker();
        if (this.element.isAbstract() == false) goto L9;
    L12:
        boolean r15 = true;
    L13:
        r14.check(r15, this.element, r13.getDAO_MUST_BE_AN_ABSTRACT_CLASS_OR_AN_INTERFACE(), new Object[0]);
        XType r16 = this.element.getType();
        Sequence<XMethodElement> r17 = this.element.getAllMethods();
        Sequence r18 = SequencesKt.filter(r17, DaoProcessor$process$methods$1.INSTANCE);
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.iterator();
    L15:
        if (r20.hasNext() == false) goto L59;
        Object r21 = r20.next();
        XMethodElement r110 = (XMethodElement) r21;
        Checks r22 = this.context.getChecker();
        List<KClass<? extends Annotation>> r111 = PROCESSED_ANNOTATIONS;
        if (r111 != null) goto L19;
    L21:
        Iterator<T> r112 = r111.iterator();
        int r113 = 0;
    L23:
        if (r112.hasNext() == false) goto L29;
        if (r110.hasAnnotation((KClass) r112.next()) == false) goto L23;
        r113 = r113 + 1;
        if (r113 >= 0) goto L23;
        CollectionsKt.throwCountOverflow();
        goto L23
    L29:
        int r23 = r113;
        int r24 = 1;
    L30:
        if (r23 > r24) goto L32;
        boolean r25 = true;
    L33:
        ProcessorErrors r26 = ProcessorErrors.INSTANCE;
        Sequence<XMethodElement> r114 = r17;
        XType r115 = r16;
        r22.check(r25, r110, r26.getINVALID_ANNOTATION_COUNT_IN_DAO_METHOD(), new Object[0]);
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(JvmName.class)) == false) goto L37;
        this.context.getLogger().w(Warning.JVM_NAME_ON_OVERRIDDEN_METHOD, r110, r26.getJVM_NAME_ON_OVERRIDDEN_METHOD(), new Object[0]);
    L37:
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(Query.class)) == false) goto L40;
        KClass r27 = Reflection.getOrCreateKotlinClass(Query.class);
    L55:
        Object r28 = r19.get(r27);
        if (r28 != null) goto L58;
        r28 = new ArrayList();
        r19.put(r27, r28);
    L58:
        ((List) r28).add(r21);
        r20 = r20;
        r17 = r114;
        r16 = r115;
        goto L15
    L40:
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(Insert.class)) == false) goto L43;
        r27 = Reflection.getOrCreateKotlinClass(Insert.class);
        goto L55
    L43:
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(Delete.class)) == false) goto L46;
        r27 = Reflection.getOrCreateKotlinClass(Delete.class);
        goto L55
    L46:
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(Update.class)) == false) goto L49;
        r27 = Reflection.getOrCreateKotlinClass(Update.class);
        goto L55
    L49:
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(RawQuery.class)) == false) goto L52;
        r27 = Reflection.getOrCreateKotlinClass(RawQuery.class);
        goto L55
    L52:
        if (r110.hasAnnotation(Reflection.getOrCreateKotlinClass(Upsert.class)) == false) goto L54;
        r27 = Reflection.getOrCreateKotlinClass(Upsert.class);
        goto L55
    L54:
        r27 = Reflection.getOrCreateKotlinClass(Object.class);
        goto L55
    L32:
        r25 = false;
        goto L33
    L19:
        if (r111.isEmpty() == false) goto L21;
        r24 = 1;
        r23 = 0;
        goto L30
    L59:
        Sequence<XMethodElement> r116 = r17;
        final XType r117 = r16;
        if (this.element.hasAnnotation(Reflection.getOrCreateKotlinClass(SkipQueryVerification.class)) == false) goto L62;
    L65:
        DatabaseVerifier r29 = null;
    L66:
        List r30 = (List) r19.get(Reflection.getOrCreateKotlinClass(Query.class));
        if (r30 == null) goto L73;
        ArrayList r31 = new ArrayList(CollectionsKt.h(r30));
        Iterator r32 = r30.iterator();
    L70:
        if (r32.hasNext() == false) goto L72;
        r31.add(new QueryMethodProcessor(this.context, r117, (XMethodElement) r32.next(), r29).process());
        goto L70
    L72:
        List r33 = r31;
    L74:
        List r34 = (List) r19.get(Reflection.getOrCreateKotlinClass(RawQuery.class));
        if (r34 == null) goto L81;
        ArrayList r35 = new ArrayList(CollectionsKt.h(r34));
        Iterator r36 = r34.iterator();
    L78:
        if (r36.hasNext() == false) goto L80;
        r35.add(new RawQueryMethodProcessor(this.context, r117, (XMethodElement) r36.next()).process());
        goto L78
    L80:
        List r37 = r35;
    L82:
        List r38 = (List) r19.get(Reflection.getOrCreateKotlinClass(Insert.class));
        if (r38 == null) goto L89;
        ArrayList r39 = new ArrayList(CollectionsKt.h(r38));
        Iterator r40 = r38.iterator();
    L86:
        if (r40.hasNext() == false) goto L88;
        r39.add(new InsertionMethodProcessor(this.context, r117, (XMethodElement) r40.next()).process());
        goto L86
    L88:
        List r118 = r39;
    L90:
        List r41 = (List) r19.get(Reflection.getOrCreateKotlinClass(Delete.class));
        if (r41 == null) goto L97;
        ArrayList r42 = new ArrayList(CollectionsKt.h(r41));
        Iterator r43 = r41.iterator();
    L94:
        if (r43.hasNext() == false) goto L96;
        r42.add(new DeletionMethodProcessor(this.context, r117, (XMethodElement) r43.next()).process());
        goto L94
    L96:
        List r119 = r42;
    L98:
        List r44 = (List) r19.get(Reflection.getOrCreateKotlinClass(Update.class));
        if (r44 == null) goto L105;
        ArrayList r45 = new ArrayList(CollectionsKt.h(r44));
        Iterator r46 = r44.iterator();
    L102:
        if (r46.hasNext() == false) goto L104;
        r45.add(new UpdateMethodProcessor(this.context, r117, (XMethodElement) r46.next()).process());
        goto L102
    L104:
        List r120 = r45;
    L106:
        List r47 = (List) r19.get(Reflection.getOrCreateKotlinClass(Upsert.class));
        if (r47 == null) goto L113;
        ArrayList r48 = new ArrayList(CollectionsKt.h(r47));
        Iterator r49 = r47.iterator();
    L110:
        if (r49.hasNext() == false) goto L112;
        r48.add(new UpsertionMethodProcessor(this.context, r117, (XMethodElement) r49.next()).process());
        goto L110
    L112:
        List r50 = r48;
    L114:
        Sequence r51 = SequencesKt.map(SequencesKt.filter(r116, DaoProcessor$process$transactionMethods$1.INSTANCE), new DaoProcessor$process$transactionMethods$2(this, r117));
        List<? extends XMethodElement> r52 = (List) r19.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (r52 != null) goto L118;
        r52 = CollectionsKt.emptyList();
    L118:
        if (this.element.getSuperClass() == null) goto L120;
    L124:
        List<KotlinBoxedPrimitiveMethodDelegate> r53 = matchKotlinBoxedPrimitiveMethods(r52, CollectionsKt.v(CollectionsKt.flatten(r19.values()), r52));
    L123:
        List<KotlinBoxedPrimitiveMethodDelegate> r121 = r53;
        if (this.element.isInterface() == false) goto L128;
        final List r54 = CollectionsKt.w(CollectionsKt.flatten(r19.values()), SequencesKt.map(r51, DaoProcessor$process$kotlinDefaultMethodDelegates$allProcessedMethods$1.INSTANCE));
        Sequence r55 = SequencesKt.mapNotNull(SequencesKt.filterNot(r116, new DaoProcessor$process$kotlinDefaultMethodDelegates$1(r54)), DaoProcessor$process$kotlinDefaultMethodDelegates$2.INSTANCE);
    L129:
        List<XConstructorElement> r56 = this.element.getConstructors();
        Iterator r57 = r56.iterator();
    L131:
        if (r57.hasNext() == false) goto L141;
        Object r122 = r57.next();
        XConstructorElement r123 = (XConstructorElement) r122;
        Iterator r124 = r57;
        if (r123.getParameters().size() == 1) goto L135;
    L137:
        boolean r58 = false;
    L138:
        if (r58 == true) goto L142;
        r57 = r124;
    L142:
        XConstructorElement r125 = (XConstructorElement) r122;
        if (r125 == null) goto L145;
        x r126 = r125.getParameters().get(0).getType().getTypeName();
    L146:
        List r127 = r50;
        this.context.getChecker().notUnbound(r117.getTypeName(), this.element, ProcessorErrors.INSTANCE.getCANNOT_USE_UNBOUND_GENERICS_IN_DAO_CLASSES(), new Object[0]);
        ArrayList r59 = new ArrayList(CollectionsKt.h(r121));
        Iterator<T> r60 = r121.iterator();
    L148:
        if (r60.hasNext() == false) goto L150;
        r59.add(((KotlinBoxedPrimitiveMethodDelegate) r60.next()).getElement());
        goto L148
    L150:
        Iterator r61 = CollectionsKt.v(r52, r59).iterator();
    L152:
        if (r61.hasNext() == false) goto L155;
        this.context.getLogger().e((XMethodElement) r61.next(), ProcessorErrors.INSTANCE.getINVALID_ANNOTATION_COUNT_IN_DAO_METHOD(), new Object[0]);
        goto L152
    L155:
        return new Dao(this.element, r117, r33, r37, r118, r119, r120, r127, SequencesKt.toList(r51), r121, SequencesKt.toList(r55), r126);
    L145:
        validateEmptyConstructor(r56);
        r126 = null;
        goto L146
    L135:
        if (r123.getParameters().get(0).getType().isAssignableFrom(this.dbType) == false) goto L137;
        r58 = true;
        goto L138
    L141:
        r122 = null;
        goto L142
    L128:
        r55 = SequencesKt.emptySequence();
        goto L129
    L120:
        if (this.element.getSuperInterfaceElements().isEmpty() == false) goto L124;
        r53 = CollectionsKt.emptyList();
        goto L123
    L113:
        r50 = CollectionsKt.emptyList();
        goto L114
    L105:
        r120 = CollectionsKt.emptyList();
        goto L106
    L97:
        r119 = CollectionsKt.emptyList();
        goto L98
    L89:
        r118 = CollectionsKt.emptyList();
        goto L90
    L81:
        r37 = CollectionsKt.emptyList();
        goto L82
    L73:
        r33 = CollectionsKt.emptyList();
        goto L74
    L62:
        if (this.element.hasAnnotation(Reflection.getOrCreateKotlinClass(RawQuery.class)) == true) goto L65;
        r29 = this.dbVerifier;
        goto L66
    L9:
        if (this.element.isInterface() == true) goto L12;
        r15 = false;
        goto L13
    }
}
