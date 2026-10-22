package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.PushUserGroupEntitiesRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class UserGroupPush$startPush$1$1 extends FunctionReferenceImpl implements Function1<PushUserGroupEntitiesRequest, Unit> {
    public UserGroupPush$startPush$1$1(Object r8) {
        super(1, r8, UserGroupPush.class, "onPush", "onPush(Lcom/bytedance/lark/pb/im/v1/PushUserGroupEntitiesRequest;)V", 0);
    }

    public final void invoke(PushUserGroupEntitiesRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        UserGroupPush r0 = (UserGroupPush) ((CallableReference) this).receiver;
        r0.c.execute(new d(r0, r4));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((PushUserGroupEntitiesRequest) r1);
        return Unit.INSTANCE;
    }
}
