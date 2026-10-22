package com.obric.assistant.session.singleton;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.ISessionEndPoint;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SessionEndpointMgr implements bga.i {
    public static final SessionEndpointMgr a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ISessionEndPoint) r2).f()), Integer.valueOf(((ISessionEndPoint) r1).f()));
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ISessionEndPoint) r2).h()), Integer.valueOf(((ISessionEndPoint) r1).h()));
        }
    }

    public SessionEndpointMgr() {
    }

    @Override // bga.i
    public final void onDestroy() {
    }

    static {
        a = new SessionEndpointMgr();
        b = LazyKt.lazy(new f());
        c = LazyKt.lazy(new g());
        d = LazyKt.lazy(new h());
    }

    @Override // bga.i
    public final void onInit() {
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        Iterator r0 = ((List) c.getValue()).iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r3 = r0.next();
        int r7 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ISessionEndPoint r4 = (ISessionEndPoint) r3;
        FLogger.a.i("AiIsland->SessionEndpointMgr", "prepare item[" + r2 + "] is " + r4 + " -> " + r4.f());
        r2 = r7;
        goto L4
    L9:
        FLogger.a.i("AiIsland->SessionEndpointMgr", "prepare size is " + ((List) c.getValue()).size());
        Iterator r5 = ((List) d.getValue()).iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        int r8 = r1 + 1;
        if (r1 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ISessionEndPoint r9 = (ISessionEndPoint) r6;
        FLogger.a.i("AiIsland->SessionEndpointMgr", "process item[" + r1 + "] is " + r9 + " -> " + r9.h());
        r1 = r8;
        goto L11
    L16:
        FLogger.a.i("AiIsland->SessionEndpointMgr", "process size is " + ((List) d.getValue()).size());
    }

    @Override // bga.i
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ad -> B:24:0x00b1). Please report as a decompilation issue!!! */
    public final Object b(Bundle r13, Continuation<? super Pair<? extends ErrorCode, String>> r14) {
        if ((r14 instanceof SessionEndpointMgr$onSessionProcess$1) == false) goto L7;
        SessionEndpointMgr$onSessionProcess$1 r0 = (SessionEndpointMgr$onSessionProcess$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r16 = r0.I$1;
        int r4 = r0.I$0;
        Bundle r6 = (Bundle) r0.L$0;
        ResultKt.throwOnFailure(r15);
        SessionEndpointMgr$onSessionProcess$1 r5 = r0;
        String r7 = "AiIsland->SessionEndpointMgr";
        int r8 = r4;
        Object r9 = r2;
    L24:
        Pair r17 = (Pair) r15;
        FLogger.a.i(r7, "onSessionProcess chain point result " + r17);
        ErrorCode r10 = (ErrorCode) r17.getFirst();
        String r18 = (String) r17.getSecond();
        if (ArraysKt.contains(new ErrorCode[]{ErrorCode.QUIT_SESSION, ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, ErrorCode.ONLY_END}, r10) == false) goto L27;
        ErrorCode r11 = r10;
        String r12 = r18;
    L29:
        return TuplesKt.to(r11, r12);
    L27:
        r16 = r16 + 1;
        r12 = r18;
        Bundle r19 = r6;
        String r20 = r7;
        r11 = r10;
    L19:
        if (r16 >= r8) goto L29;
        ISessionEndPoint r21 = (ISessionEndPoint) ListProtector.get((List) d.getValue(), r16);
        FLogger.a.i(r20, "onSessionProcess chain point start " + r21);
        r5.L$0 = r19;
        r5.I$0 = r8;
        r5.I$1 = r16;
        r5.label = 1;
        Object r22 = r21.d(r19, r5);
        if (r22 != r9) goto L23;
        return r9;
    L23:
        String r110 = r20;
        r6 = r19;
        r15 = r22;
        r7 = r110;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        FLogger.a.i("AiIsland->SessionEndpointMgr", "onSessionProcess " + r13);
        if (r13 == null) goto L17;
        ErrorCode r111 = ErrorCode.NA;
        r12 = "";
        r20 = "AiIsland->SessionEndpointMgr";
        r8 = ((List) d.getValue()).size();
        r9 = r2;
        r5 = r0;
        r11 = r111;
        r19 = r13;
        r16 = 0;
        goto L19
    L17:
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "invalid args");
    L7:
        r0 = new SessionEndpointMgr$onSessionProcess$1(this, r14);
        goto L8
    }
}
