package cj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements rj0.h {
    public static final /* synthetic */ int h = 0;
    public Disposable a;
    public long b;
    public long c;
    public final Map<String, Long> d;
    public final CopyOnWriteArrayList<rj0.h.a> e;
    public ILinkPlayerInfoBridge f;
    public final boolean g;

    public static final class a {
        public static rj0.h a() {
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L15;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L15;
            if (r1.isLiveTypeAudio() != true) goto L15;
            com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
            com.bytedance.android.live.liveinteract.voicechat.d r2 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r2 == null) goto L12;
            rj0.h r3 = r2.videoStylePaidLinkManager();
            if (r3 == null) goto L12;
            return r3;
        L12:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
            if (r4 != null) goto L25;
        L22:
            return null;
        L25:
            return r4.videoStylePaidLinkManager();
        L15:
            rj0.k.m2.getClass();
            rj0.k r5 = rj0.k.a.a();
            if (r5 == null) goto L19;
            e r6 = r5.paidLinkManager();
            if (r6 == null) goto L19;
            return r6;
        L19:
            rj0.l.n2.getClass();
            rj0.l r7 = rj0.l.a.a();
            if (r7 == null) goto L22;
            return r7.paidLinkManager();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            Long r13 = (Long) r12;
            e r14 = this.a;
            if (r14.g == false) goto L5;
        L17:
            e r15 = this.a;
            Iterator r0 = ((HashMap) r15.d).entrySet().iterator();
            boolean r6 = false;
        L19:
            if (r0.hasNext() == false) goto L27;
            Map.Entry r7 = (Map.Entry) r0.next();
            if (((Number) r7.getValue()).longValue() >= 1000) goto L22;
            if (((Number) r7.getValue()).longValue() <= 0) goto L19;
            r7.setValue(0L);
        L26:
            r6 = true;
            goto L19
        L22:
            r7.setValue(Long.valueOf(((Number) r7.getValue()).longValue() - 1000));
            goto L26
        L27:
            if (r6 == false) goto L32;
            Iterator<rj0.h.a> r1 = r15.e.iterator();
        L30:
            if (r1.hasNext() == false) goto L41;
            r1.next().v3(r15.d);
            goto L30
        L41:
            return;
        L32:
            return;
        L5:
            if (r14.j() == false) goto L17;
            if (r14.b == 0) goto L17;
            long r8 = r14.c;
            if (r8 > 0) goto L12;
            ALogger.e("ttlive_link_paid", "selfRemainingTime=" + r14.c + " invalid");
            goto L17
        L12:
            r14.c = r8 - 1000;
            Iterator<rj0.h.a> r2 = r14.e.iterator();
        L14:
            if (r2.hasNext() == false) goto L16;
            r2.next().B0(r14.c);
            goto L14
        L16:
            r14.h(true, null);
            goto L17
        }
    }

    static {
    }

    @Override // rj0.h
    public final void d() {
        this.f = null;
    }

    @Override // rj0.h
    public final boolean b() {
        if (this.b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g() {
        com.bytedance.android.live.core.utils.rxutils.j.a r0 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.a = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }

    public final void i() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e.clear();
    }

    public final boolean j() {
        if (this.g == false) goto L6;
        return false;
    L6:
        if (hd0.c.f().h() == true) goto L11;
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.isEngineOn() == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // rj0.h
    public final long a() {
        return this.c;
    }

    @Override // rj0.h
    public final Map<String, Long> c() {
        return this.d;
    }

    public e(boolean r1) {
        this.g = r1;
        this.d = new HashMap();
        this.e = new CopyOnWriteArrayList();
    }

    @Override // rj0.h
    public final void e(rj0.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.add(r2);
    }

    @Override // rj0.h
    public final void f(rj0.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.remove(r2);
    }

    public final void k(List<? extends ILinkPlayerInfoBridge> r16) {
        Intrinsics.checkNotNullParameter(r16, "list");
        if (j() == false) goto L28;
        Iterator<T> r2 = r16.iterator();
    L6:
        Object r8 = null;
        if (r2.hasNext() == false) goto L14;
        Object r7 = r2.next();
        IBaseUser r9 = ((ILinkPlayerInfoBridge) r7).getUser();
        if (r9 == null) goto L12;
        r8 = r9.getIdString();
    L12:
        if (Intrinsics.areEqual(r8, je0.d.b0()) == false) goto L6;
        r8 = r7;
    L14:
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r8;
        if (r10 == null) goto L28;
        long r11 = r10.getExpectLeaveTime();
        this.b = r11;
        if (r11 == 0) goto L28;
        long r12 = fj0.e.m(r10);
        long r13 = 1000;
        long r14 = (r11 - r12) * r13;
        this.c = r14;
        if (r14 > 0) goto L23;
        this.c = 0;
    L23:
        Iterator<rj0.h.a> r3 = this.e.iterator();
    L25:
        if (r3.hasNext() == false) goto L27;
        r3.next().B0(this.c);
        goto L25
    L27:
        h(false, Long.valueOf(r12));
        ALogger.e("ttlive_link_paid", "onlineListChange selfRemainingTime=" + (this.c / r13) + "s  selfExpectLeaveTime=" + r11);
    L28:
        HashMap r4 = new HashMap();
        Iterator<T> r1 = r16.iterator();
    L30:
        if (r1.hasNext() == false) goto L41;
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r1.next();
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L30;
        String r15 = r6.getIdString();
        if (r15 == null) goto L30;
        long r17 = r5.getExpectLeaveTime();
        long r18 = fj0.e.m(r5);
        if (r17 == 0) goto L30;
        long r19 = (r17 - r18) * ((long) 1000);
        if (r19 > 0) goto L40;
        r19 = 0;
    L40:
        r4.put(r15, Long.valueOf(r19));
        goto L30
    L41:
        Iterator r20 = r4.entrySet().iterator();
    L43:
        if (r20.hasNext() == false) goto L45;
        Map.Entry r21 = (Map.Entry) r20.next();
        ALogger.i("ttlive_link_paid", "updateCountDown uid=" + ((String) r21.getKey()) + " remaining=" + ((Number) r21.getValue()).longValue());
        goto L43
    L45:
        ((HashMap) this.d).clear();
        ((HashMap) this.d).putAll(r4);
        Iterator<rj0.h.a> r22 = this.e.iterator();
    L47:
        if (r22.hasNext() == false) goto L49;
        r22.next().v3(this.d);
        goto L47
    }

    public final void h(boolean r6, Long r7) {
        long r0 = this.c;
        if (r0 >= 1000) goto L16;
        if (r6 == false) goto L6;
        int r8 = fj0.d.a;
        fj0.d.b(r0, this.b);
    L8:
        if (je0.d.A() == false) goto L12;
        rj0.l.n2.getClass();
        rj0.l r9 = rj0.l.a.a();
        if (r9 == null) goto L17;
        rj0.l.b.d(r9, 203, true, true, 8);
        return;
    L17:
        return;
    L12:
        rj0.l.n2.getClass();
        rj0.l r10 = rj0.l.a.a();
        if (r10 == null) goto L19;
        rj0.l.b.d(r10, 203, true, false, 8);
        return;
    L19:
        return;
    L6:
        int r11 = fj0.d.a;
        fj0.d.a(r0, this.b, r7);
        goto L8
    }
}
