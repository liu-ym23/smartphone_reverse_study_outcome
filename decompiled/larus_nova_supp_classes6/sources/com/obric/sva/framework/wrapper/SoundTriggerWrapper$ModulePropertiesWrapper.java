package com.obric.sva.framework.wrapper;

import android.hardware.soundtrigger.SoundTrigger;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class SoundTriggerWrapper$ModulePropertiesWrapper {
    private SoundTrigger.ModuleProperties moduleProperties;

    public int getId() {
        return this.moduleProperties.getId();
    }

    public boolean isConcurrentCaptureSupported() {
        SoundTrigger.ModuleProperties r0 = this.moduleProperties;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isConcurrentCaptureSupported();
    }

    public String toString() {
        return this.moduleProperties.toString();
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return SoundTrigger.ModuleProperties.class;
    }

    public SoundTrigger.ModuleProperties getModuleProperties() {
        return this.moduleProperties;
    }

    public SoundTriggerWrapper$ModulePropertiesWrapper(SoundTrigger.ModuleProperties r1) {
        this.moduleProperties = r1;
    }
}
