package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.f;
import zv8.e;
import zv8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceSwitchViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", ItemStyle.ITEM_STYLE_SWITCH, "Landroidx/appcompat/widget/SwitchCompat;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceSwitchViewHolder extends EntranceViewHolder {
    public static final /* synthetic */ int c = 0;
    public SwitchCompat b;

    public EntranceSwitchViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r4) {
        Intrinsics.checkNotNullParameter(r4, "debugEntrance");
        Intrinsics.checkNotNullParameter(r4, "debugEntrance");
        this.a = r4;
        SwitchCompat r0 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371711);
        this.b = r0;
        if (r0 == null) goto L6;
        r0.setOnLongClickListener(new sv8.e(r4));
    L6:
        if ((r4 instanceof p) == false) goto L8;
        final p r1 = (p) r4;
    L9:
        if (r1 == null) goto L16;
        final SwitchCompat r2 = this.b;
        if (r2 == null) goto L13;
        r1.b = r2;
    L13:
        if (r2 == null) goto L17;
        r2.setText(r1.c());
        r2.setChecked(r1.f());
        r2.setOnCheckedChangeListener(new f(r4, r1, r2));
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r4) {
        Intrinsics.checkNotNullParameter(r4, "debugEntrance");
        Intrinsics.checkNotNullParameter(r4, "debugEntrance");
        if ((r4 instanceof p) == false) goto L5;
        p r5 = (p) r4;
    L6:
        if (r5 != null) goto L8;
    L10:
        SwitchCompat r6 = this.b;
        if (r6 == null) goto L13;
        r6.setVisibility(0);
    L13:
        SwitchCompat r7 = this.b;
        if (r7 == null) goto L16;
        r7.setText("");
    L16:
        SwitchCompat r8 = this.b;
        if (r8 == null) goto L20;
        r8.setOnCheckedChangeListener(null);
        return;
    L20:
        return;
    L8:
        if (r5.b != this.b) goto L10;
        r5.b = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
