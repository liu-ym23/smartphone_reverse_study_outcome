package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends eh0.a {
    public final List<ILinkPlayerInfoBridge> b;
    public final b c;
    public final List<eh0.c> d;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> e;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ q a;

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }

        public b(q r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<ILinkPlayerInfoBridge> r9, List<ILinkPlayerInfoBridge> r10) {
            Intrinsics.checkNotNullParameter(r9, "list");
            Intrinsics.checkNotNullParameter(r10, "peerList");
            gh0.a.b("LinkUserCenterHandler", "call onLinkRoomOnlineListChanged by linkUserCenter, listSize: " + r9.size() + ", peerListSize: " + r10.size(), 4);
            Iterator<T> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r11.next();
            r0.setLinkRoomUser(true);
            int r1 = tc0.e.a;
            tc0.e.b(r0, tc0.c.h().o);
            goto L4
        L6:
            boolean r12 = !gh0.a.f(r10, this.a.b);
            this.a.getClass();
            StringBuilder r2 = new StringBuilder("\n");
            int r3 = r10.size();
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L13;
            ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) ListProtector.get(r10, r4);
            StringBuilder r6 = new StringBuilder("position: ");
            r6.append(r4);
            r6.append(", GuestItemData, nickName = ");
            IBaseUser r7 = r5.getUser();
            if (r7 == null) goto L11;
            String r8 = r7.getNickName();
        L12:
            r6.append(r8);
            r6.append(", linkType = ");
            r6.append(r5.getLinkType());
            r6.append('\n');
            r2.append(r6.toString());
            r4 = r4 + 1;
            goto L7
        L11:
            r8 = null;
            goto L12
        L13:
            gh0.b.a("DataMerge", "onOnlineListChanged:  hasModified = " + r12 + ", " + r2.toString(), false);
            if (r12 == false) goto L33;
            ((ArrayList) this.a.b).clear();
            ((ArrayList) this.a.b).addAll(r10);
            q r13 = this.a;
            h.a r14 = r13.a(r13.b().d());
            boolean r15 = r14.a;
            Iterator<eh0.c> r16 = r13.d.iterator();
        L17:
            if (r16.hasNext() == false) goto L21;
            r14 = r16.next().a(r14.b);
            if (r14.a == false) goto L17;
            r15 = true;
            goto L17
        L21:
            if (r15 == false) goto L34;
            r14.a = true;
            r13.b().m(r14);
            return;
        L34:
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // eh0.c
    public final void attach() {
        this.e.Q4(this.c);
        List<T> r0 = this.e.getOnlineUserList();
        List<T> r1 = this.e.c();
        if (r0 == 0) goto L7;
        if (r1 == 0) goto L8;
        this.c.d(r0, r1);
        return;
    L8:
        return;
    }

    @Override // eh0.c
    public final void detach() {
        this.e.T4(this.c);
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r15) {
        Intrinsics.checkNotNullParameter(r15, "oldMergeDataList");
        List<ch0.e> r0 = r15;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.e) r2).a.getInteractId(), r2);
        goto L4
    L6:
        List<ILinkPlayerInfoBridge> r4 = this.b;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = ((ArrayList) r4).iterator();
        boolean r7 = false;
        ch0.e r8 = null;
    L7:
        boolean r9 = true;
        if (r6.hasNext() == false) goto L26;
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r6.next();
        ch0.e r11 = (ch0.e) r3.get(r10.getInteractId());
        if (r11 != null) goto L12;
        ch0.e r12 = new ch0.e(r10);
    L16:
        IBaseUser r13 = r12.a.getUser();
        if (r13 == null) goto L19;
        String r14 = r13.getIdString();
    L21:
        if (Intrinsics.areEqual(r14, gh0.a.c()) == false) goto L24;
        if (r12 == r11) goto L24;
        r8 = r12;
    L24:
        r5.add(r12);
        r7 = r9;
        goto L7
    L19:
        r14 = null;
        goto L21
    L12:
        if (r11.b(r10) == false) goto L14;
        r9 = r7;
        r12 = r11;
        goto L16
    L14:
        r12 = ch0.e.a(r11, r10, null, null, null, 14);
        goto L16
    L26:
        if ((!r15.isEmpty()) == false) goto L31;
        if (((ArrayList) this.b).isEmpty() == false) goto L31;
        r7 = true;
    L31:
        return new h.a(r7, r5, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(List<? extends eh0.c> r2, com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3) {
        Intrinsics.checkNotNullParameter(r2, "remoteChildHandlers");
        Intrinsics.checkNotNullParameter(r3, "linkUserCenter");
        this.d = r2;
        this.e = r3;
        this.b = new ArrayList();
        this.c = new b(this);
    }
}
