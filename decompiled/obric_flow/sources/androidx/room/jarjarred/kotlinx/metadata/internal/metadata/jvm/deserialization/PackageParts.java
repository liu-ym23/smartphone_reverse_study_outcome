package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u0003J$\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\u0011\u0010'\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0000H\u0086\u0002J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0003J\b\u0010*\u001a\u00020\u0003H\u0016J \u0010+\u001a\u00020\u0016*\u00020,2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0-H\u0002J6\u0010.\u001a\u00020\u0016*\u00020,2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030/2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0%2\u0006\u00100\u001a\u00020\u001dH\u0002J.\u00101\u001a\u00020\u0016*\u00020,2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030/2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0%H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR.\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\fj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0018\u0010\u0010\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u00062"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/PackageParts;", "", "packageFqName", "", "(Ljava/lang/String;)V", "metadataParts", "", "getMetadataParts", "()Ljava/util/Set;", "getPackageFqName", "()Ljava/lang/String;", "packageParts", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "parts", "getParts", "className", "getClassName", "(Ljava/lang/String;)Ljava/lang/String;", "packageName", "getPackageName", "addMetadataPart", "", "shortName", "addPart", "partInternalName", "facadeInternalName", "addTo", "builder", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmModuleProtoBuf$Module$Builder;", "equals", "", "other", "getMultifileFacadeName", "getMultifileFacadeShortNameId", "", "facadeNameToId", "", "hashCode", "plusAssign", "removePart", "internalName", "toString", "writeMultifileFacadeNames", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmModuleProtoBuf$PackageParts$Builder;", "", "writePartsOutsidePackage", "", "packageTableBuilder", "writePartsWithinPackage", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageParts {
    private final Set<String> metadataParts;
    private final String packageFqName;
    private final LinkedHashMap<String, String> packageParts;

    public PackageParts(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        this.packageFqName = r5;
        this.packageParts = new LinkedHashMap();
        this.metadataParts = new LinkedHashSet();
    }

    private final String getClassName(String r5) {
        return StringsKt.U(r5, '/');
    }

    private final int getMultifileFacadeShortNameId(String r5, Map<String, Integer> r10) {
        String r11 = getClassName(r5);
        Integer r12 = r10.get(r11);
        if (r12 != null) goto L6;
        r12 = Integer.valueOf(r10.size());
        r10.put(r11, r12);
    L6:
        return r12.intValue() + 1;
    }

    private final String getPackageName(String r5) {
        return StringsKt.Z(r5, '/');
    }

    private final void writeMultifileFacadeNames(JvmModuleProtoBuf.PackageParts.Builder r5, Map<String, Integer> r10) {
        Iterator r11 = CollectionsKt.sortedWith(CollectionsKt.zip(r10.values(), r10.keySet()), new PackageParts$writeMultifileFacadeNames$$inlined$sortedBy$1()).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Pair r12 = (Pair) r11.next();
        ((Number) r12.component1()).intValue();
        String r13 = (String) r12.component2();
        r5.getMultifileFacadeShortNameCount();
        r5.addMultifileFacadeShortName(r13);
        goto L4
    }

    private final void writePartsOutsidePackage(JvmModuleProtoBuf.PackageParts.Builder r10, List<String> r11, Map<String, Integer> r12, JvmModuleProtoBuf.Module.Builder r13) {
        ArrayList r5 = new ArrayList();
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<T> r15 = r11.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r16 = r15.next();
        String r17 = getPackageName((String) r16);
        Object r18 = r14.get(r17);
        if (r18 != null) goto L8;
        r18 = new ArrayList();
        r14.put(r17, r18);
    L8:
        ((List) r18).add(r16);
        goto L4
    L9:
        Iterator r19 = MapsKt.toSortedMap(r14).entrySet().iterator();
    L11:
        if (r19.hasNext() == false) goto L33;
        Map.Entry r20 = (Map.Entry) r19.next();
        String r21 = (String) r20.getKey();
        List r22 = (List) r20.getValue();
        String r23 = StringsKt.E(r21, '/', '.');
        if (r13.getJvmPackageNameList().contains(r23) == true) goto L15;
        r13.addJvmPackageName(r23);
    L15:
        int r24 = r13.getJvmPackageNameList().indexOf(r23);
        LinkedHashMap r25 = new LinkedHashMap();
        Iterator r26 = r22.iterator();
    L17:
        if (r26.hasNext() == false) goto L22;
        Object r27 = r26.next();
        String r28 = getMultifileFacadeName((String) r27);
        Object r29 = r25.get(r28);
        if (r29 != null) goto L21;
        r29 = new ArrayList();
        r25.put(r28, r29);
    L21:
        ((List) r29).add(r27);
        goto L17
    L22:
        Iterator r30 = MapsKt.e(r25, ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder())).entrySet().iterator();
    L24:
        if (r30.hasNext() == false) goto L11;
        Map.Entry r31 = (Map.Entry) r30.next();
        String r32 = (String) r31.getKey();
        Iterator r33 = CollectionsKt.sorted((List) r31.getValue()).iterator();
    L27:
        if (r33.hasNext() == false) goto L24;
        r10.addClassWithJvmPackageNameShortName(getClassName((String) r33.next()));
        if (r32 == null) goto L31;
        r10.addClassWithJvmPackageNameMultifileFacadeShortNameId(getMultifileFacadeShortNameId(r32, r12));
    L31:
        r5.add(Integer.valueOf(r24));
    L33:
        if (r5.size() <= 1) goto L37;
        if (((Number) a.h(r5, 1)).intValue() != ((Number) a.h(r5, 2)).intValue()) goto L37;
        r5.remove(r5.size() - 1);
    L37:
        r10.addAllClassWithJvmPackageNamePackageId(r5);
    }

    private final void writePartsWithinPackage(JvmModuleProtoBuf.PackageParts.Builder r5, List<String> r10, Map<String, Integer> r11) {
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r14 = r13.next();
        String r15 = getMultifileFacadeName((String) r14);
        Object r16 = r12.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        Iterator r17 = MapsKt.e(r12, ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder())).entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L18;
        Map.Entry r18 = (Map.Entry) r17.next();
        String r19 = (String) r18.getKey();
        Iterator r20 = CollectionsKt.sorted((List) r18.getValue()).iterator();
    L14:
        if (r20.hasNext() == false) goto L11;
        r5.addShortClassName(getClassName((String) r20.next()));
        if (r19 == null) goto L14;
        r5.addMultifileFacadeShortNameId(getMultifileFacadeShortNameId(r19, r11));
        goto L14
    }

    public final void addMetadataPart(String r5) {
        Intrinsics.checkNotNullParameter(r5, "shortName");
        Set<String> r10 = this.metadataParts;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
        TypeIntrinsics.asMutableSet(r10).add(r5);
    }

    public final void addPart(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "partInternalName");
        this.packageParts.put(r5, r10);
    }

    public final void addTo(JvmModuleProtoBuf.Module.Builder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        if (getParts().isEmpty() == true) goto L13;
        JvmModuleProtoBuf.PackageParts.Builder r5 = JvmModuleProtoBuf.PackageParts.newBuilder();
        r5.setPackageFqName(this.packageFqName);
        String r11 = StringsKt.E(r5.getPackageFqName(), '.', '/');
        Set<String> r12 = getParts();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L6:
        if (r15.hasNext() == false) goto L11;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(getPackageName((String) r16), r11) == true) goto L9;
        r14.add(r16);
        goto L6
    L9:
        r13.add(r16);
        goto L6
    L11:
        Pair r17 = new Pair(r13, r14);
        List<String> r18 = (List) r17.component1();
        List<String> r19 = (List) r17.component2();
        LinkedHashMap r20 = new LinkedHashMap();
        writePartsWithinPackage(r5, r18, r20);
        writePartsOutsidePackage(r5, r19, r20, r10);
        writeMultifileFacadeNames(r5, r20);
        r10.addPackageParts(r5);
    L13:
        if (this.metadataParts.isEmpty() == true) goto L22;
        JvmModuleProtoBuf.PackageParts.Builder r21 = JvmModuleProtoBuf.PackageParts.newBuilder();
        r21.setPackageFqName(this.packageFqName);
        r21.addAllShortClassName(CollectionsKt.sorted(this.metadataParts));
        r10.addMetadataParts(r21);
        return;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof PackageParts) == false) goto L11;
        PackageParts r10 = (PackageParts) r5;
        if (Intrinsics.areEqual(r10.packageFqName, this.packageFqName) == false) goto L11;
        if (Intrinsics.areEqual(r10.packageParts, this.packageParts) == false) goto L11;
        if (Intrinsics.areEqual(r10.metadataParts, this.metadataParts) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final Set<String> getMetadataParts() {
        return this.metadataParts;
    }

    public final String getMultifileFacadeName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "partInternalName");
        return this.packageParts.get(r5);
    }

    public final String getPackageFqName() {
        return this.packageFqName;
    }

    public final Set<String> getParts() {
        return this.packageParts.keySet();
    }

    public int hashCode() {
        int r5 = this.packageFqName.hashCode() * 31;
        int r10 = (this.packageParts.hashCode() + r5) * 31;
        return this.metadataParts.hashCode() + r10;
    }

    public final void plusAssign(PackageParts r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        Iterator<Map.Entry<String, String>> r10 = r5.packageParts.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<String, String> r11 = r10.next();
        addPart(r11.getKey(), r11.getValue());
        goto L4
    L6:
        Iterator<T> r12 = r5.metadataParts.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        addMetadataPart((String) r12.next());
        goto L8
    }

    public final void removePart(String r5) {
        Intrinsics.checkNotNullParameter(r5, "internalName");
        this.packageParts.remove(r5);
    }

    public String toString() {
        return SetsKt.plus(getParts(), this.metadataParts).toString();
    }
}
