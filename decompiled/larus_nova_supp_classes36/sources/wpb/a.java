package wpb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.internal.ThreadUtil;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements e {
    public final String a;
    public final int b;
    public final int c;
    public final IconScene d;

    /* JADX INFO: renamed from: wpb.a$a, reason: collision with other inner class name */
    public static final class C0342a {
    }

    public static final class b<T> implements FlowableOnSubscribe {
        public final /* synthetic */ a a;
        public final /* synthetic */ Drawable b;
        public final /* synthetic */ long c;

        /* JADX INFO: renamed from: wpb.a$b$a, reason: collision with other inner class name */
        public static final class C0343a implements RequestListener<Bitmap> {
            public final /* synthetic */ a a;
            public final /* synthetic */ FlowableEmitter<Bitmap> b;
            public final /* synthetic */ Drawable c;
            public final /* synthetic */ long d;

            public C0343a(a r1, FlowableEmitter<Bitmap> r2, Drawable r3, long r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final boolean onLoadFailed(GlideException r9, Object r10, Target<Bitmap> r11, boolean r12) {
                StringBuilder r13 = new StringBuilder("generateIcon error ");
                String r14 = null;
                if (r9 == null) goto L5;
                String r15 = r9.getMessage();
            L6:
                r13.append(r15);
                Log.e("BaseIconProducer", r13.toString());
                a r16 = this.a;
                FlowableEmitter<Bitmap> r17 = this.b;
                Intrinsics.checkNotNull(r17);
                Drawable r0 = this.c;
                if (r0 == null) goto L9;
                Bitmap r1 = ypb.b.a(r0);
            L10:
                a.b(r16, r17, r1);
                DecimalFormat r18 = vpb.f.a;
                IconScene r2 = this.a.d;
                long r4 = System.nanoTime() - this.d;
                if (r9 == null) goto L13;
                r14 = r9.getMessage();
            L13:
                vpb.f.a("download_image", r2, 2, false, r4, r14);
                return true;
            L9:
                r1 = null;
                goto L10
            L5:
                r15 = null;
                goto L6
            }

            public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
                a r6 = this.a;
                FlowableEmitter<Bitmap> r7 = this.b;
                Intrinsics.checkNotNull(r7);
                a.b(r6, r7, (Bitmap) r1);
                return true;
            }
        }

        public b(a r1, Drawable r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(FlowableEmitter<Bitmap> r9) {
            Intrinsics.checkNotNullParameter(r9, "emit");
            Glide.with(LarkContext.getApplication()).asBitmap().load(this.a.a).diskCacheStrategy(DiskCacheStrategy.ALL).addListener(new C0343a(this.a, r9, this.b, this.c)).submit();
        }
    }

    static {
    }

    @Override // wpb.e
    public final Flowable<Bitmap> a(Drawable r4) {
        return Flowable.create(new b(this, r4, System.nanoTime()), BackpressureStrategy.BUFFER);
    }

    public static final void b(a r1, FlowableEmitter r2, Bitmap r3) {
        r1.getClass();
        if (r2.isCancelled() == true) goto L15;
        Bitmap r4 = ypb.b.c(r3, r1.b, r1.c);
        if (r4 != null) goto L9;
        r2.onError(new Exception("bitmap null"));
        r2.onComplete();
        return;
    L9:
        if (ThreadUtil.isMainThread() == false) goto L11;
        r2.onNext(r4);
        r2.onComplete();
        return;
    L11:
        UICallbackExecutor.execute(new wpb.b(r2, r4));
        return;
    }

    public a(String r2, int r3, int r4, IconScene r5) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r5, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
