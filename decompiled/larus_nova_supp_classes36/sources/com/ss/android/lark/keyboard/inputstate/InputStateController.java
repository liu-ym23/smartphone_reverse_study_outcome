package com.ss.android.lark.keyboard.inputstate;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.InputStateHandler;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.log.Log;
import cya.e;
import cya.f;
import cya.g;
import cya.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InputStateController implements cya.d {
    public static final /* synthetic */ int l = 0;
    public final f a;
    public final int b;
    public final Map<Integer, g<?>> c;
    public final List<h> d;
    public final CoroutineScope e;
    public final Map<Integer, InputStateHandler<? extends h>> f;
    public final Channel<Function1<Continuation<? super Unit>, Object>> g;
    public e h;
    public StateStack i;
    public boolean j;
    public final Function0<Unit> k;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/inputstate/InputStateController$StateStack;", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", "depth", "", "<init>", "(I)V", "addLast", "", "e", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class StateStack extends LinkedList<h> {
        private final int depth;

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ int size() {
            return getSize();
        }

        public StateStack(int r1) {
            this.depth = r1;
        }

        public void addLast(h r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            super.addLast(r4);
            int r5 = size();
            int r0 = this.depth;
            boolean r1 = false;
            if (1 > r0) goto L6;
            if (r0 >= r5) goto L6;
            r1 = true;
        L6:
            if (r1 == false) goto L9;
            pollFirst();
            return;
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ boolean contains(Object r2) {
            if ((r2 instanceof h) == true) goto L7;
            return false;
        L7:
            return contains((h) r2);
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r2) {
            if ((r2 instanceof h) == true) goto L7;
            return -1;
        L7:
            return indexOf((h) r2);
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r2) {
            if ((r2 instanceof h) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf((h) r2);
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ boolean remove(Object r2) {
            if ((r2 instanceof h) == true) goto L7;
            return false;
        L7:
            return remove((h) r2);
        }

        public /* bridge */ h removeAt(int r1) {
            return remove(r1);
        }

        @Override // java.util.LinkedList, java.util.Deque
        public /* bridge */ /* synthetic */ void addLast(Object r1) {
            addLast((h) r1);
        }

        public /* bridge */ boolean contains(h r1) {
            return super.contains(r1);
        }

        public /* bridge */ int indexOf(h r1) {
            return super.indexOf(r1);
        }

        public /* bridge */ int lastIndexOf(h r1) {
            return super.lastIndexOf(r1);
        }

        @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public final /* bridge */ h remove(int r1) {
            return removeAt(r1);
        }

        public /* bridge */ boolean remove(h r1) {
            return super.remove(r1);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InputStateHandler.TransformResult.values().length];
            r0[InputStateHandler.TransformResult.KeepTo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[InputStateHandler.TransformResult.KeepFrom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[InputStateHandler.TransformResult.KeepBoth.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.inputstate.InputStateController$pop$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.inputstate.InputStateController$pop$1", f = "InputStateController.kt", i = {0, 1}, l = {148, 148}, m = "invokeSuspend", n = {"from", "from"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ InputStateController this$0;

        public AnonymousClass1(InputStateController r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            e r5 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            h r2 = (h) this.L$0;
            ResultKt.throwOnFailure(r9);
        L36:
            h r3 = r2;
        L37:
            InputStateController r10 = this.this$0;
            h r4 = r10.d();
            g<?> r11 = r10.g(r4);
            if (r11 == null) goto L40;
            r11.a(r4);
        L40:
            e r12 = this.this$0.h;
            if (r12 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("dependency");
        L44:
            k.a.a(r5.n().e(), com.ss.android.lark.keyboard.event.e.a(r3, r4));
            return Unit.INSTANCE;
        L43:
            r5 = r12;
            goto L44
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            InputStateController r6 = (InputStateController) this.L$1;
            h r7 = (h) this.L$0;
            ResultKt.throwOnFailure(r9);
            InputStateController r8 = r6;
            r3 = r7;
        L32:
            this.L$0 = r3;
            this.L$1 = null;
            this.label = 2;
            int r13 = InputStateController.l;
            if (r8.k((h) r9, false) != r0) goto L35;
            return r0;
        L35:
            r2 = r3;
            goto L36
        L10:
            ResultKt.throwOnFailure(r9);
            InputStateController r14 = this.this$0;
            if (r14.j == false) goto L13;
            r3 = r14.d();
            g<?> r15 = r14.g(r3);
            if (r15 == null) goto L17;
            r15.c(r3);
        L17:
            g<?> r16 = r14.g(r3);
            if (r16 == null) goto L20;
            r16.b(r3);
        L20:
            InputStateController r17 = this.this$0;
            r17.getClass();
            if (Intrinsics.areEqual(r3, h.c) == true) goto L23;
            ((ArrayList) r17.d).add(r3);
        L23:
            this.this$0.i();
            StateStack r18 = this.this$0.i;
            if (r18 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("stack");
            r18 = null;
        L27:
            if (r18.isEmpty() == false) goto L37;
            Log.i("InputStateController", "pop is empty: push default state into stack");
            InputStateController r19 = this.this$0;
            f r20 = r19.a;
            this.L$0 = r3;
            this.L$1 = r19;
            this.label = 1;
            Object r21 = r20.a(false, this);
            if (r21 != r0) goto L31;
            return r0;
        L31:
            r8 = r19;
            r9 = r21;
            goto L32
        L13:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final h d() {
        if (this.j == true) goto L6;
        h.b r0 = h.b;
        return h.c;
    L6:
        StateStack r1 = this.i;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r1 = null;
    L9:
        h r2 = (h) CollectionsKt.lastOrNull(r1);
        if (r2 != null) goto L13;
        h.b r3 = h.b;
        return h.c;
    L13:
        return r2;
    }

    public final h f() {
        if ((!this.d.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (h) CollectionsKt.last(this.d);
    }

    public final void i() {
        Log.i("InputStateController", "pop inner: state code: " + d().a());
        StateStack r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r0 = null;
    L5:
        r0.pollLast();
    }

    public final void pop() {
        m(new AnonymousClass1(this, null));
    }

    public InputStateController(f r3) {
        Intrinsics.checkNotNullParameter(r3, "stateRepo");
        this.a = r3;
        this.b = 2;
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
        this.f = new LinkedHashMap();
        this.g = ChannelKt.Channel$default(0, null, null, 7, null);
        this.k = new InputStateController$actionAfterInit$1(this);
    }

    public final boolean a(int r1) {
        if (c(r1) == false) goto L6;
        pop();
        return true;
    L6:
        return false;
    }

    public final void b(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        m(new InputStateController$push$1(this, r3, null));
    }

    public final boolean c(int r2) {
        int r0 = d().a();
        if ((r2 & r0) != r0) goto L5;
        return true;
    L5:
        return false;
    }

    public final g<?> g(h r5) {
        int r6 = r5.a();
        Map<Integer, g<?>> r0 = this.c;
        Integer r1 = Integer.valueOf(r6);
        LinkedHashMap r2 = (LinkedHashMap) r0;
        Object r3 = r2.get(r1);
        Object r4 = r3;
        if (r3 != null) goto L11;
        InputStateHandler r7 = (InputStateHandler) ((LinkedHashMap) this.f).get(Integer.valueOf(r6));
        if (r7 == null) goto L7;
        g r8 = r7.a();
    L8:
        if (r8 == null) goto L10;
        r8.e(this.a);
    L10:
        r2.put(r1, r8);
        r4 = r8;
        goto L11
    L7:
        r8 = null;
    L11:
        g<?> r9 = (g) r4;
        Log.i("InputStateController", "getStateConsumer: state code is " + r6);
        return r9;
    }

    public final void h(FlowChatKeyboardEditor.b r8) {
        Intrinsics.checkNotNullParameter(r8, "dependency");
        if (this.j == false) goto L6;
        Log.i("InputStateController", "onInit: controller is inited , method return");
        return;
    L6:
        this.h = r8;
        this.j = true;
        this.i = new StateStack(this.b);
        BuildersKt.launch$default(this.e, null, null, new InputStateController$onInit$1(this, null), 3, null);
        this.k.invoke();
    }

    public final void j(h r3) {
        Log.i("InputStateController", "push inner: state code: " + r3.a());
        StateStack r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r0 = null;
    L5:
        r0.addLast(r3);
    }

    public final void l(InputStateHandler<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "inputStateHandler");
        this.f.put(Integer.valueOf(r3.getCode()), r3);
    }

    public final void m(Function1<? super Continuation<? super Unit>, ? extends Object> r8) {
        if (CoroutineScopeKt.isActive(this.e) == true) goto L6;
        Log.e("InputStateController", "submit: scope is canceled");
        return;
    L6:
        BuildersKt.launch$default(this.e, null, null, new InputStateController$submit$1(this, r8, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0079 -> B:22:0x0054). Please report as a decompilation issue!!! */
    public static final Object e(InputStateController r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof InputStateController$startConsume$1) == false) goto L7;
        InputStateController$startConsume$1 r0 = (InputStateController$startConsume$1) r6;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ReceiveChannel r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        ChannelIterator r8 = (ChannelIterator) r0.L$1;
        ReceiveChannel r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L33
        Object r9 = r4;
    L22:
        r0.L$0 = r9;     // Catch: Throwable -> L33
        r0.L$1 = r8;     // Catch: Throwable -> L33
        r0.label = 1;     // Catch: Throwable -> L33
        r7 = r8.hasNext(r0);     // Catch: Throwable -> L33
        r3 = r9;
        if (r7 != r2) goto L26;
        return r2;
    L26:
        if (((Boolean) r7).booleanValue() == false) goto L30;
        Function1 r10 = (Function1) r8.next();     // Catch: Throwable -> L33
        r0.L$0 = r3;     // Catch: Throwable -> L33
        r0.L$1 = r8;     // Catch: Throwable -> L33
        r0.label = 2;     // Catch: Throwable -> L33
        r9 = r3;
        if (r10.invoke(r0) != r2) goto L22;
        return r2;
    L30:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L33
        ChannelsKt.cancelConsumed(r3, null);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r8 = (ChannelIterator) r0.L$1;
        ReceiveChannel r12 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L33
        r3 = r12;
        goto L26
    L20:
        ResultKt.throwOnFailure(r7);
        Channel<Function1<Continuation<? super Unit>, Object>> r13 = r5.g;
        r8 = r13.iterator();     // Catch: Throwable -> L33
        r9 = r13;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        ChannelsKt.cancelConsumed(r3, th);
        throw th;
    L7:
        r0 = new InputStateController$startConsume$1(r5, r6);
        goto L8
    }

    public final Object k(h r7, boolean r8) {
        h r0 = d();
        g<?> r1 = g(r0);
        if (r1 == null) goto L6;
        r1.c(r0);
    L6:
        if (Intrinsics.areEqual(r0, h.c) == true) goto L8;
        ((ArrayList) this.d).add(r0);
    L8:
        Object r2 = ((LinkedHashMap) this.f).get(Boxing.boxInt(r7.a()));
        e r3 = null;
        if ((r2 instanceof InputStateHandler) == false) goto L11;
        InputStateHandler r4 = (InputStateHandler) r2;
    L13:
        if (r4 != null) goto L16;
        Log.i("InputStateController", "unsupported input state, method return");
        return Boxing.boxBoolean(false);
    L16:
        int r5 = b.a[r4.b(r0, r7).ordinal()];
        if (r5 != 1) goto L19;
        Log.i("InputStateController", "pushSuspend: keep to");
        g<?> r6 = g(r0);
        if (r6 == null) goto L34;
        r6.b(r0);
    L34:
        i();
        j(r7);
        g<?> r9 = g(r7);
        if (r9 == null) goto L37;
        r9.a(r7);
    L37:
        if (r8 == false) goto L44;
        e r10 = this.h;
        if (r10 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
    L42:
        k.a.a(r3.n().e(), com.ss.android.lark.keyboard.event.e.a(r0, r7));
        goto L44
    L41:
        r3 = r10;
    L44:
        return Boxing.boxBoolean(true);
    L19:
        if (r5 != 2) goto L21;
        Log.i("InputStateController", "pushSuspend: keep from");
        Unit r11 = Unit.INSTANCE;
        goto L37
    L21:
        if (r5 != 3) goto L29;
        Log.i("InputStateController", "pushSuspend: keep both");
        g<?> r12 = g(r0);
        if (r12 == null) goto L25;
        r12.f(r0);
    L25:
        j(r7);
        g<?> r13 = g(r7);
        if (r13 == null) goto L37;
        r13.a(r7);
        goto L37
    L29:
        throw new NoWhenBranchMatchedException();
    L11:
        r4 = null;
        goto L13
    }
}
