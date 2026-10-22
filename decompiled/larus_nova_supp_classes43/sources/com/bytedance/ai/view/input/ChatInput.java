package com.bytedance.ai.view.input;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001Z\b\u0007\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010W\u001a\u00020BH\u0002J\b\u0010X\u001a\u00020BH\u0002J\u0016\u0010\\\u001a\u00020]2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020B06H\u0003J\b\u0010c\u001a\u00020BH\u0003J$\u0010d\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K0e2\u0006\u0010f\u001a\u00020'2\u0006\u0010g\u001a\u00020hH\u0002J\b\u0010i\u001a\u00020BH\u0002J\b\u0010j\u001a\u00020BH\u0002J\b\u0010k\u001a\u00020'H\u0016J\b\u0010l\u001a\u00020BH\u0016J\b\u0010m\u001a\u00020BH\u0016J\b\u0010n\u001a\u00020BH\u0016J\b\u0010o\u001a\u00020BH\u0016J\u0006\u0010p\u001a\u00020BJ\u0016\u0010q\u001a\u00020B2\u0006\u0010r\u001a\u00020/2\u0006\u0010s\u001a\u00020/R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001e\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\u0011R#\u0010!\u001a\n \u000f*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R5\u0010>\u001a\u001d\u0012\u0013\u0012\u00110/¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020B0?X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR_\u0010G\u001aG\u0012\u0013\u0012\u00110I¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110K¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110K¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020-0HX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR&\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0S06X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00108\"\u0004\bV\u0010:R\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[R\u0010\u0010_\u001a\u00020]8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020]8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/bytedance/ai/view/input/ChatInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/floating/IChatInput;", "context", "Landroid/content/Context;", "ability", "Lcom/bytedance/ai/view/input/Ability;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/view/input/Ability;)V", "getAbility", "()Lcom/bytedance/ai/view/input/Ability;", "config", "Lcom/bytedance/ai/api/model/ability/FloatingSpeakerConfig;", "_inputAreaContainer", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "get_inputAreaContainer", "()Landroid/view/ViewGroup;", "_inputAreaContainer$delegate", "Lkotlin/Lazy;", "_speakText", "Landroid/widget/TextView;", "get_speakText", "()Landroid/widget/TextView;", "_speakText$delegate", "_inputText", "Landroid/widget/EditText;", "get_inputText", "()Landroid/widget/EditText;", "_inputText$delegate", "_inputArea", "get_inputArea", "_inputArea$delegate", "_actionArea", "Landroid/widget/LinearLayout;", "get_actionArea", "()Landroid/widget/LinearLayout;", "_actionArea$delegate", "_actionInput", "Landroid/view/View;", "_actionSpeak", "_actionSend", "_chatStatusJob", "Lkotlinx/coroutines/Job;", "_speakOnInputFlag", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "placeHolder", "getPlaceHolder", "()Ljava/lang/String;", "setPlaceHolder", "(Ljava/lang/String;)V", "botId", "Lkotlin/Function0;", "getBotId", "()Lkotlin/jvm/functions/Function0;", "setBotId", "(Lkotlin/jvm/functions/Function0;)V", "cvsId", "getCvsId", "setCvsId", "onSend", "Lkotlin/Function1;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getOnSend", "()Lkotlin/jvm/functions/Function1;", "setOnSend", "(Lkotlin/jvm/functions/Function1;)V", "onSpeakEvent", "Lkotlin/Function3;", "", "action", "", "globalX", "globalY", "getOnSpeakEvent", "()Lkotlin/jvm/functions/Function3;", "setOnSpeakEvent", "(Lkotlin/jvm/functions/Function3;)V", "chatStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ai/view/input/FloatingChatStatus;", "getChatStatus", "setChatStatus", "setupStatusChangedEvent", "setupInputArea", "startSpeakRunnable", "com/bytedance/ai/view/input/ChatInput$startSpeakRunnable$1", "Lcom/bytedance/ai/view/input/ChatInput$startSpeakRunnable$1;", "onSpeakTouchHook", "Landroid/view/View$OnTouchListener;", "onClick", "onEditTextTouchListener", "speakerTouchListener", "lastPressTime", "", "setupSpeakArea", "getGlobalActionXY", "Lkotlin/Pair;", "view", "event", "Landroid/view/MotionEvent;", "setupActionArea", "setupInputContainer", "displayView", "onDestroy", "hideKeyboard", "performActionInputClick", "performActionSpeakClick", "requestInputFocus", "updateInputText", "text", "mode", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInput extends ConstraintLayout {
    public static final /* synthetic */ int v = 0;
    public final com.bytedance.ai.view.input.a a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final View g;
    public final View h;
    public final View i;
    public Job j;
    public boolean k;
    public String l;
    public Function0<String> m;
    public Function0<String> n;
    public Function1<? super String, Unit> o;
    public Function3<? super Integer, ? super Float, ? super Float, Boolean> p;
    public Function0<? extends z0<FloatingChatStatus>> q;
    public final b r;
    public final j s;
    public final q t;
    public long u;

    public static final class a {
    }

    public static final class b implements Runnable {
        public MotionEvent a;
        public View b;
        public final /* synthetic */ ChatInput c;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.t.onTouch(this.b, this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ChatInput r1) {
            this.c = r1;
        }
    }

    static {
    }

    private final LinearLayout get_actionArea() {
        return (LinearLayout) this.f.getValue();
    }

    private final ViewGroup get_inputArea() {
        return (ViewGroup) this.e.getValue();
    }

    private final ViewGroup get_inputAreaContainer() {
        return (ViewGroup) this.b.getValue();
    }

    private final EditText get_inputText() {
        return (EditText) this.d.getValue();
    }

    private final TextView get_speakText() {
        return (TextView) this.c.getValue();
    }

    public final void hideKeyboard() {
        get_inputText().clearFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i6() {
        get_inputText().requestFocus();
        EditText r0 = get_inputText();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r0, "view");
        Context r1 = getContext();
        InputMethodManager r10 = null;
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r11 = (Activity) r1;
    L6:
        if (r11 == null) goto L18;
        Window r12 = r11.getWindow();
        if (r12 != null) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L12;
        new WindowInsetsControllerCompat(r12, r0).show(WindowInsetsCompat.Type.ime());
        return;
    L12:
        Object r13 = getContext().getSystemService("input_method");
        if ((r13 instanceof InputMethodManager) == false) goto L15;
        r10 = (InputMethodManager) r13;
    L15:
        if (r10 == null) goto L21;
        r10.showSoftInput(r0, 0);
        return;
    L21:
        return;
    L18:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final com.bytedance.ai.view.input.a getAbility() {
        return this.a;
    }

    public Function0<String> getBotId() {
        return this.m;
    }

    public Function0<z0<FloatingChatStatus>> getChatStatus() {
        return this.q;
    }

    public Function0<String> getCvsId() {
        return this.n;
    }

    public Function1<String, Unit> getOnSend() {
        return this.o;
    }

    public Function3<Integer, Float, Float, Boolean> getOnSpeakEvent() {
        return this.p;
    }

    public String getPlaceHolder() {
        return this.l;
    }

    public static void Y5(ChatInput r10) {
        Function1<String, Unit> r0 = r10.getOnSend();
        if (r0 == null) goto L5;
        r0.invoke(r10.get_inputText().getText().toString());
    L5:
        r10.get_inputText().setText("");
        r10.hideKeyboard();
        Function0<z0<FloatingChatStatus>> r11 = r10.getChatStatus();
        if (r11 == null) goto L11;
        z0 r12 = (z0) r11.invoke();
        if (r12 == null) goto L12;
        r12.tryEmit(FloatingChatStatus.READY_TO_INPUT);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ EditText b6(ChatInput r0) {
        return r0.get_inputText();
    }

    public static final /* synthetic */ TextView c6(ChatInput r0) {
        return r0.get_speakText();
    }

    public void setBotId(Function0<String> r1) {
        this.m = r1;
    }

    public void setChatStatus(Function0<? extends z0<FloatingChatStatus>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.q = r10;
    }

    public void setCvsId(Function0<String> r1) {
        this.n = r1;
    }

    public void setOnSend(Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.o = r10;
    }

    public void setOnSpeakEvent(Function3<? super Integer, ? super Float, ? super Float, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.p = r10;
    }

    public void setPlaceHolder(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.l = r10;
        get_inputText().setHint(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.bytedance.ai.view.input.j] */
    public ChatInput(final Context r10, com.bytedance.ai.view.input.a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "ability");
        super(r10);
        this.a = r11;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        g2.a r1 = r0.h();
    L6:
        this.b = LazyKt.lazy(new com.bytedance.ai.view.input.b(this));
        this.c = LazyKt.lazy(new k(this));
        this.d = LazyKt.lazy(new l(this));
        this.e = LazyKt.lazy(new m(this));
        this.f = LazyKt.lazy(new n(this));
        if (r1 == null) goto L13;
        Function1<Context, View> r12 = r1.g;
        if (r12 == null) goto L13;
        View r13 = (View) r12.invoke(r10);
        if (r13 == null) goto L13;
        r13.setVisibility(8);
    L14:
        this.g = r13;
        if (r1 == null) goto L21;
        Function1<Context, View> r14 = r1.h;
        if (r14 == null) goto L21;
        final View r15 = (View) r14.invoke(r10);
        if (r15 == null) goto L21;
        r15.setVisibility(8);
    L22:
        this.h = r15;
        if (r1 == null) goto L29;
        Function1<Context, View> r16 = r1.i;
        if (r16 == null) goto L29;
        View r17 = (View) r16.invoke(r10);
        if (r17 == null) goto L29;
        r17.setVisibility(8);
    L30:
        this.i = r17;
        if (r1 == null) goto L36;
        Function0<String> r18 = r1.a;
        if (r18 == null) goto L36;
        String r19 = (String) r18.invoke();
        if (r19 == null) goto L36;
    L37:
        this.l = r19;
        this.m = r11.a;
        this.n = r11.b;
        this.o = new o(this);
        this.p = r11.e;
        this.q = r11.d;
        View.inflate(r10, 2131558714, this);
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(0, -2);
        r110.bottomToBottom = 0;
        r110.leftToLeft = 0;
        r110.rightToRight = 0;
        setLayoutParams(r110);
        if (r1 == null) goto L42;
        Function1<ViewGroup, Unit> r111 = r1.c;
        if (r111 == null) goto L42;
        r111.invoke(get_inputArea());
    L42:
        if (r1 == null) goto L46;
        Function1<ViewGroup, Unit> r112 = r1.b;
        if (r112 == null) goto L46;
        r112.invoke(get_inputAreaContainer());
    L46:
        TextView r113 = get_speakText();
        if (r113 == null) goto L54;
        r113.setVisibility(8);
        if (r1 == null) goto L53;
        Function1<TextView, Unit> r20 = r1.e;
        if (r20 == null) goto L53;
        r20.invoke(r113);
    L53:
        r113.setOnTouchListener(new r(this));
    L54:
        if (r13 == null) goto L56;
        r13.setVisibility(8);
        r13.setOnClickListener(new s(this));
        get_actionArea().addView(r13);
    L56:
        if (r15 == null) goto L58;
        r15.setVisibility(8);
        r15.setOnClickListener(new c(this));
        get_actionArea().addView(r15);
        final Function0 r114 = new d(r15);
        r15.setOnTouchListener(new j(this, r114));
    L58:
        if (r17 == null) goto L60;
        r17.setVisibility(8);
        r17.setOnClickListener(new e(this));
        get_actionArea().addView(r17);
    L60:
        final EditText r115 = get_inputText();
        r115.setHint(getPlaceHolder());
        Intrinsics.checkNotNull(r115);
        r115.addTextChangedListener(new t(this));
        if (r1 == null) goto L65;
        Function1<EditText, Unit> r21 = r1.f;
        if (r21 == null) goto L65;
        r21.invoke(r115);
    L65:
        get_inputText().setOnFocusChangeListener(new g(r115, this));
        get_inputText().post(new h(r115, this));
        this.j = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new ChatInput$setupStatusChangedEvent$1(this, null), 3, null);
        this.r = new b(this);
        final Function0 r116 = new p(this, r10);
        this.s = new j(this, r116);
        this.t = new q(this);
        return;
    L36:
        r19 = "";
    L29:
        r17 = null;
    L21:
        r15 = null;
    L13:
        r13 = null;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public static void S5(EditText r0, ChatInput r1) {
        if (r0.hasFocus() == true) goto L6;
        r1.get_inputText().setOnTouchListener(r1.s);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void U5(ChatInput r10, Context r11) {
        r10.requestFocus();
        InputMethodManager r0 = null;
        if (r11 == null) goto L5;
        Object r12 = r11.getSystemService("input_method");
    L7:
        if ((r12 instanceof InputMethodManager) == false) goto L9;
        r0 = (InputMethodManager) r12;
    L9:
        if (r0 == null) goto L12;
        r0.showSoftInput(r10.get_inputText(), 0);
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L7
    }

    public static Unit Z5(final ChatInput r10, final Context r11) {
        r10.get_inputText().post(new f(r10, r11));
        return Unit.INSTANCE;
    }

    public static void T5(EditText r1, ChatInput r10, boolean r11) {
        InputMethodManager r0 = null;
        if (r11 == true) goto L14;
        Context r12 = r1.getContext();
        if (r12 == null) goto L7;
        Object r13 = r12.getSystemService("input_method");
    L9:
        if ((r13 instanceof InputMethodManager) == false) goto L11;
        r0 = (InputMethodManager) r13;
    L11:
        if (r0 == null) goto L13;
        r0.hideSoftInputFromWindow(r10.get_inputText().getWindowToken(), 0);
    L13:
        r10.get_inputText().setOnTouchListener(r10.s);
        return;
    L7:
        r13 = null;
        goto L9
    L14:
        r10.get_inputText().setOnTouchListener(null);
    }

    public static void V5(String r1, ChatInput r10, String r11) {
        if (Intrinsics.areEqual(r1, "replace") == false) goto L5;
        r10.get_inputText().setText(r11);
    L6:
        Editable r12 = r10.get_inputText().getText();
        boolean r13 = false;
        if (r12 != null) goto L9;
    L14:
        if (r13 == false) goto L17;
        r10.get_inputText().setSelection(r10.get_inputText().getText().length());
        return;
    L17:
        return;
    L9:
        if (r12.length() <= 0) goto L11;
        boolean r14 = true;
    L12:
        if (r14 != true) goto L14;
        r13 = true;
        goto L14
    L11:
        r14 = false;
        goto L12
    L5:
        r10.get_inputText().append(r11);
        goto L6
    }

    public static void R5(ChatInput r10, Function0 r11, View r12, MotionEvent r13) {
        int r0 = r13.getActionMasked();
        if (r0 != 0) goto L5;
        b r14 = r10.r;
        r14.b = r12;
        r14.a = MotionEvent.obtain(r13);
        r10.get_inputText().postDelayed(r10.r, ViewConfiguration.getLongPressTimeout());
        return;
    L5:
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L15;
        return;
    L12:
        if (((z0) r10.getChatStatus().invoke()).getValue() != FloatingChatStatus.ON_SPEAK) goto L20;
        r10.t.onTouch(r12, r13);
        return;
    L20:
        return;
    L15:
        if (((z0) r10.getChatStatus().invoke()).getValue() != FloatingChatStatus.ON_SPEAK) goto L17;
        r10.t.onTouch(r12, r13);
        return;
    L17:
        r10.get_inputText().removeCallbacks(r10.r);
        r11.invoke();
    }
}
