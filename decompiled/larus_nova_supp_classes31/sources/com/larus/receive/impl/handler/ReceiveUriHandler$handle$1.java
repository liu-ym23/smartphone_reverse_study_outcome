package com.larus.receive.impl.handler;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.receive.impl.handler.ReceiveUriHandler$handle$1", f = "ReceiveUriHandler.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class ReceiveUriHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $currentPage;
    int label;
    final /* synthetic */ d this$0;

    /* JADX INFO: renamed from: com.larus.receive.impl.handler.ReceiveUriHandler$handle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.receive.impl.handler.ReceiveUriHandler$handle$1$1", f = "ReceiveUriHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bundle;
        final /* synthetic */ Context $context;
        int label;

        public AnonymousClass1(Context r1, Bundle r2, Continuation<? super AnonymousClass1> r3) {
            this.$context = r1;
            this.$bundle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$context, this.$bundle, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            int r3 = qs9.a.a;
            qs9.a.a(this.$context, this.$bundle);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ReceiveUriHandler$handle$1(d r1, Context r2, String r3, Continuation<? super ReceiveUriHandler$handle$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$currentPage = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ReceiveUriHandler$handle$1(this.this$0, this.$context, this.$currentPage, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L70:
        d r13 = this.this$0;
        int r2 = d.b;
        ((ArrayList) r13.a).clear();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        d r14 = this.this$0;
        Context r3 = this.$context;
        if ((r3 instanceof Activity) == false) goto L11;
        Activity r4 = (Activity) r3;
    L12:
        int r5 = 0;
        if (r4 != null) goto L16;
        int r6 = d.b;
        r14.getClass();
    L57:
        Pair[] r15 = new Pair[5];
        r15[0] = TuplesKt.to("argPreviousPage", this.$currentPage);
        int r7 = qs9.a.a;
        List<Uri> r8 = this.this$0.a;
        Intrinsics.checkNotNullParameter(r8, "uris");
        ArrayList r9 = (ArrayList) r8;
        Iterator r10 = r9.iterator();
        String r11 = "";
    L59:
        if (r10.hasNext() == false) goto L67;
        Object r16 = r10.next();
        int r17 = r5 + 1;
        if (r5 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        r11 = r11 + ((Uri) r16);
        if (r5 >= (r9.size() - 1)) goto L66;
        r11 = r11 + ',';
    L66:
        r5 = r17;
        goto L59
    L67:
        r15[1] = TuplesKt.to("auto_send_uris", r11);
        r15[2] = TuplesKt.to("enter_method", "selfshare_open");
        r15[3] = TuplesKt.to("enter_from", "selfshare_open");
        r15[4] = TuplesKt.to("ignore_same_page_check", Boxing.boxBoolean(true));
        Bundle r18 = f.c(r15);
        MainCoroutineDispatcher r19 = Dispatchers.getMain();
        AnonymousClass1 r20 = new AnonymousClass1(this.$context, r18, null);
        this.label = 1;
        if (BuildersKt.withContext(r19, r20, this) != r0) goto L70;
        return r0;
    L16:
        if (((ArrayList) r14.a).size() != 1) goto L57;
        ImFileUtil r21 = ImFileUtil.a;
        Uri r22 = (Uri) CollectionsKt.first(r14.a);
        r21.getClass();
        if (ImFileUtil.w(r22) == false) goto L57;
        if (ImFileUtil.f((Uri) CollectionsKt.first(r14.a)).c > 0) goto L57;
        FLogger.a.i("ReceiveUriHandler", "The file size is illegal,copy it!!!");
        Intrinsics.checkNotNullParameter("jpeg", "formatSuffix");
        Uri r23 = Uri.fromFile(aa9.a.a.d("image_upload", "image_" + UUID.randomUUID() + ".jpeg"));
        Uri r24 = (Uri) CollectionsKt.first(r14.a);
        Intrinsics.checkNotNull(r23);
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r24, "sourceUri");
        Intrinsics.checkNotNullParameter(r23, "destinationUri");
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L54
        ContentResolver r26 = r4.getContentResolver();     // Catch: Throwable -> L54
        if (r26 == null) goto L51;
        InputStream r27 = ContentResolverWrapper.openInputStream(r26, r24);     // Catch: Throwable -> L54
        if (r27 == null) goto L51;
        ContentResolver r28 = r4.getContentResolver();     // Catch: Throwable -> L46
        if (r28 == null) goto L43;
        OutputStream r29 = ContentResolverWrapper.openOutputStream(r28, r23);     // Catch: Throwable -> L46
        if (r29 == null) goto L43;
        byte[] r30 = new byte[4096];     // Catch: Throwable -> L38
    L32:
        int r31 = r27.read(r30);     // Catch: Throwable -> L38
        if (r31 == (-1)) goto L35;
        r29.write(r30, 0, r31);     // Catch: Throwable -> L38
        goto L32
    L35:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r29, null);     // Catch: Throwable -> L46
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        CloseableKt.closeFinally(r27, null);     // Catch: Throwable -> L54
    L52:
        Result.constructor-impl(r33);     // Catch: Throwable -> L54
    L56:
        ((ArrayList) r14.a).clear();
        ((ArrayList) r14.a).add(r23);
        goto L57
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r29, th);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L43:
        r33 = null;
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r27, th);     // Catch: Throwable -> L54
        throw th;     // Catch: Throwable -> L54
    L51:
        r33 = null;
    L54:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L11:
        r4 = null;
        goto L12
    }
}
