package com.ss.android.lark.inline.ai.ui.view;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/inline/ai/ui/view/AnchorParseFilter$filter$callbackWrapper$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AnchorParseFilter$filter$callbackWrapper$1 implements IGetDataCallback<UrlInlinePreviewEntity> {
    final /* synthetic */ CharSequence $source;
    final /* synthetic */ a this$0;

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(UrlInlinePreviewEntity r5) {
        if (r5 == null) goto L5;
        String r1 = r5.b;
    L6:
        StringBuilder r2 = new StringBuilder("title: ");
        r2.append(r1);
        r2.append("， icon: ");
        if (r5 == null) goto L9;
        String r6 = r5.c;
    L10:
        r2.append(r6);
        Log.i("AnchorParseFilter", r2.toString());
        if (r1 != null) goto L14;
        Log.e("AnchorParseFilter", "filter err: title null");
        return;
    L14:
        throw null;
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((UrlInlinePreviewEntity) r1);
    }

    public AnchorParseFilter$filter$callbackWrapper$1(a r1, CharSequence r2) {
        this.$source = r2;
    }
}
