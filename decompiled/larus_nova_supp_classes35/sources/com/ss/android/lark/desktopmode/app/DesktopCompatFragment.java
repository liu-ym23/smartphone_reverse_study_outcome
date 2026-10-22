package com.ss.android.lark.desktopmode.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.desktopmode.base.FragmentParams;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import wab.a;
import wab.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DesktopCompatFragment<T extends FragmentParams> extends Fragment {
    private static final String TAG = "CompatFragment";
    private Context mApplicationContext;
    private a mCallback;
    private String mFragmentInfoId;
    private T mFragmentParams;
    private int mRequestCode;
    private int mResultCode;
    private Intent mResultIntent;

    public a getLifecycleCallback() {
        return null;
    }

    public void onFinish() {
    }

    public boolean onNewArguments(Bundle r1) {
        return false;
    }

    public void onWindowFocusChanged(boolean r1) {
    }

    public void setLifecycleCallback(a r1) {
    }

    private String generateFragmentInfoId() {
        StringBuilder r0 = new StringBuilder();
        int r1 = e.a;
        r0.append(String.valueOf(System.currentTimeMillis() / 1000));
        r0.append("_");
        r0.append(getClass().getName());
        return r0.toString();
    }

    public void onFragmentBringToFront() {
        b.a.a.getClass();
    }

    public DesktopCompatFragment() {
        this.mResultCode = 0;
        this.mRequestCode = -1;
        this.mResultIntent = new Intent();
        this.mFragmentInfoId = generateFragmentInfoId();
        this.mFragmentParams = null;
        this.mApplicationContext = null;
    }

    public final void finish() {
        onFinish();
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (DesktopUtil.a(r0) == false) goto L8;
        b r1 = b.a.a;
        r1.getClass();
        if (this.mRequestCode >= 0) goto L19;
        return;
    L19:
        if (r1.a.remove(getFragmentInfoId()) != null) goto L22;
        return;
    L22:
        throw null;
    L8:
        if (r0.isDestroyed() == false) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L24;
        r0.finish();
        return;
    L24:
        return;
    L10:
        if (r0.isFinishing() == true) goto L12;
        r2 = true;
        goto L13
    }

    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L6;
        Log.i(TAG, new RuntimeException("getContext returns null"));
        return this.mApplicationContext;
    L6:
        return r0;
    }

    public final String getFragmentInfoId() {
        return this.mFragmentInfoId;
    }

    public T getFragmentParams() {
        return this.mFragmentParams;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        if (getContext() == null) goto L6;
        this.mApplicationContext = getContext().getApplicationContext();
        return;
    }

    public void onAttach(Context r1) {
        super.onAttach(r1);
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
    }

    public void setFragmentParams(T r1) {
        this.mFragmentParams = r1;
    }

    public void setRequestCode(int r1) {
        this.mRequestCode = r1;
    }

    public void setResult(int r2) {
        setResult(r2, null);
    }

    public void setResult(int r3, Intent r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        Log.e(getClass().getSimpleName(), "setResult", new IllegalAccessException("getActivity returns null"));
        return;
    L7:
        if (DesktopUtil.a(r0) == false) goto L9;
        this.mResultCode = r3;
        this.mResultIntent = r4;
        return;
    L9:
        r0.setResult(r3, r4);
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return super.onCreateView(r1, r2, r3);
    }
}
