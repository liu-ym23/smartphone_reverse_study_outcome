package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import f4.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8483c;
    public FileLocker d;

    public static class Dso {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8488b;

        public Dso(String r5, String r10) {
            this.f8487a = r5;
            this.f8488b = r10;
        }
    }

    public static final class DsoManifest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Dso[] f8489a;

        public DsoManifest(Dso[] r5) {
            this.f8489a = r5;
        }

        public static final DsoManifest a(RandomAccessFile r10) {
            if (r10.readByte() != 1) goto L14;
            int r5 = r10.readInt();
            if (r5 < 0) goto L12;
            Dso[] r11 = new Dso[r5];
            int r12 = 0;
        L7:
            if (r12 >= r5) goto L10;
            r11[r12] = new Dso(r10.readUTF(), r10.readUTF());
            r12 = r12 + 1;
            goto L7
        L10:
            return new DsoManifest(r11);
        L12:
            throw new RuntimeException("illegal number of shared libraries");
        L14:
            throw new RuntimeException("wrong dso manifest version");
        }
    }

    public interface InputDso extends Closeable {
    }

    public static abstract class InputDsoIterator implements Closeable {
        public InputDsoIterator() {
        }

        public abstract boolean b();

        public abstract InputDsoStream c();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    public static class InputDsoStream implements InputDso {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Dso f8490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f8491b;

        public InputDsoStream(Dso r5, InputStream r10) {
            this.f8490a = r5;
            this.f8491b = r10;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f8491b.close();
        }
    }

    public static abstract class Unpacker implements Closeable {
        public Unpacker() {
        }

        public abstract DsoManifest b();

        public abstract InputDsoIterator c();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public UnpackingSoSource(Context r5, String r10) {
        super(new File(b.b(new StringBuilder(), r5.getApplicationInfo().dataDir, "/", r10)), 1);
        new HashMap();
        this.f8483c = r5;
    }

    public static void a(File r5, byte r10) {
        RandomAccessFile r11 = new RandomAccessFile(r5, "rw");     // Catch: SyncFailedException -> L7
        r11.seek(0);     // Catch: Throwable -> L9
        r11.write(r10);     // Catch: Throwable -> L9
        r11.setLength(r11.getFilePointer());     // Catch: Throwable -> L9
        r11.getFD().sync();     // Catch: Throwable -> L9
        r11.close();     // Catch: SyncFailedException -> L7
        return;
    L9:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: SyncFailedException -> L7
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: SyncFailedException -> L7
    L7:
        e = move-exception;
        Log.w("fb-UnpackingSoSource", "state file sync failed", e);
    }

    public abstract Unpacker b();

    public final void b(InputDso r13, byte[] r14) {
        File r10 = new File(this.f8464a, ((InputDsoStream) r13).f8490a.f8487a);
        RandomAccessFile r11 = null;
    L9:
        th = move-exception;
        if (r10.setWritable(false) == true) goto L40;
        Log.w("fb-UnpackingSoSource", "error removing " + r10 + " write permission");
    L40:
        if (r11 == null) goto L42;
        r11.close();
    L42:
        throw th;
    L11:
        e = move-exception;
        SysUtil.a(r10);     // Catch: Throwable -> L9
        throw e;     // Catch: Throwable -> L9
    L4:
        if (r10.exists() == true) goto L6;
    L43:
        r11 = new RandomAccessFile(r10, "rw");     // Catch: Throwable -> L9 IOException -> L15
    L17:
        int r5 = ((InputDsoStream) r13).f8491b.available();     // Catch: Throwable -> L9 IOException -> L11
        if (r5 <= 1) goto L20;
        SysUtil.LollipopSysdeps.fallocateIfSupported(r11.getFD(), r5);     // Catch: Throwable -> L9 IOException -> L11
    L20:
        InputStream r15 = ((InputDsoStream) r13).f8491b;     // Catch: Throwable -> L9 IOException -> L11
        int r12 = 0;
    L22:
        if (r12 >= Integer.MAX_VALUE) goto L26;
        int r16 = r15.read(r14, 0, Math.min(r14.length, Integer.MAX_VALUE - r12));     // Catch: Throwable -> L9 IOException -> L11
        if (r16 == (-1)) goto L26;
        r11.write(r14, 0, r16);     // Catch: Throwable -> L9 IOException -> L11
        r12 = r12 + r16;     // Catch: Throwable -> L9 IOException -> L11
    L26:
        r11.setLength(r11.getFilePointer());     // Catch: Throwable -> L9 IOException -> L11
        if (r10.setExecutable(true, false) == false) goto L34;
        if (r10.setWritable(false) == true) goto L31;
        Log.w("fb-UnpackingSoSource", "error removing " + r10 + " write permission");
    L31:
        r11.close();
        return;
    L34:
        throw new IOException("cannot make file executable: " + r10);     // Catch: Throwable -> L9 IOException -> L11
    L15:
        e = move-exception;
        Log.w("fb-UnpackingSoSource", "error overwriting " + r10 + " trying to delete and start over", e);     // Catch: Throwable -> L9 IOException -> L11
        SysUtil.a(r10);     // Catch: Throwable -> L9 IOException -> L11
        r11 = new RandomAccessFile(r10, "rw");     // Catch: Throwable -> L9 IOException -> L11
        goto L17
    L6:
        if (r10.setWritable(true) == true) goto L43;
        Log.w("fb-UnpackingSoSource", "error adding write permission to: " + r10);     // Catch: Throwable -> L9 IOException -> L11
        goto L43
    }

    public final void a(Dso[] r10) {
        String[] r5 = this.f8464a.list();
        if (r5 == null) goto L31;
        int r11 = 0;
    L6:
        if (r11 >= r5.length) goto L29;
        String r12 = r5[r11];
        if (r12.equals("dso_state") == true) goto L28;
        if (r12.equals("dso_lock") == true) goto L28;
        if (r12.equals("dso_instance_lock") == true) goto L28;
        if (r12.equals("dso_deps") == true) goto L28;
        if (r12.equals("dso_manifest") == true) goto L28;
        boolean r13 = false;
        int r14 = 0;
    L19:
        if (r13 == true) goto L26;
        if (r14 >= r10.length) goto L26;
        if (r10[r14].f8487a.equals(r12) == false) goto L25;
        r13 = true;
    L25:
        r14 = r14 + 1;
    L26:
        if (r13 == true) goto L28;
        File r15 = new File(this.f8464a, r12);
        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + r15);
        SysUtil.a(r15);
    L28:
        r11 = r11 + 1;
        goto L6
    L29:
        return;
    L31:
        throw new IOException("unable to list directory " + this.f8464a);
    }

    public final void a(InputDso r10, byte[] r11) {
        Log.i("fb-UnpackingSoSource", "extracting DSO " + ((InputDsoStream) r10).f8490a.f8487a);
    L10:
        th = move-exception;
        if (this.f8464a.setWritable(false) == true) goto L17;
        Log.w("fb-UnpackingSoSource", "error removing " + this.f8464a.getCanonicalPath() + " write permission");
    L17:
        throw th;
    L4:
        if (this.f8464a.setWritable(true) == false) goto L13;
        b(r10, r11);     // Catch: Throwable -> L10
        if (this.f8464a.setWritable(false) == true) goto L19;
        Log.w("fb-UnpackingSoSource", "error removing " + this.f8464a.getCanonicalPath() + " write permission");
        return;
    L19:
        return;
    L13:
        throw new IOException("cannot make directory writable for us: " + this.f8464a);     // Catch: Throwable -> L10
    }

    public final void a(byte r10, DsoManifest r11, InputDsoIterator r12) {
        Log.v("fb-UnpackingSoSource", "regenerating DSO store ".concat(getClass().getName()));
        RandomAccessFile r5 = new RandomAccessFile(new File(this.f8464a, "dso_manifest"), "rw");
        if (r10 == 1) goto L51;
    L10:
        DsoManifest r13 = null;
    L12:
        if (r13 != null) goto L14;
        r13 = new DsoManifest(new Dso[0]);     // Catch: Throwable -> L6
    L14:
        a(r11.f8489a);     // Catch: Throwable -> L6
        byte[] r14 = new byte[32768];     // Catch: Throwable -> L6
    L16:
        if (r12.b() == false) goto L42;
        InputDsoStream r15 = r12.c();     // Catch: Throwable -> L6
        boolean r16 = true;
        int r17 = 0;
    L19:
        if (r16 == false) goto L31;
        Dso[] r18 = r13.f8489a;     // Catch: Throwable -> L27
        if (r17 >= r18.length) goto L31;
        if (r18[r17].f8487a.equals(r15.f8490a.f8487a) == false) goto L29;
        if (r13.f8489a[r17].f8488b.equals(r15.f8490a.f8488b) == false) goto L29;
        r16 = false;
    L29:
        r17 = r17 + 1;     // Catch: Throwable -> L27
        goto L19
    L27:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L39
    L41:
        throw th;     // Catch: Throwable -> L6
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L46
    L48:
        throw th;
    L46:
        th = move-exception;
        th.addSuppressed(th);
    L31:
        if (new File(this.f8464a, r15.f8490a.f8487a).exists() == true) goto L33;
        r16 = true;
    L33:
        if (r16 == false) goto L35;
        a(r15, r14);     // Catch: Throwable -> L27
    L35:
        r15.close();     // Catch: Throwable -> L6
        goto L16
    L42:
        r5.close();
        Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store ".concat(getClass().getName()));
        return;
    L51:
        r13 = DsoManifest.a(r5);     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e);     // Catch: Throwable -> L6
        goto L10
    }

    public final boolean a(final FileLocker r13, int r14, final byte[] r15) {
        final File r10 = new File(this.f8464a, "dso_state");
        RandomAccessFile r5 = new RandomAccessFile(r10, "rw");
        byte r11 = r5.readByte();     // Catch: Throwable -> L7 EOFException -> L54
        if (r11 == 1) goto L14;
        Log.v("fb-UnpackingSoSource", "dso store " + this.f8464a + " regeneration interrupted: wiping clean");     // Catch: Throwable -> L7 EOFException -> L54
    L14:
        r5.close();
        final File r12 = new File(this.f8464a, "dso_deps");
        RandomAccessFile r16 = new RandomAccessFile(r12, "rw");
        int r17 = (int) r16.length();     // Catch: Throwable -> L18
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L18
        if (r16.read(r18) == r17) goto L21;
        Log.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");     // Catch: Throwable -> L18
        r11 = 0;
    L21:
        if (Arrays.equals(r18, r15) == true) goto L23;
        Log.v("fb-UnpackingSoSource", "deps mismatch on deps store: regenerating");     // Catch: Throwable -> L18
        r11 = 0;
    L23:
        if (r11 != 0) goto L25;
    L28:
        Log.v("fb-UnpackingSoSource", "so store dirty: regenerating");     // Catch: Throwable -> L18
        a(r10, (byte) 0);     // Catch: Throwable -> L18
        Unpacker r19 = b();     // Catch: Throwable -> L18
        DsoManifest r20 = r19.b();     // Catch: Throwable -> L43
        a(r11, r20, r19.c());     // Catch: Throwable -> L41
        r19.close();     // Catch: Throwable -> L18
        final DsoManifest r21 = r20;
    L33:
        r16.close();
        if (r21 != null) goto L36;
        return false;
    L36:
        Runnable r22 = new AnonymousClass1(this, r12, r15, r21, r10, r13);
        if ((r14 & 1) == 0) goto L39;
        new Thread(r22, "SoSync:" + this.f8464a.getName()).start();
    L40:
        return true;
    L39:
        r22.run();
        goto L40
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r19.close();     // Catch: Throwable -> L46
    L48:
        throw th;     // Catch: Throwable -> L18
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18
        goto L48
    L25:
        if ((r14 & 2) != 0) goto L28;
        r21 = null;
    L18:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L51
    L53:
        throw th;
    L51:
        th = move-exception;
        th.addSuppressed(th);
    L7:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L10
    L12:
        throw th;
    L10:
        th = move-exception;
        th.addSuppressed(th);
    L13:
        r11 = 0;
        goto L14
    }

    public byte[] a() {
        Parcel r5 = Parcel.obtain();
        Unpacker r10 = b();
        Dso[] r11 = r10.b().f8489a;     // Catch: Throwable -> L8
        r5.writeByte((byte) 1);     // Catch: Throwable -> L8
        r5.writeInt(r11.length);     // Catch: Throwable -> L8
        int r12 = 0;
    L5:
        if (r12 >= r11.length) goto L10;
        r5.writeString(r11[r12].f8487a);     // Catch: Throwable -> L8
        r5.writeString(r11[r12].f8488b);     // Catch: Throwable -> L8
        r12 = r12 + 1;
        goto L5
    L10:
        r10.close();
        byte[] r13 = r5.marshall();
        r5.recycle();
        return r13;
    L8:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    @Override // com.facebook.soloader.SoSource
    public final void a(int r13) {
        File r10 = this.f8464a;
        if (r10.mkdirs() == false) goto L5;
    L9:
        FileLocker r11 = SysUtil.a(this.f8464a, new File(this.f8464a, "dso_lock"), true);
        if (this.d != null) goto L12;
        this.d = SysUtil.a(this.f8464a, new File(this.f8464a, "dso_instance_lock"), false);
    L12:
        boolean r12 = this.f8464a.canWrite();
        Log.v("fb-UnpackingSoSource", "locked dso store " + this.f8464a);     // Catch: Throwable -> L16
        if (r12 == true) goto L19;
        this.f8464a.setWritable(true);     // Catch: Throwable -> L16
    L19:
        if (a(r11, r13, a()) == false) goto L21;
        r11 = null;
    L22:
        if (r12 == true) goto L24;
        this.f8464a.setWritable(false);
    L24:
        if (r11 == null) goto L27;
        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.f8464a);
        r11.close();
        return;
    L27:
        Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.f8464a + " (syncer thread started)");
        return;
    L21:
        Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.f8464a);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r12 == true) goto L31;
        this.f8464a.setWritable(false);
    L31:
        if (r11 == null) goto L33;
        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.f8464a);
        r11.close();
    L34:
        throw th;
    L33:
        Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.f8464a + " (syncer thread started)");
        goto L34
    L5:
        if (r10.isDirectory() == true) goto L9;
        throw new IOException("cannot mkdir: " + r10);
    }
}
