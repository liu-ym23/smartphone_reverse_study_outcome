package com.bytedance.android.live.liveinteract.linkbase.api;

import bn0.b;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.f0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.scope.m;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J'\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013\u0012\u0004\u0012\u00020\u00110\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/f0;", "Lcom/bytedance/android/livesdk/chatroom/widget/j1;", "", "onCreate", "onDestroy", "", "getScene", "", "source", "setSource", "getSource", "Lbn0/b;", "multiLinkRoomScope", "setMultiLinkRoomScope", "getMultiLinkRoomScope", "Ldn0/b;", "T", "Ljava/lang/Class;", "serviceType", "getScopeServiceInMultiLinkRoom", "(Ljava/lang/Class;)Ldn0/b;", "getScopeServiceOrNullInMultiLinkRoom", "_source", "Ljava/lang/String;", "_multiLinkRoomScope", "Lbn0/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "multiLinkRoomScopeServiceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseMultiLinkWidget extends MiddlewareRoomWidget implements f0, j1 {
    private b _multiLinkRoomScope;
    private String _source;
    private final ConcurrentHashMap<Class<? extends dn0.b>, dn0.b> multiLinkRoomScopeServiceMap;

    public abstract int getScene();

    public BaseMultiLinkWidget() {
        this.multiLinkRoomScopeServiceMap = new ConcurrentHashMap();
    }

    public b getMultiLinkRoomScope() {
        return this._multiLinkRoomScope;
    }

    public String getSource() {
        return this._source;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
    }

    public <T extends dn0.b> T getScopeServiceInMultiLinkRoom(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        b r0 = this._multiLinkRoomScope;
        if (r0 == null) goto L18;
        m r1 = m.e;
        Intrinsics.checkNotNull(r0);
        T r2 = (T) r1.d(r0, r4);
        if (r2 != null) goto L10;
        dn0.b r3 = this.multiLinkRoomScopeServiceMap.get(r4);
        if ((r3 instanceof dn0.b) == true) goto L9;
        r3 = null;
    L9:
        r2 = (T) r3;
    L10:
        if (r2 == null) goto L16;
        if (this.multiLinkRoomScopeServiceMap.containsKey(r4) == true) goto L14;
        this.multiLinkRoomScopeServiceMap.put((Class<? extends dn0.b>) r4, r2);
    L14:
        return r2;
    L16:
        throw new Exception("service can not be null, serviceType = " + r4);
    L18:
        throw new Exception("_multiLinkRoomScope can not be null");
    }

    public <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        b r0 = this._multiLinkRoomScope;
        T r1 = null;
        if (r0 == null) goto L19;
        m r2 = m.e;
        Intrinsics.checkNotNull(r0);
        T r3 = (T) r2.d(r0, r4);
        if (r3 != null) goto L11;
        dn0.b r5 = this.multiLinkRoomScopeServiceMap.get(r4);
        if ((r5 instanceof dn0.b) == true) goto L9;
        r5 = null;
    L9:
        r3 = (T) r5;
    L11:
        if (this.multiLinkRoomScopeServiceMap.containsKey(r4) == false) goto L13;
    L18:
        return r3;
    L13:
        if ((r3 instanceof dn0.b) == false) goto L16;
        r1 = r3;
    L16:
        if (r1 == null) goto L18;
        this.multiLinkRoomScopeServiceMap.put((Class<? extends dn0.b>) r4, r1);
        goto L18
    L19:
        return null;
    }

    public void setMultiLinkRoomScope(b r1) {
        this._multiLinkRoomScope = r1;
    }

    public final void setSource(String r1) {
        this._source = r1;
    }
}
