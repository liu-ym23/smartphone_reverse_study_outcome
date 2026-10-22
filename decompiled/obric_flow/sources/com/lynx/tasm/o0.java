package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 extends j implements com.lynx.tasm.behavior.k {
    public void loadImage(Context r5, String r10, String r11, float r12, float r13, Transformer r14, com.lynx.tasm.behavior.j r15) {
    }

    public void onCallJSBFinished(Map<String, Object> r5) {
    }

    public void onDataUpdated() {
    }

    public void onDestroy() {
    }

    @Deprecated
    public void onDynamicComponentPerfReady(HashMap<String, Object> r5) {
    }

    public void onFirstLoadPerfReady(y r5) {
    }

    public void onFirstScreen() {
    }

    public void onFling(n0 r5) {
    }

    public void onFlushFinish(m0 r5) {
    }

    public void onJSBInvoked(Map<String, Object> r5) {
    }

    public void onKeyEvent(KeyEvent r5, boolean r10) {
    }

    public void onLoadFailed(String r5) {
    }

    public void onLoadSuccess() {
    }

    public void onLynxEvent(on.d r5) {
    }

    public void onLynxViewAndJSRuntimeDestroy() {
    }

    @Override // com.lynx.tasm.j
    public void onModuleMethodInvoked(String r5, String r10, int r11) {
    }

    public void onPageStart(String r5) {
    }

    public void onPageUpdate() {
    }

    public void onPiperInvoked(Map<String, Object> r5) {
    }

    @Override // com.lynx.tasm.j
    public void onReceivedError(LynxError r5) {
    }

    public void onReceivedJSError(LynxError r5) {
    }

    public void onReceivedJavaError(LynxError r5) {
    }

    public void onReceivedNativeError(LynxError r5) {
    }

    public void onReportComponentInfo(Set r5) {
    }

    public void onRuntimeReady() {
    }

    public void onScrollStart(n0 r5) {
    }

    public void onScrollStop(n0 r5) {
    }

    public void onTASMFinishedByNative() {
    }

    public void onTemplateBundleReady(@NonNull TemplateBundle r5) {
    }

    public void onTimingSetup(Map r5) {
    }

    public void onTimingUpdate(Map r5, Map r10, String r11) {
    }

    public void onUpdateDataWithoutChange() {
    }

    public void onUpdatePerfReady(y r5) {
    }

    public String shouldRedirectImageUrl(String r5) {
        return null;
    }

    @Deprecated
    public void onReceivedError(String r5) {
    }
}
