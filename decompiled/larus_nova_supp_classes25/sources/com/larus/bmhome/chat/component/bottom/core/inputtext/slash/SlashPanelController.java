package com.larus.bmhome.chat.component.bottom.core.inputtext.slash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypePanelTrigger;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillSearchIndex;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SlashPanelContent;
import com.larus.bmhome.chat.component.bottom.core.inputtext.a1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.b1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.c1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.d0;
import com.larus.bmhome.chat.component.bottom.core.inputtext.d1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.q1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.s1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.z0;
import com.larus.bmhome.taskskill.b2;
import com.larus.bmhome.taskskill.model.SkillType;
import com.larus.common.apphost.AppHost;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.IContextWindowUsageService;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import t19.s;
import tx9.q3;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SlashPanelController {
    public boolean A;
    public Job B;
    public long C;
    public Job D;
    public View E;
    public boolean F;
    public long G;
    public boolean H;
    public final ChatInputWithMentionDelegate a;
    public final CoroutineScope b;
    public final Fragment c;
    public final r d;
    public final Function0<be8.a> e;
    public final Function0<Boolean> f;
    public final Function0<Boolean> g;
    public final Function1<k1, Boolean> h;
    public final Function0<Boolean> i;
    public final Function0<Unit> j;
    public final Function0<Boolean> k;
    public final Set<SlashPanelContent> l;
    public final Function0<Boolean> m;
    public final Function1<Boolean, Unit> n;
    public final Function0<Unit> o;
    public final Function1<k1, Boolean> p;
    public final Function0<Unit> q;
    public final Context r;
    public final SkillPanelSearch s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public boolean w;
    public k1 x;
    public List<be8.b> y;
    public boolean z;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final boolean e;
        public final int f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            int r9 = (r7 + r2) * 31;
            if (this.e == false) goto L17;
            int r10 = 1231;
        L19:
            return ((r9 + r10) * 31) + this.f;
        L17:
            r10 = 1237;
            goto L19
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "OptionTrace(optionLabel=" + this.a + ", optionSubLabel=" + this.b + ", skillOptionId=" + this.c + ", skillTab=" + this.d + ", isSearchResult=" + this.e + ", position=" + this.f + ')';
        }

        public /* synthetic */ b(String r8, int r9) {
            this(r8, null, null, null, false, r9);
        }

        public b(String r2, String r3, String r4, String r5, boolean r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "optionLabel");
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

    public final void d() {
        this.w = false;
        this.s.a();
        View r1 = this.E;
        if (r1 == null) goto L5;
        com.larus.bmhome.view.screenmenu.d.b(r1);
    L5:
        this.E = null;
        this.d.e.i(false);
        this.F = false;
        this.G = 0;
        ExposeXTrackerExtKt.a(this.r, "slash_panel_option:");
        this.C++;
        Job r2 = this.B;
        if (r2 == null) goto L8;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L8:
        this.B = null;
        this.z = false;
        this.x = null;
        this.A = false;
    }

    public final boolean c() {
        k1 r0 = this.x;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (((Boolean) this.p.invoke(r0)).booleanValue() == true) goto L8;
        return false;
    L8:
        d();
        return true;
    }

    public final boolean e() {
        if (((Boolean) this.f.invoke()).booleanValue() == false) goto L6;
        return true;
    L6:
        s r1 = s.a;
        Context r2 = this.r;
        s.j(r1, r2, r2.getString(2131900187), null, false, 28);
        return false;
    }

    public final boolean k() {
        if (this.w == false) goto L11;
        k1 r0 = this.x;
        if (r0 == null) goto L7;
        MultiTypePanelTrigger r1 = r0.d;
    L9:
        if (r1 != MultiTypePanelTrigger.SLASH) goto L11;
        return true;
    L7:
        r1 = null;
    L11:
        return false;
    }

    public final String b(b r10) {
        Object[] r0 = new Object[8];
        r0[0] = "slash_panel_option";
        r0[1] = Long.valueOf(this.G);
        r0[2] = r10.a;
        String r1 = r10.b;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[3] = r1;
        String r3 = r10.c;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0[4] = r3;
        String r4 = r10.d;
        if (r4 == null) goto L12;
        r2 = r4;
    L12:
        r0[5] = r2;
        r0[6] = Boolean.valueOf(r10.e);
        r0[7] = Integer.valueOf(r10.f);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), ":", null, null, 0, null, null, 62, null);
    }

    public final void h(String r2) {
        String r3 = StringsKt.trim(r2).toString();
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        g(r3, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void i(b r7) {
        if (k() == true) goto L5;
        return;
    L5:
        String r0 = r7.a;
        String r1 = r7.b;
        String r2 = r7.c;
        String r3 = r7.d;
        boolean r8 = r7.e;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r0, "optionLabel");
        q3.b("slash_panel_option_click", q3.a(r0, r1, r2, r3, r8));
    }

    public final void j(b r8) {
        if (k() == true) goto L5;
        return;
    L5:
        String r0 = r8.a;
        String r1 = r8.b;
        String r2 = r8.c;
        String r3 = r8.d;
        boolean r4 = r8.e;
        int r9 = r8.f;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r0, "optionLabel");
        JSONObject r5 = q3.a(r0, r1, r2, r3, r4);
        r5.put("position", r9);
        q3.b("slash_panel_option_show", r5);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.slash.f, java.lang.Object] */
    public final void l(k1 r23) {
        Intrinsics.checkNotNullParameter(r23, "queryRange");
        FLogger r0 = FLogger.a;
        r0.i("SlashPanelController", "[show] begin, trigger=" + r23.d + ", queryLength=" + r23.c.length() + ", active=" + this.w + ", panelVisible=" + ((Boolean) this.m.invoke()).booleanValue() + ", skillEnabled=" + this.v + ", skills=" + this.y.size() + ", loadingSkills=" + this.z + ", skillsRefreshed=" + this.A + ", showSkillManagementOnly=" + this.H);
        if (this.w == true) goto L5;
        this.F = false;
        this.G++;
    L5:
        this.w = true;
        this.x = r23;
        if (this.v == false) goto L15;
        be8.a r1 = (be8.a) this.e.invoke();
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        boolean r3 = true;
    L16:
        this.H = r3;
        if (this.v == false) goto L39;
        if (r3 == true) goto L39;
        if (this.A == false) goto L22;
        r0.i("SlashPanelController", "[refreshSkillsIfNeeded] skip, reason=alreadyRefreshed, skills=" + this.y.size());
        goto L39
    L22:
        be8.a r4 = (be8.a) this.e.invoke();
        if (r4 != null) goto L25;
        r0.i("SlashPanelController", "[refreshSkillsIfNeeded] skip, reason=missingSkillAbility");
        goto L39
    L25:
        this.A = true;
        List r5 = r4.iH();
        HashSet r6 = new HashSet();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L27:
        if (r8.hasNext() == false) goto L33;
        Object r9 = r8.next();
        if (r6.add(((be8.b) r9).a) == false) goto L27;
        r7.add(r9);
        goto L27
    L33:
        if ((!r7.isEmpty()) == false) goto L35;
        this.y = r7;
    L35:
        FLogger.a.i("SlashPanelController", "[refreshSkillsIfNeeded] start, cachedSkills=" + r7.size());
        this.z = true;
        Job r10 = this.B;
        if (r10 == null) goto L38;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L38:
        long r11 = 1 + this.C;
        this.C = r11;
        this.B = BuildersKt.launch$default(this.b, null, null, new SlashPanelController$refreshSkillsIfNeeded$1(r4, r11, this, AccountService.a.getUserId(), null), 3, null);
    L39:
        String r12 = r23.c;
        if (((Boolean) this.m.invoke()).booleanValue() == false) goto L42;
        h(r12);
    L47:
        FLogger.a.i("SlashPanelController", "[show] end, active=" + this.w + ", panelVisible=" + ((Boolean) this.m.invoke()).booleanValue() + ", skills=" + this.y.size() + ", loadingSkills=" + this.z + ", showSkillManagementOnly=" + this.H);
        return;
    L42:
        String r13 = StringsKt.trim(r12).toString();
        if (r13.length() != 0) goto L45;
        boolean r14 = true;
    L46:
        g(r13, r14);
        r r15 = this.d;
        final ?? r16 = new f(this);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "action");
        InputPanelListView r17 = r15.b;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "action");
        r17.g.postOnAnimation(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.s(r16));
        goto L47
    L45:
        r14 = false;
        goto L46
    L10:
        if (r1.NV() != true) goto L12;
        r2 = true;
    L15:
        r3 = false;
        goto L16
    }

    public final boolean a(be8.b r23, k1 r24) {
        boolean r4 = true;
        if (((Boolean) this.i.invoke()).booleanValue() == false) goto L18;
        be8.a r3 = (be8.a) this.e.invoke();
        if (r3 != null) goto L8;
        return false;
    L8:
        if (e() == true) goto L10;
        return false;
    L10:
        r3.WY(r23);
        if (r24 != null) goto L13;
    L16:
        this.j.invoke();
        return true;
    L13:
        if (c() == false) goto L16;
        this.o.invoke();
        goto L16
    L18:
        EditText r5 = this.a.a;
        if (r24 != null) goto L21;
    L28:
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Set<Integer> r6 = com.larus.bmhome.chat.markdown.richtext.s.a;
        String r14 = com.larus.bmhome.chat.markdown.richtext.s.a(r23.a, Integer.valueOf(r23.getType()), r23.c, r23.h);
        if (r14 != null) goto L49;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("[selectSkill] invalid protocol metadata, type=");
        r8.append(r23.getType());
        r8.append(", hasExternalId=");
        String r9 = r23.c;
        if (r9 != null) goto L33;
    L36:
        boolean r10 = true;
    L37:
        r8.append(!r10);
        r8.append(", hasPath=");
        String r1 = r23.h;
        if (r1 != null) goto L40;
    L43:
        boolean r2 = true;
    L44:
        r8.append(!r2);
        r7.w("SlashPanelController", r8.toString());
        if (r24 == null) goto L47;
        d();
        this.o.invoke();
    L47:
        return false;
    L40:
        if (StringsKt.isBlank(r1) == true) goto L43;
        r2 = false;
        goto L44
    L33:
        if (StringsKt.isBlank(r9) == true) goto L36;
        r10 = false;
        goto L37
    L49:
        if (e() == true) goto L51;
        return false;
    L51:
        ChatInputWithMentionDelegate r11 = this.a;
        if (r24 == null) goto L54;
        int r12 = r24.a;
    L55:
        if (r24 == null) goto L57;
        int r13 = r24.b;
    L58:
        List<d0> r15 = CollectionsKt.listOf(new d0(r23.a, r23.b, InputReferenceType.SKILL, r14, null, null, null, null, null, null, 1008));
        if (r24 == null) goto L61;
        MultiTypePanelTrigger r16 = r24.d;
    L63:
        if (r16 == MultiTypePanelTrigger.EXTERNAL_SKILL) goto L66;
        r4 = false;
    L66:
        boolean r17 = r11.j(r12, r13, r15, r4);
        if (r24 == null) goto L69;
        d();
        this.o.invoke();
    L69:
        return r17;
    L61:
        r16 = null;
        goto L63
    L57:
        r13 = RangesKt.coerceAtLeast(r5.getSelectionEnd(), 0);
        goto L58
    L54:
        r12 = RangesKt.coerceAtLeast(r5.getSelectionStart(), 0);
        goto L55
    L21:
        if (r24.d != MultiTypePanelTrigger.EXTERNAL_SKILL) goto L28;
        if (r5.getSelectionStart() == r24.b) goto L25;
    L26:
        d();
        this.o.invoke();
        return false;
    L25:
        if (r5.getSelectionEnd() == r24.b) goto L28;
        goto L26
    }

    public final void f(be8.b r9, boolean r10) {
        Job r0 = this.D;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        this.D = BuildersKt.launch$default(this.b, null, null, new SlashPanelController$mutateRecentlyUsed$1(r10, r9, this, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(String r51, boolean r52) {
        if (this.w == true) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d r9 = null;
        if (this.v == false) goto L8;
        s1 r10 = this.s.update(this.y, r51, new com.larus.bmhome.chat.component.bottom.core.inputtext.slash.a(this));
    L9:
        View r0 = this.E;
        if (r0 == null) goto L12;
        com.larus.bmhome.view.screenmenu.d.b(r0);
    L12:
        this.E = null;
        boolean r1 = v19.h.a;
        boolean r11 = v19.h.b(this.r);
        List r12 = CollectionsKt.createListBuilder();
        int r14 = 0;
        boolean r15 = true;
        if (r52 == false) goto L15;
    L16:
        List r5 = CollectionsKt.createListBuilder();
        if (r52 == true) goto L19;
    L27:
        int r2 = 0;
    L28:
        if (r52 == true) goto L30;
    L34:
        int r34 = r2;
    L35:
        if (r52 == true) goto L37;
    L62:
        r34 = r34;
        r5 = r5;
    L63:
        int r4 = r34;
    L65:
        if (this.H == false) goto L67;
        int r3 = r4 + 1;
        final b r6 = new b("skill_management", r4);
        r5.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(this.r.getString(2131906720), false, null, 0.0f, null, 2131242818, null, null, null, null, b(r6), new k(this, r6), null, new l(this, r6), 10206));
    L68:
        List r7 = CollectionsKt.build(r5);
        if ((!r7.isEmpty()) == false) goto L71;
        r12.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.b(this.r.getString(2131906729)));
        r12.addAll(r7);
    L71:
        r14 = r3;
    L73:
        if (this.v == true) goto L75;
    L159:
        List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o> r8 = CollectionsKt.build(r12);
        List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o> r13 = r8;
        boolean r16 = r13 instanceof Collection;
        if (r16 == true) goto L162;
    L164:
        Iterator<T> r17 = r13.iterator();
    L166:
        if (r17.hasNext() == false) goto L176;
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o r18 = (com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r17.next();
        if ((r18 instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d) == false) goto L170;
    L173:
        boolean r19 = true;
    L174:
        if (r19 == false) goto L166;
        boolean r20 = true;
    L177:
        if (r16 == true) goto L179;
    L181:
        Iterator<T> r21 = r13.iterator();
        int r22 = 0;
    L183:
        if (r21.hasNext() == false) goto L189;
        if ((((com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r21.next()) instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d) == false) goto L183;
        r22 = r22 + 1;
        if (r22 >= 0) goto L183;
        CollectionsKt.throwCountOverflow();
    L189:
        if (r16 == true) goto L191;
    L193:
        Iterator<T> r23 = r13.iterator();
        int r24 = 0;
    L195:
        if (r23.hasNext() == false) goto L201;
        if ((((com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r23.next()) instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c) == false) goto L195;
        r24 = r24 + 1;
        if (r24 >= 0) goto L195;
        CollectionsKt.throwCountOverflow();
    L201:
        FLogger r25 = FLogger.a;
        r25.i("SlashPanelController", "[renderSkillItems] queryLength=" + r51.length() + ", includeRootActions=" + r52 + ", active=" + this.w + ", skills=" + this.y.size() + ", loadingSkills=" + this.z + ", items=" + r8.size() + ", rows=" + r22 + ", loadingItems=" + r24 + ", hasSearchResult=" + r20 + ", panelVisible=" + ((Boolean) this.m.invoke()).booleanValue() + ", showSkillManagementOnly=" + this.H);
        if (r20 == true) goto L205;
        r25.i("SlashPanelController", "[renderSkillItems] hide panel, reason=noSearchResult");
        this.n.invoke(Boolean.FALSE);
        return;
    L205:
        r r26 = this.d;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r8, "items");
        Intrinsics.checkNotNullParameter(r51, "highlightKeyword");
        if (r26.e.p == true) goto L239;
        InputPanelListView r27 = r26.b;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r8, "items");
        Intrinsics.checkNotNullParameter(r51, "highlightKeyword");
        if (r51.length() <= 0) goto L211;
        boolean r28 = true;
    L212:
        if (r28 == true) goto L214;
    L229:
        boolean r29 = false;
    L230:
        r27.f = r8;
        RecyclerView r30 = r27.g;
        r30.setPadding(r30.getPaddingLeft(), c7.b(Integer.valueOf(InputPanelListView.b(r8))), r27.g.getPaddingRight(), c7.b(6));
        InputPanelListView.c r31 = r27.c;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r8, "newItems");
        Intrinsics.checkNotNullParameter(r51, "newHighlightKeyword");
        r31.a = r8;
        r31.b = r51;
        r31.notifyDataSetChanged();
        RecyclerView r32 = r27.g;
        int r33 = c7.b(Integer.valueOf(InputPanelListView.b(r8) + 6));
        Intrinsics.checkNotNullParameter(r8, "items");
        r32.setLayoutParams(new FrameLayout.LayoutParams(-1, RangesKt.coerceAtMost(r33 + (r8.size() * r27.d), r27.e)));
        if (r29 == false) goto L238;
        r27.g.stopScroll();
        LinearLayoutManager r35 = r27.g.getLayoutManager();
        if ((r35 instanceof LinearLayoutManager) == false) goto L235;
        LinearLayoutManager r36 = r35;
    L236:
        if (r36 == null) goto L238;
        r36.scrollToPositionWithOffset(0, 0);
        goto L238
    L235:
        r36 = null;
    L238:
        RecyclerView r37 = r26.b.g;
        FrameLayout.LayoutParams r38 = new FrameLayout.LayoutParams(-1, -1);
        r38.topMargin = r26.c;
        r37.setLayoutParams(r38);
        r26.e.g(false);
        r26.e.i(true);
        goto L239
    L214:
        if ((!r8.isEmpty()) == false) goto L229;
        List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o> r39 = r8;
        if ((r39 instanceof Collection) == true) goto L218;
    L220:
        Iterator<T> r40 = r39.iterator();
    L222:
        if (r40.hasNext() == false) goto L226;
        if (Intrinsics.areEqual((com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r40.next(), com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c.a) == true) goto L222;
        boolean r41 = false;
    L227:
        if (r41 == false) goto L229;
        r29 = true;
    L226:
        r41 = true;
        goto L227
    L218:
        if (r39.isEmpty() == false) goto L220;
    L211:
        r28 = false;
    L239:
        this.n.invoke(Boolean.TRUE);
        FLogger.a.i("SlashPanelController", "[renderSkillItems] panel visibility requested=true");
        if (k() == true) goto L242;
        return;
    L242:
        if (this.F == true) goto L274;
        this.F = true;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        JSONObject r42 = new JSONObject();
        r42.put("current_page", "chat");
        q3.b("slash_panel_show", r42);
        return;
    L274:
        return;
    L191:
        if (r13.isEmpty() == false) goto L193;
        r24 = 0;
        goto L201
    L179:
        if (r13.isEmpty() == false) goto L181;
        r22 = 0;
        goto L189
    L170:
        if ((r18 instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c) == true) goto L173;
        r19 = false;
    L176:
        r20 = false;
        goto L177
    L162:
        if (r13.isEmpty() == false) goto L164;
    L75:
        if (this.H == true) goto L159;
        if (this.z == true) goto L79;
    L80:
        if (r10 == null) goto L82;
        List<q1> r43 = r10.b;
        if (r51.length() <= 0) goto L94;
        boolean r44 = true;
    L95:
        if (r44 == true) goto L97;
    L99:
        Iterator r45 = r43.iterator();
    L101:
        if (r45.hasNext() == false) goto L159;
        final q1 r46 = (q1) r45.next();
        if (r46.c == false) goto L106;
        String r47 = "rec";
    L110:
        if (r51.length() != 0) goto L112;
        boolean r48 = true;
    L113:
        if (r48 == false) goto L115;
        r12.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.b(r46.a));
    L115:
        Iterator<T> r49 = r46.b.iterator();
        int r210 = r14;
    L117:
        if (r49.hasNext() == false) goto L158;
        final be8.b r50 = (be8.b) r49.next();
        String r53 = r50.b;
        String r54 = r50.c;
        if (r54 != null) goto L121;
    L126:
        r54 = r50.a;
    L127:
        String r211 = r54;
        if (r51.length() <= 0) goto L130;
        boolean r212 = true;
    L131:
        int r55 = r210 + 1;
        final b r110 = new b("skill", r53, r211, r47, r212, r210);
        String r56 = r50.b;
        String r111 = r50.d;
        Iterator r112 = r45;
        t1 r310 = (t1) ((LinkedHashMap) r10.c).get(r50.a);
        b2.b r57 = b2.a;
        int r58 = b2.b(r50.a, r11).a;
        if (r51.length() != 0) goto L134;
        boolean r113 = true;
    L135:
        if (r113 == true) goto L137;
    L155:
        String r213 = r47;
    L156:
        m r410 = 0;
    L157:
        r12.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(r56, false, r111, 0.3f, r310, 2131242818, null, Integer.valueOf(r58), null, null, b(r110), new n(this, r110), r410, new o(this, r110, r50), 1858));
        r210 = r55;
        r45 = r112;
        r47 = r213;
        r15 = true;
        goto L117
    L137:
        if (r46.c == true) goto L155;
        if ((!StringsKt.isBlank(r50.a)) == false) goto L151;
        r213 = r47;
        if (r50.getType() != SkillType.LOCAL.getValue()) goto L150;
        String r59 = r50.h;
        if (r59 != null) goto L145;
    L148:
        boolean r60 = true;
    L149:
        if (r60 == false) goto L150;
    L152:
        boolean r61 = false;
    L153:
        if (r61 == false) goto L156;
        r410 = new m(this, r50, r46);
        goto L157
    L145:
        if (StringsKt.isBlank(r59) == true) goto L148;
        r60 = false;
    L150:
        r61 = true;
        goto L153
    L151:
        r213 = r47;
        goto L152
    L134:
        r113 = false;
        goto L135
    L130:
        r212 = false;
        goto L131
    L121:
        if ((StringsKt.isBlank(r54) ^ r15) == true) goto L124;
        r54 = null;
    L124:
        if (r54 == null) goto L126;
    L158:
        r14 = r210;
        goto L101
    L112:
        r48 = false;
        goto L113
    L106:
        if (r46.d == false) goto L108;
        r47 = "freq";
        goto L110
    L108:
        r47 = "common";
        goto L110
    L97:
        if ((!r43.isEmpty()) == false) goto L99;
        r12.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.b(this.r.getString(2131906731)));
        goto L99
    L94:
        r44 = false;
    L82:
        if (r51.length() != 0) goto L84;
        boolean r62 = true;
    L85:
        if (r62 == false) goto L87;
        int r63 = 5;
    L88:
        int r64 = 0;
    L89:
        if (r64 >= r63) goto L159;
        r12.add(com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c.a);
        r64 = r64 + 1;
        goto L89
    L87:
        r63 = 15;
        goto L88
    L84:
        r62 = false;
        goto L85
    L79:
        if (this.y.isEmpty() == true) goto L82;
    L67:
        r3 = r4;
        goto L68
    L37:
        if (this.t == false) goto L62;
        IContextWindowUsageService.a.getClass();
        final IContextWindowUsageService r65 = (IContextWindowUsageService) IContextWindowUsageService.a.b.getValue();
        if (r65 == null) goto L60;
        v29.c r66 = s1a.a.g(this.c).getAbility(v29.c.class);
        if (r66 == null) goto L60;
        com.larus.contextwindow.api.a.b r67 = r66.O90();
        if ((r67 instanceof com.larus.contextwindow.api.a.b) == false) goto L47;
        com.larus.contextwindow.api.a.b r68 = r67;
    L48:
        if (r68 == null) goto L60;
        final ContextWindowEntryRequest r114 = r66.dO();
        if (r114 == null) goto L60;
        Drawable r214 = r65.a(this.r, r68);
        if (r214 == null) goto L60;
        final b r69 = new b("quota_status", r34);
        String r115 = AppHost.a.getApplication().getString(2131906727);
        String r70 = r65.d(this.r, r68);
        if (r70 != null) goto L59;
        r70 = "";
    L59:
        final com.larus.contextwindow.api.a.b r215 = r68;
        r9 = new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(r115, false, r70, 0.3f, null, null, r214, null, null, null, b(r69), new d(this, r69), null, new e(this, r69, r65, r114, r215), 10130);
        goto L60
    L47:
        r68 = null;
    L60:
        if (r9 == null) goto L63;
        r4 = r34 + 1;
        r5.add(r9);
        goto L65
    L30:
        if (this.u == false) goto L34;
        if (((Boolean) this.k.invoke()).booleanValue() == false) goto L34;
        final b r71 = new b("select_project", r2);
        r5.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(this.r.getString(2131906723), false, null, 0.0f, null, 2131240269, null, null, null, null, b(r71), new i(this, r71), null, new j(this, r71), 10206));
        r34 = r2 + 1;
        goto L35
    L19:
        if (((Boolean) this.g.invoke()).booleanValue() == false) goto L27;
        k1 r72 = this.x;
        if (r72 == null) goto L23;
        MultiTypePanelTrigger r73 = r72.d;
    L25:
        if (r73 != MultiTypePanelTrigger.SLASH) goto L27;
        final b r74 = new b("create_ai_doc", r14);
        r5.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(this.r.getString(2131898222), false, this.r.getString(2131906724), 0.3f, null, 2131242115, null, null, null, null, b(r74), new g(this, r74), null, new h(this, r74), 10194));
        r2 = 1;
        goto L28
    L23:
        r73 = null;
        goto L25
    L15:
        if (this.H == false) goto L73;
    L8:
        r10 = null;
        goto L9
    }

    public SlashPanelController(ChatInputWithMentionDelegate r17, CoroutineScope r18, Fragment r19, r r20, Function0 r21, Function0 r22, Function0 r23, z0 r24, a1 r25, Function0 r26, Function0 r27, Set r28, b1 r29, c1 r30, d1 r31, Function1 r32, Function0 r33, SkillSearchIndex r34) {
        Intrinsics.checkNotNullParameter(r17, "inputDelegate");
        Intrinsics.checkNotNullParameter(r18, "coroutineScope");
        Intrinsics.checkNotNullParameter(r19, "hostFragment");
        Intrinsics.checkNotNullParameter(r20, "panelView");
        Intrinsics.checkNotNullParameter(r21, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r22, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r23, "canCreateDocument");
        Intrinsics.checkNotNullParameter(r24, "onCreateDocument");
        Intrinsics.checkNotNullParameter(r25, "shouldSelectSkillInActionBar");
        Intrinsics.checkNotNullParameter(r26, "onSkillSelectedInActionBar");
        Intrinsics.checkNotNullParameter(r27, "shouldShowProjects");
        Intrinsics.checkNotNullParameter(r28, "enabledContents");
        Intrinsics.checkNotNullParameter(r29, "isPanelVisible");
        Intrinsics.checkNotNullParameter(r30, "onPanelVisibilityChanged");
        Intrinsics.checkNotNullParameter(r31, "onQueryFinished");
        Intrinsics.checkNotNullParameter(r32, "onConsumeQuery");
        Intrinsics.checkNotNullParameter(r33, "onOpenProjectPanel");
        Intrinsics.checkNotNullParameter(r34, "skillSearchIndex");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        Context r1 = r17.a.getContext();
        this.r = r1;
        this.s = new SkillPanelSearch(r1, r18, r34);
        this.t = r28.contains(SlashPanelContent.QUOTA);
        this.u = r28.contains(SlashPanelContent.PROJECT);
        this.v = r28.contains(SlashPanelContent.SKILL);
        this.y = CollectionsKt.emptyList();
    }
}
