package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import android.webkit.WebView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/webkit/WebView;", "invoke", "(Landroid/webkit/WebView;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmWebViewRenderGoneHandler$Config$1 extends Lambda implements Function1<WebView, Boolean> {
    public static final MmWebViewRenderGoneHandler$Config$1 INSTANCE = null;

    static {
        INSTANCE = new MmWebViewRenderGoneHandler$Config$1();
    }

    public MmWebViewRenderGoneHandler$Config$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((WebView) r1);
    }

    public final Boolean invoke(WebView r1) {
        return Boolean.TRUE;
    }
}
