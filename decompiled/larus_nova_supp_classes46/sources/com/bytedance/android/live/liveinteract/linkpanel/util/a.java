package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.linkpanel.util.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a<T extends c, DATA> {
    View a(Context r1, ViewGroup r2);

    T b();

    String c();

    void d(View r1, Function1<? super View, Unit> r2);
}
