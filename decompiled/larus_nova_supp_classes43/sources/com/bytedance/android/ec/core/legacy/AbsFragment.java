package com.bytedance.android.ec.core.legacy;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import eh.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbsFragment extends Fragment implements a {
    public boolean d;
    public boolean e;

    public void onDestroy() {
        super.onDestroy();
        this.e = true;
    }

    public void onResume() {
        super.onResume();
        this.d = true;
    }

    public void onStop() {
        super.onStop();
        this.d = false;
    }

    public AbsFragment() {
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.d = false;
        this.e = false;
    }

    public void onSaveInstanceState(Bundle r10) {
        if (r10 == null) goto L4;
        r10.putBoolean("WORKAROUND_FOR_BUG_19917_KEY", true);
    L4:
        super.onSaveInstanceState(r10);
    }

    public void onViewCreated(View r1, Bundle r10) {
        super.onViewCreated(r1, r10);
    }
}
