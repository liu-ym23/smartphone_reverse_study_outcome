package com.bytedance.android.live.core.privacy.av.impl;

import android.content.Context;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.live.core.privacy.av.api.d {
    public static final ArrayList<Integer> j = null;
    public final b a;
    public boolean b;
    public boolean c;
    public final HashMap<String, Boolean> d;
    public final Lazy e;
    public final Context f;
    public final com.bytedance.android.live.core.privacy.av.api.f g;
    public final PrivacyConfig h;
    public final com.bytedance.android.live.core.privacy.av.api.h i;

    public static final class a {
    }

    static {
        j = CollectionsKt.arrayListOf(new Integer[]{1});
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.media.AudioSystem");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.media.AudioSystem");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.media.AudioSystem");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.media.AudioSystem");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.media.AudioSystem");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.media.AudioSystem");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.media.AudioSystem");
    }

    public final boolean g() {
        Iterator<Integer> r0 = j.iterator();
    L4:
        if (r0.hasNext() == false) goto L23;
        Integer r1 = r0.next();
        Object r2 = e().getDeclaredMethod("isSourceActive", new Class[]{Integer.TYPE}).invoke(null, new Object[]{r1});     // Catch: Exception -> L13
        if (r2 == null) goto L12;
        if (((Boolean) r2).booleanValue() == false) goto L4;
        this.i.a("check mic by audioSourceList; i=" + r1);     // Catch: Exception -> L13
        return true;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        this.i.b("check mic failed", e);
        goto L4
    L23:
        return false;
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean a(boolean r3) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_AUDIO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.i.b("call stopVideoCapture, but mock disable", null);
        return false;
    L6:
        if (r3 == false) goto L10;
        return !g();
    L10:
        return this.g.a();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean b(boolean r3) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_VIDEO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.i.b("call stopVideoCapture, but mock disable", null);
        return false;
    L6:
        if (r3 == false) goto L10;
        return !this.b;
    L10:
        return this.g.b();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean c(boolean r3) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_VIDEO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.i.b("call stopVideoCapture, but mock disable", null);
        return true;
    L6:
        if (r3 == false) goto L10;
        return this.b;
    L10:
        return this.g.c();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean d(boolean r3) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_AUDIO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.i.b("call stopVideoCapture, but mock disable", null);
        return true;
    L6:
        if (r3 == false) goto L10;
        return g();
    L10:
        return this.g.d();
    }

    public c(Context r3, PrivacyConfig r4, com.bytedance.android.live.core.privacy.av.api.h r5) {
        g r0 = g.g;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "liveCore");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "logger");
        this.f = r3;
        this.g = r0;
        this.h = r4;
        this.i = r5;
        this.d = new HashMap();
        this.e = LazyKt.lazy(new AudioAndVideoCheckerImpl$releaseHandler$2(this));
        this.a = new b(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        this.b = false;
        this.i.b("camera registerSystemCallBack onCameraUnavailable cameraId Exception = " + e, null);
    }

    public static final void f(c r1, String r2, boolean r3) {
        r1.d.put(r2, Boolean.valueOf(r3));
        Iterator<T> r4 = r1.d.values().iterator();
        boolean r5 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        if (((Boolean) r4.next()).booleanValue() == false) goto L4;
        r5 = true;
        goto L4
    L8:
        r1.b = r5;
    }
}
