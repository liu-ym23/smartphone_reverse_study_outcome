package com.larus.dora.obric.device_management.setting.g.feedback;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.feedback.DoraObricGFeedbackFragment$getFileSizeFromUri$2", f = "DoraObricGFeedbackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGFeedbackFragment$getFileSizeFromUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public DoraObricGFeedbackFragment$getFileSizeFromUri$2(Context r1, Uri r2, Continuation<? super DoraObricGFeedbackFragment$getFileSizeFromUri$2> r3) {
        this.$context = r1;
        this.$uri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraObricGFeedbackFragment$getFileSizeFromUri$2 r0 = new DoraObricGFeedbackFragment$getFileSizeFromUri$2(this.$context, this.$uri, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Context r8 = this.$context;
        Uri r1 = this.$uri;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L26
        Cursor r9 = a(r8.getContentResolver(), r1, new String[]{"_size"});     // Catch: Throwable -> L26
        if (r9 == null) goto L23;
        Cursor r10 = r9;     // Catch: Throwable -> L26
        Cursor r2 = r10;     // Catch: Throwable -> L18
        if (r2.moveToFirst() == false) goto L14;
        int r0 = r2.getColumnIndex("_size");     // Catch: Throwable -> L18
        if (r0 == (-1)) goto L14;
        long r3 = r2.getLong(r0);     // Catch: Throwable -> L18
    L16:
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L26
    L24:
        Object r11 = Result.constructor-impl(Boxing.boxLong(r3));     // Catch: Throwable -> L26
    L28:
        Long r5 = Boxing.boxLong(0);
        if (Result.isFailure-impl(r11) == true) goto L31;
        return r11;
    L31:
        return r5;
    L14:
        r3 = 0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L23:
        r3 = 0;
    L26:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Cursor a(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }
}
