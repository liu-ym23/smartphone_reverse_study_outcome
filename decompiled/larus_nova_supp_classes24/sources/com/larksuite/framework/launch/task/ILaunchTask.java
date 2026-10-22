package com.larksuite.framework.launch.task;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface ILaunchTask<T> {
    void a(Context r1);

    int c();

    Period d();

    List<Class<? extends ILaunchTask>> e();

    String f();

    boolean g();
}
