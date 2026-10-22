package com.larus.avlink.env.diary.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/larus/avlink/env/diary/settings/DoraEnvObserveDiarySettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_insertPhotoEnabled", "Landroidx/lifecycle/MutableLiveData;", "", "insertPhotoEnabled", "Landroidx/lifecycle/LiveData;", "getInsertPhotoEnabled", "()Landroidx/lifecycle/LiveData;", "loadSettings", "", "fetchDiaryImageSwitch", "setInsertPhotoEnabled", "enabled", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiarySettingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<Boolean> _insertPhotoEnabled;
    private final LiveData<Boolean> insertPhotoEnabled;

    public static /* synthetic */ Unit yo(DoraEnvObserveDiarySettingsViewModel r0, boolean r1) {
        return fetchDiaryImageSwitch$lambda$0(r0, r1);
    }

    private final void fetchDiaryImageSwitch() {
        DiaryImageSwitchManager.a.c(new g(this));
    }

    public DoraEnvObserveDiarySettingsViewModel() {
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        this._insertPhotoEnabled = r0;
        this.insertPhotoEnabled = r0;
    }

    public final LiveData<Boolean> getInsertPhotoEnabled() {
        return this.insertPhotoEnabled;
    }

    public final void loadSettings() {
        fetchDiaryImageSwitch();
    }

    public final void setInsertPhotoEnabled(boolean r3) {
        this._insertPhotoEnabled.setValue(Boolean.valueOf(r3));
        DiaryImageSwitchManager r0 = DiaryImageSwitchManager.a;
        DiaryImageSwitchManager.d(r3);
    }

    private static final Unit fetchDiaryImageSwitch$lambda$0(DoraEnvObserveDiarySettingsViewModel r0, boolean r1) {
        r0._insertPhotoEnabled.setValue(Boolean.valueOf(r1));
        return Unit.INSTANCE;
    }
}
