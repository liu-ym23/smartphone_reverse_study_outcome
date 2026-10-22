package com.obric.aikernel.res.utils;

import android.content.res.AssetManager;
import android.system.Os;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5222a = null;

    /* JADX INFO: renamed from: com.obric.aikernel.res.utils.a$a, reason: collision with other inner class name */
    public static final class C0118a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f5226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f5227e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5228f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f5229g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f5230h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f5231i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f5232j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f5233k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final boolean f5234l;

        public C0118a(String r10, String r11, boolean r12, boolean r13, boolean r14, String r15, String r16, boolean r17, boolean r18, boolean r19, boolean r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r10, "sourcePath");
            Intrinsics.checkNotNullParameter(r11, "destPath");
            this.f5223a = r10;
            this.f5224b = r11;
            this.f5225c = r12;
            this.f5226d = r13;
            this.f5227e = r14;
            this.f5228f = r15;
            this.f5229g = r16;
            this.f5230h = r17;
            this.f5231i = r18;
            this.f5232j = r19;
            this.f5233k = r110;
            this.f5234l = r111;
        }

        public final boolean a() {
            return this.f5234l;
        }

        public final String b() {
            return this.f5224b;
        }

        public final boolean c() {
            return this.f5226d;
        }

        public final String d() {
            return this.f5228f;
        }

        public final String e() {
            return this.f5229g;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0118a) == true) goto L8;
            return false;
        L8:
            C0118a r11 = (C0118a) r10;
            if (Intrinsics.areEqual(this.f5223a, r11.f5223a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5224b, r11.f5224b) == true) goto L15;
            return false;
        L15:
            if (this.f5225c == r11.f5225c) goto L18;
            return false;
        L18:
            if (this.f5226d == r11.f5226d) goto L21;
            return false;
        L21:
            if (this.f5227e == r11.f5227e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f5228f, r11.f5228f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f5229g, r11.f5229g) == true) goto L30;
            return false;
        L30:
            if (this.f5230h == r11.f5230h) goto L33;
            return false;
        L33:
            if (this.f5231i == r11.f5231i) goto L36;
            return false;
        L36:
            if (this.f5232j == r11.f5232j) goto L39;
            return false;
        L39:
            if (this.f5233k == r11.f5233k) goto L42;
            return false;
        L42:
            if (this.f5234l == r11.f5234l) goto L44;
            return false;
        L44:
            return true;
        }

        public final boolean f() {
            return this.f5227e;
        }

        public final boolean g() {
            return this.f5225c;
        }

        public final boolean h() {
            return this.f5232j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v19, types: [int] */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        /* JADX WARN: Type inference failed for: r0v23, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v17, types: [int] */
        /* JADX WARN: Type inference failed for: r1v19, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r10 = ((this.f5223a.hashCode() * 31) + this.f5224b.hashCode()) * 31;
            boolean r11 = this.f5225c;
            ?? r12 = 1;
            ?? r13 = r11;
            if (r11 == false) goto L5;
            r13 = 1;
        L5:
            int r14 = (r10 + r13) * 31;
            boolean r15 = this.f5226d;
            ?? r16 = r15;
            if (r15 == false) goto L8;
            r16 = 1;
        L8:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.f5227e;
            ?? r19 = r18;
            if (r18 == false) goto L11;
            r19 = 1;
        L11:
            int r20 = (r17 + r19) * 31;
            String r21 = this.f5228f;
            int r22 = 0;
            if (r21 != null) goto L14;
            int r23 = 0;
        L15:
            int r24 = (r20 + r23) * 31;
            String r25 = this.f5229g;
            if (r25 == null) goto L19;
            r22 = r25.hashCode();
        L19:
            int r26 = (r24 + r22) * 31;
            boolean r27 = this.f5230h;
            ?? r28 = r27;
            if (r27 == false) goto L22;
            r28 = 1;
        L22:
            int r29 = (r26 + r28) * 31;
            boolean r30 = this.f5231i;
            ?? r31 = r30;
            if (r30 == false) goto L25;
            r31 = 1;
        L25:
            int r32 = (r29 + r31) * 31;
            boolean r33 = this.f5232j;
            ?? r34 = r33;
            if (r33 == false) goto L28;
            r34 = 1;
        L28:
            int r35 = (r32 + r34) * 31;
            boolean r36 = this.f5233k;
            ?? r37 = r36;
            if (r36 == false) goto L31;
            r37 = 1;
        L31:
            int r38 = (r35 + r37) * 31;
            boolean r39 = this.f5234l;
            if (r39 == true) goto L36;
            r12 = r39;
        L36:
            return r38 + r12;
        L14:
            r23 = r21.hashCode();
            goto L15
        }

        public final boolean i() {
            return this.f5233k;
        }

        public final String j() {
            return this.f5223a;
        }

        public final boolean k() {
            return this.f5231i;
        }

        public final boolean l() {
            return this.f5230h;
        }

        public String toString() {
            return "RenameAttemptState(sourcePath=" + this.f5223a + ", destPath=" + this.f5224b + ", firstRenameSucceeded=" + this.f5225c + ", fallbackMoveAttempted=" + this.f5226d + ", fallbackMoveSucceeded=" + this.f5227e + ", fallbackMoveErrorClass=" + this.f5228f + ", fallbackMoveErrorMessage=" + this.f5229g + ", targetExistedBeforeDelete=" + this.f5230h + ", targetDeleteSucceeded=" + this.f5231i + ", secondRenameSucceeded=" + this.f5232j + ", sourceExistsAfter=" + this.f5233k + ", destExistsAfter=" + this.f5234l + ')';
        }
    }

    static {
        f5222a = new a();
    }

    private a() {
    }

    private final void f(File r10, String r11) {
        File r12 = new File(r11 + "_temp");
        d(r10, r12);
        if (i(r12, new File(r11)) == true) goto L17;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        Object r14 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r12)));     // Catch: Throwable -> L6
    L9:
        if (Result.m39isSuccessimpl(r14) == false) goto L11;
        ((Boolean) r14).booleanValue();
        d.f5417a.l("FileUtils", "copyFiles cleanup after failed finalize source=" + r10 + " target=" + r11 + " targetExists=" + new File(r11).exists());
    L11:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L18;
        d.f5417a.l("FileUtils", "copyFiles " + r10 + " clean tmp failed: " + r15);
        return;
    L18:
        return;
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final String a(C0118a r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        StringBuilder r11 = new StringBuilder();
        r11.append("rename source=");
        r11.append(r10.j());
        r11.append(" dest=");
        r11.append(r10.b());
        r11.append(" firstRenameSucceeded=");
        r11.append(r10.g());
        r11.append(" fallbackMoveAttempted=");
        r11.append(r10.c());
        r11.append(" fallbackMoveSucceeded=");
        r11.append(r10.f());
        r11.append(" fallbackMoveErrorClass=");
        String r12 = r10.d();
        String r13 = "";
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        r11.append(r12);
        r11.append(" fallbackMoveErrorMessage=");
        String r14 = r10.e();
        if (r14 == null) goto L9;
        r13 = r14;
    L9:
        r11.append(r13);
        r11.append(" targetExistedBeforeDelete=");
        r11.append(r10.l());
        r11.append(" targetDeleteSucceeded=");
        r11.append(r10.k());
        r11.append(" secondRenameSucceeded=");
        r11.append(r10.h());
        r11.append(" sourceExistsAfter=");
        r11.append(r10.i());
        r11.append(" destExistsAfter=");
        r11.append(r10.a());
        return r11.toString();
    }

    public final void b(AssetManager r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "asserts");
        Intrinsics.checkNotNullParameter(r11, "assertPath");
        Intrinsics.checkNotNullParameter(r12, "targetPath");
        String[] r13 = r10.list(r11);
        boolean r14 = true;
        int r15 = 0;
        if (r13 != null) goto L5;
    L11:
        boolean r16 = true;
    L12:
        if (r16 == false) goto L39;
        InputStream r17 = r10.open(r11);
        File r18 = new File(r12);     // Catch: Throwable -> L34
        File r19 = r18.getParentFile();     // Catch: Throwable -> L34
        if (r18.exists() == false) goto L17;
        r18.delete();     // Catch: Throwable -> L34
    L17:
        if (r19 != null) goto L19;
    L21:
        r14 = false;
    L22:
        if (r14 == true) goto L25;
        if (r19 == null) goto L25;
        r19.mkdirs();     // Catch: Throwable -> L34
    L25:
        FileOutputStream r20 = new FileOutputStream(r18);     // Catch: Throwable -> L34
        Intrinsics.checkNotNullExpressionValue(r17, "input");     // Catch: Throwable -> L29
        ByteStreamsKt.copyTo$default(r17, r20, 0, 2, null);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r20, null);     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r17, null);
        return;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L19:
        if (r19.exists() != true) goto L21;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L39:
        int r21 = r13.length;
    L40:
        if (r15 >= r21) goto L51;
        String r22 = r13[r15];
        f5222a.b(r10, r11 + '/' + r22, r12 + '/' + r22);
        r15 = r15 + 1;
        goto L40
    L51:
        return;
    L5:
        if (r13.length != 0) goto L7;
        boolean r23 = true;
    L8:
        if (r23 == true) goto L11;
        r16 = false;
        goto L12
    L7:
        r23 = false;
        goto L8
    }

    public final void c(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "src");
        Intrinsics.checkNotNullParameter(r11, "dest");
        FileInputStream r12 = new FileInputStream(r10);
        FileOutputStream r13 = new FileOutputStream(r11);     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default(r12, r13, 0, 2, null);     // Catch: Throwable -> L9
        r13.flush();     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r12, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public final void d(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "srcDir");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        if (r10.exists() == true) goto L5;
        return;
    L5:
        int r12 = 0;
        if (r10.isFile() == false) goto L28;
        File r13 = r11.getParentFile();
        if (r13 != null) goto L10;
    L12:
        boolean r14 = false;
    L13:
        if (r14 == true) goto L16;
        if (r13 == null) goto L16;
        r13.mkdirs();
    L16:
        int r15 = 0;
    L18:
        if (r15 >= 3) goto L25;
        c(r10, r11);
        if (r11.exists() == false) goto L24;
        if (Os.stat(r11.getPath()).st_size == Os.stat(r10.getPath()).st_size) goto L25;
    L24:
        d.f5417a.e("FileUtils", "copyFiles failed round " + r15 + ". (" + Os.stat(r11.getPath()).st_size + '/' + Os.stat(r10.getPath()).st_size + ")from " + r10 + " to " + r11);
        r15 = r15 + 1;
    L25:
        String r16 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r16, "target.name");
        if (StringsKt.endsWith$default(r16, ".so", false, 2, null) == false) goto L33;
        r11.setExecutable(true);
        return;
    L33:
        return;
    L10:
        if (r13.exists() != true) goto L12;
        r14 = true;
        goto L13
    L28:
        String[] r17 = r10.list();
        if (r17 == null) goto L40;
        int r18 = r17.length;
    L31:
        if (r12 >= r18) goto L41;
        String r19 = r17[r12];
        f5222a.d(new File(r10, r19), new File(r11, r19));
        r12 = r12 + 1;
        goto L31
    L41:
        return;
    }

    public final void e(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "srcDir");
        Intrinsics.checkNotNullParameter(r11, "targetDir");
        f(r10, r11);
    }

    public final String g(File r13) {
        Intrinsics.checkNotNullParameter(r13, "root");
        Object r12 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L26
        File[] r14 = r13.listFiles();     // Catch: Throwable -> L26
        if (r14 == null) goto L23;
        ArrayList r11 = new ArrayList(r14.length);     // Catch: Throwable -> L26
        int r15 = r14.length;     // Catch: Throwable -> L26
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L22;
        File r17 = r14[r16];     // Catch: Throwable -> L26
        if (r17.isDirectory() == false) goto L20;
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L26
        r18.append("[dir-");     // Catch: Throwable -> L26
        r18.append(r17.getName());     // Catch: Throwable -> L26
        r18.append(": ");     // Catch: Throwable -> L26
        File[] r19 = r17.listFiles();     // Catch: Throwable -> L26
        if (r19 == null) goto L18;
        Intrinsics.checkNotNullExpressionValue(r19, "listFiles()");     // Catch: Throwable -> L26
        ArrayList r20 = new ArrayList(r19.length);     // Catch: Throwable -> L26
        int r21 = r19.length;     // Catch: Throwable -> L26
        int r22 = 0;
    L12:
        if (r22 >= r21) goto L19;
        File r23 = r19[r22];     // Catch: Throwable -> L26
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L26
        if (r23.isDirectory() == false) goto L16;
        String r111 = "dir-";
    L17:
        r110.append(r111);     // Catch: Throwable -> L26
        r110.append(r23.getName());     // Catch: Throwable -> L26
        r20.add(r110.toString());     // Catch: Throwable -> L26
        r22 = r22 + 1;     // Catch: Throwable -> L26
        goto L12
    L16:
        r111 = "";
    L19:
        r18.append(r20);     // Catch: Throwable -> L26
        r18.append(']');     // Catch: Throwable -> L26
        String r24 = r18.toString();     // Catch: Throwable -> L26
    L21:
        r11.add(r24);     // Catch: Throwable -> L26
        r16 = r16 + 1;     // Catch: Throwable -> L26
        goto L6
    L18:
        r20 = null;
        goto L19
    L20:
        r24 = r17.getName();     // Catch: Throwable -> L26
        goto L21
    L22:
        String r112 = CollectionsKt.joinToString$default(r11, null, null, null, 0, null, null, 63, null);     // Catch: Throwable -> L26
    L24:
        Object r113 = Result.m32constructorimpl(r112);     // Catch: Throwable -> L26
    L29:
        if (Result.m38isFailureimpl(r113) == true) goto L33;
        r12 = r113;
    L33:
        return (String) r12;
    L23:
        r112 = null;
    L26:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r113 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    public final <T> T h(File r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "cls");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.m32constructorimpl(new com.google.gson.d().k(FilesKt.readText$default(r10, null, 1, null), r11));     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L11;
        d.f5417a.l("FileUtils", "parse json from file {" + r10.getPath() + "} failed: " + r14);
    L11:
        if (Result.m38isFailureimpl(r13) == false) goto L14;
        return null;
    L14:
        return (T) r13;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean i(File r21, File r22) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "dest");
        if (r21.renameTo(r22) == true) goto L40;
        boolean r13 = r22.exists();
        boolean r10 = false;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        Files.move(r21.toPath(), r22.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: Throwable -> L10
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        r10 = true;
    L12:
        Throwable r14 = Result.m35exceptionOrNullimpl(r12);
        String r15 = null;
        if (r14 == null) goto L18;
        String r16 = r14.getClass().getName();
        String r17 = r14.getMessage();
        if (r17 == null) goto L17;
        r15 = StringsKt.take(r17, 240);
    L17:
        String r18 = r15;
        String r19 = r16;
    L20:
        if (r10 == false) goto L45;
        d r20 = d.f5417a;
        String r23 = r21.getPath();
        Intrinsics.checkNotNullExpressionValue(r23, "path");
        String r24 = r22.getPath();
        Intrinsics.checkNotNullExpressionValue(r24, "dest.path");
        r20.d("FileUtils", a(new C0118a(r23, r24, false, true, true, r19, r18, r13, false, false, r21.exists(), r22.exists())));
        return true;
    L45:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L26
        Object r26 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r22)));     // Catch: Throwable -> L26
    L28:
        Throwable r27 = Result.m35exceptionOrNullimpl(r26);
        if (r27 == null) goto L31;
        d.f5417a.l("FileUtils", "rename delete " + r22 + " failed " + r27);
    L31:
        Boolean r28 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r26) == false) goto L34;
        r26 = r28;
    L34:
        boolean r110 = ((Boolean) r26).booleanValue();
        boolean r29 = r21.renameTo(r22);
        String r30 = r21.getPath();
        Intrinsics.checkNotNullExpressionValue(r30, "path");
        String r31 = r22.getPath();
        Intrinsics.checkNotNullExpressionValue(r31, "dest.path");
        C0118a r111 = new C0118a(r30, r31, false, true, false, r19, r18, r13, r110, r29, r21.exists(), r22.exists());
        String r32 = a(r111);
        if (j(r111) == false) goto L37;
        d.f5417a.l("FileUtils", r32);
    L47:
        return r29;
    L37:
        d.f5417a.d("FileUtils", r32);
    L26:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r26 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L28
    L18:
        r19 = null;
        r18 = null;
    L8:
        th = th;
        r10 = true;
    L11:
        Result.Companion r34 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L10:
        th = th;
        goto L11
    L40:
        return true;
    }

    public final boolean j(C0118a r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        if (r10.g() == false) goto L5;
    L9:
        return false;
    L5:
        if (r10.f() == true) goto L9;
        if (r10.h() == true) goto L9;
        return true;
    }

    public final void k(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        File r12 = r10.getParentFile();
        if (r12 == null) goto L5;
        r12.mkdirs();
    L5:
        File r13 = new File(r10.getPath() + "_temp");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
        FilesKt.writeText(r13, r11, Charsets.UTF_8);     // Catch: Throwable -> L8
        Object r15 = Result.m32constructorimpl(Boolean.valueOf(f5222a.i(r13, r10)));     // Catch: Throwable -> L8
    L10:
        Throwable r16 = Result.m35exceptionOrNullimpl(r15);
        if (r16 == null) goto L16;
        d.f5417a.e("FileUtils", r16.toString());
        r13.delete();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
