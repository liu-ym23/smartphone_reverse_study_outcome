package com.larus.chat.gallery.impl.preview.input;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.CameraTabConfig;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements IIMCallback<BotModel> {
    public final /* synthetic */ g a;
    public final /* synthetic */ String b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("BotModelCacheHelper", "preloadBotModel: failed, error=" + r4);
    }

    public final void onSuccess(Object r8) {
        BotModel r9 = (BotModel) r8;
        Intrinsics.checkNotNullParameter(r9, "result");
        g r0 = this.a;
        Object r1 = r0.c;
        monitor-enter(r1);
        r0.e = r9;     // Catch: Throwable -> L36
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r1);
        g r3 = this.a;
        r3.getClass();
        t0.e(new e(r3, r9));
        Map r4 = r9.getCameraTabConfigMap();
        List r5 = null;
        if (r4 == null) goto L9;
        CameraTabConfig r6 = (CameraTabConfig) r4.get("all_camera");
    L10:
        Map r7 = r9.getCameraTabConfigMap();
        if (r7 == null) goto L13;
        CameraTabConfig r10 = (CameraTabConfig) r7.get("input_left");
    L14:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("preloadBotModel: success, keys=");
        Map r13 = r9.getCameraTabConfigMap();
        if (r13 == null) goto L17;
        Set r14 = r13.keySet();
    L18:
        r12.append(r14);
        r12.append(", allCamera.cameraName=");
        if (r6 == null) goto L21;
        String r15 = r6.getCameraName();
    L22:
        r12.append(r15);
        r12.append(", inputLeft.tips=");
        if (r10 == null) goto L25;
        r5 = r10.getTips();
    L25:
        r12.append(r5);
        r11.i("BotModelCacheHelper", r12.toString());
        final g r16 = this.a;
        final String r17 = this.b;
        final Map r18 = r9.getCameraTabConfigMap();
        r16.getClass();
        if (r18 != null) goto L28;
    L31:
        boolean r19 = true;
    L32:
        if (r19 == true) goto L41;
        r16.b.execute(new d(r17, r16, r18));
        return;
    L41:
        return;
    L28:
        if (r18.isEmpty() == true) goto L31;
        r19 = false;
        goto L32
    L21:
        r15 = null;
        goto L22
    L17:
        r14 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        r6 = null;
    L36:
        th = move-exception;
        throw th;
    }

    public i(g r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
