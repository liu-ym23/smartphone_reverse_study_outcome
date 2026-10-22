package com.larus.doc.sdk.impl.generalbiz.state.model;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import r39.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00029:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u0007J\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0014\u0010*\u001a\u00020%2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010\u0019\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0018\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\"2\b\b\u0002\u0010.\u001a\u00020\"J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u001bJ\u000e\u00101\u001a\u00020%2\u0006\u0010)\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u000bJ\"\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0016J\u0006\u00108\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", "<init>", "()V", "_toolbarData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocToolbar;", "_keyboardHeightLiveData", "", "_toolbarActive", "", "_fileInsertActive", "fileInsertActive", "Lkotlinx/coroutines/flow/StateFlow;", "getFileInsertActive", "()Lkotlinx/coroutines/flow/StateFlow;", "setFileInsertActive", "(Lkotlinx/coroutines/flow/StateFlow;)V", "_keyboardShow", "keyboardShow", "getKeyboardShow", "setKeyboardShow", "_isInEditMode", "isInEditMode", "setInEditMode", "editPanelDelegate", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel$EditPanelDelegate;", "_docMode", "Lcom/larus/doc/sdk/api/model/DocMode;", "docMode", "getDocMode", "setDocMode", "triggerSource", "", "keyboardBtnClickListener", "Lkotlin/Function0;", "", "updateToolbarData", "toolbarData", "setToolbarActive", "active", "registerKeyboardBtnClickListener", "listener", "toggleToolbarItemState", "id", "docLogicKey", "setEditPanelDelegate", "delegate", "setPhotoInsertActive", "hasBottomPanel", "onKeyboardHeightChanged", "khp", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "hasToolbarData", "Companion", "EditPanelDelegate", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocStateViewModel extends ViewModel implements KeyboardHeightObserver {
    public static final Companion Companion = null;
    private static final String TAG = "FlowDocToolbarViewModel";
    private z0<DocMode> _docMode;
    private z0<Boolean> _fileInsertActive;
    private z0<Boolean> _isInEditMode;
    private final z0<Integer> _keyboardHeightLiveData;
    private z0<Boolean> _keyboardShow;
    private z0<Boolean> _toolbarActive;
    private z0<FlowDocToolbar> _toolbarData;
    private i1<? extends DocMode> docMode;
    private EditPanelDelegate editPanelDelegate;
    private i1<Boolean> fileInsertActive;
    private i1<Boolean> isInEditMode;
    private Function0<Unit> keyboardBtnClickListener;
    private i1<Boolean> keyboardShow;
    private String triggerSource;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel$EditPanelDelegate;", "", "onMenuItemClicked", "", "id", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface EditPanelDelegate {
        void onMenuItemClicked(String r1);
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void yo(KeyboardHeightProvider r0, FlowDocStateViewModel r1) {
        onKeyboardHeightChanged$lambda$0(r0, r1);
    }

    public final boolean hasBottomPanel() {
        return ((Boolean) this.fileInsertActive.getValue()).booleanValue();
    }

    public final boolean hasToolbarData() {
        FlowDocToolbar r0 = (FlowDocToolbar) this._toolbarData.getValue();
        if (r0 == null) goto L12;
        List<DocToolbarItem> r1 = r0.getToolbarItems();
        if (r1 == null) goto L13;
        List r2 = CollectionsKt.filterNotNull(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r2.isEmpty() == true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public FlowDocStateViewModel() {
        this._toolbarData = j1.a(null);
        this._keyboardHeightLiveData = j1.a(0);
        Boolean r0 = Boolean.FALSE;
        this._toolbarActive = j1.a(r0);
        StateFlowImpl r1 = j1.a(r0);
        this._fileInsertActive = r1;
        this.fileInsertActive = e.b(r1);
        StateFlowImpl r2 = j1.a(r0);
        this._keyboardShow = r2;
        this.keyboardShow = e.b(r2);
        StateFlowImpl r3 = j1.a(r0);
        this._isInEditMode = r3;
        this.isInEditMode = e.b(r3);
        StateFlowImpl r4 = j1.a(DocMode.READ_ONLY);
        this._docMode = r4;
        this.docMode = e.b(r4);
        this.triggerSource = "unknown";
    }

    public final i1<DocMode> getDocMode() {
        return this.docMode;
    }

    public final i1<Boolean> getFileInsertActive() {
        return this.fileInsertActive;
    }

    public final i1<Boolean> getKeyboardShow() {
        return this.keyboardShow;
    }

    public final i1<Boolean> isInEditMode() {
        return this.isInEditMode;
    }

    public final void registerKeyboardBtnClickListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.keyboardBtnClickListener = r2;
    }

    public final void setDocMode(DocMode r2) {
        Intrinsics.checkNotNullParameter(r2, "docMode");
        this._docMode.tryEmit(r2);
    }

    public final void setEditPanelDelegate(EditPanelDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.editPanelDelegate = r2;
    }

    public final void setFileInsertActive(i1<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileInsertActive = r2;
    }

    public final void setInEditMode(boolean r2) {
        this._isInEditMode.tryEmit(Boolean.valueOf(r2));
    }

    public final void setKeyboardShow(i1<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.keyboardShow = r2;
    }

    public final void setPhotoInsertActive(boolean r2) {
        this._fileInsertActive.tryEmit(Boolean.valueOf(r2));
    }

    public final void setToolbarActive(boolean r2) {
        this._toolbarActive.tryEmit(Boolean.valueOf(r2));
    }

    public final void updateToolbarData(FlowDocToolbar r6) {
        this._toolbarData.tryEmit(r6);
        List r0 = null;
        if (r6 == null) goto L7;
        List<DocToolbarItem> r1 = r6.getToolbarItems();
        if (r1 == null) goto L7;
        List r2 = CollectionsKt.filterNotNull(r1);
    L8:
        List r3 = r2;
        boolean r4 = false;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
    L19:
        boolean r7 = false;
    L20:
        this._toolbarActive.tryEmit(Boolean.valueOf(r7));
        if (r6 == null) goto L25;
        List<DocToolbarItem> r8 = r6.getToolbarItems();
        if (r8 == null) goto L25;
        r0 = CollectionsKt.filterNotNull(r8);
    L25:
        List r9 = r0;
        if (r9 != null) goto L28;
    L29:
        r4 = true;
    L30:
        if (r4 == false) goto L33;
        this._fileInsertActive.tryEmit(Boolean.FALSE);
        return;
    L33:
        return;
    L28:
        if (r9.isEmpty() == false) goto L30;
    L17:
        if (this._docMode.getValue() != DocMode.NORMAL_EDIT) goto L19;
        r7 = true;
        goto L20
    L11:
        if (r3.isEmpty() == true) goto L14;
        r5 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final void setDocMode(i1<? extends DocMode> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docMode = r2;
    }

    public final void setInEditMode(i1<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isInEditMode = r2;
    }

    private static final void onKeyboardHeightChanged$lambda$0(KeyboardHeightProvider r2, FlowDocStateViewModel r3) {
        StringBuilder r0 = new StringBuilder("resetToolbar isKeyboardShowing :");
        Intrinsics.checkNotNull(r2);
        r0.append(r2.isKeyboardShowing());
        r0.append("; ");
        r0.append(r3.hasToolbarData());
        Log.i(TAG, r0.toString());
        boolean r1 = true;
        if (r2.isKeyboardShowing() == true) goto L6;
        r1 = false;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        if (r3.hasToolbarData() == true) goto L12;
        r3.updateToolbarData((FlowDocToolbar) r3._toolbarData.getValue());
        return;
    }

    public final boolean toggleToolbarItemState(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "docLogicKey");
        DocToolbarItemId r0 = DocToolbarItemId.INSTANCE;
        if (Intrinsics.areEqual(r4, r0.getVOICE_INPUT()) == false) goto L11;
        ServiceManager r6 = ServiceManager.INSTANCE;
        i1<Boolean> r1 = r6.getChatService(r5).getVoiceInputStatus();
        if (r1 == null) goto L7;
        boolean r2 = ((Boolean) r1.getValue()).booleanValue();
    L8:
        boolean r3 = !r2;
        r6.getChatService(r5).setEnableVoiceInput(r3, this.triggerSource);
        this._fileInsertActive.tryEmit(Boolean.FALSE);
        this._keyboardShow.tryEmit(Boolean.TRUE);
        return r3;
    L7:
        r2 = false;
        goto L8
    L11:
        if (Intrinsics.areEqual(r4, r0.getFILE_INSERT()) == false) goto L14;
        boolean r7 = !((Boolean) this._fileInsertActive.getValue()).booleanValue();
        this._fileInsertActive.tryEmit(Boolean.valueOf(r7));
        this._keyboardShow.tryEmit(Boolean.valueOf(!r7));
        return r7;
    L14:
        this._fileInsertActive.tryEmit(Boolean.FALSE);
        return true;
    }

    public void onKeyboardHeightChanged(final KeyboardHeightProvider r3, int r4, int r5) {
        this._keyboardHeightLiveData.tryEmit(Integer.valueOf(r4));
        if (r4 != 0) goto L6;
        MainLooper.postDelayed(new a(r3, this), 100);
        return;
    }

    public static /* synthetic */ boolean toggleToolbarItemState$default(FlowDocStateViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "default_doc_logic_key";
    L6:
        return r0.toggleToolbarItemState(r1, r2);
    }
}
