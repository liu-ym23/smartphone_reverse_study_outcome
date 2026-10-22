package com.obric.memorydata.database.index;

import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.utils.OcrLineResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.index.EntityIndexHelper$pictureToOCR$1$1", f = "EntityIndexHelper.kt", i = {}, l = {2488}, m = "invokeSuspend", n = {}, s = {})
final class EntityIndexHelper$pictureToOCR$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super String>, Object> {
    final /* synthetic */ Uri $image;
    final /* synthetic */ String $packageName;
    int label;

    EntityIndexHelper$pictureToOCR$1$1(Uri r3, String r4, Continuation<? super EntityIndexHelper$pictureToOCR$1$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$image = r3;
        this.$packageName = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$pictureToOCR$1$1(this.$image, this.$packageName, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super String> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super String> r4) {
        return ((EntityIndexHelper$pictureToOCR$1$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityIndexHelper$pictureToOCR$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L14:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        String r15 = "";
        if (r13 != null) goto L17;
        return "";
    L17:
        List<OcrLineResult> r16 = com.obric.memorydata.aikernelcore.utils.c.f8488a.a(r13);
        StringBuilder r2 = new StringBuilder();
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r3 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == true) goto L37;
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r17.hasNext() == false) goto L36;
        Object r6 = r17.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        OcrLineResult r8 = (OcrLineResult) ZeusTransformUtils.preCheckCast(r6, OcrLineResult.class, "com.obric.memorydata.plugin");
        int r9 = r16.size() - 1;
        String r10 = r8.getText();
        if (r4 != r9) goto L34;
        r2.append(r10);
    L35:
        r4 = r7;
        goto L27
    L34:
        r2.append(r10).append(",");
        goto L35
    L36:
        r15 = r2.toString();
    L37:
        Intrinsics.checkNotNull(r15);
        return r15;
    L20:
        if (r3.isEmpty() == true) goto L23;
        r5 = false;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        String r18 = null;
        if (t.f9438a.f() == false) goto L11;
        r18 = AppContext.INSTANCE.getPackageName();
    L11:
        com.obric.memorydata.aikernelcore.a r11 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Uri r12 = this.$image;
        String r19 = this.$packageName;
        Continuation r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r14 = com.obric.memorydata.aikernelcore.a.a(r11, r12, r19, false, r18, true, r110, 4, null);
        if (r14 != r0) goto L14;
        return r0;
    }
}
