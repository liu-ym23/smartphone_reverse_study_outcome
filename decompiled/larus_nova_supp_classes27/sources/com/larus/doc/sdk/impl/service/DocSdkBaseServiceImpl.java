package com.larus.doc.sdk.impl.service;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.doc.sdk.impl.statistics.DocSdkEventHelper;
import com.larus.doc.sdk.impl.v2.plugins.snapshot.DocSnapshotManager;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.m;
import com.larus.office.base.service.n;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.g;
import n39.h;
import n39.j;
import n39.k;
import n39.l;
import n39.o;
import n39.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J0\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020$H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J)\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u001f2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020$H\u0016J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020$H\u0016J\u0018\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020&2\u0006\u0010:\u001a\u00020$H\u0016J\u0018\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020$H\u0016J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010:\u001a\u00020$H\u0016J\u0012\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0016J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0016J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0016J\u0012\u0010I\u001a\u00020&2\b\u0010 \u001a\u0004\u0018\u00010JH\u0016¨\u0006L"}, d2 = {"Lcom/larus/doc/sdk/impl/service/DocSdkBaseServiceImpl;", "Lcom/larus/doc/sdk/api/IDocSdkBaseService;", "<init>", "()V", "addChatService", "", "service", "Lcom/larus/doc/sdk/api/IChatService;", "removeChatService", "addDocModeService", "Lcom/larus/doc/sdk/api/IDocModeService;", "removeDocModeService", "addTitleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "removeTitleBarService", "addLoadingDocStateService", "Lcom/larus/doc/sdk/api/ILoadingDocStateService;", "removeLoadingDocStateService", "addLoadingService", "Lcom/larus/office/base/page/ILoadingService;", "removeLoadingService", "addOperationService", "Lcom/larus/doc/sdk/api/ICommonOperationService;", "removeOperationService", "getPartialRewriteService", "Lcom/larus/doc/sdk/api/IPartialRewriteService;", "getToolbarService", "Lcom/larus/doc/sdk/api/IToolbarService;", "getVoiceInputService", "Lcom/larus/doc/sdk/api/IVoiceInputService;", "getBottomWindowHeight", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "setChatInputVisible", "from", "", "visible", "", "aiEditMode", "normalMode", "docLogicKeyForFindService", "setConversationId", "conversationId", "setArtifactMetaId", "artifactMetaId", "reportDocPageExit", "reason", "resetDocOpenTime", "startDocSnapshot", "inputViewHeight", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;)V", "getDocInfoProvider", "Lcom/larus/doc/sdk/api/IDocInfoProvider;", "docLogicKey", "onMessageLoadingStart", "onMessageLoadingEnd", "isPartialEdit", "notifyAiThinkingStateChanged", "state", "onTitleClicked", "setHostAbilityProvider", "hostAbility", "Lcom/larus/office/base/page/IHostAbilityProvider;", "showPhotoPickerFragment", "hidePhotoPickerFragment", "reportToolbarItemClicked", "name", "reportToolbarItemShow", "isKeyboardShowing", "Landroid/app/Activity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSdkBaseServiceImpl implements IDocSdkBaseService {
    public static final Companion Companion = null;
    private static final String TAG = "DocSdkBaseServiceImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/service/DocSdkBaseServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DocSdkBaseServiceImpl() {
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public l getPartialRewriteService() {
        return new AnonymousClass1();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public o getToolbarService() {
        return new C01671();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public r getVoiceInputService() {
        return new C01681();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void hidePhotoPickerFragment() {
        j r0 = ServiceManager.getHostBizAbilityProvider$default(ServiceManager.INSTANCE, null, 1, null);
        if (r0 == null) goto L6;
        r0.hidePhotoPickerFragment();
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void resetDocOpenTime() {
        OfficeInputParam r0 = ServiceManager.INSTANCE.getInputParam();
        if (r0 == null) goto L6;
        r0.setLoadSuccessTimestamp(System.currentTimeMillis());
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void showPhotoPickerFragment() {
        j r0 = ServiceManager.getHostBizAbilityProvider$default(ServiceManager.INSTANCE, null, 1, null);
        if (r0 == null) goto L6;
        r0.showPhotoPickerFragment();
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void addChatService(n39.c r2) {
        ServiceManager.INSTANCE.addChatService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void addDocModeService(g r2) {
        ServiceManager.INSTANCE.addDocModeService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void addLoadingDocStateService(k r2) {
        ServiceManager.INSTANCE.addLoadingDocStateService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void addLoadingService(vm9.c r2) {
        ServiceManager.INSTANCE.addLoadingService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void addOperationService(n39.d r2) {
        ServiceManager.INSTANCE.addOperationService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void addTitleBarService(com.larus.office.base.service.b r2) {
        Lazy r0 = m.a;
        n r1 = (n) m.a.getValue();
        if (r2 == null) goto L5;
        r1.a.add(r2);
        return;
    L5:
        r1.getClass();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public int getBottomWindowHeight(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        KeyboardHeightProvider r4 = KeyboardHeightProvider.Factory.get(r3);
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.isKeyboardShowing() == true) goto L8;
        return 0;
    L8:
        return r4.keyBoardRawHeight();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public n39.f getDocInfoProvider(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        return ServiceManager.INSTANCE.getDocInfoProvider(r2);
    }

    public boolean isKeyboardShowing(Activity r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return KeyBoardUtils.isKeyBoardShowing(r1);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void onMessageLoadingStart(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        Lazy r0 = m.a;
        com.larus.office.base.service.c r3 = m.e(r2);
        if (r3 == null) goto L6;
        r3.onLoadingStart();
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void onTitleClicked(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        Lazy r0 = m.a;
        com.larus.office.base.service.c r3 = m.e(r2);
        if (r3 == null) goto L6;
        r3.onTitleClicked();
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void removeChatService(n39.c r2) {
        ServiceManager.INSTANCE.removeChatService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void removeDocModeService(g r2) {
        ServiceManager.INSTANCE.removeDocModeService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void removeLoadingDocStateService(k r2) {
        ServiceManager.INSTANCE.removeLoadingDocStateService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void removeLoadingService(vm9.c r2) {
        ServiceManager.INSTANCE.removeLoadingService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void removeOperationService(n39.d r2) {
        ServiceManager.INSTANCE.removeOperationService(r2);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void removeTitleBarService(com.larus.office.base.service.b r2) {
        Lazy r0 = m.a;
        n r1 = (n) m.a.getValue();
        if (r2 == null) goto L5;
        r1.a.remove(r2);
        return;
    L5:
        r1.getClass();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void reportDocPageExit(String r18) {
        Intrinsics.checkNotNullParameter(r18, "reason");
        ServiceManager r0 = ServiceManager.INSTANCE;     // Catch: Exception -> L48
        OfficeInputParam r2 = r0.getInputParam();     // Catch: Exception -> L48
        if (r2 == null) goto L6;
        long r5 = r2.getLoadSuccessTimestamp();     // Catch: Exception -> L48
    L8:
        if (r5 <= 0) goto L46;
        DocSdkEventHelper r3 = DocSdkEventHelper.INSTANCE;     // Catch: Exception -> L48
        OfficeInputParam r4 = r0.getInputParam();     // Catch: Exception -> L48
        String r6 = "";
        if (r4 == null) goto L14;
        String r7 = r4.getResourceId();     // Catch: Exception -> L48
        if (r7 == null) goto L14;
    L15:
        OfficeInputParam r8 = r0.getInputParam();     // Catch: Exception -> L48
        if (r8 == null) goto L21;
        String r9 = r8.getArtifactMetaId();     // Catch: Exception -> L48
        if (r9 == null) goto L21;
        r6 = r9;
    L21:
        OfficeInputParam r10 = r0.getInputParam();     // Catch: Exception -> L48
        if (r10 == null) goto L24;
        Integer r11 = Integer.valueOf(r10.getResourceType());     // Catch: Exception -> L48
    L25:
        r0.getDocState();     // Catch: Exception -> L48
        Long r12 = Long.valueOf(System.currentTimeMillis() - r5);     // Catch: Exception -> L48
        r0.getDocState();     // Catch: Exception -> L48
        OfficeInputParam r13 = r0.getInputParam();     // Catch: Exception -> L48
        if (r13 == null) goto L28;
        String r14 = r13.getFeishuRecordId();     // Catch: Exception -> L48
    L29:
        OfficeInputParam r15 = r0.getInputParam();     // Catch: Exception -> L48
        if (r15 == null) goto L32;
        String r16 = r15.getFeishuRecordContentType();     // Catch: Exception -> L48
    L33:
        OfficeInputParam r17 = r0.getInputParam();     // Catch: Exception -> L48
        if (r17 == null) goto L36;
        String r110 = r17.getRecordScene();     // Catch: Exception -> L48
    L37:
        OfficeInputParam r20 = r0.getInputParam();     // Catch: Exception -> L48
        if (r20 == null) goto L40;
        String r111 = r20.isGeneralAgent();     // Catch: Exception -> L48
    L41:
        OfficeInputParam r1 = r0.getInputParam();     // Catch: Exception -> L48
        if (r1 == null) goto L44;
        String r21 = r1.getAgentChatId();     // Catch: Exception -> L48
    L45:
        r3.reportOutputPreviewExit(r7, r6, r11, 0, r12, r18, 1, r14, r16, r110, r111, r21);     // Catch: Exception -> L48
        return;
    L44:
        r21 = null;
        goto L45
    L40:
        r111 = null;
        goto L41
    L36:
        r110 = null;
        goto L37
    L32:
        r16 = null;
        goto L33
    L28:
        r14 = null;
        goto L29
    L24:
        r11 = null;
    L14:
        r7 = "";
        goto L15
    L46:
        FLogger.a.e(TAG, "reportDocPageExit error: duration is 0");     // Catch: Exception -> L48
        return;
    L6:
        r5 = 0;
    L48:
        e = move-exception;
        FLogger.a.e(TAG, "reportDocPageExit error: " + e.getMessage());
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void setArtifactMetaId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "artifactMetaId");
        OfficeInputParam r0 = ServiceManager.INSTANCE.getInputParam();
        if (r0 == null) goto L6;
        r0.setArtifactMetaId(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void setConversationId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        OfficeInputParam r0 = ServiceManager.INSTANCE.getInputParam();
        if (r0 == null) goto L6;
        r0.setConversationId(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void setHostAbilityProvider(vm9.a r2) {
        Lazy r0 = m.a;
        m.d = r2;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void notifyAiThinkingStateChanged(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "docLogicKey");
        Lazy r0 = m.a;
        com.larus.office.base.service.c r4 = m.e(r3);
        if (r4 == null) goto L6;
        r4.onAiThinkingStateChanged(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void onMessageLoadingEnd(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "docLogicKey");
        Lazy r0 = m.a;
        com.larus.office.base.service.c r4 = m.e(r3);
        if (r4 == null) goto L6;
        r4.onLoadingEnd(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void reportToolbarItemClicked(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "docLogicKey");
        j r4 = ServiceManager.INSTANCE.getHostBizAbilityProvider(r3);
        if (r4 == null) goto L6;
        r4.reportToolbarItemClicked(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void reportToolbarItemShow(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "docLogicKey");
        j r4 = ServiceManager.INSTANCE.getHostBizAbilityProvider(r3);
        if (r4 == null) goto L6;
        r4.reportToolbarItemShow(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void startDocSnapshot(Integer r9, Drawable r10, h r11) {
        Intrinsics.checkNotNullParameter(r11, "listener");
        DocSnapshotManager.startDocSnapshot$default(DocSnapshotManager.INSTANCE, r9, r10, r11, null, 8, null);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkBaseService
    public void setChatInputVisible(String r2, boolean r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r6, "docLogicKeyForFindService");
        ServiceManager.INSTANCE.getChatService(r6).setChatInputVisible(r2, r3, r4, r5);
    }
}
