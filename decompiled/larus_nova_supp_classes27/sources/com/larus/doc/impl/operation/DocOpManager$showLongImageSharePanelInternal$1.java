package com.larus.doc.impl.operation;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showLongImageSharePanelInternal$1", f = "DocOpManager.kt", i = {}, l = {1090}, m = "invokeSuspend", n = {}, s = {})
final class DocOpManager$showLongImageSharePanelInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ Context $context;
    final /* synthetic */ by7.e $fragment;
    final /* synthetic */ String $path;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ int $targetWidth;
    int label;

    public DocOpManager$showLongImageSharePanelInternal$1(Context r1, by7.e r2, int r3, String r4, String r5, String r6, int r7, Continuation<? super DocOpManager$showLongImageSharePanelInternal$1> r8) {
        this.$context = r1;
        this.$fragment = r2;
        this.$resourceType = r3;
        this.$resourceId = r4;
        this.$artifactMetaId = r5;
        this.$path = r6;
        this.$targetWidth = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DocOpManager$showLongImageSharePanelInternal$1(this.$context, this.$fragment, this.$resourceType, this.$resourceId, this.$artifactMetaId, this.$path, this.$targetWidth, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        com.larus.bmhome.share.panel.f r3 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r35);
        Object r4 = r35;
    L11:
        Pair r5 = (Pair) r4;
        Bitmap r7 = (Bitmap) r5.getFirst();
        boolean r26 = ((Boolean) r5.getSecond()).booleanValue();
        ShareServiceDelegate r6 = ShareServiceDelegate.b;
        FragmentActivity r8 = this.$context;
        if ((r8 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r9 = r8;
    L15:
        com.larus.bmhome.share.panel.e r10 = new com.larus.bmhome.share.panel.e(false, null, null, this.$fragment, false, null, 218);
        String r13 = AppHost.a.getApplication().getString(2131900699);
        DocOpManager r11 = DocOpManager.a;
        int r12 = this.$resourceType;
        String r14 = this.$resourceId;
        String r15 = this.$artifactMetaId;
        if (r12 != 10) goto L26;
        if (r14 != null) goto L19;
    L22:
        boolean r16 = true;
    L23:
        if (r16 == true) goto L26;
        r3 = new com.larus.bmhome.share.panel.f(r14, "fusion_doc_resource_id", 0);
    L39:
        r6.j(r9, r10, new com.larus.bmhome.share.panel.b(this.$path, r7, null, null, null, null, null, r13, null, null, null, null, null, null, null, null, true, false, null, null, r26, true, null, false, r3, null, 47120252));
        return Unit.INSTANCE;
    L19:
        if (r14.length() == 0) goto L22;
        r16 = false;
    L26:
        if (r15 != null) goto L28;
    L31:
        boolean r17 = true;
    L33:
        if ((true ^ r17) == true) goto L36;
        r15 = null;
    L36:
        if (r15 == null) goto L39;
        r3 = new com.larus.bmhome.share.panel.f(r15, "artifact_meta_id", 0);
        goto L39
    L28:
        if (r15.length() == 0) goto L31;
        r17 = false;
        goto L33
    L14:
        r9 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r35);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1 r20 = new DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1(this.$path, this.$targetWidth, null);
        this.label = 1;
        r4 = BuildersKt.withContext(r18, r20, this);
        if (r4 != r1) goto L11;
        return r1;
    }
}
