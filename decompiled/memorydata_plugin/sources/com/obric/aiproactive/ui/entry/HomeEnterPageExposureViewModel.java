package com.obric.aiproactive.ui.entry;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "coordinator", "Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureCoordinator;", "getCoordinator", "()Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureCoordinator;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeEnterPageExposureViewModel extends ViewModel {
    private final h coordinator;

    public HomeEnterPageExposureViewModel() {
        this.coordinator = new h();
    }

    public final h getCoordinator() {
        return this.coordinator;
    }
}
