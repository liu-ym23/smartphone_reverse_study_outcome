package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.liveinteract.animation.glflymic.GLFlyMicAnimationTask;
import com.bytedance.android.livesdk.gift.model.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public String a;
    public String b;
    public final List<String> c;
    public Object d;
    public int e;
    public final ArrayList<g> f;
    public final int g;
    public o0 h;
    public final h i;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        ArrayList r0 = new ArrayList();
        int r1 = this.g;
        if (1 > r1) goto L71;
        int r3 = 1;
    L5:
        StringBuilder r4 = new StringBuilder();
        r4.append(this.i.d);
        r4.append(String.valueOf(this.e));
        h r5 = this.i;
        r5.c++;
        r4.append(r5.c);
        String r6 = r4.toString();
        int r7 = this.e;
        if (r7 != 1) goto L8;
        o r8 = new o(r6, this.e);
        String r9 = this.a;
        Intrinsics.checkNotNullParameter(r9, "from");
        r8.h = r9;
        String r10 = this.b;
        Intrinsics.checkNotNullParameter(r10, "to");
        r8.i = r10;
        Object r11 = this.d;
        if (r11 == null) goto L70;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r12 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) r11;
        Intrinsics.checkNotNullParameter(r12, "talkRoomDynamicEmoji");
        r8.j = r12;
        Unit r13 = Unit.INSTANCE;
        f r14 = r8;
    L56:
        f r15 = r14;
    L57:
        Iterator<g> r16 = this.f.iterator();
    L59:
        if (r16.hasNext() == false) goto L63;
        g r17 = r16.next();
        if (r15 == null) goto L59;
        r15.d(r17);
        goto L59
    L63:
        this.f.clear();
        if (r15 == null) goto L66;
        h r18 = this.i;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r15, "task");
        r15.g(r18.b);
        r18.a.c(r15);
    L66:
        r0.add(r15);
        if (r3 == r1) goto L84;
        r3 = r3 + 1;
        goto L5
    L84:
        return;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomDynamicEmojiFlex");
    L8:
        if (r7 != 2) goto L10;
        y r19 = new y(r6, this.e);
        String r20 = this.b;
        Intrinsics.checkNotNullParameter(r20, "to");
        r19.k = r20;
        String r21 = this.a;
        Intrinsics.checkNotNullParameter(r21, "from");
        r19.j = r21;
        Object r22 = this.d;
        if (r22 == null) goto L52;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r23 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) r22;
        Intrinsics.checkNotNullParameter(r23, "talkRoomDynamicEmoji");
        r19.l = r23;
        Unit r24 = Unit.INSTANCE;
        r14 = r19;
        goto L56
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomDynamicEmojiFlex");
    L10:
        if (r7 == 3) goto L32;
        if (r7 == 4) goto L15;
        r15 = null;
        goto L57
    L15:
        if (vm2.d.K0() == true) goto L17;
    L23:
        InteractFlyMicAnimationTask r25 = new InteractFlyMicAnimationTask(r6, 3);
        List<String> r26 = this.c;
        Intrinsics.checkNotNullParameter(r26, "toUserIDs");
        ((ArrayList) r25.e).clear();
        ((ArrayList) r25.e).addAll(r26);
        Intrinsics.checkNotNullParameter(this.a, "from");
        r25.j = true;
        o0 r27 = this.h;
        if (r27 == null) goto L26;
        Intrinsics.checkNotNullParameter(r27, "trayInfo");
        r25.h = r27;
    L26:
        Object r28 = this.d;
        if (r28 == null) goto L30;
        r25.o((com.bytedance.android.live.liveinteract.videotalk.emoji.model.m) r28);
        Unit r29 = Unit.INSTANCE;
        r14 = r25;
        goto L56
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomInteractEmoji");
    L17:
        if (vm2.d.h() == false) goto L23;
        GLFlyMicAnimationTask r30 = new GLFlyMicAnimationTask(r6, this.e);
        List<String> r31 = this.c;
        Intrinsics.checkNotNullParameter(r31, "toUserIDs");
        ((ArrayList) r30.i).clear();
        ((ArrayList) r30.i).addAll(r31);
        Intrinsics.checkNotNullParameter(this.a, "from");
        r30.g = true;
        Object r32 = this.d;
        if (r32 == null) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r33 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.m) r32;
        Intrinsics.checkNotNullParameter(r33, "talkRoomInteractEmoji");
        r30.e = r33;
        Unit r34 = Unit.INSTANCE;
        r14 = r30;
        goto L56
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomInteractEmoji");
    L32:
        if (vm2.d.K0() == true) goto L34;
    L40:
        InteractFlyMicAnimationTask r35 = new InteractFlyMicAnimationTask(r6, this.e);
        List<String> r36 = this.c;
        Intrinsics.checkNotNullParameter(r36, "toUserIDs");
        ((ArrayList) r35.e).clear();
        ((ArrayList) r35.e).addAll(r36);
        Intrinsics.checkNotNullParameter(this.a, "from");
        o0 r37 = this.h;
        if (r37 == null) goto L43;
        Intrinsics.checkNotNullParameter(r37, "trayInfo");
        r35.h = r37;
    L43:
        Object r38 = this.d;
        if (r38 == null) goto L47;
        r35.o((com.bytedance.android.live.liveinteract.videotalk.emoji.model.m) r38);
        Unit r39 = Unit.INSTANCE;
        r14 = r35;
        goto L56
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomInteractEmoji");
    L34:
        if (vm2.d.h() == false) goto L40;
        GLFlyMicAnimationTask r40 = new GLFlyMicAnimationTask(r6, this.e);
        List<String> r41 = this.c;
        Intrinsics.checkNotNullParameter(r41, "toUserIDs");
        ((ArrayList) r40.i).clear();
        ((ArrayList) r40.i).addAll(r41);
        Intrinsics.checkNotNullParameter(this.a, "from");
        Object r42 = this.d;
        if (r42 == null) goto L39;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r43 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.m) r42;
        Intrinsics.checkNotNullParameter(r43, "talkRoomInteractEmoji");
        r40.e = r43;
        Unit r44 = Unit.INSTANCE;
        r14 = r40;
        goto L56
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomInteractEmoji");
    }

    public n(h r2) {
        Intrinsics.checkNotNullParameter(r2, "interactAnimation");
        this.i = r2;
        this.a = "";
        this.b = "";
        this.c = new ArrayList();
        this.e = 3;
        this.f = new ArrayList();
        this.g = 1;
    }
}
