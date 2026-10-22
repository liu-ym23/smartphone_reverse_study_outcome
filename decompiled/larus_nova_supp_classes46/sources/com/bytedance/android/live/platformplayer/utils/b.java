package com.bytedance.android.live.platformplayer.utils;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.u6;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jc1.k;
import xj1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends PhoneStateListener implements IMiddlewareHostAction.LiveAudioModeChangedListener, as0.c {
    public static final TokenCert f = null;
    public final Context a;
    public Object b;
    public final boolean c;
    public AudioManager d;
    public final WeakReference<as0.c.a> e;

    static {
        f = TokenCert.with("bpea-live_enter_page_check_telephony");
    }

    @Override // as0.c
    public final void a() {
        if (Build.VERSION.SDK_INT > 30) goto L5;
    L12:
        g80.g.c(this, 0, f);
        return;
    L5:
        if (this.b == null) goto L12;
        if (this.c == false) goto L9;
        AudioManager r0 = this.d;
    L10:
        if (r0 == null) goto L14;
        k.f(IMiddlewareHostAction.class).removeAudioModeChangedListener(r0, this.b);
        return;
    L14:
        return;
    L9:
        r0 = (AudioManager) this.a.getSystemService("audio");
        goto L10
    }

    public final void b() {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 <= 30) goto L13;
        if (this.c == true) goto L7;
        AudioManager r2 = (AudioManager) this.a.getSystemService("audio");
    L11:
        this.b = k.f(IMiddlewareHostAction.class).addAudioModeChangedListener(r2, this);
        return;
    L7:
        if (this.d != null) goto L9;
        this.d = (AudioManager) this.a.getSystemService("audio");
    L9:
        r2 = this.d;
        goto L11
    L13:
        if (((Boolean) u6.a.getValue()).booleanValue() == true) goto L15;
    L39:
        boolean r3 = true;
    L40:
        if (r3 == false) goto L50;
        g80.g.c(this, 32, f);
        return;
    L50:
        return;
    L15:
        if (r1 < 23) goto L38;
        if (r1 < 23) goto L36;
        Context r4 = this.a;
        ArrayList r5 = new ArrayList();
        Object[] r13 = {"android.permission.READ_PHONE_STATE"};
        f06.b r15 = new f06.b("auto_cert_com_bytedance_android_live_platformplayer_utils_LivePhoneStateReceiver_android_content_Context_checkSelfPermission");
        g06.a r6 = (g06.a) ApiHookConfig.b.get(102608);
        if (r6 == null) goto L21;
        f06.a[] r7 = r6.i;
    L22:
        f06.a[] r12 = r7;
        int r11 = r12.length;
        int r10 = 0;
    L24:
        if (r10 >= r11) goto L31;
        f06.a r9 = r12[r10];
        int r19 = r10;
        int r20 = r11;
        f06.a[] r21 = r12;
        f06.d r8 = r9.preInvoke(102608, "android/content/Context", "checkSelfPermission", r4, r13, "int", r15);     // Catch: Exception -> L43
        if (r8.a == true) goto L33;
        r5.add(r9);     // Catch: Exception -> L43
    L33:
        if (r8.a == false) goto L35;
        int r14 = ((Integer) r8.b).intValue();
    L37:
        if (r14 == 0) goto L39;
    L35:
        r14 = r4.checkSelfPermission("android.permission.READ_PHONE_STATE");
    L30:
        r10 = r19 + 1;
        r11 = r20;
        r12 = r21;
        goto L24
    L31:
        r8 = new f06.d(false, null);
        goto L33
    L21:
        r7 = ApiHookConfig.d;
        goto L22
    L36:
        r14 = -1;
    L38:
        r3 = false;
        goto L40
    }

    public final void onModeChanged(int r2) {
        WeakReference<as0.c.a> r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L9;
        this.e.get().onModeChanged(r2);
        return;
    }

    public b(r r2, Context r3) {
        this.c = ((LiveMemLeakConfig) j1.a.getValue()).getFixAudioLeak();
        this.a = r3;
        this.e = new WeakReference(r2);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int r1, String r2) {
        super.onCallStateChanged(r1, r2);
        WeakReference<as0.c.a> r3 = this.e;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.get() == null) goto L9;
        this.e.get().a(r1);
        return;
    }
}
