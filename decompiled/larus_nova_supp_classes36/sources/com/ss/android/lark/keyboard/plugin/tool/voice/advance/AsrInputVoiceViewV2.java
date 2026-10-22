package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00012\u0018\u0000 b2\u00020\u0001:\u0001bB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020&J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020&J\u0006\u0010F\u001a\u00020\u0018J\u0010\u0010G\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010\u0018J\u0006\u0010I\u001a\u00020DJ\b\u0010J\u001a\u00020DH\u0002J\u0010\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020&H\u0002J\b\u0010M\u001a\u00020DH\u0002J\b\u0010N\u001a\u00020DH\u0002J\b\u0010O\u001a\u00020DH\u0002J\b\u0010P\u001a\u00020DH\u0002J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0002J\u0012\u0010S\u001a\u00020D2\b\b\u0002\u0010T\u001a\u00020\u0007H\u0002J\"\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020ZH\u0002J$\u0010[\u001a\u00020D2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020ZH\u0002J\u001a\u0010^\u001a\u00020&2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001b\u0010\u0011R\u001b\u0010\u001d\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001e\u0010\u0011R\u001b\u0010 \u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b!\u0010\u0011R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020&0)j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020&`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0013\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0013\u001a\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AsrInputVoiceViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "keyboard", "Lcom/ss/android/lark/keyboard/IKeyBoard;", "appLocale", "", "dependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceVoiceInputDependency;", "chatId", "advanceModeView", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/IKeyBoard;Ljava/lang/String;Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceVoiceInputDependency;Ljava/lang/String;Landroid/view/View;)V", "preparingHint", "getPreparingHint", "()Ljava/lang/String;", "preparingHint$delegate", "Lkotlin/Lazy;", "waitForVoiceHint", "getWaitForVoiceHint", "waitForVoiceHint$delegate", "currentHint", "", "hintBeforeRecord", "countDownTips", "getCountDownTips", "countDownTips$delegate", "shortRecordTimeToast", "getShortRecordTimeToast", "shortRecordTimeToast$delegate", "poorNetworkPrompt", "getPoorNetworkPrompt", "poorNetworkPrompt$delegate", "myHandler", "Landroid/os/Handler;", "canStart", "", "isLongPress", "sessionInterceptedSendMsg", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "advanceVoiceInputConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceVoiceInputConfig;", "overtimePrompt", "Landroid/widget/TextView;", "loadingToastImpl", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "callback", "com/ss/android/lark/keyboard/plugin/tool/voice/advance/AsrInputVoiceViewV2$callback$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AsrInputVoiceViewV2$callback$1;", "recorder", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceVoiceInputComponent;", "getRecorder", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceVoiceInputComponent;", "recorder$delegate", "mTouchThroughView", "Landroid/widget/FrameLayout;", "getMTouchThroughView", "()Landroid/widget/FrameLayout;", "mTouchThroughView$delegate", "longPressRunnable", "Ljava/lang/Runnable;", "getTouchListener", "Landroid/view/View$OnTouchListener;", "shouldInterceptSendMsg", "stopRecognizeWhenClickSend", "", "isAsrSessionRunning", "getCurrentHint", "putCurrentHint", "hint", "destroy", "initView", "showTouchThroughView", "isShow", "onClicked", "idle", "preparing", "recording", "recognizing", "removeRunnableAndHideLoadingToast", "showHintTextWithDot", "hintText", "showToastWithIconAndDuration", "iconResId", "", INotificationHitPoint.NoticeType.MESSAGE, "duration", "", "showToastWithDrawableAndDuration", "drawable", "Landroid/graphics/drawable/Drawable;", "checkTouchInSendButton", "event", "Landroid/view/MotionEvent;", "target", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AsrInputVoiceViewV2 extends ConstraintLayout {
    public boolean a;
    public boolean b;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ AsrInputVoiceViewV2 a;

        public b(AsrInputVoiceViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            int r7 = r6.getAction();
            if (r7 == 0) goto L22;
            if (r7 != 1) goto L6;
            AsrInputVoiceViewV2 r8 = this.a;
            if (r8.b == false) goto L16;
            Log.i("AsrInputVoiceViewV2", "action_up, afterLongPressed");
            AsrInputVoiceViewV2.R5(this.a).b();
            this.a.b = false;
        L20:
            this.a.getClass();
            throw null;
        L16:
            if (r8.a == false) goto L20;
            Log.i("AsrInputVoiceViewV2", "action_up, onClick");
            this.a.getClass();
            throw null;
        L6:
            if (r7 == 3) goto L9;
            return true;
        L9:
            if (this.a.b == false) goto L11;
            Log.i("AsrInputVoiceViewV2", "action_cancel");
            AsrInputVoiceViewV2 r9 = this.a;
            r9.b = false;
            AsrInputVoiceViewV2.R5(r9).b();
        L11:
            this.a.getClass();
            throw null;
        L22:
            Log.i("AsrInputVoiceViewV2", "action_down");
            AsrInputVoiceViewV2 r10 = this.a;
            r10.b = false;
            r10.a = true;
            r10.getClass();
            if (Intrinsics.areEqual("", null) == false) goto L26;
            this.a.getClass();
            throw null;
        L26:
            AsrInputVoiceViewV2.S5(this.a);
            throw null;
        }
    }

    static {
    }

    public AsrInputVoiceViewV2() {
        throw null;
    }

    public final CharSequence getCurrentHint() {
        throw null;
    }

    public final View.OnTouchListener getTouchListener() {
        return new b(this);
    }

    private final String getCountDownTips() {
        throw null;
    }

    private final FrameLayout getMTouchThroughView() {
        throw null;
    }

    private final String getPoorNetworkPrompt() {
        throw null;
    }

    private final String getPreparingHint() {
        throw null;
    }

    private final com.ss.android.lark.keyboard.plugin.tool.voice.advance.b getRecorder() {
        throw null;
    }

    private final String getShortRecordTimeToast() {
        throw null;
    }

    private final String getWaitForVoiceHint() {
        throw null;
    }

    public static final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.advance.b R5(AsrInputVoiceViewV2 r0) {
        return r0.getRecorder();
    }

    public static final void S5(AsrInputVoiceViewV2 r2) {
        r2.getClass();
        Log.i("AsrInputVoiceViewV2", "view display state: idle");
        r2.T5(false);
        throw null;
    }

    public final void T5(boolean r2) {
        if (r2 == true) goto L7;
        Log.i("AsrInputVoiceViewV2", "remove touch through view from keyboard root view");
        if (getMTouchThroughView().getVisibility() == 8) goto L9;
        getMTouchThroughView().setVisibility(8);
        return;
    L9:
        return;
    L7:
        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.BasicKeyboard");
        throw null;
    }
}
