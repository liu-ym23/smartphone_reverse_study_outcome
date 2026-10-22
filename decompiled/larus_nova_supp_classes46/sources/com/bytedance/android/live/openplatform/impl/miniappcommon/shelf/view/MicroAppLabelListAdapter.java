package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.shelf.MicroAppLabel;
import com.bytedance.android.live.openplatform.api.utils.c;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fm3.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MicroAppLabelListAdapter extends BaseAdapter {
    public List<MicroAppLabel> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/MicroAppLabelListAdapter$MicroAppLabelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class MicroAppLabelViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final HSImageView c;

        public MicroAppLabelViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131377814);
            this.b = (TextView) r2.findViewById(2131384632);
            this.c = r2.findViewById(2131385741);
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    public MicroAppLabelListAdapter(List<MicroAppLabel> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        this.a = r2;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r2) {
        return ListProtector.get(this.a, r2);
    }

    @Override // android.widget.Adapter
    public final View getView(int r7, View r8, ViewGroup r9) {
        if (r9 == null) goto L4;
        Context r10 = r9.getContext();
    L5:
        View r11 = LayoutInflater.from(r10).inflate(2131566960, r9, false);
        MicroAppLabelViewHolder r12 = new MicroAppLabelViewHolder(r11);
        MicroAppLabel r13 = (MicroAppLabel) ListProtector.get(this.a, r7);
        Intrinsics.checkNotNullParameter(r13, "label");
        String r0 = r13.url;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        HSImageView r2 = r12.c;
        String r14 = r13.url;
        Intrinsics.checkNotNull(r14);
        a1.n(r2, r14);
        UtilityKotlinExtentionsKt.w(r12.c);
        UtilityKotlinExtentionsKt.t(r12.a);
        UtilityKotlinExtentionsKt.t(r12.b);
    L15:
        return r11;
    L14:
        TextView r3 = r12.a;
        r3.setText(r13.name);
        r3.setTextSize(r13.fontSize);
        int r4 = c.a;
        r3.setTextColor(c.a(r13.fontColor));
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(e.a(r3.getContext(), 2.0f));
        r5.setGradientType(0);
        r5.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r5.setColors(new int[]{c.a(r13.backgroundBeginColor), c.a(r13.backgroundEndColor)});
        Unit r15 = Unit.INSTANCE;
        r3.setBackground(r5);
        r3.setPadding(UtilityKotlinExtentionsKt.i(4), UtilityKotlinExtentionsKt.i(3), UtilityKotlinExtentionsKt.i(3), UtilityKotlinExtentionsKt.i(4));
        UtilityKotlinExtentionsKt.w(r12.a);
        UtilityKotlinExtentionsKt.t(r12.b);
        UtilityKotlinExtentionsKt.t(r12.c);
        goto L15
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r1 = false;
        goto L12
    L4:
        r10 = null;
        goto L5
    }
}
