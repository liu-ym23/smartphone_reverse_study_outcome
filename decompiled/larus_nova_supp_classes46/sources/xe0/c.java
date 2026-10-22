package xe0;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public c(a r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = 1;
        this.d = r3;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), this.b) == true) goto L5;
    L7:
        this.a.d = false;
        IMultiLinkInternalService r0 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r0 == null) goto L12;
        dn0.c r1 = r0.getLinkSecurityService();
        if (r1 == null) goto L12;
        r1.Z(this.b, ((r1) r7.data).getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_API);
    L12:
        a.InterfaceC0292a r2 = this.a.b;
        if (r2 == null) goto L15;
        r2.D(this.b);
    L15:
        InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.d, r7.logId);
        String r3 = this.b;
        List r4 = ((r1) r7.data).getLinkedUsers();
        String r5 = null;
        if (r4 == null) goto L18;
        String r8 = je0.d.g0(r4);
    L19:
        Map r9 = ((r1) r7.data).getLinkerContentMap();
        if (r9 == null) goto L22;
        r5 = r9.toString();
    L22:
        x.w0(r3, "", r8, r5);
        return;
    L18:
        r8 = null;
        goto L19
    L5:
        if (this.c != 0) goto L7;
        com.bytedance.android.live.liveinteract.linksecurity.b.o(com.bytedance.android.live.liveinteract.linksecurity.b.g);
        goto L7
    }
}
