package com.obric.memorydata.utils.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.ParcelFileDescriptor;
import android.view.WindowManager;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u000278B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007J,\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010'0&2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020\u001eH\u0007J4\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u0007H\u0007J\u0010\u0010!\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J\u0010\u00103\u001a\u00020\u00012\u0006\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00101\u001a\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u0012\u0012\u0002\b\u0003 \u000e*\b\u0012\u0002\b\u0003\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u0012\u0012\u0002\b\u0003 \u000e*\b\u0012\u0002\b\u0003\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R+\u0010\u0016\u001a\u0012\u0012\u0002\b\u0003 \u000e*\b\u0012\u0002\b\u0003\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010R#\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001d\u0010\u001f¨\u00069"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCapture;", "", "<init>", "()V", "TAG", "", "DOWNSCALE_BY_CODEC", "", "DOWNSCALE_BY_CAPTURE", "DEFAULT_HEIF_QP", "windowManager", "Landroid/view/WindowManager;", "windowManagerGlobalClass", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "getWindowManagerGlobalClass", "()Ljava/lang/Class;", "windowManagerGlobalClass$delegate", "Lkotlin/Lazy;", "screenCaptureClass", "getScreenCaptureClass", "screenCaptureClass$delegate", "captureArgsBuilderClass", "getCaptureArgsBuilderClass", "captureArgsBuilderClass$delegate", "iWindowManagerObject", "getIWindowManagerObject", "()Ljava/lang/Object;", "iWindowManagerObject$delegate", "isHeifCaptureSupported", "", "()Z", "isHeifCaptureSupported$delegate", "captureDisplay", "Landroid/graphics/Bitmap;", "scale", "", "captureDisplayWithBuffer", "Lkotlin/Pair;", "Landroid/hardware/HardwareBuffer;", "useHardwareBuffer", "captureDisplayToHeif", "fd", "Landroid/os/ParcelFileDescriptor;", "outputWidth", "outputHeight", "qp", "downScalePreference", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureResult;", "config", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig;", "buildCaptureArgs", "validateHeifConfig", "", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$HeifConfig;", "CaptureConfig", "CaptureResult", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WindowManager f13209b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;
    private static final Lazy g = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig;", "", "BitmapConfig", "HardwareBufferConfig", "HeifConfig", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$BitmapConfig;", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$HardwareBufferConfig;", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$HeifConfig;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {

        /* JADX INFO: renamed from: com.obric.memorydata.utils.e.b$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$BitmapConfig;", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig;", "scale", "", "<init>", "(F)V", "getScale", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0721a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final float f13210a;

            public C0721a() {
                this(0.0f, 1, null);
            }

            public C0721a(float r1) {
                this.f13210a = r1;
            }

            public /* synthetic */ C0721a(float r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = 1.0f;
            L5:
                this(r1);
            }

            public final float a() {
                return this.f13210a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0721a.class) == true) goto L8;
                return false;
            L8:
                C0721a r6 = (C0721a) ZeusTransformUtils.preCheckCast(r5, C0721a.class, "com.obric.memorydata.plugin");
                if (Float.compare(this.f13210a, r6.f13210a) == 0) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Float.hashCode(this.f13210a);
            }

            public String toString() {
                return "BitmapConfig(scale=" + this.f13210a + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.utils.e.b$a$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$HardwareBufferConfig;", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig;", "scale", "", "<init>", "(F)V", "getScale", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0722b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final float f13211a;

            public C0722b() {
                this(0.0f, 1, null);
            }

            public C0722b(float r1) {
                this.f13211a = r1;
            }

            public /* synthetic */ C0722b(float r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = 1.0f;
            L5:
                this(r1);
            }

            public final float a() {
                return this.f13211a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0722b.class) == true) goto L8;
                return false;
            L8:
                C0722b r6 = (C0722b) ZeusTransformUtils.preCheckCast(r5, C0722b.class, "com.obric.memorydata.plugin");
                if (Float.compare(this.f13211a, r6.f13211a) == 0) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Float.hashCode(this.f13211a);
            }

            public String toString() {
                return "HardwareBufferConfig(scale=" + this.f13211a + ')';
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig$HeifConfig;", "Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureConfig;", "fd", "Landroid/os/ParcelFileDescriptor;", "outputWidth", "", "outputHeight", "qp", "downScalePreference", "<init>", "(Landroid/os/ParcelFileDescriptor;IIII)V", "getFd", "()Landroid/os/ParcelFileDescriptor;", "getOutputWidth", "()I", "getOutputHeight", "getQp", "getDownScalePreference", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ParcelFileDescriptor f13212a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f13213b;
            private final int c;
            private final int d;
            private final int e;

            public c(ParcelFileDescriptor r2, int r3, int r4, int r5, int r6) {
                Intrinsics.checkNotNullParameter(r2, "fd");
                this.f13212a = r2;
                this.f13213b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
            }

            public final ParcelFileDescriptor a() {
                return this.f13212a;
            }

            public final int b() {
                return this.f13213b;
            }

            public final int c() {
                return this.c;
            }

            public final int d() {
                return this.d;
            }

            public final int e() {
                return this.e;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f13212a, r6.f13212a) == true) goto L12;
                return false;
            L12:
                if (this.f13213b == r6.f13213b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L18;
                return false;
            L18:
                if (this.d == r6.d) goto L21;
                return false;
            L21:
                if (this.e == r6.e) goto L23;
                return false;
            L23:
                return true;
            }

            public int hashCode() {
                return (((((((this.f13212a.hashCode() * 31) + Integer.hashCode(this.f13213b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
            }

            public String toString() {
                return "HeifConfig(fd=" + this.f13212a + ", outputWidth=" + this.f13213b + ", outputHeight=" + this.c + ", qp=" + this.d + ", downScalePreference=" + this.e + ')';
            }
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.utils.e.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCapture$CaptureResult;", "", "bitmap", "Landroid/graphics/Bitmap;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "heifWritten", "", "<init>", "(Landroid/graphics/Bitmap;Landroid/hardware/HardwareBuffer;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "getHeifWritten", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0723b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f13214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HardwareBuffer f13215b;
        private final boolean c;

        public C0723b() {
            this(null, null, false, 7, null);
        }

        public C0723b(Bitmap r1, HardwareBuffer r2, boolean r3) {
            this.f13214a = r1;
            this.f13215b = r2;
            this.c = r3;
        }

        public /* synthetic */ C0723b(Bitmap r2, HardwareBuffer r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = false;
        L11:
            this(r2, r3, r4);
        }

        public final Bitmap a() {
            return this.f13214a;
        }

        public final HardwareBuffer b() {
            return this.f13215b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0723b.class) == true) goto L8;
            return false;
        L8:
            C0723b r6 = (C0723b) ZeusTransformUtils.preCheckCast(r5, C0723b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13214a, r6.f13214a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13215b, r6.f13215b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Bitmap r0 = this.f13214a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            HardwareBuffer r4 = this.f13215b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + Boolean.hashCode(this.c);
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "CaptureResult(bitmap=" + this.f13214a + ", hardwareBuffer=" + this.f13215b + ", heifWritten=" + this.c + ')';
        }
    }

    static {
        f13208a = new b();
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        f13209b = (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin");
        c = LazyKt.lazy($$Lambda$b$PV3BMZvChbodhAgaztceZVflW0.INSTANCE);
        d = LazyKt.lazy($$Lambda$b$giByeHZqBMCCHJs8oTmSwqMxCB8.INSTANCE);
        e = LazyKt.lazy($$Lambda$b$uUvJ9G2FptnLlhTOTl8m4CUfkw.INSTANCE);
        f = LazyKt.lazy($$Lambda$b$FlofLgCHmUC2Sj2Qd2ZN3cV29rA.INSTANCE);
        g = LazyKt.lazy($$Lambda$b$JEMjwbF7McAim2fajOSkB8XSMDo.INSTANCE);
    }

    private b() {
    }

    private final void a(a.c r4) {
        boolean r0 = false;
        if (r4.b() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L33;
        if (r4.c() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L31;
        int r6 = r4.d();
        if (1 <= r6) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L29;
        if (r4.e() != 0) goto L22;
    L23:
        r0 = true;
    L24:
        if (r0 == false) goto L27;
        return;
    L27:
        throw new IllegalArgumentException("HEIF downScalePreference must be DOWNSCALE_BY_CODEC or DOWNSCALE_BY_CAPTURE".toString());
    L22:
        if (r4.e() != 1) goto L24;
    L29:
        throw new IllegalArgumentException("HEIF qp must be in 1..51".toString());
    L15:
        if (r6 >= 52) goto L17;
        r7 = true;
        goto L18
    L31:
        throw new IllegalArgumentException("HEIF outputHeight must be > 0".toString());
    L10:
        r5 = false;
        goto L11
    L33:
        throw new IllegalArgumentException("HEIF outputWidth must be > 0".toString());
    L5:
        r3 = false;
        goto L6
    }

    private final Class<?> b() {
        return (Class) ZeusTransformUtils.preCheckCast(c.getValue(), Class.class, "com.obric.memorydata.plugin");
    }

    private final Object b(a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        Object r0 = ao.a(d(), new Object[0]);
        if (ZeusTransformUtils.instanceOf(r8, a.C0721a.class) == false) goto L6;
        ao.call(r0, "setFrameScale", new Object[]{Float.valueOf(((a.C0721a) ZeusTransformUtils.preCheckCast(r8, a.C0721a.class, "com.obric.memorydata.plugin")).a())});
    L11:
        Object r6 = ao.call(r0, "build", new Object[0]);
        Intrinsics.checkNotNullExpressionValue(r6, "call(...)");
        return r6;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, a.C0722b.class) == false) goto L9;
        ao.call(r0, "setFrameScale", new Object[]{Float.valueOf(((a.C0722b) ZeusTransformUtils.preCheckCast(r8, a.C0722b.class, "com.obric.memorydata.plugin")).a())});
        goto L11
    L9:
        if (ZeusTransformUtils.instanceOf(r8, a.c.class) == false) goto L14;
        a((a.c) ZeusTransformUtils.preCheckCast(r8, a.c.class, "com.obric.memorydata.plugin"));
        ao.call(r0, "setHeifOutput", new Object[]{((a.c) ZeusTransformUtils.preCheckCast(r8, a.c.class, "com.obric.memorydata.plugin")).a(), Integer.valueOf(((a.c) ZeusTransformUtils.preCheckCast(r8, a.c.class, "com.obric.memorydata.plugin")).b()), Integer.valueOf(((a.c) ZeusTransformUtils.preCheckCast(r8, a.c.class, "com.obric.memorydata.plugin")).c()), Integer.valueOf(((a.c) ZeusTransformUtils.preCheckCast(r8, a.c.class, "com.obric.memorydata.plugin")).d()), Integer.valueOf(((a.c) ZeusTransformUtils.preCheckCast(r8, a.c.class, "com.obric.memorydata.plugin")).e())});
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private final Class<?> c() {
        return (Class) ZeusTransformUtils.preCheckCast(d.getValue(), Class.class, "com.obric.memorydata.plugin");
    }

    private final Class<?> d() {
        return (Class) ZeusTransformUtils.preCheckCast(e.getValue(), Class.class, "com.obric.memorydata.plugin");
    }

    private final Object e() {
        return f.getValue();
    }

    private static final Class f() {
        return ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.memorydata.plugin");
    }

    private static final Class g() {
        return ZeusTransformUtils.forName("android.window.ScreenCapture", "com.obric.memorydata.plugin");
    }

    private static final Class h() {
        return ZeusTransformUtils.forName("android.window.ScreenCapture$CaptureArgs$Builder", "com.obric.memorydata.plugin");
    }

    private static final Object i() {
        return ao.call(f13208a.b(), "getWindowManagerService", new Object[0]);
    }

    private static final boolean j() {
    L11:
        th = move-exception;
        RunLog.INSTANCE.error("ScreenCapture", "check isHeifCaptureSupported failed", th);
        return false;
    L4:
        if (AppContext.INSTANCE.isDebug() == false) goto L18;
        Method[] r2 = f13208a.d().getMethods();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r2, "getMethods(...)");     // Catch: Throwable -> L11
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        int r4 = r3.length;     // Catch: Throwable -> L11
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L20;
        if (Intrinsics.areEqual(((Method) ZeusTransformUtils.preCheckCast(r3[r5], Method.class, "com.obric.memorydata.plugin")).getName(), "setHeifOutput") == true) goto L19;
        r5 = r5 + 1;
        goto L6
    L19:
        return true;
    L20:
        return false;
    L18:
        return false;
    }

    public static /* synthetic */ Object lambda$FlofLgCHmUC2Sj2Qd2ZN3cV29rA() {
        return i();
    }

    public static /* synthetic */ boolean lambda$JEMjwbF7McAim2fajOSkB8XSMDo() {
        return j();
    }

    /* JADX INFO: renamed from: lambda$PV3BMZvChbodhAgaztceZVfl-W0, reason: not valid java name */
    public static /* synthetic */ Class m1244lambda$PV3BMZvChbodhAgaztceZVflW0() {
        return f();
    }

    public static /* synthetic */ Class lambda$giByeHZqBMCCHJs8oTmSwqMxCB8() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$uUvJ9G2FptnLlhTOTl8m4CUfk-w, reason: not valid java name */
    public static /* synthetic */ Class m1245lambda$uUvJ9G2FptnLlhTOTl8m4CUfkw() {
        return h();
    }

    public final Bitmap a(float r3) {
        return a((a) ZeusTransformUtils.preCheckCast(new a.C0721a(r3), a.class, "com.obric.memorydata.plugin")).a();
    }

    public final C0723b a(a r12) {
        a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "config");
        RunLog.INSTANCE.debug("ScreenCapture", "captureDisplay config=" + r13);
        Bitmap r0 = null;
        Object r2 = b(r13);     // Catch: Exception -> L34
        boolean r6 = false;
        Object r4 = ao.call(c(), "createSyncCaptureListener", new Object[0]);     // Catch: Exception -> L34
        ao.call(e(), "captureDisplay", new Object[]{Integer.valueOf(f13209b.getDefaultDisplay().getDisplayId()), r2, r4});     // Catch: Exception -> L34
        if (ZeusTransformUtils.instanceOf(r13, a.c.class) == false) goto L7;
        RunLog.INSTANCE.debug("ScreenCapture", "captureDisplay HEIF result: success=true");     // Catch: Exception -> L34
        return new C0723b(null, null, true, 3, null);
    L7:
        Object r11 = ao.call(r4, "getBuffer", new Object[0]);     // Catch: Exception -> L34
        if (r11 == null) goto L22;
        Object r3 = ao.call(r11, "getHardwareBuffer", new Object[0]);     // Catch: Exception -> L34
        if (ZeusTransformUtils.instanceOf(r13, a.C0722b.class) == true) goto L12;
    L14:
        Bitmap r14 = (Bitmap) ZeusTransformUtils.preCheckCast(ao.call(r11, "asBitmap", new Object[0]), Bitmap.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34
        if (r14 != null) goto L38;
    L19:
        if (r3 == null) goto L21;
        ao.call(r3, IslandSession.REOPEN_VALUE_CLOSE, new Object[0]);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        Bitmap r5 = r14;
        e = e;
        HardwareBuffer r7 = null;
    L36:
        RunLog.INSTANCE.error("ScreenCapture", "captureDisplay failed: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return new C0723b(r5, r7, false, 4, null);
    L21:
        r0 = r14;
        HardwareBuffer r15 = null;
    L41:
        RunLog r16 = RunLog.INSTANCE;     // Catch: Exception -> L32
        StringBuilder r8 = new StringBuilder().append("captureDisplay result: screenshot=");     // Catch: Exception -> L32
        if (r0 == null) goto L26;
        boolean r9 = true;
    L27:
        StringBuilder r10 = r8.append(r9).append(", hardwareBuffer=");     // Catch: Exception -> L32
        if (r15 == null) goto L30;
        r6 = true;
    L30:
        r16.debug("ScreenCapture", r10.append(r6).toString());     // Catch: Exception -> L32
        return new C0723b(r0, r15, false, 4, null);
    L26:
        r9 = false;
    L32:
        e = move-exception;
        r7 = r15;
        e = e;
        r5 = r0;
        goto L36
    L38:
        Bitmap r17 = r14.copy(Bitmap.Config.RGB_565, true);     // Catch: Exception -> L17
        r14.recycle();     // Catch: Exception -> L17
        r14 = r17;
        goto L19
    L12:
        if (ZeusTransformUtils.instanceOf(r3, HardwareBuffer.class) == false) goto L14;
        r15 = (HardwareBuffer) ZeusTransformUtils.preCheckCast(r3, HardwareBuffer.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34
        goto L41
    L22:
        r15 = null;
    L34:
        e = e;
        r5 = null;
        r7 = null;
        goto L36
    }

    public final Pair<Bitmap, HardwareBuffer> a(float r2, boolean r3) {
        if (r3 == false) goto L5;
        Object r4 = new a.C0722b(r2);
    L6:
        C0723b r1 = a((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        return new Pair(r1.a(), r1.b());
    L5:
        r4 = new a.C0721a(r2);
        goto L6
    }

    public final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(g.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean a(ParcelFileDescriptor r8, int r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "fd");
        return a((a) ZeusTransformUtils.preCheckCast(new a.c(r8, r9, r10, r11, r12), a.class, "com.obric.memorydata.plugin")).c();
    }
}
