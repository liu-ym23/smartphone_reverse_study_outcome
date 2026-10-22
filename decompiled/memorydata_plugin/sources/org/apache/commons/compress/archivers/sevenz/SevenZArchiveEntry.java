package org.apache.commons.compress.archivers.sevenz;

import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.TimeZone;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes6.dex */
public class SevenZArchiveEntry implements ArchiveEntry {
    static final SevenZArchiveEntry[] EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY = null;
    private long accessDate;
    private long compressedCrc;
    private long compressedSize;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private long crc;
    private long creationDate;
    private boolean hasAccessDate;
    private boolean hasCrc;
    private boolean hasCreationDate;
    private boolean hasLastModifiedDate;
    private boolean hasStream;
    private boolean hasWindowsAttributes;
    private boolean isAntiItem;
    private boolean isDirectory;
    private long lastModifiedDate;
    private String name;
    private long size;
    private int windowsAttributes;

    static {
        EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY = new SevenZArchiveEntry[0];
    }

    public SevenZArchiveEntry() {
    }

    private boolean equalSevenZMethods(Iterable<? extends SevenZMethodConfiguration> r5, Iterable<? extends SevenZMethodConfiguration> r6) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        if (r7 != null) goto L7;
        return true;
    L7:
        return false;
    L8:
        if (r7 != null) goto L10;
        return false;
    L10:
        Iterator r8 = r4.iterator();
        Iterator r9 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L20;
        if (r9.hasNext() == false) goto L15;
        if (((SevenZMethodConfiguration) ZeusTransformUtils.preCheckCast(r8.next(), SevenZMethodConfiguration.class, "com.obric.memorydata.plugin")).equals(r9.next()) == true) goto L12;
        return false;
    L15:
        return false;
    L20:
        return !r9.hasNext();
    }

    public static Date ntfsTimeToJavaTime(long r8) {
        Calendar r7 = Calendar.getInstance();
        r7.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        r7.set(EntityType.EVENT_TASK, 0, 1, 0, 0, 0);
        r7.set(14, 0);
        return new Date(r7.getTimeInMillis() + (r8 / 10000));
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L49:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L49;
        SevenZArchiveEntry r8 = (SevenZArchiveEntry) ZeusTransformUtils.preCheckCast(r7, SevenZArchiveEntry.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.name, r8.name) == false) goto L48;
        if (this.hasStream != r8.hasStream) goto L48;
        if (this.isDirectory != r8.isDirectory) goto L48;
        if (this.isAntiItem != r8.isAntiItem) goto L48;
        if (this.hasCreationDate != r8.hasCreationDate) goto L48;
        if (this.hasLastModifiedDate != r8.hasLastModifiedDate) goto L48;
        if (this.hasAccessDate != r8.hasAccessDate) goto L48;
        if (this.creationDate != r8.creationDate) goto L48;
        if (this.lastModifiedDate != r8.lastModifiedDate) goto L48;
        if (this.accessDate != r8.accessDate) goto L48;
        if (this.hasWindowsAttributes != r8.hasWindowsAttributes) goto L48;
        if (this.windowsAttributes != r8.windowsAttributes) goto L48;
        if (this.hasCrc != r8.hasCrc) goto L48;
        if (this.crc != r8.crc) goto L48;
        if (this.compressedCrc != r8.compressedCrc) goto L48;
        if (this.size != r8.size) goto L48;
        if (this.compressedSize != r8.compressedSize) goto L48;
        if (equalSevenZMethods(this.contentMethods, r8.contentMethods) == false) goto L48;
        return true;
    L48:
        return false;
    }

    long getCompressedSize() {
        return this.compressedSize;
    }

    public Iterable<? extends SevenZMethodConfiguration> getContentMethods() {
        return this.contentMethods;
    }

    public boolean getHasLastModifiedDate() {
        return this.hasLastModifiedDate;
    }

    public Date getLastModifiedDate() {
        if (this.hasLastModifiedDate == false) goto L7;
        return ntfsTimeToJavaTime(this.lastModifiedDate);
    L7:
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        String r0 = getName();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }
}
