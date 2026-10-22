package com.larus.uaigc.service;

import android.content.Context;
import com.larus.bmhome.share.ShareScene;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016J(\u0010#\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016¨\u0006$"}, d2 = {"Lcom/larus/uaigc/service/ICreationShareServiceNoop;", "Lcom/larus/uaigc/service/ICreationShareService;", "<init>", "()V", "showShareImagePanel", "", "context", "Landroid/content/Context;", "imgUrl", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "taskType", "", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "galleryShareVideo", "params", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "tryShareLocalImage", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceUrls", "", "tryShareLocalVideo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationShareServiceNoop implements ICreationShareService {
    public ICreationShareServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final void N(Context r1, String r2, ShareScene r3, com.larus.bmhome.share.panel.d r4, com.larus.bmhome.share.panel.h r5, by7.e r6, UserCreationFromIM r7, UserCreation r8, Integer r9, String r10) {
        Intrinsics.checkNotNullParameter(r3, "shareScene");
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final boolean O(Context r2, CoroutineScope r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "sourceUrls");
        return false;
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final boolean P(Context r2, CoroutineScope r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "sourceUrls");
        return false;
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final void o(com.larus.uaigc.creation.f r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }
}
