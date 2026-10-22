package com.larus.uaigc.chat.block.create;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.uaigc.chat.block.create.i;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import java.util.List;
import java.util.Map;
import kc8.y;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class BaseCreationHolder<T extends i> extends jc8.b<T> {
    public static final /* synthetic */ int h = 0;
    public AbsCreationBlockView d;
    public kc8.b e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public abstract AbsCreationBlockView j(ViewGroup r1);

    public Object k(cz9.b r1, View r2, Message r3, kc8.q r4, Continuation<? super Unit> r5) {
        return l(this, r1, r2, r3, r4, r5);
    }

    public final void i() {
        AbsCreationBlockView r0 = this.d;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public BaseCreationHolder() {
        this.f = LazyKt.lazy(new g(this));
        this.g = LazyKt.lazy(new h(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.uaigc.chat.block.create.f] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(jc8.a r24) {
        i r13 = (i) r24;
        Intrinsics.checkNotNullParameter(r13, "blockModel");
        kc8.b r1 = jc8.c.a(this, kc8.b.class);
        this.e = r1;
        if (r1 == null) goto L73;
        y r2 = r1.a;
        if (r2 == null) goto L74;
        Fragment r3 = r2.a;
        if (r3 == null) goto L75;
        ry8.d r4 = r2.w;
        List r14 = null;
        if ((r4 instanceof ry8.d) == false) goto L12;
        ry8.d r5 = r4;
    L13:
        kc8.q r15 = r1.l;
        if (r15 == null) goto L16;
        Boolean r10 = r15.b;
    L17:
        final Message r6 = r13.j();
        final kc8.q r7 = r1.l;
        ?? r11 = new f(this, r6, r7);
        AbsCreationBlockView r8 = this.d;
        if (r8 == 0) goto L58;
        boolean r9 = true;
        if (r5 == null) goto L22;
        boolean r12 = true;
    L23:
        kc8.b r16 = this.e;
        if (r16 == null) goto L28;
        y r17 = r16.a;
        if (r17 == null) goto L28;
        z r18 = r17.A;
    L29:
        Message r19 = r13.j();
        ChatParam r20 = (ChatParam) this.g.getValue();
        Message r110 = r13.j();
        AbsCreationBlockView r21 = this.d;
        if (r21 == null) goto L56;
        View r22 = r21.a();
        if (r22 == null) goto L56;
        Context r111 = r22.getContext();
        if (r111 == null) goto L56;
        IFlowMainBot.Companion r112 = IFlowMainBot.a;
        kc8.b r23 = this.e;
        if (r23 == null) goto L41;
        y r25 = r23.a;
        if (r25 == null) goto L41;
        Integer r113 = r25.j;
    L42:
        de8.c r26 = (de8.c) this.f.getValue();
        if (r26 == null) goto L45;
        Integer r27 = r26.m();
    L46:
        if (r27 != null) goto L49;
        r9 = false;
    L49:
        Boolean r28 = Boolean.valueOf(r9);
        kc8.b r29 = this.e;
        if (r29 == null) goto L54;
        y r30 = r29.a;
        if (r30 == null) goto L54;
        boolean r210 = Intrinsics.areEqual(r30.h, Boolean.TRUE);
    L55:
        int r114 = IFlowMainBot.a.b(r112, r111, r110, r113, r28, r210, ((jc8.b) this).c);
    L57:
        r8.b(r3, r12, r18, r19, r13, r20, r114, r13.n(), r10, r11, r15);
    L54:
        r210 = false;
        goto L55
    L45:
        r27 = null;
    L41:
        r113 = null;
    L56:
        r114 = 0;
    L28:
        r18 = null;
        goto L29
    L22:
        r12 = false;
    L58:
        CreationNoWatermarkManager r115 = CreationNoWatermarkManager.a;
        Message r116 = r13.j();
        if (r15 == null) goto L63;
        Function0 r31 = r15.i;
        if (r31 == null) goto L63;
        r14 = (List) r31.invoke();
    L63:
        List r117 = r14;
        r115.getClass();
        kq9.i r32 = CreationNoWatermarkManager.i0();
        if (r32.a() == true) goto L67;
        return;
    L67:
        if (CreationNoWatermarkManager.v == true) goto L69;
    L71:
        r115.N(r116, r117, r32.c(), r32.c(), "message_render");
        return;
    L69:
        if (CreationNoWatermarkManager.u == true) goto L71;
        return;
    L16:
        r10 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L75:
        return;
    L74:
        return;
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        AbsCreationBlockView r4 = j(r3);
        this.d = r4;
        View r0 = r4.a();
        r0.setTag(2131385210, r4);
        return r0;
    }

    public static /* synthetic */ <T extends i> Object l(BaseCreationHolder<T> r19, cz9.b r20, View r21, Message r22, kc8.q r23, Continuation<? super Unit> r24) {
        cz9.b r1 = r20;
        final kc8.q r4 = r23;
        if ((r24 instanceof BaseCreationHolder$handleItemLongClick$1) == false) goto L7;
        BaseCreationHolder$handleItemLongClick$1 r6 = (BaseCreationHolder$handleItemLongClick$1) r24;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        if (r8 != 4) goto L16;
        ResultKt.throwOnFailure(r5);
    L41:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Message r0 = (Message) r6.L$4;
        View r2 = (View) r6.L$3;
        cz9.b r3 = (cz9.b) r6.L$2;
        CreationChatItemClickHelper r9 = (CreationChatItemClickHelper) r6.L$1;
        r4 = (kc8.q) r6.L$0;
        ResultKt.throwOnFailure(r5);
        Message r10 = r0;
        View r11 = r2;
        r1 = r3;
        CreationChatItemClickHelper r12 = r9;
        Object r13 = r15;
    L37:
        Function4 r16 = new e(r4);
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.label = 4;
        cz9.b r14 = r1;
        if (CreationChatItemClickHelper.c(r12, r14, r11, r10, null, (JSONObject) r5, false, null, r16, r6, 216) != r13) goto L41;
        return r13;
    L18:
        ResultKt.throwOnFailure(r5);
    L30:
        return Unit.INSTANCE;
    L19:
        Message r17 = (Message) r6.L$4;
        View r18 = (View) r6.L$3;
        cz9.b r25 = (cz9.b) r6.L$2;
        CreationChatItemClickHelper r26 = (CreationChatItemClickHelper) r6.L$1;
        r4 = (kc8.q) r6.L$0;
        ResultKt.throwOnFailure(r5);
        View r27 = r18;
        cz9.b r28 = r25;
        CreationChatItemClickHelper r29 = r26;
    L26:
        Function5 r110 = new d(r4);
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.label = 2;
        Message r111 = r17;
        if (CreationChatItemClickHelper.c(r29, r28, r27, r111, (Map) r5, null, false, r110, null, r6, 360) != r15) goto L30;
        return r15;
    L20:
        ResultKt.throwOnFailure(r5);
        if ((r1 instanceof cz9.h) == false) goto L31;
        CreationChatItemClickHelper r30 = CreationChatItemClickHelper.a;
        CoroutineDispatcher r31 = Dispatchers.getIO();
        BaseCreationHolder$handleItemLongClick$2 r32 = new BaseCreationHolder$handleItemLongClick$2(r22, r19, r4, null);
        r6.L$0 = r4;
        r6.L$1 = r30;
        r6.L$2 = r1;
        r6.L$3 = r21;
        r6.L$4 = r22;
        r6.label = 1;
        Object r33 = BuildersKt.withContext(r31, r32, r6);
        if (r33 != r15) goto L25;
        return r15;
    L25:
        r28 = r1;
        r27 = r21;
        r29 = r30;
        r5 = r33;
        r17 = r22;
        goto L26
    L31:
        r13 = r15;
        if ((r1 instanceof cz9.o) == false) goto L43;
        CreationChatItemClickHelper r34 = CreationChatItemClickHelper.a;
        CoroutineDispatcher r35 = Dispatchers.getIO();
        BaseCreationHolder$handleItemLongClick$4 r112 = new BaseCreationHolder$handleItemLongClick$4(r22, null);
        r6.L$0 = r4;
        r6.L$1 = r34;
        r6.L$2 = r1;
        r6.L$3 = r21;
        r6.L$4 = r22;
        r6.label = 3;
        Object r36 = BuildersKt.withContext(r35, r112, r6);
        if (r36 != r13) goto L36;
        return r13;
    L36:
        r11 = r21;
        r10 = r22;
        r12 = r34;
        r5 = r36;
        goto L37
    L43:
        return Unit.INSTANCE;
    L7:
        r6 = new BaseCreationHolder$handleItemLongClick$1(r19, r24);
        goto L8
    }
}
