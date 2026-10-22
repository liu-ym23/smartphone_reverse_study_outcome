package com.bytedance.ai.applet.app.foundation;

import android.os.Bundle;
import android.os.ResultReceiver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final void a(ResultReceiver r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Bundle r0 = new Bundle();
        r0.putString(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r11);
        r10.send(1, r0);
    }
}
