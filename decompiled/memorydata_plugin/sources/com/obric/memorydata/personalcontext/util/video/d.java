package com.obric.memorydata.personalcontext.util.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.au;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0010\u0018\u0000 ^2\u00020\u0001:\u0002]^B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(H\u0002J\\\u0010)\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010,J4\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H/\u0012\u0004\u0012\u00020\r0.\"\u0004\b\u0000\u0010/2\u0006\u00100\u001a\u00020\u001c2\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H/02H\u0002J\u0014\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u00106\u001a\u0002042\u0006\u00105\u001a\u00020\u000eH\u0002J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u0002042\u0006\u0010:\u001a\u000204H\u0002J\u0018\u0010;\u001a\u0002082\u0006\u00109\u001a\u00020<2\u0006\u0010:\u001a\u00020<H\u0002J\"\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\b\b\u0002\u0010@\u001a\u000208H\u0002J$\u0010A\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u0001042\b\u0010:\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u000208H\u0002J\u001e\u0010B\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010C\u001a\u00020&H\u0002J\u0018\u0010D\u001a\u0004\u0018\u00010\u000e2\u0006\u0010E\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020\rH\u0002J\b\u0010H\u001a\u00020\u001aH\u0002JF\u0010D\u001a\u00020I2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010E\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010JJF\u0010K\u001a\u00020I2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010E\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010JJ\u0016\u0010L\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\nJ&\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ8\u0010P\u001a\u00020\n2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J \u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\nH\u0002J \u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020O2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0002J\u0010\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/KeyframeExtractor;", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "savedFrameIndexSet", "", "", "frameMap", "", "", "Landroid/graphics/Bitmap;", "extractor", "Landroid/media/MediaExtractor;", "codec", "Landroid/media/MediaCodec;", "colorFormat", "width", "height", Key.ROTATION, "duration", "minInterval", LBSLightLocationTraceLogger.PREPARE, "", "convertToNewType", "", "mimeType", "isInitialized", "", "extractKeyFrameTimeUs", "Lcom/obric/memorydata/personalcontext/util/video/KeyFramesInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doExtractKeyFrameTimeUs", "compareFinalResult", "", "Lcom/obric/memorydata/personalcontext/util/video/KeyFrame;", "keyframes", "", "recursiveExtract", "startKeyFrame", "endKeyFrame", "(Ljava/util/List;Lcom/obric/memorydata/personalcontext/util/video/KeyFrame;Lcom/obric/memorydata/personalcontext/util/video/KeyFrame;Landroid/media/MediaExtractor;Landroid/media/MediaCodec;IIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcTimeConsumed", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, LocationMonitorConst.TAG, "function", "Lkotlin/Function0;", "calculateHistogram", "Lcom/obric/memorydata/personalcontext/util/video/ColorHistogram;", "bitmap", "calculateColorHistogram", "compareColorHistograms", "", "hist1", "hist2", "histogramIntersection", "", "compareKeyFrame", "frame1", "frame2", "similarityThreshold", "compareHistograms", "addKeyFrame", TypedValues.AttributesType.S_FRAME, "getFrameAtTimeUs", "timeUs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDurationUs", "destroy", "Lcom/obric/memorydata/personalcontext/util/video/KeyframeExtractor$ExtractResult;", "(Landroid/media/MediaExtractor;Landroid/media/MediaCodec;IIIIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractFrameAtTimeUs", "rotateBitmapIfNeeded", "yuvToBitmap", "yuvData", "", "yuvToArgbPixel", "x", "y", "yuvToArgb", "yValue", "uValue", "vValue", "getUnsignedByte", "data", "index", "defaultValue", "clampColor", EventBody.KEY_VALUE, "ExtractResult", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12389b;
    private final Uri c;
    private final Set<Integer> d;
    private final Map<Long, Bitmap> e;
    private MediaExtractor f;
    private MediaCodec g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private int m;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/KeyframeExtractor$Companion;", "", "<init>", "()V", "TAG", "", "TIMEOUT_SINGLE_FRAME_EXTRACTION_MS", "", "TIMEOUT_ENQUEUE_DEQUEUE_CODEC_US", "WAITING_DURATION_MS", "MAX_FRAME_COUNT", "", "SIMILARITY_THRESHOLD_FAST", "", "SIMILARITY_THRESHOLD_FINAL", "MIN_FRAME_INTERVAL", "MAX_FRAME_DIMENSION", "HISTOGRAM_BIN_COUNT", "DEFAULT_Y_VALUE", "DEFAULT_UV_VALUE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/KeyframeExtractor$ExtractResult;", "", "endExtract", "", "frameData", "Landroid/graphics/Bitmap;", "<init>", "(ZLandroid/graphics/Bitmap;)V", "getEndExtract", "()Z", "getFrameData", "()Landroid/graphics/Bitmap;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bitmap f12391b;

        public b(boolean r1, Bitmap r2) {
            this.f12390a = r1;
            this.f12391b = r2;
        }

        public final Bitmap a() {
            return this.f12391b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f12390a == r6.f12390a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12391b, r6.f12391b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f12390a) * 31;
            Bitmap r1 = this.f12391b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ExtractResult(endExtract=" + this.f12390a + ", frameData=" + this.f12391b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12388a = new a(null);
    }

    public d(Context r3, Uri r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        this.f12389b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.m = 2;
    }

    private final float a(com.obric.memorydata.personalcontext.util.video.a r4, com.obric.memorydata.personalcontext.util.video.a r5) {
        float r0 = a(r4.a(), r5.a());
        float r1 = a(r4.b(), r5.b());
        float r3 = a(r4.c(), r5.c());
        RunLog.INSTANCE.debug("KeyframeExtractor5", "compareColorHistograms similarityR: " + r0 + ", similarityG: " + r1 + ", similarityB: " + r3);
        return Math.min(r0, Math.min(r1, r3));
    }

    private final float a(float[] r4, float[] r5) {
        float r3 = 0.0f;
        int r0 = 0;
    L4:
        if (r0 >= 256) goto L6;
        r3 = r3 + Math.min(r4[r0], r5[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    private final int a(int r3) {
        boolean r2 = true;
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return r3;
    L11:
        if (Integer.MIN_VALUE > r3) goto L14;
        if (r3 >= 0) goto L14;
    L15:
        if (r2 == true) goto L19;
        return 255;
    L19:
        return 0;
    L14:
        r2 = false;
        goto L15
    L5:
        if (r3 >= 256) goto L7;
        r1 = true;
        goto L8
    }

    private final int a(int r3, int r4, int r5) {
        int r6 = r4 - 128;
        int r7 = r5 - 128;
        int r8 = Math.max(0, r3 - 16) * 298;
        return a(((r8 + (r6 * 516)) + 128) >> 8) | (((a((((r7 * 409) + r8) + 128) >> 8) << 16) | ViewCompat.MEASURED_STATE_MASK) | (a((((r8 - (r6 * 100)) - (r7 * 208)) + 128) >> 8) << 8));
    }

    private final int a(byte[] r2, int r3, int r4) {
        boolean r1 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r1 == true) goto L9;
        return r4;
    L9:
        return r2[r3] & 255;
    L5:
        if (r3 >= r2.length) goto L7;
        r1 = true;
        goto L7
    }

    private final int a(byte[] r7, int r8, int r9, int r10, int r11, int r12) {
        int r0 = r8 * r9;
        int r1 = r8 / 2;
        int r13 = r9 / 2;
        int r2 = a(r7, (r11 * r8) + r10, 16);
        int r14 = r11 / 2;
        int r15 = r10 / 2;
        int r3 = (r14 * r1) + r15;
        if (r12 != 19) goto L5;
        int r16 = r0 + r3;
        int r4 = (r0 + (r1 * r13)) + r3;
    L13:
        Integer r17 = Integer.valueOf(a(r7, r16, 128));
    L14:
        Pair r18 = TuplesKt.to(r17, Integer.valueOf(a(r7, r4, 128)));
        return a(r2, ((Number) ZeusTransformUtils.preCheckCast(r18.component1(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r18.component2(), Number.class, "com.obric.memorydata.plugin")).intValue());
    L5:
        if (r12 != 21) goto L7;
        int r5 = (r0 + (r14 * r8)) + (r15 * 2);
        r17 = Integer.valueOf(a(r7, r5, 128));
        r4 = r5 + 1;
        goto L14
    L7:
        if (r12 != 39) goto L10;
        r4 = (r0 + (r14 * r8)) + (r15 * 2);
        r16 = r4 + 1;
        goto L13
    L10:
        throw new IllegalArgumentException("Unsupported color format: " + r12);
    }

    private static final Bitmap a(d r0, byte[] r1, int r2, int r3, int r4, int r5) {
        return r0.a(r0.a(r1, r2, r3, r4), r5);
    }

    private final com.obric.memorydata.personalcontext.util.video.a a(final Bitmap r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Pair r4 = a("calculateHistogram", new $$Lambda$d$nZ6wjlcMdnQfFT2CiIrQvy3YaY(this, r5));
        RunLog.INSTANCE.debug("KeyframeExtractor5", "calculateHistogram, time consumed: " + ((Number) ZeusTransformUtils.preCheckCast(r4.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue());
        return (com.obric.memorydata.personalcontext.util.video.a) ZeusTransformUtils.preCheckCast(r4.getFirst(), com.obric.memorydata.personalcontext.util.video.a.class, "com.obric.memorydata.plugin");
    }

    private static final com.obric.memorydata.personalcontext.util.video.a a(d r0, Bitmap r1) {
        return r0.b(r1);
    }

    private final Object a(long r13, Continuation<? super Bitmap> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, KeyframeExtractor$getFrameAtTimeUs$1.class) == false) goto L7;
        KeyframeExtractor$getFrameAtTimeUs$1 r0 = (KeyframeExtractor$getFrameAtTimeUs$1) ZeusTransformUtils.preCheckCast(r16, KeyframeExtractor$getFrameAtTimeUs$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        KeyframeExtractor$getFrameAtTimeUs$1 r11 = r0;
        Object r17 = r11.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r11.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r17);
    L27:
        return ((b) ZeusTransformUtils.preCheckCast(r17, b.class, "com.obric.memorydata.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        if (b() == true) goto L17;
        return null;
    L17:
        MediaExtractor r18 = this.f;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r18 = null;
    L20:
        MediaCodec r4 = this.g;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("codec");
        r4 = null;
    L23:
        int r5 = this.h;
        int r6 = this.i;
        int r7 = this.j;
        int r8 = this.k;
        r11.label = 1;
        r17 = a(r18, r4, r5, r6, r7, r8, r13, r11);
        if (r17 != r1) goto L27;
        return r1;
    L7:
        r0 = new KeyframeExtractor$getFrameAtTimeUs$1(this, r16);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v21, types: [T, com.obric.memorydata.personalcontext.util.video.d$b] */
    private final Object a(MediaExtractor r18, MediaCodec r19, int r20, int r21, int r22, int r23, long r24, Continuation<? super b> r26) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, KeyframeExtractor$getFrameAtTimeUs$2.class) == false) goto L7;
        KeyframeExtractor$getFrameAtTimeUs$2 r2 = (KeyframeExtractor$getFrameAtTimeUs$2) ZeusTransformUtils.preCheckCast(r1, KeyframeExtractor$getFrameAtTimeUs$2.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        KeyframeExtractor$getFrameAtTimeUs$2 r14 = r2;
        Object r3 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        if (r4 == 0) goto L19;
        if (r4 != 1) goto L18;
        long r5 = r14.J$0;
        Ref.ObjectRef r0 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r14.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L14 TimeoutCancellationException -> L16
    L42:
    L40:
        return r0.element;
    L16:
        long r6 = r5;
    L38:
        RunLog.INSTANCE.debug("KeyframeExtractor5", "getFrameAtTimeUs timeout timeUs: " + r6);
        r0.element = new b(false, null);
        goto L40
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r3);
        if (this.e.get(Boxing.boxLong(r24)) != null) goto L22;
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        Ref.ObjectRef r16 = r11;
        Function2 r7 = (Function2) ZeusTransformUtils.preCheckCast(new KeyframeExtractor$getFrameAtTimeUs$3(r11, this, r18, r19, r20, r21, r22, r23, r24, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14 TimeoutCancellationException -> L33
        r14.L$0 = r16;     // Catch: Exception -> L14 TimeoutCancellationException -> L33
        r6 = r24;
        r14.J$0 = r6;     // Catch: Exception -> L14 TimeoutCancellationException -> L41
        r14.label = 1;     // Catch: Exception -> L14 TimeoutCancellationException -> L41
        if (da.a(2000, r7, r14) != r15) goto L32;
        return r15;
    L32:
        r0 = r16;
    L37:
        r0 = r16;
    L33:
        r6 = r24;
    L36:
        r6 = r24;
        r16 = r11;
        goto L37
    L22:
        return new b(false, (Bitmap) ZeusTransformUtils.preCheckCast(this.e.get(Boxing.boxLong(r24)), Bitmap.class, "com.obric.memorydata.plugin"));
    L14:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "getFrameAtTimeUs exception: " + e, null, 4, null);
        throw new UnSupportVideoFileException("exception happened when extractFrameAtTimeUs for [" + e.getMessage() + ']');
    L7:
        r2 = new KeyframeExtractor$getFrameAtTimeUs$2(this, r1);
        goto L8
    }

    public static final /* synthetic */ Object a(d r2, long r3, Continuation r5) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r11, MediaExtractor r12, MediaCodec r13, int r14, int r15, int r16, int r17, long r18, Continuation r20) {
        return r11.a(r12, r13, r14, r15, r16, r17, r18, (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r13, List r14, com.obric.memorydata.personalcontext.util.video.b r15, com.obric.memorydata.personalcontext.util.video.b r16, MediaExtractor r17, MediaCodec r18, int r19, int r20, int r21, int r22, Continuation r23) {
        return r13.a((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), r15, r16, r17, r18, r19, r20, r21, r22, (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(List<com.obric.memorydata.personalcontext.util.video.b> r23, com.obric.memorydata.personalcontext.util.video.b r24, com.obric.memorydata.personalcontext.util.video.b r25, MediaExtractor r26, MediaCodec r27, int r28, int r29, int r30, int r31, Continuation<? super Unit> r32) {
        com.obric.memorydata.personalcontext.util.video.b r11 = r24;
        List<com.obric.memorydata.personalcontext.util.video.b> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r32, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, KeyframeExtractor$recursiveExtract$1.class) == false) goto L7;
        KeyframeExtractor$recursiveExtract$1 r2 = (KeyframeExtractor$recursiveExtract$1) ZeusTransformUtils.preCheckCast(r1, KeyframeExtractor$recursiveExtract$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        KeyframeExtractor$recursiveExtract$1 r14 = r2;
        Object r3 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r3);
    L47:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r5 = r14.I$5;
        int r6 = r14.I$4;
        int r7 = r14.I$3;
        int r8 = r14.I$2;
        int r9 = r14.I$1;
        int r10 = r14.I$0;
        com.obric.memorydata.personalcontext.util.video.b r12 = (com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r14.L$5, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin");
        MediaCodec r16 = (MediaCodec) ZeusTransformUtils.preCheckCast(r14.L$4, MediaCodec.class, "com.obric.memorydata.plugin");
        MediaExtractor r17 = (MediaExtractor) ZeusTransformUtils.preCheckCast(r14.L$3, MediaExtractor.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.util.video.b r18 = (com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r14.L$2, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.personalcontext.util.video.b> r19 = (List) ZeusTransformUtils.preCheckCast(r14.L$1, List.class, "com.obric.memorydata.plugin");
        d r0 = (d) ZeusTransformUtils.preCheckCast(r14.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        MediaCodec r20 = r16;
        MediaExtractor r110 = r17;
        Object r111 = r15;
        List<com.obric.memorydata.personalcontext.util.video.b> r112 = r19;
        int r21 = r5;
    L37:
        int r113 = r6;
        com.obric.memorydata.personalcontext.util.video.b r22 = r18;
        int r33 = r10;
        com.obric.memorydata.personalcontext.util.video.b r34 = r22;
    L39:
        if ((r113 - r21) < r0.m) goto L49;
        if (a(r0, r12, r34, 0.0f, 4, null) == false) goto L43;
        r34.a(r12.c());
        r0.a(r112, r12);
        goto L49
    L43:
        r34.a(r113);
        r0.a(r112, r12);
        r0.a(r112, r34);
        r14.L$0 = null;
        r14.L$1 = null;
        r14.L$2 = null;
        r14.L$3 = null;
        r14.L$4 = null;
        r14.L$5 = null;
        r14.label = 3;
        if (r0.a(r112, r12, r34, r110, r20, r33, r9, r8, r7, r14) != r111) goto L47;
        return r111;
    L49:
        return Unit.INSTANCE;
    L17:
        int r35 = r14.I$6;
        int r36 = r14.I$5;
        int r37 = r14.I$4;
        int r38 = r14.I$3;
        int r39 = r14.I$2;
        int r40 = r14.I$1;
        r33 = r14.I$0;
        MediaCodec r114 = (MediaCodec) ZeusTransformUtils.preCheckCast(r14.L$5, MediaCodec.class, "com.obric.memorydata.plugin");
        MediaExtractor r115 = (MediaExtractor) ZeusTransformUtils.preCheckCast(r14.L$4, MediaExtractor.class, "com.obric.memorydata.plugin");
        r34 = (com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r14.L$3, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.util.video.b r41 = (com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r14.L$2, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.personalcontext.util.video.b> r116 = (List) ZeusTransformUtils.preCheckCast(r14.L$1, List.class, "com.obric.memorydata.plugin");
        r0 = (d) ZeusTransformUtils.preCheckCast(r14.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        int r117 = r37;
        MediaCodec r42 = r114;
        r112 = r116;
        int r43 = r35;
        r113 = r36;
        Object r44 = r3;
        MediaExtractor r45 = r115;
        r11 = r41;
    L26:
        Bitmap r46 = ((b) ZeusTransformUtils.preCheckCast(r44, b.class, "com.obric.memorydata.plugin")).a();
        com.obric.memorydata.personalcontext.util.video.b r118 = new com.obric.memorydata.personalcontext.util.video.b(r43, r0.a(r46), r43, r46, false, 16, null);
        if ((r43 - r117) >= r0.m) goto L30;
        r0.a(r112, r11);
        r118.a(r11.c());
    L32:
        r110 = r45;
        r20 = r42;
        r21 = r43;
        r7 = r38;
        r8 = r39;
        r9 = r40;
        r12 = r118;
        r111 = r15;
        goto L39
    L30:
        if (a(r0, r11, r118, 0.0f, 4, null) == false) goto L33;
        r118.a(r11.c());
        r0.a(r112, r11);
        goto L32
    L33:
        r118.a(r43);
        r0.a(r112, r11);
        r0.a(r112, r118);
        r14.L$0 = r0;
        r14.L$1 = r112;
        r14.L$2 = r34;
        r14.L$3 = r45;
        r14.L$4 = r42;
        r14.L$5 = r118;
        r14.I$0 = r33;
        r14.I$1 = r40;
        r14.I$2 = r39;
        r14.I$3 = r38;
        r14.I$4 = r113;
        r14.I$5 = r43;
        r14.label = 2;
        Object r47 = r0.a(r112, r11, r118, r45, r42, r33, r40, r39, r38, r14);
        r111 = r15;
        if (r47 != r111) goto L36;
        return r111;
    L36:
        r110 = r45;
        r20 = r42;
        r21 = r43;
        r7 = r38;
        r8 = r39;
        r9 = r40;
        r6 = r113;
        r12 = r118;
        int r210 = r33;
        r18 = r34;
        r10 = r210;
        goto L37
    L18:
        ResultKt.throwOnFailure(r3);
        int r48 = r24.a();
        int r49 = r25.a();
        if ((r49 - r48) >= this.m) goto L22;
        a(r13, r11);
        return Unit.INSTANCE;
    L22:
        int r50 = (r48 + r49) / 2;
        long r119 = ((long) r50) * TimeUtils.NANOSECONDS_PER_MILLISECOND;
        r14.L$0 = this;
        r14.L$1 = r13;
        r14.L$2 = r11;
        r14.L$3 = r25;
        r14.L$4 = r26;
        r14.L$5 = r27;
        r14.I$0 = r28;
        r14.I$1 = r29;
        r14.I$2 = r30;
        r14.I$3 = r31;
        r14.I$4 = r48;
        r14.I$5 = r49;
        r14.I$6 = r50;
        r14.label = 1;
        r117 = r48;
        Object r51 = a(r26, r27, r28, r29, r30, r31, r119, r14);
        if (r51 != r15) goto L25;
        return r15;
    L25:
        r0 = this;
        r34 = r25;
        r42 = r27;
        r33 = r28;
        r40 = r29;
        r39 = r30;
        r38 = r31;
        r44 = r51;
        r112 = r13;
        r113 = r49;
        r43 = r50;
        r45 = r26;
    L7:
        r2 = new KeyframeExtractor$recursiveExtract$1(this, r1);
        goto L8
    }

    private final String a(String r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (Intrinsics.areEqual(r1, "video/dolby-vision") == false) goto L8;
        return "video/hevc";
    L8:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<com.obric.memorydata.personalcontext.util.video.b> a(List<com.obric.memorydata.personalcontext.util.video.b> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("KeyframeExtractor5", "compareFinalResult origin size: " + r10.size());
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r2 = r12.next();
        if (((com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin")).d() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.personalcontext.util.video.b> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (r13.size() <= 1) goto L16;
        r1.add(r13.get(0));
        com.obric.memorydata.personalcontext.util.video.b r3 = (com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r13.get(0), com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin");
        int r5 = r13.size();
    L11:
        if (r4 >= r5) goto L17;
        com.obric.memorydata.personalcontext.util.video.b r6 = (com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r13.get(r4), com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin");
        if (a(r3, r6, 0.8f) == true) goto L15;
        r1.add(r6);
        r3 = r6;
    L15:
        r4 = r4 + 1;
    L17:
        RunLog.INSTANCE.debug("KeyframeExtractor5", "compareFinalResult final size: " + r1.size());
        return r1;
    L16:
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"));
        goto L17
    }

    public static final /* synthetic */ Map a(d r0) {
        return r0.e;
    }

    private final <T> Pair<T, Long> a(String r3, Function0<? extends T> r4) {
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        long r5 = System.currentTimeMillis();
        return TuplesKt.to(r2.invoke(), Long.valueOf(System.currentTimeMillis() - r5));
    }

    private final void a(List<com.obric.memorydata.personalcontext.util.video.b> r4, com.obric.memorydata.personalcontext.util.video.b r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (this.d.contains(Integer.valueOf(r5.c())) == true) goto L6;
        RunLog.INSTANCE.debug("KeyframeExtractor5", "addKeyFrame index: " + r5.a());
        r6.add(r5);
        this.d.add(Integer.valueOf(r5.c()));
        return;
    }

    private final boolean a(com.obric.memorydata.personalcontext.util.video.a r8, com.obric.memorydata.personalcontext.util.video.a r9, float r10) {
        if (r8 == null) goto L11;
        if (r9 == null) goto L11;
        float r7 = a(r8, r9);
        RunLog.INSTANCE.debug("KeyframeExtractor5", "compareHistograms similarity: " + r7);
        if (r7 >= r10) goto L13;
        return false;
    L13:
        return true;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "compareHistograms null list", null, 4, null);
        return true;
    }

    private final boolean a(com.obric.memorydata.personalcontext.util.video.b r4, com.obric.memorydata.personalcontext.util.video.b r5, float r6) {
        RunLog.INSTANCE.debug("KeyframeExtractor5", "compareKeyFrame frame1: " + r4.a() + ", frame2: " + r5.a());
        return a(r4.b(), r5.b(), r6);
    }

    static /* synthetic */ boolean a(d r0, com.obric.memorydata.personalcontext.util.video.b r1, com.obric.memorydata.personalcontext.util.video.b r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0.8f;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final com.obric.memorydata.personalcontext.util.video.a b(Bitmap r21) {
        float[] r1 = new float[256];
        float[] r2 = new float[256];
        float[] r3 = new float[256];
        int r4 = r21.getWidth();
        int[] r13 = new int[r4];
        int r14 = r21.getHeight();
        float r17 = 0.0f;
        int r12 = 0;
    L3:
        if (r12 >= r14) goto L9;
        int r19 = r12;
        r21.getPixels(r13, 0, r21.getWidth(), 0, r12, r21.getWidth(), 1);
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        int r6 = r13[r5];
        int r7 = (r6 >> 16) & 255;
        r1[r7] = r1[r7] + 1.0f;
        int r8 = (r6 >> 8) & 255;
        r2[r8] = r2[r8] + 1.0f;
        int r9 = r6 & 255;
        r3[r9] = r3[r9] + 1.0f;
        r5 = r5 + 1;
        goto L5
    L7:
        r17 = r17 + r21.getWidth();
        r12 = r19 + 1;
        goto L3
    L9:
        if (r17 <= 0.0f) goto L14;
        int r10 = 0;
    L11:
        if (r10 >= 256) goto L14;
        r1[r10] = r1[r10] / r17;
        r2[r10] = r2[r10] / r17;
        r3[r10] = r3[r10] / r17;
        r10 = r10 + 1;
    L14:
        return new com.obric.memorydata.personalcontext.util.video.a(r1, r2, r3);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0381 -> B:56:0x0385). Please report as a decompilation issue!!! */
    private final Object b(MediaExtractor r25, MediaCodec r26, int r27, int r28, int r29, int r30, long r31, Continuation<? super b> r33) {
        String r1 = ", error: ";
        String r4 = "com.obric.memorydata.plugin";
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r33, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, KeyframeExtractor$extractFrameAtTimeUs$1.class) == false) goto L7;
        KeyframeExtractor$extractFrameAtTimeUs$1 r5 = (KeyframeExtractor$extractFrameAtTimeUs$1) ZeusTransformUtils.preCheckCast(r3, KeyframeExtractor$extractFrameAtTimeUs$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        String r11 = "KeyframeExtractor5";
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        long r12 = r5.J$0;
        int r0 = r5.I$3;
        int r9 = r5.I$2;
        int r14 = r5.I$1;
        int r15 = r5.I$0;
        MediaCodec.BufferInfo r10 = (MediaCodec.BufferInfo) ZeusTransformUtils.preCheckCast(r5.L$3, MediaCodec.BufferInfo.class, "com.obric.memorydata.plugin");
        MediaCodec r13 = (MediaCodec) ZeusTransformUtils.preCheckCast(r5.L$2, MediaCodec.class, "com.obric.memorydata.plugin");
        MediaExtractor r2 = (MediaExtractor) ZeusTransformUtils.preCheckCast(r5.L$1, MediaExtractor.class, "com.obric.memorydata.plugin");
        d r16 = (d) ZeusTransformUtils.preCheckCast(r5.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        MediaExtractor r17 = r2;
        String r19 = ", error: ";
        KeyframeExtractor$extractFrameAtTimeUs$1 r18 = r5;
        MediaCodec.BufferInfo r110 = r10;
        MediaCodec r20 = r13;
        String r111 = "KeyframeExtractor5";
        int r21 = r0;
        String r22 = "com.obric.memorydata.plugin";
    L56:
        Object r32 = r7;
        r4 = r22;
        r11 = r111;
        int r23 = r14;
        int r24 = r15;
        MediaCodec.BufferInfo r112 = r110;
        int r113 = 2;
    L51:
        KeyframeExtractor$extractFrameAtTimeUs$1 r114 = r18;
        r1 = r19;
    L17:
        r17.seekTo(r12, r113);
        KeyframeExtractor$extractFrameAtTimeUs$1 r34 = r114;
        final int r115 = r24;
        final int r116 = r21;
        RunLog.INSTANCE.debug(r11, new StringBuilder().append("try to get frame at timeUs: ").append(r12).append(" after seek extractor.sampleTime: ").append(r17.getSampleTime()).append(", duration: ").append(r16.l).toString());
        long r35 = r17.getSampleTime();
        String r117 = r11;
        int r118 = r20.dequeueInputBuffer(100000);     // Catch: Exception -> L20
    L23:
        if (r118 < 0) goto L29;
        ByteBuffer r36 = r20.getInputBuffer(r118);
        Intrinsics.checkNotNull(r36);
        int r37 = r17.readSampleData(r36, 0);
        if (r37 < 0) goto L26;
        r20.queueInputBuffer(r118, 0, r37, r35, 0);
        goto L29
    L26:
        r20.queueInputBuffer(r118, 0, 0, 0, 4);
        return new b(true, null);
    L29:
        long r210 = r12;
        if (r118 < 0) goto L52;
        int r38 = r20.dequeueOutputBuffer(r112, 100000);     // Catch: Exception -> L34
        long r39 = r210;
    L36:
        r19 = r1;
        RunLog.INSTANCE.debug(r117, "inputBufferIndex: " + r118 + ", outputBufferIndex: " + r38);
        if (r38 < 0) goto L46;
        ByteBuffer r40 = r20.getOutputBuffer(r38);
        String r119 = r4;
        long r120 = r112.presentationTimeUs;
        MediaExtractor r211 = r17;
        long r212 = r39;
        RunLog.INSTANCE.debug(r117, "presentationTime ms: " + r120 + " target time: " + r35);
        if (r120 == r35) goto L40;
        r20.releaseOutputBuffer(r38, false);
        r17 = r211;
        r4 = r119;
        r11 = r117;
        r21 = r116;
        r1 = r19;
        r24 = r115;
        r12 = r212;
        r113 = 2;
        r114 = r34;
        goto L17
    L40:
        final byte[] r41 = new byte[r112.size];
        if (r40 == null) goto L43;
        r40.get(r41);
    L43:
        final d r213 = r16;
        final int r214 = r23;
        final int r215 = r9;
        Pair r42 = r16.a("create bitmap", new $$Lambda$d$7heV4ToexYem71K5rRABW0s8bA(r213, r41, r214, r215, r115, r116));
        RunLog.INSTANCE.debug(r117, "create bitmap time consumed: " + ((Number) ZeusTransformUtils.preCheckCast(r42.getSecond(), Number.class, r119)).longValue());
        b r43 = new b(false, (Bitmap) ZeusTransformUtils.preCheckCast(r42.getFirst(), Bitmap.class, r119));
        r20.releaseOutputBuffer(r38, false);
        return r43;
    L46:
        r18 = r34;
        long r216 = r39;
        String r44 = r4;
        r18.L$0 = r16;
        r17 = r17;
        r18.L$1 = r17;
        r18.L$2 = r20;
        r18.L$3 = r112;
        r18.I$0 = r115;
        r18.I$1 = r23;
        r18.I$2 = r9;
        r21 = r116;
        r18.I$3 = r21;
        r18.J$0 = r216;
        r18.label = 1;
        Object r121 = r32;
        if (au.a(10, r18) != r121) goto L50;
        return r121;
    L50:
        r32 = r121;
        r4 = r44;
        r11 = r117;
        r24 = r115;
        r12 = r216;
        r113 = 2;
        r23 = r23;
    L34:
        e = move-exception;
        r39 = r210;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r4), "KeyframeExtractor5", "codec.dequeueOutputBuffer failed at timeUs: " + r39 + r1 + e, null, 4, null);
        r38 = -1;
        goto L36
    L52:
        Object r122 = r32;
        r19 = r1;
        r22 = r4;
        r21 = r116;
        r111 = r117;
        r18 = r34;
        r18.L$0 = r16;
        r18.L$1 = r17;
        r18.L$2 = r20;
        r18.L$3 = r112;
        r18.I$0 = r115;
        r18.I$1 = r23;
        r18.I$2 = r9;
        r18.I$3 = r21;
        r18.J$0 = r210;
        r18.label = 2;
        r110 = r112;
        if (au.a(10, r18) != r122) goto L55;
        return r122;
    L55:
        r15 = r115;
        r14 = r23;
        r7 = r122;
        r12 = r210;
    L20:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r4), "KeyframeExtractor5", "codec.dequeueInputBuffer failed at timeUs: " + r12 + r1 + e, null, 4, null);
        r118 = -1;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r45 = r5.J$0;
        int r46 = r5.I$3;
        int r47 = r5.I$2;
        int r123 = r5.I$1;
        int r124 = r5.I$0;
        MediaCodec.BufferInfo r125 = (MediaCodec.BufferInfo) ZeusTransformUtils.preCheckCast(r5.L$3, MediaCodec.BufferInfo.class, "com.obric.memorydata.plugin");
        MediaCodec r126 = (MediaCodec) ZeusTransformUtils.preCheckCast(r5.L$2, MediaCodec.class, "com.obric.memorydata.plugin");
        MediaExtractor r48 = (MediaExtractor) ZeusTransformUtils.preCheckCast(r5.L$1, MediaExtractor.class, "com.obric.memorydata.plugin");
        r16 = (d) ZeusTransformUtils.preCheckCast(r5.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r17 = r48;
        r19 = ", error: ";
        r18 = r5;
        r112 = r125;
        r20 = r126;
        r9 = r47;
        r21 = r46;
        r32 = r7;
        r4 = "com.obric.memorydata.plugin";
        r11 = "KeyframeExtractor5";
        r24 = r124;
        r12 = r45;
        r113 = 2;
        r23 = r123;
        goto L51
    L16:
        ResultKt.throwOnFailure(r6);
        new b(true, null);
        MediaCodec.BufferInfo r49 = new MediaCodec.BufferInfo();
        RunLog.INSTANCE.debug("KeyframeExtractor5", "extractFrameAtTimeUs at timeUs: " + r31 + " duration: " + this.l);
        r17 = r25;
        r9 = r29;
        r112 = r49;
        r114 = r5;
        r32 = r7;
        r12 = r31;
        r113 = 2;
        r20 = r26;
        r24 = r27;
        r23 = r28;
        r21 = r30;
        r16 = this;
    L7:
        r5 = new KeyframeExtractor$extractFrameAtTimeUs$1(this, r3);
        goto L8
    }

    public static final /* synthetic */ Object b(d r11, MediaExtractor r12, MediaCodec r13, int r14, int r15, int r16, int r17, long r18, Continuation r20) {
        return r11.b(r12, r13, r14, r15, r16, r17, r18, (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super com.obric.memorydata.personalcontext.util.video.c> r27) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, KeyframeExtractor$doExtractKeyFrameTimeUs$1.class) == false) goto L7;
        KeyframeExtractor$doExtractKeyFrameTimeUs$1 r2 = (KeyframeExtractor$doExtractKeyFrameTimeUs$1) ZeusTransformUtils.preCheckCast(r1, KeyframeExtractor$doExtractKeyFrameTimeUs$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        KeyframeExtractor$doExtractKeyFrameTimeUs$1 r15 = r2;
        Object r3 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r15.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        List<com.obric.memorydata.personalcontext.util.video.b> r5 = (List) ZeusTransformUtils.preCheckCast(r15.L$1, List.class, "com.obric.memorydata.plugin");
        d r0 = (d) ZeusTransformUtils.preCheckCast(r15.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L54:
        r0.c();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r0.a(r5), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L56:
        if (r8.hasNext() == false) goto L59;
        r7.add(Boxing.boxLong(((long) ((com.obric.memorydata.personalcontext.util.video.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.personalcontext.util.video.b.class, "com.obric.memorydata.plugin")).a()) * TimeUtils.NANOSECONDS_PER_MILLISECOND));
        goto L56
    L59:
        return new com.obric.memorydata.personalcontext.util.video.c((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), r0.l);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r9 = r15.J$0;
        Bitmap r10 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.L$2, Bitmap.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.personalcontext.util.video.b> r11 = (List) ZeusTransformUtils.preCheckCast(r15.L$1, List.class, "com.obric.memorydata.plugin");
        r0 = (d) ZeusTransformUtils.preCheckCast(r15.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        Bitmap r12 = r10;
        List<com.obric.memorydata.personalcontext.util.video.b> r13 = r11;
        Object r16 = r14;
        KeyframeExtractor$doExtractKeyFrameTimeUs$1 r17 = r15;
    L42:
        Bitmap r18 = ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).a();
        com.obric.memorydata.personalcontext.util.video.a r19 = r0.a(r12);
        com.obric.memorydata.personalcontext.util.video.a r20 = r0.a(r18);
        com.obric.memorydata.personalcontext.util.video.b r21 = new com.obric.memorydata.personalcontext.util.video.b(0, r19, 0, r12, false, 16, null);
        int r22 = (int) r9;
        com.obric.memorydata.personalcontext.util.video.b r23 = new com.obric.memorydata.personalcontext.util.video.b(r22, r20, r22, r18, false, 16, null);
        MediaExtractor r24 = r0.f;
        if (r24 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        MediaExtractor r110 = null;
    L46:
        MediaCodec r25 = r0.g;
        if (r25 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("codec");
        MediaCodec r111 = null;
    L50:
        int r26 = r0.h;
        int r28 = r0.i;
        int r29 = r0.j;
        int r30 = r0.k;
        r17.L$0 = r0;
        r17.L$1 = r13;
        r17.L$2 = null;
        r17.label = 3;
        if (r0.a(r13, r21, r23, r110, r111, r26, r28, r29, r30, r17) != r16) goto L53;
        return r16;
    L53:
        r5 = r13;
        goto L54
    L49:
        r111 = r25;
        goto L50
    L45:
        r110 = r24;
        goto L46
    L17:
        r9 = r15.J$0;
        r13 = (List) ZeusTransformUtils.preCheckCast(r15.L$1, List.class, "com.obric.memorydata.plugin");
        r0 = (d) ZeusTransformUtils.preCheckCast(r15.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L32:
        Bitmap r31 = ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).a();
        MediaExtractor r32 = r0.f;
        if (r32 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r32 = null;
    L35:
        MediaCodec r33 = r0.g;
        if (r33 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("codec");
        r33 = null;
    L38:
        r15.L$0 = r0;
        r15.L$1 = r13;
        r15.L$2 = r31;
        r15.J$0 = r9;
        r15.label = 2;
        r16 = r14;
        MediaExtractor r112 = r32;
        r17 = r15;
        Object r34 = r0.a(r112, r33, r0.h, r0.i, r0.j, r0.k, r9 * ((long) 1000000), r17);
        if (r34 != r16) goto L41;
        return r16;
    L41:
        r12 = r31;
        r3 = r34;
        goto L42
    L18:
        ResultKt.throwOnFailure(r3);
        List<com.obric.memorydata.personalcontext.util.video.b> r35 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a();     // Catch: Exception -> L60
        long r36 = this.l / ((long) 1000000);
        MediaExtractor r37 = this.f;
        if (r37 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        MediaExtractor r38 = null;
    L24:
        MediaCodec r39 = this.g;
        if (r39 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("codec");
        MediaCodec r40 = null;
    L28:
        int r41 = this.h;
        int r42 = this.i;
        int r43 = this.j;
        int r44 = this.k;
        r15.L$0 = this;
        r15.L$1 = r35;
        r15.J$0 = r36;
        r15.label = 1;
        r3 = a(r38, r40, r41, r42, r43, r44, 0, r15);
        if (r3 != r14) goto L31;
        return r14;
    L31:
        r13 = r35;
        r0 = this;
        r9 = r36;
        goto L32
    L27:
        r40 = r39;
        goto L28
    L23:
        r38 = r37;
    L60:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "prepare error: " + e, null, 4, null);
        c();
        throw new UnSupportVideoFileException("prepare error");
    L7:
        r2 = new KeyframeExtractor$doExtractKeyFrameTimeUs$1(this, r1);
        goto L8
    }

    private final boolean b() {
        if (this.f != null) goto L5;
    L7:
        return false;
    L5:
        if (this.g == null) goto L7;
        return true;
    }

    private final void c() {
        MediaExtractor r1 = null;
        MediaCodec r2 = this.g;     // Catch: Exception -> L13
        if (r2 != null) goto L6;
    L34:
        MediaExtractor r3 = this.f;     // Catch: Exception -> L22
        if (r3 == null) goto L24;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");     // Catch: Exception -> L22
    L20:
        r1.release();     // Catch: Exception -> L22
        goto L24
    L19:
        r1 = r3;
    L24:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r4.hasNext() == false) goto L30;
        Bitmap r5 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.next(), Bitmap.class, "com.obric.memorydata.plugin");
        if (r5.isRecycled() == true) goto L26;
        r5.recycle();
        goto L26
    L30:
        this.e.clear();
        this.d.clear();
        return;
    L22:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "destroy extractor error: " + e, null, 4, null);
        goto L24
    L6:
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("codec");     // Catch: Exception -> L13
        r2 = null;
    L8:
        r2.stop();     // Catch: Exception -> L13
        MediaCodec r6 = this.g;     // Catch: Exception -> L13
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("codec");     // Catch: Exception -> L13
        r6 = null;
    L11:
        r6.release();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "destroy codec error: " + e, null, 4, null);
        goto L34
    }

    /* JADX INFO: renamed from: lambda$7heV4ToexYem71K5-rRABW0s8bA, reason: not valid java name */
    public static /* synthetic */ Bitmap m1103lambda$7heV4ToexYem71K5rRABW0s8bA(d r0, byte[] r1, int r2, int r3, int r4, int r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$n-Z6wjlcMdnQfFT2CiIrQvy3YaY, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.personalcontext.util.video.a m1104lambda$nZ6wjlcMdnQfFT2CiIrQvy3YaY(d r0, Bitmap r1) {
        return a(r0, r1);
    }

    public final Bitmap a(Bitmap r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        if (r9 != 0) goto L5;
        return r8;
    L5:
        Matrix r5 = new Matrix();
        r5.postRotate(r9);
        Bitmap r7 = Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r5, true);
        Intrinsics.checkNotNullExpressionValue(r7, "createBitmap(...)");
        if (r7 == r8) goto L8;
        r8.recycle();
    L8:
        return r7;
    }

    public final Bitmap a(byte[] r19, int r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r19, "yuvData");
        if ((r20 % 2) == 0) goto L5;
        int r2 = r20 - 1;
    L7:
        if ((r21 % 2) == 0) goto L9;
        int r11 = r21 - 1;
    L10:
        if (r2 <= 0) goto L25;
        if (r11 <= 0) goto L25;
        int r0 = Math.max(r2, r11);
        if (r0 <= 1344) goto L15;
        double r3 = 1344.0d / ((double) r0);
    L16:
        int r1 = Math.max(1, (int) (((double) r2) * r3));
        int r4 = Math.max(1, (int) (((double) r11) * r3));
        int[] r12 = new int[r1 * r4];
        int r14 = 0;
    L17:
        if (r14 >= r4) goto L22;
        int r15 = (r14 * r11) / r4;
        int r9 = 0;
    L19:
        if (r9 >= r1) goto L21;
        r12[(r14 * r1) + r9] = a(r19, r2, r11, (r9 * r2) / r1, r15, r22);
        r9 = r9 + 1;
        goto L19
    L21:
        r14 = r14 + 1;
        goto L17
    L22:
        Bitmap r5 = Bitmap.createBitmap(r12, r1, r4, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(r5, "createBitmap(...)");
        return r5;
    L15:
        r3 = 1.0d;
    L25:
        throw new IllegalArgumentException("Invalid video frame size: " + r20 + 'x' + r21);
    L9:
        r11 = r21;
        goto L10
    L5:
        r2 = r20;
        goto L7
    }

    public final Object a(Continuation<? super com.obric.memorydata.personalcontext.util.video.c> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, KeyframeExtractor$extractKeyFrameTimeUs$1.class) == false) goto L7;
        KeyframeExtractor$extractKeyFrameTimeUs$1 r0 = (KeyframeExtractor$extractKeyFrameTimeUs$1) ZeusTransformUtils.preCheckCast(r7, KeyframeExtractor$extractKeyFrameTimeUs$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d this = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        com.obric.memorydata.personalcontext.util.video.c r9 = (com.obric.memorydata.personalcontext.util.video.c) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.personalcontext.util.video.c.class, "com.obric.memorydata.plugin");
        if (r9.a().isEmpty() == true) goto L21;
        return r9;
    L21:
        throw new UnSupportVideoFileException("get empty videoUri: " + this.c);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.label = 1;
        r8 = b(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new KeyframeExtractor$extractKeyFrameTimeUs$1(this, r7);
        goto L8
    }

    public final void a() {
        RunLog.INSTANCE.debug("KeyframeExtractor5", "prepare videoUri: " + this.c);
        MediaExtractor r2 = new MediaExtractor();
        this.f = r2;
        r2.setDataSource(this.f12389b, this.c, null);
        MediaExtractor r3 = this.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r3 = null;
    L5:
        int r4 = r3.getTrackCount();
        int r7 = 0;
    L7:
        if (r7 >= r4) goto L23;
        MediaExtractor r13 = this.f;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r13 = null;
    L11:
        MediaFormat r14 = r13.getTrackFormat(r7);
        Intrinsics.checkNotNullExpressionValue(r14, "getTrackFormat(...)");
        String r15 = r14.getString("mime");
        if (r15 != null) goto L14;
    L16:
        boolean r16 = false;
    L17:
        if (r16 == true) goto L18;
        r7 = r7 + 1;
        goto L7
    L18:
        MediaExtractor r5 = this.f;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r5 = null;
    L21:
        r5.selectTrack(r7);
    L24:
        if (r7 == (-1)) goto L49;
        MediaExtractor r6 = this.f;
        if (r6 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r6 = null;
    L28:
        MediaFormat r8 = r6.getTrackFormat(r7);
        Intrinsics.checkNotNullExpressionValue(r8, "getTrackFormat(...)");
        long r17 = r8.getLong("durationUs", 0);
        this.l = r17;
        this.m = Math.max(2, (int) Math.ceil((r17 / 1000000.0d) / ((double) 50)));
        this.k = r8.getInteger("rotation-degrees", 0);
        this.i = r8.getInteger("width", 0);
        this.j = r8.getInteger("height", 0);
        String r9 = r8.getString("mime");
        RunLog.INSTANCE.debug("KeyframeExtractor5", "duration: " + this.l + ", rotation: " + this.k + ", width: " + this.i + ", height: " + this.j + ", mimeType: " + r9);
        String r10 = a(r9);
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L46
        MediaCodec r11 = MediaCodec.createDecoderByType(r10);     // Catch: Exception -> L46
        Intrinsics.checkNotNullExpressionValue(r11, "createDecoderByType(...)");     // Catch: Exception -> L46
        this.g = r11;     // Catch: Exception -> L46
        r8.setInteger("vendor.obric-ext-sr-filter-client-disable.value", 1);     // Catch: Exception -> L46
        r8.setInteger("vendor.obric-ext-sr-filter-enabled.value", 0);     // Catch: Exception -> L46
        MediaCodec r12 = this.g;     // Catch: Exception -> L46
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("codec");     // Catch: Exception -> L46
        r12 = null;
    L33:
        r12.configure(r8, null, null, 0);     // Catch: Exception -> L46
        MediaCodec r18 = this.g;     // Catch: Exception -> L46
        if (r18 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("codec");     // Catch: Exception -> L46
        r18 = null;
    L36:
        r18.start();     // Catch: Exception -> L46
        MediaCodec r19 = this.g;     // Catch: Exception -> L43
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("codec");     // Catch: Exception -> L43
        r19 = null;
    L40:
        MediaFormat r1 = r19.getOutputFormat();     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r1);
        this.h = r1.getInteger("color-format", -1);
        RunLog.INSTANCE.debug("KeyframeExtractor5", "colorFormat: " + this.h);
        return;
    L43:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "get outputFormat failed, error: " + e, null, 4, null);
        throw new UnSupportVideoFileException("get outputFormat failed for [" + e.getMessage() + ']');
    L46:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeyframeExtractor5", "codec initialization failed (configure/start) for mimeType: " + r10 + ", error: " + e, null, 4, null);
        throw new UnSupportVideoFileException("codec initialization failed for [" + e.getMessage() + ']');
    L49:
        Log.e("KeyframeExtractor5", "No video track found.");
        throw new UnSupportVideoFileException("not initialized for [No video track found]");
    L14:
        if (StringsKt.startsWith$default(r15, "video/", false, 2, null) != true) goto L16;
        r16 = true;
        goto L17
    L23:
        r7 = -1;
        goto L24
    }
}
