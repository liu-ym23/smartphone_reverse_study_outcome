package com.bytedance.android.ec.core.imagex.common;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class ProxyControllerListener extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ w<ControllerListener<? super ImageInfo>> a;

    public static final class a {
    }

    static {
    }

    public final void b(Function1<? super ControllerListener<? super ImageInfo>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        this.a.a(r10);
    }

    public ProxyControllerListener(ControllerListener<? super ImageInfo> r10) {
        this.a = new w(r10);
    }

    public void onRelease(final String r10) {
        b(new C02461(r10));
    }

    public final void onControllerStart(final ImageRequest r10, final long r11) {
        b(new ProxyControllerListener$onControllerStart$$inlined$withEachType$1(r10, r11));
    }

    public void onFailure(final String r10, final Throwable r11) {
        b(new AnonymousClass1(r10, r11));
    }

    public final void onIntermediateImageFailed(final String r10, final Throwable r11) {
        b(new C02441(r10, r11));
    }

    public final void onIntermediateImageSet(final String r10, Object r11) {
        final ImageInfo r12 = (ImageInfo) r11;
        b(new C02451(r10, r12));
    }

    public void onRelease(final String r10, final ImageRequest r11) {
        b(new ProxyControllerListener$onRelease$$inlined$withEachType$1(r10, r11));
    }

    public final void onSubmit(final String r10, final Object r11) {
        b(new C02471(r10, r11));
    }

    public void onFailure(final String r10, final ImageRequest r11, final Throwable r12) {
        b(new ProxyControllerListener$onFailure$$inlined$withEachType$1(r10, r11, r12));
    }

    public void onFinalImageSet(final String r10, final ImageInfo r11, final Animatable r12) {
        b(new C02431(r10, r11, r12));
    }

    public final void onIntermediateImageSet(final String r10, Object r11, final Animatable r12) {
        final ImageInfo r13 = (ImageInfo) r11;
        b(new ProxyControllerListener$onIntermediateImageSet$$inlined$withEachType$1(r10, r13, r12));
    }

    public /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r10, Animatable r11) {
        onFinalImageSet(r1, (ImageInfo) r10, r11);
    }

    public void a(final String r10, final ImageInfo r11, final Animatable r12, final ImageRequest r13, final Map<Object, Object> r14) {
        b(new ProxyControllerListener$onFinalImageSet$$inlined$withEachType$1(r10, r11, r12, r13, r14));
    }

    public /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r10, Animatable r11, ImageRequest r12, Map r13) {
        a(r1, (ImageInfo) r10, r11, r12, r13);
    }
}
