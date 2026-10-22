package com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough;

import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class FeedBreakThroughBarState$teamTaskData$1 extends Lambda implements Function1<Map<String, Object>, Unit> {
    final /* synthetic */ String $value;

    public FeedBreakThroughBarState$teamTaskData$1(String r1) {
        this.$value = r1;
        super(1);
    }

    public final void invoke(Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.put("type", "refresh");
        r3.put(Constants.Keys.DATA, this.$value);
        r3.put("show_like_reword", Boolean.FALSE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Map) r1);
        return Unit.INSTANCE;
    }
}
