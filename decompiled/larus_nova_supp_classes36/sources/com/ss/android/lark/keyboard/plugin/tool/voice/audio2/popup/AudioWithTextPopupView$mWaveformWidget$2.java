package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioWaveformWidget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AudioWithTextPopupView$mWaveformWidget$2 extends Lambda implements Function0<AudioWaveformWidget> {
    final /* synthetic */ AudioWithTextPopupView this$0;

    public AudioWithTextPopupView$mWaveformWidget$2(AudioWithTextPopupView r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AudioWaveformWidget invoke() {
        return (AudioWaveformWidget) this.this$0.findViewById(2131363529);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1235invoke() {
        return invoke();
    }
}
