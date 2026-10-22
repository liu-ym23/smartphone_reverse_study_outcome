package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AdminRecordPermissionChanger a;

    public a(AdminRecordPermissionChanger r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        AdminRecordPermissionChanger r0 = this.a;
        if (((Boolean) r3).booleanValue() == true) goto L7;
        ALogger.i(r0.a, "管理员权限被下掉了");
        Function1<Boolean, Unit> r4 = r0.e;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke(Boolean.FALSE);
        return;
    L9:
        return;
    L7:
        r0.getClass();
    }
}
