package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class OrFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<IOFileFilter> fileFilters;

    public OrFileFilter() {
        this(0);
    }

    private OrFileFilter(int r2) {
        this(new ArrayList(r2));
    }

    private OrFileFilter(ArrayList<IOFileFilter> r3) {
        this.fileFilters = (List) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3, "initialList"), List.class, "com.obric.memorydata.plugin");
    }

    public OrFileFilter(List<IOFileFilter> r4) {
        this(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), "fileFilters"), Collection.class, "com.obric.memorydata.plugin")));
    }

    public OrFileFilter(IOFileFilter r3, IOFileFilter r4) {
        IOFileFilter r5 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r3, IOFileFilter.class, "com.obric.memorydata.plugin");
        IOFileFilter r6 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r4, IOFileFilter.class, "com.obric.memorydata.plugin");
        this(2);
        addFileFilter(r5);
        addFileFilter(r6);
    }

    public OrFileFilter(IOFileFilter... r4) {
        this(((IOFileFilter[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4, "fileFilters"), IOFileFilter[].class, "com.obric.memorydata.plugin")).length);
        addFileFilter(r4);
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r4, BasicFileAttributes r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r7 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r5, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        Iterator<IOFileFilter> r3 = this.fileFilters.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        if (((IOFileFilter) ZeusTransformUtils.preCheckCast(r3.next(), IOFileFilter.class, "com.obric.memorydata.plugin")).accept(r6, r7) != FileVisitResult.CONTINUE) goto L4;
        return FileVisitResult.CONTINUE;
    L10:
        return FileVisitResult.TERMINATE;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r4) {
        Iterator<IOFileFilter> r3 = this.fileFilters.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((IOFileFilter) ZeusTransformUtils.preCheckCast(r3.next(), IOFileFilter.class, "com.obric.memorydata.plugin")).accept(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r4, String r5) {
        Iterator<IOFileFilter> r3 = this.fileFilters.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((IOFileFilter) ZeusTransformUtils.preCheckCast(r3.next(), IOFileFilter.class, "com.obric.memorydata.plugin")).accept(r4, r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void addFileFilter(IOFileFilter r3) {
        IOFileFilter r4 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r3, IOFileFilter.class, "com.obric.memorydata.plugin");
        this.fileFilters.add((IOFileFilter) Objects.requireNonNull(r4, "fileFilter"));
    }

    public void addFileFilter(IOFileFilter... r4) {
        IOFileFilter[] r5 = (IOFileFilter[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4, "fileFilters"), IOFileFilter[].class, "com.obric.memorydata.plugin");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addFileFilter(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    public boolean removeFileFilter(IOFileFilter r3) {
        IOFileFilter r4 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r3, IOFileFilter.class, "com.obric.memorydata.plugin");
        return this.fileFilters.remove(r4);
    }

    public void setFileFilters(List<IOFileFilter> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.fileFilters.clear();
        this.fileFilters.addAll((Collection) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4, "fileFilters"), Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append("(");
        if (this.fileFilters == null) goto L10;
        int r1 = 0;
    L6:
        if (r1 >= this.fileFilters.size()) goto L10;
        if (r1 <= 0) goto L9;
        r0.append(",");
    L9:
        r0.append(this.fileFilters.get(r1));
        r1 = r1 + 1;
    L10:
        r0.append(")");
        return r0.toString();
    }
}
