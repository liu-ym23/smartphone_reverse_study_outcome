package com.bytedance.android.live.browser.jsbridge.protobuf;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ExternalProtobufShrinkConfigs {
    public static final Companion b = null;
    public final Map<String, Config> a;

    public static final class Companion extends AbstractChanneledRepo<ExternalProtobufShrinkConfigs> {
        public Companion() {
            super("protobuf/shrink_config.json", "", AnonymousClass1.INSTANCE);
        }
    }

    public static final class Config {
        public static final /* synthetic */ int e = 0;
        public final Map<Class<?>, a<?>> a;
        public final String b;
        public final Set<String> c;
        public final Map<String, Config> d;

        public static final class Companion {
            public static Config a(String r7, JsonObject r8) {
                Intrinsics.checkNotNullParameter(r7, "name");
                Intrinsics.checkNotNullParameter(r8, "jsonObject");
                JsonElement r1 = r8.get("keep");
                if (r1 == null) goto L12;
                JsonArray r2 = r1.getAsJsonArray();
                if (r2 == null) goto L12;
                Sequence r3 = CollectionsKt.asSequence(r2);
                if (r3 == null) goto L12;
                Sequence r4 = SequencesKt.map(r3, ExternalProtobufShrinkConfigs$Config$Companion$fromJsonObject$1.INSTANCE);
                if (r4 == null) goto L12;
                Set r5 = SequencesKt.toSet(r4);
                if (r5 == null) goto L12;
            L13:
                JsonElement r6 = r8.get("children");
                if (r6 == null) goto L19;
                final JsonObject r9 = r6.getAsJsonObject();
                if (r9 == null) goto L19;
                Map r11 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r9.keySet()), new ExternalProtobufShrinkConfigs$Config$Companion$$special$$inlined$shallowToMap$1(r9)));
                if (r11 == null) goto L19;
            L20:
                int r12 = a.a;
                Intrinsics.checkNotNullParameter(r8, "jsonObject");
                a[] r0 = new a[4];
                JsonElement r13 = r8.get("length");
                a.d r14 = null;
                if (r13 == null) goto L23;
                a.b r15 = new a.b(r13.getAsInt());
            L24:
                r0[0] = r15;
                JsonElement r16 = r8.get("config");
                if (r16 == null) goto L29;
                String r17 = r16.getAsString();
                if (r17 == null) goto L29;
                a.e r18 = new a.e(r17);
            L30:
                r0[1] = r18;
                JsonElement r19 = r8.get("map_keys");
                if (r19 == null) goto L35;
                JsonObject r21 = r19.getAsJsonObject();
                if (r21 == null) goto L35;
                int r22 = Config.e;
                a.c r23 = new a.c(a("__map_key", r21));
            L36:
                r0[2] = r23;
                JsonElement r24 = r8.get("map_values");
                if (r24 == null) goto L41;
                JsonObject r25 = r24.getAsJsonObject();
                if (r25 == null) goto L41;
                int r26 = Config.e;
                r14 = new a.d(a("__map_value", r25));
            L41:
                r0[3] = r14;
                return new Config(r7, r5, r11, SequencesKt.toSet(SequencesKt.filterNotNull(SequencesKt.sequenceOf(r0))));
            L35:
                r23 = null;
            L29:
                r18 = null;
                goto L30
            L23:
                r15 = null;
            L19:
                r11 = MapsKt.emptyMap();
            L12:
                r5 = SetsKt.emptySet();
                goto L13
            }
        }

        static {
        }

        public Config(String r2, Set<String> r3, Map<String, Config> r4, Collection<? extends a<?>> r5) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "keeps");
            Intrinsics.checkNotNullParameter(r4, "children");
            Intrinsics.checkNotNullParameter(r5, "options");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            if (r5.isEmpty() == false) goto L5;
            Map<Class<?>, a<?>> r6 = MapsKt.emptyMap();
        L10:
            this.a = r6;
            return;
        L5:
            Collection<? extends a<?>> r7 = r5;
            LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
            Iterator<T> r9 = r7.iterator();
        L7:
            if (r9.hasNext() == false) goto L9;
            Object r11 = r9.next();
            r8.put(((a) r11).getClass(), r11);
            goto L7
        L9:
            r6 = r8;
            goto L10
        }
    }

    public static abstract class a<T> {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs$a$a, reason: collision with other inner class name */
        public static final class C0122a {
        }

        public static final class b extends a<Integer> {
            public final int b;

            public b(int r1) {
                this.b = r1;
            }
        }

        public static final class c extends a<Config> {
            public final Config b;

            public c(Config r2) {
                Intrinsics.checkNotNullParameter(r2, "value");
                this.b = r2;
            }
        }

        public static final class d extends a<Config> {
            public final Config b;

            public d(Config r2) {
                Intrinsics.checkNotNullParameter(r2, "value");
                this.b = r2;
            }
        }

        public static final class e extends a<String> {
            public final String b;

            public e(String r2) {
                Intrinsics.checkNotNullParameter(r2, "value");
                this.b = r2;
            }
        }

        static {
        }

        public a() {
        }
    }

    static {
        b = new Companion();
    }

    public ExternalProtobufShrinkConfigs(BufferedReader r5) {
        final JsonObject r6 = GsonHelper.parser().parse(r5).getAsJsonObject();
        Map<String, Config> r7 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r6.keySet()), new ExternalProtobufShrinkConfigs$$special$$inlined$shallowToMap$1(r6)));
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r1 = r7.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((Config) r1.next(), r7, r0, true);
        goto L4
    L6:
        this.a = r0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs$mergedConfigs$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs$mergedConfigs$2] */
    public final Config a(final Config r8, final Map<String, Config> r9, final Map<String, Config> r11, boolean r12) {
        ?? r0 = new ExternalProtobufShrinkConfigs$mergedConfigs$1(this, r9, r11);
        ?? r1 = new ExternalProtobufShrinkConfigs$mergedConfigs$2(this, r9, r11);
        a.e r2 = (a.e) r8.a.get(a.e.class);
        if (r2 == null) goto L5;
        Config r3 = r11.get(r2.b);
        if (r3 != null) goto L20;
        Config r4 = r9.get(r2.b);
        if (r4 == null) goto L19;
        r3 = a(r4, r9, r11, true);
        goto L20
    L19:
        throw new IllegalArgumentException(("failed to find [" + r2.b + ']').toString());
    L20:
        Config r5 = new Config(r8.b, SetsKt.plus(r8.c, r3.c), MapsKt.toMap(r0.invoke(SequencesKt.plus(MapsKt.asSequence(r8.d), SequencesKt.filterNot(MapsKt.asSequence(r3.d), new ExternalProtobufShrinkConfigs$mergedConfigs$children$1(r8))))), SequencesKt.toSet(r1.invoke(SequencesKt.filterNot(CollectionsKt.asSequence(r3.a.entrySet()), new ExternalProtobufShrinkConfigs$mergedConfigs$options$1(r8)))));
        if (r12 == false) goto L23;
        r11.put(r5.b, r5);
    L23:
        return r5;
    L5:
        if (r8.d.isEmpty() == true) goto L7;
    L9:
        r8 = new Config(r8.b, r8.c, MapsKt.toMap(r0.invoke(MapsKt.asSequence(r8.d))), SequencesKt.toSet(r1.invoke(MapsKt.asSequence(r8.a))));
    L10:
        if (r12 == false) goto L12;
        r11.put(r8.b, r8);
    L12:
        return r8;
    L7:
        if (r8.a.isEmpty() == false) goto L9;
        goto L9
    }
}
