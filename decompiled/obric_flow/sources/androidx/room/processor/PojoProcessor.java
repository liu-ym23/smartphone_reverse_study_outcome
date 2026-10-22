package androidx.room.processor;

import ai.j0;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.ext.Xtype_extKt;
import androidx.room.log.RLog;
import androidx.room.preconditions.Checks;
import androidx.room.processor.autovalue.AutoValuePojoProcessorDelegate;
import androidx.room.processor.cache.Cache;
import androidx.room.vo.CallType;
import androidx.room.vo.Constructor;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.EntityOrView;
import androidx.room.vo.Field;
import androidx.room.vo.FieldSetter;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Index;
import androidx.room.vo.Junction;
import androidx.room.vo.Pojo;
import androidx.room.vo.PojoMethod;
import androidx.room.vo.Relation;
import androidx.room.vo.Warning;
import com.lynx.jsbridge.LynxResourceModule;
import fl.b;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u0001:\u0005TUVWXBK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J$\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J(\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J.\u0010)\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J|\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0!2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002000/2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001d0/2\u0018\u00104\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!\u0012\u0004\u0012\u00020\u001d0/H\u0002J4\u00105\u001a\u0004\u0018\u00010(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\t0!2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090!H\u0002J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0005H\u0002J6\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0!2\u0006\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020+2\u0006\u0010;\u001a\u00020\u0005H\u0002J\b\u0010D\u001a\u00020EH\u0002J\u0006\u0010F\u001a\u00020EJ\u001a\u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020JH\u0002J(\u0010K\u001a\u0004\u0018\u0001092\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\u0006\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020JH\u0002J+\u0010N\u001a\u00020\u001d2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0P2\u0006\u0010?\u001a\u00020@2\u0006\u0010M\u001a\u00020QH\u0002¢\u0006\u0002\u0010RJ4\u0010S\u001a\u0004\u0018\u00010\"2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0018\u00104\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!\u0012\u0004\u0012\u00020\u001d0/H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006Y"}, d2 = {"Landroidx/room/processor/PojoProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "bindingScope", "Landroidx/room/processor/FieldProcessor$BindingScope;", "parent", "Landroidx/room/vo/EmbeddedField;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "delegate", "Landroidx/room/processor/PojoProcessor$Delegate;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/processor/FieldProcessor$BindingScope;Landroidx/room/vo/EmbeddedField;Ljava/util/LinkedHashSet;Landroidx/room/processor/PojoProcessor$Delegate;)V", "getBindingScope", "()Landroidx/room/processor/FieldProcessor$BindingScope;", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "getParent", "()Landroidx/room/vo/EmbeddedField;", "getReferenceStack", "()Ljava/util/LinkedHashSet;", "assignGetter", "", "field", "Landroidx/room/vo/Field;", "getterCandidates", "", "Landroidx/room/vo/PojoMethod;", "assignGetters", "fields", "assignSetter", "setterCandidates", "constructor", "Landroidx/room/vo/Constructor;", "assignSetters", "chooseAssignment", "", "candidates", "nameVariations", "getType", "Lkotlin/Function1;", "Landroidx/room/compiler/processing/XType;", "assignFromField", "Lkotlin/Function0;", "assignFromMethod", "reportAmbiguity", "chooseConstructor", "myFields", "embedded", "relations", "Landroidx/room/vo/Relation;", "computeReferenceRecursionString", "typeElement", "createRelationshipProjection", "inferEntity", "typeArg", "entity", "Landroidx/room/vo/EntityOrView;", "entityField", "typeArgElement", "detectReferenceRecursion", "doProcess", "Landroidx/room/vo/Pojo;", "process", "processEmbeddedField", "declaredType", "variableElement", "Landroidx/room/compiler/processing/XFieldElement;", "processRelationField", "container", "relationElement", "validateRelationshipProjection", "projectionInput", "", "Landroidx/room/compiler/processing/XVariableElement;", "([Ljava/lang/String;Landroidx/room/vo/EntityOrView;Landroidx/room/compiler/processing/XVariableElement;)V", "verifyAndChooseOneFrom", "Companion", "DefaultDelegate", "Delegate", "EmptyDelegate", "FailedConstructor", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PojoProcessor {
    public static final Companion Companion = null;
    private static final List<KClass<? extends Annotation>> PROCESSED_ANNOTATIONS = null;
    private static final KClass<? extends Annotation>[] TARGET_METHOD_ANNOTATIONS = null;
    private final FieldProcessor.BindingScope bindingScope;
    private final Context context;
    private final Delegate delegate;
    private final XTypeElement element;
    private final EmbeddedField parent;
    private final LinkedHashSet<String> referenceStack;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bR\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/room/processor/PojoProcessor$Companion;", "", "()V", "PROCESSED_ANNOTATIONS", "", "Lkotlin/reflect/KClass;", "", "getPROCESSED_ANNOTATIONS", "()Ljava/util/List;", "TARGET_METHOD_ANNOTATIONS", "", "getTARGET_METHOD_ANNOTATIONS", "()[Lkotlin/reflect/KClass;", "[Lkotlin/reflect/KClass;", "createFor", "Landroidx/room/processor/PojoProcessor;", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "bindingScope", "Landroidx/room/processor/FieldProcessor$BindingScope;", "parent", "Landroidx/room/vo/EmbeddedField;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PojoProcessor createFor$default(Companion r10, Context r11, XTypeElement r12, FieldProcessor.BindingScope r13, EmbeddedField r14, LinkedHashSet r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L6;
            r15 = new LinkedHashSet();
        L6:
            return r10.createFor(r11, r12, r13, r14, r15);
        }

        public final PojoProcessor createFor(Context r10, XTypeElement r11, FieldProcessor.BindingScope r12, EmbeddedField r13, LinkedHashSet<String> r14) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "element");
            Intrinsics.checkNotNullParameter(r12, "bindingScope");
            Intrinsics.checkNotNullParameter(r14, "referenceStack");
            if (r11.hasAnnotation(Reflection.getOrCreateKotlinClass(b.class)) == false) goto L8;
            XProcessingEnv r15 = r10.getProcessingEnv();
            String r5 = AutoValuePojoProcessorDelegate.Companion.getGeneratedClassName(r11);
            XTypeElement r16 = r15.findTypeElement(r5);
            if (r16 == null) goto L7;
            Pair r17 = TuplesKt.to(r16, new AutoValuePojoProcessorDelegate(r10, r11));
        L10:
            return new PojoProcessor(r10, (XTypeElement) r17.component1(), r12, r13, r14, (Delegate) r17.component2(), null);
        L7:
            r10.reportMissingType(r5);
            r17 = TuplesKt.to(r11, EmptyDelegate.INSTANCE);
            goto L10
        L8:
            r17 = TuplesKt.to(r11, new DefaultDelegate(r10));
            goto L10
        }

        public final List<KClass<? extends Annotation>> getPROCESSED_ANNOTATIONS() {
            return PojoProcessor.access$getPROCESSED_ANNOTATIONS$cp();
        }

        public final KClass<? extends Annotation>[] getTARGET_METHOD_ANNOTATIONS() {
            return PojoProcessor.access$getTARGET_METHOD_ANNOTATIONS$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JL\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/processor/PojoProcessor$DefaultDelegate;", "Landroidx/room/processor/PojoProcessor$Delegate;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "createPojo", "Landroidx/room/vo/Pojo;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "declaredType", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "relations", "Landroidx/room/vo/Relation;", "constructor", "Landroidx/room/vo/Constructor;", "findConstructors", "Landroidx/room/compiler/processing/XConstructorElement;", "onPreProcess", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultDelegate implements Delegate {
        private final Context context;

        public DefaultDelegate(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            this.context = r5;
        }

        @Override // androidx.room.processor.PojoProcessor.Delegate
        public Pojo createPojo(XTypeElement r10, XType r11, List<Field> r12, List<EmbeddedField> r13, List<Relation> r14, Constructor r15) {
            Intrinsics.checkNotNullParameter(r10, "element");
            Intrinsics.checkNotNullParameter(r11, "declaredType");
            Intrinsics.checkNotNullParameter(r12, "fields");
            Intrinsics.checkNotNullParameter(r13, "embeddedFields");
            Intrinsics.checkNotNullParameter(r14, "relations");
            return new Pojo(r10, r11, r12, r13, r14, r15);
        }

        @Override // androidx.room.processor.PojoProcessor.Delegate
        public List<XConstructorElement> findConstructors(XTypeElement r5) {
            Intrinsics.checkNotNullParameter(r5, "element");
            List<XConstructorElement> r10 = r5.getConstructors();
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L11;
            Object r13 = r12.next();
            XConstructorElement r14 = (XConstructorElement) r13;
            if (r14.hasAnnotation(Reflection.getOrCreateKotlinClass(Ignore.class)) == true) goto L4;
            if (r14.isPrivate() == true) goto L4;
            r11.add(r13);
            goto L4
        L11:
            return r11;
        }

        @Override // androidx.room.processor.PojoProcessor.Delegate
        public void onPreProcess(XTypeElement r10) {
            Intrinsics.checkNotNullParameter(r10, "element");
            Iterator r11 = SequencesKt.filter(r10.getAllMethods(), PojoProcessor$DefaultDelegate$onPreProcess$1.INSTANCE).iterator();
        L4:
            if (r11.hasNext() == false) goto L13;
            XMethodElement r5 = (XMethodElement) r11.next();
            KClass<? extends Annotation>[] r12 = PojoProcessor.Companion.getTARGET_METHOD_ANNOTATIONS();
            int r13 = r12.length;
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L12;
            KClass<? extends Annotation> r15 = r12[r14];
            if (r5.hasAnnotation(r15) == true) goto L9;
            r14 = r14 + 1;
            goto L6
        L9:
            this.context.getLogger().e(r5, ProcessorErrors.INSTANCE.invalidAnnotationTarget(JvmClassMappingKt.getJavaClass(r15).getSimpleName(), r5.kindName()), new Object[0]);
            goto L4
        L12:
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/room/processor/PojoProcessor$Delegate;", "", "createPojo", "Landroidx/room/vo/Pojo;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "declaredType", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "relations", "Landroidx/room/vo/Relation;", "constructor", "Landroidx/room/vo/Constructor;", "findConstructors", "Landroidx/room/compiler/processing/XExecutableElement;", "onPreProcess", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Delegate {
        Pojo createPojo(XTypeElement r5, XType r10, List<Field> r11, List<EmbeddedField> r12, List<Relation> r13, Constructor r14);

        List<XExecutableElement> findConstructors(XTypeElement r5);

        void onPreProcess(XTypeElement r5);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, d2 = {"Landroidx/room/processor/PojoProcessor$EmptyDelegate;", "Landroidx/room/processor/PojoProcessor$Delegate;", "()V", "createPojo", "Landroidx/room/vo/Pojo;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "declaredType", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "relations", "Landroidx/room/vo/Relation;", "constructor", "Landroidx/room/vo/Constructor;", "findConstructors", "Landroidx/room/compiler/processing/XExecutableElement;", "onPreProcess", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EmptyDelegate implements Delegate {
        public static final EmptyDelegate INSTANCE = null;

        static {
            INSTANCE = new EmptyDelegate();
        }

        private EmptyDelegate() {
        }

        @Override // androidx.room.processor.PojoProcessor.Delegate
        public Pojo createPojo(XTypeElement r10, XType r11, List<Field> r12, List<EmbeddedField> r13, List<Relation> r14, Constructor r15) {
            Intrinsics.checkNotNullParameter(r10, "element");
            Intrinsics.checkNotNullParameter(r11, "declaredType");
            Intrinsics.checkNotNullParameter(r12, "fields");
            Intrinsics.checkNotNullParameter(r13, "embeddedFields");
            Intrinsics.checkNotNullParameter(r14, "relations");
            return new Pojo(r10, r11, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null);
        }

        @Override // androidx.room.processor.PojoProcessor.Delegate
        public List<XExecutableElement> findConstructors(XTypeElement r5) {
            Intrinsics.checkNotNullParameter(r5, "element");
            return CollectionsKt.emptyList();
        }

        @Override // androidx.room.processor.PojoProcessor.Delegate
        public void onPreProcess(XTypeElement r5) {
            Intrinsics.checkNotNullParameter(r5, "element");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0006J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/room/processor/PojoProcessor$FailedConstructor;", "", "method", "Landroidx/room/compiler/processing/XExecutableElement;", LynxResourceModule.PARAMS_KEY, "", "", "matches", "Landroidx/room/vo/Constructor$Param;", "(Landroidx/room/compiler/processing/XExecutableElement;Ljava/util/List;Ljava/util/List;)V", "getMatches", "()Ljava/util/List;", "getMethod", "()Landroidx/room/compiler/processing/XExecutableElement;", "getParams", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "log", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FailedConstructor {
        private final List<Constructor.Param> matches;
        private final XExecutableElement method;
        private final List<String> params;

        /* JADX WARN: Multi-variable type inference failed */
        public FailedConstructor(XExecutableElement r5, List<String> r10, List<? extends Constructor.Param> r11) {
            Intrinsics.checkNotNullParameter(r5, "method");
            Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
            Intrinsics.checkNotNullParameter(r11, "matches");
            this.method = r5;
            this.params = r10;
            this.matches = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FailedConstructor copy$default(FailedConstructor r5, XExecutableElement r10, List r11, List r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = r5.method;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = r5.params;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r12 = r5.matches;
        L12:
            return r5.copy(r10, r11, r12);
        }

        public final XExecutableElement component1() {
            return this.method;
        }

        public final List<String> component2() {
            return this.params;
        }

        public final List<Constructor.Param> component3() {
            return this.matches;
        }

        public final FailedConstructor copy(XExecutableElement r5, List<String> r10, List<? extends Constructor.Param> r11) {
            Intrinsics.checkNotNullParameter(r5, "method");
            Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
            Intrinsics.checkNotNullParameter(r11, "matches");
            return new FailedConstructor(r5, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof FailedConstructor) == true) goto L8;
            return false;
        L8:
            FailedConstructor r10 = (FailedConstructor) r5;
            if (Intrinsics.areEqual(this.method, r10.method) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.params, r10.params) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.matches, r10.matches) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final List<Constructor.Param> getMatches() {
            return this.matches;
        }

        public final XExecutableElement getMethod() {
            return this.method;
        }

        public final List<String> getParams() {
            return this.params;
        }

        public int hashCode() {
            int r5 = this.method.hashCode() * 31;
            int r10 = androidx.constraintlayout.motion.widget.a.f(this.params, r5, 31);
            return this.matches.hashCode() + r10;
        }

        public final String log() {
            String r5 = CollectionsKt.q(CollectionsKt.withIndex(this.params), ", ", null, null, 0, null, new PojoProcessor$FailedConstructor$log$logPerParam$1(this), 30);
            return this.method + " -> [" + r5 + "]";
        }

        public String toString() {
            return "FailedConstructor(method=" + this.method + ", params=" + this.params + ", matches=" + this.matches + ")";
        }
    }

    static {
        Companion = new Companion(null);
        PROCESSED_ANNOTATIONS = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(ColumnInfo.class), Reflection.getOrCreateKotlinClass(Embedded.class), Reflection.getOrCreateKotlinClass(androidx.room.Relation.class)});
        TARGET_METHOD_ANNOTATIONS = new KClass[]{Reflection.getOrCreateKotlinClass(PrimaryKey.class), Reflection.getOrCreateKotlinClass(ColumnInfo.class), Reflection.getOrCreateKotlinClass(Embedded.class), Reflection.getOrCreateKotlinClass(androidx.room.Relation.class)};
    }

    public /* synthetic */ PojoProcessor(Context r5, XTypeElement r10, FieldProcessor.BindingScope r11, EmbeddedField r12, LinkedHashSet r13, Delegate r14, DefaultConstructorMarker r15) {
        this(r5, r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ Pojo access$doProcess(PojoProcessor r5) {
        return r5.doProcess();
    }

    public static final /* synthetic */ List access$getPROCESSED_ANNOTATIONS$cp() {
        return PROCESSED_ANNOTATIONS;
    }

    public static final /* synthetic */ KClass[] access$getTARGET_METHOD_ANNOTATIONS$cp() {
        return TARGET_METHOD_ANNOTATIONS;
    }

    private final void assignGetter(final Field r10, List<PojoMethod> r11) {
        boolean r12 = chooseAssignment(r10, r11, r10.getGetterNameWithVariations(), PojoProcessor$assignGetter$success$1.INSTANCE, new PojoProcessor$assignGetter$success$2(r10), new PojoProcessor$assignGetter$success$3(r10), new PojoProcessor$assignGetter$success$4(this, r10));
        Checks r5 = this.context.getChecker();
        if (r12 == false) goto L5;
    L8:
        boolean r13 = true;
    L9:
        XFieldElement r14 = r10.getElement();
        ProcessorErrors r15 = ProcessorErrors.INSTANCE;
        r5.check(r13, r14, r15.getCANNOT_FIND_GETTER_FOR_FIELD(), new Object[0]);
        if (r12 == true) goto L12;
        return;
    L12:
        if (r10.getGetter().getType().isSameType(r10.getType()) == true) goto L16;
        this.context.getLogger().w(Warning.MISMATCHED_GETTER_TYPE, r10.getElement(), r15.mismatchedGetter(r10.getName(), this.element.getType().getTypeName(), r10.getGetter().getType().getTypeName(), XTypeNameKt.toJavaPoet(r10.getTypeName())), new Object[0]);
        r10.setStatementBinder(this.context.getTypeAdapterStore().findStatementValueBinder(r10.getGetter().getType(), r10.getAffinity()));
        return;
    L16:
        return;
    L5:
        if (this.bindingScope == FieldProcessor.BindingScope.READ_FROM_CURSOR) goto L8;
        r13 = false;
        goto L9
    }

    private final void assignGetters(List<Field> r5, List<PojoMethod> r10) {
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        assignGetter((Field) r11.next(), r10);
        goto L4
    }

    private final void assignSetter(final Field r10, List<PojoMethod> r11, Constructor r12) {
        if (r12 != null) goto L4;
    L7:
        boolean r13 = chooseAssignment(r10, r11, r10.getSetterNameWithVariations(), PojoProcessor$assignSetter$success$1.INSTANCE, new PojoProcessor$assignSetter$success$2(r10), new PojoProcessor$assignSetter$success$3(r10), new PojoProcessor$assignSetter$success$4(this, r10));
        Checks r14 = this.context.getChecker();
        if (r13 == false) goto L10;
    L13:
        boolean r5 = true;
    L14:
        XFieldElement r15 = r10.getElement();
        ProcessorErrors r16 = ProcessorErrors.INSTANCE;
        r14.check(r5, r15, r16.getCANNOT_FIND_SETTER_FOR_FIELD(), new Object[0]);
        if (r13 == true) goto L17;
        return;
    L17:
        if (r10.getSetter().getType().isSameType(r10.getType()) == true) goto L21;
        this.context.getLogger().w(Warning.MISMATCHED_SETTER_TYPE, r10.getElement(), r16.mismatchedSetter(r10.getName(), this.element.getType().getTypeName(), r10.getSetter().getType().getTypeName(), XTypeNameKt.toJavaPoet(r10.getTypeName())), new Object[0]);
        r10.setCursorValueReader(this.context.getTypeAdapterStore().findCursorValueReader(r10.getSetter().getType(), r10.getAffinity()));
        return;
    L21:
        return;
    L10:
        if (this.bindingScope == FieldProcessor.BindingScope.BIND_TO_STMT) goto L13;
        r5 = false;
        goto L14
    L4:
        if (r12.hasField(r10) == false) goto L7;
        r10.setSetter(new FieldSetter(r10.getName(), r10.getType(), CallType.CONSTRUCTOR));
    }

    private final void assignSetters(List<Field> r5, List<PojoMethod> r10, Constructor r11) {
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        assignSetter((Field) r12.next(), r10, r11);
        goto L4
    }

    private final boolean chooseAssignment(Field r10, List<PojoMethod> r11, List<String> r12, Function1<? super PojoMethod, ? extends XType> r13, Function0<Unit> r14, Function1<? super PojoMethod, Unit> r15, Function1<? super List<String>, Unit> r16) {
        if (r10.getElement().isPublic() == false) goto L6;
        r14.invoke();
        return true;
    L6:
        ArrayList r5 = new ArrayList();
        Iterator<T> r17 = r11.iterator();
    L8:
        if (r17.hasNext() == false) goto L16;
        Object r18 = r17.next();
        PojoMethod r19 = (PojoMethod) r18;
        if (r10.getType().isAssignableFromWithoutVariance(r13.invoke(r19)) == false) goto L8;
        if (r10.getNameWithVariations().contains(r19.getElement().getName()) == true) goto L15;
        if (r12.contains(r19.getElement().getName()) == false) goto L8;
    L15:
        r5.add(r18);
        goto L8
    L16:
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r21 = r5.iterator();
    L18:
        if (r21.hasNext() == false) goto L24;
        Object r110 = r21.next();
        Boolean r22 = Boolean.valueOf(((PojoMethod) r110).getElement().isPublic());
        Object r23 = r20.get(r22);
        if (r23 != null) goto L22;
        r23 = new ArrayList();
        r20.put(r22, r23);
    L22:
        ((List) r23).add(r110);
        goto L18
    L24:
        if (r20.isEmpty() == false) goto L27;
        r14.invoke();
        return !r10.getElement().isPrivate();
    L27:
        PojoMethod r24 = verifyAndChooseOneFrom((List) r20.get(Boolean.TRUE), r16);
        if (r24 != null) goto L30;
        r24 = verifyAndChooseOneFrom((List) r20.get(Boolean.FALSE), r16);
    L30:
        if (r24 != null) goto L33;
        r14.invoke();
        return false;
    L33:
        r15.invoke(r24);
        return true;
    }

    private final Constructor chooseConstructor(List<Field> r27, List<EmbeddedField> r28, List<Relation> r29) {
        List<XExecutableElement> r5 = this.delegate.findConstructors(this.element);
        LinkedHashMap r10 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r27, 16));
        Iterator<T> r11 = r27.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Object r12 = r11.next();
        r10.put(((Field) r12).getName(), r12);
        goto L4
    L6:
        LinkedHashMap r13 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r28, 16));
        Iterator<T> r14 = r28.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Object r15 = r14.next();
        r13.put(((EmbeddedField) r15).getField().getName(), r15);
        goto L8
    L10:
        LinkedHashMap r16 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r29, 16));
        Iterator<T> r17 = r29.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        Object r18 = r17.next();
        r16.put(((Relation) r18).getField().getName(), r18);
        goto L12
    L14:
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList(CollectionsKt.h(r5));
        Iterator r21 = r5.iterator();
    L16:
        if (r21.hasNext() == false) goto L106;
        XExecutableElement r22 = (XExecutableElement) r21.next();
        List<XExecutableParameterElement> r110 = r22.getParameters();
        ArrayList r111 = new ArrayList(CollectionsKt.h(r110));
        Iterator<T> r112 = r110.iterator();
    L19:
        if (r112.hasNext() == false) goto L21;
        r111.add(((XExecutableParameterElement) r112.next()).getName());
        goto L19
    L21:
        List<XExecutableParameterElement> r113 = r22.getParameters();
        ArrayList r114 = new ArrayList(CollectionsKt.h(r113));
        Iterator r115 = r113.iterator();
        int r116 = 0;
    L23:
        if (r115.hasNext() == false) goto L95;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        XExecutableParameterElement r119 = (XExecutableParameterElement) r117;
        final String r120 = (String) r111.get(r116);
        Iterator r121 = r21;
        final XType r23 = r119.getType();
        Function1<Field, Boolean> r24 = new PojoProcessor$chooseConstructor$goodConstructors$1$params$1$matches$1(r120, r23);
        Field r25 = (Field) r10.get(r120);
        if (r24.invoke(r25).booleanValue() == false) goto L31;
        Intrinsics.checkNotNull(r25);
        Constructor.Param r26 = new Constructor.Param.FieldParam(r25);
        r10 = r10;
    L30:
        LinkedHashMap r210 = r13;
        r115 = r115;
    L94:
        r114.add(r26);
        r21 = r121;
        r116 = r118;
        r10 = r10;
        r16 = r16;
        r13 = r210;
        r115 = r115;
        goto L23
    L31:
        EmbeddedField r30 = (EmbeddedField) r13.get(r120);
        if (r30 == null) goto L34;
        Field r31 = r30.getField();
    L36:
        if (r24.invoke(r31).booleanValue() == false) goto L39;
        Intrinsics.checkNotNull(r30);
        r26 = new Constructor.Param.EmbeddedParam(r30);
        goto L30
    L39:
        Relation r32 = (Relation) r16.get(r120);
        if (r32 == null) goto L42;
        Field r33 = r32.getField();
    L44:
        if (r24.invoke(r33).booleanValue() == false) goto L46;
        Intrinsics.checkNotNull(r32);
        r26 = new Constructor.Param.RelationParam(r32);
        goto L30
    L46:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r27.iterator();
    L48:
        if (r35.hasNext() == false) goto L53;
        LinkedHashMap r211 = r16;
        Object r36 = r35.next();
        Iterator r212 = r35;
        if (r24.invoke((Field) r36).booleanValue() == false) goto L52;
        r34.add(r36);
    L52:
        r16 = r211;
        r35 = r212;
        goto L48
    L53:
        r16 = r16;
        ArrayList r37 = new ArrayList();
        Iterator r38 = r28.iterator();
    L55:
        if (r38.hasNext() == false) goto L60;
        Object r39 = r38.next();
        Iterator r213 = r38;
        if (r24.invoke(((EmbeddedField) r39).getField()).booleanValue() == false) goto L59;
        r37.add(r39);
    L59:
        r38 = r213;
        goto L55
    L60:
        ArrayList r40 = new ArrayList();
        Iterator r41 = r29.iterator();
    L62:
        if (r41.hasNext() == false) goto L67;
        LinkedHashMap r214 = r13;
        Object r42 = r41.next();
        Iterator r215 = r41;
        if (r24.invoke(((Relation) r42).getField()).booleanValue() == false) goto L66;
        r40.add(r42);
    L66:
        r13 = r214;
        r41 = r215;
        goto L62
    L67:
        r210 = r13;
        int r43 = r40.size() + (r37.size() + r34.size());
        if (r43 == 0) goto L84;
        if (r43 == 1) goto L85;
        RLog r44 = this.context.getLogger();
        ProcessorErrors r45 = ProcessorErrors.INSTANCE;
        String r46 = this.element.getQualifiedName();
        ArrayList r47 = new ArrayList(CollectionsKt.h(r34));
        Iterator r48 = r34.iterator();
    L73:
        if (r48.hasNext() == false) goto L75;
        r47.add(((Field) r48.next()).getPath());
        goto L73
    L75:
        ArrayList r49 = new ArrayList(CollectionsKt.h(r37));
        Iterator r50 = r37.iterator();
    L77:
        if (r50.hasNext() == false) goto L79;
        r49.add(((EmbeddedField) r50.next()).getField().getPath());
        goto L77
    L79:
        List r51 = CollectionsKt.plus(r47, r49);
        ArrayList r52 = new ArrayList(CollectionsKt.h(r40));
        Iterator r53 = r40.iterator();
    L81:
        if (r53.hasNext() == false) goto L83;
        r52.add(((Relation) r53.next()).getField().getPath());
        goto L81
    L83:
        r44.e(r119, r45.ambiguousConstructor(r46, r120, CollectionsKt.plus(r51, r52)), new Object[0]);
        goto L84
    L85:
        r115 = r115;
        if (r34.isEmpty() == true) goto L89;
        r26 = new Constructor.Param.FieldParam((Field) CollectionsKt.first(r34));
        goto L94
    L89:
        if (r37.isEmpty() == true) goto L92;
        Constructor.Param r54 = new Constructor.Param.EmbeddedParam((EmbeddedField) CollectionsKt.first(r37));
    L91:
        r26 = r54;
        goto L94
    L92:
        r54 = new Constructor.Param.RelationParam((Relation) CollectionsKt.first(r40));
    L84:
        r26 = null;
        goto L94
    L42:
        r33 = null;
        goto L44
    L34:
        r31 = null;
        goto L36
    L95:
        Iterator r122 = r21;
        LinkedHashMap r216 = r16;
        LinkedHashMap r217 = r10;
        LinkedHashMap r218 = r13;
        if (r114.isEmpty() == true) goto L104;
        Iterator r55 = r114.iterator();
    L100:
        if (r55.hasNext() == false) goto L104;
        if (((Constructor.Param) r55.next()) != null) goto L100;
        r19.add(new FailedConstructor(r22, r111, r114));
        Constructor r56 = null;
    L105:
        r20.add(r56);
        r21 = r122;
        r10 = r217;
        r16 = r216;
        r13 = r218;
    L104:
        r56 = new Constructor(r22, r114);
        goto L105
    L106:
        List r57 = CollectionsKt.m(r20);
        if (r57.isEmpty() == false) goto L115;
        if (r19.isEmpty() == true) goto L111;
        int r58 = 0;
        this.context.getLogger().e(this.element, j0.D(ProcessorErrors.INSTANCE.getMISSING_POJO_CONSTRUCTOR(), "\nTried the following constructors but they failed to match:\n", CollectionsKt.q(r19, "\n", null, null, 0, null, PojoProcessor$chooseConstructor$failureMsg$1.INSTANCE, 30)), new Object[0]);
    L112:
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getMISSING_POJO_CONSTRUCTOR(), new Object[r58]);
        return null;
    L111:
        r58 = 0;
        goto L112
    L115:
        if (r57.size() <= 1) goto L146;
        XConstructorElement r59 = this.element.findPrimaryConstructor();
        if (r59 == null) goto L126;
        Iterator r60 = r57.iterator();
    L120:
        if (r60.hasNext() == false) goto L124;
        Object r61 = r60.next();
        if (Intrinsics.areEqual(((Constructor) r61).getElement(), r59) == false) goto L120;
    L125:
        Constructor r62 = (Constructor) r61;
    L127:
        if (r62 == null) goto L129;
        return r62;
    L129:
        Iterator r63 = r57.iterator();
    L131:
        if (r63.hasNext() == false) goto L135;
        Object r64 = r63.next();
        if (((Constructor) r64).getParams().isEmpty() == false) goto L131;
    L136:
        Constructor r65 = (Constructor) r64;
        if (r65 == null) goto L140;
        this.context.getLogger().w(Warning.DEFAULT_CONSTRUCTOR, this.element, ProcessorErrors.INSTANCE.getTOO_MANY_POJO_CONSTRUCTORS_CHOOSING_NO_ARG(), new Object[0]);
        return r65;
    L140:
        Iterator r66 = r57.iterator();
    L142:
        if (r66.hasNext() == false) goto L144;
        this.context.getLogger().e(((Constructor) r66.next()).getElement(), ProcessorErrors.INSTANCE.getTOO_MANY_POJO_CONSTRUCTORS(), new Object[0]);
        goto L142
    L144:
        return null;
    L135:
        r64 = null;
        goto L136
    L124:
        r61 = null;
        goto L125
    L126:
        r62 = null;
        goto L127
    L146:
        return (Constructor) CollectionsKt.first(r57);
    }

    private final String computeReferenceRecursionString(XTypeElement r10) {
        String r11 = r10.getQualifiedName();
        ArrayList r5 = new ArrayList();
        r5.add(r11);
        List r12 = CollectionsKt.toList(this.referenceStack);
        if (r12.isEmpty() == false) goto L5;
        List r13 = CollectionsKt.emptyList();
    L19:
        r5.addAll(r13);
        r5.add(r11);
        return CollectionsKt.q(r5, " -> ", null, null, 0, null, null, 62);
    L5:
        ListIterator r14 = r12.listIterator(r12.size());
    L7:
        if (r14.hasPrevious() == false) goto L18;
        if (Intrinsics.areEqual((String) r14.previous(), r11) == false) goto L7;
        r14.next();
        int r15 = r12.size() - r14.nextIndex();
        if (r15 != 0) goto L13;
        r13 = CollectionsKt.emptyList();
        goto L19
    L13:
        ArrayList r16 = new ArrayList(r15);
    L15:
        if (r14.hasNext() == false) goto L17;
        r16.add(r14.next());
        goto L15
    L17:
        r13 = r16;
        goto L19
    L18:
        r13 = CollectionsKt.toList(r12);
        goto L19
    }

    private final List<String> createRelationshipProjection(boolean r10, XType r11, EntityOrView r12, Field r13, XTypeElement r14) {
        if (r10 == true) goto L11;
        if (Intrinsics.areEqual(r11.getTypeName(), XTypeNameKt.toJavaPoet(r12.getTypeName())) == true) goto L11;
        if (this.context.getTypeAdapterStore().findCursorValueReader(r11, null) == null) goto L13;
        return CollectionsKt.listOf(r13.getName());
    L13:
        return HasFieldsKt.getColumnNames(Companion.createFor(this.context, r14, FieldProcessor.BindingScope.READ_FROM_CURSOR, this.parent, this.referenceStack).process());
    L11:
        return HasFieldsKt.getColumnNames(r12);
    }

    private final boolean detectReferenceRecursion(XTypeElement r5) {
        if (this.referenceStack.contains(r5.getQualifiedName()) == false) goto L6;
        this.context.getLogger().e(r5, String.format(ProcessorErrors.INSTANCE.getRECURSIVE_REFERENCE_DETECTED(), Arrays.copyOf(new Object[]{computeReferenceRecursionString(r5)}, 1)), new Object[0]);
        return true;
    L6:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [androidx.room.processor.PojoProcessor] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Iterable, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Iterable] */
    private final Pojo doProcess() {
        if (this.element.validate() == true) goto L6;
        this.context.reportMissingTypeReference(this.element.getQualifiedName());
        Delegate r5 = this.delegate;
        XTypeElement r10 = this.element;
        return r5.createPojo(r10, r10.getType(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null);
    L6:
        this.delegate.onPreProcess(this.element);
        final XType r11 = this.element.getType();
        Sequence r12 = SequencesKt.filter(this.element.getAllFieldsIncludingPrivateSupers(), PojoProcessor$doProcess$allFields$1.INSTANCE);
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r12.iterator();
    L7:
        KClass r15 = null;
        boolean r16 = false;
        if (r14.hasNext() == false) goto L36;
        Object r17 = r14.next();
        XFieldElement r18 = (XFieldElement) r17;
        Checks r19 = this.context.getChecker();
        List<KClass<? extends Annotation>> r20 = PROCESSED_ANNOTATIONS;
        if (r20 != null) goto L12;
    L14:
        Iterator r21 = r20.iterator();
        int r22 = 0;
    L16:
        if (r21.hasNext() == false) goto L23;
        if (r18.hasAnnotation((KClass) r21.next()) == false) goto L16;
        r22 = r22 + 1;
        if (r22 >= 0) goto L16;
        CollectionsKt.throwCountOverflow();
    L23:
        if (r22 >= 2) goto L25;
        boolean r23 = true;
    L26:
        r19.check(r23, r18, ProcessorErrors.INSTANCE.getCANNOT_USE_MORE_THAN_ONE_POJO_FIELD_ANNOTATION(), new Object[0]);
        if (r18.hasAnnotation(Reflection.getOrCreateKotlinClass(Embedded.class)) == false) goto L30;
        r15 = Reflection.getOrCreateKotlinClass(Embedded.class);
    L32:
        Object r24 = r13.get(r15);
        if (r24 != null) goto L35;
        r24 = new ArrayList();
        r13.put(r15, r24);
    L35:
        ((List) r24).add(r17);
        goto L7
    L30:
        if (r18.hasAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Relation.class)) == false) goto L32;
        r15 = Reflection.getOrCreateKotlinClass(androidx.room.Relation.class);
        goto L32
    L25:
        r23 = false;
        goto L26
    L12:
        if (r20.isEmpty() == false) goto L14;
        r22 = 0;
        goto L23
    L36:
        XAnnotationBox r25 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(Entity.class));
        if (r25 == null) goto L46;
        Entity r26 = (Entity) r25.getValue();
        if (r26 == null) goto L46;
        String[] r27 = r26.ignoredColumns();
        if (r27 == null) goto L46;
        Set r28 = ArraysKt.toSet(r27);
        if (r28 == null) goto L46;
    L45:
        Set r110 = r28;
        final LinkedHashMap r29 = new LinkedHashMap();
        List r30 = (List) r13.get(null);
        if (r30 == null) goto L54;
        ArrayList r31 = new ArrayList(CollectionsKt.h(r30));
        Iterator r111 = r30.iterator();
        ArrayList r32 = r31;
    L51:
        if (r111.hasNext() == false) goto L53;
        ArrayList r112 = r32;
        r112.add(new FieldProcessor(this.context, r11, (XFieldElement) r111.next(), this.bindingScope, this.parent, new PojoProcessor$doProcess$unfilteredMyFields$1$1(r29)).process());
        r29 = r29;
        r32 = r112;
        goto L51
    L53:
        LinkedHashMap r33 = r29;
        Collection r34 = r32;
    L55:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r34.iterator();
    L57:
        if (r36.hasNext() == false) goto L61;
        Object r37 = r36.next();
        if (r110.contains(((Field) r37).getColumnName()) == true) goto L57;
        r35.add(r37);
        goto L57
    L61:
        Iterator r38 = r35.iterator();
    L63:
        if (r38.hasNext() == false) goto L67;
        Field r39 = (Field) r38.next();
        String r40 = (String) r33.get(r39);
        if (r40 == null) goto L63;
        this.context.getLogger().e(r39.getElement(), r40, new Object[0]);
        Unit r41 = Unit.INSTANCE;
        goto L63
    L67:
        List r42 = (List) r13.get(Reflection.getOrCreateKotlinClass(Embedded.class));
        if (r42 == null) goto L75;
        ?? r43 = new ArrayList();
        Iterator r44 = r42.iterator();
    L71:
        if (r44.hasNext() == false) goto L76;
        EmbeddedField r45 = processEmbeddedField(r11, (XFieldElement) r44.next());
        if (r45 == null) goto L71;
        r43.add(r45);
    L76:
        ArrayList r46 = new ArrayList();
        Iterator r47 = r43.iterator();
    L78:
        if (r47.hasNext() == false) goto L82;
        Object r48 = r47.next();
        if (r110.contains(((EmbeddedField) r48).getField().getColumnName()) == true) goto L78;
        r46.add(r48);
        goto L78
    L82:
        ArrayList r49 = new ArrayList();
        Iterator r50 = r46.iterator();
    L84:
        if (r50.hasNext() == false) goto L86;
        CollectionsKt.a(r49, ((EmbeddedField) r50.next()).getPojo().getFields());
        goto L84
    L86:
        List<Field> r51 = CollectionsKt.plus(r35, r49);
        ArrayList r52 = new ArrayList(CollectionsKt.h(r43));
        Iterator r53 = r43.iterator();
    L88:
        if (r53.hasNext() == false) goto L90;
        r52.add(((EmbeddedField) r53.next()).getField());
        goto L88
    L90:
        List r54 = CollectionsKt.plus(r34, r52);
        ArrayList r55 = new ArrayList();
        Iterator r56 = r110.iterator();
    L92:
        if (r56.hasNext() == false) goto L106;
        Object r57 = r56.next();
        String r58 = (String) r57;
        if (r54 != null) goto L96;
    L98:
        Iterator r113 = r54.iterator();
    L100:
        if (r113.hasNext() == false) goto L97;
        if (Intrinsics.areEqual(((Field) r113.next()).getColumnName(), r58) == false) goto L100;
        boolean r59 = true;
    L104:
        if (r59 == true) goto L92;
        r55.add(r57);
    L97:
        r59 = false;
        goto L104
    L96:
        if (r54.isEmpty() == false) goto L98;
    L106:
        this.context.getChecker().check(r55.isEmpty(), this.element, ProcessorErrors.INSTANCE.missingIgnoredColumns(r55), new Object[0]);
        List r60 = (List) r13.get(Reflection.getOrCreateKotlinClass(androidx.room.Relation.class));
        if (r60 == null) goto L114;
        ?? r61 = new ArrayList();
        Iterator r62 = r60.iterator();
    L110:
        if (r62.hasNext() == false) goto L115;
        Relation r63 = processRelationField(r51, r11, (XFieldElement) r62.next());
        if (r63 == null) goto L110;
        r61.add(r63);
    L115:
        ArrayList r64 = new ArrayList();
        Iterator r65 = r46.iterator();
    L117:
        if (r65.hasNext() == false) goto L119;
        CollectionsKt.a(r64, ((EmbeddedField) r65.next()).getPojo().getRelations());
        goto L117
    L119:
        List<Relation> r66 = CollectionsKt.plus(r61, r64);
        LinkedHashMap r67 = new LinkedHashMap();
        Iterator r68 = r51.iterator();
    L121:
        if (r68.hasNext() == false) goto L126;
        Object r69 = r68.next();
        String r114 = ((Field) r69).getColumnName();
        Object r115 = r67.get(r114);
        if (r115 != null) goto L125;
        r115 = new ArrayList();
        r67.put(r114, r115);
    L125:
        ((List) r115).add(r69);
        goto L121
    L126:
        LinkedHashMap r70 = new LinkedHashMap();
        Iterator r71 = r67.entrySet().iterator();
    L128:
        if (r71.hasNext() == false) goto L135;
        Map.Entry r72 = (Map.Entry) r71.next();
        if (((List) r72.getValue()).size() <= 1) goto L132;
        boolean r116 = true;
    L133:
        if (r116 == false) goto L128;
        r70.put(r72.getKey(), r72.getValue());
        goto L128
    L132:
        r116 = false;
        goto L133
    L135:
        Iterator r73 = r70.entrySet().iterator();
    L137:
        if (r73.hasNext() == false) goto L147;
        Map.Entry r74 = (Map.Entry) r73.next();
        RLog r75 = this.context.getLogger();
        XTypeElement r117 = this.element;
        ProcessorErrors r118 = ProcessorErrors.INSTANCE;
        String r119 = (String) r74.getKey();
        Iterable r120 = (Iterable) r74.getValue();
        ArrayList r121 = new ArrayList(CollectionsKt.h(r120));
        Iterator r122 = r120.iterator();
    L140:
        if (r122.hasNext() == false) goto L142;
        r121.add(((Field) r122.next()).getPath());
        goto L140
    L142:
        r75.e(r117, r118.pojoDuplicateFieldNames(r119, r121), new Object[0]);
        Iterator r76 = ((Iterable) r74.getValue()).iterator();
    L144:
        if (r76.hasNext() == false) goto L146;
        this.context.getLogger().e(((Field) r76.next()).getElement(), ProcessorErrors.INSTANCE.getPOJO_FIELD_HAS_DUPLICATE_COLUMN_NAME(), new Object[0]);
        goto L144
    L146:
        r16 = false;
        goto L137
    L147:
        boolean r123 = r16;
        List r77 = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(this.element.getAllNonPrivateInstanceMethods(), PojoProcessor$doProcess$methods$1.INSTANCE), new PojoProcessor$doProcess$methods$2(this, r11)));
        ArrayList r78 = new ArrayList();
        Iterator r79 = r77.iterator();
    L149:
        if (r79.hasNext() == false) goto L158;
        Object r124 = r79.next();
        PojoMethod r125 = (PojoMethod) r124;
        if (r125.getElement().getParameters().size() == 0) goto L153;
    L155:
        boolean r126 = r123;
    L156:
        if (r126 == false) goto L149;
        r78.add(r124);
        goto L149
    L153:
        if (Xtype_extKt.isNotVoid(r125.getResolvedType().getReturnType()) == false) goto L155;
        r126 = true;
        goto L156
    L158:
        ArrayList r80 = new ArrayList();
        Iterator r81 = r77.iterator();
    L160:
        if (r81.hasNext() == false) goto L170;
        Object r127 = r81.next();
        PojoMethod r128 = (PojoMethod) r127;
        if (r128.getElement().getParameters().size() == 1) goto L164;
    L166:
        boolean r129 = r123;
    L167:
        if (r129 == false) goto L160;
        r80.add(r127);
        goto L160
    L164:
        if (XTypeKt.isVoid(r128.getResolvedType().getReturnType()) == false) goto L166;
        r129 = true;
        goto L167
    L170:
        if (this.bindingScope != FieldProcessor.BindingScope.BIND_TO_STMT) goto L172;
        Constructor r82 = null;
    L173:
        assignGetters(r35, r78);
        assignSetters(r35, r80, r82);
        Iterator r83 = r46.iterator();
    L175:
        if (r83.hasNext() == false) goto L177;
        EmbeddedField r130 = (EmbeddedField) r83.next();
        assignGetter(r130.getField(), r78);
        assignSetter(r130.getField(), r80, r82);
        goto L175
    L177:
        Iterator r84 = r61.iterator();
    L179:
        if (r84.hasNext() == false) goto L182;
        Relation r85 = (Relation) r84.next();
        assignGetter(r85.getField(), r78);
        assignSetter(r85.getField(), r80, r82);
        goto L179
    L182:
        return this.delegate.createPojo(this.element, r11, r51, r46, r66, r82);
    L172:
        r82 = chooseConstructor(r35, r46, r66);
        goto L173
    L114:
        r61 = CollectionsKt.emptyList();
        goto L115
    L75:
        r43 = CollectionsKt.emptyList();
        goto L76
    L54:
        r33 = r29;
        r34 = CollectionsKt.emptyList();
    L46:
        r28 = SetsKt.emptySet();
        goto L45
    }

    private final EmbeddedField processEmbeddedField(XType r24, XFieldElement r25) {
        XType r5 = r25.asMemberOf(r24);
        XTypeElement r15 = r5.getTypeElement();
        if (r15 != null) goto L7;
        this.context.getLogger().e(r25, ProcessorErrors.INSTANCE.getEMBEDDED_TYPES_MUST_BE_A_CLASS_OR_INTERFACE(), new Object[0]);
        return null;
    L7:
        if (detectReferenceRecursion(r15) == false) goto L9;
        return null;
    L9:
        XAnnotationBox r10 = r25.getAnnotation(Reflection.getOrCreateKotlinClass(Embedded.class));
        if (r10 == null) goto L17;
        Embedded r11 = (Embedded) r10.getValue();
        if (r11 == null) goto L17;
        String r12 = r11.prefix();
        if (r12 == null) goto L17;
        String r13 = r12;
    L18:
        EmbeddedField r14 = this.parent;
        if (r14 == null) goto L24;
        String r16 = r14.getPrefix();
        if (r16 == null) goto L24;
        String r17 = r16;
    L25:
        EmbeddedField r18 = new EmbeddedField(new Field(r25, r25.getName(), r5, null, null, null, null, this.parent, false, false, 880, null), r17.concat(r13), this.parent);
        r18.setPojo(Companion.createFor(Context.fork$default(this.context, r25, null, 2, null), r15, this.bindingScope, r18, this.referenceStack).process());
        return r18;
    L24:
        r17 = "";
    L17:
        r13 = "";
        goto L18
    }

    private final Relation processRelationField(List<Field> r25, XType r26, XFieldElement r27) {
        XAnnotationBox r15 = r27.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Relation.class));
        Intrinsics.checkNotNull(r15);
        Iterator<T> r5 = r25.iterator();
    L3:
        Junction r10 = null;
        if (r5.hasNext() == false) goto L8;
        Object r11 = r5.next();
        if (Intrinsics.areEqual(((Field) r11).getColumnName(), ((androidx.room.Relation) r15.getValue()).parentColumn()) == false) goto L3;
    L9:
        Field r16 = (Field) r11;
        if (r16 != null) goto L17;
        RLog r12 = this.context.getLogger();
        ProcessorErrors r13 = ProcessorErrors.INSTANCE;
        String r14 = this.element.getQualifiedName();
        String r17 = ((androidx.room.Relation) r15.getValue()).parentColumn();
        ArrayList r18 = new ArrayList(CollectionsKt.h(r25));
        Iterator<T> r19 = r25.iterator();
    L13:
        if (r19.hasNext() == false) goto L15;
        r18.add(((Field) r19.next()).getColumnName());
        goto L13
    L15:
        r12.e(r27, r13.relationCannotFindParentEntityField(r14, r17, r18), new Object[0]);
        return null;
    L17:
        XType r20 = r27.asMemberOf(r26);
        if (XTypeKt.isCollection(r20) == false) goto L20;
        r20 = ((XType) CollectionsKt.first(r20.getTypeArguments())).extendsBoundOrSelf();
    L20:
        XType r110 = r20;
        XTypeElement r111 = r110.getTypeElement();
        if (r111 != null) goto L24;
        this.context.getLogger().e(r27, ProcessorErrors.INSTANCE.getRELATION_TYPE_MUST_BE_A_CLASS_OR_INTERFACE(), new Object[0]);
        return null;
    L24:
        XType r21 = r15.getAsType("entity");
        if (r21 != null) goto L27;
    L30:
        boolean r112 = true;
    L31:
        if (r112 == false) goto L33;
        XTypeElement r22 = r111;
    L34:
        if (r22 != null) goto L38;
        this.context.getLogger().e(r111, ProcessorErrors.INSTANCE.getRELATION_TYPE_MUST_BE_A_CLASS_OR_INTERFACE(), new Object[0]);
        return null;
    L38:
        if (detectReferenceRecursion(r22) == false) goto L40;
        return null;
    L40:
        EntityOrView r113 = EntityOrViewProcessorKt.EntityOrViewProcessor(this.context, r22, this.referenceStack).process();
        Field r114 = HasFieldsKt.findFieldByColumnName(r113, ((androidx.room.Relation) r15.getValue()).entityColumn());
        if (r114 != null) goto L44;
        this.context.getLogger().e(r27, ProcessorErrors.INSTANCE.relationCannotFindEntityField(XTypeNameKt.toJavaPoet(r113.getTypeName()).toString(), ((androidx.room.Relation) r15.getValue()).entityColumn(), HasFieldsKt.getColumnNames(r113)), new Object[0]);
        return null;
    L44:
        XAnnotationBox r23 = r15.getAsAnnotationBox("associateBy");
        XType r24 = r23.getAsType("value");
        if (r24 != null) goto L47;
    L51:
        final XTypeElement r28 = null;
    L52:
        if (r28 == null) goto L66;
        final EntityOrView r29 = EntityOrViewProcessorKt.EntityOrViewProcessor(this.context, r28, this.referenceStack).process();
        if (((androidx.room.Junction) r23.getValue()).parentColumn().length() <= 0) goto L56;
        final String r30 = ((androidx.room.Junction) r23.getValue()).parentColumn();
    L57:
        Field r31 = processRelationField$lambda$43$findAndValidateJunctionColumn(r29, this, r30, new PojoProcessor$processRelationField$junction$1$junctionParentField$1(this, r28, r29, r30));
        if (((androidx.room.Junction) r23.getValue()).entityColumn().length() <= 0) goto L60;
        final String r32 = ((androidx.room.Junction) r23.getValue()).entityColumn();
    L61:
        Field r33 = processRelationField$lambda$43$findAndValidateJunctionColumn(r29, this, r32, new PojoProcessor$processRelationField$junction$1$junctionEntityField$1(this, r28, r29, r32));
        if (r31 == null) goto L67;
        if (r33 == null) goto L67;
        r10 = new Junction(r29, r31, r33);
    L67:
        return null;
    L60:
        r32 = r114.getColumnName();
        goto L61
    L56:
        r30 = r16.getColumnName();
    L66:
        Junction r210 = r10;
        Field r211 = new Field(r27, r27.getName(), r27.asMemberOf(r26), null, null, null, null, this.parent, false, false, 880, null);
        if (((androidx.room.Relation) r15.getValue()).projection().length != 0) goto L72;
        List<String> r34 = createRelationshipProjection(r112, r110, r113, r114, r111);
        EntityOrView r35 = r113;
    L74:
        return new Relation(r35, r110, r211, r16, r114, r210, r34);
    L72:
        r35 = r113;
        validateRelationshipProjection(((androidx.room.Relation) r15.getValue()).projection(), r35, r27);
        r34 = ArraysKt.asList(((androidx.room.Relation) r15.getValue()).projection());
        goto L74
    L47:
        if (r24.isTypeOf(Reflection.getOrCreateKotlinClass(Object.class)) == true) goto L51;
        r28 = r24.getTypeElement();
        if (r28 != null) goto L52;
        this.context.getLogger().e(r27, ProcessorErrors.INSTANCE.getNOT_ENTITY_OR_VIEW(), new Object[0]);
        goto L52
    L33:
        Intrinsics.checkNotNull(r21);
        r22 = r21.getTypeElement();
        goto L34
    L27:
        if (r21.isTypeOf(Reflection.getOrCreateKotlinClass(Object.class)) == true) goto L30;
        r112 = false;
        goto L31
    L8:
        r11 = null;
        goto L9
    }

    private static final Field processRelationField$lambda$43$findAndValidateJunctionColumn(EntityOrView r5, PojoProcessor r10, String r11, Function0<Unit> r12) {
        Field r13 = HasFieldsKt.findFieldByColumnName(r5, r11);
        if (r13 != null) goto L7;
        r12.invoke();
        return null;
    L7:
        if ((r5 instanceof androidx.room.vo.Entity) == false) goto L15;
        androidx.room.vo.Entity r14 = (androidx.room.vo.Entity) r5;
        Object r15 = CollectionsKt.first(r14.getPrimaryKey().getFields().getColumnNames$room_compiler());
        List<Index> r16 = r14.getIndices();
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r18 = r16.iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        r17.add((String) CollectionsKt.first(HasFieldsKt.getColumnNames((Index) r18.next())));
        goto L10
    L12:
        StringBuilder r19 = new StringBuilder();
        r19.append(r15);
        r19.append(r17);
        if (StringsKt.g(r19.toString(), r13.getColumnName()) == true) goto L15;
        r10.context.getLogger().w(Warning.MISSING_INDEX_ON_JUNCTION, r13.getElement(), ProcessorErrors.INSTANCE.junctionColumnWithoutIndex(XTypeNameKt.toJavaPoet(r5.getTypeName()).toString(), r11), new Object[0]);
    L15:
        return r13;
    }

    private final void validateRelationshipProjection(String[] r5, EntityOrView r10, XVariableElement r11) {
        List<String> r12 = CollectionsKt.v(ArraysKt.toList(r5), HasFieldsKt.getColumnNames(r10));
        if (r12.isEmpty() == true) goto L6;
        this.context.getLogger().e(r11, ProcessorErrors.INSTANCE.relationBadProject(XTypeNameKt.toJavaPoet(r10.getTypeName()).toString(), r12, HasFieldsKt.getColumnNames(r10)), new Object[0]);
        return;
    }

    private final PojoMethod verifyAndChooseOneFrom(List<PojoMethod> r5, Function1<? super List<String>, Unit> r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.size() <= 1) goto L13;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r11.add(((PojoMethod) r12.next()).getElement().getName());
        goto L9
    L11:
        r10.invoke(r11);
    L13:
        return (PojoMethod) CollectionsKt.first(r5);
    }

    public final FieldProcessor.BindingScope getBindingScope() {
        return this.bindingScope;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final EmbeddedField getParent() {
        return this.parent;
    }

    public final LinkedHashSet<String> getReferenceStack() {
        return this.referenceStack;
    }

    public final Pojo process() {
        return this.context.getCache().getPojos().get(new Cache.PojoKey(this.element, this.bindingScope, this.parent), new AnonymousClass1(this));
    }

    private PojoProcessor(Context r5, XTypeElement r10, FieldProcessor.BindingScope r11, EmbeddedField r12, LinkedHashSet<String> r13, Delegate r14) {
        this.element = r10;
        this.bindingScope = r11;
        this.parent = r12;
        this.referenceStack = r13;
        this.delegate = r14;
        this.context = Context.fork$default(r5, r10, null, 2, null);
    }

    public /* synthetic */ PojoProcessor(Context r10, XTypeElement r11, FieldProcessor.BindingScope r12, EmbeddedField r13, LinkedHashSet r14, Delegate r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 16) == 0) goto L5;
        r14 = new LinkedHashSet();
    L5:
        this(r10, r11, r12, r13, r14, r15);
    }
}
