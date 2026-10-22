package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q20.b;
import q20.c;
import q20.d;
import q20.e;
import q20.f;
import q20.g;
import r20.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u000bR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/HybridHistoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/browser/debug/mock/HybridHistoryListAdapter$ViewHolder;", "Landroidx/fragment/app/FragmentActivity;", "b", "Landroidx/fragment/app/FragmentActivity;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "setContext", "(Landroidx/fragment/app/FragmentActivity;)V", "context", "ViewHolder", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridHistoryListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<a> a;
    public final FragmentActivity b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/HybridHistoryListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final Button e;
        public final Button f;
        public final TextView g;
        public final Button h;
        public final Button i;
        public final Button j;

        public final String toString() {
            return super.toString() + " '" + this.b.getText() + "'";
        }

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131375812);
            this.b = (TextView) r2.findViewById(2131381744);
            this.c = (TextView) r2.findViewById(2131381674);
            this.d = (TextView) r2.findViewById(2131381675);
            TextView r0 = (TextView) r2.findViewById(2131379529);
            this.e = (Button) r2.findViewById(2131373335);
            this.f = (Button) r2.findViewById(2131367959);
            this.g = (TextView) r2.findViewById(2131379530);
            this.h = (Button) r2.findViewById(2131381520);
            this.i = (Button) r2.findViewById(2131381505);
            this.j = (Button) r2.findViewById(2131385931);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final FragmentActivity getContext() {
        return this.b;
    }

    public HybridHistoryListAdapter(List<a> r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "values");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ViewHolder r7 = (ViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        a r0 = (a) ListProtector.get(this.a, r6);
        TextView r1 = r7.a;
        StringBuilder r2 = new StringBuilder();
        if (r0.a == false) goto L5;
        String r3 = "TOP";
    L6:
        r2.append(r3);
        r2.append(String.valueOf(this.a.size() - r6));
        r1.setText(r2.toString());
        r7.b.setText(r0.b.toString());
        Uri r8 = UriProtector.parse(UriProtector.getQueryParameter(r0.b, LiveSlardarConstants.EXTRA_KEY_URL));
        r7.c.setText(r8.getHost());
        r7.d.setText(r8.getPath());
        r7.e.setOnClickListener(new b(r0));
        r7.g.setOnClickListener(new c(this, r0));
        r7.h.setOnClickListener(new d(this, r0));
        r7.i.setOnClickListener(new e(this, r0));
        r7.j.setOnClickListener(new f(r0));
        r7.f.setOnClickListener(new g(this, r0));
        return;
    L5:
        r3 = "";
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131561210, r3, false));
    }
}
