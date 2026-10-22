package aa2;

import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements Function1<PSTopMessagePayload, Unit> {
    public final /* synthetic */ TransTextMessagePresenter a;

    public x(TransTextMessagePresenter r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        PSTopMessagePayload r8 = (PSTopMessagePayload) r7;
        if (this.a.I.a <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        s0 r9 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10023, "已经收到其他消息-2", null);
        return Unit.INSTANCE;
    L10:
        if (r8.getPayload() == null) goto L24;
        TransTextMessagePresenter r1 = this.a;
        if (r1.A == null) goto L24;
        IRoom r2 = r1.e;
        if (r2 == null) goto L16;
        r2.getRoomId();
    L16:
        List<? extends tlc.d> r3 = this.a.A.O1(r8.getPayload(), r8.getActualRoomId());
        if (r3 != null) goto L19;
    L21:
        s0 r4 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10010, "backend解析出空列表", null);
    L22:
        r8.setPayload(null);
    L30:
        return Unit.INSTANCE;
    L19:
        if (r3.isEmpty() == true) goto L21;
        TransTextMessagePresenter r5 = this.a;
        r5.P = true;
        r5.D.insertBackendTopMessage(r3);
    L24:
        if (this.a.A != null) goto L27;
        s0 r6 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10012, "roomcontext为空", null);
    L27:
        if (r8.getPayload() != null) goto L30;
        s0 r10 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10011, "payload为空", null);
        goto L30
    L5:
        r0 = false;
        goto L7
    }
}
