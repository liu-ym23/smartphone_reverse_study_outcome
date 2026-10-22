package com.bytedance.android.live.liveinteract.aimv;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/aimv/LiveLinkmicAIMVContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/aimv/a;", "Lcom/bytedance/live/datacontext/m;", "", "isPlaying$delegate", "Lcom/bytedance/live/datacontext/p;", "isPlaying", "()Lcom/bytedance/live/datacontext/m;", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveLinkmicAIMVContext extends DataContext implements com.bytedance.android.live.liveinteract.aimv.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p isPlaying$delegate;

    public static final class a {
        @JvmStatic
        public final LiveLinkmicAIMVContext getContext() {
            DataContext r0 = d.d(com.bytedance.android.live.liveinteract.aimv.a.class);
            if ((r0 instanceof LiveLinkmicAIMVContext) == true) goto L6;
            r0 = null;
        L6:
            return (LiveLinkmicAIMVContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveLinkmicAIMVContext.class, "isPlaying", "isPlaying()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final LiveLinkmicAIMVContext getContext() {
        return Companion.getContext();
    }

    public final m<Boolean> isPlaying() {
        return (m) this.isPlaying$delegate.a(this, $$delegatedProperties[0]);
    }

    public LiveLinkmicAIMVContext() {
        this.isPlaying$delegate = q.d(this, Boolean.FALSE);
    }
}
