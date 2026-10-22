package com.ss.android.lark.integrator.ccm.im.export;

import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/biz/im/extension/PageType;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class CcmChatExportDocActionProvider$supportedPageTypes$2 extends Lambda implements Function0<List<? extends PageType>> {
    public static final CcmChatExportDocActionProvider$supportedPageTypes$2 INSTANCE = null;

    static {
        INSTANCE = new CcmChatExportDocActionProvider$supportedPageTypes$2();
    }

    public CcmChatExportDocActionProvider$supportedPageTypes$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<PageType> m889invoke() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.CHAT_THREAD, PageType.MERGE_FORWARD, PageType.REPLY_IN_THREAD});
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m889invoke();
    }
}
