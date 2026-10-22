package emc;

import android.os.Message;
import android.util.SparseArray;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import com.ss.ugc.live.sdk.msg.utils.LoggerUtils;
import com.ss.ugc.live.sdk.msg.utils.f;
import com.ss.ugc.live.sdk.msg.utils.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import vlc.e;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements wlc.c, i.a, l {
    public final i a;
    public final vlc.d b;
    public final d<c> c;
    public b d;
    public final SparseArray<Set<wlc.b>> e;
    public final HashMap<String, Set<wlc.b>> f;
    public volatile long g;
    public volatile long h;
    public InterfaceC0255a i;
    public final vlc.c j;

    /* JADX INFO: renamed from: emc.a$a, reason: collision with other inner class name */
    public interface InterfaceC0255a {
        void a(IStreamMessage r1);

        void b(IStreamMessage r1);

        void c(IStreamMessage r1, long r2, long r4);
    }

    @Override // wlc.c
    public final void release() {
        i r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        vlc.d r1 = this.b;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        b r2 = this.d;
        if (r2 == null) goto L11;
        r2.interrupt();
    L11:
        this.e.clear();
        this.f.clear();
        this.c.clear();
        this.g = 0;
    }

    public a(vlc.d r3) {
        this.c = new d();
        this.e = new SparseArray();
        this.f = new HashMap();
        this.g = 0;
        this.h = 0;
        this.a = new i(this);
        this.b = r3;
        Lazy r0 = LoggerUtils.a;
        if ((r3 instanceof e) == true) goto L5;
        r3 = null;
    L5:
        e r4 = (e) r3;
        if (r4 == null) goto L12;
        amc.e r5 = r4.q();
        if (r5 == null) goto L12;
        vlc.c r6 = r5.getLogger();
        if (r6 == null) goto L12;
    L13:
        this.j = r6;
        return;
    L12:
        r6 = (vlc.c) LoggerUtils.a.getValue();
        goto L13
    }

    public final void a(IStreamMessage r3) {
        InterfaceC0255a r0 = this.i;
        if (r0 == null) goto L5;
        r0.a(r3);
    L5:
        Set<wlc.b> r1 = this.e.get(r3.getIntType());
        if (r1 != null) goto L8;
    L13:
        Set<wlc.b> r2 = this.f.get(r3.getMessageMethod());
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.isEmpty() == true) goto L24;
        Iterator<wlc.b> r4 = r2.iterator();
    L19:
        if (r4.hasNext() == false) goto L25;
        r4.next().Rk(r3);
        goto L19
    L25:
        return;
    L24:
        return;
    L8:
        if (r1.isEmpty() == true) goto L13;
        Iterator<wlc.b> r5 = r1.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        r5.next().Rk(r3);
        goto L11
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.i.a
    public final void handleMsg(Message r3) {
        if (r3.what != 7968) goto L8;
        Object r4 = r3.obj;
        if ((r4 instanceof IStreamMessage) == false) goto L9;
        a((IStreamMessage) r4);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [emc.b, java.lang.Thread] */
    @Override // vlc.l
    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof IStreamMessage) == true) goto L5;
        return;
    L5:
        if (this.d != null) goto L7;
        ?? r0 = new b(this.c, this.a);
        this.d = r0;
        ThreadMethodProxy.start(r0);
    L7:
        IStreamMessage r11 = (IStreamMessage) r10;
        if (r11 != null) goto L11;
        return;
    L11:
        if (r11.ignoreCondition() == false) goto L15;
        InterfaceC0255a r1 = this.i;
        if (r1 == null) goto L39;
        r1.b(r11);
        return;
    L39:
        return;
    L15:
        InterfaceC0255a r3 = this.i;
        if (r3 == null) goto L19;
        r3.c(r11, this.g, this.h);
    L19:
        if (r11.isStreamMessage() == true) goto L22;
        a(r11);
        return;
    L22:
        if ((r11 instanceof wlc.a) == false) goto L30;
        Iterator<IStreamMessage> r12 = ((wlc.a) r11).getStreamMessageList().iterator();
    L25:
        if (r12.hasNext() == false) goto L43;
        IStreamMessage r2 = r12.next();
        if (r2.getProcessAtSeiTs() > 0) goto L28;
        this.c.a(new c(r2, this.g, this.j));
        goto L25
    L28:
        this.c.a(new c(r2, this.g, r2.getProcessAtSeiTs(), this.j));
        goto L25
    L43:
        return;
    L30:
        c r4 = new c(r11, this.g, this.j);
        r4.d = this.h;
        this.c.a(r4);
    }

    @Override // wlc.c
    public final void updateStreamDelay(long r4) {
        this.h = r4;
        if (r4 <= 0) goto L5;
        this.g = f.a() - r4;
    L5:
        this.j.log("MessageStreamManager", "update stream delay: " + this.g + " sei: " + this.h);
        Object r5 = this.c.iterator();
    L6:
        d.a r6 = (d.a) r5;
        if (r6.hasNext() == false) goto L9;
        c r7 = (c) r6.next();
        r7.c = this.g;
        r7.d = this.h;
        goto L6
    }

    @Override // wlc.c
    public final void addMessageListener(int r3, wlc.b r4) {
        if (r4 == null) goto L11;
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.addMessageListener(r3, this);
    L6:
        Set<wlc.b> r1 = this.e.get(r3);
        if (r1 != null) goto L9;
        r1 = new CopyOnWriteArraySet();
        this.e.put(r3, r1);
    L9:
        r1.add(r4);
        return;
    }

    @Override // wlc.c
    public final void removeMessageListener(int r2, wlc.b r3) {
        if (r3 == null) goto L12;
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.removeMessageListener(r2, this);
    L6:
        Set<wlc.b> r4 = this.e.get(r2);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isEmpty() == true) goto L14;
        r4.remove(r3);
        return;
    L14:
        return;
    }

    @Override // wlc.c
    public final void addMessageListener(String r3, wlc.b r4) {
        if (r4 == null) goto L11;
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.addMessageListener(r3, this);
    L6:
        Set<wlc.b> r1 = this.f.get(r3);
        if (r1 != null) goto L9;
        r1 = new CopyOnWriteArraySet();
        this.f.put(r3, r1);
    L9:
        r1.add(r4);
        return;
    }

    @Override // wlc.c
    public final void removeMessageListener(String r2, wlc.b r3) {
        if (r3 == null) goto L12;
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.removeMessageListener(r2, this);
    L6:
        Set<wlc.b> r4 = this.f.get(r2);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isEmpty() == true) goto L14;
        r4.remove(r3);
        return;
    L14:
        return;
    }
}
