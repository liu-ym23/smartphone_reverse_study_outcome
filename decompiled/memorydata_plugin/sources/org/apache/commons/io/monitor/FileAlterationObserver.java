package org.apache.commons.io.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.NameFileComparator;

/* JADX INFO: loaded from: classes6.dex */
public class FileAlterationObserver implements Serializable {
    private static final long serialVersionUID = 1185122225658782848L;
    private final Comparator<File> comparator;
    private final FileFilter fileFilter;
    private final List<FileAlterationListener> listeners;
    private final FileEntry rootEntry;

    public FileAlterationObserver(File r2) {
        this(r2, null);
    }

    public FileAlterationObserver(File r3, FileFilter r4) {
        this(r3, (FileFilter) ZeusTransformUtils.wrapperContextForParams(r4, FileFilter.class, "com.obric.memorydata.plugin"), null);
    }

    public FileAlterationObserver(File r3, FileFilter r4, IOCase r5) {
        FileFilter r6 = (FileFilter) ZeusTransformUtils.wrapperContextForParams(r4, FileFilter.class, "com.obric.memorydata.plugin");
        this(new FileEntry(r3), r6, r5);
    }

    public FileAlterationObserver(String r2) {
        this(new File(r2));
    }

    public FileAlterationObserver(String r3, FileFilter r4) {
        FileFilter r5 = (FileFilter) ZeusTransformUtils.wrapperContextForParams(r4, FileFilter.class, "com.obric.memorydata.plugin");
        this(new File(r3), r5);
    }

    public FileAlterationObserver(String r3, FileFilter r4, IOCase r5) {
        FileFilter r6 = (FileFilter) ZeusTransformUtils.wrapperContextForParams(r4, FileFilter.class, "com.obric.memorydata.plugin");
        this(new File(r3), r6, r5);
    }

    public FileAlterationObserver(FileEntry r3, FileFilter r4, IOCase r5) {
        FileFilter r6 = (FileFilter) ZeusTransformUtils.wrapperContextForParams(r4, FileFilter.class, "com.obric.memorydata.plugin");
        this.listeners = new CopyOnWriteArrayList();
        if (r3 == null) goto L21;
        if (r3.getFile() == null) goto L19;
        this.rootEntry = r3;
        this.fileFilter = r6;
        if (r5 != null) goto L9;
    L15:
        Comparator<File> r7 = NameFileComparator.NAME_SYSTEM_COMPARATOR;
    L16:
        this.comparator = r7;
        return;
    L9:
        if (r5.equals(IOCase.SYSTEM) == true) goto L15;
        if (r5.equals(IOCase.INSENSITIVE) == false) goto L14;
        r7 = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
        goto L16
    L14:
        r7 = NameFileComparator.NAME_COMPARATOR;
        goto L16
    L19:
        throw new IllegalArgumentException("Root directory is missing");
    L21:
        throw new IllegalArgumentException("Root entry is missing");
    }

    private void checkAndNotify(FileEntry r9, FileEntry[] r10, File[] r11) {
        if (r11.length <= 0) goto L5;
        FileEntry[] r0 = new FileEntry[r11.length];
    L6:
        int r1 = r10.length;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r1) goto L22;
        FileEntry r4 = r10[r2];
    L10:
        if (r3 >= r11.length) goto L15;
        if (this.comparator.compare(r4.getFile(), r11[r3]) <= 0) goto L15;
        r0[r3] = createFileEntry(r9, r11[r3]);
        doCreate(r0[r3]);
        r3 = r3 + 1;
    L15:
        if (r3 < r11.length) goto L17;
    L19:
        checkAndNotify(r4, r4.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        doDelete(r4);
    L20:
        r2 = r2 + 1;
        goto L7
    L17:
        if (this.comparator.compare(r4.getFile(), r11[r3]) != 0) goto L19;
        doMatch(r4, r11[r3]);
        checkAndNotify(r4, r4.getChildren(), listFiles(r11[r3]));
        r0[r3] = r4;
        r3 = r3 + 1;
    L22:
        if (r3 >= r11.length) goto L24;
        r0[r3] = createFileEntry(r9, r11[r3]);
        doCreate(r0[r3]);
        r3 = r3 + 1;
        goto L22
    L24:
        r9.setChildren(r0);
        return;
    L5:
        r0 = FileEntry.EMPTY_FILE_ENTRY_ARRAY;
        goto L6
    }

    private FileEntry createFileEntry(FileEntry r1, File r2) {
        FileEntry r3 = r1.newChildInstance(r2);
        r3.refresh(r2);
        r3.setChildren(doListFiles(r2, r3));
        return r3;
    }

    private void doCreate(FileEntry r5) {
        Iterator<FileAlterationListener> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        FileAlterationListener r1 = (FileAlterationListener) ZeusTransformUtils.preCheckCast(r0.next(), FileAlterationListener.class, "com.obric.memorydata.plugin");
        if (r5.isDirectory() == true) goto L7;
        r1.onFileCreate(r5.getFile());
        goto L4
    L7:
        r1.onDirectoryCreate(r5.getFile());
        goto L4
    L9:
        FileEntry[] r6 = r5.getChildren();
        int r2 = r6.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L12;
        doCreate(r6[r3]);
        r3 = r3 + 1;
        goto L10
    }

    private void doDelete(FileEntry r4) {
        Iterator<FileAlterationListener> r3 = this.listeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        FileAlterationListener r0 = (FileAlterationListener) ZeusTransformUtils.preCheckCast(r3.next(), FileAlterationListener.class, "com.obric.memorydata.plugin");
        if (r4.isDirectory() == true) goto L7;
        r0.onFileDelete(r4.getFile());
        goto L4
    L7:
        r0.onDirectoryDelete(r4.getFile());
        goto L4
    }

    private FileEntry[] doListFiles(File r4, FileEntry r5) {
        File[] r6 = listFiles(r4);
        if (r6.length <= 0) goto L5;
        FileEntry[] r0 = new FileEntry[r6.length];
    L6:
        int r1 = 0;
    L8:
        if (r1 >= r6.length) goto L10;
        r0[r1] = createFileEntry(r5, r6[r1]);
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        r0 = FileEntry.EMPTY_FILE_ENTRY_ARRAY;
        goto L6
    }

    private void doMatch(FileEntry r4, File r5) {
        if (r4.refresh(r5) == false) goto L11;
        Iterator<FileAlterationListener> r3 = this.listeners.iterator();
    L6:
        if (r3.hasNext() == false) goto L18;
        FileAlterationListener r0 = (FileAlterationListener) ZeusTransformUtils.preCheckCast(r3.next(), FileAlterationListener.class, "com.obric.memorydata.plugin");
        if (r4.isDirectory() == true) goto L9;
        r0.onFileChange(r5);
        goto L6
    L9:
        r0.onDirectoryChange(r5);
        goto L6
    L18:
        return;
    }

    private File[] listFiles(File r3) {
        if (r3.isDirectory() == false) goto L8;
        FileFilter r0 = this.fileFilter;
        if (r0 != null) goto L7;
        File[] r4 = r3.listFiles();
    L9:
        if (r4 != null) goto L11;
        r4 = FileUtils.EMPTY_FILE_ARRAY;
    L11:
        Comparator<File> r2 = this.comparator;
        if (r2 != null) goto L14;
    L16:
        return r4;
    L14:
        if (r4.length <= 1) goto L16;
        Arrays.sort(r4, r2);
        goto L16
    L7:
        r4 = r3.listFiles(r0);
        goto L9
    L8:
        r4 = null;
        goto L9
    }

    public void addListener(FileAlterationListener r3) {
        FileAlterationListener r4 = (FileAlterationListener) ZeusTransformUtils.wrapperContextForParams(r3, FileAlterationListener.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.listeners.add(r4);
        return;
    }

    public void checkAndNotify() {
        Iterator<FileAlterationListener> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((FileAlterationListener) ZeusTransformUtils.preCheckCast(r0.next(), FileAlterationListener.class, "com.obric.memorydata.plugin")).onStart(this);
        goto L4
    L6:
        File r1 = this.rootEntry.getFile();
        if (r1.exists() == false) goto L10;
        FileEntry r2 = this.rootEntry;
        checkAndNotify(r2, r2.getChildren(), listFiles(r1));
    L12:
        Iterator<FileAlterationListener> r3 = this.listeners.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        ((FileAlterationListener) ZeusTransformUtils.preCheckCast(r3.next(), FileAlterationListener.class, "com.obric.memorydata.plugin")).onStop(this);
        goto L14
    L16:
        return;
    L10:
        if (this.rootEntry.isExists() == false) goto L12;
        FileEntry r4 = this.rootEntry;
        checkAndNotify(r4, r4.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        goto L12
    }

    public void destroy() {
    }

    public File getDirectory() {
        return this.rootEntry.getFile();
    }

    public FileFilter getFileFilter() {
        return this.fileFilter;
    }

    public Iterable<FileAlterationListener> getListeners() {
        return this.listeners;
    }

    public void initialize() {
        FileEntry r0 = this.rootEntry;
        r0.refresh(r0.getFile());
        FileEntry[] r1 = doListFiles(this.rootEntry.getFile(), this.rootEntry);
        this.rootEntry.setChildren(r1);
    }

    public void removeListener(FileAlterationListener r3) {
        FileAlterationListener r4 = (FileAlterationListener) ZeusTransformUtils.wrapperContextForParams(r3, FileAlterationListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.listeners.remove(r4) == true) goto L5;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getClass().getSimpleName());
        r0.append("[file='");
        r0.append(getDirectory().getPath());
        r0.append('\'');
        if (this.fileFilter == null) goto L5;
        r0.append(", ");
        r0.append(this.fileFilter.toString());
    L5:
        r0.append(", listeners=");
        r0.append(this.listeners.size());
        r0.append("]");
        return r0.toString();
    }
}
