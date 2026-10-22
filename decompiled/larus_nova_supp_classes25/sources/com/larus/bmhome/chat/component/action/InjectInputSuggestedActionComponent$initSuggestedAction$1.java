package com.larus.bmhome.chat.component.action;

import android.os.Bundle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.action.InjectInputSuggestedActionComponent$initSuggestedAction$1", f = "InjectInputSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InjectInputSuggestedActionComponent$initSuggestedAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InjectInputSuggestedActionComponent this$0;

    public InjectInputSuggestedActionComponent$initSuggestedAction$1(InjectInputSuggestedActionComponent r1, Continuation<? super InjectInputSuggestedActionComponent$initSuggestedAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InjectInputSuggestedActionComponent$initSuggestedAction$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L41;
        ResultKt.throwOnFailure(r5);
        boolean r1 = false;
        if (this.this$0.C3() != com.larus.bmhome.chat.camera.command.s.a) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L10;
        ICoreInputAbility r7 = this.this$0.B3();
        if (r7 == null) goto L14;
        r1 = r7.c1();
    L14:
        if (r1 == false) goto L16;
        de8.c r8 = this.this$0.f1();
        String r0 = "";
        if (r8 == null) goto L26;
        Bundle r9 = r8.a;
        if (r9 == null) goto L26;
        String r10 = r9.getString("bot_id", "");
        if (r10 == null) goto L26;
        r0 = r10;
    L26:
        if (ObricFeatureServiceDelegate.b.a() == false) goto L28;
        SuggestedActionData r11 = com.larus.bmhome.chat.camera.command.v.a(r0);
    L29:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("initSuggestedAction, botId: ");
        r3.append(r0);
        r3.append(", suggestedActionCacheData: ");
        if (r11 == null) goto L34;
        List r4 = r11.getAttachmentAreaSingleImg();
        if (r4 == null) goto L34;
        Integer r12 = Boxing.boxInt(r4.size());
    L35:
        r3.append(r12);
        r2.i("InjectInputSuggestedActionComponent", r3.toString());
        if (r11 == null) goto L39;
        this.this$0.C3().d(r11);
    L39:
        return Unit.INSTANCE;
    L34:
        r12 = null;
        goto L35
    L28:
        Lazy r13 = com.larus.bmhome.chat.camera.command.v.a;
        Intrinsics.checkNotNullParameter(r0, "botId");
        r11 = (SuggestedActionData) ((LinkedHashMap) com.larus.bmhome.chat.camera.command.v.b).get(r0);
        goto L29
    L16:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L7:
        r6 = false;
        goto L8
    L41:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
