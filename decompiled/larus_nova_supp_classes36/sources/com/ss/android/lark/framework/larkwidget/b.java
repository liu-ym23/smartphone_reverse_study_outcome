package com.ss.android.lark.framework.larkwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {
    <T extends ViewModel> T a(String r1, Class<T> r2, ViewModelProvider.Factory r3);

    <T extends c> T b(Class<? extends c> r1);

    Activity getActivity();

    Context getContext();

    Fragment getHostFragment();

    void startActivity(Intent r1);

    void startActivity(Intent r1, Bundle r2);

    void startActivityForResult(Intent r1, int r2);

    void startActivityForResult(Intent r1, int r2, Bundle r3);
}
