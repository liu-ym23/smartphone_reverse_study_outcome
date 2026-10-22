package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.menu.databinding.UdItemMenuBinding;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<c> {
        public final Context a;
        public final ArrayList<g> b;
        public boolean c;

        public final int getItemCount() {
            return this.b.size();
        }

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            c r6 = (c) r4;
            Intrinsics.checkNotNullParameter(r6, "holder");
            if (r5 >= getItemCount()) goto L24;
            g r0 = (g) ListProtector.get(this.b, r5);
            int r1 = r0.getIcon();
            if (r1 != 0) goto L8;
            r6.a.c.setImageDrawable(null);
        L9:
            int r2 = r0.c();
            if (r2 == 0) goto L12;
            ColorStateList r3 = UDColorUtils.getColorStateList(this.a, r2);
            r6.a.c.setImageTintList(r3);
        L12:
            int r7 = r0.b();
            if (r7 == 0) goto L16;
            r6.a.c.setImageTintList(ColorStateList.valueOf(r7));
        L16:
            if (this.c == false) goto L18;
            r6.a.d.setMaxLines(1);
            r6.a.b.setMaxLines(2);
        L19:
            r6.a.d.setText(r0.getName());
            int r8 = r0.getTextColor();
            if (r8 == 0) goto L22;
            r6.a.d.setTextColor(r8);
        L22:
            r0.getDescription();
            r6.a.b.setVisibility(8);
            ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new i(r0, r5));
            ((RecyclerView.ViewHolder) r6).itemView.setEnabled(r0.isEnabled());
            return;
        L18:
            r6.a.d.setMaxLines(LKUIToast.DURATION_MAX);
            r6.a.b.setMaxLines(LKUIToast.DURATION_MAX);
            goto L19
        L8:
            r6.a.c.setImageResource(r1);
            goto L9
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            ConstraintLayout r6 = LayoutInflater.from(this.a).inflate(2131568094, r4, false);
            int r7 = 2131379908;
            TextView r0 = (TextView) ViewBindings.findChildViewById(r6, 2131379908);
            if (r0 == null) goto L11;
            r7 = 2131379912;
            ImageView r1 = (ImageView) ViewBindings.findChildViewById(r6, 2131379912);
            if (r1 == null) goto L11;
            r7 = 2131379921;
            TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131379921);
            if (r2 == null) goto L11;
            return new c(new UdItemMenuBinding(r6, r0, r1, r2));
        L11:
            throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final UdItemMenuBinding a;

        public c(UdItemMenuBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "viewBinding");
            super(r2.a);
            this.a = r2;
        }
    }

    static {
    }
}
