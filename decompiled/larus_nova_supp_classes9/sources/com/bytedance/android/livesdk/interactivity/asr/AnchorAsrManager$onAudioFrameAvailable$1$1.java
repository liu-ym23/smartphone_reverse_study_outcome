package com.bytedance.android.livesdk.interactivity.asr;

import android.os.Handler;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "length", BuildConfig.FLAVOR, "timestamp", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class AnchorAsrManager$onAudioFrameAvailable$1$1 extends Lambda implements Function3<byte[], Integer, Long, Unit> {
    final /* synthetic */ Handler $this_apply;

    public AnchorAsrManager$onAudioFrameAvailable$1$1(Handler r1) {
        this.$this_apply = r1;
        super(3);
    }

    public final void invoke(byte[] r3, int r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Handler r0 = this.$this_apply;
        r0.sendMessage(r0.obtainMessage(3, new AnchorAsrManager.b(r3, r4, r5)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        invoke((byte[]) r3, ((Number) r4).intValue(), ((Number) r5).longValue());
        return Unit.INSTANCE;
    }
}
