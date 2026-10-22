package com.larus.bmhome.chat.nestedmenu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusItemOfficeTaskDeviceSwitchBinding;
import di8.d0;
import di8.f0;
import di8.p0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class OfficeTaskAdapter extends ListAdapter<w, TaskViewHolder> {
    public static final OfficeTaskAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final Function1<w, Unit> a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusItemOfficeTaskDeviceSwitchBinding;", "<init>", "(Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskAdapter;Lcom/larus/mainbot/impl/databinding/LarusItemOfficeTaskDeviceSwitchBinding;)V", "bind", "", "item", "Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskItem;", "showDivider", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class TaskViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusItemOfficeTaskDeviceSwitchBinding a;
        public final /* synthetic */ OfficeTaskAdapter b;

        public TaskViewHolder(OfficeTaskAdapter r2, LarusItemOfficeTaskDeviceSwitchBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.nestedmenu.ui.OfficeTaskAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new OfficeTaskAdapter$Companion$DIFF_CALLBACK$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeTaskAdapter(Function1<? super w, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        super(b);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        TaskViewHolder r14 = (TaskViewHolder) r12;
        Intrinsics.checkNotNullParameter(r14, "holder");
        final w r0 = (w) getItem(r13);
        int r3 = 0;
        if (r13 == (getItemCount() - 1)) goto L5;
        boolean r15 = true;
    L6:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        Context r1 = r14.a.a.getContext();
        TextView r4 = r14.a.f;
        d0 r5 = r0.b();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        f0 r6 = r5.c();
        String r8 = null;
        if ((r6 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L10;
        com.larus.bmhome.chat.nestedmenu.b r7 = (com.larus.bmhome.chat.nestedmenu.b) r6;
    L15:
        String r9 = "";
        if (r7 == null) goto L29;
        com.larus.bmhome.chat.nestedmenu.b.a r10 = r7.c;
        if (r10 == null) goto L29;
        t0 r11 = r10.a;
        if (r11 == null) goto L29;
        String r16 = r11.b;
        if (r16 == null) goto L29;
        if ((!StringsKt.isBlank(r16)) == true) goto L27;
        r16 = null;
    L27:
        if (r16 == null) goto L29;
    L44:
        r4.setText(r16);
        LarusItemOfficeTaskDeviceSwitchBinding r17 = r14.a;
        TextView r18 = r17.d;
        if ((r0 instanceof w.b) == false) goto L59;
        r17.c.setImageResource(2131241515);
        w.b r2 = (w.b) r0;
        String r19 = r2.c().d();
        if (r19 != null) goto L49;
    L54:
        String r20 = r2.c().getDeviceId();
        if (r20 == null) goto L61;
        r9 = r20;
    L61:
        r18.setText(r9);
        View r21 = r14.a.b;
        if (r15 == true) goto L65;
        r3 = 8;
    L65:
        r21.setVisibility(r3);
        ConstraintLayout r110 = r14.a.a;
        final OfficeTaskAdapter r111 = r14.b;
        r110.setOnClickListener(new r(r111, r0));
        return;
    L49:
        if ((true ^ StringsKt.isBlank(r19)) == false) goto L51;
        r8 = r19;
    L51:
        if (r8 == null) goto L54;
        r9 = r8;
        goto L61
    L59:
        if ((r0 instanceof w.a) == false) goto L68;
        r17.c.setImageResource(2131241905);
        r9 = r1.getString(2131908244);
        Intrinsics.checkNotNull(r9);
        goto L61
    L68:
        throw new NoWhenBranchMatchedException();
    L29:
        if (r7 == null) goto L39;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r22 = r7.a;
        if (r22 == null) goto L39;
        b2 r23 = r22.a;
        if (r23 == null) goto L39;
        String r24 = r23.b;
        if (r24 == null) goto L39;
        if ((!StringsKt.isBlank(r24)) == false) goto L39;
        r16 = r24;
    L40:
        if (r16 != null) goto L44;
        r16 = r5.getCenter().a;
        if (r16 != null) goto L44;
        r16 = "";
    L39:
        r16 = null;
        goto L40
    L10:
        if ((r6 instanceof p0) == false) goto L14;
        f0 r25 = ((p0) r6).a;
        if ((r25 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L14;
        r7 = (com.larus.bmhome.chat.nestedmenu.b) r25;
    L14:
        r7 = null;
        goto L15
    L5:
        r15 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r11 = LayoutInflater.from(r9.getContext()).inflate(2131562602, r9, false);
        int r0 = 2131381389;
        View r3 = ViewBindings.findChildViewById(r11, 2131381389);
        if (r3 == null) goto L15;
        r0 = 2131381390;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r11, 2131381390);
        if (r4 == null) goto L15;
        r0 = 2131381391;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131381391);
        if (r5 == null) goto L15;
        r0 = 2131381392;
        View r6 = ViewBindings.findChildViewById(r11, 2131381392);
        if (r6 == null) goto L15;
        r0 = 2131381396;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, 2131381396);
        if (r7 == null) goto L15;
        return new TaskViewHolder(this, new LarusItemOfficeTaskDeviceSwitchBinding(r11, r3, r4, r5, r6, r7));
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
