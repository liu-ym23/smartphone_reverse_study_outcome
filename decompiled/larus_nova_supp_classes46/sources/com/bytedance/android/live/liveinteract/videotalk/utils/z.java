package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.utils.s0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z {
    public final Paint a;
    public final Paint b;
    public final HashMap<String, String> c;
    public final HashMap<String, Bitmap> d;
    public final HashMap<String, Bitmap> e;
    public final Bitmap f;
    public final double g;
    public Bitmap h;
    public final Bitmap i;
    public final CompositeDisposable j;
    public ei6.a k;
    public final v l;
    public final boolean m;
    public final IRoom n;
    public final int o;
    public final int p;
    public final j1 q;

    public final ei6.a a() {
        if (this.k != null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r0 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r0 == null) goto L9;
        hg6.g r1 = r0.R1();
        if (r1 == null) goto L9;
        ei6.a r2 = r1.V0();
    L10:
        this.k = r2;
    L9:
        r2 = null;
    L12:
        return this.k;
    }

    public final void d() {
        ei6.a r0 = a();
        this.k = r0;
        if (r0 == null) goto L9;
        ti6.d r1 = r0.p();
        if (r1 == null) goto L9;
        ti6.e r2 = r1.f();
        if (r2 == null) goto L9;
        r2.n();
    L9:
        ei6.a r3 = this.k;
        if (r3 == null) goto L17;
        ti6.d r4 = r3.p();
        if (r4 == null) goto L18;
        ti6.e r5 = r4.f();
        if (r5 == null) goto L19;
        r5.o();
        return;
    L19:
        return;
    L18:
        return;
    }

    public final String b(ILinkPlayerInfoBridge r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.o);
        r0.append('_');
        r0.append(this.p);
        r0.append('_');
        r0.append(r4.getUserPosition());
        return r0.toString();
    }

    public final void e(ILinkPlayerInfoBridge r2, boolean r3) {
        ei6.a r0 = a();
        this.k = r0;
        if (r0 == null) goto L9;
        ti6.d r1 = r0.p();
        if (r1 == null) goto L9;
        ti6.e r4 = r1.f();
        if (r4 == null) goto L9;
        r4.k(b(r2));
    L9:
        if (r3 == false) goto L18;
        ei6.a r5 = this.k;
        if (r5 == null) goto L19;
        ti6.d r6 = r5.p();
        if (r6 == null) goto L20;
        ti6.e r7 = r6.f();
        if (r7 == null) goto L21;
        r7.o();
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public z(IRoom r6, int r7, j1 r8) {
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        this.n = r6;
        boolean r9 = false;
        this.o = 0;
        this.p = r7;
        this.q = r8;
        this.a = new Paint(1);
        this.b = new Paint();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = BitmapFactory.decodeResource(s1.getResources(), 2131253267);
        this.g = 0.4d;
        this.i = BitmapFactory.decodeResource(s1.getResources(), 2131251871);
        this.j = new CompositeDisposable();
        v.b r10 = v.b;
        monitor-enter(r10);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (v.a != null) goto L7;
        v.a = new v();     // Catch: Throwable -> L34
    L7:
        v r1 = v.a;     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L34
        monitor-exit(r10);
        this.l = r1;
        this.m = true;
        ReadOnlyProperty r11 = vm2.d.U1;
        KProperty[] r2 = vm2.d.a;
        if (((Boolean) r11.getValue(null, r2[148(0x94, float:2.07E-43)])).booleanValue() == false) goto L32;
        r1.getClass();
        if (r7 > 0) goto L39;
        Iterator r12 = ((List) vm2.d.a7.getValue(null, r2[414(0x19e, float:5.8E-43)])).iterator();     // Catch: Exception -> L27
    L23:
        if (r12.hasNext() == false) goto L29;
        String r3 = (String) r12.next();     // Catch: Exception -> L27
        if (String.valueOf(0).equals(r3) == false) goto L23;
    L26:
        boolean r13 = false;
    L30:
        if (r13 == false) goto L32;
        r9 = true;
    L29:
        r13 = true;
    L27:
        e = move-exception;
        ALogger.e("supportAudioMixer", e.toString());
        goto L29
    L39:
        Iterator r4 = vm2.d.b7.iterator();     // Catch: Exception -> L19
    L15:
        if (r4.hasNext() == false) goto L29;
        String r5 = (String) r4.next();     // Catch: Exception -> L19
        if (String.valueOf(r7).equals(r5) == false) goto L15;
    L19:
        e = move-exception;
        ALogger.e("supportAudioMixer", e.toString());
    L32:
        this.m = r9;
    }

    public final void f(ILinkPlayerInfoBridge r16, ch0.h r17, ti6.f r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r16, "guestInfo");
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L5;
        MixStreamType r4 = r3.getMixStreamType();
    L6:
        boolean r7 = true;
        if (r4 == MixStreamType.CLIENT_MIX) goto L14;
        if (r4 == MixStreamType.RTC_CLIENT_MIX) goto L14;
        if (r4 == MixStreamType.SERVER_MIX) goto L14;
    L19:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L24;
        return;
    L24:
        if (this.m == true) goto L26;
        return;
    L26:
        if (r16 == null) goto L30;
        IBaseUser r6 = r16.getUser();
        if (r6 == null) goto L30;
        String r8 = r6.getIdString();
    L32:
        if (Intrinsics.areEqual(r8, this.n.getOwnerUserIdString()) == true) goto L63;
        boolean r9 = TextUtils.isEmpty(r16.getMInteractIdStr());
        if (r16.getLinkType() != 2) goto L37;
    L40:
        boolean r11 = true;
    L41:
        j1 r12 = this.q;
        if (r12 == null) goto L44;
        cg6.a r13 = (cg6.a) r12.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L45:
        if (r17 == null) goto L53;
        if (r13 == null) goto L53;
        hg6.g r14 = r13.getRtcManager();
        if (r14 == null) goto L53;
        if (r14.A() != true) goto L53;
        boolean r0 = r17.c;
    L59:
        if (r9 == true) goto L64;
        if (r11 == true) goto L64;
        if (r0 == false) goto L63;
    L64:
        if (r7 == false) goto L96;
        if (r18 == null) goto L97;
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        v r10 = this.l;
        int r15 = this.o;
        int r20 = this.p;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "region");
        if (r15 == 11) goto L72;
        if (r20 == 2) goto L72;
        float r21 = 0.56f;
    L73:
        if (r15 == 15) goto L77;
        if (r20 == 7) goto L77;
        float r22 = 1.0f;
    L78:
        v.a r23 = new v.a(r21, r22, 0.5f);
        r23.a = (int) (((double) 720.0f) * r18.f);
        r23.b = (int) (((double) 1280.0f) * r18.g);
        r1.element = r23;
        if (TextUtils.isEmpty(r16.getMInteractIdStr()) == false) goto L88;
        v.a r24 = (v.a) r1.element;
        int r25 = r24.a;
        int r26 = r24.b;
        String r27 = "e_" + (r25 - (r25 % 16)) + '_' + (r26 - (r26 % 16));
        Bitmap r28 = this.e.get(r27);
        if (r28 == null) goto L83;
        c(r16, r18, r27, r28, false);
        goto L97
    L83:
        v.a r2 = (v.a) r1.element;
        int r29 = r2.a;
        int r30 = r2.b;
        Bitmap r31 = Bitmap.createBitmap(r29 - (r29 % 16), r30 - (r30 % 16), Bitmap.Config.ARGB_8888);
        Canvas r110 = new Canvas(r31);
        this.b.setColor(ColorProtector.parseColor("#1b0c2b"));
        float r32 = r2.d;
        int r33 = r2.a;
        float r111 = r33 - (r33 % 16);
        int r34 = r2.b;
        r110.drawRect(r32, 0.0f, r111, (r34 - (r34 % 16)) - r2.e, this.b);
        int r35 = r2.a;
        int r36 = r35 - (r35 % 16);
        int r37 = r2.b;
        int r38 = r37 - (r37 % 16);
        if (r36 <= r38) goto L86;
        int r39 = r38;
    L87:
        double r40 = ((double) r39) * this.g;
        double r41 = 2;
        double r112 = (((double) r36) - r40) / r41;
        double r42 = (((double) r38) - r40) / r41;
        r110.drawBitmap(this.f, null, new Rect((int) r112, (int) r42, (int) (r112 + r40), (int) (r40 + r42)), this.b);
        this.e.put(r27, r31);
        c(r16, r18, r27, r31, false);
        goto L97
    L86:
        r39 = r36;
        goto L87
    L88:
        Ref.ObjectRef r43 = new Ref.ObjectRef();
        v.a r44 = (v.a) r1.element;
        int r45 = r44.a;
        int r46 = r45 - (r45 % 16);
        int r47 = r44.b;
        int r48 = r47 - (r47 % 16);
        if (r16.getSilenceStatus() != 0) goto L91;
        String r49 = "1";
    L92:
        String r50 = r16.getMInteractIdStr() + '_' + this.o + '_' + this.p + '_' + r49 + '_' + r46 + '_' + r48;
        r43.element = r50;
        Bitmap r51 = this.d.get(r50);
        if (r51 == null) goto L95;
        c(r16, r18, (String) r43.element, r51, false);
        goto L97
    L95:
        IBaseUser r52 = r16.getUser();
        Intrinsics.checkNotNull(r52);
        py.k r53 = r52.getAvatarMedium();
        v.a r54 = (v.a) r1.element;
        int r55 = r54.a;
        int r56 = r54.b;
        this.j.add(Observable.create(new s0(r53, r55 - (r55 % 16), r56 - (r56 % 16))).compose(RxUtil.rxSchedulerHelper()).map(new w(this, r16, r18, r1)).subscribe(new x(this, r43, r16, r18), new y(this, r43, r16, r18)));
        goto L97
    L91:
        r49 = "0";
    L77:
        r22 = 0.0f;
    L72:
        r21 = 0.5f;
    L97:
        if (r19 == false) goto L106;
        ei6.a r57 = this.k;
        if (r57 == null) goto L107;
        ti6.d r58 = r57.p();
        if (r58 == null) goto L108;
        ti6.e r59 = r58.f();
        if (r59 == null) goto L109;
        r59.o();
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L96:
        e(r16, false);
    L53:
        if (r16.getMediaType() != 2) goto L55;
    L58:
        r0 = true;
        goto L59
    L55:
        if (r16.getMediaType() == 0) goto L58;
        r0 = false;
        goto L59
    L44:
        r13 = null;
        goto L45
    L37:
        if (r16.getLinkType() == 0) goto L40;
        r11 = false;
    L63:
        r7 = false;
    L30:
        r8 = null;
    L14:
        if (this.o == 15) goto L18;
        if (this.p == 7) goto L18;
    L20:
        r5 = false;
    L18:
        if (r4 != MixStreamType.SERVER_MIX) goto L20;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(ILinkPlayerInfoBridge r6, ti6.f r7, String r8, Bitmap r9, boolean r10) {
        int r0 = r6.getUserPosition();
        RTCWaterMarkRegion r1 = new RTCWaterMarkRegion();
        boolean r2 = false;
        if (r7 == null) goto L5;
        r1.a = (float) r7.d;
        r1.c = (float) r7.f;
        r1.b = (float) r7.e;
        r1.d = (float) r7.g;
        r1.e = 0;
        r1.h = r9;
    L5:
        String r11 = String.valueOf(r0);
        if (this.c.containsKey(r11) == false) goto L13;
        String r12 = this.c.get(r11);
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        if (r8.equals(r12) == true) goto L13;
        r2 = true;
    L13:
        if (r2 == false) goto L15;
        e(r6, r10);
    L15:
        String r13 = String.valueOf(r0);
        this.c.put(r13, r8);
        ei6.a r14 = a();
        this.k = r14;
        if (r14 == null) goto L22;
        ti6.d r15 = r14.p();
        if (r15 == null) goto L22;
        ti6.e r16 = r15.f();
        if (r16 == null) goto L22;
        String r17 = b(r6);
        System.currentTimeMillis();
        r16.a(r17, r1);
    L22:
        if (r10 == false) goto L31;
        ei6.a r18 = this.k;
        if (r18 == null) goto L32;
        ti6.d r19 = r18.p();
        if (r19 == null) goto L33;
        ti6.e r20 = r19.f();
        if (r20 == null) goto L34;
        r20.o();
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }
}
