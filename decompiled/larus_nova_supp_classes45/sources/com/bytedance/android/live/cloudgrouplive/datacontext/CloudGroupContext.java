package com.bytedance.android.live.cloudgrouplive.datacontext;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import z30.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/datacontext/CloudGroupContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lz30/a;", "Lcom/bytedance/live/datacontext/j;", "Lz30/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", "a", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CloudGroupContext extends DataContext implements z30.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final CloudGroupContext getContext() {
            DataContext r0 = d.d(z30.a.class);
            if ((r0 instanceof CloudGroupContext) == true) goto L6;
            r0 = null;
        L6:
            return (CloudGroupContext) r0;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CloudGroupContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final CloudGroupContext getContext() {
        return Companion.getContext();
    }

    /* JADX INFO: renamed from: getService, reason: collision with other method in class */
    public final j<b> m536getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    @JvmStatic
    public static final b getService() {
        CloudGroupContext r0 = Companion.getContext();
        if (r0 == null) goto L7;
        j<b> r1 = r0.m536getService();
        if (r1 == null) goto L7;
        return (b) r1.getValue();
    L7:
        return null;
    }

    public CloudGroupContext() {
        this.service$delegate = ConstantKt.c(this);
    }
}
