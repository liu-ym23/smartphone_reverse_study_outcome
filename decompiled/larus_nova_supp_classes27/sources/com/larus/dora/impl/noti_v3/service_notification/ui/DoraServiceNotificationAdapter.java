package com.larus.dora.impl.noti_v3.service_notification.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraItemServiceNotificationBinding;
import com.larus.dora.impl.view.DoraTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s59.a;
import t59.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/noti_v3/service_notification/ui/DoraServiceNotificationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/noti_v3/service_notification/ui/DoraServiceNotificationAdapter$ViewHolder;", "onItemSelected", "Lkotlin/Function1;", "Lcom/larus/dora/impl/noti_v3/service_notification/model/DoraServiceNotificationItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "setData", "newItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraServiceNotificationAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Function1<a, Unit> a;
    public List<a> b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/noti_v3/service_notification/ui/DoraServiceNotificationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemServiceNotificationBinding;", "<init>", "(Lcom/larus/dora/impl/noti_v3/service_notification/ui/DoraServiceNotificationAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemServiceNotificationBinding;)V", "bind", "", "item", "Lcom/larus/dora/impl/noti_v3/service_notification/model/DoraServiceNotificationItem;", "isLast", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusDoraItemServiceNotificationBinding a;
        public final /* synthetic */ DoraServiceNotificationAdapter b;

        public ViewHolder(DoraServiceNotificationAdapter r2, LarusDoraItemServiceNotificationBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public DoraServiceNotificationAdapter(e r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemSelected");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        final ViewHolder r7 = (ViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        final a r0 = (a) ListProtector.get(this.b, r6);
        boolean r2 = true;
        int r3 = 0;
        if (r6 == (this.b.size() - 1)) goto L6;
        r2 = false;
    L6:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        r7.a.f.setText(r0.b);
        r7.a.e.setText(r0.c);
        r7.a.c.setImageResource(r0.d);
        if (r0.e == false) goto L9;
        int r8 = 2131240385;
    L10:
        r7.a.d.setImageResource(r8);
        View r9 = r7.a.b;
        if (r2 == false) goto L13;
        r3 = 8;
    L13:
        r9.setVisibility(r3);
        ConstraintLayout r10 = r7.a.a;
        final DoraServiceNotificationAdapter r1 = r7.b;
        r10.setOnClickListener(new t59.a(r0, r7, r1));
        return;
    L9:
        r8 = 2131240384;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        ConstraintLayout r10 = LayoutInflater.from(r8.getContext()).inflate(2131562221, r8, false);
        int r11 = 2131369746;
        View r2 = ViewBindings.findChildViewById(r10, 2131369746);
        if (r2 == null) goto L15;
        r11 = 2131369747;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r10, 2131369747);
        if (r3 == null) goto L15;
        r11 = 2131369748;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r10, 2131369748);
        if (r4 == null) goto L15;
        r11 = 2131369749;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369749);
        if (r5 == null) goto L15;
        r11 = 2131369750;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369750);
        if (r6 == null) goto L15;
        return new ViewHolder(this, new LarusDoraItemServiceNotificationBinding(r10, r2, r3, r4, r5, r6));
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
