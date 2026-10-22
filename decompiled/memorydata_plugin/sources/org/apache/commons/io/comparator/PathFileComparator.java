package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes6.dex */
public class PathFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> PATH_COMPARATOR = null;
    public static final Comparator<File> PATH_INSENSITIVE_COMPARATOR = null;
    public static final Comparator<File> PATH_INSENSITIVE_REVERSE = null;
    public static final Comparator<File> PATH_REVERSE = null;
    public static final Comparator<File> PATH_SYSTEM_COMPARATOR = null;
    public static final Comparator<File> PATH_SYSTEM_REVERSE = null;
    private static final long serialVersionUID = 6527501707585768673L;
    private final IOCase caseSensitivity;

    static {
        PathFileComparator r0 = new PathFileComparator();
        PATH_COMPARATOR = r0;
        PATH_REVERSE = new ReverseFileComparator(r0);
        PathFileComparator r1 = new PathFileComparator(IOCase.INSENSITIVE);
        PATH_INSENSITIVE_COMPARATOR = r1;
        PATH_INSENSITIVE_REVERSE = new ReverseFileComparator(r1);
        PathFileComparator r2 = new PathFileComparator(IOCase.SYSTEM);
        PATH_SYSTEM_COMPARATOR = r2;
        PATH_SYSTEM_REVERSE = new ReverseFileComparator(r2);
    }

    public PathFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    public PathFileComparator(IOCase r1) {
        if (r1 != null) goto L5;
        r1 = IOCase.SENSITIVE;
    L5:
        this.caseSensitivity = r1;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r1, File r2) {
        return this.caseSensitivity.checkCompareTo(r1.getPath(), r2.getPath());
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
        return super.toString() + "[caseSensitivity=" + this.caseSensitivity + "]";
    }
}
