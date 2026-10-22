package com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.scope.m;
import i12.e;
import i12.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements GiftStateMachineConfig.g {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    public static final class b extends a {
        public final IBaseUser a;

        public b(IBaseUser r2) {
            Intrinsics.checkNotNullParameter(r2, "anchor");
            this.a = r2;
        }
    }

    public static final class c extends a {
        public final IBaseUser a;
        public final IBaseUser b;
        public final Map<Integer, GiftStateMachineConfig.d> c;
        public final List<IBaseUser> d;
        public final boolean e;
        public final ReceiverType f;

        public /* synthetic */ c(IBaseUser r8, IBaseUser r9, Map r10, ReceiverType r11) {
            this(r8, r9, r10, CollectionsKt.emptyList(), false, r11);
        }

        public c(IBaseUser r2, IBaseUser r3, Map<Integer, GiftStateMachineConfig.d> r4, List<? extends IBaseUser> r5, boolean r6, ReceiverType r7) {
            Intrinsics.checkNotNullParameter(r2, "currentUser");
            Intrinsics.checkNotNullParameter(r3, "defaultUser");
            Intrinsics.checkNotNullParameter(r4, "currentListMap");
            Intrinsics.checkNotNullParameter(r5, "multiSendReceivers");
            Intrinsics.checkNotNullParameter(r7, "receiverType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    static {
    }

    public a() {
    }

    public final GiftStateMachineConfig.d a(int r5) {
        if ((this instanceof c) == false) goto L24;
        e r0 = o.b();
        if (r0 == null) goto L7;
        Object r1 = m.e.d(r0, GiftReceiverRepoService.class);
    L8:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 == null) goto L11;
        boolean r3 = r2.q(r5);
    L12:
        Boolean r4 = Boolean.valueOf(r3);
        if (r4.booleanValue() == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L22;
        r4.booleanValue();
        GiftStateMachineConfig.d r6 = ((c) this).c.get(Integer.valueOf(r5));
        if (r6 == null) goto L20;
        return r6;
    L20:
        return new GiftStateMachineConfig.d(new ArrayList(), null);
    L22:
        return new GiftStateMachineConfig.d(new ArrayList(), null);
    L11:
        r3 = false;
        goto L12
    L7:
        r1 = null;
        goto L8
    L24:
        return new GiftStateMachineConfig.d(new ArrayList(), null);
    }

    public final GiftStateMachineConfig.d b(int r6) {
        if (r6 != 2) goto L5;
        List r7 = CollectionsKt.plus(a(1).a, a(5).a);
        HashSet r0 = new HashSet();
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L27;
        Object r3 = r8.next();
        if (r0.add(((IBaseUser) r3).getIdString()) == false) goto L22;
        r2.add(r3);
        goto L22
    L27:
        return new GiftStateMachineConfig.d(r2, null);
    L5:
        if (r6 != 4) goto L7;
        List r9 = CollectionsKt.plus(a(2).a, a(3).a);
        HashSet r1 = new HashSet();
        ArrayList r4 = new ArrayList();
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L41;
        Object r5 = r10.next();
        if (r1.add(((IBaseUser) r5).getIdString()) == false) goto L15;
        r4.add(r5);
        goto L15
    L41:
        return new GiftStateMachineConfig.d(r4, null);
    L7:
        if (r6 == 8) goto L40;
        if (r6 == 1024) goto L39;
        return new GiftStateMachineConfig.d(new ArrayList(), null);
    L39:
        return new GiftStateMachineConfig.d(a(6).a, null);
    L40:
        return new GiftStateMachineConfig.d(a(4).a, a(4).b);
    }
}
