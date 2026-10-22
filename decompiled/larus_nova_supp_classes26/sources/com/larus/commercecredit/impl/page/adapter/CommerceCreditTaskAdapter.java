package com.larus.commercecredit.impl.page.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.commercecredit.impl.entity.ButtonStatus;
import com.larus.commercecredit.impl.page.i;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nz8.b;
import qz8.h;
import qz8.j;
import rz8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceCreditTaskAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/commercecredit/impl/entity/CreditTask;", "Lcom/larus/commercecredit/impl/page/adapter/CommerceCreditTaskAdapter$ViewHolder;", "config", "Lcom/larus/commercecredit/api/TraceConfig;", "mobileActivityAction", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/commercecredit/api/TraceConfig;Lkotlin/jvm/functions/Function0;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "ViewHolder", "CreditTaskDiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceCreditTaskAdapter extends ListAdapter<j, ViewHolder> {
    public final b a;
    public final Function0<Unit> b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceCreditTaskAdapter$CreditTaskDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/commercecredit/impl/entity/CreditTask;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreditTaskDiffCallback extends DiffUtil.ItemCallback<j> {
        public CreditTaskDiffCallback() {
        }

        public final boolean areContentsTheSame(Object r3, Object r4) {
            j r5 = (j) r3;
            j r6 = (j) r4;
            Intrinsics.checkNotNullParameter(r5, "oldItem");
            Intrinsics.checkNotNullParameter(r6, "newItem");
            if (Intrinsics.areEqual(r5.g(), r6.g()) == true) goto L5;
        L17:
            return false;
        L5:
            if (Intrinsics.areEqual(r5.f(), r6.f()) == false) goto L17;
            if (Intrinsics.areEqual(r5.d(), r6.d()) == false) goto L17;
            if (Intrinsics.areEqual(r5.h(), r6.h()) == false) goto L17;
            if (Intrinsics.areEqual(r5.e(), r6.e()) == false) goto L17;
            if (Intrinsics.areEqual(r5.c(), r6.c()) == false) goto L17;
            if (Intrinsics.areEqual(r5.b(), r6.b()) == false) goto L17;
            return true;
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            j r4 = (j) r2;
            j r5 = (j) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            if (r4.g() != null) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r4.g(), r5.g()) == false) goto L7;
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceCreditTaskAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "creditTaskIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCreditTaskIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "description", "getDescription", "doTaskAction", "getDoTaskAction", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131376160);
            this.b = (TextView) r2.findViewById(2131390464);
            this.c = (TextView) r2.findViewById(2131390463);
            this.d = (TextView) r2.findViewById(2131390523);
        }
    }

    public CommerceCreditTaskAdapter(b r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "mobileActivityAction");
        super(new CreditTaskDiffCallback());
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        final ViewHolder r6 = (ViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        final j r7 = (j) getItem(r5);
        TextView r0 = r6.b;
        String r1 = r7.h();
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0.setText(r1);
        TextView r3 = r6.c;
        String r8 = r7.e();
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r3.setText(r8);
        TextView r9 = r6.d;
        String r10 = r7.c();
        if (r10 == null) goto L13;
        r2 = r10;
    L13:
        r9.setText(r2);
        ImageLoaderKt.u(r6.a, h.a(r7.f(), r7.d()), "commerce_credit_task");
        Integer r11 = r7.b();
        int r12 = ButtonStatus.BUTTON_STATUS_UNFINISHED.getStatus();
        if (r11 != null) goto L17;
    L18:
        int r13 = ButtonStatus.BUTTON_STATUS_ONGOING.getStatus();
        if (r11 != null) goto L22;
    L24:
        int r14 = ButtonStatus.BUTTON_STATUS_FINISHED.getStatus();
        if (r11 != null) goto L28;
    L31:
        e1.d(r6.d, new a(r7, this, r6));
        return;
    L28:
        if (r11.intValue() != r14) goto L31;
        r6.d.setBackgroundResource(2131238794);
        r6.d.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r6).itemView.getContext(), 2131103143));
        goto L31
    L22:
        if (r11.intValue() != r13) goto L24;
    L30:
        r6.d.setBackgroundResource(2131238793);
        r6.d.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r6).itemView.getContext(), 2131103298));
        goto L31
    L17:
        if (r11.intValue() == r12) goto L30;
        goto L18
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562518, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ViewHolder(r5);
    }
}
