package com.ss.android.lark.integrator.ccm.im;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "Lkotlin/jvm/internal/EnhancedNullability;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class WebContainerResourceLoadTask$chatService$2 extends Lambda implements Function0<ImSdkChatService> {
    public static final WebContainerResourceLoadTask$chatService$2 INSTANCE = null;

    static {
        INSTANCE = new WebContainerResourceLoadTask$chatService$2();
    }

    public WebContainerResourceLoadTask$chatService$2() {
        super(0);
    }

    public final ImSdkChatService invoke() {
        return (ImSdkChatService) LarkContext.spiByDwarf(ImSdkChatService.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m887invoke() {
        return invoke();
    }
}
