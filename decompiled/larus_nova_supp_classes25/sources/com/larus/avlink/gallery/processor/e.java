package com.larus.avlink.gallery.processor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.dora.api.model.MediaInfo;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static boolean a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileName");
            if (StringsKt.endsWith(r2, ".pack", true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.endsWith(r2, ".zip", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        public static File b(PolarisFileWrapper r10) {
            Intrinsics.checkNotNullParameter(r10, "dir");
            List r11 = SequencesKt.toList(SequencesKt.filter(FilesKt.walkTopDown(r10), new d()));
            ArrayList r0 = new ArrayList();
            Iterator r1 = r11.iterator();
        L3:
            boolean r3 = false;
            if (r1.hasNext() == false) goto L10;
            Object r2 = r1.next();
            if (((File) r2).length() > 0) goto L8;
            r3 = true;
        L8:
            if (r3 == false) goto L3;
            r0.add(r2);
            goto L3
        L10:
            Iterator r4 = r0.iterator();
        L12:
            if (r4.hasNext() == false) goto L14;
            File r5 = (File) r4.next();
            FLogger.a.w("DownloadArchiveProcessor", "Skip empty image pack file: " + r5.getAbsolutePath());
            goto L12
        L14:
            Iterator r12 = r11.iterator();
        L16:
            if (r12.hasNext() == false) goto L23;
            Object r6 = r12.next();
            if (((File) r6).length() <= 0) goto L20;
            boolean r7 = true;
        L21:
            if (r7 == false) goto L16;
        L25:
            return (File) r6;
        L20:
            r7 = false;
            goto L21
        L23:
            r6 = null;
            goto L25
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final File a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Incomplete(file=" + this.a + ')';
            }

            public a(File r2) {
                Intrinsics.checkNotNullParameter(r2, "file");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.larus.avlink.gallery.processor.e$b$b, reason: collision with other inner class name */
        public static final class C0009b extends b {
            public static final C0009b a = null;

            static {
                a = new C0009b();
            }

            public C0009b() {
            }
        }

        public static final class c extends b {
            public final File a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Ready(file=" + this.a + ')';
            }

            public c(File r2) {
                Intrinsics.checkNotNullParameter(r2, "file");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Result(displayableFilePath=" + this.a + ", downloadFilePath=" + this.b + ", processingInputFilePath=" + this.c + ", processingDirPath=" + this.d + ')';
        }

        public c(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "displayableFilePath");
            Intrinsics.checkNotNullParameter(r3, "downloadFilePath");
            Intrinsics.checkNotNullParameter(r4, "processingInputFilePath");
            Intrinsics.checkNotNullParameter(r5, "processingDirPath");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public e() {
    }

    public static File b(PolarisFileWrapper r8) {
        Iterator r9 = FilesKt.walkTopDown(r8).iterator();
    L3:
        Object r1 = null;
        if (r9.hasNext() == false) goto L15;
        Object r0 = r9.next();
        File r2 = (File) r0;
        boolean r4 = false;
        if (r2.isFile() == false) goto L12;
        String r3 = r2.getName();
        Locale r5 = Locale.ROOT;
        if (StringsKt.endsWith$default(r3.toLowerCase(r5), ".jpeg", false, 2, null) == false) goto L10;
    L11:
        r4 = true;
        goto L12
    L10:
        if (StringsKt.endsWith$default(r2.getName().toLowerCase(r5), ".jpg", false, 2, null) == true) goto L11;
    L12:
        if (r4 == false) goto L3;
        r1 = r0;
    L15:
        return (File) r1;
    }

    public static Pair a(String r8, MediaInfo r9) {
        int r0 = 1080;
        int r1 = 1920;
        MatchResult r2 = Regex.find$default(new Regex("(\\d+)x(\\d+)"), r8, 0, 2, null);     // Catch: Exception -> L21
        if (r2 != null) goto L6;
        MatchResult r10 = Regex.find$default(new Regex("_(\\d{3,4})_(\\d{3,4})(?:\\.|$)"), r8, 0, 2, null);     // Catch: Exception -> L21
        if (r10 != null) goto L10;
        Integer r11 = r9.getWidth();     // Catch: Exception -> L21
        if (r11 == null) goto L14;
        int r12 = r11.intValue();     // Catch: Exception -> L21
    L15:
        Integer r3 = r9.getHeight();     // Catch: Exception -> L21
        if (r3 == null) goto L18;
        int r4 = r3.intValue();     // Catch: Exception -> L21
    L31:
        return new Pair(Integer.valueOf(r12), Integer.valueOf(r4));
    L18:
        r4 = 1080;
        goto L31
    L14:
        r12 = 1920;
        goto L15
    L10:
        return new Pair(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r10.getGroupValues(), 2))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r10.getGroupValues(), 1))));
    L6:
        return new Pair(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r2.getGroupValues(), 2))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r2.getGroupValues(), 1))));
    L21:
        e = move-exception;
        FLogger.a.e("DownloadArchiveProcessor", "Error extracting dimensions: " + e.getMessage(), e);
        Integer r13 = r9.getWidth();
        if (r13 == null) goto L25;
        r1 = r13.intValue();
    L25:
        Integer r14 = r9.getHeight();
        if (r14 == null) goto L29;
        r0 = r14.intValue();
    L29:
        return new Pair(Integer.valueOf(r1), Integer.valueOf(r0));
    }

    public static File d(PolarisFileWrapper r5, String r6) {
        File r7 = r5.getCanonicalFile();
        File r0 = new PolarisFileWrapper(r7, r6).getCanonicalFile();
        if (StringsKt.startsWith$default(r0.getPath(), r7.getPath() + File.separator, false, 2, null) == false) goto L7;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        throw new IOException("Unsafe zip entry path: " + r6);
    }

    public static boolean e(File r6, String r7) {
        if (r6.length() > 0) goto L6;
        return false;
    L6:
        if (StringsKt.endsWith(r7, ".zip", true) == true) goto L20;
        return true;
    L20:
        PolarisZipFileWrapper r8 = new PolarisZipFileWrapper(r6);     // Catch: Exception -> L19
        boolean r9 = r8.entries().hasMoreElements();     // Catch: Throwable -> L13
        goto L25
    L11:
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L19
        return r9;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L25:
        return false;
    }

    public static String c(String r7, int r8, int r9, boolean r10, MediaInfo r11) {
        long r0 = 0;
        if (r10 == false) goto L8;
        Number r2 = r11.getDuration();
        if (r2 != null) goto L7;
        r2 = Double.valueOf(5000.0d);
    L7:
        long r3 = r2.longValue();
    L9:
        Long r4 = r11.getCreateTime();
        if (r4 == null) goto L13;
        r0 = r4.longValue();
    L13:
        if (r0 >= 1735660800000L) goto L15;
        Long r12 = Long.valueOf(System.currentTimeMillis());
    L16:
        if (r10 == false) goto L18;
        String r13 = ".mp4";
    L20:
        return "media_" + r7 + "_0_" + r3 + '_' + r9 + '_' + r8 + '_' + r12 + r13;
    L18:
        r13 = ".jpeg";
        goto L20
    L15:
        r12 = r11.getCreateTime();
        goto L16
    L8:
        r3 = 0;
        goto L9
    }

    public static c f(String r22, String r23, String r24, MediaInfo r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r23, "sourceFileName");
        Intrinsics.checkNotNullParameter(r24, "mediaId");
        Intrinsics.checkNotNullParameter(r25, "mediaInfo");
        if (r22 == null) goto L162;
        File r6 = new PolarisFileWrapper(r22);
        if (r6.exists() == true) goto L8;
        FLogger.a.w("DownloadArchiveProcessor", "Archive source file not found: ".concat(r22));
        return null;
    L8:
        int r0 = j0.a;
        a.d(r6.getAbsolutePath(), r23, r24);
        com.larus.avlink.gallery.e.a.getClass();
        Intrinsics.checkNotNullParameter(r24, "mediaId");
        PolarisFileWrapper r4 = new PolarisFileWrapper(com.larus.avlink.gallery.e.f(), r24);
        r4.mkdirs();
        final PolarisFileWrapper r7 = new PolarisFileWrapper(r4, "unpacked");
        if (r7.exists() == false) goto L11;
        FilesKt.deleteRecursively(r7);
    L11:
        r7.mkdirs();
        FLogger r1 = FLogger.a;
        StringBuilder r9 = new StringBuilder("Archive source file: ");
        r9.append(r6.getAbsolutePath());
        String r10 = ", size=";
        r9.append(", size=");
        r9.append(r6.length());
        char r11 = 'B';
        r9.append('B');
        r1.i("DownloadArchiveProcessor", r9.toString());
        if (StringsKt.endsWith(r23, ".zip", true) == false) goto L95;
        PolarisZipFileWrapper r13 = new PolarisZipFileWrapper(r6);
        Enumeration<? extends ZipEntry> r2 = r13.entries();     // Catch: Throwable -> L88
    L15:
        if (r2.hasMoreElements() == false) goto L83;
        ZipEntry r14 = r2.nextElement();     // Catch: Throwable -> L81
        FLogger r15 = FLogger.a;     // Catch: Throwable -> L81
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L81
        r12.append("Zip entry: ");     // Catch: Throwable -> L81
        r12.append(r14.getName());     // Catch: Throwable -> L81
        r12.append(", isDirectory=");     // Catch: Throwable -> L81
        r12.append(r14.isDirectory());     // Catch: Throwable -> L81
        r12.append(r10);     // Catch: Throwable -> L81
        PolarisZipFileWrapper r16 = r13;
        r12.append(r14.getSize());     // Catch: Throwable -> L79
        r12.append(", compressedSize=");     // Catch: Throwable -> L79
        r12.append(r14.getCompressedSize());     // Catch: Throwable -> L79
        r12.append(", method=");     // Catch: Throwable -> L79
        r12.append(r14.getMethod());     // Catch: Throwable -> L79
        r15.i("DownloadArchiveProcessor", r12.toString());     // Catch: Throwable -> L79
        File r17 = d(r7, r14.getName());     // Catch: Throwable -> L76
        if (r14.isDirectory() == false) goto L26;
        r17.mkdirs();     // Catch: Throwable -> L79
    L24:
        PolarisFileWrapper r19 = r4;
        String r18 = r10;
        PolarisZipFileWrapper r110 = r16;
    L51:
        r13 = r110;
        r10 = r18;
        r4 = r19;
        r11 = 'B';
        goto L15
    L26:
        if (r17.exists() == true) goto L28;
    L32:
        boolean r111 = false;
    L33:
        if (r111 == false) goto L35;
        r15.w("DownloadArchiveProcessor", "Skip zero-byte duplicate zip entry: " + r14.getName() + ", existingSize=" + r17.length() + r11);     // Catch: Throwable -> L79
        goto L24
    L35:
        File r112 = r17.getParentFile();     // Catch: Throwable -> L79
        if (r112 == null) goto L166;
        r112.mkdirs();     // Catch: Throwable -> L79
    L166:
        InputStream r113 = r16.getInputStream(r14);     // Catch: Throwable -> L74
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r17);     // Catch: Throwable -> L64
        byte[] r20 = new byte[262144];     // Catch: Throwable -> L54
        int r5 = r113.read(r20);     // Catch: Throwable -> L54
        r110 = r16;
        long r115 = 0;
    L44:
        if (r5 < 0) goto L47;
        String r116 = r10;
        r114.write(r20, 0, r5);     // Catch: Throwable -> L52
        r115 = r115 + ((long) r5);     // Catch: Throwable -> L52
        r5 = r113.read(r20);     // Catch: Throwable -> L52
        r10 = r116;
        r4 = r4;
    L52:
        th = th;
    L56:
        Throwable r3 = th;
        throw r3;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        CloseableKt.closeFinally(r114, r3);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L62:
        th = th;
    L66:
        Throwable r8 = th;
        throw r8;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        CloseableKt.closeFinally(r113, r8);     // Catch: Throwable -> L72
        throw th;     // Catch: Throwable -> L72
    L72:
        th = th;
    L78:
        Throwable r21 = th;
        PolarisZipFileWrapper r27 = r110;
    L182:
        throw r21;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        CloseableKt.closeFinally(r27, r21);
        throw th;
    L47:
        r19 = r4;
        r18 = r10;
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L52
        CloseableKt.closeFinally(r114, null);     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L72
        FLogger.a.i("DownloadArchiveProcessor", "Extracted zip entry: " + r14.getName() + ", writtenBytes=" + r115);     // Catch: Throwable -> L72
    L54:
        th = th;
        r110 = r16;
    L64:
        th = th;
        r110 = r16;
    L74:
        th = move-exception;
        r21 = th;
        r27 = r16;
        goto L182
    L28:
        if (r17.length() <= 0) goto L32;
        if (r14.getSize() != 0) goto L32;
        r111 = true;
    L76:
        th = th;
        r110 = r16;
    L79:
        th = move-exception;
        r21 = th;
        r27 = r16;
    L81:
        th = move-exception;
        r21 = th;
        r27 = r13;
        goto L182
    L83:
        PolarisFileWrapper r117 = r4;
        PolarisZipFileWrapper r118 = r13;
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L86
        CloseableKt.closeFinally(r118, null);
    L98:
        FLogger r30 = FLogger.a;
        r30.i("DownloadArchiveProcessor", "Successfully extracted archive: " + r23 + " to " + r7.getAbsolutePath());
        List r31 = SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.filter(FilesKt.walkTopDown(r7), new com.larus.avlink.gallery.processor.b()), 20), new com.larus.avlink.gallery.processor.c(r7)));
        StringBuilder r32 = new StringBuilder("Archive extracted files: ");
        r32.append(r31);
        r30.i("DownloadArchiveProcessor", r32.toString());
        if (r26 == false) goto L104;
        File r33 = a.b(r7);
        if (r33 != null) goto L105;
        r30.w("DownloadArchiveProcessor", "No non-empty inner image pack found in live photo archive: ".concat(r23));
        return null;
    L105:
        File r34 = b(r7);
        if (r34 == null) goto L108;
    L107:
        File r119 = r34;
        if (r119 != null) goto L163;
        return null;
    L163:
        int r35 = j0.a;     // Catch: Exception -> L144
        a.d(r119.getAbsolutePath(), r119.getName(), r24);     // Catch: Exception -> L144
        boolean r36 = StringsKt.endsWith$default(r119.getName().toLowerCase(Locale.ROOT), ".mp4", false, 2, null);     // Catch: Exception -> L144
        Pair r37 = a(r119.getName(), r25);     // Catch: Exception -> L144
        String r38 = c(r24, ((Number) r37.getFirst()).intValue(), ((Number) r37.getSecond()).intValue(), r36, r25);     // Catch: Exception -> L144
        com.larus.avlink.gallery.e.a.getClass();     // Catch: Exception -> L144
        PolarisFileWrapper r39 = com.larus.avlink.gallery.e.g();     // Catch: Exception -> L144
        r39.mkdirs();     // Catch: Exception -> L144
        PolarisFileWrapper r40 = new PolarisFileWrapper(r39, r38);     // Catch: Exception -> L144
        FilesKt.copyTo$default(r119, r40, true, 0, 4, null);     // Catch: Exception -> L144
        FLogger.a.i("DownloadArchiveProcessor", "Prepared displayable file: " + r40.getAbsolutePath());     // Catch: Exception -> L144
        String r41 = r40.getAbsolutePath();     // Catch: Exception -> L144
    L146:
        if (r41 != null) goto L150;
        return null;
    L150:
        if (r26 == false) goto L152;
        String r42 = r6.getAbsolutePath();
    L153:
        Intrinsics.checkNotNull(r42);
        return new c(r41, r42, r33.getAbsolutePath(), r117.getAbsolutePath());
    L152:
        r42 = r33.getAbsolutePath();
    L144:
        e = move-exception;
        FLogger.a.e("DownloadArchiveProcessor", "Error preparing displayable file: " + e.getMessage(), e);
        r41 = null;
        goto L146
    L108:
        if (r26 == true) goto L196;
    L125:
        Iterator r43 = FilesKt.walkTopDown(r7).iterator();
    L127:
        if (r43.hasNext() == false) goto L136;
        Object r44 = r43.next();
        File r45 = (File) r44;
        if (r45.isFile() == true) goto L131;
    L133:
        boolean r120 = false;
    L134:
        if (r120 == false) goto L127;
    L137:
        r34 = (File) r44;
        goto L107
    L131:
        if (StringsKt.endsWith$default(r45.getName().toLowerCase(Locale.ROOT), ".mp4", false, 2, null) == false) goto L133;
        r120 = true;
        goto L134
    L136:
        r44 = null;
        goto L137
    L196:
        PolarisFileWrapper r46 = new PolarisFileWrapper(r7, "live_photo_image_pack_unpacked");     // Catch: Exception -> L121
        r46.mkdirs();     // Catch: Exception -> L121
        PolarisFileInputStreamWrapper r47 = new PolarisFileInputStreamWrapper(r33);     // Catch: Exception -> L121
        ja8.f.a(r47, r46.getAbsolutePath());     // Catch: Throwable -> L114
    L112:
        CloseableKt.closeFinally(r47, null);     // Catch: Exception -> L121
        r34 = b(r46);     // Catch: Exception -> L121
    L123:
        if (r34 == null) goto L125;
    L114:
        th = move-exception;
        throw th;     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        CloseableKt.closeFinally(r47, th);     // Catch: Exception -> L121
        throw th;     // Catch: Exception -> L121
    L121:
        e = move-exception;
        FLogger.a.e("DownloadArchiveProcessor", "Error unpacking live photo image pack: " + e.getMessage(), e);
        r34 = null;
        goto L123
    L104:
        r33 = r6;
    L86:
        th = th;
        r27 = r118;
    L90:
        r21 = th;
    L88:
        th = th;
        r27 = r13;
        goto L90
    L95:
        r117 = r4;
        PolarisFileInputStreamWrapper r48 = new PolarisFileInputStreamWrapper(r6);
        ja8.f.a(r48, r7.getAbsolutePath());     // Catch: Throwable -> L155
        Unit r49 = Unit.INSTANCE;     // Catch: Throwable -> L155
        CloseableKt.closeFinally(r48, null);
    L155:
        th = move-exception;
        throw th;     // Catch: Throwable -> L158
    L158:
        th = move-exception;
        CloseableKt.closeFinally(r48, th);
        throw th;
    L162:
        return null;
    }
}
