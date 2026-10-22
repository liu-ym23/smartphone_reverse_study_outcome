package com.larus.bmhome.upload.instant;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import java.io.BufferedInputStream;
import java.io.File;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/upload/instant/ImageInstantUploadHash$SourceDigest;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.instant.ImageInstantUploadHash$sha256OfSource$2", f = "ImageInstantUploadHash.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageInstantUploadHash$sha256OfSource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageInstantUploadHash.a>, Object> {
    final /* synthetic */ long $maxFileSize;
    final /* synthetic */ j $param;
    private /* synthetic */ Object L$0;
    int label;

    public ImageInstantUploadHash$sha256OfSource$2(j r1, long r2, Continuation<? super ImageInstantUploadHash$sha256OfSource$2> r4) {
        this.$param = r1;
        this.$maxFileSize = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ImageInstantUploadHash$sha256OfSource$2 r0 = new ImageInstantUploadHash$sha256OfSource$2(this.$param, this.$maxFileSize, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ImageInstantUploadHash.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L109;
        ResultKt.throwOnFailure(r19);
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ImageInstantUploadHash r0 = ImageInstantUploadHash.a;
        j r3 = this.$param;
        r0.getClass();
        long r6 = 0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        Boolean r4 = r3.q;     // Catch: Throwable -> L32
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();     // Catch: Throwable -> L32
    L9:
        if (r5 == true) goto L29;
        File r7 = new PolarisFileWrapper(ImageInstantUploadHash.a(r3));     // Catch: Throwable -> L32
        if (r7.exists() == true) goto L14;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == true) goto L22;
        r7 = null;
    L22:
        if (r7 == null) goto L29;
        Long r9 = Long.valueOf(r7.length());     // Catch: Throwable -> L32
        if (r9.longValue() < 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
    L30:
        Object r11 = Result.constructor-impl(r9);     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r11) == false) goto L37;
        r11 = null;
    L37:
        Long r12 = (Long) r11;
        if (r12 != null) goto L40;
    L42:
        ImageInstantUploadHash r13 = ImageInstantUploadHash.a;
        j r14 = this.$param;
        r13.getClass();
        String r15 = ImageInstantUploadHash.a(r14);
        if ((true ^ StringsKt.isBlank(r15)) == true) goto L46;
        r15 = null;
    L46:
        if (r15 == null) goto L82;
        Boolean r16 = r14.q;
        if (r16 == null) goto L51;
        boolean r17 = r16.booleanValue();
    L52:
        if (r17 == true) goto L114;
        PolarisFileInputStreamWrapper r18 = ImageInstantUploadHash.b(r15);
    L84:
        PolarisFileInputStreamWrapper r20 = r18;
    L85:
        if (r20 == null) goto L107;
        long r21 = this.$maxFileSize;
        MessageDigest r22 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L101
        byte[] r110 = new byte[262144];     // Catch: Throwable -> L101
        BufferedInputStream r111 = new BufferedInputStream(r20, 262144);     // Catch: Throwable -> L101
    L88:
        JobKt.ensureActive(r2.getCoroutineContext());     // Catch: Throwable -> L101
        int r112 = r111.read(r110);     // Catch: Throwable -> L101
        if (r112 <= 0) goto L90;
        r6 = r6 + ((long) r112);
        if (r6 > r21) goto L97;
        r22.update(r110, 0, r112);     // Catch: Throwable -> L101
        goto L88
    L97:
        CloseableKt.closeFinally(r20, null);
        return null;
    L90:
        ImageInstantUploadHash r23 = ImageInstantUploadHash.a;     // Catch: Throwable -> L101
        byte[] r24 = r22.digest();     // Catch: Throwable -> L101
        r23.getClass();     // Catch: Throwable -> L101
        String r25 = ArraysKt.joinToString$default(r24, "", null, null, 0, null, new a(), 30, null);     // Catch: Throwable -> L101
        if (r12 == null) goto L93;
        r6 = r12.longValue();     // Catch: Throwable -> L101
    L93:
        ImageInstantUploadHash.a r26 = new ImageInstantUploadHash.a(r25, r6);     // Catch: Throwable -> L101
        CloseableKt.closeFinally(r20, null);
        return r26;
    L101:
        th = move-exception;
        throw th;     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);
        throw th;
    L107:
        return null;
    L114:
        Object r27 = Result.constructor-impl(UriProtector.parse(r15));     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r27) == false) goto L60;
        r27 = null;
    L60:
        Uri r28 = (Uri) r27;
        if (r28 == null) goto L82;
        String r29 = r28.getScheme();
        if (r29 == null) goto L82;
        int r113 = r29.hashCode();
        if (r113 == 3143036) goto L77;
        if (r113 != 951530617) goto L82;
        if (r29.equals("content") == false) goto L82;
        Context r30 = r14.getContext();
        if (r30 != null) goto L75;
        r30 = AppHost.a.getApplication();
    L75:
        r18 = ContentResolverWrapper.openInputStream(r30.getContentResolver(), r28);
        goto L84
    L77:
        if (r29.equals(ShareType.FILE) == false) goto L82;
        String r31 = r28.getPath();
        if (r31 == null) goto L82;
        ImageInstantUploadHash.a.getClass();
        r18 = ImageInstantUploadHash.b(r31);
    L55:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L51:
        r17 = r14.g;
    L82:
        r20 = null;
        goto L85
    L40:
        if (r12.longValue() <= this.$maxFileSize) goto L42;
        return null;
    L26:
        r10 = false;
        goto L27
    L14:
        if (r7.isFile() == false) goto L18;
        if (r7.canRead() == false) goto L18;
        r8 = true;
    L29:
        r9 = null;
        goto L30
    L8:
        r5 = r3.g;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L109:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
