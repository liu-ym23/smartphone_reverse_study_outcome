package com.bytedance.android.live.browser.webview.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/browser/webview/fragment/HybridDebugConsoleDialog$HybridDebugConsoleAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/browser/webview/fragment/HybridDebugConsoleDialog$HybridDebugConsoleViewHolder;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridDebugConsoleDialog$HybridDebugConsoleAdapter extends RecyclerView.Adapter<HybridDebugConsoleDialog$HybridDebugConsoleViewHolder> {
    public int a;
    public final List<j> b;

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public HybridDebugConsoleDialog$HybridDebugConsoleAdapter() {
        this.a = -1;
        this.b = new ArrayList();
        System.getProperty("line.separator");
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        HybridDebugConsoleDialog$HybridDebugConsoleViewHolder r8 = (HybridDebugConsoleDialog$HybridDebugConsoleViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "p0");
        ((j) ListProtector.get(this.b, r7)).getClass();
        r8.b.setText("UnKnown");
        TextView r0 = r8.b;
        ((j) ListProtector.get(this.b, r7)).getClass();
        r8.b.setVisibility(8);
        r0.setText("");
        TextView r1 = r8.b;
        ((j) ListProtector.get(this.b, r7)).getClass();
        r1.setText(null);
        TextView r2 = r8.a;
        ((j) ListProtector.get(this.b, r7)).getClass();
        r2.setText(null);
        TextView r3 = r8.c;
        ((j) ListProtector.get(this.b, r7)).getClass();
        r3.setText(null);
        TextView r4 = r8.d;
        ((j) ListProtector.get(this.b, r7)).getClass();
        r8.d.setVisibility(8);
        r4.setText("");
        TextView r5 = r8.e;
        ((j) ListProtector.get(this.b, r7)).getClass();
        r8.e.setVisibility(8);
        r5.setText("");
        if (r7 != this.a) goto L5;
        r8.g.setVisibility(0);
        return;
    L5:
        r8.g.setVisibility(8);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        HybridDebugConsoleDialog$HybridDebugConsoleViewHolder r5 = new HybridDebugConsoleDialog$HybridDebugConsoleViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131566273, r3, false));
        r5.f.setOnClickListener(new k(this, r5));
        return r5;
    }
}
