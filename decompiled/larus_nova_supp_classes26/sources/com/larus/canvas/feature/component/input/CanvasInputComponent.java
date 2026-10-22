package com.larus.canvas.feature.component.input;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020#H\u0002J\f\u0010'\u001a\u00020\b*\u00020(H\u0002J\f\u0010)\u001a\u00020\b*\u00020(H\u0002J\f\u0010*\u001a\u00020\b*\u00020(H\u0002J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00101\u001a\u00020#2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u00020\bH\u0016J9\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u0001032\b\u0010<\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u0006H\u0016J\u0010\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 ¨\u0006F"}, d2 = {"Lcom/larus/canvas/feature/component/input/CanvasInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "<init>", "()V", "curInputContent", "", "isPaste", "", "rootView", "Landroid/view/View;", "_canvasInputEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/canvas/feature/ability/CanvasInputEvent;", "canvasInputEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getCanvasInputEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "onAttach", "", "onViewCreated", "view", "configCoreInputManager", "onReadyToSpeak", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "onReadyToInput", "onReadyToSend", "onCopyAndSendClick", "onCopyClick", "getPrompt", "getHint", "changeImeStatus", "show", "setInputTextSelection", "index", "", "startIndex", "endIndex", "isImeShowing", "updateInputContentText", ShareType.TEXT, "requestFocus", "showIme", "selectionStartIndex", "selectionEndIndex", "(Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/Integer;)V", "initInput", "inputInitConfig", "Lcom/larus/canvas/feature/ability/InputInitConfig;", "updateInputHintText", "hint", "setInputVisible", "visible", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasInputComponent extends BaseContentWidget implements fy8.f {
    public static final /* synthetic */ int t = 0;
    public String m;
    public View n;
    public final MutableSharedFlow<fy8.g> o;
    public final a1 p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;

    public static final class a {
    }

    static {
    }

    public final ICoreInputAbility Y2() {
        return (ICoreInputAbility) this.q.getValue();
    }

    @Override // fy8.f
    public final String getPrompt() {
        va8.o r0 = (va8.o) this.r.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.u7();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final z8 h3() {
        return (z8) this.s.getValue();
    }

    @Override // fy8.f
    public final boolean w() {
        va8.o r0 = (va8.o) this.r.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.w();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fy8.f.class);
    }

    public CanvasInputComponent() {
        this.m = "";
        MutableSharedFlow<fy8.g> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.o = r0;
        this.p = kotlinx.coroutines.flow.e.a(r0);
        this.q = LazyKt.lazy(new h(this));
        this.r = LazyKt.lazy(new i(this));
        this.s = LazyKt.lazy(new j(this));
    }

    @Override // fy8.f
    public final void J3() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasInputComponent$changeImeStatus$1(false, this, null), 3, null);
    }

    @Override // fy8.f
    public final void KK() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasInputComponent$setInputVisible$1(true, this, null), 3, null);
    }

    @Override // fy8.f
    public final a1 CV() {
        return this.p;
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.n = r5;
        View r6 = r5.findViewById(2131362044);
        if (r6 == null) goto L5;
        e1.o(r6);
    L5:
        z8 r7 = h3();
        if (r7 == null) goto L8;
        r7.z9(true);
    L8:
        z8 r8 = h3();
        if (r8 == null) goto L11;
        r8.R8();
    L11:
        z8 r9 = h3();
        if (r9 == null) goto L14;
        r9.s9();
    L14:
        z8 r10 = h3();
        if (r10 == null) goto L17;
        r10.f9(true);
    L17:
        z8 r11 = h3();
        if (r11 == null) goto L20;
        r11.w8();
    L20:
        z8 r12 = h3();
        if (r12 == null) goto L23;
        r12.e9();
    L23:
        z8 r13 = h3();
        if (r13 == null) goto L26;
        r13.w9(false);
    L26:
        z8 r14 = h3();
        if (r14 == null) goto L29;
        r14.c9();
    L29:
        ICoreInputAbility r15 = Y2();
        if (r15 == null) goto L32;
        r15.tr(new k(this));
    L32:
        z8 r16 = h3();
        if (r16 == null) goto L35;
        r16.y9(1, new g9.a(new l(this)));
    L35:
        z8 r17 = h3();
        if (r17 == null) goto L38;
        r17.y9(2, new g9.a(new m(this)));
    L38:
        z8 r18 = h3();
        if (r18 == null) goto L41;
        r18.y9(3, new g9.a(new n(this)));
    L41:
        z8 r19 = h3();
        if (r19 == null) goto L44;
        r19.r8(true, new z8.e(new o(this), new p(this)));
    L44:
        ICoreInputAbility r20 = Y2();
        if (r20 == null) goto L47;
        r20.YT(new r(this));
    L47:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r21 = s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r21 == null) goto L51;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.b(r21, new q(this));
        return;
    }

    @Override // fy8.f
    public final void qi(fy8.k r8) {
        Intrinsics.checkNotNullParameter(r8, "inputInitConfig");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasInputComponent$initInput$1(this, r8, null), 3, null);
    }

    @Override // fy8.f
    public final void t4(String r13, boolean r14, boolean r15, Integer r16, Integer r17) {
        Intrinsics.checkNotNullParameter(r13, ShareType.TEXT);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasInputComponent$updateInputContentText$1(this, r13, r14, r15, r16, r17, null), 3, null);
    }
}
