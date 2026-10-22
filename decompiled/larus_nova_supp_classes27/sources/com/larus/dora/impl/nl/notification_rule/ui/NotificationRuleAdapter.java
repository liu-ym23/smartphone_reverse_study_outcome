package com.larus.dora.impl.nl.notification_rule.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.databinding.LarusDoraItemNotificationRuleSwipeBinding;
import com.larus.utils.e1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B]\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00062\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter$ViewHolder;", "onRuleClick", "Lkotlin/Function1;", "Lcom/larus/dora/api/entity/NotificationRule;", "", "onEditClick", "onDeleteClick", "onLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "openedSwipeLayout", "Ljava/lang/ref/WeakReference;", "Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout;", "updateData", "newItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getItem", "closeAllSwipedMenus", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationRuleAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Function1<NotificationRule, Unit> a;
    public final Function1<NotificationRule, Unit> b;
    public final Function1<NotificationRule, Unit> c;
    public final Function2<View, NotificationRule, Unit> d;
    public final List<NotificationRule> e;
    public WeakReference<SwipeLayout> f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemNotificationRuleSwipeBinding;", "<init>", "(Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemNotificationRuleSwipeBinding;)V", "bind", "", "item", "Lcom/larus/dora/api/entity/NotificationRule;", "isLast", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusDoraItemNotificationRuleSwipeBinding a;
        public final /* synthetic */ NotificationRuleAdapter b;

        public ViewHolder(NotificationRuleAdapter r2, LarusDoraItemNotificationRuleSwipeBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.e).size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ViewHolder r8 = (ViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final NotificationRule r0 = (NotificationRule) ListProtector.get(this.e, r7);
        boolean r2 = true;
        int r3 = 0;
        if (r7 == (((ArrayList) this.e).size() - 1)) goto L6;
        r2 = false;
    L6:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        final LarusDoraItemNotificationRuleSwipeBinding r9 = r8.a;
        final NotificationRuleAdapter r10 = r8.b;
        TextView r1 = r9.f;
        String r4 = r0.getRuleDesc();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r1.setText(r4);
        ImageView r5 = r9.g;
        Boolean r11 = r0.getStatus();
        if (r11 == null) goto L13;
        boolean r12 = r11.booleanValue();
    L14:
        r5.setSelected(r12);
        View r13 = r9.e;
        if (r2 == false) goto L17;
        r3 = 8;
    L17:
        r13.setVisibility(r3);
        SwipeLayout r14 = r9.a;
        if ((r14 instanceof SwipeLayout) == true) goto L21;
        r14 = null;
    L21:
        if (r14 == null) goto L23;
        r14.setOnSwipeListener(new f0(r10));
    L23:
        e1.d(r9.g, new b0(r10, r0));
        r9.d.setOnLongClickListener(new c0(r10, r0));
        e1.d(r9.c, new d0(r10, r0, r9));
        e1.d(r9.b, new e0(r10, r0, r9));
        return;
    L13:
        r12 = false;
        goto L14
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        View r12 = LayoutInflater.from(r10.getContext()).inflate(2131562218, r10, false);
        int r13 = 2131364702;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131364702);
        if (r3 == null) goto L17;
        r13 = 2131364716;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131364716);
        if (r4 == null) goto L17;
        r13 = 2131367833;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r12, 2131367833);
        if (r5 == null) goto L17;
        r13 = 2131369197;
        View r6 = ViewBindings.findChildViewById(r12, 2131369197);
        if (r6 == null) goto L17;
        r13 = 2131384891;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131384891);
        if (r7 == null) goto L17;
        r13 = 2131384892;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r12, 2131384892);
        if (r8 == null) goto L17;
        return new ViewHolder(this, new LarusDoraItemNotificationRuleSwipeBinding((SwipeLayout) r12, r3, r4, r5, r6, r7, r8));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }

    public NotificationRuleAdapter(n r2, p r3, q r4, r r5) {
        Intrinsics.checkNotNullParameter(r2, "onRuleClick");
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
