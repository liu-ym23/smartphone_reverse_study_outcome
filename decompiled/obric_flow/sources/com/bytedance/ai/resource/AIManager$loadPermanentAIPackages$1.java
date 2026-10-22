package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$loadPermanentAIPackages$1", f = "AIManager.kt", i = {1}, l = {800, 804, 831}, m = "invokeSuspend", n = {"permanentInstallList"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nAIManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIManager.kt\ncom/bytedance/ai/resource/AIManager$loadPermanentAIPackages$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1162:1\n1863#2,2:1163\n1863#2,2:1165\n216#3,2:1167\n*S KotlinDebug\n*F\n+ 1 AIManager.kt\ncom/bytedance/ai/resource/AIManager$loadPermanentAIPackages$1\n*L\n807#1:1163,2\n822#1:1165,2\n828#1:1167,2\n*E\n"})
final class AIManager$loadPermanentAIPackages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f2491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2492b;

    public AIManager$loadPermanentAIPackages$1(Continuation r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIManager$loadPermanentAIPackages$1(r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return new AIManager$loadPermanentAIPackages$1(r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2492b;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        ResultKt.throwOnFailure(r11);
    L65:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        List r12 = this.f2491a;
        ResultKt.throwOnFailure(r11);
    L26:
        List r13 = (List) r11;
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        Iterator r15 = r12.iterator();
    L27:
        boolean r16 = false;
        if (r15.hasNext() == false) goto L51;
        k r17 = (k) r15.next();
        if (j.f2738i == true) goto L31;
        String r18 = r17.getPackageName();
        com.bytedance.ai.multiprocess.a r19 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r19 != null) goto L39;
    L49:
        if (r16 == true) goto L27;
        r14.put(ym.a.b(r17.getPackageName(), r17.getAppId()), r17);
        goto L27
    L39:
        if (r19.f2402c == false) goto L41;
        boolean r20 = true;
    L47:
        if (r20 != true) goto L49;
        r16 = true;
        goto L49
    L41:
        if (r18 != null) goto L43;
    L46:
        r20 = false;
        goto L47
    L43:
        if (r18.length() == 0) goto L46;
        r20 = r19.d.contains(r18);
        goto L47
    L31:
        Set r21 = j.f2740k;
        if (r21.isEmpty() == true) goto L27;
        if (r21.contains(r17.getPackageName()) == false) goto L27;
        r14.put(ym.a.b(r17.getPackageName(), r17.getAppId()), r17);
        goto L27
    L51:
        Iterator r110 = r13.iterator();
    L53:
        if (r110.hasNext() == false) goto L56;
        AIPackage r22 = (AIPackage) r110.next();
        j.k(r22, false);
        r14.remove(r22.f());
        goto L53
    L56:
        if (r14.isEmpty() == true) goto L65;
        ArrayList r111 = new ArrayList();
        Iterator r23 = r14.entrySet().iterator();
    L59:
        if (r23.hasNext() == false) goto L61;
        r111.add(((Map.Entry) r23.next()).getValue());
        goto L59
    L61:
        r r24 = r.f2752a;
        g r25 = new g();
        this.f2491a = null;
        this.f2492b = 3;
        if (r24.g(r111, r25, this) != r5) goto L65;
    L63:
        return r5;
    L11:
        ResultKt.throwOnFailure(r11);
    L18:
        r12 = (List) r11;
        if (r12.isEmpty() == false) goto L23;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L65;
        r112.w("AIManager", "permanent package list is empty");
        goto L65
    L23:
        r r113 = r.f2752a;
        this.f2491a = r12;
        this.f2492b = 2;
        r11 = AIPackageStorage.f2618a.a(r12, true, this);
        if (r11 != r5) goto L26;
    L12:
        ResultKt.throwOnFailure(r11);
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r114 = com.bytedance.ai.utils.c.f2846a;
        if (r114 == null) goto L15;
        r114.d("AIManager", "load AIPackage in permanent list");
    L15:
        r r115 = r.f2752a;
        this.f2492b = 1;
        r11 = r.f2753b.a();
        if (r11 != r5) goto L18;
        goto L18
    }
}
