package com.larus.bmhome.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class VolumeChangedObserver {
    public VolumeBroadcastReceiver a;
    public b b;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/audio/VolumeChangedObserver$VolumeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/larus/bmhome/audio/VolumeChangedObserver;)V", "lastVolumeChangeTime", "", "supportStreamTypes", "", "", "[Ljava/lang/Integer;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class VolumeBroadcastReceiver extends BroadcastReceiver {
        public long a;
        public final Integer[] b;
        public final /* synthetic */ VolumeChangedObserver c;

        public VolumeBroadcastReceiver(VolumeChangedObserver r3) {
            this.c = r3;
            this.b = new Integer[]{3, 0, 6};
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r9, Intent r10) {
            if (r10 == null) goto L5;
            String r0 = r10.getAction();
        L7:
            if (Intrinsics.areEqual(r0, "android.media.VOLUME_CHANGED_ACTION") == false) goto L22;
        L18:
            e = move-exception;
            FLogger.a.e("VolumeChangedObserver", "getIntExtra EXTRA_VOLUME_STREAM_TYPE failed, message: " + e.getMessage());
            return;
        L9:
            if (ArraysKt.contains(this.b, Integer.valueOf(r10.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1))) == false) goto L23;
            long r2 = System.currentTimeMillis();     // Catch: Exception -> L18
            if ((r2 - this.a) <= 10) goto L16;
            int r1 = r10.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);     // Catch: Exception -> L18
            int r11 = r10.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1);     // Catch: Exception -> L18
            b r3 = this.c.b;     // Catch: Exception -> L18
            if (r3 == null) goto L15;
            r3.onVolumeChanged(r1, r11);     // Catch: Exception -> L18
        L15:
            this.a = r2;     // Catch: Exception -> L18
            return;
        L16:
            FLogger.a.i("VolumeChangedObserver", "Ignoring duplicate volume change event");     // Catch: Exception -> L18
            return;
        L23:
            return;
        L22:
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    public static final class a {
    }

    public interface b {
        void onVolumeChanged(int r1, int r2);
    }

    static {
    }

    public VolumeChangedObserver() {
    }

    public final void unregisterReceiver(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.b = null;
        VolumeBroadcastReceiver r1 = this.a;
        if (r1 == null) goto L19;
        ReceiverRegisterLancet.loge(r1, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L17;
        r4.unregisterReceiver(r1);
    L15:
        this.a = null;
        return;
    L17:
    L10:
        e = move-exception;
        if (r1 == null) goto L13;
        Npth.addTag("unregisterReceiver", r1.toString());
    L13:
        e.printStackTrace();
        goto L15
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r1, r4) == false) goto L15;
        r4.unregisterReceiver(r1);     // Catch: Exception -> L10
        goto L15
    }

    public final void registerReceiver(Context r9, b r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "onVolumeChangedListener");
        this.b = r10;
        if (this.a != null) goto L39;
        VolumeBroadcastReceiver r11 = new VolumeBroadcastReceiver(this);
        this.a = r11;
        IntentFilter r7 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L37:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r7);
        return;
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L21;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r7, 0, null, null, 2, r9).result;     // Catch: Exception -> L30
        if (r0 != 1) goto L14;
        r9.registerReceiver(r11, r7);     // Catch: Exception -> L30
    L36:
        return;
    L14:
        if (r0 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L36
    L16:
        if (r0 == 3) goto L36;
        r9.registerReceiver(r11, r7);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r9.registerReceiver(r11, r7, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L36
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r9.registerReceiver(r11, r7);     // Catch: Exception -> L30
        goto L36
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r7) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r9, r11, r7, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
        goto L36
    }
}
