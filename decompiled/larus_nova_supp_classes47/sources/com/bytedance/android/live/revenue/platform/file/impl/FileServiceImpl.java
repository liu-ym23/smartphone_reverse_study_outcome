package com.bytedance.android.live.revenue.platform.file.impl;

import bytedance.io.BdFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.h2;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.q;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FileServiceImpl implements uy0.b, o {

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Unit> r8) {
            Intrinsics.checkNotNullParameter(r8, "emitter");
            ZipInputStream r0 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(this.a)));     // Catch: Exception -> L23
        L4:
            ZipEntry r1 = r0.getNextEntry();     // Catch: Exception -> L23
            if (r1 == null) goto L21;
            String r2 = r1.getName();     // Catch: Exception -> L23
            if (StringsKt.contains$default(r2, "../", false, 2, null) == true) goto L4;
            if (r1.isDirectory() == true) goto L11;
            PolarisFileWrapper r3 = new PolarisFileWrapper(this.b + File.separator + r2);     // Catch: Exception -> L23
            if (r3.exists() == false) goto L15;
            r3.delete();     // Catch: Exception -> L23
        L16:
            r3.createNewFile();     // Catch: Exception -> L23
            BufferedOutputStream r4 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r3));     // Catch: Exception -> L23
            byte[] r5 = new byte[2048];     // Catch: Exception -> L23
        L17:
            int r6 = r0.read(r5);     // Catch: Exception -> L23
            if (r6 == (-1)) goto L20;
            r4.write(r5, 0, r6);     // Catch: Exception -> L23
            goto L17
        L20:
            r4.flush();     // Catch: Exception -> L23
            r4.close();     // Catch: Exception -> L23
            goto L4
        L15:
            r3.getParentFile().mkdirs();     // Catch: Exception -> L23
            goto L16
        L11:
            new PolarisFileWrapper(this.b + File.separator + r2).mkdirs();     // Catch: Exception -> L23
            goto L4
        L21:
            r0.close();     // Catch: Exception -> L23
            r8.onNext(Unit.INSTANCE);     // Catch: Exception -> L23
            r8.onComplete();     // Catch: Exception -> L23
            return;
        L23:
            e = move-exception;
            r8.onError(e);
        }
    }

    public FileServiceImpl() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // uy0.b
    public final long q5() {
        return BdFileSystem.getAvailableStorageSize(s1.getContext());
    }

    public static boolean E(File r6) {
        if (r6.exists() == true) goto L6;
        return true;
    L6:
        if (r6.isDirectory() == true) goto L8;
        return false;
    L8:
        File[] r0 = r6.listFiles();
        if (r0 == null) goto L30;
        if (r0.length != 0) goto L13;
        boolean r3 = true;
    L15:
        if ((true ^ r3) == false) goto L30;
        int r1 = r0.length;
        int r4 = 0;
    L17:
        if (r4 >= r1) goto L30;
        File r5 = r0[r4];
        if (r5.isFile() == false) goto L24;
        if (r5.delete() == true) goto L28;
        return false;
    L28:
        r4 = r4 + 1;
        goto L17
    L24:
        if (r5.isDirectory() == false) goto L28;
        if (E(r5) == true) goto L28;
        return false;
    L13:
        r3 = false;
    L30:
        return r6.delete();
    }

    public static long I(File r6) {
        long r1 = 0;
        if (r6.exists() == true) goto L6;
        return 0;
    L6:
        if (r6.isDirectory() == false) goto L17;
        File[] r7 = r6.listFiles();
        if (r7 == null) goto L21;
        int r0 = r7.length;
        int r3 = 0;
    L10:
        if (r3 >= r0) goto L22;
        File r4 = r7[r3];
        if (r4.isDirectory() == false) goto L14;
        long r5 = I(r4);
    L15:
        r1 = r1 + r5;
        r3 = r3 + 1;
        goto L10
    L14:
        r5 = r4.length();
        goto L15
    L22:
        return r1;
    L21:
        return 0;
    L17:
        return r6.length();
    }

    @Override // uy0.b
    public final boolean J(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.isDirectory() == false) goto L6;
        return E(r0);
    L6:
        if (r0.exists() == true) goto L8;
    L13:
        return true;
    L8:
        if (r0.isFile() == true) goto L10;
    L12:
        return false;
    L10:
        if (r0.delete() == false) goto L12;
        goto L12
    }

    @Override // uy0.b
    public final void L(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        new PolarisFileWrapper(r2).createNewFile();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // uy0.b
    public final Single<String> V2(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        int r0 = q.a;
        final Function0<String> r1 = new FileServiceImpl$readFile$1(r2);
        return Single.fromCallable(new c(r1));
    }

    @Override // uy0.b
    public final boolean Y4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileOrDirPath");
        return new PolarisFileWrapper(r2).exists();
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // uy0.b
    public final List<String> c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "dirPath");
        File[] r6 = new PolarisFileWrapper(r5).listFiles();
        if (r6 == null) goto L7;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        r0.add(r6[r2].getPath());
        r2 = r2 + 1;
        goto L5
    L10:
        return r0;
    L7:
        return null;
    }

    @Override // uy0.b
    public final boolean k3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dirPath");
        return new PolarisFileWrapper(r2).mkdirs();
    }

    @Override // uy0.b
    public final long l4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileOrDirPath");
        return I(new PolarisFileWrapper(r3));
    }

    @Override // uy0.b
    public final String o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return new PolarisFileWrapper(r2).getName();
    }

    @Override // uy0.b
    public final com.bytedance.android.live.revenue.platform.file.impl.a H2(String r2, h2 r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "listener");
        return new com.bytedance.android.live.revenue.platform.file.impl.a(new b(r3, r2));
    }

    @Override // uy0.b
    public final Observable<Unit> unZipFolder(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "zipFilePath");
        Intrinsics.checkNotNullParameter(r3, "outPath");
        return Observable.create(new a(r2, r3));
    }
}
