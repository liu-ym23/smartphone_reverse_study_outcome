package o3a;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponent;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ QuicInterpretComponent a;

    public /* synthetic */ g(QuicInterpretComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        QuicInterpretComponent r0 = this.a;
        String r3 = (String) r14;
        Intrinsics.checkNotNullParameter(r3, "id");
        FLogger.a.d(r0.l, "onConversationIdUpdated : " + r3);
        RealtimeCallUtil r15 = RealtimeCallUtil.a;
        y r1 = (y) r0.n.getValue();
        if (r1 == null) goto L8;
        BotModel r2 = r1.j0();
        if (r2 == null) goto L8;
        String r4 = r2.getBotId();
        if (r4 == null) goto L8;
    L9:
        RealtimeCallParam r5 = r0.o;
        if (r5 == null) goto L13;
        String r6 = r5.e;
        if (r6 == null) goto L13;
    L14:
        CopyOnWriteArraySet r7 = new CopyOnWriteArraySet();
        CopyOnWriteArraySet r8 = new CopyOnWriteArraySet();
        ConcurrentHashMap r9 = new ConcurrentHashMap();
        CopyOnWriteArraySet r10 = new CopyOnWriteArraySet();
        CopyOnWriteArraySet r11 = new CopyOnWriteArraySet();
        RealtimeCallParam r12 = r0.o;
        if (r12 == null) goto L17;
        AudioSessionType r13 = r12.s;
    L18:
        r15.getClass();
        RealtimeCallUtil.H(r4, NameKeys.UnloadStrategy_No_Strategy, r3, r6, null, r7, r8, r9, r10, r11, 0, r13);
        return Unit.INSTANCE;
    L17:
        r13 = null;
    L13:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r4 = NameKeys.UnloadStrategy_No_Strategy;
        goto L9
    }
}
