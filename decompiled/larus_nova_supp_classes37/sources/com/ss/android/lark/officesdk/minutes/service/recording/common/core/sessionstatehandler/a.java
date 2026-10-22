package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import android.app.Application;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int h = 0;
    public final Function1<Boolean, Unit> a;
    public final String b;
    public final Application c;
    public final TelephonyManager d;
    public boolean e;
    public c f;
    public b g;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a$a, reason: collision with other inner class name */
    public static final class C0029a {
        public static boolean a() {
            Application r0 = LarkContext.getApplication();
            Intrinsics.checkNotNull(r0);
            Intrinsics.checkNotNullParameter(r0, "context");
            if (ContextCompat.checkSelfPermission(r0, "android.permission.READ_PHONE_STATE") != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L22;
            Object r2 = r0.getSystemService("audio");
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.media.AudioManager");
            int r3 = ((AudioManager) r2).getMode();
            if (r3 == 1) goto L20;
            if (r3 == 2) goto L20;
            return false;
        L20:
            return true;
        L22:
            Object r4 = r0.getSystemService("phone");     // Catch: Exception -> L14
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Exception -> L14
            TelephonyManager r5 = (TelephonyManager) r4;     // Catch: Exception -> L14
            if (2 == r5.getCallState()) goto L12;
            if (1 == r5.getCallState()) goto L12;
            return false;
        L12:
            return true;
        L14:
            e = move-exception;
            lvb.a.b("MmPhoneStateListener", "[isCalling] error: " + e);
            return false;
        L5:
            r1 = false;
            goto L7
        }

        public static boolean b() {
            Application r0 = LarkContext.getApplication();
            boolean r1 = a();
            Object r2 = r0.getSystemService("audio");
            Integer r3 = null;
            if ((r2 instanceof AudioManager) == false) goto L5;
            AudioManager r4 = (AudioManager) r2;
        L6:
            if (r4 == null) goto L8;
            r3 = Integer.valueOf(r4.getMode());
        L8:
            boolean r5 = false;
            if (r3 != null) goto L12;
        L13:
            if (r3 != null) goto L16;
        L18:
            boolean r6 = false;
        L20:
            if (r1 == true) goto L22;
            if (r6 == true) goto L22;
        L23:
            lvb.a.e("MmPhoneStateListener", "[isSystemCallActiveWithAudioFallback] telephonyCalling=" + r1 + ", audioMode=" + r3 + ", audioCalling=" + r6 + ", result=" + r5);
            return r5;
        L22:
            r5 = true;
            goto L23
        L16:
            if (r3.intValue() != 2) goto L18;
        L19:
            r6 = true;
            goto L20
        L12:
            if (r3.intValue() == 1) goto L19;
        L5:
            r4 = null;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.d != null) goto L8;
        return;
    L8:
        Application r0 = this.c;
        Intrinsics.checkNotNullParameter(r0, "context");
        if (ContextCompat.checkSelfPermission(r0, "android.permission.READ_PHONE_STATE") != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L29;
        lvb.a.e(this.b, "No READ_PHONE_STATE permission");
        return;
    L29:
        int r2 = Build.VERSION.SDK_INT;     // Catch: Exception -> L26
        if (r2 < 31) goto L21;
        if (r2 < 31) goto L24;
        c r3 = new c(this);     // Catch: Exception -> L26
        this.f = r3;     // Catch: Exception -> L26
        TelephonyManager r4 = this.d;     // Catch: Exception -> L26
        if (r4 == null) goto L24;
        r4.registerTelephonyCallback(this.c.getMainExecutor(), r3);     // Catch: Exception -> L26
    L24:
        this.e = true;     // Catch: Exception -> L26
        lvb.a.e(this.b, "startListening success");     // Catch: Exception -> L26
        return;
    L21:
        b r5 = new b(this);     // Catch: Exception -> L26
        this.g = r5;     // Catch: Exception -> L26
        TelephonyManager r6 = this.d;     // Catch: Exception -> L26
        if (r6 == null) goto L24;
        r6.listen(r5, 32);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        lvb.a.b(this.b, "startListening failed: " + e);
        return;
    L11:
        r1 = false;
        goto L12
    }

    public final void c() {
        if (this.e == true) goto L5;
        return;
    L5:
        TelephonyManager r0 = this.d;
        if (r0 != null) goto L26;
        return;
    L26:
        int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L23
        if (r1 < 31) goto L18;
        if (r1 < 31) goto L21;
        c r2 = this.f;     // Catch: Exception -> L23
        if ((r2 instanceof TelephonyCallback) == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L17;
        r0.unregisterTelephonyCallback(r2);     // Catch: Exception -> L23
    L17:
        this.f = null;     // Catch: Exception -> L23
    L21:
        this.e = false;     // Catch: Exception -> L23
        lvb.a.e(this.b, "stopListening success");     // Catch: Exception -> L23
        return;
    L18:
        b r3 = this.g;     // Catch: Exception -> L23
        if (r3 == null) goto L21;
        r0.listen(r3, 0);     // Catch: Exception -> L23
        this.g = null;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        lvb.a.b(this.b, "stopListening failed: " + e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onPhoneStateChange");
        this.a = r2;
        this.b = "MmPhoneStateHelper";
        Application r3 = LarkContext.getApplication();
        this.c = r3;
        Object r4 = r3.getSystemService("phone");
        if ((r4 instanceof TelephonyManager) == false) goto L5;
        TelephonyManager r5 = (TelephonyManager) r4;
    L6:
        this.d = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void a(a r3, int r4) {
        lvb.a.e(r3.b, "onCallStateChanged: " + r4);
        if (r4 != 0) goto L5;
        r3.a.invoke(Boolean.FALSE);
        return;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r3.a.invoke(Boolean.TRUE);
        return;
    L7:
        if (r4 == 2) goto L9;
    }
}
