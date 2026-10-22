package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.a8;
import com.relax.relaxframework.j5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0000j\b\u0012\u0004\u0012\u00020\u0004`\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Function0;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Lcom/relax/relaxframework/StateGetter;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/relax/relaxframework/j5;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2$2$3$listItems__1$2 extends Lambda implements Function2<Function0<? extends FeedItem>, Function0<? extends Integer>, j5> {
    final /* synthetic */ MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2.AnonymousClass2.AnonymousClass3 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2$2$3$listItems__1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<j5> {
        final /* synthetic */ Function0 $index;
        final /* synthetic */ Function0 $item;
        final /* synthetic */ MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2$2$3$listItems__1$2 this$0;

        public AnonymousClass1(MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2$2$3$listItems__1$2 r1, Function0 r2, Function0 r3) {
            this.this$0 = r1;
            this.$item = r2;
            this.$index = r3;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m849invoke() {
            return invoke();
        }

        public final j5 invoke() {
            j5 r0 = RelaxFrameworkKt.z(RelaxFrameworkKt.z, new a8(null), new MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2$2$3$listItems__1$2$1$switch__5$1(this));
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.relax.relaxframework.RxElement");
        }
    }

    public MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2$2$3$listItems__1$2(MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$4$1$switch__0$1$match__0$2$switch__1$1$match__1$2.AnonymousClass2.AnonymousClass3 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function0) r1, (Function0) r2);
    }

    public final j5 invoke(Function0<? extends FeedItem> r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "index");
        return (j5) new AnonymousClass1(this, r2, r3).invoke();
    }
}
