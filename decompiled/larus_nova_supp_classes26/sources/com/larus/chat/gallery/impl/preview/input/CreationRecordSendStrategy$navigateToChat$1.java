package com.larus.chat.gallery.impl.preview.input;

import android.app.Application;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.input.CreationRecordSendStrategy$navigateToChat$1", f = "CreationRecordSendStrategy.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class CreationRecordSendStrategy$navigateToChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUri;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ CreationRecordSendStrategy this$0;

    public CreationRecordSendStrategy$navigateToChat$1(CreationRecordSendStrategy r1, String r2, String r3, Continuation<? super CreationRecordSendStrategy$navigateToChat$1> r4) {
        this.this$0 = r1;
        this.$imageUri = r2;
        this.$text = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationRecordSendStrategy$navigateToChat$1(this.this$0, this.$imageUri, this.$text, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L18 CancellationException -> L29
    L13:
        AttachmentInfo r8 = (AttachmentInfo) r7;     // Catch: Throwable -> L18 CancellationException -> L29
        if (r8 == null) goto L20;
        if (CreationRecordSendStrategy.j(this.this$0, this.$text, r8) == false) goto L20;
    L21:
        this.this$0.c = null;
        if (r4 == true) goto L24;
        t19.s r9 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r9.getClass();
        t19.s.b(r2, 2131908080, false);
    L24:
        Function1<? super Boolean, Unit> r10 = this.this$0.b;
        if (r10 == null) goto L28;
        r10.invoke(Boxing.boxBoolean(r4));
    L28:
        return Unit.INSTANCE;
    L20:
        r4 = false;
        goto L21
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CreationRecordSendStrategy r11 = this.this$0;     // Catch: Throwable -> L18 CancellationException -> L29
        String r3 = this.$imageUri;     // Catch: Throwable -> L18 CancellationException -> L29
        this.label = 1;     // Catch: Throwable -> L18 CancellationException -> L29
        int r5 = CreationRecordSendStrategy.d;     // Catch: Throwable -> L18 CancellationException -> L29
        r11.getClass();     // Catch: Throwable -> L18 CancellationException -> L29
        r7 = BuildersKt.withContext(Dispatchers.getIO(), new CreationRecordSendStrategy$resolveImageAttachment$2(r3, null), this);     // Catch: Throwable -> L18 CancellationException -> L29
        if (r7 != r0) goto L13;
        return r0;
    L29:
        e = move-exception;
        throw e;
    L18:
        th = move-exception;
        FLogger.a.e("CreationRecordSendStrategy", "navigateToChat: resolveAndSendImage failed", th);
        goto L20
    }
}
