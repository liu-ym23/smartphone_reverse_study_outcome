package com.obric.aee.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class EngineConfig implements com.obric.pap.base.a {
    private final com.obric.aee.a callback;
    private boolean logThreadNamed;
    private final Function2<String, byte[], Unit> pipeHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public EngineConfig(com.obric.aee.a r10, Function2<? super String, ? super byte[], Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "pipeHandler");
        this.callback = r10;
        this.pipeHandler = r11;
    }

    public final String getAdditionalAssetsHash() {
        return "00bfde3b-fff5-4387-8e63-a0b7b22ecc6e";
    }

    public final Context getContext() {
        return this.callback.getContext();
    }

    public final Map<String, String> getGlobalConfig() {
        return this.callback.d();
    }

    public final File getHome() {
        return new File(this.callback.c(), "Aee");
    }

    @Override // com.obric.pap.base.a
    public void log(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "content");
        this.callback.b(r10, r11, Process.myTid() + ' ' + r12);
    }

    @Override // com.obric.pap.base.a
    public void logD(String r10, String r11) {
        com.obric.pap.base.a.C0137a.a(this, r10, r11);
    }

    @Override // com.obric.pap.base.a
    public void logE(String r10, String r11) {
        com.obric.pap.base.a.C0137a.b(this, r10, r11);
    }

    @Override // com.obric.pap.base.a
    public void logI(String r10, String r11) {
        com.obric.pap.base.a.C0137a.c(this, r10, r11);
    }

    public void logV(String r10, String r11) {
        com.obric.pap.base.a.C0137a.d(this, r10, r11);
    }

    @Override // com.obric.pap.base.a
    public void logW(String r10, String r11) {
        com.obric.pap.base.a.C0137a.e(this, r10, r11);
    }

    public final void onGlobalEvent(String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(r11, "args");
        this.callback.L0(r10, r11);
    }

    public final void onLog(int r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "tag");
        Intrinsics.checkNotNullParameter(r13, "content");
        if (this.logThreadNamed == true) goto L5;
        Thread.currentThread().setName("Aee-LogDispatcher");
        this.logThreadNamed = true;
    L5:
        this.callback.b(r10, r12, r11 + ' ' + r13);
    }

    public final void onPipeData(String r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "data");
        this.pipeHandler.invoke(r10, r11);
    }
}
