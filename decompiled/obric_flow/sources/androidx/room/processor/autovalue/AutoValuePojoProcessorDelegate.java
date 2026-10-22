package androidx.room.processor.autovalue;

import ai.j0;
import androidx.room.Ignore;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.processor.Context;
import androidx.room.processor.PojoProcessor;
import androidx.room.processor.ProcessorErrors;
import androidx.room.vo.Constructor;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.Field;
import androidx.room.vo.Pojo;
import androidx.room.vo.Relation;
import androidx.room.vo.Warning;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JL\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/room/processor/autovalue/AutoValuePojoProcessorDelegate;", "Landroidx/room/processor/PojoProcessor$Delegate;", "context", "Landroidx/room/processor/Context;", "autoValueElement", "Landroidx/room/compiler/processing/XTypeElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;)V", "autoValueDeclaredType", "Landroidx/room/compiler/processing/XType;", "getAutoValueDeclaredType", "()Landroidx/room/compiler/processing/XType;", "autoValueDeclaredType$delegate", "Lkotlin/Lazy;", "createPojo", "Landroidx/room/vo/Pojo;", "element", "declaredType", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "relations", "Landroidx/room/vo/Relation;", "constructor", "Landroidx/room/vo/Constructor;", "findConstructors", "Landroidx/room/compiler/processing/XExecutableElement;", "onPreProcess", "", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoValuePojoProcessorDelegate implements PojoProcessor.Delegate {
    public static final Companion Companion = null;
    private final Lazy autoValueDeclaredType$delegate;
    private final XTypeElement autoValueElement;
    private final Context context;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/processor/autovalue/AutoValuePojoProcessorDelegate$Companion;", "", "()V", "getGeneratedClassName", "", "element", "Landroidx/room/compiler/processing/XTypeElement;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final String getGeneratedClassName(XTypeElement r5) {
            Intrinsics.checkNotNullParameter(r5, "element");
            String r10 = r5.getName();
        L4:
            if (r5.getEnclosingTypeElement() == null) goto L6;
            r5 = r5.getEnclosingTypeElement();
            Intrinsics.checkNotNull(r5);
            r10 = j0.D(r5.getName(), "_", r10);
            goto L4
        L6:
            String r11 = r5.getPackageName();
            if (r11.length() != 0) goto L9;
            String r12 = "";
        L11:
            return a.q(r11, r12, "AutoValue_", r10);
        L9:
            r12 = ".";
            goto L11
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AutoValuePojoProcessorDelegate(Context r5, XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "autoValueElement");
        this.context = r5;
        this.autoValueElement = r10;
        this.autoValueDeclaredType$delegate = LazyKt.lazy(new AutoValuePojoProcessorDelegate$autoValueDeclaredType$2(this));
    }

    public static final /* synthetic */ XTypeElement access$getAutoValueElement$p(AutoValuePojoProcessorDelegate r5) {
        return r5.autoValueElement;
    }

    private final XType getAutoValueDeclaredType() {
        return (XType) this.autoValueDeclaredType$delegate.getValue();
    }

    @Override // androidx.room.processor.PojoProcessor.Delegate
    public Pojo createPojo(XTypeElement r10, XType r11, List<Field> r12, List<EmbeddedField> r13, List<Relation> r14, Constructor r15) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "declaredType");
        Intrinsics.checkNotNullParameter(r12, "fields");
        Intrinsics.checkNotNullParameter(r13, "embeddedFields");
        Intrinsics.checkNotNullParameter(r14, "relations");
        return new Pojo(r10, getAutoValueDeclaredType(), r12, r13, r14, r15);
    }

    @Override // androidx.room.processor.PojoProcessor.Delegate
    public List<XExecutableElement> findConstructors(XTypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        List<XMethodElement> r10 = this.autoValueElement.getDeclaredMethods();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        Object r13 = r12.next();
        XMethodElement r14 = (XMethodElement) r13;
        if (r14.isStatic() == false) goto L4;
        if (r14.hasAnnotation(Reflection.getOrCreateKotlinClass(Ignore.class)) == true) goto L4;
        if (r14.isPrivate() == true) goto L4;
        if (r14.getReturnType().isSameType(this.autoValueElement.getType()) == false) goto L4;
        r11.add(r13);
        goto L4
    L14:
        return r11;
    }

    @Override // androidx.room.processor.PojoProcessor.Delegate
    public void onPreProcess(XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Sequence<XMethodElement> r11 = this.autoValueElement.getAllMethods();
        Sequence r5 = SequencesKt.filter(r11, AutoValuePojoProcessorDelegate$onPreProcess$autoValueAbstractGetters$1.INSTANCE);
        Iterator r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        XMethodElement r13 = (XMethodElement) r12.next();
        if (r13.hasAnnotationWithPackage("androidx.room") == false) goto L4;
        if (r13.hasAnnotation(Reflection.getOrCreateKotlinClass(fl.a.class)) == true) goto L4;
        this.context.getLogger().w(Warning.MISSING_COPY_ANNOTATIONS, r13, ProcessorErrors.INSTANCE.getMISSING_COPY_ANNOTATIONS(), new Object[0]);
        goto L4
    L10:
        Iterator r14 = SequencesKt.filter(SequencesKt.minus(r11, r5), AnonymousClass2.INSTANCE).iterator();
    L12:
        if (r14.hasNext() == false) goto L21;
        XMethodElement r15 = (XMethodElement) r14.next();
        KClass<? extends Annotation>[] r16 = PojoProcessor.Companion.getTARGET_METHOD_ANNOTATIONS();
        int r17 = r16.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L20;
        KClass<? extends Annotation> r19 = r16[r18];
        if (r15.hasAnnotation(r19) == true) goto L17;
        r18 = r18 + 1;
        goto L14
    L17:
        this.context.getLogger().e(r15, ProcessorErrors.INSTANCE.invalidAnnotationTarget(JvmClassMappingKt.getJavaClass(r19).getSimpleName(), r15.kindName()), new Object[0]);
        goto L12
    L20:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}
