package com.bytedance.android.live.liveinteract.revenue.paid.viewmodel;

import cj0.c;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b&\u0010'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0014R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001bR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u0014R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u0014R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/viewmodel/PaidLinkMicContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcj0/a;", "Lpy/k;", "interactGuestAvatar", "", "state", "", "setPaidQueueState", "Lcj0/c;", "getWidget", "Lcom/bytedance/live/datacontext/j;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "()Lcom/bytedance/live/datacontext/j;", "widget", "Lcom/bytedance/live/datacontext/m;", "", "refreshWaitingUserList$delegate", "getRefreshWaitingUserList", "()Lcom/bytedance/live/datacontext/m;", "refreshWaitingUserList", "isAnonymous$delegate", "isAnonymous", "Lcom/bytedance/live/datacontext/n;", "anonymousGuestImageModel$delegate", "getAnonymousGuestImageModel", "()Lcom/bytedance/live/datacontext/n;", "anonymousGuestImageModel", "lastSize$delegate", "getLastSize", "lastSize", "discountMode$delegate", "getDiscountMode", "discountMode", "paidQueueState$delegate", "getPaidQueueState", "paidQueueState", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkMicContext extends DataContext implements cj0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p anonymousGuestImageModel$delegate;
    private final p discountMode$delegate;
    private final p isAnonymous$delegate;
    private final p lastSize$delegate;
    private final p paidQueueState$delegate;
    private final p refreshWaitingUserList$delegate;
    private final p widget$delegate;

    public static final class a {
        public a() {
        }

        public final PaidLinkMicContext getContext() {
            DataContext r0 = d.d(cj0.a.class);
            if ((r0 instanceof PaidLinkMicContext) == true) goto L6;
            r0 = null;
        L6:
            return (PaidLinkMicContext) r0;
        }

        public final c a() {
            PaidLinkMicContext r0 = getContext();
            if (r0 == null) goto L7;
            j<c> r1 = r0.m308getWidget();
            if (r1 == null) goto L7;
            return (c) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "refreshWaitingUserList", "getRefreshWaitingUserList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "isAnonymous", "isAnonymous()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "anonymousGuestImageModel", "getAnonymousGuestImageModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "lastSize", "getLastSize()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "discountMode", "getDiscountMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidLinkMicContext.class, "paidQueueState", "getPaidQueueState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final n<k> getAnonymousGuestImageModel() {
        return (n) this.anonymousGuestImageModel$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Integer> getDiscountMode() {
        return (m) this.discountMode$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Integer> getLastSize() {
        return (m) this.lastSize$delegate.a(this, $$delegatedProperties[4]);
    }

    @Override // cj0.a
    public m<Integer> getPaidQueueState() {
        return (m) this.paidQueueState$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // cj0.a
    public m<Boolean> getRefreshWaitingUserList() {
        return (m) this.refreshWaitingUserList$delegate.a(this, $$delegatedProperties[1]);
    }

    /* JADX INFO: renamed from: getWidget, reason: collision with other method in class */
    public final j<c> m308getWidget() {
        return (j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> isAnonymous() {
        return (m) this.isAnonymous$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // cj0.a
    public c getWidget() {
        PaidLinkMicContext r0 = Companion.getContext();
        if (r0 == null) goto L7;
        j<c> r1 = r0.m308getWidget();
        if (r1 == null) goto L7;
        return (c) r1.getValue();
    L7:
        return null;
    }

    public PaidLinkMicContext() {
        this.widget$delegate = ConstantKt.c(this);
        Boolean r0 = Boolean.FALSE;
        this.refreshWaitingUserList$delegate = q.d(this, r0);
        this.isAnonymous$delegate = q.d(this, r0);
        this.anonymousGuestImageModel$delegate = q.c(this);
        this.lastSize$delegate = q.d(this, 0);
        this.discountMode$delegate = q.d(this, 0);
        this.paidQueueState$delegate = q.d(this, 0);
    }

    public k interactGuestAvatar() {
        return (k) getAnonymousGuestImageModel().getValue();
    }

    @Override // cj0.a
    public void setPaidQueueState(int r2) {
        getPaidQueueState().setValue(Integer.valueOf(r2));
    }
}
