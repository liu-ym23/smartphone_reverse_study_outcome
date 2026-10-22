package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a<T> {
    int getType();

    void setData(T r1);

    void setOnClickBlock(Function0<Unit> r1);

    void setOnCloseBlock(Function0<Unit> r1);
}
