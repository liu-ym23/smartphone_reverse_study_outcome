package com.larus.uaigc.createpage.component.stylelist;

import android.app.Application;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent$preloadImageStyleListImage$1$1", f = "ImageStyleListComponent.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
final class ImageStyleListComponent$preloadImageStyleListImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ImageStyleRecommendApi.ImageStyle> $it;
    Object L$0;
    int label;

    public ImageStyleListComponent$preloadImageStyleListImage$1$1(List<ImageStyleRecommendApi.ImageStyle> r1, Continuation<? super ImageStyleListComponent$preloadImageStyleListImage$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageStyleListComponent$preloadImageStyleListImage$1$1(this.$it, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r11);
    L10:
        if (r2.hasNext() == false) goto L21;
        ImageStyleRecommendApi.ImageStyle r12 = (ImageStyleRecommendApi.ImageStyle) r2.next();
        if (r12 == null) goto L10;
        g1 r13 = r12.getIcon();
        if (r13 == null) goto L10;
        String r3 = r13.b;
        if (r3 == null) goto L10;
        Application r5 = AppHost.a.getApplication();
        this.L$0 = r2;
        this.label = 1;
        if (ImageLoaderKt.A(r3, "ImageStyleListComponent", r5, null, null, this, 56) != r0) goto L10;
        return r0;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r2 = this.$it.iterator();
        goto L10
    }
}
