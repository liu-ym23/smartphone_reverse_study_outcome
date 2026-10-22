package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/base/LinkInternalServiceContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/plantform/base/g;", "multiService$delegate", "Lcom/bytedance/live/datacontext/p;", "getMultiService", "()Lcom/bytedance/live/datacontext/j;", "multiService", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/liveinteract/api/data/a;", "paidInteractAudienceConfig$delegate", "getPaidInteractAudienceConfig", "()Lcom/bytedance/live/datacontext/m;", "paidInteractAudienceConfig", "paidVideoTalkConfig$delegate", "getPaidVideoTalkConfig", "paidVideoTalkConfig", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkInternalServiceContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p multiService$delegate;
    private final p paidInteractAudienceConfig$delegate;
    private final p paidVideoTalkConfig$delegate;

    public static final class a {
        @JvmStatic
        public final LinkInternalServiceContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("ILinkMultiInternalService");
            if ((r0 instanceof LinkInternalServiceContext) == true) goto L6;
            r0 = null;
        L6:
            return (LinkInternalServiceContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkInternalServiceContext.class, "multiService", "getMultiService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkInternalServiceContext.class, "paidInteractAudienceConfig", "getPaidInteractAudienceConfig()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkInternalServiceContext.class, "paidVideoTalkConfig", "getPaidVideoTalkConfig()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final LinkInternalServiceContext getContext() {
        return Companion.getContext();
    }

    public final com.bytedance.live.datacontext.j<g> getMultiService() {
        return (com.bytedance.live.datacontext.j) this.multiService$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<com.bytedance.android.live.liveinteract.api.data.a> getPaidInteractAudienceConfig() {
        return (m) this.paidInteractAudienceConfig$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<com.bytedance.android.live.liveinteract.api.data.a> getPaidVideoTalkConfig() {
        return (m) this.paidVideoTalkConfig$delegate.a(this, $$delegatedProperties[2]);
    }

    public LinkInternalServiceContext() {
        this.multiService$delegate = ConstantKt.c(this);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        this.paidInteractAudienceConfig$delegate = q.d(this, com.bytedance.android.live.liveinteract.api.data.a.C0017a.h());
        this.paidVideoTalkConfig$delegate = q.d(this, com.bytedance.android.live.liveinteract.api.data.a.C0017a.k());
    }
}
