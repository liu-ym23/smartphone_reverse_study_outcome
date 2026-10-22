package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u001eR!\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\rR!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSPlayerViewControlContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "initVisible", "Z", "getInitVisible", "()Z", "setInitVisible", "(Z)V", "Lcom/bytedance/live/datacontext/m;", "isLocked$delegate", "Lcom/bytedance/live/datacontext/p;", "isLocked", "()Lcom/bytedance/live/datacontext/m;", "playerViewVisible$delegate", "getPlayerViewVisible", "playerViewVisible", "playerViewVisibleTriggeredByUser$delegate", "getPlayerViewVisibleTriggeredByUser", "playerViewVisibleTriggeredByUser", "", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", "tmpControlItemList", "Ljava/util/List;", "getTmpControlItemList", "()Ljava/util/List;", "Lcom/bytedance/live/datacontext/k;", "", "resetHideTaskEvent$delegate", "getResetHideTaskEvent", "()Lcom/bytedance/live/datacontext/k;", "resetHideTaskEvent", "autoHideTaskEnable$delegate", "getAutoHideTaskEnable", "autoHideTaskEnable", "controlAnimEndEvent$delegate", "getControlAnimEndEvent", "controlAnimEndEvent", "", "customAnimDuration$delegate", "getCustomAnimDuration", "customAnimDuration", "playerViewIsInZoom$delegate", "getPlayerViewIsInZoom", "playerViewIsInZoom", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSPlayerViewControlContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p autoHideTaskEnable$delegate;
    private final p controlAnimEndEvent$delegate;
    private final p customAnimDuration$delegate;
    private boolean initVisible;
    private final p isLocked$delegate;
    private final p playerViewIsInZoom$delegate;
    private final p playerViewVisible$delegate;
    private final p playerViewVisibleTriggeredByUser$delegate;
    private final p resetHideTaskEvent$delegate;
    private final List<c> tmpControlItemList;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "isLocked", "isLocked()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "playerViewVisible", "getPlayerViewVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "playerViewVisibleTriggeredByUser", "getPlayerViewVisibleTriggeredByUser()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "resetHideTaskEvent", "getResetHideTaskEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "autoHideTaskEnable", "getAutoHideTaskEnable()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "controlAnimEndEvent", "getControlAnimEndEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "customAnimDuration", "getCustomAnimDuration()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VSPlayerViewControlContext.class, "playerViewIsInZoom", "getPlayerViewIsInZoom()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> getAutoHideTaskEnable() {
        return (m) this.autoHideTaskEnable$delegate.a(this, $$delegatedProperties[4]);
    }

    public final k<Boolean> getControlAnimEndEvent() {
        return (k) this.controlAnimEndEvent$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Long> getCustomAnimDuration() {
        return (m) this.customAnimDuration$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> getPlayerViewIsInZoom() {
        return (m) this.playerViewIsInZoom$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getPlayerViewVisible() {
        return (m) this.playerViewVisible$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getPlayerViewVisibleTriggeredByUser() {
        return (m) this.playerViewVisibleTriggeredByUser$delegate.a(this, $$delegatedProperties[2]);
    }

    public final k<Unit> getResetHideTaskEvent() {
        return (k) this.resetHideTaskEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> isLocked() {
        return (m) this.isLocked$delegate.a(this, $$delegatedProperties[0]);
    }

    public VSPlayerViewControlContext() {
        this.initVisible = true;
        Boolean r0 = Boolean.FALSE;
        this.isLocked$delegate = q.d(this, r0);
        Boolean r1 = Boolean.TRUE;
        this.playerViewVisible$delegate = q.d(this, r1);
        this.playerViewVisibleTriggeredByUser$delegate = q.d(this, r0);
        this.tmpControlItemList = new ArrayList();
        this.resetHideTaskEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.autoHideTaskEnable$delegate = q.d(this, r1);
        this.controlAnimEndEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.customAnimDuration$delegate = q.d(this, -1L);
        this.playerViewIsInZoom$delegate = q.d(this, r0);
    }

    public final boolean getInitVisible() {
        return this.initVisible;
    }

    public final List<c> getTmpControlItemList() {
        return this.tmpControlItemList;
    }

    public final void setInitVisible(boolean r1) {
        this.initVisible = r1;
    }
}
