package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public v(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        com.bytedance.android.live.effect.sticker.viewmodel.f r12 = (com.bytedance.android.live.effect.sticker.viewmodel.f) r11;
        LiveStickerDialogV2 r0 = this.a;
        int r1 = LiveStickerDialogV2.y;
        r0.getClass();
        int r2 = h.b[r12.a.ordinal()];
        if (r2 != 1) goto L5;
        View r13 = r0.getView();
        if (r13 == null) goto L59;
        View r14 = r13.findViewById(2131371500);
        if (r14 == null) goto L59;
        r14.setVisibility(8);
    L59:
        View r15 = r0.getView();
        if (r15 == null) goto L64;
        SurfaceView r16 = (SurfaceView) r15.findViewById(2131371503);
        if (r16 == null) goto L64;
        r16.setVisibility(8);
    L64:
        View r17 = r0.getView();
        if (r17 == null) goto L69;
        SimpleDraweeView r18 = (HSImageView) r17.findViewById(2131371501);
        if (r18 == null) goto L69;
        r18.setVisibility(8);
    L69:
        r0.Z90();
        return;
    L5:
        if (r2 != 2) goto L7;
        View r3 = r0.getView();
        if (r3 == null) goto L41;
        View r4 = r3.findViewById(2131371500);
        if (r4 == null) goto L41;
        r4.setVisibility(0);
    L41:
        View r5 = r0.getView();
        if (r5 == null) goto L46;
        SurfaceView r6 = (SurfaceView) r5.findViewById(2131371503);
        if (r6 == null) goto L46;
        r6.setVisibility(0);
    L46:
        View r7 = r0.getView();
        if (r7 == null) goto L51;
        SimpleDraweeView r8 = (HSImageView) r7.findViewById(2131371501);
        if (r8 == null) goto L51;
        r8.setVisibility(8);
    L51:
        Sticker r19 = r12.b;
        if (r19 == null) goto L69;
        List<String> r9 = com.bytedance.android.live.effect.utils.q.a;
        com.bytedance.android.live.effect.utils.q.b(true, r19, r0.U90(), r0.p, r0.q.getPage());
        goto L69
    L7:
        if (r2 != 3) goto L69;
        View r21 = r0.getView();
        if (r21 == null) goto L14;
        View r22 = r21.findViewById(2131371500);
        if (r22 == null) goto L14;
        r22.setVisibility(0);
    L14:
        View r23 = r0.getView();
        if (r23 == null) goto L19;
        SurfaceView r24 = (SurfaceView) r23.findViewById(2131371503);
        if (r24 == null) goto L19;
        r24.setVisibility(8);
    L19:
        View r25 = r0.getView();
        if (r25 == null) goto L24;
        SimpleDraweeView r26 = (HSImageView) r25.findViewById(2131371501);
        if (r26 == null) goto L24;
        r26.setVisibility(0);
    L24:
        View r27 = r0.getView();
        py.k r28 = null;
        if (r27 == null) goto L27;
        SimpleDraweeView r29 = (HSImageView) r27.findViewById(2131371501);
    L28:
        Sticker r31 = r12.b;
        if (r31 == null) goto L33;
        UrlModel r32 = r31.getIcon();
        if (r32 == null) goto L33;
        r28 = r32.toImgModel();
    L33:
        ImageUtil.loadImage(r29, r28, 0);
        Sticker r110 = r12.b;
        if (r110 == null) goto L69;
        List<String> r33 = com.bytedance.android.live.effect.utils.q.a;
        com.bytedance.android.live.effect.utils.q.b(false, r110, r0.U90(), r0.p, r0.q.getPage());
        goto L69
    L27:
        r29 = null;
        goto L28
    }
}
