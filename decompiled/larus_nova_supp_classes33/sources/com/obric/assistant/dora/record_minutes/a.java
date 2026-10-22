package com.obric.assistant.dora.record_minutes;

import android.media.AudioDeviceInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    public final Object invoke(Object r4) {
        AudioDeviceInfo r5 = (AudioDeviceInfo) r4;
        int r0 = DoraRecordMinutesProvider.a;
        Intrinsics.checkNotNullParameter(r5, "it");
        StringBuilder r1 = new StringBuilder("{id=");
        r1.append(r5.getId());
        r1.append(", type=");
        r1.append(r5.getType());
        r1.append(", hasAddress=");
        String r2 = r5.getAddress();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        r1.append(!r3);
        r1.append(", name=");
        r1.append(r5.getProductName());
        r1.append('}');
        return r1.toString();
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }
}
