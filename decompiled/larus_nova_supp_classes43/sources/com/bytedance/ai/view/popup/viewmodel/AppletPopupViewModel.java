package com.bytedance.ai.view.popup.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/view/popup/viewmodel/AppletPopupViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", a.KEY_LUBAN_VALUE, "Lcom/bytedance/ai/view/popup/AppletPopup$FragmentLifecycleListener;", "mLifeCycleListener", "getMLifeCycleListener", "()Lcom/bytedance/ai/view/popup/AppletPopup$FragmentLifecycleListener;", "setLifeCycleListener", "", "listener", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPopupViewModel extends ViewModel {
    private AppletPopup.b mLifeCycleListener;

    public AppletPopupViewModel() {
    }

    public final AppletPopup.b getMLifeCycleListener() {
        return this.mLifeCycleListener;
    }

    public final void setLifeCycleListener(AppletPopup.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.mLifeCycleListener = r10;
    }
}
