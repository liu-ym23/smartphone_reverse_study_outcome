package androidx.room.processor;

import androidx.room.BuiltInTypeConverters;
import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverters;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.preconditions.Checks;
import androidx.room.solver.types.CustomTypeConverterWrapper;
import androidx.room.vo.BuiltInConverterFlags;
import androidx.room.vo.CustomTypeConverter;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ*\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/room/processor/CustomConverterProcessor;", "", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;)V", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "process", "", "Landroidx/room/vo/CustomTypeConverter;", "processMethod", "container", "Landroidx/room/compiler/processing/XType;", "methodElement", "Landroidx/room/compiler/processing/XMethodElement;", "isContainerKotlinObject", "", "isProvidedConverter", "Companion", "ProcessResult", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CustomConverterProcessor {
    public static final Companion Companion = null;
    private final Context context;
    private final XTypeElement element;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Landroidx/room/processor/CustomConverterProcessor$Companion;", "", "()V", "findConverters", "Landroidx/room/processor/CustomConverterProcessor$ProcessResult;", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XElement;", "reportDuplicates", "", "converters", "", "Landroidx/room/vo/CustomTypeConverter;", "isInvalidReturnType", "", "Landroidx/room/compiler/processing/XType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ boolean access$isInvalidReturnType(Companion r5, XType r10) {
            return r5.isInvalidReturnType(r10);
        }

        private final boolean isInvalidReturnType(XType r5) {
            if (r5.isError() == false) goto L5;
        L10:
            return true;
        L5:
            if (XTypeKt.isVoid(r5) == true) goto L10;
            if (r5.isNone() == true) goto L10;
            return false;
        }

        private final void reportDuplicates(Context r10, List<CustomTypeConverter> r11) {
            LinkedHashMap r12 = new LinkedHashMap();
            Iterator<T> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L9;
            Object r5 = r13.next();
            CustomTypeConverter r14 = (CustomTypeConverter) r5;
            Pair r15 = TuplesKt.to(r14.getFrom().getTypeName(), r14.getTo().getTypeName());
            Object r16 = r12.get(r15);
            if (r16 != null) goto L8;
            r16 = new ArrayList();
            r12.put(r15, r16);
        L8:
            ((List) r16).add(r5);
            goto L4
        L9:
            LinkedHashMap r17 = new LinkedHashMap();
            Iterator r18 = r12.entrySet().iterator();
        L11:
            if (r18.hasNext() == false) goto L15;
            Map.Entry r19 = (Map.Entry) r18.next();
            if (((List) r19.getValue()).size() <= 1) goto L11;
            r17.put(r19.getKey(), r19.getValue());
            goto L11
        L15:
            Iterator r20 = r17.values().iterator();
        L17:
            if (r20.hasNext() == false) goto L34;
            List r110 = (List) r20.next();
            Iterator r21 = r110.iterator();
        L20:
            if (r21.hasNext() == false) goto L17;
            CustomTypeConverter r22 = (CustomTypeConverter) r21.next();
            ArrayList r23 = new ArrayList();
            Iterator r24 = r110.iterator();
        L23:
            if (r24.hasNext() == false) goto L32;
            Object r25 = r24.next();
            CustomTypeConverter r26 = (CustomTypeConverter) r25;
            if (r26 == r22) goto L23;
            if (r26.getFrom().isSameType(r22.getFrom()) == false) goto L23;
            if (r26.getTo().isSameType(r22.getTo()) == false) goto L23;
            r23.add(r25);
            goto L23
        L32:
            if (r23.isEmpty() == true) goto L20;
            r10.getLogger().e(r22.getMethod(), ProcessorErrors.INSTANCE.duplicateTypeConverters(r23), new Object[0]);
            goto L20
        }

        public final ProcessResult findConverters(Context r10, XElement r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "element");
            if (r11.hasAnnotation(Reflection.getOrCreateKotlinClass(TypeConverters.class)) == true) goto L7;
            return ProcessResult.EMPTY.INSTANCE;
        L7:
            if (r11.validate() == true) goto L10;
            r10.reportMissingTypeReference(r11.toString());
            return ProcessResult.EMPTY.INSTANCE;
        L10:
            XAnnotationBox r5 = r11.requireAnnotation(Reflection.getOrCreateKotlinClass(TypeConverters.class));
            List<XType> r12 = r5.getAsTypeList("value");
            LinkedHashSet r13 = new LinkedHashSet();
            Iterator<T> r14 = r12.iterator();
        L12:
            if (r14.hasNext() == false) goto L14;
            r13.add((XType) r14.next());
            goto L12
        L14:
            ArrayList r15 = new ArrayList();
            Iterator r16 = r13.iterator();
        L16:
            if (r16.hasNext() == false) goto L22;
            XType r17 = (XType) r16.next();
            XTypeElement r18 = r17.getTypeElement();
            if (r18 != null) goto L20;
            r10.getLogger().e(r11, ProcessorErrors.INSTANCE.typeConverterMustBeDeclared(r17.getTypeName()), new Object[0]);
            List<CustomTypeConverter> r19 = CollectionsKt.emptyList();
        L21:
            CollectionsKt.a(r15, r19);
            goto L16
        L20:
            r19 = new CustomConverterProcessor(r10, r18).process();
            goto L21
        L22:
            reportDuplicates(r10, r15);
            XAnnotationBox r20 = r5.getAsAnnotationBox("builtInTypeConverters");
            BuiltInConverterFlags r21 = new BuiltInConverterFlags(((BuiltInTypeConverters) r20.getValue()).enums(), ((BuiltInTypeConverters) r20.getValue()).uuid());
            ArrayList r22 = new ArrayList(CollectionsKt.h(r15));
            Iterator r23 = r15.iterator();
        L24:
            if (r23.hasNext() == false) goto L27;
            r22.add(new CustomTypeConverterWrapper((CustomTypeConverter) r23.next()));
            goto L24
        L27:
            return new ProcessResult(r13, r22, r21);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0086\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/room/processor/CustomConverterProcessor$ProcessResult;", "", "classes", "Ljava/util/LinkedHashSet;", "Landroidx/room/compiler/processing/XType;", "converters", "", "Landroidx/room/solver/types/CustomTypeConverterWrapper;", "builtInConverterFlags", "Landroidx/room/vo/BuiltInConverterFlags;", "(Ljava/util/LinkedHashSet;Ljava/util/List;Landroidx/room/vo/BuiltInConverterFlags;)V", "getBuiltInConverterFlags", "()Landroidx/room/vo/BuiltInConverterFlags;", "getClasses", "()Ljava/util/LinkedHashSet;", "getConverters", "()Ljava/util/List;", "plus", "other", "EMPTY", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class ProcessResult {
        private final BuiltInConverterFlags builtInConverterFlags;
        private final LinkedHashSet<XType> classes;
        private final List<CustomTypeConverterWrapper> converters;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/room/processor/CustomConverterProcessor$ProcessResult$EMPTY;", "Landroidx/room/processor/CustomConverterProcessor$ProcessResult;", "()V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class EMPTY extends ProcessResult {
            public static final EMPTY INSTANCE = null;

            static {
                INSTANCE = new EMPTY();
            }

            private EMPTY() {
                super(new LinkedHashSet(), CollectionsKt.emptyList(), BuiltInConverterFlags.Companion.getDEFAULT());
            }
        }

        public ProcessResult(LinkedHashSet<XType> r5, List<CustomTypeConverterWrapper> r10, BuiltInConverterFlags r11) {
            Intrinsics.checkNotNullParameter(r5, "classes");
            Intrinsics.checkNotNullParameter(r10, "converters");
            Intrinsics.checkNotNullParameter(r11, "builtInConverterFlags");
            this.classes = r5;
            this.converters = r10;
            this.builtInConverterFlags = r11;
        }

        public final BuiltInConverterFlags getBuiltInConverterFlags() {
            return this.builtInConverterFlags;
        }

        public final LinkedHashSet<XType> getClasses() {
            return this.classes;
        }

        public final List<CustomTypeConverterWrapper> getConverters() {
            return this.converters;
        }

        public final ProcessResult plus(ProcessResult r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            LinkedHashSet r10 = new LinkedHashSet();
            r10.addAll(this.classes);
            r10.addAll(r5.classes);
            return new ProcessResult(r10, CollectionsKt.plus(this.converters, r5.converters), r5.builtInConverterFlags.withNext(this.builtInConverterFlags));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CustomConverterProcessor(Context r5, XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "element");
        this.context = r5;
        this.element = r10;
    }

    private final CustomTypeConverter processMethod(XType r10, XMethodElement r11, boolean r12, boolean r13) {
        XType r14 = r11.asMemberOf(r10).getReturnType();
        boolean r5 = Companion.access$isInvalidReturnType(Companion, r14);
        Checks r15 = this.context.getChecker();
        boolean r16 = r11.isPublic();
        ProcessorErrors r17 = ProcessorErrors.INSTANCE;
        r15.check(r16, r11, r17.getTYPE_CONVERTER_MUST_BE_PUBLIC(), new Object[0]);
        if (r5 == false) goto L6;
        this.context.getLogger().e(r11, r17.getTYPE_CONVERTER_BAD_RETURN_TYPE(), new Object[0]);
        return null;
    L6:
        x r18 = r14.getTypeName();
        this.context.getChecker().notUnbound(r18, r11, r17.getTYPE_CONVERTER_UNBOUND_GENERIC(), new Object[0]);
        List<XExecutableParameterElement> r19 = r11.getParameters();
        if (r19.size() == 1) goto L10;
        this.context.getLogger().e(r11, r17.getTYPE_CONVERTER_MUST_RECEIVE_1_PARAM(), new Object[0]);
        return null;
    L10:
        ArrayList r20 = new ArrayList(CollectionsKt.h(r19));
        Iterator<T> r21 = r19.iterator();
    L12:
        if (r21.hasNext() == false) goto L14;
        r20.add(((XExecutableParameterElement) r21.next()).asMemberOf(r10));
        goto L12
    L14:
        XType r22 = (XType) CollectionsKt.first(r20);
        this.context.getChecker().notUnbound(r22.getTypeName(), r19.get(0), ProcessorErrors.INSTANCE.getTYPE_CONVERTER_UNBOUND_GENERIC(), new Object[0]);
        return new CustomTypeConverter(r10, r12, r11, r22, r14, r13);
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final List<CustomTypeConverter> process() {
        if (this.element.validate() == true) goto L5;
        this.context.reportMissingTypeReference(this.element.getQualifiedName());
    L5:
        List r5 = SequencesKt.toList(SequencesKt.filter(this.element.getAllMethods(), CustomConverterProcessor$process$converterMethods$1.INSTANCE));
        boolean r10 = this.element.hasAnnotation(Reflection.getOrCreateKotlinClass(ProvidedTypeConverter.class));
        boolean r11 = true;
        this.context.getChecker().check(!r5.isEmpty(), this.element, ProcessorErrors.INSTANCE.getTYPE_CONVERTER_EMPTY_CLASS(), new Object[0]);
        if (r5 != null) goto L8;
    L10:
        Iterator r12 = r5.iterator();
    L12:
        if (r12.hasNext() == false) goto L9;
        if (((XMethodElement) r12.next()).isStatic() == true) goto L12;
        boolean r13 = false;
    L16:
        List<XConstructorElement> r14 = this.element.getConstructors();
        boolean r15 = this.element.isKotlinObject();
        if (r10 == true) goto L41;
        Checks r16 = this.context.getChecker();
        if (this.element.getEnclosingTypeElement() != null) goto L21;
    L24:
        boolean r17 = true;
    L25:
        r16.check(r17, this.element, ProcessorErrors.INSTANCE.getINNER_CLASS_TYPE_CONVERTER_MUST_BE_STATIC(), new Object[0]);
        Checks r18 = this.context.getChecker();
        if (r15 == true) goto L40;
        if (r13 == true) goto L40;
        if (r14.isEmpty() == true) goto L40;
        if (r14.isEmpty() == true) goto L39;
        Iterator<T> r19 = r14.iterator();
    L35:
        if (r19.hasNext() == false) goto L39;
        if (((XConstructorElement) r19.next()).getParameters().isEmpty() == false) goto L35;
    L39:
        r11 = false;
    L40:
        r18.check(r11, this.element, ProcessorErrors.INSTANCE.getTYPE_CONVERTER_MISSING_NOARG_CONSTRUCTOR(), new Object[0]);
        goto L41
    L21:
        if (this.element.isStatic() == true) goto L24;
        r17 = false;
    L41:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r5.iterator();
    L43:
        if (r21.hasNext() == false) goto L47;
        CustomTypeConverter r22 = processMethod(this.element.getType(), (XMethodElement) r21.next(), r15, r10);
        if (r22 == null) goto L43;
        r20.add(r22);
        goto L43
    L47:
        return r20;
    L9:
        r13 = true;
        goto L16
    L8:
        if (r5.isEmpty() == false) goto L10;
        goto L9
    }
}
