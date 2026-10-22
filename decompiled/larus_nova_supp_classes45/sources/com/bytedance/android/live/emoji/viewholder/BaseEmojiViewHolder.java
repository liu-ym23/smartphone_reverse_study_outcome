package com.bytedance.android.live.emoji.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BaseEmojiViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public t90.a b;

    public BaseEmojiViewHolder(View r2) {
        super(r2);
        this.a = (HSImageView) r2.findViewById(2131371532);
    }

    public final void T3(final BaseEmoji r4) {
        if (r4.getIconId() == 0) goto L6;
        this.a.setImageResource(r4.getIconId());
    L11:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new a(this, r4));
        if (r4.getType() != BaseEmoji.Type.DeleteEmoji) goto L14;
        r3.c(((RecyclerView.ViewHolder) this).itemView, LiveResUtil.getString(2131914425), true);
        return;
    L14:
        r3.a(((RecyclerView.ViewHolder) this).itemView, r4.getDescription());
        return;
    L6:
        if (r4.getDrawable() == null) goto L9;
        this.a.setImageDrawable(r4.getDrawable());
        goto L11
    L9:
        if (TextUtils.isEmpty(r4.getLocalFilePath()) == true) goto L11;
        ImageLoader.bindImage(this.a, "file://" + r4.getLocalFilePath());
        goto L11
    }
}
