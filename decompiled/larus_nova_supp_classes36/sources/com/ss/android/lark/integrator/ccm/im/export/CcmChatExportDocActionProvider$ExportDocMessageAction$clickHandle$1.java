package com.ss.android.lark.integrator.ccm.im.export;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.messages.DeriveMessagesToDocResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/integrator/ccm/im/export/CcmChatExportDocActionProvider$ExportDocMessageAction$clickHandle$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/messages/DeriveMessagesToDocResponse;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CcmChatExportDocActionProvider$ExportDocMessageAction$clickHandle$1 implements IGetDataCallback<DeriveMessagesToDocResponse> {
    final /* synthetic */ long $sendTime;
    final /* synthetic */ a this$0;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("CcmChatExportDocActionProvider", "export error " + r3.getErrorCode());
        this.this$0.getClass();
        b.a();
        throw null;
    }

    public void onSuccess(DeriveMessagesToDocResponse r2) {
        Log.i("CcmChatExportDocActionProvider", "export success");
        this.this$0.getClass();
        b.a();
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((DeriveMessagesToDocResponse) r1);
    }

    public CcmChatExportDocActionProvider$ExportDocMessageAction$clickHandle$1(a r1, long r2) {
        this.this$0 = r1;
        this.$sendTime = r2;
    }
}
