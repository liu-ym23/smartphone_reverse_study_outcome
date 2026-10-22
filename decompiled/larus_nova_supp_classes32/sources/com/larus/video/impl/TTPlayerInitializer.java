package com.larus.video.impl;

import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.as;
import com.larus.settings.value.e10;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.sdk.constant.EasyGoCode;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import n2a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TTPlayerInitializer {
    public static TTVideoEngine a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/video/impl/TTPlayerInitializer$TTPlayerType;", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TTPlayerType {
    }

    static {
    }

    public static TTVideoEngine a(int r4, boolean r5) {
        if (a == null) goto L5;
        if (r5 == true) goto L5;
    L17:
        TTVideoEngine r6 = a;
        Intrinsics.checkNotNull(r6);
        return r6;
    L5:
        boolean r0 = !r5;
        if (ObricLazyInitSettingsServiceDelegate.a.b() == false) goto L8;
        FLogger.a.i("BackgroundLazyInit", "event=component_init_request, component=VideoEngine, trigger=first_use");
        c.a.getClass();
        c.a();
    L8:
        HashMap r1 = new HashMap();
        r1.put("enable_looper", Boolean.TRUE);
        if (r0 == false) goto L11;
        r1.put("callback_looper", Looper.getMainLooper());
    L11:
        TTVideoEngine r2 = new TTVideoEngine(AppHost.a.getApplication(), r4, r1);
        r2.setIntOption(160, 1);
        r2.setIntOption(450, 1);
        r2.setIntOption(471, 1);
        r2.setIntOption(415, 1);
        r2.setIntOption(402, 1);
        r2.setIntOption(21, 1);
        r2.setIntOption(314, 1);
        r2.setIntOption(602, 1);
        r2.setIntOption(0, 1);
        r2.setIntOption(17, 1);
        r2.setIntOption(33, 1);
        r2.setIntOption(7, 1);
        r2.setIntOption(424, 2);
        r2.setIntOption(425, 0);
        r2.setIntOption(313, 1);
        r2.setIntOption(27, 1);
        r2.setIntOption(329, 1);
        r2.setIntOption(EasyGoCode.InitializedErrCode.UNKNOWN_ERR, 1);
        r2.setIntOption(343, 1);
        e10 r3 = e10.a;
        int r7 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new as())).booleanValue() == true) goto L14;
        r2.setAsyncInit(true, 0);
    L14:
        if (r5 == false) goto L16;
        return r2;
    L16:
        a = r2;
        goto L17
    }
}
