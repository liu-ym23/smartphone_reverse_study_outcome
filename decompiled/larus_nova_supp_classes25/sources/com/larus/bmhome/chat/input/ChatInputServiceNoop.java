package com.larus.bmhome.chat.input;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ye8.a;
import ye8.b;
import ye8.c;
import ye8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J&\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020&H\u0017J\f\u0010'\u001a\u00060(j\u0002`)H\u0017J\f\u0010*\u001a\u00060(j\u0002`)H\u0017J\f\u0010+\u001a\u00060(j\u0002`)H\u0017¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/input/ChatInputServiceNoop;", "Lcom/larus/bmhome/chat/input/IChatInputService;", "<init>", "()V", "createChatInputPlaceholder", "Landroid/view/View;", "context", "Landroid/content/Context;", "config", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderConfig;", "updateChatInputPlaceholder", "", "view", "resolveInitialChatInputPlaceholderMode", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderMode;", "resolveChatInputPlaceholderHint", "", "conversationId", "configuredHint", "execSendImgMsgCacheScanner", "getSendImageCacheCleanupTargets", "", "Lcom/larus/bmhome/chat/input/SendImageCacheCleanupTarget;", "recordCameraParam", "clickFrom", "templateId", "templateType", "registerOnChatInputIntercept", "onChatInputIntercept", "Lcom/larus/bmhome/chat/input/OnChatInputIntercept;", "unregisterOnChatInputIntercept", "getInputUploadManager", "Lcom/larus/bmhome/chat/input/InputUploadManager;", "getInputResourceManager", "Lcom/larus/bmhome/chat/input/InputResourceManager;", "getMultimodalDowngradeData", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "compatBuildBottomMultimodal", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "compatBuildBottomMultimodalBottomMenu", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "compatBuildBottomAttachmentPanel", "compatBuildBottomLatestPhotoShortcut", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatInputServiceNoop implements IChatInputService {
    public ChatInputServiceNoop() {
    }

    public final MultimodalDowngradeData A6() {
        return null;
    }

    public final void c() {
    }

    public final void d(String r1, String r2, String r3) {
    }

    public final void e(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    public final View l(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        return null;
    }

    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget a() {
        throw new RuntimeException("IChatInputService#getInputResourceManager not implemented");
    }

    @Deprecated(message = "use component registry instead")
    public final ComponentFeature b() {
        throw new RuntimeException("IChatInputService#compatBuildBottomMultimodal not implemented");
    }

    public final b f() {
        throw new RuntimeException("IChatInputService#getInputResourceManager not implemented");
    }

    public final c g() {
        throw new RuntimeException("IChatInputService#getInputUploadManager not implemented");
    }

    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget h() {
        throw new RuntimeException("IChatInputService#getInputResourceManager not implemented");
    }

    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget m() {
        throw new RuntimeException("IChatInputService#compatBuildBottomMultimodalBottomMenu not implemented");
    }

    public final List<e> k() {
        return CollectionsKt.emptyList();
    }

    public final ChatInputPlaceholderMode j() {
        return ChatInputPlaceholderMode.KEYBOARD;
    }

    public final String i(String r2, String r3) {
        if (r3 == null) goto L8;
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        return r3;
    L8:
        return null;
    }
}
