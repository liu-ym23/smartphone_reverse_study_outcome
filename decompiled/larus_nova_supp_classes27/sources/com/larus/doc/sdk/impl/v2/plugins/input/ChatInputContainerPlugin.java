package com.larus.doc.sdk.impl.v2.plugins.input;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.google.gson.annotations.SerializedName;
import com.larus.doc.sdk.api.SyncedDocInfoSource;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.office.OfficeInputParam;
import com.larus.office.w;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n39.b;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u000f*\u0004\u0018\u00010\u000fH\u0002¨\u0006\u001a"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/input/ChatInputContainerPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/IChatInputFoldStatusListener;", "<init>", "()V", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getChatInputContainer", "Landroid/view/ViewGroup;", "onFoldStatusChanged", "isFold", "", "safeLogId", "Companion", "ChatInputHiddenHandler", "HiddenParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputContainerPlugin extends OfficeDocumentPlugin implements b {
    public static final String BIZ_NOTIFY_STATE_CHANGED = "biz.util.setChatInputHidden";
    public static final Companion Companion = null;
    private static final String TAG = "ChatInputContainerPlugin";

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\fH\u0002¨\u0006\r"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/input/ChatInputContainerPlugin$ChatInputHiddenHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/v2/plugins/input/ChatInputContainerPlugin$HiddenParams;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/input/ChatInputContainerPlugin;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "isRealPageToken", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ChatInputHiddenHandler implements i<HiddenParams> {
        final /* synthetic */ ChatInputContainerPlugin this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public ChatInputHiddenHandler(ChatInputContainerPlugin r1) {
            this.this$0 = r1;
        }

        private final boolean isRealPageToken(String r6) {
            if (r6 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
        L13:
            return false;
        L11:
            if (StringsKt.startsWith$default(r6, "fake_", false, 2, null) == true) goto L13;
            return true;
        L5:
            if (StringsKt.isBlank(r6) == true) goto L8;
            r2 = false;
            goto L9
        }

        public void handle(HiddenParams r5, m r6) {
            FLogger r7 = FLogger.a;
            StringBuilder r0 = new StringBuilder("On chat input hidden params changed, isHidden=");
            String r1 = null;
            if (r5 == null) goto L5;
            Boolean r2 = Boolean.valueOf(r5.isHidden());
        L6:
            r0.append(r2);
            r0.append(", animated=");
            if (r5 == null) goto L9;
            Boolean r3 = Boolean.valueOf(r5.getAnimated());
        L10:
            r0.append(r3);
            r0.append(", pageToken=");
            ChatInputContainerPlugin r4 = this.this$0;
            if (r5 == null) goto L13;
            r1 = r5.getPageToken();
        L13:
            r0.append(ChatInputContainerPlugin.access$safeLogId(r4, r1));
            r7.i(ChatInputContainerPlugin.TAG, r0.toString());
            if (r5 == null) goto L35;
            ChatInputContainerPlugin r8 = this.this$0;
            ChameleonPluginHost r9 = r8.getHost();
            String r10 = "";
            if (r9 == null) goto L19;
            String r11 = x.a(r9);
            if (r11 == null) goto L19;
        L20:
            String r12 = r5.getPageToken();
            if (isRealPageToken(r12) == false) goto L33;
            if (r12 == null) goto L25;
            r10 = r12;
        L25:
            ChameleonPluginHost r13 = r8.getHost();
            if (r13 == null) goto L32;
            w r14 = x.b(r13);
            if (r14 == null) goto L32;
            OfficeInputParam r15 = r14.a;
            if (r15 == null) goto L32;
            r15.setResourceId(r10);
        L32:
            ServiceManager.INSTANCE.getOperationService(r11).onSyncedDocInfo(SyncedDocInfoSource.CHAT_INPUT_HIDDEN);
        L33:
            ServiceManager.INSTANCE.getChatService(r11).setChatInputVisibility(r5.isHidden());
            return;
        L19:
            r11 = "";
            goto L20
        L35:
            return;
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((HiddenParams) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/input/ChatInputContainerPlugin$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_NOTIFY_STATE_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/input/ChatInputContainerPlugin$HiddenParams;", "", "<init>", "()V", "isHidden", "", "()Z", "setHidden", "(Z)V", "animated", "getAnimated", "setAnimated", "pageToken", "", "getPageToken", "()Ljava/lang/String;", "setPageToken", "(Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiddenParams {

        @SerializedName("animated")
        private boolean animated;

        @SerializedName("isHidden")
        private boolean isHidden;

        @SerializedName("pageToken")
        private String pageToken;

        public HiddenParams() {
        }

        public final boolean getAnimated() {
            return this.animated;
        }

        public final String getPageToken() {
            return this.pageToken;
        }

        public final boolean isHidden() {
            return this.isHidden;
        }

        public final void setAnimated(boolean r1) {
            this.animated = r1;
        }

        public final void setHidden(boolean r1) {
            this.isHidden = r1;
        }

        public final void setPageToken(String r1) {
            this.pageToken = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final ViewGroup getChatInputContainer() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        t r1 = r0.getUIContainer();
        if (r1 == null) goto L7;
        return r1.c(this);
    L7:
        return null;
    }

    public ChatInputContainerPlugin() {
    }

    private final String safeLogId(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L14;
        if (r3 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r3.length() + ",hash=" + r3.hashCode();
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_NOTIFY_STATE_CHANGED, new ChatInputHiddenHandler(this));
    }

    @Override // n39.b
    public void onFoldStatusChanged(boolean r4) {
        t r0 = getUIContainer();
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L7;
        View r2 = r0.getContentView();
        if (r2 == null) goto L7;
        ViewGroup r3 = (ViewGroup) r2.findViewById(2131367812);
    L8:
        int r5 = 0;
        if (r4 == false) goto L18;
        if (r3 == null) goto L12;
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
    L14:
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r1 = (ViewGroup.MarginLayoutParams) r6;
    L16:
        if (r1 == null) goto L30;
        r1.topMargin = 0;
        return;
    L30:
        return;
    L12:
        r6 = null;
        goto L14
    L18:
        if (r3 == null) goto L20;
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();
    L22:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r1 = (ViewGroup.MarginLayoutParams) r7;
    L24:
        if (r1 == null) goto L32;
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L28;
        r5 = u.c(r8);
    L28:
        r1.topMargin = r5;
        return;
    L32:
        return;
    L20:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    public static final /* synthetic */ String access$safeLogId(ChatInputContainerPlugin r0, String r1) {
        return r0.safeLogId(r1);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        if (r1 == null) goto L6;
        String r3 = x.a(r1);
        if (r3 == null) goto L6;
    L7:
        ServiceManager.INSTANCE.setChatInputFoldStatusListener(this, r3);
        return;
    L6:
        r3 = "";
        goto L7
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        if (r2 == null) goto L6;
        String r4 = x.a(r2);
        if (r4 == null) goto L6;
    L7:
        ServiceManager.INSTANCE.setChatInputFoldStatusListener(null, r4);
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
}
