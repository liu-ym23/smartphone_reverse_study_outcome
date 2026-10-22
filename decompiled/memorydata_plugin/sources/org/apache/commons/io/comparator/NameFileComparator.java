package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes6.dex */
public class NameFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> NAME_COMPARATOR = null;
    public static final Comparator<File> NAME_INSENSITIVE_COMPARATOR = null;
    public static final Comparator<File> NAME_INSENSITIVE_REVERSE = null;
    public static final Comparator<File> NAME_REVERSE = null;
    public static final Comparator<File> NAME_SYSTEM_COMPARATOR = null;
    public static final Comparator<File> NAME_SYSTEM_REVERSE = null;
    private static final long serialVersionUID = 8397947749814525798L;
    private final IOCase caseSensitivity;

    static {
        NameFileComparator r0 = new NameFileComparator();
        NAME_COMPARATOR = r0;
        NAME_REVERSE = new ReverseFileComparator(r0);
        NameFileComparator r1 = new NameFileComparator(IOCase.INSENSITIVE);
        NAME_INSENSITIVE_COMPARATOR = r1;
        NAME_INSENSITIVE_REVERSE = new ReverseFileComparator(r1);
        NameFileComparator r2 = new NameFileComparator(IOCase.SYSTEM);
        NAME_SYSTEM_COMPARATOR = r2;
        NAME_SYSTEM_REVERSE = new ReverseFileComparator(r2);
    }

    public NameFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    public NameFileComparator(IOCase r1) {
        if (r1 != null) goto L5;
        r1 = IOCase.SENSITIVE;
    L5:
        this.caseSensitivity = r1;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r1, File r2) {
        return this.caseSensitivity.checkCompareTo(r1.getName(), r2.getName());
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
