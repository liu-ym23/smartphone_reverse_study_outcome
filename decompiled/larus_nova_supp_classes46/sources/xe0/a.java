package xe0;

import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContentKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements l {
    public final vlc.d a;
    public final InterfaceC0292a b;
    public final IRoom c;
    public boolean d;
    public boolean e;
    public final CompositeDisposable f;

    /* JADX INFO: renamed from: xe0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0292a {
        void D(String r1);

        void F(String r1, Throwable r2);

        void G(String r1);

        void Y2();

        void q(int r1);

        void r(String r1, Throwable r2);
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof z0) == false) goto L36;
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        z0 r6 = (z0) r5;
        int r2 = (int) r6.getType2();
        if (r2 == 10) goto L24;
        if (r2 == 11) goto L17;
        if (r2 == 16) goto L12;
        return;
    L12:
        if (r6.isToUser(r0) == false) goto L68;
        InterfaceC0292a r7 = this.b;
        if (r7 == null) goto L69;
        r7.q(3);
        return;
    L69:
        return;
    L68:
        return;
    L17:
        if (r6.isToUser(r0) == true) goto L19;
        return;
    L19:
        if (r6.isFromUser(r0) == true) goto L72;
        InterfaceC0292a r8 = this.b;
        if (r8 == null) goto L73;
        r8.q(0);
        return;
    L73:
        return;
    L72:
        return;
    L24:
        if (r6.isToUser(r0) == true) goto L26;
        return;
    L26:
        if (r6.isFromUser(r0) == true) goto L76;
        IMultiLinkInternalService r1 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r1 == null) goto L32;
        dn0.c r3 = r1.getLinkSecurityService();
        if (r3 == null) goto L32;
        r3.Z(r6.getToUserId().toString(), r6.getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_MESSAGE);
    L32:
        com.bytedance.android.live.liveinteract.linksecurity.b.n(com.bytedance.android.live.liveinteract.linksecurity.b.g);
        InterfaceC0292a r9 = this.b;
        if (r9 == null) goto L77;
        r9.q(2);
        return;
    L77:
        return;
    L76:
        return;
    L36:
        if ((r5 instanceof o0) == false) goto L43;
        if (((o0) r5).getAction() != 3) goto L79;
        InterfaceC0292a r10 = this.b;
        if (r10 == null) goto L80;
        r10.Y2();
        return;
    L80:
        return;
    L79:
        return;
    L43:
        if ((r5 instanceof h1) == false) goto L82;
        h1 r11 = (h1) r5;
        if (r11.getMUpdateUser() != null) goto L47;
        return;
    L47:
        ILinkerUpdateUserContent r4 = r11.getMUpdateUser();
        if (r4 != null) goto L50;
        return;
    L50:
        if (ILinkerUpdateUserContentKt.isSilenceStatusUpdate(r4) == true) goto L53;
        return;
    L53:
        if (12 != r11.getMType()) goto L84;
        ILinkerUpdateUserContent r12 = r11.getMUpdateUser();
        if (r12 != null) goto L57;
        return;
    L57:
        if (4 != ILinkerUpdateUserContentKt.getSilenceStatus(r12)) goto L86;
        ILinkerUpdateUserContent r13 = r11.getMUpdateUser();
        if (r13 == null) goto L61;
        String r14 = ILinkerUpdateUserContentKt.getToUserIdString(r13);
    L63:
        if (Intrinsics.areEqual(r14, je0.d.b0()) == false) goto L87;
        InterfaceC0292a r15 = this.b;
        if (r15 == null) goto L88;
        r15.q(4);
        return;
    L88:
        return;
    L87:
        return;
    L61:
        r14 = null;
        goto L63
    L86:
        return;
    L84:
        return;
    }

    public a(IRoom r2, LinkmicOnlineFloatWindowManager r3, vlc.d r4) {
        this.f = new CompositeDisposable();
        this.a = r4;
        this.b = r3;
        this.c = r2;
    }
}
