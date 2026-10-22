package ia;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e {
    void a(View r1);

    void b(View r1, Bundle r10);

    void onActivityCreated(Bundle r1);

    void onActivityResult(int r1, int r10, Intent r11);

    void onConfigurationChanged(Configuration r1);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void setUserVisibleHint(boolean r1);
}
