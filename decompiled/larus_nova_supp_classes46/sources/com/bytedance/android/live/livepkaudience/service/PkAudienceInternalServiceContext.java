package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/service/PkAudienceInternalServiceContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/livepkaudience/service/e;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceInternalServiceContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "IPkAudienceInternalService";
    private final p service$delegate;

    public static final class a {
        @JvmStatic
        public final PkAudienceInternalServiceContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(PkAudienceInternalServiceContext.TAG);
            if ((r0 instanceof PkAudienceInternalServiceContext) == true) goto L6;
            r0 = null;
        L6:
            return (PkAudienceInternalServiceContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PkAudienceInternalServiceContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final PkAudienceInternalServiceContext getContext() {
        return Companion.getContext();
    }

    public final j<e> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public PkAudienceInternalServiceContext() {
        this.service$delegate = ConstantKt.c(this);
    }
}
