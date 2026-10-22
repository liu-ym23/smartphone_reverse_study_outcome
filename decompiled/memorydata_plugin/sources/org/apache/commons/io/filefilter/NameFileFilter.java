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
public class NameFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 176844364689077340L;
    private final IOCase caseSensitivity;
    private final String[] names;

    public NameFileFilter(String r2) {
        this(r2, IOCase.SENSITIVE);
    }

    public NameFileFilter(String r3, IOCase r4) {
        if (r3 == null) goto L7;
        this.names = new String[]{r3};
        this.caseSensitivity = toIOCase(r4);
        return;
    L7:
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public NameFileFilter(List<String> r3) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), null);
    }

    public NameFileFilter(List<String> r3, IOCase r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        this.names = (String[]) ZeusTransformUtils.preCheckCast(r5.toArray(EMPTY_STRING_ARRAY), String[].class, "com.obric.memorydata.plugin");
        this.caseSensitivity = toIOCase(r4);
        return;
    L7:
        throw new IllegalArgumentException("The list of names must not be null");
    }

    public NameFileFilter(String... r2) {
        this(r2, IOCase.SENSITIVE);
    }

    public NameFileFilter(String[] r4, IOCase r5) {
        if (r4 == null) goto L7;
        String[] r0 = new String[r4.length];
        this.names = r0;
        System.arraycopy(r4, 0, r0, 0, r4.length);
        this.caseSensitivity = toIOCase(r5);
        return;
    L7:
        throw new IllegalArgumentException("The array of names must not be null");
    }

    private boolean acceptBaseName(String r7) {
        String[] r0 = this.names;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (this.caseSensitivity.checkEquals(r7, r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private IOCase toIOCase(IOCase r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return IOCase.SENSITIVE;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(acceptBaseName(Objects.toString(r5.getFileName(), null)), r5);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return acceptBaseName(r1.getName());
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return acceptBaseName(r2);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append("(");
        if (this.names == null) goto L10;
        int r1 = 0;
    L6:
        if (r1 >= this.names.length) goto L10;
        if (r1 <= 0) goto L9;
        r0.append(",");
    L9:
        r0.append(this.names[r1]);
        r1 = r1 + 1;
    L10:
        r0.append(")");
        return r0.toString();
    }
}
