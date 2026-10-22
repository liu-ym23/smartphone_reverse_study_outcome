package com.bytedance.android.live.revenue.common;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a.\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0004\u0012\u0002H\u00030\u00020\u0001j\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0004\u0012\u0002H\u00030\u0002`\u0004\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "T", "Lcom/bytedance/revenue/platform/api/core/rx/Observable;", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class PropertyOwnersKt$diff$1 extends Lambda implements Function0<Observable<Pair<Object, Object>>> {
    final /* synthetic */ Observable $this_diff;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Ref.ObjectRef a;

        public a(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            Pair r0 = TuplesKt.to(this.a.element, r3);
            this.a.element = r3;
            return r0;
        }
    }

    public PropertyOwnersKt$diff$1(Observable r1) {
        this.$this_diff = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m302invoke() {
        return invoke();
    }

    public final Observable<Pair<Object, Object>> invoke() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        return this.$this_diff.map(new a(r0));
    }
}
