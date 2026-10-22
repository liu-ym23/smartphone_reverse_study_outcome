package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper$loadAvatarViewWithKey$1", f = "MmUserInfoHelper.kt", i = {}, l = {146, 149}, m = "invokeSuspend", n = {}, s = {})
final class MmUserInfoHelper$loadAvatarViewWithKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $config;
    final /* synthetic */ ImageView $imageView;
    int label;
    final /* synthetic */ MmUserInfoHelper this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper$loadAvatarViewWithKey$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper$loadAvatarViewWithKey$1$1", f = "MmUserInfoHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $avatarImage;
        final /* synthetic */ ImageView $imageView;
        int label;

        public AnonymousClass1(ImageView r1, Bitmap r2, Continuation<? super AnonymousClass1> r3) {
            this.$imageView = r1;
            this.$avatarImage = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$imageView, this.$avatarImage, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$imageView.setImageBitmap(this.$avatarImage);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmUserInfoHelper$loadAvatarViewWithKey$1(MmUserInfoHelper r1, b r2, ImageView r3, Continuation<? super MmUserInfoHelper$loadAvatarViewWithKey$1> r4) {
        this.this$0 = r1;
        this.$config = r2;
        this.$imageView = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmUserInfoHelper$loadAvatarViewWithKey$1(this.this$0, this.$config, this.$imageView, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        Bitmap r8 = (Bitmap) r7;
        String r2 = this.this$0.b;
        StringBuilder r3 = new StringBuilder("loadAvatarViewWithKey, config:");
        r3.append(this.$config);
        r3.append(", avatarImage: ");
        if (r8 == null) goto L16;
        Integer r5 = Boxing.boxInt(r8.hashCode());
    L17:
        r3.append(r5);
        lvb.a.e(r2, r3.toString());
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(this.$imageView, r8, null);
        this.label = 2;
        if (BuildersKt.withContext(r4, r6, this) != r0) goto L21;
        return r0;
    L16:
        r5 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r7);
        MmUserInfoHelper r9 = this.this$0;
        b r10 = this.$config;
        this.label = 1;
        r7 = r9.d(r10, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
