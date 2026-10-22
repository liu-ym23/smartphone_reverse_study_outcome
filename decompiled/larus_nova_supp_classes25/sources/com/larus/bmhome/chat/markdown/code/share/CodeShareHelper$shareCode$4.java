package com.larus.bmhome.chat.markdown.code.share;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.share.CodeShareHelper$shareCode$4", f = "CodeShareHelper.kt", i = {1}, l = {58, 65}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
public final class CodeShareHelper$shareCode$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $language;
    private /* synthetic */ Object L$0;
    int label;

    public CodeShareHelper$shareCode$4(Context r1, String r2, String r3, Continuation<? super CodeShareHelper$shareCode$4> r4) {
        this.$context = r1;
        this.$code = r2;
        this.$language = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CodeShareHelper$shareCode$4 r0 = new CodeShareHelper$shareCode$4(this.$context, this.$code, this.$language, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r37) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Object r3 = null;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        File r1 = (File) this.L$0;
        ResultKt.throwOnFailure(r37);
        Object r4 = r37;
    L32:
        String r5 = (String) r4;
        if (r5 != null) goto L35;
        r5 = r1.getPath();
    L35:
        String r16 = r5;
        IShareService.a.d(ShareServiceDelegate.b, this.$context, "export_file", "file", new b(null, null, null, null, null, null, null, null, null, null, null, r16, r1.getName(), null, null, null, false, false, null, null, false, false, null, false, null, null, 67102719), null, 48);
    L38:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r37);     // Catch: Throwable -> L17
        Object r6 = r37;
    L15:
        Object r7 = Result.constructor-impl((File) r6);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r7) == true) goto L23;
        r3 = r7;
    L23:
        r1 = (File) r3;
        if (r1 != null) goto L26;
    L36:
        s r8 = s.a;
        Context r9 = this.$context;
        r8.getClass();
        s.b(r9, 2131905600, false);
        goto L38
    L26:
        if (r1.exists() == false) goto L36;
        if (r1.length() <= 0) goto L36;
        CodeShareHelper r10 = CodeShareHelper.a;
        String r11 = r1.getPath();
        this.L$0 = r1;
        this.label = 2;
        r4 = CodeShareHelper.a(r10, r11, this);
        if (r4 != r2) goto L32;
        return r2;
    L11:
        ResultKt.throwOnFailure(r37);
        Deferred r12 = BuildersKt.async$default((CoroutineScope) this.L$0, Dispatchers.getIO(), null, new CodeShareHelper$shareCode$4$createDeferred$1(this.$context, this.$code, this.$language, null), 2, null);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        r6 = r12.await(this);     // Catch: Throwable -> L17
        if (r6 != r2) goto L15;
        return r2;
    L17:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
