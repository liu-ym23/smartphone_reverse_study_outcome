package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SizeFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> SIZE_COMPARATOR = null;
    public static final Comparator<File> SIZE_REVERSE = null;
    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = null;
    public static final Comparator<File> SIZE_SUMDIR_REVERSE = null;
    private static final long serialVersionUID = -1201561106411416190L;
    private final boolean sumDirectoryContents;

    static {
        SizeFileComparator r0 = new SizeFileComparator();
        SIZE_COMPARATOR = r0;
        SIZE_REVERSE = new ReverseFileComparator(r0);
        SizeFileComparator r1 = new SizeFileComparator(true);
        SIZE_SUMDIR_COMPARATOR = r1;
        SIZE_SUMDIR_REVERSE = new ReverseFileComparator(r1);
    }

    public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    public SizeFileComparator(boolean r1) {
        this.sumDirectoryContents = r1;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r6, File r7) {
        if (r6.isDirectory() == true) goto L5;
        long r3 = r6.length();
    L12:
        if (r7.isDirectory() == true) goto L14;
        long r5 = r7.length();
    L20:
        long r4 = r3 - r5;
        if (r4 >= 0) goto L24;
        return -1;
    L24:
        if (r4 <= 0) goto L27;
        return 1;
    L27:
        return 0;
    L14:
        if (this.sumDirectoryContents == true) goto L16;
    L18:
        r5 = 0;
        goto L20
    L16:
        if (r7.exists() == false) goto L18;
        r5 = FileUtils.sizeOfDirectory(r7);
        goto L20
    L5:
        if (this.sumDirectoryContents == true) goto L7;
    L9:
        r3 = 0;
        goto L12
    L7:
        if (r6.exists() == false) goto L9;
        r3 = FileUtils.sizeOfDirectory(r6);
        goto L12
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
        return super.toString() + "[sumDirectoryContents=" + this.sumDirectoryContents + "]";
    }
}
