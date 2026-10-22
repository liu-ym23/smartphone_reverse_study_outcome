package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$updateAIPackages$4", f = "AIPackageManager.kt", i = {1}, l = {431, 454, 472}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nAIPackageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$updateAIPackages$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,729:1\n1863#2,2:730\n*S KotlinDebug\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$updateAIPackages$4\n*L\n433#1:730,2\n*E\n"})
final class AIPackageManager$updateAIPackages$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlinx.coroutines.r f2532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2534c;

    public AIPackageManager$updateAIPackages$4(String r5, Continuation r10) {
        this.f2534c = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageManager$updateAIPackages$4(this.f2534c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        String r11 = this.f2534c;
        return new AIPackageManager$updateAIPackages$4(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2533b;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        ResultKt.throwOnFailure(r12);
    L39:
        return Boxing.boxBoolean(((Boolean) r12).booleanValue());
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.r r11 = this.f2532a;
        ResultKt.throwOnFailure(r12);
    L35:
        this.f2532a = null;
        this.f2533b = 3;
        r12 = ((kotlinx.coroutines.s) r11).d(this);
        if (r12 != r5) goto L39;
    L37:
        return r5;
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        ArrayList r13 = new ArrayList();
        Iterator r14 = ((List) r12).iterator();
    L17:
        if (r14.hasNext() == false) goto L20;
        AIPackage r15 = (AIPackage) r14.next();
        String r16 = r15.c();
        String r17 = String.valueOf(r15.f2260c);
        r13.add(new AppRequestItem(r16, r15.f2259b, r17));
        goto L17
    L20:
        if (r13.isEmpty() == false) goto L26;
        String r18 = "The AIPackage is not installed. packageName: ".concat(this.f2534c);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L25;
        r19.d("AIPackageManager", r18);
    L25:
        return Boxing.boxBoolean(false);
    L26:
        r r110 = r.f2752a;
        AIPackageAppList r20 = r.a(r13);
        if (r20 != null) goto L29;
    L40:
        String r111 = "The package is the latest. packageName: ".concat(this.f2534c);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L44;
        r112.d("AIPackageManager", r111);
    L44:
        return Boxing.boxBoolean(true);
    L29:
        if (r20.getAppList().isEmpty() == true) goto L40;
        Boolean r21 = Boxing.boxBoolean(false);
        kotlinx.coroutines.s r22 = new kotlinx.coroutines.s(null);
        r22.N(r21);
        q r23 = new q(new AtomicInteger(r20.getAppList().size()), new Ref.BooleanRef(), r22);
        this.f2532a = r22;
        this.f2533b = 2;
        if (r110.e(r20, r23, this) == r5) goto L37;
        r11 = r22;
        goto L35
    L12:
        ResultKt.throwOnFailure(r12);
        AIPackageStorage r113 = AIPackageStorage.f2618a;
        String r24 = this.f2534c;
        this.f2533b = 1;
        r12 = r113.a(r24, this);
        if (r12 != r5) goto L15;
        goto L15
    }
}
