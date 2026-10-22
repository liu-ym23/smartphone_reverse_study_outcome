package com.larus.bmhome.chat.component.bottom.voice;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\rH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/voice/VoiceMixInputPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "visualizer", "Lcom/larus/common_ui/widget/input/AudioVisualizerOpt;", "startVoiceInput", "", "stopVoiceInput", "updateAudioData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "data", "", "setImmersiveMode", "immersiveColor", "initAudioVisualizer", "getVisualizer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VoiceMixInputPanel extends FrameLayout {
    public AudioVisualizerOpt a;

    public VoiceMixInputPanel(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceMixInputPanel(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final AudioVisualizerOpt getVisualizer() {
        AudioVisualizerOpt r0 = this.a;
        if (r0 == null) goto L7;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
        goto L7
    L8:
        return r0;
    L7:
        return null;
    }

    public final void setImmersiveMode(int r5) {
        AudioVisualizerOpt r0 = this.a;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
        r0 = null;
    L6:
        r0.setPaintColor(getResources().getColor(2131103298));
    L7:
        TextView r1 = (TextView) findViewById(2131363432);
        if (r1 == null) goto L10;
        r1.setTextColor(getResources().getColor(2131106540));
    L10:
        ImageView r2 = (ImageView) findViewById(2131367930);
        if (r2 == null) goto L13;
        r2.setImageTintList(ColorStateList.valueOf(r5));
    L13:
        RoundConstraintLayout r6 = findViewById(2131367924);
        if (r6 == null) goto L19;
        c29.a r7 = r6.getDelegate();
        if (r7 == null) goto L20;
        r7.a(getResources().getColor(2131103298));
        return;
    L20:
        return;
    }

    public final void a(CoroutineScope r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "data");
        AudioVisualizerOpt r0 = getVisualizer();
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    public VoiceMixInputPanel(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        FrameLayout.inflate(r5, 2131562935, this);
        FrameLayout r8 = (FrameLayout) findViewById(2131363513);
        if (r8 == null) goto L14;
        AudioVisualizerOpt r9 = new AudioVisualizerOpt(getContext());
        this.a = r9;
        r9.setPaintColor(getResources().getColor(v19.c.b(2130972123, r8.getContext(), 2131103203)));
        AudioVisualizerOpt r10 = this.a;
        View r11 = null;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
        r10 = null;
    L8:
        r10.getClass();
        r10.n = RangesKt.coerceAtLeast(5, 0);
        r10.o = RangesKt.coerceAtLeast(5, 0);
        View r12 = this.a;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
    L12:
        r8.addView(r11, new FrameLayout.LayoutParams(-1, -1));
        return;
    L11:
        r11 = r12;
        goto L12
    }

    public /* synthetic */ VoiceMixInputPanel(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
