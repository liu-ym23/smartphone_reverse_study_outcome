package com.bytedance.android.live.room.api.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    void a(Function1<? super Integer, Unit> r1, Function1<? super String, Unit> r2);

    PanelName getPanelName();

    int getUnionId();
}
