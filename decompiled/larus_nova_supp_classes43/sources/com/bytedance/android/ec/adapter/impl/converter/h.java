package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements ToolbarComponentCheckInterface {
    public final /* synthetic */ vd.a a;

    public h(vd.a r1) {
        this.a = r1;
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r10, Function0<Unit> r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "loadButton");
        Intrinsics.checkNotNullParameter(r12, "stopLoadCallback");
        this.a.a(new te.a(r10), r11, r12);
        return true;
    }
}
