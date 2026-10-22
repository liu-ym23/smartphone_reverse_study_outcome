package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.floatwindow.common.listener.LinkmicOnlineListDiffCallback;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends FrameLayout {
    public HSImageView a;
    public HSImageView b;
    public RecyclerView c;
    public ViewGroup d;
    public TextView e;
    public TextView f;
    public ViewGroup g;
    public ViewGroup h;
    public TextView i;
    public TextView j;
    public View k;
    public TextView l;
    public IRoom m;
    public List<ILinkPlayerInfoBridge> n;
    public LinkmicOnlineFloatViewAvatarAdapter o;
    public final ye0.c p;

    public static final class a {
    }

    static {
    }

    public final void a(boolean r5) {
        Iterator<T> r0 = this.n.iterator();
    L3:
        RecyclerView.ViewHolder r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r1) == false) goto L3;
    L10:
        if (((ILinkPlayerInfoBridge) r1) != null) goto L12;
        return;
    L12:
        if (this.n.size() < 4) goto L16;
        RecyclerView r3 = this.c;
        if (r3 == null) goto L20;
        r2 = r3.findViewHolderForAdapterPosition(3);
    L20:
        if ((r2 instanceof LinkmicOnlineFloatViewAvatarViewHolder) == false) goto L27;
        ((LinkmicOnlineFloatViewAvatarViewHolder) r2).T3(r5);
        return;
    L27:
        return;
    L16:
        RecyclerView r4 = this.c;
        if (r4 == null) goto L20;
        r2 = r4.findViewHolderForAdapterPosition(this.n.size() - 1);
        goto L20
    L8:
        r1 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        String r2 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().getClass();
        LinkmicOnlineFloatWindowManager.d();
    }

    public final void setGuestListWithDiffUpdate(List<ILinkPlayerInfoBridge> r10) {
        Intrinsics.checkNotNullParameter(r10, "newList");
        this.n = r10;
        LinkmicOnlineFloatViewAvatarAdapter r1 = this.o;
        if (r1 == null) goto L60;
        Intrinsics.checkNotNullParameter(r10, "newList");
        Iterator<ILinkPlayerInfoBridge> r0 = r10.iterator();
        int r3 = 0;
    L6:
        if (r0.hasNext() == false) goto L11;
        if (je0.d.C(r0.next()) == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r10.size() <= 4) goto L15;
        boolean r2 = true;
    L17:
        if (r2 == r1.a) goto L21;
        r1.a = r2;
        if (r10.size() <= 2) goto L21;
        r1.notifyItemChanged(2);
    L21:
        if (r3 == (-1)) goto L36;
        List r11 = CollectionsKt.toMutableList(r10);
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) ListProtector.remove(r11, r3);
        ArrayList r5 = new ArrayList();
        Iterator r12 = r11.iterator();
        int r6 = 0;
    L24:
        if (r12.hasNext() == false) goto L35;
        Object r7 = r12.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r7;
        if (r6 >= 3) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L34;
        r5.add(r7);
    L34:
        r6 = r8;
        goto L24
    L31:
        r13 = false;
        goto L32
    L35:
        List<? extends ILinkPlayerInfoBridge> r14 = CollectionsKt.toMutableList(r5);
        r14.add(r4);
    L50:
        DiffUtil.calculateDiff(new LinkmicOnlineListDiffCallback(r1.c, r14), true).dispatchUpdatesTo(r1);
        r1.c = r14;
        return;
    L36:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r10.iterator();
        int r17 = 0;
    L38:
        if (r16.hasNext() == false) goto L49;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        ILinkPlayerInfoBridge r20 = (ILinkPlayerInfoBridge) r18;
        if (r17 >= 4) goto L45;
        boolean r21 = true;
    L46:
        if (r21 == false) goto L48;
        r15.add(r18);
    L48:
        r17 = r19;
        goto L38
    L45:
        r21 = false;
        goto L46
    L49:
        r14 = CollectionsKt.toMutableList(r15);
        goto L50
    L15:
        r2 = false;
        goto L17
    L11:
        r3 = -1;
        goto L13
    }

    public final void setInitState(IRoom r8) {
        this.m = r8;
        RecyclerView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        TextView r1 = this.l;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        ViewGroup r2 = this.g;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        ViewGroup r3 = this.h;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        ViewGroup r4 = this.d;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
    L17:
        float r5 = s1.y() / s1.w();
        if (r8 == null) goto L22;
        py.k r6 = r8.getCover();
        if (r6 == null) goto L22;
        ImageLoader.bindImage(this.a, r6, new l3(5, r5, null));
    L22:
        if (r8 != null) goto L24;
        return;
    L24:
        if (r8.getVisibilityRange() != 15) goto L30;
        HSImageView r9 = this.b;
        if (r9 == null) goto L31;
        r9.setVisibility(0);
        return;
    L31:
        return;
    }

    public b(Context r4, LinkmicOnlineFloatWindowManager r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "listener");
        super(r4);
        this.p = r5;
        this.n = new ArrayList();
        View r6 = LayoutInflater.from(getContext()).inflate(2131566842, this);
        this.a = r6.findViewById(2131372973);
        this.b = r6.findViewById(2131372974);
        this.c = r6.findViewById(2131372982);
        this.d = (ViewGroup) r6.findViewById(2131372980);
        this.e = (TextView) r6.findViewById(2131372981);
        this.f = (TextView) r6.findViewById(2131372968);
        this.g = (ViewGroup) r6.findViewById(2131372975);
        this.h = (ViewGroup) r6.findViewById(2131372969);
        this.i = (TextView) r6.findViewById(2131372977);
        this.j = (TextView) r6.findViewById(2131372978);
        this.l = (TextView) r6.findViewById(2131372983);
        this.k = r6.findViewById(2131389689);
        this.o = new LinkmicOnlineFloatViewAvatarAdapter(getContext(), this.n);
        RecyclerView r7 = this.c;
        if (r7 == null) goto L5;
        LinearLayoutManager r1 = new LinearLayoutManager(getContext());
        r1.setOrientation(0);
        Unit r2 = Unit.INSTANCE;
        r7.setLayoutManager(r1);
    L5:
        RecyclerView r8 = this.c;
        if (r8 == null) goto L8;
        r8.addItemDecoration(new LinkmicOnlineFloatView$initView$2());
    L8:
        RecyclerView r9 = this.c;
        if (r9 == null) goto L11;
        r9.setAdapter(this.o);
    L11:
        r6.setOnClickListener(new c(this));
        HSImageView r10 = this.b;
        if (r10 == null) goto L15;
        r10.setOnClickListener(new d(this));
    L15:
        if (((Boolean) vm2.d.j7.getValue(null, vm2.d.a[422(0x1a6, float:5.91E-43)])).booleanValue() == false) goto L19;
        HSImageView r11 = this.b;
        if (r11 == null) goto L23;
        r11.setVisibility(8);
        return;
    L23:
        return;
    L19:
        HSImageView r12 = this.b;
        if (r12 == null) goto L25;
        r12.setVisibility(0);
        return;
    }
}
