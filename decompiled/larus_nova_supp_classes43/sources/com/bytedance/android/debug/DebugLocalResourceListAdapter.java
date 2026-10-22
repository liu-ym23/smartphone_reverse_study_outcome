package com.bytedance.android.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/debug/DebugLocalResourceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/debug/DebugLocalResourceListAdapter$AssetHolder;", "Landroid/widget/Filterable;", "<init>", "()V", "a", "AssetHolder", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugLocalResourceListAdapter extends RecyclerView.Adapter<AssetHolder> implements Filterable {
    public final List<a> a;
    public final List<a> b;
    public b c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/debug/DebugLocalResourceListAdapter$AssetHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AssetHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final Button b;

        public AssetHolder(View r10) {
            Intrinsics.checkNotNullParameter(r10, "itemView");
            super(r10);
            View r0 = r10.findViewById(2131363260);
            if (r0 == null) goto L11;
            this.a = (TextView) r0;
            View r11 = r10.findViewById(2131368789);
            if (r11 == null) goto L9;
            this.b = (Button) r11;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L14;
            a r11 = (a) r10;
            if (this.a == r11.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r10 = this.b;
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            int r13 = (r1 + r12) * 31;
            String r14 = this.c;
            if (r14 == null) goto L9;
            int r15 = r14.hashCode();
        L10:
            int r16 = (r13 + r15) * 31;
            String r17 = this.d;
            if (r17 == null) goto L14;
            r11 = r17.hashCode();
        L14:
            return r16 + r11;
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }

        public final String toString() {
            return "AssetDebugModel(assetId=" + this.a + ", assetCleanType=" + this.b + ", assetSize=" + this.c + ", md5=" + this.d + ")";
        }

        public a(long r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r11, "assetCleanType");
            Intrinsics.checkNotNullParameter(r12, "assetSize");
            Intrinsics.checkNotNullParameter(r13, "md5");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public interface b {
        void a(String r1);
    }

    public static final class c extends Filter {
        public final /* synthetic */ DebugLocalResourceListAdapter a;

        public c(DebugLocalResourceListAdapter r1) {
            this.a = r1;
        }

        @Override // android.widget.Filter
        public final Filter.FilterResults performFiltering(CharSequence r10) {
            String r11 = String.valueOf(r10);
            Filter.FilterResults r0 = new Filter.FilterResults();
            if (r11.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            ArrayList r12 = new ArrayList();
            r12.addAll(this.a.a);
            r0.values = r12;
        L19:
            return r0;
        L8:
            ArrayList r13 = new ArrayList();
            Iterator r14 = ((ArrayList) this.a.a).iterator();
        L10:
            if (r14.hasNext() == false) goto L18;
            a r15 = (a) r14.next();
            String r16 = String.valueOf(r15.a) + ": " + r15.b + ": " + r15.c + "kb";
            if (r16 == null) goto L17;
            if (StringsKt.contains$default(StringsKt.trim(r16).toString(), r11, false, 2, null) == false) goto L10;
            r13.add(r15);
            goto L10
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L18:
            r0.values = r13;
            goto L19
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.widget.Filter
        public final void publishResults(CharSequence r10, Filter.FilterResults r11) {
            Object r12 = null;
            if (r11 == null) goto L5;
            Object r0 = r11.values;
        L6:
            if (r0 == null) goto L17;
            Object r13 = r11.values;
            if (TypeIntrinsics.isMutableList(r13) == false) goto L11;
            r12 = r13;
        L11:
            List r14 = (List) r12;
            if (r14 == null) goto L16;
            List r15 = r14;
            if ((!r15.isEmpty()) == false) goto L16;
            ((ArrayList) this.a.b).clear();
            ((ArrayList) this.a.b).addAll(r15);
        L16:
            ((ArrayList) this.a.b).clear();
        L17:
            this.a.notifyDataSetChanged();
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return new c(this);
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public DebugLocalResourceListAdapter() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        AssetHolder r12 = (AssetHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        a r13 = (a) ListProtector.get(this.b, r11);
        String r0 = String.valueOf(r13.a) + ": " + r13.b + ": " + r13.c + "kb";
        if (r0 == null) goto L7;
        String r1 = StringsKt.trim(r0).toString();
        r12.a.setText(r1);
        r12.b.setOnClickListener(new j(r12, r13));
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new k(this, r1));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        return new AssetHolder(LayoutInflater.from(r10.getContext()).inflate(2131565161, null));
    }
}
