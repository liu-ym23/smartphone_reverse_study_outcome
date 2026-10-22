package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.d;
import zv8.e;
import zv8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceInputViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "editor", "Landroid/widget/EditText;", "confirm", "Landroid/widget/Button;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceInputViewHolder extends EntranceViewHolder {
    public static final /* synthetic */ int d = 0;
    public EditText b;
    public Button c;

    public EntranceInputViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r7) {
        Intrinsics.checkNotNullParameter(r7, "debugEntrance");
        Intrinsics.checkNotNullParameter(r7, "debugEntrance");
        this.a = r7;
        this.b = (EditText) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371707);
        this.c = (Button) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371706);
        if ((r7 instanceof n) == false) goto L5;
        final n r0 = (n) r7;
    L6:
        if (r0 == null) goto L32;
        EditText r1 = this.b;
        boolean r2 = false;
        String r4 = "";
        if (r1 != null) goto L10;
    L17:
        EditText r3 = this.b;
        if (r3 == null) goto L20;
        r3.setText(r0.f());
    L20:
        Button r5 = this.c;
        if (r5 != null) goto L23;
    L28:
        Button r6 = this.c;
        if (r6 == null) goto L33;
        r6.setOnClickListener(new d(r7, r0, this));
        return;
    L33:
        return;
    L23:
        if ("".length() != 0) goto L25;
        r2 = true;
    L25:
        if (r2 == false) goto L27;
        r4 = "确认设置";
    L27:
        r5.setText(r4);
        goto L28
    L10:
        if ("".length() != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        String r9 = r0.c();
    L16:
        r1.setHint(r9);
        goto L17
    L15:
        r9 = "";
        goto L16
    L12:
        r8 = false;
        goto L13
    L32:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r2) {
        Intrinsics.checkNotNullParameter(r2, "debugEntrance");
        Intrinsics.checkNotNullParameter(r2, "debugEntrance");
        EditText r3 = this.b;
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        Button r4 = this.c;
        if (r4 == null) goto L8;
        r4.setVisibility(0);
    L8:
        EditText r5 = this.b;
        if (r5 == null) goto L11;
        r5.setText("");
    L11:
        EditText r6 = this.b;
        if (r6 == null) goto L14;
        r6.setHint("");
    L14:
        Button r7 = this.c;
        if (r7 == null) goto L18;
        r7.setOnClickListener(null);
        return;
    }
}
