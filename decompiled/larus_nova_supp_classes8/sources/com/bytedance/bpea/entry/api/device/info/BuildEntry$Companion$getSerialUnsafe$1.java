package com.bytedance.bpea.entry.api.device.info;

import android.os.Build;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class BuildEntry$Companion$getSerialUnsafe$1 extends Lambda implements Function0<String> {
    public static final BuildEntry$Companion$getSerialUnsafe$1 INSTANCE = null;

    static {
        INSTANCE = new BuildEntry$Companion$getSerialUnsafe$1();
    }

    public BuildEntry$Companion$getSerialUnsafe$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1607invoke() {
        if (Build.VERSION.SDK_INT < 26) goto L22;
        ArrayList r0 = new ArrayList();
        Object[] r2 = new Object[0];
        f06.b r12 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(101200);
        if (r4 == null) goto L7;
        f06.a[] r5 = r4.i;
    L8:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L10:
        if (r9 >= r10) goto L17;
        f06.a r8 = r11[r9];
        int r17 = r9;
        int r18 = r10;
        f06.a[] r19 = r11;
        f06.d r6 = r8.preInvoke(101200, "android/os/Build", "getSerial", Build.class, r2, "java.lang.String", r12);     // Catch: Exception -> L41
        if (r6.a == true) goto L19;
        r0.add(r8);     // Catch: Exception -> L41
    L19:
        if (r6.a == false) goto L54;
        return (String) r6.b;
    L54:
        return Build.getSerial();
    L16:
        r9 = r17 + 1;
        r10 = r18;
        r11 = r19;
        goto L10
    L17:
        r6 = new f06.d(false, null);
        goto L19
    L7:
        r5 = ApiHookConfig.d;
        goto L8
    L22:
        ArrayList r1 = new ArrayList();
        Object[] r3 = new Object[0];
        f06.b r7 = new f06.b();
        g06.a r13 = (g06.a) ApiHookConfig.b.get(102002);
        if (r13 == null) goto L25;
        f06.a[] r14 = r13.i;
    L26:
        f06.a[] r15 = r14;
        int r16 = r15.length;
        int r20 = 0;
    L28:
        if (r20 >= r16) goto L35;
        f06.a r21 = r15[r20];
        int r110 = r20;
        int r111 = r16;
        f06.a[] r112 = r15;
        f06.d r22 = r21.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r3, "java.lang.String", r7);     // Catch: Exception -> L42
        if (r22.a == true) goto L37;
        r1.add(r21);     // Catch: Exception -> L42
    L37:
        if (r22.a == false) goto L40;
        return (String) r22.b;
    L40:
        return Build.SERIAL;
    L34:
        r20 = r110 + 1;
        r16 = r111;
        r15 = r112;
        goto L28
    L35:
        r22 = new f06.d(false, null);
        goto L37
    L25:
        r14 = ApiHookConfig.d;
        goto L26
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1607invoke();
    }
}
