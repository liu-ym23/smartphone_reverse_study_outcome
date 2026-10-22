package com.lynx.rts.gen;

import mpa.f;
import mpa.h;
import mpa.i;
import s87.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RendererFunctionNG {
    public long a;

    private native void nativeAddEventListener(long r1, String r3, CommonCallbackNG r4);

    private native void nativeAdoptStyleSheet(long r1);

    private native Object nativeBridgeInvoke(long r1, String r3, String r4, Object r5, BridgeCallback r6, BridgeCallback r7);

    private native void nativeCancelAnimationFrame(long r1, long r3);

    private native void nativeClearTimeInterval(long r1, long r3);

    private native void nativeClearTimeout(long r1, long r3);

    private native long nativeCreate(long r1);

    private native void nativeDestroy(long r1);

    private native void nativeElementAnimate(long r1, long r3, Object[] r5);

    private native void nativeEnableStaticPageDirectMode(long r1);

    private native void nativeFiberAddClass(long r1, long r3, String r5);

    private native void nativeFiberAddConfig(long r1, long r3, String r5, Object r6);

    private native void nativeFiberAddDataset(long r1, long r3, String r5, Object r6);

    private native void nativeFiberAddEventListener(long r1, long r3, String r5, CommonCallbackNG r6, FiberEventListenerOption r7);

    private native void nativeFiberAddInlineStyle(long r1, long r3, Object r5, Object r6);

    private native long nativeFiberAppendElement(long r1, long r3, long r5);

    private native void nativeFiberAsyncResolveElement(long r1, long r3);

    private native void nativeFiberAsyncResolveSubtreeProperty(long r1, long r3);

    private native long nativeFiberCloneElement(long r1, long r3, Object r5);

    private native void nativeFiberConsumeGesture(long r1, long r3, long r5, ConsumeGestureOption r7);

    private native long nativeFiberCreateBlock(long r1, long r3, Object r5);

    private native long nativeFiberCreateComponent(long r1, long r3, String r5, long r6, String r8, String r9, String r10, Object r11);

    private native long nativeFiberCreateElement(long r1, String r3, long r4);

    private native long[] nativeFiberCreateElementWithProperties(long r1, int r3, Object r4, Object r5);

    private native long nativeFiberCreateFor(long r1, long r3, Object r5);

    private native long[] nativeFiberCreateFrame(long r1, long r3, FiberCreateFrameOption r5);

    private native long nativeFiberCreateIf(long r1, long r3, Object r5);

    private native long nativeFiberCreateImage(long r1, long r3);

    private native long nativeFiberCreateList(long r1, int r3, ComponentAtIndexCallbackNG r4, EnqueueComponentCallbackNG r5, Object r6, ComponentAtIndexesCallbackNG r7);

    private native long nativeFiberCreateNonElement(long r1, long r3);

    private native long nativeFiberCreatePage(long r1, String r3, long r4);

    private native long nativeFiberCreateRawText(long r1, String r3);

    private native long nativeFiberCreateScrollView(long r1, long r3, Object r5);

    private native long nativeFiberCreateText(long r1, long r3, Object r5);

    private native long nativeFiberCreateView(long r1, long r3);

    private native long nativeFiberCreateWrapperElement(long r1, long r3, Object r5);

    private native long[] nativeFiberElementFromBinary(long r1, String r3, long r4, String r6);

    private native void nativeFiberElementFromBinaryAsync(long r1);

    private native long nativeFiberElementIsEqual(long r1, long r3, long r5);

    private native long nativeFiberFirstElement(long r1, long r3);

    private native void nativeFiberFlushElementTree(long r1, long r3, Object r5);

    private native void nativeFiberFreeValue(long r1, long r3);

    private native Object nativeFiberGetAttributeByName(long r1, long r3, String r5);

    private native String[] nativeFiberGetAttributeNames(long r1, long r3);

    private native Object nativeFiberGetAttributes(long r1, long r3);

    private native long[] nativeFiberGetChildren(long r1, long r3);

    private native String[] nativeFiberGetClasses(long r1, long r3);

    private native String nativeFiberGetComponentID(long r1, long r3);

    private native Object nativeFiberGetComputedStyleByKey(long r1, long r3, String r5);

    private native void nativeFiberGetComputedStyles(long r1);

    private native Object nativeFiberGetDataByKey(long r1, long r3, String r5);

    private native Object nativeFiberGetDataset(long r1, long r3);

    private native long[] nativeFiberGetElementByUniqueID(long r1, long r3);

    private native Object nativeFiberGetElementConfig(long r1, long r3);

    private native long nativeFiberGetElementUniqueID(long r1, long r3);

    private native String nativeFiberGetID(long r1, long r3);

    private native Object nativeFiberGetInlineStyle(long r1, long r3, long r5);

    private native String nativeFiberGetInlineStyles(long r1, long r3);

    private native long nativeFiberGetPageElement(long r1);

    private native long nativeFiberGetParent(long r1, long r3);

    private native String nativeFiberGetTag(long r1, long r3);

    private native Object nativeFiberGetTemplateParts(long r1, long r3);

    private native long nativeFiberInsertElementBefore(long r1, long r3, long r5, long r7);

    private native boolean nativeFiberIsPartElement(long r1, long r3);

    private native boolean nativeFiberIsTemplateElement(long r1, long r3);

    private native long nativeFiberLastElement(long r1, long r3);

    private native void nativeFiberMarkAsyncResolveRoot(long r1, long r3);

    private native void nativeFiberMarkPartElement(long r1, long r3, String r5);

    private native void nativeFiberMarkTemplateElement(long r1, long r3);

    private native long nativeFiberNextElement(long r1, long r3);

    private native void nativeFiberOnLifecycleEvent(long r1, Object r3);

    private native Object nativeFiberQueryComponent(long r1, String r3, CommonCallbackNG r4);

    private native long nativeFiberQuerySelector(long r1, long r3, String r5, Object r6);

    private native long[] nativeFiberQuerySelectorAll(long r1, long r3, String r5, Object r6);

    private native long nativeFiberRemoveElement(long r1, long r3, long r5);

    private native void nativeFiberRemoveEventListener(long r1, long r3, String r5, CommonCallbackNG r6, FiberEventListenerOption r7);

    private native void nativeFiberRemoveGestureDetector(long r1, long r3, long r5);

    private native long nativeFiberReplaceElement(long r1, long r3, long r5);

    private native void nativeFiberReplaceElements(long r1, long r3, long[] r5, long[] r6);

    private native void nativeFiberSetAttribute(long r1, long r3, Object r5, Object r6);

    private native void nativeFiberSetCSSId(long r1, long[] r3, long r4, String r6);

    private native void nativeFiberSetClasses(long r1, long r3, String r5);

    private native void nativeFiberSetConfig(long r1, long r3, Object r5);

    private native void nativeFiberSetDataset(long r1, long r3, Object r5);

    private native void nativeFiberSetGestureDetector(long r1, long r3, long r5, int r7, Object r8, Object r9, Object[] r10, CommonCallbackNG r11);

    private native void nativeFiberSetGestureState(long r1, long r3, long r5, int r7);

    private native void nativeFiberSetID(long r1, long r3, String r5);

    private native void nativeFiberSetInlineStyles(long r1, long r3, Object r5);

    private native void nativeFiberSetParsedStyles(long r1, long r3, String r5, Object r6);

    private native void nativeFiberSetStringAttribute(long r1, long r3, String r5, String r6);

    private native void nativeFiberStopImmediatePropagation(long r1, long r3);

    private native void nativeFiberStopPropagation(long r1, long r3);

    private native long nativeFiberSwapElement(long r1, long r3, long r5);

    private native void nativeFiberUpdateComponentID(long r1, long r3, String r5);

    private native void nativeFiberUpdateComponentInfo(long r1);

    private native Object nativeFiberUpdateForChildCount(long r1, long r3, int r5);

    private native Object nativeFiberUpdateIfNodeIndex(long r1, long r3, int r5);

    private native void nativeFiberUpdateListCallbacks(long r1, long r3, ComponentAtIndexCallbackNG r5, EnqueueComponentCallbackNG r6, ComponentAtIndexesCallbackNG r7);

    private native void nativeFilterI18nResource(long r1, Object r3);

    private native Object nativeGeneratePipelineOptions(long r1);

    private native Object nativeGetGlobalProps(long r1);

    private native int nativeGetInstanceId(long r1);

    private native Object nativeGetSessionStorageItem(long r1, String r3);

    private native Object nativeGetSystemInfo(long r1);

    private native Object nativeI18nResourceTranslation(long r1, Object r3);

    private native void nativeInvokeUIMethod(long r1, long r3, String r5, Object r6, CommonCallbackNG r7);

    private native boolean nativeIsProfileRecording(long r1);

    private native boolean[] nativeLoadLepusChunk(long r1, String r3, LoadLepusChunkOption r4);

    private native void nativeLoadStyleSheet(long r1, String r3, String r4);

    private native void nativeMarkPipelineTiming(long r1, String r3, String r4);

    private native void nativeOnPipelineStart(long r1, String r3, String r4);

    private native void nativeProfileEnd(long r1);

    private native int nativeProfileFlowId(long r1);

    private native void nativeProfileMark(long r1, String r3, Object r4);

    private native void nativeProfileStart(long r1, String r3, Object r4);

    private native void nativeReplaceStyleSheets(long r1);

    private native void nativeReportError(long r1, RendererError r3, ErrorOption r4);

    private native long nativeRequestAnimationFrame(long r1, CommonCallbackNG r3);

    private native long nativeRequestFrameCommitCallback(long r1, CommonCallbackNG r3);

    private native void nativeRuntimeAddEventListener(long r1, String r3, CommonCallbackNG r4, int r5);

    private native void nativeRuntimeDispatchEvent(long r1, RuntimeDispatchEventOption r3, int r4);

    private native void nativeRuntimeRemoveEventListener(long r1, String r3, CommonCallbackNG r4, int r5);

    private native void nativeSendGlobalEvent(long r1, String r3, Object r4);

    private native void nativeSetDynamicStyleObject(long r1, long r3, Object r5);

    private native void nativeSetDynamicStyleObjectKV(long r1, long r3, int r5, Object r6);

    private native void nativeSetDynamicStyleString(long r1, long r3, String r5);

    private native long nativeSetInterval(long r1, CommonCallbackNG r3, long r4);

    private native void nativeSetSessionStorageItem(long r1, String r3, Object r4);

    private native void nativeSetSourceMapRelease(long r1, RendererError r3);

    private native void nativeSetStyleObject(long r1, long r3, String r5);

    private native long nativeSetTimeout(long r1, CommonCallbackNG r3, long r4);

    private native void nativeSubscribeSessionStorage(long r1, String r3, int r4, CommonCallbackNG r5);

    private native void nativeUnsubscribeSessionStorage(long r1, String r3, int r4);

    public final synchronized void e() {
        monitor-enter(this);
        long r0 = this.a;     // Catch: Throwable -> L11
        if (r0 != 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.a = 0;     // Catch: Throwable -> L11
        nativeDestroy(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final Object B() {
        return nativeGeneratePipelineOptions(this.a);
    }

    public final Object C() {
        return nativeGetGlobalProps(this.a);
    }

    public final int D() {
        return nativeGetInstanceId(this.a);
    }

    public final void f() {
        nativeEnableStaticPageDirectMode(this.a);
    }

    public final long j() {
        return nativeFiberCreatePage(this.a, "page", 0);
    }

    public RendererFunctionNG() {
        this.a = 0;
    }

    public RendererFunctionNG(long r3) {
        this.a = 0;
        this.a = nativeCreate(r3);
    }

    public final long H(CommonCallbackNG r3) {
        return nativeRequestAnimationFrame(this.a, r3);
    }

    public final long I(CommonCallbackNG r3) {
        return nativeRequestFrameCommitCallback(this.a, r3);
    }

    public final void b(long r3) {
        nativeCancelAnimationFrame(this.a, r3);
    }

    public final void c(long r3) {
        nativeClearTimeInterval(this.a, r3);
    }

    public final void d(long r3) {
        nativeClearTimeout(this.a, r3);
    }

    public final long k(String r3) {
        return nativeFiberCreateRawText(this.a, r3);
    }

    public final long l(long r7) {
        return nativeFiberCreateText(this.a, r7, null);
    }

    public final long m(long r3) {
        return nativeFiberCreateView(this.a, r3);
    }

    public final void p(long r3) {
        nativeFiberFreeValue(this.a, r3);
    }

    public final long q(long r3) {
        return nativeFiberGetElementUniqueID(this.a, r3);
    }

    public final void F(String r3, String r4) {
        nativeMarkPipelineTiming(this.a, r3, r4);
    }

    public final void G(String r3, String r4) {
        nativeOnPipelineStart(this.a, r3, r4);
    }

    public final void L(long r7, String r9) {
        nativeSetStyleObject(this.a, r7, r9);
    }

    public final long M(CommonCallbackNG r7, long r8) {
        return nativeSetTimeout(this.a, r7, r8);
    }

    public final void h(long r8, long r10) {
        nativeFiberAppendElement(this.a, r8, r10);
    }

    public final long i(String r7, long r8) {
        return nativeFiberCreateElement(this.a, r7, r8);
    }

    public final long n(long r7, Object r9) {
        return nativeFiberCreateWrapperElement(this.a, r7, r9);
    }

    public final void o(long r7, Object r9) {
        nativeFiberFlushElementTree(this.a, r7, r9);
    }

    public final void t(long r8, long r10) {
        nativeFiberRemoveElement(this.a, r8, r10);
    }

    public final void v(long r8, long r10) {
        nativeFiberRemoveGestureDetector(this.a, r8, r10);
    }

    public final void w(long r8, long r10) {
        nativeFiberReplaceElement(this.a, r8, r10);
    }

    public final void y(long r7, String r9) {
        nativeFiberSetID(this.a, r7, r9);
    }

    public final void E(long r9, Object r11, g r12) {
        nativeInvokeUIMethod(this.a, r9, "setValue", r11, r12);
    }

    public final void J(String r7, CommonCallbackNG r8, int r9) {
        nativeRuntimeAddEventListener(this.a, r7, r8, r9);
    }

    public final void K(String r7, CommonCallbackNG r8, int r9) {
        nativeRuntimeRemoveEventListener(this.a, r7, r8, r9);
    }

    public final void r(long r10, long r12, long r14) {
        nativeFiberInsertElementBefore(this.a, r10, r12, r14);
    }

    public final long s(long r8, String r10, Object r11) {
        return nativeFiberQuerySelector(this.a, r8, r10, r11);
    }

    public final void x(long r8, Object r10, Object r11) {
        nativeFiberSetAttribute(this.a, r8, r10, r11);
    }

    public final void z(long r8, String r10, String r11) {
        nativeFiberSetStringAttribute(this.a, r8, r10, r11);
    }

    public final void A(long r9, h r11, i r12, f r13) {
        nativeFiberUpdateListCallbacks(this.a, r9, r11, r12, r13);
    }

    public final void g(long r9, String r11, CommonCallbackNG r12, FiberEventListenerOption r13) {
        nativeFiberAddEventListener(this.a, r9, r11, r12, r13);
    }

    public final void u(long r9, String r11, CommonCallbackNG r12, FiberEventListenerOption r13) {
        nativeFiberRemoveEventListener(this.a, r9, r11, r12, r13);
    }

    public final Object a(String r9, String r10, Object r11, BridgeCallback r12, BridgeCallback r13) {
        return nativeBridgeInvoke(this.a, r9, r10, r11, r12, r13);
    }
}
