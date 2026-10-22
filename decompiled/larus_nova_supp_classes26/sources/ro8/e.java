package ro8;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.standarduikit.widget.view.WidgetView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kc8.x0;
import kc8.y;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends jc8.b<ro8.a> {
    public fo8.c d;
    public WidgetView e;
    public kc8.b f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final String c() {
        return "WidgetBlockHolder";
    }

    public final void i() {
        WidgetView r0 = this.e;
        if (r0 == null) goto L5;
        r0.b(null);
    L5:
        fo8.c r1 = this.d;
        if (r1 == null) goto L9;
        r1.b().c();
        return;
    }

    public e() {
        this.g = LazyKt.lazy(new c(this));
    }

    public final jc8.d f(jc8.a r4) {
        ro8.a r5 = (ro8.a) r4;
        Intrinsics.checkNotNullParameter(r5, "blockModel");
        if (r5.m() == true) goto L5;
    L12:
        boolean r0 = false;
    L13:
        if (r0 == true) goto L23;
        AppletBlock r1 = r5.o();
        if (r1 == null) goto L18;
        boolean r2 = Intrinsics.areEqual(r1.isFullWidth, Boolean.TRUE);
    L19:
        if (r2 == false) goto L22;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return jc8.d.a(jc8.e.d(r5), 0, 0, 0, 10);
    L22:
        return jc8.e.d(r5);
    L18:
        r2 = false;
        goto L19
    L23:
        return new jc8.d(0, 0, 0, 0);
    L5:
        if (r5.n() == false) goto L12;
        AppletBlock r3 = r5.o();
        if (r3 == null) goto L9;
        boolean r6 = Intrinsics.areEqual(r3.mixedBlock, Boolean.TRUE);
    L10:
        if (r6 == true) goto L12;
        r0 = true;
        goto L13
    L9:
        r6 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(jc8.a r19) {
        ro8.a r1 = (ro8.a) r19;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.f = jc8.c.a(this, kc8.b.class);
        AppletBlock r2 = r1.o();
        b r3 = 0;
        if (r2 == null) goto L5;
        String r4 = r2.renderData;
    L6:
        AppletBlock r5 = r1.o();
        boolean r6 = false;
        if (r5 == null) goto L9;
        boolean r7 = Intrinsics.areEqual(r5.mixedBlock, Boolean.TRUE);
    L11:
        if (r1.m() == true) goto L13;
    L20:
        boolean r8 = false;
    L21:
        AppletBlock r9 = r1.o();
        if (r9 == null) goto L24;
        boolean r10 = Intrinsics.areEqual(r9.isFullWidth, Boolean.TRUE);
    L25:
        if (r8 == true) goto L35;
        AppletBlock r11 = r1.o();
        if (r11 == null) goto L29;
        boolean r12 = Intrinsics.areEqual(r11.isFullWidth, Boolean.TRUE);
    L30:
        if (r12 == true) goto L35;
        jc8.d r13 = jc8.e.d(r1);
        int r14 = r13.a + r13.c;
        cd8.a r15 = jc8.c.a(this, cd8.a.class);
        if (r15 == null) goto L39;
        int r16 = r15.b - r14;
    L38:
        int r17 = r16;
    L40:
        FLogger r18 = FLogger.a;
        StringBuilder r110 = new StringBuilder("onBindBlockView, holder=");
        r110.append(hashCode());
        r110.append(", messageId=");
        r110.append(r1.j().getMessageId());
        r110.append(", blockId=");
        r110.append(((jc8.a) r1).a.getBlockId());
        r110.append(", mixedBlock=");
        r110.append(r7);
        r110.append(", useSingleLayout=");
        r110.append(r8);
        r110.append(", strategy=");
        AppletBlock r20 = r1.o();
        if (r20 == null) goto L43;
        Integer r21 = r20.renderDataUpdateStrategy;
    L44:
        r110.append(r21);
        r110.append(", renderDataLength=");
        if (r4 == null) goto L47;
        int r22 = r4.length();
    L48:
        r110.append(r22);
        r18.i("AppletRenderUpdate", r110.toString());
        jc8.d r23 = jc8.e.d(r1);
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("is_full_width", Boolean.valueOf(r10)), TuplesKt.to("block_margin", MapsKt.mapOf(new Pair[]{TuplesKt.to("left", Integer.valueOf((int) c7.d(Integer.valueOf(r23.a)))), TuplesKt.to("top", Integer.valueOf((int) c7.d(Integer.valueOf(r23.b)))), TuplesKt.to("right", Integer.valueOf((int) c7.d(Integer.valueOf(r23.c)))), TuplesKt.to("bottom", Integer.valueOf((int) c7.d(Integer.valueOf(r23.d))))})), TuplesKt.to("msg_container_max_width", Integer.valueOf(r17))});
        Message r112 = r1.j();
        if (r4 != null) goto L51;
        r4 = "";
    L51:
        String r113 = r4;
        kc8.b r24 = this.f;
        if (r24 == null) goto L56;
        y r25 = r24.a;
        if (r25 == null) goto L56;
        RecyclerView.Adapter r26 = r25.w;
    L57:
        boolean r27 = r26 instanceof q0;
        if (r24 == null) goto L67;
        y r28 = r24.a;
        if (r28 == null) goto L67;
        Integer r29 = r28.j;
        if (r29 == null) goto L67;
        if (r29.intValue() != 3) goto L67;
        r6 = true;
    L67:
        if (r6 == false) goto L69;
        float r114 = 0.0f;
    L70:
        ho8.a r30 = new ho8.a(false, r17, r112, r113, r114, r27, r111);
        kc8.b r31 = this.f;
        if (r31 == null) goto L77;
        y r32 = r31.a;
        if (r32 == null) goto L77;
        Function1 r33 = r32.z;
        if (r33 == null) goto L77;
        r33.invoke(Integer.valueOf(i5.r0()));
    L77:
        fo8.c r34 = this.d;
        if (r34 == null) goto L80;
        r34.a(r30, (eo8.b) this.g.getValue());
    L80:
        kc8.b r35 = this.f;
        if (r35 == null) goto L85;
        x0 r36 = r35.t;
        if (r36 == null) goto L85;
        final z r37 = r36.c;
    L86:
        WidgetView r38 = this.e;
        if (r38 == null) goto L93;
        if (r37 == null) goto L91;
        r3 = new b(r37);
    L91:
        r38.b(r3);
        return;
    L93:
        return;
    L85:
        r37 = null;
        goto L86
    L69:
        r114 = i5.r0();
    L56:
        r26 = null;
        goto L57
    L47:
        r22 = 0;
        goto L48
    L43:
        r21 = null;
    L39:
        r17 = -1;
        goto L40
    L29:
        r12 = false;
    L35:
        cd8.a r39 = jc8.c.a(this, cd8.a.class);
        if (r39 == null) goto L39;
        r16 = r39.b;
        goto L38
    L24:
        r10 = false;
        goto L25
    L13:
        if (r1.n() == false) goto L20;
        AppletBlock r40 = r1.o();
        if (r40 == null) goto L17;
        boolean r41 = Intrinsics.areEqual(r40.mixedBlock, Boolean.TRUE);
    L18:
        if (r41 == true) goto L20;
        r8 = true;
        goto L21
    L17:
        r41 = false;
        goto L18
    L9:
        r7 = false;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("AppletRenderUpdate", "onCreatedBlockView, holder=" + hashCode());
        fo8.c r0 = new fo8.c(r4.getContext());
        this.d = r0;
        WidgetView r5 = r0.b();
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r1 = r5;
    L6:
        this.e = r1;
        return r5;
    L5:
        r1 = null;
        goto L6
    }
}
