package com.obric.assistant.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a2 {
    public static final /* synthetic */ int f = 0;
    public final View a;
    public final Function0<List<paa.e>> b;
    public final Function1<paa.e, Unit> c;
    public PopupWindow d;
    public b e;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<d> {
        public final int a;
        public final Function1<paa.e, Unit> b;
        public final List<c> c;

        public final int getItemCount() {
            return this.c.size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
            d r16 = (d) r14;
            Intrinsics.checkNotNullParameter(r16, "holder");
            final c r0 = (c) ListProtector.get(this.c, r15);
            int r1 = this.a;
            boolean r3 = true;
            int r4 = 0;
            if (r15 == (getItemCount() - 1)) goto L5;
            boolean r17 = true;
        L6:
            final Function1<paa.e, Unit> r2 = this.b;
            r16.getClass();
            Intrinsics.checkNotNullParameter(r0, "item");
            Intrinsics.checkNotNullParameter(r2, "onClick");
            paa.e r5 = r0.a;
            String r6 = r5.c;
            if (r6 != null) goto L9;
        L12:
            if (r3 == false) goto L14;
            r16.a.setActualImageResource(2131244581);
        L15:
            TextView r7 = r16.b;
            SpannableString r8 = new SpannableString(r0.a.b);
            IntIterator r9 = StringsKt.getIndices(r0.a.b).iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            int r10 = r9.nextInt();
            if (r0.b.contains(Integer.valueOf(r10)) == false) goto L21;
            int r11 = 230;
        L22:
            r8.setSpan(new ForegroundColorSpan(Color.argb(r11, Color.red(r1), Color.green(r1), Color.blue(r1))), r10, r10 + 1, 33);
            goto L17
        L21:
            r11 = 115;
            goto L22
        L23:
            r7.setText(r8);
            View r12 = r16.c;
            if (r17 == true) goto L27;
            r4 = 8;
        L27:
            r12.setVisibility(r4);
            ((RecyclerView.ViewHolder) r16).itemView.setOnClickListener(new b2(r2, r0));
            return;
        L14:
            ImageLoaderKt.u(r16.a, r5.c, "obric_mention_skill_cover");
            goto L15
        L9:
            if (StringsKt.isBlank(r6) == true) goto L12;
            r3 = false;
            goto L12
        L5:
            r17 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            View r7 = LayoutInflater.from(r5.getContext()).inflate(2131564030, r5, false);
            SimpleDraweeView r0 = r7.findViewById(2131381212);
            TextView r1 = (TextView) r7.findViewById(2131381213);
            Resources r8 = r5.getResources();
            TextViewCompat.setLineHeight(r1, (int) ((22 * WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density) + 0.5f));
            View r9 = r7.findViewById(2131381211);
            Intrinsics.checkNotNull(r7);
            Intrinsics.checkNotNull(r0);
            Intrinsics.checkNotNull(r1);
            Intrinsics.checkNotNull(r9);
            return new d(r7, r0, r1, r9);
        }

        public b(List<c> r2, int r3, Function1<? super paa.e, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r4, "onClick");
            this.a = r3;
            this.b = r4;
            this.c = CollectionsKt.toMutableList(r2);
        }
    }

    public static final class c {
        public final paa.e a;
        public final Set<Integer> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "MentionDisplayItem(mentionItem=" + this.a + ", matchedIndexes=" + this.b + ')';
        }

        public c(paa.e r2, Set<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "mentionItem");
            Intrinsics.checkNotNullParameter(r3, "matchedIndexes");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final TextView b;
        public final View c;

        public static final class a {
        }

        static {
        }

        public d(View r2, SimpleDraweeView r3, TextView r4, View r5) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "iconView");
            Intrinsics.checkNotNullParameter(r4, "textView");
            Intrinsics.checkNotNullParameter(r5, "dividerView");
            super(r2);
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    static {
    }

    public static void a(RecyclerView r5) {
        Object r0 = r5.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = r1.findViewById(2131381217);
        int r3 = 8;
        if (r2 != null) goto L11;
    L15:
        View r4 = r1.findViewById(2131381210);
        if (r4 != null) goto L18;
        return;
    L18:
        if (r5.canScrollVertically(1) == false) goto L20;
        r3 = 0;
    L20:
        r4.setVisibility(r3);
        return;
    L11:
        if (r5.canScrollVertically(-1) == false) goto L13;
        int r6 = 0;
    L14:
        r2.setVisibility(r6);
        goto L15
    L13:
        r6 = 8;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public a2(View r2, Function0 r3, q1 r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        Intrinsics.checkNotNullParameter(r3, "itemsProvider");
        Intrinsics.checkNotNullParameter(r4, "onItemClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
