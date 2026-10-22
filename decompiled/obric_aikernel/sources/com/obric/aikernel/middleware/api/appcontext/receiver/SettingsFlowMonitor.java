package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsFlowMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g1<String> f4524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p1<String> f4525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SettingsFlowMonitor$settingsObserver$1 f4526f;

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.aikernel.middleware.api.appcontext.receiver.SettingsFlowMonitor$settingsObserver$1] */
    public SettingsFlowMonitor(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "targetKey");
        this.f4521a = r10;
        this.f4522b = r11;
        this.f4523c = "SettingsFlowMonitor_" + r11;
        g1<String> r12 = q1.a(c());
        this.f4524d = r12;
        this.f4525e = kotlinx.coroutines.flow.e.a(r12);
        final Handler r13 = new Handler(Looper.getMainLooper());
        this.f4526f = new SettingsFlowMonitor$settingsObserver$1(this, r13);
        e();
    }

    public static final /* synthetic */ String a(SettingsFlowMonitor r10) {
        return r10.f4522b;
    }

    public static final /* synthetic */ g1 b(SettingsFlowMonitor r10) {
        return r10.f4524d;
    }

    private final void e() {
        this.f4521a.getContentResolver().registerContentObserver(Settings.Global.getUriFor(this.f4522b), false, this.f4526f);
    }

    public final String c() {
        return Settings.Global.getString(this.f4521a.getContentResolver(), this.f4522b);
    L4:
        e = move-exception;
        Log.e(this.f4523c, "getCurrentSettingsValue failed：" + e.getMessage());
        return null;
    }

    public final p1<String> d() {
        return this.f4525e;
    }
}
