package com.obric.assistant.cocreationreview;

import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.instruction.g;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/cocreationreview/CocreationTaskLauncher$SendTarget;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationTaskLauncher$run$target$1", f = "CocreationTaskLauncher.kt", i = {0, 0}, l = {49}, m = "invokeSuspend", n = {"switchingAbility", "lastSwitchTime"}, s = {"L$0", "J$0"})
public final class CocreationTaskLauncher$run$target$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CocreationTaskLauncher.b>, Object> {
    final /* synthetic */ IAssistantChatWindow $chatWindow;
    final /* synthetic */ Ref.ObjectRef<String> $waitingFor;
    long J$0;
    Object L$0;
    int label;

    public CocreationTaskLauncher$run$target$1(IAssistantChatWindow r1, Ref.ObjectRef<String> r2, Continuation<? super CocreationTaskLauncher$run$target$1> r3) {
        this.$chatWindow = r1;
        this.$waitingFor = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CocreationTaskLauncher$run$target$1(this.$chatWindow, this.$waitingFor, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super CocreationTaskLauncher.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0034 -> B:12:0x0037). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        long r5 = this.J$0;
        g r3 = (g) this.L$0;
        ResultKt.throwOnFailure(r20);
        CocreationTaskLauncher$run$target$1 r7 = this;
    L12:
        boolean r8 = r7.$chatWindow.isWindowMode();
        r7.$waitingFor.element = "window";
        if (r8 == false) goto L15;
        boolean r10 = r7.$chatWindow.isShowing();
    L25:
        if (r10 == true) goto L26;
    L9:
        r7.L$0 = r3;
        r7.J$0 = r5;
        r7.label = 1;
        if (DelayKt.delay(100, r7) != r1) goto L12;
        return r1;
    L26:
        r7.$waitingFor.element = "chat context";
        if (r8 == false) goto L29;
        t1a.b r9 = r7.$chatWindow.provideWindowVContext();
    L30:
        if (r9 == null) goto L9;
        r7.$waitingFor.element = "input ability";
        g r11 = (g) r9.getAbility(g.class);
        if (r11 == null) goto L9;
        r7.$waitingFor.element = "conversation";
        com.larus.bmhome.chat.component.cvs.y r12 = r9.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r12 == null) goto L9;
        String r13 = r12.Y1();
        if (r13 == null) goto L9;
        if ((!StringsKt.isBlank(r13)) == true) goto L43;
        r13 = null;
    L43:
        if (r13 == null) goto L9;
        r7.$waitingFor.element = "message ability";
        gd8.g r14 = r9.getAbility(gd8.g.class);
        if (r14 == null) goto L9;
        r7.$waitingFor.element = "phone availability";
        ObricTaskSkillDelegate r15 = ObricTaskSkillDelegate.b;
        if (r15.q(10000) == false) goto L9;
        r7.$waitingFor.element = "phone mode";
        if (r15.c(r11.Ql()) == true) goto L52;
        if (r3 == r11) goto L55;
    L56:
        com.larus.bmhome.actionbar.model.z0 r16 = r11.un(ActiveSwitchType.DEEPTHINK, null);
        if (r16 == null) goto L9;
        com.larus.bmhome.actionbar.model.p0 r17 = r16.o;
        if (r17 == null) goto L9;
        if (Intrinsics.areEqual(r17.k, Boxing.boxBoolean(true)) == false) goto L98;
        com.larus.bmhome.actionbar.model.s0 r18 = r17.j;
        if (r18 == null) goto L9;
        com.larus.bmhome.actionbar.model.u0 r19 = r18.a;
        if (r19 == null) goto L9;
        ArrayList r110 = r19.a;
        if (r110 == null) goto L9;
        Iterator r111 = r110.iterator();
    L70:
        if (r111.hasNext() == false) goto L74;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.t0) r112).a, "10000") == false) goto L70;
    L75:
        com.larus.bmhome.actionbar.model.t0 r113 = (com.larus.bmhome.actionbar.model.t0) r112;
        if (r113 == null) goto L9;
        com.larus.bmhome.actionbar.model.o1 r114 = r113.m;
        if (r114 == null) goto L9;
        ModelItemIdentity r115 = r114.a();
        com.larus.bmhome.actionbar.model.a2 r21 = r17.d();
        if (r21 == null) goto L95;
        ArrayList r22 = r21.a;
        if (r22 == null) goto L95;
        if (r22.isEmpty() == true) goto L92;
        Iterator r23 = r22.iterator();
    L88:
        if (r23.hasNext() == false) goto L92;
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.b2) r23.next()).b(), r115) == false) goto L88;
        boolean r24 = false;
    L93:
        if (r24 == true) goto L95;
        boolean r25 = true;
    L96:
        if (r25 == false) goto L9;
        ReplyOption r4 = ReplyOption.copy$default(r11.IT(r115), null, r113.a, null, 5, null);
    L99:
        r11.M80(r4, false);
        r5 = SystemClock.uptimeMillis();
        r3 = r11;
    L92:
        r24 = true;
    L95:
        r25 = false;
        goto L96
    L74:
        r112 = null;
        goto L75
    L98:
        r4 = r11.IT(new ModelItemIdentity(null, Boxing.boxInt(10000), 1, null));
        goto L99
    L55:
        if ((SystemClock.uptimeMillis() - r5) < 1000) goto L9;
    L52:
        return new CocreationTaskLauncher.b(r13, r14);
    L29:
        r9 = ObricChatContextServiceDelegate.b.a();
        goto L30
    L15:
        FragmentActivity r116 = ObricChatContextServiceDelegate.b.d();
        if (r116 == null) goto L24;
        Lifecycle r117 = r116.getLifecycle();
        if (r117 == null) goto L24;
        Lifecycle.State r118 = r117.getCurrentState();
        if (r118 == null) goto L24;
        if (r118.isAtLeast(Lifecycle.State.RESUMED) != true) goto L24;
        r10 = true;
    L24:
        r10 = false;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        r5 = 0;
        r7 = this;
        r3 = null;
        goto L9
    }
}
