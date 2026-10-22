package com.ss.android.lark.picker.doubao.selectedmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.picker.doubao.view.DoubaoCustomBinderViewHolder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DoubaoSelectedMoreAdapter extends LarkRecyclerViewBaseAdapter<SelectedMemberViewHolder, SearchBaseInfo> {
    private static final String TAG = "LarkSearch.Common.SelectedMoreAdapter";
    private Context mContext;
    private OnItemRemoveListener mItemRemoveListener;

    public interface OnItemRemoveListener {
        void onItemRemove(SearchBaseInfo r1);
    }

    public static class SelectedMemberViewHolder extends RecyclerView.ViewHolder {
        public DoubaoCustomBinderViewHolder innerHolder;
        public View item;
        public View remove;

        public SelectedMemberViewHolder(View r3) {
            super(r3);
            this.item = r3.findViewById(2131370095);
            this.innerHolder = new DoubaoCustomBinderViewHolder(this.item);
            this.remove = r3.findViewById(2131385848);
        }
    }

    public DoubaoSelectedMoreAdapter(Context r1) {
        this.mContext = r1;
    }

    public static /* synthetic */ OnItemRemoveListener access$000(DoubaoSelectedMoreAdapter r0) {
        return r0.mItemRemoveListener;
    }

    public void setOnItemRemoveListener(OnItemRemoveListener r1) {
        this.mItemRemoveListener = r1;
    }

    public void onBindViewHolder(SelectedMemberViewHolder r3, int r4) {
        final SearchBaseInfo r5 = (SearchBaseInfo) getItem(r4);
        r3.remove.setOnClickListener(new AnonymousClass1(this, r5));
        r3.innerHolder.bindTitle(r5);
        r3.innerHolder.bindAvatar(r5);
        r3.innerHolder.bindSummary(r5);
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public SelectedMemberViewHolder m3385onCreateViewHolder(ViewGroup r4, int r5) {
        return new SelectedMemberViewHolder(LayoutInflater.from(this.mContext).inflate(2131560177, r4, false));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SelectedMemberViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m3385onCreateViewHolder(r1, r2);
    }
}
