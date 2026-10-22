package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes6.dex */
public class LastModifiedFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> LASTMODIFIED_COMPARATOR = null;
    public static final Comparator<File> LASTMODIFIED_REVERSE = null;
    private static final long serialVersionUID = 7372168004395734046L;

    static {
        LastModifiedFileComparator r0 = new LastModifiedFileComparator();
        LASTMODIFIED_COMPARATOR = r0;
        LASTMODIFIED_REVERSE = new ReverseFileComparator(r0);
    }

    public LastModifiedFileComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r3, File r4) {
        long r2 = FileUtils.lastModifiedUnchecked(r3) - FileUtils.lastModifiedUnchecked(r4);
        if (r2 >= 0) goto L6;
        return -1;
    L6:
        if (r2 <= 0) goto L9;
        return 1;
    L9:
        return 0;
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
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
