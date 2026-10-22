package com.ss.android.lark.framework.assembly.appconfig;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.launch.task.BaseWarmupTriggerState;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.concurrent.atomic.AtomicBoolean;
import jdb.e;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitSettingsTask extends AsyncLaunchTask {
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;
    public static volatile Boolean e;

    static {
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = null;
    }

    public static void j() {
        AtomicBoolean r0 = d;
        if (r0.get() == false) goto L6;
        return;
    L6:
        monitor-enter(InitSettingsTask.class);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (r0.get() == false) goto L11;
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L14
        return;
    L11:
        ((e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(e.class)).Y9();     // Catch: Throwable -> L14
        r0.set(true);     // Catch: Throwable -> L14
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L14
    }

    public static void k() {
        if (e != null) goto L5;
    L7:
        e = Boolean.TRUE;
        com.ss.android.lark.larkconfig.userconfig.e.a.a.b();
        return;
    L5:
        if (e.booleanValue() != true) goto L7;
    }

    public static void l() {
        Log.i("InitSettingsTask", "runInternal");
        AtomicBoolean r0 = c;
        if (r0.get() == false) goto L6;
    L13:
        j();
        if (((b) LarkContext.spiByDwarf(b.class)).isLogin() == false) goto L16;
        k();
        return;
    L16:
        opb.e.a.a.e();
        return;
    L6:
        monitor-enter(InitSettingsTask.class);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (r0.get() == false) goto L11;
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L18
    L21:
        goto L13
    L11:
        h.a(new a((j) LarkContext.spiByDwarf(j.class)));     // Catch: Throwable -> L18
        r0.set(true);     // Catch: Throwable -> L18
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L18
        goto L21
    }

    public InitSettingsTask() {
    }

    public final void a(Context r2) {
        Log.i("InitSettingsTask", "execute");
        if (BaseWarmupTriggerState.a.get() == false) goto L6;
        Log.i("InitSettingsTask", "skip execute, BASE warmup already triggered");
        return;
    L6:
        l();
    }
}
