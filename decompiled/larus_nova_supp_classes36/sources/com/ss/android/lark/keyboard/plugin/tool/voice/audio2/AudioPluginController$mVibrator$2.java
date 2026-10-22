package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.os.Vibrator;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AudioPluginController$mVibrator$2 extends Lambda implements Function0<Vibrator> {
    final /* synthetic */ h this$0;

    public AudioPluginController$mVibrator$2(h r1) {
        this.this$0 = r1;
        super(0);
    }

    public final Vibrator invoke() {
        h r0 = this.this$0;
        int r1 = h.a;
        Object r2 = r0.c().getSystemService("vibrator");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) r2;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1199invoke() {
        return invoke();
    }
}
