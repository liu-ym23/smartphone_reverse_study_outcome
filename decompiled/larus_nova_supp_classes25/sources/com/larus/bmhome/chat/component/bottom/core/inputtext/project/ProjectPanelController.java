package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectFolder;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import t19.s;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ProjectPanelController {
    public final CoroutineScope a;
    public final Fragment b;
    public final h c;
    public final Function0<be8.a> d;
    public final Function0<Boolean> e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;
    public final Context h;
    public String i;
    public boolean j;
    public List<b> k;
    public boolean l;
    public boolean m;
    public Job n;
    public final ProjectPanelController$backCallback$1 o;

    public static final class a {
    }

    public static final class b {
        public final be8.f a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ProjectItem(selection=" + this.a + ')';
        }

        public b(be8.f r2) {
            Intrinsics.checkNotNullParameter(r2, "selection");
            this.a = r2;
        }
    }

    static {
    }

    public final void b() {
        this.j = false;
        setEnabled(false);
        this.c.i.setVisibility(8);
    }

    public final boolean c() {
        if (((Boolean) this.e.invoke()).booleanValue() == false) goto L6;
        return true;
    L6:
        s r1 = s.a;
        Context r2 = this.h;
        s.j(r1, r2, r2.getString(2131900187), null, false, 28);
        return false;
    }

    public final void d() {
        if (this.l == false) goto L6;
        e();
        return;
    L6:
        IProjectListDataSource r0 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r0 != null) goto L10;
        e();
        return;
    L10:
        this.l = true;
        e();
        Job r2 = this.n;
        if (r2 == null) goto L13;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L13:
        this.n = BuildersKt.launch$default(this.a, null, null, new ProjectPanelController$loadProjects$1(r0, this, null), 3, null);
    }

    public final void e() {
        if (this.j == true) goto L5;
        return;
    L5:
        be8.a r1 = (be8.a) this.d.invoke();
        if (r1 == null) goto L8;
        String r2 = r1.Ve();
    L9:
        List<b> r3 = this.k;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L24;
        Object r6 = r5.next();
        b r7 = (b) r6;
        if (this.i.length() != 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == false) goto L11;
        r4.add(r6);
        goto L11
    L18:
        if (StringsKt.contains(r7.a.b, this.i, true) == true) goto L21;
        r9 = false;
        goto L22
    L15:
        r8 = false;
        goto L16
    L24:
        List<? extends o> r10 = CollectionsKt.listOf(new o.b(this.h.getString(2131906723)));
        List r11 = CollectionsKt.createListBuilder();
        Iterator r12 = r4.iterator();
    L26:
        if (r12.hasNext() == false) goto L33;
        final b r13 = (b) r12.next();
        String r14 = r13.a.b;
        if (Intrinsics.areEqual(r13.a.a, r2) == false) goto L30;
        Integer r15 = Integer.valueOf(v19.c.b(2130971676, this.h, 2131241038));
    L31:
        Context r16 = this.h;
        Integer r17 = r15;
        r11.add(new o.d(r14, true, null, 0.0f, null, 2131240269, null, null, r17, Integer.valueOf(ContextCompat.getColor(r16, v19.c.b(2130972079, r16, 2131103136))), null, null, null, new com.larus.bmhome.chat.component.bottom.core.inputtext.project.a(this, r13), 15580));
        goto L26
    L30:
        r15 = null;
        goto L31
    L33:
        if (this.l == false) goto L38;
        int r18 = 0;
    L36:
        if (r18 >= 5) goto L38;
        r11.add(o.c.a);
        r18 = r18 + 1;
    L38:
        List<? extends o> r19 = CollectionsKt.build(r11);
        List r20 = CollectionsKt.createListBuilder();
        r20.add(new o.d(this.h.getString(2131906717), false, null, 0.0f, null, 2131240264, null, null, null, null, null, null, null, new com.larus.bmhome.chat.component.bottom.core.inputtext.project.b(this), 16350));
        if (r2 == null) goto L41;
        r20.add(new o.d(this.h.getString(2131906917), false, null, 0.0f, null, 2131240265, null, null, null, null, null, null, null, new c(this), 16350));
    L41:
        List<? extends o> r21 = CollectionsKt.build(r20);
        h r22 = this.c;
        String r23 = this.i;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r10, "topItems");
        Intrinsics.checkNotNullParameter(r19, "projectItems");
        Intrinsics.checkNotNullParameter(r21, "bottomItems");
        Intrinsics.checkNotNullParameter(r23, "highlightKeyword");
        InputPanelListView r24 = r22.a;
        LinearLayout r25 = r22.f;
        int r26 = InputPanelListView.h;
        r24.e(r25, r10, "");
        r22.a.e(r22.e, r19, r23);
        r22.a.e(r22.g, r21, "");
        InputPanelListView r27 = r22.a;
        List r28 = CollectionsKt.plus(CollectionsKt.plus(r10, r19), r21);
        int r29 = c7.b(16);
        r27.getClass();
        Intrinsics.checkNotNullParameter(r28, "items");
        r22.d = r29 + (r28.size() * r27.d);
        r22.a();
        r22.i.setVisibility(0);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static final b a(ProjectPanelController r13, OmniProject r14) {
        r13.getClass();
        String r1 = null;
        if (r14.status == OmniProjectStatus.OmniProjectStatus_DELETED) goto L37;
        String r15 = r14.projectId;
        if (r15 != null) goto L8;
        return null;
    L8:
        if ((!StringsKt.isBlank(r15)) == false) goto L10;
        String r4 = r15;
    L11:
        if (r4 == null) goto L38;
        List r16 = r14.folders;
        if (r16 != null) goto L16;
        r16 = CollectionsKt.emptyList();
    L16:
        OmniProjectFolder r17 = (OmniProjectFolder) CollectionsKt.firstOrNull(r16);
        String r18 = r14.name;
        if (r18 != null) goto L19;
        r18 = "";
    L19:
        String r5 = r18;
        if (r17 != null) goto L22;
        boolean r6 = true;
    L23:
        if (r17 == null) goto L25;
        String r7 = r17.folderName;
    L26:
        if (r17 == null) goto L28;
        String r8 = r17.workspace;
    L29:
        if (r17 == null) goto L31;
        String r9 = r17.folderDeviceId;
    L32:
        if (r17 == null) goto L35;
        r1 = r17.folderDeviceName;
    L35:
        return new b(new be8.f(r4, r5, r6, r7, r8, r9, r1, 128));
    L31:
        r9 = null;
        goto L32
    L28:
        r8 = null;
        goto L29
    L25:
        r7 = null;
        goto L26
    L22:
        r6 = false;
        goto L23
    L38:
        return null;
    L10:
        r4 = null;
        goto L11
    L37:
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.activity.OnBackPressedCallback, com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController$backCallback$1] */
    public ProjectPanelController(CoroutineScope r2, Fragment r3, h r4, Function0<? extends be8.a> r5, Function0<Boolean> r6, Function0<Unit> r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "coroutineScope");
        Intrinsics.checkNotNullParameter(r3, "hostFragment");
        Intrinsics.checkNotNullParameter(r4, "panelView");
        Intrinsics.checkNotNullParameter(r5, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r6, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r7, "onBack");
        Intrinsics.checkNotNullParameter(r8, "onFinished");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r3.requireContext();
        this.i = "";
        this.k = CollectionsKt.emptyList();
        this.m = true;
        ?? r9 = new ProjectPanelController$backCallback$1(this);
        this.o = r9;
        Function0<Unit> r10 = new d(this);
        Intrinsics.checkNotNullParameter(r10, "action");
        r4.b = r10;
        r3.requireActivity().getOnBackPressedDispatcher().addCallback(r3, r9);
    }
}
