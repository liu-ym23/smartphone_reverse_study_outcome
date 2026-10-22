package com.ss.android.lark.keyboard.biz.mention;

import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.IMCommonAtStrategy$getChatters$2", f = "IMCommonAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IMCommonAtStrategy$getChatters$2 extends SuspendLambda implements Function2<Map<String, ? extends ChatChatter>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $chatterIds;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMCommonAtStrategy this$0;

    public IMCommonAtStrategy$getChatters$2(IMCommonAtStrategy r1, List<String> r2, Continuation<? super IMCommonAtStrategy$getChatters$2> r3) {
        this.this$0 = r1;
        this.$chatterIds = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        IMCommonAtStrategy$getChatters$2 r0 = new IMCommonAtStrategy$getChatters$2(this.this$0, this.$chatterIds, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Map) r1, (Continuation) r2);
    }

    public final Object invoke(Map<String, ? extends ChatChatter> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r10);
        Map r11 = (Map) this.L$0;
        IMCommonAtStrategy r0 = this.this$0;
        List<String> r1 = this.$chatterIds;
        int r2 = IMCommonAtStrategy.i;
        r0.getClass();
        if (r11 != null) goto L7;
    L10:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        Log.e("IMCommonAtStrategy", "get local chatter success, but data is empty");
        r0.a(r1);
    L24:
        return Unit.INSTANCE;
    L14:
        ChatterNameDisplayRule r4 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        Iterator<T> r5 = r1.iterator();
    L16:
        if (r5.hasNext() == false) goto L24;
        String r6 = (String) r5.next();
        ChatChatter r7 = (ChatChatter) r11.get(r6);
        List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>> r8 = r0.f.remove(r6);
        if (r7 != null) goto L20;
        Log.e("IMCommonAtStrategy", "get local chatter success, but id = " + r6 + " chatter is null");
        r0.g.invoke(r8);
    L21:
        if (r8 == null) goto L16;
        r8.clear();
        goto L16
    L20:
        String r9 = r7.getLocalizedName();
        r0.h.invoke(TuplesKt.to(com.ss.android.lark.chat.utils.m.b(r7, r4, true), r9), r8);
        goto L21
    L7:
        if (r11.isEmpty() == true) goto L10;
        r3 = false;
        goto L12
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
