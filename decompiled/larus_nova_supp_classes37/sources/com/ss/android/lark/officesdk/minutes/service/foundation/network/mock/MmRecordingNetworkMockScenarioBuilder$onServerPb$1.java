package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.squareup.wire.Message;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/squareup/wire/Message;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/internal/MmPBMessage;", "invoke", "(Lcom/squareup/wire/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRecordingNetworkMockScenarioBuilder$onServerPb$1 extends Lambda implements Function1<Message<?, ?>, Boolean> {
    public static final MmRecordingNetworkMockScenarioBuilder$onServerPb$1 INSTANCE = null;

    static {
        INSTANCE = new MmRecordingNetworkMockScenarioBuilder$onServerPb$1();
    }

    public MmRecordingNetworkMockScenarioBuilder$onServerPb$1() {
        super(1);
    }

    public final Boolean invoke(Message<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Boolean.TRUE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Message) r1);
    }
}
