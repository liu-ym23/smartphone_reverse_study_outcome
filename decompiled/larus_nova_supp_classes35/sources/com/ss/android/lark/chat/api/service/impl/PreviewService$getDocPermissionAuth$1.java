package com.ss.android.lark.chat.api.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.preview.DocPer;
import com.ss.android.lark.chat.entity.preview.DocType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.entities.DocPermission;
import com.ss.android.lark.pb.messages.PullMessageDocPermsResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/api/service/impl/PreviewService$getDocPermissionAuth$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/messages/PullMessageDocPermsResponse;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewService$getDocPermissionAuth$1 implements IGetDataCallback<PullMessageDocPermsResponse> {
    final /* synthetic */ IGetDataCallback<ArrayList<DocPer>> $callback;

    public PreviewService$getDocPermissionAuth$1(IGetDataCallback<ArrayList<DocPer>> r1) {
        this.$callback = r1;
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("[URLPreview] PreviewService", "getDocPermissionAuth error:" + r3.getDisplayMsg());
        this.$callback.onError(r3);
    }

    public void onSuccess(PullMessageDocPermsResponse r11) {
        ArrayList r0 = new ArrayList();
        if (r11 == null) goto L16;
        List r12 = r11.mdoc_perms;
        if (r12 == null) goto L16;
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L16;
        PullMessageDocPermsResponse.DocPerm r1 = (PullMessageDocPermsResponse.DocPerm) r13.next();
        ArrayList r7 = new ArrayList();
        List r2 = r1.mpermissions;
        if (r2 == null) goto L15;
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        DocPermission r4 = (DocPermission) r3.next();
        r7.add(new com.ss.android.lark.chat.entity.preview.DocPermission(r4.mperm_code, r4.mperm_name, r4.mis_set.booleanValue()));
    L15:
        String r5 = r1.mdoc_title;
        DocType.a r6 = DocType.Companion;
        int r8 = r1.mdoc_type.getValue();
        r6.getClass();
        r0.add(new DocPer(r5, DocType.a.a(r8), r1.mowner_name, r1.mdoc_url, r7, r1.mmessage_ids));
    L16:
        this.$callback.onSuccess(r0);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((PullMessageDocPermsResponse) r1);
    }
}
