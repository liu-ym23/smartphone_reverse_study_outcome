package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zaxxer.sparsebits.SparseBitSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

/* JADX INFO: loaded from: classes7.dex */
public final class PackagePartCollection implements Serializable {
    private static final long serialVersionUID = 2515031135957635517L;
    private final TreeMap<String, PackagePart> packagePartLookup;
    private final Set<String> registerPartNameStr;

    public PackagePartCollection() {
        this.registerPartNameStr = new HashSet();
        this.packagePartLookup = new TreeMap($$Lambda$ooY8TxzyhDZYRnL25TsceeO3jk.INSTANCE);
    }

    static /* synthetic */ int lambda$getUnusedPartIndex$0(Pattern r0, String r1) {
        Matcher r2 = r0.matcher(r1);
        if (r2.matches() == true) goto L7;
        return 0;
    L7:
        return Integer.parseInt(r2.group(1));
    }

    static /* synthetic */ void lambda$getUnusedPartIndex$1(SparseBitSet r0, SparseBitSet r1) {
        r0.or(r1);
    }

    public boolean containsKey(PackagePartName r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.packagePartLookup.containsKey(r1.getName()) == false) goto L6;
        return true;
    }

    public PackagePart get(PackagePartName r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (PackagePart) ZeusTransformUtils.preCheckCast(this.packagePartLookup.get(r2.getName()), PackagePart.class, "com.obric.memorydata.plugin");
    }

    public int getUnusedPartIndex(String r3) {
        if (r3 == null) goto L8;
        if (r3.contains("#") == false) goto L8;
        final Pattern r4 = Pattern.compile(r3.replace("#", "([0-9]+)"));
        ToIntFunction<? super String> r0 = new $$Lambda$PackagePartCollection$uKuEDXfjW0NTs69g1zDDodUpRE(r4);
        return ((SparseBitSet) ZeusTransformUtils.preCheckCast(this.packagePartLookup.keySet().stream().mapToInt(r0).collect($$Lambda$QVaw9wiS_WvatqGjDAtHqqRh4.INSTANCE, $$Lambda$cKnOEuLzaVzgqf9hjLBBN6omaI.INSTANCE, $$Lambda$PackagePartCollection$K_Ixr49x_qP_u1wNcdS4pyWzuqw.INSTANCE), SparseBitSet.class, "com.obric.memorydata.plugin")).nextClearBit(1);
    L8:
        throw new InvalidFormatException("name template must not be null and contain an index char (#)");
    }

    public PackagePart put(PackagePartName r7, PackagePart r8) {
        String r9 = r7.getName();
        StringBuilder r0 = new StringBuilder();
        String[] r1 = r9.split("(?=[/])");
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        r0.append(r1[r3]);
        if (this.registerPartNameStr.contains(r0.toString()) == true) goto L8;
        r3 = r3 + 1;
        goto L3
    L8:
        throw new InvalidOperationException("You can't add a part with a part name derived from another part ! [M1.11]");
    L9:
        this.registerPartNameStr.add(r9);
        return (PackagePart) ZeusTransformUtils.preCheckCast(this.packagePartLookup.put(r9, r8), PackagePart.class, "com.obric.memorydata.plugin");
    }

    public PackagePart remove(PackagePartName r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r5 = r4.getName();
        PackagePart r0 = (PackagePart) ZeusTransformUtils.preCheckCast(this.packagePartLookup.remove(r5), PackagePart.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        this.registerPartNameStr.remove(r5);
    L8:
        return r0;
    }

    public int size() {
        return this.packagePartLookup.size();
    }

    public Collection<PackagePart> sortedValues() {
        return Collections.unmodifiableCollection(this.packagePartLookup.values());
    }
}
