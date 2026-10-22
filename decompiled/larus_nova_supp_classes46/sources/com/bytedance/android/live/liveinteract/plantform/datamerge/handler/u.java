package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u extends eh0.a {
    public Boolean b;
    public final b c;
    public final DataCenter d;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            KVData r5 = (KVData) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual("data_big_party_support_send_gift_to_linker", r5.getKey()) == true) goto L8;
            return;
        L8:
            if (r5.getData() == null) goto L14;
            Object r6 = r5.getData();
            if (r6 == null) goto L13;
            boolean r7 = ((Boolean) r6).booleanValue();
        L16:
            if ((!Intrinsics.areEqual(this.a.b, Boolean.valueOf(r7))) == false) goto L20;
            gh0.a.b("RemoteSupportSendGiftSettingHandler", "call isSupportSendGift change from " + this.a.b + " to " + r7, 4);
            this.a.b = Boolean.valueOf(r7);
            this.a.c();
            return;
        L20:
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L14:
            r7 = false;
            goto L16
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        this.d.observe("data_big_party_support_send_gift_to_linker", this.c);
    }

    @Override // eh0.c
    public final void detach() {
        this.d.removeObserver("data_big_party_support_send_gift_to_linker", this.c);
    }

    public u(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.d = r3;
        this.b = (Boolean) r3.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE);
        this.c = new b(this);
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r12) {
        Intrinsics.checkNotNullParameter(r12, "oldMergeDataList");
        List<ch0.e> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
        boolean r1 = false;
        ch0.e r3 = null;
    L4:
        if (r14.hasNext() == false) goto L19;
        ch0.e r4 = (ch0.e) r14.next();
        if (Intrinsics.areEqual(Boolean.valueOf(r4.a.isOpenSendGift()), this.b) == false) goto L8;
        boolean r5 = r1;
        ch0.e r2 = r4;
    L9:
        IBaseUser r6 = r2.a.getUser();
        if (r6 == null) goto L12;
        String r7 = r6.getIdString();
    L14:
        if (Intrinsics.areEqual(r7, gh0.a.c()) == false) goto L17;
        if (r2 == r4) goto L17;
        r3 = r2;
    L17:
        r0.add(r2);
        r1 = r5;
        goto L4
    L12:
        r7 = null;
        goto L14
    L8:
        ILinkPlayerInfoBridge r8 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r4.a);
        r8.setOpenSendGift(this.b.booleanValue());
        r2 = ch0.e.a(r4, r8, null, null, null, 14);
        r5 = true;
        goto L9
    L19:
        return new h.a(r1, r0, r3);
    }
}
