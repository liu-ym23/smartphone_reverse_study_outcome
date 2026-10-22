package com.bytedance.android.annie.protobuf;

import android.util.SparseArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ExternalProtobufMessageDefinitions {
    public static final Companion b = null;
    public final Map<String, Message> a;

    public static final class Companion extends AbstractChanneledRepo<ExternalProtobufMessageDefinitions> {
        public Companion() {
            super("protobuf/definitions.json", "protobuf/definitions_v2.json", AnonymousClass1.INSTANCE);
        }
    }

    public static final class Message {
        public final SparseArray<a> a;

        public Message() {
            throw null;
        }

        public Message(String r13, final JsonObject r14) {
            Intrinsics.checkNotNullParameter(r13, "fqName");
            Intrinsics.checkNotNullParameter(r14, "jsonObject");
            SparseArray<a> r0 = new SparseArray(r14.size());
            Iterator r15 = SequencesKt.map(CollectionsKt.asSequence(r14.keySet()), new ExternalProtobufMessageDefinitions$Message$1$1(r14)).iterator();
        L4:
            if (r15.hasNext() == false) goto L25;
            Pair r1 = (Pair) r15.next();
            String r10 = (String) r1.component1();
            JsonObject r11 = (JsonObject) r1.component2();
            int r12 = a.g;
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r11, "jsonObject");
            int r16 = r11.get("i").getAsInt();
            int r17 = r11.get("t").getAsInt();
            JsonElement r18 = r11.get("r");
            if (r18 == null) goto L8;
            boolean r19 = r18.getAsBoolean();
        L9:
            Pair r20 = null;
            if (r17 != 20) goto L12;
            String r21 = r11.get("fq").getAsString();
        L24:
            a r22 = new a(r10, r16, r17, r19, r21, r20);
            r0.put(r22.b, r22);
            goto L4
        L12:
            if (r17 == 21) goto L14;
            r21 = null;
            goto L24
        L14:
            JsonObject r23 = r11.get("k").getAsJsonObject();
            int r110 = r23.get("t").getAsInt();
            JsonElement r24 = r23.get("fq");
            if (r24 == null) goto L17;
            String r25 = r24.getAsString();
        L18:
            a.b r111 = new a.b(r110, r25);
            JsonObject r26 = r11.get("v").getAsJsonObject();
            int r27 = r26.get("t").getAsInt();
            JsonElement r28 = r26.get("fq");
            if (r28 == null) goto L21;
            String r29 = r28.getAsString();
        L22:
            r21 = null;
            r20 = new Pair(r111, new a.c(r27, r29));
            goto L24
        L21:
            r29 = null;
            goto L22
        L17:
            r25 = null;
            goto L18
        L8:
            r19 = false;
            goto L9
        L25:
            Unit r112 = Unit.INSTANCE;
            this.a = r0;
        }
    }

    public static class a {
        public static final /* synthetic */ int g = 0;
        public final String a;
        public final int b;
        public final int c;
        public final boolean d;
        public final String e;
        public final Pair<b, c> f;

        /* JADX INFO: renamed from: com.bytedance.android.annie.protobuf.ExternalProtobufMessageDefinitions$a$a, reason: collision with other inner class name */
        public static final class C0075a {
        }

        public static final class b extends a {
            public b(int r10, String r11) {
                super("_map_key", 1, r10, r11);
            }
        }

        public static final class c extends a {
            public c(int r10, String r11) {
                super("_map_value", 2, r10, r11);
            }
        }

        static {
        }

        public final int getType() {
            return this.c;
        }

        public /* synthetic */ a(String r10, int r11, int r12, String r13) {
            this(r10, r11, r12, false, r13, null);
        }

        public a(String r10, int r11, int r12, boolean r13, String r14, Pair<b, c> r15) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
        }
    }

    static {
        b = new Companion();
    }

    public final Message a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return this.a.get(r10);
    }

    public ExternalProtobufMessageDefinitions(String r10, final JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        Intrinsics.checkNotNullParameter(r11, "defJson");
        this.a = MapsKt.toMutableMap(MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r11.keySet()), new ExternalProtobufMessageDefinitions$special$$inlined$shallowToMap$1(r11))));
    }
}
