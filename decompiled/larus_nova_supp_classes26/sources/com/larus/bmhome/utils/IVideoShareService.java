package com.larus.bmhome.utils;

import android.view.View;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.video.save_share.VideoGenerateShareHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0095\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001bJ\u0093\u0001\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/utils/IVideoShareService;", "", "shareWithShareService", "", "shareContainer", "Landroid/view/View;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "messageId", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "videoDetailEventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "sendShareEvent", "", "creationId", "metaDataMap", "", "taskType", "", "(Landroid/view/View;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/common_ui/dialog/CommonLoadDialog;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/larus/bmhome/utils/VideoDetailEventParams;ZLjava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)V", "createVideoShareCallback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "reportType", "(Landroid/view/View;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/common_ui/dialog/CommonLoadDialog;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/larus/bmhome/utils/VideoDetailEventParams;ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVideoShareService {

    public static final class a {
        public static /* synthetic */ com.larus.bmhome.share.panel.d a(IVideoShareService r13, View r14, CoroutineScope r15, com.larus.common_ui.dialog.l0 r16, nr9.g r17, String r18, ShareScene r19, com.larus.bmhome.share.panel.h r20, c4 r21, String r22, Map r23, int r24) {
            if ((r24 & 32) == 0) goto L5;
            ShareScene r8 = ShareScene.VIDEO_VIEWER;
        L7:
            if ((r24 & 64) == 0) goto L9;
            com.larus.bmhome.share.panel.h r9 = null;
        L11:
            if ((r24 & 128) == 0) goto L13;
            c4 r10 = null;
        L15:
            if ((r24 & 2048) == 0) goto L17;
            Map r12 = null;
        L19:
            return r13.a(r14, r15, r16, r17, r18, r8, r9, r10, r22, r12);
        L17:
            r12 = r23;
            goto L19
        L13:
            r10 = r21;
            goto L15
        L9:
            r9 = r20;
            goto L11
        L5:
            r8 = r19;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IVideoShareService r15, View r16, CoroutineScope r17, com.larus.common_ui.dialog.l0 r18, nr9.g r19, String r20, ShareScene r21, com.larus.bmhome.share.panel.h r22, c4 r23, String r24, Map r25, Integer r26, int r27) {
            if ((r27 & 32) == 0) goto L5;
            ShareScene r8 = ShareScene.VIDEO_VIEWER;
        L7:
            if ((r27 & 64) == 0) goto L9;
            com.larus.bmhome.share.panel.h r9 = null;
        L11:
            if ((r27 & 128) == 0) goto L13;
            c4 r10 = null;
        L15:
            if ((r27 & 256) == 0) goto L17;
            boolean r11 = true;
        L19:
            if ((r27 & 1024) == 0) goto L21;
            Map r13 = null;
        L23:
            if ((r27 & 2048) == 0) goto L25;
            Integer r14 = null;
        L26:
            r15.b(r16, r17, r18, r19, r20, r8, r9, r10, r11, r24, r13, r14);
            return;
        L25:
            r14 = r26;
            goto L26
        L21:
            r13 = r25;
            goto L23
        L17:
            r11 = false;
            goto L19
        L13:
            r10 = r23;
            goto L15
        L9:
            r9 = r22;
            goto L11
        L5:
            r8 = r21;
            goto L7
        }
    }

    VideoGenerateShareHelper.VideoShareCallback a(View r1, CoroutineScope r2, com.larus.common_ui.dialog.l0 r3, nr9.g r4, String r5, ShareScene r6, com.larus.bmhome.share.panel.h r7, c4 r8, String r9, Map r10);

    void b(View r1, CoroutineScope r2, com.larus.common_ui.dialog.l0 r3, nr9.g r4, String r5, ShareScene r6, com.larus.bmhome.share.panel.h r7, c4 r8, boolean r9, String r10, Map<String, String> r11, Integer r12);
}
