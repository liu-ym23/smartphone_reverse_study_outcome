package com.ss.android.lark.profile_office.userprofile;

import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileNavigator$openAvatarPreview$request$2", f = "OfficeProfileNavigator.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
final class OfficeProfileNavigator$openAvatarPreview$request$2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $userAvatarKey;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ g this$0;

    public OfficeProfileNavigator$openAvatarPreview$request$2(g r1, String r2, String r3, Continuation<? super OfficeProfileNavigator$openAvatarPreview$request$2> r4) {
        this.this$0 = r1;
        this.$userAvatarKey = r2;
        this.$userId = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new OfficeProfileNavigator$openAvatarPreview$request$2(this.this$0, this.$userAvatarKey, this.$userId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        g r11 = this.this$0;
        String r2 = this.$userAvatarKey;
        String r3 = this.$userId;
        int r4 = r11.c;
        AvatarImage r5 = AvatarImage.Builder.obtain(r2, r3, r4, r4).build();
        int r6 = this.this$0.c;
        this.label = 1;
        r10 = BuildersKt.withContext(Dispatchers.getIO(), new OfficeProfileNavigator$loadAvatarUri$2(r11, r5, r6, r6, null), this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
