package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DisplayMode;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioRotatableButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioWaveformWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001@\u0018\u0000 Y2\u00020\u0001:\u0001YB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020>H\u0016J\b\u0010H\u001a\u00020CH\u0016J\b\u0010I\u001a\u00020CH\u0016J\u0010\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u000fH\u0016J\u0018\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020>H\u0016J\u0010\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020>H\u0016J\u0010\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020>H\u0016J\b\u0010S\u001a\u00020CH\u0016J\u0010\u0010T\u001a\u00020C2\u0006\u0010U\u001a\u00020>H\u0002J\u0010\u0010V\u001a\u00020C2\u0006\u0010W\u001a\u00020\u000fH\u0002J\b\u0010X\u001a\u00020CH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001a\u001a\u0004\b0\u0010-R\u001b\u00102\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001a\u001a\u0004\b3\u0010-R\u001b\u00105\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u001a\u001a\u0004\b6\u0010-R\u001b\u00108\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b9\u0010\u0018R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010A¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/AudioWithTextPopupView;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/AbsAudioPopupViewWithEditText;", "context", "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mDisplayMode", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "mCancelBtnBottomMargin", "", "mCompleteLayoutId", "getMCompleteLayoutId", "()I", "mSimpleLayoutId", "getMSimpleLayoutId", "mBgLayout", "Landroid/view/ViewGroup;", "getMBgLayout", "()Landroid/view/ViewGroup;", "mBgLayout$delegate", "Lkotlin/Lazy;", "mEditText", "Landroidx/appcompat/widget/AppCompatEditText;", "getMEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "mEditText$delegate", "mWaveformWidget", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "getMWaveformWidget", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "mWaveformWidget$delegate", "mMainBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMMainBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "mMainBtn$delegate", "mCancelBtn", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioRotatableButton;", "getMCancelBtn", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioRotatableButton;", "mCancelBtn$delegate", "mSendAudioBtn", "getMSendAudioBtn", "mSendAudioBtn$delegate", "mSendTextBtn", "getMSendTextBtn", "mSendTextBtn$delegate", "mSendAllBtn", "getMSendAllBtn", "mSendAllBtn$delegate", "mContentContainer", "getMContentContainer", "mContentContainer$delegate", "imeWrapper", "Lcom/ss/android/lark/keyboard/ime/ImeWrapper;", "mIsSendClickInputEvent", "", "imeWrapperHeightChangeListener", "com/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/AudioWithTextPopupView$imeWrapperHeightChangeListener$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/AudioWithTextPopupView$imeWrapperHeightChangeListener$1;", "initImeWrapperIfNeed", "", "getEditText", "Landroid/widget/EditText;", "onSysKeyboardShowOrHide", "keyboardIsShown", "onMainBtnUpOrCancelEvent", "resetUI", "setVolume", "volume", "setDuration", "duration", "isElapseCountDown", "updateUIOnRecordStateChanged", "isRecording", "updateUIOnAsrFinish", "isAsrTimeOut", "onAsrLastFrameTimeOut", "toggleBtnVisibility", "showMainBtn", "updateContentBottomMargin", "margin", "stopBtnAnimation", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioWithTextPopupView extends AbsAudioPopupViewWithEditText {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public int getMCompleteLayoutId() {
        return 0;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public int getMSimpleLayoutId() {
        return 0;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public String getMTag() {
        return null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void R5() {
        super.R5();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void T5() {
        super.T5();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText
    public EditText getEditText() {
        return getMEditText();
    }

    private final AudioRotatableButton getMCancelBtn() {
        throw null;
    }

    private final ViewGroup getMContentContainer() {
        throw null;
    }

    private final AppCompatEditText getMEditText() {
        throw null;
    }

    private final AudioRotatableButton getMSendAllBtn() {
        throw null;
    }

    private final AudioRotatableButton getMSendAudioBtn() {
        throw null;
    }

    private final AudioRotatableButton getMSendTextBtn() {
        throw null;
    }

    private final AudioWaveformWidget getMWaveformWidget() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public ViewGroup getMBgLayout() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public UDButton getMMainBtn() {
        throw null;
    }

    public static final /* synthetic */ AudioRotatableButton Z5(AudioWithTextPopupView r0) {
        return r0.getMCancelBtn();
    }

    public static final /* synthetic */ AppCompatEditText b6(AudioWithTextPopupView r0) {
        return r0.getMEditText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void U5(final boolean r3) {
        super.U5(r3);
        if (AudioPluginEnums$DisplayMode.SIMPLE != null) goto L5;
        return;
    L5:
        int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.p(getMWaveformWidget(), new AudioWithTextPopupView$onSysKeyboardShowOrHide$1(r3, this));
        post(new AudioWithTextPopupView$onSysKeyboardShowOrHide$2(this, r3));
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.p(getMCancelBtn(), new AudioWithTextPopupView$onSysKeyboardShowOrHide$3(r3, this));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText
    public final void Y5(boolean r2) {
        super.Y5(r2);
        boolean r3 = !TextUtils.isEmpty(getMEditText().getText());
        getMSendTextBtn().R5(r3);
        getMSendAllBtn().R5(r3);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void setVolume(int r2) {
        super.setVolume(r2);
        getMWaveformWidget().T5(r2);
    }
}
