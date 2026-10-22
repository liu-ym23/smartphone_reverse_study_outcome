package com.bytedance.ai.resource;

import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$cleanPackagesToDelete$4", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAIPackageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$cleanPackagesToDelete$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,729:1\n1863#2,2:730\n*S KotlinDebug\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$cleanPackagesToDelete$4\n*L\n595#1:730,2\n*E\n"})
final class AIPackageManager$cleanPackagesToDelete$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f2508a;

    public AIPackageManager$cleanPackagesToDelete$4(List r5, Continuation r10) {
        this.f2508a = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageManager$cleanPackagesToDelete$4(this.f2508a, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        List r11 = this.f2508a;
        return new AIPackageManager$cleanPackagesToDelete$4(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        Iterator r10 = this.f2508a.iterator();
    L4:
        if (r10.hasNext() == false) goto L19;
        String r11 = (String) r10.next();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (TextUtils.isEmpty(r11) == true) goto L14;
        File r12 = new File(r11);
        if (r12.exists() == false) goto L14;
        if (r12.isDirectory() == false) goto L13;
        boolean r13 = FilesKt.deleteRecursively(r12);
    L15:
        String r14 = r11 + " is removed: " + r13;
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L4;
        r15.d("AIPackageManager", r14);
        goto L4
    L13:
        r13 = r12.delete();
    L14:
        r13 = false;
        goto L15
    L19:
        return Unit.INSTANCE;
    }
}
