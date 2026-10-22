package com.larus.common.account.bdauth.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.bdauth.impl.databinding.LarusItemAuthAccountBinding;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.view.o;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/common/account/bdauth/ui/BDAuthorizeAccountAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onAccountClick", "Lkotlin/Function1;", "", "", "onAddAccountClick", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "items", "", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeListItemUiModel;", "submitList", "newItems", "", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "AccountViewHolder", "SingleAccountViewHolder", "AddAccountViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BDAuthorizeAccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int d = 0;
    public final Function1<String, Unit> a;
    public final Function0<Unit> b;
    public final List<com.larus.common.account.bdauth.viewmodel.c> c;

    public static final class a extends RecyclerView.ViewHolder {
        public final LarusItemAuthAccountBinding a;

        public a(LarusItemAuthAccountBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final LarusItemAuthAccountBinding a;

        public b(LarusItemAuthAccountBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class c {
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final LarusItemAuthAccountBinding a;

        public d(LarusItemAuthAccountBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final int getItemViewType(int r2) {
        com.larus.common.account.bdauth.viewmodel.c r3 = (com.larus.common.account.bdauth.viewmodel.c) ListProtector.get(this.c, r2);
        if ((r3 instanceof com.larus.common.account.bdauth.viewmodel.c.C0008c) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof com.larus.common.account.bdauth.viewmodel.c.a) == false) goto L9;
        return 0;
    L9:
        if ((r3 instanceof com.larus.common.account.bdauth.viewmodel.c.b) == false) goto L13;
        return 2;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public BDAuthorizeAccountAdapter(o r2, com.larus.nova.view.b r3) {
        Intrinsics.checkNotNullParameter(r2, "onAccountClick");
        Intrinsics.checkNotNullParameter(r3, "onAddAccountClick");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        final com.larus.common.account.bdauth.viewmodel.c r12 = (com.larus.common.account.bdauth.viewmodel.c) ListProtector.get(this.c, r11);
        String r5 = null;
        if ((r12 instanceof com.larus.common.account.bdauth.viewmodel.c.a) == false) goto L23;
        a r13 = (a) r10;
        com.larus.common.account.bdauth.viewmodel.a r0 = ((com.larus.common.account.bdauth.viewmodel.c.a) r12).a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        TextView r6 = r13.a.e;
        String r7 = r0.c;
        if ((!StringsKt.isBlank(r7)) == false) goto L7;
        r5 = r7;
    L7:
        if (r5 != null) goto L10;
        r5 = r13.a.a.getContext().getString(2131910908);
    L10:
        r6.setText(r5);
        RoundAvatarImageView.f(r13.a.b, r0.e, "settings.multi_account", false, 12);
        int r2 = 2131240881;
        if (r0.h == false) goto L17;
        TextView r1 = r13.a.d;
        String r3 = r0.d;
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        r1.setText(r3);
        TextView r4 = r13.a.e;
        ConstraintLayout.LayoutParams r8 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r9 = r8;
        r9.startToEnd = r13.a.b.getId();
        r9.topToTop = r13.a.b.getId();
        r9.bottomToTop = r13.a.d.getId();
        r4.setLayoutParams(r9);
        r13.a.b.setAlpha(0.3f);
        r13.a.e.setAlpha(0.3f);
        r13.a.d.setAlpha(0.3f);
        r13.a.c.setImageResource(2131240881);
        e1.q(r13.a.c);
        e1.x(r13.a.d);
    L21:
        e1.d(((RecyclerView.ViewHolder) r13).itemView, new wz8.a(this, r12));
        e1.d(r13.a.c, new wz8.b(this, r12));
        return;
    L17:
        TextView r14 = r13.a.e;
        ConstraintLayout.LayoutParams r15 = r14.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r16 = r15;
        r16.startToEnd = r13.a.b.getId();
        r16.topToTop = r13.a.b.getId();
        r16.bottomToBottom = r13.a.b.getId();
        r14.setLayoutParams(r16);
        r13.a.b.setAlpha(1.0f);
        r13.a.e.setAlpha(1.0f);
        r13.a.d.setAlpha(1.0f);
        ImageView r17 = r13.a.c;
        if (r0.g == false) goto L20;
        r2 = 2131240880;
    L20:
        r17.setImageResource(r2);
        e1.x(r13.a.c);
        e1.o(r13.a.d);
        goto L21
    L23:
        if ((r12 instanceof com.larus.common.account.bdauth.viewmodel.c.C0008c) == false) goto L32;
        d r18 = (d) r10;
        com.larus.common.account.bdauth.viewmodel.a r110 = ((com.larus.common.account.bdauth.viewmodel.c.C0008c) r12).a;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r110, "item");
        TextView r20 = r18.a.e;
        String r21 = r110.c;
        if ((!StringsKt.isBlank(r21)) == false) goto L27;
        r5 = r21;
    L27:
        if (r5 != null) goto L30;
        r5 = r18.a.a.getContext().getString(2131910908);
    L30:
        r20.setText(r5);
        RoundAvatarImageView.f(r18.a.b, r110.e, "settings.multi_account", false, 12);
        e1.o(r18.a.c);
        e1.o(r18.a.d);
        return;
    L32:
        if ((r12 instanceof com.larus.common.account.bdauth.viewmodel.c.b) == false) goto L36;
        b r111 = (b) r10;
        LarusItemAuthAccountBinding r22 = r111.a;
        r22.e.setText(r22.a.getContext().getString(2131910226));
        r111.a.b.setImageResource(2131240879);
        e1.o(r111.a.c);
        e1.d(((RecyclerView.ViewHolder) r111).itemView, new wz8.c(r12, this));
        return;
    L36:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        LayoutInflater r0 = LayoutInflater.from(r3.getContext());
        if (r4 == 0) goto L9;
        if (r4 == 1) goto L11;
        return new b(LarusItemAuthAccountBinding.a(r0, r3));
    L11:
        return new d(LarusItemAuthAccountBinding.a(r0, r3));
    L9:
        return new a(LarusItemAuthAccountBinding.a(r0, r3));
    }
}
