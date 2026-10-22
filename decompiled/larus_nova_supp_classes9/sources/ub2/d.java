package ub2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.i;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.e;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements i {

    public static final class a implements a3.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ k c;

        public final void onFail() {
            LiveTracingMonitor.EventModule r0 = e.a;
            this.a.getClass();
            e.c("NetWorkResizableImageLoader", this.c, null);
            this.b.invoke(null);
        }

        public final void a(NinePatchDrawable r2) {
            Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
            this.b.invoke(r2);
        }

        public a(d r1, Function1 r2, k r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public d() {
    }

    public static float d(ITextPieceImage r2) {
        if (r2.getScaleY() > 0) goto L7;
        Resources r3 = s1.getResources();
        return WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density / 3.0f;
    L7:
        return r2.getScaleY();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final boolean c(ITextPieceImage r3) {
        Intrinsics.checkNotNullParameter(r3, "image");
        if (r3.getResourceType() != ITextPieceImage.ResourceType.NetWork) goto L9;
        k r4 = r3.getImageModel();
        if (r4 == null) goto L9;
        if (r4.isResizableImg() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final Drawable a(ITextPieceImage r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "image");
        String r0 = jc1.k.n(IHostFrescoHelper.class).getImageFilePath(r4.getImageModel());
        int r1 = a3.d;
        Pair r6 = new a3().b(r0, f.a(d(r4), r5), true);
        if (r6 == null) goto L5;
        NinePatchDrawable r7 = (NinePatchDrawable) r6.getFirst();
    L6:
        if (r7 != null) goto L9;
        LiveTracingMonitor.EventModule r8 = e.a;
        e.c("NetWorkResizableImageLoader", r4.getImageModel(), null);
        return null;
    L9:
        return r7;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final void b(ITextPieceImage r4, float r5, Function1<? super Drawable, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "image");
        Intrinsics.checkNotNullParameter(r6, "callback");
        k r0 = r4.getImageModel();
        if (r0 != null) goto L5;
    L11:
        e.d("NetWorkResizableImageLoader", r0);
        r6.invoke(null);
        return;
    L5:
        if (r0.getUrls() == null) goto L11;
        if (r0.getUrls().isEmpty() == true) goto L11;
        int r2 = a3.d;
        a3.a.a(null, r0, new a(this, r6, r0), f.a(d(r4), r5));
    }
}
