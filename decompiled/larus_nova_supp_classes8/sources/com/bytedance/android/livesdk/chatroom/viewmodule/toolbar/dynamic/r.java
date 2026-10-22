package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.live.base.model.message.k5;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.we;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    public final Boolean a;
    public final Boolean b;
    public ArrayList<s> c;
    public ArrayList<s> d;
    public Map<Integer, ? extends IToolbarComponentSkin> e;
    public final List<String> f;
    public final PropertyOwner<a> g;
    public final PropertyOwner h;
    public final DataCenter i;

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

        public c() {
            throw null;
        }

        public c(List r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            super(r3, null);
            this.c = r2;
        }
    }

    public final boolean k() {
        if (this.a.booleanValue() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.a.booleanValue() == false) goto L7;
    L9:
        return false;
    L7:
        if (((Boolean) we.a.getValue()).booleanValue() == false) goto L9;
        goto L9
    }

    public r(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.i = r4;
        this.a = (Boolean) r4.get("data_is_anchor", Boolean.FALSE);
        this.b = (Boolean) r4.get("data_is_portrait", Boolean.TRUE);
        this.f = (List) LiveInfraSettingKeys.LIVE_TOOLBAR_MESSAGE_UPDATE_WHITELIST.getValue();
        PropertyOwner<a> r5 = new PropertyOwner(new a(0, null));
        this.g = r5;
        this.h = r5;
    }

    public final void a(s r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarButton");
        ArrayList<s> r0 = this.c;
        if (r0 == null) goto L6;
        int r1 = r0.size();
        r0.remove(r3);
        r0.add(r3);
        i(r1, r0.size());
        return;
    }

    public final void c(s r2) {
        ArrayList<s> r0 = this.d;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        ArrayList<s> r1 = this.d;
        if (r1 == null) goto L9;
        r1.add(r2);
        return;
    }

    public final boolean f(dm r6) {
        if (k() == true) goto L5;
    L15:
        return false;
    L5:
        if (r6.getOpType() != 0) goto L15;
        List r0 = r6.getHighList();
        if (r0 == null) goto L15;
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        k5 r2 = (k5) r1.next();
        int r4 = (int) r2.getId();
        s r3 = new s();
        r3.a = r4;
        if (y3.m(this.i).n(f3.b(r3, this.a.booleanValue(), false)) == false) goto L10;
        ALogger.i("NewToolbarLog", "filter " + r6.getComponentType() + " up msg, because " + r2.getId() + " is showing.");
        return true;
    }

    public final void h(s r3) {
        ArrayList<s> r0 = this.c;
        if (r0 == null) goto L6;
        int r1 = r0.size();
        r0.remove(r3);
        i(r1, r0.size());
        return;
    }

    public final void j(dm r10) {
        if (k() == true) goto L5;
        return;
    L5:
        if (r10.getOpType() != 0) goto L59;
        List r0 = r10.getLowList();
        if (r0 == null) goto L60;
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L61;
        k5 r2 = (k5) r1.next();
        ALogger.i("NewToolbarLog", "remove " + r2.getId() + " by " + r10.getComponentType() + " up msg lowList.");
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
        g(r9, (int) r2.getOpType(this.a.booleanValue()));
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

    public static ArrayList d(com.bytedance.live.datacontext.n r5, List r6) {
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
        ToolbarComponentData r4 = (ToolbarComponentData) r8.next();
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
        if (r5 == null) goto L18;
        List r10 = (List) r5.getValue();
    L20:
        if ((r10 instanceof ArrayList) == false) goto L24;
        r0 = r10;
    L24:
        return (ArrayList) r0;
    L18:
        r10 = null;
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public static void e(ArrayList r3, String r4) {
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        s r0 = (s) r5.next();
        ALogger.i("NewToolbarLog", "Enter room data:" + r4 + ' ' + r0 + " - extra: " + r0.d);
        goto L4
    }

    public final void b(s r5, int r6) {
        int r2 = 2;
        if (u40.a.b() == false) goto L17;
        if (r6 == 0) goto L8;
        if (r6 == 1) goto L7;
        r2 = 0;
    L12:
        if (r2 != 0) goto L15;
        ALogger.i("NewToolbarLog", "add button op_type not support: " + r6);
        return;
    L15:
        this.g.a(new b(r5, r2, null));
        return;
    L7:
        h(r5);
        c(r5);
        goto L12
    L8:
        ArrayList<s> r0 = this.d;
        if (r0 == null) goto L11;
        r0.remove(r5);
    L11:
        a(r5);
        r2 = 1;
        goto L12
    L17:
        if (1 != r6) goto L19;
        h(r5);
        c(r5);
    L23:
        this.g.a(new b(r5, r2, null));
        return;
    L19:
        ArrayList<s> r7 = this.d;
        if (r7 == null) goto L22;
        r7.remove(r5);
    L22:
        a(r5);
        r2 = 1;
        goto L23
    }

    public final void g(s r4, int r5) {
        ALogger.i("NewToolbarLog", "onButtonRemove - " + r4);
        Lazy r0 = ToolbarComponentCheckManager.a;
        DataCenter r1 = this.i;
        Intrinsics.checkNotNullParameter(r4, "model");
        ToolbarComponentCheckManager.h(r1, new ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$1(r4), new ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$2(r4));
        if (1 != r5) goto L5;
        h(r4);
        c(r4);
        int r6 = 2;
    L6:
        this.g.a(new b(r4, r4, r6, null));
        return;
    L5:
        h(r4);
        r6 = 3;
        goto L6
    }

    public final void i(int r2, int r3) {
        if (this.b.booleanValue() == true) goto L8;
        if (r2 == r3) goto L9;
        this.i.put("landscape_toolbar_button_change", new ArrayList(this.c));
        return;
    L9:
        return;
    }
}
