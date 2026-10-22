package com.ss.android.lark.message.universalcard.datachannel;

import com.larksuite.component.card.protocol.CardActionDataSource;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ Ref.ObjectRef<CardData> a;
    public final /* synthetic */ MessageCardDataService b;

    public c(Ref.ObjectRef<CardData> r1, MessageCardDataService r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = ((CardData) this.a.element).getUniversalCardID();
        if (r0 == null) goto L9;
        CardRenderData r1 = this.b.b.get(r0);
        if (r1 == null) goto L10;
        Ref.ObjectRef<CardData> r2 = this.a;
        CardData.a r3 = CardData.Companion;
        CardData r4 = (CardData) r2.element;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "cardData");
        CardData.a.a r5 = new CardData.a.a();
        String r6 = r4.getCardID();
        Intrinsics.checkNotNullParameter(r6, "cardID");
        r5.a = r6;
        r5.b = r4.getUniversalCardID();
        r5.d = r4.getUniversalCardVersion();
        r5.c = r4.getVersion();
        r5.e = r4.getCardContent();
        r5.f = r4.getTranslateContent();
        r5.h = r4.getTranslateInfo();
        r5.g = r4.getComponentStatus();
        r5.i = r4.getActionInfo();
        r5.j = r4.isStreamingMode();
        r5.k = r4.getStreamingConfig();
        r5.l = r4.getCardDataSource();
        CardActionDataSource r7 = r4.getActionDataSource();
        Intrinsics.checkNotNullParameter(r7, "dataSource");
        r5.m = r7;
        r5.o = r4.getHostCardId();
        String r8 = r1.getCardData().getCardID();
        Intrinsics.checkNotNullParameter(r8, "cardID");
        r5.a = r8;
        CardActionDataSource r9 = CardActionDataSource.STREAMING_CARD_ENTITY;
        Intrinsics.checkNotNullParameter(r9, "dataSource");
        r5.m = r9;
        r2.element = r5.a();
        CardContext r10 = r1.getCardContext();
        CardConfig r11 = r1.getCardConfig();
        String r12 = r1.getBizID();
        this.b.g(new CardRenderData(CardRenderData.LinkType.STREAMING_POLLING, r12, (CardData) this.a.element, r10, r11), true);
        return;
    L10:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
