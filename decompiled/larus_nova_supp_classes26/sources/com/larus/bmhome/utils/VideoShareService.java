package com.larus.bmhome.utils;

import android.view.View;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.video.save_share.VideoGenerateShareHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0089\u0001\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0087\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"Lcom/larus/bmhome/utils/VideoShareService;", "Lcom/larus/bmhome/utils/IVideoShareService;", "<init>", "()V", "shareWithShareService", "", "shareContainer", "Landroid/view/View;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "messageId", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "videoDetailEventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "sendShareEvent", "", "creationId", "metaDataMap", "", "taskType", "", "(Landroid/view/View;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/common_ui/dialog/CommonLoadDialog;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/larus/bmhome/utils/VideoDetailEventParams;ZLjava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)V", "createVideoShareCallback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "reportType", "(Landroid/view/View;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/common_ui/dialog/CommonLoadDialog;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/larus/bmhome/utils/VideoDetailEventParams;ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoShareService implements IVideoShareService {
    public VideoShareService() {
    }

    @Override // com.larus.bmhome.utils.IVideoShareService
    public final VideoGenerateShareHelper.VideoShareCallback a(View r14, CoroutineScope r15, com.larus.common_ui.dialog.l0 r16, nr9.g r17, String r18, ShareScene r19, com.larus.bmhome.share.panel.h r20, c4 r21, String r22, Map r23) {
        Intrinsics.checkNotNullParameter(r14, "shareContainer");
        Intrinsics.checkNotNullParameter(r15, "scope");
        Intrinsics.checkNotNullParameter(r18, "messageId");
        Intrinsics.checkNotNullParameter(r19, "shareScene");
        return VideoGenerateShareHelper.f(VideoGenerateShareHelper.a, r14, r15, r16, r17, r18, r19, r21, 8, r22, r23, 256);
    }

    @Override // com.larus.bmhome.utils.IVideoShareService
    public final void b(View r15, CoroutineScope r16, com.larus.common_ui.dialog.l0 r17, nr9.g r18, String r19, ShareScene r20, com.larus.bmhome.share.panel.h r21, c4 r22, boolean r23, String r24, Map<String, String> r25, Integer r26) {
        Intrinsics.checkNotNullParameter(r16, "scope");
        Intrinsics.checkNotNullParameter(r19, "messageId");
        Intrinsics.checkNotNullParameter(r20, "shareScene");
        if (r15 != null) goto L5;
        return;
    L5:
        VideoGenerateShareHelper.a.getClass();
        VideoGenerateShareHelper.i(r15, r16, r17, r18, r19, r20, r21, r22, r23, 8, r24, r25, r26);
    }
}
