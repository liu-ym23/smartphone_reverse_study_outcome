package com.ss.android.lark.forwardv2.sharefile;

import android.os.Bundle;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/forwardv2/sharefile/ShareFileFactory$getFileForwardExecutor$1$2$callback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", "messageId", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ShareFileFactory$getFileForwardExecutor$1$2$callback$1 implements IGetDataCallback<String> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ Bundle $extra;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("ShareFileFactory", "send message error: " + r3 + ", chatId: " + this.$chatId, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larksuite.framework.callback.IGetDataCallback, com.ss.android.lark.forwardv2.sharefile.ShareFileFactory$sendAdditionNote$noteCallback$1] */
    public void onSuccess(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Bundle r0 = this.$extra;
        if (r0 == null) goto L6;
        String r1 = r0.getString("key_param_addition_note");
        if (r1 == null) goto L6;
    L7:
        RichText r2 = this.$extra.getSerializable("key_param_addition_richtext_note");
        Lazy r3 = ShareFileFactory.a;
        final String r4 = this.$chatId;
        if (r1.length() != 0) goto L10;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L17;
        if (i.l(r2) == false) goto L17;
        Log.e("ShareFileFactory", "note is null, richText is null");
        return;
    L17:
        if (i.l(r2) == false) goto L19;
        r2 = com.ss.android.lark.widget.richtext.c.c(r1);
    L19:
        j1.a r7 = new j1.a();
        r7.A = r2;
        ((MessageParams.a) r7).c = r4;
        ((MessageParams.a) r7).b = r6;
        ((MessageParams.a) r7).a = r6;
        ((MessageParams.a) r7).i = r6;
        j1 r8 = r7.b();
        ?? r9 = new ShareFileFactory$sendAdditionNote$noteCallback$1(r4, r6);
        hib.c r10 = (hib.c) ShareFileFactory.a.getValue();
        if (r10 != 0) goto L22;
        Log.e("ShareFileFactory", "IForwardMessageDependency is not registered");
        r9.onError(new ErrorResult("IForwardMessageDependency is not registered"));
        return;
    L22:
        Intrinsics.checkNotNull(r8);
        r10.sendMessage(r8, r9);
        return;
    L10:
        r5 = false;
    L6:
        r1 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((String) r1);
    }

    public ShareFileFactory$getFileForwardExecutor$1$2$callback$1(Bundle r1, String r2) {
        this.$extra = r1;
        this.$chatId = r2;
    }
}
