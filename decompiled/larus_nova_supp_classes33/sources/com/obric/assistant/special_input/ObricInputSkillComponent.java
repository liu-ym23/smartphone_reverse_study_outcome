package com.obric.assistant.special_input;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.assistant.ability.chat.input.SkillSelectSource;
import com.obric.assistant.component.c7;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J,\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070(H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J \u0010*\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J \u0010-\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\b\u00104\u001a\u00020\u0017H\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0016\u0010:\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\b\u0010<\u001a\u00020\u001bH\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0011H\u0016J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0011H\u0016J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0013H\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0013H\u0016J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0018\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00072\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0016J\b\u0010M\u001a\u00020\u0017H\u0016J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0016\u0010O\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\b\u0010P\u001a\u00020\u001bH\u0016J\u0012\u0010Q\u001a\u00020\u001b2\b\b\u0002\u0010R\u001a\u00020\u001aH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002J\u001c\u0010T\u001a\u00020\u001b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001fH\u0002J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\r2\u0006\u0010H\u001a\u00020YH\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0010\u0010\\\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0016\u0010]\u001a\u00020\u00172\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070^H\u0002J\u0010\u0010_\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0002J \u0010`\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0002J*\u0010d\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070e2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001fH\u0002J \u0010f\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\r2\u0006\u0010g\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0002J\u000e\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0016\u0010i\u001a\u00020\u001b2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\b\u0010l\u001a\u00020\u001bH\u0002J\b\u0010m\u001a\u00020\u001bH\u0016J\b\u0010n\u001a\u00020\u0007H\u0002J\u0010\u0010o\u001a\u00020\u00172\u0006\u0010p\u001a\u00020qH\u0016J\u0014\u0010r\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0014\u0010s\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/obric/assistant/special_input/ObricInputSkillComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "<init>", "()V", "selectedSkillIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "mentionedSkillIds", "routeSelectedSkillIds", "routeMentionTemporarySkills", "Ljava/util/LinkedHashMap;", "Lcom/obric/assistant/ability/chat/input/ObricSkillItem;", "Lkotlin/collections/LinkedHashMap;", "selectionChangeListeners", "", "Lcom/obric/assistant/ability/chat/input/SkillSelectionChangeListener;", "displayedSkillListChangeListeners", "Lcom/obric/assistant/ability/chat/input/DisplayedSkillListChangeListener;", "mentionCandidateLoadListeners", "Lcom/obric/assistant/ability/chat/input/MentionCandidateLoadListener;", "skillCacheLoaded", "", "skillCacheListener", "Lkotlin/Function1;", "Lcom/obric/assistant/special_input/SkillCacheSnapshot;", "", "availableSkillList", "", "routeRecognizableSkillMap", "", "rowBaseSkillList", "loadedSkillList", "initialized", "destroyed", "setSkillMessageExt", "conversationId", "content", "extra", "", "buildFinalQuery", "replaceSkillMention", "skillName", "skillId", "isSkillMentionBoundary", "start", "", "end", "onDestroy", "initializeIfNeeded", "getLoadedSkillList", "isSkillCacheLoaded", "resolveAvailableSkill", "getPhoneOperationActionBarSkills", "getSelectedSkillIds", "getSelectedSkills", "toggleSkillSelection", "setSelectedSkillIds", "skillIds", "resetSelection", "addSkillSelectionChangeListener", "listener", "removeSkillSelectionChangeListener", "addMentionCandidateLoadListener", "removeMentionCandidateLoadListener", "addDisplayedSkillListChangeListener", "removeDisplayedSkillListChangeListener", "getMentionCandidateSkills", "getMentionedSkillIds", "getMentionedSkills", "addRouteSelectedSkill", "skill", "source", "Lcom/obric/assistant/ability/chat/input/SkillSelectSource;", "addMentionedSkill", "removeRouteMentionTemporarySkill", "clearRouteMentionTemporarySkills", "removeMentionedSkill", "setMentionedSkillIds", "clearMentionedSkills", "refreshSkillListFromCache", "snapshot", "removeUnavailableRouteMentionTemporarySkills", "reconcileSelectionState", "previousSkillById", "withAllSkillItem", "skillItems", "mapToObricSkillItem", "Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "resolveSkillById", "buildDisplayedSkillList", "moveRouteSkillToFront", "updateRouteSelectedSkillIds", "", "removeRouteSelectedSkill", "removeRouteMentionTemporarySkillInternal", "removeMention", "normalizeSkillId", "isRouteSelectSource", "notifyInvalidatedMentions", "", "notifySelectionChanged", "selected", "snapshotDisplayedSkillList", "notifyDisplayedSkillListChangedIfNeeded", "previousDisplayedSkillList", "notifyDisplayedSkillListChanged", "notifyMentionCandidatesLoaded", "openAllSkillsPage", "buildAllSkillsLogExtras", "isOmniSkillUsable", "syncTimeoutMs", "", "joinSkillIds", "joinSkillNames", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInputSkillComponent extends ComponentFeature implements paa.c {
    public static final /* synthetic */ int w = 0;
    public final LinkedHashSet<String> h;
    public final LinkedHashSet<String> i;
    public final LinkedHashSet<String> j;
    public final LinkedHashMap<String, paa.e> k;
    public final Set<paa.f> l;
    public final Set<paa.a> m;
    public final Set<paa.d> n;
    public boolean o;
    public final Function1<s0, Unit> p;
    public List<paa.e> q;
    public Map<String, paa.e> r;
    public List<paa.e> s;
    public List<paa.e> t;
    public boolean u;
    public volatile boolean v;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((paa.e) r2).b.length()), Integer.valueOf(((paa.e) r1).b.length()));
        }
    }

    public static final class c implements oga.a {
        public final /* synthetic */ ObricInputSkillComponent a;

        @Override // oga.a
        public final void onDismissFailed() {
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            AppHost.Companion r0 = AppHost.a;
            ContextWrapper r1 = r0.a().getCurrentActivity();
            if (r1 != null) goto L5;
            r1 = r0.getApplication();
        L5:
            Intent r2 = new Intent().setClassName(r1.getPackageName(), "com.obric.aiagent.skill.manager.impl.ui.SkillShopStarterActivity");
            ObricInputSkillComponent r3 = this.a;
            int r4 = ObricInputSkillComponent.w;
            r3.getClass();
            JSONObject r5 = new JSONObject();
            r5.put("previous_page", "chat");
            r5.put("enter_method", "obric_omni_click_all_skill");
            Intent r6 = r2.putExtra("log_extras", r5.toString());
            if ((r1 instanceof Activity) == true) goto L16;
            r6.addFlags(268435456);
        L16:
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
            r1.startActivity(r6);     // Catch: Throwable -> L10
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L18;
            FLogger.a.e("ObricInputSkillComponent", "openAllSkillsPage failed", r9);
            t19.s.a.g(AppHost.a.getApplication(), 2131911903, false);
            return;
        L18:
            return;
        L10:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        }

        public c(ObricInputSkillComponent r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void onDestroy() {
        this.v = true;
        OSkillCache r0 = OSkillCache.a;
        Function1<s0, Unit> r1 = this.p;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        OSkillCache.f("removeListener", r1, OSkillCache.i(r1));
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o = false;
        this.q = CollectionsKt.emptyList();
        this.r = MapsKt.emptyMap();
        this.s = CollectionsKt.emptyList();
        this.t = CollectionsKt.emptyList();
        this.u = false;
    }

    public final List<paa.e> F2() {
        Iterator<T> r0 = this.t.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((paa.e) r1).a, "all_skills") == false) goto L4;
    L9:
        paa.e r2 = (paa.e) r1;
        if (r2 == null) goto L12;
        LinkedHashSet<String> r3 = this.j;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        paa.e r6 = m3((String) r5.next());
        if (r6 == null) goto L15;
        r4.add(r6);
        goto L15
    L19:
        HashSet r7 = new HashSet();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r4.iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        if (r7.add(((paa.e) r10).a) == false) goto L21;
        r8.add(r10);
        goto L21
    L25:
        List r11 = CollectionsKt.take(r8, 10);
        final HashSet r12 = new HashSet();
        Iterator r13 = r11.iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        r12.add(((paa.e) r13.next()).a);
        goto L27
    L29:
        List r14 = CollectionsKt.createListBuilder(10);
        r14.addAll(r11);
        Iterator r15 = SequencesKt.take(SequencesKt.filter(CollectionsKt.asSequence(this.s), new k(r12)), 10 - r14.size()).iterator();
    L31:
        if (r15.hasNext() == false) goto L33;
        r14.add((paa.e) r15.next());
        goto L31
    L33:
        List r16 = CollectionsKt.build(r14);
        List r17 = CollectionsKt.createListBuilder(r16.size() + 1);
        r17.add(r2);
        r17.addAll(r16);
        return CollectionsKt.build(r17);
    L12:
        return this.t;
    L8:
        r1 = null;
        goto L9
    }

    public final void L2() {
        if (this.v == false) goto L5;
        return;
    L5:
        if (this.u == true) goto L10;
        this.o = false;
        this.q = CollectionsKt.emptyList();
        this.r = MapsKt.emptyMap();
        this.s = CollectionsKt.emptyList();
        this.t = B3(CollectionsKt.emptyList());
        this.u = true;
        OSkillCache r0 = OSkillCache.a;
        Function1<s0, Unit> r1 = this.p;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        int r2 = OSkillCache.i(r1);
        OSkillCache.k.add(new WeakReference(r1));
        OSkillCache.f("addListener", r1, r2);
        OSkillCache.k();
        Y2(OSkillCache.n);
        return;
    }

    public final List<paa.e> p3() {
        if (this.u == false) goto L6;
        return F2();
    L6:
        return CollectionsKt.emptyList();
    }

    public final void px() {
        IKeyguardService$a.a(KeyguardService.a, new c(this), false, false, false, false, null, 62);
    }

    public ObricInputSkillComponent() {
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
        this.j = new LinkedHashSet();
        this.k = new LinkedHashMap();
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.n = new LinkedHashSet();
        this.p = new ObricInputSkillComponent$skillCacheListener$1(this);
        this.q = CollectionsKt.emptyList();
        this.r = MapsKt.emptyMap();
        this.s = CollectionsKt.emptyList();
        this.t = CollectionsKt.emptyList();
    }

    public final List<String> AM() {
        L2();
        return CollectionsKt.toList(this.h);
    }

    public final void CZ() {
        L2();
        if (this.i.isEmpty() == true) goto L5;
    L11:
        List<paa.e> r0 = p3();
        LinkedHashSet<String> r1 = this.i;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        paa.e r4 = m3((String) r3.next());
        if (r4 == null) goto L13;
        r2.add(r4);
        goto L13
    L17:
        LinkedHashSet<String> r5 = this.h;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        paa.e r8 = m3((String) r7.next());
        if (r8 == null) goto L19;
        r6.add(r8);
        goto L19
    L23:
        this.i.clear();
        this.h.clear();
        this.j.clear();
        this.k.clear();
        Iterator r9 = r6.iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        X2((paa.e) r9.next(), false, SkillSelectSource.MENTION);
        goto L25
    L27:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r2.iterator();
    L29:
        if (r11.hasNext() == false) goto L41;
        Object r12 = r11.next();
        paa.e r13 = (paa.e) r12;
        if (r6.isEmpty() == false) goto L33;
    L32:
        boolean r14 = false;
    L39:
        if (r14 == true) goto L29;
        r10.add(r12);
        goto L29
    L33:
        Iterator r15 = r6.iterator();
    L35:
        if (r15.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((paa.e) r15.next()).a, r13.a) == false) goto L35;
        r14 = true;
        goto L39
    L41:
        Iterator r16 = r10.iterator();
    L43:
        if (r16.hasNext() == false) goto L45;
        X2((paa.e) r16.next(), false, SkillSelectSource.MENTION);
        goto L43
    L45:
        U2(r0);
        return;
    L5:
        if (this.h.isEmpty() == false) goto L11;
        if (this.j.isEmpty() == false) goto L11;
        if (this.k.isEmpty() == false) goto L11;
    }

    public final List<paa.e> Nh() {
        L2();
        LinkedHashSet<String> r0 = this.i;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        paa.e r3 = m3((String) r2.next());
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public final boolean Yb() {
        L2();
        return this.o;
    }

    public final List<String> Yg() {
        L2();
        return CollectionsKt.toList(this.i);
    }

    public final List<paa.e> Zm() {
        L2();
        return this.q;
    }

    public final List<paa.e> a00() {
        L2();
        LinkedHashSet<String> r0 = this.h;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        paa.e r3 = m3((String) r2.next());
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public final List<paa.e> bJ() {
        L2();
        return F2();
    }

    public final List<paa.e> dj() {
        L2();
        return this.t;
    }

    public static List B3(List r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((paa.e) r1).a, "all_skills") == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r8 = CollectionsKt.createListBuilder(r0.size() + 1);
        r8.add(new paa.e("all_skills", AppHost.a.getApplication().getString(2131912611), null, 60));
        r8.addAll(r0);
        return CollectionsKt.build(r8);
    }

    public static paa.e N2(OSkill r8) {
        String r2 = StringsKt.trim(r8.getSlug()).toString();
        String r0 = StringsKt.trim(r8.getDisplayName()).toString();
        if (StringsKt.isBlank(r0) == false) goto L5;
        String r3 = r2;
    L7:
        if (StringsKt.isBlank(r2) == false) goto L9;
        return null;
    L9:
        if (StringsKt.isBlank(r3) == false) goto L12;
        return null;
    L12:
        return new paa.e(r2, r3, r8.getCoverUrl(), r8.getLastUsedAt(), r8.getCreatedAt(), r8.getLastUpdatedAt());
    L5:
        r3 = r0;
        goto L7
    }

    public static String P2(String r1) {
        String r2 = StringsKt.trim(r1).toString();
        if ((!StringsKt.isBlank(r2)) == true) goto L7;
        return null;
    L7:
        return r2;
    }

    public final void Dd(String r5) {
        Intrinsics.checkNotNullParameter(r5, "skillId");
        L2();
        List<paa.e> r0 = p3();
        String r6 = P2(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        paa.e r1 = m3(r6);
        if (r1 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r1.a, "all_skills") == false) goto L12;
        return;
    L12:
        if (this.h.contains(r6) == true) goto L14;
        this.h.remove("all_skills");
        this.h.add(r6);
        boolean r7 = true;
    L23:
        X2(r1, r7, SkillSelectSource.ROW);
        U2(r0);
        return;
    L14:
        if (this.k.containsKey(r6) == false) goto L17;
        h3(r6, SkillSelectSource.ROW);
        return;
    L17:
        this.h.remove(r6);
        if (this.j.contains(r6) == false) goto L21;
        this.j.remove(r6);
    L21:
        r7 = false;
        goto L23
    }

    public final paa.e GJ(String r5) {
        Intrinsics.checkNotNullParameter(r5, "skillId");
        L2();
        String r6 = P2(r5);
        Object r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        Iterator<T> r1 = this.q.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((paa.e) r2).a, r6) == false) goto L7;
        r0 = r2;
    L12:
        return (paa.e) r0;
    }

    public final boolean Kz(String r2) {
        Intrinsics.checkNotNullParameter(r2, "skillId");
        L2();
        return h3(r2, SkillSelectSource.MENTION);
    }

    public final String MG(String r14) {
        Intrinsics.checkNotNullParameter(r14, "content");
        List<paa.e> r0 = Nh();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();
        paa.e r5 = (paa.e) r4;
        if ((!StringsKt.isBlank(r5.a)) == true) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L8:
        if ((!StringsKt.isBlank(r5.b)) == false) goto L10;
    L13:
        Iterator r6 = CollectionsKt.sortedWith(r1, new b()).iterator();
    L15:
        if (r6.hasNext() == false) goto L50;
        paa.e r7 = (paa.e) r6.next();
        String r8 = r7.b;
        String r9 = "@" + r8;
        String r10 = "@" + r7.a;
        if (Intrinsics.areEqual(r9, r10) == true) goto L15;
        if (StringsKt.contains$default(r14, r9, false, 2, null) == false) goto L15;
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L23:
        if (r12 >= r14.length()) goto L49;
        int r13 = StringsKt.indexOf$default(r14, r9, r12, false, 4, null);
        if (r13 < 0) goto L26;
        int r15 = r9.length() + r13;
        r11.append(r14, r12, r13);
        if (r13 != 0) goto L30;
    L33:
        boolean r16 = true;
    L35:
        if (r15 != r14.length()) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r16 == false) goto L44;
        if (r17 == false) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L47;
        r11.append(r10);
    L48:
        r12 = r15;
        goto L23
    L47:
        r11.append(r9);
    L44:
        r18 = false;
        goto L45
    L37:
        if (CharsKt.isWhitespace(r14.charAt(r15)) == true) goto L40;
        r17 = false;
        goto L41
    L30:
        if (CharsKt.isWhitespace(r14.charAt(r13 - 1)) == true) goto L33;
        r16 = false;
        goto L35
    L26:
        r11.append(r14, r12, r14.length());
    L49:
        r14 = r11.toString();
        goto L15
    L50:
        return r14;
    }

    public final void N40(c7 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.remove(r2);
    }

    public final void U2(List<paa.e> r3) {
        if (Intrinsics.areEqual(r3, F2()) == false) goto L6;
        return;
    L6:
        if (this.m.isEmpty() == true) goto L12;
        List<paa.e> r4 = F2();
        Iterator<T> r0 = this.m.iterator();
    L10:
        if (r0.hasNext() == false) goto L14;
        ((paa.a) r0.next()).a(r4);
        goto L10
    L14:
        return;
    }

    public final void Y2(s0 r24) {
        if (this.v == false) goto L6;
        return;
    L6:
        if (r24.b == true) goto L9;
        this.o = false;
        FLogger.a.i("ObricInputSkillComponent", "refreshSkillListFromCache skipped, cache not loaded yet, lastLoadSucceeded=" + r24.c);
        return;
    L9:
        this.o = true;
        List<paa.e> r5 = p3();
        Map r6 = MapsKt.createMapBuilder();
        Iterator<T> r7 = this.q.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        paa.e r8 = (paa.e) r7.next();
        r6.put(r8.a, r8);
        goto L11
    L13:
        Iterator<T> r9 = this.k.values().iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        paa.e r10 = (paa.e) r9.next();
        String r11 = r10.a;
        Intrinsics.checkNotNull(r10);
        r6.put(r11, r10);
        goto L15
    L17:
        Map r12 = MapsKt.build(r6);
        List<OSkill> r13 = r24.a;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L19:
        if (r15.hasNext() == false) goto L23;
        Object r16 = r15.next();
        if (((OSkill) r16).getEnabled() == false) goto L19;
        r14.add(r16);
        goto L19
    L23:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r14.iterator();
    L25:
        if (r18.hasNext() == false) goto L33;
        Object r19 = r18.next();
        OSkill r110 = (OSkill) r19;
        String r111 = P2(r110.getSlug());
        if (r110.getAvailable() == false) goto L30;
        if (r111 == null) goto L30;
        boolean r112 = true;
    L31:
        if (r112 == false) goto L25;
        r17.add(r19);
    L30:
        r112 = false;
        goto L31
    L33:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r14.iterator();
    L35:
        if (r114.hasNext() == false) goto L39;
        paa.e r115 = N2((OSkill) r114.next());
        if (r115 == null) goto L35;
        r113.add(r115);
        goto L35
    L39:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r113.iterator();
    L41:
        if (r117.hasNext() == false) goto L45;
        Object r118 = r117.next();
        if (Intrinsics.areEqual(((paa.e) r118).a, "all_skills") == true) goto L41;
        r116.add(r118);
        goto L41
    L45:
        HashSet r119 = new HashSet();
        ArrayList r120 = new ArrayList();
        Iterator r121 = r116.iterator();
    L47:
        if (r121.hasNext() == false) goto L51;
        Object r122 = r121.next();
        if (r119.add(((paa.e) r122).a) == false) goto L47;
        r120.add(r122);
        goto L47
    L51:
        FLogger.a.i("ObricInputSkillComponent", "refreshSkillListFromCache: rawCount=" + r13.size() + ", enabledCount=" + r14.size() + ", availableCount=" + r17.size() + ", routeRecognizableCount=" + r120.size() + ", version=" + r24.d + ", rawSkills=" + CollectionsKt.joinToString$default(r13, null, null, null, 0, null, new l(), 31, null));
        ArrayList r1 = new ArrayList();
        Iterator r20 = r17.iterator();
    L53:
        if (r20.hasNext() == false) goto L57;
        paa.e r21 = N2((OSkill) r20.next());
        if (r21 == null) goto L53;
        r1.add(r21);
        goto L53
    L57:
        HashSet r22 = new HashSet();
        ArrayList r23 = new ArrayList();
        Iterator r2 = r1.iterator();
    L59:
        if (r2.hasNext() == false) goto L63;
        Object r25 = r2.next();
        if (r22.add(((paa.e) r25).a) == false) goto L59;
        r23.add(r25);
        goto L59
    L63:
        FLogger.a.i("ObricInputSkillComponent", "refreshSkillListFromCache: mappedAvailableSkills(size=" + r23.size() + "), skills=" + CollectionsKt.joinToString$default(r23, null, null, null, 0, null, new m(), 31, null));
        this.q = r23;
        LinkedHashMap r26 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r120, 10)), 16));
        Iterator r27 = r120.iterator();
    L65:
        if (r27.hasNext() == false) goto L67;
        Object r123 = r27.next();
        r26.put(((paa.e) r123).a, r123);
        goto L65
    L67:
        this.r = r26;
        Set<String> r28 = this.k.keySet();
        Map<String, paa.e> r29 = this.r;
        ArrayList r124 = new ArrayList();
        Iterator<T> r30 = r28.iterator();
    L69:
        if (r30.hasNext() == false) goto L74;
        Object r125 = r30.next();
        if (r29.containsKey((String) r125) == true) goto L69;
        r124.add(r125);
        goto L69
    L74:
        if (r124.isEmpty() == true) goto L81;
        LinkedHashMap<String, paa.e> r31 = this.k;
        Iterator r32 = r124.iterator();
    L78:
        if (r32.hasNext() == false) goto L80;
        r31.remove((String) r32.next());
        goto L78
    L80:
        FLogger.a.i("ObricInputSkillComponent", "removeUnavailableRouteMentionTemporarySkills: skillIds=" + CollectionsKt.joinToString$default(r124, null, null, null, 0, null, null, 63, null));
    L81:
        this.s = CollectionsKt.take(r23, 10);
        this.t = B3(this.q);
        FLogger.a.i("ObricInputSkillComponent", "refreshSkillListFromCache: rowBaseSkills(size=" + this.s.size() + ")=" + CollectionsKt.joinToString$default(this.s, null, null, null, 0, null, new n(), 31, null));
        Set<String> r4 = this.k.keySet();
        List<paa.e> r33 = this.s;
        HashSet r34 = new HashSet();
        Iterator<T> r35 = r33.iterator();
    L83:
        if (r35.hasNext() == false) goto L85;
        r34.add(((paa.e) r35.next()).a);
        goto L83
    L85:
        Set<String> r36 = r4;
        r34.addAll(r36);
        L2();
        List<paa.e> r37 = this.q;
        HashSet r38 = new HashSet();
        Iterator<T> r39 = r37.iterator();
    L87:
        if (r39.hasNext() == false) goto L89;
        r38.add(((paa.e) r39.next()).a);
        goto L87
    L89:
        r38.addAll(r36);
        Set r40 = CollectionsKt.toSet(this.i);
        LinkedHashSet<String> r41 = this.j;
        ArrayList r126 = new ArrayList();
        Iterator<T> r42 = r41.iterator();
    L91:
        if (r42.hasNext() == false) goto L100;
        Object r127 = r42.next();
        String r128 = (String) r127;
        if (r38.contains(r128) == true) goto L95;
    L97:
        boolean r129 = false;
    L98:
        if (r129 == false) goto L91;
        r126.add(r127);
        goto L91
    L95:
        if (m3(r128) == null) goto L97;
        r129 = true;
        goto L98
    L100:
        z3(r126);
        r34.addAll(this.j);
        this.h.retainAll(r34);
        this.h.addAll(this.j);
        this.i.retainAll(r38);
        Set r43 = SetsKt.minus(r40, this.i);
        ArrayList r44 = new ArrayList();
        Iterator r45 = r43.iterator();
    L102:
        if (r45.hasNext() == false) goto L106;
        Object r46 = r45.next();
        if ((!Intrinsics.areEqual((String) r46, "all_skills")) == false) goto L102;
        r44.add(r46);
        goto L102
    L106:
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator r47 = r44.iterator();
    L108:
        if (r47.hasNext() == false) goto L113;
        String r48 = (String) r47.next();
        paa.e r49 = (paa.e) r12.get(r48);
        if (r49 != null) goto L112;
        r49 = new paa.e(r48, r48, null, 60);
    L112:
        r3.add(r49);
        goto L108
    L113:
        Iterator r50 = r3.iterator();
    L115:
        if (r50.hasNext() == false) goto L118;
        X2((paa.e) r50.next(), false, SkillSelectSource.INVALIDATED);
        goto L115
    L118:
        if (this.n.isEmpty() == true) goto L124;
        L2();
        List<paa.e> r51 = this.q;
        Iterator<T> r52 = this.n.iterator();
    L122:
        if (r52.hasNext() == false) goto L124;
        ((paa.d) r52.next()).a(r51);
    L124:
        U2(r5);
    }

    public final boolean Zu(String r7) {
        Intrinsics.checkNotNullParameter(r7, "skillId");
        L2();
        List<paa.e> r0 = p3();
        String r8 = P2(r7);
        if (r8 != null) goto L5;
        return false;
    L5:
        boolean r2 = this.i.remove(r8);
        if (this.j.contains(r8) == true) goto L8;
        boolean r3 = false;
    L10:
        if (this.h.remove(r8) == false) goto L16;
        paa.e r9 = m3(r8);
        if (r9 == null) goto L14;
        X2(r9, false, SkillSelectSource.MENTION);
    L14:
        U2(r0);
        return true;
    L16:
        if (r2 == false) goto L20;
        paa.e r10 = m3(r8);
        if (r10 == null) goto L20;
        X2(r10, false, SkillSelectSource.MENTION);
    L20:
        U2(r0);
        if (r2 == true) goto L23;
        if (r3 == true) goto L23;
        return false;
    L23:
        return true;
    L8:
        this.j.remove(r8);
        r3 = true;
        goto L10
    }

    public final void hJ(com.obric.assistant.chat.component.bottom.core.mention.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.n.remove(r2);
    }

    public final void hM(paa.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.l.add(r2);
    }

    public final void lR(c7 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.add(r2);
    }

    public final paa.e m3(String r5) {
        L2();
        String r6 = P2(r5);
        Object r0 = null;
        if (r6 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r6, "all_skills") == false) goto L14;
        Iterator<T> r1 = this.t.iterator();
    L9:
        if (r1.hasNext() == false) goto L21;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((paa.e) r2).a, r6) == false) goto L9;
        r0 = r2;
    L21:
        return (paa.e) r0;
    L14:
        paa.e r3 = GJ(r6);
        if (r3 == null) goto L17;
        return r3;
    L17:
        return this.k.get(r6);
    }

    public final void nz(com.obric.assistant.chat.component.bottom.core.mention.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.n.add(r2);
    }

    public final void p70(paa.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.l.remove(r2);
    }

    public final void x70(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "skillIds");
        L2();
        List<paa.e> r0 = p3();
        List<paa.e> r1 = this.s;
        HashSet r2 = new HashSet();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((paa.e) r3.next()).a);
        goto L4
    L6:
        ArrayList r4 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L7:
        boolean r5 = true;
        if (r11.hasNext() == false) goto L19;
        Object r6 = r11.next();
        String r7 = (String) r6;
        if (Intrinsics.areEqual(r7, "all_skills") == false) goto L12;
    L16:
        r5 = false;
    L17:
        if (r5 == false) goto L7;
        r4.add(r6);
        goto L7
    L12:
        if (r2.contains(r7) == true) goto L17;
        if (m3(r7) == null) goto L16;
    L19:
        LinkedHashSet r12 = new LinkedHashSet(r4);
        ArrayList r8 = new ArrayList();
        Iterator r9 = r12.iterator();
    L21:
        if (r9.hasNext() == false) goto L31;
        Object r13 = r9.next();
        String r14 = (String) r13;
        if (r2.contains(r14) == true) goto L25;
    L28:
        boolean r15 = true;
    L29:
        if (r15 == false) goto L21;
        r8.add(r13);
        goto L21
    L25:
        if (this.j.contains(r14) == true) goto L28;
        r15 = false;
        goto L29
    L31:
        Set r16 = CollectionsKt.toSet(this.h);
        this.h.clear();
        this.h.addAll(r12);
        z3(r8);
        Set r17 = SetsKt.minus(r16, r12);
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L33:
        if (r19.hasNext() == false) goto L37;
        paa.e r20 = m3((String) r19.next());
        if (r20 == null) goto L33;
        r18.add(r20);
        goto L33
    L37:
        Iterator r21 = r18.iterator();
    L39:
        if (r21.hasNext() == false) goto L41;
        X2((paa.e) r21.next(), false, SkillSelectSource.DRAFT);
        goto L39
    L41:
        Set r110 = SetsKt.minus(r12, r16);
        ArrayList r22 = new ArrayList();
        Iterator r111 = r110.iterator();
    L43:
        if (r111.hasNext() == false) goto L47;
        paa.e r23 = m3((String) r111.next());
        if (r23 == null) goto L43;
        r22.add(r23);
        goto L43
    L47:
        Iterator r112 = r22.iterator();
    L49:
        if (r112.hasNext() == false) goto L51;
        X2((paa.e) r112.next(), true, SkillSelectSource.DRAFT);
        goto L49
    L51:
        U2(r0);
    }

    public final boolean z3(Collection<String> r7) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        String r1 = P2((String) r8.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r9 = CollectionsKt.distinct(r0);
        ArrayList r2 = new ArrayList();
        Iterator r10 = r9.iterator();
    L9:
        boolean r3 = true;
        if (r10.hasNext() == false) goto L20;
        Object r4 = r10.next();
        String r5 = (String) r4;
        if (Intrinsics.areEqual(r5, "all_skills") == false) goto L14;
    L16:
        r3 = false;
    L17:
        if (r3 == false) goto L9;
        r2.add(r4);
        goto L9
    L14:
        if (m3(r5) == null) goto L16;
    L20:
        if (Intrinsics.areEqual(CollectionsKt.toList(this.j), r2) == false) goto L22;
        return false;
    L22:
        this.j.clear();
        this.j.addAll(r2);
        return true;
    }

    public final boolean YW(String r6, SkillSelectSource r7) {
        Intrinsics.checkNotNullParameter(r6, "skillId");
        Intrinsics.checkNotNullParameter(r7, "source");
        L2();
        List<paa.e> r0 = p3();
        String r8 = P2(r6);
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r7 != SkillSelectSource.ROUTE_USE) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        paa.e r3 = m3(r8);
    L15:
        if (r3 != null) goto L17;
    L24:
        return false;
    L17:
        if (Intrinsics.areEqual(r8, "all_skills") == true) goto L24;
        boolean r9 = this.i.add(r8);
        if (r9 == false) goto L22;
        X2(r3, true, r7);
    L22:
        U2(r0);
        return r9;
    L14:
        r3 = GJ(r8);
        goto L15
    L8:
        if (r7 == SkillSelectSource.ROUTE_DEMO) goto L11;
        r2 = false;
        goto L12
    }

    public final boolean h3(String r7, SkillSelectSource r8) {
        String r9 = P2(r7);
        if (r9 != null) goto L5;
        return false;
    L5:
        paa.e r1 = this.k.get(r9);
        if (r1 != null) goto L8;
        return false;
    L8:
        List<paa.e> r2 = p3();
        this.k.remove(r9);
        boolean r3 = this.h.remove(r9);
        boolean r4 = this.i.remove(r9);
        this.j.remove(r9);
        if (r3 == true) goto L11;
        if (r4 == true) goto L11;
    L12:
        U2(r2);
        return true;
    L11:
        X2(r1, false, r8);
        goto L12
    }

    public final boolean hZ(paa.e r13, SkillSelectSource r14) {
        Intrinsics.checkNotNullParameter(r13, "skill");
        Intrinsics.checkNotNullParameter(r14, "source");
        L2();
        if (r14 != SkillSelectSource.ROUTE_USE) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        String r1 = P2(r13.a);
        if (r1 != null) goto L14;
        return false;
    L14:
        String r3 = StringsKt.trim(r13.b).toString();
        if ((!StringsKt.isBlank(r3)) == true) goto L18;
        r3 = null;
    L18:
        String r5 = r3;
        if (r5 != null) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r1, "all_skills") == false) goto L24;
        return false;
    L24:
        List<paa.e> r10 = p3();
        paa.e r11 = GJ(r1);
        if (r11 != null) goto L27;
        String r6 = r13.c;
        Long r7 = r13.d;
        Long r8 = r13.e;
        Long r9 = r13.f;
        Intrinsics.checkNotNullParameter(r1, "id");
        Intrinsics.checkNotNullParameter(r5, "name");
        paa.e r15 = new paa.e(r1, r5, r6, r7, r8, r9);
    L28:
        paa.e r4 = this.k.get(r1);
        if (r11 != null) goto L31;
        this.k.put(r1, r15);
    L31:
        boolean r12 = this.h.add(r1);
        List r16 = CollectionsKt.createListBuilder(this.j.size() + 1);
        r16.add(r1);
        Iterator<T> r17 = this.j.iterator();
    L33:
        if (r17.hasNext() == false) goto L37;
        Object r18 = r17.next();
        if ((!Intrinsics.areEqual((String) r18, r1)) == false) goto L33;
        r16.add(r18);
        goto L33
    L37:
        boolean r2 = z3(CollectionsKt.build(r16));
        if (r11 == null) goto L40;
    L42:
        boolean r19 = false;
    L43:
        if (r12 == true) goto L45;
        if (r19 == true) goto L45;
    L46:
        U2(r10);
        if (r12 == true) goto L50;
        if (r2 == true) goto L50;
        if (r19 == true) goto L50;
        return false;
    L50:
        return true;
    L45:
        X2(r15, true, r14);
        goto L46
    L40:
        if (Intrinsics.areEqual(r4, r15) == true) goto L42;
        r19 = true;
        goto L43
    L27:
        r15 = r11;
        goto L28
    L5:
        if (r14 == SkillSelectSource.ROUTE_DEMO) goto L8;
        r0 = false;
        goto L9
    }

    public final void X2(paa.e r3, boolean r4, SkillSelectSource r5) {
        Iterator<T> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((paa.f) r0.next()).a(r3, r4, r5);
        goto L4
    }

    public final void pU(String r20, String r21, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r20, "conversationId");
        Intrinsics.checkNotNullParameter(r21, "content");
        Intrinsics.checkNotNullParameter(r22, "extra");
        List<paa.e> r4 = Nh();
        String r6 = null;
        if ((!((ArrayList) r4).isEmpty()) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L39;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r8 = r4.iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        r5.add(((paa.e) r8.next()).a);
        goto L9
    L11:
        r22.put("o_omni_init_skill_ids", new JSONArray(r5).toString());
        r22.put("o_omni_skill_final_query", MG(r21));
        IAIChatRenderTraceService.Companion r2 = IAIChatRenderTraceService.a;
        LinkedHashMap r3 = new LinkedHashMap();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r9 = r4.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r7.add(((paa.e) r9.next()).a);
        goto L13
    L15:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        Object r12 = r11.next();
        if ((!StringsKt.isBlank((String) r12)) == false) goto L17;
        r10.add(r12);
        goto L17
    L21:
        String r13 = CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r13)) == true) goto L25;
        r13 = null;
    L25:
        r3.put("obric_omni_skill_ids", String.valueOf(r13));
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r15 = r4.iterator();
    L27:
        if (r15.hasNext() == false) goto L29;
        r14.add(((paa.e) r15.next()).b);
        goto L27
    L29:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r14.iterator();
    L31:
        if (r17.hasNext() == false) goto L35;
        Object r18 = r17.next();
        if ((!StringsKt.isBlank((String) r18)) == false) goto L31;
        r16.add(r18);
        goto L31
    L35:
        String r19 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r19)) == false) goto L38;
        r6 = r19;
    L38:
        r3.put("obric_omni_skill_names", String.valueOf(r6));
        Unit r23 = Unit.INSTANCE;
        r2.e(r20, r3);
        CZ();
    L39:
        L2();
        List r1 = CollectionsKt.toList(this.k.keySet());
        if (r1.isEmpty() == true) goto L94;
        List<paa.e> r24 = p3();
        List r25 = r1;
        Set r26 = CollectionsKt.toSet(r25);
        ArrayList r27 = new ArrayList();
        Iterator r28 = r25.iterator();
    L44:
        if (r28.hasNext() == false) goto L48;
        paa.e r29 = m3((String) r28.next());
        if (r29 == null) goto L44;
        r27.add(r29);
        goto L44
    L48:
        HashSet r30 = new HashSet();
        ArrayList r31 = new ArrayList();
        Iterator r32 = r27.iterator();
    L50:
        if (r32.hasNext() == false) goto L54;
        Object r33 = r32.next();
        if (r30.add(((paa.e) r33).a) == false) goto L50;
        r31.add(r33);
        goto L50
    L54:
        Set r34 = r26;
        boolean r35 = this.h.removeAll(r34);
        boolean r36 = this.i.removeAll(r34);
        boolean r37 = this.j.removeAll(r34);
        this.k.clear();
        if (r35 == true) goto L57;
        if (r36 == true) goto L57;
    L61:
        U2(r24);
        if (r35 == true) goto L91;
        if (r36 == true) goto L92;
        if (r37 == true) goto L93;
        r1.isEmpty();
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L57:
        Iterator r38 = r31.iterator();
    L59:
        if (r38.hasNext() == false) goto L61;
        X2((paa.e) r38.next(), false, SkillSelectSource.MENTION);
        goto L59
    }
}
