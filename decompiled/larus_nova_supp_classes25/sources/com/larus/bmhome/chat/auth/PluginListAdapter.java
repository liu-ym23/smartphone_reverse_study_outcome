package com.larus.bmhome.chat.auth;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusLayoutViewPluginHintBinding;
import com.larus.bmhome.databinding.LarusLayoutViewPluginItemBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B,\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0005R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "Lcom/larus/bmhome/chat/auth/PluginHolder;", "getDrawable", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "res", "Landroid/graphics/drawable/Drawable;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "setOnItemClickListener", "listener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PluginListAdapter extends ListAdapter<PluginItem, PluginHolder> {
    public static final PluginListAdapter$Companion$DIFFER$1 c = null;
    public final Function1<Integer, Drawable> a;
    public Function1<? super PluginItem, Unit> b;

    public static final class a {
    }

    public final int getItemViewType(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.auth.PluginListAdapter$Companion$DIFFER$1] */
    static {
        c = new PluginListAdapter$Companion$DIFFER$1();
    }

    public PluginListAdapter(c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "getDrawable");
        super(c);
        this.a = r2;
        this.b = new w();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        PluginHolder r0 = (PluginHolder) r7;
        Intrinsics.checkNotNullParameter(r0, "holder");
        List r9 = getCurrentList();
        if (r8 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        Object r10 = ListProtector.get(r9, r8);
    L11:
        PluginItem r2 = (PluginItem) r10;
        if (r2 == null) goto L15;
        r0.T3(r2, r8, getCurrentList().size(), this.a, this.b);
        return;
    L15:
        return;
    L10:
        r10 = null;
        goto L11
    L5:
        if (r8 >= r9.size()) goto L7;
        r1 = true;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        if (r13 != 0) goto L9;
        View r14 = LayoutInflater.from(r12.getContext()).inflate(2131562915, r12, false);
        if (r14 == null) goto L8;
        RecyclerView.ViewHolder r15 = new PluginItemHintHolder(new LarusLayoutViewPluginHintBinding((TextView) r14));
    L26:
        return r15;
    L8:
        throw new NullPointerException("rootView");
    L9:
        ConstraintLayout r16 = LayoutInflater.from(r12.getContext()).inflate(2131562916, r12, false);
        int r0 = 2131363544;
        if (((ImageView) ViewBindings.findChildViewById(r16, 2131363544)) == null) goto L28;
        r0 = 2131363556;
        if (ViewBindings.findChildViewById(r16, 2131363556) == null) goto L28;
        r0 = 2131363567;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r16, 2131363567);
        if (r4 == null) goto L28;
        r0 = 2131363576;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r16, 2131363576);
        if (r5 == null) goto L28;
        ConstraintLayout r6 = r16;
        r0 = 2131368819;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r16, 2131368819);
        if (r7 == null) goto L28;
        r0 = 2131369197;
        View r8 = ViewBindings.findChildViewById(r16, 2131369197);
        if (r8 == null) goto L28;
        r0 = 2131374718;
        SimpleDraweeView r9 = ViewBindings.findChildViewById(r16, 2131374718);
        if (r9 == null) goto L28;
        r0 = 2131380593;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131380593);
        if (r10 == null) goto L28;
        r15 = new PluginItemContentHolder(new LarusLayoutViewPluginItemBinding(r6, r4, r5, r6, r7, r8, r9, r10));
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r0)));
    }
}
