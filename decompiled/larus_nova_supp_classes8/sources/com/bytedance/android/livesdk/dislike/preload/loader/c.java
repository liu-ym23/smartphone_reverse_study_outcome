package com.bytedance.android.livesdk.dislike.preload.loader;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.live.base.model.user.q;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.ItemType;
import com.bytedance.android.livesdk.dislike.l;
import com.bytedance.android.livesdk.dislike.n;
import com.bytedance.android.livesdk.utils.LivePanelsOptUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements q {
    public final /* synthetic */ b a;
    public final /* synthetic */ List b;
    public final /* synthetic */ long c;

    public final void a(List<f> r10) {
        ActionsManager r0 = this.a.c.b();
        if (r0 == null) goto L46;
        boolean r2 = true;
        if ((!r10.isEmpty()) == true) goto L8;
        r10 = null;
    L8:
        if (r10 != null) goto L10;
        return;
    L10:
        if (b.e(this.a, ItemIdentity.IM_MESSAGE.getKey()) == false) goto L16;
        Iterator<T> r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L16;
        f r1 = (f) r11.next();
        List r4 = this.b;
        Intrinsics.checkNotNullParameter(r1, "contact");
        r4.add(new l(r1, new com.bytedance.android.livesdk.dislike.action.l(r0, r1), ItemType.IM_MESSAGE));
    L16:
        if (this.c != 2) goto L18;
    L20:
        b r12 = this.a;
        List<n> r3 = this.b;
        List<n> r5 = r12.e;
        r12.e = r3;
        if (r5.size() != r3.size()) goto L38;
        Iterator<T> r6 = r5.iterator();
        int r7 = 0;
    L24:
        if (r6.hasNext() == false) goto L36;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        n r13 = (n) r8;
        n r14 = (n) ListProtector.get(r3, r7);
        if ((r14 instanceof l) == false) goto L35;
        if ((r13 instanceof l) == false) goto L35;
        ((l) r14).c.getClass();
        ((l) r13).c.getClass();
        if (TextUtils.equals(null, null) == true) goto L35;
        r2 = false;
    L35:
        r7 = r9;
        goto L24
    L36:
        if (r2 == false) goto L38;
        return;
    L38:
        LivePanelsOptUtil.c("更新im数据");
        r12.f();
        r12.c.a();
        return;
    L18:
        if (b.e(this.a, ItemIdentity.MORE_FRIENDS.getKey()) == false) goto L20;
        this.b.add(r0.o());
        this.a.getClass();
        goto L20
    }

    public c(b r1, List r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
