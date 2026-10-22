package com.larus.doc.sdk.impl.v2.plugins.state;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.impl.generalbiz.state.model.DocModeData;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.doc.sdk.impl.statistics.DocSdkEventHelper;
import com.larus.doc.sdk.impl.v2.plugins.rewrite.PartialRewritePluginV2;
import com.larus.office.OfficeInputParam;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import n39.j;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0012\u001a\u00020\n2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/DocStatePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/IHostBizAbilityProvider;", "<init>", "()V", "docStateModel", "Lcom/larus/doc/sdk/impl/v2/plugins/state/DocStateModel;", "lastShowBtnName", "", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "getChatService", "Lcom/larus/doc/sdk/api/IChatService;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "reportToolbarItemShow", "name", "reportToolbarItemClicked", "getItemTraceName", "origName", "Companion", "InnerModeChangeHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocStatePluginV2 extends OfficeDocumentPlugin implements j {
    private static final String BIZ_DOC_MODE_CHANGED = "biz.notify.modeChanged";
    public static final Companion Companion = null;
    private DocStateModel docStateModel;
    private String lastShowBtnName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/DocStatePluginV2$Companion;", "", "<init>", "()V", "BIZ_DOC_MODE_CHANGED", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/DocStatePluginV2$InnerModeChangeHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/DocModeData;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/state/DocStatePluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerModeChangeHandler implements i<DocModeData> {
        final /* synthetic */ DocStatePluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public InnerModeChangeHandler(DocStatePluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(DocModeData r4, m r5) {
            DocStateModel r6 = DocStatePluginV2.access$getDocStateModel$p(this.this$0);
            Integer r0 = null;
            if (r6 == null) goto L7;
            i1<DocMode> r7 = r6.getDocMode();
            if (r7 == null) goto L7;
            DocMode r8 = (DocMode) r7.getValue();
        L8:
            if (r4 == null) goto L10;
            r0 = r4.getMode();
        L10:
            if (r0 != null) goto L13;
        L15:
            if (r0 != null) goto L18;
        L20:
            if (r0 != null) goto L23;
        L25:
            DocMode r9 = DocMode.READ_ONLY;
        L26:
            DocStateModel r1 = DocStatePluginV2.access$getDocStateModel$p(this.this$0);
            if (r1 == null) goto L29;
            r1.setDocMode(r9);
        L29:
            FLogger.a.i("CML_TAG_AbsChameleonPlugin", "handle mode change: old=" + r8 + ", new=" + r9);
            return;
        L23:
            if (r0.intValue() != 2) goto L25;
            r9 = DocMode.AI_EDIT;
            goto L26
        L18:
            if (r0.intValue() != 1) goto L20;
            r9 = DocMode.NORMAL_EDIT;
            goto L26
        L13:
            if (r0.intValue() != 0) goto L15;
            r9 = DocMode.READ_ONLY;
        L7:
            r8 = null;
            goto L8
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((DocModeData) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(DocStatePluginV2 r0, String r1, String r2, String r3) {
        return reportToolbarItemClicked$lambda$5(r0, r1, r2, r3);
    }

    @Override // n39.j
    public void hidePhotoPickerFragment() {
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // n39.j
    public void showPhotoPickerFragment() {
    }

    private final n39.c getChatService() {
        ServiceManager r0 = ServiceManager.INSTANCE;
        ChameleonPluginHost r1 = getHost();
        if (r1 == null) goto L6;
        String r2 = x.a(r1);
        if (r2 == null) goto L6;
    L8:
        return r0.getChatService(r2);
    L6:
        r2 = "";
        goto L8
    }

    public DocStatePluginV2() {
        this.lastShowBtnName = "";
    }

    public static final /* synthetic */ n39.c access$getChatService(DocStatePluginV2 r0) {
        return r0.getChatService();
    }

    public static final /* synthetic */ DocStateModel access$getDocStateModel$p(DocStatePluginV2 r0) {
        return r0.docStateModel;
    }

    private final String getItemTraceName(String r2) {
        switch(r2.hashCode()) {
            case -779578017: goto L18;
            case -235927065: goto L14;
            case -123682270: goto L10;
            case 1327548607: goto L6;
            default: goto L21;
        };
    L21:
        return "";
    L6:
        if (r2.equals("textTransform") == false) goto L21;
        return "adjust_font_size";
    L10:
        if (r2.equals("insertImage") == false) goto L21;
        return "insert_image";
    L14:
        if (r2.equals("alignTransform") == false) goto L21;
        return "adjust_paragraph";
    L18:
        if (r2.equals("blockTransform") == false) goto L21;
        return "adjust_style";
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_DOC_MODE_CHANGED, new InnerModeChangeHandler(this));
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.docStateModel = (DocStateModel) q.c(getHost(), DocStateModel.class, null);
    }

    @Override // n39.j
    public void reportToolbarItemClicked(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        if (Intrinsics.areEqual(r4, "keyboard") == false) goto L7;
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), "javascript:window.flow.biz.keyboard.hide");
        PartialRewritePluginV2 r0 = getHost().findPlugin(PartialRewritePluginV2.class);
        if (r0 == null) goto L7;
        r0.clearReference();
    L7:
        ServiceManager r1 = ServiceManager.INSTANCE;
        OfficeInputParam r2 = r1.getInputParam();
        if (r2 == null) goto L10;
        final String r3 = r2.getOfflineCreateAttemptId();
    L11:
        r1.getChatService(x.a(getHost())).getLatestMessageId(new a(this, r4, r3));
        return;
    L10:
        r3 = null;
        goto L11
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // n39.j
    public void reportToolbarItemShow(String r13) {
        Intrinsics.checkNotNullParameter(r13, "name");
        if (Intrinsics.areEqual(this.lastShowBtnName, r13) == true) goto L62;
        this.lastShowBtnName = r13;
        String r5 = getItemTraceName(r13);
        if (TextUtils.isEmpty(r5) == true) goto L63;
        DocSdkEventHelper r1 = DocSdkEventHelper.INSTANCE;
        ServiceManager r14 = ServiceManager.INSTANCE;
        OfficeInputParam r0 = r14.getInputParam();
        String r2 = null;
        if (r0 == null) goto L9;
        String r3 = r0.getResourceId();
    L10:
        OfficeInputParam r4 = r14.getInputParam();
        if (r4 == null) goto L13;
        String r6 = r4.getArtifactMetaId();
    L14:
        OfficeInputParam r7 = r14.getInputParam();
        if (r7 == null) goto L17;
        Integer r8 = Integer.valueOf(r7.getResourceType());
    L18:
        OfficeInputParam r9 = r14.getInputParam();
        if (r9 == null) goto L21;
        String r10 = r9.getPreviousPage();
    L22:
        OfficeInputParam r11 = r14.getInputParam();
        if (r11 == null) goto L25;
        String r12 = r11.getConversationId();
    L26:
        JSONObject r15 = new JSONObject();
        OfficeInputParam r16 = r14.getInputParam();
        if (r16 == null) goto L29;
        String r17 = r16.getFeishuRecordId();
    L30:
        r15.put("feishu_record_id", r17);
        OfficeInputParam r18 = r14.getInputParam();
        if (r18 == null) goto L33;
        String r20 = r18.getFeishuRecordContentType();
    L34:
        r15.put("feishu_record_generated_type", r20);
        OfficeInputParam r21 = r14.getInputParam();
        if (r21 == null) goto L37;
        String r22 = r21.getRecordScene();
    L38:
        r15.put("record_scene", r22);
        OfficeInputParam r23 = r14.getInputParam();
        if (r23 == null) goto L41;
        String r24 = r23.isGeneralAgent();
    L43:
        if (r24 != null) goto L45;
    L48:
        boolean r110 = true;
    L50:
        if ((true ^ r110) == true) goto L53;
        r24 = null;
    L53:
        if (r24 != null) goto L55;
        r24 = "0";
    L55:
        r15.put("is_general_agent", r24);
        OfficeInputParam r111 = r14.getInputParam();
        if (r111 == null) goto L58;
        r2 = r111.getAgentChatId();
    L58:
        if (r2 != null) goto L60;
        r2 = "";
    L60:
        r15.put("chat_id", r2);
        r1.reportToolbarButtonShow(r3, r6, r8, r5, r12, r10, r15);
        return;
    L45:
        if (r24.length() == 0) goto L48;
        r110 = false;
        goto L50
    L41:
        r24 = null;
        goto L43
    L37:
        r22 = null;
        goto L38
    L33:
        r20 = null;
        goto L34
    L29:
        r17 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L63:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r4, t r5) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r4, r5);
        if (r4 == null) goto L6;
        String r6 = x.a(r4);
        if (r6 == null) goto L6;
    L7:
        ServiceManager.INSTANCE.setHostBizAbilityProvider(this, r6);
        if (r4 == null) goto L19;
        Fragment r7 = r4.getFragment();
        if (r7 == null) goto L20;
        LifecycleCoroutineScope r8 = LifecycleOwnerKt.getLifecycleScope(r7);
        if (r8 == null) goto L21;
        DocStateModel r0 = this.docStateModel;
        if (r0 == null) goto L22;
        i1<DocMode> r1 = r0.getDocMode();
        if (r1 == null) goto L23;
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1, new DocStatePluginV2$onAttachToUIContainer$1$1(r4, this, null)), r8);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L6:
        r6 = "";
        goto L7
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        if (r2 == null) goto L6;
        String r4 = x.a(r2);
        if (r4 == null) goto L6;
    L7:
        ServiceManager.INSTANCE.setHostBizAbilityProvider(null, r4);
        return;
    L6:
        r4 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static final Unit reportToolbarItemClicked$lambda$5(DocStatePluginV2 r14, String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r17, "messageId");
        DocSdkEventHelper r1 = DocSdkEventHelper.INSTANCE;
        ServiceManager r0 = ServiceManager.INSTANCE;
        OfficeInputParam r2 = r0.getInputParam();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getResourceId();
    L6:
        OfficeInputParam r5 = r0.getInputParam();
        if (r5 == null) goto L9;
        String r6 = r5.getArtifactMetaId();
    L10:
        OfficeInputParam r7 = r0.getInputParam();
        if (r7 == null) goto L13;
        Integer r8 = Integer.valueOf(r7.getResourceType());
    L14:
        String r9 = r14.getItemTraceName(r15);
        OfficeInputParam r10 = r0.getInputParam();
        if (r10 == null) goto L17;
        String r11 = r10.getPreviousPage();
    L18:
        OfficeInputParam r12 = r0.getInputParam();
        if (r12 == null) goto L21;
        String r13 = r12.getConversationId();
    L22:
        JSONObject r18 = new JSONObject();
        OfficeInputParam r20 = r0.getInputParam();
        if (r20 == null) goto L25;
        String r21 = r20.getFeishuRecordId();
    L26:
        r18.put("feishu_record_id", r21);
        OfficeInputParam r22 = r0.getInputParam();
        if (r22 == null) goto L29;
        String r23 = r22.getFeishuRecordContentType();
    L30:
        r18.put("feishu_record_generated_type", r23);
        OfficeInputParam r24 = r0.getInputParam();
        if (r24 == null) goto L33;
        String r25 = r24.getRecordScene();
    L34:
        r18.put("record_scene", r25);
        OfficeInputParam r26 = r0.getInputParam();
        if (r26 == null) goto L37;
        String r27 = r26.isGeneralAgent();
    L39:
        if (r27 != null) goto L41;
    L44:
        boolean r110 = true;
    L46:
        if ((true ^ r110) == true) goto L49;
        r27 = null;
    L49:
        if (r27 != null) goto L51;
        r27 = "0";
    L51:
        r18.put("is_general_agent", r27);
        OfficeInputParam r28 = r0.getInputParam();
        if (r28 == null) goto L54;
        r3 = r28.getAgentChatId();
    L54:
        if (r3 != null) goto L56;
        r3 = "";
    L56:
        r18.put("chat_id", r3);
        r1.reportToolbarButtonClick(r4, r6, r8, r9, null, "1", r13, r11, r17, r16, r18);
        return Unit.INSTANCE;
    L41:
        if (r27.length() == 0) goto L44;
        r110 = false;
        goto L46
    L37:
        r27 = null;
        goto L39
    L33:
        r25 = null;
        goto L34
    L29:
        r23 = null;
        goto L30
    L25:
        r21 = null;
        goto L26
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
