package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.core.utils.f2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class RecordReplayHighlightsSetting$doCheckStateChangedNew$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final RecordReplayHighlightsSetting$doCheckStateChangedNew$2 INSTANCE = null;

    static {
        INSTANCE = new RecordReplayHighlightsSetting$doCheckStateChangedNew$2();
    }

    public RecordReplayHighlightsSetting$doCheckStateChangedNew$2() {
        super(1);
    }

    public final void invoke(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        f2.c(com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r2), 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
