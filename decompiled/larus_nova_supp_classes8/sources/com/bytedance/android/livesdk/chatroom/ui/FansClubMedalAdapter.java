package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.FansClubMedal;
import com.bytedance.android.live.base.model.user.FansClubData;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FansClubMedalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<FansClubMedal> a;
    public final FansClubData b;
    public boolean c;
    public final a d;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {
        public final HSImageView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final View e;
        public final TextView f;
        public FansClubMedal g;
        public final int h;
        public final /* synthetic */ FansClubMedalAdapter i;

        public b(FansClubMedalAdapter r1, View r2, int r3) {
            this.i = r1;
            super(r2);
            this.h = r3;
            HSImageView r4 = r2.findViewById(2131372095);
            this.a = r4;
            this.b = (TextView) r2.findViewById(2131388772);
            this.c = (TextView) r2.findViewById(2131377837);
            this.e = r2.findViewById(2131385840);
            this.d = (TextView) r2.findViewById(2131362587);
            r4.setOnClickListener(new j6(this));
            TextView r5 = (TextView) r2.findViewById(2131372089);
            this.f = r5;
            r5.setOnClickListener(new k6(this));
        }
    }

    public final int getItemCount() {
        List<FansClubMedal> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public final int getItemViewType(int r3) {
        if (r3 != (this.a.size() - 1)) goto L5;
        return 1;
    L5:
        return 0;
    }

    public static void z2(FansClubMedalAdapter r3, FansClubMedal r4) {
        if (r4 == null) goto L4;
        r3.getClass();
        r4.setSelected(true);
    L4:
        Iterator<FansClubMedal> r0 = r3.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        FansClubMedal r1 = r0.next();
        if (r1 == null) goto L6;
        if (r1.equals(r4) == true) goto L6;
        r1.setSelected(false);
        goto L6
    L12:
        r3.notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        b r8 = (b) r6;
        FansClubMedal r9 = (FansClubMedal) ListProtector.get(this.a, r7);
        r8.g = r9;
        int r2 = 0;
        if (r8.h != 1) goto L5;
        y2(r8.i, r8.f, 0);
        y2(r8.i, r8.a, 8);
        y2(r8.i, r8.b, 8);
        y2(r8.i, r8.c, 8);
        y2(r8.i, r8.d, 8);
    L20:
        if (r9 == null) goto L27;
        View r10 = r8.e;
        if (r9.isSelected() == true) goto L25;
        r2 = 4;
    L25:
        r10.setVisibility(r2);
        return;
    L27:
        return;
    L5:
        y2(r8.i, r8.f, 8);
        y2(r8.i, r8.a, 0);
        y2(r8.i, r8.b, 0);
        y2(r8.i, r8.c, 0);
        y2(r8.i, r8.d, 0);
        if (r9.getBadge() == null) goto L8;
        ImageLoader.bindImage(r8.a, r9.getBadge().getIcon());
        r8.b.setText(r9.getBadge().getTitle());
    L8:
        r8.c.setText(com.bytedance.android.live.core.utils.s1.C(2131916541, new Object[]{String.valueOf(r9.getLevel())}));
        if (r9.getAnchor() == null) goto L11;
        r8.d.setText(r9.getAnchor().getNickName());
    L11:
        FansClubMedalAdapter r0 = r8.i;
        if (r0.c == false) goto L20;
        FansClubData r1 = r0.b;
        if (r1 == null) goto L20;
        if (TextUtils.isEmpty(r1.getClubName()) == true) goto L20;
        if (r8.i.b.getClubName().equals(r9.getBadge().getTitle()) == false) goto L20;
        r9.setSelected(true);
        r8.i.c = false;
        goto L20
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new b(this, LayoutInflater.from(r4.getContext()).inflate(2131566254, r4, false), r5);
    }

    public FansClubMedalAdapter(List r3, FansClubData r4, r7 r5) {
        this.c = true;
        if (r3 == null) goto L8;
        FansClubMedal r1 = new FansClubMedal();
        if (r4 != null) goto L7;
        r1.setSelected(true);
    L7:
        r3.add(r1);
    L8:
        this.a = r3;
        this.b = r4;
        this.d = r5;
    }

    public static void y2(FansClubMedalAdapter r0, View r1, int r2) {
        r0.getClass();
        if (r1 == null) goto L6;
        r1.setVisibility(r2);
        return;
    }
}
