package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.b1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i12.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTrayMessageManager implements WeakHandler.IHandler {
    public static GiftTrayMessageManager r;
    public final List<NormalGiftMessage> a;
    public final Map<String, NormalGiftMessage> b;
    public final List<NormalGiftMessage> c;
    public final Map<String, NormalGiftMessage> d;
    public final Map<String, NormalGiftMessage> e;
    public final Map<String, HashSet<NormalGiftMessage>> f;
    public NormalGiftMessage g;
    public NormalGiftMessage h;
    public s02.c i;
    public boolean j;
    public y k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final boolean p;
    public final d q;

    public static final class a {
        public static GiftTrayMessageManager a() {
            if (GiftTrayMessageManager.r == null) goto L5;
        L15:
            GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
            Intrinsics.checkNotNull(r0);
            return r0;
        L5:
            monitor-enter(GiftTrayMessageManager.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (GiftTrayMessageManager.r != null) goto L9;
            GiftTrayMessageManager.r = new GiftTrayMessageManager();     // Catch: Throwable -> L12
        L9:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(GiftTrayMessageManager.class);
            goto L15
        }
    }

    public static final class b extends d {
        public final c c;
        public final e d;
        public long e;
        public long f;

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final void a() {
            this.c.getClass();
            this.d.a();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public void update() {
            this.c.update();
            this.d.update();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final NormalGiftMessage b() {
            long r0 = SystemClock.uptimeMillis();
            NormalGiftMessage r2 = this.c.b();
            long r3 = SystemClock.uptimeMillis();
            List<NormalGiftMessage> r5 = this.a;
            if (r5.isEmpty() == true) goto L9;
            ArrayList r6 = new ArrayList();
            int r7 = new Random().nextInt(r5.size());
            int r8 = r5.size();
            int r9 = 0;
        L6:
            if (r9 >= r8) goto L8;
            ListProtector.add(r6, r9, ListProtector.get(r5, (r9 + r7) % r5.size()));
            r9 = r9 + 1;
            goto L6
        L8:
            r5 = r6;
        L9:
            e r10 = this.d;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r5, "list");
            r10.a = r5;
            long r11 = SystemClock.uptimeMillis();
            NormalGiftMessage r13 = this.d.b();
            long r14 = SystemClock.uptimeMillis();
            if (r13 != null) goto L12;
            d.c("getHighMessage optimize null");
        L15:
            return r2;
        L12:
            if (r13 != r2) goto L14;
            long r4 = r3 - r0;
            this.e += r4;
            long r15 = r14 - r11;
            this.f += r15;
            d.c("getHighMessage optimize success:" + r4 + " vs " + r15);
            d.c("getHighMessage optimize total duration:" + this.e + " vs " + this.f);
            goto L15
        L14:
            d.c("getHighMessage optimize fail");
            goto L15
        }

        public b(List<NormalGiftMessage> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            super(r2, r3);
            this.c = new c(r2, r3);
            this.d = new e(r2, r3);
        }
    }

    public static final class c extends d {
        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public void update() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final NormalGiftMessage b() {
            CollectionsKt.sort(this.a);
            return (NormalGiftMessage) CollectionsKt.first(this.a);
        }

        public c(List r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            super(r2, 500);
        }

        public c(List<NormalGiftMessage> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            super(r2, r3);
        }
    }

    public static abstract class d {
        public List<NormalGiftMessage> a;
        public final int b;

        public abstract void a();

        public abstract NormalGiftMessage b();

        public abstract void update();

        public static void c(String r1) {
            Intrinsics.checkNotNullParameter(r1, "msg");
            if (v.a() == false) goto L6;
            GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
            jy0.b.a("GiftTrayMessageManager", r1);
            return;
        }

        public d(List<NormalGiftMessage> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e extends d {
        public long c;
        public NormalGiftMessage d;
        public long e;
        public long f;
        public long g;
        public final boolean h;

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final void a() {
            this.d = null;
            this.e = 0;
            this.c = 0;
            this.g = 0;
            this.f = 0;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final NormalGiftMessage b() {
            if (this.e <= this.c) goto L7;
            NormalGiftMessage r0 = this.d;
            if (r0 == null) goto L7;
        L8:
            int r1 = 1;
            if (r0 == null) goto L11;
            this.g++;
        L30:
            this.f++;
            StringBuilder r2 = new StringBuilder("getHighMessage cache ");
            if (r1 == 0) goto L33;
            String r3 = "success";
        L34:
            r2.append(r3);
            r2.append(" size=");
            r2.append(this.a.size());
            r2.append(" rate:");
            r2.append(this.g);
            r2.append('/');
            r2.append(this.f);
            d.c(r2.toString());
            return r0;
        L33:
            r3 = "failed";
            goto L34
        L11:
            if (this.h == true) goto L13;
        L27:
            CollectionsKt.sort(this.a);
        L28:
            r0 = (NormalGiftMessage) CollectionsKt.first(this.a);
            this.d = r0;
            this.e = SystemClock.uptimeMillis();
            r1 = 0;
            goto L30
        L13:
            if (this.a.size() >= (this.b - 2)) goto L27;
            List<NormalGiftMessage> r4 = this.a;
            int r5 = com.bytedance.android.livesdk.gift.platform.business.tray2.a.a;
            Intrinsics.checkNotNullParameter(r4, "list");
            if (r4.isEmpty() == true) goto L28;
            if (r4.size() == 1) goto L28;
            Comparable r6 = (Comparable) CollectionsKt.first(r4);
            Comparable r7 = (Comparable) CollectionsKt.first(r4);
            int r8 = r4.size();
            int r9 = 0;
        L20:
            if (r1 >= r8) goto L25;
            Comparable r10 = (Comparable) ListProtector.get(r4, r1);
            if (r10.compareTo(r6) >= 0) goto L24;
            r9 = r1;
            r6 = r10;
        L24:
            r1 = r1 + 1;
            goto L20
        L25:
            if (r9 == 0) goto L28;
            Comparable r11 = (Comparable) CollectionsKt.first(r4);
            ListProtector.set(r4, 0, r6);
            ListProtector.set(r4, r9, r11);
        L7:
            r0 = null;
            goto L8
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public void update() {
            this.c = SystemClock.uptimeMillis();
        }

        public e(List r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            super(r2, r3);
            this.h = true;
        }
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    public final void c() {
        ((HashMap) this.b).clear();
        ((ArrayList) this.a).clear();
        ((HashMap) this.d).clear();
        ((ArrayList) this.c).clear();
        this.q.a();
        ((LinkedHashMap) this.e).clear();
        ((LinkedHashMap) this.f).clear();
        this.j = true;
    }

    public final NormalGiftMessage d() {
        if (((ArrayList) this.a).size() <= 0) goto L6;
        CollectionsKt.sort(this.a);
        return (NormalGiftMessage) CollectionsKt.first(this.a);
    L6:
        if (((ArrayList) this.c).size() > 0) goto L11;
        return null;
    L11:
        return this.q.b();
    }

    public final int e() {
        return ((Number) com.bytedance.android.livesdk.gift.platform.business.e.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[0])).intValue();
    }

    public final int f() {
        return ((ArrayList) this.a).size() + ((ArrayList) this.c).size();
    }

    public final void m() {
        if (this.m == true) goto L7;
        if (this.n == true) goto L7;
    L11:
        if (this.l == false) goto L14;
        ALogger.d("PauseAnim", "tryConsumePriorityMessage return due to isScrolling");
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "isScrolling is true, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.e("isScrolling:true");
        return;
    L14:
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        if (com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getNeedShowGiftEffectSwitch() == true) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "needShowGiftEffectSwitch is false, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.e("needShowGiftEffectSwitch:false");
        return;
    L19:
        if (com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGiftTraySwitch() == true) goto L23;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "getGiftTraySwitch is false, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.e("getGiftTraySwitch:false");
        return;
    L23:
        if (com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGiftTraySwitch() == true) goto L27;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "needShowGiftTraySwitch is false, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.e("needShowGiftEffectSwitch:false");
        return;
    L27:
        if (this.m == false) goto L30;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "isBackground  is true, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.e("isBackground:true");
        return;
    L30:
        NormalGiftMessage r1 = d();
        if (r1 == null) goto L33;
        j3 r2 = r1.D;
    L34:
        if (r2 == null) goto L42;
        j3 r3 = r1.D;
        if (r3 == null) goto L38;
        long r4 = r3.getEndTime();
    L40:
        if (r4 >= (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L42;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GiftTrayMessageManager", "消息过期丢弃，message id is " + r1.t.getCommonData().getMessageId() + ", isLocal is " + r1.v);
        i(r1, false);
        m();
        goto L42
    L38:
        r4 = Long.MAX_VALUE;
    L42:
        if (r1 == null) goto L47;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.g(Long.valueOf(r1.a), "run onConsumeMessage", GiftTrayMessageManager$tryConsumePriorityMessage$1$1.INSTANCE);
        y r5 = this.k;
        if (r5 == null) goto L46;
        r5.Lc(r1);
        goto L47
    L46:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftTrayMessageManager", "mListener is null ");
    L47:
        if (r1 == null) goto L49;
        return;
    L49:
        if (f() == 0) goto L53;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "tryConsumePriorityMessage: message is null " + f());
        return;
    L53:
        return;
    L33:
        r2 = null;
    L7:
        if (((b1) LiveInfraSettingKeys.LIVE_ANIMATION_LEAK.getValue()).giftTray == false) goto L11;
        ALogger.d("LiveAnimationLeak", "tryConsumePriorityMessage isBackground=" + this.m + ", isClear=" + this.n);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "isBackground | isClear is true, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.e("isBackground|isClear:true");
    }

    public GiftTrayMessageManager() {
        this.a = new ArrayList();
        this.b = new HashMap();
        ArrayList r0 = new ArrayList();
        this.c = r0;
        this.d = new HashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.j = true;
        new WeakHandler(this);
        ReadOnlyProperty r2 = com.bytedance.android.livesdk.gift.platform.business.e.F;
        KProperty[] r3 = com.bytedance.android.livesdk.gift.platform.business.e.a;
        this.p = ((Boolean) r2.getValue(null, r3[30])).booleanValue();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.c.getValue(null, r3[1])).booleanValue() == true) goto L5;
        d r1 = new c(r0);
    L11:
        this.q = r1;
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.h.getValue(null, r3[6])).booleanValue() == true) goto L7;
    L9:
        r1 = new e(r0, e());
        goto L11
    L7:
        if (v.a() == false) goto L9;
        r1 = new b(r0, e());
        goto L11
    }

    public final int n() {
        NormalGiftMessage r0 = d();
        if (r0 == null) goto L66;
        NormalGiftMessage r1 = this.g;
        long r3 = 0;
        if (r1 != null) goto L7;
    L12:
        Boolean r5 = null;
        if (r1 == null) goto L15;
        Boolean r2 = Boolean.valueOf(r1.v);
    L16:
        NormalGiftMessage r6 = this.h;
        if (r6 == null) goto L20;
        r5 = Boolean.valueOf(r6.v);
    L20:
        if (Intrinsics.areEqual(r2, r5) == false) goto L48;
        NormalGiftMessage r4 = this.g;
        if (r4 == null) goto L24;
        long r7 = r4.getTotalMoney();
    L25:
        NormalGiftMessage r8 = this.h;
        if (r8 == null) goto L28;
        long r9 = r8.getTotalMoney();
    L30:
        if (r7 <= r9) goto L48;
    L31:
        boolean r10 = r0.v;
        if (r10 == false) goto L37;
        NormalGiftMessage r11 = this.h;
        if (r11 == null) goto L37;
        if (r11.v == true) goto L37;
    L47:
        return 1;
    L37:
        if (r10 == true) goto L69;
        NormalGiftMessage r13 = this.h;
        if (r13 != null) goto L41;
        return 0;
    L41:
        if (r13.v == true) goto L71;
        long r14 = r0.getTotalMoney();
        NormalGiftMessage r15 = this.h;
        if (r15 == null) goto L46;
        r3 = r15.getTotalMoney();
    L46:
        if (r14 > r3) goto L47;
        return 0;
    L71:
        return 0;
    L69:
        return 0;
    L28:
        r9 = 0;
        goto L30
    L24:
        r7 = 0;
    L48:
        boolean r16 = r0.v;
        if (r16 == false) goto L54;
        NormalGiftMessage r17 = this.g;
        if (r17 == null) goto L54;
        if (r17.v == true) goto L54;
        return 2;
    L54:
        if (r16 == true) goto L73;
        NormalGiftMessage r18 = this.g;
        if (r18 != null) goto L58;
        return 0;
    L58:
        if (r18.v == true) goto L75;
        long r19 = r0.getTotalMoney();
        NormalGiftMessage r20 = this.g;
        if (r20 == null) goto L63;
        r3 = r20.getTotalMoney();
    L63:
        if (r19 <= r3) goto L76;
        return 2;
    L76:
        return 0;
    L75:
        return 0;
    L73:
        return 0;
    L15:
        r2 = null;
        goto L16
    L7:
        if (r1.v != true) goto L12;
        NormalGiftMessage r21 = this.h;
        if (r21 == null) goto L12;
        if (r21.v == false) goto L31;
    L66:
        return 0;
    }

    public static void k(NormalGiftMessage r4) {
        if (r4 != null) goto L4;
    L6:
        if (r4 == null) goto L9;
        r4.x(r4.m + ((long) r4.n));
        r4.n = 0;
        return;
    L9:
        return;
    L4:
        if (r4.v != true) goto L6;
    }

    public final void a(NormalGiftMessage r4) {
        r4.h = System.currentTimeMillis();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.d(Long.valueOf(r4.a), "GiftTrayMessageManager  addMessage ");
        if (r4.v == false) goto L18;
        if (e() != (-1)) goto L7;
    L12:
        ((ArrayList) this.a).add(r4);
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L15;
    L16:
        ((HashMap) this.b).put(r4.u(), r4);
    L34:
        if (this.f.containsKey(r4.v()) == true) goto L36;
        this.f.put(r4.v(), new HashSet());
    L36:
        HashSet r0 = (HashSet) ((LinkedHashMap) this.f).get(r4.v());
        if (r0 == null) goto L40;
        r0.add(r4);
        return;
    L40:
        return;
    L15:
        if (b02.a.b(r4) == false) goto L34;
    L7:
        if (((ArrayList) this.a).size() < e()) goto L12;
        NormalGiftMessage r1 = (NormalGiftMessage) CollectionsKt.last(this.a);
        if (r1.h(r4) != 1) goto L11;
        i(r1, true);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "remove one message self size:" + ((ArrayList) this.a).size());
        goto L12
    L11:
        return;
    L18:
        if (this.o == false) goto L21;
        return;
    L21:
        if (e() != (-1)) goto L23;
    L28:
        ((ArrayList) this.c).add(r4);
        this.q.update();
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L31;
    L32:
        ((HashMap) this.d).put(r4.u(), r4);
        goto L34
    L31:
        if (b02.a.b(r4) == false) goto L34;
    L23:
        if (((ArrayList) this.c).size() < e()) goto L28;
        NormalGiftMessage r2 = (NormalGiftMessage) CollectionsKt.last(this.c);
        if (r2.h(r4) != 1) goto L27;
        i(r2, true);
        goto L28
    }

    public final void b(NormalGiftMessage r7) {
        if (r7 == null) goto L46;
        Map<String, HashSet<NormalGiftMessage>> r0 = this.f;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        HashSet r2 = (HashSet) r1.get(r7.v());
        if (r2 == null) goto L47;
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L27;
        NormalGiftMessage r4 = (NormalGiftMessage) r3.next();
        boolean r5 = false;
        if (r4 == null) goto L20;
        if (Intrinsics.areEqual(this.g, r4) == false) goto L14;
    L19:
        r5 = true;
        goto L20
    L14:
        if (Intrinsics.areEqual(this.h, r4) == true) goto L19;
        Map<String, NormalGiftMessage> r6 = this.b;
        HashMap r8 = (HashMap) r6;
        if (r8.containsKey(r4.u()) == true) goto L19;
        Map<String, NormalGiftMessage> r9 = this.d;
        HashMap r10 = (HashMap) r9;
        if (r10.containsKey(r4.u()) == true) goto L19;
    L20:
        if (r5 == false) goto L7;
        StringBuilder r11 = new StringBuilder("can't remove since wait groupId: ");
        r11.append(r4.l);
        r11.append(" + giftId: ");
        h2 r13 = r4.w;
        if (r13 == null) goto L24;
        Long r14 = Long.valueOf(r13.getId());
    L25:
        r11.append(r14);
        jy0.b.a("GiftTrayMessageManager", r11.toString());
        return;
    L24:
        r14 = null;
        goto L25
    L27:
        Iterator r15 = r2.iterator();
    L29:
        if (r15.hasNext() == false) goto L33;
        NormalGiftMessage r16 = (NormalGiftMessage) r15.next();
        if (this.e.containsKey(r16.u()) == false) goto L29;
        this.e.remove(r16.u());
        goto L29
    L33:
        HashSet<NormalGiftMessage> r17 = this.f.remove(r7.v());
        return;
    L47:
        return;
    }

    public final void g(NormalGiftMessage r14) {
        if (r14 == null) goto L150;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a r1 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e;
        r1.b.d(Long.valueOf(r14.a), "GiftTrayMessageManager newMessage run");
        if ((r14.t instanceof o7) == true) goto L7;
    L18:
        Object r3 = null;
        if (b02.a.b(r14) == true) goto L40;
        if ((r14 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L40;
        if (r14.p == false) goto L25;
        return;
    L25:
        i12.e r2 = o.b();
        if (r2 == null) goto L28;
        Object r4 = m.e.d(r2, GiftDataStorageService.class);
    L29:
        GiftDataStorageService r5 = (GiftDataStorageService) r4;
        if (r5 == null) goto L32;
        r5.d += r14.k * r14.m;
    L32:
        i12.e r6 = o.b();
        if (r6 == null) goto L35;
        r3 = m.e.d(r6, GiftDataStorageService.class);
    L35:
        GiftDataStorageService r7 = (GiftDataStorageService) r3;
        if (r7 == null) goto L38;
        r7.c += r14.k * r14.m;
    L38:
        a(r14);
        goto L150
    L28:
        r4 = null;
    L40:
        if ((r14 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L42;
        a(r14);
        goto L150
    L42:
        List<n3> r8 = r14.F;
        if (r8 != null) goto L45;
    L48:
        boolean r9 = true;
    L49:
        if (r9 == true) goto L56;
        if (r14.p == true) goto L53;
    L54:
        a(r14);
        goto L150
    L53:
        if (((Boolean) LiveInfraSettingKeys.FORCE_ALLOW_REPEAT_END_SHOW_TRAY.getValue()).booleanValue() == false) goto L150;
    L56:
        if (r14.p == true) goto L63;
        j3 r10 = r14.D;
        if (r10 == null) goto L63;
        if (r10.getEndTime() >= (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L63;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GiftTrayMessageManager", "消息过期丢弃，message id is " + r14.t.getCommonData().getMessageId() + ", isLocal is " + r14.v);
    L63:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.H.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[32])).booleanValue() == false) goto L107;
        NormalGiftMessage r11 = this.g;
        if (r11 == null) goto L67;
        String r13 = r11.u();
    L68:
        NormalGiftMessage r15 = this.h;
        if (r15 == null) goto L71;
        r3 = r15.u();
    L71:
        String r16 = r14.u();
        if (Intrinsics.areEqual(r13, r16) == false) goto L75;
        NormalGiftMessage r17 = this.g;
        Intrinsics.checkNotNull(r17);
        o(r17, r14);
        goto L150
    L75:
        if (Intrinsics.areEqual(r3, r16) == false) goto L78;
        NormalGiftMessage r18 = this.h;
        Intrinsics.checkNotNull(r18);
        o(r18, r14);
        goto L150
    L78:
        if (((HashMap) this.b).containsKey(r16) == false) goto L83;
        NormalGiftMessage r19 = (NormalGiftMessage) ((HashMap) this.b).get(r16);
        if (r19 == null) goto L150;
        o(r19, r14);
        goto L150
    L83:
        if (((HashMap) this.d).containsKey(r16) == false) goto L89;
        NormalGiftMessage r20 = (NormalGiftMessage) ((HashMap) this.d).get(r16);
        if (r20 == null) goto L87;
        o(r20, r14);
    L87:
        this.q.update();
        goto L150
    L89:
        if (this.e.containsKey(r16) == false) goto L98;
        NormalGiftMessage r21 = (NormalGiftMessage) ((LinkedHashMap) this.e).get(r16);
        if (r14.p == false) goto L95;
        if (r21 == null) goto L94;
        l(r21, r14);
    L94:
        this.e.remove(r16);
        goto L150
    L95:
        if (r21 == null) goto L150;
        o(r21, r14);
        this.e.remove(r16);
        a(r21);
        goto L150
    L98:
        if (r14.p == true) goto L100;
    L106:
        a(r14);
        goto L150
    L100:
        if ((r14 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L106;
        s02.c r23 = this.i;
        if (r23 == null) goto L104;
        r23.a(r14.e, r14.q, r14.b, r14.r(), r14.m);
    L104:
        r1.b.f(Long.valueOf(r14.a), "is IGift End");
        return;
    L67:
        r13 = null;
        goto L68
    L107:
        NormalGiftMessage r24 = this.g;
        if (r24 == null) goto L110;
        String r25 = r24.u();
    L112:
        if (Intrinsics.areEqual(r25, r14.u()) == false) goto L114;
        NormalGiftMessage r26 = this.g;
        Intrinsics.checkNotNull(r26);
        o(r26, r14);
        goto L150
    L114:
        NormalGiftMessage r27 = this.h;
        if (r27 == null) goto L118;
        r3 = r27.u();
    L118:
        if (Intrinsics.areEqual(r3, r14.u()) == false) goto L121;
        NormalGiftMessage r28 = this.h;
        Intrinsics.checkNotNull(r28);
        o(r28, r14);
        goto L150
    L121:
        if (((HashMap) this.b).containsKey(r14.u()) == false) goto L126;
        NormalGiftMessage r29 = (NormalGiftMessage) ((HashMap) this.b).get(r14.u());
        if (r29 == null) goto L150;
        o(r29, r14);
        goto L150
    L126:
        if (((HashMap) this.d).containsKey(r14.u()) == false) goto L132;
        NormalGiftMessage r30 = (NormalGiftMessage) ((HashMap) this.d).get(r14.u());
        if (r30 == null) goto L130;
        o(r30, r14);
    L130:
        this.q.update();
        goto L150
    L132:
        if (this.e.containsKey(r14.u()) == false) goto L141;
        NormalGiftMessage r31 = (NormalGiftMessage) ((LinkedHashMap) this.e).get(r14.u());
        if (r14.p == false) goto L138;
        if (r31 == null) goto L137;
        l(r31, r14);
    L137:
        this.e.remove(r14.u());
        goto L150
    L138:
        if (r31 == null) goto L150;
        o(r31, r14);
        this.e.remove(r14.u());
        a(r31);
        goto L150
    L141:
        if (r14.p == true) goto L143;
    L149:
        a(r14);
        goto L150
    L143:
        if ((r14 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L149;
        s02.c r33 = this.i;
        if (r33 == null) goto L147;
        r33.a(r14.e, r14.q, r14.b, r14.r(), r14.m);
    L147:
        r1.b.f(Long.valueOf(r14.a), "is IGift End");
        return;
    L110:
        r25 = null;
        goto L112
    L45:
        if (r8.isEmpty() == true) goto L48;
        r9 = false;
        goto L49
    L7:
        if (r14.r().isBannedInTray() == false) goto L18;
        if (r14.r().isBannedInChat() == false) goto L11;
        return;
    L11:
        if (r14.p == true) goto L13;
        return;
    L13:
        if ((r14 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L159;
        s02.c r34 = this.i;
        if (r34 == null) goto L160;
        r34.a(r14.e, r14.q, r14.b, r14.r(), r14.m);
        return;
    L160:
        return;
    L159:
        return;
    L150:
        if (r14 != null) goto L153;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "newMessage is null");
    L153:
        if (this.j == false) goto L155;
        m();
        return;
    L155:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "mHasIdleTray is false,skip.. queue size:" + f());
    }

    public final void h(gm2.d r2) {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i<k> r1 = r0.getMessageDispatcher();
        if (r1 == null) goto L9;
        k r3 = (k) r1.getValue();
        if (r3 == null) goto L9;
        NormalGiftMessage r4 = r3.a(r2);
    L10:
        g(r4);
        return;
    L9:
        r4 = null;
        goto L10
    }

    public final void j(NormalGiftMessage r5) {
        if (Intrinsics.areEqual(this.h, r5) == false) goto L6;
        this.h = null;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        if ((r5 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L15;
        if (b02.a.b(r5) == true) goto L15;
        return;
    L15:
        if (r5.n != 0) goto L29;
        if (r5.p == false) goto L19;
    L27:
        b(r5);
        return;
    L19:
        if (this.e.size() <= e()) goto L23;
        if (((Boolean) nz1.a.P.getValue(null, nz1.a.a[40])).booleanValue() == true) goto L27;
    L23:
        if (r5.P == true) goto L25;
    L26:
        this.e.put(r5.u(), r5);
        goto L27
    L25:
        if (r5.Q == true) goto L27;
    L29:
        if (r5.P == false) goto L34;
        if (r5.Q == false) goto L34;
        return;
    L34:
        if (r5.v == false) goto L36;
        ((ArrayList) this.a).add(r5);
        Map<String, NormalGiftMessage> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        r1.put(r5.u(), r5);
        return;
    L36:
        ((ArrayList) this.c).add(r5);
        Map<String, NormalGiftMessage> r2 = this.d;
        HashMap r3 = (HashMap) r2;
        r3.put(r5.u(), r5);
        this.q.update();
        return;
    L6:
        if (Intrinsics.areEqual(this.g, r5) == false) goto L8;
        this.g = null;
        goto L8
    }

    public final void i(NormalGiftMessage r4, boolean r5) {
        if (r4 == null) goto L29;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.d(Long.valueOf(r4.a), "removeOneMessage");
        if (r5 == false) goto L18;
        if (this.p == false) goto L18;
        int r6 = ((ArrayList) this.a).lastIndexOf(r4);
        if (r6 != (-1)) goto L10;
    L12:
        int r7 = ((ArrayList) this.c).lastIndexOf(r4);
        if (r7 != (-1)) goto L15;
    L23:
        Map<String, NormalGiftMessage> r8 = this.b;
        HashMap r9 = (HashMap) r8;
        if (r9.containsKey(r4.u()) == false) goto L26;
        Map<String, NormalGiftMessage> r10 = this.b;
        HashMap r11 = (HashMap) r10;
        r11.remove(r4.u());
    L26:
        Map<String, NormalGiftMessage> r13 = this.d;
        HashMap r14 = (HashMap) r13;
        if (r14.containsKey(r4.u()) == false) goto L29;
        Map<String, NormalGiftMessage> r15 = this.d;
        HashMap r16 = (HashMap) r15;
        r16.remove(r4.u());
        goto L29
    L15:
        if (r7 >= ((ArrayList) this.c).size()) goto L23;
        ListProtector.remove(this.c, r7);
        this.q.update();
        goto L23
    L10:
        if (r6 >= ((ArrayList) this.a).size()) goto L12;
        ListProtector.remove(this.a, r6);
    L18:
        if (((ArrayList) this.a).contains(r4) == false) goto L21;
        ((ArrayList) this.a).remove(r4);
    L21:
        if (((ArrayList) this.c).contains(r4) == false) goto L23;
        ((ArrayList) this.c).remove(r4);
        this.q.update();
    L29:
        b(r4);
    }

    public final void l(NormalGiftMessage r10, NormalGiftMessage r11) {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.f(Long.valueOf(r11.a), "tag end");
        r10.p = true;
        r10.q = r11.q;
        HashSet r1 = (HashSet) ((LinkedHashMap) this.f).get(r11.v());
        if (r1 == null) goto L8;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        ((NormalGiftMessage) r2.next()).p = true;
    L8:
        b(r10);
        i12.e r0 = o.b();
        if (r0 == null) goto L11;
        Object r3 = m.e.d(r0, GiftDataStorageService.class);
    L12:
        GiftDataStorageService r4 = (GiftDataStorageService) r3;
        if (r4 == null) goto L16;
        r4.c += r11.k * r11.m;
    L16:
        if ((r11 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L25;
        s02.c r5 = this.i;
        if (r5 == null) goto L21;
        r5.a(r11.e, r11.q, r11.b, r11.r(), r11.m);
    L21:
        if (r10.v == false) goto L26;
        d0.m(r11);
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final void o(NormalGiftMessage r7, NormalGiftMessage r8) {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.f(Long.valueOf(r8.a), "GiftTrayMessageManager  updateMessage ");
        r7.h = System.currentTimeMillis();
        boolean r0 = r7.p;
        if (r0 == true) goto L5;
    L7:
        if (r0 == false) goto L9;
    L11:
        if (r0 == false) goto L13;
        return;
    L13:
        if (r8.p == true) goto L27;
        r7.r().setTrayInfo(r8.r().getTrayInfo());
        if (Intrinsics.areEqual(r7, this.g) == false) goto L17;
    L22:
        r7.w(r8);
        return;
    L17:
        if (Intrinsics.areEqual(r7, this.h) == true) goto L22;
        if (r7.v == true) goto L22;
        r7.x(r7.m + ((long) r7.n));
        r7.n = 0;
        r7.w(r8);
        return;
    L27:
        return;
    L9:
        if (r8.p == false) goto L11;
        l(r7, r8);
        return;
    L5:
        if (r8.p == true) goto L7;
        r7.p = false;
        r7.q = BuildConfig.FLAVOR;
        r7.w(r8);
    }
}
