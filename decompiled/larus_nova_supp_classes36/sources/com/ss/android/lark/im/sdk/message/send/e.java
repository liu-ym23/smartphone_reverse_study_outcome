package com.ss.android.lark.im.sdk.message.send;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.t0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements jkb.d<k> {
    public final c a;
    public final b b;

    public static final class a {
    }

    public interface b {
        File a(File r1);

        PolarisFileWrapper b(Context r1, Uri r2);

        Uri c(Context r1, Uri r2);

        PolarisFileWrapper d(String r1);
    }

    public interface c {
        boolean a();
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "DecryptFileStep";
    }

    public e() {
        com.ss.android.lark.im.sdk.message.c r0 = com.ss.android.lark.im.sdk.message.c.a;
        d r1 = new d();
        Intrinsics.checkNotNullParameter(r0, "fileDescriptorFeature");
        Intrinsics.checkNotNullParameter(r1, "decryptFileDependency");
        this.a = r0;
        this.b = r1;
    }

    @Override // jkb.d
    public final void a(jkb.b r17, final jkb.c r18) {
        k r2 = (k) r17;
        Intrinsics.checkNotNullParameter(r2, "pipelineContext");
        Intrinsics.checkNotNullParameter(r18, "pipelineControl");
        com.ss.android.lark.biz.im.api.l r3 = r2.a;
        boolean r4 = r3 instanceof com.ss.android.lark.biz.im.api.l;
        if (r4 == true) goto L5;
    L7:
        IGetDataCallback<Boolean> r5 = new DecryptFileStep$process$callback$1(r18);
        Log.i("DecryptFileStep", "decrypt file");
        c r0 = this.a;
        b r6 = this.b;
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r0, "fileDescriptorFeature");
        Intrinsics.checkNotNullParameter(r6, "decryptFileDependency");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Log.i("DecryptFileStep", "decryptMessageFile");
        if (r4 == false) goto L44;
        com.ss.android.lark.biz.im.api.l r7 = r3;
        if (r7.K == null) goto L13;
        Log.i("DecryptFileStep", "[DoubaoFile] skip decrypt for remote resource");
        r5.onSuccess(Boolean.TRUE);
        return;
    L13:
        if (TextUtils.isEmpty(r7.A) == true) goto L15;
        String r8 = r7.A;
    L16:
        if (r8 != null) goto L34;
        Uri r9 = r7.I;
        if (r9 == null) goto L33;
        Application r13 = LarkContext.getApplication();
        Log.i("DecryptFileStep", "decryptMessageUri");
        Uri r10 = r6.c(r13, r9);     // Catch: SecurityException -> L29 DecryptException -> L31
        Log.i("DecryptFileStep", "[cipher] file decrypt success, origin uri = " + r9.getPath() + ", new uri = " + r9.getPath());     // Catch: SecurityException -> L29 DecryptException -> L31
        if (r0.a() == false) goto L23;
        r7.I = r10;     // Catch: SecurityException -> L29 DecryptException -> L31
    L27:
        r5.onSuccess(Boolean.TRUE);     // Catch: SecurityException -> L29 DecryptException -> L31
    L64:
        return;
    L23:
        PolarisFileWrapper r1 = r6.b(r13, r10);     // Catch: SecurityException -> L29 DecryptException -> L31
        if (r1 == null) goto L26;
        r7.B = r1.getAbsolutePath();     // Catch: SecurityException -> L29 DecryptException -> L31
        goto L27
    L26:
        r7.I = r10;     // Catch: SecurityException -> L29 DecryptException -> L31
    L31:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original uri = " + r9.getPath());
        r5.onError(new ErrorResult(e));
        return;
    L29:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original uri = " + r9.getPath() + ", exception message is " + e.getMessage());
        new Exception("unknown error");
        ErrorResult r11 = new ErrorResult(0);
        ErrorResult.access$002(r11, -1);
        ErrorResult.access$102(r11, -9999);
        ErrorResult.access$202(r11, 0);
        ErrorResult.access$302(r11, e);
        ErrorResult.access$402(r11, "");
        ErrorResult.access$502(r11, "");
        ErrorResult.access$602(r11, "");
        ErrorResult.access$702(r11, "");
        ErrorResult.access$802(r11, 0);
        ErrorResult.access$902(r11, null);
        ErrorResult.access$1002(r11, null);
        ErrorResult.access$1102(r11, null);
        r5.onError(r11);
        return;
    L33:
        Log.e("DecryptFileStep", "File uri is null");
        Exception r12 = new Exception("unknown error");
        ErrorResult r14 = new ErrorResult(0);
        ErrorResult.access$002(r14, -1);
        ErrorResult.access$102(r14, -9999);
        ErrorResult.access$202(r14, 0);
        ErrorResult.access$302(r14, r12);
        ErrorResult.access$402(r14, "");
        ErrorResult.access$502(r14, "File uri is null");
        ErrorResult.access$602(r14, "");
        ErrorResult.access$702(r14, "");
        ErrorResult.access$802(r14, 0);
        ErrorResult.access$902(r14, null);
        ErrorResult.access$1002(r14, null);
        ErrorResult.access$1102(r14, null);
        r5.onError(r14);
        return;
    L34:
        Log.i("DecryptFileStep", "decryptMessageFile for FileMessage");
        PolarisFileWrapper r15 = r6.d(r8);     // Catch: DecryptException -> L41
        Log.i("DecryptFileStep", "[cipher] file decrypt success, original path = " + r8 + ", new path = " + r15.getAbsolutePath());     // Catch: DecryptException -> L41
        if (r0.a() == false) goto L38;
        r7.I = Uri.fromFile(r15);     // Catch: DecryptException -> L41
    L39:
        r5.onSuccess(Boolean.TRUE);     // Catch: DecryptException -> L41
        return;
    L38:
        r7.B = r15.getAbsolutePath();     // Catch: DecryptException -> L41
    L41:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original path = ".concat(r8));
        r5.onError(new ErrorResult(e));
        return;
    L15:
        r8 = null;
        goto L16
    L44:
        if ((r3 instanceof t0) == true) goto L51;
        r5.onSuccess(Boolean.TRUE);
        return;
    L51:
        File r16 = ((t0) r3).D;     // Catch: Exception -> L47
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L47
        File r19 = r6.a(r16);     // Catch: Exception -> L47
        Log.i("DecryptFileStep", "[cipher] file decrypt success, original path = " + r16.getAbsolutePath() + ", new path = " + r19.getAbsolutePath());     // Catch: Exception -> L47
        ((t0) r3).E = r19;     // Catch: Exception -> L47
        r5.onSuccess(Boolean.TRUE);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original path = " + ((t0) r3).D.getAbsolutePath());
        r5.onError(new ErrorResult(e));
        return;
    L5:
        if (r3.K == null) goto L7;
        Log.i("DecryptFileStep", "skip decrypt for doubao remote file");
        r18.a();
    }
}
