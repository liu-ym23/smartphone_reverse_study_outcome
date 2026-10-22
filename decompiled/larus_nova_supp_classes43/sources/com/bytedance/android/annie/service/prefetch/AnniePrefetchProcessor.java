package com.bytedance.android.annie.service.prefetch;

import android.net.Uri;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnniePrefetchProcessor {
    public Map<String, x46.a> a;
    public final Lazy b;
    public t c;

    public static final class a {
    }

    public static final class b implements Executor {
        public static final b a = null;

        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r1) {
                ((Runnable) r1).run();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.annie.service.prefetch.AnniePrefetchProcessor$b$b, reason: collision with other inner class name */
        public static final class C0083b<T> implements Consumer {
            public static final C0083b<T> a = null;

            static {
                a = new C0083b();
            }

            public C0083b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r10 = (Throwable) r1;
            }
        }

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r10) {
            Observable.just(r10).subscribeOn(Schedulers.io()).subscribe(a.a, C0083b.a);
        }
    }

    public static final class c implements com.bytedance.ies.tools.prefetch.g {
        public final /* synthetic */ List<String> a;

        public final List<String> a() {
            return this.a;
        }

        public c(List<String> r1) {
            this.a = r1;
        }
    }

    static {
    }

    public AnniePrefetchProcessor() {
        this.a = MapsKt.emptyMap();
        this.b = LazyKt.lazy(AnniePrefetchProcessor$providers$2.INSTANCE);
    }

    public final String a(final String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        int r0 = x8.a.a;
        x8.a.d("AnniePrefetchProcessor", "getChannelFrom(url=" + r10 + ')', false);
        Object r11 = null;
        if (AnnieConfigSettingKeys.ANNIE_TRY_FIX_PREFETCH_OUT_OF_INDEX.a().booleanValue() == false) goto L56;
        x8.a.d("AnniePrefetchProcessor", "getChannelFromFixed(url=" + r10 + ')', false);
        Uri r1 = UriProtector.parse(r10);
        if (r1.isHierarchical() == false) goto L7;
        final String r12 = r1.getHost() + r1.getPath();
    L9:
        if (r12.length() != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L58;
        x8.a.b("AnniePrefetchProcessor", "getChannelFromFixed, invalid url=" + r10, false);
        return null;
    L58:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L24
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L24
        Iterator<T> r16 = AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a().iterator();     // Catch: Throwable -> L24
    L16:
        if (r16.hasNext() == false) goto L18;
        r15.add(PatternProtector.compile((String) r16.next()));     // Catch: Throwable -> L24
        goto L16
    L18:
        Matcher r17 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r15), new AnniePrefetchProcessor$getChannelFromFixed$1$2(r12)), AnniePrefetchProcessor$getChannelFromFixed$1$3.INSTANCE));     // Catch: Throwable -> L24
        if (r17 == null) goto L21;
        String r18 = StringsKt.substringBefore$default(b(r12, r17), '/', null, 2, null);     // Catch: Throwable -> L24
    L22:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L24
    L26:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L30;
        int r21 = x8.a.a;
        x8.a.b("AnniePrefetchProcessor", "getChannelFromFixed Failure, exception=" + r20.getMessage(), false);
    L30:
        if (Result.isFailure-impl(r19) == true) goto L34;
        r11 = r19;
    L34:
        return (String) r11;
    L21:
        r18 = null;
    L24:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L11:
        r13 = false;
        goto L12
    L7:
        r12 = toString();
        goto L9
    L56:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L45
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L45
        Iterator<T> r25 = AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a().iterator();     // Catch: Throwable -> L45
    L37:
        if (r25.hasNext() == false) goto L39;
        r24.add(PatternProtector.compile((String) r25.next()));     // Catch: Throwable -> L45
        goto L37
    L39:
        Matcher r26 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r24), new AnniePrefetchProcessor$getChannelFrom$1$2(r10)), AnniePrefetchProcessor$getChannelFrom$1$3.INSTANCE));     // Catch: Throwable -> L45
        if (r26 == null) goto L42;
        String r27 = StringsKt.substringBefore$default(b(r10, r26), '/', null, 2, null);     // Catch: Throwable -> L45
    L43:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L45
    L47:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L51;
        int r30 = x8.a.a;
        x8.a.b("AnniePrefetchProcessor", "getChannelFrom Failure, exception=" + r29.getMessage(), false);
    L51:
        if (Result.isFailure-impl(r28) == true) goto L55;
        r11 = r28;
    L55:
        return (String) r11;
    L42:
        r27 = null;
    L45:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    }

    public final x46.a d(String r10) {
        if (r10 == null) goto L9;
        x46.a r11 = this.a.get(a(r10));
        if (r11 != null) goto L8;
        r11 = this.a.get(null);
    L8:
        return r11;
    L9:
        return null;
    }

    public static String b(String r10, Matcher r11) {
        int r0 = StringsKt.indexOf$default(r10, "?", 0, false, 6, null);
        int r1 = StringsKt.indexOf$default(r10, "#", 0, false, 6, null);
        Integer r12 = Integer.valueOf(RangesKt.coerceAtMost(r0, r1));
        if (r12.intValue() < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L9;
        r12 = null;
    L9:
        if (r12 == null) goto L11;
        int r14 = r12.intValue();
    L13:
        if (r14 == (-1)) goto L19;
        int r15 = r11.end();
        if (r10 == null) goto L18;
        String r16 = r10.substring(r15, r14);
    L23:
        return StringsKt.trim(r16, new char[]{'/'});
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        int r17 = r11.end();
        if (r10 == null) goto L25;
        r16 = r10.substring(r17);
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        r14 = RangesKt.coerceAtLeast(r0, r1);
        goto L13
    L5:
        r13 = false;
        goto L6
    }

    public static final x46.a c(AnniePrefetchProcessor r1, List<String> r10) {
        x46.a r0 = x46.a.b;
        t r11 = r1.c;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r11 = null;
    L5:
        r11.getClass();
        x46.a.b r12 = new x46.a.b();
        com.bytedance.android.anniex.assemble.a.h();
        ((com.bytedance.ies.tools.prefetch.a) r12).e = false;
        ((com.bytedance.ies.tools.prefetch.a) r12).b = b.a;
        ((com.bytedance.ies.tools.prefetch.a) r12).d = new c(r10);
        ((com.bytedance.ies.tools.prefetch.a) r12).c = new PrefetchNetworkExecutorImpl();
        return r12.a();
    }
}
