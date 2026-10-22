package com.larus.browsertakeover.signaling;

import android.os.Handler;
import android.os.Looper;
import com.larus.im.internal.jni.bean.RoomMeta;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LocalPcSignaling {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/browsertakeover/signaling/LocalPcSignaling$Failure;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_TARGET", "HTTP_REJECTED", "INVALID_ROOM_META", "PEER_REJECTED", "TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Failure extends Enum<Failure> {
        public static final Failure HTTP_REJECTED = null;
        public static final Failure INVALID_ROOM_META = null;
        public static final Failure INVALID_TARGET = null;
        public static final Failure PEER_REJECTED = null;
        public static final Failure TIMEOUT = null;
        public static final /* synthetic */ Failure[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Failure> getEntries() {
            return b;
        }

        static {
            Failure r0 = new Failure("INVALID_TARGET", 0);
            INVALID_TARGET = r0;
            Failure r1 = new Failure("HTTP_REJECTED", 1);
            HTTP_REJECTED = r1;
            Failure r3 = new Failure("INVALID_ROOM_META", 2);
            INVALID_ROOM_META = r3;
            Failure r5 = new Failure("PEER_REJECTED", 3);
            PEER_REJECTED = r5;
            Failure r7 = new Failure("TIMEOUT", 4);
            TIMEOUT = r7;
            Failure[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static Failure[] values() {
            return (Failure[]) a.clone();
        }

        public static Failure valueOf(String r1) {
            return (Failure) r27.a.a(Failure.class, r1);
        }

        public Failure(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void cancel();
    }

    public static final class b implements a {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final Map<String, String> e;
        public Function1<? super RoomMeta, Unit> f;
        public Function1<? super Failure, Unit> g;
        public final Handler h;
        public final String i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public final c n;
        public final f o;

        public final void a() {
            if (this.j == false) goto L5;
            return;
        L5:
            this.j = true;
            this.h.removeCallbacks(this.n);
            if (this.m == false) goto L9;
            this.m = false;
            com.larus.im.d.b().unregisterDispatchCommandListener(this.o);
        L9:
            this.f = null;
            this.g = null;
        }

        @Override // com.larus.browsertakeover.signaling.LocalPcSignaling.a
        public final void cancel() {
            c(new com.larus.browsertakeover.signaling.b(this));
        }

        public final void b(Failure r2) {
            if (this.j == false) goto L5;
            return;
        L5:
            Function1<? super Failure, Unit> r0 = this.g;
            a();
            if (r0 == null) goto L9;
            r0.invoke(r2);
            return;
        }

        public final void c(final Function0<Unit> r3) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            r3.invoke();
            return;
        L5:
            this.h.post(new d(r3));
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.browsertakeover.signaling.c] */
        public b(String r2, int r3, String r4, String r5, Map r6, com.larus.browsertakeover.session.b r7, com.larus.browsertakeover.session.c r8) {
            Intrinsics.checkNotNullParameter(r2, "deviceId");
            Intrinsics.checkNotNullParameter(r4, "sourceDeviceId");
            Intrinsics.checkNotNullParameter(r5, "conversationId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = new Handler(Looper.getMainLooper());
            this.i = UUID.randomUUID().toString();
            this.n = new c(this);
            this.o = new f(this);
        }
    }

    static {
    }
}
