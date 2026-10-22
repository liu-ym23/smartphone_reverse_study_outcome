package com.larus.contextwindow.impl.routing;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vc8.d;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ContextWindowColdStartDataSource {
    public final Function0<Boolean> a;
    public final Function0<IConversationRepoService> b;
    public final Function0<IChatRepoService> c;
    public final Function0<IActionBarService> d;
    public final Function1<String, List<String>> e;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.routing.ContextWindowColdStartDataSource$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(Object r8) {
            super(0, r8, y29.b.class, "isEnabled", "isEnabled()Z", 0);
        }

        public final Boolean invoke() {
            ((y29.b) ((CallableReference) this).receiver).getClass();
            return Boolean.valueOf(y29.b.a());
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m21invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.routing.ContextWindowColdStartDataSource$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
        public AnonymousClass5(Object r8) {
            super(1, r8, d.class, "get", "get(Ljava/lang/String;)Ljava/util/List;", 0);
        }

        public final List<String> invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            ((d) ((CallableReference) this).receiver).getClass();
            return d.a(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((String) r1);
        }
    }

    public static final class a {
    }

    static {
    }

    public ContextWindowColdStartDataSource() {
        this(null);
    }

    public ContextWindowColdStartDataSource(Object r6) {
        AnonymousClass1 r7 = new AnonymousClass1(y29.b.a);
        Function0<IConversationRepoService> r0 = new com.larus.contextwindow.impl.routing.a();
        Function0<IChatRepoService> r1 = new b();
        Function0<IActionBarService> r2 = new c();
        AnonymousClass5 r3 = new AnonymousClass5(d.a);
        Intrinsics.checkNotNullParameter(r7, "featureEnabled");
        Intrinsics.checkNotNullParameter(r0, "conversationService");
        Intrinsics.checkNotNullParameter(r1, "chatService");
        Intrinsics.checkNotNullParameter(r2, "actionBarService");
        Intrinsics.checkNotNullParameter(r3, "cachedBotIds");
        this.a = r7;
        this.b = r0;
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }

    public final Object a(ContextWindowEntryRequest r23, Continuation<? super v29.a> r24) {
        ContextWindowEntryRequest r2 = r23;
        if ((r24 instanceof ContextWindowColdStartDataSource$load$1) == false) goto L7;
        ContextWindowColdStartDataSource$load$1 r3 = (ContextWindowColdStartDataSource$load$1) r24;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        ReplyOption r13 = null;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        r2 = (ContextWindowEntryRequest) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L15
    L49:
        List r1 = (List) r0;     // Catch: Throwable -> L15
    L51:
        Object r6 = Result.constructor-impl(r1);     // Catch: Throwable -> L15
    L55:
        if (Result.isFailure-impl(r6) == false) goto L57;
        r6 = null;
    L57:
        List r7 = (List) r6;
        if (r7 != null) goto L60;
        r7 = CollectionsKt.emptyList();
    L60:
        List r8 = CollectionsKt.take(r7, 300);
        String r9 = r2.c;
        if (r9 != null) goto L111;
        List r11 = (List) this.e.invoke(r2.a);
        if (r11 == null) goto L65;
        r9 = (String) CollectionsKt.firstOrNull(r11);
        goto L111
    L65:
        r9 = null;
    L111:
        IActionBarService r12 = (IActionBarService) this.d.invoke();     // Catch: Throwable -> L72
        if (r12 == null) goto L69;
        List r14 = r12.f(r9);     // Catch: Throwable -> L72
    L70:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L72
    L75:
        if (Result.isFailure-impl(r15) == false) goto L77;
        r15 = null;
    L77:
        List r16 = (List) r15;
        if (r16 != null) goto L80;
        r16 = CollectionsKt.emptyList();
    L80:
        List r17 = r16;
        Object r18 = Result.constructor-impl(IConvReplyModeRecordHelper.a.b(r2.a));     // Catch: Throwable -> L83
    L86:
        if (Result.isFailure-impl(r18) == false) goto L88;
        r18 = null;
    L88:
        ReplyOption r20 = (ReplyOption) r18;
        if (r20 != null) goto L103;
        Iterator r21 = r17.iterator();
    L92:
        if (r21.hasNext() == false) goto L96;
        Object r22 = r21.next();
        if (Intrinsics.areEqual(((z0) r22).b, "coco_deep_thinking") == false) goto L92;
    L97:
        z0 r25 = (z0) r22;
        if (r25 == null) goto L102;
        p0 r26 = r25.o;
        if (r26 == null) goto L102;
        r13 = r26.a();
    L102:
        ReplyOption r27 = r13;
    L104:
        int r28 = com.larus.contextwindow.impl.data.a.a;
        return com.larus.contextwindow.impl.data.a.a(true, r2.e, r2.a, r2.b, r8, r27, r17);
    L96:
        r22 = null;
        goto L97
    L103:
        r27 = r20;
    L83:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L69:
        r14 = null;
    L72:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r2 = (ContextWindowEntryRequest) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L35
    L31:
        e r32 = (e) r0;     // Catch: Throwable -> L35
    L33:
        Object r33 = Result.constructor-impl(r32);     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r33) == false) goto L41;
        r33 = null;
    L41:
        if (((e) r33) == null) goto L43;
        IChatRepoService r34 = (IChatRepoService) this.c.invoke();     // Catch: Throwable -> L15
        if (r34 == null) goto L50;
        String r35 = r2.a;     // Catch: Throwable -> L15
        r3.L$0 = r2;     // Catch: Throwable -> L15
        r3.label = 2;     // Catch: Throwable -> L15
        r0 = r34.o1(r35, 300, r3);     // Catch: Throwable -> L15
        if (r0 != r10) goto L49;
        return r10;
    L50:
        r1 = null;
        goto L51
    L43:
        return new v29.a(true, "", r2.b, r2.e, ContextWindowMode.SUPPORTED, null, CollectionsKt.emptyList());
    L22:
        ResultKt.throwOnFailure(r0);
        if (((Boolean) this.a.invoke()).booleanValue() == false) goto L25;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L35
        IConversationRepoService r37 = (IConversationRepoService) this.b.invoke();     // Catch: Throwable -> L35
        if (r37 == null) goto L32;
        String r38 = r2.a;     // Catch: Throwable -> L35
        r3.L$0 = r2;     // Catch: Throwable -> L35
        r3.label = 1;     // Catch: Throwable -> L35
        r0 = IConversationRepoService.a.c(r37, r38, true, null, r3, 4);     // Catch: Throwable -> L35
        if (r0 != r10) goto L31;
        return r10;
    L32:
        r32 = null;
        goto L33
    L25:
        return new v29.a(false, r2.a, r2.b, r2.e, ContextWindowMode.SUPPORTED, null, CollectionsKt.emptyList());
    L35:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new ContextWindowColdStartDataSource$load$1(this, r24);
        goto L8
    }
}
