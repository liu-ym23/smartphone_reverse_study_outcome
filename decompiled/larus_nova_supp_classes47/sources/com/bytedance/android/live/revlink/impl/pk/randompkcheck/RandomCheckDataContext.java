package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import cy0.j;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/randompkcheck/RandomCheckDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "randomChecked$delegate", "Lcom/bytedance/live/datacontext/p;", "getRandomChecked", "()Lcom/bytedance/live/datacontext/m;", "randomChecked", "Lcom/bytedance/live/datacontext/k;", "", "startRandomMatch$delegate", "getStartRandomMatch", "()Lcom/bytedance/live/datacontext/k;", "startRandomMatch", "<init>", "()V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RandomCheckDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "random_check_data_context";
    private final p randomChecked$delegate;
    private final p startRandomMatch$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a() {
            cy0.e.a.getClass();
            j r1 = cy0.e.a.a;
            m.e.getClass();
            Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Intrinsics.checkNotNull(r0);
            String r2 = ((com.bytedance.live.kmp.core.c) r0).getCurrentUserId();
            if (r2 != null) goto L5;
            r2 = DataType.FALSE;
        L5:
            Boolean r3 = (Boolean) ((HashMap) l51.a.g0.getValue(null, l51.a.a[68])).get(r2);
            if (r3 != null) goto L10;
            return false;
        L10:
            return r3.booleanValue();
        }

        @JvmStatic
        public static void d() {
            cy0.e.a.getClass();
            j r1 = cy0.e.a.a;
            m.e.getClass();
            Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Intrinsics.checkNotNull(r0);
            String r2 = ((com.bytedance.live.kmp.core.c) r0).getCurrentUserId();
            if (r2 != null) goto L5;
            r2 = DataType.FALSE;
        L5:
            com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.g0;
            KProperty[] r4 = l51.a.a;
            HashMap r5 = (HashMap) r3.getValue(null, r4[68]);
            r5.put(r2, Boolean.TRUE);
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r3.setValue(null, r4[68], r5);
        }

        @JvmStatic
        public final RandomCheckDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(RandomCheckDataContext.TAG);
            if ((r0 instanceof RandomCheckDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (RandomCheckDataContext) r0;
        }

        @JvmStatic
        public final boolean b() {
            RandomCheckDataContext r0 = getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r1 = r0.getRandomChecked();
            if (r1 == null) goto L9;
            Boolean r2 = (Boolean) r1.getValue();
            if (r2 == null) goto L9;
            return r2.booleanValue();
        L9:
            return false;
        }

        @JvmStatic
        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            RandomCheckDataContext r0 = getContext();
            if (r0 == null) goto L8;
            k<String> r1 = r0.getStartRandomMatch();
            if (r1 == null) goto L9;
            r1.post(r2);
            return;
        L9:
            return;
        }

        @JvmStatic
        public final void c(boolean r3, boolean r4) {
            l51.a.y(r3);
            RandomCheckDataContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.m<Boolean> r1 = r0.getRandomChecked();
            if (r1 == null) goto L7;
            r1.setValue(Boolean.valueOf(r3));
        L7:
            if (r3 == false) goto L11;
            if (r4 == false) goto L12;
            d();
            return;
        L12:
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RandomCheckDataContext.class, "randomChecked", "getRandomChecked()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RandomCheckDataContext.class, "startRandomMatch", "getStartRandomMatch()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final RandomCheckDataContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final boolean isConfirmed() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final boolean isRandomChecked() {
        return Companion.b();
    }

    @JvmStatic
    public static final void modifyRandomChecked(boolean r1, boolean r2) {
        Companion.c(r1, r2);
    }

    @JvmStatic
    public static final void startRandomMatch(String r1) {
        Companion.e(r1);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getRandomChecked() {
        return (com.bytedance.live.datacontext.m) this.randomChecked$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<String> getStartRandomMatch() {
        return (k) this.startRandomMatch$delegate.a(this, $$delegatedProperties[1]);
    }

    @JvmStatic
    private static final void setConfirmed() {
        Companion.getClass();
        a.d();
    }

    public RandomCheckDataContext() {
        this.randomChecked$delegate = q.d(this, Boolean.FALSE);
        this.startRandomMatch$delegate = com.bytedance.live.datacontext.e.b(this);
    }

    @JvmStatic
    public static final void modifyRandomChecked(boolean r2) {
        Companion.c(r2, true);
    }
}
