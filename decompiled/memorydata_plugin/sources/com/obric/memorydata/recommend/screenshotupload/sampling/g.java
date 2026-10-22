package com.obric.memorydata.recommend.screenshotupload.sampling;

import android.app.ActivityManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.utils.af;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bm\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingGate;", "", "isScreenEnabled", "Lkotlin/Function0;", "", "isPackageScreenEnabled", "Lkotlin/Function1;", "", "isOAutoRunning", "isMonkey", "foregroundPackage", "isScreenLocked", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "canCapture", ObricMemoryConstants.KEY_PACKAGE_NAME, "triggerType", "Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f12591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<String, Boolean> f12592b;
    private final Function0<Boolean> c;
    private final Function0<Boolean> d;
    private final Function0<String> e;
    private final Function0<Boolean> f;

    public g() {
        this(null, null, null, null, null, null, 63, null);
    }

    public g(Function0<Boolean> r3, Function1<? super String, Boolean> r4, Function0<Boolean> r5, Function0<Boolean> r6, Function0<String> r7, Function0<Boolean> r8) {
        Function0<Boolean> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Boolean> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0<String> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "isScreenEnabled");
        Intrinsics.checkNotNullParameter(r10, "isPackageScreenEnabled");
        Intrinsics.checkNotNullParameter(r11, "isOAutoRunning");
        Intrinsics.checkNotNullParameter(r12, "isMonkey");
        Intrinsics.checkNotNullParameter(r13, "foregroundPackage");
        Intrinsics.checkNotNullParameter(r14, "isScreenLocked");
        this.f12591a = r9;
        this.f12592b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public /* synthetic */ g(Function0 r8, Function1 r9, Function0 r10, Function0 r11, Function0 r12, Function0 r13, int r14, DefaultConstructorMarker r15) {
        Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function0 r18 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Function0 r19 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Function0 r110 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Function0 r111 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r16 = $$Lambda$g$6HcE7AU9R58gTsu2sIZi9zZaxms.INSTANCE;
    L5:
        Function0 r1 = r16;
        if ((r14 & 2) == 0) goto L8;
        r17 = $$Lambda$g$ad8QWEjBnuMGQpc5yaV00oC1K0.INSTANCE;
    L8:
        Function1 r2 = r17;
        if ((r14 & 4) == 0) goto L11;
        r18 = $$Lambda$g$3qXiA0dnxkcGQ782DtXSVlj7SI.INSTANCE;
    L11:
        Function0 r3 = r18;
        if ((r14 & 8) == 0) goto L14;
        r19 = $$Lambda$g$Y7E9XlmGpPeATbYbk0hE16TEoXI.INSTANCE;
    L14:
        Function0 r4 = r19;
        if ((r14 & 16) == 0) goto L17;
        r110 = $$Lambda$g$ra_Yksaxf9RYGfLTJpdhi1MHAf0.INSTANCE;
    L17:
        Function0 r5 = r110;
        if ((r14 & 32) == 0) goto L20;
        r111 = $$Lambda$g$KDHMSv4x30BZOWqjvWJ34Ew2fg.INSTANCE;
    L20:
        this(r1, r2, r3, r4, r5, r111);
    }

    private static final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pkg");
        return com.obric.memorydata.recommend.screenshotupload.b.f12542a.b(r1);
    }

    private static final boolean b() {
        return com.obric.memorydata.recommend.c.a.f12500a.a();
    }

    private static final boolean c() {
        return ActivityManager.isUserAMonkey();
    }

    private static final String d() {
        return af.f13160a.b();
    }

    private static final boolean e() {
        return ba.f();
    }

    /* JADX INFO: renamed from: lambda$3qXiA0dnx-kcGQ782DtXSVlj7SI, reason: not valid java name */
    public static /* synthetic */ boolean m1128lambda$3qXiA0dnxkcGQ782DtXSVlj7SI() {
        return b();
    }

    public static /* synthetic */ boolean lambda$6HcE7AU9R58gTsu2sIZi9zZaxms() {
        return a();
    }

    /* JADX INFO: renamed from: lambda$KDHMSv4x30BZOWqjv-WJ34Ew2fg, reason: not valid java name */
    public static /* synthetic */ boolean m1129lambda$KDHMSv4x30BZOWqjvWJ34Ew2fg() {
        return e();
    }

    public static /* synthetic */ boolean lambda$Y7E9XlmGpPeATbYbk0hE16TEoXI() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$ad8QWEjBnuMGQpc5yaV0-0oC1K0, reason: not valid java name */
    public static /* synthetic */ boolean m1130lambda$ad8QWEjBnuMGQpc5yaV00oC1K0(String r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$ra_Yksaxf9RYGfLTJpdhi1MHAf0() {
        return d();
    }

    public final boolean a(String r4, TriggerUploadType r5) {
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r5 != TriggerUploadType.VideoPlaybackSample) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        return false;
    L8:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.e.invoke(), r4) == true) goto L14;
        return false;
    L14:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.d.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return false;
    L17:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
        return false;
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f12591a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L22;
        return false;
    L22:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f12592b.invoke(r4), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
        return true;
    L26:
        return false;
    }
}
