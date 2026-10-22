package com.larus.bmhome.chat.markdown.code.share;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import se8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.share.CodeShareHelper$shareCode$4$createDeferred$1", f = "CodeShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CodeShareHelper$shareCode$4$createDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $language;
    int label;

    public CodeShareHelper$shareCode$4$createDeferred$1(Context r1, String r2, String r3, Continuation<? super CodeShareHelper$shareCode$4$createDeferred$1> r4) {
        this.$context = r1;
        this.$code = r2;
        this.$language = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CodeShareHelper$shareCode$4$createDeferred$1(this.$context, this.$code, this.$language, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        Lazy r4 = d.a;
        return d.a(this.$context, this.$code, this.$language);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
