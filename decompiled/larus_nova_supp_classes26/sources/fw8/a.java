package fw8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.e0;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.n0;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.business.floatchat.api.AIChatActionBarCapability;
import com.larus.im.bean.bot.BotModel;
import dw8.c;
import dw8.d;
import dw8.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import juc.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.v;
import ss8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements IActionBarSegmentV2, f {
    public final Function0<d> a;
    public final String b;
    public final String c;
    public final IActionBarSegmentV2.Position d;

    /* JADX INFO: renamed from: fw8.a$a, reason: collision with other inner class name */
    public static final class C0109a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AIChatActionBarCapability.values().length];
            r0[AIChatActionBarCapability.OPEN_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AIChatActionBarCapability.MUSIC_GENERATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AIChatActionBarCapability.IMAGE_GENERATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // ss8.e
    public final boolean g() {
        return true;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2
    public final int getPriority() {
        return 0;
    }

    @Override // ss8.e
    public final boolean h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return false;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2
    public final boolean isEnabled() {
        return !((d) this.a.invoke()).a.isEmpty();
    }

    public final List<z0> k() {
        a r0 = this;
        List<dw8.f> r1 = ((d) r0.a.invoke()).a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L81;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        dw8.f r8 = (dw8.f) r6;
        long r9 = ((long) r5) + 1;
        Map<String, String> r24 = r0.i(r8.a, r7);
        c r10 = r8.e;
        if ((r10 instanceof c.b) == false) goto L40;
        dw8.b r11 = ((c.b) r10).a;
        String r12 = r8.a;
        String r13 = r8.b;
        String r4 = r8.c;
        String r14 = r8.d;
        String r15 = "applet_chat_action_bar_" + r12;
        g1 r16 = m(r4);
        g1 r17 = m(r14);
        if ((r11 instanceof dw8.b.c) == false) goto L14;
        z0 r28 = new z0(Long.valueOf(r9), r15, r16, r17, r13, null, Integer.valueOf(ActionBarExecutionType.USER_SEND_MSG.getValue()), new n0(((dw8.b.c) r11).a, 2), null, null, null, null, true, r24, null, -536946784, 13);
    L36:
        int r29 = r7;
        z0 r41 = r28;
        Iterator r210 = r3;
        z0 r18 = r41;
    L78:
        r2.add(r18);
        r0 = this;
        r3 = r210;
        r5 = r29;
        goto L4
    L14:
        if ((r11 instanceof dw8.b.C0106b) == false) goto L17;
        r28 = new z0(Long.valueOf(r9), r15, r16, r17, r13, null, Integer.valueOf(ActionBarExecutionType.OPEN_BY_SCHEMA.getValue()), null, new e0(((dw8.b.C0106b) r11).a, 2), null, null, null, true, r24, null, -536950880, 13);
        goto L36
    L17:
        if ((r11 instanceof dw8.b.a) == false) goto L38;
        AIChatActionBarCapability r19 = ((dw8.b.a) r11).a;
        int r110 = b.a[r19.ordinal()];
        if (r110 == 1) goto L26;
        if (r110 == 2) goto L25;
        if (r110 != 3) goto L24;
        Integer r111 = 4;
    L27:
        Long r20 = Long.valueOf(r9);
        if (r19 != AIChatActionBarCapability.OPEN_CAMERA) goto L30;
        int r21 = ActionBarExecutionType.OPEN_CAMERA.getValue();
    L31:
        Integer r112 = Integer.valueOf(r21);
        if (r111 == null) goto L34;
        r r22 = new r(Integer.valueOf(r111.intValue()), null, null, null, null, null, Boolean.TRUE, null, 3966);
    L35:
        r28 = new z0(r20, r15, r16, r17, r13, null, r112, null, null, null, r22, null, true, r24, null, -536946784, 13);
        goto L36
    L34:
        r22 = null;
        goto L35
    L30:
        r21 = ActionBarExecutionType.INSTRUCTION.getValue();
        goto L31
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r111 = 1;
        goto L27
    L26:
        r111 = null;
        goto L27
    L38:
        throw new NoWhenBranchMatchedException();
    L40:
        if ((r10 instanceof c.a) == false) goto L80;
        c.a r23 = (c.a) r10;
        String r25 = r8.a;
        String r26 = r8.b;
        String r113 = r8.c;
        String r27 = r8.d;
        List<e> r114 = r23.a;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
        int r117 = 0;
    L43:
        if (r116.hasNext() == false) goto L77;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        e r120 = (e) r118;
        Iterator r211 = r3;
        Map<String, String> r30 = r0.i(r120.a, r119);
        dw8.b r31 = r120.e;
        int r212 = r7;
        if ((r31 instanceof dw8.b.c) == false) goto L53;
        Iterator r121 = r116;
        HashMap r32 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("message_text", ((dw8.b.c) r31).a)});
        if (r30 == null) goto L52;
        r32.putAll(r30);
    L52:
        Unit r33 = Unit.INSTANCE;
        c0 r34 = j(r120, r119, "send_user_message", r32);
    L74:
        r115.add(r34);
        r0 = this;
        r117 = r119;
        r116 = r121;
        r3 = r211;
        r7 = r212;
        goto L43
    L53:
        r121 = r116;
        if ((r31 instanceof dw8.b.C0106b) == false) goto L58;
        r34 = l(r120, r119, ((dw8.b.C0106b) r31).a, r30);
        goto L74
    L58:
        if ((r31 instanceof dw8.b.a) == false) goto L76;
        int r35 = b.a[((dw8.b.a) r31).a.ordinal()];
        if (r35 != 1) goto L62;
        HashMap r36 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "common_input"), TuplesKt.to("click_from", "input_left_icon")});
        if (r30 == null) goto L73;
        r36.putAll(r30);
    L73:
        Unit r37 = Unit.INSTANCE;
        r34 = j(r120, r119, "universal_camera", r36);
        goto L74
    L62:
        if (r35 != 2) goto L64;
        r34 = l(r120, r119, "sslocal://flow/edit_instruction?actionbar_instruction_type=1", r30);
        goto L74
    L64:
        if (r35 != 3) goto L67;
        r34 = l(r120, r119, "sslocal://flow/edit_instruction?actionbar_instruction_type=4", r30);
        goto L74
    L67:
        throw new NoWhenBranchMatchedException();
    L76:
        throw new NoWhenBranchMatchedException();
    L77:
        r210 = r3;
        r29 = r7;
        b0 r38 = new b0(r115, Integer.valueOf(r23.b));
        r18 = new z0(Long.valueOf(r9), "applet_chat_action_bar_" + r25, m(r113), m(r27), r26, null, Integer.valueOf(ActionBarExecutionType.INSTRUCTION.getValue()), null, null, null, new r(2, CollectionsKt.listOf(new u(1, 8, null, xt7.d.b.a(b0.Companion.serializer(), r38), null, Boolean.TRUE, null, 180)), null, null, null, null, Boolean.FALSE, null, 3708), null, true, r24, null, -536946784, 13);
        goto L78
    L80:
        throw new NoWhenBranchMatchedException();
    L81:
        return r2;
    }

    @Override // ss8.f
    public final List a() {
        return k();
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2
    public final String c() {
        return this.c;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2
    public final IActionBarSegmentV2.Position getPosition() {
        return this.d;
    }

    public static g1 m(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((true ^ r1) == false) goto L12;
        String r4 = r8;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return new g1(null, r4, null, null, 29);
    L12:
        r4 = null;
        goto L13
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r1 = false;
        goto L10
    }

    public a(com.larus.business.floatchat.impl.component.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "configProvider");
        this.a = r2;
        this.b = r3;
        this.c = "applet_chat_action_bar";
        this.d = IActionBarSegmentV2.Position.BEFORE_DEFAULT;
    }

    @Override // ss8.e
    public final List b(BotModel r2, wc9.e r3) {
        Intrinsics.checkNotNullParameter(r2, "bot");
        Intrinsics.checkNotNullParameter(r3, "conversation");
        return k();
    }

    @Override // ss8.e
    public final boolean d(z0 r3, z0 r4) {
        Intrinsics.checkNotNullParameter(r3, "old");
        Intrinsics.checkNotNullParameter(r4, "next");
        Intrinsics.checkNotNullParameter(r3, "old");
        Intrinsics.checkNotNullParameter(r4, "next");
        return false;
    }

    public final Map<String, String> i(String r4, int r5) {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return null;
    L6:
        Map r1 = wa8.c0.a;
        Intrinsics.checkNotNullParameter(r0, "scopeId");
        Intrinsics.checkNotNullParameter(r4, "actionBarKey");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("__action_bar_item_event_scope_id", r0), TuplesKt.to("__action_bar_item_event_key", r4), TuplesKt.to("__action_bar_item_event_position", String.valueOf(r5))});
    }

    @Override // ss8.e
    public final void e(BaseActionBarHolder r2, z0 r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    @Override // ss8.e
    public final BaseActionBarHolder f(ViewGroup r2, t1 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        return new BaseActionBarHolder(new View(r2.getContext()));
    }

    public static c0 j(e r14, int r15, String r16, HashMap r17) {
        return new c0(Integer.valueOf(r15), 5, xt7.d.b.a(com.larus.bmhome.actionbar.model.c.Companion.serializer(), new com.larus.bmhome.actionbar.model.c(Integer.valueOf(r15), r14.b, r17, r16, m(r14.c), m(r14.d), 960)));
    }

    public static c0 l(e r11, int r12, String r13, Map r14) {
        Integer r0 = Integer.valueOf(r12);
        v r1 = xt7.d.b;
        n r2 = com.larus.bmhome.actionbar.model.a.Companion.serializer();
        Integer r4 = Integer.valueOf(r12);
        String r5 = r11.b;
        if (r14 == null) goto L5;
        HashMap r15 = new HashMap(r14);
    L7:
        return new c0(r0, 7, r1.a(r2, new com.larus.bmhome.actionbar.model.a(r4, r5, r13, r15, m(r11.c), m(r11.d), 960)));
    L5:
        r15 = null;
        goto L7
    }
}
