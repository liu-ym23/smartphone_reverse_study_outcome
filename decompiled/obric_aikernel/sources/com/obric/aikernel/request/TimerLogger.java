package com.obric.aikernel.request;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class TimerLogger implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f4838a = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            if (r10.isEmpty() == false) goto L6;
            return "null";
        L6:
            if (r10.size() != 1) goto L9;
            return (String) CollectionsKt.first(r10);
        L9:
            return CollectionsKt.joinToString$default(r10, null, null, null, 0, null, TimerLogger$Companion$tag$1.INSTANCE, 31, null);
        }

        public final <T> Object b(String r10, String r11, Function1<? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
            if ((r13 instanceof TimerLogger$Companion$timer$1) == false) goto L7;
            TimerLogger$Companion$timer$1 r14 = (TimerLogger$Companion$timer$1) r13;
            int r15 = r14.label;
            if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
            r14.label = r15 - Integer.MIN_VALUE;
        L8:
            T r16 = (T) r14.result;
            Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r18 = r14.label;
            if (r18 == 0) goto L14;
            if (r18 != 1) goto L13;
            long r19 = r14.J$0;
            Ref.ObjectRef r20 = (Ref.ObjectRef) r14.L$3;
            Ref.ObjectRef r21 = (Ref.ObjectRef) r14.L$2;
            String r22 = (String) r14.L$1;
            String r23 = (String) r14.L$0;
            ResultKt.throwOnFailure(r16);
        L18:
            r20.element = r16;
            long r24 = System.currentTimeMillis() - r19;
            AIKLog.INSTANCE.i("trace-perf-" + r23, r22 + " cost " + r24 + " ms. " + r21.element);
            return r21.element;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r16);
            Ref.ObjectRef r25 = new Ref.ObjectRef();
            long r26 = System.currentTimeMillis();
            r14.L$0 = r10;
            r14.L$1 = r11;
            r14.L$2 = r25;
            r14.L$3 = r25;
            r14.J$0 = r26;
            r14.label = 1;
            Object r27 = r12.invoke(r14);
            if (r27 != r17) goto L17;
            return r17;
        L17:
            r21 = r25;
            r23 = r10;
            r22 = r11;
            r19 = r26;
            r16 = (T) r27;
            r20 = r21;
        L7:
            r14 = new TimerLogger$Companion$timer$1(this, r13);
            goto L8
        }
    }

    static {
        f4838a = new Companion(null);
    }

    public static final /* synthetic */ a i(TimerLogger r10) {
        throw null;
    }
}
