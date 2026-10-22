package com.obric.assistant.settings;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/settings/LocalDataSearchConfirmViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", WindowEvent.Params.RESULT, "Landroidx/lifecycle/MutableLiveData;", "", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "setResult", "(Landroidx/lifecycle/MutableLiveData;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalDataSearchConfirmViewModel extends ViewModel {
    private MutableLiveData<Boolean> result;

    public LocalDataSearchConfirmViewModel() {
    }

    public final MutableLiveData<Boolean> getResult() {
        return this.result;
    }

    public final void setResult(MutableLiveData<Boolean> r1) {
        this.result = r1;
    }
}
