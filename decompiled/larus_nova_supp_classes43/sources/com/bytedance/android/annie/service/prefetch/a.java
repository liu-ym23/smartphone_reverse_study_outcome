package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a implements p {
    public final AnniePrefetchProcessor a;

    public a() {
        this.a = new AnniePrefetchProcessor();
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final String A0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return this.a.a(r10);
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final void E(t r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        AnniePrefetchProcessor r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        r1.c = r10;
        Observable.merge(SequencesKt.asIterable(SequencesKt.map(CollectionsKt.asSequence((Set) r1.b.getValue()), AnniePrefetchProcessor$initActual$itr$1.INSTANCE))).subscribeOn(Schedulers.io()).filter(j.a).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r1), l.a);
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final JSONObject getCacheJsonByScheme(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        AnniePrefetchProcessor r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        x46.a r0 = r1.d(r10);
        if (r0 == null) goto L49;
        List r11 = r0.getCacheByScheme(r10);
        if (r11 == null) goto L50;
        Iterator r12 = r11.iterator();
        JSONObject r13 = null;
    L8:
        if (r12.hasNext() == false) goto L35;
        PrefetchProcess r14 = (PrefetchProcess) r12.next();
        String r15 = r14.f.d;
        boolean r16 = true;
        if (r15.length() != 0) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == true) goto L8;
        com.bytedance.ies.tools.prefetch.i.b r18 = r14.d;
        if (r18 == null) goto L8;
        if ((r18 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == true) goto L20;
    L22:
        r16 = false;
    L23:
        if (r16 == true) goto L26;
        r18 = null;
    L26:
        if (r18 == null) goto L8;
        JSONObject r19 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r18).h.getValue();
        if (r19 == null) goto L8;
        JSONObject r20 = r19.optJSONObject("raw");
        if (r20 == null) goto L8;
        if (r13 != null) goto L33;
        r13 = new JSONObject();
    L33:
        r13.put(r15, r20);
        goto L8
    L20:
        if (r18.d != 200) goto L22;
    L12:
        r17 = false;
        goto L13
    L35:
        return r13;
    L50:
        return null;
    L49:
        return null;
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final void prefetch(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        AnniePrefetchProcessor r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        x46.a r0 = r1.d(r10);
        if (r0 == null) goto L6;
        r0.c(r10);
        return;
    }

    @Override // com.bytedance.android.annie.service.prefetch.p
    public final void r0(IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridComponent");
        AnniePrefetchProcessor r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "component");
        if ((!r0.a.isEmpty()) == false) goto L5;
        r10.registerMethod("__prefetch", new h(r0));
        return;
    L5:
        r10.registerMethod("__prefetch", i.a);
    }
}
