package com.larus.ugc.feed.impl.quickmenu.doSame;

import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuElementShowParamsKmp;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import sq9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.quickmenu.doSame.DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1", f = "DoSameQuickMenuIntegrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasAvatar;
    final /* synthetic */ List<String> $itemIds;
    final /* synthetic */ String $recommendFrom;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ o0a.a $tracker;
    final /* synthetic */ UserCreation $userCreation;
    int label;

    public DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(List<String> r1, o0a.a r2, String r3, UserCreation r4, String r5, boolean r6, Continuation<? super DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1> r7) {
        this.$itemIds = r1;
        this.$tracker = r2;
        this.$recommendFrom = r3;
        this.$userCreation = r4;
        this.$showFrom = r5;
        this.$hasAvatar = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(this.$itemIds, this.$tracker, this.$recommendFrom, this.$userCreation, this.$showFrom, this.$hasAvatar, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r20);
        List<String> r1 = this.$itemIds;
        o0a.a r2 = this.$tracker;
        String r14 = this.$recommendFrom;
        UserCreation r15 = this.$userCreation;
        String r13 = this.$showFrom;
        boolean r12 = this.$hasAvatar;
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L19;
        String r4 = (String) r3.next();
        Boolean r5 = Boxing.boxBoolean(r15.D());
        UserCreationRefContent r6 = r15.o;
        if (r6 == null) goto L12;
        List<ImageInfo> r7 = r6.a();
        if (r7 == null) goto L12;
        Integer r8 = Boxing.boxInt(r7.size());
    L13:
        AuthorInfo r9 = r15.g;
        if (r9 == null) goto L16;
        String r10 = r9.b;
    L17:
        r2.h(new MobTemplateMenuElementShowParamsKmp(r14, r5, r8, r10, r15.a, r13, zp9.d.c(r15), zp9.d.d(r15), zp9.d.e(r15), q.a(r4, r15, r12, false)));
        r12 = r12;
        r13 = r13;
        goto L6
    L16:
        r10 = null;
    L12:
        r8 = null;
        goto L13
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
