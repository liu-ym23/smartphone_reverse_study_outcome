package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nDeclaredMemberIndex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeclaredMemberIndex.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/ClassDeclaredMemberIndex\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n970#2:67\n999#2,3:68\n1002#2,3:78\n674#2:81\n704#2,4:82\n1137#2,3:95\n1137#2,3:98\n361#3,7:71\n766#4:86\n857#4,2:87\n1194#4,2:89\n1222#4,4:91\n*S KotlinDebug\n*F\n+ 1 DeclaredMemberIndex.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/ClassDeclaredMemberIndex\n*L\n52#1:67\n52#1:68,3\n52#1:78,3\n53#1:81\n53#1:82,4\n57#1:95,3\n60#1:98,3\n52#1:71,7\n54#1:86\n54#1:87,2\n54#1:89,2\n54#1:91,4\n*E\n"})
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaRecordComponent> components;
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    private final Function1<JavaMember, Boolean> memberFilter;
    private final Function1<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(JavaClass r5, Function1<? super JavaMember, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "jClass");
        Intrinsics.checkNotNullParameter(r10, "memberFilter");
        this.jClass = r5;
        this.memberFilter = r10;
        Function1<JavaMethod, Boolean> r11 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.methodFilter = r11;
        Sequence r12 = SequencesKt.filter(CollectionsKt.asSequence(r5.getMethods()), r11);
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        Object r15 = r14.next();
        Name r16 = ((JavaMethod) r15).getName();
        Object r17 = r13.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r13.put(r16, r17);
    L8:
        ((List) r17).add(r15);
        goto L4
    L9:
        this.methods = r13;
        Sequence r18 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.iterator();
    L11:
        if (r20.hasNext() == false) goto L13;
        Object r21 = r20.next();
        r19.put(((JavaField) r21).getName(), r21);
        goto L11
    L13:
        this.fields = r19;
        Collection<JavaRecordComponent> r22 = this.jClass.getRecordComponents();
        Function1<JavaMember, Boolean> r23 = this.memberFilter;
        ArrayList r24 = new ArrayList();
        Iterator<T> r25 = r22.iterator();
    L15:
        if (r25.hasNext() == false) goto L19;
        Object r26 = r25.next();
        if (r23.invoke((JavaMember) r26).booleanValue() == false) goto L15;
        r24.add(r26);
        goto L15
    L19:
        LinkedHashMap r27 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r24)), 16));
        Iterator r28 = r24.iterator();
    L21:
        if (r28.hasNext() == false) goto L23;
        Object r29 = r28.next();
        r27.put(((JavaRecordComponent) r29).getName(), r29);
        goto L21
    L23:
        this.components = r27;
    }

    public static final /* synthetic */ Function1 access$getMemberFilter$p(ClassDeclaredMemberIndex r5) {
        return r5.memberFilter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.fields.get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection<JavaMethod> findMethodsByName(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        List<JavaMethod> r10 = this.methods.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaRecordComponent findRecordComponentByName(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.components.get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getFieldNames() {
        Sequence r5 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashSet r10 = new LinkedHashSet();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((JavaField) r11.next()).getName());
        goto L4
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getMethodNames() {
        Sequence r5 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashSet r10 = new LinkedHashSet();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((JavaMethod) r11.next()).getName());
        goto L4
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }
}
