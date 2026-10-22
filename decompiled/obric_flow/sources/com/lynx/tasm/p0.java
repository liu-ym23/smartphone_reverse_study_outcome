package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import com.lynx.tasm.base.TraceEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: classes2.dex */
public class p0 extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f10927a;

    public p0() {
        this.f10927a = new CopyOnWriteArrayList();
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public void loadImage(Context r11, String r12, String r13, float r14, float r15, Transformer r16, com.lynx.tasm.behavior.j r17) {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).loadImage(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onCallJSBFinished(Map r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onCallJSBFinished(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onDataUpdated() {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onDataUpdated();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onDestroy() {
        TraceEvent.c("Client.onDestory");
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onDestroy();
        goto L4
    L6:
        TraceEvent.a(0, "Client.onDestory");
    }

    @Override // com.lynx.tasm.o0
    public final void onDynamicComponentPerfReady(HashMap r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onDynamicComponentPerfReady(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onFirstLoadPerfReady(y r5) {
    }

    @Override // com.lynx.tasm.o0
    public void onFirstScreen() {
        TraceEvent.c("Client.onFirstScreen");
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onFirstScreen();
        goto L4
    L6:
        TraceEvent.a(0, "Client.onFirstScreen");
    }

    @Override // com.lynx.tasm.o0
    public final void onFling(n0 r5) {
        TraceEvent.c("Client.onFling");
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onFling(r5);
        goto L4
    L6:
        TraceEvent.a(0, "Client.onFling");
    }

    @Override // com.lynx.tasm.o0
    public final void onFlushFinish(m0 r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onFlushFinish(null);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onJSBInvoked(Map r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onJSBInvoked(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onKeyEvent(KeyEvent r5, boolean r10) {
        Iterator r11 = this.f10927a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((o0) r11.next()).onKeyEvent(r5, r10);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onLoadFailed(String r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onLoadFailed(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onLoadSuccess() {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onLoadSuccess();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onLynxEvent(on.d r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onLynxEvent(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onLynxViewAndJSRuntimeDestroy() {
        TraceEvent.c("Client.onLynxViewAndJSRuntimeDestroy");
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onLynxViewAndJSRuntimeDestroy();
        goto L4
    L6:
        TraceEvent.a(0, "Client.onLynxViewAndJSRuntimeDestroy");
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public void onModuleMethodInvoked(String r5, String r10, int r11) {
        Iterator r12 = this.f10927a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((o0) r12.next()).onModuleMethodInvoked(r5, r10, r11);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onPageStart(String r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onPageStart(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onPageUpdate() {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onPageUpdate();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onPiperInvoked(Map r5) {
        TraceEvent.c("Client.onPiperInvoked");
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onPiperInvoked(r5);
        goto L4
    L6:
        TraceEvent.a(0, "Client.onPiperInvoked");
    }

    @Override // com.lynx.tasm.o0
    public void onReceivedError(String r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onReceivedError(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedJSError(LynxError r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == null) goto L12;
        Iterator r10 = this.f10927a.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        ((o0) r10.next()).onReceivedJSError(r5);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedJavaError(LynxError r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == null) goto L12;
        Iterator r10 = this.f10927a.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        ((o0) r10.next()).onReceivedJavaError(r5);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedNativeError(LynxError r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == null) goto L12;
        Iterator r10 = this.f10927a.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        ((o0) r10.next()).onReceivedNativeError(r5);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReportComponentInfo(Set r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onReportComponentInfo(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onRuntimeReady() {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onRuntimeReady();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onScrollStart(n0 r5) {
        TraceEvent.c("Client.onScrollStart");
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onScrollStart(r5);
        goto L4
    L6:
        TraceEvent.a(0, "Client.onScrollStart");
    }

    @Override // com.lynx.tasm.o0
    public void onScrollStop(n0 r5) {
        TraceEvent.c("Client.onScrollStop");
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onScrollStop(r5);
        goto L4
    L6:
        TraceEvent.a(0, "Client.onScrollStop");
    }

    @Override // com.lynx.tasm.o0
    public final void onTASMFinishedByNative() {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onTASMFinishedByNative();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onTemplateBundleReady(TemplateBundle r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onTemplateBundleReady(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onTimingSetup(Map r5) {
        TraceEvent.c("Client.onTimingSetup");
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onTimingSetup(r5);
        goto L4
    L6:
        TraceEvent.a(0, "Client.onTimingSetup");
    }

    @Override // com.lynx.tasm.o0
    public void onTimingUpdate(Map r5, Map r10, String r11) {
        TraceEvent.c("Client.onTimingUpdate");
        Iterator r12 = this.f10927a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((o0) r12.next()).onTimingUpdate(r5, r10, r11);
        goto L4
    L6:
        TraceEvent.a(0, "Client.onTimingUpdate");
    }

    @Override // com.lynx.tasm.o0
    public final void onUpdateDataWithoutChange() {
        Iterator r5 = this.f10927a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onUpdateDataWithoutChange();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onUpdatePerfReady(y r5) {
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public String shouldRedirectImageUrl(String r5) {
        Iterator r10 = this.f10927a.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        String r11 = ((o0) r10.next()).shouldRedirectImageUrl(r5);
        if (r11 == null) goto L4;
        return r11;
    L8:
        return null;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public void onReceivedError(LynxError r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == null) goto L12;
        Iterator r10 = this.f10927a.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        ((o0) r10.next()).onReceivedError(r5);
        goto L8
    L13:
        return;
    }
}
