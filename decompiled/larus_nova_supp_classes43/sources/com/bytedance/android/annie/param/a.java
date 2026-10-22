package com.bytedance.android.annie.param;

import android.os.Bundle;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends c7.a {
    public ILatchService.e a;
    public Function0<Unit> b;
    public int c;
    public final x8.b d;
    public final s7.c e;

    public a() {
        this(null, null, null, 31);
    }

    public a(b7.b r10, Bundle r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r12 = null;
    L11:
        super(r10, r11, r12);
        this.a = null;
        this.b = null;
        this.d = new x8.b(getUuid());
        if (r11 == null) goto L15;
        r11.putString("annie_uuid_key", getUuid());
    L15:
        if (AnnieConfigSettingKeys.ANNIE_OPEN_MULTI_WINDOW.a().booleanValue() == false) goto L17;
        s7.c r14 = new s7.a(this);
    L18:
        this.e = r14;
        return;
    L17:
        r14 = new s7.b();
        goto L18
    }
}
