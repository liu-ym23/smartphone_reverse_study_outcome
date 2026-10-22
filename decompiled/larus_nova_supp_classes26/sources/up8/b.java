package up8;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.y;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.n;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import va8.s;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b implements d {
    public final Lazy a;
    public u b;
    public com.larus.bmhome.view.actionbar.edit.c c;
    public CoroutineScope d;
    public n e;
    public b f;
    public Integer g;
    public ActivityResultLauncher<String> h;
    public ActivityResultLauncher<Intent> i;
    public s j;
    public List<b> k;

    public Long c() {
        return null;
    }

    public abstract AbsInstructionWidget e(Context r1);

    public abstract int getType();

    public int i() {
        return 0;
    }

    public boolean j() {
        return false;
    }

    public abstract void k(String r1, boolean r2);

    public void m(Map<String, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionDefaultParams");
    }

    public abstract a0 n(String r1);

    public void p(boolean r1) {
    }

    public void q(Integer r1) {
    }

    public final List<b> f() {
        List<b> r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.filterNotNull(r0);
    }

    public final Integer h() {
        u r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final void o() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.c;
        if (r0 == null) goto L71;
        r r1 = r0.getInstructionRebuildStateConf();
        if (r1 == null) goto L71;
        Integer r3 = r1.a;
        Integer r4 = null;
        if (r3 != null) goto L10;
    L47:
        List r2 = r1.b;
        if (r2 == null) goto L70;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L51:
        if (r6.hasNext() == false) goto L61;
        Object r7 = r6.next();
        Integer r8 = ((u) r7).b;
        int r9 = getType();
        if (r8 != null) goto L56;
    L58:
        boolean r10 = false;
    L59:
        if (r10 == false) goto L51;
        r5.add(r7);
        goto L51
    L56:
        if (r8.intValue() != r9) goto L58;
        r10 = true;
        goto L59
    L61:
        Iterator r11 = r5.iterator();
    L63:
        if (r11.hasNext() == false) goto L69;
        String r12 = ((u) r11.next()).d;
        if (r12 == null) goto L63;
        if (o0.d(r12) == false) goto L63;
        k(r12, false);
        goto L63
    L69:
        r4 = Unit.INSTANCE;
    L70:
        if (r4 == null) goto L71;
        return;
    L10:
        if (r3.intValue() != 28) goto L47;
        y r13 = r1.i;
        if (r13 == null) goto L70;
        ArrayList r14 = r13.a;
        if (r14 == null) goto L70;
        z0 r15 = (z0) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L70;
        r r16 = r15.q;
        if (r16 == null) goto L21;
        r4 = r16.a;
    L21:
        if (Intrinsics.areEqual(r4, this.g) == false) goto L46;
        r r17 = r15.q;
        if (r17 == null) goto L46;
        List r18 = r17.b;
        if (r18 == null) goto L46;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L28:
        if (r20.hasNext() == false) goto L38;
        Object r21 = r20.next();
        Integer r22 = ((u) r21).b;
        int r23 = getType();
        if (r22 != null) goto L33;
    L35:
        boolean r24 = false;
    L36:
        if (r24 == false) goto L28;
        r19.add(r21);
        goto L28
    L33:
        if (r22.intValue() != r23) goto L35;
        r24 = true;
        goto L36
    L38:
        Iterator r25 = r19.iterator();
    L40:
        if (r25.hasNext() == false) goto L46;
        String r26 = ((u) r25.next()).d;
        if (r26 == null) goto L40;
        if (o0.d(r26) == false) goto L40;
        k(r26, false);
    L46:
        r4 = Unit.INSTANCE;
    L71:
        com.larus.bmhome.view.actionbar.edit.c r27 = this.c;
        if (r27 == null) goto L136;
        r r28 = r27.getCurrentInstructionUsuallyConfig();
        if (r28 == null) goto L137;
        List r29 = r28.b;
        if (r29 == null) goto L138;
        ArrayList r30 = new ArrayList();
        Iterator r31 = r29.iterator();
    L79:
        if (r31.hasNext() == false) goto L89;
        Object r32 = r31.next();
        Integer r33 = ((u) r32).b;
        int r34 = getType();
        if (r33 != null) goto L84;
    L86:
        boolean r35 = false;
    L87:
        if (r35 == false) goto L79;
        r30.add(r32);
        goto L79
    L84:
        if (r33.intValue() != r34) goto L86;
        r35 = true;
        goto L87
    L89:
        Iterator r36 = r30.iterator();
    L91:
        if (r36.hasNext() == false) goto L97;
        String r37 = ((u) r36.next()).d;
        if (r37 == null) goto L91;
        if (o0.d(r37) == false) goto L91;
        k(r37, true);
        goto L91
    L97:
        Unit r38 = Unit.INSTANCE;
        return;
    L138:
        return;
    L137:
        return;
    }

    public b() {
        this.a = LazyKt.lazy(new a());
        this.g = 0;
    }

    public static /* synthetic */ void l(b r1, String r2) {
        r1.k(r2, false);
    }

    public final AbsInstructionWidget d(Context r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r4 == null) goto L5;
        s r0 = (s) s1a.a.g(r4).getAbility(s.class);
    L6:
        this.j = r0;
        AbsInstructionWidget r5 = e(r3);
        r5.setComponentScope(this.d);
        if (r4 == null) goto L9;
        r5.R5(r4);
    L9:
        r5.T5(this);
        return r5;
    L5:
        r0 = null;
        goto L6
    }

    @Override // up8.d
    public a0 b(u r1, com.larus.bmhome.view.actionbar.edit.c r2, com.larus.bmhome.view.actionbar.edit.d r3, b r4) {
        this.b = r1;
        this.c = r2;
        this.f = r4;
        a0 r5 = n(r1.d);
        if (r3 == null) goto L7;
        Map<String, ?> r6 = r3.a;
        if (r6 == null) goto L7;
        m(r6);
    L8:
        return r5;
    L7:
        o();
        goto L8
    }

    public a0 r(String r2, com.larus.bmhome.view.actionbar.edit.c r3, u r4, com.larus.bmhome.view.actionbar.edit.d r5, b r6) {
        Intrinsics.checkNotNullParameter(r2, "template");
        this.b = r4;
        this.c = r3;
        this.f = r6;
        a0 r7 = n(r2);
        if (r5 == null) goto L7;
        Map<String, ?> r8 = r5.a;
        if (r8 == null) goto L7;
        m(r8);
    L8:
        return r7;
    L7:
        o();
        goto L8
    }
}
