package com.obric.sva.framework.wrapper;

import android.hardware.soundtrigger.SoundTrigger;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SoundTriggerWrapper$StatusListenerWrapper {
    public SoundTrigger.StatusListener statusListener;

    public void onModelUnloadedExt(int r1) {
    }

    public void onRecognitionExt(SoundTriggerWrapper.RecognitionEventWrapper r1) {
    }

    public void onResourcesAvailableExt() {
    }

    public void onServiceDiedExt() {
    }

    public SoundTriggerWrapper$StatusListenerWrapper() {
        this.statusListener = new AnonymousClass1(this);
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return SoundTrigger.StatusListener.class;
    }
}
