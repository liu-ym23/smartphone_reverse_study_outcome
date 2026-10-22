package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import com.bytedance.android.live.base.model.message.k5;
import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.z;
import com.bytedance.android.livesdk.config.we;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ot2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NewToolbarOriginalDataManager {
    public final Lazy a;
    public final Boolean b;
    public ArrayList<s> c;
    public ArrayList<s> d;
    public Map<Integer, ? extends IToolbarComponentSkin> e;
    public final List<String> f;
    public final PropertyOwner<a> g;
    public final PropertyOwner h;
    public final DataCenter i;
    public final z j;
    public final ot2.c k;

    public static class a {
        public final int a;
        public final Integer b;

        public a(int r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends a {
        public final s c;
        public final s d;

        public /* synthetic */ b() {
            throw null;
        }

        public b(s r2, int r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this(null, r2, r3, r4);
        }

        public b(s r2, s r3, int r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r3, "to");
            super(r4, r5);
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class c extends a {
        public final List<s> c;
        public final e d;

        public c() {
            throw null;
        }

        public c(List r2, int r3, e r4, int r5) {
            if ((r5 & 8) == 0) goto L5;
            r4 = null;
        L5:
            Intrinsics.checkNotNullParameter(r2, "list");
            super(r3, null);
            this.c = r2;
            this.d = r4;
        }
    }

    public final boolean i() {
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L5;
    L10:
        return true;
    L5:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L7;
    L9:
        return false;
    L7:
        if (((Boolean) we.a.getValue()).booleanValue() == false) goto L9;
        goto L9
    }

    public final boolean d(l5 r6) {
        if (i() == true) goto L5;
        return false;
    L5:
        if (r6.getOpType() != 0) goto L20;
        List r0 = r6.getHighList();
        if (r0 == null) goto L21;
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L22;
        k5 r2 = (k5) r1.next();
        if (this.k.isComponentShowing((int) r2.getId()) == false) goto L10;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "filter " + r6.getComponentType() + " up msg, because " + r2.getId() + " is showing.");
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    public final void f(s r3) {
        ArrayList<s> r0 = this.c;
        if (r0 == null) goto L6;
        int r1 = r0.size();
        r0.remove(r3);
        g(r1, r0.size());
        return;
    }

    public final void h(l5 r10) {
        if (i() == true) goto L5;
        return;
    L5:
        if (r10.getOpType() != 0) goto L59;
        List r0 = r10.getLowList();
        if (r0 == null) goto L60;
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L61;
        k5 r2 = (k5) r1.next();
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "remove " + r2.getId() + " by " + r10.getComponentType() + " up msg lowList.");
        int r3 = (int) r2.getId();
        Iterable r4 = this.c;
        if (r4 != null) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        Iterator r5 = r4.iterator();
    L16:
        Object r7 = null;
        if (r5.hasNext() == false) goto L24;
        Object r6 = r5.next();
        if (((s) r6).a != r3) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L16;
    L25:
        s r9 = (s) r6;
        if (r9 != null) goto L41;
        Iterable r11 = this.d;
        if (r11 != null) goto L31;
        r11 = CollectionsKt.emptyList();
    L31:
        Iterator r12 = r11.iterator();
    L33:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();
        if (((s) r13).a != r3) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L33;
        r7 = r13;
        goto L40
    L37:
        r14 = false;
    L40:
        r9 = (s) r7;
    L41:
        if (r9 == null) goto L10;
        e(r9, (int) r2.getOpType(((Boolean) this.a.getValue()).booleanValue()));
        goto L10
    L21:
        r8 = false;
        goto L22
    L24:
        r6 = null;
        goto L25
    L61:
        return;
    L60:
        return;
    }

    public static ArrayList b(n r5, List r6) {
        List r0 = null;
        if (r5 == null) goto L5;
        List r1 = (List) r5.getValue();
    L6:
        if (r1 != null) goto L16;
        ArrayList r2 = new ArrayList();
        if (r6 == null) goto L14;
        List r7 = r6;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        IToolbarComponentData r4 = (IToolbarComponentData) r8.next();
        Intrinsics.checkNotNullParameter(r4, "$this$toModel");
        int r9 = s.q;
        r3.add(s.a.a(r4));
        goto L11
    L13:
        r2.addAll(r3);
    L14:
        if (r5 == null) goto L16;
        r5.setValue(r2);
    L16:
        String r10 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG();
        StringBuilder r11 = new StringBuilder("initToolbarData, result: ");
        if (r5 == null) goto L19;
        List r12 = (List) r5.getValue();
    L20:
        r11.append(r12);
        ALogger.i(r10, r11.toString());
        if (r5 == null) goto L23;
        List r13 = (List) r5.getValue();
    L25:
        if ((r13 instanceof ArrayList) == false) goto L29;
        r0 = r13;
    L29:
        return (ArrayList) r0;
    L23:
        r13 = null;
        goto L25
    L19:
        r12 = null;
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public static void c(Iterable r4, String r5) {
        if (r4 == null) goto L7;
        Iterator r6 = r4.iterator();
    L5:
        if (r6.hasNext() == false) goto L9;
        s r0 = (s) r6.next();
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "Enter room data:" + r5 + ' ' + r0 + " showType = " + r0.g + " - extra: " + r0.d);
        goto L5
    L9:
        return;
    }

    public final void a(s r4, int r5) {
        int r0 = 1;
        if (r5 == 0) goto L13;
        if (r5 == 1) goto L6;
        r0 = 0;
    L19:
        if (r0 != 0) goto L22;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "add button op_type not support: " + r5);
        return;
    L22:
        this.g.a(new b(r4, r0, null));
        return;
    L6:
        f(r4);
        ArrayList<s> r1 = this.d;
        if (r1 == null) goto L9;
        r1.remove(r4);
    L9:
        ArrayList<s> r2 = this.d;
        if (r2 == null) goto L12;
        r2.add(r4);
    L12:
        r0 = 2;
        goto L19
    L13:
        ArrayList<s> r3 = this.d;
        if (r3 == null) goto L16;
        r3.remove(r4);
    L16:
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        ArrayList<s> r6 = this.c;
        if (r6 == null) goto L19;
        int r7 = r6.size();
        r6.remove(r4);
        r6.add(r4);
        g(r7, r6.size());
        goto L19
    }

    public final void e(s r4, int r5) {
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onButtonRemove - " + r4);
        z r0 = this.j;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "model");
        Map.Entry<z.a, Runnable> r1 = r0.g(r4.a);
        if (r1 == null) goto L6;
        Runnable r2 = r0.d.remove(r1.getKey());
    L6:
        if (1 != r5) goto L14;
        f(r4);
        ArrayList<s> r6 = this.d;
        if (r6 == null) goto L10;
        r6.remove(r4);
    L10:
        ArrayList<s> r7 = this.d;
        if (r7 == null) goto L13;
        r7.add(r4);
    L13:
        int r8 = 2;
    L15:
        this.g.a(new b(r4, r4, r8, null));
        return;
    L14:
        f(r4);
        r8 = 3;
        goto L15
    }

    public final void g(int r2, int r3) {
        if (this.b.booleanValue() == true) goto L8;
        if (r2 == r3) goto L9;
        this.i.put("landscape_toolbar_button_change", new ArrayList(this.c));
        return;
    L9:
        return;
    }

    public NewToolbarOriginalDataManager(DataCenter r2, z r3, ot2.c r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "checkManager");
        Intrinsics.checkNotNullParameter(r4, "bottomToolbarViewModel");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.a = LazyKt.lazy(new NewToolbarOriginalDataManager$isAnchor$2(this));
        this.b = (Boolean) r2.get("data_is_portrait", Boolean.TRUE);
        this.f = (List) LiveInfraSettingKeys.LIVE_TOOLBAR_MESSAGE_UPDATE_WHITELIST.getValue();
        PropertyOwner<a> r5 = new PropertyOwner(new a(0, null));
        this.g = r5;
        this.h = r5;
    }
}
