package com.larus.doc.sdk.impl.generalbiz.state.keyboard;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.HardKeyboardUtils;
import com.google.gson.JsonObject;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.impl.generalbiz.rewrite.PartialRewriteManager;
import com.larus.doc.sdk.impl.generalbiz.state.model.FlowDocStateViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.u;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002+,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0012J\u0010\u0010\u001f\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010 \u001a\u00020\u0019J\n\u0010!\u001a\u00060\u000eR\u00020\u0000J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010*H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0016\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", "<init>", "()V", "keyboardHeight", "", "bottomPanelTop", "keyboardHeightProviderRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "scrollWebViewWhenKeyboardHeightChange", "", "keyBoardStatusChangedHandler", "Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager$KeyBoardStatusChangedHandler;", "updateJSKeyboardStateTask", "Ljava/lang/Runnable;", "toolbarViewModel", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel;", "host", "Lcom/larus/office/base/plugins/IOfficePluginHost;", "hasReferencePanel", "selectTextChangeListener", "Lkotlin/Function3;", "", "", "requestUpdateWebContentHeight", "delay", "", "setDocToolbarViewModel", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "onAttachToHost", "onDetachFromHost", "getKeyboardStatusChangeHandler", "getBottomPanelTop", "view", "Landroid/view/View;", "onKeyboardHeightChanged", "khp", "orientation", "getBottomPanelHeight", "activity", "Landroid/app/Activity;", "KeyBoardStatusChangedHandler", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditPanelsManager extends ViewModel implements KeyboardHeightObserver {
    public static final Companion Companion = null;
    private static final String TAG = "EditPanelsManager";
    private int bottomPanelTop;
    private boolean hasReferencePanel;
    private xm9.a host;
    private KeyBoardStatusChangedHandler keyBoardStatusChangedHandler;
    private int keyboardHeight;
    private WeakReference<KeyboardHeightProvider> keyboardHeightProviderRef;
    private boolean scrollWebViewWhenKeyboardHeightChange;
    private final Function3<String, String, String, Unit> selectTextChangeListener;
    private FlowDocStateViewModel toolbarViewModel;
    private final Runnable updateJSKeyboardStateTask;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u001c\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager$KeyBoardStatusChangedHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Ljava/lang/Void;", "<init>", "(Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager;)V", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "handle", "", "data", "getWebRemainingHeight", "", "view", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "notifyKeyboardChanged", "contentView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class KeyBoardStatusChangedHandler implements BridgeHandlerV2<Void> {
        private CallBackFunction callback;
        final /* synthetic */ EditPanelsManager this$0;

        public KeyBoardStatusChangedHandler(EditPanelsManager r1) {
            this.this$0 = r1;
        }

        private final int getWebRemainingHeight(View r6, Activity r7) {
            int[] r0 = new int[2];
            r6.getLocationOnScreen(r0);
            boolean r1 = true;
            int r2 = r0[1];
            int r3 = EditPanelsManager.access$getBottomPanelTop(this.this$0, r6);
            if (r3 > 0) goto L9;
            View r4 = r6.getRootView().findViewById(R.id.content);
            if (r4 != null) goto L8;
            return -1;
        L8:
            int[] r8 = new int[2];
            r4.getLocationOnScreen(r8);
            r3 = r4.getHeight() + r8[1];
        L9:
            FLogger.a.i(EditPanelsManager.TAG, "getWebRemainingHeight: panelTop " + r3);
            int r5 = r3 - r2;
            FlowDocStateViewModel r9 = EditPanelsManager.access$getToolbarViewModel$p(this.this$0);
            if (r9 == null) goto L14;
            i1<DocMode> r10 = r9.getDocMode();
            if (r10 == null) goto L14;
            DocMode r11 = (DocMode) r10.getValue();
        L16:
            if (r11 != DocMode.NORMAL_EDIT) goto L31;
            FlowDocStateViewModel r12 = EditPanelsManager.access$getToolbarViewModel$p(this.this$0);
            if (r12 != null) goto L20;
        L22:
            r1 = false;
        L23:
            if (r1 == false) goto L36;
            View r13 = r6.getRootView();
            if (r13 == null) goto L29;
            View r14 = r13.findViewById(2131389063);
            if (r14 == null) goto L29;
            int r15 = r14.getHeight();
        L35:
            r5 = r5 - r15;
        L29:
            r15 = i5.l0();
        L36:
            xm9.a r16 = EditPanelsManager.access$getHost$p(this.this$0);
            if (r16 == null) goto L42;
            FragmentActivity r17 = r16.getActivity();
            if (r17 == null) goto L42;
            r5 = r5 - u.b(r17);
        L42:
            return (int) c7.d(Integer.valueOf(r5));
        L20:
            if (r12.hasToolbarData() != true) goto L22;
        L31:
            if (EditPanelsManager.access$getHasReferencePanel$p(this.this$0) == false) goto L33;
            int r18 = 187;
        L34:
            r15 = c7.b(Integer.valueOf(r18));
            goto L35
        L33:
            r18 = 73;
        L14:
            r11 = null;
            goto L16
        }

        public void handle(Void r4, CallBackFunction r5) {
            Intrinsics.checkNotNullParameter(r5, "callback");
            this.callback = r5;
            EditPanelsManager.requestUpdateWebContentHeight$default(this.this$0, 0, 1, null);
        }

        public final void notifyKeyboardChanged(View r7, Activity r8) {
            if (this.callback == null) goto L40;
            Boolean r0 = null;
            if (r7 == null) goto L7;
            View r1 = r7.getRootView();
        L8:
            if (r1 == null) goto L42;
            int r9 = getWebRemainingHeight(r7, r8);
            if (r9 != (-1)) goto L13;
            return;
        L13:
            xm9.a r10 = EditPanelsManager.access$getHost$p(this.this$0);
            if (r10 == null) goto L18;
            FragmentActivity r11 = r10.getActivity();
            if (r11 == null) goto L18;
            Object r12 = r11.getSystemService("input_method");
        L20:
            if ((r12 instanceof InputMethodManager) == false) goto L22;
            InputMethodManager r13 = (InputMethodManager) r12;
        L23:
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("Is keyboard showing? keyboardHeight:");
            r3.append(EditPanelsManager.access$getKeyboardHeight$p(this.this$0));
            r3.append(", inputActive: ");
            if (r13 == null) goto L26;
            r0 = Boolean.valueOf(r13.isActive());
        L26:
            r3.append(r0);
            r2.i(EditPanelsManager.TAG, r3.toString());
            boolean r4 = true;
            if (EditPanelsManager.access$getKeyboardHeight$p(this.this$0) <= 0) goto L29;
            int r14 = 1;
        L30:
            JsonObject r5 = new JsonObject();
            r5.addProperty("isOpenKeyboard", Integer.valueOf(r14));
            FlowDocStateViewModel r15 = EditPanelsManager.access$getToolbarViewModel$p(this.this$0);
            if (r15 != null) goto L33;
        L35:
            r4 = false;
        L36:
            r5.addProperty("toolbar_v2_compat", Boolean.valueOf(r4));
            r5.addProperty("innerHeight", Integer.valueOf(r9));
            r5.addProperty("keyboardType", "editor");
            r2.i(EditPanelsManager.TAG, "Notify js keyboard:" + r5 + " keyboard height:" + EditPanelsManager.access$getKeyboardHeight$p(this.this$0));
            CallBackFunction r16 = this.callback;
            if (r16 == null) goto L41;
            r16.onCallBack(r5);
            return;
        L41:
            return;
        L33:
            if (r15.hasBottomPanel() != true) goto L35;
        L29:
            r14 = 0;
            goto L30
        L22:
            r13 = null;
        L18:
            r12 = null;
            goto L20
        L42:
            return;
        L7:
            r1 = null;
            goto L8
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((Void) r1, r2);
        }

        public static /* synthetic */ void notifyKeyboardChanged$default(KeyBoardStatusChangedHandler r0, View r1, Activity r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = null;
        L5:
            r0.notifyKeyboardChanged(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void Mo(EditPanelsManager r0) {
        updateJSKeyboardStateTask$lambda$0(r0);
    }

    public static /* synthetic */ Unit yo(EditPanelsManager r0, String r1, String r2, String r3) {
        return selectTextChangeListener$lambda$1(r0, r1, r2, r3);
    }

    public final void requestUpdateWebContentHeight() {
        requestUpdateWebContentHeight$default(this, 0, 1, null);
    }

    public final void onDetachFromHost() {
        PartialRewriteManager.INSTANCE.removeSelectedTextChangeListener(this.selectTextChangeListener);
    }

    public EditPanelsManager() {
        this.scrollWebViewWhenKeyboardHeightChange = true;
        this.keyBoardStatusChangedHandler = new KeyBoardStatusChangedHandler(this);
        this.updateJSKeyboardStateTask = new a(this);
        this.selectTextChangeListener = new b(this);
    }

    public final KeyBoardStatusChangedHandler getKeyboardStatusChangeHandler() {
        return this.keyBoardStatusChangedHandler;
    }

    public static final /* synthetic */ boolean access$getHasReferencePanel$p(EditPanelsManager r0) {
        return r0.hasReferencePanel;
    }

    public static final /* synthetic */ xm9.a access$getHost$p(EditPanelsManager r0) {
        return r0.host;
    }

    public static final /* synthetic */ int access$getKeyboardHeight$p(EditPanelsManager r0) {
        return r0.keyboardHeight;
    }

    public static final /* synthetic */ FlowDocStateViewModel access$getToolbarViewModel$p(EditPanelsManager r0) {
        return r0.toolbarViewModel;
    }

    private final int getBottomPanelHeight(Activity r2) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        if (HardKeyboardUtils.hasHardKeyboard(r2) == false) goto L10;
        int r0 = r2.getResources().getConfiguration().orientation;
        return KeyboardHeightProvider.Factory.get(r2).keyBoardRawHeightWithOrientation(r0);
    L10:
        return KeyboardHeightProvider.Factory.get(r2).keyBoardRawHeight();
    }

    private final int getBottomPanelTop(View r4) {
        FlowDocStateViewModel r0 = this.toolbarViewModel;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        View r5 = r4.getRootView().findViewById(2131376823);
        if (r5 == null) goto L20;
        int[] r2 = new int[2];
        r5.getLocationOnScreen(r2);
        return r2[1];
    L20:
        return this.bottomPanelTop;
    L12:
        WeakReference<KeyboardHeightProvider> r6 = this.keyboardHeightProviderRef;
        if (r6 == null) goto L15;
        KeyboardHeightProvider r7 = r6.get();
    L16:
        if (r7 == null) goto L20;
        return r7.getKeyboardTop();
    L15:
        r7 = null;
        goto L16
    L5:
        if (r0.hasBottomPanel() != true) goto L7;
        r1 = true;
        goto L7
    }

    private static final void updateJSKeyboardStateTask$lambda$0(EditPanelsManager r3) {
        KeyBoardStatusChangedHandler r0 = r3.keyBoardStatusChangedHandler;
        xm9.a r1 = r3.host;
        FragmentActivity r2 = null;
        if (r1 == null) goto L5;
        View r4 = r1.getContentView();
    L6:
        xm9.a r5 = r3.host;
        if (r5 == null) goto L9;
        r2 = r5.getActivity();
    L9:
        r0.notifyKeyboardChanged(r4, r2);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onAttachToHost(xm9.a r2) {
        this.host = r2;
        PartialRewriteManager.INSTANCE.addSelectedTextChangeListener(this.selectTextChangeListener);
    }

    public final void requestUpdateWebContentHeight(long r2) {
        MainLooper.removeCallbacks(this.updateJSKeyboardStateTask);
        MainLooper.postDelayed(this.updateJSKeyboardStateTask, r2);
    }

    public final void setDocToolbarViewModel(FlowDocStateViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.toolbarViewModel = r2;
    }

    public static final /* synthetic */ int access$getBottomPanelTop(EditPanelsManager r0, View r1) {
        return r0.getBottomPanelTop(r1);
    }

    public void onKeyboardHeightChanged(KeyboardHeightProvider r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "khp");
        this.keyboardHeight = r4;
        this.bottomPanelTop = r3.getKeyboardTop();
        this.keyboardHeightProviderRef = new WeakReference(r3);
        FLogger.a.i(TAG, "onKeyboardHeightChanged: keyboardHeight = " + r4 + ", bottomPanelTop = " + this.bottomPanelTop);
        if (this.scrollWebViewWhenKeyboardHeightChange == false) goto L6;
        requestUpdateWebContentHeight$default(this, 0, 1, null);
        return;
    }

    public static /* synthetic */ void requestUpdateWebContentHeight$default(EditPanelsManager r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.requestUpdateWebContentHeight(r1);
    }

    private static final Unit selectTextChangeListener$lambda$1(EditPanelsManager r2, String r3, String r4, String r5) {
        r2.hasReferencePanel = o0.d(r3);
        requestUpdateWebContentHeight$default(r2, 0, 1, null);
        return Unit.INSTANCE;
    }
}
