package com.bytedance.android.live.multilink.impl.control;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/control/MultiControlContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "shareByRoomScope", "Lcom/bytedance/live/datacontext/j;", "", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Ljn0/b;", "multiLinkRoomScopeService", "Ljn0/b;", "<init>", "(Ljn0/b;)V", "Companion", "a", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiControlContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "MultiControlContext";
    private final jn0.b multiLinkRoomScopeService;
    private final p service$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiControlContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final j<Object> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void shareByRoomScope() {
        jn0.b r0 = this.multiLinkRoomScopeService;
        if (r0 == null) goto L6;
        MultiControlContext r1 = (MultiControlContext) r0.Jn(this);
        return;
    }

    public MultiControlContext(jn0.b r1) {
        this.multiLinkRoomScopeService = r1;
        this.service$delegate = ConstantKt.c(this);
    }
}
