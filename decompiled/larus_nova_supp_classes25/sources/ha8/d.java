package ha8;

import android.content.Context;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.avlink.n1;
import com.larus.avlink.simulInterpret.page.model.TextType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ea8.w;
import ea8.x;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static boolean a;
    public static volatile String b;
    public static final CopyOnWriteArrayList<w> c = null;
    public static final CopyOnWriteArrayList<w> d = null;
    public static Function1<? super x, Unit> e;
    public static Function1<? super x, Unit> f;
    public static final CopyOnWriteArrayList<Function1<Boolean, Unit>> g = null;
    public static Function1<? super Boolean, Unit> h;
    public static Function1<? super w, Unit> i;
    public static Function1<? super w, Unit> j;
    public static final Lazy k = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TextType.values().length];
            r0[TextType.ORIGINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TextType.TRANSLATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        b = "";
        c = new CopyOnWriteArrayList();
        d = new CopyOnWriteArrayList();
        g = new CopyOnWriteArrayList();
        k = LazyKt.lazy(new c());
    }

    public static String c() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.b0() != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        return DoraConfig.c();
    L13:
        return DoraConfig.a();
    L9:
        r2 = false;
        goto L10
    }

    public static String d() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.b0() != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        return DoraConfig.d();
    L13:
        return DoraConfig.b();
    L9:
        r2 = false;
        goto L10
    }

    public static void a(w r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        CopyOnWriteArrayList<w> r0 = d;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r4.a) == false) goto L4;
        int r2 = r1.nextIndex();
    L9:
        if (r2 == (-1)) goto L11;
        d.set(r2, r4);
    L11:
        Function1<? super w, Unit> r3 = j;
        if (r3 == null) goto L18;
        Unit r5 = (Unit) r3.invoke(r4);
        return;
    L18:
        return;
    L8:
        r2 = -1;
        goto L9
    }

    public static void b(w r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        CopyOnWriteArrayList<w> r0 = c;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r4.a) == false) goto L4;
        int r2 = r1.nextIndex();
    L9:
        if (r2 == (-1)) goto L11;
        c.set(r2, r4);
    L11:
        Function1<? super w, Unit> r3 = i;
        if (r3 == null) goto L18;
        Unit r5 = (Unit) r3.invoke(r4);
        return;
    L18:
        return;
    L8:
        r2 = -1;
        goto L9
    }

    public static void f(x r7) {
        Intrinsics.checkNotNullParameter(r7, "resultSentence");
        CopyOnWriteArrayList<w> r0 = d;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r7.b) == false) goto L4;
        int r2 = r1.nextIndex();
    L10:
        if (r2 == (-1)) goto L19;
        CopyOnWriteArrayList<w> r3 = d;
        w r4 = r3.get(r2);
        int r5 = a.a[r7.getType().ordinal()];
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L16;
        w r6 = w.a(r4, null, StringsKt.trim(r4.c + r7.c).toString(), 3);
    L18:
        r3.set(r2, r6);
    L27:
        Function1<? super x, Unit> r8 = f;
        if (r8 == null) goto L34;
        Unit r9 = (Unit) r8.invoke(r7);
        return;
    L34:
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r6 = w.a(r4, StringsKt.trim(r4.b + r7.c).toString(), null, 5);
        goto L18
    L19:
        int r10 = a.a[r7.getType().ordinal()];
        if (r10 == 1) goto L25;
        if (r10 != 2) goto L24;
        w r11 = new w(r7.b, "", StringsKt.trim(r7.c).toString());
    L26:
        d.add(r11);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r11 = new w(r7.b, StringsKt.trim(r7.c).toString(), "");
        goto L26
    L8:
        r2 = -1;
        goto L10
    }

    public static void g(x r7) {
        Intrinsics.checkNotNullParameter(r7, "resultSentence");
        CopyOnWriteArrayList<w> r0 = c;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r7.b) == false) goto L4;
        int r2 = r1.nextIndex();
    L10:
        if (r2 == (-1)) goto L19;
        CopyOnWriteArrayList<w> r3 = c;
        w r4 = r3.get(r2);
        int r5 = a.a[r7.getType().ordinal()];
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L16;
        w r6 = w.a(r4, null, StringsKt.trim(r4.c + r7.c).toString(), 3);
    L18:
        r3.set(r2, r6);
    L27:
        Function1<? super x, Unit> r8 = e;
        if (r8 == null) goto L34;
        Unit r9 = (Unit) r8.invoke(r7);
        return;
    L34:
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r6 = w.a(r4, StringsKt.trim(r4.b + r7.c).toString(), null, 5);
        goto L18
    L19:
        int r10 = a.a[r7.getType().ordinal()];
        if (r10 == 1) goto L25;
        if (r10 != 2) goto L24;
        w r11 = new w(r7.b, "", StringsKt.trim(r7.c).toString());
    L26:
        c.add(r11);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r11 = new w(r7.b, StringsKt.trim(r7.c).toString(), "");
        goto L26
    L8:
        r2 = -1;
        goto L10
    }

    public static void h(boolean r3) {
        a = r3;
        c.clear();
        d.clear();
        Iterator<Function1<Boolean, Unit>> r0 = g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().invoke(Boolean.valueOf(r3));
        goto L4
    }

    public static void e(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7 != null) goto L7;
        String r0 = a98.a.c;
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        boolean r2 = false;
        if (StringsKt.contains$default(r0, "female", false, 2, null) == false) goto L12;
    L14:
        r2 = true;
    L15:
        n1.d("SimultaneousInterpretSettingManager", "styleName is " + r7 + ", botStyleId is " + a98.a.c + ", isFemaleTimbre is " + r2);
        if (r2 == false) goto L18;
        String r8 = "simulInterpret_female_start_error_music.mp3";
    L19:
        SoundPlayManager.e((SoundPlayManager) k.getValue(), r6, r8, true, null);
        return;
    L18:
        r8 = "simulInterpret_male_start_error_music.mp3";
        goto L19
    L12:
        if (StringsKt.contains$default(r0, "male", false, 2, null) == false) goto L14;
    L7:
        r0 = r7;
        goto L8
    }
}
