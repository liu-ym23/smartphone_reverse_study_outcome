package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
    private static final Comparator<?>[] EMPTY_COMPARATOR_ARRAY = null;
    private static final Comparator<?>[] NO_COMPARATORS = null;
    private static final long serialVersionUID = -2224170307287243428L;
    private final Comparator<File>[] delegates;

    static {
        EMPTY_COMPARATOR_ARRAY = new Comparator[0];
        NO_COMPARATORS = new Comparator[0];
    }

    public CompositeFileComparator(Iterable<Comparator<File>> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        this.delegates = (Comparator[]) ZeusTransformUtils.preCheckCast(NO_COMPARATORS, Comparator[].class, "com.obric.memorydata.plugin");
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r0.add((Comparator) ZeusTransformUtils.preCheckCast(r7.next(), Comparator.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        this.delegates = (Comparator[]) ZeusTransformUtils.preCheckCast((Comparator[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_COMPARATOR_ARRAY), Comparator[].class, "com.obric.memorydata.plugin"), Comparator[].class, "com.obric.memorydata.plugin");
    }

    public CompositeFileComparator(Comparator<File>... r4) {
        if (r4 != null) goto L5;
        this.delegates = (Comparator[]) ZeusTransformUtils.preCheckCast(NO_COMPARATORS, Comparator[].class, "com.obric.memorydata.plugin");
        return;
    L5:
        Comparator<File>[] r0 = (Comparator[]) ZeusTransformUtils.preCheckCast(new Comparator[r4.length], Comparator[].class, "com.obric.memorydata.plugin");
        this.delegates = r0;
        System.arraycopy(r4, 0, r0, 0, r4.length);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r4, File r5) {
        Comparator<File>[] r3 = this.delegates;
        int r0 = r3.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        r2 = r3[r1].compare(r4, r5);
        if (r2 != 0) goto L8;
        r1 = r1 + 1;
    L8:
        return r2;
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(File r3, File r4) {
        return compare2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* synthetic */ List sort(List r3) {
        return super.sort((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] r1) {
        return super.sort(r1);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append('{');
        int r1 = 0;
    L4:
        if (r1 >= this.delegates.length) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(',');
    L7:
        r0.append(this.delegates[r1]);
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append('}');
        return r0.toString();
    }
}
