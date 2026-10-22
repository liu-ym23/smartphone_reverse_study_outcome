package com.larus.dora.impl.device.manage.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.device.manage.u;
import com.larus.dora.impl.device.manage.v;
import com.skydoves.balloon.Balloon;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGDeviceManagementSwitchPopup {
    public final Context a;
    public final Function1<String, Unit> b;
    public final Function0<Unit> c;
    public Balloon d;
    public DeviceListAdapter e;
    public RecyclerView f;
    public final int g;

    public static final class DeviceListAdapter extends RecyclerView.Adapter<ViewHolder> {
        public List<String> a;
        public String b;
        public final Function1<String, Unit> c;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/device/manage/widget/DoraGDeviceManagementSwitchPopup$DeviceListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/dora/impl/device/manage/widget/DoraGDeviceManagementSwitchPopup$DeviceListAdapter;Landroid/view/View;)V", "iconDevice", "Landroid/widget/ImageView;", "textName", "Landroid/widget/TextView;", "iconCheck", "divider", "bind", "", "name", "", "isSelected", "", "isLast", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int e = 0;
            public final TextView a;
            public final ImageView b;
            public final View c;
            public final /* synthetic */ DeviceListAdapter d;

            public ViewHolder(DeviceListAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                this.d = r2;
                super(r3);
                ImageView r4 = (ImageView) r3.findViewById(2131374748);
                this.a = (TextView) r3.findViewById(2131368925);
                this.b = (ImageView) r3.findViewById(2131374735);
                this.c = r3.findViewById(2131369197);
            }
        }

        public final int getItemCount() {
            return this.a.size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
            ViewHolder r8 = (ViewHolder) r6;
            Intrinsics.checkNotNullParameter(r8, "holder");
            final String r0 = (String) ListProtector.get(this.a, r7);
            boolean r1 = Intrinsics.areEqual(r0, this.b);
            int r3 = 0;
            if (r7 != CollectionsKt.getLastIndex(this.a)) goto L5;
            boolean r9 = true;
        L6:
            r8.getClass();
            Intrinsics.checkNotNullParameter(r0, "name");
            r8.a.setText(r0);
            ImageView r2 = r8.b;
            if (r1 == false) goto L9;
            int r4 = 0;
        L10:
            r2.setVisibility(r4);
            View r5 = r8.c;
            if (r9 == false) goto L13;
            r3 = 8;
        L13:
            r5.setVisibility(r3);
            View r10 = ((RecyclerView.ViewHolder) r8).itemView;
            final DeviceListAdapter r11 = r8.d;
            r10.setOnClickListener(new h(r11, r0));
            return;
        L9:
            r4 = 8;
            goto L10
        L5:
            r9 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562560, r3, false);
            Intrinsics.checkNotNull(r5);
            return new ViewHolder(this, r5);
        }

        public DeviceListAdapter(List r2, String r3, f r4) {
            Intrinsics.checkNotNullParameter(r2, "items");
            Intrinsics.checkNotNullParameter(r3, "currentDevice");
            Intrinsics.checkNotNullParameter(r4, "onItemClick");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public DoraGDeviceManagementSwitchPopup(Context r2, u r3, v r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onDeviceSelected");
        Intrinsics.checkNotNullParameter(r4, "onAddDeviceClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.g = 5;
    }
}
