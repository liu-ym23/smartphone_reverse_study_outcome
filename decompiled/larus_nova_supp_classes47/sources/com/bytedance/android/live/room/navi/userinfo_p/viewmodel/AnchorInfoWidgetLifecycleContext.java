package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.UserInfoContextExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR,\u0010\u0011\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00030\nj\b\u0012\u0004\u0012\u00020\u0003`\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000eR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR,\u0010\u0017\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00030\nj\b\u0012\u0004\u0012\u00020\u0003`\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u000eR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR,\u0010\u001c\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u000eR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000eR,\u0010!\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00030\nj\b\u0012\u0004\u0012\u00020\u0003`\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/AnchorInfoWidgetLifecycleContext;", "Lo81/a;", "Lcom/bytedance/live/datacontext/DataContext;", "", "notifyWidgetLoad", "notifyWidgetViewPrepared", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "notifyWidgetRoomEnter", "notifyWidgetUnload", "Lcom/bytedance/live/datacontext/n;", "_onWidgetLoad$delegate", "Lcom/bytedance/live/datacontext/p;", "get_onWidgetLoad", "()Lcom/bytedance/live/datacontext/n;", "_onWidgetLoad", "Lcom/bytedance/android/live/core/utils/IReadonlyNullable;", "onWidgetLoad", "Lcom/bytedance/live/datacontext/n;", "getOnWidgetLoad", "_onWidgetViewPrepared$delegate", "get_onWidgetViewPrepared", "_onWidgetViewPrepared", "onWidgetViewPrepared", "getOnWidgetViewPrepared", "_onWidgetRoomEnter$delegate", "get_onWidgetRoomEnter", "_onWidgetRoomEnter", "onWidgetRoomEnter", "getOnWidgetRoomEnter", "_onWidgetUnload$delegate", "get_onWidgetUnload", "_onWidgetUnload", "onWidgetUnload", "getOnWidgetUnload", "<init>", "()V", "Companion", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInfoWidgetLifecycleContext extends DataContext implements o81.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static final String TAG = "UserInfoWidgetLifecycleContext";
    private final p _onWidgetLoad$delegate;
    private final p _onWidgetRoomEnter$delegate;
    private final p _onWidgetUnload$delegate;
    private final p _onWidgetViewPrepared$delegate;
    private final n<? extends Unit> onWidgetLoad;
    private final n<? extends IRoom> onWidgetRoomEnter;
    private final n<? extends Unit> onWidgetUnload;
    private final n<? extends Unit> onWidgetViewPrepared;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnchorInfoWidgetLifecycleContext.class, "_onWidgetLoad", "get_onWidgetLoad()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorInfoWidgetLifecycleContext.class, "_onWidgetViewPrepared", "get_onWidgetViewPrepared()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorInfoWidgetLifecycleContext.class, "_onWidgetRoomEnter", "get_onWidgetRoomEnter()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorInfoWidgetLifecycleContext.class, "_onWidgetUnload", "get_onWidgetUnload()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    private final n<Unit> get_onWidgetLoad() {
        return (n) this._onWidgetLoad$delegate.a(this, $$delegatedProperties[0]);
    }

    private final n<IRoom> get_onWidgetRoomEnter() {
        return (n) this._onWidgetRoomEnter$delegate.a(this, $$delegatedProperties[2]);
    }

    private final n<Unit> get_onWidgetUnload() {
        return (n) this._onWidgetUnload$delegate.a(this, $$delegatedProperties[3]);
    }

    private final n<Unit> get_onWidgetViewPrepared() {
        return (n) this._onWidgetViewPrepared$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // o81.a
    public void notifyWidgetLoad() {
        ALogger.d(TAG, "notifyWidgetLoad");
        get_onWidgetLoad().setValue(Unit.INSTANCE);
    }

    @Override // o81.a
    public void notifyWidgetUnload() {
        ALogger.d(TAG, "notifyWidgetUnload");
        get_onWidgetUnload().setValue(Unit.INSTANCE);
    }

    @Override // o81.a
    public void notifyWidgetViewPrepared() {
        ALogger.d(TAG, "notifyWidgetViewPrepared");
        get_onWidgetViewPrepared().setValue(Unit.INSTANCE);
    }

    public AnchorInfoWidgetLifecycleContext() {
        this._onWidgetLoad$delegate = UserInfoContextExtKt.a(this);
        this.onWidgetLoad = get_onWidgetLoad();
        this._onWidgetViewPrepared$delegate = UserInfoContextExtKt.a(this);
        this.onWidgetViewPrepared = get_onWidgetViewPrepared();
        this._onWidgetRoomEnter$delegate = UserInfoContextExtKt.a(this);
        this.onWidgetRoomEnter = get_onWidgetRoomEnter();
        this._onWidgetUnload$delegate = UserInfoContextExtKt.a(this);
        this.onWidgetUnload = get_onWidgetUnload();
    }

    @Override // o81.a
    public n<? extends Unit> getOnWidgetLoad() {
        return this.onWidgetLoad;
    }

    @Override // o81.a
    public n<? extends IRoom> getOnWidgetRoomEnter() {
        return this.onWidgetRoomEnter;
    }

    @Override // o81.a
    public n<? extends Unit> getOnWidgetUnload() {
        return this.onWidgetUnload;
    }

    @Override // o81.a
    public n<? extends Unit> getOnWidgetViewPrepared() {
        return this.onWidgetViewPrepared;
    }

    @Override // o81.a
    public void notifyWidgetRoomEnter(IRoom r3) {
        ALogger.d(TAG, "notifyWidgetRoomEnter");
        get_onWidgetRoomEnter().setValue(r3);
    }
}
