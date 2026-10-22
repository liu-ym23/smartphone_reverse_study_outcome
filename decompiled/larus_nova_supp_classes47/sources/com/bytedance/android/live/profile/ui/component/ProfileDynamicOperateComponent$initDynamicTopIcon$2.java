package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.ActionConfig;
import com.bytedance.android.live.core.utils.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileDynamicOperateComponent$initDynamicTopIcon$2 implements View.OnClickListener {
    public final /* synthetic */ ProfileDynamicOperateComponent a;
    public final /* synthetic */ List b;

    public static final class a implements hm3.a {
        public a() {
        }

        public final void onCancel() {
        }
    }

    public ProfileDynamicOperateComponent$initDynamicTopIcon$2(ProfileDynamicOperateComponent r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        final ArrayList r4 = new ArrayList();
        Iterator r13 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r13.hasNext() == false) goto L18;
        Object r2 = r13.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ActionConfig r5 = (ActionConfig) r2;
        if (r1 == 0) goto L17;
        String r6 = r5.getTextInMore();
        if (r6 == null) goto L17;
        if (r5.actionType == ActionConfig.TYPE_DIGG) goto L15;
        boolean r7 = true;
    L16:
        r4.add(new gm3.a(r1, r6, r7));
        goto L17
    L15:
        r7 = false;
    L17:
        r1 = r3;
        goto L4
    L18:
        this.a.C.b().recordBusinessClick("more", null);
        Context r8 = this.a.a.getContext();
        if (r8 == null) goto L26;
        Intrinsics.checkNotNullParameter(r8, "context");
        String r9 = s1.B(2131920691);
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r4, "items");
        a r10 = new a();
        Intrinsics.checkNotNullParameter(r10, "listener");
        hm3.b r14 = new ProfileDynamicOperateComponent$initDynamicTopIcon$2$$special$$inlined$let$lambda$1(this, r4);
        Intrinsics.checkNotNullParameter(r14, "listener");
        new gm3.b(r14, r10, r9, r4, r8, null).b();
        return;
    }
}
