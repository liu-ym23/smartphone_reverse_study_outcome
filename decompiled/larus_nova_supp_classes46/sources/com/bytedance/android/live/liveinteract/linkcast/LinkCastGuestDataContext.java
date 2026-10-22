package com.bytedance.android.live.liveinteract.linkcast;

import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkcast/LinkCastGuestDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lvf0/b;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "mLinkCastInfo$delegate", "Lcom/bytedance/live/datacontext/p;", "getMLinkCastInfo", "()Lcom/bytedance/live/datacontext/n;", "mLinkCastInfo", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkCastGuestDataContext extends DataContext implements vf0.b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p mLinkCastInfo$delegate;

    public static final class a {
        public final LinkCastGuestDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(vf0.b.class);
            if ((r0 instanceof LinkCastGuestDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (LinkCastGuestDataContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkCastGuestDataContext.class, "mLinkCastInfo", "getMLinkCastInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<s0> getMLinkCastInfo() {
        return (n) this.mLinkCastInfo$delegate.a(this, $$delegatedProperties[0]);
    }

    public LinkCastGuestDataContext() {
        this.mLinkCastInfo$delegate = q.c(this);
    }
}
