package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0007J\u001a\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/SelectButtonListView;", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentIndex", "totalCount", "onButtonSelected", "Lkotlin/Function1;", "", "show", "index", "total", "hide", "getCurrentIndex", "onIndexSelected", "listener", "updateSelection", "generateSelectButtonStateList", "", "Lcom/larus/bmhome/view/SelectButtonState;", "SelectButtonAdapter", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectButtonListView extends HorizontalOverScrollRV {
    public static final /* synthetic */ int l = 0;
    public int i;
    public int j;
    public Function1<? super Integer, Unit> k;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/view/SelectButtonListView$SelectButtonAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/SelectButtonState;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "(Lcom/larus/bmhome/view/SelectButtonListView;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "SelectButtonViewHolder", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SelectButtonAdapter extends ListAdapter<f4, RecyclerView.ViewHolder> {
        public final /* synthetic */ SelectButtonListView a;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/SelectButtonListView$SelectButtonAdapter$SelectButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/view/SelectButtonListView$SelectButtonAdapter;Landroid/view/View;)V", "textIndex", "Landroid/widget/TextView;", "bind", "", "item", "Lcom/larus/bmhome/view/SelectButtonState;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SelectButtonViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int c = 0;
            public final TextView a;
            public final /* synthetic */ SelectButtonAdapter b;

            public SelectButtonViewHolder(SelectButtonAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                this.b = r2;
                super(r3);
                this.a = (TextView) r3.findViewById(2131388457);
            }
        }

        public SelectButtonAdapter(SelectButtonListView r1) {
            this.a = r1;
            super(new AnonymousClass1());
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            final f4 r5 = (f4) getItem(r4);
            if ((r3 instanceof SelectButtonViewHolder) == false) goto L6;
            SelectButtonViewHolder r6 = (SelectButtonViewHolder) r3;
            Intrinsics.checkNotNull(r5);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r5, "item");
            r6.a.setText(String.valueOf(r5.a + 1));
            r6.a.setSelected(r5.b);
            TextView r0 = r6.a;
            final SelectButtonListView r7 = r6.b.a;
            com.larus.utils.e1.d(r0, new e4(r7, r5));
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562664, r3, false);
            Intrinsics.checkNotNull(r5);
            return new SelectButtonViewHolder(this, r5);
        }
    }

    public SelectButtonListView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelectButtonListView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final List<f4> v() {
        ArrayList r0 = new ArrayList();
        int r1 = this.j;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r3 != this.i) goto L7;
        boolean r5 = true;
    L8:
        r0.add(new f4(r3, r5));
        r3 = r3 + 1;
        goto L3
    L7:
        r5 = false;
        goto L8
    L9:
        return r0;
    }

    public final int getCurrentIndex() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectButtonListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOverScrollMode(2);
        setItemAnimator(null);
        setLayoutManager(new LinearLayoutManager(r2, 0, false));
        setAdapter(new SelectButtonAdapter(this));
    }

    public /* synthetic */ SelectButtonListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
