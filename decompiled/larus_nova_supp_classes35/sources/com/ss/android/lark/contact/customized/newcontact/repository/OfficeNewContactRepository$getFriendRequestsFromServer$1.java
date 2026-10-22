package com.ss.android.lark.contact.customized.newcontact.repository;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import e9b.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/customized/newcontact/repository/OfficeNewContactRepository$getFriendRequestsFromServer$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/contact/base/interfaces/IContactServiceInternal$GetFriendRequestResult;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactRepository$getFriendRequestsFromServer$1 implements IGetDataCallback<b> {
    final /* synthetic */ IGetDataCallback<b> $callback;
    final /* synthetic */ a this$0;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("Contact_NewContactRepo", "get server friend requests failed: " + r3);
        this.this$0.b = false;
        this.$callback.onError(r3);
    }

    public void onSuccess(b r6) {
        a r0 = this.this$0;
        boolean r1 = false;
        r0.b = false;
        if (r6 == null) goto L7;
        r0.getClass();
        if (r6.b != true) goto L7;
        r1 = true;
    L7:
        r0.a = r1;
        if (r6 == null) goto L10;
        List<ChatApplication> r2 = r6.a;
    L11:
        if (r2 != null) goto L13;
        r2 = CollectionsKt.emptyList();
    L13:
        List<ChatApplication> r4 = r2;
        ((ArrayList) r0.d).addAll(r4);
        if ((true ^ r4.isEmpty()) == false) goto L16;
        r0.c = ((ChatApplication) CollectionsKt.last(r2)).getId();
    L16:
        this.$callback.onSuccess(r6);
        return;
    L10:
        r2 = null;
        goto L11
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((b) r1);
    }

    public OfficeNewContactRepository$getFriendRequestsFromServer$1(a r1, IGetDataCallback<b> r2) {
        this.this$0 = r1;
        this.$callback = r2;
    }
}
