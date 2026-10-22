package ma2;

import c52.d;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.PageUIContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.s;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenAttachments;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import gd0.v;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import o42.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends ma2.b {
    public final String c;
    public final b52.a d;
    public final c52.b e;
    public final float f;
    public final float g;
    public d52.a h;
    public d52.b i;
    public final String j;
    public final DataCenter k;

    /* JADX INFO: renamed from: ma2.a$a, reason: collision with other inner class name */
    public static final class C0248a implements la2.a {
        public C0248a() {
        }

        @Override // la2.a
        public final void a() {
            f2.c("当前高度不能调整", 0);
        }
    }

    public static final class b implements la2.a {
        public b() {
        }

        @Override // la2.a
        public final void a() {
            f2.c("当前直播间公屏高度不可调节", 0);
        }
    }

    @Override // ma2.b
    public final void f() {
        c52.b r1 = this.e;
        Class r2 = Integer.TYPE;
        Intrinsics.checkNotNullParameter(d52.b.class, "styleType");
        Intrinsics.checkNotNullParameter(r1, "strategy");
        Intrinsics.checkNotNullParameter(r2, "valueType");
        this.b.put(d52.b.class, r1);
        b52.a r3 = this.d;
        Class r4 = Float.TYPE;
        Intrinsics.checkNotNullParameter(d52.a.class, "styleType");
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Intrinsics.checkNotNullParameter(r4, "valueType");
        this.b.put(d52.a.class, r3);
    }

    @Override // ma2.b
    public final void g() {
        e.c(this.j, z42.a.c.e(), y42.a.c.b());
    }

    @Override // ma2.b
    public final void h() {
        int r0 = f.a;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("audience_public_screen_setting_saved", Boolean.FALSE), Boolean.TRUE);
        e.c(this.j, this.i, this.h);
        d52.a r1 = this.h;
        this.d.getClass();
        y42.a r2 = y42.a.c;
        if ((!Intrinsics.areEqual(r1, r2.b())) == false) goto L5;
        int r3 = s.a;
        StringBuilder r4 = new StringBuilder("Font Size From ");
        this.d.getClass();
        r4.append(r2.b().a());
        r4.append(" to ");
        r4.append(this.h.a());
        String r5 = r4.toString();
        Intrinsics.checkNotNullParameter(r5, "string");
        ALogger.i("PublicScreenStyleSetting", r5);
        this.d.getClass();
        d52.a r6 = this.h;
        Intrinsics.checkNotNullParameter(r6, "style");
        com.bytedance.android.livesdk.sharedpref.e r7 = (com.bytedance.android.livesdk.sharedpref.e) r2.a.getValue();
        Integer r8 = Integer.valueOf(r6.a());
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r8);
        RxBusAbility.INSTANCE.getRxBus(this.k).post(new o42.b("PublicScreenConfigDialog"));
    L5:
        d52.b r9 = this.i;
        this.e.getClass();
        z42.a r10 = z42.a.c;
        if ((!Intrinsics.areEqual(r9, r10.e())) == false) goto L9;
        int r11 = s.a;
        StringBuilder r13 = new StringBuilder("Height Level From ");
        this.e.getClass();
        r13.append(r10.e().a());
        r13.append(" to ");
        r13.append(this.i.a());
        String r14 = r13.toString();
        Intrinsics.checkNotNullParameter(r14, "string");
        ALogger.i("PublicScreenStyleSetting", r14);
        this.e.getClass();
        d52.b r15 = this.i;
        Intrinsics.checkNotNullParameter(r15, "style");
        com.bytedance.android.livesdk.sharedpref.e r16 = (com.bytedance.android.livesdk.sharedpref.e) r10.a.getValue();
        Integer r17 = Integer.valueOf(r15.a());
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r17);
        RxBusAbility.INSTANCE.getRxBus(this.k).post(new c(false, true, "PublicScreenConfigDialog"));
        return;
    }

    @Override // ma2.b
    public final String e() {
        return this.c;
    }

    @Override // ma2.b
    public final float c(float r4) {
        return ((1 + (this.g * r4)) / this.f) * q.d(true, false);
    }

    @Override // ma2.b
    public final int d(float r11) {
        int r0 = this.e.g(d52.b.C0225b.a).intValue();
        int r1 = this.e.g(d52.b.c.b).intValue();
        int r2 = this.e.g(d52.b.a.b).intValue();
        if (r11 < 0) goto L15;
        double r3 = r11;
        if (r3 > 0.5d) goto L9;
        return r0 + ((int) ((2 * r11) * (r1 - r0)));
    L9:
        if (r11 > 1) goto L12;
        return r1 + ((int) ((((double) 2) * (r3 - 0.5d)) * ((double) (r2 - r1))));
    L12:
        return r2;
    L15:
        return r0;
    }

    @Override // ma2.b
    public final void j(DataCenter r13) {
        if (this.e.c() >= 0) goto L7;
        ma2.b.InterfaceC0249b r0 = this.a;
        if (r0 == null) goto L7;
        r0.Cn(d52.b.class, d52.b.C0225b.a, new C0248a());
    L7:
        int r1 = f.a;
        boolean r2 = false;
        if (r13 == null) goto L85;
        IRoomContextService r3 = k.f(IRoomContextService.class);
        Integer r4 = null;
        if (r3 == null) goto L17;
        o r5 = IRoomContextService.a.a(r3, r13, 0, 2);
        if (r5 == null) goto L17;
        n r6 = r5.getTemplateContext();
        if (r6 == null) goto L17;
        z70.b r7 = (z70.b) r6.getValue();
    L18:
        int r8 = com.bytedance.android.livesdk.interactivity.service.model.e.a;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().audiencePSHeightSetting == false) goto L35;
        if (r7 == null) goto L35;
        if (r7.c("public_screen") != true) goto L35;
        if (r7.j("public_screen") == false) goto L85;
        IRoom r9 = a0.o(r13);
        if (r9 == null) goto L85;
        RoomPublicScreenInfo r10 = gb2.b.b(r9);
        if (r10 == null) goto L85;
        RoomPublicScreenAttachments r11 = r10.attachments;
        if (r11 == null) goto L85;
        if (r11.enableSettingHeight() != true) goto L85;
    L51:
        if (((Number) r13.get("data_link_state", 0)).intValue() <= 2) goto L70;
        Object r14 = r13.get("data_link_state", null);
        if ((r14 instanceof Integer) == true) goto L55;
        r14 = null;
    L55:
        Integer r15 = (Integer) r14;
        if (r15 != null) goto L58;
    L60:
        r15 = null;
    L61:
        if (r15 == null) goto L85;
        IInteractivityInjectService r16 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r16 == null) goto L65;
        r4 = r16.getVideoTalkRoomSubScene(r13);
    L65:
        if (r4 == null) goto L85;
        if (r4.intValue() != 8) goto L85;
        r2 = true;
        goto L85
    L58:
        if (v.a(r15.intValue(), 32) == false) goto L60;
    L70:
        PageUIContext r17 = PageUIContext.Companion.getContext(r13);
        if (r17 == null) goto L84;
        com.bytedance.android.livesdk.interactivity.api.base.a r18 = (com.bytedance.android.livesdk.interactivity.api.base.a) r17.getInteractUIInfo().getValue();
        if (r18 == null) goto L84;
        int r19 = r18.pT();
        int r110 = ((Number) r17.getVideoBottom().getValue()).intValue();
        if (r110 < com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.a) goto L84;
        if (r110 >= ((((double) r19) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L80;
        boolean r20 = true;
    L81:
        if (r20 == false) goto L84;
        if (r110 <= 0) goto L84;
        r2 = true;
        goto L84
    L80:
        r20 = false;
    L84:
        r2 = !r2;
    L35:
        Object r21 = r13.get("data_live_mode", null);
        if ((r21 instanceof LiveMode) == true) goto L38;
        r21 = null;
    L38:
        LiveMode r23 = (LiveMode) r21;
        if (r23 != LiveMode.VIDEO) goto L41;
    L43:
        IRoom r24 = a0.o(r13);
        if (r24 == null) goto L51;
        if (r24.isMergeVSRoom() == true) goto L85;
        if (r24.isMediaRoom() == false) goto L51;
    L41:
        if (r23 == LiveMode.THIRD_PARTY) goto L43;
    L17:
        r7 = null;
    L85:
        if (r2 == true) goto L90;
        ma2.b.InterfaceC0249b r111 = this.a;
        if (r111 == null) goto L91;
        this.e.getClass();
        r111.Cn(d52.b.class, z42.a.c.e(), new b());
        return;
    L91:
        return;
    }

    public a(String r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        this.j = r3;
        this.k = r4;
        this.c = "AudienceVideoStyleSettingPresenter";
        b52.a r5 = b52.a.a;
        this.d = r5;
        if (PadConfigUtils.c() == false) goto L11;
        if (r4 == null) goto L6;
        LiveMode r6 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
    L8:
        if (r6 != LiveMode.THIRD_PARTY) goto L10;
        c52.b r7 = c52.c.f;
    L12:
        this.e = r7;
        this.f = q.i();
        d52.a.b r0 = d52.a.b.b;
        r5.getClass();
        this.g = b52.a.c(r0).floatValue() - b52.a.c(d52.a.c.a).floatValue();
        this.h = y42.a.c.b();
        r7.getClass();
        this.i = z42.a.c.e();
        return;
    L10:
        r7 = d.f;
        goto L12
    L6:
        r6 = null;
        goto L8
    L11:
        r7 = c52.a.g;
        goto L12
    }

    @Override // ma2.b
    public final <T extends d52.c> void i(Class<T> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "styleType");
        if (Intrinsics.areEqual(r2, d52.b.class) == false) goto L13;
        this.e.getClass();
        z42.a.c.getClass();
        if (r3 != 1) goto L7;
        d52.b r4 = d52.b.c.b;
    L11:
        this.i = r4;
        return;
    L7:
        if (r3 == 2) goto L9;
        r4 = d52.b.C0225b.a;
        goto L11
    L9:
        r4 = d52.b.a.b;
        goto L11
    L13:
        if (Intrinsics.areEqual(r2, d52.a.class) == false) goto L17;
        this.d.getClass();
        this.h = (d52.a) y42.a.c.d(r3);
        return;
    }
}
