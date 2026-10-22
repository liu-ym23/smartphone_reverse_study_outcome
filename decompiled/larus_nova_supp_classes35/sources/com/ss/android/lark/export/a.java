package com.ss.android.lark.export;

import android.view.View;
import com.bytedance.lark.pb.basic.v1.CardComponent;
import com.bytedance.lark.pb.basic.v1.EngineEntity;
import com.ss.android.lark.export.engine.smartcard.SmartCardEngineProperty;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.url.card.UrlCardProperty;
import q6c.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a<T extends q6c.e<? extends Props, ? extends View, ? extends r6c.a>> {
    void a();

    com.ss.android.lark.url.card.c b(SmartCardEngineProperty r1, TCStyle r2, vcb.d r3);

    UrlCardProperty c(CardComponent.EngineProperty r1, EngineEntity r2);
}
