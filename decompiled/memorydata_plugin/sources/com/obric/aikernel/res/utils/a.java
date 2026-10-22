package com.obric.aikernel.res.utils;

import android.content.res.AssetManager;
import android.system.Os;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.obric.aikernel.runtime.utils.d;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u00014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\fJ(\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0004J*\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010(\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0004J\u0015\u0010)\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b+J%\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-*\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/¢\u0006\u0002\u00100J\u0012\u00101\u001a\u00020**\u00020\f2\u0006\u0010\u0014\u001a\u00020\fJ\u0012\u00102\u001a\u00020\n*\u00020\f2\u0006\u00103\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/aikernel/res/utils/FileUtils;", "", "()V", "TAG", "", "buildRenameAttemptLog", "state", "Lcom/obric/aikernel/res/utils/FileUtils$RenameAttemptState;", "buildRenameAttemptLog$resource_manager_release", "clearDir", "", "dir", "Ljava/io/File;", "copyAssertFiles", "asserts", "Landroid/content/res/AssetManager;", "assertPath", "targetPath", "copyFile", "src", "dest", "copyFiles", "srcDir", TypedValues.AttributesType.S_TARGET, "targetDir", "copyFilesWithTemp", "deleteFile", "file", "dumpFileStructure", "root", "getFileFromContent", "context", "Landroid/content/Context;", Params.CONTENT, "fileName", "getFileFromUri", "uri", "Landroid/net/Uri;", "linkFiles", "mkdir", "moveFiles", "shouldWarnRenameAttempt", "", "shouldWarnRenameAttempt$resource_manager_release", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "cls", "Ljava/lang/Class;", "(Ljava/io/File;Ljava/lang/Class;)Ljava/lang/Object;", "rename", "writeTextWithTemp", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "RenameAttemptState", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6155a = null;

    /* JADX INFO: renamed from: com.obric.aikernel.res.utils.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u0085\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010,\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, d2 = {"Lcom/obric/aikernel/res/utils/FileUtils$RenameAttemptState;", "", "sourcePath", "", "destPath", "firstRenameSucceeded", "", "fallbackMoveAttempted", "fallbackMoveSucceeded", "fallbackMoveErrorClass", "fallbackMoveErrorMessage", "targetExistedBeforeDelete", "targetDeleteSucceeded", "secondRenameSucceeded", "sourceExistsAfter", "destExistsAfter", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZZZZZ)V", "getDestExistsAfter", "()Z", "getDestPath", "()Ljava/lang/String;", "getFallbackMoveAttempted", "getFallbackMoveErrorClass", "getFallbackMoveErrorMessage", "getFallbackMoveSucceeded", "getFirstRenameSucceeded", "getSecondRenameSucceeded", "getSourceExistsAfter", "getSourcePath", "getTargetDeleteSucceeded", "getTargetExistedBeforeDelete", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0272a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6157b;
        private final boolean c;
        private final boolean d;
        private final boolean e;
        private final String f;
        private final String g;
        private final boolean h;
        private final boolean i;
        private final boolean j;
        private final boolean k;
        private final boolean l;

        public C0272a(String r2, String r3, boolean r4, boolean r5, boolean r6, String r7, String r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r2, "sourcePath");
            Intrinsics.checkNotNullParameter(r3, "destPath");
            this.f6156a = r2;
            this.f6157b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
        }

        public final String a() {
            return this.f6156a;
        }

        public final String b() {
            return this.f6157b;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0272a.class) == true) goto L8;
            return false;
        L8:
            C0272a r6 = (C0272a) ZeusTransformUtils.preCheckCast(r5, C0272a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6156a, r6.f6156a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6157b, r6.f6157b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L44;
            return false;
        L44:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
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
            int r0 = ((this.f6156a.hashCode() * 31) + this.f6157b.hashCode()) * 31;
            boolean r1 = this.c;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.d;
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (r4 + r6) * 31;
            boolean r8 = this.e;
            ?? r9 = r8;
            if (r8 == false) goto L11;
            r9 = 1;
        L11:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f;
            int r12 = 0;
            if (r11 != null) goto L14;
            int r13 = 0;
        L15:
            int r14 = (r10 + r13) * 31;
            String r15 = this.g;
            if (r15 == null) goto L19;
            r12 = r15.hashCode();
        L19:
            int r16 = (r14 + r12) * 31;
            boolean r17 = this.h;
            ?? r18 = r17;
            if (r17 == false) goto L22;
            r18 = 1;
        L22:
            int r19 = (r16 + r18) * 31;
            boolean r20 = this.i;
            ?? r21 = r20;
            if (r20 == false) goto L25;
            r21 = 1;
        L25:
            int r22 = (r19 + r21) * 31;
            boolean r23 = this.j;
            ?? r24 = r23;
            if (r23 == false) goto L28;
            r24 = 1;
        L28:
            int r25 = (r22 + r24) * 31;
            boolean r26 = this.k;
            ?? r27 = r26;
            if (r26 == false) goto L31;
            r27 = 1;
        L31:
            int r28 = (r25 + r27) * 31;
            boolean r29 = this.l;
            if (r29 == true) goto L36;
            r2 = r29;
        L36:
            return r28 + r2;
        L14:
            r13 = r11.hashCode();
            goto L15
        }

        public final boolean i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }

        public final boolean l() {
            return this.l;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("RenameAttemptState(sourcePath=").append(this.f6156a).append(", destPath=").append(this.f6157b).append(", firstRenameSucceeded=").append(this.c).append(", fallbackMoveAttempted=").append(this.d).append(", fallbackMoveSucceeded=").append(this.e).append(", fallbackMoveErrorClass=").append(this.f).append(", fallbackMoveErrorMessage=").append(this.g).append(", targetExistedBeforeDelete=").append(this.h).append(", targetDeleteSucceeded=").append(this.i).append(", secondRenameSucceeded=").append(this.j).append(", sourceExistsAfter=").append(this.k).append(", destExistsAfter=");
            r0.append(this.l).append(')');
            return r0.toString();
        }
    }

    static {
        f6155a = new a();
    }

    private a() {
    }

    private final void c(File r5, String r6) {
        File r1 = new File(r6 + "_temp");
        a(r5, r1);
        if (c(r1, new File(r6)) == true) goto L17;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Object r7 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r1)));     // Catch: Throwable -> L6
    L9:
        if (Result.m1428isSuccessimpl(r7) == false) goto L11;
        ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        d.f6216a.f("FileUtils", "copyFiles cleanup after failed finalize source=" + r5 + " target=" + r6 + " targetExists=" + new File(r6).exists());
    L11:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L18;
        d.f6216a.f("FileUtils", "copyFiles " + r5 + " clean tmp failed: " + r8);
        return;
    L18:
        return;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final <T> T a(File r5, Class<T> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "cls");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(new Gson().fromJson(FilesKt.readText$default(r5, null, 1, null), r6));     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r7);
        if (r1 == null) goto L11;
        d.f6216a.f("FileUtils", "parse json from file {" + r5.getPath() + "} failed: " + r1);
    L11:
        if (Result.m1427isFailureimpl(r7) == false) goto L14;
        return null;
    L14:
        return (T) r7;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final String a(C0272a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        StringBuilder r3 = new StringBuilder();
        StringBuilder r0 = r3.append("rename source=").append(r4.a()).append(" dest=").append(r4.b()).append(" firstRenameSucceeded=").append(r4.c()).append(" fallbackMoveAttempted=").append(r4.d()).append(" fallbackMoveSucceeded=").append(r4.e()).append(" fallbackMoveErrorClass=");
        String r1 = r4.f();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        StringBuilder r5 = r0.append(r1).append(" fallbackMoveErrorMessage=");
        String r6 = r4.g();
        if (r6 == null) goto L9;
        r2 = r6;
    L9:
        r5.append(r2).append(" targetExistedBeforeDelete=").append(r4.h()).append(" targetDeleteSucceeded=").append(r4.i()).append(" secondRenameSucceeded=").append(r4.j()).append(" sourceExistsAfter=").append(r4.k()).append(" destExistsAfter=");
        r3.append(r4.l());
        return r3.toString();
    }

    public final String a(File r14) {
        Intrinsics.checkNotNullParameter(r14, "root");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        File[] r15 = r14.listFiles();     // Catch: Throwable -> L27
        if (r15 == null) goto L24;
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        int r3 = r15.length;     // Catch: Throwable -> L27
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L23;
        File r5 = r15[r4];     // Catch: Throwable -> L27
        if (r5.isDirectory() == false) goto L21;
        StringBuilder r6 = new StringBuilder().append("[dir-").append(r5.getName()).append(": ");     // Catch: Throwable -> L27
        File[] r7 = r5.listFiles();     // Catch: Throwable -> L27
        if (r7 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r7, "listFiles()");     // Catch: Throwable -> L27
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        int r9 = r7.length;     // Catch: Throwable -> L27
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L18;
        File r11 = r7[r10];     // Catch: Throwable -> L27
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L27
        if (r11.isDirectory() == false) goto L16;
        String r17 = "dir-";
    L17:
        r8.add(r12.append(r17).append(r11.getName()).toString());     // Catch: Throwable -> L27
        r10 = r10 + 1;     // Catch: Throwable -> L27
        goto L12
    L16:
        r17 = "";
        goto L17
    L18:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L20:
        String r19 = r6.append(r18).append(']').toString();     // Catch: Throwable -> L27
    L22:
        r16.add(r19);     // Catch: Throwable -> L27
        r4 = r4 + 1;     // Catch: Throwable -> L27
        goto L6
    L19:
        r18 = null;
        goto L20
    L21:
        r19 = r5.getName();     // Catch: Throwable -> L27
        goto L22
    L23:
        String r110 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null);     // Catch: Throwable -> L27
    L25:
        Object r111 = Result.m1421constructorimpl(r110);     // Catch: Throwable -> L27
    L30:
        if (Result.m1427isFailureimpl(r111) == true) goto L34;
        r1 = r111;
    L34:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L24:
        r110 = null;
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public final void a(AssetManager r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "asserts");
        Intrinsics.checkNotNullParameter(r9, "assertPath");
        Intrinsics.checkNotNullParameter(r10, "targetPath");
        String[] r7 = r8.list(r9);
        boolean r0 = true;
        int r1 = 0;
        if (r7 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L39;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r8.open(r9), Closeable.class, "com.obric.memorydata.plugin");
        InputStream r12 = (InputStream) ZeusTransformUtils.preCheckCast(r11, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        File r3 = new File(r10);     // Catch: Throwable -> L34
        File r13 = r3.getParentFile();     // Catch: Throwable -> L34
        if (r3.exists() == false) goto L17;
        r3.delete();     // Catch: Throwable -> L34
    L17:
        if (r13 != null) goto L19;
    L21:
        r0 = false;
    L22:
        if (r0 == true) goto L25;
        if (r13 == null) goto L25;
        r13.mkdirs();     // Catch: Throwable -> L34
    L25:
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        FileOutputStream r4 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r14, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r12, "input");     // Catch: Throwable -> L29
        ByteStreamsKt.copyTo$default(r12, (OutputStream) ZeusTransformUtils.preCheckCast(r4, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r11, null);
        return;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L19:
        if (r13.exists() != true) goto L21;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L39:
        int r5 = r7.length;
    L40:
        if (r1 >= r5) goto L51;
        String r6 = r7[r1];
        f6155a.a(r8, r9 + '/' + r6, r10 + '/' + r6);
        r1 = r1 + 1;
        goto L40
    L51:
        return;
    L5:
        if (r7.length != 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r15 = false;
        goto L8
    }

    public final void a(File r8, File r9) {
        Intrinsics.checkNotNullParameter(r8, "srcDir");
        Intrinsics.checkNotNullParameter(r9, TypedValues.AttributesType.S_TARGET);
        if (r8.exists() == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r8.isFile() == false) goto L28;
        File r0 = r9.getParentFile();
        if (r0 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L16;
        if (r0 == null) goto L16;
        r0.mkdirs();
    L16:
        int r2 = 0;
    L18:
        if (r2 >= 3) goto L25;
        b(r8, r9);
        if (r9.exists() == false) goto L24;
        if (Os.stat(r9.getPath()).st_size == Os.stat(r8.getPath()).st_size) goto L25;
    L24:
        d.f6216a.g("FileUtils", "copyFiles failed round " + r2 + ". (" + Os.stat(r9.getPath()).st_size + '/' + Os.stat(r8.getPath()).st_size + ")from " + r8 + " to " + r9);
        r2 = r2 + 1;
    L25:
        String r7 = r9.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "target.name");
        if (StringsKt.endsWith$default(r7, ".so", false, 2, null) == false) goto L33;
        r9.setExecutable(true);
        return;
    L33:
        return;
    L10:
        if (r0.exists() != true) goto L12;
        r3 = true;
        goto L13
    L28:
        String[] r10 = r8.list();
        if (r10 == null) goto L40;
        int r4 = r10.length;
    L31:
        if (r1 >= r4) goto L41;
        String r5 = r10[r1];
        f6155a.a(new File(r8, r5), new File(r9, r5));
        r1 = r1 + 1;
        goto L31
    L41:
        return;
    }

    public final void a(File r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "srcDir");
        Intrinsics.checkNotNullParameter(r3, "targetDir");
        c(r2, r3);
    }

    public final void b(File r6, File r7) {
        Intrinsics.checkNotNullParameter(r6, "src");
        Intrinsics.checkNotNullParameter(r7, "dest");
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r6), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r5, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r7), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        FileOutputStream r1 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r9, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r1, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L8
        r1.flush();     // Catch: Throwable -> L8
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L13
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r5, null);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public final void b(File r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        File r2 = r3.getParentFile();
        if (r2 == null) goto L5;
        r2.mkdirs();
    L5:
        File r5 = new File(r3.getPath() + "_temp");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        FilesKt.writeText(r5, r4, Charsets.UTF_8);     // Catch: Throwable -> L8
        Object r6 = Result.m1421constructorimpl(Boolean.valueOf(f6155a.c(r5, r3)));     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L16;
        d.f6216a.g("FileUtils", r7.toString());
        r5.delete();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final boolean b(C0272a r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        if (r1.c() == false) goto L5;
    L9:
        return false;
    L5:
        if (r1.e() == true) goto L9;
        if (r1.j() == true) goto L9;
        return true;
    }

    public final boolean c(File r20, File r21) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Intrinsics.checkNotNullParameter(r21, "dest");
        if (r20.renameTo(r21) == true) goto L41;
        boolean r14 = r21.exists();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Files.move(r20.toPath(), r21.toPath(), new CopyOption[]{(CopyOption) ZeusTransformUtils.preCheckCast(StandardCopyOption.REPLACE_EXISTING, CopyOption.class, "com.obric.memorydata.plugin")});     // Catch: Throwable -> L10
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        boolean r7 = true;
    L13:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        String r8 = null;
        if (r2 == null) goto L19;
        String r9 = r2.getClass().getName();
        String r3 = r2.getMessage();
        if (r3 == null) goto L18;
        r8 = StringsKt.take(r3, 240);
    L18:
        String r13 = r8;
        String r12 = r9;
    L21:
        if (r7 == false) goto L46;
        d r4 = d.f6216a;
        String r10 = r20.getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "path");
        String r11 = r21.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "dest.path");
        r4.a("FileUtils", a(new C0272a(r10, r11, false, true, true, r12, r13, r14, false, false, r20.exists(), r21.exists())));
        return true;
    L46:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
        Object r6 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r21)));     // Catch: Throwable -> L27
    L29:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r6);
        if (r15 == null) goto L33;
        d.f6216a.f("FileUtils", "rename delete " + r21 + " failed " + r15);
    L33:
        if (Result.m1427isFailureimpl(r6) == false) goto L35;
        r6 = false;
    L35:
        boolean r16 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r17 = r20.renameTo(r21);
        String r18 = r20.getPath();
        Intrinsics.checkNotNullExpressionValue(r18, "path");
        String r19 = r21.getPath();
        Intrinsics.checkNotNullExpressionValue(r19, "dest.path");
        C0272a r22 = new C0272a(r18, r19, false, true, false, r12, r13, r14, r16, r17, r20.exists(), r21.exists());
        String r23 = a(r22);
        if (b(r22) == false) goto L38;
        d.f6216a.f("FileUtils", r23);
    L48:
        return r17;
    L38:
        d.f6216a.a("FileUtils", r23);
    L27:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L19:
        r12 = null;
        r13 = null;
    L8:
        th = th;
        r7 = true;
    L12:
        Result.Companion r25 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L10:
        th = th;
        r7 = false;
        goto L12
    L41:
        return true;
    }
}
