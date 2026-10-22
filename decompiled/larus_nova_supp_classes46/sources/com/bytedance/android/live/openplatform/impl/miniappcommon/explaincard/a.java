package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a<T> {
    View getExplainCardView();

    Function0<Unit> getOnBtnClickBlock();

    Function0<Unit> getOnClickBlock();

    Function0<Unit> getOnCloseBlock();

    void setData(T r1);

    void setOnBtnClickBlock(Function0<Unit> r1);

    void setOnClickBlock(Function0<Unit> r1);

    void setOnCloseBlock(Function0<Unit> r1);

    void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r1);
}
