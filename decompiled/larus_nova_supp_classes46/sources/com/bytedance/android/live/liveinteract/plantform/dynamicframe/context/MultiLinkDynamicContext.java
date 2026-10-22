package com.bytedance.android.live.liveinteract.plantform.dynamicframe.context;

import com.bytedance.android.live.liveinteract.plantform.multiroom.e;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.nb0;
import com.bytedance.android.livesdk.config.oa1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/context/MultiLinkDynamicContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/context/b;", "Lcom/bytedance/live/datacontext/i;", "", "isFeed$delegate", "Lcom/bytedance/live/datacontext/p;", "isFeed", "()Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/live/datacontext/n;", "Lih0/b;", "serviceMutable$delegate", "getServiceMutable", "()Lcom/bytedance/live/datacontext/n;", "serviceMutable", "Lnh0/p;", "preLayoutConfigState", "Lnh0/p;", "getPreLayoutConfigState", "()Lnh0/p;", "setPreLayoutConfigState", "(Lnh0/p;)V", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkDynamicContext extends DataContext implements b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG_FOR_FEED = "MultiLinkDynamicFeedContext";
    public static final String TAG_FOR_LIVE = "MultiLinkDynamicContext";
    private final p isFeed$delegate;
    private nh0.p preLayoutConfigState;
    private final p serviceMutable$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final MultiLinkDynamicContext getContext(Long r9) {
            DataContext r1 = null;
            if (((Boolean) oa1.a.getValue()).booleanValue() == false) goto L41;
            DataContext r0 = d.d("MultiLinkDynamicContext");
            if ((r0 instanceof MultiLinkDynamicContext) == true) goto L7;
            r0 = null;
        L7:
            MultiLinkDynamicContext r2 = (MultiLinkDynamicContext) r0;
            if (((Boolean) nb0.a.getValue()).booleanValue() == false) goto L13;
            if (r9 == null) goto L13;
            if (r9.longValue() <= 0) goto L13;
            String r10 = "MultiLinkDynamicFeedContext_" + r9;
        L14:
            DataContext r11 = d.d(r10);
            if (r11 != null) goto L18;
            r11 = d.d("MultiLinkDynamicFeedContext");
        L18:
            if ((r11 instanceof MultiLinkDynamicContext) == true) goto L20;
            r11 = null;
        L20:
            MultiLinkDynamicContext r12 = (MultiLinkDynamicContext) r11;
            if (r2 == null) goto L27;
            i<Boolean> r3 = r2.isFeed();
            if (r3 == null) goto L27;
            if (((Boolean) r3.getValue()).booleanValue() == true) goto L27;
            return r2;
        L27:
            if (r12 == null) goto L40;
            i<Boolean> r4 = r12.isFeed();
            if (r4 == null) goto L40;
            if (((Boolean) r4.getValue()).booleanValue() != true) goto L40;
            o r5 = IRoomContextService.a.a(k.n(IRoomContextService.class), null, 0, 3);
            if (r5 == null) goto L37;
            n r6 = r5.getInteractionDataPrepared();
            if (r6 == null) goto L37;
            IRoom r7 = (IRoom) r6.getValue();
        L38:
            if (r7 != null) goto L40;
            return r12;
        L37:
            r7 = null;
        L40:
            return null;
        L13:
            r10 = "MultiLinkDynamicFeedContext";
            goto L14
        L41:
            DataContext r13 = d.d(b.class);
            if ((r13 instanceof MultiLinkDynamicContext) == false) goto L46;
            r1 = r13;
        L46:
            return (MultiLinkDynamicContext) r1;
        }

        public final ih0.b a(DataCenter r3, Long r4) {
            ih0.b r1 = null;
            if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
            ih0.b r5 = e.b(r3);
        L6:
            if (r5 != null) goto L14;
            MultiLinkDynamicContext r6 = getContext(r4);
            if (r6 == null) goto L13;
            n<ih0.b> r7 = r6.getServiceMutable();
            if (r7 == null) goto L13;
            r1 = (ih0.b) r7.getValue();
        L13:
            return r1;
        L14:
            return r5;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiLinkDynamicContext.class, "isFeed", "isFeed()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiLinkDynamicContext.class, "serviceMutable", "getServiceMutable()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final MultiLinkDynamicContext getContext(Long r1) {
        return Companion.getContext(r1);
    }

    public final n<ih0.b> getServiceMutable() {
        return (n) this.serviceMutable$delegate.a(this, $$delegatedProperties[1]);
    }

    public final i<Boolean> isFeed() {
        return (i) this.isFeed$delegate.a(this, $$delegatedProperties[0]);
    }

    public MultiLinkDynamicContext() {
        this.isFeed$delegate = ConstantKt.d(this, Boolean.FALSE);
        this.serviceMutable$delegate = q.c(this);
    }

    public final nh0.p getPreLayoutConfigState() {
        return this.preLayoutConfigState;
    }

    public final void setPreLayoutConfigState(nh0.p r1) {
        this.preLayoutConfigState = r1;
    }
}
