package com.bytedance.awemeopen.infra.base.anim.lottie;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.plugs.lotties.i;
import com.bytedance.awemeopen.infra.plugs.lotties.j;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationService;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB\u0011\b\u0016\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?B\u0019\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b>\u0010BB!\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020\u000e¢\u0006\u0004\b>\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010)\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R*\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00105\u001a\u0004\u0018\u0001002\b\u0010\u001e\u001a\u0004\u0018\u0001008\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R(\u0010;\u001a\u0004\u0018\u0001062\b\u0010\u001e\u001a\u0004\u0018\u0001068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006F"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimationLottieView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "", "getScale", "scale", "", "setScale", "Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;", "config", "setAnimationConfigAndStartLoad", "", "str", "setImagesAssetsFolder", "", "frame", "setFrame", "c", "Ljava/lang/Object;", "getFallbackRes", "()Ljava/lang/Object;", "setFallbackRes", "(Ljava/lang/Object;)V", "fallbackRes", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "d", "Lkotlin/Lazy;", "getAnimService", "()Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "animService", "value", "e", "I", "getRepeatMode", "()I", "setRepeatMode", "(I)V", "repeatMode", "f", "getRepeatCount", "setRepeatCount", "repeatCount", "g", "Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;", "getConfig", "()Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;", "setConfig", "(Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;)V", "Lcom/bytedance/awemeopen/servicesapi/ui/c;", "i", "Lcom/bytedance/awemeopen/servicesapi/ui/c;", "setCompositionTask", "(Lcom/bytedance/awemeopen/servicesapi/ui/c;)V", "compositionTask", "Lcom/bytedance/awemeopen/servicesapi/ui/a;", "l", "Lcom/bytedance/awemeopen/servicesapi/ui/a;", "setComposition", "(Lcom/bytedance/awemeopen/servicesapi/ui/a;)V", "composition", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public class AoAnimationLottieView extends AppCompatImageView implements Animatable {
    public static final /* synthetic */ int m = 0;
    public final CopyOnWriteArraySet<Runnable> a;
    public volatile boolean b;
    public Object c;
    public final Lazy d;
    public int e;
    public int f;
    public AoAnimConfig g;
    public final com.bytedance.awemeopen.servicesapi.ui.d h;
    public com.bytedance.awemeopen.servicesapi.ui.c i;
    public final e j;
    public final d k;
    public com.bytedance.awemeopen.servicesapi.ui.a l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AoAnimConfig.ResMode.values().length];
            r0[AoAnimConfig.ResMode.URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[AoAnimConfig.ResMode.ASSET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[AoAnimConfig.ResMode.JSON_STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AoAnimConfig.ResMode.RAW_RES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[AoAnimConfig.ResMode.JSON_STREAM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[AoAnimConfig.ResMode.ZIP_STREAM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[AoAnimConfig.ResMode.EMPTY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public static final class c implements l64.a {
        public c() {
        }

        @Override // l64.a
        public final void onFail(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        @Override // l64.a
        public final void onSuccess() {
        }
    }

    public static final class d extends com.bytedance.awemeopen.servicesapi.ui.b<Throwable> {
        public final /* synthetic */ AoAnimationLottieView b;

        public d(AoAnimationLottieView r1) {
            this.b = r1;
        }

        @Override // com.bytedance.awemeopen.servicesapi.ui.b
        public final /* bridge */ /* synthetic */ void a(Throwable r1) {
            b(r1);
        }

        public final void b(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            AoAnimationLottieView r0 = this.b;
            int r1 = AoAnimationLottieView.m;
            r0.m();
            this.b.getConfig().f.invoke(r3);
        }
    }

    public static final class e extends com.bytedance.awemeopen.servicesapi.ui.b<com.bytedance.awemeopen.servicesapi.ui.a> {
        public final /* synthetic */ AoAnimationLottieView b;

        public e(AoAnimationLottieView r1) {
            this.b = r1;
        }

        @Override // com.bytedance.awemeopen.servicesapi.ui.b
        public final void a(com.bytedance.awemeopen.servicesapi.ui.a r2) {
            com.bytedance.awemeopen.servicesapi.ui.a r3 = r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            AoAnimationLottieView.j(this.b, r3);
            this.b.b = true;
            Iterator<Runnable> r4 = this.b.a.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r4.next().run();
            goto L4
        }
    }

    static {
    }

    private final float getScale() {
        return this.h.getScale();
    }

    public final AoAnimationService getAnimService() {
        return (AoAnimationService) this.d.getValue();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.h.isRunning();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m() {
        Object r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof Integer) == false) goto L8;
        setImageResource(((Number) r0).intValue());
        return;
    L8:
        if ((r0 instanceof String) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty((CharSequence) r0) == true) goto L16;
        l64.b r1 = new l64.b();
        r1.a = (String) r0;
        r1.e = new c();
        r1.d = this;
        AoImageService r2 = j64.a.a(AoImageService.class);
        Intrinsics.checkNotNull(r2);
        r2.Q0(getContext(), r1);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        setImageDrawable(this.h.getDrawable());
        this.h.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.h.stop();
    }

    public final AoAnimConfig getConfig() {
        return this.g;
    }

    public final Object getFallbackRes() {
        return this.c;
    }

    public final int getRepeatCount() {
        return this.f;
    }

    public final int getRepeatMode() {
        return this.e;
    }

    public AoAnimationLottieView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.a = new CopyOnWriteArraySet();
        this.d = LazyKt.lazy(AoAnimationLottieView$animService$2.INSTANCE);
        this.e = 1;
        this.g = AoAnimConfig.g;
        j r3 = getAnimService().p0();
        setImageDrawable(r3.a);
        this.h = r3;
        this.j = new e(this);
        this.k = new d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setComposition(com.bytedance.awemeopen.servicesapi.ui.a r2) {
        this.l = r2;
        if (r2 == null) goto L5;
        this.h.d(this);
        this.h.h(r2);
        this.g.getClass();
        Unit r3 = Unit.INSTANCE;
    L6:
        if (r3 != null) goto L9;
        this.h.b();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void setCompositionTask(com.bytedance.awemeopen.servicesapi.ui.c r4) {
        i r0 = null;
        setComposition(null);
        com.bytedance.awemeopen.servicesapi.ui.c r1 = this.i;
        if (r1 == null) goto L5;
        r1.b(this.j);
        r1.a(this.k);
    L5:
        if (r4 == null) goto L9;
        i r5 = r4.c(this.j);
        if (r5 == null) goto L9;
        r5.d(this.k);
        r0 = r5;
    L9:
        this.i = r0;
    }

    private final void setScale(float r2) {
        this.h.setScale(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(AoAnimConfig r4) {
        AoAnimConfig.ResMode r0 = r4.a;
        switch(b.a[r0.ordinal()]) {
            case 1: goto L41;
            case 2: goto L34;
            case 3: goto L27;
            case 4: goto L20;
            case 5: goto L13;
            case 6: goto L6;
            default: goto L71;
        };
    L71:
        return;
    L6:
        if (r4.d == true) goto L58;
        AoAnimationService r1 = getAnimService();
        Object r2 = r4.b;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.util.zip.ZipInputStream");
        setCompositionTask(r1.K((ZipInputStream) r2, r4.b.toString()));
        return;
    L58:
        AoAnimationService r3 = getAnimService();     // Catch: Exception -> L9
        Object r5 = r4.b;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.zip.ZipInputStream");     // Catch: Exception -> L9
        setComposition(r3.j0((ZipInputStream) r5, r4.b.toString()));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        this.k.b(e);
        return;
    L13:
        if (r4.d == true) goto L56;
        AoAnimationService r6 = getAnimService();
        Object r7 = r4.b;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.io.InputStream");
        setCompositionTask(r6.A2((InputStream) r7, r4.b.toString()));
        return;
    L56:
        AoAnimationService r8 = getAnimService();     // Catch: Exception -> L16
        Object r9 = r4.b;     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.io.InputStream");     // Catch: Exception -> L16
        setComposition(r8.w0((InputStream) r9, r4.b.toString()));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        this.k.b(e);
        return;
    L20:
        if (r4.d == true) goto L52;
        AoAnimationService r10 = getAnimService();
        Context r11 = getContext();
        Object r12 = r4.b;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
        setCompositionTask(r10.F1(r11, ((Integer) r12).intValue()));
        return;
    L52:
        AoAnimationService r13 = getAnimService();     // Catch: Exception -> L23
        Context r14 = getContext();     // Catch: Exception -> L23
        Object r15 = r4.b;     // Catch: Exception -> L23
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L23
        setComposition(r13.c1(r14, ((Integer) r15).intValue()));     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        this.k.b(e);
        return;
    L27:
        if (r4.d == true) goto L50;
        AoAnimationService r16 = getAnimService();
        Object r17 = r4.b;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.String");
        setCompositionTask(r16.i1((String) r17, r4.b.toString()));
        return;
    L50:
        AoAnimationService r18 = getAnimService();     // Catch: Exception -> L30
        Object r19 = r4.b;     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L30
        setComposition(r18.b2((String) r19, r4.b.toString()));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        this.k.b(e);
        return;
    L34:
        if (r4.d == true) goto L54;
        AoAnimationService r20 = getAnimService();
        Context r21 = getContext();
        Object r22 = r4.b;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.String");
        setCompositionTask(r20.W(r21, (String) r22));
        return;
    L54:
        AoAnimationService r23 = getAnimService();     // Catch: Exception -> L37
        Context r24 = getContext();     // Catch: Exception -> L37
        Object r25 = r4.b;     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L37
        setComposition(r23.D2(r24, (String) r25));     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        this.k.b(e);
        return;
    L41:
        if (r4.d == true) goto L48;
        AoAnimationService r26 = getAnimService();
        Context r27 = getContext();
        Object r28 = r4.b;
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type kotlin.String");
        setCompositionTask(r26.X1(r27, (String) r28));
        return;
    L48:
        AoAnimationService r29 = getAnimService();     // Catch: Exception -> L44
        Context r30 = getContext();     // Catch: Exception -> L44
        Object r31 = r4.b;     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L44
        setComposition(r29.R(r30, (String) r31));     // Catch: Exception -> L44
        return;
    L44:
        e = move-exception;
        this.k.b(e);
    }

    public final void setAnimationConfigAndStartLoad(AoAnimConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        setConfig(r2);
    }

    public final void setConfig(AoAnimConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        this.c = r4.c;
        com.bytedance.awemeopen.servicesapi.ui.d r0 = this.h;
        r0.e();
        r0.a(r4.e);
        AoAnimConfig.ResMode r1 = r4.a;
        if (r1 == this.g.a) goto L5;
        l(r4);
    L18:
        this.g = r4;
        return;
    L5:
        switch(b.a[r1.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L18;
        };
    L7:
        m();
        goto L18
    L11:
        Object r2 = r4.b;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        int r3 = ((Integer) r2).intValue();
        Object r5 = this.g.b;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        if (r3 == ((Integer) r5).intValue()) goto L18;
        l(r4);
        goto L18
    L14:
        Object r6 = r4.b;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.String");
        Object r7 = this.g.b;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.String");
        if (Intrinsics.areEqual((String) r6, (String) r7) == true) goto L18;
        l(r4);
        goto L18
    L9:
        if (Intrinsics.areEqual(r4.b, this.g.b) == true) goto L18;
        l(r4);
        goto L18
    }

    public final void setFallbackRes(Object r1) {
        this.c = r1;
    }

    public final void setFrame(final int r4) {
        if (getAnimService().f() == false) goto L14;
        if (r4 != 0) goto L6;
        this.h.setFrame(1);
    L6:
        final Function0<Unit> r0 = new AnonymousClass1(this, r4);
        if (this.g.d == false) goto L10;
        AoPool.d(new com.bytedance.awemeopen.infra.base.anim.lottie.a(r0), 10);
        return;
    L10:
        if (this.b == false) goto L12;
        AoPool.d(new com.bytedance.awemeopen.infra.base.anim.lottie.b(r0), 10);
        return;
    L12:
        this.a.add(new com.bytedance.awemeopen.infra.base.anim.lottie.c(r0));
        return;
    L14:
        this.h.setFrame(r4);
    }

    public final void setImagesAssetsFolder(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.h.c(r2);
    }

    public final void setRepeatCount(int r2) {
        this.f = r2;
        this.h.setRepeatCount(r2);
    }

    public final void setRepeatMode(int r2) {
        this.e = r2;
        this.h.g(r2);
    }

    public AoAnimationLottieView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3);
        this.a = new CopyOnWriteArraySet();
        this.d = LazyKt.lazy(AoAnimationLottieView$animService$2.INSTANCE);
        this.e = 1;
        this.g = AoAnimConfig.g;
        j r4 = getAnimService().p0();
        setImageDrawable(r4.a);
        this.h = r4;
        this.j = new e(this);
        this.k = new d(this);
    }

    public static final /* synthetic */ void j(AoAnimationLottieView r0, com.bytedance.awemeopen.servicesapi.ui.a r1) {
        r0.setComposition(r1);
    }

    public final void setMinAndMaxFrame(int r2, int r3) {
        this.h.f(r2, r3);
    }

    public AoAnimationLottieView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = new CopyOnWriteArraySet();
        this.d = LazyKt.lazy(AoAnimationLottieView$animService$2.INSTANCE);
        this.e = 1;
        this.g = AoAnimConfig.g;
        j r5 = getAnimService().p0();
        setImageDrawable(r5.a);
        this.h = r5;
        this.j = new e(this);
        this.k = new d(this);
    }
}
