package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SuffixAsrSpan;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010`J\u0006\u0010a\u001a\u00020\u001cJ\u0010\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020eJ\u0018\u0010f\u001a\u00020]2\u0006\u0010g\u001a\u00020h2\u0006\u0010d\u001a\u00020eH\u0002J\u0018\u0010i\u001a\u00020]2\u0006\u0010g\u001a\u00020h2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010j\u001a\u00020]H\u0002J\u0010\u0010k\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u001aH\u0002J\u0012\u0010m\u001a\u00020]2\b\b\u0002\u0010n\u001a\u00020\u001eH\u0002J\u0014\u0010o\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020908H\u0002J\b\u0010p\u001a\u00020]H\u0002J\b\u0010q\u001a\u00020]H\u0002J\b\u0010r\u001a\u00020]H\u0002J\b\u0010s\u001a\u00020]H\u0002J\b\u0010t\u001a\u00020\u001cH\u0002J\b\u0010u\u001a\u00020]H\u0002J\b\u0010v\u001a\u00020]H\u0002J\u0012\u0010w\u001a\u00020]2\b\b\u0002\u0010x\u001a\u00020\u001cH\u0002J\b\u0010y\u001a\u00020]H\u0002J\u001a\u0010z\u001a\u00020\u001c2\u0006\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J\u0007\u0010\u007f\u001a\u00030\u0080\u0001J\u001d\u0010\u0081\u0001\u001a\u00020]2\u0007\u0010\u0082\u0001\u001a\u00020?2\t\b\u0002\u0010\u0083\u0001\u001a\u00020#H\u0002J\u0007\u0010\u0084\u0001\u001a\u00020#J\u0012\u0010\u0085\u0001\u001a\u00020]2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010#J\u0007\u0010\u0087\u0001\u001a\u00020]R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b%\u0010 R\u000e\u0010'\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b)\u0010 R\u001b\u0010+\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b,\u0010 R\u001b\u0010.\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b/\u0010 R\u001b\u00101\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0018\u001a\u0004\b2\u0010 R\u001b\u00104\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0018\u001a\u0004\b5\u0010 R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020908X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010F\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0Gj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c`HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0018\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u0018\u001a\u0004\bU\u0010VR\u000e\u0010X\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/AsrInputVoiceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "keyboard", "Lcom/ss/android/lark/keyboard/IKeyBoard;", "voiceInputDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputDependency;", "voiceInputConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputConfig;", "observers", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceKeyboardEventObserver;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/IKeyBoard;Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputDependency;Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputConfig;Ljava/util/List;Landroid/util/AttributeSet;)V", "mContext", "mKeyboard", "mImmersiveVoiceViewModel", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "getMImmersiveVoiceViewModel", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "mImmersiveVoiceViewModel$delegate", "Lkotlin/Lazy;", "finalAsrRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "hasEnteredAdvanceMode", "", "mHintString", "", "getMHintString", "()Ljava/lang/String;", "mHintString$delegate", "hintBeforeRecord", "", "mWaitingForVoiceHint", "getMWaitingForVoiceHint", "mWaitingForVoiceHint$delegate", "currentHint", "mPoorNetworkPrompt", "getMPoorNetworkPrompt", "mPoorNetworkPrompt$delegate", "mCountDownTips", "getMCountDownTips", "mCountDownTips$delegate", "mShortRecordTimeToast", "getMShortRecordTimeToast", "mShortRecordTimeToast$delegate", "mNetworkUnavailableToast", "getMNetworkUnavailableToast", "mNetworkUnavailableToast$delegate", "mErrorToast", "getMErrorToast", "mErrorToast$delegate", "mTextBeforeRecord", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "handler", "Landroid/os/Handler;", "isLongPress", "netUnavailable", "textLengthBeforeRecord", "", "loadingToastImpl", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "recordStartTime", "", "punctuation", "punctuationRichText", "mSessionInterceptedSendMsg", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "overtimePrompt", "Landroid/widget/TextView;", "lastRecognizeResult", "button", "Landroid/widget/ImageButton;", "mVibrator", "Landroid/os/Vibrator;", "getMVibrator", "()Landroid/os/Vibrator;", "mVibrator$delegate", "longPressRunnable", "Ljava/lang/Runnable;", "getLongPressRunnable", "()Ljava/lang/Runnable;", "longPressRunnable$delegate", "loadingToast", "cancelLoadingToast", "mTouchThroughView", "Landroid/widget/FrameLayout;", "initView", "", "applyCustomMainButton", "buttonConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/AdvanceVoiceButtonConfig;", "shouldInterceptSendMsg", "getEditorAndUpdateTarget", "Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", "richTextEditor", "Lcom/ss/android/lark/keyboard/edittext2/edittors/richText/RichTextEditor;", "asrResultRichTextCallBackLegacy", "asrResult", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/AsrRichTextResult;", "asrResultRichTextCallBack", "initObserver", "isRichTextEmpty", "richText", "showHintTextWithDot", "hintText", "getTwoPartsBeforeRecord", "onClickedRunnable", "afterLongPressed", "stopASRAndRecordIfNeed", "actionUpOrCancel", "triggerVoiceRecordOnLongPressed", "stopPlayingAudioMessage", "stopRecordAfterLongPressed", "resetViewModelState", "isClearVoiceDataAll", "vibrate", "checkTouchInSendButton", "event", "Landroid/view/MotionEvent;", "target", "Landroid/view/View;", "getTouchListener", "Landroid/view/View$OnTouchListener;", "showToastWithIcon", "iconSrc", "toastText", "getCurrentHint", "putCurrentHint", "hint", "whenAdvanceModeSend", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AsrInputVoiceView extends ConstraintLayout {
    public ImageButton A;
    public final Lazy B;
    public final Lazy C;
    public final n D;
    public final d E;
    public final FrameLayout F;
    public final x a;
    public final w b;
    public final List<z> c;
    public final Context d;
    public final com.ss.android.lark.keyboard.b e;
    public final Lazy f;
    public boolean g;
    public final Lazy h;
    public CharSequence i;
    public final Lazy j;
    public CharSequence k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public Pair<? extends SpannableStringBuilder, ? extends SpannableStringBuilder> q;
    public final Handler r;
    public boolean s;
    public boolean t;
    public int u;
    public com.larksuite.component.universe_design.toast.c v;
    public String w;
    public RichText x;
    public final HashMap<String, Boolean> y;
    public TextView z;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ AsrInputVoiceView a;

        public b(AsrInputVoiceView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            int r7 = r6.getAction();
            if (r7 == 0) goto L31;
            if (r7 != 1) goto L6;
            ViewParent r8 = r5.getParent();
            if (r8 == null) goto L18;
            r8.requestDisallowInterceptTouchEvent(false);
        L18:
            AsrInputVoiceView r9 = this.a;
            if (r9.s == false) goto L22;
            Log.i("AsrInputVoiceView", "action_up, afterLongPressed");
            AsrInputVoiceView.S5(this.a);
        L30:
            AsrInputVoiceView.R5(this.a);
            this.a.s = false;
        L46:
            return true;
        L22:
            if (r9.t == true) goto L30;
            Log.i("AsrInputVoiceView", "action_up, onClick");
            AsrInputVoiceView r10 = this.a;
            r10.e.v().a(ImmersiveVoiceInputComponent.a, true);
            if (r10.e.z().y() == false) goto L27;
            r10.e.z().g();
        L27:
            if (r10.e.z().B() == false) goto L29;
            r10.e.z().a();
        L29:
            r5.performClick();
            goto L30
        L6:
            if (r7 != 3) goto L46;
            ViewParent r11 = r5.getParent();
            if (r11 == null) goto L12;
            r11.requestDisallowInterceptTouchEvent(false);
        L12:
            if (this.a.s == false) goto L14;
            Log.i("AsrInputVoiceView", "action_cancel");
            AsrInputVoiceView.S5(this.a);
        L14:
            AsrInputVoiceView.R5(this.a);
            this.a.s = false;
            goto L46
        L31:
            Log.i("AsrInputVoiceView", "action_down");
            ViewParent r12 = r5.getParent();
            if (r12 == null) goto L34;
            r12.requestDisallowInterceptTouchEvent(true);
        L34:
            AsrInputVoiceView r13 = this.a;
            r13.s = false;
            r13.t = false;
            r13.u = 0;
            if (Intrinsics.areEqual("", r13.i) == false) goto L37;
            AsrInputVoiceView r14 = this.a;
            r14.i = r14.e.L().c().getHint();
        L37:
            int r15 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
            if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.h() == false) goto L41;
            Log.i("AsrInputVoiceView", "onActionDown / Network unavailable");
            AsrInputVoiceView r16 = this.a;
            r16.t = true;
            AsrInputVoiceView.C6(r16, AsrInputVoiceView.i6(r16));
            return true;
        L41:
            Iterator<T> r17 = this.a.c.iterator();
        L43:
            if (r17.hasNext() == false) goto L45;
            ((z) r17.next()).b();
            goto L43
        L45:
            AsrInputVoiceView r18 = this.a;
            AsrInputVoiceView.u6(r18, !r18.g);
            AsrInputVoiceView r19 = this.a;
            System.currentTimeMillis();
            r19.getClass();
            AsrInputVoiceView r20 = this.a;
            r20.r.postDelayed(AsrInputVoiceView.V5(r20), 300);
            goto L46
        }
    }

    static {
    }

    public AsrInputVoiceView() {
        throw null;
    }

    private final Runnable getLongPressRunnable() {
        return (Runnable) this.C.getValue();
    }

    private final String getMCountDownTips() {
        return (String) this.m.getValue();
    }

    private final String getMErrorToast() {
        return (String) this.p.getValue();
    }

    private final String getMHintString() {
        return (String) this.h.getValue();
    }

    private final ImmersiveVoiceViewModel getMImmersiveVoiceViewModel() {
        return (ImmersiveVoiceViewModel) this.f.getValue();
    }

    private final String getMNetworkUnavailableToast() {
        return (String) this.o.getValue();
    }

    private final String getMPoorNetworkPrompt() {
        return (String) this.l.getValue();
    }

    private final String getMShortRecordTimeToast() {
        return (String) this.n.getValue();
    }

    private final Vibrator getMVibrator() {
        return (Vibrator) this.B.getValue();
    }

    private final String getMWaitingForVoiceHint() {
        return (String) this.j.getValue();
    }

    private final Pair<SpannableStringBuilder, SpannableStringBuilder> getTwoPartsBeforeRecord() {
        EditText r0 = this.e.L().c();
        r0.setKeepScreenOn(true);
        this.u = r0.getText().length();
        if (r0.hasFocus() == false) goto L5;
        r0.clearFocus();
    L5:
        int r1 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        Pair r2 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.l(new SpannableStringBuilder(r0.getText()), r0.getSelectionEnd());
        SpannableStringBuilder r3 = new SpannableStringBuilder((CharSequence) r2.getFirst());
        SpannableStringBuilder r4 = new SpannableStringBuilder((CharSequence) r2.getSecond());
        Lazy r5 = SpannableStringUtils.a;
        SpannableStringUtils.c(r3);
        SpannableStringUtils.c(r4);
        if (getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L8;
        this.x = getMImmersiveVoiceViewModel().addPeriodForRichTextIfNeed(r0.getText().toString(), r0.getSelectionEnd());
    L9:
        Log.i("AsrInputVoiceView", "kbEditText.selectionEnd = " + r0.getSelectionEnd() + " mFirstPartOfContent = " + r3.length() + " mLastPartOfContent = " + r4.length() + " punctuation = " + this.w);
        return TuplesKt.to(r3, r4);
    L8:
        this.w = getMImmersiveVoiceViewModel().addPeriodIfNeed(r0.getText().toString(), r0.getSelectionEnd());
        goto L9
    }

    public final CharSequence getCurrentHint() {
        Log.i("AsrInputVoiceView", " get current hint: " + this.k.length());
        return this.k;
    }

    public final View.OnTouchListener getTouchListener() {
        return new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean H6(AsrInputVoiceView r6) {
        r6.getMImmersiveVoiceViewModel().setMaxRecordTime(AudioRecordSettings.c().getAudioToText().getAudio2TextMaxDuration());
        r6.getMImmersiveVoiceViewModel().switch2VoiceAsr();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Map r2 = com.ss.android.lark.audio.f.e;     // Catch: Throwable -> L9
        Context r3 = r6.getContext();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r3, "context");     // Catch: Throwable -> L9
        com.ss.android.lark.audio.f r4 = (com.ss.android.lark.audio.f) ((ConcurrentHashMap) com.ss.android.lark.audio.f.e).get(r3.toString());     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        r4.d();     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L14;
        Log.e("AsrInputVoiceView", "stop playing audio message failed", r8);
    L14:
        VoiceInputMode r9 = VoiceInputMode.OnlyAsr;
        VoiceInputScene r10 = VoiceInputScene.AdvancedMode;
        com.ss.android.lark.audio.voiceinput.p r11 = new com.ss.android.lark.audio.voiceinput.p(r9, r10);
        Object r12 = r6.e.L().c();
        if ((r12 instanceof RichTextFunctionEditText) == false) goto L17;
        RichTextFunctionEditText r13 = (RichTextFunctionEditText) r12;
    L18:
        String r14 = com.ss.android.lark.keyboard.plugin.tool.voice.utils.c.a(r13);
        if (r6.g == false) goto L21;
        r11 = new com.ss.android.lark.audio.voiceinput.p(VoiceInputMode.SecondVoice, r10);
        r6.getMImmersiveVoiceViewModel().setBeforeVoiceEditAsrResult(r14);
    L22:
        ImmersiveVoiceViewModel r0 = r6.getMImmersiveVoiceViewModel();
        int r15 = AudioAsrLanguageSwitcher.i;
        if (r0.startVoiceRecord(r11, AudioAsrLanguageSwitcher.a.a(), r14) == true) goto L25;
        return false;
    L25:
        r6.getMImmersiveVoiceViewModel().whenVoiceInputStart();
        Log.i("AsrInputVoiceView", "startVoiceRecord");
        return true;
    L21:
        r6.getMImmersiveVoiceViewModel().setBeforeVoiceEditAsrResult(null);
        goto L22
    L17:
        r13 = null;
        goto L18
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static final void N6(AsrInputVoiceView r2) {
        r2.getMVibrator().vibrate(50);
    }

    public static final void R5(AsrInputVoiceView r3) {
        r3.getMImmersiveVoiceViewModel().whenReleaseOrCancelTouch();
        r3.r.removeCallbacks(r3.getLongPressRunnable());
        r3.r.removeCallbacks(r3.D);
        r3.r.post(r3.E);
        TextView r0 = r3.z;
        TextView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
        r0 = null;
    L6:
        if (r0.getVisibility() != 0) goto L13;
        TextView r4 = r3.z;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
    L11:
        r1.setVisibility(8);
        return;
    L10:
        r1 = r4;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void S5(AsrInputVoiceView r3) {
        com.ss.android.lark.keyboard.keyboard2.d r0 = r3.e.H();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.OverlayKeyboardMenu");
        ((com.ss.android.lark.keyboard.keyboard2.n) r0).a(null);
        r3.e.v().e().l();
        Iterator<T> r1 = r3.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((z) r1.next()).a();
        goto L4
    L6:
        r3.getMImmersiveVoiceViewModel().whenReleaseOrCancelTouch();
        r3.e.L().c();
        boolean r2 = false;
        r3.setKeepScreenOn(false);
        if (r3.e.z().y() == true) goto L9;
        r3.e.z().z();
    L9:
        EditText r4 = r3.e.L().c();
        if (r3.getMImmersiveVoiceViewModel().isAsrSessionRunning() == false) goto L20;
        Editable r5 = r4.getText();
        if (r5 != null) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == false) goto L21;
        r3.f7("");
        return;
    L21:
        return;
    L14:
        if (r5.length() != 0) goto L16;
    }

    public static final /* synthetic */ Runnable V5(AsrInputVoiceView r0) {
        return r0.getLongPressRunnable();
    }

    public static boolean W6(RichText r1) {
        if (r1.getElements() != null) goto L5;
    L10:
        return true;
    L5:
        if (CollectionUtils.isEmpty(r1.getElements().getDictionary()) == true) goto L10;
        if (CollectionUtils.isEmpty(r1.getElementIds()) == true) goto L10;
        return false;
    }

    public static final /* synthetic */ String Y5(AsrInputVoiceView r0) {
        return r0.getMCountDownTips();
    }

    public static final /* synthetic */ String Z5(AsrInputVoiceView r0) {
        return r0.getMErrorToast();
    }

    public static final /* synthetic */ String b6(AsrInputVoiceView r0) {
        return r0.getMHintString();
    }

    public static final /* synthetic */ ImmersiveVoiceViewModel c6(AsrInputVoiceView r0) {
        return r0.getMImmersiveVoiceViewModel();
    }

    public static final /* synthetic */ String i6(AsrInputVoiceView r0) {
        return r0.getMNetworkUnavailableToast();
    }

    public static final /* synthetic */ String k6(AsrInputVoiceView r0) {
        return r0.getMPoorNetworkPrompt();
    }

    public static final /* synthetic */ String n6(AsrInputVoiceView r0) {
        return r0.getMShortRecordTimeToast();
    }

    public static final /* synthetic */ String o6(AsrInputVoiceView r0) {
        return r0.getMWaitingForVoiceHint();
    }

    public static final /* synthetic */ Pair s6(AsrInputVoiceView r0) {
        return r0.getTwoPartsBeforeRecord();
    }

    public final RichTextFunctionEditText V6(m r3) {
        Intrinsics.checkNotNullParameter(r3, "richTextEditor");
        Object r0 = this.e.L().c();
        if ((r0 instanceof RichTextFunctionEditText) == false) goto L5;
        RichTextFunctionEditText r1 = (RichTextFunctionEditText) r0;
    L6:
        if (r1 == null) goto L8;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r3.a = r1;
    L8:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f7(String r6) {
        EditText r0 = this.e.L().c();
        Lazy r1 = SpannableStringUtils.a;
        SpannableStringBuilder r7 = SpannableStringUtils.a(getContext(), new SpannableStringBuilder(r6), new SpannableStringUtils.a(r0), null);
        int r2 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        r7.setSpan(new ForegroundColorSpan(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.c(this, 2131103456)), 0, r7.length(), 33);
        r0.setHint(r7);
        this.k = r7;
        Log.i("AsrInputVoiceView", "current hint: " + this.k.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void C6(AsrInputVoiceView r3, CharSequence r4) {
        int r0 = com.ss.android.lark.c.a(r3.e) + UIUtils.dp2px(r3.d, 30.0f);
        Context r5 = r3.getContext();
        Intrinsics.checkNotNullParameter(r5, "context");
        FlowToast.a r1 = FlowToast.a(r5);
        Intrinsics.checkNotNullParameter(r4, "value");
        Intrinsics.checkNotNullParameter(r4, "value");
        r1.b = r4;
        r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r5, 2131254921));
        r1.c(80, 0, r0);
        r1.a().show();
    }

    public static final void u6(AsrInputVoiceView r1, boolean r2) {
        ImmersiveVoiceViewModel r3 = r1.getMImmersiveVoiceViewModel();
        r3.updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.j());
        r3.resetLiveData(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void T5(final AsrInputVoiceView r13, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r14, m r15) {
        r13.getClass();
        RichText r0 = r14.a;
        SpannableStringBuilder r1 = r14.b;
        String r2 = r14.e;
        Boolean r3 = r14.d;
        if (r3 == null) goto L5;
        boolean r4 = r3.booleanValue();
    L6:
        boolean r16 = r14.c;
        final SpannableStringBuilder r12 = new SpannableStringBuilder();
        final RichTextFunctionEditText r7 = r13.V6(r15);
        if (r7 == null) goto L73;
        Pair r6 = (Pair) r13.getMImmersiveVoiceViewModel().getBeforeInsertSelectionV2().getValue();
        if (r6 != null) goto L11;
        r6 = new Pair(0, 0);
    L11:
        final Pair r8 = r6;
        SpannableStringBuilder r5 = new SpannableStringBuilder();
        RichTextEditor r17 = r15;
        if (r13.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L14;
        r17 = (RichTextEditor) r7.q(RichTextEditor.t);
    L14:
        r17.R(r0, r5);
        Character r9 = StringsKt.lastOrNull(r5);
        int r10 = 1;
        if (r9 != null) goto L18;
    L20:
        if (r16 == true) goto L25;
        if (r13.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L25;
        Lazy r18 = SpannableStringUtils.a;
        SpannableStringUtils.e(r5, r2, new SuffixAsrSpan(UIUtils.getColor(r13.getContext(), 2131108741)));
    L25:
        if (r13.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == true) goto L27;
        r12.append(r13.w);
    L38:
        if (r13.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L51;
        if (r4 == false) goto L51;
        if (((CharSequence) r13.q.getFirst()).length() != 0) goto L43;
        boolean r19 = true;
    L44:
        if (r19 == true) goto L51;
        Character r110 = StringsKt.lastOrNull((CharSequence) r13.q.getFirst());
        if (r110 != null) goto L49;
    L50:
        r12.append("\n");
        goto L51
    L49:
        if (r110.charValue() == '\n') goto L51;
    L43:
        r19 = false;
    L51:
        y9b.a[] r111 = (y9b.a[]) r5.getSpans(0, r5.length(), y9b.a.class);
        if (r111.length != 0) goto L54;
        boolean r112 = true;
    L56:
        if (r112 == false) goto L58;
        y9b.a r113 = null;
    L68:
        if (r113 == null) goto L70;
        r113.g(ListHeadType.VirtualHead);
    L70:
        r12.append(r5);
        r12.append(StringsKt.trim(r1));
        Lazy r114 = SpannableStringUtils.a;
        SpannableStringUtils.a(r13.d, r12, null, null);
        final p r11 = new p();
        r12.setSpan(r11, 0, r12.length(), 33);
        sob.c.d(r13, "updateAsrResult", new AsrInputVoiceView$asrResultRichTextCallBack$1$3(r7, r8, r12, r11, r13));
        Log.i("AsrInputVoiceView", "resultSpan: " + r12.length() + ", mTextBeforeRecord.first " + ((SpannableStringBuilder) r13.q.getFirst()).length() + " mTextBeforeRecord.second: " + ((SpannableStringBuilder) r13.q.getSecond()).length());
        return;
    L58:
        r113 = r111[0];
        int r20 = ArraysKt.getLastIndex(r111);
        if (r20 == 0) goto L68;
        int r21 = r5.getSpanStart(r113);
        if (1 > r20) goto L68;
    L63:
        y9b.a r22 = r111[r10];
        int r115 = r5.getSpanStart(r22);
        if (r21 <= r115) goto L66;
        r113 = r22;
        r21 = r115;
    L66:
        if (r10 == r20) goto L68;
        r10 = r10 + 1;
        goto L63
    L54:
        r112 = false;
        goto L56
    L27:
        if (W6(r0) == false) goto L34;
        if (StringsKt.trim(r1).length() != 0) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == true) goto L38;
    L31:
        r116 = false;
    L34:
        if (com.ss.android.lark.widget.richtext.i.l(r13.x) == true) goto L38;
        SpannableStringBuilder r117 = new SpannableStringBuilder();
        r17.R(r13.x, r117);
        r12.append(r117);
        goto L38
    L18:
        if (r9.charValue() != '\n') goto L20;
        r5.delete(r5.length() - 1, r5.length());
        goto L20
    L73:
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void U5(final AsrInputVoiceView r12, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r13, m r14) {
        r12.getClass();
        RichText r0 = r13.a;
        SpannableStringBuilder r1 = r13.b;
        String r2 = r13.e;
        Boolean r3 = r13.d;
        boolean r4 = false;
        if (r3 == null) goto L5;
        boolean r5 = r3.booleanValue();
    L6:
        boolean r15 = r13.c;
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = new SpannableStringBuilder();
        final RichTextFunctionEditText r7 = r12.V6(r14);
        if (r7 == null) goto L49;
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        RichTextEditor r16 = r14;
        if (r12.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L11;
        r16 = (RichTextEditor) r7.q(RichTextEditor.t);
    L11:
        r16.R(r0, r8);
        Character r9 = StringsKt.lastOrNull(r8);
        if (r9 != null) goto L15;
    L17:
        if (r15 == false) goto L19;
    L21:
        ((SpannableStringBuilder) r6.element).append((CharSequence) r12.q.getFirst());
        if (r12.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == true) goto L24;
        ((SpannableStringBuilder) r6.element).append(r12.w);
    L35:
        if (r12.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L47;
        if (r5 == false) goto L47;
        if (((CharSequence) r12.q.getFirst()).length() != 0) goto L40;
        r4 = true;
    L40:
        if (r4 == true) goto L47;
        Character r17 = StringsKt.lastOrNull((CharSequence) r12.q.getFirst());
        if (r17 != null) goto L45;
    L46:
        ((SpannableStringBuilder) r6.element).append("\n");
        goto L47
    L45:
        if (r17.charValue() != '\n') goto L46;
    L47:
        ((SpannableStringBuilder) r6.element).append(r8);
        ((SpannableStringBuilder) r6.element).append(StringsKt.trim(r1));
        Lazy r18 = SpannableStringUtils.a;
        SpannableStringBuilder r19 = SpannableStringUtils.a(r12.d, (SpannableStringBuilder) r6.element, null, null);
        r6.element = r19;
        r19.append((CharSequence) r12.q.getSecond());
        sob.c.d(r12, "updateAsrResult", new AsrInputVoiceView$asrResultRichTextCallBackLegacy$1$1(r7, r6, r12));
        Log.i("AsrInputVoiceView", "resultSpan: " + ((SpannableStringBuilder) r6.element).length() + ", mTextBeforeRecord.first " + ((SpannableStringBuilder) r12.q.getFirst()).length() + " mTextBeforeRecord.second: " + ((SpannableStringBuilder) r12.q.getSecond()).length());
        return;
    L24:
        if (W6(r0) == false) goto L31;
        if (StringsKt.trim(r1).length() != 0) goto L28;
        boolean r110 = true;
    L29:
        if (r110 == true) goto L35;
    L28:
        r110 = false;
    L31:
        if (com.ss.android.lark.widget.richtext.i.l(r12.x) == true) goto L35;
        SpannableStringBuilder r111 = new SpannableStringBuilder();
        r16.R(r12.x, r111);
        ((SpannableStringBuilder) r6.element).append(r111);
        goto L35
    L19:
        if (r12.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L21;
        Lazy r112 = SpannableStringUtils.a;
        SpannableStringUtils.e(r8, r2, new SuffixAsrSpan(UIUtils.getColor(r12.getContext(), 2131108741)));
        goto L21
    L15:
        if (r9.charValue() != '\n') goto L17;
        r8.delete(r8.length() - 1, r8.length());
        goto L17
    L49:
        return;
    L5:
        r5 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsrInputVoiceView(final Context r2, com.ss.android.lark.keyboard.b r3, x r4, w r5, List r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "keyboard");
        Intrinsics.checkNotNullParameter(r4, "voiceInputDependency");
        Intrinsics.checkNotNullParameter(r5, "voiceInputConfig");
        Intrinsics.checkNotNullParameter(r6, "observers");
        super(r2, null);
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r2;
        this.e = r3;
        this.f = LazyKt.lazy(new AsrInputVoiceView$mImmersiveVoiceViewModel$2(this, r2));
        this.h = LazyKt.lazy(new AsrInputVoiceView$mHintString$2(this));
        this.i = "";
        this.j = LazyKt.lazy(new AsrInputVoiceView$mWaitingForVoiceHint$2(this));
        this.k = "";
        this.l = LazyKt.lazy(new AsrInputVoiceView$mPoorNetworkPrompt$2(this));
        this.m = LazyKt.lazy(new AsrInputVoiceView$mCountDownTips$2(this));
        this.n = LazyKt.lazy(new AsrInputVoiceView$mShortRecordTimeToast$2(this));
        this.o = LazyKt.lazy(new AsrInputVoiceView$mNetworkUnavailableToast$2(this));
        this.p = LazyKt.lazy(new AsrInputVoiceView$mErrorToast$2(this));
        this.q = new Pair(new SpannableStringBuilder(), new SpannableStringBuilder());
        this.r = new Handler(Looper.getMainLooper());
        this.w = "";
        this.x = new RichText();
        this.y = new HashMap();
        this.B = LazyKt.lazy(new AsrInputVoiceView$mVibrator$2(this));
        this.C = LazyKt.lazy(new AsrInputVoiceView$longPressRunnable$2(this));
        this.D = new n(this, r2);
        this.E = new d(this);
        FrameLayout r7 = new FrameLayout(r2);
        r7.setVisibility(8);
        r7.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r7.setAlpha(0.0f);
        r7.setOnTouchListener(new o(this, r7));
        this.F = r7;
        LayoutInflater.from(r2).inflate(2131563338, this, true);
        if (h18.f.a(getContext()) == false) goto L5;
        int r8 = UIUtils.getColor(getContext(), 2131100154);
    L6:
        this.z = (TextView) findViewById(2131383394);
        this.A = (ImageButton) findViewById(2131363524);
        GradientDrawable r9 = new GradientDrawable();
        r9.setShape(0);
        r9.setColor(r8);
        r9.setCornerRadius(UIUtils.dp2px(r2, 10));
        ImageButton r10 = this.A;
        if (r10 == null) goto L9;
        r10.setBackground(r9);
    L9:
        Fragment r11 = r3.l().d;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        m r12 = new m();
        V6(r12);
        ImmersiveVoiceViewModel r13 = getMImmersiveVoiceViewModel();
        r13.getAudioAsrResult().observe(r11, new e(this, r12, r13));
        r13.getAsrResultRichText().observe(r11, new f(this, r12));
        r13.isRecordHardWareReady().observe(r11, new g(this, r13));
        r13.isAsrRecognizeFinish().observe(r11, new h(this, r12, r13));
        r13.getShouldShowPoorNetTips().observe(r11, new i(this));
        r13.getShouldShowAsrWaitingPoorNetTips().observe(r11, new j(this));
        r13.getVoiceRecordTooShort().observe(r11, new k(this));
        r13.isElapseCountDown().observe(r11, new l(this));
        getMImmersiveVoiceViewModel().injectIGetEditTextAndSelectionDependency(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.b(this));
        getMImmersiveVoiceViewModel().injectDependency(new c(r2, this));
        Log.i("AsrInputVoiceView", "SimpleImmersiveVoiceView init over");
        return;
    L5:
        r8 = UIUtils.getColor(getContext(), 2131100153);
        goto L6
    }
}
