package com.larus.community.impl.quickmenu.doSame;

import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
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
import org.json.JSONObject;
import sq9.q;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.quickmenu.doSame.DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1", f = "DoSameQuickMenuIntegrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasAvatar;
    final /* synthetic */ List<String> $itemIds;
    final /* synthetic */ JSONObject $trackParams;
    final /* synthetic */ UserCreation $userCreation;
    int label;

    public DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(List<String> r1, UserCreation r2, boolean r3, JSONObject r4, Continuation<? super DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1> r5) {
        this.$itemIds = r1;
        this.$userCreation = r2;
        this.$hasAvatar = r3;
        this.$trackParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(this.$itemIds, this.$userCreation, this.$hasAvatar, this.$trackParams, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r110);
        List<String> r1 = this.$itemIds;
        UserCreation r2 = this.$userCreation;
        boolean r3 = this.$hasAvatar;
        JSONObject r4 = this.$trackParams;
        Iterator<T> r5 = r1.iterator();
    L6:
        if (r5.hasNext() == false) goto L22;
        String r6 = (String) r5.next();
        Boolean r7 = Boxing.boxBoolean(r2.D());
        UserCreationRefContent r8 = r2.o;
        String r9 = null;
        if (r8 == null) goto L12;
        List r10 = r8.a();
        if (r10 == null) goto L12;
        Integer r11 = Boxing.boxInt(r10.size());
    L13:
        AuthorInfo r12 = r2.g;
        if (r12 == null) goto L16;
        r9 = r12.b;
    L16:
        String r13 = r2.a;
        String r14 = zp9.d.c(r2);
        String r15 = zp9.d.d(r2);
        String r16 = zp9.d.e(r2);
        String r17 = q.a(r6, r2, r3, false);
        if (r4 != null) goto L19;
        JSONObject r18 = new JSONObject();
    L20:
        u3.n(null, r7, r11, r9, r13, null, r14, r15, r16, r17, r18, 2081);
        goto L6
    L19:
        r18 = r4;
    L12:
        r11 = null;
        goto L13
    L22:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
