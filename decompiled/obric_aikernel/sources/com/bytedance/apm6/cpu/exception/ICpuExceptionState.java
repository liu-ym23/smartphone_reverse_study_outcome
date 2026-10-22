package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;

/* JADX INFO: loaded from: classes.dex */
public interface ICpuExceptionState {
    void onEnterThisState(CpuExceptionConfig r10, boolean r11);

    void onLifeCycleChange(boolean r10);

    void onStopDetect();

    StateType provideType();
}
