package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "old", "new", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class FlowExtKt$subscribeAllDiff$2 extends Lambda implements Function2<Object, Object, Boolean> {
    final /* synthetic */ Function2<Object, Object, Boolean> $areEquivalent;

    public FlowExtKt$subscribeAllDiff$2(Function2<Object, Object, Boolean> r1) {
        this.$areEquivalent = r1;
        super(2);
    }

    public final Boolean invoke(Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "old");
        Intrinsics.checkNotNullParameter(r3, "new");
        return (Boolean) this.$areEquivalent.invoke(r2, r3);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m187invoke(Object r1, Object r2) {
        return invoke(r1, r2);
    }
}
