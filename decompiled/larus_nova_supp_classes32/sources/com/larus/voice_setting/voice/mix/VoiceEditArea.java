package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.lottieadapter.LottieAdapterView;
import com.lynx.tasm.LynxTemplateRender;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002J>\u0010%\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\u0016\u0010+\u001a\u00020\u00102\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-J\u0016\u0010/\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001001H\u0016J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020.2\b\b\u0002\u00104\u001a\u00020\u0016J$\u00105\u001a\u00020\u00102\f\u00106\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00107\u001a\u0002082\u0006\u00103\u001a\u00020.J\u0006\u00109\u001a\u00020\u0010J\u0018\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0016H\u0002J\u0006\u0010=\u001a\u00020\u0010J\u000e\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020@J\u0016\u0010A\u001a\u00020\u00102\u0006\u00103\u001a\u00020.2\u0006\u0010B\u001a\u00020\bJ\u0014\u0010C\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020.0-J\u0010\u0010D\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010FJ \u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u000fH\u0002J\f\u0010K\u001a\u00020\u0010*\u00020LH\u0002J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006R"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceEditArea;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoicePlayButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/voice/mix/ILayoutVoiceEditAreaBinding;", "pitchChangeAction", "Lkotlin/Function1;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "speechRateChangeAction", "selectVoiceMode", "Ljava/lang/Integer;", "renderingItemCount", "defaultExpandMixVoiceView", NameKeys.UnloadStrategy_No_Strategy, "defaultCollapsing", "getDefaultCollapsing", "()Z", "setDefaultCollapsing", "(Z)V", "voiceMixView", "Lcom/larus/voice_setting/voice/mix/VoiceMixedView;", "getVoiceMixView", "()Lcom/larus/voice_setting/voice/mix/VoiceMixedView;", "voiceSingleView", "Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "getVoiceSingleView", "()Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "initViewBindingByMode", "initViews", "processVoiceAudition", LynxTemplateRender.RENDER_PHASE_UPDATE, "Lcom/larus/voice_setting/voice/mix/res/VoiceAuditionUpdate;", "hidePitchAndRate", "initPitchAndRate", "initMixViewByVoiceList", "voiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/bot/MixVoice;", "delegatePlayMixVoice", "callback", "Lkotlin/Function0;", "onVoiceAdd", "voice", "byReset", "onVoiceRemove", "mixVoiceList", "from", NameKeys.UnloadStrategy_No_Strategy, "onVoiceClear", "applyCheckSingleVoice", "count", "defaultCollapse", "expandDefaultCollapsing", "refreshPitchAndRate", LynxResourceModule.DATA_KEY, "Lcom/larus/voice_setting/voice/editvoice/VoicePitchAndRate;", "onVoiceUpdate", "index", "onVoiceListUpdate", "onSingleVoiceSelected", "speakVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "reportVoiceEditResult", "scene", "voicePith", "voiceSpeed", "updateVoiceEmptyText", "Landroid/view/View;", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEditArea extends ConstraintLayout implements com.larus.voice_setting.voice.mix.a {
    public static final /* synthetic */ int h = 0;
    public v2a.a a;
    public Function1<? super Float, Unit> b;
    public Function1<? super Float, Unit> c;
    public Integer d;
    public int e;
    public boolean f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public VoiceEditArea(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceEditArea(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void T5() {
        v2a.a r0 = this.a;
        if (r0 == null) goto L7;
        ConstraintLayout r1 = r0.a();
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        v2a.a r2 = this.a;
        if (r2 == null) goto L12;
        View r3 = r2.f();
        if (r3 == null) goto L12;
        r3.setVisibility(0);
    L12:
        v2a.a r4 = this.a;
        if (r4 == null) goto L18;
        VoiceMixedView r5 = r4.d();
        if (r5 == null) goto L19;
        r5.k.clear();
        r5.removeAllViews();
        return;
    L19:
        return;
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public ImageView getPlayIcon() {
        v2a.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayIcon();
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public LottieAdapterView getPlayLottieView() {
        v2a.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final VoiceMixedView getVoiceMixView() {
        v2a.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final VoiceSingleView getVoiceSingleView() {
        v2a.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k();
    }

    public final boolean getDefaultCollapsing() {
        return this.g;
    }

    public final void setDefaultCollapsing(boolean r1) {
        this.g = r1;
    }

    public final void S5(int r4, boolean r5) {
        if (r4 <= 1) goto L9;
        v2a.a r0 = this.a;
        if (r0 == null) goto L15;
        View r1 = r0.e();
        if (r1 == null) goto L15;
        e1.x(r1);
    L15:
        if (r4 <= 0) goto L21;
        v2a.a r2 = this.a;
        if (r2 == null) goto L26;
        View r3 = r2.f();
        if (r3 == null) goto L26;
        r3.setVisibility(8);
    L26:
        if (r4 <= 0) goto L31;
        if (r5 == true) goto L31;
        v2a.a r6 = this.a;
        if (r6 == null) goto L35;
        r6.a().setVisibility(0);
        return;
    L35:
        return;
    L31:
        v2a.a r7 = this.a;
        if (r7 == null) goto L37;
        r7.a().setVisibility(8);
        return;
    L37:
        return;
    L21:
        v2a.a r8 = this.a;
        if (r8 == null) goto L26;
        View r9 = r8.f();
        if (r9 == null) goto L26;
        r9.setVisibility(0);
        goto L26
    L9:
        v2a.a r10 = this.a;
        if (r10 == null) goto L15;
        View r11 = r10.e();
        if (r11 == null) goto L15;
        e1.o(r11);
        goto L15
    }

    public VoiceEditArea(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ VoiceEditArea(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void R5(VoiceEditArea r1, String r2, float r3, float r4) {
        r1.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("edit_scene", r2);
        r5.put("voice_pitch", Float.valueOf(r3));
        r5.put("voice_speed", Float.valueOf(r4));
        o.a.reportEvent("voice_edit_result", r5);
    }
}
