package k9;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a();

    long getAutoSwitchIntervalMs();

    LiveData<Integer> getSelectedPosition();
}
