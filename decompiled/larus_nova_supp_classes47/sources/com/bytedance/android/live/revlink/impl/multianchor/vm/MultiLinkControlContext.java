package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiLinkControlContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "roomId", "", "sharedWithRoomId", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/d;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkControlContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final p service$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiLinkControlContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final j<com.bytedance.android.live.revlink.impl.multianchor.service.d> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public MultiLinkControlContext(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.linkFakeGlobalService = r1;
        this.service$delegate = ConstantKt.c(this);
    }

    public final void sharedWithRoomId(long r4) {
        if (r4 != 0) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("MultiLinkControlContext_");
        Intrinsics.checkNotNullParameter(Companion, "$this$TAG");
        r0.append(r4);
        com.bytedance.android.live.revlink.impl.global.d.a(this, r0.toString(), this.linkFakeGlobalService);
    }
}
