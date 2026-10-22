package com.facebook.soloader;

import ai.j0;
import android.content.Context;
import android.util.Log;
import androidx.room.writer.DaoWriter;
import com.lynx.tasm.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.collections.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExtractFromZipSoSource extends UnpackingSoSource {
    public final File e;
    public final String f;

    public static final class ZipDso extends UnpackingSoSource.Dso implements Comparable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ZipEntry f8470c;
        public final int d;

        public ZipDso(String r10, ZipEntry r11, int r12) {
            String r5 = r11.getName();
            long r13 = r11.getSize();
            long r14 = r11.getCompressedSize();
            long r15 = r11.getCrc();
            StringBuilder r16 = new StringBuilder("pseudo-zip-hash-1-");
            r16.append(r5);
            r16.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
            r16.append(r13);
            a.o(r16, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, r14, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
            r16.append(r15);
            super(r10, r16.toString());
            this.f8470c = r11;
            this.d = r12;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r5) {
            return this.f8487a.compareTo(((ZipDso) r5).f8487a);
        }
    }

    public class ZipUnpacker extends UnpackingSoSource.Unpacker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipDso[] f8471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ZipFile f8472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ExtractFromZipSoSource f8473c;
        public final /* synthetic */ ApkSoSource d;

        public final class ZipBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8474a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ZipUnpacker f8475b;

            public ZipBackedInputDsoIterator(ZipUnpacker r5) {
                this.f8475b = r5;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public final boolean b() {
                this.f8475b.d();
                if (this.f8474a >= this.f8475b.f8471a.length) goto L6;
                return true;
            L6:
                return false;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public final UnpackingSoSource.InputDsoStream c() {
                this.f8475b.d();
                ZipUnpacker r5 = this.f8475b;
                ZipDso[] r10 = r5.f8471a;
                int r11 = this.f8474a;
                this.f8474a = r11 + 1;
                ZipDso r12 = r10[r11];
                InputStream r13 = r5.f8472b.getInputStream(r12.f8470c);
                return new UnpackingSoSource.InputDsoStream(r12, r13);
            L5:
                th = move-exception;
                if (r13 == null) goto L8;
                r13.close();
            L8:
                throw th;
            }
        }

        public ZipUnpacker(ApkSoSource r5, ExtractFromZipSoSource r10) {
            this.d = r5;
            this.f8472b = new ZipFile(r5.e);
            this.f8473c = r10;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.DsoManifest b() {
            return new UnpackingSoSource.DsoManifest(d());
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.InputDsoIterator c() {
            return new ZipBackedInputDsoIterator(this);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f8472b.close();
        }

        public final ZipDso[] d() {
            if (this.f8471a != null) goto L69;
            LinkedHashSet r5 = new LinkedHashSet();
            HashMap r10 = new HashMap();
            Pattern r11 = Pattern.compile(this.d.f);
            String[] r12 = SysUtil.a();
            Enumeration<? extends ZipEntry> r13 = this.f8472b.entries();
        L5:
            int r14 = 0;
            if (r13.hasMoreElements() == false) goto L25;
            ZipEntry r15 = r13.nextElement();
            Matcher r16 = r11.matcher(r15.getName());
            if (r16.matches() == false) goto L5;
            String r17 = r16.group(1);
            String r18 = r16.group(2);
        L11:
            if (r14 >= r12.length) goto L18;
            String r19 = r12[r14];
            if (r19 == null) goto L17;
            if (r17.equals(r19) == false) goto L17;
        L19:
            if (r14 < 0) goto L5;
            r5.add(r17);
            ZipDso r20 = (ZipDso) r10.get(r18);
            if (r20 == null) goto L24;
            if (r14 >= r20.d) goto L5;
        L24:
            r10.put(r18, new ZipDso(r18, r15, r14));
        L17:
            r14 = r14 + 1;
            goto L11
        L18:
            r14 = -1;
            goto L19
        L25:
            ExtractFromZipSoSource r21 = this.f8473c;
            String[] r22 = (String[]) r5.toArray(new String[r5.size()]);
            r21.getClass();
            ZipDso[] r23 = (ZipDso[]) r10.values().toArray(new ZipDso[r10.size()]);
            Arrays.sort(r23);
            int r24 = 0;
            int r25 = 0;
        L27:
            if (r24 >= r23.length) goto L60;
            ZipDso r26 = r23[r24];
            ZipEntry r27 = r26.f8470c;
            String r28 = r26.f8487a;
            ApkSoSource.ApkUnpacker r29 = (ApkSoSource.ApkUnpacker) this;
            String r110 = r27.getName();
            r29.g.getClass();
            if (r28.equals(null) == false) goto L33;
            r29.g.getClass();
            String r30 = "allowing consideration of corrupted lib ".concat(r28);
        L31:
            boolean r31 = true;
        L55:
            Log.d("ApkSoSource", r30);
            if (r31 == false) goto L58;
            r25 = r25 + 1;
        L59:
            r24 = r24 + 1;
            goto L27
        L58:
            r23[r24] = null;
            goto L59
        L33:
            if ((r29.f & 1) != 0) goto L35;
            r30 = g.d("allowing consideration of ", r110, ": self-extraction preferred");
            goto L31
        L35:
            File r111 = new File(r29.e, r28);
        L40:
            e = move-exception;
            String r32 = e.toString();
            StringBuilder r112 = androidx.constraintlayout.motion.widget.a.y("not allowing consideration of ", r110, ": ", r28, ", IOException when constructing path: ");
            r112.append(r32);
            String r33 = r112.toString();
        L44:
            boolean r113 = false;
        L45:
            if (r113 == true) goto L47;
            r30 = r33;
        L53:
            r31 = false;
            goto L55
        L47:
            if (r111.isFile() == true) goto L49;
            r30 = j0.l("allowing consideration of ", r110, ": ", r28, " not in system lib dir");
            goto L31
        L49:
            long r114 = r111.length();
            long r34 = r27.getSize();
            if (r114 == r34) goto L52;
            r30 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[]{r111, Long.valueOf(r114), Long.valueOf(r34)});
            goto L31
        L52:
            r30 = g.d("not allowing consideration of ", r110, ": deferring to libdir");
            goto L53
        L37:
            if (r111.getCanonicalPath().startsWith(r29.e.getCanonicalPath()) == true) goto L42;
            r33 = "not allowing consideration of " + r110 + ": " + r28 + " not in lib dir";     // Catch: IOException -> L40
            goto L44
        L42:
            r33 = "";
            r113 = true;
            goto L45
        L60:
            ZipDso[] r35 = new ZipDso[r25];
            int r36 = 0;
        L62:
            if (r14 >= r23.length) goto L67;
            ZipDso r37 = r23[r14];
            if (r37 == null) goto L66;
            r35[r36] = r37;
            r36 = r36 + 1;
        L66:
            r14 = r14 + 1;
            goto L62
        L67:
            this.f8471a = r35;
        L69:
            return this.f8471a;
        }
    }

    public ExtractFromZipSoSource(Context r5, String r10, File r11) {
        super(r5, r10);
        this.e = r11;
        this.f = "^lib/([^/]+)/([^/]+\\.so)$";
    }
}
