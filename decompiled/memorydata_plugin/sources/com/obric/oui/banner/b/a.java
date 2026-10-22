package com.obric.oui.banner.b;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/oui/banner/interfaces/BannerOperator;", "", "autoSwitchIntervalMs", "", "getAutoSwitchIntervalMs", "()J", "selectedPosition", "Landroidx/lifecycle/LiveData;", "", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "currentItemPlayDone", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {
    void e();

    long getAutoSwitchIntervalMs();

    LiveData<Integer> getSelectedPosition();
}
