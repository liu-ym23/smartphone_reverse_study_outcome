package com.facebook.soloader;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class ExoSoSource extends UnpackingSoSource {

    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileDso[] f8466a;

        public final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8467a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExoUnpacker f8468b;

            public FileBackedInputDsoIterator(ExoUnpacker r5) {
                this.f8468b = r5;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public final boolean b() {
                if (this.f8467a >= this.f8468b.f8466a.length) goto L6;
                return true;
            L6:
                return false;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public final UnpackingSoSource.InputDsoStream c() {
                FileDso[] r5 = this.f8468b.f8466a;
                int r10 = this.f8467a;
                this.f8467a = r10 + 1;
                FileDso r11 = r5[r10];
                FileInputStream r12 = new FileInputStream(r11.f8469c);
                return new UnpackingSoSource.InputDsoStream(r11, r12);
            L5:
                th = move-exception;
                r12.close();
                throw th;
            }
        }

        public ExoUnpacker(ExoSoSource r17, ExoSoSource r18) {
            File r5 = new File("/data/local/tmp/exopackage/" + r17.f8483c.getPackageName() + "/native-libs/");
            ArrayList r10 = new ArrayList();
            LinkedHashSet r11 = new LinkedHashSet();
            String[] r12 = SysUtil.a();
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L46;
            String r15 = r12[r14];
            File r16 = new File(r5, r15);
            if (r16.isDirectory() == false) goto L32;
            r11.add(r15);
            File r19 = new File(r16, "metadata.txt");
            if (r19.isFile() == false) goto L32;
            FileReader r20 = new FileReader(r19);
            BufferedReader r21 = new BufferedReader(r20);     // Catch: Throwable -> L33
        L51:
            String r110 = r21.readLine();     // Catch: Throwable -> L25
            if (r110 == null) goto L30;
            if (r110.length() == 0) goto L51;
            int r111 = r110.indexOf(32);     // Catch: Throwable -> L25
            if (r111 == (-1)) goto L29;
            String r112 = r110.substring(0, r111) + ".so";     // Catch: Throwable -> L25
            int r113 = r10.size();     // Catch: Throwable -> L25
            int r114 = 0;
        L20:
            if (r114 >= r113) goto L27;
            if (((FileDso) r10.get(r114)).f8487a.equals(r112) == true) goto L51;
            r114 = r114 + 1;     // Catch: Throwable -> L25
            goto L20
        L27:
            String r115 = r110.substring(r111 + 1);     // Catch: Throwable -> L25
            r10.add(new FileDso(r112, r115, new File(r16, r115)));     // Catch: Throwable -> L25
            goto L51
        L29:
            throw new RuntimeException("illegal line in exopackage metadata: [" + r110 + "]");     // Catch: Throwable -> L25
        L30:
            r21.close();     // Catch: Throwable -> L33
            r20.close();
        L25:
            th = move-exception;
            r21.close();     // Catch: Throwable -> L37
        L69:
            throw th;     // Catch: Throwable -> L33
        L37:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            r20.close();     // Catch: Throwable -> L43
            throw th;
        L43:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L32:
            r14 = r14 + 1;
            goto L3
        L46:
            String[] r22 = (String[]) r11.toArray(new String[r11.size()]);
            this.f8466a = (FileDso[]) r10.toArray(new FileDso[r10.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.DsoManifest b() {
            return new UnpackingSoSource.DsoManifest(this.f8466a);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.InputDsoIterator c() {
            return new FileBackedInputDsoIterator(this);
        }
    }

    public static final class FileDso extends UnpackingSoSource.Dso {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File f8469c;

        public FileDso(String r5, String r10, File r11) {
            super(r5, r10);
            this.f8469c = r11;
        }
    }

    public ExoSoSource(Context r5) {
        super(r5, "lib-main");
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final UnpackingSoSource.Unpacker b() {
        return new ExoUnpacker(this, this);
    }
}
