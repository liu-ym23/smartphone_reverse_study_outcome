package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class WildcardFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -5037645902506953517L;
    private final String[] wildcards;

    public WildcardFilter(String r3) {
        if (r3 == null) goto L7;
        this.wildcards = new String[]{r3};
        return;
    L7:
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public WildcardFilter(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.wildcards = (String[]) ZeusTransformUtils.preCheckCast(r4.toArray(EMPTY_STRING_ARRAY), String[].class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalArgumentException("The wildcard list must not be null");
    }

    public WildcardFilter(String... r3) {
        if (r3 == null) goto L7;
        String[] r0 = new String[r3.length];
        this.wildcards = r0;
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return;
    L7:
        throw new IllegalArgumentException("The wildcard array must not be null");
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r5, BasicFileAttributes r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r8 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r6, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        if (Files.isDirectory(r7, new LinkOption[0]) == true) goto L5;
        String[] r4 = this.wildcards;
        int r0 = r4.length;
    L7:
        if (r9 >= r0) goto L14;
        String r1 = r4[r9];
        if (FilenameUtils.wildcardMatch(Objects.toString(r7.getFileName(), null), r1) == true) goto L11;
        r9 = r9 + 1;
        goto L7
    L11:
        return FileVisitResult.CONTINUE;
    L14:
        return FileVisitResult.TERMINATE;
    L5:
        return FileVisitResult.TERMINATE;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r6) {
        if (r6.isDirectory() == false) goto L5;
        return false;
    L5:
        String[] r5 = this.wildcards;
        int r0 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (FilenameUtils.wildcardMatch(r6.getName(), r5[r2]) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r4, String r5) {
        if (r4 != null) goto L5;
    L7:
        String[] r3 = this.wildcards;
        int r6 = r3.length;
        int r1 = 0;
    L8:
        if (r1 >= r6) goto L14;
        if (FilenameUtils.wildcardMatch(r5, r3[r1]) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    L5:
        if (new File(r4, r5).isDirectory() == false) goto L7;
        return false;
    }
}
