package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.util.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q implements com.bytedance.android.annie.bridge.method.permission.b {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DownloadFileMethod.a c;
    public final /* synthetic */ LinkedHashMap<String, String> d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Integer f;
    public final /* synthetic */ DownloadFileMethod g;

    public static final class a implements Runnable {
        public final /* synthetic */ DownloadFileMethod a;
        public final /* synthetic */ DownloadFileMethod.DownloadFileResModel b;

        public a(DownloadFileMethod r1, DownloadFileMethod.DownloadFileResModel r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.finishWithResult(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DownloadFileMethod a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Integer c;

        public b(DownloadFileMethod r1, int r10, Integer r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void a() {
            DownloadFileMethod r0 = this.a;
            DownloadFileMethod.DownloadFileResModel r1 = new DownloadFileMethod.DownloadFileResModel();
            int r10 = this.b;
            Integer r11 = this.c;
            r1.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
            r1.f("Failed for permission rejected");
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
            Object r13 = Result.constructor-impl(Integer.valueOf(r10));     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r13) == false) goto L10;
            r13 = 0;
        L10:
            r1.e((Integer) r13);
            if (r11 != null) goto L26;
            Integer r14 = null;
        L16:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L13
        L20:
            if (Result.isFailure-impl(r15) == false) goto L22;
            r15 = 0;
        L22:
            r1.a((Integer) r15);
            r0.finishWithResult(r1);
            return;
        L13:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        L26:
            r14 = Integer.valueOf(r11.intValue());     // Catch: Throwable -> L13
        L5:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.annie.bridge.method.permission.b
    public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        Intrinsics.checkNotNullParameter(r12, "grantResults");
        if (ContextCompat.checkSelfPermission(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L51;
        int r13 = com.bytedance.android.annie.util.k.a;
        Context r14 = this.a;
        String r15 = this.b;
        String r16 = this.c.e();
        Intrinsics.checkNotNull(r16);
        Integer r0 = null;
        Pair r17 = com.bytedance.android.annie.util.k.a(r14, r15, Intrinsics.areEqual(r16, "image"), null, null);
        if (r17 == null) goto L7;
        Uri r18 = (Uri) r17.getFirst();
    L9:
        if (r18 == null) goto L11;
        boolean r19 = true;
    L12:
        DownloadFileMethod.DownloadFileResModel r20 = new DownloadFileMethod.DownloadFileResModel();
        LinkedHashMap<String, String> r1 = this.d;
        int r21 = this.e;
        Integer r22 = this.f;
        if (r19 == false) goto L31;
        r20.b(DownloadFileMethod.DownloadFileResModel.Code.Success);
        r20.f("Success");
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L17
        Object r24 = Result.constructor-impl(Integer.valueOf(r21));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r24) == false) goto L22;
        r24 = 0;
    L22:
        r20.e((Integer) r24);
        Object r25 = Result.constructor-impl(r22);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r25) == false) goto L30;
        r25 = 0;
    L30:
        r20.a((Integer) r25);
        r20.d(r1);
        r20.c(String.valueOf(r19));
    L50:
        ThreadUtils.a().post(new a(this.g, r20));
        return;
    L25:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L31:
        r20.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
        r20.f("Failed");
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L34
        Object r29 = Result.constructor-impl(Integer.valueOf(r21));     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r29) == false) goto L39;
        r29 = 0;
    L39:
        r20.e((Integer) r29);
        if (r22 != null) goto L57;
    L42:
        Object r30 = Result.constructor-impl(r0);     // Catch: Throwable -> L44
    L47:
        if (Result.isFailure-impl(r30) == false) goto L49;
        r30 = 0;
    L49:
        r20.a((Integer) r30);
    L44:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L57:
        r0 = Integer.valueOf(r22.intValue());     // Catch: Throwable -> L44
    L34:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L11:
        r19 = false;
        goto L12
    L7:
        r18 = null;
        goto L9
    L51:
        ThreadUtils.a().post(new b(this.g, this.e, this.f));
    }

    public q(Context r1, String r10, DownloadFileMethod.a r11, LinkedHashMap<String, String> r12, int r13, Integer r14, DownloadFileMethod r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }
}
