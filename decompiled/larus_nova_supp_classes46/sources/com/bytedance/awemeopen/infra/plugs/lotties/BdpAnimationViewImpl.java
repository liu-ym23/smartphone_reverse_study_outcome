package com.bytedance.awemeopen.infra.plugs.lotties;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieTask;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationServiceConfig;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\"\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001b8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010&\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001b8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R*\u0010(\u001a\u00020'2\u0006\u0010\f\u001a\u00020'8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/lotties/BdpAnimationViewImpl;", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationView;", "", "a", "Ljava/lang/Object;", "getFallbackRes", "()Ljava/lang/Object;", "setFallbackRes", "(Ljava/lang/Object;)V", "fallbackRes", "Lcom/airbnb/lottie/LottieTask;", "Lcom/airbnb/lottie/LottieComposition;", "value", "b", "Lcom/airbnb/lottie/LottieTask;", "getCompositionTask", "()Lcom/airbnb/lottie/LottieTask;", "setCompositionTask", "(Lcom/airbnb/lottie/LottieTask;)V", "compositionTask", "c", "Lcom/airbnb/lottie/LottieComposition;", "getComposition", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition", "(Lcom/airbnb/lottie/LottieComposition;)V", "composition", "", "d", "I", "getRepeatMode", "()I", "setRepeatMode", "(I)V", "repeatMode", "e", "getRepeatCount", "setRepeatCount", "repeatCount", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;", "config", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;", "getConfig", "()Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;", "setConfig", "(Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;)V", "ao_plugin_lottie_release"}, k = 1, mv = {1, 7, 1})
public final class BdpAnimationViewImpl extends AoAnimationView {
    public static final /* synthetic */ int f = 0;
    public Object a;
    public LottieTask<LottieComposition> b;
    public LottieComposition c;
    public int d;
    public int e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationView
    public AoAnimationServiceConfig getConfig() {
        return null;
    }

    public final LottieComposition getComposition() {
        return this.c;
    }

    public final LottieTask<LottieComposition> getCompositionTask() {
        return this.b;
    }

    public final Object getFallbackRes() {
        return this.a;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationView
    public int getRepeatCount() {
        return this.e;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationView
    public int getRepeatMode() {
        return this.d;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        throw null;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        throw null;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        throw null;
    }

    public final void setComposition(LottieComposition r2) {
        this.c = r2;
        if (r2 != null) goto L5;
        throw null;
    L5:
        throw null;
    }

    public final void setCompositionTask(LottieTask<LottieComposition> r4) {
        LottieTask<LottieComposition> r0 = null;
        setComposition(null);
        LottieTask<LottieComposition> r1 = this.b;
        if (r1 == null) goto L5;
        r1.removeListener(new com.bytedance.awemeopen.infra.plugs.lotties.a());
        r1.removeFailureListener(new b());
    L5:
        if (r4 == null) goto L9;
        LottieTask r5 = r4.addListener(new c());
        if (r5 == null) goto L9;
        r0 = r5.addFailureListener(new d());
    L9:
        this.b = r0;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationView
    public void setConfig(AoAnimationServiceConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        throw null;
    }

    public final void setFallbackRes(Object r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationView
    public void setRepeatCount(int r1) {
        this.e = r1;
        throw null;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationView
    public void setRepeatMode(int r1) {
        this.d = r1;
        throw null;
    }
}
