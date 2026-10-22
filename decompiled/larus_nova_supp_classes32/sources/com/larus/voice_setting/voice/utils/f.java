package com.larus.voice_setting.voice.utils;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import p2a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements p2a.a {
    public static final f a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public f() {
    }

    static {
        a = new f();
        b = LazyKt.lazy(new b());
        c = LazyKt.lazy(new c());
        d = LazyKt.lazy(new d());
        e = LazyKt.lazy(new e());
    }

    @Override // p2a.a
    public final boolean a() {
        if (z2.a.m3() == true) goto L5;
        return false;
    L5:
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        String r2 = f(r0);
        FeatureConfig r3 = r0.y0();
        if (r3 == null) goto L15;
        FeatureDetail r4 = r3.F0();
        if (r4 == null) goto L15;
        if (r4.b() != true) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L26;
        List r1 = r0.d();
        if (r1 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        if (r1.contains(r2) != true) goto L22;
        r6 = true;
        goto L23
    L26:
        return false;
    L15:
        r5 = false;
        goto L16
    }

    @Override // p2a.a
    public final p c() {
        return (p) b.getValue();
    }

    @Override // p2a.a
    public final boolean e() {
        if (z2.a.m3() == true) goto L5;
        return false;
    L5:
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 != null) goto L9;
        return false;
    L9:
        if (FeatureKitDelegate.b.w0().b() == false) goto L14;
        AudioUserConfig r2 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r2 == null) goto L13;
        boolean r3 = r2.getHasUgcVoiceRecord();
    L15:
        String r4 = f(r0);
        FeatureConfig r5 = r0.y0();
        if (r5 == null) goto L22;
        FeatureDetail r6 = r5.F0();
        if (r6 == null) goto L22;
        if (r6.b() != true) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L34;
        if (r3 == true) goto L32;
        List r1 = r0.d();
        if (r1 != null) goto L28;
    L30:
        boolean r8 = false;
    L31:
        if (r8 == true) goto L32;
        return false;
    L28:
        if (r1.contains(r4) != true) goto L30;
        r8 = true;
    L32:
        return true;
    L34:
        return false;
    L22:
        r7 = false;
        goto L23
    L13:
        return false;
    L14:
        r3 = r0.J0();
        goto L15
    }

    public final boolean g() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public static String f(LaunchInfo r1) {
        if (AppHost.a.isOversea() == true) goto L5;
    L7:
        AppLocaleUtils.a.getClass();
        String r2 = AppLocaleUtils.c().getLanguage();
        Intrinsics.checkNotNull(r2);
        return r2;
    L5:
        if (Intrinsics.areEqual(r1.i0(), Boolean.TRUE) == false) goto L7;
        String r3 = b0.a;
        AppLocaleUtils.a.getClass();
        return b0.c(AppLocaleUtils.c());
    }

    @Override // p2a.a
    public final boolean b(String r5) {
        if (z2.a.m3() == true) goto L5;
        return false;
    L5:
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        String r6 = h(r0, r5);
        if (r6 != null) goto L11;
        return false;
    L11:
        FeatureConfig r2 = r0.y0();
        if (r2 == null) goto L18;
        FeatureDetail r3 = r2.F0();
        if (r3 == null) goto L18;
        if (r3.b() != true) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L29;
        List r1 = r0.d();
        if (r1 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        if (r1.contains(r6) != true) goto L25;
        r7 = true;
        goto L26
    L29:
        return false;
    L18:
        r4 = false;
        goto L19
    }

    @Override // p2a.a
    public final boolean d(String r4) {
        if (AppHost.a.isOversea() == true) goto L5;
        return true;
    L5:
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        String r5 = h(r0, r4);
        if (r5 != null) goto L11;
        return false;
    L11:
        List r1 = r0.d();
        if (r1 != null) goto L14;
    L16:
        return false;
    L14:
        if (r1.contains(r5) != true) goto L16;
        return true;
    }

    public static String h(LaunchInfo r1, String r2) {
        if (AppHost.a.isOversea() == true) goto L5;
        return r2;
    L5:
        if (Intrinsics.areEqual(r1.i0(), Boolean.TRUE) == false) goto L9;
        String r3 = b0.a;
        AppLocaleUtils.a.getClass();
        return b0.c(AppLocaleUtils.c());
    L9:
        return r2;
    }
}
