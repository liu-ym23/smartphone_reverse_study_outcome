package com.larus.audioplayer.impl.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/audioplayer/impl/utils/AudioVolumeChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "TAG", "", "VOLUME_CHANGED_ACTION", "EXTRA_VOLUME_STREAM_TYPE", "EXTRA_VOLUME_STREAM_VALUE", "EXTRA_PREV_VOLUME_STREAM_VALUE", "hasRegisteredSelf", "", "registerSelf", "", "unregisterSelf", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioVolumeChangeReceiver extends BroadcastReceiver {
    public static final AudioVolumeChangeReceiver a = null;
    public static boolean b;

    static {
        a = new AudioVolumeChangeReceiver();
    }

    public final synchronized void c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        b = true;     // Catch: Throwable -> L11
        a(AppHost.a.getApplication(), this, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final synchronized void d() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (b == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        b = false;     // Catch: Throwable -> L16
        b(AppHost.a.getApplication(), this);     // Catch: Exception -> L12 Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        FLogger.a.e("AudioVolumeChangeReceiver", "unregisterSelf error[" + e + ']', e);     // Catch: Throwable -> L16
        goto L14
    }

    private AudioVolumeChangeReceiver() {
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Application r1, AudioVolumeChangeReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getAction();
    L6:
        if (Intrinsics.areEqual("android.media.VOLUME_CHANGED_ACTION", r5) == true) goto L16;
        return;
    L16:
    L13:
        e = move-exception;
        FLogger.a.e("AudioVolumeChangeReceiver", "onReceive failed", e);
        return;
    L9:
        if (r4.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) goto L11;
        return;
    L11:
        int r6 = r4.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);     // Catch: Exception -> L13
        int r7 = r4.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1);     // Catch: Exception -> L13
        GlobalAudioController.a.onVolumeChanged(r6, r7);     // Catch: Exception -> L13
        return;
    L4:
        r5 = null;
        goto L6
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r8, AudioVolumeChangeReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
