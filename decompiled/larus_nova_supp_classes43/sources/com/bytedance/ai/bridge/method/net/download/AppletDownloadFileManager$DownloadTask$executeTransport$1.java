package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.ai.file.AppletFileError;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.net.download.AppletDownloadFileManager$DownloadTask$executeTransport$1", f = "AppletDownloadFileManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletDownloadFileManager$DownloadTask$executeTransport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Call<TypedInput> $call;
    int label;
    final /* synthetic */ a.b this$0;

    public AppletDownloadFileManager$DownloadTask$executeTransport$1(a.b r1, Call<TypedInput> r10, Continuation<? super AppletDownloadFileManager$DownloadTask$executeTransport$1> r11) {
        this.this$0 = r1;
        this.$call = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletDownloadFileManager$DownloadTask$executeTransport$1(this.this$0, this.$call, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        String r10 = "downloadFile:fail abort";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L118;
        ResultKt.throwOnFailure(r24);
        a.b r11 = this.this$0;
        Call<TypedInput> r12 = this.$call;
        r11.getClass();
        String r13 = "downloadFile:fail redirect is not allowed";
        LinkedHashMap r14 = null;
        SsResponse r0 = r12.execute();     // Catch: Throwable -> L84 AppletFileError -> L94 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        Integer r15 = Integer.valueOf(r0.code());     // Catch: Throwable -> L84 AppletFileError -> L94 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Throwable -> L80 AppletFileError -> L82 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        Iterator r17 = r0.headers().iterator();     // Catch: Throwable -> L80 AppletFileError -> L82 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L8:
        if (r17.hasNext() == false) goto L128;
        Header r18 = (Header) r17.next();     // Catch: Throwable -> L80 AppletFileError -> L82 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        String r19 = r18.getName();     // Catch: Throwable -> L80 AppletFileError -> L82 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        String r110 = r18.getValue();     // Catch: Throwable -> L80 AppletFileError -> L82 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        if (r110 != null) goto L12;
        r110 = "";
    L12:
        r16.put(r19, r110);     // Catch: Throwable -> L80 AppletFileError -> L82 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L128:
    L78:
        e = e;
        Integer r111 = r15;
        r14 = r16;
    L96:
        LinkedHashMap r112 = r14;
        Integer r113 = r111;
        boolean r20 = false;
    L97:
        String r21 = e.getMessage();
        if (r21 != null) goto L100;
        r21 = e.getCode();
    L100:
        r11.e(r12, r20, new a.e(r21, r113, r112));
    L116:
        return Unit.INSTANCE;
    L76:
        th = th;
        Integer r114 = r15;
        r14 = r16;
    L86:
        LinkedHashMap r115 = r14;
        Integer r116 = r114;
        boolean r22 = false;
    L88:
        if (r12.isCanceled() == true) goto L93;
        r10 = th.getMessage();
        if (r10 != null) goto L93;
        r10 = "downloadFile failed";
    L93:
        r11.e(r12, r22, new a.e(r10, r116, r115));
        goto L116
    L134:
        if (new IntRange(FontWeight.WEIGHT_300, 399).contains(r15.intValue()) == true) goto L124;
        long r117 = a.c(r11.r, r16);     // Catch: Throwable -> L76 AppletFileError -> L78 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        TypedInput r1 = (TypedInput) r0.body();     // Catch: Throwable -> L76 AppletFileError -> L78 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        if (r1 == null) goto L35;
        InputStream r23 = r1.in();     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L36:
        if (r23 == null) goto L38;
    L40:
        if (r23 != null) goto L42;
        r23 = new ByteArrayInputStream(new byte[0]);     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L42:
        InputStream r118 = r23;
        if (r11.a(r12, r16) == false) goto L121;
        Ref.LongRef r25 = new Ref.LongRef();     // Catch: Throwable -> L67 AppletFileError -> L70 CancellationException -> L75 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        r11.e.r(r11.c(r12), r118, r117, new d(r11, r12), new e(r11, r12), new f(r25, r11, r117));     // Catch: Throwable -> L67 AppletFileError -> L70 CancellationException -> L75 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        Integer r119 = r15;
        LinkedHashMap r26 = r16;
        r11.d(new a.d.C0031d(new a.j(r15.intValue(), r16, r25.element, r117)));     // Catch: Throwable -> L59 AppletFileError -> L61 CancellationException -> L75 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L61:
        e = e;
    L74:
        r113 = r119;
        r112 = r26;
        r20 = true;
    L59:
        th = th;
    L73:
        r116 = r119;
        r115 = r26;
        r22 = true;
        goto L88
    L65:
        e = e;
    L72:
        r26 = r16;
    L63:
        th = th;
    L69:
        r26 = r16;
        goto L73
    L75:
        boolean r27 = true;
    L102:
        r11.e(r12, r27, new a.e("downloadFile:fail abort", null, null));
    L70:
        e = e;
        r119 = r15;
    L67:
        th = th;
        r119 = r15;
        goto L69
    L121:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L47
        r118.close();     // Catch: Throwable -> L47
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        r12.cancel();     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L47:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        goto L49
    L38:
        if (r117 <= 0) goto L40;
        r11.d(new a.d.l(new a.e("downloadFile:fail response body is unavailable", r15, r16), r12));     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        goto L116
    L35:
        r23 = null;
        goto L36
    L124:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L24
        TypedInput r29 = (TypedInput) r0.body();     // Catch: Throwable -> L24
        if (r29 == null) goto L21;
        InputStream r30 = r29.in();     // Catch: Throwable -> L24
        if (r30 == null) goto L21;
        r30.close();     // Catch: Throwable -> L24
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Result.constructor-impl(r31);     // Catch: Throwable -> L24
    L26:
        r11.d(new a.d.l(new a.e("downloadFile:fail redirect is not allowed", r15, r16), r12));     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L21:
        r31 = null;
    L24:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L28 AppletFileError -> L30 CancellationException -> L101 NetworkNotAvailabeException -> L103 HttpResponseException -> L104
    L30:
        e = e;
        r111 = r15;
        r14 = r16;
    L28:
        th = th;
        r114 = r15;
        r14 = r16;
    L82:
        e = e;
        r111 = r15;
    L80:
        th = th;
        r114 = r15;
        goto L86
    L101:
        r27 = false;
    L104:
        e = move-exception;
        int r32 = e.getStatusCode();
        if (300 <= r32) goto L108;
    L110:
        boolean r33 = false;
    L111:
        if (r33 == true) goto L114;
        r13 = "downloadFile:fail httpCode: " + e.getStatusCode() + ", message: " + e.getMessage();
    L114:
        r11.d(new a.d.l(new a.e(r13, Integer.valueOf(e.getStatusCode()), MapsKt.emptyMap()), r12));
        goto L116
    L108:
        if (r32 >= 400) goto L110;
        r33 = true;
    L103:
        r11.d(new a.d.l(new a.e("downloadFile:fail network unavailable", -1001, MapsKt.emptyMap()), r12));
    L94:
        e = e;
        r111 = null;
    L84:
        th = th;
        r114 = null;
        goto L86
    L118:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
