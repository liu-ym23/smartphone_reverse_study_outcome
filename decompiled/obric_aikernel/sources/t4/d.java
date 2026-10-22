package t4;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    void onActivityCreated(Activity r10, Bundle r11);

    void onActivityPause(Activity r10);

    void onActivityResume(Activity r10);

    void onActivityStarted(Activity r10);

    void onBackground(Activity r10);

    void onChange(Activity r10, Fragment r11);

    void onFront(Activity r10);
}
