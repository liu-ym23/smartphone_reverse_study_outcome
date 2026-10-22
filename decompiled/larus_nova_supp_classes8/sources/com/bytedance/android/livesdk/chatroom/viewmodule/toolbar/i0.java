package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 {
    public static final List<String> d = null;
    public static final b e = null;
    public final g a;
    public f b;
    public final List<d> c;

    public static final class a implements d {
        public final String a;
        public boolean b;
        public JSONObject c;
        public final String d;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final Map<String, Object> getResult() {
            JSONObject r0 = this.c;
            if (r0 == null) goto L7;
            Map<String, Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(this.a, r0)});
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new LinkedHashMap();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final boolean isFinished() {
            return this.b;
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "urlPath");
            this.d = r2;
            this.a = "beats";
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final void a(g r4) {
            Intrinsics.checkNotNullParameter(r4, "callBack");
            int r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a(this.d, new h0(this, r4), null, 4);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements d {
        public final String a;
        public boolean b;
        public String c;
        public final String d;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final Map<String, Object> getResult() {
            if (this.c.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return new LinkedHashMap();
        L9:
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(this.a, this.c)});
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final boolean isFinished() {
            return this.b;
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "urlPath");
            this.d = r2;
            this.a = "cover";
            this.c = "";
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final void a(g r4) {
            Intrinsics.checkNotNullParameter(r4, "callBack");
            int r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a(this.d, null, new m0(this, r4), 2);
        }
    }

    public interface d {
        void a(g r1);

        Map<String, Object> getResult();

        boolean isFinished();
    }

    public static final class e implements d {
        public final String a;
        public Disposable b;
        public JSONArray c;
        public boolean d;
        public final String e;
        public final int f;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final Map<String, Object> getResult() {
            JSONArray r0 = this.c;
            if (r0 == null) goto L7;
            String r2 = this.a;
            Intrinsics.checkNotNull(r0);
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r2, r0)});
        L7:
            return new LinkedHashMap();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final boolean isFinished() {
            return this.d;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final void a(g r4) {
            Intrinsics.checkNotNullParameter(r4, "callBack");
            this.b = Single.create(new n0(this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o0(this, r4), new p0(this, r4));
        }

        public e(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "localPath");
            this.e = r2;
            this.f = r3;
            this.a = "lyrics";
        }
    }

    public interface f {
        void onFinish();
    }

    public static final class g implements f {
        public final /* synthetic */ i0 a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.f
        public final void onFinish() {
            List<d> r0 = this.a.c;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            Object r3 = r2.next();
            if ((!((d) r3).isFinished()) == false) goto L4;
            r1.add(r3);
            goto L4
        L9:
            if (r1.isEmpty() == false) goto L19;
            f r4 = this.a.b;
            if (r4 == null) goto L20;
            r4.onFinish();
            return;
        L20:
            return;
        }

        public g(i0 r1) {
            this.a = r1;
        }
    }

    static {
        e = new b();
        d = new ArrayList();
    }

    public i0() {
        this.a = new g(this);
        this.c = new ArrayList();
    }

    public final void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        if ((r3 instanceof a) == false) goto L5;
        ((ArrayList) this.c).add(r3);
        return;
    L5:
        ListProtector.add(this.c, 0, r3);
    }
}
