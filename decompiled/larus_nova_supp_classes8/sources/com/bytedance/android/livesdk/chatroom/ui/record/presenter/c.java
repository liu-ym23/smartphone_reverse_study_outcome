package com.bytedance.android.livesdk.chatroom.ui.record.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IHostPlugin.Callback {
    public final /* synthetic */ QuickRecordingPresenter a;
    public final /* synthetic */ Function1 b;

    public final void onCancel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        this.b.invoke(Boolean.FALSE);
    }

    public final void onSuccess(String r26) {
        Intrinsics.checkNotNullParameter(r26, "packageName");
        String[] r2 = {"yuv", "c++_shared", "gaia_lib", "AGFX", "ttffmpeg", "iesapplogger", "bytenn", "audioeffect", "quick", "napi", "jazz", "bytevc0", "fastcv", "lens", "effect", "fdk-aac", "RealXBase", "RealXAudio", "RealX", "byteaudio", "vcbasekit", "bytevc1enc", "avframework"};
        IHostPlugin r9 = k.n(IHostPlugin.class);
        int r10 = 0;
        boolean r11 = false;
    L4:
        if (r10 >= 23) goto L13;
        String r0 = r2[r10];
        ALogger.e("QuickRecordingPresenter", "start load library:" + r0);     // Catch: Throwable -> L10
        boolean r3 = r9.loadLibrary(2, this.a.getContext(), r9.getHostPackageName(), r0, c.class.getClassLoader());     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r0, "yuv") == false) goto L12;
        if (r3 == false) goto L12;
        r11 = true;
    L12:
        r10 = r10 + 1;
    L10:
        th = move-exception;
        ALogger.e("quickshot", th);
        goto L12
    L13:
        QuickRecordingPresenter.p = r11;
        this.b.invoke(Boolean.TRUE);
    }

    public c(QuickRecordingPresenter r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
