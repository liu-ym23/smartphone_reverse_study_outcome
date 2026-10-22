package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ ToolbarBroadcastFunction c;
    public final /* synthetic */ ToolbarBroadcastFunction d;

    public m(Function1 r1, long r2, ToolbarBroadcastFunction r4, ToolbarBroadcastFunction r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r6) {
        this.a.invoke(Boolean.FALSE);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.e("ToolbarBroadcastStatus", String.format("%d change %s to %s", Arrays.copyOf(new Object[]{Long.valueOf(this.b), this.c.name(), this.d.name()}, 3)), (Throwable) r6);
        f2.b(2131922687, 1);
    }
}
