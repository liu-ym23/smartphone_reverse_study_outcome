package com.bytedance.android.live.browser.jsbridge.protobuf;

import android.util.SparseArray;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
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
            Iterator r15 = SequencesKt.map(CollectionsKt.asSequence(r14.keySet()), new ExternalProtobufMessageDefinitions$Message$$special$$inlined$also$lambda$1(r14)).iterator();
        L4:
            if (r15.hasNext() == false) goto L25;
            Pair r1 = (Pair) r15.next();
            String r4 = (String) r1.component1();
            JsonObject r2 = (JsonObject) r1.component2();
            int r3 = a.g;
            Intrinsics.checkNotNullParameter(r4, "name");
            Intrinsics.checkNotNullParameter(r2, "jsonObject");
            int r5 = r2.get("i").getAsInt();
            int r6 = r2.get("t").getAsInt();
            JsonElement r7 = r2.get("r");
            if (r7 == null) goto L8;
            boolean r8 = r7.getAsBoolean();
        L9:
            Pair r9 = null;
            if (r6 != 20) goto L12;
            String r11 = r2.get("fq").getAsString();
        L24:
            a r12 = new a(r4, r5, r6, r8, r11, r9);
            r0.put(r12.b, r12);
            goto L4
        L12:
            if (r6 == 21) goto L14;
            r11 = null;
            goto L24
        L14:
            JsonObject r16 = r2.get("k").getAsJsonObject();
            int r17 = r16.get("t").getAsInt();
            JsonElement r18 = r16.get("fq");
            if (r18 == null) goto L17;
            String r19 = r18.getAsString();
        L18:
            a.b r110 = new a.b(r17, r19);
            JsonObject r21 = r2.get("v").getAsJsonObject();
            int r22 = r21.get("t").getAsInt();
            JsonElement r23 = r21.get("fq");
            if (r23 == null) goto L21;
            String r24 = r23.getAsString();
        L22:
            r11 = null;
            r9 = new Pair(r110, new a.c(r22, r24));
            goto L24
        L21:
            r24 = null;
            goto L22
        L17:
            r19 = null;
            goto L18
        L8:
            r8 = false;
            goto L9
        L25:
            Unit r111 = Unit.INSTANCE;
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

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufMessageDefinitions$a$a, reason: collision with other inner class name */
        public static final class C0121a {
        }

        public static final class b extends a {
            public b(int r3, String r4) {
                super("_map_key", 1, r3, r4);
            }
        }

        public static final class c extends a {
            public c(int r3, String r4) {
                super("_map_value", 2, r3, r4);
            }
        }

        static {
        }

        public final int getType() {
            return this.c;
        }

        public /* synthetic */ a(String r8, int r9, int r11, String r12) {
            this(r8, r9, r11, false, r12, null);
        }

        public a(String r2, int r3, int r4, boolean r5, String r6, Pair<b, c> r7) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    static {
        b = new Companion();
    }

    public ExternalProtobufMessageDefinitions(BufferedReader r3) {
        final JsonObject r4 = GsonHelper.parser().parse(r3).getAsJsonObject();
        this.a = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(r4.keySet()), new ExternalProtobufMessageDefinitions$$special$$inlined$shallowToMap$1(r4)));
    }

    public final Message a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return this.a.get(r2);
    }
}
