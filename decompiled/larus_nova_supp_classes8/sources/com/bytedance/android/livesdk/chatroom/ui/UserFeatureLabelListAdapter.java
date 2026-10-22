package com.bytedance.android.livesdk.chatroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class UserFeatureLabelListAdapter extends RecyclerView.Adapter<LabelViewHolder> {
    public List<ImageModel> a;
    public View.OnClickListener b;

    public static class LabelViewHolder extends RecyclerView.ViewHolder {
        public final int a;
        public final ImageView b;

        public LabelViewHolder(View r2) {
            super(r2);
            this.b = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131389866);
            this.a = com.bytedance.android.live.core.utils.s1.f(16.0f);
        }
    }

    public final int getItemCount() {
        List<ImageModel> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return ((ArrayList) r0).size();
    }

    public UserFeatureLabelListAdapter() {
    }

    public final void setData(List<ImageModel> r2) {
        if (CollectionUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        this.a = new ArrayList();
    L8:
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r2);
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        LabelViewHolder r11 = (LabelViewHolder) r9;
        if (CollectionUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        if (r10 >= ((ArrayList) this.a).size()) goto L28;
        ImageModel r12 = (ImageModel) ListProtector.get(this.a, r10);
        View.OnClickListener r7 = this.b;
        r11.getClass();
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.getImageType().intValue() != 7) goto L12;
    L25:
        UIUtils.setViewVisibility(r11.b, 8);
        return;
    L12:
        if (r12.getImageType().intValue() == 50) goto L25;
        if (r12.getImageType().intValue() == 51) goto L25;
        if (r12.getImageType().intValue() == 52) goto L25;
        if (r12.getImageType().intValue() == 53) goto L25;
        if (r12.getImageType().intValue() == 5) goto L25;
        if (r12.getImageType().intValue() == 6) goto L25;
        ImageUtil.loadImage(r11.b, r12, -1, -1, true, 0, new s9(r11));
        UIUtils.setClickListener(true, ((RecyclerView.ViewHolder) r11).itemView, r7);
        ((RecyclerView.ViewHolder) r11).itemView.setTag(r12);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new LabelViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567550, r3, false));
    }
}
