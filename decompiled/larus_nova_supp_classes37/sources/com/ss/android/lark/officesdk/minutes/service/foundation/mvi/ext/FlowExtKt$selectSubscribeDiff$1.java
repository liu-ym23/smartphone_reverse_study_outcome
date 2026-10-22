package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "A", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class FlowExtKt$selectSubscribeDiff$1 extends Lambda implements Function2 {
    public static final FlowExtKt$selectSubscribeDiff$1 INSTANCE = null;

    static {
        INSTANCE = new FlowExtKt$selectSubscribeDiff$1();
    }

    public FlowExtKt$selectSubscribeDiff$1() {
        super(2);
    }

    public final Boolean invoke(Object r1, Object r2) {
        return Boolean.valueOf(Intrinsics.areEqual(r1, r2));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m184invoke(Object r1, Object r2) {
        return invoke(r1, r2);
    }
}
