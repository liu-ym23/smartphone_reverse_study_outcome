package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface LynxRecorderActionCallback {

    /* JADX INFO: renamed from: com.lynx.devtool.recorder.LynxRecorderActionCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onLynxViewDidBuild(LynxRecorderActionCallback r0, LynxView r1, Intent r2, Context r3, ViewGroup r4) {
        }

        public static void $default$onLynxViewWillBuild(LynxRecorderActionCallback r0, LynxRecorderActionManager r1, LynxViewBuilder r2) {
        }

        public static void $default$onReplayFinish(LynxRecorderActionCallback r0, int r1) {
        }

        public static void $default$onTestBenchComplete(LynxRecorderActionCallback r0) {
        }
    }

    void onLynxViewDidBuild(LynxView r1, Intent r2, Context r3, ViewGroup r4);

    void onLynxViewWillBuild(LynxRecorderActionManager r1, LynxViewBuilder r2);

    void onReplayFinish(int r1);

    void onTestBenchComplete();
}
