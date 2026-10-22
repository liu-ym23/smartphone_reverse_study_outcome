package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ n a;

    public l(n r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        List<IMEmoji> r6 = (List) r5;
        if (r6.isEmpty() == false) goto L5;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("ChatChannelEmojiManager get empty list");
        n r7 = this.a;
        r7.b = CollectionsKt.emptyList();
        n r8 = this.a;
        r8.c = MapsKt.emptyMap();
        return;
    L5:
        HashMap r0 = new HashMap();
        Iterator<IMEmoji> r1 = r6.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        IMEmoji r2 = r1.next();
        String r3 = r2.getDisplayName();
        if (r3 == null) goto L7;
        r0.put(r3, r2);
        goto L7
    L11:
        n r4 = this.a;
        r4.b = r6;
        r4.c = r0;
        StringBuilder r9 = new StringBuilder("ChatChannelEmojiManager get ");
        List<IMEmoji> r10 = this.a.b;
        if (r10 == null) goto L14;
        Integer r11 = Integer.valueOf(r10.size());
    L15:
        r9.append(r11);
        r9.append(" emoji");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r9.toString());
        return;
    L14:
        r11 = null;
        goto L15
    }
}
