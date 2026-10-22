package com.larus.setting.impl.iconchanger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.setting.impl.databinding.LarusItemAdjustAppIconBinding;
import com.larus.setting.impl.databinding.LarusItemAppIconBinding;
import com.larus.utils.e1;
import com.larus.utils.m0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B,\u0012#\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0018H\u0016R.\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/setting/impl/iconchanger/ChangeAppIconAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/setting/impl/iconchanger/AppIconViewHolder;", "onClickItem", "Lkotlin/Function1;", "Lcom/larus/setting/impl/iconchanger/ChangeAppIconData;", "Lkotlin/ParameterName;", "name", "changeAppIconData", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClickItem", "()Lkotlin/jvm/functions/Function1;", "renderAppIconList", "", "getRenderAppIconList", "()Ljava/util/List;", "setRenderAppIconList", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "reSizeItemView", "binding", "Landroid/view/View;", "itemSize", "getItemCount", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ChangeAppIconAdapter extends RecyclerView.Adapter<AppIconViewHolder> {
    public final Function1<b, Unit> a;
    public List<b> b;

    public final int getItemCount() {
        List<b> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public ChangeAppIconAdapter(i r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickItem");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        final AppIconViewHolder r15 = (AppIconViewHolder) r13;
        Intrinsics.checkNotNullParameter(r15, "holder");
        List<b> r0 = this.b;
        Integer r1 = null;
        if (r0 == null) goto L5;
        final b r16 = (b) CollectionsKt.getOrNull(r0, r14);
    L6:
        r15.d.setColor(2131103203);
        r15.d.setStrokeWidth(c7.b(6));
        if (r16 != null) goto L10;
        return;
    L10:
        if (r16.c == false) goto L14;
        CircleRingView r2 = r15.d;
        if (r2 == null) goto L17;
        e1.x(r2);
    L17:
        boolean r3 = true;
        if (AppHost.a.isOversea() == true) goto L41;
        Integer r4 = r16.g;
        if (r4 != null) goto L23;
    L29:
        Integer r5 = r16.g;
        if (r5 != null) goto L33;
    L39:
        if (r1 == null) goto L41;
        r15.a.setContentDescription(((RecyclerView.ViewHolder) r15).itemView.getContext().getString(r1.intValue()));
        goto L41
    L33:
        if (r5.intValue() != 3) goto L39;
        if (r16.c == false) goto L37;
        int r6 = 2131898787;
    L38:
        r1 = Integer.valueOf(r6);
        goto L39
    L37:
        r6 = 2131898788;
        goto L38
    L23:
        if (r4.intValue() != 1) goto L29;
        if (r16.c == false) goto L27;
        int r7 = 2131898789;
    L28:
        r1 = Integer.valueOf(r7);
        goto L39
    L27:
        r7 = 2131898790;
    L41:
        e1.d(((RecyclerView.ViewHolder) r15).itemView.getRootView(), new a(r15, r16));
        if (r16.d == false) goto L53;
        e1.o(r15.f);
        if (r15.e.getVisibility() == 0) goto L47;
        r3 = false;
    L47:
        if (r3 == true) goto L50;
        e1.x(r15.e);
    L50:
        if (Intrinsics.areEqual(r15.c, r16.i.c()) == true) goto L60;
        r15.c = r16.i.c();
        CircleSimpleDraweeView.f(r15.e, b0.a(r16.i.c(), "change_app_icon", false, false, 6), null, null, 0, 0, 62);
        return;
    L60:
        return;
    L53:
        e1.o(r15.e);
        e1.x(r15.f);
        if (Intrinsics.areEqual(r15.c, r16.i.e()) == true) goto L61;
        r15.c = r16.i.e();
        ImageLoaderKt.u(r15.f, r16.i.e(), "change_app_icon");
        return;
    L61:
        return;
    L14:
        CircleRingView r8 = r15.d;
        if (r8 == null) goto L17;
        e1.q(r8);
        goto L17
    L5:
        r16 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        List<b> r14 = this.b;
        if (r14 == null) goto L5;
        b r15 = (b) CollectionsKt.getOrNull(r14, 0);
    L6:
        if (r15 == null) goto L10;
        boolean r3 = true;
        if (r15.a != true) goto L10;
    L11:
        if (r15 == null) goto L13;
        int r16 = r15.b;
    L14:
        int r2 = 2131387273;
        if (r3 == false) goto L33;
        View r0 = LayoutInflater.from(r12.getContext()).inflate(2131562489, null, false);
        View r1 = ViewBindings.findChildViewById(r0, 2131363082);
        if (r1 != null) goto L19;
        r2 = 2131363082;
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    L19:
        if (ViewBindings.findChildViewById(r0, 2131370468) == null) goto L29;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131377334);
        if (r9 == null) goto L28;
        FrameLayout r8 = (FrameLayout) r0;
        if (((CircleRingView) ViewBindings.findChildViewById(r0, 2131385764)) != null) goto L25;
        r2 = 2131385764;
        goto L32
    L25:
        if (ViewBindings.findChildViewById(r0, 2131387273) == null) goto L32;
        ViewBinding r4 = new LarusItemAdjustAppIconBinding(r8, r1, r9, r8);
    L42:
        View r5 = r4.getRoot();
        if (r3 == false) goto L45;
        View r17 = r4.getRoot();
        CircleRingView r6 = (CircleRingView) r17.findViewById(2131385764);
        CircleSimpleDraweeView r7 = r17.findViewById(2131370468);
        SimpleDraweeView r10 = r17.findViewById(2131387273);
        View r18 = r17.findViewById(2131363082);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(r16 - c7.b(20), r16 - c7.b(20));
        r11.gravity = 17;
        r7.setLayoutParams(r11);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(r16 - c7.b(20), r16 - c7.b(20));
        r19.gravity = 17;
        r18.setLayoutParams(r19);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(r16 - c7.b(20), r16 - c7.b(20));
        r110.gravity = 17;
        r10.setLayoutParams(r110);
        ViewGroup.LayoutParams r111 = new ViewGroup.LayoutParams(-1, r16);
    L46:
        r5.setLayoutParams(r111);
        return new AppIconViewHolder(r4.getRoot(), this.a);
    L45:
        int r20 = m0.a;
        r111 = new ViewGroup.LayoutParams(m0.b(r12.getContext()), m0.b(r12.getContext()) - (c7.b(72) * 2));
        goto L46
    L28:
        r2 = 2131377334;
        goto L32
    L29:
        r2 = 2131370468;
        goto L32
    L33:
        ConstraintLayout r21 = LayoutInflater.from(r12.getContext()).inflate(2131562491, null, false);
        View r22 = ViewBindings.findChildViewById(r21, 2131363082);
        if (r22 != null) goto L36;
        r2 = 2131363082;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r2)));
    L36:
        if (ViewBindings.findChildViewById(r21, 2131370468) == null) goto L49;
        ConstraintLayout r23 = r21;
        if (((CircleRingView) ViewBindings.findChildViewById(r21, 2131385764)) != null) goto L40;
        r2 = 2131385764;
        goto L52
    L40:
        if (ViewBindings.findChildViewById(r21, 2131387273) == null) goto L52;
        r4 = new LarusItemAppIconBinding(r23, r22);
        goto L42
    L49:
        r2 = 2131370468;
        goto L52
    L13:
        int r112 = m0.a;
        r16 = m0.b(r12.getContext()) - 10;
    L10:
        r3 = false;
        goto L11
    L5:
        r15 = null;
        goto L6
    }
}
