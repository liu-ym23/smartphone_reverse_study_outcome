package org.apache.commons.compress.archivers.dump;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes6.dex */
public class DumpArchiveEntry implements ArchiveEntry {
    private final TapeSegmentHeader header;
    private int ino;
    private String name;
    private Set<PERMISSION> permissions;
    private final DumpArchiveSummary summary;
    private TYPE type;

    public static final enum PERMISSION extends Enum<PERMISSION> {
        private static final /* synthetic */ PERMISSION[] $VALUES = null;
        public static final PERMISSION GROUP_EXEC = null;
        public static final PERMISSION GROUP_READ = null;
        public static final PERMISSION GROUP_WRITE = null;
        public static final PERMISSION SETGUI = null;
        public static final PERMISSION SETUID = null;
        public static final PERMISSION STICKY = null;
        public static final PERMISSION USER_EXEC = null;
        public static final PERMISSION USER_READ = null;
        public static final PERMISSION USER_WRITE = null;
        public static final PERMISSION WORLD_EXEC = null;
        public static final PERMISSION WORLD_READ = null;
        public static final PERMISSION WORLD_WRITE = null;
        private final int code;

        static {
            PERMISSION r0 = new PERMISSION("SETUID", 0, 2048);
            SETUID = r0;
            PERMISSION r1 = new PERMISSION("SETGUI", 1, 1024);
            SETGUI = r1;
            PERMISSION r3 = new PERMISSION("STICKY", 2, 512);
            STICKY = r3;
            PERMISSION r5 = new PERMISSION("USER_READ", 3, 256);
            USER_READ = r5;
            PERMISSION r7 = new PERMISSION("USER_WRITE", 4, 128);
            USER_WRITE = r7;
            PERMISSION r9 = new PERMISSION("USER_EXEC", 5, 64);
            USER_EXEC = r9;
            PERMISSION r11 = new PERMISSION("GROUP_READ", 6, 32);
            GROUP_READ = r11;
            PERMISSION r13 = new PERMISSION("GROUP_WRITE", 7, 16);
            GROUP_WRITE = r13;
            PERMISSION r12 = new PERMISSION("GROUP_EXEC", 8, 8);
            GROUP_EXEC = r12;
            PERMISSION r15 = new PERMISSION("WORLD_READ", 9, 4);
            WORLD_READ = r15;
            PERMISSION r14 = new PERMISSION("WORLD_WRITE", 10, 2);
            WORLD_WRITE = r14;
            PERMISSION r8 = new PERMISSION("WORLD_EXEC", 11, 1);
            WORLD_EXEC = r8;
            $VALUES = new PERMISSION[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r15, r14, r8};
        }

        private PERMISSION(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        public static Set<PERMISSION> find(int r7) {
            HashSet r0 = new HashSet();
            PERMISSION[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            PERMISSION r4 = r1[r3];
            int r5 = r4.code;
            if ((r7 & r5) != r5) goto L7;
            r0.add(r4);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            if (r0.isEmpty() == false) goto L13;
            return Collections.emptySet();
        L13:
            return EnumSet.copyOf(r0);
        }

        public static PERMISSION valueOf(String r2) {
            return (PERMISSION) ZeusTransformUtils.preCheckCast(Enum.valueOf(PERMISSION.class, r2), PERMISSION.class, "com.obric.memorydata.plugin");
        }

        public static PERMISSION[] values() {
            return (PERMISSION[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PERMISSION[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE BLKDEV = null;
        public static final TYPE CHRDEV = null;
        public static final TYPE DIRECTORY = null;
        public static final TYPE FIFO = null;
        public static final TYPE FILE = null;
        public static final TYPE LINK = null;
        public static final TYPE SOCKET = null;
        public static final TYPE UNKNOWN = null;
        public static final TYPE WHITEOUT = null;
        private final int code;

        static {
            TYPE r0 = new TYPE("WHITEOUT", 0, 14);
            WHITEOUT = r0;
            TYPE r1 = new TYPE("SOCKET", 1, 12);
            SOCKET = r1;
            TYPE r3 = new TYPE("LINK", 2, 10);
            LINK = r3;
            TYPE r5 = new TYPE("FILE", 3, 8);
            FILE = r5;
            TYPE r7 = new TYPE("BLKDEV", 4, 6);
            BLKDEV = r7;
            TYPE r10 = new TYPE("DIRECTORY", 5, 4);
            DIRECTORY = r10;
            TYPE r13 = new TYPE("CHRDEV", 6, 2);
            CHRDEV = r13;
            TYPE r15 = new TYPE("FIFO", 7, 1);
            FIFO = r15;
            TYPE r12 = new TYPE("UNKNOWN", 8, 15);
            UNKNOWN = r12;
            $VALUES = new TYPE[]{r0, r1, r3, r5, r7, r10, r13, r15, r12};
        }

        private TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        public static TYPE find(int r6) {
            TYPE r0 = UNKNOWN;
            TYPE[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            TYPE r4 = r1[r3];
            if (r6 != r4.code) goto L7;
            r0 = r4;
        L7:
            r3 = r3 + 1;
            goto L3
        L8:
            return r0;
        }

        public static TYPE valueOf(String r2) {
            return (TYPE) ZeusTransformUtils.preCheckCast(Enum.valueOf(TYPE.class, r2), TYPE.class, "com.obric.memorydata.plugin");
        }

        public static TYPE[] values() {
            return (TYPE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TYPE[].class, "com.obric.memorydata.plugin");
        }
    }

    static class TapeSegmentHeader {
        private final byte[] cdata;
        private int count;
        private int holes;
        private DumpArchiveConstants.SEGMENT_TYPE type;
        private int volume;

        TapeSegmentHeader() {
            this.cdata = new byte[512];
        }

        static /* synthetic */ int access$102(TapeSegmentHeader r0, int r1) {
            r0.volume = r1;
            return r1;
        }

        static /* synthetic */ int access$300(TapeSegmentHeader r0) {
            return r0.count;
        }

        static /* synthetic */ int access$302(TapeSegmentHeader r0, int r1) {
            r0.count = r1;
            return r1;
        }

        static /* synthetic */ int access$402(TapeSegmentHeader r0, int r1) {
            r0.holes = r1;
            return r1;
        }

        static /* synthetic */ int access$408(TapeSegmentHeader r2) {
            int r0 = r2.holes;
            r2.holes = r0 + 1;
            return r0;
        }

        static /* synthetic */ byte[] access$500(TapeSegmentHeader r0) {
            return r0.cdata;
        }

        public DumpArchiveConstants.SEGMENT_TYPE getType() {
            return this.type;
        }
    }

    public DumpArchiveEntry() {
        this.type = TYPE.UNKNOWN;
        this.permissions = Collections.emptySet();
        this.summary = null;
        this.header = new TapeSegmentHeader();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (r5.getClass().equals(getClass()) == false) goto L25;
        DumpArchiveEntry r6 = (DumpArchiveEntry) ZeusTransformUtils.preCheckCast(r5, DumpArchiveEntry.class, "com.obric.memorydata.plugin");
        if (r6.header != null) goto L14;
        return false;
    L14:
        if (this.ino == r6.ino) goto L16;
        return false;
    L16:
        DumpArchiveSummary r4 = this.summary;
        if (r4 == null) goto L19;
    L20:
        if (r4 != null) goto L22;
    L24:
        return true;
    L22:
        if (r4.equals(r6.summary) == true) goto L24;
    L23:
        return false;
    L19:
        if (r6.summary != null) goto L23;
        goto L20
    }

    public String getName() {
        return this.name;
    }

    public TYPE getType() {
        return this.type;
    }

    public int hashCode() {
        return this.ino;
    }

    public String toString() {
        return getName();
    }

    void update(byte[] r5) {
        TapeSegmentHeader.access$102(this.header, DumpArchiveUtil.convert32(r5, 16));
        TapeSegmentHeader.access$302(this.header, DumpArchiveUtil.convert32(r5, 160));
        TapeSegmentHeader.access$402(this.header, 0);
        int r0 = 0;
    L4:
        if (r0 >= 512) goto L11;
        if (r0 >= TapeSegmentHeader.access$300(this.header)) goto L11;
        if (r5[r0 + 164] != 0) goto L10;
        TapeSegmentHeader.access$408(this.header);
    L10:
        r0 = r0 + 1;
    L11:
        System.arraycopy(r5, 164, TapeSegmentHeader.access$500(this.header), 0, 512);
    }
}
