package cj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends com.bytedance.android.live.liveinteract.plantform.base.i.d implements com.bytedance.android.live.liveinteract.voicechat.util.b {
    public static final /* synthetic */ int f = 0;
    public long a;
    public long b;
    public boolean c;
    public final List<b> d;
    public final boolean e;

    public static final class a {
        public static l a() {
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.paidLinkManager();
        }
    }

    public interface b {
        void B0(long r1);
    }

    static {
    }

    public l() {
        this.e = false;
        this.d = new ArrayList();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.util.b
    public final void c(int r5) {
        long r0 = this.b;
        if (r0 > 0) goto L5;
        ALogger.e("ttlive_link_paid", "selfRemainingTime=" + this.b + " invalid");
        return;
    L5:
        this.b = r0 - ((long) 1);
        Iterator r1 = ((ArrayList) this.d).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b) r1.next()).B0(this.b);
        goto L7
    L9:
        f(true, null);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r14) {
        Intrinsics.checkNotNullParameter(r14, "list");
        Iterator<T> r15 = r14.iterator();
    L3:
        Object r1 = null;
        if (r15.hasNext() == false) goto L11;
        Object r0 = r15.next();
        IBaseUser r2 = ((ILinkPlayerInfoBridge) r0).getUser();
        if (r2 == null) goto L9;
        r1 = r2.getIdString();
    L9:
        if (Intrinsics.areEqual(r1, je0.d.b0()) == false) goto L3;
        r1 = r0;
    L11:
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r1;
        if (this.e == true) goto L18;
        if (r3 == null) goto L18;
        if (r3.getExpectLeaveTime() == 0) goto L18;
        boolean r16 = true;
    L19:
        if (r16 == false) goto L21;
        Intrinsics.checkNotNull(r3);
        this.a = r3.getExpectLeaveTime();
        long r5 = fj0.e.m(r3);
        long r7 = this.a - (System.currentTimeMillis() / 1000);
        this.b = r7;
        if (r7 > 0) goto L27;
        this.b = 0;
    L27:
        if (this.c == true) goto L29;
        com.bytedance.android.live.liveinteract.voicechat.util.c.d.b(this);
        this.c = true;
    L29:
        f(false, Long.valueOf(r5));
        ALogger.e("ttlive_link_paid", "onlineListChange selfRemainingTime=" + this.b + "s  selfExpectLeaveTime=" + this.a);
        return;
    L21:
        if (this.c == false) goto L34;
        List<com.bytedance.android.live.liveinteract.voicechat.util.b> r17 = com.bytedance.android.live.liveinteract.voicechat.util.c.a;
        com.bytedance.android.live.liveinteract.voicechat.util.c.c(this);
        this.c = false;
        return;
    L34:
        return;
    L18:
        r16 = false;
        goto L19
    }

    public final void f(boolean r7, Long r8) {
        long r0 = this.b;
        if (r0 >= 1) goto L27;
        if (r7 == false) goto L6;
        int r9 = fj0.d.a;
        fj0.d.b(r0, this.a);
    L7:
        List<com.bytedance.android.live.liveinteract.voicechat.util.b> r10 = com.bytedance.android.live.liveinteract.voicechat.util.c.a;
        com.bytedance.android.live.liveinteract.voicechat.util.c.c(this);
        boolean r11 = false;
        this.c = false;
        if (this.e == false) goto L11;
    L17:
        if (r11 == true) goto L19;
        return;
    L19:
        if (je0.d.A() == false) goto L23;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L29;
        IVoiceChatGuestService.b.b(r1, 203, false, true, true, 16);
        return;
    L29:
        return;
    L23:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r2 == null) goto L31;
        IVoiceChatGuestService.b.b(r2, 203, false, true, false, 24);
        return;
    L31:
        return;
    L11:
        if (hd0.c.f().h() == true) goto L16;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r12 = IVoiceChatGuestService.a.a();
        if (r12 == null) goto L17;
        if (r12.isEngineOn() != true) goto L17;
    L16:
        r11 = true;
        goto L17
    L6:
        int r13 = fj0.d.a;
        fj0.d.a(r0, this.a, r8);
        goto L7
    }
}
