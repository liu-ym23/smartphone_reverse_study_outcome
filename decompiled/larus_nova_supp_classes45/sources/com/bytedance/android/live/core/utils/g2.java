package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdk.followtool.utils.XTFollowSyncPrefs;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class g2 {
    public final SharedPrefHelper a;
    public final Function0<String> b;

    public class a<T> extends b<T> {
        public final /* synthetic */ g2 d;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final Object b(KProperty r7) {
            Intrinsics.checkNotNullParameter(r7, "property");
            long r0 = this.d.a.i(a(), 0);
            if ((4294967295L & r0) != h2.b()) goto L18;
            T r8 = this.b;
            if ((r8 instanceof Integer) == false) goto L9;
            return Integer.valueOf((int) (r0 >> 32));
        L9:
            if ((r8 instanceof Boolean) == false) goto L17;
            if ((r0 >> 32) != 1) goto L13;
            boolean r9 = true;
        L15:
            return Boolean.valueOf(r9);
        L13:
            r9 = false;
            goto L15
        L17:
            throw new IllegalStateException(("not support type " + this.b.getClass()).toString());
        L18:
            return this.b;
        }

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final void c(KProperty r6, Object r7) {
            Intrinsics.checkNotNullParameter(r6, "property");
            Intrinsics.checkNotNullParameter(r7, "value");
            SharedPrefHelper r8 = this.d.a;
            if ((r7 instanceof Integer) == false) goto L6;
            r8.m(a(), Long.valueOf((((long) ((Number) r7).intValue()) << 32) | h2.b()));
            return;
        L6:
            if ((r7 instanceof Boolean) == false) goto L14;
            String r0 = a();
            if (((Boolean) r7).booleanValue() == false) goto L10;
            long r2 = 1;
        L11:
            r8.m(r0, Long.valueOf((r2 << 32) | h2.b()));
            return;
        L10:
            r2 = 0;
            goto L11
        L14:
            throw new IllegalStateException(("not support type " + this.b.getClass()).toString());
        }

        public a(g2 r2, String r3, T r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.d = r2;
            super(r2, r3, r4);
        }
    }

    public class b<T> {
        public final String a;
        public final T b;
        public final /* synthetic */ g2 c;

        public String a() {
            return this.a;
        }

        public Object b(KProperty r4) {
            Intrinsics.checkNotNullParameter(r4, "property");
            SharedPrefHelper r5 = this.c.a;
            T r0 = this.b;
            if ((r0 instanceof String) == false) goto L10;
            String r6 = r5.j(a(), (String) this.b);
            if (r6 == null) goto L8;
            return r6;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L10:
            if ((r0 instanceof Integer) == false) goto L13;
            return Integer.valueOf(r5.h(a(), ((Number) this.b).intValue()));
        L13:
            if ((r0 instanceof Long) == false) goto L16;
            return Long.valueOf(r5.i(a(), ((Number) this.b).longValue()));
        L16:
            if ((r0 instanceof Boolean) == false) goto L19;
            return Boolean.valueOf(r5.f(a(), ((Boolean) this.b).booleanValue()));
        L19:
            if ((r0 instanceof Float) == false) goto L22;
            return Float.valueOf(r5.g(a(), ((Number) this.b).floatValue()));
        L22:
            if ((r0 instanceof Set) == false) goto L34;
            String r1 = a();
            T r2 = this.b;
            if (r2 == null) goto L32;
            Set r7 = r5.k(r1, (Set) r2);
            if (r7 == null) goto L30;
            return r7;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        L34:
            throw new IllegalStateException(("not support type " + this.b.getClass()).toString());
        }

        public void c(KProperty r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "property");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.c.a.m(a(), r3);
        }

        public b(g2 r2, String r3, T r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public final class c<T> extends a<T> {
        public final String e;
        public final /* synthetic */ g2 f;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.e);
            Function0<String> r1 = this.f.b;
            if (r1 == null) goto L7;
            r0.append((String) r1.invoke());
            return r0.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public c(XTFollowSyncPrefs r2, String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.f = r2;
            super(r2, r3, r4);
            this.e = r3;
        }
    }

    public final class d<T> extends b<T> {
        public final String d;
        public final /* synthetic */ g2 e;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.d);
            Function0<String> r1 = this.e.b;
            if (r1 == null) goto L7;
            r0.append((String) r1.invoke());
            return r0.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public d(XTFollowSyncPrefs r2, String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.e = r2;
            super(r2, r3, r4);
            this.d = r3;
        }
    }

    public final class e<T> extends g<T> {
        public final String e;
        public final /* synthetic */ g2 f;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.e);
            Function0<String> r1 = this.f.b;
            if (r1 == null) goto L7;
            r0.append((String) r1.invoke());
            return r0.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public e(XTFollowSyncPrefs r3, Object r4) {
            Intrinsics.checkNotNullParameter("follow_relations_dialog_cnt_week_days", "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.f = r3;
            super(r3, r4);
            this.e = "follow_relations_dialog_cnt_week_days";
        }
    }

    public final class f<T> extends h<T> {
        public final String e;
        public final /* synthetic */ g2 f;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.e);
            Function0<String> r1 = this.f.b;
            if (r1 == null) goto L7;
            r0.append((String) r1.invoke());
            return r0.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public f(XTFollowSyncPrefs r3, Object r4) {
            Intrinsics.checkNotNullParameter("follow_dialog_cnt_week", "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.f = r3;
            super(r3, r4);
            this.e = "follow_dialog_cnt_week";
        }
    }

    public class g<T> extends b<T> {
        public final /* synthetic */ g2 d;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final Object b(KProperty r7) {
            Intrinsics.checkNotNullParameter(r7, "property");
            long r0 = this.d.a.i(a(), 0);
            if ((h2.b() - (4294967295L & r0)) > 7) goto L18;
            T r8 = this.b;
            if ((r8 instanceof Integer) == false) goto L9;
            return Integer.valueOf((int) (r0 >> 32));
        L9:
            if ((r8 instanceof Boolean) == false) goto L17;
            if ((r0 >> 32) != 1) goto L13;
            boolean r9 = true;
        L15:
            return Boolean.valueOf(r9);
        L13:
            r9 = false;
            goto L15
        L17:
            throw new IllegalStateException(("not support type " + this.b.getClass()).toString());
        L18:
            return this.b;
        }

        public g(XTFollowSyncPrefs r3, Object r4) {
            Intrinsics.checkNotNullParameter("follow_relations_dialog_cnt_week_days", "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.d = r3;
            super(r3, "follow_relations_dialog_cnt_week_days", r4);
        }

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final void c(KProperty r6, Object r7) {
            Intrinsics.checkNotNullParameter(r6, "property");
            Intrinsics.checkNotNullParameter(r7, "value");
            SharedPrefHelper r8 = this.d.a;
            if ((r7 instanceof Integer) == false) goto L6;
            r8.m(a(), Long.valueOf((((long) ((Number) r7).intValue()) << 32) | h2.b()));
            return;
        L6:
            if ((r7 instanceof Boolean) == false) goto L14;
            String r0 = a();
            if (((Boolean) r7).booleanValue() == false) goto L10;
            long r2 = 1;
        L11:
            r8.m(r0, Long.valueOf((r2 << 32) | h2.b()));
            return;
        L10:
            r2 = 0;
            goto L11
        L14:
            throw new IllegalStateException(("not support type " + this.b.getClass()).toString());
        }
    }

    public class h<T> extends b<T> {
        public final /* synthetic */ g2 d;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final Object b(KProperty r1) {
            throw null;
        }

        public h(XTFollowSyncPrefs r3, Object r4) {
            Intrinsics.checkNotNullParameter("follow_dialog_cnt_week", "key");
            Intrinsics.checkNotNullParameter(r4, "default");
            this.d = r3;
            super(r3, "follow_dialog_cnt_week", r4);
        }

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final void c(KProperty r6, Object r7) {
            Intrinsics.checkNotNullParameter(r6, "property");
            Intrinsics.checkNotNullParameter(r7, "value");
            SharedPrefHelper r8 = this.d.a;
            if ((r7 instanceof Integer) == false) goto L6;
            r8.m(a(), Long.valueOf((((long) ((Number) r7).intValue()) << 32) | h2.a()));
            return;
        L6:
            if ((r7 instanceof Boolean) == false) goto L14;
            String r0 = a();
            if (((Boolean) r7).booleanValue() == false) goto L10;
            long r2 = 1;
        L11:
            r8.m(r0, Long.valueOf((r2 << 32) | h2.a()));
            return;
        L10:
            r2 = 0;
            goto L11
        L14:
            throw new IllegalStateException(("not support type " + this.b.getClass()).toString());
        }
    }

    public g2(String r1, Function0<String> r2) {
        this.b = r2;
        if (r1 != null) goto L5;
        SharedPrefHelper r3 = SharedPrefHelper.b(LiveResUtil.getContext());
    L6:
        this.a = r3;
        return;
    L5:
        r3 = SharedPrefHelper.c(LiveResUtil.getContext(), r1);
        goto L6
    }
}
