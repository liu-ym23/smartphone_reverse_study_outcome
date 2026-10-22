package t72;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.enteranim.EnterAnimWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: t72.a$a, reason: collision with other inner class name */
    public static final class C0283a {
        public static String a(k r4) {
            Intrinsics.checkNotNullParameter(r4, "imageModel");
            List r5 = r4.getUrls();
            Object r0 = null;
            if (r5 == null) goto L15;
            Iterator r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L11;
            Object r1 = r6.next();
            int r3 = a.a;
            ImageRequest r2 = ImageRequest.fromUri((String) r1);
            CacheKey r7 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r2, null);
            if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r7) == false) goto L6;
            r0 = r1;
        L11:
            return (String) r0;
        L15:
            return null;
        }
    }

    public static final class b extends BaseDataSubscriber<Void> {
        public final List<String> a;
        public final k b;
        public final c c;

        public final void a() {
            if (this.a.isEmpty() == false) goto L5;
            ALogger.e("LocalImageProvider", "Failed to fetch resource " + this.b.getUri());
            this.c.getClass();
            return;
        L5:
            String r0 = (String) ListProtector.remove(this.a, 0);
            ALogger.i("LocalImageProvider", "Trying alternative " + r0 + " of resource " + this.b.getUri());
            Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(r0), null).subscribe(this, UiThreadImmediateExecutorService.getInstance());
        }

        public final void onFailureImpl(DataSource<Void> r4) {
            if (r4 != null) goto L5;
        L7:
            ALogger.w("LocalImageProvider", "Alternative failed");
        L8:
            a();
            return;
        L5:
            if (r4.getFailureCause() == null) goto L7;
            ALogger.w("LocalImageProvider", "Alternative failed", r4.getFailureCause());
            goto L8
        }

        public final void onNewResultImpl(DataSource<Void> r2) {
            Intrinsics.checkNotNull(r2);
            if (r2.isFinished() == false) goto L8;
            ALogger.i("LocalImageProvider", "Resource " + this.b.getUri() + " fetched from network");
            EnterAnimWidget.d r3 = (EnterAnimWidget.d) this.c;
            if (r3.b.isViewValid() == false) goto L9;
            r3.b.b.b(r3.a);
            return;
        L9:
            return;
        }

        public b(k r2, EnterAnimWidget.d r3) {
            Intrinsics.checkNotNullParameter(r2, "imageModel");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.b = r2;
            this.c = r3;
            List r4 = r2.getUrls();
            if (r4 == null) goto L6;
            List<String> r5 = CollectionsKt.toMutableList(r4);
            if (r5 == null) goto L6;
        L7:
            this.a = r5;
            return;
        L6:
            r5 = new ArrayList();
            goto L7
        }
    }

    public interface c {
    }

    static {
    }
}
