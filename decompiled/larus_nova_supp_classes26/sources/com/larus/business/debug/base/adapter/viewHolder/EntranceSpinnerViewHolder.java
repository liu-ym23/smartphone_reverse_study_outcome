package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;
import zv8.k;
import zv8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceSpinnerViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "spinnerName", "Landroid/widget/TextView;", "spinnerView", "Landroid/widget/Spinner;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceSpinnerViewHolder extends EntranceViewHolder {
    public TextView b;
    public Spinner c;

    public static final class a implements AdapterView.OnItemSelectedListener {
        public boolean a;
        public final /* synthetic */ e b;
        public final /* synthetic */ AdapterView.OnItemSelectedListener c;

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> r2) {
            this.c.onNothingSelected(r2);
        }

        public a(e r1, AdapterView.OnItemSelectedListener r2) {
            this.b = r1;
            this.c = r2;
            this.a = true;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> r8, View r9, int r10, long r11) {
            if (this.a == false) goto L6;
            this.a = false;
            return;
        L6:
            k.e(this.b);
            this.c.onItemSelected(r8, r9, r10, r11);
        }
    }

    public EntranceSpinnerViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(e r5) {
        Intrinsics.checkNotNullParameter(r5, "debugEntrance");
        Intrinsics.checkNotNullParameter(r5, "debugEntrance");
        this.a = r5;
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371710);
        this.c = (Spinner) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371709);
        if ((r5 instanceof o) == false) goto L5;
        o r0 = (o) r5;
    L6:
        if (r0 == null) goto L20;
        TextView r1 = this.b;
        if (r1 == null) goto L10;
        r1.setText(r0.c());
    L10:
        Spinner r2 = this.c;
        if (r2 == null) goto L13;
        r2.setAdapter(r0.f());
    L13:
        AdapterView.OnItemSelectedListener r3 = r0.h();
        Spinner r4 = this.c;
        if (r4 == null) goto L16;
        r4.setOnItemSelectedListener(new a(r5, r3));
    L16:
        Spinner r6 = this.c;
        if (r6 == null) goto L21;
        r6.setSelection(r0.g());
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r3) {
        Intrinsics.checkNotNullParameter(r3, "debugEntrance");
        Intrinsics.checkNotNullParameter(r3, "debugEntrance");
        TextView r4 = this.b;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        Spinner r5 = this.c;
        if (r5 == null) goto L8;
        r5.setVisibility(0);
    L8:
        TextView r6 = this.b;
        if (r6 == null) goto L11;
        r6.setText("");
    L11:
        Spinner r7 = this.c;
        if (r7 == null) goto L14;
        r7.setAdapter(null);
    L14:
        Spinner r8 = this.c;
        if (r8 == null) goto L17;
        r8.setOnItemSelectedListener(null);
    L17:
        Spinner r9 = this.c;
        if (r9 == null) goto L21;
        r9.setSelection(0);
        return;
    }
}
