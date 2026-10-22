package jh;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.apm.e;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.p;
import io.reactivex.internal.observers.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Keva f18344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Keva f18345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f18346c = null;
    public static long d;
    public static final AtomicBoolean e = null;

    static {
        f18346c = i.a();
        e = new AtomicBoolean(false);
    }

    public static final Keva a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Lazy r10 = Settings.B;
        if (p.a().m() == true) goto L6;
        return null;
    L6:
        if (e.get() == true) goto L8;
        return null;
    L8:
        Keva r11 = f18344a;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r11 = null;
    L12:
        if (r11.contains(r5) == false) goto L20;
        Keva r12 = f18344a;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r12 = null;
    L16:
        String r13 = r12.getString(r5, "");
        if (r13.length() <= 0) goto L20;
        return Keva.getRepo(r13);
    L20:
        return null;
    }

    public static final i4.a b(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Lazy r5 = Settings.B;
        if (p.a().m() == true) goto L6;
        return null;
    L6:
        if (e.get() == true) goto L9;
        return null;
    L9:
        if (d != 0) goto L11;
    L12:
        ((Handler) m.f7156b.getValue()).postDelayed(b.f18343a, 5000);
    L13:
        String r11 = j.k(r10, null);
        if (r11 != null) goto L16;
        return null;
    L16:
        Keva r12 = a(r11);
        if (r12 == null) goto L50;
        Keva r13 = f18344a;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r13 = null;
    L21:
        String[] r14 = r13.getStringArray(r11.concat("_extraVary"), null);
        if (r14 == null) goto L24;
        List r15 = ArraysKt.toList(r14);
    L25:
        if (r15 != null) goto L27;
    L37:
        String r16 = r11;
    L38:
        i4.a r17 = o(r12, r16);
        if (r17 == null) goto L43;
        if (com.lynx.tasm.utils.j.h(r17) == false) goto L43;
    L45:
        if (r17 == null) goto L50;
        if (com.lynx.tasm.utils.j.h(r17) == false) goto L50;
        j.y("[PIACacheManager][Query] Find Matched PIA Cache. (URL = " + r10 + ", CacheConfig = " + ((a) r17.d) + ')', null);
        return r17;
    L43:
        if (Intrinsics.areEqual(r16, r11) == true) goto L45;
        r17 = o(r12, r11);
        goto L45
    L27:
        if (r15.isEmpty() == true) goto L37;
        r16 = j.k(r10, r15);
        if (r16 == null) goto L37;
        if (r16.length() == 0) goto L37;
        if (l(r12, r16) == false) goto L37;
    L24:
        r15 = null;
    L50:
        j.y("[PIACacheManager][Query] Find No Matched PIA Cache. (URL = " + r10 + ')', null);
        return null;
    L11:
        if ((System.currentTimeMillis() - d) <= 60000) goto L13;
        goto L12
    }

    public static final a c(JsonObject r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Result.m124constructorimpl((a) i.a().fromJson(r5.getAsJsonObject("cache").toString(), a.class));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r11) == false) goto L9;
        r11 = null;
    L9:
        a r12 = (a) r11;
        if (r12 != null) goto L13;
        return null;
    L13:
        if (TextUtils.isEmpty(r12.g()) == false) goto L15;
        return null;
    L15:
        return r12;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void d() {
        Lazy r5 = Settings.B;
        if (p.a().m() == true) goto L6;
        return;
    L6:
        if (e.compareAndSet(false, true) == false) goto L9;
        f18344a = Keva.getRepo("pia_cache_index_repo");
        f18345b = Keva.getRepo("pia_cache_content_repo");
        j.y("[PIACacheManager]: Finish Init PIA Cache Pool.", null);
        return;
    }

    public static void e(Uri r5, i4.a r10, boolean r11) {
        if (r10 == null) goto L23;
        Lazy r12 = Settings.B;
        if (p.a().m() == false) goto L15;
        if (r5 == null) goto L15;
        String r13 = j.k(r5, null);
        if (r13 == null) goto L15;
        if (r13.length() == 0) goto L15;
        Keva r14 = a(r13);
    L16:
        if (r14 == null) goto L21;
        String r15 = (String) r10.f17502b;
        if (l(r14, r15) == false) goto L22;
        Boolean r16 = Boolean.valueOf(r11);
        a r17 = (a) r10.d;
        r17.b(r16);
        g(r15, r17.h(), (String) r10.f17503c, r14);
        j.y("[PIACacheManager] Finish Cache Mark. (URL: " + r15 + ", CacheConfig: " + r17 + ')', null);
        return;
    L22:
        return;
    L21:
        return;
    L15:
        r14 = null;
        goto L16
    }

    public static final void f(Uri r10, String r11, JsonObject r12, i4.a r13) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Lazy r5 = Settings.B;
        if (p.a().m() == true) goto L6;
        return;
    L6:
        if (e.get() == true) goto L8;
        return;
    L8:
        j.y("[PIACacheManager] Begin to Validate Cache. (URL: " + r10 + ')', null);
        m.b(new e(12, r11, r10, r12, r13));
    }

    public static void g(String r5, JsonObject r10, String r11, Keva r12) {
        Keva r13 = f18345b;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r13 = null;
    L5:
        monitor-enter(r13);
        r12.storeString(r5, r10.toString());     // Catch: Throwable -> L9
        Keva r14 = f18345b;     // Catch: Throwable -> L9
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");     // Catch: Throwable -> L9
        r14 = null;
    L11:
        r14.storeString(r5.concat("_headers"), r10.toString());     // Catch: Throwable -> L9
        Keva r15 = f18345b;     // Catch: Throwable -> L9
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");     // Catch: Throwable -> L9
        r15 = null;
    L14:
        r15.storeString(r5, r11);     // Catch: Throwable -> L9
        j.y("[PIACacheManager] Save Cache Success. (URL = " + r5 + ", CacheConfig: " + r10 + ')', null);     // Catch: Throwable -> L9
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r13);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void h(String r5, List r10) {
        Keva r11 = f18344a;
        Keva r12 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r11 = null;
    L5:
        r11.storeString(r5, UUID.randomUUID().toString());
        if (r10 == null) goto L17;
        Keva r13 = f18344a;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
    L11:
        String r14 = r5.concat("_extraVary");
        Object[] r15 = r10.toArray(new String[0]);
        if (r15 == null) goto L16;
        r12.storeStringArray(r14, (String[]) r15);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        r12 = r13;
        goto L11
    }

    public static final boolean i(Uri r10, String r11, JsonObject r12, List r13) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "content");
        Lazy r5 = Settings.B;
        boolean r14 = false;
        if (p.a().m() == true) goto L6;
        return false;
    L6:
        if (e.get() == true) goto L8;
        return false;
    L8:
        a r15 = c(r12);
        Keva r16 = null;
        if (r15 != null) goto L16;
        JsonObject r17 = j.t(r11);
        if (r17 != null) goto L13;
        r15 = null;
    L14:
        if (r15 != null) goto L16;
        return false;
    L13:
        r15 = c(r17);
    L16:
        Number r18 = r15.e();
        if (r18 == null) goto L19;
        long r19 = r18.longValue();
    L20:
        r15.c(Long.valueOf(System.currentTimeMillis() + (r19 * ((long) 1000))));
        r15.b(Boolean.FALSE);
        String r20 = j.k(r10, null);
        if (r20 == null) goto L69;
        String r21 = j.k(r10, r13);
        if (r21 == null) goto L69;
        Keva r22 = f18344a;
        if (r22 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r22 = null;
    L30:
        if (r22.contains(r20) == true) goto L32;
        h(r20, r13);
    L63:
        Keva r110 = a(r20);
        if (r110 == null) goto L69;
        if (l(r110, r21) == false) goto L68;
        j(r110, r21);
        r14 = true;
    L68:
        g(r21, r15.h(), r11, r110);
        goto L69
    L32:
        if (r13 == null) goto L63;
        Keva r23 = f18344a;
        if (r23 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r23 = null;
    L37:
        if (r23.contains(r20.concat("_extraVary")) == false) goto L54;
        Keva r24 = f18344a;
        if (r24 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r24 = null;
    L41:
        String[] r25 = r24.getStringArray(r20.concat("_extraVary"), null);
        if (r25 == null) goto L53;
        List r26 = ArraysKt.toList(r25);
        Intrinsics.checkNotNullParameter(r13, "first");
        Intrinsics.checkNotNullParameter(r26, "second");
        if (r13.isEmpty() == false) goto L49;
        if (r26.isEmpty() == false) goto L49;
        boolean r27 = true;
    L52:
        if (r27 == true) goto L63;
    L49:
        if (r13.size() == r26.size()) goto L51;
        r27 = false;
        goto L52
    L51:
        r27 = Intrinsics.areEqual(CollectionsKt.sorted(r13), CollectionsKt.sorted(r26));
    L53:
        n(r20);
        h(r20, r13);
        goto L63
    L54:
        Keva r28 = f18344a;
        if (r28 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
    L58:
        String r29 = r20.concat("_extraVary");
        Object[] r111 = r13.toArray(new String[0]);
        if (r111 == null) goto L62;
        r16.storeStringArray(r29, (String[]) r111);
        goto L63
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L57:
        r16 = r28;
    L69:
        return r14;
    L19:
        r19 = 600;
        goto L20
    }

    public static final boolean j(Keva r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "normalizeUrl");
        Intrinsics.checkNotNullParameter(r5, "configRepo");
        Lazy r11 = Settings.B;
        if (p.a().m() == true) goto L6;
        return false;
    L6:
        if (e.get() == true) goto L9;
        return false;
    L9:
        if (l(r5, r10) == false) goto L19;
        r5.erase(r10);
        Keva r12 = f18345b;
        Keva r13 = null;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r12 = null;
    L13:
        r12.erase(r10);
        Keva r14 = f18345b;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
    L17:
        r13.erase(h.b(r10, "_headers"));
        return true;
    L16:
        r13 = r14;
        goto L17
    L19:
        return false;
    }

    public static final String k(String r5) {
        Intrinsics.checkNotNullParameter(r5, "normalizeUrl");
        Lazy r10 = Settings.B;
        if (p.a().m() == true) goto L6;
        return null;
    L6:
        if (e.get() == true) goto L8;
        return null;
    L8:
        Keva r11 = f18345b;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r11 = null;
    L12:
        if (r11.contains(r5) == true) goto L14;
        return null;
    L14:
        Keva r12 = f18345b;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r12 = null;
    L17:
        String r13 = r12.getString(r5, "");
        if (r13 != null) goto L20;
    L23:
        return null;
    L20:
        if (r13.length() == 0) goto L23;
        return r13;
    }

    public static boolean l(Keva r5, String r10) {
        if (r5.contains(r10) == false) goto L11;
        Keva r11 = f18345b;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r11 = null;
    L8:
        if (r11.contains(r10) == false) goto L13;
        return true;
    L13:
        return false;
    L11:
        return false;
    }

    public static final a m(Keva r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "normalizeUrl");
        Lazy r11 = Settings.B;
        Object r12 = null;
        if (p.a().m() == true) goto L6;
        return null;
    L6:
        if (e.get() == true) goto L8;
        return null;
    L8:
        Keva r13 = f18345b;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r13 = null;
    L12:
        if (r13.contains(r10) == true) goto L14;
        return null;
    L14:
        Gson r14 = f18346c;
        if (r5 != null) goto L17;
        Keva r15 = f18345b;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r15 = null;
    L36:
        String r16 = r15.getString(h.b(r10, "_headers"), "");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L46
        JsonElement r18 = i.f7152b.parse(r16);     // Catch: Throwable -> L46
        if ((r18 instanceof JsonObject) == false) goto L40;
        JsonObject r19 = (JsonObject) r18;     // Catch: Throwable -> L46
    L41:
        if (r19 == null) goto L43;
        r12 = r14.fromJson(r19, a.class);     // Catch: Throwable -> L46
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.m124constructorimpl(r20);     // Catch: Throwable -> L46
    L49:
        return (a) r12;
    L43:
        r20 = null;
        goto L44
    L40:
        r19 = null;
    L46:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L49
    L17:
        if (r5.contains(r10) == true) goto L19;
        return null;
    L19:
        String r22 = r5.getString(r10, "");
        if (r22 != null) goto L22;
    L32:
        return null;
    L22:
        if (r22.length() == 0) goto L32;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L26
        Object r24 = Result.m124constructorimpl((a) r14.fromJson(r22, a.class));     // Catch: Throwable -> L26
    L29:
        if (Result.m130isFailureimpl(r24) == true) goto L49;
        r12 = r24;
    L26:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    public static void n(String r5) {
        j.y("[PIACacheManager] Remove ALL Cache. (URL: " + r5 + ')', null);
        Keva r10 = a(r5);
        if (r10 == null) goto L9;
        Map<String, ?> r11 = r10.getAll();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        Iterator<Map.Entry<String, ?>> r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        j(r10, r12.next().getKey());
        goto L6
    L8:
        r10.clear();
    L9:
        p(r5);
    }

    public static final i4.a o(Keva r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "normalizeUrl");
        Intrinsics.checkNotNullParameter(r5, "configRepo");
        Lazy r11 = Settings.B;
        if (p.a().m() == true) goto L6;
        return null;
    L6:
        if (e.get() == true) goto L9;
        return null;
    L9:
        if (l(r5, r10) == true) goto L11;
        return null;
    L11:
        a r12 = m(r5, r10);
        if (r12 != null) goto L14;
        return null;
    L14:
        String r13 = k(r10);
        if (r13 != null) goto L18;
        return null;
    L18:
        return new i4.a(r10, 6, r13, r12);
    }

    public static void p(String r5) {
        Keva r10 = f18344a;
        Keva r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r10 = null;
    L5:
        r10.erase(r5);
        Keva r12 = f18344a;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
    L9:
        r11.erase(r5.concat("_extraVary"));
        return;
    L8:
        r11 = r12;
        goto L9
    }
}
