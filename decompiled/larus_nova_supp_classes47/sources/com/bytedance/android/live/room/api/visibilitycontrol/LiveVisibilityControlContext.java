package com.bytedance.android.live.room.api.visibilitycontrol;

import com.bytedance.android.live.core.log.ALogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0015R!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001dR!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001dR!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u001d\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R!\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010:R!\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010\u001dR!\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0005078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001b\u001a\u0004\b@\u0010:R!\u0010E\u001a\b\u0012\u0004\u0012\u00020B0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010\u001d¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "checkEnablePlayback", "Lcom/bytedance/live/datacontext/m;", "", "getViewVisibleMutable", "b", "setViewVisibleValue", "getPlaybackVisibleValue", "getPlaybackVisibleMutable", "setPlaybackVisibleValue", "enablePlayBackAbility", "enablePlayBackInEnterRoom", "setPlayBackAbilityInRoom", "setPlayBackAbilityInMsg", "setPlayBackAbilityInShift", "getPlayBackAbilityInShiftMutable", "getEnablePlaybackMutable", "getPlayBackAbilityInMsgMutable", "initVisible", "Z", "getInitVisible", "()Z", "setInitVisible", "(Z)V", "isLocked$delegate", "Lcom/bytedance/live/datacontext/p;", "isLocked", "()Lcom/bytedance/live/datacontext/m;", "viewVisible$delegate", "getViewVisible", "viewVisible", "playBackVisible$delegate", "getPlayBackVisible", "playBackVisible", "enablePlayback$delegate", "getEnablePlayback", "enablePlayback", "enablePlayBackAbilityInRoom", "enablePlayBackAbilityInMsg$delegate", "getEnablePlayBackAbilityInMsg", "enablePlayBackAbilityInMsg", "enablePlayBackAbilityInShift$delegate", "getEnablePlayBackAbilityInShift", "enablePlayBackAbilityInShift", "playerViewVisibleTriggeredByUser$delegate", "getPlayerViewVisibleTriggeredByUser", "playerViewVisibleTriggeredByUser", "", "Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", "tmpControlItemList", "Ljava/util/List;", "getTmpControlItemList", "()Ljava/util/List;", "Lcom/bytedance/live/datacontext/k;", "resetHideTaskEvent$delegate", "getResetHideTaskEvent", "()Lcom/bytedance/live/datacontext/k;", "resetHideTaskEvent", "autoHideTaskEnable$delegate", "getAutoHideTaskEnable", "autoHideTaskEnable", "controlAnimEndEvent$delegate", "getControlAnimEndEvent", "controlAnimEndEvent", "", "customAnimDuration$delegate", "getCustomAnimDuration", "customAnimDuration", "<init>", "()V", "Companion", "a", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVisibilityControlContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String enablePlayBackTag = "enablePlayBackTag";
    public static final String enterRoomTag = "enablePlayBackTag-enterRoom";
    public static final String timerTag = "timerTag";
    public static final String visibilityControlTag = "visibilityControlTag";
    private final p autoHideTaskEnable$delegate;
    private final p controlAnimEndEvent$delegate;
    private final p customAnimDuration$delegate;
    private final p enablePlayBackAbilityInMsg$delegate;
    private boolean enablePlayBackAbilityInRoom;
    private final p enablePlayBackAbilityInShift$delegate;
    private final p enablePlayback$delegate;
    private boolean initVisible;
    private final p isLocked$delegate;
    private final p playBackVisible$delegate;
    private final p playerViewVisibleTriggeredByUser$delegate;
    private final p resetHideTaskEvent$delegate;
    private final List<d> tmpControlItemList;
    private final p viewVisible$delegate;

    public static final class a {
        public static boolean a() {
            return ((Boolean) m61.a.a.getValue()).booleanValue();
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "isLocked", "isLocked()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "viewVisible", "getViewVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "playBackVisible", "getPlayBackVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "enablePlayback", "getEnablePlayback()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "enablePlayBackAbilityInMsg", "getEnablePlayBackAbilityInMsg()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "enablePlayBackAbilityInShift", "getEnablePlayBackAbilityInShift()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "playerViewVisibleTriggeredByUser", "getPlayerViewVisibleTriggeredByUser()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "resetHideTaskEvent", "getResetHideTaskEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "autoHideTaskEnable", "getAutoHideTaskEnable()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "controlAnimEndEvent", "getControlAnimEndEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LiveVisibilityControlContext.class, "customAnimDuration", "getCustomAnimDuration()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    private final m<Boolean> getEnablePlayBackAbilityInMsg() {
        return (m) this.enablePlayBackAbilityInMsg$delegate.a(this, $$delegatedProperties[4]);
    }

    private final m<Boolean> getEnablePlayBackAbilityInShift() {
        return (m) this.enablePlayBackAbilityInShift$delegate.a(this, $$delegatedProperties[5]);
    }

    private final m<Boolean> getEnablePlayback() {
        return (m) this.enablePlayback$delegate.a(this, $$delegatedProperties[3]);
    }

    private final m<Boolean> getPlayBackVisible() {
        return (m) this.playBackVisible$delegate.a(this, $$delegatedProperties[2]);
    }

    private final m<Boolean> getViewVisible() {
        return (m) this.viewVisible$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getAutoHideTaskEnable() {
        return (m) this.autoHideTaskEnable$delegate.a(this, $$delegatedProperties[8]);
    }

    public final k<Boolean> getControlAnimEndEvent() {
        return (k) this.controlAnimEndEvent$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Long> getCustomAnimDuration() {
        return (m) this.customAnimDuration$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Boolean> getPlayerViewVisibleTriggeredByUser() {
        return (m) this.playerViewVisibleTriggeredByUser$delegate.a(this, $$delegatedProperties[6]);
    }

    public final k<Unit> getResetHideTaskEvent() {
        return (k) this.resetHideTaskEvent$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> isLocked() {
        return (m) this.isLocked$delegate.a(this, $$delegatedProperties[0]);
    }

    private final void checkEnablePlayback() {
        if (this.enablePlayBackAbilityInRoom == false) goto L12;
        if (((Boolean) getEnablePlayBackAbilityInMsg().getValue()).booleanValue() == false) goto L12;
        if (((Boolean) getEnablePlayBackAbilityInShift().getValue()).booleanValue() == false) goto L12;
        if (((Boolean) getEnablePlayback().getValue()).booleanValue() == true) goto L15;
        getEnablePlayback().setValue(Boolean.TRUE);
        return;
    L15:
        return;
    L12:
        if (((Boolean) getEnablePlayback().getValue()).booleanValue() == false) goto L17;
        getEnablePlayback().setValue(Boolean.FALSE);
        return;
    }

    public final boolean enablePlayBackAbility() {
        Companion.getClass();
        if (a.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) getEnablePlayback().getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public final boolean enablePlayBackInEnterRoom() {
        Companion.getClass();
        if (a.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enablePlayBackAbilityInRoom == false) goto L7;
        return true;
    }

    public LiveVisibilityControlContext() {
        this.initVisible = true;
        Boolean r0 = Boolean.FALSE;
        this.isLocked$delegate = q.d(this, r0);
        Boolean r1 = Boolean.TRUE;
        this.viewVisible$delegate = q.d(this, r1);
        this.playBackVisible$delegate = q.d(this, r0);
        this.enablePlayback$delegate = q.d(this, r0);
        this.enablePlayBackAbilityInMsg$delegate = q.d(this, r1);
        this.enablePlayBackAbilityInShift$delegate = q.d(this, r0);
        this.playerViewVisibleTriggeredByUser$delegate = q.d(this, r0);
        this.tmpControlItemList = new ArrayList();
        this.resetHideTaskEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.autoHideTaskEnable$delegate = q.d(this, r1);
        this.controlAnimEndEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.customAnimDuration$delegate = q.d(this, -1L);
    }

    public final m<Boolean> getEnablePlaybackMutable() {
        return getEnablePlayback();
    }

    public final m<Boolean> getPlayBackAbilityInMsgMutable() {
        return getEnablePlayBackAbilityInMsg();
    }

    public final m<Boolean> getPlayBackAbilityInShiftMutable() {
        return getEnablePlayBackAbilityInShift();
    }

    public final m<Boolean> getPlaybackVisibleMutable() {
        return getPlayBackVisible();
    }

    public final boolean getPlaybackVisibleValue() {
        return ((Boolean) getPlayBackVisible().getValue()).booleanValue();
    }

    public final m<Boolean> getViewVisibleMutable() {
        return getViewVisible();
    }

    public final boolean getInitVisible() {
        return this.initVisible;
    }

    public final List<d> getTmpControlItemList() {
        return this.tmpControlItemList;
    }

    public final void setInitVisible(boolean r1) {
        this.initVisible = r1;
    }

    public final void setPlayBackAbilityInMsg(boolean r3) {
        getEnablePlayBackAbilityInMsg().setValue(Boolean.valueOf(r3));
        checkEnablePlayback();
        ALogger.i(enablePlayBackTag, "LiveVisibilityControlContext #  set enablePlayBackAbilityInMsg to " + r3);
    }

    public final void setPlayBackAbilityInRoom(boolean r3) {
        this.enablePlayBackAbilityInRoom = r3;
        checkEnablePlayback();
        ALogger.i(enablePlayBackTag, "LiveVisibilityControlContext #  set enablePlayBackAbilityInRoom to " + r3);
    }

    public final void setPlayBackAbilityInShift(boolean r2) {
        getEnablePlayBackAbilityInShift().setValue(Boolean.valueOf(r2));
        checkEnablePlayback();
    }

    public final void setPlaybackVisibleValue(boolean r4) {
        if (r4 == true) goto L5;
    L7:
        if (r4 == true) goto L10;
        ALogger.i(visibilityControlTag, "LiveVisibilityControlContext #  set playBackTetrisVisible false");
        getPlayBackVisible().setValue(Boolean.FALSE);
        return;
    L10:
        return;
    L5:
        if (enablePlayBackAbility() == false) goto L7;
        ALogger.i(visibilityControlTag, "LiveVisibilityControlContext #  set playBackTetrisVisible true");
        getPlayBackVisible().setValue(Boolean.TRUE);
        goto L7
    }

    public final void setViewVisibleValue(boolean r3) {
        ALogger.d(visibilityControlTag, "b change to  " + r3);
        getViewVisible().setValue(Boolean.valueOf(r3));
    }
}
