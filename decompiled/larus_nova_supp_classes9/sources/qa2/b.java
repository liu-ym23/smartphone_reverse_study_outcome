package qa2;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.HotMsgType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.MatchLogHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import ra2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements pa2.a {
    public final /* synthetic */ d a;
    public final /* synthetic */ f52.b b;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ok1.c.a((this.a.a.q.getHeight() + e.a) + e.b, this.a.b.getDataCenter());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // pa2.a
    public final void a() {
        this.a.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("ConfrontView img load FAILED, dismissed");
        this.a.m(this.b);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // pa2.a
    public final void b() {
        d r0 = this.a;
        r0.p = true;
        r0.o = System.currentTimeMillis();
        this.a.q.setPadding(0, 0, 0, 0);
        ConfrontMsgView r1 = this.a.n;
        if (r1 == null) goto L60;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("ConfrontView img load success, start anim");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        ViewGroup.LayoutParams r4 = null;
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L7;
        r2 = null;
    L7:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (r3 == null) goto L10;
        r3.width = -1;
    L10:
        if (r3 == null) goto L12;
        r3.height = -1;
    L12:
        r1.setLayoutParams(r3);
        r1.setVisibility(0);
        GroupMsgView r5 = r1.c;
        if (r5 == null) goto L17;
        Float r6 = r5.e();
        if (r6 == null) goto L17;
        Integer r7 = Integer.valueOf((int) r6.floatValue());
    L18:
        GroupMsgView r8 = r1.b;
        if (r8 == null) goto L23;
        Float r9 = r8.e();
        if (r9 == null) goto L23;
        Integer r10 = Integer.valueOf((int) r9.floatValue());
    L24:
        ViewGroup r11 = r1.a;
        if (r11 == null) goto L27;
        r4 = r11.getLayoutParams();
    L27:
        if (r4 == null) goto L35;
        int r13 = 60;
        if (r7 == null) goto L31;
        int r14 = r7.intValue();
    L32:
        if (r10 == null) goto L34;
        r13 = r10.intValue();
    L34:
        r4.width = (Math.max(r14, r13) + s1.f(20.0f)) + s1.f(60.0f);
        goto L35
    L31:
        r14 = 60;
    L35:
        ViewGroup r15 = r1.a;
        if (r15 == null) goto L38;
        r15.setLayoutParams(r4);
    L38:
        ViewGroup r16 = r1.a;
        if (r16 == null) goto L43;
        ViewGroup r17 = UtilityKotlinExtentionsKt.p(r16);
        if (r17 == null) goto L43;
        r17.setClipChildren(false);
    L43:
        GroupMsgView r18 = r1.b;
        if (r18 == null) goto L46;
        r18.setClipChildren(false);
    L46:
        GroupMsgView r19 = r1.c;
        if (r19 == null) goto L50;
        r19.setClipChildren(false);
    L50:
        if (m.a.a(r1) == false) goto L58;
        GroupMsgView r20 = r1.b;
        if (r20 == null) goto L54;
        r20.b();
    L54:
        GroupMsgView r21 = r1.c;
        if (r21 == null) goto L57;
        r21.b();
    L57:
        r1.postDelayed(r1.j, r1.t);
    L59:
        r1.post(new a(this));
        goto L60
    L58:
        r1.postDelayed(r1.k, r1.r);
        r1.postDelayed(r1.l, r1.s);
        r1.postDelayed(r1.j, r1.t);
        r1.post(r1.g);
    L23:
        r10 = null;
    L17:
        r7 = null;
    L60:
        int r23 = MatchLogHelper.a;
        MatchLogHelper.c(HotMsgType.ConfrontMsg, this.b.getDataCenter(), true, null, 0, 24);
    }

    @Override // pa2.a
    public final void onDismiss() {
        this.a.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("ConfrontView dismissed");
        this.a.m(this.b);
    }

    public b(d r1, f52.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
