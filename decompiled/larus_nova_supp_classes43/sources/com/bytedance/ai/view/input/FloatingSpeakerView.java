package com.bytedance.ai.view.input;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0019H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J3\u0010>\u001a\u00020\u00122)\u0010?\u001a%\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013H\u0016J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020/H\u0016J\b\u0010B\u001a\u00020\u0012H\u0014J \u0010C\u001a\u00020\u00122\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\"J\u0006\u0010E\u001a\u00020\u0012J\u0016\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0019J\b\u0010H\u001a\u00020\u0012H\u0002J\b\u0010I\u001a\u00020\u0012H\u0002J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\bH\u0002J\u0012\u0010L\u001a\u00020\u000e2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016R3\u0010\u000b\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rj\u0002`\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/01X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ai/view/input/FloatingSpeakerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/floating/IFloatingSpeaker;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_speakStatusCallbackHolder", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "onSpeak", "", "Lcom/bytedance/ai/floating/SpeakStatusCallback;", "_inputView", "Lcom/bytedance/ai/view/input/ChatInput;", "_speakerView", "Lcom/bytedance/ai/view/input/ChatSpeaker;", "_botId", "", "_conversationId", "_appendQuery", "_chatStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ai/view/input/FloatingChatStatus;", "_chatStatusJob", "Lkotlinx/coroutines/Job;", "redirectQuery", "Lkotlin/Function2;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "marginBottom", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "_inputModeFlow", "Lcom/bytedance/ai/bridge/method/floatinginput/InputMode;", "inputModeFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInputModeFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_ability", "Lcom/bytedance/ai/view/input/Ability;", "updateBotId", "botId", "conversationId", "setPlaceHolder", "placeHolder", "setAppendQuery", "appendQuery", "clearAppendQuery", "addSpeakStatusCallback", "callback", "changeInputMode", "mode", "onDetachedFromWindow", "setRedirectQuery", "redirect", "requestInputFocus", "updateInputText", "text", "onSpeakerCreate", "onSpeakerDestroy", "setMarginBottomLocked", "margin", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingSpeakerView extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public final Set<Function1<Boolean, Unit>> a;
    public ChatInput b;
    public ChatSpeaker c;
    public String d;
    public String e;
    public String f;
    public final StateFlowImpl g;
    public Job h;
    public Function2<? super String, ? super String, Boolean> i;
    public int j;
    public boolean k;
    public final StateFlowImpl l;
    public final b1 m;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InputMode.values().length];
            r0[InputMode.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[InputMode.ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public FloatingSpeakerView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public FloatingSpeakerView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ChatInput r0 = this.b;
        if (r0 == null) goto L7;
        Job r1 = r0.j;
        if (r1 == null) goto L7;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L7:
        this.b = null;
        this.c = null;
        Job r10 = this.h;
        if (r10 == null) goto L10;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L10:
        this.h = null;
        this.g.setValue(FloatingChatStatus.READY_TO_INPUT);
    }

    public boolean getEnable() {
        return this.k;
    }

    public i1<InputMode> getInputModeFlow() {
        return this.m;
    }

    public int getMarginBottom() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setMarginBottomLocked(int r10) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r10);
    }

    public final void R5(InputMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        int r11 = a.a[r10.ordinal()];
        if (r11 != 1) goto L5;
        ChatInput r12 = this.b;
        if (r12 == null) goto L22;
        View r13 = r12.g;
        if (r13 == null) goto L23;
        r13.performClick();
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r11 != 2) goto L12;
        ChatInput r14 = this.b;
        if (r14 == null) goto L19;
        View r15 = r14.h;
        if (r15 == null) goto L20;
        r15.performClick();
        return;
    L20:
        return;
    L19:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (getEnable() == true) goto L7;
        return true;
    L7:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r10);
    }

    public void setAppendQuery(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appendQuery");
        this.f = r10;
    }

    public void setEnable(boolean r1) {
        this.k = r1;
    }

    public void setMarginBottom(int r1) {
        this.j = r1;
        setMarginBottomLocked(r1);
    }

    public void setPlaceHolder(String r10) {
        String r0 = null;
        if (r10 != null) goto L5;
    L11:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r11 = AppletRuntimeManager.d;
        if (r11 == null) goto L18;
        g2.a r12 = r11.h();
        if (r12 == null) goto L18;
        Function0<String> r13 = r12.a;
        if (r13 == null) goto L18;
        r0 = (String) r13.invoke();
    L18:
        if (r0 == null) goto L23;
        ChatInput r14 = this.b;
        if (r14 == null) goto L24;
        r14.setPlaceHolder(r0);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (com.bytedance.ai.utils.f.g(r10) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L11;
        r0 = r10;
        goto L18
    }

    public final void setRedirectQuery(Function2<? super String, ? super String, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "redirect");
        this.i = r10;
    }

    public final void S5(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r11, "mode");
        final ChatInput r12 = this.b;
        if (r12 == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r11, "mode");
        p2.c.a().post(new i(r11, r12, r10));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.ai.view.input.g0] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.ai.view.input.h0] */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.view.View, com.bytedance.ai.view.input.ChatInput] */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.view.View, com.bytedance.ai.view.input.ChatSpeaker] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ai.view.input.z] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.ai.view.input.a0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.view.input.b0] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ai.view.input.c0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.ai.view.input.d0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.ai.view.input.e0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedance.ai.view.input.f0] */
    public FloatingSpeakerView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        this.a = new LinkedHashSet();
        this.g = j1.a(FloatingChatStatus.READY_TO_INPUT);
        this.k = true;
        StateFlowImpl r1 = j1.a(InputMode.TEXT);
        this.l = r1;
        this.m = kotlinx.coroutines.flow.e.b(r1);
        com.bytedance.ai.view.input.a r10 = new com.bytedance.ai.view.input.a(new z(this), new a0(this), new b0(this), new c0(this), new d0(this), new e0(this), new f0(this), new g0(this), new h0(this));
        TypedArray r16 = r13.obtainStyledAttributes(r14, new int[]{2130969949}, r15, 0);
        setEnable(r16.getBoolean(0, true));     // Catch: Throwable -> L6
        r16.recycle();
        ?? r17 = new ChatInput(getContext(), r10);
        r17.setVisibility(8);
        addView(r17);
        this.b = r17;
        ?? r18 = new ChatSpeaker(getContext(), r10);
        r18.setVisibility(8);
        addView(r18);
        this.c = r18;
        this.h = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new FloatingSpeakerView$onSpeakerCreate$3(this, null), 3, null);
        return;
    L6:
        th = move-exception;
        r16.recycle();
        throw th;
    }

    public /* synthetic */ FloatingSpeakerView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
