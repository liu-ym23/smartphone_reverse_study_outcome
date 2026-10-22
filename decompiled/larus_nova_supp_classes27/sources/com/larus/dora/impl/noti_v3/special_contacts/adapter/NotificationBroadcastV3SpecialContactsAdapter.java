package com.larus.dora.impl.noti_v3.special_contacts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraItemNotiV3SpecialContactSwipeBinding;
import com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout;
import com.larus.dora.impl.noti_v3.special_contacts.ui.e;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w59.b;
import w59.c;
import w59.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B]\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u0016\u001a\u00020\u0006J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00062\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter$ViewHolder;", "onContactClick", "Lkotlin/Function1;", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "", "onEditClick", "onDeleteClick", "onLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "openedSwipeLayout", "Ljava/lang/ref/WeakReference;", "Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout;", "updateData", "newItems", "", "closeAllSwipedMenus", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SpecialContactsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Function1<y59.a, Unit> a;
    public final Function1<y59.a, Unit> b;
    public final Function1<y59.a, Unit> c;
    public final Function2<View, y59.a, Unit> d;
    public final List<y59.a> e;
    public WeakReference<SwipeLayout> f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemNotiV3SpecialContactSwipeBinding;", "<init>", "(Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemNotiV3SpecialContactSwipeBinding;)V", "bind", "", "item", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "isLast", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusDoraItemNotiV3SpecialContactSwipeBinding a;
        public final /* synthetic */ NotificationBroadcastV3SpecialContactsAdapter b;

        public ViewHolder(NotificationBroadcastV3SpecialContactsAdapter r2, LarusDoraItemNotiV3SpecialContactSwipeBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.e).size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        ViewHolder r9 = (ViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final y59.a r0 = (y59.a) ListProtector.get(this.e, r8);
        boolean r2 = true;
        int r3 = 0;
        if (r8 == (((ArrayList) this.e).size() - 1)) goto L6;
        r2 = false;
    L6:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        final LarusDoraItemNotiV3SpecialContactSwipeBinding r10 = r9.a;
        final NotificationBroadcastV3SpecialContactsAdapter r11 = r9.b;
        AppCompatTextView r1 = r10.h;
        CharSequence r4 = r0.c();
        CharSequence r5 = "";
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r1.setText(r4);
        AppCompatTextView r6 = r10.g;
        CharSequence r12 = r0.b();
        if (r12 == null) goto L13;
        r5 = r12;
    L13:
        r6.setText(r5);
        ImageView r13 = r10.f;
        Boolean r14 = r0.e();
        if (r14 == null) goto L16;
        boolean r15 = r14.booleanValue();
    L17:
        r13.setSelected(r15);
        View r16 = r10.e;
        if (r2 == false) goto L20;
        r3 = 8;
    L20:
        r16.setVisibility(r3);
        SwipeLayout r17 = r10.a;
        if ((r17 instanceof SwipeLayout) == true) goto L24;
        r17 = null;
    L24:
        if (r17 == null) goto L26;
        r17.setOnSwipeListener(new a(r11));
    L26:
        e1.d(r10.f, new w59.a(r11, r0));
        r10.d.setOnLongClickListener(new b(r11, r0));
        e1.d(r10.c, new c(r11, r0, r10));
        e1.d(r10.b, new d(r11, r0, r10));
        return;
    L16:
        r15 = false;
        goto L17
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        View r13 = LayoutInflater.from(r11.getContext()).inflate(2131562215, r11, false);
        int r14 = 2131364702;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131364702);
        if (r3 == null) goto L19;
        r14 = 2131364716;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131364716);
        if (r4 == null) goto L19;
        r14 = 2131367833;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r13, 2131367833);
        if (r5 == null) goto L19;
        r14 = 2131369197;
        View r6 = ViewBindings.findChildViewById(r13, 2131369197);
        if (r6 == null) goto L19;
        r14 = 2131376597;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, 2131376597);
        if (r7 == null) goto L19;
        r14 = 2131390156;
        DoraTextView r8 = (DoraTextView) ViewBindings.findChildViewById(r13, 2131390156);
        if (r8 == null) goto L19;
        r14 = 2131390389;
        DoraTextView r9 = (DoraTextView) ViewBindings.findChildViewById(r13, 2131390389);
        if (r9 == null) goto L19;
        return new ViewHolder(this, new LarusDoraItemNotiV3SpecialContactSwipeBinding((SwipeLayout) r13, r3, r4, r5, r6, r7, r8, r9));
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }

    public NotificationBroadcastV3SpecialContactsAdapter(com.larus.dora.impl.noti_v3.special_contacts.ui.b r2, com.larus.dora.impl.noti_v3.special_contacts.ui.c r3, com.larus.dora.impl.noti_v3.special_contacts.ui.d r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "onContactClick");
        Intrinsics.checkNotNullParameter(r3, "onEditClick");
        Intrinsics.checkNotNullParameter(r4, "onDeleteClick");
        Intrinsics.checkNotNullParameter(r5, "onLongClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new ArrayList();
    }
}
