package od8;

import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements y.a<e> {
    public final /* synthetic */ ChatCameraComponent a;

    public g0(ChatCameraComponent r1) {
        this.a = r1;
    }

    public final void c(Object r6) {
        e r7 = (e) r6;
        Intrinsics.checkNotNullParameter(r7, "new");
        ChatCameraComponent r0 = this.a;
        com.larus.bmhome.chat.camera.command.t r1 = r0.s;
        r0.L2("conversation ready");
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[waitConversationReadyForPendingResult] conversation ready, consume pending, type=");
        String r4 = null;
        if (r1 == null) goto L5;
        String r5 = r1.getClass().getSimpleName();
    L6:
        r3.append(r5);
        r3.append(", cvsId=");
        r3.append(r7.a);
        r3.append(", abilityCvs=");
        y r8 = this.a.u0();
        if (r8 == null) goto L9;
        String r9 = r8.Y1();
    L10:
        r3.append(r9);
        r3.append(", botId=");
        y r10 = this.a.u0();
        if (r10 == null) goto L13;
        r4 = r10.getBotId();
    L13:
        r3.append(r4);
        r3.append(", fragmentAdded=");
        r3.append(s1a.a.c(this.a).isAdded());
        r2.i("ChatCameraComponent", r3.toString());
        if (r1 != null) goto L16;
        r2.e("ChatCameraComponent", "[waitConversationReadyForPendingResult] pending missing");
        return;
    L16:
        this.a.X2(r1);
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
