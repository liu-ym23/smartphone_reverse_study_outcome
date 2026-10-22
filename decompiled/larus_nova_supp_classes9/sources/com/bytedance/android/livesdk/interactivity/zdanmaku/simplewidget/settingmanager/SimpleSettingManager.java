package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.bk0;
import com.bytedance.android.livesdk.config.hk0;
import com.bytedance.android.livesdk.config.nk0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import p22.n;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SimpleSettingManager {
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> a = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static volatile Disposable e;
    public static final AtomicBoolean f = null;

    public SimpleSettingManager() {
    }

    static {
        a = new com.bytedance.android.livesdk.sharedpref.e("live_user_operate_base_simple_danmaku_setting_state", 0);
        b = new com.bytedance.android.livesdk.sharedpref.e("live_danmaku_checked_old_version", Boolean.FALSE);
        c = LazyKt.lazy(SimpleSettingManager$defaultSettingBeforeAB$2.INSTANCE);
        d = LazyKt.lazy(SimpleSettingManager$defaultSettingWithAB$2.INSTANCE);
        f = new AtomicBoolean(false);
    }

    public static o b() {
        int r1 = -1;
        if (((Boolean) hk0.a.getValue()).booleanValue() == false) goto L80;
        long r4 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e<o> r0 = l42.a.z;
        o r6 = (o) r0.getValue();
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r7 = b;
        if (((Boolean) r7.getValue()).booleanValue() == true) goto L12;
        if (r6 != null) goto L8;
    L11:
        com.bytedance.android.livesdk.sharedpref.f.d(r7, Boolean.TRUE);
        goto L12
    L8:
        if (d(r6, (o) c.getValue()) == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r8 = a;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, 2);
        i.d("check old version, is same, set to un operated");
        goto L11
    L10:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r9 = a;
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, 1);
        i.d("check old version, is not same, set to operated");
    L12:
        Boolean r10 = (Boolean) l42.a.A.getValue();
        Integer r11 = (Integer) a.getValue();
        if (r11 != null) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r11 != null) goto L22;
    L23:
        if (r11 != null) goto L26;
    L28:
        boolean r14 = false;
    L30:
        int r15 = i.a;
        i.d("isUserOperated: " + r10 + ", isUserOperatedBaseSettingState: " + r11 + ", spSetting: " + r6);
        if (r6 != null) goto L33;
        r6 = (o) d.getValue();
    L41:
        nk0 r2 = nk0.a;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L49;
        if (r10.booleanValue() == true) goto L49;
        if (r6.f() == false) goto L49;
        r6.h(false);
    L49:
        if (r10.booleanValue() == false) goto L52;
    L78:
        i.d("get simple setting new done in " + (System.currentTimeMillis() - r4) + "ms");
        return r6;
    L52:
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L78;
        LivePreviewDanmakuConfig r3 = LivePreviewDanmakuConfig.Companion.getConfig();
        IMiddlewareUserService r16 = k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L61;
        com.bytedance.android.livesdk.user.e r17 = r16.user();
        if (r17 == null) goto L61;
        IBaseUser r18 = r17.b();
        if (r18 == null) goto L61;
        r1 = r18.getAgeRange();
    L61:
        float r19 = z0.b(false);
        i.d("currentUserAgeLevel: " + r1 + ", deviceScore: " + r19 + ", config: " + r3.getDebugString());
        if (((Boolean) bk0.a.getValue()).booleanValue() == true) goto L64;
        if (r1 >= 0) goto L73;
    L77:
        i.d("result setting: " + r6);
        f.set(true);
        goto L78
    L73:
        if (r1 > r3.getAgeLevel()) goto L77;
        if (r19 <= r3.getDeviceScore()) goto L77;
        r6.h(true);
        goto L77
    L64:
        if (r3.getAgeLevelList().contains(Integer.valueOf(r1)) == true) goto L66;
    L70:
        r6.h(false);
        goto L77
    L66:
        if (r19 <= r3.getFromDeviceScore()) goto L70;
        if (r19 > r3.getToDeviceScore()) goto L70;
        r6.h(true);
        goto L77
    L33:
        if (r13 == false) goto L35;
        i.d("get setting, is user operated base setting");
        goto L41
    L35:
        if (r14 == false) goto L40;
        Lazy r20 = d;
        if (d(r6, (o) r20.getValue()) == true) goto L39;
        o r21 = (o) r20.getValue();
        r6.j(r21.d());
        r6.k(r21.e());
        r6.i(r21.c());
        r6.g(r21.b());
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r6);
    L39:
        i.d("get setting, is user un operated base setting, new setting: " + r6);
        goto L41
    L40:
        i.b("get setting else, no reach here");
        goto L41
    L26:
        if (r11.intValue() != 0) goto L28;
    L29:
        r14 = true;
        goto L30
    L22:
        if (r11.intValue() == 2) goto L29;
    L16:
        if (r11.intValue() != 1) goto L18;
        r13 = true;
        goto L19
    L80:
        Boolean r5 = (Boolean) l42.a.A.getValue();
        o r23 = (o) l42.a.y.getValue();
        nk0 r24 = nk0.a;
        if (((Boolean) r24.getValue()).booleanValue() == true) goto L88;
        if (r5.booleanValue() == true) goto L88;
        if (r23.f() == false) goto L88;
        r23.h(false);
    L88:
        if (r5.booleanValue() == false) goto L90;
    L110:
        return r23;
    L90:
        if (r23.f() == true) goto L110;
        if (((Boolean) r24.getValue()).booleanValue() == true) goto L95;
        return r23;
    L95:
        LivePreviewDanmakuConfig r25 = LivePreviewDanmakuConfig.Companion.getConfig();
        IMiddlewareUserService r26 = k.f(IMiddlewareUserService.class);
        if (r26 == null) goto L102;
        com.bytedance.android.livesdk.user.e r27 = r26.user();
        if (r27 == null) goto L102;
        IBaseUser r28 = r27.b();
        if (r28 == null) goto L102;
        r1 = r28.getAgeRange();
    L102:
        float r29 = z0.b(false);
        if (r1 >= 0) goto L105;
    L109:
        f.set(true);
        goto L110
    L105:
        if (r1 > r25.getAgeLevel()) goto L109;
        if (r29 <= r25.getDeviceScore()) goto L109;
        r23.h(true);
        goto L109
    }

    public static o c() {
        AtomicBoolean r0 = f;
        if (r0.get() == false) goto L6;
        i.d("get simple setting async, has prefetched");
        return b();
    L6:
        long r1 = System.currentTimeMillis();
        if (r0.get() == true) goto L15;
        Disposable r2 = e;
        if (r2 != null) goto L12;
    L14:
        e = Single.fromCallable(d.a).subscribeOn(Schedulers.io()).subscribe(e.a, f.a);
        goto L15
    L12:
        if (r2.isDisposed() == true) goto L14;
    L15:
        o r3 = o.a((o) d.getValue());
        int r4 = i.a;
        i.d("get simple setting async done in " + (System.currentTimeMillis() - r1) + "ms");
        return r3;
    }

    public static void e(o r2) {
        xs2.b.a().post(new b(r2));
    }

    public static n a(o r11, int r13) {
        int r7 = UtilityKotlinExtentionsKt.i(60);
        Intrinsics.checkNotNullParameter(r11, "danmakuSetting");
        boolean r2 = r11.f();
        int r4 = r11.d();
        float r1 = r11.c();
        if (r1 != 0.8f) goto L7;
        float r3 = UtilityKotlinExtentionsKt.h(17);
    L5:
        float r6 = r3;
        if (r11.c() >= 1.0f) goto L22;
        int r5 = UtilityKotlinExtentionsKt.i(6);
    L24:
        return new n(r2, r13, r4, r6, r5, r7, (UtilityKotlinExtentionsKt.h(52) * r11.e()) / 1000.0f, r11.b(), r11.c() * UtilityKotlinExtentionsKt.h(15.0f));
    L22:
        r5 = UtilityKotlinExtentionsKt.i(4);
        goto L24
    L7:
        if (r1 != 0.9f) goto L10;
        r3 = UtilityKotlinExtentionsKt.h(12);
        goto L5
    L10:
        if (r1 != 1.0f) goto L13;
        r3 = UtilityKotlinExtentionsKt.h(21);
        goto L5
    L13:
        if (r1 != 1.2f) goto L16;
        r3 = UtilityKotlinExtentionsKt.h(24);
        goto L5
    L16:
        if (r1 != 1.4f) goto L18;
        r3 = UtilityKotlinExtentionsKt.h(29);
        goto L5
    L18:
        r3 = UtilityKotlinExtentionsKt.h(21);
        goto L5
    }

    public static boolean d(o r2, o r3) {
        if (r2.d() == r3.d()) goto L5;
    L11:
        return false;
    L5:
        if (r2.e() != r3.e()) goto L11;
        if (r2.c() != r3.c()) goto L11;
        if (r2.b() != r3.b()) goto L11;
        return true;
    }

    public static void f(o r2, ChangeSettingSource r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r3, "source");
        if (r3.isBaseSetting() == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = a;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, 1);
    L6:
        if (r3 != ChangeSettingSource.SETTING_PANEL_RESET) goto L8;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r4 = a;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, 2);
    L8:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r5 = l42.a.A;
        Boolean r1 = Boolean.TRUE;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r1);
        com.bytedance.android.livesdk.sharedpref.e<o> r6 = l42.a.z;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r2);
    }
}
