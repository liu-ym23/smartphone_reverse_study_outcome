package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.GetAvatarPathRequest;
import com.bytedance.lark.pb.media.v1.GetAvatarPathResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper$syncGetAvatarPath$2", f = "MmUserInfoHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmUserInfoHelper$syncGetAvatarPath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $avatarKey;
    final /* synthetic */ float $dpi;
    final /* synthetic */ String $entityId;
    final /* synthetic */ int $sizeInDp;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r2) {
            return ((GetAvatarPathResponse) GetAvatarPathResponse.ADAPTER.decode(r2)).path;
        }
    }

    public MmUserInfoHelper$syncGetAvatarPath$2(String r1, String r2, int r3, float r4, Continuation<? super MmUserInfoHelper$syncGetAvatarPath$2> r5) {
        this.$entityId = r1;
        this.$avatarKey = r2;
        this.$sizeInDp = r3;
        this.$dpi = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmUserInfoHelper$syncGetAvatarPath$2 r6 = new MmUserInfoHelper$syncGetAvatarPath$2(this.$entityId, this.$avatarKey, this.$sizeInDp, this.$dpi, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = this.$entityId;
        String r0 = this.$avatarKey;
        int r1 = this.$sizeInDp;
        float r2 = this.$dpi;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        GetAvatarPathRequest.Builder r8 = new GetAvatarPathRequest.Builder().entity_id(r7).key(r0).dp_size(Boxing.boxInt(r1)).dpr(Boxing.boxFloat(r2));     // Catch: Throwable -> L7
        Object r9 = Result.constructor-impl((String) SdkSender.syncSend(Command.GET_AVATAR_PATH, r8, a.a));     // Catch: Throwable -> L7
    L10:
        return Result.box-impl(r9);
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
