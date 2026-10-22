package com.larus.community.impl.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.e1;
import com.larus.utils.w0;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001IB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JJ\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0017H\u0002J\u001a\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010)\u001a\u00020'2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002JK\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010\u001b2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105J<\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>0=2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020>2\u0006\u0010B\u001a\u00020CH\u0002J\u0015\u0010E\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "waterMarkIcon", "Landroid/widget/ImageView;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconTemplate", "textView", "Landroid/widget/TextView;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getImageInfo", "Lcom/larus/platform/api/ImageInfo;", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "resetTemplateIcon", "", "creationFeedType", "", "bindData", "position", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "handleIconTemplate", "handleDownLoadIcon", "userCreation", "shouldUseProfileSelfNoWatermarkThumb", "", "imageInfo", "shouldUseProfileSelfNoWatermark", "shouldUseCreationFeedArgb", "config", "Lcom/larus/platform/model/chat/CreationPreviewPerformanceOptConfig;", "buildCreationFeedCoverSrPostProcessor", "Lcom/bytedance/fresco/sr/SRPostProcessor;", "sourceWidth", "sourceHeight", "targetWidth", "targetHeight", "enableFeedArgb", "isReviewBan", "(Lcom/larus/platform/model/chat/CreationPreviewPerformanceOptConfig;Ljava/lang/Integer;Ljava/lang/Integer;IIZZ)Lcom/bytedance/fresco/sr/SRPostProcessor;", "createSrFallbackBitmap", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "sourceBitmap", "bitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "extraMap", "", "", "throwable", "", "selectCreationFeedCoverSrScaleType", "scaleRatio", "", "selectCreationFeedCoverSrScaleTypeName", "toPositiveInt", "", "(Ljava/lang/Long;)Ljava/lang/Integer;", "onViewRecycled", "CreationFeedCoverSrTraceReporter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreationImageViewHolder extends RecyclerView.ViewHolder implements zp9.q {
    public static final /* synthetic */ int h = 0;
    public final CommonDownLoadLayout a;
    public final ImageView b;
    public final SimpleDraweeView c;
    public final View d;
    public final TextView e;
    public final CommonAuthorInfoLayout f;
    public LifecycleCoroutineScope g;

    public static final class a {
        public static final a a = null;
        public static final AtomicInteger b = null;
        public static final AtomicInteger c = null;
        public static final AtomicInteger d = null;
        public static final AtomicInteger e = null;
        public static final AtomicInteger f = null;
        public static final AtomicInteger g = null;
        public static final AtomicInteger h = null;
        public static final AtomicInteger i = null;
        public static final AtomicInteger j = null;
        public static final AtomicInteger k = null;
        public static final AtomicInteger l = null;
        public static final AtomicInteger m = null;
        public static final AtomicInteger n = null;
        public static final AtomicInteger o = null;
        public static final AtomicInteger p = null;
        public static final AtomicInteger q = null;
        public static final AtomicInteger r = null;
        public static final AtomicBoolean s = null;

        public a() {
        }

        static {
            a = new a();
            b = new AtomicInteger();
            c = new AtomicInteger();
            d = new AtomicInteger();
            e = new AtomicInteger();
            f = new AtomicInteger();
            g = new AtomicInteger();
            h = new AtomicInteger();
            i = new AtomicInteger();
            j = new AtomicInteger();
            k = new AtomicInteger();
            l = new AtomicInteger();
            m = new AtomicInteger();
            n = new AtomicInteger();
            o = new AtomicInteger();
            p = new AtomicInteger();
            q = new AtomicInteger();
            r = new AtomicInteger();
            s = new AtomicBoolean(false);
        }

        public static void a() {
            int r0 = b.getAndSet(0);
            int r2 = c.getAndSet(0);
            int r3 = d.getAndSet(0);
            if (r0 > 0) goto L15;
            if (r3 > 0) goto L15;
            return;
        L15:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
            by7.a r5 = new by7.a("creation_feed_cover_sr_trace");     // Catch: Throwable -> L8
            r5.d("request_count", Integer.valueOf(r0));     // Catch: Throwable -> L8
            r5.d("postprocessor_created_count", Integer.valueOf(r2));     // Catch: Throwable -> L8
            r5.d("process_triggered_count", Integer.valueOf(r3));     // Catch: Throwable -> L8
            r5.d("process_success_count", Integer.valueOf(e.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("process_fallback_count", Integer.valueOf(f.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("process_error_count", Integer.valueOf(g.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("skip_argb_disable_count", Integer.valueOf(h.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("skip_review_ban_count", Integer.valueOf(i.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("skip_invalid_source_count", Integer.valueOf(j.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("skip_invalid_target_count", Integer.valueOf(k.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("skip_scale_too_small_count", Integer.valueOf(l.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("scale_type_1_1_count", Integer.valueOf(m.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("scale_type_1_2_count", Integer.valueOf(n.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("scale_type_1_3_count", Integer.valueOf(o.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("scale_type_1_4_count", Integer.valueOf(p.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("scale_type_1_5_count", Integer.valueOf(q.getAndSet(0)));     // Catch: Throwable -> L8
            r5.d("scale_type_2_count", Integer.valueOf(r.getAndSet(0)));     // Catch: Throwable -> L8
            r5.b();     // Catch: Throwable -> L8
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r6 = Result.exceptionOrNull-impl(r1);
            if (r6 == null) goto L17;
            boolean r7 = m29.a.a;
            m29.a.b("CreationImageViewHolder", "report feed cover sr trace error: " + r6.getLocalizedMessage());
            return;
        L17:
            return;
        L8:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public static void d() {
            if ((b.get() + d.get()) >= 50) goto L5;
            return;
        L5:
            AtomicBoolean r0 = s;
            if (r0.compareAndSet(false, true) == true) goto L14;
            return;
        L14:
            a();     // Catch: Throwable -> L11
            r0.set(false);
            return;
        L11:
            th = move-exception;
            s.set(false);
            throw th;
        }

        public static void b(String r1, boolean r2) {
            d.incrementAndGet();
            if (r2 == false) goto L6;
            g.incrementAndGet();
        L9:
            d();
            return;
        L6:
            if (Intrinsics.areEqual(r1, "0") == false) goto L8;
            e.incrementAndGet();
            goto L9
        L8:
            f.incrementAndGet();
            goto L9
        }

        public static void c(a r2, String r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            r2.getClass();
            b.incrementAndGet();
            if (r3 != null) goto L11;
            c.incrementAndGet();
            if (r4 == null) goto L63;
            int r6 = r4.hashCode();
            if (r6 == (-1805472659)) goto L60;
            switch(r6) {
                case 107564318: goto L56;
                case 107564319: goto L52;
                case 107564320: goto L48;
                case 107564321: goto L44;
                case 107564322: goto L40;
                default: goto L63;
            };
        L40:
            if (r4.equals("TYPE_1_5") == false) goto L63;
            q.incrementAndGet();
            goto L63
        L44:
            if (r4.equals("TYPE_1_4") == false) goto L63;
            p.incrementAndGet();
            goto L63
        L48:
            if (r4.equals("TYPE_1_3") == false) goto L63;
            o.incrementAndGet();
            goto L63
        L52:
            if (r4.equals("TYPE_1_2") == false) goto L63;
            n.incrementAndGet();
            goto L63
        L56:
            if (r4.equals("TYPE_1_1") == false) goto L63;
            m.incrementAndGet();
            goto L63
        L60:
            if (r4.equals("TYPE_2") == false) goto L63;
            r.incrementAndGet();
        L63:
            d();
            return;
        L11:
            switch(r3.hashCode()) {
                case -1937450585: goto L30;
                case -1895811416: goto L26;
                case -170811549: goto L22;
                case -155211559: goto L18;
                case 873729653: goto L14;
                default: goto L63;
            };
        L14:
            if (r3.equals("argb_disable") == false) goto L63;
            h.incrementAndGet();
            goto L63
        L18:
            if (r3.equals("invalid_target") == false) goto L63;
            k.incrementAndGet();
            goto L63
        L22:
            if (r3.equals("invalid_source") == false) goto L63;
            j.incrementAndGet();
            goto L63
        L26:
            if (r3.equals("review_ban") == false) goto L63;
            i.incrementAndGet();
            goto L63
        L30:
            if (r3.equals("scale_too_small") == false) goto L63;
            l.incrementAndGet();
            goto L63
        }
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Ref.ObjectRef<Integer> b;
        public final /* synthetic */ CreationImageViewHolder c;

        public final void onFailure(String r3, Throwable r4) {
            m29.a.c("CreationImageViewHolder", "cover image failed");
            super.onFailure(r3, r4);
        }

        public final void onSubmit(String r1, Object r2) {
            super.onSubmit(r1, r2);
        }

        public b(boolean r1, Ref.ObjectRef<Integer> r2, CreationImageViewHolder r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            boolean r4 = r0.a;
            if (r0.a == true) goto L5;
            return;
        L5:
            if (this.a == false) goto L7;
            return;
        L7:
            if (this.b.element == null) goto L12;
            e1.x(this.c.b);
            return;
        }
    }

    public final void onViewRecycled() {
        this.a.onDestroy();
    }

    public CreationImageViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.a = r4.findViewById(2131370173);
        this.b = (ImageView) r4.findViewById(2131393017);
        this.c = r4.findViewById(2131375775);
        View r0 = r4.findViewById(2131374752);
        ICommunityService.Companion r1 = ICommunityService.a;
        if (r1.f1().e() != 0) goto L5;
        r0.setBackgroundResource(2131239556);
    L6:
        this.d = r0;
        TextView r2 = (TextView) r4.findViewById(2131369264);
        if (r1.f1().e() != 0) goto L9;
        r2.setTextColor(ContextCompat.getColor(r4.getContext(), 2131103298));
    L10:
        this.e = r2;
        this.f = (CommonAuthorInfoLayout) r4.findViewById(2131377437);
        w0.e(r4, i5.Y());
        return;
    L9:
        r2.setTextColor(ContextCompat.getColor(r4.getContext(), 2131103292));
        goto L10
    L5:
        r0.setBackgroundResource(2131239557);
        goto L6
    }

    public static Integer W3(Long r5) {
        long r0 = r5.longValue();
        if (1 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        r5 = null;
    L12:
        if (r5 != null) goto L14;
        return null;
    L14:
        return Integer.valueOf((int) r5.longValue());
    L5:
        if (r0 >= com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_RESERVE_BYTES) goto L7;
        r1 = true;
        goto L9
    }

    public ImageInfo V3(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        UserCreationContent r3 = r2.e;
        if (r3 == null) goto L7;
        UserCreationImage r4 = r3.a;
        if (r4 == null) goto L7;
        return r4.a;
    L7:
        return null;
    }

    public static final CloseableReference T3(CreationImageViewHolder r2, Bitmap r3, PlatformBitmapFactory r4, Map r5, Throwable r6) {
        r2.getClass();
        if (r6 == null) goto L6;
        String r7 = r6.getLocalizedMessage();
        if (r7 == null) goto L6;
    L12:
        if (r5.containsKey("sr_status") == true) goto L15;
        r5.put("sr_status", "1");
    L15:
        if (r5.containsKey("sr_err") == true) goto L17;
        r5.put("sr_err", r7);
    L17:
        boolean r0 = m29.a.a;
        m29.a.b("CreationImageViewHolder", "[feed_cover_sr_process_fallback] srError=" + r7 + ", srExtra=" + r5);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L20
        Object r9 = Result.constructor-impl(r4.createBitmap(r3));     // Catch: Throwable -> L20
    L22:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L25;
        boolean r11 = m29.a.a;
        m29.a.b("CreationImageViewHolder", "[feed_cover_sr_process_fallback_failed] " + r10.getLocalizedMessage());
        if (r6 == null) goto L29;
        throw r6;
    L29:
        throw r10;
    L25:
        return (CloseableReference) r9;
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L6:
        if (r6 == null) goto L8;
        r7 = r6.getClass().getSimpleName();
    L9:
        if (r7 != null) goto L12;
        r7 = "process_error";
        goto L12
    L8:
        r7 = null;
        goto L9
    }

    public void U3(int r21, final UserCreation r22, final int r23, g29.i r24, LifecycleCoroutineScope r25, @CreationFeedType int r26, zp9.f r27) {
        if (r22 != null) goto L5;
        return;
    L5:
        this.g = r25;
        if (r26 == 1) goto L8;
    L10:
        if (r26 == 1) goto L13;
        if (r26 == 2) goto L13;
        e1.x(this.d);
        e1.o(this.a);
    L15:
        if (this.a.getVisibility() != 0) goto L17;
        boolean r1 = true;
    L19:
        if (r1 == false) goto L36;
        ImageInfo r2 = V3(r22);
        if (r2 == null) goto L36;
        Image r3 = r2.a;
        if (r3 == null) goto L36;
        String r4 = r3.a;
        if (r4 == null) goto L36;
        if (r4.length() <= 0) goto L30;
        boolean r5 = true;
    L31:
        if (r5 == true) goto L34;
        r4 = null;
    L34:
        if (r4 == null) goto L36;
        this.a.S5(this.g, new com.larus.bmhome.bigimg.download.d.a(r4));
        goto L36
    L30:
        r5 = false;
    L36:
        z2 r6 = z2.a;
        if (r6.m() == true) goto L39;
    L62:
        e1.o(this.d);
    L63:
        ImageInfo r7 = V3(r22);
        if (CollectionsKt.listOf(new Integer[]{1, 2}).contains(Integer.valueOf(r26)) == true) goto L66;
    L68:
        boolean r0 = false;
    L69:
        if (r0 == false) goto L76;
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;
        if (r8.D() == true) goto L73;
        boolean r9 = false;
    L74:
        if (r9 == false) goto L76;
        boolean r10 = true;
    L77:
        if (r10 == false) goto L81;
        if (r7 == null) goto L86;
        Image r11 = r7.b;
    L87:
        Integer r12 = r22.c;
        if (r12 != null) goto L91;
    L93:
        boolean r17 = false;
    L94:
        AuthorInfo r13 = r22.g;
        if (r11 == null) goto L97;
        final Long r14 = Long.valueOf(r11.d);
    L98:
        if (r11 == null) goto L100;
        final Long r15 = Long.valueOf(r11.c);
    L101:
        boolean r16 = r0.a;
        if (r15 == null) goto L104;
        Integer r18 = Integer.valueOf((int) r15.longValue());
    L105:
        if (r14 == null) goto L107;
        Integer r20 = Integer.valueOf((int) r14.longValue());
    L108:
        final int r28 = r0.b(r18, r20, r23, "CreationImageViewHolder" + r21);
        e1.o(this.b);
        this.b.setImageDrawable(null);
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        SimpleDraweeView r30 = this.c;
        ViewGroup.LayoutParams r111 = r30.getLayoutParams();
        r111.height = r28;
        r30.setLayoutParams(r111);
        if (r0.a == false) goto L129;
        float r31 = r23;
        if ((r31 / r28) <= 1.3f) goto L117;
        ImageView r112 = this.b;
        ViewGroup.LayoutParams r32 = r112.getLayoutParams();
        if (r32 == null) goto L115;
        r32.width = (int) (r31 / 6.0f);
    L116:
        r112.setLayoutParams(r32);
    L123:
        if (r6.u3() == false) goto L125;
        Integer r33 = 2131240170;
    L126:
        r110.element = r33;
        if (r33 == null) goto L129;
        this.b.setImageResource(r33.intValue());
        e1.q(this.b);
        goto L129
    L125:
        r33 = null;
        goto L126
    L115:
        r32 = null;
        goto L116
    L117:
        ImageView r34 = this.b;
        ViewGroup.LayoutParams r113 = r34.getLayoutParams();
        if (r113 == null) goto L120;
        r113.width = (int) (r31 / 5.0f);
    L121:
        r34.setLayoutParams(r113);
        goto L123
    L120:
        r113 = null;
    L129:
        SimpleDraweeView r114 = this.c;
        if (r17 == false) goto L132;
        String r35 = UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + "/2131240129").toString();
    L134:
        String r36 = r35;
    L136:
        final boolean r37 = r17;
        final boolean r38 = r10;
        ImageLoaderKt.y(r114, r36, "community_creation_photo", new m(this, r15, r14, r23, r28, r37, r38, r110), 4);
        if (r27 == null) goto L156;
        boolean r40 = r27.p;
        Long r41 = r22.f;
        if (r41 == null) goto L141;
        long r42 = r41.longValue();
    L142:
        CommonAuthorInfoLayout r43 = this.f;
        if (r40 == false) goto L145;
        int r44 = 0;
    L146:
        r43.setVisibility(r44);
        CommonAuthorInfoLayout r45 = this.f;
        if (r13 == null) goto L149;
        AuthorInfo r46 = r13;
        String r47 = r46.c;
    L150:
        r45.a(r47, r0.a());
        CommonAuthorInfoLayout r48 = this.f;
        if (r46 == null) goto L154;
        String r50 = r46.a;
        if (r50 == null) goto L154;
    L155:
        r48.setAuthorName(r50);
        this.f.setUseCount(r42);
        final int r51 = r21;
        final g29.i r52 = r24;
        e1.d(this.f, new n(r52, r51));
        this.f.setOnLongClickListener(new o(r52, this, r51));
        SimpleDraweeView r53 = this.c;
        StringCompanionObject r54 = StringCompanionObject.INSTANCE;
        int r55 = com.larus.utils.j0.a;
        boolean r56 = true;
        r53.setContentDescription(String.format(com.larus.utils.j0.d(2131898797), Arrays.copyOf(new Object[]{this.f.getAuthorName(), this.f.getUseCount()}, 2)));
    L157:
        ((RecyclerView.ViewHolder) this).itemView.setClickable(r56);
        e1.d(this.c, new p(r52, r51));
        e1.d(this.d, new q(r52, r51));
        e1.d(this.a, new r(r52, r22, this));
        this.c.setOnLongClickListener(new s(r52, this, r51, r22));
        Integer r57 = r22.c;
        if (r57 != null) goto L161;
        return;
    L161:
        if (r57.intValue() != 5) goto L164;
        this.c.setOnClickListener(null);
        this.f.setOnClickListener(null);
        this.d.setOnClickListener(null);
        this.a.setOnClickListener(null);
        this.c.setOnLongClickListener(null);
        this.f.setOnClickListener(null);
        this.d.setOnClickListener(null);
        this.a.setOnClickListener(null);
        return;
    L164:
        return;
    L154:
        r50 = "";
        goto L155
    L149:
        r46 = r13;
        r47 = null;
        goto L150
    L145:
        r44 = 8;
        goto L146
    L141:
        r42 = 0;
        goto L142
    L156:
        r51 = r21;
        r52 = r24;
        r56 = true;
        e1.o(this.f);
        goto L157
    L132:
        if (r11 == null) goto L135;
        r35 = r11.a;
        goto L134
    L135:
        r36 = null;
        goto L136
    L107:
        r20 = null;
        goto L108
    L104:
        r18 = null;
        goto L105
    L100:
        r15 = null;
        goto L101
    L97:
        r14 = null;
        goto L98
    L91:
        if (r12.intValue() != 5) goto L93;
        r17 = true;
    L86:
        r11 = null;
        goto L87
    L81:
        if (r0.a == false) goto L84;
        if (r7 == null) goto L86;
        r11 = r7.j;
        goto L87
    L84:
        if (r7 == null) goto L86;
        r11 = r7.b;
        goto L87
    L73:
        r9 = r8.y(CreationNoWatermarkManager.t0(r7));
    L76:
        r10 = false;
        goto L77
    L66:
        if (CreationNoWatermarkManager.a.D() == false) goto L68;
        r0 = true;
        goto L69
    L39:
        if (r6.getCreationMakeSameConfigV2().b() == true) goto L62;
        if (this.d.getVisibility() != 0) goto L44;
        boolean r58 = true;
    L45:
        if (r58 == false) goto L63;
        if (r22.b() == false) goto L50;
        this.e.setText(2131901253);
        goto L63
    L50:
        CreationDynamicInfo r60 = r22.h;
        if (r60 == null) goto L53;
        String r61 = r60.c;
    L55:
        if (com.larus.utils.o0.d(r61) == false) goto L61;
        TextView r62 = this.e;
        CreationDynamicInfo r63 = r22.h;
        if (r63 == null) goto L59;
        String r64 = r63.c;
    L60:
        r62.setText(r64);
        goto L63
    L59:
        r64 = null;
        goto L60
    L61:
        this.e.setText(2131901659);
        goto L63
    L53:
        r61 = null;
        goto L55
    L44:
        r58 = false;
        goto L45
    L17:
        r1 = false;
    L13:
        e1.o(this.a);
        e1.o(this.d);
        goto L15
    L8:
        if (com.larus.bmhome.utils.u.b() == false) goto L10;
        e1.x(this.a);
        this.a.setDownloadIcon(2131240149);
        e1.o(this.d);
        goto L15
    }
}
