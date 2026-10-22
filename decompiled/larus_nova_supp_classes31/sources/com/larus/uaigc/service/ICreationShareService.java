package com.larus.uaigc.service;

import android.content.Context;
import com.larus.bmhome.share.ShareScene;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.creation.detail.image.BigImageDetailFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u0000 \"2\u00020\u0001:\u0001\"J\u007f\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070 H&J(\u0010!\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070 H&¨\u0006#"}, d2 = {"Lcom/larus/uaigc/service/ICreationShareService;", "", "showShareImagePanel", "", "context", "Landroid/content/Context;", "imgUrl", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "taskType", "", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "galleryShareVideo", "params", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "tryShareLocalImage", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceUrls", "", "tryShareLocalVideo", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationShareService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001Jp\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\"H\u0096\u0001J)\u0010#\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\"H\u0096\u0001¨\u0006$"}, d2 = {"Lcom/larus/uaigc/service/ICreationShareService$Companion;", "Lcom/larus/uaigc/service/ICreationShareService;", "<init>", "()V", "galleryShareVideo", "", "params", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "showShareImagePanel", "context", "Landroid/content/Context;", "imgUrl", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "taskType", "", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "tryShareLocalImage", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceUrls", "", "tryShareLocalVideo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationShareService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationShareService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationShareService
        public final void N(Context r13, String r14, ShareScene r15, com.larus.bmhome.share.panel.d r16, com.larus.bmhome.share.panel.h r17, by7.e r18, UserCreationFromIM r19, UserCreation r20, Integer r21, String r22) {
            Intrinsics.checkNotNullParameter(r15, "shareScene");
            this.b.N(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        @Override // com.larus.uaigc.service.ICreationShareService
        public final boolean O(Context r2, CoroutineScope r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "scope");
            Intrinsics.checkNotNullParameter(r4, "sourceUrls");
            return this.b.O(r2, r3, r4);
        }

        @Override // com.larus.uaigc.service.ICreationShareService
        public final boolean P(Context r2, CoroutineScope r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "scope");
            Intrinsics.checkNotNullParameter(r4, "sourceUrls");
            return this.b.P(r2, r3, r4);
        }

        @Override // com.larus.uaigc.service.ICreationShareService
        public final void o(com.larus.uaigc.creation.f r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.b.o(r2);
        }

        private Companion() {
            ICreationShareService r0 = (ICreationShareService) ServiceManager.get().getService(ICreationShareService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationShareServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r13, Context r14, String r15, ShareScene r16, BigImageDetailFragment.b r17, com.larus.bmhome.share.panel.h r18, by7.e r19, UserCreationFromIM r20, Integer r21, String r22, int r23) {
            if ((r23 & 4) == 0) goto L5;
            ShareScene r5 = ShareScene.IMAGE_VIEWER_REPORT;
        L7:
            if ((r23 & 8) == 0) goto L9;
            BigImageDetailFragment.b r6 = null;
        L11:
            if ((r23 & 16) == 0) goto L13;
            com.larus.bmhome.share.panel.h r7 = null;
        L15:
            if ((r23 & 32) == 0) goto L17;
            by7.e r8 = null;
        L19:
            if ((r23 & 64) == 0) goto L21;
            UserCreationFromIM r9 = null;
        L23:
            if ((r23 & 256) == 0) goto L25;
            Integer r11 = null;
        L27:
            if ((r23 & 512) == 0) goto L29;
            String r12 = null;
        L30:
            r13.N(r14, r15, r5, r6, r7, r8, r9, null, r11, r12);
            return;
        L29:
            r12 = r22;
            goto L30
        L25:
            r11 = r21;
            goto L27
        L21:
            r9 = r20;
            goto L23
        L17:
            r8 = r19;
            goto L19
        L13:
            r7 = r18;
            goto L15
        L9:
            r6 = r17;
            goto L11
        L5:
            r5 = r16;
            goto L7
        }
    }

    static {
        a = Companion.c;
    }

    void N(Context r1, String r2, ShareScene r3, com.larus.bmhome.share.panel.d r4, com.larus.bmhome.share.panel.h r5, by7.e r6, UserCreationFromIM r7, UserCreation r8, Integer r9, String r10);

    boolean O(Context r1, CoroutineScope r2, List<String> r3);

    boolean P(Context r1, CoroutineScope r2, List<String> r3);

    void o(com.larus.uaigc.creation.f r1);
}
