package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.chatbase.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import q3b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements i<MessageInfo> {
    public final Function0<MessageListPinExtraLoader> a;

    public e(g r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r3) {
        MessageInfo r4 = (MessageInfo) r3;
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        MessageListPinExtraLoader r0 = (MessageListPinExtraLoader) this.a.invoke();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.b == false) goto L11;
        BuildersKt.runBlocking$default(null, new MessageUniversalPinExtraDecorator$decorate$1(this, r4, null), 1, null);
        return;
    }

    public static final Object b(e r5, Map r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof MessageUniversalPinExtraDecorator$patchPinExtra$1) == false) goto L7;
        MessageUniversalPinExtraDecorator$patchPinExtra$1 r0 = (MessageUniversalPinExtraDecorator$patchPinExtra$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L26:
        Map r9 = (Map) r8;
        if ((!r9.isEmpty()) == false) goto L35;
        Iterator r10 = r6.entrySet().iterator();
    L30:
        if (r10.hasNext() == false) goto L35;
        Map.Entry r11 = (Map.Entry) r10.next();
        Long r4 = StringsKt.toLongOrNull((String) r11.getKey());
        if (r4 == null) goto L30;
        ((MessageInfo) r11.getValue()).setUniversalPinExtra((UniversalPinExtra) r9.get(Boxing.boxLong(r4.longValue())));
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MessageListPinExtraLoader r12 = (MessageListPinExtraLoader) r5.a.invoke();
        if (r12 == null) goto L46;
        Set r13 = r6.keySet();
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L19:
        if (r15.hasNext() == false) goto L23;
        Long r16 = StringsKt.toLongOrNull((String) r15.next());
        if (r16 == null) goto L19;
        r14.add(r16);
        goto L19
    L23:
        ArrayList r17 = new ArrayList(r14);
        r0.L$0 = r6;
        r0.label = 1;
        r8 = r12.e(r17, r0);
        if (r8 != r2) goto L26;
        return r2;
    L46:
        return Unit.INSTANCE;
    L7:
        r0 = new MessageUniversalPinExtraDecorator$patchPinExtra$1(r5, r7);
        goto L8
    }
}
