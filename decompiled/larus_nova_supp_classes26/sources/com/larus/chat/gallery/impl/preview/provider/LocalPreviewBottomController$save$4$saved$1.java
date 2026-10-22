package com.larus.chat.gallery.impl.preview.provider;

import android.content.Context;
import com.larus.chat.gallery.impl.preview.data.LocalMediaType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.provider.LocalPreviewBottomController$save$4$saved$1", f = "LocalPreviewBottomController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalPreviewBottomController$save$4$saved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ xy8.d $data;
    int label;

    public LocalPreviewBottomController$save$4$saved$1(Context r1, xy8.d r2, Continuation<? super LocalPreviewBottomController$save$4$saved$1> r3) {
        this.$context = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalPreviewBottomController$save$4$saved$1(this.$context, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r6);
        com.larus.chat.gallery.impl.preview.toolbar.action.r r7 = com.larus.chat.gallery.impl.preview.toolbar.action.r.a;
        Context r0 = this.$context;
        xy8.d r1 = this.$data;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r1, "data");
        xy8.c r8 = r1.p;
        boolean r2 = false;
        if (r8 == null) goto L31;
        String r3 = r8.c;
        if (r3 != null) goto L10;
    L14:
        r3 = com.larus.chat.gallery.impl.preview.toolbar.action.r.a(r8.b);
    L15:
        if (r3 == null) goto L31;
        if (r8.getType() != LocalMediaType.IMAGE) goto L20;
        r2 = true;
    L20:
        FLogger.a.i("PreviewLocalMediaHelper", "saveToAlbum: localPath=" + r3 + ", isImage=" + r2);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        com.larus.utils.r.u(r0, r3, r2);     // Catch: Throwable -> L23
        Object r10 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L23
    L25:
        Throwable r4 = Result.exceptionOrNull-impl(r10);
        if (r4 == null) goto L29;
        FLogger.a.e("PreviewLocalMediaHelper", "saveToAlbum failed, localPath=".concat(r3), r4);
        r10 = Boolean.FALSE;
    L29:
        r2 = ((Boolean) r10).booleanValue();
    L23:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L10:
        if ((!StringsKt.isBlank(r3)) == true) goto L13;
        r3 = null;
    L13:
        if (r3 != null) goto L15;
    L31:
        return Boxing.boxBoolean(r2);
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
