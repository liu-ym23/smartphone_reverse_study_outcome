package com.bytedance.android.livesdk.debugtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.livesdk.utils.v5;
import com.ss.alog.middleware.ALogService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/debugtools/AntiDeteriorationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AntiDeteriorationBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
    }

    static {
    }

    public AntiDeteriorationBroadcastReceiver() {
        this.a = "AntiDeterioration";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        if (r3 != null) goto L4;
    L12:
        ALogService.eSafely(this.a, "onReceive");
        return;
    L4:
        if ("android.intent.action.ANTI_DETERIORATION".equals(r3.getAction()) == false) goto L12;
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L8;
        Object r5 = r4.get("key");
    L10:
        if (Intrinsics.areEqual(r5, "enter_room") == false) goto L12;
        v5.a().putBoolean("live.enter.room.key", true).apply();
        FileUtils.a();
        ALogService.eSafely(this.a, "enter_room 开关已经打开");
        goto L12
    L8:
        r5 = null;
        goto L10
    }
}
