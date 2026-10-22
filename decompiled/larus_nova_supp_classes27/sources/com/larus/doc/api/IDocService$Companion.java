package com.larus.doc.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.doc.impl.DocFragment;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import q97.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001JO\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010\u0017\u001a\u00020\nH\u0096\u0001J\t\u0010\u0018\u001a\u00020\nH\u0096\u0001J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001b\u001a\u00020\nH\u0096\u0001J\t\u0010\u001c\u001a\u00020\nH\u0096\u0001J\t\u0010\u001d\u001a\u00020\nH\u0096\u0001J#\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010!\u001a\u00020\u0005H\u0096\u0001J\t\u0010\"\u001a\u00020\u000fH\u0096\u0001J\u000b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000e\u0010$\u001a\u00020\u000fH\u0096A¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\u000fH\u0096\u0001J\u0010\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0001¢\u0006\u0002\u0010)J\u000b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0001J\u000b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0001J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0010\u0010/\u001a\u0004\u0018\u00010(H\u0096\u0001¢\u0006\u0002\u0010)J\u000b\u00100\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u00101\u001a\u00020(H\u0096\u0001J\u000b\u00102\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u00103\u001a\u00020\u000fH\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000b\u00105\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000b\u00106\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000108H\u0096\u0001J\t\u00109\u001a\u00020\u0005H\u0096\u0001J\t\u0010:\u001a\u00020\u0005H\u0096\u0001J8\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020BH\u0096A¢\u0006\u0002\u0010CJ\t\u0010D\u001a\u00020(H\u0096\u0001J\t\u0010E\u001a\u00020\bH\u0096\u0001J\u0011\u0010F\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\t\u0010G\u001a\u00020(H\u0096\u0001J\t\u0010H\u001a\u00020\u0005H\u0096\u0001J!\u0010I\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u00020\u000fH\u0096\u0001J9\u0010K\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010\u000f2\b\u0010M\u001a\u0004\u0018\u00010\u000f2\b\u0010N\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u001e\u0010O\u001a\u00020\b2\u0006\u0010=\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0096A¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010-H\u0096\u0001J\u0011\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\bH\u0096\u0001J\u0011\u0010U\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\t\u0010V\u001a\u00020\bH\u0096\u0001JS\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020<2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0096\u0001JA\u0010`\u001a\u00020\u00052\b\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020\u000f2\b\u0010d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010e\u001a\u00020\u00052\b\u0010f\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J@\u0010g\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010\u000f2\b\u0010b\u001a\u0004\u0018\u00010(2\b\u0010\\\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010hJ#\u0010i\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000f2\b\u0010j\u001a\u0004\u0018\u00010\u000f2\u0006\u0010k\u001a\u00020(H\u0096\u0001¨\u0006l"}, d2 = {"Lcom/larus/doc/api/IDocService$Companion;", "Lcom/larus/doc/api/IDocService;", "<init>", "()V", "clearReference", "", "clickVoiceInput", "enable", "", "createAiEditBackRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createDocByMessage", "message", "Lcom/larus/im/bean/message/Message;", "conversationId", "", "isInMainConversation", "botId", "context", "Landroid/content/Context;", "from", "currentPage", "meetingRecordCreatePlatform", "createDocDetailRouteInterceptor", "createDocPasteRouteInterceptor", "createFeishuDocLinkInterceptor", "createNewDoc", "createNewDocRouteInterceptor", "createOfficeApplyPermissionRouteInterceptor", "createOfficeUrlRouterInterceptor", "doubaoDocUrlJump", "url", "enterMethod", "enterStreamEditIfNeeded", "getActionBarScene", "getAgentChatId", "getAppIconUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArtifactMetaId", "getArtifactType", "", "()Ljava/lang/Integer;", "getCurBot", "Lcom/larus/im/bean/bot/BotModel;", "getCurConv", "Lcom/larus/im/bean/conversation/Conversation;", "getCurScene", "getDocApplyPermissionIconResId", "getFeishuRecordId", "getFloatChatShowPercent", "getGeneralAgent", "getPageToken", "getRecordContentType", "getRecordScene", "getSpeakInputHint", "getVoiceInputStatus", "Lkotlinx/coroutines/flow/StateFlow;", "init", "initDocSdk", "integrateFloatChatFragment", "Landroidx/fragment/app/Fragment;", "parentFragment", "sceneKey", "hasBottomTab", "useRemoteConv", "bundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZZLandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeepThinkingSwitchOn", "isDocPageShown", "isDoubaoDoc", "isFloatChat", "leaveAIEditMode", "openDocDetailPage", "page", "openOfficeDocByToken", "token", "originFileTypeString", "fallbackUrl", "refreshFloatChatRemoteBinding", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveConv", "conv", "setInputTextFocusable", "focusable", "shouldDeferFeishuDocLink", "shouldShowBackSegment", "showDownloadPanel", "fragment", "resourceId", "resourceVersion", "showFrom", "artifactMetaId", "bizExtra", "", "", "trackDocCreate", "pageToken", "resourceType", "enterFrom", "previousPage", "tryCloseChatFloatFragment", "docId", "tryPrefetchData", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "updateDocBrief", "artifactVersionId", "artifactType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IDocService$Companion implements IDocService {
    public static final /* synthetic */ IDocService$Companion c = null;
    public final /* synthetic */ IDocService b;

    static {
        c = new IDocService$Companion();
    }

    public final int A() {
        return this.b.A();
    }

    public final String F9() {
        return this.b.F9();
    }

    public final boolean G9(Context r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        return this.b.G9(r8, r9, r10, r11, r12);
    }

    public final a H9() {
        return this.b.H9();
    }

    public final void I9(String r9, int r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        this.b.I9(r9, r10, r11, r12, r13, r14);
    }

    public final a J9() {
        return this.b.J9();
    }

    public final int K9() {
        return this.b.K9();
    }

    public final a L9() {
        return this.b.L9();
    }

    public final void M9(Fragment r3, String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "resourceId");
        Intrinsics.checkNotNullParameter("drive", "showFrom");
        this.b.M9(r3, r4, r5);
    }

    public final void N9(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "resourceId");
        this.b.N9(r2, r3, r4);
    }

    public final void O9() {
        this.b.O9();
    }

    public final void P1(e r2) {
        this.b.P1(r2);
    }

    public final BotModel P4() {
        return this.b.P4();
    }

    public final Integer P9() {
        return this.b.P9();
    }

    public final void Q1(Message r11, String r12, boolean r13, String r14, Context r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "from");
        Intrinsics.checkNotNullParameter(r17, "currentPage");
        this.b.Q1(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final boolean Q9() {
        return this.b.Q9();
    }

    public final int R() {
        return this.b.R();
    }

    public final Object R9(DocFragment r2, Bundle r3, Continuation r4) {
        return this.b.R9(r2, r3, r4);
    }

    public final String S9() {
        return this.b.S9();
    }

    public final Object T9(DocFragment r7, String r8, boolean r9, Bundle r10, Continuation r11) {
        return this.b.T9(r7, r8, r9, r10, r11);
    }

    public final String U0() {
        return this.b.U0();
    }

    public final boolean U9(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        return this.b.U9(r2, r3, r4);
    }

    public final a V9() {
        return this.b.V9();
    }

    public final String W3() {
        return this.b.W3();
    }

    public final a W9() {
        return this.b.W9();
    }

    public final void X9() {
        this.b.X9();
    }

    public final String Y0() {
        return this.b.Y0();
    }

    public final a Y9() {
        return this.b.Y9();
    }

    public final void Z9(Context r2, Bundle r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "page");
        this.b.Z9(r2, r3, r4);
    }

    public final a aa() {
        return this.b.aa();
    }

    public final String b7() {
        return this.b.b7();
    }

    public final boolean ba(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return this.b.ba(r2);
    }

    public final boolean ca(String r7, Integer r8, String r9, String r10, String r11) {
        return this.b.ca(r7, r8, r9, r10, r11);
    }

    public final void clearReference() {
        this.b.clearReference();
    }

    public final String e4() {
        return this.b.e4();
    }

    public final void enterStreamEditIfNeeded() {
        this.b.enterStreamEditIfNeeded();
    }

    public final Object getAppIconUrl(Continuation<? super String> r2) {
        return this.b.getAppIconUrl(r2);
    }

    public final String getCurScene() {
        return this.b.getCurScene();
    }

    public final i1<Boolean> getVoiceInputStatus() {
        return this.b.getVoiceInputStatus();
    }

    public final void init() {
        this.b.init();
    }

    public final e p1() {
        return this.b.p1();
    }

    public final String r1() {
        return this.b.r1();
    }

    public final boolean shouldShowBackSegment() {
        return this.b.shouldShowBackSegment();
    }

    public final String w0() {
        return this.b.w0();
    }

    public final Integer w8() {
        return this.b.w8();
    }

    private IDocService$Companion() {
        this.b = (IDocService) ServiceManager.get().getService(IDocService.class);
    }
}
