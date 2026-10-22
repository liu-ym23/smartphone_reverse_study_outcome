package com.larus.voice_setting.voice.dialog.v2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.larus.voice_setting.voice.l2;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_nav", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel$Action;", "nav", "Lkotlinx/coroutines/flow/SharedFlow;", "getNav", "()Lkotlinx/coroutines/flow/SharedFlow;", "_voiceCheckSuccess", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/VoiceCheckSuccessData;", "voiceCheckSuccess", "Landroidx/lifecycle/LiveData;", "getVoiceCheckSuccess", "()Landroidx/lifecycle/LiveData;", "goTo", NameKeys.UnloadStrategy_No_Strategy, "action", "clickAuthorize", "filePath", NameKeys.UnloadStrategy_No_Strategy, "freeTalkContent", "Companion", "Action", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "UgcVoiceFlowViewModel";
    private final MutableSharedFlow<Action> _nav;
    private final MutableLiveData<u2a.a> _voiceCheckSuccess;
    private final d1<Action> nav;
    private final LiveData<u2a.a> voiceCheckSuccess;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel$Action;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "Authorize", "Create", "Close", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        public static final Action Authorize = null;
        public static final Action Close = null;
        public static final Action Create = null;
        public static final /* synthetic */ Action[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Action> getEntries() {
            return b;
        }

        static {
            Action r0 = new Action("Authorize", 0);
            Authorize = r0;
            Action r1 = new Action("Create", 1);
            Create = r1;
            Action r3 = new Action("Close", 2);
            Close = r3;
            Action[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public Action(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void clickAuthorize() {
        FLogger.a.i(TAG, "clickAuthorize");
        l2.b.storeBoolean(l2.a, true);
        UgcVoiceLoader r0 = UgcVoiceLoader.a;
        UgcVoiceLoader.p();
    }

    public UgcVoiceViewModel() {
        MutableSharedFlow<Action> r0 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._nav = r0;
        this.nav = e.a(r0);
        MutableLiveData<u2a.a> r1 = new MutableLiveData();
        this._voiceCheckSuccess = r1;
        this.voiceCheckSuccess = r1;
    }

    public final d1<Action> getNav() {
        return this.nav;
    }

    public final LiveData<u2a.a> getVoiceCheckSuccess() {
        return this.voiceCheckSuccess;
    }

    public final void goTo(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this._nav.tryEmit(r2);
    }

    public final void voiceCheckSuccess(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Intrinsics.checkNotNullParameter(r5, "freeTalkContent");
        FLogger.a.i(TAG, "voiceCheckSuccess: filePath=" + r4 + ", freeTalkContent=" + r5);
        this._voiceCheckSuccess.postValue(new u2a.a(r4, r5));
    }
}
