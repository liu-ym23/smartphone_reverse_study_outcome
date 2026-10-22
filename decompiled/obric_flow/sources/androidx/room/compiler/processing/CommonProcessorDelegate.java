package androidx.room.compiler.processing;

import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ0\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00112\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/compiler/processing/CommonProcessorDelegate;", "", "processorClass", "Ljava/lang/Class;", "env", "Landroidx/room/compiler/processing/XProcessingEnv;", "steps", "", "Landroidx/room/compiler/processing/XProcessingStep;", "(Ljava/lang/Class;Landroidx/room/compiler/processing/XProcessingEnv;Ljava/util/List;)V", "deferredElementNames", "", "", "elementsDeferredBySteps", "", "", "getStepElementsByAnnotation", "", "Landroidx/room/compiler/processing/XElement;", "step", "typeElementNames", "processLastRound", "processRound", "", "roundEnv", "Landroidx/room/compiler/processing/XRoundEnv;", "reportMissingElements", "missingElementNames", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonProcessorDelegate {
    private final Set<String> deferredElementNames;
    private final Map<XProcessingStep, Set<String>> elementsDeferredBySteps;
    private final XProcessingEnv env;
    private final Class<?> processorClass;
    private final List<XProcessingStep> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonProcessorDelegate(Class<?> r5, XProcessingEnv r10, List<? extends XProcessingStep> r11) {
        Intrinsics.checkNotNullParameter(r5, "processorClass");
        Intrinsics.checkNotNullParameter(r10, "env");
        Intrinsics.checkNotNullParameter(r11, "steps");
        this.processorClass = r5;
        this.env = r10;
        this.steps = r11;
        this.deferredElementNames = new LinkedHashSet();
        this.elementsDeferredBySteps = new LinkedHashMap();
    }

    private final Map<String, Set<XElement>> getStepElementsByAnnotation(XProcessingStep r10, Set<String> r11) {
        if (r11.isEmpty() == true) goto L5;
        Set<String> r12 = r10.annotations();
        LinkedHashMap r5 = new LinkedHashMap();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        String r15 = (String) r14.next();
        XTypeElement r16 = this.env.findTypeElement(r15);
        if (r16 == null) goto L8;
        r13.add(r16);
        goto L8
    L12:
        Iterator r17 = r13.iterator();
    L14:
        if (r17.hasNext() == false) goto L33;
        XTypeElement r18 = (XTypeElement) r17.next();
        List<XElement> r19 = r18.getEnclosedElements();
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L17:
        if (r21.hasNext() == false) goto L21;
        Object r22 = r21.next();
        if (XElementKt.isTypeElement((XElement) r22) == true) goto L17;
        r20.add(r22);
        goto L17
    L21:
        Iterator r23 = r20.iterator();
    L23:
        if (r23.hasNext() == false) goto L31;
        XElement r24 = (XElement) r23.next();
        if ((r24 instanceof XExecutableElement) == false) goto L30;
        Iterator<T> r25 = ((XExecutableElement) r24).getParameters().iterator();
    L28:
        if (r25.hasNext() == false) goto L30;
        getStepElementsByAnnotation$putStepAnnotatedElements(r12, r5, (XExecutableParameterElement) r25.next());
    L30:
        getStepElementsByAnnotation$putStepAnnotatedElements(r12, r5, r24);
        goto L23
    L31:
        getStepElementsByAnnotation$putStepAnnotatedElements(r12, r5, r18);
        goto L14
    L33:
        return MapsKt.f(r5, AnonymousClass3.INSTANCE);
    L5:
        return MapsKt.emptyMap();
    }

    private static final void getStepElementsByAnnotation$putStepAnnotatedElements(Set<String> r5, Map<String, Set<XElement>> r10, XElement r11) {
        List<XAnnotation> r12 = r11.getAllAnnotations();
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(((XAnnotation) r14.next()).getQualifiedName());
        goto L4
    L6:
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L15;
        String r16 = (String) r15.next();
        if (r5.contains(r16) == false) goto L8;
        Set<XElement> r17 = r10.get(r16);
        if (r17 != null) goto L14;
        r17 = new LinkedHashSet();
        r10.put(r16, r17);
    L14:
        r17.add(r11);
        goto L8
    }

    public final List<String> processLastRound() {
        Iterator<T> r5 = this.steps.iterator();
    L4:
        if (r5.hasNext() == false) goto L22;
        XProcessingStep r10 = (XProcessingStep) r5.next();
        Set<String> r11 = this.deferredElementNames;
        Set<String> r12 = this.elementsDeferredBySteps.get(r10);
        if (r12 != null) goto L8;
        r12 = SetsKt.emptySet();
    L8:
        Map<String, Set<XElement>> r13 = getStepElementsByAnnotation(r10, SetsKt.plus(r11, r12));
        Set<String> r14 = r10.annotations();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L20;
        String r17 = (String) r16.next();
        Set<XElement> r18 = r13.get(r17);
        if (r18 != null) goto L15;
        r18 = SetsKt.emptySet();
    L15:
        if (r18.isEmpty() == true) goto L17;
        Pair r19 = TuplesKt.to(r17, r18);
    L18:
        if (r19 == null) goto L10;
        r15.add(r19);
        goto L10
    L17:
        r19 = null;
        goto L18
    L20:
        Map<String, ? extends Set<? extends XElement>> r20 = MapsKt.toMap(r15);
        r10.process(this.env, r20, true);
        goto L4
    L22:
        return CollectionsKt.flatten(this.elementsDeferredBySteps.values());
    }

    public final void processRound(XRoundEnv r18) {
        XRoundEnv r5 = r18;
        Intrinsics.checkNotNullParameter(r5, "roundEnv");
        Set<String> r10 = CollectionsKt.toMutableSet(this.deferredElementNames);
        this.deferredElementNames.clear();
        List<XProcessingStep> r11 = this.steps;
        LinkedHashMap r12 = new LinkedHashMap(a.e(r11, 16));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L59;
        Object r14 = r13.next();
        XProcessingStep r15 = (XProcessingStep) r14;
        Map r16 = MapsKt.withDefault(getStepElementsByAnnotation(r15, r10), CommonProcessorDelegate$processRound$currentElementsDeferredByStep$1$previousRoundDeferredElementsByAnnotation$1.INSTANCE);
        Set<String> r17 = this.elementsDeferredBySteps.get(r15);
        if (r17 != null) goto L8;
        r17 = SetsKt.emptySet();
    L8:
        Map r19 = MapsKt.withDefault(getStepElementsByAnnotation(r15, r17), CommonProcessorDelegate$processRound$currentElementsDeferredByStep$1$stepDeferredElementsByAnnotation$1.INSTANCE);
        LinkedHashSet r20 = new LinkedHashSet();
        Set<String> r110 = r15.annotations();
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L10:
        if (r112.hasNext() == false) goto L30;
        String r113 = (String) r112.next();
        Set r114 = SetsKt.plus(r5.getElementsAnnotatedWith(r113), (Iterable) MapsKt.getValue(r16, r113));
        if (this.env.getConfig().getDisableAnnotatedElementValidation() == false) goto L14;
        Pair r115 = TuplesKt.to(r114, SetsKt.emptySet());
    L23:
        Collection r21 = (Collection) r115.component1();
        r20.addAll((Collection) r115.component2());
        List r22 = CollectionsKt.plus(r21, (Iterable) MapsKt.getValue(r19, r113));
        if (r22.isEmpty() == true) goto L26;
        Pair r116 = TuplesKt.to(r113, CollectionsKt.toSet(r22));
    L27:
        if (r116 == null) goto L29;
        r111.add(r116);
    L29:
        r5 = r18;
        goto L10
    L26:
        r116 = null;
        goto L27
    L14:
        ArrayList r117 = new ArrayList();
        ArrayList r118 = new ArrayList();
        Iterator r119 = r114.iterator();
    L16:
        if (r119.hasNext() == false) goto L22;
        Object r23 = r119.next();
        if (((XElement) r23).validate() == false) goto L21;
        r117.add(r23);
        goto L16
    L21:
        r118.add(r23);
        goto L16
    L22:
        r115 = new Pair(r117, r118);
        goto L23
    L30:
        Map<String, ? extends Set<? extends XElement>> r24 = MapsKt.toMap(r111);
        Set<String> r25 = this.deferredElementNames;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r20.iterator();
    L32:
        if (r27.hasNext() == false) goto L42;
        XMemberContainer r120 = ((XElement) r27.next()).getClosestMemberContainer();
        if ((r120 instanceof XTypeElement) == false) goto L36;
        XTypeElement r121 = (XTypeElement) r120;
    L37:
        if (r121 == null) goto L39;
        String r122 = r121.getQualifiedName();
    L40:
        if (r122 == null) goto L32;
        r26.add(r122);
        goto L32
    L39:
        r122 = null;
        goto L40
    L36:
        r121 = null;
        goto L37
    L42:
        r25.addAll(r26);
        if (r24.isEmpty() == true) goto L57;
        Set<XElement> r28 = r15.process(this.env, r24, false);
        ArrayList r29 = new ArrayList();
        Iterator<T> r30 = r28.iterator();
    L46:
        if (r30.hasNext() == false) goto L56;
        XMemberContainer r31 = ((XElement) r30.next()).getClosestMemberContainer();
        if ((r31 instanceof XTypeElement) == false) goto L50;
        XTypeElement r32 = (XTypeElement) r31;
    L51:
        if (r32 == null) goto L53;
        String r33 = r32.getQualifiedName();
    L54:
        if (r33 == null) goto L46;
        r29.add(r33);
        goto L46
    L53:
        r33 = null;
        goto L54
    L50:
        r32 = null;
        goto L51
    L56:
        Set r34 = CollectionsKt.toSet(r29);
    L58:
        r12.put(r14, r34);
        r5 = r18;
        goto L4
    L57:
        r34 = SetsKt.emptySet();
        goto L58
    L59:
        this.elementsDeferredBySteps.clear();
        this.elementsDeferredBySteps.putAll(r12);
    }

    public final void reportMissingElements(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "missingElementNames");
        Iterator<T> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = (String) r10.next();
        this.env.getMessager().printMessage(Diagnostic.Kind.ERROR, String.format("%s was unable to process '%s' because not all of its dependencies could be resolved. Check for compilation errors or a circular dependency with generated code.", Arrays.copyOf(new Object[]{this.processorClass.getCanonicalName(), r11}, 2)));
        goto L4
    }
}
