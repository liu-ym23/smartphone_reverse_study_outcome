package com.bytedance.als.ui.state;

import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class StateContainer<STATE> {
    public final STATE a;

    public StateContainer(STATE r10) {
        this.a = r10;
        new Handler(Looper.getMainLooper());
        new ArrayMap();
        Intrinsics.checkNotNullParameter(new StateContainer$stateLiveState$1(this), "getValueCallable");
        new ArrayList();
        new HashMap();
        new HashMap();
        new HashMap();
    }
}
