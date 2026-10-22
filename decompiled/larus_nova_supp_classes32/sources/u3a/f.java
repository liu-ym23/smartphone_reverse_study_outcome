package u3a;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.bean.bot.SceneModel;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.voicecall.impl.scene.o;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final Lazy d = null;
    public static String e;
    public static String f;
    public static final Lazy g = null;

    static {
        AccountService r0 = AccountService.a;
        a = r0.getUserId().concat("-interpret_source_language");
        b = r0.getUserId().concat("-interpret_target_language");
        c = r0.getUserId().concat("-interpret_player_mute");
        d = LazyKt.lazy(new d());
        e = NameKeys.UnloadStrategy_No_Strategy;
        f = NameKeys.UnloadStrategy_No_Strategy;
        g = LazyKt.lazy(new e());
    }

    public static Keva a() {
        return (Keva) d.getValue();
    }

    public static Object b() {
        return ((Result) g.getValue()).unbox-impl();
    }

    public static String c() {
        w r1 = null;
        if (z2.a.getRealtimeCallTranslatorConfig().e() == false) goto L5;
        String r0 = a().getString(a, NameKeys.UnloadStrategy_No_Strategy);
        if (TextUtils.isEmpty(r0) == true) goto L38;
        Intrinsics.checkNotNull(r0);
        return r0;
    L38:
        Object r2 = b();
        if (Result.isFailure-impl(r2) == false) goto L41;
        r2 = null;
    L41:
        l0 r3 = (l0) r2;
        if (r3 == null) goto L46;
        h r4 = r3.a;
        if (r4 == null) goto L46;
        Long r5 = r4.g;
    L47:
        Object r6 = b();
        if (Result.isFailure-impl(r6) == false) goto L50;
        r6 = null;
    L50:
        l0 r7 = (l0) r6;
        if (r7 == null) goto L66;
        h r8 = r7.a;
        if (r8 == null) goto L66;
        List r9 = r8.e;
        if (r9 == null) goto L66;
        Iterator r10 = r9.iterator();
    L58:
        if (r10.hasNext() == false) goto L62;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((w) r11).a, r5) == false) goto L58;
    L63:
        w r12 = (w) r11;
        if (r12 == null) goto L66;
        r1 = r12.k;
        goto L66
    L62:
        r11 = null;
    L66:
        if (r1 != null) goto L69;
        return NameKeys.UnloadStrategy_No_Strategy;
    L69:
        return r1;
    L46:
        r5 = null;
        goto L47
    L5:
        if (TextUtils.isEmpty(e) == false) goto L34;
        Object r13 = b();
        if (Result.isFailure-impl(r13) == false) goto L9;
        r13 = null;
    L9:
        l0 r14 = (l0) r13;
        if (r14 == null) goto L14;
        h r15 = r14.a;
        if (r15 == null) goto L14;
        Long r16 = r15.g;
    L15:
        Object r17 = b();
        if (Result.isFailure-impl(r17) == false) goto L18;
        r17 = null;
    L18:
        l0 r18 = (l0) r17;
        if (r18 == null) goto L28;
        h r19 = r18.a;
        if (r19 == null) goto L28;
        List r20 = r19.e;
        if (r20 == null) goto L28;
        if (r16 == null) goto L26;
        int r21 = (int) r16.longValue();
    L27:
        r1 = (w) CollectionsKt.getOrNull(r20, r21);
        goto L28
    L26:
        r21 = -1;
    L28:
        if (r1 == null) goto L31;
        String r22 = r1.k;
        if (r22 == null) goto L31;
        return r22;
    L31:
        return "en";
    L14:
        r16 = null;
        goto L15
    L34:
        return e;
    }

    public static String d() {
        w r1 = null;
        if (z2.a.getRealtimeCallTranslatorConfig().e() == false) goto L5;
        String r0 = a().getString(b, NameKeys.UnloadStrategy_No_Strategy);
        if (TextUtils.isEmpty(r0) == true) goto L38;
        Intrinsics.checkNotNull(r0);
        return r0;
    L38:
        Object r2 = b();
        if (Result.isFailure-impl(r2) == false) goto L41;
        r2 = null;
    L41:
        l0 r3 = (l0) r2;
        if (r3 == null) goto L46;
        h r4 = r3.b;
        if (r4 == null) goto L46;
        Long r5 = r4.g;
    L47:
        Object r6 = b();
        if (Result.isFailure-impl(r6) == false) goto L50;
        r6 = null;
    L50:
        l0 r7 = (l0) r6;
        if (r7 == null) goto L66;
        h r8 = r7.b;
        if (r8 == null) goto L66;
        List r9 = r8.e;
        if (r9 == null) goto L66;
        Iterator r10 = r9.iterator();
    L58:
        if (r10.hasNext() == false) goto L62;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((w) r11).a, r5) == false) goto L58;
    L63:
        w r12 = (w) r11;
        if (r12 == null) goto L66;
        r1 = r12.k;
        goto L66
    L62:
        r11 = null;
    L66:
        if (r1 != null) goto L69;
        return NameKeys.UnloadStrategy_No_Strategy;
    L69:
        return r1;
    L46:
        r5 = null;
        goto L47
    L5:
        if (TextUtils.isEmpty(f) == false) goto L34;
        Object r13 = b();
        if (Result.isFailure-impl(r13) == false) goto L9;
        r13 = null;
    L9:
        l0 r14 = (l0) r13;
        if (r14 == null) goto L14;
        h r15 = r14.b;
        if (r15 == null) goto L14;
        Long r16 = r15.g;
    L15:
        Object r17 = b();
        if (Result.isFailure-impl(r17) == false) goto L18;
        r17 = null;
    L18:
        l0 r18 = (l0) r17;
        if (r18 == null) goto L28;
        h r19 = r18.b;
        if (r19 == null) goto L28;
        List r20 = r19.e;
        if (r20 == null) goto L28;
        if (r16 == null) goto L26;
        int r21 = (int) r16.longValue();
    L27:
        r1 = (w) CollectionsKt.getOrNull(r20, r21);
        goto L28
    L26:
        r21 = -1;
    L28:
        if (r1 == null) goto L31;
        String r22 = r1.k;
        if (r22 == null) goto L31;
        return r22;
    L31:
        return "zh";
    L14:
        r16 = null;
        goto L15
    L34:
        return f;
    }

    public static boolean e() {
        RealtimeCallUtil.a.getClass();
        o r0 = RealtimeCallUtil.l;
        if (r0 == null) goto L7;
        SceneModel r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.getKey();
    L9:
        return Intrinsics.areEqual(r2, "interpret_v2");
    L7:
        r2 = null;
        goto L9
    }

    public static void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        e = r2;
        if (z2.a.getRealtimeCallTranslatorConfig().e() == false) goto L6;
        a().storeString(a, r2);
        return;
    }

    public static void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        f = r2;
        if (z2.a.getRealtimeCallTranslatorConfig().e() == false) goto L6;
        a().storeString(b, r2);
        return;
    }
}
