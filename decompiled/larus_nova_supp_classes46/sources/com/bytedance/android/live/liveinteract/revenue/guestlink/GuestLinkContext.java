package com.bytedance.android.live.liveinteract.revenue.guestlink;

import com.bytedance.android.live.core.utils.f2;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/GuestLinkContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/i;", "", "isLinker", "isWatcher", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/j;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "getWidget", "()Lcom/bytedance/live/datacontext/j;", "widget", "Lcom/bytedance/live/datacontext/m;", "isOpen$delegate", "isOpen", "()Lcom/bytedance/live/datacontext/m;", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestLinkContext extends DataContext implements i {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static final String TAG = "GuestLinkContext";
    private final p isOpen$delegate;
    private final p widget$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final GuestLinkContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(i.class);
            if ((r0 instanceof GuestLinkContext) == true) goto L6;
            r0 = null;
        L6:
            return (GuestLinkContext) r0;
        }

        public final sb6.a a() {
            GuestLinkContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<j> r1 = r0.getWidget();
            if (r1 == null) goto L7;
            j r2 = (j) r1.getValue();
        L8:
            if (r2 != null) goto L10;
            return null;
        L10:
            return r2.getLinkState();
        L7:
            r2 = null;
            goto L8
        }

        public final boolean b(boolean r3) {
            sb6.a r0 = a();
            if (r0 == null) goto L5;
            boolean r1 = r0.b;
        L6:
            if (r1 == false) goto L9;
            if (r3 == false) goto L9;
            f2.b(2131918707, 0);
        L9:
            return r1;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GuestLinkContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GuestLinkContext.class, "isOpen", "isOpen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final GuestLinkContext getContext() {
        return Companion.getContext();
    }

    public final com.bytedance.live.datacontext.j<j> getWidget() {
        return (com.bytedance.live.datacontext.j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.i
    public m<Boolean> isOpen() {
        return (m) this.isOpen$delegate.a(this, $$delegatedProperties[1]);
    }

    public boolean isLinker() {
        sb6.a r0 = Companion.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a != true) goto L7;
        return true;
    }

    public boolean isWatcher() {
        sb6.a r0 = Companion.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c != true) goto L7;
        return true;
    }

    public GuestLinkContext() {
        this.widget$delegate = ConstantKt.c(this);
        this.isOpen$delegate = q.d(this, Boolean.FALSE);
    }
}
