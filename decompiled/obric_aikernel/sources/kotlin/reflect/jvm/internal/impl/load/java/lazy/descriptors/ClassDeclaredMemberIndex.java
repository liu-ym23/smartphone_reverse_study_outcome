package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaRecordComponent> components;
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    private final Function1<JavaMember, Boolean> memberFilter;
    private final Function1<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(JavaClass r10, Function1<? super JavaMember, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        Intrinsics.checkNotNullParameter(r11, "memberFilter");
        this.jClass = r10;
        this.memberFilter = r11;
        Function1<JavaMethod, Boolean> r12 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.methodFilter = r12;
        Sequence r13 = SequencesKt.filter(CollectionsKt.asSequence(r10.getMethods()), r12);
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r16 = r15.next();
        Name r17 = ((JavaMethod) r16).getName();
        Object r18 = r14.get(r17);
        if (r18 != null) goto L8;
        r18 = new ArrayList();
        r14.put(r17, r18);
    L8:
        ((List) r18).add(r16);
        goto L4
    L9:
        this.methods = r14;
        Sequence r19 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r21 = r19.iterator();
    L11:
        if (r21.hasNext() == false) goto L13;
        Object r22 = r21.next();
        r20.put(((JavaField) r22).getName(), r22);
        goto L11
    L13:
        this.fields = r20;
        Collection<JavaRecordComponent> r23 = this.jClass.getRecordComponents();
        Function1<JavaMember, Boolean> r24 = this.memberFilter;
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r23.iterator();
    L15:
        if (r26.hasNext() == false) goto L19;
        Object r27 = r26.next();
        if (r24.invoke((JavaMember) r27).booleanValue() == false) goto L15;
        r25.add(r27);
        goto L15
    L19:
        LinkedHashMap r28 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r25, 10)), 16));
        Iterator r29 = r25.iterator();
    L21:
        if (r29.hasNext() == false) goto L23;
        Object r30 = r29.next();
        r28.put(((JavaRecordComponent) r30).getName(), r30);
        goto L21
    L23:
        this.components = r28;
    }

    public static final /* synthetic */ Function1 access$getMemberFilter$p(ClassDeclaredMemberIndex r10) {
        return r10.memberFilter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.fields.get(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection<JavaMethod> findMethodsByName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        List<JavaMethod> r11 = this.methods.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaRecordComponent findRecordComponentByName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.components.get(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getFieldNames() {
        Sequence r10 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((JavaField) r12.next()).getName());
        goto L4
    L6:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getMethodNames() {
        Sequence r10 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((JavaMethod) r12.next()).getName());
        goto L4
    L6:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }
}
