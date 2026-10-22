package com.ss.android.lark.flow.chat.message.block.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.flow.chat.databinding.FlowChatAudioPlayBarBinding;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002BCB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010!\u001a\u00020\bJ\u0017\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010$J*\u0010&\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0016\u0010'\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\bH\u0002J2\u0010*\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u000103H\u0017J\u0010\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020-H\u0016J\u0010\u00109\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010:\u001a\u00020\u0019H\u0016J\b\u0010;\u001a\u00020\u0019H\u0016J\b\u0010<\u001a\u00020\u0019H\u0016J\b\u0010=\u001a\u00020\u0019H\u0016J\b\u0010>\u001a\u00020\u0019H\u0016J\b\u0010?\u001a\u00020\u0019H\u0016J\u0012\u0010@\u001a\u00020\u00192\b\u0010A\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/suite/lark/platform/component/widget_biz_chatkeyboard/widget/IAudioView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FlowChatAudioPlayBarBinding;", "hasSetupWaveDragListener", "", "audioPlayBarListener", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar$OnAudioPlayBarListener;", "getAudioPlayBarListener", "()Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar$OnAudioPlayBarListener;", "setAudioPlayBarListener", "(Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar$OnAudioPlayBarListener;)V", "audioViewListener", "Lcom/suite/lark/platform/component/widget_biz_chatkeyboard/widget/IAudioView$IAudioViewListener;", "primaryColor", "update", "", "cell", "Lcom/ss/android/lark/blueprint/ICell;", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "Lcom/ss/android/lark/chat/base/view/vo/message/AudioContentVO;", "block", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioContentBlock;", "data", "color", "setMatchTextWidthPx", "textWidthPx", "(Ljava/lang/Integer;)V", "updateMatchTextWidth", "updatePlayCb", "updateDuration", "updateDurationText", "durationInMs", "updateWave", "updateProgress", "progress", "", "updateViewStatusPlaying", "updateViewStatusPaused", "updateViewStatusStopped", "setDelegate", "mDelegate", "Lcom/suite/lark/platform/component/widget_biz_chatkeyboard/widget/PlayControlBar$PlayControlBarDelegate;", "setDuration", "duration", "getDurationText", "", "getProgress", "setProgress", "toggle", "togglePlay", "startPlay", "stopPlay", "pausePlay", "resumePlay", "setListener", "listener", "Companion", "OnAudioPlayBarListener", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowAudioPlayBar extends ConstraintLayout implements com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a {
    public static final LruCache<String, byte[]> e = null;
    public final FlowChatAudioPlayBarBinding a;
    public boolean b;
    public b c;
    public int d;

    public static final class a {
    }

    public interface b extends FlowAudioWaveView.b {
        void b(CheckBox r1);
    }

    public FlowAudioPlayBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowAudioPlayBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public float getProgress() {
        return 0.3f;
    }

    @Deprecated(message = "FlowAudioPlayBar 使用 OnAudioPlayBarListener 向外发送事件")
    public void setDelegate(PlayControlBar.a r1) {
    }

    public void setListener(com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC0243a r1) {
    }

    static {
        e = new LruCache(30);
    }

    public final void S5() {
        Log.d("FlowAudioPlayBar", "startPlay");
        this.a.b.setChecked(true);
        FlowAudioWaveView r0 = this.a.d;
        r0.getClass();
        r0.m = FlowAudioWaveView.PlayState.PLAYING;
        r0.l = r0.k;
        r0.invalidate();
    }

    public String getDurationText() {
        return this.a.c.getText().toString();
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void pausePlay() {
        this.a.b.setChecked(false);
        FlowAudioWaveView r0 = this.a.d;
        r0.getClass();
        r0.m = FlowAudioWaveView.PlayState.PAUSED;
        r0.l = r0.k;
        r0.invalidate();
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void stopPlay() {
        this.a.b.setChecked(false);
        FlowAudioWaveView r0 = this.a.d;
        r0.getClass();
        r0.m = FlowAudioWaveView.PlayState.STOPPED;
        r0.l = 0.0f;
        r0.invalidate();
        this.a.d.setProgress(0.0f);
    }

    public final b getAudioPlayBarListener() {
        return this.c;
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void resumePlay() {
        S5();
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void startPlay() {
        S5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setMatchTextWidthPx(Integer r3) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L8:
        if (r4 > 0) goto L12;
        r4 = -2;
    L12:
        if (r0.width == r4) goto L15;
        r0.width = r4;
        setLayoutParams(r0);
        requestLayout();
        return;
    L15:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(int r3) {
        this.a.c.setText(String.valueOf(r3 / AudioViewModel.ASR_SESSION_IDLE) + 8243);
        this.a.c.setTextColor(UDColorUtils.getColor(getContext(), this.d));
    }

    public final void setAudioPlayBarListener(b r1) {
        this.c = r1;
    }

    public void setDuration(int r1) {
        R5(r1);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public void setProgress(float r2) {
        this.a.d.setProgress(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowAudioPlayBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = 2131102053;
        LayoutInflater.from(getContext()).inflate(2131561118, this, true);
        int r5 = 2131363411;
        CheckBox r6 = (CheckBox) ViewBindings.findChildViewById(this, 2131363411);
        if (r6 == null) goto L11;
        r5 = 2131363427;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131363427);
        if (r7 == null) goto L11;
        r5 = 2131363517;
        FlowAudioWaveView r0 = (FlowAudioWaveView) ViewBindings.findChildViewById(this, 2131363517);
        if (r0 == null) goto L11;
        this.a = new FlowChatAudioPlayBarBinding(this, r6, r7, r0);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ FlowAudioPlayBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(m<y6b.a<AudioContentVO>> r6, FlowAudioContentBlock r7, y6b.a<AudioContentVO> r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "block");
        Intrinsics.checkNotNullParameter(r8, "data");
        setTag(2131363449, r8.getId());
        this.d = r9;
        this.a.b.setButtonDrawable(UDIconUtils.getIconDrawable(getContext(), 2131235415, UDColorUtils.getColor(getContext(), this.d)));
        this.a.b.setBackground(null);
        this.a.b.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.audio.b(this));
        R5(r8.b().g());
        String r10 = r8.getId();
        FlowAudioWaveView r0 = this.a.d;
        r0.setBarSpacingPx(UIUtils.dp2px(r0.getContext(), 2.0f));
        r0.setBarWidthPx(UIUtils.dp2px(r0.getContext(), 2.5f));
        r0.setCornerRadiusPx(UIUtils.dp2px(r0.getContext(), 5.0f));
        r0.setMinBarHeightPx(UIUtils.dp2px(r0.getContext(), 3.5f));
        r0.setPlayedColor(UIUtils.getColor(r0.getContext(), this.d));
        r0.setUnPlayedColor(UIUtils.getColor(r0.getContext(), this.d) & 1275068415);
        byte[] r1 = r8.b().v;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L11:
        if (r2 == false) goto L13;
        e.put(r10, (byte[]) r1.clone());
    L14:
        r0.setWaveformBytes(r1);
        if (this.b == true) goto L17;
        this.b = true;
        r0.setOnProgressDragListener(new c(this));
    L17:
        r0.setOnLongClickListener(new d(r6, r7, r8));
        return;
    L13:
        r1 = e.get(r10);
        goto L14
    L5:
        if (r1.length != 0) goto L7;
        boolean r4 = true;
    L9:
        if ((!r4) != true) goto L11;
        r2 = true;
        goto L11
    L7:
        r4 = false;
        goto L9
    }
}
