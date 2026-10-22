package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import bt8.q;
import bt8.r;
import bt8.s;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.w;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DropdownBoxListAdapter extends ListAdapter<h, bt8.h> {
    public static final DropdownBoxListAdapter$Companion$DIFF$1 d = null;
    public final Function3<Integer, Long, Integer, Unit> a;
    public final Function3<h, w, Integer, Unit> b;
    public final Function0<Boolean> c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.edit.kmp.widget.DropdownBoxListAdapter$Companion$DIFF$1] */
    static {
        d = new DropdownBoxListAdapter$Companion$DIFF$1();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        final bt8.h r10 = (bt8.h) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        r10.setIsRecyclable(false);
        final h r11 = (h) getItem(r9);
        Intrinsics.checkNotNullParameter(r11, "dropdown");
        AppCompatTextView r1 = r10.a.c;
        String r2 = r11.c;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.setText(r2);
        e1.x(r10.a.c);
        List r4 = r11.e;
        w r5 = null;
        Object r6 = null;
        if (r4 == null) goto L20;
        Iterator r7 = r4.iterator();
    L9:
        if (r7.hasNext() == false) goto L19;
        Object r12 = r7.next();
        Integer r13 = ((w) r12).s;
        if (r13 == null) goto L16;
        boolean r14 = true;
        if (r13.intValue() != 1) goto L16;
    L17:
        if (r14 == false) goto L9;
        r6 = r12;
    L16:
        r14 = false;
    L19:
        r5 = (w) r6;
    L20:
        if (r5 != null) goto L22;
        e1.o(r10.a.d);
    L27:
        e1.d(r10.a.a, new bt8.a(r10, r11));
        return;
    L22:
        AppCompatTextView r0 = r10.a.d;
        String r15 = r5.b();
        if (r15 == null) goto L26;
        r3 = r15;
    L26:
        r0.setText(r3);
        e1.x(r10.a.d);
        goto L27
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new bt8.h(LarusItemActionbarDropdownListBinding.b(LayoutInflater.from(r4.getContext()), r4, false), this.a, this.b, this.c);
    }

    public DropdownBoxListAdapter(q r2, r r3, s r4) {
        Intrinsics.checkNotNullParameter(r2, "onOptionSelected");
        Intrinsics.checkNotNullParameter(r3, "onOptionShow");
        Intrinsics.checkNotNullParameter(r4, "shouldConsumeOutsideClick");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
