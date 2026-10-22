package com.obric.processsdk.wakeup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import ka.b;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class WakeUpReceiver extends BroadcastReceiver {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public WakeUpReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 != null) goto L8;
        ka.a r12 = la.a.f10917a.a();
        if (r12 == null) goto L23;
        r12.w("WakeUpReceiver", "intent is null");
        return;
    L23:
        return;
    L8:
        if (r10 != null) goto L14;
        ka.a r13 = la.a.f10917a.a();
        if (r13 == null) goto L24;
        r13.w("WakeUpReceiver", "context is null");
        return;
    L24:
        return;
    L14:
        if (TextUtils.equals(r11.getAction(), r10.getPackageName() + ".WAKE_UP") == false) goto L19;
        String r14 = r11.getStringExtra("extra_wakeup_desc");
        String r15 = r11.getStringExtra("extra_wakeup_scene");
        ka.a r16 = la.a.f10917a.a();
        if (r16 == null) goto L18;
        r16.d("WakeUpReceiver", "onReceive，intent: " + r11 + ", desc: " + r14 + ", scene: " + r15);
    L18:
        b.f10143a.b();
        return;
    L19:
        ka.a r17 = la.a.f10917a.a();
        if (r17 == null) goto L26;
        r17.w("WakeUpReceiver", "onReceive, not wake up action: " + r11.getAction());
        return;
    }
}
