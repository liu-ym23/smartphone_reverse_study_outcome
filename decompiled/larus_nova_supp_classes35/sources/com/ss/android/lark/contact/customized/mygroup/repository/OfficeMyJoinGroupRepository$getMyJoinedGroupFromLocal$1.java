package com.ss.android.lark.contact.customized.mygroup.repository;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/contact/customized/mygroup/repository/OfficeMyJoinGroupRepository$getMyJoinedGroupFromLocal$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chat/Chat;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyJoinGroupRepository$getMyJoinedGroupFromLocal$1 implements IGetDataCallback<List<? extends Chat>> {
    final /* synthetic */ IGetDataCallback<List<Chat>> $callback;
    final /* synthetic */ a this$0;

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        this.$callback.onError(r2);
    }

    public void onSuccess(List<? extends Chat> r3) {
        a r0 = this.this$0;
        if (r3 != null) goto L5;
        r3 = CollectionsKt.emptyList();
    L5:
        GetMyGroupChatsRequest.Type r1 = a.e;
        r0.b(r3);
        this.$callback.onSuccess(CollectionsKt.toList(this.this$0.d));
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }

    public OfficeMyJoinGroupRepository$getMyJoinedGroupFromLocal$1(a r1, IGetDataCallback<List<Chat>> r2) {
        this.this$0 = r1;
        this.$callback = r2;
    }
}
