package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "info", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AudioPluginController$setDataProcessorDependency$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ h this$0;

    public AudioPluginController$setDataProcessorDependency$2(h r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        h r0 = this.this$0;
        int r1 = h.a;
        r0.m(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
