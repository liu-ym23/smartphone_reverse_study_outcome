package com.bytedance.android.live.emoji.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.emoji.SelfEmoji;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SelfEmojiViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final HSImageView a;
    public final View b;

    public SelfEmojiViewHolder(View r2) {
        super(r2);
        this.b = r2;
        this.a = (HSImageView) r2.findViewById(2131385879);
    }

    public final void T3(final SelfEmoji r9, final int r11, final int r12) {
        if (r12 != 0) goto L5;
        ImageLoader.bindDrawableResource(this.a, 2131251477);
        this.a.setOnClickListener(new b(this, r9, r11, r12));
        return;
    L5:
        if (r12 != 1) goto L17;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.getAnimatedImage() == null) goto L10;
        ImageModel r0 = r9.getAnimatedImage();
    L11:
        ImageModel r2 = r0;
        if (r2 == null) goto L14;
        SimpleDraweeView r1 = this.a;
        ImageUtil.loadImage(r1, r2, r1.getMeasuredWidth(), this.a.getMeasuredHeight(), true, 2131249937, null);
    L14:
        this.a.setOnTouchListener(new c(this, r9, r11, r12));
        return;
    L10:
        r0 = r9.getStaticImage();
        goto L11
    }
}
