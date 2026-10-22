package com.ss.android.lark.profile_office.userprofile;

import android.net.Uri;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileNavigator$loadAvatarUri$2", f = "OfficeProfileNavigator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeProfileNavigator$loadAvatarUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ AvatarImage $previewModel;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public OfficeProfileNavigator$loadAvatarUri$2(g r1, AvatarImage r2, int r3, int r4, Continuation<? super OfficeProfileNavigator$loadAvatarUri$2> r5) {
        this.this$0 = r1;
        this.$previewModel = r2;
        this.$width = r3;
        this.$height = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        OfficeProfileNavigator$loadAvatarUri$2 r6 = new OfficeProfileNavigator$loadAvatarUri$2(this.this$0, this.$previewModel, this.$width, this.$height, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        g r8 = this.this$0;
        AvatarImage r0 = this.$previewModel;
        int r1 = this.$width;
        int r2 = this.$height;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        File r9 = ImageLoader.with(r8.a).load(r0).diskCacheStrategy(DiskCacheStrategy.ALL).downloadOnly(r1, r2);     // Catch: Throwable -> L11
        if (r9 == null) goto L8;
        String r10 = Uri.fromFile(r9).toString();     // Catch: Throwable -> L11
    L9:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r11) == false) goto L17;
        return null;
    L17:
        return r11;
    L8:
        r10 = null;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
