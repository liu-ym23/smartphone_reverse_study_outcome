package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r0 {
    public static final void a(HSImageView r18, py.k r19, boolean r20, int r21, Drawable r22, com.bytedance.android.live.core.utils.p0 r23, String r24) {
        if (r22 == null) goto L4;
        ImageUtil.loadImage(r18, r19, -1, -1, r20, r22, ImageView.ScaleType.CENTER_CROP, false, r23, r24);
        return;
    L4:
        ImageUtil.loadImage(r18, r19, -1, -1, r20, r21, ImageView.ScaleType.CENTER_CROP, false, r23, r24);
    }
}
