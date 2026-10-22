package com.ss.android.lark.integrator.security.compliance.export;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.lark.android.encryption.utils.PreCheckUtilKt;
import e0c.k;
import java.io.File;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class SecurityFileCryptoService implements com.ss.android.lark.integrator.security.compliance.export.c {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final jkc.c b;
    public final f c;
    public final Function0<Long> d;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Integer b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "NativePathResult(path=" + this.a + ", errorCode=" + this.b + ", failureReason=" + this.c + ')';
        }

        public b(String r1, Integer r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c<T> {
        public final T a;
        public final boolean b;
        public final Integer c;
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
            if (this.b == r6.b) goto L15;
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
            T r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            if (this.b == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            Integer r6 = this.c;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (r5 + r7) * 31;
            String r9 = this.d;
            if (r9 == null) goto L19;
            r1 = r9.hashCode();
        L19:
            return r8 + r1;
        L13:
            r7 = r6.hashCode();
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "OperationResult(value=" + this.a + ", result=" + this.b + ", errorCode=" + this.c + ", failureReason=" + this.d + ')';
        }

        public c(T r1, boolean r2, Integer r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final String A0() {
        r4c.b.a.getClass();
        return r4c.b.a(2131890696, "defaultShareBlockTips");
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final boolean B4() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Integer.valueOf(this.b.o1()));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        Log.e("SecurityFileCryptoService", "[isEncryptionEnabled] query failed, userId=" + this.a, r2);
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        Integer r3 = (Integer) r1;
        if (r3 == null) goto L23;
        int r4 = r3.intValue();
        if (r4 != (-1)) goto L18;
        Log.i("SecurityFileCryptoService", "[isEncryptionEnabled] status=error, treated as disabled, userId=" + this.a);
    L18:
        if (r4 != 1) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final String H0() {
        r4c.b.a.getClass();
        return r4c.b.a(2131890695, "defaultBlockTips");
    }

    public static boolean c(String r4) {
        if ((!StringsKt.isBlank(r4)) == true) goto L5;
    L9:
        return false;
    L5:
        if (StringsKt.contains$default(r4, 0, false, 2, null) == true) goto L9;
        if (new PolarisFileWrapper(r4).isAbsolute() == false) goto L9;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final boolean C(final File r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Function0<c<Boolean>> r0 = new SecurityFileCryptoService$encryptFile$1(r10, this);
        long r7 = ((Number) this.d.invoke()).longValue();
        c r11 = (c) r0.invoke();     // Catch: Exception -> L6
        d(r11.b, r7, r11.c, r11.d);     // Catch: Exception -> L6
        return ((Boolean) r11.a).booleanValue();
    L6:
        e = move-exception;
        d(false, r7, null, null);
        throw e;
    }

    @Inject
    public SecurityFileCryptoService(String r3, jkc.c r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "cipherManager");
        boolean r0 = ((jdb.e) k.a(LarkContext.getApplication(), jdb.e.class)).B0(r3, "doubao_file_encryption_enabled");
        this.a = r3;
        this.b = r4;
        if (r0 == false) goto L7;
        this.c = f.a;
        this.d = SecurityFileCryptoService$clock$1.INSTANCE;
        return;
    L7:
        throw new IllegalStateException("doubao_file_encryption_enabled is disabled".toString());
    }

    public static final boolean a(SecurityFileCryptoService r4, String r5, String r6) {
        r4.getClass();
        if (c(r5) == true) goto L6;
        Log.e("SecurityFileCryptoService", "[" + r6 + "] returned invalid path");
    L8:
        return false;
    L6:
        if (new PolarisFileWrapper(r5).isFile() == true) goto L23;
        Log.e("SecurityFileCryptoService", "[" + r6 + "] returned non-regular file");
        goto L8
    L23:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        Object r8 = Result.constructor-impl(Boolean.valueOf(PreCheckUtilKt.a(r5, null)));     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L16;
        Log.e("SecurityFileCryptoService", "[" + r6 + "] file header check failed, error=" + r9.getClass().getSimpleName());
    L16:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L19;
        r8 = r10;
    L19:
        boolean r11 = ((Boolean) r8).booleanValue();
        if (r11 == true) goto L26;
        Log.e("SecurityFileCryptoService", "[" + r6 + "] returned plaintext or invalid file header");
        return r11;
    L26:
        return r11;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static final b b(SecurityFileCryptoService r3, Pair r4, String r5) {
        r3.getClass();
        Integer r6 = (Integer) r4.first;
        if (r6 != null) goto L6;
    L7:
        Log.e("SecurityFileCryptoService", "[" + r5 + "] failed, code=" + r4.first);
        return new b(null, (Integer) r4.first, null);
    L6:
        if (r6.intValue() != 0) goto L7;
        String r7 = (String) r4.second;
        if (r7 != null) goto L11;
    L13:
        r7 = null;
    L14:
        if (r7 != null) goto L17;
        Log.e("SecurityFileCryptoService", "[" + r5 + "] failed, native returned empty path");
        return new b(null, null, "native_empty_path");
    L17:
        return new b(r7, null, null);
    L11:
        if ((!Intrinsics.areEqual(r7, "")) == false) goto L13;
        goto L13
    }

    public final void d(boolean r8, long r9, Integer r11, String r12) {
        e r6 = new e(r8, Math.max(0, ((Number) this.d.invoke()).longValue() - r9), r11, r12);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        this.c.a(r6);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
