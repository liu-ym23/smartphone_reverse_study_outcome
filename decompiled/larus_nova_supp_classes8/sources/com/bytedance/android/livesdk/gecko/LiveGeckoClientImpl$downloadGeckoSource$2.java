package com.bytedance.android.livesdk.gecko;

import com.bytedance.geckox.utils.ResLoadUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveGeckoClientImpl$downloadGeckoSource$2 extends Lambda implements Function1<String, String> {
    final /* synthetic */ LiveGeckoClientImpl this$0;

    public LiveGeckoClientImpl$downloadGeckoSource$2(LiveGeckoClientImpl r1) {
        this.this$0 = r1;
        super(1);
    }

    public final String invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        LiveGeckoClientImpl r0 = this.this$0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "channel");
        return ResLoadUtils.getChannelPath(r0.d, LiveGeckoConfig.b(), r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
