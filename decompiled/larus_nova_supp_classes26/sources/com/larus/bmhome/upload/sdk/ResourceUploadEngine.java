package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.s2;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceUploadEngine implements hs8.g {
    public static final /* synthetic */ int c = 0;
    public final UploadEngineType a;
    public final CoroutineScope b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadDataType.values().length];
            r0[UploadDataType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UploadDataType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UploadDataType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UploadDataType.UNCLEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ is8.g b;
        public final /* synthetic */ b4 c;
        public final /* synthetic */ j d;
        public final /* synthetic */ is8.a e;

        public c(String r1, is8.g r2, b4 r3, j r4, is8.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object invoke(Object r6) {
            Throwable r7 = (Throwable) r6;
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[engineCancel] taskId=");
            r1.append(this.a);
            r1.append(", identifier=");
            r1.append(this.b.c.f);
            r1.append(", reason=");
            String r2 = null;
            if (r7 == null) goto L5;
            String r3 = r7.getMessage();
        L6:
            r1.append(r3);
            r0.w("ResourceUploadEngine", r1.toString());
            b4 r4 = this.c;
            if (r7 == null) goto L9;
            String r5 = r7.getMessage();
        L10:
            String r8 = "";
            if (r5 != null) goto L13;
            r5 = "";
        L13:
            r4.cancel(r5, true);
            ms8.b r9 = ms8.b.a;
            j r10 = this.d;
            if (r7 == null) goto L16;
            r2 = r7.getMessage();
        L16:
            if (r2 == null) goto L19;
            r8 = r2;
        L19:
            ResourceUploadError r11 = new ResourceUploadError("canceled", r8);
            Map r12 = MapsKt.mapOf(TuplesKt.to("route", this.e.f.name()));
            r9.getClass();
            ms8.b.b(r10, "file_transfer", "cancel", r11, r12);
            j r13 = this.d;
            if (r13.m == false) goto L25;
            CountDownLatch r14 = r13.n;
            if (r14 == null) goto L25;
            r14.countDown();
        L25:
            return Unit.INSTANCE;
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class d implements Function1<j, Unit> {
        public final /* synthetic */ j a;
        public final /* synthetic */ b4 b;

        public d(j r1, b4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((j) r2, "it");
            ms8.b r3 = ms8.b.a;
            j r0 = this.a;
            r3.getClass();
            ms8.b.i(r0, "file_transfer");
            Function1 r4 = this.a.u;
            if (r4 == null) goto L5;
            r4.invoke("transfer_started");
        L5:
            this.b.a();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public ResourceUploadEngine(UploadEngineType r2) {
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // hs8.g
    public final boolean a(is8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "route");
        if (r2.b != this.a) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.upload.sdk.ResourceUploadEngine$upload$2$1] */
    @Override // hs8.g
    public final Object b(final String r14, final is8.g r15, final is8.a r16, hs8.e r17, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r18, Continuation<? super hs8.a> r19) {
        final kotlinx.coroutines.j r9 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r19), 1);
        r9.C();
        ConcurrentHashMap<String, j> r0 = g.a;
        Intrinsics.checkNotNullParameter(r15, "request");
        String r1 = r15.c.f;
        Intrinsics.checkNotNullParameter(r1, "identifier");
        final j r10 = g.a.get(r1);
        if (r10 != null) goto L5;
        Result.Companion r2 = Result.Companion;
        r9.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ResourceUploadError("upload_imagex_error", "origin param missing"))));
    L28:
        Object r3 = r9.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(r19);
    L31:
        return r3;
    L5:
        int r4 = b.a[r10.c.ordinal()];
        if (r4 != 1) goto L8;
    L17:
        b4 r5 = s2.a.b(r10);
    L18:
        b4 r11 = r5;
        if (r11 != null) goto L22;
        ms8.b.g(ms8.b.a, r10, "file_transfer", "fail", null, new ResourceUploadError("upload_imagex_error", "uploader is null"), 40);
        Result.Companion r6 = Result.Companion;
        r9.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ResourceUploadError("upload_imagex_error", "uploader is null"))));
        goto L28
    L22:
        r11.b(new ResourceUploadEngine$upload$2$1(r10, r14, r15, r16, r9, this, r18));
        r9.i(new c(r14, r15, r11, r10, r16));
        FLogger.a.i("ResourceUploadEngine", "[engineUpload] taskId=" + r14 + ", identifier=" + r15.c.f + ", engineType=" + this.a + ", authMode=" + r17.a);
        Lazy r7 = com.larus.bmhome.upload.g.a;
        final d r8 = new d(r10, r11);
        Intrinsics.checkNotNullParameter(r10, "param");
        Intrinsics.checkNotNullParameter(r8, "doUpload");
        if (r10.m == true) goto L25;
    L27:
        ((ThreadPoolExecutor) com.larus.bmhome.upload.g.b.getValue()).execute(new com.larus.bmhome.upload.f(r8, r10));
        goto L28
    L25:
        if (r10.n == null) goto L27;
        ((ThreadPoolExecutor) com.larus.bmhome.upload.g.b.getValue()).execute(new com.larus.bmhome.upload.e(r8, r10));
        goto L28
    L8:
        if (r4 == 2) goto L17;
        if (r4 != 3) goto L12;
        r5 = s2.a.a(r10);
        goto L18
    L12:
        if (r4 != 4) goto L15;
        r5 = null;
        goto L18
    L15:
        throw new NoWhenBranchMatchedException();
    }
}
