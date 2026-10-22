package com.bytedance.android.bcm.impl.chain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkc/a;", "", "it", "Lorg/json/JSONArray;", "invoke", "(Lkc/a;Z)Lorg/json/JSONArray;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class BcmChainEventParamAppender$append$2 extends Lambda implements Function2<kc.a, Boolean, JSONArray> {
    public static final BcmChainEventParamAppender$append$2 INSTANCE = null;

    static {
        INSTANCE = new BcmChainEventParamAppender$append$2();
    }

    public BcmChainEventParamAppender$append$2() {
        super(2);
    }

    public final JSONArray invoke(kc.a r10, boolean r11) {
        List<kc.a.C0174a> r12 = r10.a;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13.add(((kc.a.C0174a) r14.next()).c);
        goto L4
    L7:
        return new JSONArray(r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((kc.a) r1, ((Boolean) r10).booleanValue());
    }
}
