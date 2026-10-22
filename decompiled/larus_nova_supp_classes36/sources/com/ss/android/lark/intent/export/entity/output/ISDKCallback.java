package com.ss.android.lark.intent.export.entity.output;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/ISDKCallback;", "", "callback", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/output/ISDKCallbackVisitor;", "(Lcom/ss/android/lark/intent/export/entity/output/ISDKCallbackVisitor;)Ljava/lang/Object;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface ISDKCallback {
    <R> R callback(ISDKCallbackVisitor<R> r1);
}
