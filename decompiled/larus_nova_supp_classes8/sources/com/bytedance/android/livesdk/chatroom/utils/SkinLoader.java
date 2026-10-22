package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarBizSkin;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SkinLoader {
    public static final ArrayList<w2> b = null;
    public static final a c = null;
    public final Map<String, v2> a;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean b() {
            return ((Boolean) com.bytedance.android.livesdk.chatroom.setting.j.a.getValue()).booleanValue();
        }

        @JvmStatic
        public static void f() {
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.v r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.v.a;
            Intrinsics.checkNotNullParameter(r0, "factory");
            Iterator<w2> r1 = SkinLoader.b.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            w2 r2 = r1.next();
            r2.getName();
            if (Intrinsics.areEqual("SkinAnimHandlerFactory", "SkinAnimHandlerFactory") == false) goto L4;
        L9:
            w2 r3 = r2;
            ArrayList<w2> r4 = SkinLoader.b;
            if (r4 == null) goto L14;
            TypeIntrinsics.asMutableCollection(r4).remove(r3);
            r4.add(r0);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        L8:
            r2 = null;
            goto L9
        }

        public static void c(Function0 r1) {
            Intrinsics.checkNotNullParameter(r1, "data");
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
            ALogger.i("SkinLoader", (String) r1.invoke());
            return;
        }

        public static SkinLoader e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
            if (r1 == null) goto L5;
            Map<String, v2> r2 = r1.i;
        L7:
            return new SkinLoader(r2);
        L5:
            r2 = null;
            goto L7
        }

        public static HashMap a(boolean r5, IToolbarComponentSkin r6) {
            Intrinsics.checkNotNullParameter(r6, "skinComponent");
            HashMap r0 = new HashMap();
            Map r1 = r6.getGeneral();
            if (r1 == null) goto L11;
            Iterator r2 = r1.entrySet().iterator();
        L6:
            if (r2.hasNext() == false) goto L11;
            Map.Entry r3 = (Map.Entry) r2.next();
            Object r4 = r3.getKey();
            py.k r7 = ((IToolbarBizSkin) r3.getValue()).getSkinImg();
            if (r4 == null) goto L6;
            if (r7 == null) goto L6;
            r0.put((String) r4, new v2(r7));
        L11:
            if (r5 == false) goto L13;
            Map r8 = r6.getVertical();
        L14:
            if (r8 == null) goto L22;
            Iterator r9 = r8.entrySet().iterator();
        L17:
            if (r9.hasNext() == false) goto L22;
            Map.Entry r10 = (Map.Entry) r9.next();
            Object r11 = r10.getKey();
            py.k r12 = ((IToolbarBizSkin) r10.getValue()).getSkinImg();
            if (r11 == null) goto L17;
            if (r12 == null) goto L17;
            r0.put((String) r11, new v2(r12));
        L22:
            return r0;
        L13:
            r8 = r6.getLandscape();
            goto L14
        }

        public static SkinLoader d(int r0, Room r1, boolean r2) {
            if (r1 == null) goto L11;
            ILiveToolbarData r3 = r1.getToolbarData();
            if (r3 == null) goto L11;
            Map r4 = r3.getSkinResource();
            if (r4 == null) goto L11;
            IToolbarComponentSkin r5 = (IToolbarComponentSkin) r4.get(Integer.valueOf(r0));
            if (r5 == null) goto L11;
            HashMap r6 = a(r2, r5);
        L13:
            return new SkinLoader(r6);
        L11:
            r6 = null;
            goto L13
        }
    }

    static {
        c = new a();
        b = new ArrayList();
    }

    public SkinLoader(Map<String, v2> r1) {
        this.a = r1;
    }

    public static z2 a(v2 r3) {
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.a;
    L6:
        boolean r1 = r4 instanceof String;
        if (r1 == false) goto L18;
        py.k r2 = vh7.f.c(py.k.class);
        if (r1 == false) goto L12;
        r0 = r4;
    L12:
        String r5 = (String) r0;
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r2.setUrls(CollectionsKt.listOf(r5));
        Unit r6 = Unit.INSTANCE;
        return new q2(r2);
    L18:
        if ((r4 instanceof py.k) == false) goto L22;
        return new q2((py.k) r4);
    L22:
        if ((r4 instanceof Integer) == false) goto L26;
        return new t1(r4);
    L26:
        if ((r4 instanceof Drawable) == true) goto L28;
        return null;
    L28:
        return new t1(r4);
    L5:
        r4 = null;
        goto L6
    }

    public final String b(x2 r4) {
        Intrinsics.checkNotNullParameter(r4, "resKey");
        Map<String, v2> r0 = this.a;
        if (r0 == null) goto L8;
        v2 r1 = r0.get(r4.a.getKey());
        if (r1 == null) goto L8;
        Object r2 = r1.a;
        if (r2 == null) goto L8;
    L13:
        if ((r2 instanceof String) == false) goto L16;
        return (String) r2;
    L16:
        if ((r2 instanceof py.k) == true) goto L18;
        return null;
    L18:
        return (String) CollectionsKt.getOrNull(((py.k) r2).getUrls(), 0);
    L8:
        v2 r5 = r4.b;
        if (r5 == null) goto L11;
        r2 = r5.a;
        goto L13
    L11:
        r2 = null;
        goto L13
    }

    public final void c(x2 r5, View r6, a4 r7) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "view");
        if (r6.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        r7.b(SkinLoadResultType.ERROR, "warn:view is invisible");
    L8:
        ArrayList<v2> r1 = new ArrayList();
        Map<String, v2> r2 = this.a;
        if (r2 == null) goto L13;
        v2 r3 = r2.get(r5.a.getKey());
        if (r3 == null) goto L13;
        r1.add(r3);
    L13:
        v2 r8 = r5.b;
        if (r8 == null) goto L16;
        r1.add(r8);
    L16:
        d(r1, 0, r6, r7);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void d(ArrayList<v2> r9, int r10, View r11, a4 r12) {
        if (r10 < r9.size()) goto L7;
        if (r12 == null) goto L14;
        r12.b(SkinLoadResultType.ERROR, "all_data_failed");
        return;
    L14:
        return;
    L7:
        z2 r0 = a((v2) ListProtector.get(r9, r10));
        b4.a(r0, SkinLoader$loopLoadImg$1.INSTANCE);
        if (r0 == null) goto L15;
        Disposable r13 = r0.b(r11, new SkinLoader$loopLoadImg$2(this, r12, r10, r9, r11));
        if (r13 == null) goto L16;
        if (r12 == null) goto L17;
        r12.a(r13);
        return;
    L17:
        return;
    L16:
        return;
    }
}
