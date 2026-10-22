package fo1;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface i {
    FragmentManager getChildFragmentManager();

    boolean isAdded();

    void setArguments(Bundle r1);

    void show(FragmentManager r1, String r2);
}
