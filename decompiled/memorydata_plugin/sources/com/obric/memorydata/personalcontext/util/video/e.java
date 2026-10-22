package com.obric.memorydata.personalcontext.util.video;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/VideoFrameExtractJob;", "", "<init>", "()V", "TAG", "", "extractSingleFile", "", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12392a = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12392a = new e();
    }

    private e() {
    }

    public final Object a(Uri r31, Continuation<? super List<VideoFrame>> r32) {
        Uri r0 = r31;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r32, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, VideoFrameExtractJob$extractSingleFile$1.class) == false) goto L7;
        VideoFrameExtractJob$extractSingleFile$1 r3 = (VideoFrameExtractJob$extractSingleFile$1) ZeusTransformUtils.preCheckCast(r1, VideoFrameExtractJob$extractSingleFile$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        r0 = (Uri) ZeusTransformUtils.preCheckCast(r3.L$0, Uri.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);     // Catch: UnSupportVideoFileException -> L38 TimeoutCancellationException -> L41
    L20:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin");     // Catch: UnSupportVideoFileException -> L38 TimeoutCancellationException -> L41
        List<Long> r7 = r6.a();
        long r8 = r6.b();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L37;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r11 = 0;
        Iterator r12 = r9.iterator();
    L25:
        if (r12.hasNext() == false) goto L34;
        Object r13 = r12.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        long r15 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r11 >= (r7.size() - 1)) goto L32;
        long r16 = ((Number) ZeusTransformUtils.preCheckCast(r7.get(r14), Number.class, "com.obric.memorydata.plugin")).longValue();
    L33:
        long r22 = r15 / 1000;
        r10.add(new VideoFrame(r22, r16 / 1000, r22, null, null, null, null, 120, null));
        r11 = r14;
        goto L25
    L32:
        r16 = r8;
        goto L33
    L34:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("VideoFrameExtractJob", "processSingleFile frameList: " + r17);
        return r17;
    L37:
        return CollectionsKt.emptyList();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        RunLog.INSTANCE.debug("VideoFrameExtractJob", "processSingleFile uri: " + r0);
        d r18 = new d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0);     // Catch: UnSupportVideoFileException -> L38 TimeoutCancellationException -> L41
        r3.L$0 = r0;     // Catch: UnSupportVideoFileException -> L38 TimeoutCancellationException -> L41
        r3.label = 1;     // Catch: UnSupportVideoFileException -> L38 TimeoutCancellationException -> L41
        r2 = r18.a(r3);     // Catch: UnSupportVideoFileException -> L38 TimeoutCancellationException -> L41
        if (r2 != r4) goto L20;
        return r4;
    L38:
        RunLog r19 = RunLog.INSTANCE;
        StringBuilder r20 = new StringBuilder();
        String r21 = "processSingleFile UnSupportVideoFileException uri: ";
    L39:
        r19.debug("VideoFrameExtractJob", r20.append(r21).append(r0).toString());
        return null;
    L41:
        r19 = RunLog.INSTANCE;
        r20 = new StringBuilder();
        r21 = "processSingleFile timeout uri: ";
    L7:
        r3 = new VideoFrameExtractJob$extractSingleFile$1(this, r1);
        goto L8
    }
}
