package com.ss.android.lark.reaction.widget.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionOperationMenuAdapter extends RecyclerView.Adapter<a> {
    public c a;
    public b b;
    public final Context c;
    public final List<e> d;

    public class a extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final ImageView c;

        public a(View r2) {
            super(r2);
            this.c = (ImageView) r2.findViewById(2131375052);
            this.b = (ImageView) r2.findViewById(2131375006);
            this.a = (TextView) r2.findViewById(2131388456);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public final int getItemCount() {
        return this.d.size();
    }

    public ReactionOperationMenuAdapter(Context r2, List<e> r3) {
        this.a = null;
        this.b = null;
        this.c = r2;
        this.d = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        a r8 = (a) r6;
        e r0 = (e) ListProtector.get(this.d, r7);
        final boolean r1 = r0.e;
        e.b r2 = r0.f;
        if (r2 != null) goto L5;
    L7:
        r8.a.setText(r0.a);
        if (r1 == false) goto L10;
        int r3 = v2c.a.b(this.c, 2131102418);
    L11:
        int r4 = r0.c;
        if (r4 == (-1)) goto L14;
        Drawable r5 = UDIconUtils.getIconDrawable(this.c, r4, r3);
    L18:
        r8.c.setVisibility(8);
        r8.b.setImageDrawable(r5);
        ((RecyclerView.ViewHolder) r8).itemView.setTag(Integer.valueOf(r7));
        r8.a.setMaxLines(2);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new s2c.a(this, r1));
        r8.a.setEnabled(r1);
        r8.b.setEnabled(r1);
        r8.c.setEnabled(r1);
        e.b r9 = r0.f;
        if (r9 == null) goto L22;
        r9.onViewCreated();
        r0.f.onShow();
        return;
    L22:
        return;
    L14:
        Drawable r10 = r0.d;
        if (r1 == false) goto L17;
        r10.mutate();
        r10.setTint(r3);
    L17:
        r5 = r10;
        goto L18
    L10:
        r3 = v2c.a.b(this.c, 2131102416);
        goto L11
    L5:
        if (r2.a() == false) goto L7;
        r1 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new a(LayoutInflater.from(this.c).inflate(2131564263, r3, false));
    }
}
