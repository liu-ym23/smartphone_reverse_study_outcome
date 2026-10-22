package com.obric.memorydata.ui.settingpage.viewmodel;

import androidx.lifecycle.ViewModel;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/ui/settingpage/viewmodel/SettingPageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "memoryStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/ui/settingpage/viewmodel/SettingUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "notifyInstantEntityIndexCheckedChange", "", "isChecked", "notifyIsOnScreenUseClientOcrSwitchOn", "notifyIsOnAvoidDataImportSwitchOn", "Companion", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SettingPageViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "SettingPageViewModel";
    private final ae<com.obric.memorydata.ui.settingpage.viewmodel.a> _uiState;
    private final IStore memoryStore;
    private final ar<com.obric.memorydata.ui.settingpage.viewmodel.a> uiState;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ui/settingpage/viewmodel/SettingPageViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public SettingPageViewModel() {
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        this.memoryStore = r0;
        ae<com.obric.memorydata.ui.settingpage.viewmodel.a> r1 = at.a(new com.obric.memorydata.ui.settingpage.viewmodel.a(r0.getBoolean("is_instant_entity_index_switch_on", false), r0.getBoolean("is_on_screen_use_client_ocr_switch_on", false), r0.getBoolean("is_on_avoid_data_import_switch_on", false)));
        this._uiState = r1;
        this.uiState = k.a(r1);
    }

    public final ar<com.obric.memorydata.ui.settingpage.viewmodel.a> getUiState() {
        return this.uiState;
    }

    public final boolean notifyInstantEntityIndexCheckedChange(boolean r10) {
        if (((com.obric.memorydata.ui.settingpage.viewmodel.a) ZeusTransformUtils.preCheckCast(this._uiState.c(), com.obric.memorydata.ui.settingpage.viewmodel.a.class, "com.obric.memorydata.plugin")).a() == r10) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "is_instant_entity_index_switch_on value change, now is " + r10, false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_instant_entity_index_switch_on", r10);
        ae<com.obric.memorydata.ui.settingpage.viewmodel.a> r9 = this._uiState;
    L5:
        com.obric.memorydata.ui.settingpage.viewmodel.a r0 = r9.c();
        if (r9.a(r0, com.obric.memorydata.ui.settingpage.viewmodel.a.a((com.obric.memorydata.ui.settingpage.viewmodel.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ui.settingpage.viewmodel.a.class, "com.obric.memorydata.plugin"), r10, false, false, 6, null)) == false) goto L5;
        PersonalContextAPI.INSTANCE.notifyForceIndexStateChange();
        return true;
    L9:
        return false;
    }

    public final boolean notifyIsOnAvoidDataImportSwitchOn(boolean r10) {
        if (((com.obric.memorydata.ui.settingpage.viewmodel.a) ZeusTransformUtils.preCheckCast(this._uiState.c(), com.obric.memorydata.ui.settingpage.viewmodel.a.class, "com.obric.memorydata.plugin")).c() == r10) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "is_on_screen_use_client_ocr_switch_on value change, now is " + r10, false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_on_avoid_data_import_switch_on", r10);
        ae<com.obric.memorydata.ui.settingpage.viewmodel.a> r9 = this._uiState;
    L5:
        com.obric.memorydata.ui.settingpage.viewmodel.a r0 = r9.c();
        if (r9.a(r0, com.obric.memorydata.ui.settingpage.viewmodel.a.a((com.obric.memorydata.ui.settingpage.viewmodel.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ui.settingpage.viewmodel.a.class, "com.obric.memorydata.plugin"), false, false, r10, 3, null)) == false) goto L5;
        return true;
    L9:
        return false;
    }

    public final boolean notifyIsOnScreenUseClientOcrSwitchOn(boolean r10) {
        if (((com.obric.memorydata.ui.settingpage.viewmodel.a) ZeusTransformUtils.preCheckCast(this._uiState.c(), com.obric.memorydata.ui.settingpage.viewmodel.a.class, "com.obric.memorydata.plugin")).b() == r10) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "is_on_screen_use_client_ocr_switch_on value change, now is " + r10, false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_on_screen_use_client_ocr_switch_on", r10);
        ae<com.obric.memorydata.ui.settingpage.viewmodel.a> r9 = this._uiState;
    L5:
        com.obric.memorydata.ui.settingpage.viewmodel.a r0 = r9.c();
        if (r9.a(r0, com.obric.memorydata.ui.settingpage.viewmodel.a.a((com.obric.memorydata.ui.settingpage.viewmodel.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ui.settingpage.viewmodel.a.class, "com.obric.memorydata.plugin"), false, r10, false, 5, null)) == false) goto L5;
        return true;
    L9:
        return false;
    }
}
