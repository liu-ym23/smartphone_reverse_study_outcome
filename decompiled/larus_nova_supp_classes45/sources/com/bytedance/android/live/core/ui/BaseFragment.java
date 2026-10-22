package com.bytedance.android.live.core.ui;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Map;
import tw2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BaseFragment extends Fragment implements b {
    private final CompositeDisposable compositeDisposable;
    protected boolean mStatusActive;
    protected boolean mStatusDestroyed;
    protected boolean mStatusViewValid;

    public Map<String, Object> getEnvData() {
        return null;
    }

    public Map<String, Object> getPropertyParams() {
        return null;
    }

    public String getSpm() {
        return null;
    }

    public boolean isIgnored() {
        return false;
    }

    public BaseFragment() {
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mStatusViewValid = false;
        this.mStatusDestroyed = true;
        this.compositeDisposable.clear();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mStatusViewValid = false;
    }

    public void onPause() {
        super.onPause();
        this.mStatusActive = false;
    }

    public void onResume() {
        super.onResume();
        this.mStatusActive = true;
        if (v.a() == false) goto L9;
        FragmentActivity r0 = getActivity();
        WeakReference r1 = d.a;
        if (v.a() == false) goto L10;
        if (r0 == null) goto L11;
        d.a = new WeakReference(r0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean isActive() {
        return this.mStatusActive;
    }

    public boolean isDestroyed() {
        return this.mStatusDestroyed;
    }

    public boolean isViewValid() {
        return this.mStatusViewValid;
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
    }

    public void register(Disposable r2) {
        this.compositeDisposable.add(r2);
    }

    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mStatusViewValid = true;
    }
}
