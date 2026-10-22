package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0004abcdB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ2\u0010\u001f\u001a\u00020 2#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020 0\"H\u0000¢\u0006\u0002\b'J\b\u0010(\u001a\u00020 H\u0002Jq\u0010)\u001a\u00020 2b\u0010!\u001a^\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020 0*H\u0000¢\u0006\u0002\b/J\u0006\u00100\u001a\u00020 J\b\u00101\u001a\u00020\u0017H\u0014J\b\u00102\u001a\u00020\u0017H\u0014J\n\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0017H\u0014J\b\u00106\u001a\u00020\u0017H\u0014J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0007H\u0002J\u0012\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J0\u0010<\u001a\u00020 2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020 0\"H\u0000¢\u0006\u0002\b>J0\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0018\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0014J2\u0010H\u001a\u00020 2#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010I¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020 0\"H\u0000¢\u0006\u0002\bKJ\u0018\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0014Jq\u0010O\u001a\u00020 2b\u0010!\u001a^\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020 0*H\u0000¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020\u0010H\u0016J\u0010\u0010S\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007H\u0016J\u0012\u0010T\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010V\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u00010WH\u0016J\u001a\u0010X\u001a\u00020 2\b\b\u0002\u0010Y\u001a\u00020\u00172\b\b\u0002\u0010Z\u001a\u00020\u0017J6\u0010[\u001a\u00020 2\b\b\u0002\u0010\\\u001a\u00020\u00102\b\b\u0002\u0010]\u001a\u00020\u00102\b\b\u0002\u0010^\u001a\u00020\u00102\b\b\u0002\u0010_\u001a\u00020\u00102\u0006\u0010`\u001a\u00020\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commitCompletionListener", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$CommitCompletionListener;)V", "isBottomFading", "", "isLeftFading", "isPerformingLongClick", "isRightFading", "isTopFading", "mErrorBackgroundColor", "mPasswordMaskDotSizeRatio", "", "mPasswordMaskDotSpacingRatio", "onFocusChangeListenerWrapper", "Lcom/obric/oui/forms/OEditText$OnFocusChangeListenerWrapper;", "onTouchListenerWrapper", "Lcom/obric/oui/forms/OEditText$OnTouchListenerWrapper;", "textWatcherWrapper", "Lcom/obric/oui/forms/OEditText$TextWatcherWrapper;", "afterTextChanged", "", "action", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "s", "afterTextChanged$OUI_standardRelease", "applyPasswordTransformationIfNeeded", "beforeTextChanged", "Lkotlin/Function4;", "", CommonConsts.APM_INNER_EVENT_COST_START, CommonConsts.COUNT_TYPE, "after", "beforeTextChanged$OUI_standardRelease", "clearPasswordMask", "getBottomFadingEdgeStrength", "getLeftFadingEdgeStrength", "getOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "isHiddenPasswordInputType", "type", "onCommitCompletion", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/view/inputmethod/CompletionInfo;", "onFocusChange", "hasFocus", "onFocusChange$OUI_standardRelease", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onOnTouchEvent", "Landroid/view/MotionEvent;", "event", "onOnTouchEvent$OUI_standardRelease", "onSelectionChanged", "selStart", "selEnd", "onTextChanged", "before", "onTextChanged$OUI_standardRelease", "performLongClick", "setInputType", "setOnFocusChangeListener", "l", "setOnTouchListener", "Landroid/view/View$OnTouchListener;", "setPasswordMask", "dotSizeRatio", "dotSpacingRatio", "setTextFading", "leftFading", "topFading", "rightFading", "bottomFading", "fadingLength", "CommitCompletionListener", "OnFocusChangeListenerWrapper", "OnTouchListenerWrapper", "TextWatcherWrapper", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OEditText extends AppCompatEditText {
    private a commitCompletionListener;
    private boolean isBottomFading;
    private boolean isLeftFading;
    private boolean isPerformingLongClick;
    private boolean isRightFading;
    private boolean isTopFading;
    private int mErrorBackgroundColor;
    private float mPasswordMaskDotSizeRatio;
    private float mPasswordMaskDotSpacingRatio;
    private final b onFocusChangeListenerWrapper;
    private final c onTouchListenerWrapper;
    private final d textWatcherWrapper;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "", "onCommitCompletion", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/view/inputmethod/CompletionInfo;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(CompletionInfo r1);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\u0005H\u0016R7\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/forms/OEditText$OnFocusChangeListenerWrapper;", "Landroid/view/View$OnFocusChangeListener;", "()V", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "hasFocus", "", "getAction", "()Lkotlin/jvm/functions/Function1;", "setAction", "(Lkotlin/jvm/functions/Function1;)V", "listener", "getListener", "()Landroid/view/View$OnFocusChangeListener;", "setListener", "(Landroid/view/View$OnFocusChangeListener;)V", "onFocusChange", BaseSwitches.V, "Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Function1<? super Boolean, Unit> f13857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View.OnFocusChangeListener f13858b;

        public b() {
        }

        public final View.OnFocusChangeListener a() {
            return this.f13858b;
        }

        public final void a(View.OnFocusChangeListener r3) {
            this.f13858b = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
        }

        public final void a(Function1<? super Boolean, Unit> r3) {
            this.f13857a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r3, boolean r4) {
            Function1<? super Boolean, Unit> r0 = this.f13857a;
            if (r0 == null) goto L6;
            r0.invoke(Boolean.valueOf(r4));
        L6:
            View.OnFocusChangeListener r2 = this.f13858b;
            if (r2 == null) goto L11;
            r2.onFocusChange(r3, r4);
            return;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016R9\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/forms/OEditText$OnTouchListenerWrapper;", "Landroid/view/View$OnTouchListener;", "()V", "action", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "event", "", "getAction", "()Lkotlin/jvm/functions/Function1;", "setAction", "(Lkotlin/jvm/functions/Function1;)V", "listener", "getListener", "()Landroid/view/View$OnTouchListener;", "setListener", "(Landroid/view/View$OnTouchListener;)V", "onTouch", "", BaseSwitches.V, "Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Function1<? super MotionEvent, Unit> f13859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View.OnTouchListener f13860b;

        public c() {
        }

        public final void a(View.OnTouchListener r3) {
            this.f13860b = (View.OnTouchListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnTouchListener.class, "com.obric.memorydata.plugin");
        }

        public final void a(Function1<? super MotionEvent, Unit> r3) {
            this.f13859a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r2, MotionEvent r3) {
            Function1<? super MotionEvent, Unit> r0 = this.f13859a;
            if (r0 == null) goto L6;
            r0.invoke(r3);
        L6:
            View.OnTouchListener r1 = this.f13860b;
            if (r1 != null) goto L10;
            return false;
        L10:
            return r1.onTouch(r2, r3);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u001e\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J*\u0010\u001f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R9\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rRx\u0010\u000e\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018Rx\u0010\u0019\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006 "}, d2 = {"Lcom/obric/oui/forms/OEditText$TextWatcherWrapper;", "Landroid/text/TextWatcher;", "()V", "afterTextChangedAction", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "s", "", "getAfterTextChangedAction", "()Lkotlin/jvm/functions/Function1;", "setAfterTextChangedAction", "(Lkotlin/jvm/functions/Function1;)V", "beforeTextChangedAction", "Lkotlin/Function4;", "", "", CommonConsts.APM_INNER_EVENT_COST_START, CommonConsts.COUNT_TYPE, "after", "getBeforeTextChangedAction", "()Lkotlin/jvm/functions/Function4;", "setBeforeTextChangedAction", "(Lkotlin/jvm/functions/Function4;)V", "onTextChangedAction", "before", "getOnTextChangedAction", "setOnTextChangedAction", "afterTextChanged", "beforeTextChanged", "onTextChanged", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> f13861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> f13862b;
        private Function1<? super Editable, Unit> c;

        public d() {
        }

        public final void a(Function1<? super Editable, Unit> r3) {
            this.c = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        public final void a(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3) {
            this.f13861a = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
            Function1<? super Editable, Unit> r2 = this.c;
            if (r2 == null) goto L7;
            r2.invoke(r4);
            return;
        }

        public final void b(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3) {
            this.f13862b = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2 = this.f13862b;
            if (r2 == null) goto L7;
            r2.invoke(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
            return;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2 = this.f13861a;
            if (r2 == null) goto L7;
            r2.invoke(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
            return;
        }
    }

    public OEditText(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OEditText(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OEditText(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        b r11 = new b();
        this.onFocusChangeListenerWrapper = r11;
        c r12 = new c();
        this.onTouchListenerWrapper = r12;
        d r0 = new d();
        this.textWatcherWrapper = r0;
        this.mPasswordMaskDotSizeRatio = 0.38f;
        this.mPasswordMaskDotSpacingRatio = 0.19f;
        this.mErrorBackgroundColor = ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, TypedValues.Custom.S_COLOR, "oui_functional_red_2"));
        setOnFocusChangeListener((View.OnFocusChangeListener) ZeusTransformUtils.preCheckCast(r11, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin"));
        super.setOnTouchListener((View.OnTouchListener) ZeusTransformUtils.preCheckCast(r12, View.OnTouchListener.class, "com.obric.memorydata.plugin"));
        addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin"));
        setHighlightColor(r9.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_highlight_color, TypedValues.Custom.S_COLOR, "oui_text_highlight_color")));
        applyPasswordTransformationIfNeeded();
    }

    public /* synthetic */ OEditText(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void applyPasswordTransformationIfNeeded() {
        if (isHiddenPasswordInputType(getInputType()) == false) goto L5;
        TransformationMethod r0 = getTransformationMethod();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.forms.a.class) == false) goto L21;
        boolean r3 = true;
        if (((com.obric.oui.forms.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.forms.a.class, "com.obric.memorydata.plugin")).a() != this.mPasswordMaskDotSizeRatio) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L21;
        if (((com.obric.oui.forms.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.forms.a.class, "com.obric.memorydata.plugin")).b() == this.mPasswordMaskDotSpacingRatio) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L21;
        return;
    L13:
        r1 = false;
    L21:
        super.setTransformationMethod((TransformationMethod) ZeusTransformUtils.preCheckCast(new com.obric.oui.forms.a(this.mPasswordMaskDotSizeRatio, this.mPasswordMaskDotSpacingRatio, this.mErrorBackgroundColor), TransformationMethod.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(getTransformationMethod(), PasswordTransformationMethod.class) == false) goto L23;
        super.setTransformationMethod(null);
        return;
    }

    private final boolean isHiddenPasswordInputType(int r5) {
        int r4 = r5 & 4095;
        if (r4 != 129) goto L5;
        boolean r1 = true;
    L7:
        if (r4 != 225) goto L9;
        boolean r2 = true;
    L11:
        if (r4 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r1 == true) goto L20;
        if (r2 == true) goto L21;
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    public static /* synthetic */ void setPasswordMask$default(OEditText r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        r1.setPasswordMask(r2, r3);
    }

    public static /* synthetic */ void setTextFading$default(OEditText r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r13 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r13 & 8) == 0) goto L17;
        boolean r5 = false;
    L18:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L17:
        r5 = r11;
        goto L18
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final void afterTextChanged$OUI_standardRelease(Function1<? super Editable, Unit> r3) {
        Function1<? super Editable, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.textWatcherWrapper.a(r4);
    }

    public final void beforeTextChanged$OUI_standardRelease(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3) {
        Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r4 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.textWatcherWrapper.b(r4);
    }

    public final void clearPasswordMask() {
        setPasswordMask(0.0f, 0.0f);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.isBottomFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    public final a getCommitCompletionListener() {
        return this.commitCompletionListener;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.isLeftFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r2 = super.getOnFocusChangeListener();
        if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L5;
        return r2;
    L5:
        return ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.isRightFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.isTopFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo r1) {
        super.onCommitCompletion(r1);
        a r0 = this.commitCompletionListener;
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    }

    public final void onFocusChange$OUI_standardRelease(Function1<? super Boolean, Unit> r3) {
        Function1<? super Boolean, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.onFocusChangeListenerWrapper.a(r4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void onOnTouchEvent$OUI_standardRelease(Function1<? super MotionEvent, Unit> r3) {
        Function1<? super MotionEvent, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.onTouchListenerWrapper.a(r4);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        if (r1 == r2) goto L5;
        boolean r3 = true;
    L7:
        if (this.isPerformingLongClick == true) goto L11;
        if (r3 == false) goto L12;
        com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = false;
        goto L7
    }

    public final void onTextChanged$OUI_standardRelease(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3) {
        Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r4 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.textWatcherWrapper.a(r4);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.isPerformingLongClick = true;
        boolean r0 = super.performLongClick();
        this.isPerformingLongClick = false;
        return r0;
    }

    public final void setCommitCompletionListener(a r3) {
        this.commitCompletionListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.TextView
    public void setInputType(int r1) {
        super.setInputType(r1);
        applyPasswordTransformationIfNeeded();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L5;
        super.setOnFocusChangeListener(r4);
        return;
    L5:
        this.onFocusChangeListenerWrapper.a(r4);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r3) {
        View.OnTouchListener r4 = (View.OnTouchListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnTouchListener.class, "com.obric.memorydata.plugin");
        this.onTouchListenerWrapper.a(r4);
    }

    public final void setPasswordMask(float r4, float r5) {
        float r6 = RangesKt.coerceAtLeast(r4, 0.0f);
        float r7 = RangesKt.coerceAtLeast(r5, 0.0f);
        boolean r1 = true;
        if (this.mPasswordMaskDotSizeRatio != r6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        this.mPasswordMaskDotSizeRatio = r6;
        this.mPasswordMaskDotSpacingRatio = r7;
        applyPasswordTransformationIfNeeded();
        return;
    L8:
        if (this.mPasswordMaskDotSpacingRatio == r7) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTextFading(boolean r1, boolean r2, boolean r3, boolean r4, int r5) {
        setFadingEdgeLength(r5);
        this.isLeftFading = r1;
        this.isTopFading = r2;
        this.isRightFading = r3;
        this.isBottomFading = r4;
        boolean r6 = false;
        if (r1 == true) goto L7;
        if (r3 == true) goto L7;
        boolean r7 = false;
    L8:
        setHorizontalFadingEdgeEnabled(r7);
        if (this.isTopFading == false) goto L11;
    L12:
        r6 = true;
    L13:
        setVerticalFadingEdgeEnabled(r6);
        return;
    L11:
        if (this.isBottomFading == false) goto L13;
    L7:
        r7 = true;
        goto L8
    }
}
