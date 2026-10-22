package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.e;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RenderGoneHelper {
    public static final CopyOnWriteArrayList<k.a> a = null;
    public static final Channel<Pair<Boolean, Integer>> b = null;
    public static boolean c;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1", f = "RenderGoneHelper.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1$1", f = "RenderGoneHelper.kt", i = {0, 1}, l = {40, 41}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
        public static final class C00221 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends Integer>>, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            public C00221(Continuation<? super C00221> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                C00221 r0 = new C00221(r3);
                r0.L$0 = r2;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((FlowCollector) r1, (Continuation) r2);
            }

            public final Object invoke(FlowCollector<? super Pair<Boolean, Integer>> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006a -> B:12:0x003e). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                ChannelIterator r2 = (ChannelIterator) this.L$1;
                FlowCollector r4 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(r8);
                FlowCollector r9 = r4;
            L11:
                C00221 r5 = this;
            L12:
                r5.L$0 = r9;
                r5.L$1 = r2;
                r5.label = 1;
                Object r6 = r2.hasNext(r5);
                if (r6 != r0) goto L15;
                return r0;
            L15:
                C00221 r7 = r5;
                FlowCollector r10 = r9;
                r8 = r6;
                C00221 r11 = r7;
            L17:
                if (((Boolean) r8).booleanValue() == false) goto L23;
                Pair r12 = (Pair) r2.next();
                r11.L$0 = r10;
                r11.L$1 = r2;
                r11.label = 2;
                if (r10.emit(r12, r11) != r0) goto L21;
                return r0;
            L21:
                r9 = r10;
                r5 = r11;
                goto L12
            L23:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                r2 = (ChannelIterator) this.L$1;
                r10 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(r8);
                r11 = this;
                goto L17
            L10:
                ResultKt.throwOnFailure(r8);
                r9 = (FlowCollector) this.L$0;
                r2 = RenderGoneHelper.b.iterator();
                goto L11
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r4, Continuation r5) {
                Pair r6 = (Pair) r4;
                boolean r7 = ((Boolean) r6.component1()).booleanValue();
                int r8 = ((Number) r6.component2()).intValue();
                Log.i("CML_TAG_RenderGoneHelper", "onRenderProcessGone execute " + r7 + ' ' + r8);
                RenderGoneHelper.c = true;
                Iterator<k.a> r0 = RenderGoneHelper.a.iterator();     // Catch: Throwable -> L8
            L5:
                if (r0.hasNext() == false) goto L11;
                r0.next().a(r7, r8);     // Catch: Throwable -> L8
            L11:
                return Unit.INSTANCE;
            L8:
                th = move-exception;
                Log.e("CML_TAG_RenderGoneHelper", th);
                goto L11
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Flow r7 = e.m(new c1(new C00221(null)), 200);
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        a = new CopyOnWriteArrayList();
        b = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(null), 2, null);
    }
}
