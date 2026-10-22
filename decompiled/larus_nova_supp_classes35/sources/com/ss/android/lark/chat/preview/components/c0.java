package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 extends q6c.e<VideoProperty, com.ss.android.lark.chat.preview.components.view.j, r6c.a> {
    public final Style f;
    public final String g;
    public final URLPreviewParams h;

    public static final class a extends OnSingleClickListener {
        public final /* synthetic */ com.ss.android.lark.chat.preview.components.view.j a;
        public final /* synthetic */ c0 b;

        public final void onSingleClick(View r12) {
            g6b.a.InterfaceC0223a r0 = g6b.a.a;
            String r13 = null;
            if (r0 == null) goto L9;
            Context r1 = this.a.getContext();
            com.ss.android.lark.chat.preview.components.view.j r2 = this.a;
            String r3 = ((VideoProperty) ((q6c.e) this.b).e).getSrcUrl();
            String r4 = ((VideoProperty) ((q6c.e) this.b).e).getIframeUrl();
            c0 r5 = this.b;
            String r6 = r5.h.c;
            String r7 = ((VideoProperty) ((q6c.e) r5).e).getVid();
            int r8 = ((VideoProperty) ((q6c.e) this.b).e).getSite().getValue();
            ImageSet r9 = ((VideoProperty) ((q6c.e) this.b).e).getCoverImage();
            if (r9 == null) goto L7;
            Image r10 = r9.getOrigin();
        L8:
            r0.b(r1, r2, r3, r4, r6, r7, r8, r10, this.b.h.d);
            goto L9
        L7:
            r10 = null;
        L9:
            g6b.a.InterfaceC0223a r11 = g6b.a.a;
            if (r11 == null) goto L22;
            com.ss.android.lark.officesdk.integrator.im.a r14 = r11.a();
            if (r14 == null) goto L23;
            c0 r15 = this.b;
            URLPreviewParams r16 = r15.h;
            String r17 = r16.c;
            String r18 = r16.a;
            String r19 = r15.g;
            Long r20 = r16.h;
            if (r20 == null) goto L16;
            String r21 = r20.toString();
        L17:
            Long r22 = this.b.h.i;
            if (r22 == null) goto L20;
            r13 = r22.toString();
        L20:
            r14.c(r17, r18, "play_video", r19, null, r21, r13, this.b.h.e);
            return;
        L16:
            r21 = null;
            goto L17
        L23:
            return;
        }

        public a(com.ss.android.lark.chat.preview.components.view.j r1, c0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final String i() {
        return "com.ss.android.lark.chat.preview.components.view.VideoCoverView";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new com.ss.android.lark.chat.preview.components.view.j(r1.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void update(com.ss.android.lark.chat.preview.components.view.j r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.update(r3);
        r3.setOnClickListener(new a(r3, this));
        r3.g((VideoProperty) ((q6c.e) this).e, this.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ void update(View r1) {
        update((com.ss.android.lark.chat.preview.components.view.j) r1);
    }

    public c0(VideoProperty r2, Style r3, vcb.d r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = r5;
        this.h = r4.d;
    }
}
