package com.larus.dora.impl.device.scan;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraDialogScanDeviceItemBinding;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007J\u001a\u0010\u000e\u001a\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/device/scan/ScanDeviceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/device/scan/ScanDeviceViewHolder;", "<init>", "()V", "data", "", "Lcom/larus/dora/impl/device/scan/ScanDeviceModel;", "clickAction", "Lkotlin/Function1;", "", "addDevice", "deviceModel", "updateDevice", "setClickAction", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanDeviceListAdapter extends RecyclerView.Adapter<ScanDeviceViewHolder> {
    public final List<j> a;
    public Function1<? super j, Unit> b;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public ScanDeviceListAdapter() {
        this.a = new ArrayList();
        this.b = new f();
    }

    public final void y2(j r5) {
        Intrinsics.checkNotNullParameter(r5, "deviceModel");
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((j) r0.next()).a, r5.a) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L15;
        ListProtector.set(this.a, r1, r5);
        notifyItemChanged(r1);
        return;
    L15:
        return;
    L9:
        r1 = -1;
        goto L10
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ScanDeviceViewHolder r7 = (ScanDeviceViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        LarusDoraDialogScanDeviceItemBinding r8 = r7.a;
        final j r9 = (j) CollectionsKt.getOrNull(this.a, r6);
        TextView r0 = r8.b;
        Integer r1 = null;
        if (r9 == null) goto L5;
        String r2 = r9.a;
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        if (r9 == null) goto L10;
        String r3 = r9.b;
    L11:
        r0.setText(o59.a.z(r2, r3));
        if (r9 == null) goto L14;
        r1 = Integer.valueOf(r9.e);
    L14:
        if (r1 != null) goto L17;
    L19:
        if (r1 != null) goto L22;
    L24:
        if (r1 != null) goto L27;
        return;
    L27:
        if (r1.intValue() != 2) goto L32;
        e1.d(r8.a, new i());
        r8.c.setText(2131902454);
        return;
    L32:
        return;
    L22:
        if (r1.intValue() != 0) goto L24;
        e1.d(r8.a, new h(this, r9));
        r8.c.setText(2131902456);
        return;
    L17:
        if (r1.intValue() != 1) goto L19;
        e1.d(r8.a, new g());
        r8.c.setText(2131902455);
        return;
    L10:
        r3 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = e1.m(r3).inflate(2131562169, r3, false);
        int r6 = 2131368925;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r5, 2131368925);
        if (r0 == null) goto L9;
        r6 = 2131368927;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r5, 2131368927);
        if (r1 == null) goto L9;
        return new ScanDeviceViewHolder(new LarusDoraDialogScanDeviceItemBinding(r5, r0, r1));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
