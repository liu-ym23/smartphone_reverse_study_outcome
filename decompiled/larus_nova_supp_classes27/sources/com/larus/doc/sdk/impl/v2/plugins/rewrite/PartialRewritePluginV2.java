package com.larus.doc.sdk.impl.v2.plugins.rewrite;

import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.rewrite.PartialRewriteJsCaller;
import com.larus.doc.sdk.impl.generalbiz.rewrite.PartialRewriteManager;
import com.larus.doc.sdk.impl.generalbiz.rewrite.PositionPoint;
import com.larus.doc.sdk.impl.generalbiz.rewrite.SelectChangeData;
import com.larus.doc.sdk.impl.generalbiz.rewrite.SelectedContent;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.network.http.HttpExtKt;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.l;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u0003345B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\u00112\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u0018H\u0016J\u001c\u0010\u001a\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u000bJ\b\u0010*\u001a\u00020\u0011H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\tH\u0016J\u0018\u0010-\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u00100\u001a\u00020\u0011H\u0016J.\u00101\u001a\u00020\u00112$\u0010\u001b\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J.\u00102\u001a\u00020\u00112$\u0010\u001b\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\"\u0012 \u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/rewrite/PartialRewritePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/IPartialRewriteService;", "<init>", "()V", "selectedText", "", "selectedWholeText", "shouldShowBackFunction", "", "currentDocMode", "Lcom/larus/doc/sdk/api/model/DocMode;", "selectedData", "Lcom/larus/doc/sdk/impl/generalbiz/rewrite/SelectChangeData;", "selectedTextChangeListener", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function3;", "", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "enterStreamEditMode", "callback", "Lkotlin/Function1;", "startStreamEdit", "notifyTrackInfoUpdated", "streamEditTextContent", "content", "endStreamEdit", "cancelStreaming", "leaveStreamEditMode", "scene", "", "restoreSelection", "clearReference", "setCurrentDocMode", "docMode", "enterStreamEditIfNeeded", "handleActionBarPaste", "shouldShowBackSegment", "getSelectedText", "Lkotlin/Pair;", "getRefBlockInfo", "resetAiEditState", "addSelectedTextChangeListener", "removeSelectedTextChangeListener", "Companion", "SelectChangeHandler", "InnerAIEditBreakStreamHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PartialRewritePluginV2 extends OfficeDocumentPlugin implements l {
    private static final String BIZ_AIEDIT_BREAK_STREAM = "biz.aiEdit.breakStream";
    private static final String BIZ_SELECT_TEXT_CHANGED = "biz.notify.selectChange";
    public static final Companion Companion = null;
    public static final String TAG = "PartialRewritePluginV2";
    private DocMode currentDocMode;
    private SelectChangeData selectedData;
    private String selectedText;
    private final CopyOnWriteArraySet<Function3<String, String, String, Unit>> selectedTextChangeListener;
    private String selectedWholeText;
    private boolean shouldShowBackFunction;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/rewrite/PartialRewritePluginV2$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_SELECT_TEXT_CHANGED", "BIZ_AIEDIT_BREAK_STREAM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/rewrite/PartialRewritePluginV2$InnerAIEditBreakStreamHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Ljava/lang/Void;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/rewrite/PartialRewritePluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerAIEditBreakStreamHandler implements i<Void> {
        final /* synthetic */ PartialRewritePluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public InnerAIEditBreakStreamHandler(PartialRewritePluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Void r1, m r2) {
            ChameleonPluginHost r3 = this.this$0.getHost();
            if (r3 == null) goto L6;
            String r4 = x.a(r3);
            if (r4 == null) goto L6;
        L7:
            ServiceManager.INSTANCE.getOperationService(r4).notifyInterruptConversation();
            return;
        L6:
            r4 = "";
            goto L7
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((Void) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/rewrite/PartialRewritePluginV2$SelectChangeHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/generalbiz/rewrite/SelectChangeData;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/rewrite/PartialRewritePluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SelectChangeHandler implements i<SelectChangeData> {
        final /* synthetic */ PartialRewritePluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public SelectChangeHandler(PartialRewritePluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(SelectChangeData r5, m r6) {
            FLogger r7 = FLogger.a;
            StringBuilder r0 = new StringBuilder("Selected text changed, text length: ");
            String r1 = null;
            if (r5 == null) goto L7;
            String r2 = r5.getText();
            if (r2 == null) goto L7;
            Integer r3 = Integer.valueOf(r2.length());
        L8:
            r0.append(r3);
            r7.i(PartialRewritePluginV2.TAG, r0.toString());
            PartialRewritePluginV2.access$setSelectedData$p(this.this$0, r5);
            String r8 = PartialRewritePluginV2.access$getSelectedText$p(this.this$0);
            if (r5 == null) goto L11;
            String r4 = r5.getText();
        L13:
            if (Intrinsics.areEqual(r8, r4) == true) goto L29;
            PartialRewritePluginV2 r9 = this.this$0;
            if (r5 == null) goto L17;
            String r10 = r5.getText();
        L18:
            PartialRewritePluginV2.access$setSelectedText$p(r9, r10);
            PartialRewritePluginV2 r11 = this.this$0;
            if (r5 == null) goto L21;
            String r12 = r5.getWholeText();
        L22:
            PartialRewritePluginV2.access$setSelectedWholeText$p(r11, r12);
            if (r5 == null) goto L25;
            r1 = r5.getPlainText();
        L25:
            CopyOnWriteArraySet r13 = PartialRewritePluginV2.access$getSelectedTextChangeListener$p(this.this$0);
            PartialRewritePluginV2 r14 = this.this$0;
            Iterator r15 = r13.iterator();
        L27:
            if (r15.hasNext() == false) goto L31;
            ((Function3) r15.next()).invoke(PartialRewritePluginV2.access$getSelectedText$p(r14), PartialRewritePluginV2.access$getSelectedWholeText$p(r14), r1);
            goto L27
        L31:
            return;
        L21:
            r12 = null;
            goto L22
        L17:
            r10 = null;
            goto L18
        L29:
            return;
        L11:
            r4 = null;
        L7:
            r3 = null;
            goto L8
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((SelectChangeData) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(PartialRewritePluginV2 r0, String r1) {
        return notifyTrackInfoUpdated$lambda$3(r0, r1);
    }

    @Override // n39.l
    public void handleActionBarPaste() {
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // n39.l
    public void resetAiEditState() {
        this.selectedText = null;
        this.selectedWholeText = null;
    }

    @Override // n39.l
    public void enterStreamEditIfNeeded() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("enterStreamEditIfNeeded, selectedText length: ");
        String r2 = this.selectedText;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.length());
    L6:
        r1.append(r3);
        r1.append(", current doc mode: ");
        r1.append(this.currentDocMode);
        r0.i(TAG, r1.toString());
        if (TextUtils.isEmpty(this.selectedText) == false) goto L9;
        return;
    L9:
        if (this.currentDocMode == DocMode.AI_EDIT) goto L13;
        this.shouldShowBackFunction = false;
        PartialRewriteJsCaller.INSTANCE.enterStreamEditMode(getHost().getWeb().getWebView(), null, DocSdkVersion.V2);
        return;
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // n39.l
    public String getRefBlockInfo() {
        SelectChangeData r0 = this.selectedData;
        if (r0 == null) goto L5;
        SelectedContent r1 = r0.getSelectedContent();
    L6:
        if (r1 != null) goto L12;
        SelectChangeData r2 = this.selectedData;
        if (r2 == null) goto L10;
        PositionPoint r3 = r2.getCursorPosition();
    L11:
        if (r3 != null) goto L12;
        return null;
    L10:
        r3 = null;
    L12:
        SelectChangeData r4 = this.selectedData;
        if (r4 != null) goto L15;
        return null;
    L15:
        return HttpExtKt.p(r4);
    L5:
        r1 = null;
        goto L6
    }

    @Override // n39.l
    public Pair<String, String> getSelectedText() {
        return new Pair(this.selectedText, this.selectedWholeText);
    }

    @Override // n39.l
    public void notifyTrackInfoUpdated() {
        ServiceManager.getChatService$default(ServiceManager.INSTANCE, null, 1, null).getLatestMessageId(new a(this));
    }

    public PartialRewritePluginV2() {
        this.shouldShowBackFunction = true;
        this.selectedTextChangeListener = new CopyOnWriteArraySet();
    }

    @Override // n39.l
    public void clearReference() {
        resetAiEditState();
        k r0 = getHost().getWeb();
        if (r0 == null) goto L8;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L9;
        PartialRewriteJsCaller.INSTANCE.clearReference(r1, DocSdkVersion.V2);
        return;
    L9:
        return;
    }

    @Override // n39.l
    public void startStreamEdit() {
        k r0 = getHost().getWeb();
        if (r0 == null) goto L8;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L9;
        PartialRewriteJsCaller.INSTANCE.startStreamEdit(r1, DocSdkVersion.V2);
        return;
    L9:
        return;
    }

    @Override // n39.l
    public boolean shouldShowBackSegment() {
        return this.shouldShowBackFunction;
    }

    public static final /* synthetic */ String access$getSelectedText$p(PartialRewritePluginV2 r0) {
        return r0.selectedText;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getSelectedTextChangeListener$p(PartialRewritePluginV2 r0) {
        return r0.selectedTextChangeListener;
    }

    public static final /* synthetic */ String access$getSelectedWholeText$p(PartialRewritePluginV2 r0) {
        return r0.selectedWholeText;
    }

    @Override // n39.l
    public void addSelectedTextChangeListener(Function3<? super String, ? super String, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.selectedTextChangeListener.add(r2);
    }

    @Override // n39.l
    public void endStreamEdit(boolean r4) {
        FLogger.a.i(TAG, "endStreamEdit: " + r4 + ", isAiEditing");
        k r0 = getHost().getWeb();
        if (r0 == null) goto L8;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L9;
        PartialRewriteJsCaller.INSTANCE.endStreamEdit(r1, r4, DocSdkVersion.V2);
        return;
    L9:
        return;
    }

    @Override // n39.l
    public void enterStreamEditMode(Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        k r0 = getHost().getWeb();
        if (r0 == null) goto L8;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L9;
        PartialRewriteJsCaller.INSTANCE.enterStreamEditMode(r1, r4, DocSdkVersion.V2);
        return;
    L9:
        return;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_SELECT_TEXT_CHANGED, new SelectChangeHandler(this));
        r3.put(BIZ_AIEDIT_BREAK_STREAM, new InnerAIEditBreakStreamHandler(this));
    }

    public void onAttachToHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        PartialRewriteManager.INSTANCE.addDelegate(this);
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        PartialRewriteManager.INSTANCE.removeDelegate(this);
    }

    @Override // n39.l
    public void removeSelectedTextChangeListener(Function3<? super String, ? super String, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.selectedTextChangeListener.remove(r2);
    }

    public final void setCurrentDocMode(DocMode r2) {
        Intrinsics.checkNotNullParameter(r2, "docMode");
        this.currentDocMode = r2;
    }

    @Override // n39.l
    public void streamEditTextContent(String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        k r0 = getHost().getWeb();
        if (r0 == null) goto L8;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L9;
        PartialRewriteJsCaller.INSTANCE.streamEditTextContent(r1, r4, DocSdkVersion.V2);
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$setSelectedData$p(PartialRewritePluginV2 r0, SelectChangeData r1) {
        r0.selectedData = r1;
    }

    public static final /* synthetic */ void access$setSelectedText$p(PartialRewritePluginV2 r0, String r1) {
        r0.selectedText = r1;
    }

    public static final /* synthetic */ void access$setSelectedWholeText$p(PartialRewritePluginV2 r0, String r1) {
        r0.selectedWholeText = r1;
    }

    private static final Unit notifyTrackInfoUpdated$lambda$3(PartialRewritePluginV2 r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        JSONObject r0 = new JSONObject();
        r0.put("message_id", r3);
        k r4 = r2.getHost().getWeb();
        if (r4 == null) goto L8;
        WebView r5 = r4.getWebView();
        if (r5 == null) goto L8;
        PartialRewriteJsCaller.INSTANCE.notifyTrackInfoUpdate(r5, DocSdkVersion.V2, r0.toString());
    L8:
        return Unit.INSTANCE;
    }

    @Override // n39.l
    public void leaveStreamEditMode(int r8, boolean r9) {
        FLogger.a.i(TAG, "leaveStreamEditMode, is_keyboard_showing: " + KeyBoardUtils.isKeyBoardShowing(getHost().getActivity()));
        k r0 = getHost().getWeb();
        if (r0 == null) goto L8;
        WebView r2 = r0.getWebView();
        if (r2 == null) goto L9;
        PartialRewriteJsCaller.INSTANCE.leaveStreamEditMode(r2, r8, r9, KeyBoardUtils.isKeyBoardShowing(getHost().getActivity()), DocSdkVersion.V2);
        return;
    L9:
        return;
    }
}
