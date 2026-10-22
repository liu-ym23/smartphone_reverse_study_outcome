package com.larus.bmhome.chat.list.cell.record;

import com.larus.audio.j0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ RecordCardCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ g(RecordCardCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r15) {
        RecordCardCell r6 = this.a;
        Message r7 = this.b;
        boolean r16 = ((Boolean) r15).booleanValue();
        Map r0 = RecordCardCell.m;
        if (r16 == false) goto L18;
        FLogger.a.i("RecordCardBox", "call audio start recording");
        j0 r17 = r6.i;
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        h r2 = new h(r7, r6, r1);
        r1.element = r2;
        r17.j(r2);
        y r18 = (y) r6.k.getValue();
        if (r18 == null) goto L7;
        String r19 = r18.getBotId();
    L9:
        if (o0.d(r19) == false) goto L11;
        r6.h = System.currentTimeMillis();
        r6.i.i(r7.getMessageId(), r19);
    L31:
        return Unit.INSTANCE;
    L11:
        q0 r110 = lf8.a.b(r6);
        if (r110 == null) goto L31;
        com.larus.bmhome.chat.api.j0 r111 = r110.y7();
        if (r111 == null) goto L31;
        CoroutineScope r8 = (CoroutineScope) r111.invoke();
        if (r8 == null) goto L31;
        BuildersKt.launch$default(r8, null, null, new RecordCardCell$handleSpecialSituation$1$1(r6, r7, null), 3, null);
        goto L31
    L7:
        r19 = null;
        goto L9
    L18:
        RecordStatus r3 = RecordStatus.UNAUTHORIZED_ERROR;
        String r112 = r7.getMessageId();
        String r9 = "";
        if (r112 != null) goto L21;
        String r4 = "";
    L22:
        RecordCardCell.r(r6, r3, r4, null, "handleSpecialSituation in cell not granted", 12);
        String r113 = r7.getMessageId();
        if (r113 != null) goto L25;
        r113 = "";
    L25:
        String r5 = r7.getConversationId();
        if (r5 == null) goto L29;
        r9 = r5;
    L29:
        r6.x("voice_note_card_error", r113, r9, new Pair[]{TuplesKt.to("error_type", "permission")});
        goto L31
    L21:
        r4 = r112;
        goto L22
    }
}
