package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.relax.relaxframework.j5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0000j\b\u0012\u0004\u0012\u00020\u0004`\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Function0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Lcom/relax/relaxframework/StateGetter;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__5$1$match__5$2$1$1$listItems__0$2 extends Lambda implements Function2<Function0<? extends Room>, Function0<? extends Integer>, j5> {
    final /* synthetic */ MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__5$1$match__5$2.AnonymousClass1.C02771 this$0;

    public MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__5$1$match__5$2$1$1$listItems__0$2(MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__5$1$match__5$2.AnonymousClass1.C02771 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function0) r1, (Function0) r2);
    }

    public final j5 invoke(final Function0<Room> r2, final Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "index");
        return (j5) new AnonymousClass1(this, r3, r2).invoke();
    }
}
