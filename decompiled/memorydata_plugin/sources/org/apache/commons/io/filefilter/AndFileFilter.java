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
public class AndFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7215974688563965257L;
    private final List<IOFileFilter> fileFilters;

    public AndFileFilter() {
        this(0);
    }

    private AndFileFilter(int r2) {
        this(new ArrayList(r2));
    }

    private AndFileFilter(ArrayList<IOFileFilter> r3) {
        this.fileFilters = (List) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3, "initialList"), List.class, "com.obric.memorydata.plugin");
    }

    public AndFileFilter(List<IOFileFilter> r4) {
        this(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), "fileFilters"), Collection.class, "com.obric.memorydata.plugin")));
    }

    public AndFileFilter(IOFileFilter r3, IOFileFilter r4) {
        IOFileFilter r5 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r3, IOFileFilter.class, "com.obric.memorydata.plugin");
        IOFileFilter r6 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r4, IOFileFilter.class, "com.obric.memorydata.plugin");
        this(2);
        addFileFilter(r5);
        addFileFilter(r6);
    }

    public AndFileFilter(IOFileFilter... r4) {
        this(((IOFileFilter[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4, "fileFilters"), IOFileFilter[].class, "com.obric.memorydata.plugin")).length);
        addFileFilter(r4);
    }

    private boolean isEmpty() {
        return this.fileFilters.isEmpty();
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r4, BasicFileAttributes r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r7 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r5, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        if (isEmpty() == true) goto L5;
        Iterator<IOFileFilter> r3 = this.fileFilters.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        if (((IOFileFilter) ZeusTransformUtils.preCheckCast(r3.next(), IOFileFilter.class, "com.obric.memorydata.plugin")).accept(r6, r7) == FileVisitResult.CONTINUE) goto L8;
        return FileVisitResult.TERMINATE;
    L14:
        return FileVisitResult.CONTINUE;
    L5:
        return FileVisitResult.TERMINATE;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        if (isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<IOFileFilter> r4 = this.fileFilters.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (((IOFileFilter) ZeusTransformUtils.preCheckCast(r4.next(), IOFileFilter.class, "com.obric.memorydata.plugin")).accept(r5) == true) goto L7;
        return false;
    L11:
        return true;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r5, String r6) {
        if (isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<IOFileFilter> r4 = this.fileFilters.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (((IOFileFilter) ZeusTransformUtils.preCheckCast(r4.next(), IOFileFilter.class, "com.obric.memorydata.plugin")).accept(r5, r6) == true) goto L7;
        return false;
    L11:
        return true;
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
        this.fileFilters.addAll(r4);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append("(");
        int r1 = 0;
    L4:
        if (r1 >= this.fileFilters.size()) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(",");
    L7:
        r0.append(this.fileFilters.get(r1));
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(")");
        return r0.toString();
    }
}
