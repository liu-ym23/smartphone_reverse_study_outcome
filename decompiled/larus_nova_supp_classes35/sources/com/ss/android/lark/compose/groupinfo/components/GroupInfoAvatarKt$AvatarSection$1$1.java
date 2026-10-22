package com.ss.android.lark.compose.groupinfo.components;

import com.ss.android.lark.image.compose.common.url.a;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.components.GroupInfoAvatarKt$AvatarSection$1$1", f = "GroupInfoAvatar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupInfoAvatarKt$AvatarSection$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $avatarRefreshKey;
    final /* synthetic */ a $state;
    int label;

    public GroupInfoAvatarKt$AvatarSection$1$1(long r1, a r3, Continuation<? super GroupInfoAvatarKt$AvatarSection$1$1> r4) {
        this.$avatarRefreshKey = r1;
        this.$state = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GroupInfoAvatarKt$AvatarSection$1$1(this.$avatarRefreshKey, this.$state, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        if (this.$avatarRefreshKey <= 0) goto L8;
        a r6 = this.$state;
        int r0 = ((Number) r6.a.getValue()).intValue() + 1;
        r6.a.setValue(Integer.valueOf(r0));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
