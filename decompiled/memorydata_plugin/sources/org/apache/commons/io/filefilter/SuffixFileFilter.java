package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes6.dex */
public class SuffixFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -3389157631240246157L;
    private final IOCase caseSensitivity;
    private final String[] suffixes;

    public SuffixFileFilter(String r2) {
        this(r2, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(String r3, IOCase r4) {
        if (r3 == null) goto L10;
        this.suffixes = new String[]{r3};
        if (r4 != null) goto L7;
        r4 = IOCase.SENSITIVE;
    L7:
        this.caseSensitivity = r4;
        return;
    L10:
        throw new IllegalArgumentException("The suffix must not be null");
    }

    public SuffixFileFilter(List<String> r3) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), IOCase.SENSITIVE);
    }

    public SuffixFileFilter(List<String> r3, IOCase r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        this.suffixes = (String[]) ZeusTransformUtils.preCheckCast(r5.toArray(EMPTY_STRING_ARRAY), String[].class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        r4 = IOCase.SENSITIVE;
    L7:
        this.caseSensitivity = r4;
        return;
    L10:
        throw new IllegalArgumentException("The list of suffixes must not be null");
    }

    public SuffixFileFilter(String... r2) {
        this(r2, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(String[] r4, IOCase r5) {
        if (r4 == null) goto L10;
        String[] r0 = new String[r4.length];
        this.suffixes = r0;
        System.arraycopy(r4, 0, r0, 0, r4.length);
        if (r5 != null) goto L7;
        r5 = IOCase.SENSITIVE;
    L7:
        this.caseSensitivity = r5;
        return;
    L10:
        throw new IllegalArgumentException("The array of suffixes must not be null");
    }

    private boolean accept(String r7) {
        String[] r0 = this.suffixes;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (this.caseSensitivity.checkEndsWith(r7, r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(accept(Objects.toString(r5.getFileName(), null)), r5);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return accept(r1.getName());
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return accept(r2);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append("(");
        if (this.suffixes == null) goto L10;
        int r1 = 0;
    L6:
        if (r1 >= this.suffixes.length) goto L10;
        if (r1 <= 0) goto L9;
        r0.append(",");
    L9:
        r0.append(this.suffixes[r1]);
        r1 = r1 + 1;
    L10:
        r0.append(")");
        return r0.toString();
    }
}
