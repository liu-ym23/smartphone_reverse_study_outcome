package com.bytedance.ai.applet.render.core.camera;

import android.content.Context;
import androidx.camera.view.PreviewView;
import androidx.lifecycle.LifecycleOwner;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    PreviewView A();

    Function1<File, String> F();

    File G();

    Function0<Long> L();

    void m(String r1);

    void onSessionReady();

    void s(int r1, String r10);

    Context u();

    LifecycleOwner w();
}
