package com.bytedance.android.live.revlink.impl.service.internal;

import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.control.u;
import com.bytedance.android.live.revlink.impl.control.v;
import com.bytedance.android.live.revlink.impl.control.w;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.global.d;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B\u001b\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b6\u00107J\u0019\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013R\u0016\u00101\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0004\u0018\u0001038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "roomId", "", "sharedWithRoomId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/live/revlink/impl/control/w;", "revLinkSeiProvider", "onInit", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "setEnterRoom", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "linkUserCenter$delegate", "getLinkUserCenter", "linkUserCenter", "Lcom/bytedance/live/datacontext/m;", "", "isAppBackground$delegate", "isAppBackground", "()Lcom/bytedance/live/datacontext/m;", "enterRoomTs", "J", "getEnterRoomTs", "()J", "Lcom/bytedance/android/live/revlink/impl/control/c;", "enterRoomLinkInfo$delegate", "getEnterRoomLinkInfo", "enterRoomLinkInfo", "", "currentFeedLength", "I", "getCurrentFeedLength", "()I", "setCurrentFeedLength", "(I)V", "seiProvider$delegate", "getSeiProvider", "seiProvider", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "<init>", "(Lld/a;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRevInternalServiceContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "ILinkRevInternalService";
    private int currentFeedLength;
    private final p enterRoomLinkInfo$delegate;
    private final long enterRoomTs;
    private final p isAppBackground$delegate;
    private final ld.a linkDataSet;
    private final c linkFakeGlobalService;
    private final p linkUserCenter$delegate;
    private final p seiProvider$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkRevInternalServiceContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevInternalServiceContext.class, "linkUserCenter", "getLinkUserCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevInternalServiceContext.class, "isAppBackground", "isAppBackground()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevInternalServiceContext.class, "enterRoomLinkInfo", "getEnterRoomLinkInfo()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevInternalServiceContext.class, "seiProvider", "getSeiProvider()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final j<com.bytedance.android.live.revlink.impl.control.c> getEnterRoomLinkInfo() {
        return (j) this.enterRoomLinkInfo$delegate.a(this, $$delegatedProperties[3]);
    }

    public final j<AnchorLinkUserCenterV2> getLinkUserCenter() {
        return (j) this.linkUserCenter$delegate.a(this, $$delegatedProperties[1]);
    }

    public final j<w> getSeiProvider() {
        return (j) this.seiProvider$delegate.a(this, $$delegatedProperties[4]);
    }

    public final j<com.bytedance.android.live.revlink.impl.service.internal.a> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> isAppBackground() {
        return (m) this.isAppBackground$delegate.a(this, $$delegatedProperties[2]);
    }

    public final int getCurrentFeedLength() {
        return this.currentFeedLength;
    }

    public final long getEnterRoomTs() {
        return this.enterRoomTs;
    }

    public final void onInit(w r2) {
        ld.a r0 = this.linkDataSet;
        if (r0 == null) goto L9;
        NextLiveData r1 = r0.Q2();
        if (r1 == null) goto L9;
        Integer r3 = (Integer) r1.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        this.currentFeedLength = r4;
        getSeiProvider().d(r2);
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public final void setCurrentFeedLength(int r1) {
        this.currentFeedLength = r1;
    }

    public final void setEnterRoom(IRoom r7) {
        if (r7 != null) goto L5;
        getEnterRoomLinkInfo().d(null);
        return;
    L5:
        Map r0 = MapsKt.toMap(IRoomKt_androidKt.getLinkMapKt(r7));
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
        Iterator r2 = r0.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.put(r3.getKey(), Long.valueOf(((Number) r3.getValue()).longValue()));
        goto L7
    L9:
        IRoomLinkExt r4 = (IRoomLinkExt) ((vh7.c) r7).castTo(IRoomLinkExt.class);
        u r5 = v.b(r7);
        com.bytedance.android.live.revlink.impl.control.c r6 = new com.bytedance.android.live.revlink.impl.control.c(r1, r4, r5, v.a(r7));
        getEnterRoomLinkInfo().d(r6);
        StringBuilder r8 = new StringBuilder("setEnterRoom room has pk info ");
        if (r5 == null) goto L12;
        boolean r9 = true;
    L13:
        r8.append(r9);
        jy0.b.d(TAG, r8.toString());
        return;
    L12:
        r9 = false;
        goto L13
    }

    public final void sharedWithRoomId(Long r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.longValue() == 0) goto L9;
        a r0 = Companion;
        long r1 = r6.longValue();
        r0.getClass();
        d.a(this, "ILinkRevInternalService_" + r1, this.linkFakeGlobalService);
        return;
    }

    public LinkRevInternalServiceContext(ld.a r1, c r2) {
        this.linkDataSet = r1;
        this.linkFakeGlobalService = r2;
        this.service$delegate = ConstantKt.c(this);
        this.linkUserCenter$delegate = ConstantKt.c(this);
        this.isAppBackground$delegate = q.d(this, Boolean.FALSE);
        i97.a r3 = i97.a.a;
        this.enterRoomTs = System.currentTimeMillis();
        this.enterRoomLinkInfo$delegate = ConstantKt.c(this);
        this.seiProvider$delegate = ConstantKt.c(this);
    }

    public static /* synthetic */ void sharedWithRoomId$default(LinkRevInternalServiceContext r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.sharedWithRoomId(r1);
    }
}
