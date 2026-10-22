package qk0;

import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager$mMsgListener$1;
import com.bytedance.android.live.multilink.common.message.MultiLinkMessageTypeKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.e9;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vb6.b implements ac6.a {
    public f b;
    public final CopyOnWriteArrayList<ac6.a.a> c;
    public final CompositeDisposable d;

    /* JADX INFO: renamed from: qk0.a$a, reason: collision with other inner class name */
    public static final class C0259a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            z0 r5 = com.bytedance.android.live.liveinteract.multianchor.model.a.a((com.bytedance.android.live.liveinteract.multianchor.model.b) r4);
            if (r5 == null) goto L55;
            z0 r6 = r5;
            a r0 = this.a;
            r0.getClass();
            int r2 = (int) r6.getType2();
            if (r2 != 1) goto L7;
            Iterator<ac6.a.a> r1 = r0.c.iterator();
        L51:
            if (r1.hasNext() == false) goto L71;
            r1.next().E2(r6);
            goto L51
        L71:
            return;
        L7:
            if (r2 != 2) goto L9;
            Iterator<ac6.a.a> r3 = r0.c.iterator();
        L47:
            if (r3.hasNext() == false) goto L70;
            r3.next().J2(r6);
            goto L47
        L70:
            return;
        L9:
            if (r2 != 3) goto L11;
            Iterator<ac6.a.a> r7 = r0.c.iterator();
        L43:
            if (r7.hasNext() == false) goto L69;
            r7.next().A2(r6);
            goto L43
        L69:
            return;
        L11:
            if (r2 != 4) goto L13;
            Iterator<ac6.a.a> r8 = r0.c.iterator();
        L39:
            if (r8.hasNext() == false) goto L68;
            r8.next().C2(r6);
            goto L39
        L68:
            return;
        L13:
            if (r2 != 12) goto L15;
            Iterator<ac6.a.a> r9 = r0.c.iterator();
        L35:
            if (r9.hasNext() == false) goto L67;
            r9.next().I2(r6);
            goto L35
        L67:
            return;
        L15:
            if (r2 != 13) goto L17;
            Iterator<ac6.a.a> r10 = r0.c.iterator();
        L31:
            if (r10.hasNext() == false) goto L66;
            r10.next().z2(r6);
            goto L31
        L66:
            return;
        L17:
            if (r2 != 15) goto L19;
            Iterator<ac6.a.a> r11 = r0.c.iterator();
        L27:
            if (r11.hasNext() == false) goto L65;
            r11.next().y1(r6);
            goto L27
        L65:
            return;
        L19:
            if (r2 != 17) goto L53;
            Iterator<ac6.a.a> r12 = r0.c.iterator();
        L23:
            if (r12.hasNext() == false) goto L64;
            r12.next().D2(r6);
            goto L23
        L64:
            return;
        L53:
            return;
        L55:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkMicMessageBridge");
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            jy0.b.c("LinkMsgM", "WebcastLinkMicMethod subscribe error " + ((Throwable) r4), null, 4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            h1 r5 = com.bytedance.android.live.liveinteract.multianchor.model.a.a((e9) r4);
            if (r5 == null) goto L31;
            h1 r6 = r5;
            a r0 = this.a;
            r0.getClass();
            int r2 = (int) r6.getType2();
            if (r2 != 8) goto L7;
            Iterator<ac6.a.a> r1 = r0.c.iterator();
        L27:
            if (r1.hasNext() == false) goto L39;
            r1.next().G2(r6);
            goto L27
        L39:
            return;
        L7:
            if (r2 != 53) goto L9;
            Iterator<ac6.a.a> r3 = r0.c.iterator();
        L23:
            if (r3.hasNext() == false) goto L38;
            r3.next().B2(r6);
            goto L23
        L38:
            return;
        L9:
            if (r2 != 64) goto L11;
            Iterator<ac6.a.a> r7 = r0.c.iterator();
        L19:
            if (r7.hasNext() == false) goto L37;
            r7.next().H2(r6);
            goto L19
        L37:
            return;
        L11:
            if (r2 != 101) goto L29;
            Iterator<ac6.a.a> r8 = r0.c.iterator();
        L15:
            if (r8.hasNext() == false) goto L36;
            r8.next().F2(r6);
            goto L15
        L36:
            return;
        L29:
            return;
        L31:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkerMessageBridge");
        }
    }

    static {
    }

    public final void attach() {
        this.b = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), f.class);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.o("LinkMsgManager", "call attach with messageManager = " + this.b);
        f r1 = this.b;
        if (r1 == null) goto L9;
        Observable r2 = h.a.a(r1, MultiLinkMessageTypeKt.b(com.bytedance.android.live.multilink.common.message.a.b), false, 6);
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new b(this), c.a);
        if (r3 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.d);
    L9:
        f r4 = this.b;
        if (r4 == null) goto L17;
        Observable r5 = h.a.a(r4, MultiLinkMessageTypeKt.a(com.bytedance.android.live.multilink.common.message.a.b), false, 6);
        if (r5 == null) goto L18;
        Disposable r6 = r5.subscribe(new d(this));
        if (r6 == null) goto L19;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6, this.d);
        return;
    L19:
        return;
    L18:
        return;
    }

    public a() {
        this.c = new CopyOnWriteArrayList();
        this.d = new CompositeDisposable();
    }

    public final void h(xb6.b r2) {
        super.h(r2);
        this.d.clear();
        Iterator<T> r3 = this.c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        h0((ac6.a.a) r3.next());
        goto L4
    }

    public final void h0(ac6.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    public final void j0(yh6.c r3) {
        if (r3 == null) goto L7;
        f r0 = this.b;
        if (r0 == null) goto L8;
        r0.insert(r3, true);
        return;
    L8:
        return;
    }

    public final void s(LinkPipelineManager$mMsgListener$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.add(r2);
    }
}
