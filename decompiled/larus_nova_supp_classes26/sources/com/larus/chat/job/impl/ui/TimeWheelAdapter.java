package com.larus.chat.job.impl.ui;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TimeWheelAdapter<T> extends RecyclerView.Adapter<TimeWheelAdapter<T>.WheelViewHolder> {
    public final List<T> a;
    public final boolean b;
    public final int c;
    public final float d;
    public final int e;
    public final int f;
    public final Function1<T, String> g;
    public int h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/chat/job/impl/ui/TimeWheelAdapter$WheelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "textView", "Landroid/widget/TextView;", "<init>", "(Lcom/larus/chat/job/impl/ui/TimeWheelAdapter;Landroid/widget/TextView;)V", "getTextView", "()Landroid/widget/TextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WheelViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public WheelViewHolder(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "textView");
            super(r2);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        if (this.b == false) goto L8;
        if (this.a.size() <= 1) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return this.a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        WheelViewHolder r7 = (WheelViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        TextView r0 = r7.a;
        Function1<T, String> r1 = this.g;
        List<T> r2 = this.a;
        r0.setText((CharSequence) r1.invoke(ListProtector.get(r2, r6 % r2.size())));
        TextView r8 = r7.a;
        if (r6 != this.h) goto L5;
        int r9 = this.e;
    L6:
        r8.setTextColor(r9);
        return;
    L5:
        r9 = this.f;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        TextView r5 = new TextView(r3.getContext());
        r5.setGravity(17);
        r5.setIncludeFontPadding(false);
        r5.setTextSize(0, this.d);
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, this.c));
        return new WheelViewHolder(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TimeWheelAdapter(List<? extends T> r2, int r3, boolean r4, int r5, float r6, int r7, int r8, Function1<? super T, String> r9) {
        Intrinsics.checkNotNullParameter(r2, "values");
        Intrinsics.checkNotNullParameter(r9, "valueFormatter");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r3;
    }
}
