package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import am2.x;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public static final /* synthetic */ int o = 0;
    public final TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> a;
    public final TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> b;
    public final Map<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> c;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f d;
    public final List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> e;
    public final Set<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> f;
    public final int g;
    public final int h;
    public final int i;
    public boolean j;
    public final g k;
    public final ViewGroup l;
    public final HorizontalScrollView m;
    public final HorizontalScrollView n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b$b, reason: collision with other inner class name */
    public static final class C0118b<T> implements Comparator {
        public static final C0118b a = null;

        static {
            a = new C0118b();
        }

        public C0118b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            return (((InputFunctionEnum) r5).getPriority() > ((InputFunctionEnum) r4).getPriority() ? 1 : (((InputFunctionEnum) r5).getPriority() == ((InputFunctionEnum) r4).getPriority() ? 0 : -1));
        }
    }

    public static final class c<T> implements Comparator {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            return (((InputFunctionEnum) r5).getPriority() > ((InputFunctionEnum) r4).getPriority() ? 1 : (((InputFunctionEnum) r5).getPriority() == ((InputFunctionEnum) r4).getPriority() ? 0 : -1));
        }
    }

    static {
    }

    public final void a() {
        TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r2 = r0.entrySet().iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L10;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r4 = r2.next();
        if (r4.getValue().n() != 2) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.put(r4.getKey(), r4.getValue());
        goto L3
    L10:
        Iterator r5 = r1.entrySet().iterator();
        boolean r6 = false;
    L12:
        if (r5.hasNext() == false) goto L16;
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r5.next()).getValue()).i() == false) goto L12;
        r6 = true;
        goto L12
    L16:
        TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r7 = this.b;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r9 = r7.entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L25;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r10 = r9.next();
        if (r10.getValue().n() != 2) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L18;
        r8.put(r10.getKey(), r10.getValue());
        goto L18
    L22:
        r11 = false;
        goto L23
    L25:
        Iterator r13 = r8.entrySet().iterator();
    L27:
        if (r13.hasNext() == false) goto L31;
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r13.next()).getValue()).i() == false) goto L27;
        r6 = true;
        goto L27
    L31:
        Iterator r14 = ((LinkedHashMap) this.c).entrySet().iterator();
    L33:
        if (r14.hasNext() == false) goto L37;
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r14.next()).getValue()).canShowRedDot() == false) goto L33;
        r6 = true;
        goto L33
    L37:
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r15 = this.d;
        if (r15 == null) goto L66;
        r15.u(r6, true);
        return;
    }

    public final int b() {
        return this.b.size() + this.a.size();
    }

    public final int c(InputFunctionEnum r4) {
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r1 = r0.next();
        if (r1.getKey() != r4) goto L4;
        return r1.getValue().n();
    L9:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r2 = this.b.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r3 = r2.next();
        if (r3.getKey() != r4) goto L11;
        return r3.getValue().n();
    L16:
        return 1;
    }

    public final void d(com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c r11) {
        Intrinsics.checkNotNullParameter(r11, "behavior");
        int r0 = com.bytedance.android.livesdk.interactivity.comment.newinput.framework.c.a[r11.b().ordinal()];
        if (r0 != 1) goto L5;
        this.b.put(r11.f, r11);
        View r1 = r11.getView();
        if (r1 == null) goto L53;
        r1.setOnClickListener(this);
    L53:
        r11.r(this.k);
        return;
    L5:
        if (r0 != 2) goto L7;
        InputFunctionEnum r3 = null;
        if ((r11 instanceof com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f) == true) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c r2 = null;
    L16:
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r4 = (com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f) r2;
        this.d = r4;
        if (r4 == null) goto L19;
        InputFunctionManager$registerBehavior$1 r5 = new InputFunctionManager$registerBehavior$1(this);
        Intrinsics.checkNotNullParameter(r5, "action");
        r4.n = r5;
    L19:
        View r6 = r11.getView();
        if (r6 == null) goto L22;
        r6.setOnClickListener(this);
    L22:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r7 = this.k.V();
        if (r7 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r8 = r7.g;
        if (r8 == null) goto L44;
        String r9 = r8.p;
        if (r9 == null) goto L44;
        InputFunctionEnum.Companion.getClass();
        if (r9.length() != 0) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == true) goto L40;
        InputFunctionEnum[] r13 = InputFunctionEnum.values();
        int r14 = r13.length;
        int r15 = 0;
    L35:
        if (r15 >= r14) goto L40;
        InputFunctionEnum r16 = r13[r15];
        if (Intrinsics.areEqual(r16.getLogValue(), r9) == true) goto L38;
        r15 = r15 + 1;
        goto L35
    L38:
        r3 = r16;
    L40:
        if (r3 == null) goto L44;
        if (c(r3) != 2) goto L44;
        boolean r17 = true;
    L45:
        HashMap r18 = new HashMap();
        r18.put("screen_type", "portrait");
        if (r17 == false) goto L48;
        String r19 = "on";
    L49:
        r18.put("extend_mode", r19);
        j0.l().sendLog("livesdk_comment_expansion_module_extend_show", r18, new Object[]{IRoom.class, x.class});
        goto L53
    L48:
        r19 = "off";
        goto L49
    L31:
        r10 = false;
    L44:
        r17 = false;
        goto L45
    L15:
        r2 = r11;
        goto L16
    L7:
        if (r0 == 3) goto L11;
        this.a.put(r11.f, r11);
        View r20 = r11.getView();
        if (r20 == null) goto L53;
        r20.setOnClickListener(this);
        goto L53
    L11:
        this.c.put(r11.f, r11);
        goto L53
    }

    public final void e(boolean r11) {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.f.size();
        List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r2 = this.e;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((true ^ this.f.contains((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r5)) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r3.iterator();
    L9:
        boolean r8 = false;
        if (r7.hasNext() == false) goto L19;
        Object r9 = r7.next();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r10 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r9;
        if (r11 == false) goto L15;
    L13:
        r8 = true;
    L17:
        if (r8 == false) goto L9;
        r6.add(r9);
        goto L9
    L15:
        if (r10.n() != 1) goto L17;
    L19:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r6.iterator();
    L21:
        if (r14.hasNext() == false) goto L28;
        Object r15 = r14.next();
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r15).q() == InputFunctionEnum.ChatInputCarrier_Audio) goto L25;
        boolean r16 = true;
    L26:
        if (r16 == false) goto L21;
        r13.add(r15);
        goto L21
    L25:
        r16 = false;
        goto L26
    L28:
        Iterator r17 = r13.iterator();
    L30:
        if (r17.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r18 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r17.next();
        r0.append("|");
        r0.append(r18.q().getLogValue());
        this.f.add(r18);
        goto L30
    L32:
        List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r19 = this.e;
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L34:
        if (r21.hasNext() == false) goto L38;
        Object r23 = r21.next();
        if ((!this.f.contains((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r23)) == false) goto L34;
        r20.add(r23);
        goto L34
    L38:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r20.iterator();
    L40:
        if (r25.hasNext() == false) goto L47;
        Object r26 = r25.next();
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r26).q() != InputFunctionEnum.ChatInputCarrier_Audio) goto L44;
        boolean r27 = true;
    L45:
        if (r27 == false) goto L40;
        r24.add(r26);
        goto L40
    L44:
        r27 = false;
        goto L45
    L47:
        Iterator r28 = r24.iterator();
    L49:
        if (r28.hasNext() == false) goto L56;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r29 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r28.next();
        r0.append("|");
        if (this.k.f() != 0) goto L53;
        String r30 = "voice";
    L54:
        r0.append(r30);
        this.f.add(r29);
        goto L49
    L53:
        r30 = "voice_to_text";
        goto L54
    L56:
        if (this.f.size() != r1) goto L59;
        return;
    L59:
        if (r0.length() <= 0) goto L61;
        boolean r31 = true;
    L62:
        if (r31 == false) goto L64;
        r0.deleteCharAt(0);
    L64:
        StringBuilder r33 = new StringBuilder();
        List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r34 = this.e;
        ArrayList r35 = new ArrayList();
        Iterator<T> r36 = r34.iterator();
    L66:
        if (r36.hasNext() == false) goto L76;
        Object r37 = r36.next();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r38 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r37;
        if (r11 == false) goto L71;
    L69:
        boolean r39 = true;
    L74:
        if (r39 == false) goto L66;
        r35.add(r37);
        goto L66
    L71:
        if (r38.n() == 1) goto L69;
        r39 = false;
        goto L74
    L76:
        Iterator r40 = r35.iterator();
    L78:
        if (r40.hasNext() == false) goto L83;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r41 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r40.next();
        if (r41.i() == false) goto L78;
        r33.append("|");
        r33.append(r41.q().getLogValue());
        goto L78
    L83:
        if (r33.length() <= 0) goto L85;
        boolean r43 = true;
    L86:
        if (r43 == false) goto L88;
        r33.deleteCharAt(0);
    L88:
        HashMap r44 = new HashMap();
        r44.put("show_icon", r0.toString());
        if (r11 == false) goto L91;
        String r110 = "on";
    L92:
        r44.put("extend_mode", r110);
        r44.put("screen_type", "portrait");
        r44.put("is_red_dot", r33.toString());
        IInteractivityInjectService r111 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r111 == null) goto L95;
        r111.buildVsRoomLog(null, r44);
    L95:
        j0.l().sendLog("livesdk_comment_expansion_module_show", r44, new Object[]{IRoom.class, x.class});
        return;
    L91:
        r110 = "off";
        goto L92
    L85:
        r43 = false;
        goto L86
    L61:
        r31 = false;
        goto L62
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r0 = this.a.entrySet().iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L12;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r1 = r0.next();
        if (r6 == null) goto L9;
        r2 = r6.getTag();
    L9:
        if (r2 != r1.getKey()) goto L3;
        r1.getValue().t(r6, this.k);
        return;
    L12:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r3 = this.b.entrySet().iterator();
    L14:
        if (r3.hasNext() == false) goto L23;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r4 = r3.next();
        if (r6 == null) goto L18;
        Object r5 = r6.getTag();
    L20:
        if (r5 != r4.getKey()) goto L14;
        r4.getValue().t(r6, this.k);
        return;
    L18:
        r5 = null;
        goto L20
    L23:
        Iterator r7 = ((LinkedHashMap) this.c).entrySet().iterator();
    L25:
        if (r7.hasNext() == false) goto L33;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (r6 == null) goto L29;
        Object r9 = r6.getTag();
    L31:
        if (r9 != ((InputFunctionEnum) r8.getKey())) goto L25;
        ((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r8.getValue()).t(r6, this.k);
        goto L25
    L29:
        r9 = null;
        goto L31
    L33:
        if (r6 == null) goto L36;
        r2 = r6.getTag();
    L36:
        if (r2 != InputFunctionEnum.ChatInputCarrier_Fold) goto L52;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r10 = this.d;
        if (r10 == null) goto L53;
        r10.t(r6, this.k);
        return;
    L53:
        return;
    }

    public b(g r2, ViewGroup r3, HorizontalScrollView r4, HorizontalScrollView r5) {
        Intrinsics.checkNotNullParameter(r2, "inputPanelBridges");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "rightScrollContainer");
        Intrinsics.checkNotNullParameter(r5, "leftScrollContainer");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.a = new TreeMap(C0118b.a);
        this.b = new TreeMap(c.a);
        this.c = new LinkedHashMap();
        this.e = new ArrayList();
        this.f = new LinkedHashSet();
        int r6 = s1.k(2131168801);
        this.g = r6;
        this.h = s1.y() - r6;
        this.i = UtilityKotlinExtentionsKt.i(4);
    }
}
