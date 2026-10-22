package com.larus.doc.sdk.impl.generalbiz.state;

import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.common.FlowJsCaller;
import com.larus.doc.sdk.impl.generalbiz.state.keyboard.EditPanelsManager;
import com.larus.doc.sdk.impl.generalbiz.state.model.DocToolbarItemId;
import com.larus.doc.sdk.impl.generalbiz.state.model.FlowDocStateViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import n39.o;
import xm9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/ToolbarProcessor;", "Lcom/larus/doc/sdk/api/IToolbarService;", "toolbarViewModel", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel;", "editPanelsManager", "Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager;", "host", "Lcom/larus/office/base/plugins/IOfficePluginHost;", "docSdkVersion", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "<init>", "(Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel;Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager;Lcom/larus/office/base/plugins/IOfficePluginHost;Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;)V", "switchToNormalEditMode", "", "switchToReadOnlyMode", "notifyMoreAction", "type", "", "switchToAiEditMode", "docLogicKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarProcessor implements o {
    public static final Companion Companion = null;
    private static final String PLUGIN_TAG = "FlowDocToolbarPlugin";
    private final DocSdkVersion docSdkVersion;
    private final EditPanelsManager editPanelsManager;
    private final a host;
    private final FlowDocStateViewModel toolbarViewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/ToolbarProcessor$Companion;", "", "<init>", "()V", "PLUGIN_TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // n39.o
    public void switchToNormalEditMode() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("switchToNormalEditMode, current in edit mode: ");
        FlowDocStateViewModel r2 = this.toolbarViewModel;
        Boolean r3 = null;
        if (r2 == null) goto L7;
        i1<Boolean> r4 = r2.isInEditMode();
        if (r4 == null) goto L7;
        Boolean r5 = (Boolean) r4.getValue();
    L8:
        r1.append(r5);
        r1.append("，hasToolbarDta: ");
        FlowDocStateViewModel r6 = this.toolbarViewModel;
        if (r6 == null) goto L11;
        r3 = Boolean.valueOf(r6.hasToolbarData());
    L11:
        r1.append(r3);
        r0.i(PLUGIN_TAG, r1.toString());
        FlowDocStateViewModel r7 = this.toolbarViewModel;
        boolean r8 = false;
        if (r7 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L32;
        FlowDocStateViewModel r10 = this.toolbarViewModel;
        if (r10 == null) goto L25;
        i1<Boolean> r11 = r10.isInEditMode();
        if (r11 == null) goto L25;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L25;
        r8 = true;
    L25:
        if (r8 == false) goto L32;
        FlowDocStateViewModel r12 = this.toolbarViewModel;
        if (r12 == null) goto L29;
        r12.setToolbarActive(true);
    L29:
        FlowDocStateViewModel r13 = this.toolbarViewModel;
        if (r13 == null) goto L36;
        r13.setDocMode(DocMode.NORMAL_EDIT);
        return;
    L36:
        return;
    L32:
        FlowDocStateViewModel r14 = this.toolbarViewModel;
        if (r14 == null) goto L38;
        r14.setDocMode(DocMode.READ_ONLY);
        return;
    L38:
        return;
    L14:
        if (r7.hasToolbarData() != true) goto L16;
        r9 = true;
    L7:
        r5 = null;
        goto L8
    }

    @Override // n39.o
    public void switchToReadOnlyMode() {
        KeyBoardUtils.hideKeyboard(this.host.getActivity());
        FlowDocStateViewModel r0 = this.toolbarViewModel;
        if (r0 == null) goto L6;
        r0.setDocMode(DocMode.READ_ONLY);
        return;
    }

    @Override // n39.o
    public void notifyMoreAction(String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        FlowJsCaller.INSTANCE.notifyMoreAction(this.host.getWebView(), r4, this.docSdkVersion);
    }

    public final void switchToAiEditMode(String r3) {
        Intrinsics.checkNotNullParameter(r3, "docLogicKey");
        FlowDocStateViewModel r0 = this.toolbarViewModel;
        if (r0 == null) goto L5;
        r0.setToolbarActive(false);
    L5:
        FlowDocStateViewModel r1 = this.toolbarViewModel;
        if (r1 == null) goto L8;
        r1.toggleToolbarItemState(DocToolbarItemId.INSTANCE.getALL(), r3);
    L8:
        FlowDocStateViewModel r4 = this.toolbarViewModel;
        if (r4 == null) goto L11;
        r4.setDocMode(DocMode.AI_EDIT);
    L11:
        this.editPanelsManager.requestUpdateWebContentHeight(36);
    }

    public ToolbarProcessor(FlowDocStateViewModel r2, EditPanelsManager r3, a r4, DocSdkVersion r5) {
        Intrinsics.checkNotNullParameter(r3, "editPanelsManager");
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, "docSdkVersion");
        this.toolbarViewModel = r2;
        this.editPanelsManager = r3;
        this.host = r4;
        this.docSdkVersion = r5;
    }

    public static /* synthetic */ void switchToAiEditMode$default(ToolbarProcessor r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "default_doc_logic_key";
    L5:
        r0.switchToAiEditMode(r1);
    }
}
