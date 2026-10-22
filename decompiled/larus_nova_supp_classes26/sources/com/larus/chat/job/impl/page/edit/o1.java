package com.larus.chat.job.impl.page.edit;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.databinding.LarusChatJobEditOptionsItemBinding;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o1 extends RecyclerView.ViewHolder {
    public final LarusChatJobEditOptionsItemBinding a;
    public final List<b> b;

    public static final class a {
    }

    public static final class b {
        public final View a;
        public final TextView b;
        public final TextView c;
        public final View d;
        public final View e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            View r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            View r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "RowSlot(row=" + this.a + ", labelView=" + this.b + ", valueView=" + this.c + ", divider=" + this.d + ", arrowView=" + this.e + ')';
        }

        public b(ConstraintLayout r2, TextView r3, TextView r4, View r5, AppCompatImageView r6) {
            Intrinsics.checkNotNullParameter(r2, "row");
            Intrinsics.checkNotNullParameter(r3, "labelView");
            Intrinsics.checkNotNullParameter(r4, "valueView");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public o1(LarusChatJobEditOptionsItemBinding r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "binding");
        if (r20 == true) goto L5;
        LinearLayout r4 = r19.a;
    L6:
        super(r4);
        this.a = r19;
        this.b = CollectionsKt.listOf(new b[]{new b(r19.s, r19.r, r19.t, r19.q, r19.p), new b(r19.x, r19.w, r19.y, r19.v, r19.u), new b(r19.j, r19.i, r19.k, r19.h, r19.g), new b(r19.e, r19.d, r19.f, r19.c, r19.b), new b(r19.n, r19.m, r19.o, null, r19.l)});
        return;
    L5:
        r4 = new LinearLayout(r19.a.getContext());
        r4.setOrientation(1);
        r4.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        LinearLayout r5 = r19.a;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        r8.topMargin = i5.q();
        Unit r9 = Unit.INSTANCE;
        r4.addView(r5, r8);
        TextView r6 = new TextView(r4.getContext());
        r6.setText(gz8.f.b("triggerTasks_Card_subtitle"));
        r6.setTextSize(14.0f);
        r6.setIncludeFontPadding(false);
        int r10 = gz8.g.a;
        r6.setTextColor(gz8.g.c(r6.getContext()));
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-1, -2);
        r11.topMargin = i5.q();
        r4.addView(r6, r11);
        goto L6
    }
}
