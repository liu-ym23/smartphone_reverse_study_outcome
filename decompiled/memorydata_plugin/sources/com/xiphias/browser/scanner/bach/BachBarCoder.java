package com.xiphias.browser.scanner.bach;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.byted_bach_sdk.BachAlgorithmSystem;
import com.bytedance.byted_bach_sdk.BachResourceFinder;
import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmOutput;
import com.bytedance.byted_bach_sdk.buffer.BachObject;
import com.bytedance.byted_bach_sdk.finder.AssetResourceFinder;
import com.bytedance.byted_bach_sdk.input.BachAlgorithmInput;
import com.bytedance.byted_bach_sdk.input.BachBitmapInput;
import com.google.zxing.BarcodeFormat;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.barcode.SourceData;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0003,-.B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0016\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020*2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarCoder;", "Lcom/xiphias/browser/scanner/barcode/BarcodeDecoder;", "context", "Landroid/content/Context;", "resultCallback", "Lkotlin/Function1;", "Lcom/xiphias/browser/scanner/barcode/BarDecodeResult;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "sourceQueue", "Ljava/util/concurrent/BlockingQueue;", "Lcom/xiphias/browser/scanner/barcode/SourceData;", "running", "", "decodeThread", "Ljava/lang/Thread;", "startScan", "stopScan", "addSource", AILabCheckPermissionTask.KEY_SOURCE, "release", "runDecoder", "initialized", "Ljava/util/concurrent/CountDownLatch;", "initializationFailure", "Ljava/util/concurrent/atomic/AtomicReference;", "", "createRuntime", "Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachRuntime;", "graphMode", "Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode;", "createAlgorithmSystem", "Lcom/bytedance/byted_bach_sdk/BachAlgorithmSystem;", "finder", "Lcom/bytedance/byted_bach_sdk/finder/AssetResourceFinder;", "loadGraph", "", "assetPath", "decode", "algorithmSystem", "toBarcodeResult", "Lcom/bytedance/byted_bach_sdk/buffer/BachAlgorithmOutput;", "notifyGalleryFailure", "Companion", "BachGraphMode", "BachRuntime", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BachBarCoder implements com.xiphias.browser.scanner.barcode.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16323a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f16324b;
    private final Function1<com.xiphias.browser.scanner.barcode.a, Unit> c;
    private final BlockingQueue<SourceData> d;
    private volatile boolean e;
    private final Thread f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode;", "", "assetPath", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAssetPath", "()Ljava/lang/String;", "CAMERA", "GALLERY", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum BachGraphMode extends Enum<BachGraphMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ BachGraphMode[] $VALUES = null;
        public static final BachGraphMode CAMERA = null;
        public static final a Companion = null;
        public static final BachGraphMode GALLERY = null;
        private final String assetPath;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode$Companion;", "", "<init>", "()V", "from", "Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/xiphias/browser/scanner/barcode/SourceData;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: com.xiphias.browser.scanner.bach.BachBarCoder$BachGraphMode$a$a, reason: collision with other inner class name */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class C0853a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f16325a = null;

                static {
                    int[] r0 = new int[SourceData.Type.values().length];
                    r0[SourceData.Type.FROM_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r0[SourceData.Type.FROM_GALLERY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    f16325a = r0;
                }
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final BachGraphMode a(SourceData r1) {
                Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
                SourceData.Type r0 = r1.getType();
                int r2 = C0853a.f16325a[r0.ordinal()];
                if (r2 == 1) goto L10;
                if (r2 != 2) goto L8;
                return BachGraphMode.GALLERY;
            L8:
                throw new NoWhenBranchMatchedException();
            L10:
                return BachGraphMode.CAMERA;
            }
        }

        private static final /* synthetic */ BachGraphMode[] $values() {
            return new BachGraphMode[]{CAMERA, GALLERY};
        }

        static {
            CAMERA = new BachGraphMode("CAMERA", 0, "bach/qrcode_camera.json");
            GALLERY = new BachGraphMode("GALLERY", 1, "bach/qrcode_gallery.json");
            BachGraphMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private BachGraphMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.assetPath = r3;
        }

        public static EnumEntries<BachGraphMode> getEntries() {
            return $ENTRIES;
        }

        public static BachGraphMode valueOf(String r2) {
            return (BachGraphMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(BachGraphMode.class, r2), BachGraphMode.class, "com.obric.memorydata.plugin");
        }

        public static BachGraphMode[] values() {
            return (BachGraphMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BachGraphMode[].class, "com.obric.memorydata.plugin");
        }

        public final String getAssetPath() {
            return this.assetPath;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachRuntime;", "", "finder", "Lcom/bytedance/byted_bach_sdk/finder/AssetResourceFinder;", "algorithmSystem", "Lcom/bytedance/byted_bach_sdk/BachAlgorithmSystem;", "graphMode", "Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode;", "<init>", "(Lcom/bytedance/byted_bach_sdk/finder/AssetResourceFinder;Lcom/bytedance/byted_bach_sdk/BachAlgorithmSystem;Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode;)V", "getFinder", "()Lcom/bytedance/byted_bach_sdk/finder/AssetResourceFinder;", "getAlgorithmSystem", "()Lcom/bytedance/byted_bach_sdk/BachAlgorithmSystem;", "getGraphMode", "()Lcom/xiphias/browser/scanner/bach/BachBarCoder$BachGraphMode;", "destroy", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetResourceFinder f16326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BachAlgorithmSystem f16327b;
        private final BachGraphMode c;

        public a(AssetResourceFinder r2, BachAlgorithmSystem r3, BachGraphMode r4) {
            Intrinsics.checkNotNullParameter(r2, "finder");
            Intrinsics.checkNotNullParameter(r3, "algorithmSystem");
            Intrinsics.checkNotNullParameter(r4, "graphMode");
            this.f16326a = r2;
            this.f16327b = r3;
            this.c = r4;
        }

        public final BachAlgorithmSystem a() {
            return this.f16327b;
        }

        public final BachGraphMode b() {
            return this.c;
        }

        public final void c() {
            this.f16327b.destroy();     // Catch: Throwable -> L5
            this.f16326a.destroy();
            return;
        L5:
            th = move-exception;
            this.f16326a.destroy();
            throw th;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f16326a, r6.f16326a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f16327b, r6.f16327b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f16326a.hashCode() * 31) + this.f16327b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "BachRuntime(finder=" + this.f16326a + ", algorithmSystem=" + this.f16327b + ", graphMode=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarCoder$Companion;", "", "<init>", "()V", "TAG", "", "ENIGMA_NODE", "ENIGMA_OUTPUT_INDEX", "", "PARAM_CURRENT_ZOOM_FACTOR", "RESULT_TYPE", "RESULT_TEXT", "RESULT_ZOOM_FACTOR", "BUFFER_SIZE", "INIT_TIMEOUT_SECONDS", "", "RELEASE_TIMEOUT_MILLIS", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f16323a = new b(null);
    }

    public BachBarCoder(Context r6, Function1<? super com.xiphias.browser.scanner.barcode.a, Unit> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Function1<com.xiphias.browser.scanner.barcode.a, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "resultCallback");
        this.f16324b = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.c = r9;
        this.d = (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(5), BlockingQueue.class, "com.obric.memorydata.plugin");
        this.e = true;
        final CountDownLatch r10 = new CountDownLatch(1);
        final AtomicReference r11 = new AtomicReference();
        Thread r0 = new Thread(new $$Lambda$BachBarCoder$DS4KwdNYmWRc788o1MeCGuXwvw(this, r10, r11), "BachBarcodeDecoder");
        r0.start();
        this.f = r0;
        if (r10.await(10, TimeUnit.SECONDS) == false) goto L9;
        Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r11.get(), Throwable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Failed to initialize Bach barcode decoder", r5);
    L9:
        this.e = false;
        r0.interrupt();
        throw new IllegalStateException("Timed out while initializing Bach barcode decoder");
    }

    private final BachAlgorithmSystem a(AssetResourceFinder r4, BachGraphMode r5) {
        BachAlgorithmSystem.BachInitConfig r0 = new BachAlgorithmSystem.BachInitConfig();
        r0.finder = (BachResourceFinder) ZeusTransformUtils.preCheckCast(r4, BachResourceFinder.class, "com.obric.memorydata.plugin");
        r0.applicationName = "AScan";
        r0.deviceName = Build.DEVICE;
        r0.cacheFolder = this.f16324b.getCacheDir().getAbsolutePath();
        BachAlgorithmSystem r6 = new BachAlgorithmSystem(r0);
        r6.initGraph(a(r5.getAssetPath()));
        Log.i("BachBarCoder", "Loaded Bach graph: mode=" + r5 + ", asset=" + r5.getAssetPath());
        return r6;
    }

    private final a a(BachGraphMode r5) {
        AssetResourceFinder r0 = new AssetResourceFinder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f16324b.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return new a(r0, a(r0, r5), r5);
    L5:
        th = move-exception;
        r0.destroy();
        throw th;
    }

    private final com.xiphias.browser.scanner.barcode.a a(BachAlgorithmOutput r12, SourceData r13) {
        HashMap<String, BachObject>[] r11 = r12.m_dataMap;
        if (r11 != null) goto L5;
        r11 = new HashMap[0];
    L5:
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r11), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L24;
        BachObject r1 = (BachObject) ZeusTransformUtils.preCheckCast(r0.get("zoomInfoFactor"), BachObject.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L24;
        Float r2 = Float.valueOf(r1.asFloat());
        float r4 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r13.getType() == SourceData.Type.FROM_CAMERA) goto L12;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L24;
    L25:
        int r6 = r11.length;
        int r7 = 0;
    L26:
        if (r7 >= r6) goto L50;
        HashMap<String, BachObject> r8 = r11[r7];
        BachObject r9 = (BachObject) ZeusTransformUtils.preCheckCast(r8.get("enigmaText"), BachObject.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L30;
        String r10 = r9.asString();
    L31:
        BachObject r14 = (BachObject) ZeusTransformUtils.preCheckCast(r8.get("enigmaType"), BachObject.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L34;
        Long r15 = Long.valueOf(r14.asLong());
    L35:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L38;
    L41:
        boolean r17 = true;
    L42:
        if (r17 == true) goto L49;
        if (r15 == null) goto L49;
        BarcodeFormat r18 = com.xiphias.browser.scanner.bach.a.f16328a.a(r15.longValue());
        if (r18 == null) goto L49;
        return new com.xiphias.browser.scanner.barcode.a(r10, r18, r13.getType(), r2);
    L49:
        r7 = r7 + 1;
        goto L26
    L38:
        if (StringsKt.isBlank(r16) == true) goto L41;
        r17 = false;
        goto L42
    L34:
        r15 = null;
        goto L35
    L30:
        r10 = null;
        goto L31
    L50:
        if (r2 != null) goto L52;
        return null;
    L52:
        return new com.xiphias.browser.scanner.barcode.a(null, null, r13.getType(), Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).floatValue()));
    L12:
        if (Float.isInfinite(r4) == false) goto L14;
    L16:
        boolean r19 = false;
    L17:
        if (r19 == false) goto L21;
        if (r4 <= 0.0f) goto L21;
        r5 = true;
        goto L22
    L14:
        if (Float.isNaN(r4) == true) goto L16;
        r19 = true;
    L24:
        r2 = null;
        goto L25
    }

    private final String a(String r4) {
        InputStream r3 = this.f16324b.getAssets().open(r4);
        Intrinsics.checkNotNullExpressionValue(r3, "open(...)");
        Reader r5 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r3, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, BufferedReader.class) == false) goto L5;
        BufferedReader r6 = (BufferedReader) ZeusTransformUtils.preCheckCast(r5, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
        String r8 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r7, BufferedReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);
        return r8;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L5:
        r6 = new BufferedReader(r5, 8192);
        goto L6
    }

    private final void a(BachAlgorithmSystem r5, SourceData r6) {
        if (r6.getType() != SourceData.Type.FROM_CAMERA) goto L5;
        r5.setFloatParam("enigma", "enigma_current_zoomin_factor", r6.b());
    L5:
        BachAlgorithmSystem.BachErrorCode r0 = r5.execute((BachAlgorithmInput) ZeusTransformUtils.preCheckCast(new BachBitmapInput(r6.a()), BachAlgorithmInput.class, "com.obric.memorydata.plugin"));
        if (r0 == BachAlgorithmSystem.BachErrorCode.NO_ERROR) goto L9;
        Log.e("BachBarCoder", "Bach execute failed: " + r0);
        b(r6);
        return;
    L9:
        BachAlgorithmOutput r7 = r5.getResult("enigma", 0);
        if (r7 == null) goto L12;
        com.xiphias.browser.scanner.barcode.a r8 = a(r7, r6);
    L13:
        if (r8 == null) goto L15;
        this.c.invoke(r8);
        return;
    L15:
        b(r6);
        return;
    L12:
        r8 = null;
        goto L13
    }

    private static final void a(BachBarCoder r0, CountDownLatch r1, AtomicReference r2) {
        r0.a(r1, r2);
    }

    private final void a(CountDownLatch r7, AtomicReference<Throwable> r8) {
        a r0 = null;
        a r1 = a(BachGraphMode.CAMERA);     // Catch: Throwable -> L25 InterruptedException -> L44
        r7.countDown();     // Catch: Throwable -> L22 InterruptedException -> L24
    L6:
        if (this.e == false) goto L19;
        SourceData r2 = (SourceData) ZeusTransformUtils.preCheckCast(this.d.take(), SourceData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22 InterruptedException -> L24
        BachGraphMode.a r3 = BachGraphMode.Companion;     // Catch: Throwable -> L22 InterruptedException -> L24
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L22 InterruptedException -> L24
        BachGraphMode r4 = r3.a(r2);     // Catch: Throwable -> L22 InterruptedException -> L24
        if (r1 == null) goto L18;
        if (r4 == r1.b()) goto L13;
        r1.c();     // Catch: Throwable -> L25 InterruptedException -> L44
        r1 = a(r4);     // Catch: Throwable -> L25 InterruptedException -> L44
    L13:
        if (r1 == null) goto L16;
        a(r1.a(), r2);     // Catch: Throwable -> L22 InterruptedException -> L24
        goto L6
    L16:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L22 InterruptedException -> L24
    L18:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L22 InterruptedException -> L24
    L19:
        r7.countDown();
        if (r1 == null) goto L55;
    L21:
        r1.c();
        return;
    L55:
        return;
    L24:
        r0 = r1;
    L22:
        th = th;
    L45:
        r8.compareAndSet(null, th);     // Catch: Throwable -> L31
        Log.e("BachBarCoder", "Bach decoder stopped", th);     // Catch: Throwable -> L31
        r7.countDown();
        if (r1 != null) goto L21;
        return;
    L31:
        th = th;
    L40:
        r7.countDown();
        if (r1 == null) goto L43;
        r1.c();
    L43:
        throw th;
    L25:
        th = th;
        r1 = null;
    L47:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L38
        r7.countDown();
        if (r0 == null) goto L58;
        r0.c();
        return;
    L58:
        return;
    L38:
        th = th;
        r1 = r0;
        goto L40
    }

    private final void b(SourceData r9) {
        if (r9.getType() != SourceData.Type.FROM_GALLERY) goto L6;
        this.c.invoke(new com.xiphias.browser.scanner.barcode.a(null, null, r9.getType(), null, 8, null));
        return;
    }

    /* JADX INFO: renamed from: lambda$DS4KwdNYmWRc788-o1MeCGuXwvw, reason: not valid java name */
    public static /* synthetic */ void m1410lambda$DS4KwdNYmWRc788o1MeCGuXwvw(BachBarCoder r0, CountDownLatch r1, AtomicReference r2) {
        a(r0, r1, r2);
    }

    @Override // com.xiphias.browser.scanner.barcode.b
    public void a() {
        this.d.clear();
    }

    @Override // com.xiphias.browser.scanner.barcode.b
    public boolean a(SourceData r3) {
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        if (r3.getType() != SourceData.Type.FROM_GALLERY) goto L5;
        this.d.clear();     // Catch: InterruptedException -> L8
        this.d.put(r3);     // Catch: InterruptedException -> L8
        return true;
    L8:
        Thread.currentThread().interrupt();
        return false;
    L5:
        return this.d.offer(r3);
    }

    @Override // com.xiphias.browser.scanner.barcode.b
    public void b() {
        this.d.clear();
        this.c.invoke(null);
    }

    @Override // com.xiphias.browser.scanner.barcode.b
    public void c() {
        this.e = false;
        this.d.clear();
        this.f.interrupt();
        this.f.join(500);     // Catch: InterruptedException -> L5
    L6:
        this.c.invoke(null);
        return;
    L5:
        Thread.currentThread().interrupt();
        goto L6
    }
}
