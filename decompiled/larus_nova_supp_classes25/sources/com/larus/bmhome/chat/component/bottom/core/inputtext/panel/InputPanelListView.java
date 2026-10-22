package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.bottom.core.inputtext.PanelStickyHeaderDecoration;
import com.larus.bmhome.chat.component.bottom.core.inputtext.m1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.o1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class InputPanelListView {
    public static final /* synthetic */ int h = 0;
    public final Context a;
    public final LayoutInflater b;
    public final c c;
    public final int d;
    public final int e;
    public List<? extends o> f;
    public final RecyclerView g;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public List<? extends o> a;
        public String b;
        public final /* synthetic */ InputPanelListView c;

        public final int getItemCount() {
            return this.a.size();
        }

        public c(InputPanelListView r1) {
            this.c = r1;
            this.a = CollectionsKt.emptyList();
            this.b = "";
        }

        public final int getItemViewType(int r2) {
            o r3 = (o) ListProtector.get(this.a, r2);
            if ((r3 instanceof o.b) == false) goto L6;
            return 0;
        L6:
            if ((r3 instanceof o.d) == false) goto L9;
            return 1;
        L9:
            if (Intrinsics.areEqual(r3, o.c.a) == false) goto L13;
            return 2;
        L13:
            throw new NoWhenBranchMatchedException();
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r2) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            ExposeXTrackerExtKt.e(r2.itemView);
            super.onViewRecycled(r2);
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            o r6 = (o) ListProtector.get(this.a, r5);
            if ((r6 instanceof o.b) == false) goto L6;
            View r7 = r4.itemView;
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) r7).setText(((o.b) r6).a);
            return;
        L6:
            if ((r6 instanceof o.d) == false) goto L9;
            String r1 = this.b;
            int r2 = InputPanelListView.h;
            this.c.a(((d) r4).a, (o.d) r6, r1);
            return;
        L9:
            if (Intrinsics.areEqual(r6, o.c.a) == false) goto L12;
            return;
        L12:
            throw new NoWhenBranchMatchedException();
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 != 0) goto L5;
            InputPanelListView r0 = this.c;
            int r1 = InputPanelListView.h;
            return new f(r0.c(r3));
        L5:
            if (r4 == 2) goto L7;
            InputPanelListView r2 = this.c;
            int r5 = InputPanelListView.h;
            return new d(r2.d(r3));
        L7:
            InputPanelListView r6 = this.c;
            int r7 = InputPanelListView.h;
            return new b(m1.a(r6.b, r3));
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final e a;

        public d(e r2) {
            Intrinsics.checkNotNullParameter(r2, "views");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class e {
        public final View a;
        public final ImageView b;
        public final TextView c;
        public final TextView d;
        public final ImageView e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
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
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "RowViews(root=" + this.a + ", icon=" + this.b + ", title=" + this.c + ", description=" + this.d + ", trailingIcon=" + this.e + ')';
        }

        public e(View r2, ImageView r3, TextView r4, TextView r5, ImageView r6) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "icon");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, "description");
            Intrinsics.checkNotNullParameter(r6, "trailingIcon");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class f extends RecyclerView.ViewHolder {
        public f(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    static {
    }

    public InputPanelListView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.a = r5;
        this.b = LayoutInflater.from(r5);
        c r1 = new c(this);
        this.c = r1;
        Intrinsics.checkNotNullParameter(r5, "context");
        this.d = r5.getResources().getDimensionPixelSize(v19.c.b(2130971481, r5, 2131167332));
        this.e = c7.b(360);
        this.f = CollectionsKt.emptyList();
        RecyclerView r0 = new RecyclerView(r5);
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext()));
        r0.setAdapter(r1);
        r0.setItemAnimator(null);
        ExposeXTrackerExtKt.c(r0);
        r0.addItemDecoration(new PanelStickyHeaderDecoration(new InputPanelListView$view$1$1(r1), new InputPanelListView$view$1$2(this)));
        this.g = r0;
    }

    public static int b(List r3) {
        boolean r1 = true;
        if ((!r3.isEmpty()) == false) goto L17;
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L7;
    L9:
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        if (Intrinsics.areEqual((o) r5.next(), o.c.a) == true) goto L11;
        r1 = false;
    L15:
        if (r1 == false) goto L17;
        return 6;
    L7:
        if (r4.isEmpty() == false) goto L9;
    L17:
        return 4;
    }

    public final TextView c(ViewGroup r4) {
        View r5 = this.b.inflate(2131562603, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        TextView r6 = (TextView) r5;
        nda.d.a().wa(r6);
        return r6;
    }

    public final e d(ViewGroup r10) {
        View r4 = this.b.inflate(2131562606, r10, false);
        Intrinsics.checkNotNull(r4);
        return new e(r4, (ImageView) r4.findViewById(2131381888), (TextView) r4.findViewById(2131381892), (TextView) r4.findViewById(2131381887), (ImageView) r4.findViewById(2131381893));
    }

    public final void a(e r9, final o.d r10, String r11) {
        ExposeXTrackerExtKt.e(r9.a);
        final String r0 = r10.l;
        final Function0<Unit> r1 = r10.m;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        ExposeXTrackerExtKt.b(r9.a, new p(r1, r0));
    L6:
        r9.a.setEnabled(r10.k);
        r9.a.setClickable(r10.k);
        r9.a.setFocusable(r10.k);
        View r2 = r9.a;
        if (r10.k == false) goto L9;
        float r3 = 1.0f;
    L10:
        r2.setAlpha(r3);
        ColorStateList r4 = null;
        if (r10.k == false) goto L13;
        r9.a.setOnClickListener(new q(r10));
    L14:
        final Function1<View, Unit> r5 = r10.n;
        int r6 = 0;
        if (r10.k == false) goto L18;
        if (r5 == null) goto L18;
        r9.a.setOnLongClickListener(new r(r5));
    L19:
        t1 r7 = r10.e;
        TextView r8 = r9.c;
        if (r10.b == false) goto L22;
        TextUtils.TruncateAt r12 = null;
    L23:
        r8.setEllipsize(r12);
        r9.c.setHorizontalFadingEdgeEnabled(r10.b);
        TextView r13 = r9.c;
        if (r10.b == false) goto L26;
        int r14 = c7.b(24);
    L27:
        r13.setFadingEdgeLength(r14);
        r9.c.scrollTo(0, 0);
        if (r7 == null) goto L30;
        o1.a(r9.c, r10.a, r7.b);
        o1.a(r9.d, r10.c, r7.c);
    L31:
        r9.d.setAlpha(r10.d);
        TextView r15 = r9.d;
        boolean r16 = true;
        if ((!StringsKt.isBlank(r10.c)) == false) goto L34;
        int r17 = 0;
    L35:
        r15.setVisibility(r17);
        ImageView r18 = r9.e;
        if (r10.i != null) goto L39;
        r16 = false;
    L39:
        if (r16 == true) goto L42;
        r6 = 8;
    L42:
        r18.setVisibility(r6);
        Integer r19 = r10.i;
        if (r19 == null) goto L45;
        r9.e.setImageResource(r19.intValue());
    L45:
        ImageView r110 = r9.e;
        Integer r20 = r10.j;
        if (r20 == null) goto L48;
        ColorStateList r21 = ColorStateList.valueOf(r20.intValue());
    L49:
        r110.setImageTintList(r21);
        Drawable r111 = r10.g;
        if (r111 == null) goto L52;
        r9.b.setImageDrawable(r111);
    L55:
        ImageView r22 = r9.b;
        Integer r112 = r10.h;
        if (r112 == null) goto L58;
        r4 = ColorStateList.valueOf(r112.intValue());
    L64:
        r22.setImageTintList(r4);
        return;
    L58:
        Integer r113 = r10.f;
        if (r113 == null) goto L64;
        if (r113.intValue() != 2131241523) goto L64;
        r4 = ContextCompat.getColorStateList(this.a, R.color.holo_blue_light);
        goto L64
    L52:
        Integer r114 = r10.f;
        if (r114 == null) goto L55;
        r9.b.setImageResource(r114.intValue());
        goto L55
    L48:
        r21 = null;
        goto L49
    L34:
        r17 = 8;
        goto L35
    L30:
        TextView r23 = r9.c;
        String r24 = r10.a;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Intrinsics.checkNotNullParameter(r24, "value");
        Intrinsics.checkNotNullParameter(r11, "keyword");
        o1.b(r23, r24, CollectionsKt.listOf(r11));
        TextView r25 = r9.d;
        String r26 = r10.c;
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Intrinsics.checkNotNullParameter(r26, "value");
        Intrinsics.checkNotNullParameter(r11, "keyword");
        o1.b(r25, r26, CollectionsKt.listOf(r11));
        goto L31
    L26:
        r14 = 0;
        goto L27
    L22:
        r12 = TextUtils.TruncateAt.END;
    L18:
        r9.a.setOnLongClickListener(null);
        r9.a.setLongClickable(false);
        goto L19
    L13:
        r9.a.setOnClickListener(null);
        goto L14
    L9:
        r3 = 0.4f;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.ViewGroup, android.widget.LinearLayout, java.lang.Object] */
    public final void e(LinearLayout r3, List<? extends o> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "items");
        Intrinsics.checkNotNullParameter(r5, "highlightKeyword");
        r3.removeAllViews();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        o r0 = (o) r6.next();
        if ((r0 instanceof o.b) == false) goto L9;
        ?? r1 = c(r3);
        r1.setText(((o.b) r0).a);
    L14:
        r3.addView(r1);
        goto L4
    L9:
        if ((r0 instanceof o.d) == false) goto L12;
        e r2 = d(r3);
        a(r2, (o.d) r0, r5);
        r1 = r2.a;
        goto L14
    L12:
        if (Intrinsics.areEqual(r0, o.c.a) == false) goto L16;
        r1 = m1.a(this.b, r3);
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
