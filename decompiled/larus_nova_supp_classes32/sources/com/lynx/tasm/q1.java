package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class q1 extends p implements com.lynx.tasm.behavior.m {

    public static class a {
    }

    public static class b {
        public final View a;
        public final String b;
        public final String c;

        public final String toString() {
            return String.format("ViewInfo @%d view %s, name %s, monitor-name %s", new Object[]{Integer.valueOf(hashCode()), this.a.getClass().getSimpleName(), this.b, this.c});
        }

        public b(View r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.lynx.tasm.behavior.m
    public void loadImage(Context r1, String r2, String r3, float r4, float r5, Transformer r6, com.lynx.tasm.behavior.m.a r7) {
    }

    public void onCallJSBFinished(Map<String, Object> r1) {
    }

    public void onDataUpdated() {
    }

    public void onDestroy() {
    }

    public void onDynamicComponentPerfReady(HashMap<String, Object> r1) {
    }

    public void onFirstLoadPerfReady(v0 r1) {
    }

    public void onFirstScreen() {
    }

    public void onFling(b r1) {
    }

    public void onFlushFinish(a r1) {
    }

    public void onJSBInvoked(Map<String, Object> r1) {
    }

    public void onKeyEvent(KeyEvent r1, boolean r2) {
    }

    public void onLoadFailed(String r1) {
    }

    public void onLoadSuccess() {
    }

    public void onLynxEvent(LynxEventDetail r1) {
    }

    public void onLynxViewAndJSRuntimeDestroy() {
    }

    @Override // com.lynx.tasm.p
    public void onModuleMethodInvoked(String r1, String r2, int r3) {
    }

    public void onPageStart(String r1) {
    }

    public void onPageUpdate() {
    }

    public void onPiperInvoked(Map<String, Object> r1) {
    }

    @Override // com.lynx.tasm.p
    public void onReceivedError(LynxError r1) {
    }

    public void onReceivedError(String r1) {
    }

    public void onReceivedJSError(LynxError r1) {
    }

    public void onReceivedJavaError(LynxError r1) {
    }

    public void onReceivedNativeError(LynxError r1) {
    }

    public void onReportComponentInfo(Set<String> r1) {
    }

    public void onReportLynxConfigInfo(LynxConfigInfo r1) {
    }

    public void onRuntimeReady() {
    }

    public void onScrollStart(b r1) {
    }

    public void onScrollStop(b r1) {
    }

    public void onTASMFinishedByNative() {
    }

    public void onTemplateBundleReady(TemplateBundle r1) {
    }

    public void onTimingSetup(Map<String, Object> r1) {
    }

    public void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r2, String r3) {
    }

    public void onUpdateDataWithoutChange() {
    }

    public void onUpdatePerfReady(v0 r1) {
    }

    @Override // com.lynx.tasm.behavior.m
    public String shouldRedirectImageUrl(String r1) {
        return null;
    }

    public q1() {
    }
}
