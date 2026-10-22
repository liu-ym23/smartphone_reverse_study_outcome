package com.larus.bmhome.chat.nestedmenu.provider.officetask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import bs8.e;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.bmhome.taskskill.service.d;
import com.larus.platform.service.p1;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import di8.o0;
import di8.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import v19.c7;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class OfficeTaskNestedMenuProvider implements ei8.c, ei8.b {
    public static final /* synthetic */ int f = 0;
    public final Lazy a;
    public final CoroutineScope b;
    public Job c;
    public e d;
    public final c e;

    public static final class a {
    }

    public static final class b extends ReplacementSpan {
        public final int a;
        public final int b;
        public final int c;

        public b(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            return this.b + (this.c * 2);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r9, "paint");
            int r10 = r9.getColor();
            r9.setColor(this.a);
            float r11 = this.b / 2.0f;
            r1.drawCircle((r5 + this.c) + r11, (r6 + r8) / 2.0f, r11, r9);
            r9.setColor(r10);
        }
    }

    static {
    }

    @Override // ei8.c
    public final String getKey() {
        return "office_task";
    }

    public final d g() {
        return (d) this.a.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.bmhome.chat.nestedmenu.provider.officetask.c] */
    public OfficeTaskNestedMenuProvider() {
        this.a = LazyKt.lazy(new com.larus.bmhome.chat.nestedmenu.provider.officetask.b());
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.e = new c(this);
    }

    public static String i(d0 r3) {
        f0 r0 = r3.c();
        String r2 = null;
        if ((r0 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L5;
        com.larus.bmhome.chat.nestedmenu.b r1 = (com.larus.bmhome.chat.nestedmenu.b) r0;
    L6:
        if (r1 == null) goto L18;
        com.larus.bmhome.chat.nestedmenu.b.a r4 = r1.c;
        if (r4 == null) goto L18;
        t0 r5 = r4.a;
        if (r5 == null) goto L18;
        String r6 = r5.b;
        if (r6 == null) goto L18;
        if ((!StringsKt.isBlank(r6)) == false) goto L16;
        r2 = r6;
    L16:
        if (r2 == null) goto L18;
        return r2;
    L18:
        String r7 = r3.getCenter().a;
        if (r7 != null) goto L22;
        return "";
    L22:
        return r7;
    L5:
        r1 = null;
        goto L6
    }

    public static String h(Context r2, int r3) {
        return "res://" + r2.getPackageName() + '/' + r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r50, c0 r51) {
        Intrinsics.checkNotNullParameter(r50, "models");
        Intrinsics.checkNotNullParameter(r51, "config");
        if (r51.a != NestedMenuScene.ACTION_BAR) goto L7;
        if (r51.g.a == true) goto L7;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return r50;
    L12:
        boolean r14 = TaskModeService.a.a();
        if (r14 == false) goto L15;
    L17:
        if (r14 == false) goto L22;
        e r1 = g().b();
        if (r1 != null) goto L21;
        r1 = this.d;
    L21:
        e r8 = r1;
    L23:
        this.d = r8;
        if (r8 == null) goto L26;
        List r2 = r8.a();
    L27:
        if (r2 != null) goto L29;
        r2 = CollectionsKt.emptyList();
    L29:
        List r16 = r2;
        String r3 = "mode";
        List<d0> r4 = r50.get("mode");
        if (r4 != null) goto L32;
        r4 = CollectionsKt.emptyList();
    L32:
        List<d0> r5 = r4;
        if ((r5 instanceof Collection) == true) goto L35;
    L37:
        Iterator r6 = r5.iterator();
    L39:
        if (r6.hasNext() == false) goto L58;
        f0 r7 = ((d0) r6.next()).c();
        if ((r7 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L43;
        com.larus.bmhome.chat.nestedmenu.b r9 = (com.larus.bmhome.chat.nestedmenu.b) r7;
    L44:
        if (r9 == null) goto L55;
        com.larus.bmhome.chat.nestedmenu.b.a r10 = r9.c;
        if (r10 == null) goto L55;
        t0 r11 = r10.a;
        if (r11 == null) goto L55;
        Integer r12 = r11.j;
        int r13 = AgentMode.MOA.getValue();
        if (r12 == null) goto L55;
        if (r12.intValue() != r13) goto L55;
        boolean r15 = true;
    L56:
        if (r15 == false) goto L39;
        boolean r17 = true;
    L59:
        if (r17 == true) goto L62;
        r3 = "model";
    L62:
        String r18 = r3;
        List<d0> r19 = r50.get(r18);
        if (r19 != null) goto L65;
        r19 = CollectionsKt.emptyList();
    L65:
        List<d0> r110 = r19;
        Iterator r20 = r110.iterator();
    L67:
        if (r20.hasNext() == false) goto L112;
        Object r21 = r20.next();
        f0 r22 = ((d0) r21).c();
        if ((r22 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L71;
        com.larus.bmhome.chat.nestedmenu.b r23 = (com.larus.bmhome.chat.nestedmenu.b) r22;
    L72:
        if (r23 == null) goto L83;
        com.larus.bmhome.chat.nestedmenu.b.a r24 = r23.c;
        if (r24 == null) goto L83;
        t0 r25 = r24.a;
        if (r25 == null) goto L83;
        Integer r26 = r25.j;
        int r27 = AgentMode.MOA.getValue();
        if (r26 == null) goto L83;
        if (r26.intValue() != r27) goto L83;
        boolean r28 = true;
    L84:
        if (r28 == true) goto L109;
        if (r23 == null) goto L96;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r29 = r23.a;
        if (r29 == null) goto L96;
        b2 r30 = r29.a;
        if (r30 == null) goto L96;
        Integer r31 = r30.l;
        int r32 = AgentMode.MOA.getValue();
        if (r31 == null) goto L96;
        if (r31.intValue() != r32) goto L96;
        boolean r33 = true;
    L97:
        if (r33 == true) goto L109;
        if (r23 == null) goto L104;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r34 = r23.a;
        if (r34 == null) goto L104;
        b2 r35 = r34.a;
        if (r35 == null) goto L104;
        String r36 = r35.s;
    L106:
        if (Intrinsics.areEqual(r36, "3") == true) goto L109;
        boolean r37 = false;
    L110:
        if (r37 == false) goto L67;
    L113:
        d0 r38 = (d0) r21;
        if (r38 != null) goto L116;
        return r50;
    L116:
        Context r39 = r51.c.getContext();
        String r40 = i(r38);
        Intrinsics.checkNotNull(r39);
        String r111 = h(r39, 2131241906);
        String r210 = h(r39, 2131241905);
        f0 r41 = r38.c();
        if ((r41 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L119;
        com.larus.bmhome.chat.nestedmenu.b r42 = (com.larus.bmhome.chat.nestedmenu.b) r41;
    L120:
        if (r42 == null) goto L124;
        com.larus.bmhome.chat.nestedmenu.b.a r43 = r42.c;
        if (r43 == null) goto L124;
        t0 r44 = r43.a;
    L125:
        boolean r45 = h.a;
        if (h.b(r39) == false) goto L136;
        if (r44 == null) goto L132;
        g1 r46 = r44.f;
        if (r46 == null) goto L132;
        String r47 = r46.b;
        if (r47 == null) goto L132;
    L140:
        String r211 = r47;
    L142:
        o0 r48 = r51.g;
        if (r48.a == true) goto L145;
    L148:
        boolean r49 = true;
    L150:
        if (r8 == null) goto L158;
        List r52 = r8.a;
        if (r52 == null) goto L158;
        List r53 = r52;
        ArrayList r54 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));
        Iterator r112 = r53.iterator();
        ArrayList r55 = r54;
    L155:
        if (r112.hasNext() == false) goto L157;
        ArrayList r113 = r55;
        boolean r310 = r49;
        r113.add(j(this, (PcDevice) r112.next(), r39, r38.c(), r40, true, r16.size(), r111, r310));
        r55 = r113;
        r8 = r8;
        r49 = r310;
        r39 = r39;
        r38 = r38;
        r18 = r18;
        goto L155
    L157:
        boolean r311 = r49;
        Context r312 = r39;
        d0 r313 = r38;
        String r314 = r18;
        e r114 = r8;
        List r56 = r55;
    L159:
        if (r56 != null) goto L161;
        r56 = CollectionsKt.emptyList();
    L161:
        List r115 = r56;
        if (r114 == null) goto L169;
        List r57 = r114.b;
        if (r57 == null) goto L169;
        List r58 = r57;
        ?? r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r58, 10));
        Iterator r212 = r58.iterator();
    L167:
        if (r212.hasNext() == false) goto L170;
        r116.add(j(this, (PcDevice) r212.next(), r312, r313.c(), r40, false, r16.size(), r111, r311));
    L170:
        if (r116 != 0) goto L172;
        r116 = CollectionsKt.emptyList();
    L172:
        Context r59 = r312;
        String r60 = r59.getString(2131908129);
        if (r14 == false) goto L188;
        if (r114 == null) goto L176;
        List r61 = r114.a();
    L177:
        List r62 = r61;
        if (r62 != null) goto L180;
    L183:
        boolean r63 = true;
    L184:
        if (r63 == false) goto L188;
        if (p1.a.g() == false) goto L188;
        String r64 = r40;
        com.larus.bmhome.chat.nestedmenu.d r65 = new com.larus.bmhome.chat.nestedmenu.d(new g0(2131241515, null, null, false, null, 62), new b0(null, f(r59, r64, r60, false, true), null, null, null, null, null, null, null, null, 32764), null, false, null, false, null, new p0(r313.c(), false, null, null, null, null, true, 62), false, false, false, 1916);
    L189:
        ArrayList r66 = new ArrayList();
        Iterator r67 = r110.iterator();
    L191:
        if (r67.hasNext() == false) goto L212;
        d0 r68 = (d0) r67.next();
        d0 r69 = r313;
        if (r68 == r69) goto L195;
        boolean r70 = r311;
        List r71 = CollectionsKt.listOf(r68);
    L211:
        CollectionsKt.addAll(r66, r71);
        r313 = r69;
        r311 = r70;
        goto L191
    L195:
        if (r51.g.d == false) goto L197;
    L208:
        r70 = r311;
        d0 r72 = new com.larus.bmhome.chat.nestedmenu.d(new g0(2131241269, null, null, false, null, 62), new b0(null, f(r59, r64, r59.getString(2131908244), true, r70), null, null, null, null, null, null, null, null, 32764), null, false, null, false, null, new p0(r69.c(), true, null, r59.getString(2131908244), r64, r210, false, 64), false, false, false, 1916);
    L209:
        r71 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(r115, CollectionsKt.listOfNotNull(r65)), r72), (Iterable) r116);
        goto L211
    L197:
        if ((!r16.isEmpty()) == true) goto L208;
        if (r65 != null) goto L208;
        if ((r69 instanceof com.larus.bmhome.chat.nestedmenu.d) == false) goto L203;
        com.larus.bmhome.chat.nestedmenu.d r73 = (com.larus.bmhome.chat.nestedmenu.d) r69;
    L204:
        if (r73 == null) goto L206;
        r72 = com.larus.bmhome.chat.nestedmenu.d.e(r73, new p0(((com.larus.bmhome.chat.nestedmenu.d) r69).h, false, null, r64, r64, r211, false, 64));
    L207:
        r70 = r311;
        goto L209
    L206:
        r72 = r69;
        goto L207
    L203:
        r73 = null;
        goto L204
    L212:
        r50.put(r314, r66);
        return r50;
    L180:
        if (r62.isEmpty() == true) goto L183;
        r63 = false;
        goto L184
    L176:
        r61 = null;
    L188:
        r64 = r40;
        r65 = null;
    L169:
        r116 = 0;
    L158:
        r311 = r49;
        r312 = r39;
        r313 = r38;
        r314 = r18;
        r114 = r8;
        r56 = null;
        goto L159
    L145:
        if (r48.d == true) goto L148;
        r49 = false;
    L132:
        if (r44 == null) goto L141;
        g1 r74 = r44.e;
        if (r74 == null) goto L141;
        r47 = r74.b;
    L141:
        r211 = null;
        goto L142
    L136:
        if (r44 == null) goto L141;
        g1 r75 = r44.e;
        if (r75 == null) goto L141;
        r47 = r75.b;
    L124:
        r44 = null;
        goto L125
    L119:
        r42 = null;
    L104:
        r36 = null;
    L96:
        r33 = false;
    L109:
        r37 = true;
    L83:
        r28 = false;
        goto L84
    L71:
        r23 = null;
        goto L72
    L112:
        r21 = null;
    L55:
        r15 = false;
        goto L56
    L43:
        r9 = null;
    L58:
        r17 = false;
        goto L59
    L35:
        if (r5.isEmpty() == false) goto L37;
    L26:
        r2 = null;
        goto L27
    L22:
        r8 = null;
        goto L23
    L15:
        if (r51.g.d == true) goto L17;
        return r50;
    L7:
        if (r51.g.d == true) goto L8;
        r0 = false;
        goto L10
    }

    @Override // ei8.b
    public final void b(LinkedHashMap<String, List<d0>> r8, c0 r9) {
        Intrinsics.checkNotNullParameter(r8, "models");
        Intrinsics.checkNotNullParameter(r9, "config");
        o0 r10 = r9.g;
        if (r10.a == false) goto L8;
        if (r10.d == true) goto L8;
        return;
    L8:
        if (TaskModeService.a.a() == true) goto L10;
        return;
    L10:
        g().f();
        g().d().observeForever(this.e);
        Job r11 = this.c;
        if (r11 == null) goto L13;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L13:
        this.c = BuildersKt.launch$default(this.b, null, null, new OfficeTaskNestedMenuProvider$onShow$1(this, null), 3, null);
    }

    @Override // ei8.b
    public final void c(List<? extends q> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void d(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void e(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
        o0 r4 = r3.g;
        if (r4.a == true) goto L5;
    L7:
        Job r5 = this.c;
        if (r5 == null) goto L10;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L10:
        this.c = null;
        g().d().removeObserver(this.e);
        g().e();
        return;
    L5:
        if (r4.d == true) goto L7;
    }

    public static CharSequence f(Context r1, String r2, String r3, boolean r4, boolean r5) {
        if (r5 == false) goto L4;
        if (r4 == false) goto L7;
        int r6 = 2131106552;
    L9:
        return new SpannableStringBuilder(r2).append("￼", new b(ContextCompat.getColor(r1, r6), c7.b(6), c7.b(6)), 33).append(r3);
    L7:
        r6 = 2131103143;
        goto L9
    L4:
        return r2 + ' ' + r3;
    }

    public static com.larus.bmhome.chat.nestedmenu.d j(OfficeTaskNestedMenuProvider r43, PcDevice r44, Context r45, f0 r46, String r47, boolean r48, int r49, String r50, boolean r51) {
        r43.getClass();
        String r1 = r44.d();
        boolean r10 = true;
        if (r1 != null) goto L5;
    L9:
        r1 = r44.getDeviceId();
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        String r5 = r1;
        g0 r18 = new g0(2131241515, null, null, false, null, 62);
        CharSequence r27 = f(r45, r47, r5, r48, r51);
        String r6 = r44.b();
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L36;
        List r8 = p1.a.k();
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L36;
        boolean r11 = h.a;
        if (h.b(r45) == false) goto L31;
        String r2 = r44.i();
    L32:
        if (r2 == null) goto L36;
        if ((!StringsKt.isBlank(r2)) == false) goto L36;
        String r28 = r2;
    L37:
        b0 r13 = new b0(null, r27, r28, null, null, null, null, null, null, null, 32760);
        NestedMenuRightModel r14 = new NestedMenuRightModel(null, null, null, null, 1023);
        if (r49 != 1) goto L40;
        String r12 = r47;
    L41:
        p0 r20 = new p0(r46, false, r44, r5, r12, r50, false, 64);
        if (r48 == true) goto L48;
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L48;
        r10 = false;
    L48:
        return new com.larus.bmhome.chat.nestedmenu.d(r18, r13, r14, false, null, false, null, r20, r10, false, false, 1656);
    L40:
        r12 = r5;
        goto L41
    L31:
        r2 = r44.h();
        goto L32
    L23:
        if (r8.contains(r44.b()) != true) goto L25;
        r9 = true;
    L36:
        r28 = null;
        goto L37
    L15:
        if (StringsKt.isBlank(r6) == true) goto L18;
        r7 = false;
        goto L19
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 != null) goto L12;
        goto L9
    }
}
