package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends FrameLayout {
    public HSImageView a;
    public HSImageView b;
    public RecyclerView c;
    public ViewGroup d;
    public TextView e;
    public TextView f;
    public ViewGroup g;
    public TextView h;
    public ViewGroup i;
    public TextView j;
    public IRoom k;
    public final List<ILinkPlayerInfoBridge> l;
    public x m;
    public LinkmicApplyFloatViewAvatarAdapter n;
    public final ye0.c o;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.floatwindow.applywindow.a$a, reason: collision with other inner class name */
    public static final class C0030a {
    }

    static {
    }

    public final void b(List<? extends ILinkPlayerInfoBridge> r5) {
        Intrinsics.checkNotNullParameter(r5, "newOnlineUserList");
        ArrayList r6 = (ArrayList) r5;
        if (r6.size() != ((ArrayList) this.l).size()) goto L22;
        List r0 = CollectionsKt.zip(r6, this.l);
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L23;
        Pair r2 = (Pair) r1.next();
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.component1();
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r2.component2();
        IBaseUser r7 = r3.getUser();
        String r8 = null;
        if (r7 == null) goto L16;
        String r9 = r7.getIdString();
    L17:
        IBaseUser r10 = r4.getUser();
        if (r10 == null) goto L21;
        r8 = r10.getIdString();
    L21:
        if (Intrinsics.areEqual(r9, r8) == true) goto L12;
    L16:
        r9 = null;
    L23:
        boolean r11 = true;
    L24:
        if (r11 == false) goto L26;
        return;
    L26:
        ArrayList r12 = (ArrayList) this.l;
        r12.clear();
        r12.addAll(r6);
        LinkmicApplyFloatViewAvatarAdapter r13 = this.n;
        if (r13 == null) goto L33;
        r13.notifyDataSetChanged();
        return;
    L33:
        return;
    L8:
        if (r0.isEmpty() == false) goto L10;
    L22:
        r11 = false;
        goto L24
    }

    public final void c(x r9) {
        Intrinsics.checkNotNullParameter(r9, "waitingRankResult");
        this.m = r9;
        if (r9.getRank() <= 99) goto L7;
        TextView r10 = this.h;
        if (r10 == null) goto L11;
        r10.setText(s1.C(2131917759, new Object[]{"99+"}));
        return;
    L11:
        return;
    L7:
        TextView r0 = this.h;
        if (r0 == null) goto L13;
        r0.setText(s1.C(2131917759, new Object[]{Long.valueOf(r9.getRank())}));
        return;
    }

    public a(Context r2, LinkmicApplyFloatWindowManager r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2);
        this.o = r3;
        ArrayList r4 = new ArrayList();
        this.l = r4;
        View r5 = LayoutInflater.from(getContext()).inflate(2131566841, this);
        this.a = r5.findViewById(2131372973);
        this.b = r5.findViewById(2131372974);
        this.c = r5.findViewById(2131372982);
        this.d = (ViewGroup) r5.findViewById(2131372980);
        this.e = (TextView) r5.findViewById(2131372981);
        this.f = (TextView) r5.findViewById(2131372968);
        this.g = (ViewGroup) r5.findViewById(2131372967);
        this.h = (TextView) r5.findViewById(2131372984);
        this.i = (ViewGroup) r5.findViewById(2131372966);
        this.j = (TextView) r5.findViewById(2131372978);
        r5.setOnClickListener(new b(this));
        HSImageView r6 = this.b;
        if (r6 == null) goto L5;
        r6.setOnClickListener(new c(this));
    L5:
        this.n = new LinkmicApplyFloatViewAvatarAdapter(getContext(), r4);
        RecyclerView r7 = this.c;
        if (r7 == null) goto L8;
        LinearLayoutManager r8 = new LinearLayoutManager(getContext());
        r8.setOrientation(0);
        Unit r0 = Unit.INSTANCE;
        r7.setLayoutManager(r8);
    L8:
        RecyclerView r9 = this.c;
        if (r9 == null) goto L12;
        r9.setAdapter(this.n);
        return;
    }

    public final void a(int r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "tips");
        if (r4 != 5) goto L16;
        this.o.b();
        ViewGroup r0 = this.d;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        RecyclerView r1 = this.c;
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        ViewGroup r2 = this.g;
        if (r2 == null) goto L13;
        r2.setVisibility(8);
    L13:
        ViewGroup r3 = this.i;
        if (r3 == null) goto L16;
        r3.setVisibility(8);
    L16:
        TextView r7 = this.e;
        if (r7 == null) goto L19;
        r7.setText(r5);
    L19:
        TextView r8 = this.e;
        if (r8 == null) goto L22;
        r8.setTextSize(r6);
    L22:
        TextView r9 = this.f;
        if (r9 == null) goto L26;
        r9.setText(s1.C(2131917597, new Object[]{Integer.valueOf(r4)}));
        return;
    }
}
