package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes6.dex */
public class ExtensionFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> EXTENSION_COMPARATOR = null;
    public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR = null;
    public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE = null;
    public static final Comparator<File> EXTENSION_REVERSE = null;
    public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR = null;
    public static final Comparator<File> EXTENSION_SYSTEM_REVERSE = null;
    private static final long serialVersionUID = 1928235200184222815L;
    private final IOCase caseSensitivity;

    static {
        ExtensionFileComparator r0 = new ExtensionFileComparator();
        EXTENSION_COMPARATOR = r0;
        EXTENSION_REVERSE = new ReverseFileComparator(r0);
        ExtensionFileComparator r1 = new ExtensionFileComparator(IOCase.INSENSITIVE);
        EXTENSION_INSENSITIVE_COMPARATOR = r1;
        EXTENSION_INSENSITIVE_REVERSE = new ReverseFileComparator(r1);
        ExtensionFileComparator r2 = new ExtensionFileComparator(IOCase.SYSTEM);
        EXTENSION_SYSTEM_COMPARATOR = r2;
        EXTENSION_SYSTEM_REVERSE = new ReverseFileComparator(r2);
    }

    public ExtensionFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    public ExtensionFileComparator(IOCase r1) {
        if (r1 != null) goto L5;
        r1 = IOCase.SENSITIVE;
    L5:
        this.caseSensitivity = r1;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r1, File r2) {
        String r3 = FilenameUtils.getExtension(r1.getName());
        String r4 = FilenameUtils.getExtension(r2.getName());
        return this.caseSensitivity.checkCompareTo(r3, r4);
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
