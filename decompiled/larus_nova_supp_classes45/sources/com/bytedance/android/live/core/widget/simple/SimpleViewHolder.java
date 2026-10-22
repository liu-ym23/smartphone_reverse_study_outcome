package com.bytedance.android.live.core.widget.simple;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SimpleViewHolder extends BaseViewHolder {
    private Map<String, Object> extra;
    private SparseArray<View> mViews;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public void bind(Object r1, int r2) {
    }

    public <T> T getItem() {
        return (T) this.extra.get("__________");
    }

    public SimpleViewHolder(View r1) {
        super(r1);
        this.extra = new HashMap();
        this.mViews = new SparseArray();
        ((RecyclerView.ViewHolder) this).itemView.setTag(this);
    }

    public int getInt(String r3) {
        Object r4 = this.extra.get(r3);
        if (r4 != null) goto L6;
        return 0;
    L6:
        if ((r4 instanceof String) == false) goto L15;
        return CastIntegerProtector.parseInt((String) r4);
    L9:
        return 0;
    L15:
        return ((Integer) r4).intValue();
    L12:
        return 0;
    }

    public long getLong(String r4) {
        Object r5 = this.extra.get(r4);
        if (r5 != null) goto L6;
        return 0;
    L6:
        if ((r5 instanceof String) == false) goto L15;
        return CastLongProtector.parseLong((String) r5);
    L17:
        return 0;
    L15:
        return ((Long) r5).longValue();
    L18:
        return 0;
    }

    public <V extends View> V getView(int r3) {
        V r0 = (V) this.mViews.get(r3);
        if (r0 != null) goto L6;
        V r1 = (V) ((RecyclerView.ViewHolder) this).itemView.findViewById(r3);
        this.mViews.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public SimpleViewHolder hide(int r2) {
        View r3 = getView(r2);
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        return this;
    }

    public void setItem(Object r3) {
        this.extra.put("__________", r3);
    }

    public SimpleViewHolder show(int r2) {
        View r3 = getView(r2);
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        return this;
    }

    public void put(String r2, Object r3) {
        this.extra.put(r2, r3);
    }

    public SimpleViewHolder setBackgroundResource(int r1, int r2) {
        getView(r1).setBackgroundResource(r2);
        return this;
    }

    public SimpleViewHolder setImageBitmap(int r1, Bitmap r2) {
        ((ImageView) getView(r1)).setImageBitmap(r2);
        return this;
    }

    public SimpleViewHolder setImageResource(int r1, int r2) {
        ((ImageView) getView(r1)).setImageResource(r2);
        return this;
    }

    public SimpleViewHolder setOnClickListener(int r1, View.OnClickListener r2) {
        getView(r1).setOnClickListener(r2);
        return this;
    }

    public SimpleViewHolder setText(int r1, CharSequence r2) {
        ((TextView) getView(r1)).setText(r2);
        return this;
    }

    public SimpleViewHolder setTextColor(int r1, int r2) {
        ((TextView) getView(r1)).setTextColor(r2);
        return this;
    }

    public SimpleViewHolder setText(int r1, String r2) {
        ((TextView) getView(r1)).setText(r2);
        return this;
    }
}
