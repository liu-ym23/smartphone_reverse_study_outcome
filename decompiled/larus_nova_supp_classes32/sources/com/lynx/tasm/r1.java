package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class r1 extends q1 {
    public final CopyOnWriteArrayList<q1> a;

    @Override // com.lynx.tasm.q1
    public void onFirstLoadPerfReady(v0 r1) {
    }

    @Override // com.lynx.tasm.q1
    public void onUpdatePerfReady(v0 r1) {
    }

    @Override // com.lynx.tasm.q1
    public void onDataUpdated() {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDataUpdated();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onDestroy() {
        TraceEvent.beginSection("Client.onDestory");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDestroy();
        goto L4
    L6:
        TraceEvent.endSection("Client.onDestory");
    }

    @Override // com.lynx.tasm.q1
    public void onFirstScreen() {
        TraceEvent.beginSection("Client.onFirstScreen");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onFirstScreen();
        goto L4
    L6:
        TraceEvent.endSection("Client.onFirstScreen");
    }

    @Override // com.lynx.tasm.q1
    public void onLoadSuccess() {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLoadSuccess();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onLynxViewAndJSRuntimeDestroy() {
        TraceEvent.beginSection("Client.onLynxViewAndJSRuntimeDestroy");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onLynxViewAndJSRuntimeDestroy();
        goto L4
    L6:
        TraceEvent.endSection("Client.onLynxViewAndJSRuntimeDestroy");
    }

    @Override // com.lynx.tasm.q1
    public void onPageUpdate() {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPageUpdate();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onRuntimeReady() {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onRuntimeReady();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onTASMFinishedByNative() {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTASMFinishedByNative();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onUpdateDataWithoutChange() {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onUpdateDataWithoutChange();
        goto L4
    }

    public r1() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void a(q1 r2) {
        if (this.a.contains(r2) == true) goto L6;
        this.a.add(r2);
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onCallJSBFinished(Map<String, Object> r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCallJSBFinished(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onDynamicComponentPerfReady(HashMap<String, Object> r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDynamicComponentPerfReady(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onFling(q1.b r4) {
        TraceEvent.beginSection("Client.onFling");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onFling(r4);
        goto L4
    L6:
        TraceEvent.endSection("Client.onFling");
    }

    @Override // com.lynx.tasm.q1
    public void onFlushFinish(q1.a r3) {
        Iterator<q1> r4 = this.a.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().onFlushFinish(null);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onJSBInvoked(Map<String, Object> r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onJSBInvoked(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onLoadFailed(String r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLoadFailed(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onLynxEvent(LynxEventDetail r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLynxEvent(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onPageStart(String r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPageStart(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onPiperInvoked(Map<String, Object> r4) {
        TraceEvent.beginSection("Client.onPiperInvoked");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onPiperInvoked(r4);
        goto L4
    L6:
        TraceEvent.endSection("Client.onPiperInvoked");
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public void onReceivedError(LynxError r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getMsg() == null) goto L12;
        Iterator<q1> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        r0.next().onReceivedError(r3);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedJSError(LynxError r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getMsg() == null) goto L12;
        Iterator<q1> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        r0.next().onReceivedJSError(r3);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedJavaError(LynxError r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getMsg() == null) goto L12;
        Iterator<q1> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        r0.next().onReceivedJavaError(r3);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedNativeError(LynxError r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getMsg() == null) goto L12;
        Iterator<q1> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        r0.next().onReceivedNativeError(r3);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReportComponentInfo(Set<String> r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReportComponentInfo(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onScrollStart(q1.b r4) {
        TraceEvent.beginSection("Client.onScrollStart");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onScrollStart(r4);
        goto L4
    L6:
        TraceEvent.endSection("Client.onScrollStart");
    }

    @Override // com.lynx.tasm.q1
    public void onScrollStop(q1.b r4) {
        TraceEvent.beginSection("Client.onScrollStop");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onScrollStop(r4);
        goto L4
    L6:
        TraceEvent.endSection("Client.onScrollStop");
    }

    @Override // com.lynx.tasm.q1
    public void onTemplateBundleReady(TemplateBundle r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTemplateBundleReady(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onTimingSetup(Map<String, Object> r4) {
        TraceEvent.beginSection("Client.onTimingSetup");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onTimingSetup(r4);
        goto L4
    L6:
        TraceEvent.endSection("Client.onTimingSetup");
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public String shouldRedirectImageUrl(String r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next().shouldRedirectImageUrl(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedError(String r3) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedError(r3);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onKeyEvent(KeyEvent r3, boolean r4) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onKeyEvent(r3, r4);
        goto L4
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public void onModuleMethodInvoked(String r3, String r4, int r5) {
        Iterator<q1> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onModuleMethodInvoked(r3, r4, r5);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onTimingUpdate(Map<String, Object> r4, Map<String, Long> r5, String r6) {
        TraceEvent.beginSection("Client.onTimingUpdate");
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onTimingUpdate(r4, r5, r6);
        goto L4
    L6:
        TraceEvent.endSection("Client.onTimingUpdate");
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public void loadImage(Context r12, String r13, String r14, float r15, float r16, Transformer r17, com.lynx.tasm.behavior.m.a r18) {
        Iterator<q1> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().loadImage(r12, r13, r14, r15, r16, r17, r18);
        goto L4
    }
}
