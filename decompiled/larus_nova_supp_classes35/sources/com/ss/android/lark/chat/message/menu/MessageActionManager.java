package com.ss.android.lark.chat.message.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.h;
import yya.i;
import yya.k;
import yya.l;
import yya.m;
import yya.p;
import yya.q;
import yya.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageActionManager {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a<T> implements Comparator {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((yya.e) r2).getType().ordinal() - ((yya.e) r1).getType().ordinal();
        }
    }

    public static final class b implements zya.d {
        public final /* synthetic */ i a;
        public final /* synthetic */ com.ss.android.lark.chat.message.menu.b b;
        public final /* synthetic */ List<yya.e> c;
        public final /* synthetic */ yya.a d;

        public final boolean a() {
            List<yya.e> r0 = this.c;
            i r1 = this.a;
            yya.a r2 = this.d;
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            yya.e r4 = (yya.e) r3.next();
            if (r4.b(r1.getType(), r2) == false) goto L4;
            Log.i("MessageActionManager", r1.getType().name() + " is disabled by " + r4.getType().name());
            return true;
        L9:
            return false;
        }

        public final void onHide() {
            this.a.onHide();
        }

        public final void onShow() {
            this.a.onShow();
        }

        public final boolean c(boolean r6) {
            List<yya.e> r0 = this.c;
            i r1 = this.a;
            yya.a r2 = this.d;
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            yya.e r4 = (yya.e) r3.next();
            if (r4.c(r1.getType(), r2, r6) == false) goto L4;
            Log.i("MessageActionManager", r1.getType().name() + "'s click event is intercepted by " + r4.getType().name());
            return true;
        L9:
            return false;
        }

        public final void d(a6b.a.b r3) {
            Intrinsics.checkNotNullParameter(r3, "itemControl");
            this.a.d(new c(r3));
        }

        public final void b(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.b(r2, r3);
            this.b.a(this.a, r3);
        }

        public b(i r1, com.ss.android.lark.chat.message.menu.b r2, List<? extends yya.e> r3, yya.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        a = LazyKt.lazy(r0, MessageActionManager$actionProviders$2.INSTANCE);
        b = LazyKt.lazy(r0, MessageActionManager$actionInterceptors$2.INSTANCE);
    }

    public static List d(yya.a r5) {
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        Log.i("MessageActionManager", "getInterceptors for page: " + r5.r().name());
        Message.Type r0 = r5.l();
        Log.i("MessageActionManager", "message type is " + r0.name());
        PageType r6 = r5.r();
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((CopyOnWriteArrayList) b.getValue()).iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        r r3 = (l) r2.next();
        if ((r3 instanceof p) == true) goto L8;
        if ((r3 instanceof r) == true) goto L13;
        if ((r3 instanceof yya.e) == false) goto L4;
        r1.add(r3);
        goto L4
    L13:
        if (r3.getPageType() != r6) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (((p) r3).getMessageType() != r0) goto L4;
        r1.add(r3);
        goto L4
    L18:
        return r1;
    }

    public static void b(int r4, List r5) {
        Intrinsics.checkNotNullParameter(r5, "groupActionVOList");
        if (r4 != 1) goto L9;
        if (((ArrayList) r5).size() != 1) goto L18;
        ((zya.e) ListProtector.get(r5, 0)).b(3);
        return;
    L18:
        return;
    L9:
        if (r4 != 2) goto L11;
        return;
    L11:
        int r6 = ((ArrayList) r5).size();
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        ((zya.e) ListProtector.get(r5, 0)).b(0);
        ((zya.e) CollectionsKt.last(r5)).b(2);
        return;
    L15:
        ((zya.e) ListProtector.get(r5, 0)).b(3);
        return;
    L16:
        Log.w("MessageActionManager", "wrong action list size: 0");
    }

    public static boolean f(yya.a r4, List r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r1 = r6.next();
        if ((r1 instanceof h) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == true) goto L19;
        Iterator r7 = r0.iterator();
    L13:
        if (r7.hasNext() == false) goto L19;
        h r2 = (h) r7.next();
        boolean r3 = r2.d(r4);
        if (r3 == false) goto L17;
        Log.i("MessageActionManager", "menu is intercepted by " + r2.getTAG() + ", msgId=" + r4.m().getId() + ", page=" + r4.r().name());
    L17:
        if (r3 == false) goto L13;
        return true;
    L19:
        return false;
    }

    public static d a(yya.a r27, List r28, com.ss.android.lark.chat.message.menu.b r29) {
        Intrinsics.checkNotNullParameter(r27, "actionContext");
        Intrinsics.checkNotNullParameter(r28, "messageActionGroups");
        Intrinsics.checkNotNullParameter(r29, "extraClickListener");
        List r1 = d(r27);
        Intrinsics.checkNotNullParameter(r27, "actionContext");
        Intrinsics.checkNotNullParameter(r1, "interceptors");
        if ((!f(r27, r1)) == true) goto L5;
        Log.i("MessageActionManager", "skip provider evaluation for unsupported message, msgId=" + r27.m().getId() + ", page=" + r27.r().name());
        Triple r0 = new Triple(new ArrayList(), new LinkedHashMap(), new LinkedHashMap());
    L49:
        List r2 = (List) r0.component1();
        Map r13 = (Map) r0.component2();
        Map r14 = (Map) r0.component3();
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) b.getValue();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L51:
        if (r5.hasNext() == false) goto L56;
        Object r6 = r5.next();
        if ((r6 instanceof yya.c) == false) goto L51;
        r4.add(r6);
        goto L51
    L56:
        if (r4.isEmpty() == true) goto L64;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r27.b = r13;
        Iterator r7 = r2.iterator();
    L60:
        if (r7.hasNext() == false) goto L64;
        i r8 = (i) r7.next();
        if (e(r8, r27, r4) == false) goto L60;
        r7.remove();
        r13.remove(r8.getType());
        r14.remove(r8.getType());
    L64:
        ArrayList r15 = new ArrayList();
        LinkedHashMap r9 = new LinkedHashMap();
        Context r16 = r27.getContext();
        ArrayList r10 = new ArrayList();
        Iterator r11 = ((ArrayList) r1).iterator();
    L66:
        if (r11.hasNext() == false) goto L70;
        Object r12 = r11.next();
        if ((r12 instanceof yya.e) == false) goto L66;
        r10.add(r12);
        goto L66
    L70:
        List r17 = CollectionsKt.sortedWith(r10, a.a);
        Iterator r18 = r28.iterator();
        int r19 = 0;
    L72:
        if (r18.hasNext() == false) goto L125;
        Object r20 = r18.next();
        int r110 = r19 + 1;
        if (r19 >= 0) goto L76;
        CollectionsKt.throwIndexOverflow();
    L76:
        k r21 = (k) r20;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.b.iterator();
    L78:
        if (r23.hasNext() == false) goto L118;
        MessageActionType r24 = (MessageActionType) r23.next();
        List r25 = (List) r13.get(r24);
        List r26 = r25;
        if (r26 != null) goto L82;
    L85:
        boolean r30 = true;
    L86:
        if (r30 == true) goto L117;
        Iterator r210 = r25.iterator();
    L89:
        if (r210.hasNext() == false) goto L117;
        i r211 = (i) r210.next();
        int r31 = r21.c;
        Map r32 = r21.d;
        if (r32 == null) goto L93;
        List r33 = (List) r32.get(r211.getType());
    L94:
        MessageActionType r212 = r24;
        ArrayList r213 = r22;
        k r111 = r21;
        int r214 = r19;
        LinkedHashMap r34 = r9;
        zya.b r35 = c(r211, null, r27, r16, r17, r29, r31, r13, r33);
        Map r36 = r111.d;
        if (r36 == null) goto L101;
        List r37 = (List) r36.get(r211.getType());
        if (r37 == null) goto L101;
        if ((!r37.isEmpty()) != true) goto L101;
        boolean r38 = true;
    L102:
        if (r38 == false) goto L112;
        List r39 = r35.k;
        if (r39 != null) goto L106;
    L109:
        boolean r40 = true;
    L110:
        if (r40 == false) goto L112;
        MessageActionType r41 = r212;
        ArrayList r42 = r213;
    L116:
        r22 = r42;
        r24 = r41;
        r9 = r34;
        r21 = r111;
        r19 = r214;
        goto L89
    L106:
        if (r39.isEmpty() == true) goto L109;
        r40 = false;
    L112:
        r42 = r213;
        r42.add(r35);
        r41 = r212;
        Object r43 = r34.get(r41);
        if (r43 != null) goto L115;
        r43 = new ArrayList();
        r34.put(r41, r43);
    L115:
        ((List) r43).add(r35);
    L101:
        r38 = false;
        goto L102
    L93:
        r33 = null;
    L117:
        r22 = r22;
        r9 = r9;
        r21 = r21;
        r19 = r19;
        goto L78
    L82:
        if (r26.isEmpty() == true) goto L85;
        r30 = false;
        goto L86
    L118:
        ArrayList r44 = r22;
        int r215 = r19;
        LinkedHashMap r45 = r9;
        b(r21.c, r44);
        r15.addAll(r44);
        if ((!r44.isEmpty()) == false) goto L124;
        if (r215 >= CollectionsKt.getLastIndex(r28)) goto L124;
        r15.add(new zya.h(0));
    L124:
        r9 = r45;
        r19 = r110;
        goto L72
    L125:
        LinkedHashMap r46 = r9;
        if ((CollectionsKt.lastOrNull(r15) instanceof zya.h) == false) goto L129;
        CollectionsKt.removeLastOrNull(r15);
    L129:
        if (r13.get(MessageActionType.ADD_REACTION) == null) goto L131;
        boolean r47 = true;
    L133:
        return new d(r15, r46, r47, r14, r17);
    L131:
        r47 = false;
        goto L133
    L5:
        ArrayList r48 = new ArrayList();
        LinkedHashMap r49 = new LinkedHashMap();
        LinkedHashMap r50 = new LinkedHashMap();
        Iterator r51 = ((CopyOnWriteArrayList) a.getValue()).iterator();
    L7:
        if (r51.hasNext() == false) goto L48;
        q r52 = (yya.b) r51.next();
        if (r52.b().contains(r27.r()) == false) goto L10;
        if ((r52 instanceof m) == true) goto L13;
        if ((r52 instanceof q) == false) goto L47;
        Iterator r53 = r52.a().iterator();
    L31:
        if (r53.hasNext() == false) goto L7;
        i r54 = (i) r53.next();
        if (e(r54, r27, r1) == false) goto L35;
        Log.i("MessageActionManager", r54.getType().name() + " is intercepted.");
        goto L31
    L35:
        if (r54.isVisible() == false) goto L40;
        r48.add(r54);
        MessageActionType r112 = r54.getType();
        Object r113 = r49.get(r112);
        if (r113 != null) goto L39;
        r113 = new ArrayList();
        r49.put(r112, r113);
    L39:
        ((List) r113).add(r54);
    L41:
        MessageActionType r114 = r54.getType();
        Object r115 = r50.get(r114);
        if (r115 != null) goto L44;
        r115 = new ArrayList();
        r50.put(r114, r115);
    L44:
        ((List) r115).add(r54);
        goto L31
    L40:
        Log.i("MessageActionManager", r54.getType().name() + " is invisible");
        goto L41
    L47:
        throw new NoWhenBranchMatchedException();
    L13:
        i r55 = ((m) r52).c(r27);
        if (e(r55, r27, r1) == false) goto L16;
        Log.i("MessageActionManager", r55.getType().name() + " is intercepted.");
        goto L7
    L16:
        if (r55.isVisible() == false) goto L21;
        r48.add(r55);
        MessageActionType r56 = r55.getType();
        Object r57 = r49.get(r56);
        if (r57 != null) goto L20;
        r57 = new ArrayList();
        r49.put(r56, r57);
    L20:
        ((List) r57).add(r55);
    L22:
        MessageActionType r58 = r55.getType();
        Object r59 = r50.get(r58);
        if (r59 != null) goto L25;
        r59 = new ArrayList();
        r50.put(r58, r59);
    L25:
        ((List) r59).add(r55);
        goto L7
    L21:
        Log.i("MessageActionManager", r55.getType().name() + " is invisible");
        goto L22
    L10:
        Log.i("MessageActionManager", r52.getTAG() + " don't support page: " + r27.r().name() + ", continue");
        goto L7
    L48:
        r0 = new Triple(r48, r49, r50);
        goto L49
    }

    public static boolean e(i r2, yya.a r3, List r4) {
        Iterator r5 = ((ArrayList) r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        l r0 = (l) r5.next();
        if (r0.a(r2.getType(), r3) == false) goto L4;
        Log.i("MessageActionManager", r2.getType().name() + " is intercepted by " + r0.getTAG());
        return true;
    L9:
        return false;
    }

    public static zya.b c(i r29, yya.d r30, yya.a r31, Context r32, List r33, com.ss.android.lark.chat.message.menu.b r34, int r35, Map r36, List r37) {
        Intrinsics.checkNotNullParameter(r29, Keys.API_PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r31, "actionContext");
        Intrinsics.checkNotNullParameter(r32, "context");
        Intrinsics.checkNotNullParameter(r33, "featureScopeInterceptors");
        Intrinsics.checkNotNullParameter(r34, "extraClickListener");
        Intrinsics.checkNotNullParameter(r36, "messageActionsMap");
        if (r35 != 1) goto L5;
        int r16 = 5;
    L9:
        Drawable r8 = r29.getIcon(r32);
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Intrinsics.checkNotNullParameter(r32, "context");
        if (r30 != null) goto L12;
    L18:
        String r0 = r29.getLabel(r32);
    L19:
        String r7 = r0;
        Intrinsics.checkNotNullParameter(r8, "drawable");
        Intrinsics.checkNotNullParameter(r7, "label");
        boolean r18 = r29.f();
        Integer r19 = r29.e();
        boolean r20 = r29.c();
        boolean r21 = r29.isEnable();
        View r22 = r29.getView(r32);
        b r6 = new b(r29, r34, r33, r31);
        Intrinsics.checkNotNullParameter(r6, "callback");
        List r1 = r37;
        if (r1 != null) goto L22;
    L25:
        boolean r2 = true;
    L26:
        if (r2 == true) goto L28;
        ArrayList r9 = new ArrayList();
        Iterator r17 = r37.iterator();
    L31:
        if (r17.hasNext() == false) goto L45;
        yya.d r24 = (yya.d) r17.next();
        List r3 = (List) r36.get(r24.getType());
        List r4 = r3;
        if (r4 != null) goto L35;
    L38:
        boolean r5 = true;
    L39:
        if (r5 == true) goto L44;
        Iterator r25 = r3.iterator();
    L42:
        if (r25.hasNext() == false) goto L44;
        ArrayList r15 = r9;
        r15.add(c((i) r25.next(), r24, r31, r32, r33, r34, 0, r36, null));
        r9 = r15;
        r7 = r7;
        r8 = r8;
    L44:
        r9 = r9;
        r7 = r7;
        r8 = r8;
        goto L31
    L35:
        if (r4.isEmpty() == true) goto L38;
        r5 = false;
        goto L39
    L45:
        ArrayList r110 = r9;
        Drawable r28 = r8;
        b(0, r110);
        return new zya.b(r28, r18, r19, r7, r20, r21, r16, r22, r6, r110, r29);
    L28:
        return new zya.b(r8, r18, r19, r7, r20, r21, r16, r22, r6, null, r29);
    L22:
        if (r1.isEmpty() == true) goto L25;
        r2 = false;
        goto L26
    L12:
        if (r30.getType() != r29.getType()) goto L18;
        int r10 = r30.b;
        if (r10 == 0) goto L17;
        r0 = UIUtils.getString(r32, r10);
        goto L19
    L17:
        r0 = r29.getLabel(r32);
        goto L19
    L5:
        if (r35 == 2) goto L7;
        r16 = 1;
        goto L9
    L7:
        r16 = 6;
        goto L9
    }
}
