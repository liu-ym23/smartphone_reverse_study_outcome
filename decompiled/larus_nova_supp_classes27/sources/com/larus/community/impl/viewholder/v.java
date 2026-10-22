package com.larus.community.impl.viewholder;

import android.graphics.Bitmap;
import com.bytedance.fresco.sr.SRPostProcessor;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v extends SRPostProcessor {
    public final /* synthetic */ CreationImageViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ String e;

    public final CloseableReference<Bitmap> process(final Bitmap r10, PlatformBitmapFactory r11, final Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r11, "bitmapFactory");
        Intrinsics.checkNotNullParameter(r12, "extraMap");
        boolean r1 = m29.a.a;
        String r2 = SRPostProcessor.TAG;
        final int r4 = this.b;
        final int r5 = this.c;
        final float r6 = this.d;
        final String r7 = this.e;
        m29.a.a(r2, new t(r10, r4, r5, r6, r7));
        final CloseableReference<Bitmap> r3 = super.process(r10, r11, r12);     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        CreationImageViewHolder.a r8 = CreationImageViewHolder.a.a;
        String r0 = r12.get("sr_status");
        r8.getClass();
        CreationImageViewHolder.a.b(r0, true);
        return CreationImageViewHolder.T3(this.a, r10, r11, r12, null);
    L7:
        m29.a.a(SRPostProcessor.TAG, new u(r3, r12));
        CreationImageViewHolder.a r13 = CreationImageViewHolder.a.a;
        String r14 = r12.get("sr_status");
        r13.getClass();
        CreationImageViewHolder.a.b(r14, false);
        return r3;
    L9:
        th = move-exception;
        CreationImageViewHolder.a r9 = CreationImageViewHolder.a.a;
        String r15 = r12.get("sr_status");
        r9.getClass();
        CreationImageViewHolder.a.b(r15, true);
        return CreationImageViewHolder.T3(this.a, r10, r11, r12, th);
    }

    public v(int r1, CreationImageViewHolder r2, int r3, int r4, float r5, String r6) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        super(r1, false);
    }
}
