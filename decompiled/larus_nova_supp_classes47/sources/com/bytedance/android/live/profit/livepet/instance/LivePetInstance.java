package com.bytedance.android.live.profit.livepet.instance;

import android.net.Uri;
import com.bytedance.android.live.revenue.common.p;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.revenue.common.x0;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LivePetInstance {
    public final com.bytedance.android.live.revenue.common.reactive.c a;
    public ru0.b b;
    public u0 c;
    public final c d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/livepet/instance/LivePetInstance$State;", "", "Uninitialized", "Created", "Loading", "LoadCompleted", "LoadFailed", "Destroyed", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum State extends Enum<State> {
        public static final State Created = null;
        public static final State Destroyed = null;
        public static final State LoadCompleted = null;
        public static final State LoadFailed = null;
        public static final State Loading = null;
        public static final State Uninitialized = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("Uninitialized", 0);
            Uninitialized = r1;
            State r2 = new State("Created", 1);
            Created = r2;
            State r3 = new State("Loading", 2);
            Loading = r3;
            State r4 = new State("LoadCompleted", 3);
            LoadCompleted = r4;
            State r5 = new State("LoadFailed", 4);
            LoadFailed = r5;
            State r6 = new State("Destroyed", 5);
            Destroyed = r6;
            a = new State[]{r1, r2, r3, r4, r5, r6};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final State a() {
        return (State) this.a.b;
    }

    public final Uri b() {
        String r0 = this.d.b;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        x0 r1 = new x0(r0);
        x0 r2 = r1.d("url");
        qu0.a.c r3 = qu0.b.c.b(this.d.a);
        if (r3 == null) goto L8;
        LivePetInstance$appendUrlParams$petConfig$1 r4 = LivePetInstance$appendUrlParams$petConfig$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "factory");
        qu0.a.c r5 = (qu0.a.c) ((p) r4.invoke(r3.a.deepCopy()));
    L9:
        if (r5 == null) goto L22;
        r5.b.b(r5, qu0.a.c.c[0], null);
        Iterator r6 = CollectionsKt.toList(r5.a.entrySet()).iterator();
    L12:
        if (r6.hasNext() == false) goto L22;
        Map.Entry r7 = (Map.Entry) r6.next();
        String r8 = (String) r7.getKey();
        JsonElement r9 = (JsonElement) r7.getValue();
        Intrinsics.checkNotNullParameter(r9, "$this$convertToString");
        if ((r9 instanceof JsonNull) == false) goto L17;
        String r10 = null;
    L20:
        r2.b(r8, r10);
        goto L12
    L17:
        if ((r9 instanceof JsonPrimitive) == false) goto L19;
        r10 = r9.getAsString();
        goto L20
    L19:
        r10 = r9.toString();
    L22:
        return r1.c();
    L8:
        r5 = null;
        goto L9
    }

    public LivePetInstance(c r2) {
        Intrinsics.checkNotNullParameter(r2, "loadParams");
        this.d = r2;
        this.a = new com.bytedance.android.live.revenue.common.reactive.c(State.Uninitialized);
        this.c = u0.f;
    }
}
