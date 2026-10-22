package com.larus.voice_setting.voice.dialog.v2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.dialog.v2.UgcVoiceCreateFragment;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceCreateSharedViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_ugcVoiceCreatePageStatus", "Lcom/larus/utils/livedata/NonStickyLiveData;", "Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceCreateFragment$PageStatus;", "ugcVoiceCreatePageStatus", "Landroidx/lifecycle/LiveData;", "getUgcVoiceCreatePageStatus", "()Landroidx/lifecycle/LiveData;", "_ugcVoiceCreateSpeakerTextVisibility", NameKeys.UnloadStrategy_No_Strategy, "ugcVoiceCreateSpeakerTextVisibility", "getUgcVoiceCreateSpeakerTextVisibility", "_closeUgcVoiceCreateDialog", "closeUgcVoiceCreateDialog", "getCloseUgcVoiceCreateDialog", "updateUgcVoiceCreatePageStatus", NameKeys.UnloadStrategy_No_Strategy, "status", "updateUgcVoiceCreateSpeakerTextVisibility", "isShow", "caller", NameKeys.UnloadStrategy_No_Strategy, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceCreateSharedViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "UgcVoiceCreateSharedViewModel";
    private final NonStickyLiveData<Boolean> _closeUgcVoiceCreateDialog;
    private final NonStickyLiveData<UgcVoiceCreateFragment.PageStatus> _ugcVoiceCreatePageStatus;
    private final NonStickyLiveData<Boolean> _ugcVoiceCreateSpeakerTextVisibility;
    private final LiveData<Boolean> closeUgcVoiceCreateDialog;
    private final LiveData<UgcVoiceCreateFragment.PageStatus> ugcVoiceCreatePageStatus;
    private final LiveData<Boolean> ugcVoiceCreateSpeakerTextVisibility;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UgcVoiceCreateSharedViewModel() {
        NonStickyLiveData<UgcVoiceCreateFragment.PageStatus> r0 = new NonStickyLiveData();
        this._ugcVoiceCreatePageStatus = r0;
        this.ugcVoiceCreatePageStatus = r0;
        NonStickyLiveData<Boolean> r1 = new NonStickyLiveData();
        this._ugcVoiceCreateSpeakerTextVisibility = r1;
        this.ugcVoiceCreateSpeakerTextVisibility = r1;
        NonStickyLiveData<Boolean> r2 = new NonStickyLiveData();
        this._closeUgcVoiceCreateDialog = r2;
        this.closeUgcVoiceCreateDialog = r2;
    }

    public final LiveData<Boolean> getCloseUgcVoiceCreateDialog() {
        return this.closeUgcVoiceCreateDialog;
    }

    public final LiveData<UgcVoiceCreateFragment.PageStatus> getUgcVoiceCreatePageStatus() {
        return this.ugcVoiceCreatePageStatus;
    }

    public final LiveData<Boolean> getUgcVoiceCreateSpeakerTextVisibility() {
        return this.ugcVoiceCreateSpeakerTextVisibility;
    }

    public final void closeUgcVoiceCreateDialog(String r4) {
        Intrinsics.checkNotNullParameter(r4, "caller");
        FLogger.a.i(TAG, "[closeUgcVoiceCreateDialog] caller=" + r4);
        this._closeUgcVoiceCreateDialog.postValue(Boolean.TRUE);
    }

    public final void updateUgcVoiceCreatePageStatus(UgcVoiceCreateFragment.PageStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this._ugcVoiceCreatePageStatus.postValue(r2);
    }

    public final void updateUgcVoiceCreateSpeakerTextVisibility(boolean r2) {
        this._ugcVoiceCreateSpeakerTextVisibility.postValue(Boolean.valueOf(r2));
    }
}
