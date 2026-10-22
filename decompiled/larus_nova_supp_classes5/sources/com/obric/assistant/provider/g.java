package com.obric.assistant.provider;

import android.content.UriMatcher;
import com.obric.assistant.settings.ToggleName;
import com.obric.assistant.settings.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class g implements Function0 {
    public /* synthetic */ g() {
    }

    public final Object invoke() {
        UriMatcher r0 = ObricLocalDataSearchDomainProvider.f;
        EnumEntries r1 = ToggleName.getEntries();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((!((ToggleName) r4).isDeprecated()) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        CollectionsKt.addAll(r5, i.a((ToggleName) r6.next()));
        goto L10
    L13:
        return CollectionsKt.toSet(r5);
    }
}
