package com.ss.android.lark.message.universalcard.datachannel;

import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.ss.android.lark.message.lynxcard.message.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    void b(String r1, String r2, p r3);

    void c(String r1, CardData r2, CardContext r3, CardConfig r4, boolean r5);

    CardRenderData d(String r1);

    void e(String r1, String r2, p r3);

    void onDestroy();
}
