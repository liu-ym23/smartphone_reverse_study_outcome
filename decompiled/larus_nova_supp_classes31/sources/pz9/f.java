package pz9;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.creation.ChatCreationPagerFragment;
import com.larus.uaigc.creation.detail.image.BigImageDetailFragment;
import com.larus.uaigc.creation.detail.image.l;
import com.larus.uaigc.creation.detail.image.m;
import com.larus.uaigc.creation.detail.image.o;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;
import uo8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements b {
    public final KClass<? extends zo8.a> a;

    public f() {
        this.a = Reflection.getOrCreateKotlinClass(zo8.b.class);
    }

    @Override // pz9.b
    public KClass<? extends zo8.a> getType() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [pz9.d] */
    /* JADX WARN: Type inference failed for: r3v2, types: [pz9.e] */
    @Override // pz9.c
    public final Fragment a(final Fragment r45, zo8.a r46, int r47, int r48) {
        Intrinsics.checkNotNullParameter(r46, "data");
        if ((r46 instanceof zo8.b) == false) goto L5;
        zo8.b r2 = (zo8.b) r46;
    L6:
        if (r2 == null) goto L121;
        final BigImageDetailFragment r4 = new BigImageDetailFragment();
        boolean r5 = r45 instanceof ChatCreationPagerFragment;
        if (r5 == false) goto L10;
        ChatCreationPagerFragment r6 = (ChatCreationPagerFragment) r45;
    L11:
        if (r6 == null) goto L13;
        iy9.a<? extends zo8.a> r7 = r6.p;
    L14:
        if (r5 == false) goto L16;
        ChatCreationPagerFragment r8 = (ChatCreationPagerFragment) r45;
    L18:
        if (r8 == null) goto L20;
        int r21 = r8.o;
    L21:
        List r10 = CollectionsKt.mutableListOf(new zo8.b[]{r2});
        if (r7 == null) goto L24;
        String r3 = r7.e;
    L25:
        String r35 = "";
        if (r3 != null) goto L28;
        String r14 = "";
    L29:
        if (r7 == null) goto L31;
        k r12 = r7.c;
    L32:
        if (r7 == null) goto L34;
        String r18 = r7.k;
    L35:
        zo8.b r9 = (zo8.b) r46;
        List r15 = CollectionsKt.listOf(r9.a);
        if (o0.d(r9.b) == false) goto L38;
        List r16 = CollectionsKt.listOf(r9.b);
    L39:
        if (r5 == false) goto L41;
        ChatCreationPagerFragment r11 = (ChatCreationPagerFragment) r45;
    L43:
        if (r11 == null) goto L45;
        JSONObject r22 = r11.qa0(r48);
    L46:
        if (r7 == null) goto L49;
        ic8.d r13 = r7.r;
        if (r13 == null) goto L49;
    L50:
        ic8.d r24 = r13;
        if (r7 == null) goto L56;
        ic8.d r17 = r7.s;
        if (r17 == null) goto L56;
        ic8.d r25 = r17;
    L57:
        if (r7 == null) goto L62;
        ic8.d r19 = r7.t;
        if (r19 == null) goto L62;
        ic8.d r26 = r19;
    L63:
        if (r7 == null) goto L68;
        ic8.d r20 = r7.u;
        if (r20 == null) goto L68;
        ic8.d r27 = r20;
    L69:
        if (r7 == null) goto L72;
        ic8.d r23 = r7.v;
        if (r23 == null) goto L72;
    L73:
        ic8.d r28 = r23;
        if (r7 == null) goto L76;
        boolean r29 = r7.x;
    L77:
        if (r7 == null) goto L79;
        long r30 = r7.y;
    L80:
        long r31 = r30;
        if (r7 == null) goto L83;
        boolean r32 = r7.z;
    L84:
        if (r7 == null) goto L86;
        Integer r210 = r7.q;
    L87:
        if (r7 == null) goto L89;
        com.larus.bmhome.bigimg.e r33 = r7.d;
    L90:
        final iy9.a<zo8.b> r34 = new iy9.a(r10, 0, r12, r33, r14, r15, r16, r48, r18, new d(r45), new e(r45), r21, r22, r210, r24, r25, r26, r27, r28, r29, r31, r32, null, 71336450);
        Intrinsics.checkNotNullParameter(r34, "property");
        r4.F = r34;
        ImageAdapter r36 = new ImageAdapter();
        r36.h = r34.l;
        r36.i = r34.m;
        r36.k = r34.n;
        r36.l = true;
        List<n1> r37 = CollectionsKt.toMutableList(r34.f);
        List<String> r38 = r34.g;
        Function1<? super Integer, Unit> r39 = new com.larus.uaigc.creation.detail.image.a();
        Intrinsics.checkNotNullParameter(r36, "adapter");
        r4.d = r36;
        r4.e = r37;
        r4.f = r38;
        r4.g = r39;
        System.currentTimeMillis();
        ImageAdapter r40 = r4.d;
        if (r40 == null) goto L93;
        Function1 r41 = new com.larus.uaigc.creation.detail.image.k(r34, r4);
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r40.d = r41;
    L93:
        ImageAdapter r42 = r4.d;
        if (r42 == null) goto L96;
        r42.e = new l(r4);
    L96:
        if (r42 == null) goto L98;
        r42.f = new m(r34, r4);
    L98:
        if (r42 == null) goto L100;
        r42.j = new o(r4);
    L100:
        iy9.a<zo8.b> r43 = r4.F;
        if (r5 == false) goto L103;
        ChatCreationPagerFragment r44 = (ChatCreationPagerFragment) r45;
    L104:
        if (r44 == null) goto L106;
        int r49 = r44.oa0(qz9.a.a(r46));
    L107:
        r43.B = r49;
        if (r5 == false) goto L110;
        ChatCreationPagerFragment r0 = (ChatCreationPagerFragment) r45;
    L111:
        if (r0 == null) goto L120;
        String r1 = qz9.a.a(r46);
        Intrinsics.checkNotNullParameter(r1, "creationKey");
        Map<String, UserCreationFromIM> r50 = r0.k;
        if (r50 == null) goto L120;
        UserCreationFromIM r51 = r50.get(r1);
        if (r51 == null) goto L120;
        String r52 = r51.getCreationId();
        if (r52 == null) goto L120;
        r35 = r52;
    L120:
        String r53 = r35;
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r43.C = r53;
        r43.D = r9.c;
        return r4;
    L110:
        r0 = null;
        goto L111
    L106:
        r49 = 0;
        goto L107
    L103:
        r44 = null;
        goto L104
    L89:
        r33 = null;
        goto L90
    L86:
        r210 = null;
        goto L87
    L83:
        r32 = false;
        goto L84
    L79:
        r30 = 0;
        goto L80
    L76:
        r29 = false;
    L72:
        r23 = new ic8.d(false, null, null, false, null, null, 63);
    L68:
        r27 = new ic8.d(false, null, null, false, null, null, 63);
    L62:
        r26 = new ic8.d(false, null, null, false, null, null, 63);
    L56:
        r25 = new ic8.d(false, null, null, false, null, null, 63);
    L49:
        r13 = new ic8.d(false, null, null, false, null, null, 63);
        goto L50
    L45:
        r22 = null;
        goto L46
    L41:
        r11 = null;
        goto L43
    L38:
        r16 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L31:
        r12 = null;
        goto L32
    L28:
        r14 = r3;
        goto L29
    L24:
        r3 = null;
        goto L25
    L20:
        r21 = 0;
        goto L21
    L16:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L10:
        r6 = null;
        goto L11
    L121:
        return null;
    L5:
        r2 = null;
        goto L6
    }
}
