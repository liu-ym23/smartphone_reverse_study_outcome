package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0006*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00050\u00050\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"K", "V", "", "new", "Lio/reactivex/ObservableSource;", "Lcom/bytedance/android/live/core/utils/rxutils/g;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/util/Map;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RxUtilKt$flatDiff$2$1 extends Lambda implements Function1<Map<Object, Object>, ObservableSource<g<Object, Object>>> {
    final /* synthetic */ Ref.ObjectRef $last;

    public RxUtilKt$flatDiff$2$1(Ref.ObjectRef r1) {
        this.$last = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map) r1);
    }

    public final ObservableSource<g<Object, Object>> invoke(Map<Object, Object> r9) {
        Intrinsics.checkNotNullParameter(r9, "new");
        Map r0 = (Map) this.$last.element;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        if ((!r9.containsKey(r3.getKey())) == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        ArrayList r4 = new ArrayList(r1.size());
        Iterator r5 = r1.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r6 = (Map.Entry) r5.next();
        r4.add(new g.c(r6.getKey(), r6.getValue()));
        goto L10
    L12:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<Object, Object>> r8 = r9.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Map.Entry<Object, Object> r11 = r8.next();
        if ((!((Map) this.$last.element).containsKey(r11.getKey())) == false) goto L14;
        r7.put(r11.getKey(), r11.getValue());
        goto L14
    L18:
        ArrayList r12 = new ArrayList(r7.size());
        Iterator r13 = r7.entrySet().iterator();
    L20:
        if (r13.hasNext() == false) goto L22;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.add(new g.a(r14.getKey(), r14.getValue()));
        goto L20
    L22:
        Set r15 = CollectionsKt.intersect(((Map) this.$last.element).keySet(), r9.keySet());
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L24:
        if (r17.hasNext() == false) goto L28;
        Object r18 = r17.next();
        if ((!Intrinsics.areEqual(((Map) this.$last.element).get(r18), r9.get(r18))) == false) goto L24;
        r16.add(r18);
        goto L24
    L28:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r21 = r16.iterator();
    L30:
        if (r21.hasNext() == false) goto L32;
        Object r22 = r21.next();
        r19.add(new g.b(r22, MapsKt.getValue((Map) this.$last.element, r22), MapsKt.getValue(r9, r22)));
        goto L30
    L32:
        this.$last.element = MapsKt.toMap(r9);
        return Observable.concat(Observable.fromIterable(r4), Observable.fromIterable(r19), Observable.fromIterable(r12));
    }
}
