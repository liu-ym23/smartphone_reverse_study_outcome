package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000 \u0005*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u00040\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"E", "", "new", "Lio/reactivex/ObservableSource;", "Lcom/bytedance/android/live/core/utils/rxutils/g;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/util/Set;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RxUtilKt$flatDiff$1$1 extends Lambda implements Function1<Set<Object>, ObservableSource<g<Object, Object>>> {
    final /* synthetic */ Ref.ObjectRef $last;

    public RxUtilKt$flatDiff$1$1(Ref.ObjectRef r1) {
        this.$last = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Set) r1);
    }

    public final ObservableSource<g<Object, Object>> invoke(Set<Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "new");
        Set<Object> r1 = r7;
        Set r0 = SetsKt.minus((Set) this.$last.element, r1);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Object r4 = r3.next();
        r2.add(new g.c(r4, r4));
        goto L4
    L6:
        Set r8 = SetsKt.minus(r7, (Set) this.$last.element);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        Object r6 = r9.next();
        r5.add(new g.a(r6, r6));
        goto L8
    L10:
        Ref.ObjectRef r11 = this.$last;
        r11.element = CollectionsKt.toSet(r1);
        return Observable.concat(Observable.fromIterable(r2), Observable.fromIterable(r5));
    }
}
