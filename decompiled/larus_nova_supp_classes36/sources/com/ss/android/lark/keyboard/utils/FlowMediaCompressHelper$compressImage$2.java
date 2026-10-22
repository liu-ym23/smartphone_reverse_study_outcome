package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowMediaCompressHelper$compressImage$2", f = "FlowMediaCompressHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowMediaCompressHelper$compressImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    int label;

    public FlowMediaCompressHelper$compressImage$2(String r1, Context r2, Continuation<? super FlowMediaCompressHelper$compressImage$2> r3) {
        this.$imagePath = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMediaCompressHelper$compressImage$2(this.$imagePath, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r6);
        com.ss.android.lark.image.uploader.entity.b.a r7 = new com.ss.android.lark.image.uploader.entity.b.a();
        r7.c(this.$imagePath);
        com.ss.android.lark.image.uploader.entity.b r8 = r7.b();
        boolean r2 = false;
        ImageInfo r0 = com.ss.android.lark.image.uploader.utils.b.d(this.$imagePath, true, false);
        FlowMediaCompressHelper r3 = FlowMediaCompressHelper.a;
        String r9 = FlowMediaCompressHelper.b(this.$context, this.$imagePath, r0, r8);
        if (r9.length() != 0) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L10;
        return null;
    L10:
        String r10 = com.ss.android.lark.vfs.d.a().G(r9, true).getAbsolutePath();
        if (TextUtils.isEmpty(r10) == false) goto L13;
        return null;
    L13:
        if (new PolarisFileWrapper(r10).exists() == true) goto L16;
        return null;
    L16:
        return r10;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
