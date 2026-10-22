package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/live/openplatform/impl/minigameanchor/cloudgame/LiveMgXplayRtcContextService$mRtcListener$2$1", "invoke", "()Lcom/bytedance/android/live/openplatform/impl/minigameanchor/cloudgame/LiveMgXplayRtcContextService$mRtcListener$2$1;"}, k = 3, mv = {1, 4, 3})
public final class LiveMgXplayRtcContextService$mRtcListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ LiveMgXplayRtcContextService this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.LiveMgXplayRtcContextService$mRtcListener$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ii6.a {
        public final /* synthetic */ LiveMgXplayRtcContextService$mRtcListener$2 a;

        public AnonymousClass1(LiveMgXplayRtcContextService$mRtcListener$2 r1) {
            this.a = r1;
        }

        public final void H(ei6.a r11, final int r12, final long r13, final Exception r15) {
            UtilityKotlinExtentionsKt.s(0, false, false, new LiveMgXplayRtcContextService$mRtcListener$2$1$onError$1(this, r13, r15, r12), 7);
        }

        public final void M(final ei6.a r7, final int r8, long r9, final Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "params");
            UtilityKotlinExtentionsKt.s(0, false, false, new LiveMgXplayRtcContextService$mRtcListener$2$1$onInfo$1(this, r8, r7, r11), 7);
        }
    }

    public LiveMgXplayRtcContextService$mRtcListener$2(LiveMgXplayRtcContextService r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m772invoke() {
        return invoke();
    }
}
