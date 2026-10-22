package com.bytedance.android.live.broadcastgame.api.xplay;

import android.view.ViewGroup;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\tR'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/XplayExternalContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "xplayRunning$delegate", "Lcom/bytedance/live/datacontext/p;", "getXplayRunning", "()Lcom/bytedance/live/datacontext/m;", "getXplayRunning$annotations", "()V", "xplayRunning", "clearScreen$delegate", "getClearScreen", "clearScreen", "Lcom/bytedance/live/datacontext/n;", "Landroid/view/ViewGroup;", "interactPlayContainer$delegate", "getInteractPlayContainer", "()Lcom/bytedance/live/datacontext/n;", "interactPlayContainer", "Lcom/bytedance/live/datacontext/k;", "", "openGameMoreDialog$delegate", "getOpenGameMoreDialog", "()Lcom/bytedance/live/datacontext/k;", "openGameMoreDialog", "openPerfDetect$delegate", "getOpenPerfDetect", "openPerfDetect", "<init>", "Companion", "a", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayExternalContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final String CONTEXT_KEY = "XplayExternalContext";
    public static final a Companion = null;
    private final com.bytedance.live.datacontext.p clearScreen$delegate;
    private final com.bytedance.live.datacontext.p interactPlayContainer$delegate;
    private final com.bytedance.live.datacontext.p openGameMoreDialog$delegate;
    private final com.bytedance.live.datacontext.p openPerfDetect$delegate;
    private final com.bytedance.live.datacontext.p xplayRunning$delegate;

    public static final class a {
        @JvmStatic
        public final XplayExternalContext getContext() {
            return (XplayExternalContext) com.bytedance.live.datacontext.d.e(XplayExternalContext.CONTEXT_KEY, XplayExternalContext.class);
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(XplayExternalContext.class, "xplayRunning", "getXplayRunning()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayExternalContext.class, "clearScreen", "getClearScreen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayExternalContext.class, "interactPlayContainer", "getInteractPlayContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(XplayExternalContext.class, "openGameMoreDialog", "getOpenGameMoreDialog()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(XplayExternalContext.class, "openPerfDetect", "getOpenPerfDetect()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final XplayExternalContext getContext() {
        return Companion.getContext();
    }

    @Deprecated(message = "Use IXplayGlobalService instead")
    public static /* synthetic */ void getXplayRunning$annotations() {
    }

    public final com.bytedance.live.datacontext.m<Boolean> getClearScreen() {
        return (com.bytedance.live.datacontext.m) this.clearScreen$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.n<ViewGroup> getInteractPlayContainer() {
        return (com.bytedance.live.datacontext.n) this.interactPlayContainer$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.k<String> getOpenGameMoreDialog() {
        return (com.bytedance.live.datacontext.k) this.openGameMoreDialog$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getOpenPerfDetect() {
        return (com.bytedance.live.datacontext.m) this.openPerfDetect$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getXplayRunning() {
        return (com.bytedance.live.datacontext.m) this.xplayRunning$delegate.a(this, $$delegatedProperties[0]);
    }

    public XplayExternalContext() {
        Boolean r0 = Boolean.FALSE;
        this.xplayRunning$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.clearScreen$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.TRUE);
        this.interactPlayContainer$delegate = com.bytedance.live.datacontext.q.c(this);
        this.openGameMoreDialog$delegate = com.bytedance.live.datacontext.e.b(this);
        this.openPerfDetect$delegate = com.bytedance.live.datacontext.q.d(this, r0);
    }
}
