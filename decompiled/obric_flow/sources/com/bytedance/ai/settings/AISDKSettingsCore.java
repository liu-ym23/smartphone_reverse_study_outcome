package com.bytedance.ai.settings;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.ai.settings.internal.AISDKSettingsPreferencesServiceImpl;
import com.bytedance.ai.settings.internal.AISDKSettingsRequestServiceImpl;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import pg.a;
import pg.d;
import s0.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/settings/AISDKSettingsCore;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AISDKSettingsCore {
    public static void a() {
        a r5 = a.b("flow_ai_sdk");
        r5.f21343a = new com.bytedance.ai.resource.core.net.a(2);
    }

    public static final d b() {
        Application r5 = c.a();
        String r10 = z5.a.f23407o;
        if (TextUtils.isEmpty(r10) == true) goto L42;
    L28:
        boolean r11 = false;
        if (r10 != null) goto L31;
    L33:
        if (r10 != null) goto L35;
    L37:
        pg.c r12 = new pg.c();
        r12.f21347a = c.a();
        r12.f21349c = new AISDKSettingsRequestServiceImpl();
        new AISDKSettingsPreferencesServiceImpl();
        r12.g = r11;
        return r12.a();
    L35:
        if (r10.equals(r5.getPackageName()) == false) goto L37;
        r11 = true;
        goto L37
    L31:
        if (r10.contains(":") == false) goto L33;
    L42:
        int r13 = Process.myPid();     // Catch: Exception -> L12
        Iterator<ActivityManager.RunningAppProcessInfo> r14 = ((ActivityManager) r5.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L7:
        if (r14.hasNext() == false) goto L44;
        ActivityManager.RunningAppProcessInfo r15 = r14.next();     // Catch: Exception -> L12
        if (r15.pid != r13) goto L7;
        r10 = r15.processName;     // Catch: Exception -> L12
        z5.a.f23407o = r10;     // Catch: Exception -> L12
    L44:
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L23
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L40
    L17:
        int r18 = r16.read();     // Catch: Throwable -> L40
        if (r18 <= 0) goto L20;
        r17.append((char) r18);     // Catch: Throwable -> L40
        goto L17
    L20:
        r10 = r17.toString();     // Catch: Throwable -> L40
        r16.close();     // Catch: Exception -> L39
    L27:
        z5.a.f23407o = r10;
    L24:
        if (r16 != null) goto L50;
    L26:
        r10 = null;
        goto L27
    L50:
        r16.close();     // Catch: Exception -> L41
    L23:
        r16 = null;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L44
    }

    public static IAISDKSettings c() {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl((IAISDKSettings) a.b("flow_ai_sdk").a(IAISDKSettings.class));     // Catch: Throwable -> L4
    L6:
        Throwable r11 = Result.m127exceptionOrNullimpl(r10);
        if (r11 != null) goto L9;
    L14:
        DefaultValueAISDKSettings r12 = DefaultValueAISDKSettings.INSTANCE;
        if (Result.m130isFailureimpl(r10) == false) goto L18;
        r10 = r12;
    L18:
        return (IAISDKSettings) r10;
    L9:
        if (c.f21802b == true) goto L13;
        Intrinsics.checkNotNullParameter("AppletSettingsManager", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L14;
        r13.w("AppletSettingsManager", "obtain settings failed", r11);
        goto L14
    L13:
        throw r11;
    L4:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
