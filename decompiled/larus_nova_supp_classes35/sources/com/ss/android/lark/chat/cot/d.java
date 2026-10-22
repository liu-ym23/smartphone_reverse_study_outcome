package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Grouping<CotEvent, CotEventType> {
    public final /* synthetic */ Iterable a;

    public final Iterator<CotEvent> sourceIterator() {
        return this.a.iterator();
    }

    public d(Iterable r1) {
        this.a = r1;
    }

    public final CotEventType keyOf(CotEvent r1) {
        return r1.getEventType();
    }
}
