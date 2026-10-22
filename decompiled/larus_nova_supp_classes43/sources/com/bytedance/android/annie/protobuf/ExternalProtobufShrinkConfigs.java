package com.bytedance.android.annie.protobuf;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
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
        public final String a;
        public final Set<String> b;
        public final Map<String, Config> c;
        public final Map<Class<?>, a<?>> d;

        public static final class Companion {
            public static Config a(String r10, JsonObject r11) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
                Intrinsics.checkNotNullParameter(r11, "jsonObject");
                JsonElement r1 = r11.get("keep");
                if (r1 == null) goto L13;
                JsonArray r12 = r1.getAsJsonArray();
                if (r12 == null) goto L13;
                Sequence r13 = CollectionsKt.asSequence(r12);
                if (r13 == null) goto L13;
                Sequence r14 = SequencesKt.map(r13, ExternalProtobufShrinkConfigs$Config$Companion$fromJsonObject$1.INSTANCE);
                if (r14 == null) goto L13;
                Set r15 = SequencesKt.toSet(r14);
                if (r15 == null) goto L13;
            L14:
                JsonElement r16 = r11.get("children");
                if (r16 == null) goto L21;
                final JsonObject r17 = r16.getAsJsonObject();
                if (r17 == null) goto L21;
                Map r18 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r17.keySet()), new ExternalProtobufShrinkConfigs$Config$Companion$fromJsonObject$lambda$1$$inlined$shallowToMap$1(r17)));
                if (r18 == null) goto L21;
            L22:
                int r19 = a.a;
                Intrinsics.checkNotNullParameter(r11, "jsonObject");
                a[] r0 = new a[4];
                JsonElement r20 = r11.get("length");
                a.d r21 = null;
                if (r20 == null) goto L25;
                a.b r22 = new a.b(r20.getAsInt());
            L26:
                r0[0] = r22;
                JsonElement r23 = r11.get("config");
                if (r23 == null) goto L31;
                String r24 = r23.getAsString();
                if (r24 == null) goto L31;
                a.e r25 = new a.e(r24);
            L32:
                r0[1] = r25;
                JsonElement r26 = r11.get("map_keys");
                if (r26 == null) goto L37;
                JsonObject r27 = r26.getAsJsonObject();
                if (r27 == null) goto L37;
                int r28 = Config.e;
                a.c r29 = new a.c(a("__map_key", r27));
            L38:
                r0[2] = r29;
                JsonElement r30 = r11.get("map_values");
                if (r30 == null) goto L43;
                JsonObject r31 = r30.getAsJsonObject();
                if (r31 == null) goto L43;
                int r32 = Config.e;
                r21 = new a.d(a("__map_value", r31));
            L43:
                r0[3] = r21;
                return new Config(r10, r15, r18, SequencesKt.toSet(SequencesKt.filterNotNull(SequencesKt.sequenceOf(r0))));
            L37:
                r29 = null;
            L31:
                r25 = null;
                goto L32
            L25:
                r22 = null;
            L21:
                r18 = MapsKt.emptyMap();
            L13:
                r15 = SetsKt.emptySet();
                goto L14
            }
        }

        static {
        }

        public Config(String r10, Set<String> r11, Map<String, Config> r12, Collection<? extends a<?>> r13) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r11, "keeps");
            Intrinsics.checkNotNullParameter(r12, "children");
            Intrinsics.checkNotNullParameter(r13, "options");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            if (r13.isEmpty() == false) goto L5;
            Map<Class<?>, a<?>> r14 = MapsKt.emptyMap();
        L10:
            this.d = r14;
            return;
        L5:
            Collection<? extends a<?>> r15 = r13;
            LinkedHashMap r16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
            Iterator<T> r17 = r15.iterator();
        L7:
            if (r17.hasNext() == false) goto L9;
            Object r18 = r17.next();
            r16.put(((a) r18).getClass(), r18);
            goto L7
        L9:
            r14 = r16;
            goto L10
        }
    }

    public static abstract class a<T> {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.annie.protobuf.ExternalProtobufShrinkConfigs$a$a, reason: collision with other inner class name */
        public static final class C0076a {
        }

        public static final class b extends a<Integer> {
            public final int b;

            public b(int r1) {
                this.b = r1;
            }
        }

        public static final class c extends a<Config> {
            public final Config b;

            public c(Config r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
                this.b = r10;
            }
        }

        public static final class d extends a<Config> {
            public final Config b;

            public d(Config r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
                this.b = r10;
            }
        }

        public static final class e extends a<String> {
            public final String b;

            public e(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
                this.b = r10;
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

    public ExternalProtobufShrinkConfigs(String r10, final JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        Intrinsics.checkNotNullParameter(r11, "shrinkJson");
        Map<String, Config> r12 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r11.keySet()), new ExternalProtobufShrinkConfigs$special$$inlined$shallowToMap$1(r11)));
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<T> r0 = r12.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((Config) r0.next(), r12, r13, true);
        goto L4
    L6:
        this.a = r13;
    }

    public final Config a(final Config r10, final Map<String, Config> r11, final Map<String, Config> r12, boolean r13) {
        a.e r0 = (a.e) r10.d.get(a.e.class);
        if (r0 == null) goto L5;
        Config r1 = r12.get(r0.b);
        if (r1 != null) goto L20;
        Config r14 = r11.get(r0.b);
        if (r14 == null) goto L19;
        r1 = a(r14, r11, r12, true);
        goto L20
    L19:
        throw new IllegalArgumentException(("failed to find [" + r0.b + ']').toString());
    L20:
        Config r15 = new Config(r10.a, SetsKt.plus(r10.b, r1.b), MapsKt.toMap(SequencesKt.map(SequencesKt.plus(MapsKt.asSequence(r10.c), SequencesKt.filterNot(MapsKt.asSequence(r1.c), new ExternalProtobufShrinkConfigs$mergedConfigs$children$1(r10))), new ExternalProtobufShrinkConfigs$mergedConfigs$traverse$1(this, r11, r12))), SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.filterNot(CollectionsKt.asSequence(r1.d.entrySet()), new ExternalProtobufShrinkConfigs$mergedConfigs$options$1(r10)), new ExternalProtobufShrinkConfigs$mergedConfigs$traverse$2(this, r11, r12))));
        if (r13 == false) goto L23;
        r12.put(r15.a, r15);
    L23:
        return r15;
    L5:
        if (r10.c.isEmpty() == true) goto L7;
    L9:
        r10 = new Config(r10.a, r10.b, MapsKt.toMap(SequencesKt.map(MapsKt.asSequence(r10.c), new ExternalProtobufShrinkConfigs$mergedConfigs$traverse$1(this, r11, r12))), SequencesKt.toSet(SequencesKt.mapNotNull(MapsKt.asSequence(r10.d), new ExternalProtobufShrinkConfigs$mergedConfigs$traverse$2(this, r11, r12))));
    L10:
        if (r13 == false) goto L12;
        r12.put(r10.a, r10);
    L12:
        return r10;
    L7:
        if (r10.d.isEmpty() == false) goto L9;
        goto L9
    }
}
