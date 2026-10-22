package com.bytedance.ai.view.input;

import android.content.Context;
import android.graphics.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u00105\u001a\u000206H\u0016J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,H\u0002J\u0018\u0010=\u001a\u00020\u00192\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,H\u0002J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R=\u0010\u0014\u001a%\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R2\u0010)\u001a\u001a\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00130*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ai/view/input/ChatSpeaker;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/floating/IChatSpeaker;", "context", "Landroid/content/Context;", "ability", "Lcom/bytedance/ai/view/input/Ability;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/view/input/Ability;)V", "getAbility", "()Lcom/bytedance/ai/view/input/Ability;", "config", "Lcom/bytedance/ai/api/model/ability/FloatingSpeakerConfig;", "_tips", "Lcom/bytedance/ai/floating/ChatSpeakTipsAbility;", "_visualizer", "Lcom/bytedance/ai/floating/ChatSpeakVisualizerAbility;", "_cancelStatus", "Lkotlin/Pair;", "", "onSpeakStatusChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "onSpeak", "", "Lcom/bytedance/ai/floating/SpeakStatusCallback;", "getOnSpeakStatusChanged", "()Lkotlin/jvm/functions/Function1;", "setOnSpeakStatusChanged", "(Lkotlin/jvm/functions/Function1;)V", "botId", "Lkotlin/Function0;", "", "getBotId", "()Lkotlin/jvm/functions/Function0;", "setBotId", "(Lkotlin/jvm/functions/Function0;)V", "cvsId", "getCvsId", "setCvsId", "onSpeakEvent", "Lkotlin/Function3;", "", "", "getOnSpeakEvent", "()Lkotlin/jvm/functions/Function3;", "setOnSpeakEvent", "(Lkotlin/jvm/functions/Function3;)V", "chatStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ai/view/input/FloatingChatStatus;", "getChatStatus", "displayView", "Landroid/view/View;", "isSubmit", "_onSpeakAbility", "Lcom/bytedance/ai/floating/OnSpeakAbility;", "handleMove", "globalX", "globalY", "handleRelease", "touchOutsideOfVisualizer", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSpeaker extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public final a a;
    public final g2.a b;
    public final y4.a c;
    public final y4.b d;
    public Pair<Boolean, Boolean> e;
    public Function1<? super Boolean, Unit> f;
    public Function0<String> g;
    public Function0<String> h;
    public Function3<? super Integer, ? super Float, ? super Float, Boolean> i;
    public final Function0<z0<FloatingChatStatus>> j;
    public final y4.c k;

    public final a getAbility() {
        return this.a;
    }

    public Function0<String> getBotId() {
        return this.g;
    }

    public Function0<z0<FloatingChatStatus>> getChatStatus() {
        return this.j;
    }

    public Function0<String> getCvsId() {
        return this.h;
    }

    public Function3<Integer, Float, Float, Boolean> getOnSpeakEvent() {
        return this.i;
    }

    public Function1<Boolean, Unit> getOnSpeakStatusChanged() {
        return this.f;
    }

    public final boolean R5(float r10) {
        y4.b r0 = this.d;
        if (r0 == null) goto L14;
        Function0<Rect> r1 = r0.b;
        if (r1 == null) goto L14;
        Rect r11 = (Rect) r1.invoke();
        if (r11 == null) goto L14;
        if (r10 >= r11.top) goto L12;
    L13:
        return true;
    L12:
        if (r10 > r11.bottom) goto L13;
    L14:
        return false;
    }

    public void setBotId(Function0<String> r1) {
        this.g = r1;
    }

    public void setCvsId(Function0<String> r1) {
        this.h = r1;
    }

    public void setOnSpeakEvent(Function3<? super Integer, ? super Float, ? super Float, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.i = r10;
    }

    public void setOnSpeakStatusChanged(Function1<? super Boolean, Unit> r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.ai.view.input.w] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.view.input.x] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ai.view.input.y] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.ai.view.input.v] */
    public ChatSpeaker(Context r11, a r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "ability");
        super(r11);
        this.a = r12;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r13 = AppletRuntimeManager.d;
        if (r13 == null) goto L5;
        g2.a r14 = r13.h();
    L6:
        this.b = r14;
        this.e = new Pair(null, Boolean.FALSE);
        this.f = r12.f;
        this.g = r12.a;
        this.h = r12.b;
        this.i = new u(this);
        this.j = r12.d;
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(0, -2);
        r0.bottomToBottom = 0;
        r0.leftToLeft = 0;
        r0.rightToRight = 0;
        setLayoutParams(r0);
        this.k = new y4.c(new w(this), new x(this), new y(this), new v(this), r12.c, r12.h);
        if (r14 == null) goto L14;
        Function1<ConstraintLayout, Pair<y4.a, y4.b>> r15 = r14.d;
        if (r15 == null) goto L15;
        Pair r16 = (Pair) r15.invoke(this);
        if (r16 == null) goto L16;
        this.c = (y4.a) r16.getFirst();
        this.d = (y4.b) r16.getSecond();
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r14 = null;
        goto L6
    }
}
