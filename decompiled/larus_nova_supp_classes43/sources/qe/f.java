package qe;

import android.view.View;
import com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements IExternalAnnieLifecycle {
    public final pd.c a;

    public final void onBeforeGlobalPropsInitialize() {
        this.a.onBeforeGlobalPropsInitialize();
    }

    public final void onBeforeInitialPropsInitialize() {
        this.a.onBeforeInitialPropsInitialize();
    }

    public final void onBeforeJsbRegister() {
        this.a.onBeforeJsbRegister();
    }

    public final void onBeforeOpenContainer() {
        this.a.onBeforeOpenContainer();
    }

    public final void onContainerInitEnd() {
        this.a.onContainerInitEnd();
    }

    public final void onContainerInitStart() {
        this.a.onContainerInitStart();
    }

    public final void onGlobalPropsInitialized() {
        this.a.onGlobalPropsInitialized();
    }

    public final void onInitialPropsInitialized() {
        this.a.onInitialPropsInitialized();
    }

    public final void onJsbRegistered() {
        this.a.onJsbRegistered();
    }

    public final void onLynxEnvInitialized() {
        this.a.onLynxEnvInitialized();
    }

    public final void onPrepareComponentEnd() {
        this.a.onPrepareComponentEnd();
    }

    public final void onPrepareComponentStart() {
        this.a.onPrepareComponentStart();
    }

    public final void onPrepareInitDataEnd() {
        this.a.onPrepareInitDataEnd();
    }

    public final void onPrepareTemplateEnd() {
        this.a.onPrepareTemplateEnd();
    }

    public final void onPrepareTemplateStart() {
        this.a.onPrepareTemplateStart();
    }

    public final void onRelease() {
        this.a.onRelease();
    }

    public f(pd.c r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        this.a = r10;
    }

    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        this.a.onBeforeCreateRenderData(r10);
    }

    public final void onBeforeLynxEnvInitialize(boolean r10) {
        this.a.onBeforeLynxEnvInitialize(r10);
    }

    public final void onLoadSuccess(View r10) {
        this.a.onLoadSuccess(r10);
    }

    public final void onAttachView(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        this.a.onAttachView(r10, r11);
    }

    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        this.a.onCreateRenderData(r10, r11);
    }

    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        return this.a.onFallback(r10, r11);
    }

    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        this.a.onInnerFallback(r10, r11);
    }

    public final void onLoadStart(View r10, boolean r11) {
        this.a.onLoadStart(r10, r11);
    }

    public final void onContainerError(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        this.a.onContainerError(r10, r11, r12);
    }

    public final void onLoadFail(View r10, String r11, String r12) {
        this.a.onLoadFail(r10, r11, r12);
    }

    public final void onPrepareInitDataStart(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "fallbackUrl");
        this.a.onPrepareInitDataStart(r10, r11, r12);
    }
}
