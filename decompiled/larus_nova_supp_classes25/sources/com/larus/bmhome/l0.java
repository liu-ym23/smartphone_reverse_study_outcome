package com.larus.bmhome;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.home.impl.main.side_bar.data.ComponentTypeEnum;
import com.larus.home.impl.main.side_bar.view.SideBarContentFragment;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarComponentAdapter;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hq9.m2;
import hq9.v2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 {
    public static final /* synthetic */ int g = 0;
    public final SideBarContentFragment a;
    public final AtomicInteger b;
    public volatile OfficeSDKUserApi c;
    public volatile v2 d;
    public n0 e;
    public final j0 f;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.a.isAdded() == true) goto L6;
        FLogger.a.w("SideBarLarkBadgeManager", "refreshAddressBookBadge skip: fragment not added");
        return;
    L6:
        FLogger.a.i("SideBarLarkBadgeManager", "refreshAddressBookBadge count=" + this.b.get());
        ConcatAdapter r0 = this.a.g;
        if (r0 == null) goto L30;
        List r1 = r0.getAdapters();
        if (r1 == null) goto L38;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L39;
        SideBarComponentAdapter r3 = (RecyclerView.Adapter) r2.next();
        if ((r3 instanceof SideBarComponentAdapter) == false) goto L12;
        SideBarComponentAdapter r4 = r3;
        Iterator r5 = r4.getCurrentList().iterator();
        int r6 = 0;
    L17:
        if (r5.hasNext() == false) goto L12;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        com.larus.home.impl.main.side_bar.data.j0 r9 = (com.larus.home.impl.main.side_bar.data.j0) r7;
        com.larus.home.impl.main.side_bar.data.p r10 = r9.d;
        if (r10 != null) goto L24;
    L26:
        boolean r11 = false;
    L27:
        if (r11 == false) goto L29;
        r9.j = this.b.get();
        r4.notifyItemChanged(r6);
    L29:
        r6 = r8;
        goto L17
    L24:
        if (r10.getType() != ComponentTypeEnum.LARK_ADDRESS_BOOK.getType()) goto L26;
        r11 = true;
        goto L27
    L39:
        return;
    L38:
        return;
    }

    public final void c() {
        Object r0 = xp9.o.a;
        xp9.o.d(this.f);
        d();
        this.b.set(0);
        com.larus.utils.y.c(new k0(this));
    }

    public final void d() {
        OfficeSDKUserApi r0 = this.c;
        n0 r1 = this.e;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        ktb.a r2 = r0.getService(ktb.a.class);
        if (r2 == null) goto L8;
        r2.t1(r1);
    L8:
        this.c = null;
        this.d = null;
        this.e = null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.j0] */
    public l0(SideBarContentFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = new AtomicInteger(0);
        this.f = new j0(this);
    }

    public final boolean a(OfficeSDKUserApi r2, v2 r3) {
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == true) goto L5;
    L13:
        return false;
    L5:
        if (xp9.o.a != r2) goto L13;
        if (this.c != r2) goto L13;
        if (Intrinsics.areEqual(this.d, r3) == false) goto L13;
        if (Intrinsics.areEqual(((m2) LarkSocialExp.e.getValue()).b, r3) == false) goto L13;
        return true;
    }
}
