package com.larus.platform.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface u0 {
    void a(Activity r1, Bundle r2);

    void attachBaseContext(Context r1);

    void b(Activity r1, Bundle r2);

    kotlinx.coroutines.flow.i1<Boolean> c();

    void d(Activity r1, boolean r2);

    void onCreate();

    void onDestroy();
}
