package com.bytedance.android.live.liveinteract.plantform.datamerge;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/datamerge/LinkUserDataMergeContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "share", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/d;", "dataMergeCenter$delegate", "Lcom/bytedance/live/datacontext/p;", "getDataMergeCenter", "()Lcom/bytedance/live/datacontext/j;", "dataMergeCenter", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/b;", "linkRoomFightDataMergeCenter$delegate", "getLinkRoomFightDataMergeCenter", "linkRoomFightDataMergeCenter", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/handler/d;", "dynamicHandler$delegate", "getDynamicHandler", "dynamicHandler", "<init>", "()V", "Companion", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkUserDataMergeContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p dataMergeCenter$delegate;
    private final p dynamicHandler$delegate;
    private final p linkRoomFightDataMergeCenter$delegate;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ LinkUserDataMergeContext a(a r1, DataCenter r2) {
            return r1.getContext(r2, "");
        }

        public static d b(a r1, DataCenter r2) {
            LinkUserDataMergeContext r3 = r1.getContext(r2, "");
            if (r3 == null) goto L7;
            com.bytedance.live.datacontext.j<d> r4 = r3.getDataMergeCenter();
            if (r4 == null) goto L7;
            return (d) r4.getValue();
        L7:
            return null;
        }

        public final LinkUserDataMergeContext getContext(DataCenter r5, String r6) {
            StringBuilder r0 = new StringBuilder("LinkUserDataMergeContext_");
            DataContext r2 = null;
            if (r5 == null) goto L5;
            Integer r3 = Integer.valueOf(r5.hashCode());
        L6:
            r0.append(r3);
            DataContext r1 = com.bytedance.live.datacontext.d.d(r0.toString());
            if ((r1 instanceof LinkUserDataMergeContext) == true) goto L9;
            r1 = null;
        L9:
            LinkUserDataMergeContext r4 = (LinkUserDataMergeContext) r1;
            if (r4 != null) goto L15;
            DataContext r7 = com.bytedance.live.datacontext.d.d("LinkUserDataMergeContext_" + r6);
            if ((r7 instanceof LinkUserDataMergeContext) == true) goto L14;
            r7 = null;
        L14:
            r4 = (LinkUserDataMergeContext) r7;
        L15:
            if (r4 != null) goto L25;
            StringBuilder r8 = new StringBuilder("LinkUserDataMergeContext_");
            if (r5 == null) goto L19;
            String r9 = (String) r5.get("data_room_unique_id", "");
        L20:
            r8.append(r9);
            DataContext r10 = com.bytedance.live.datacontext.d.d(r8.toString());
            if ((r10 instanceof LinkUserDataMergeContext) == false) goto L24;
            r2 = r10;
        L24:
            r4 = (LinkUserDataMergeContext) r2;
            goto L25
        L19:
            r9 = null;
        L25:
            if (r4 != null) goto L27;
            com.bytedance.live.datacontext.d.d(LinkUserDataMergeContext.class);
        L27:
            return r4;
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkUserDataMergeContext.class, "dataMergeCenter", "getDataMergeCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkUserDataMergeContext.class, "linkRoomFightDataMergeCenter", "getLinkRoomFightDataMergeCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkUserDataMergeContext.class, "dynamicHandler", "getDynamicHandler()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<d> getDataMergeCenter() {
        return (com.bytedance.live.datacontext.j) this.dataMergeCenter$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d> getDynamicHandler() {
        return (com.bytedance.live.datacontext.j) this.dynamicHandler$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.j<b> getLinkRoomFightDataMergeCenter() {
        return (com.bytedance.live.datacontext.j) this.linkRoomFightDataMergeCenter$delegate.a(this, $$delegatedProperties[1]);
    }

    public LinkUserDataMergeContext() {
        this.dataMergeCenter$delegate = ConstantKt.c(this);
        this.linkRoomFightDataMergeCenter$delegate = ConstantKt.c(this);
        this.dynamicHandler$delegate = ConstantKt.c(this);
    }

    public final void share(DataCenter r4) {
        com.bytedance.live.datacontext.b.a(this, LinkUserDataMergeContext.class);
        if (r4 == null) goto L8;
        com.bytedance.live.datacontext.b.a(this, "LinkUserDataMergeContext_" + r4.hashCode());
        String r5 = (String) r4.get("data_room_unique_id", "");
        if (ln1.a.a.a(r5) == false) goto L9;
        com.bytedance.live.datacontext.b.a(this, "LinkUserDataMergeContext_" + r5);
        return;
    L9:
        return;
    }
}
