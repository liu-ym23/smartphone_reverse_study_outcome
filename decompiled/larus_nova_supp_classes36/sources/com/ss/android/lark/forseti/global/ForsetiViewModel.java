package com.ss.android.lark.forseti.global;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0014R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/forseti/global/ForsetiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "value", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "forsetiGlobalChainManager", "getForsetiGlobalChainManager", "()Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "setForsetiGlobalChainManager", "(Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;)V", "onCleared", "", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "FST_ViewModel";
    private tua.b forsetiGlobalChainManager;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void onCleared() {
        super.onCleared();
        Log.i(TAG, "ForsetiViewModel onCleard calls.");
    }

    public ForsetiViewModel() {
    }

    public final tua.b getForsetiGlobalChainManager() {
        return this.forsetiGlobalChainManager;
    }

    public final void setForsetiGlobalChainManager(tua.b r2) {
        this.forsetiGlobalChainManager = r2;
        Log.i(TAG, "IForsetiActivityChainManager init");
    }
}
