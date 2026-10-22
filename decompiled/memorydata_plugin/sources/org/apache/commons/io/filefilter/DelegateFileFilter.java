package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DelegateFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -8723373124984771318L;
    private final FileFilter fileFilter;
    private final FilenameFilter filenameFilter;

    public DelegateFileFilter(FileFilter r3) {
        FileFilter r4 = (FileFilter) ZeusTransformUtils.wrapperContextForParams(r3, FileFilter.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.fileFilter = r4;
        this.filenameFilter = null;
        return;
    L7:
        throw new IllegalArgumentException("The FileFilter must not be null");
    }

    public DelegateFileFilter(FilenameFilter r3) {
        FilenameFilter r4 = (FilenameFilter) ZeusTransformUtils.wrapperContextForParams(r3, FilenameFilter.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.filenameFilter = r4;
        this.fileFilter = null;
        return;
    L7:
        throw new IllegalArgumentException("The FilenameFilter must not be null");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r2) {
        FileFilter r0 = this.fileFilter;
        if (r0 == null) goto L7;
        return r0.accept(r2);
    L7:
        return super.accept(r2);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r2, String r3) {
        FilenameFilter r0 = this.filenameFilter;
        if (r0 == null) goto L7;
        return r0.accept(r2, r3);
    L7:
        return super.accept(r2, r3);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        Object r0 = this.fileFilter;
        if (r0 != null) goto L7;
        r0 = this.filenameFilter;
    L7:
        return super.toString() + "(" + r0.toString() + ")";
    }
}
