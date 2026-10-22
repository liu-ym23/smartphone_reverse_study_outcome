package qa2;

import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.HotMsgType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.MatchLogHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements pa2.a {
    public final /* synthetic */ h a;
    public final /* synthetic */ f52.b b;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
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
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView img load FAILED, dismissed");
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
        this.a.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView img load success, start anim");
        h r0 = this.a;
        r0.p = true;
        r0.n = System.currentTimeMillis();
        this.a.q.setPadding(0, 0, 0, 0);
        MatchHotMsgView r1 = this.a.o;
        if (r1 == null) goto L47;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Float r4 = null;
        CharSequence r5 = null;
        r4 = null;
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
        TextView r6 = r1.k;
        if (r6 == null) goto L39;
        TextPaint r7 = r6.getPaint();
        if (r7 == null) goto L39;
        TextView r8 = r1.k;
        if (r8 == null) goto L19;
        CharSequence r9 = r8.getText();
    L20:
        float r10 = r7.measureText(String.valueOf(r9));
        TextView r11 = r1.i;
        float r13 = 0.0f;
        if (r11 == null) goto L29;
        TextPaint r14 = r11.getPaint();
        if (r14 == null) goto L29;
        TextView r15 = r1.i;
        if (r15 == null) goto L27;
        CharSequence r16 = r15.getText();
    L28:
        float r17 = r14.measureText(String.valueOf(r16));
    L30:
        float r18 = r10 + r17;
        TextView r19 = r1.j;
        if (r19 == null) goto L38;
        TextPaint r20 = r19.getPaint();
        if (r20 == null) goto L38;
        TextView r21 = r1.j;
        if (r21 == null) goto L37;
        r5 = r21.getText();
    L37:
        r13 = r20.measureText(String.valueOf(r5));
    L38:
        r4 = Float.valueOf((r18 + r13) + (((r1.K + r1.L) + r1.M) + r1.N));
        goto L39
    L27:
        r16 = null;
    L29:
        r17 = 0.0f;
        goto L30
    L19:
        r9 = null;
    L39:
        if (r4 == null) goto L46;
        int r23 = (int) r4.floatValue();
        ImageView r24 = r1.f;
        if (r24 == null) goto L43;
        q32.a.a(r24, r23);
    L43:
        HSImageView r25 = r1.b;
        if (r25 == null) goto L46;
        a1.m(r25, r23 - r1.O);
    L46:
        r1.postDelayed(r1.n, r1.w);
        r1.postDelayed(r1.l, r1.x);
        r1.post(r1.m);
        r1.post(new a(this));
    L47:
        int r26 = MatchLogHelper.a;
        MatchLogHelper.c(HotMsgType.AggregateMsg, this.b.getDataCenter(), true, this.a.o, 0, 16);
    }

    @Override // pa2.a
    public final void onDismiss() {
        this.a.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView dismissed");
        this.a.m(this.b);
    }

    public f(h r1, f52.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
