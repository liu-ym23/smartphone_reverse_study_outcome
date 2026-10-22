package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.h;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DisplayMode;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioPopupBackground;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001ZB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00109\u001a\u00020\u001eH\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u000208H\u0016J\u0010\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020\u000fH\u0016J\u0010\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\u000fH\u0016J\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u00020;H\u0016J\"\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u0002082\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0018\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u000208H\u0016J\b\u0010N\u001a\u00020;H\u0002J\u0010\u0010O\u001a\u00020;2\u0006\u0010P\u001a\u000208H\u0016J\u0010\u0010Q\u001a\u00020;2\u0006\u0010R\u001a\u000208H\u0016J\u0010\u0010S\u001a\u00020;2\u0006\u0010T\u001a\u00020\u000fH\u0016J\u0006\u0010U\u001a\u00020;J\b\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020;H\u0002J\b\u0010Y\u001a\u00020;H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0019\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/AudioRecognizePopupView;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/AbsAudioPopupViewWithEditText;", "context", "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mDisplayMode", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "mCompleteLayoutId", "", "getMCompleteLayoutId", "()I", "mSimpleLayoutId", "getMSimpleLayoutId", "mAILayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMAILayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mAILayout$delegate", "Lkotlin/Lazy;", "mBgLayout", "getMBgLayout", "mBgLayout$delegate", "mEditText", "Landroid/widget/EditText;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mHintTv", "Landroidx/appcompat/widget/AppCompatTextView;", "mDurationTv", "getMDurationTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "mDurationTv$delegate", "mMainBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMMainBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "mMainBtn$delegate", "mCancelBtn", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioRotatableButton;", "mSendBtn", "mSwitchLanguageTv", "mDeleteBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "mOnLongPressedRunnable", "Ljava/lang/Runnable;", "getMOnLongPressedRunnable", "()Ljava/lang/Runnable;", "mOnLongPressedRunnable$delegate", "mIsSingleClick", "", "getEditText", "onMainBtnUpOrCancelEvent", "", "resetUI", "setIsSingleClick", "isSingleClick", "setBgHeight", "height", "setMainBtnBottomMargin", "bottomMargin", "getAILayout", "Landroid/view/ViewGroup;", "onAsrLastFrameTimeOut", "setText", "asrText", "isFinish", "diffIndex", "", "setDuration", "duration", "isElapseCountDown", "updateSendBtnState", "updateUIOnRecordStateChanged", "isRecording", "updateUIOnAsrFinish", "isAsrTimeOut", "setVolume", "volume", "onTouchDecorView", "getMainBtnOnTouchListener", "Landroid/view/View$OnTouchListener;", "startRecordIfNeed", "tryShowAIButtons", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioRecognizePopupView extends AbsAudioPopupViewWithEditText {
    public static final /* synthetic */ int d = 0;
    public boolean c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioPluginEnums$DisplayMode.values().length];
            r0[AudioPluginEnums$DisplayMode.COMPLETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AudioPluginEnums$DisplayMode.SIMPLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ AudioRecognizePopupView a;

        public c(AudioRecognizePopupView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            this.a.getClass();
            throw null;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AudioRecognizePopupView a;
        public final /* synthetic */ int b;

        public d(AudioRecognizePopupView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConstraintLayout r0 = this.a.m1211getMBgLayout();     // Catch: Throwable -> L9
            if ((r0 instanceof AudioPopupBackground) == false) goto L5;
            AudioPopupBackground r1 = (AudioPopupBackground) r0;     // Catch: Throwable -> L9
        L6:
            if (r1 == null) goto L12;
            int r2 = this.a.getMMainBtn().getMeasuredHeight() / 2;     // Catch: Throwable -> L9
            int r3 = this.b;     // Catch: Throwable -> L9
            r1.f = r2;     // Catch: Throwable -> L9
            r1.g = r3;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L5:
            r1 = null;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
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

    private final View.OnTouchListener getMainBtnOnTouchListener() {
        return new c(this);
    }

    public final void c6() {
        if (AudioPluginEnums$DisplayMode.SIMPLE != null) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText
    public EditText getEditText() {
        int[] r0 = b.a;
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void R5() {
        super.R5();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void T5() {
        super.T5();
        if (AudioPluginEnums$DisplayMode.SIMPLE != null) goto L5;
        int r0 = h.a;
        throw null;
    L5:
        if (this.c == false) goto L7;
        return;
    L7:
        int r1 = h.a;
        throw null;
    }

    public final ViewGroup getAILayout() {
        return getMAILayout();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public /* bridge */ /* synthetic */ ViewGroup getMBgLayout() {
        return m1211getMBgLayout();
    }

    private final ConstraintLayout getMAILayout() {
        throw null;
    }

    private final AppCompatTextView getMDurationTv() {
        throw null;
    }

    private final Runnable getMOnLongPressedRunnable() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public UDButton getMMainBtn() {
        throw null;
    }

    public final void i6() {
        getEditText();
    }

    /* JADX INFO: renamed from: getMBgLayout, reason: collision with other method in class */
    public ConstraintLayout m1211getMBgLayout() {
        throw null;
    }

    public static final /* synthetic */ Runnable Z5(AudioRecognizePopupView r0) {
        return r0.getMOnLongPressedRunnable();
    }

    public static final void b6(AudioRecognizePopupView r2) {
        r2.getClass();
        int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.h() == false) goto L6;
        Log.i(r2.getMTag(), "startRecordIfNeed / Network unavailable");
        r2.getClass();
        throw null;
    L6:
        r2.getClass();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText
    public final void Y5(boolean r1) {
        super.Y5(r1);
        if (AudioPluginEnums$DisplayMode.SIMPLE != null) goto L5;
        return;
    L5:
        c6();
        h.k(null);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void setBgHeight(final int r3) {
        super.setBgHeight(r3);
        if (AudioPluginEnums$DisplayMode.COMPLETE != null) goto L6;
        int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.p(getMAILayout(), new AnonymousClass1(r3));
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void setIsSingleClick(boolean r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void setMainBtnBottomMargin(int r2) {
        super.setMainBtnBottomMargin(r2);
        post(new d(this, r2));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void setVolume(int r3) {
        super.setVolume(r3);
        if (AudioPluginEnums$DisplayMode.SIMPLE != null) goto L5;
        return;
    L5:
        ConstraintLayout r0 = m1211getMBgLayout();
        if ((r0 instanceof AudioPopupBackground) == false) goto L8;
        AudioPopupBackground r1 = (AudioPopupBackground) r0;
    L9:
        if (r1 == null) goto L12;
        r1.setVolume(r3);
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    }
}
