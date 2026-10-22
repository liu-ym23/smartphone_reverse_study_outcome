package r02;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ca0.j;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revenue.common.d0;
import com.bytedance.android.livesdk.config.bz;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GamePlatformGiftCombView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TogetherComboView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.condition.RevConditionType;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import i12.o;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import n12.f;
import s02.c;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final String y = null;
    public NormalGiftMessage a;
    public boolean b;
    public boolean c;
    public final FrameLayout d;
    public BaseNormalGiftCombView e;
    public final int f;
    public int g;
    public int h;
    public final Context i;
    public s02.b j;
    public c k;
    public int l;
    public final Map<String, Object> m;
    public final List<Integer> n;
    public Disposable o;
    public Disposable p;
    public final f q;
    public boolean r;
    public boolean s;
    public boolean t;
    public ViewGroup u;
    public final boolean v;
    public int w;
    public final C0268b x;

    public class a implements Function1<h, Unit> {
        public a() {
        }

        public final Object invoke(Object r2) {
            ((h) r2).f = true;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: r02.b$b, reason: collision with other inner class name */
    public class C0268b implements s02.a {
        public final /* synthetic */ b a;

        /* JADX INFO: renamed from: r02.b$b$a */
        public class a implements Consumer<Long> {
            public final /* synthetic */ C0268b a;

            public a(C0268b r1) {
                this.a = r1;
            }

            public final void accept(Object r2) throws Exception {
                Long r3 = (Long) r2;
                b r4 = this.a.a;
                r4.c = false;
                r4.b = true;
                s02.b r0 = r4.j;
                if (r0 == null) goto L6;
                r0.a(r4.a);
                return;
            }
        }

        /* JADX INFO: renamed from: r02.b$b$b, reason: collision with other inner class name */
        public class C0269b implements Consumer<Boolean> {
            public final /* synthetic */ C0268b a;

            public C0269b(C0268b r1) {
                this.a = r1;
            }

            public final void accept(Object r2) throws Exception {
                if (((Boolean) r2).booleanValue() == false) goto L8;
                b r3 = this.a.a;
                if (r3.c == false) goto L9;
                b.a(r3);
                return;
            L9:
                return;
            }
        }

        @Override // s02.a
        public final void a() {
            Disposable r0 = this.a.o;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            Disposable r1 = this.a.p;
            if (r1 == null) goto L8;
            r1.dispose();
        L8:
            this.a.c = false;
        }

        @Override // s02.a
        public final void onExit() {
            b r0 = this.a;
            BaseNormalGiftCombView r1 = r0.e;
            if (r1 == null) goto L7;
            r0.d.removeView(r1);
            this.a.e.j();
            b r2 = this.a;
            r2.e = null;
            NormalGiftMessage r3 = r2.a;
            if (r3.m <= 1) goto L7;
            o7 r6 = r3.r();
            long r7 = this.a.a.getTotalMoney();
            long r9 = this.a.a.getTotalCount();
            NormalGiftMessage r13 = this.a.a;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.K(r6, r7, r9, r13.h, r13, true);
        L7:
            Disposable r4 = this.a.o;
            if (r4 == null) goto L10;
            r4.dispose();
        L10:
            Disposable r5 = this.a.p;
            if (r5 == null) goto L13;
            r5.dispose();
        L13:
            boolean r8 = false;
            if (this.a.v == false) goto L16;
        L19:
            boolean r10 = true;
        L20:
            if (r10 == false) goto L27;
            b r11 = this.a;
            GiftTrayMessageManager r14 = GiftTrayMessageManager.r;
            r11.w = GiftTrayMessageManager.a.a().n();
            b r15 = this.a;
            if (r15.w != r15.f) goto L27;
            r15.c = false;
            r15.b = true;
            s02.b r16 = r15.j;
            if (r16 == null) goto L50;
            r16.a(r15.a);
            return;
        L50:
            return;
        L27:
            b r17 = this.a;
            NormalGiftMessage r18 = r17.a;
            if (r18 != null) goto L30;
        L38:
            r17.c = false;
            r17.b = true;
            s02.b r19 = r17.j;
            if (r19 == null) goto L41;
            r19.a(r18);
        L41:
            b r20 = this.a;
            if (r20.s == false) goto L51;
            NormalGiftMessage r21 = r20.a;
            if (r21 != null) goto L46;
        L48:
            com.bytedance.android.livesdk.gift.platform.business.normal.utils.b.b(r21, r20.q);
            return;
        L46:
            if (r21.v == false) goto L48;
            com.bytedance.android.livesdk.gift.platform.business.normal.utils.b.c(r21, r20.q);
            return;
        L51:
            return;
        L30:
            if (r18.n <= 0) goto L38;
            r18.b();
            b r23 = this.a;
            if (l.c() == false) goto L34;
        L35:
            r8 = true;
        L36:
            r23.g(r8);
            return;
        L34:
            if (this.a.d().booleanValue() == false) goto L36;
        L16:
            if (com.bytedance.android.livesdk.gift.util.b.b() != null) goto L19;
            r10 = false;
            goto L20
        }

        @Override // s02.a
        public final void onWaiting() {
            boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
            if (com.bytedance.android.live.revenue.core.util.h.d(j.class).getGiftTraySwitch() == true) goto L5;
            return;
        L5:
            if (com.bytedance.android.live.revenue.core.util.h.d(j.class).getNeedShowGiftEffectSwitch() == false) goto L28;
            this.a.getClass();
            if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L17;
            b r1 = this.a;
            GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
            r1.w = GiftTrayMessageManager.a.a().n();
            b r3 = this.a;
            if (r3.w != r3.f) goto L17;
            Disposable r4 = r3.o;
            if (r4 == null) goto L14;
            r4.dispose();
        L14:
            b r5 = this.a;
            r5.o = Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
            return;
        L17:
            if (b.a(this.a) == false) goto L20;
            return;
        L20:
            if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L27;
            Disposable r6 = this.a.p;
            if (r6 == null) goto L24;
            r6.dispose();
        L24:
            b r7 = this.a;
            r7.p = com.bytedance.android.livesdk.gift.util.b.b().getGiftTrayTempComboUpdateEvent().onEvent().subscribe(new C0269b(this));
            return;
        L27:
            return;
        }

        public C0268b(b r1) {
            this.a = r1;
        }
    }

    static {
        y = b.class.getName();
    }

    public static boolean k() {
        k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r0 == null) goto L5;
        DataCenter r1 = r0.getDataCenter();
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[11])).booleanValue() == true) goto L11;
        return false;
    L11:
        if (((Integer) r1.get("cast_game_panel_height_change", 0)).intValue() <= 0) goto L16;
        return true;
    L16:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final void b() {
        NormalGiftMessage r0 = this.a;
        String r2 = y;
        if (r0 != null) goto L5;
    L48:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r2, "checkSpecialEffect mGiftMsg is " + this.a + "  or  mGiftMsg is BigGiftTrayMessage");
        return;
    L5:
        if ((r0 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L48;
        o7 r1 = r0.r();
        if (r1 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        NormalGiftMessage r5 = this.a;
        Map<String, Long> r6 = r5.s;
        long r7 = r5.m * r5.k;
        if (r3 == false) goto L68;
        if (r6 == null) goto L69;
        Set<String> r4 = r6.keySet();
        ArrayList r8 = new ArrayList();
        Iterator<String> r9 = r4.iterator();
    L18:
        if (r9.hasNext() == false) goto L24;
        String r10 = r9.next();
        r8.add(Integer.valueOf(CastIntegerProtector.parseInt(r10)));     // Catch: NumberFormatException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r2, "checkSpecialEffect parseInt " + r10 + " err ");
        goto L18
    L24:
        Collections.sort(r8);
        Iterator r11 = r8.iterator();
        long r13 = -1;
    L26:
        if (r11.hasNext() == false) goto L43;
        int r14 = ((Integer) r11.next()).intValue();
        Iterator r15 = ((ArrayList) this.n).iterator();
        boolean r16 = false;
    L29:
        if (r15.hasNext() == false) goto L34;
        if (((Integer) r15.next()).intValue() != r14) goto L29;
        r16 = true;
        goto L29
    L34:
        if (r7 < r14) goto L26;
        if (r16 == true) goto L26;
        ((ArrayList) this.n).add(Integer.valueOf(r14));
        Long r17 = r6.get(String.valueOf(r14));
        if (r17 == null) goto L40;
        long r18 = r17.longValue();
    L41:
        r13 = r18;
        goto L26
    L40:
        r18 = 0;
        goto L41
    L43:
        if (r13 == (-1)) goto L70;
        jy0.b.d(r2, "触发连发特效， 原giftId=" + this.a.b + ", 触发giftId=" + r13);
        o7 r19 = vh7.f.c(o7.class);
        r19.setCommonData(this.a.r().getCommonData());
        r19.setFromUser(this.a.r().getFromUser());
        r19.setToUser(this.a.r().getToUser());
        r19.setGiftId(r13);
        r19.setGroupId(this.a.l);
        r19.setGroupCount(1);
        r19.setTrayInfo(this.a.r().getTrayInfo());
        r19.setComboCount(1);
        c r20 = this.k;
        if (r20 == null) goto L71;
        r20.c(r19);
        return;
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L10:
        if (r1.isLocal() == false) goto L12;
        r3 = true;
        goto L13
    }

    public final void c() {
        BaseNormalGiftCombView r0 = this.e;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final boolean e() {
        if (this.i.getResources() != null) goto L5;
        return false;
    L5:
        if (this.i.getResources().getConfiguration() != null) goto L7;
        return false;
    L7:
        if (this.i.getResources().getConfiguration().orientation != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public final void h() {
        BaseNormalGiftCombView r0 = this.e;
        if (r0 == null) goto L5;
        this.d.removeView(r0);
        this.e.j();
        this.e = null;
    L5:
        Disposable r1 = this.o;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.p;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.p = null;
        this.o = null;
        this.b = true;
    }

    public final Boolean d() {
        if (e() == true) goto L9;
        if (((Boolean) bz.a.getValue()).booleanValue() == false) goto L9;
        ALogger.d("degrade_opt", "normal gift degrade");
        return Boolean.TRUE;
    L9:
        return Boolean.FALSE;
    }

    public static boolean a(b r4) {
        if (r4.e == null) goto L9;
        NormalGiftMessage r0 = r4.a;
        if (r0 == null) goto L9;
        if (r0.n <= 0) goto L9;
        r0.b();
        r4.e.i();
        r4.b();
        r4.c = false;
        return true;
    L9:
        r4.c = true;
        return false;
    }

    public final void f(NormalGiftMessage r6) {
        NormalGiftMessage r0 = this.a;
        if (r0 != null) goto L5;
    L22:
        ((ArrayList) this.n).clear();
    L23:
        e.d.getClass();
        e.a.C0075a.e.b.g(Long.valueOf(r6.a), "play..." + r6.b, new a());
        this.a = r6;
        g(d().booleanValue());
        NormalGiftMessage r7 = this.a;
        if (r7 == null) goto L26;
        ((HashMap) this.m).put("gift_msg_id", String.valueOf(r7.a));
        ((HashMap) this.m).put("gift_id", String.valueOf(this.a.b));
    L26:
        jy0.b.d("ttlive_gift", this.m.toString());
        return;
    L5:
        if (r0.p == true) goto L22;
        if (r6 == null) goto L23;
        if (r0.l != r6.l) goto L22;
        KProperty[] r1 = s.a;
        i12.e r2 = o.b();
        Object r3 = null;
        if (r2 == null) goto L12;
        Object r4 = m.e.d(r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L14:
        if (((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r4) == null) goto L23;
        i12.e r5 = o.b();
        if (r5 == null) goto L19;
        r3 = m.e.d(r5, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L19:
        if (((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r3).j() == false) goto L23;
        if (r6.v == false) goto L23;
    L12:
        r4 = null;
        goto L14
    }

    public final void g(boolean r19) {
        boolean r1 = true;
        int r2 = 0;
        if (r19 == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        if (com.bytedance.android.live.revenue.core.util.h.d(j.class).getGiftTraySwitch() == true) goto L12;
    L108:
        this.b = true;
        this.c = true;
        return;
    L12:
        if (com.bytedance.android.live.revenue.core.util.h.d(j.class).getNeedShowGiftEffectSwitch() == false) goto L108;
        this.b = false;
        this.c = false;
        BaseNormalGiftCombView r5 = this.e;
        if (r5 == null) goto L17;
        r5.k();
    L36:
        j(this.i);
        if (this.e.getParent() != null) goto L39;
    L41:
        NormalGiftMessage r6 = this.a;
        if (r6 != null) goto L44;
    L54:
        this.e.setShowCombo(r1);
        this.e.setRoomOrientation(this.l);
        NormalGiftMessage r7 = this.a;
        if (r7 == null) goto L58;
        r7.M = this.r;
        this.e.m(r7);
    L58:
        if (this.a.r() != null) goto L60;
    L72:
        BaseNormalGiftCombView r8 = this.e;
        if (r3 == false) goto L75;
        float r9 = 0.0f;
    L76:
        r8.setAlpha(r9);
        BaseNormalGiftCombView r10 = this.e;
        if (r3 == true) goto L80;
        r2 = -this.d.getWidth();
    L80:
        r10.n(r2, (this.d.getHeight() - this.h) - (this.f * this.g));
    L81:
        this.e.setClickListener(this.k);
        this.e.setGiftControllerCallback(this.j);
        BaseNormalGiftCombView r11 = this.e;
        if (r11 != null) goto L84;
    L104:
        this.e.h(this.x, r3);
        b();
        com.bytedance.android.live.revenue.core.util.e.a(vq2.a.class).g7(RevConditionType.SHOW_GIFT_EFFECT);
        if (this.a == null) goto L110;
        this.e.post(new r02.a(this));
        return;
    L110:
        return;
    L84:
        if ((r11 instanceof GamePlatformGiftCombView) == true) goto L104;
        if (this.d == null) goto L104;
        if (l.d(this.r) == false) goto L101;
        if (this.u == null) goto L101;
        NormalGiftMessage r13 = this.a;
        if (r13 == null) goto L101;
        if (r13.r() == null) goto L101;
        if (this.a.r().getTrayInfo() == null) goto L101;
        if (this.a.r().getTrayInfo().getUserHighLayer() == false) goto L101;
    L102:
        this.e.d(this.u);
    L101:
        if (l.e(this.a) == true) goto L102;
        this.d.addView(this.e);
        goto L104
    L75:
        r9 = 1.0f;
        goto L76
    L60:
        if (this.a.r().getTrayInfo() == null) goto L72;
        if (this.a.r().getTrayInfo() == null) goto L72;
        if (this.a.r().getTrayInfo().getTrayPreEffect() == null) goto L72;
        if (this.a.r().getTrayInfo().getTrayPreEffect().getPreEffectImg() == null) goto L72;
        if (this.a.r().getTrayInfo().getTrayPreEffect().getPreEffectImg().isValid() == false) goto L72;
        if (l.f(Integer.valueOf(this.a.r().getTrayInfo().getTrayPreEffect().getPreEffectSource())) == false) goto L72;
        this.e.n((int) this.d.getX(), (this.d.getHeight() - this.h) - (this.f * this.g));
        goto L81
    L44:
        if (b02.a.b(r6) == true) goto L54;
        h2 r14 = u.f(this.a.r());
        if (r14 == null) goto L54;
        if (r14.getType() != 11) goto L50;
    L53:
        r1 = false;
        goto L54
    L50:
        if (r14.getType() == 2) goto L53;
        if (r14.getType() != 8) goto L54;
    L39:
        if ((this.e.getParent() instanceof ViewGroup) == false) goto L41;
        ((ViewGroup) this.e.getParent()).removeView(this.e);
        goto L41
    L17:
        if (k() == false) goto L20;
        this.e = new GamePlatformGiftCombView(this.i, null, 0);
        goto L36
    L20:
        if ((this.a instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L28;
        Context r15 = this.i;
        if (this.s == true) goto L24;
    L26:
        boolean r16 = false;
    L27:
        this.e = new TogetherComboView(r15, null, 0, r16, 16);
        goto L36
    L24:
        if (d0.a(this.r, this.t) == false) goto L26;
        r16 = true;
        goto L27
    L28:
        Context r17 = this.i;
        AttributeSet r18 = null;
        int r110 = 0;
        if (this.s == true) goto L31;
    L33:
        boolean r111 = false;
    L34:
        this.e = new NormalGiftCombViewV2(r17, r18, r110, r111, null, 16);
        goto L36
    L31:
        if (d0.a(this.r, this.t) == false) goto L33;
        r111 = true;
        goto L34
    L5:
        if (l.a() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean i(NormalGiftMessage r13) {
        e.d.getClass();
        e.a.C0075a.e.b.d(Long.valueOf(r13.a), "tryPlayContinueMsg");
        if (this.a != null) goto L6;
        return false;
    L6:
        if (this.b == true) goto L35;
        h2 r0 = u.f(r13.r());
        if (r0 != null) goto L11;
    L13:
        NormalGiftMessage r1 = this.a;
        if (r1 == null) goto L35;
        if (r1.u().equals(r13.u()) == false) goto L35;
        NormalGiftMessage r2 = this.a;
        if (r2.p == true) goto L35;
        long r5 = r13.l;
        if (r5 == 0) goto L28;
        if (r5 != r2.l) goto L28;
    L29:
        boolean r3 = true;
    L31:
        if (r3 == false) goto L35;
        if (r13.p == true) goto L35;
        boolean r4 = true;
    L37:
        if (r4 == false) goto L40;
        this.a.w(r13);
    L60:
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_NORMAL_GIFT_NEED_HAND_SHOW, Boolean.FALSE)).booleanValue() == true) goto L62;
    L70:
        NormalGiftMessage r6 = this.a;
        if (r6 == null) goto L78;
        if (r6.u().equals(r13.u()) == true) goto L75;
    L76:
        ((ArrayList) this.n).clear();
        goto L78
    L75:
        if (r13.m == 1) goto L76;
    L78:
        if (this.c == false) goto L85;
        NormalGiftMessage r14 = this.a;
        if (r14.n <= 0) goto L85;
        r14.b();
        BaseNormalGiftCombView r15 = this.e;
        if (r15 == null) goto L84;
        r15.i();
    L84:
        b();
        this.c = false;
    L85:
        return true;
    L62:
        if (r13.r() == null) goto L70;
        if (r13.r().isLocal() == false) goto L70;
        if (this.a.n <= 0) goto L70;
        BaseNormalGiftCombView r7 = this.e;
        if (r7 == null) goto L70;
        r7.e();
        goto L70
    L40:
        if (this.b == true) goto L56;
        NormalGiftMessage r8 = this.a;
        if (r8 == null) goto L56;
        if (r8.u().equals(r13.u()) == false) goto L56;
        NormalGiftMessage r9 = this.a;
        if (r9.p == true) goto L56;
        if (r13.p == false) goto L56;
        if ((r9.m + ((long) r9.n)) != r13.m) goto L56;
        boolean r10 = true;
    L57:
        if (r10 == false) goto L86;
        NormalGiftMessage r11 = this.a;
        r11.p = true;
        r11.q = r13.q;
        r11.t = r13.r();
        goto L60
    L86:
        return false;
    L56:
        r10 = false;
    L28:
        if (r13.m == ((r2.m + ((long) r2.n)) + 1)) goto L29;
        r3 = false;
        goto L31
    L11:
        if (r0.getType() != 11) goto L13;
    L35:
        r4 = false;
        goto L37
    }

    public final void j(Context r9) {
        if (this.s == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L30;
        float r1 = r9.getResources().getDimension(2131168673);
        int r3 = x12.b.a();
        gq2.b r4 = com.bytedance.android.live.revenue.core.util.e.a(d.class).Qc();
        r4.c();
        if (r4.d(r3, 4) == false) goto L13;
        this.g = (int) (r9.getResources().getDimension(2131168663) + r1);
        this.h = (int) r9.getResources().getDimension(2131168676);
    L29:
        this.h = (int) (this.h + r1);
        return;
    L13:
        r4.k();
        if (r4.d(r3, 64) == false) goto L17;
        this.g = (int) (r9.getResources().getDimension(2131168663) + r1);
        this.h = (int) r9.getResources().getDimension(2131168676);
        goto L29
    L17:
        if (k() == false) goto L19;
        this.g = (int) (r9.getResources().getDimension(2131168710) + r1);
        this.h = (int) r9.getResources().getDimension(2131168673);
        goto L29
    L19:
        n01.a r5 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r5 == null) goto L22;
        boolean r6 = r5.Q0(null);
    L23:
        if (r6 == false) goto L26;
        this.g = 0;
        this.h = (int) (this.d.getHeight() - r1);
        goto L29
    L26:
        if (u.j() == false) goto L28;
        this.g = (int) (r9.getResources().getDimension(2131168663) + r1);
        this.h = (int) r9.getResources().getDimension(2131168676);
        goto L29
    L28:
        this.g = (int) (r9.getResources().getDimension(2131168664) + r1);
        this.h = (int) r9.getResources().getDimension(2131168673);
        goto L29
    L22:
        r6 = false;
        goto L23
    L30:
        float r10 = this.i.getResources().getDimension(2131168673);
        this.g = (int) (this.i.getResources().getDimension(2131168666) + r10);
        this.h = (int) (0 + r10);
        return;
    L5:
        if (d0.a(this.r, this.t) == false) goto L7;
        r0 = true;
        goto L9
    }

    public b(Context r6, FrameLayout r7, int r8) {
        this.a = null;
        this.b = true;
        this.c = false;
        this.e = null;
        this.j = null;
        this.k = null;
        HashMap r3 = new HashMap();
        this.m = r3;
        this.n = new ArrayList();
        this.q = n12.e.a();
        this.r = false;
        this.t = false;
        this.v = false;
        this.w = -1;
        this.x = new C0268b(this);
        this.i = r6;
        this.d = r7;
        this.f = r8;
        this.s = !e();
        r3.put("desc", "播放小礼物动画");
        this.v = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.v.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[20])).booleanValue();
        j(r6);
    }
}
