package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Uri $destinationUri;
    final /* synthetic */ Uri $imageFileUri;
    int label;

    public BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1(FragmentActivity r1, Uri r2, Uri r3, Continuation<? super BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1> r4) {
        this.$activity = r1;
        this.$imageFileUri = r2;
        this.$destinationUri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1(this.$activity, this.$imageFileUri, this.$destinationUri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        FragmentActivity r4 = this.$activity;
        Uri r0 = this.$imageFileUri;
        Uri r1 = this.$destinationUri;
        Intrinsics.checkNotNull(r1);
        return Result.box-impl(BitmapHelperKt.b(r4, r0, r1));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
