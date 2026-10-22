package com.bytedance.android.live.search.impl.search.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.d7;
import com.bytedance.android.livesdk.config.lb;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.util.KotlinExtsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchUserViewHolder;", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchUserAdapter extends RecyclerView.Adapter<LiveSearchUserViewHolder> {
    public List<User> a;
    public Function3<? super User, ? super LiveSearchUserViewHolder, ? super Boolean, Unit> b;
    public boolean c;
    public boolean d;
    public final String e;
    public Function1<? super User, Boolean> f;

    public final int getItemCount() {
        return this.a.size();
    }

    public LiveSearchUserAdapter() {
        this.a = new ArrayList();
        this.b = LiveSearchUserAdapter$itemClickListener$1.INSTANCE;
        this.d = true;
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L10;
        f r1 = r0.user();
        if (r1 == null) goto L10;
        IUser r2 = r1.b();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
        if (r3 == null) goto L10;
    L11:
        this.e = r3;
        this.f = LiveSearchUserAdapter$isUserSelectedByInput$1.INSTANCE;
        return;
    L10:
        r3 = DataType.FALSE;
        goto L11
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        LiveSearchUserViewHolder r8 = (LiveSearchUserViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        ((ConstraintLayout) r8.a.getValue()).setBackgroundColor(-1);
        r8.T3().setBackground(s1.m(2131253004));
        User r9 = (User) ListProtector.get(this.a, r7);
        ImageUtil.loadRoundImage((HSImageView) r8.b.getValue(), r9._avatarMedium);
        ((TextView) r8.c.getValue()).setText(r9.getNickName());
        boolean r0 = ((Boolean) this.f.invoke(r9)).booleanValue();
        r8.T3().setSelected(r0);
        int r1 = d7.a;
        if (((Boolean) lb.a.getValue()).booleanValue() == false) goto L5;
        boolean r2 = this.d;
        r8.T3().setEnabled(r2);
    L5:
        Ref.BooleanRef r3 = new Ref.BooleanRef();
        r3.element = false;
        if (Intrinsics.areEqual(this.e, r9.getIdStr()) == true) goto L8;
    L10:
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new a(this, r3, r8, r9));
        if (KotlinExtsKt.isStranger(r9) == false) goto L13;
        UtilityKotlinExtentionsKt.t((TextView) r8.d.getValue());
    L25:
        if (r9.getDisplayId() != null) goto L27;
    L36:
        UtilityKotlinExtentionsKt.t((TextView) r8.e.getValue());
        return;
    L27:
        if (r9.getDisplayId().length() != 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == true) goto L36;
        UtilityKotlinExtentionsKt.w((TextView) r8.e.getValue());
        TextView r10 = (TextView) r8.e.getValue();
        Object[] r5 = new Object[1];
        String r12 = r9.getDisplayId();
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        r5[0] = r12;
        r10.setText(s1.C(2131922395, r5));
        return;
    L29:
        r4 = false;
        goto L30
    L13:
        UtilityKotlinExtentionsKt.w((TextView) r8.d.getValue());
        TextView r13 = (TextView) r8.d.getValue();
        if (KotlinExtsKt.isFriend(r9) == false) goto L17;
        int r14 = 2131922394;
    L23:
        r13.setText(r14);
        goto L25
    L17:
        if (KotlinExtsKt.isFollower(r9) == false) goto L20;
        r14 = 2131922392;
        goto L23
    L20:
        if (KotlinExtsKt.isFollowingButNotFriend(r9) == false) goto L22;
        r14 = 2131922393;
        goto L23
    L22:
        r14 = 2131922371;
        goto L23
    L8:
        if (this.c == false) goto L10;
        r3.element = true;
        ((ConstraintLayout) r8.a.getValue()).setBackgroundColor(-460552);
        r8.T3().setSelected(true);
        r8.T3().setBackground(s1.m(2131251869));
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LiveSearchUserViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566801, r4, false));
    }
}
