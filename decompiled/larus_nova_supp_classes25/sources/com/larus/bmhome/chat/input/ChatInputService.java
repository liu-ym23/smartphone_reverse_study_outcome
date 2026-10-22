package com.larus.bmhome.chat.input;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ye8.a;
import ye8.b;
import ye8.c;
import ye8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0097\u0001J\r\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0097\u0001J\t\u0010\b\u001a\u00020\tH\u0097\u0001J\r\u0010\n\u001a\u00060\u0005j\u0002`\u0006H\u0097\u0001J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0096\u0001J'\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u0011\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\u001f\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\t\u0010'\u001a\u00020(H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\u0019\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/input/ChatInputService;", "Lcom/larus/bmhome/chat/input/IChatInputService;", "<init>", "()V", "compatBuildBottomAttachmentPanel", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "compatBuildBottomLatestPhotoShortcut", "compatBuildBottomMultimodal", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "compatBuildBottomMultimodalBottomMenu", "createChatInputPlaceholder", "Landroid/view/View;", "context", "Landroid/content/Context;", "config", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderConfig;", "execSendImgMsgCacheScanner", "", "getInputResourceManager", "Lcom/larus/bmhome/chat/input/InputResourceManager;", "getInputUploadManager", "Lcom/larus/bmhome/chat/input/InputUploadManager;", "getMultimodalDowngradeData", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "getSendImageCacheCleanupTargets", "", "Lcom/larus/bmhome/chat/input/SendImageCacheCleanupTarget;", "recordCameraParam", "clickFrom", "", "templateId", "templateType", "registerOnChatInputIntercept", "onChatInputIntercept", "Lcom/larus/bmhome/chat/input/OnChatInputIntercept;", "resolveChatInputPlaceholderHint", "conversationId", "configuredHint", "resolveInitialChatInputPlaceholderMode", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderMode;", "unregisterOnChatInputIntercept", "updateChatInputPlaceholder", "view", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatInputService implements IChatInputService {
    public static final ChatInputService b = null;
    public final /* synthetic */ IChatInputService a;

    static {
        b = new ChatInputService();
    }

    public final MultimodalDowngradeData A6() {
        return this.a.A6();
    }

    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget a() {
        return this.a.a();
    }

    @Deprecated(message = "use component registry instead")
    public final ComponentFeature b() {
        return this.a.b();
    }

    public final void c() {
        this.a.c();
    }

    public final void d(String r2, String r3, String r4) {
        this.a.d(r2, r3, r4);
    }

    public final void e(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a.e(r2, r3);
    }

    public final b f() {
        return this.a.f();
    }

    public final c g() {
        return this.a.g();
    }

    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget h() {
        return this.a.h();
    }

    public final String i(String r2, String r3) {
        return this.a.i(r2, r3);
    }

    public final ChatInputPlaceholderMode j() {
        return this.a.j();
    }

    public final List<e> k() {
        return this.a.k();
    }

    public final View l(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        return this.a.l(r2, r3);
    }

    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget m() {
        return this.a.m();
    }

    private ChatInputService() {
        IChatInputService r0 = (IChatInputService) ServiceManager.get().getService(IChatInputService.class);
        if (r0 != null) goto L5;
        r0 = new ChatInputServiceNoop();
    L5:
        this.a = r0;
    }
}
