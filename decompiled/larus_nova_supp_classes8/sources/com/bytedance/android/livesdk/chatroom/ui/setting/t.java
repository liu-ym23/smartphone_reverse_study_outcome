package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t extends mx.l {
    public t() {
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.b.getValue()).booleanValue() == true) goto L10;
        Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.b.a.a();
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L10;
        boolean r5 = true;
    L11:
        Integer r1 = (Integer) com.bytedance.android.livesdk.sharedpref.b.a.a();
        if (r1 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        super("画面镜像", null, r5, false, r7, null, 106);
        return;
    L15:
        if (r1.intValue() != 1) goto L17;
        r7 = true;
    L10:
        r5 = false;
        goto L11
    }

    public final void c(SwitchSettingViewHolder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r2, "holder");
        ((mx.l) this).l = r3;
        xs2.b.a().post(new h1(22));
    }
}
