package h8;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends b7.a {
    public final b7.b a;
    public final List<? extends b7.a> b;

    public c() {
        this(null);
    }

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeGlobalPropsInitialize();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeGlobalPropsInitialize();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeInitialPropsInitialize();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeInitialPropsInitialize();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeJsbRegister();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeJsbRegister();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeOpenContainer();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeOpenContainer();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onCardLoadStart() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onCardLoadStart();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onCardLoadStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onContainerInitEnd();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onContainerInitEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onContainerInitStart();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onContainerInitStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadEnd() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onEngineLoadEnd();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onEngineLoadEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadStart() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onEngineLoadStart();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onEngineLoadStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onGlobalPropsInitialized();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onGlobalPropsInitialized();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onInitialPropsInitialized();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onInitialPropsInitialized();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onJsbRegistered();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onJsbRegistered();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLynxEnvInitialized();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onLynxEnvInitialized();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLynxFirstScreen() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLynxFirstScreen();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onLynxFirstScreen();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareComponentEnd();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareComponentEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareComponentStart();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareComponentStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareInitDataEnd();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareInitDataEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareTemplateStart();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareTemplateStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onRelease();
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onRelease();
        goto L7
    }

    public c(b7.b r10) {
        this.a = r10;
        int r11 = j9.c.a;
        this.b = ((e) Annie.getService$default(e.class, null, 2, null)).T();
    }

    @Override // b7.a, b7.b
    public final void onAttachedToWindow(String r10) {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onAttachedToWindow(r10);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onAttachedToWindow(r10);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeCreateRenderData(r10);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeCreateRenderData(r10);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r10) {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeLynxEnvInitialize(r10);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeLynxEnvInitialize(r10);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onInit(r10);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onInit(r10);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r10) {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLoadSuccess(r10);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onLoadSuccess(r10);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r10) {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareTemplateEnd(r10);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareTemplateEnd(r10);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onCreateRenderData(r10, r11);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onCreateRenderData(r10, r11);
        goto L7
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b7.a) r0.next()).onFallback(r10, r11);
        goto L4
    L6:
        b7.b r1 = this.a;
        if (r1 == null) goto L10;
        return r1.onFallback(r10, r11);
    L10:
        return super.onFallback(r10, r11);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onInnerFallback(r10, r11);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onInnerFallback(r10, r11);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r10, boolean r11) {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLoadStart(r10, r11);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onLoadStart(r10, r11);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "resFrom");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareTemplateEnd(r10, r11);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareTemplateEnd(r10, r11);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onAttachView(r10, r11, r12);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onAttachView(r10, r11, r12);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onContainerError(r10, r11, r12);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onContainerError(r10, r11, r12);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r10, String r11, String r12) {
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLoadFail(r10, r11, r12);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onLoadFail(r10, r11, r12);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "fallbackUrl");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPrepareInitDataStart(r10, r11, r12);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onPrepareInitDataStart(r10, r11, r12);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeLoadRequest(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "resType");
        Intrinsics.checkNotNullParameter(r12, "type");
        b7.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onBeforeLoadRequest(r10, r11, r12, r13);
    L5:
        Iterator<T> r1 = this.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b7.a) r1.next()).onBeforeLoadRequest(r10, r11, r12, r13);
        goto L7
    }
}
