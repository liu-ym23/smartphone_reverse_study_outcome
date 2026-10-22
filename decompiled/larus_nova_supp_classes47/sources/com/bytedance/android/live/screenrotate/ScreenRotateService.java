package com.bytedance.android.live.screenrotate;

import c81.a;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.rotate.c;
import com.bytedance.android.live.room.api.screenrotation.rotate.e;
import com.bytedance.android.live.screenrotate.config.ConfigChangeHandler;
import com.bytedance.android.live.screenrotate.rotate.ScreenRotateContext;
import com.bytedance.android.live.screenrotate.rotate.d;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016JA\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u001a\u0010'\u001a\u00020&2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020%H\u0016J\u001a\u0010)\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020%H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006."}, d2 = {"Lcom/bytedance/android/live/screenrotate/ScreenRotateService;", "Lcom/bytedance/android/live/room/api/screenrotation/api/IScreenRotateService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initRotateContext", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/d;", "rotateSession", "dc", "Lz71/a;", "rotateContext", "R", "Lkotlin/Function1;", "action", "useContext", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/e;", "rotation", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/a;", "rotateHandler", "Lc81/a;", "rotateInterceptor", "Lcom/bytedance/android/live/room/api/screenrotation/entrance/b;", "entranceVisibleNotify", "handler", "", "registerRotateHandler", "unregisterRotateHandler", "interceptor", "registerRotateInterceptor", "unregisterRotateInterceptor", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "rotateMonitor", "La81/a;", "configHandler", "La81/b;", "Lio/reactivex/disposables/Disposable;", "registerOnConfigChanged", "registerGlobalOnConfigChanged", "unregisterOnConfigChanged", "unregisterOnGlobalConfigChanged", "paidLiveRotateInterceptor", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ScreenRotateService implements IScreenRotateService {
    public ScreenRotateService() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public a paidLiveRotateInterceptor() {
        ScreenRotateContext.Companion.getClass();
        z71.a r1 = ScreenRotateContext.Companion.a(null);
        if (r1 == null) goto L21;
        c r2 = r1.getHandleRegistry();
        if (r2 == null) goto L22;
        List<a> r3 = r2.e();
        if (r3 == null) goto L23;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((a) r5).getTag(), "paid_live") == false) goto L10;
        r0.add(r5);
        goto L10
    L15:
        return (a) CollectionsKt.firstOrNull(r0);
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public a81.a configHandler() {
        return ConfigChangeHandler.b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public b entranceVisibleNotify() {
        return na1.a.c;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public com.bytedance.android.live.room.api.screenrotation.rotate.a rotateHandler() {
        return com.bytedance.android.live.screenrotate.rotate.c.a;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public a rotateInterceptor() {
        return oa1.b.a;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IMiddlewareScreenRotateService
    public e rotation() {
        return d.c;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public Disposable registerGlobalOnConfigChanged(a81.b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Map<a81.b, Disposable> r1 = ConfigChangeHandler.a;
        Intrinsics.checkNotNullParameter(r3, "action");
        ConcurrentHashMap r0 = (ConcurrentHashMap) ConfigChangeHandler.a;
        Disposable r2 = (Disposable) r0.get(r3);
        if (r2 != null) goto L6;
        Disposable r4 = Disposables.fromAction(new com.bytedance.android.live.screenrotate.config.a(r0, r3));
        r0.put(r3, r4);
        return r4;
    L6:
        return r2;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void registerRotateHandler(com.bytedance.android.live.room.api.screenrotation.rotate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        ScreenRotateContext.Companion.getClass();
        z71.a r0 = ScreenRotateContext.Companion.a(null);
        if (r0 == null) goto L8;
        c r1 = r0.getHandleRegistry();
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void registerRotateInterceptor(a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ScreenRotateContext.Companion.getClass();
        z71.a r0 = ScreenRotateContext.Companion.a(null);
        if (r0 == null) goto L8;
        c r1 = r0.getHandleRegistry();
        if (r1 == null) goto L9;
        r1.c(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public z71.a rotateContext(DataCenter r2) {
        ScreenRotateContext.Companion.getClass();
        return ScreenRotateContext.Companion.b(r2);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public IScreenRotateMonitor rotateMonitor(DataCenter r2) {
        ScreenRotateContext.Companion.getClass();
        z71.a r3 = ScreenRotateContext.Companion.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getMonitor();
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterOnGlobalConfigChanged(a81.b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Map<a81.b, Disposable> r1 = ConfigChangeHandler.a;
        Intrinsics.checkNotNullParameter(r3, "action");
        Disposable r4 = (Disposable) ((ConcurrentHashMap) ConfigChangeHandler.a).get(r3);
        if (r4 == null) goto L6;
        r4.dispose();
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterRotateHandler(com.bytedance.android.live.room.api.screenrotation.rotate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        ScreenRotateContext.Companion.getClass();
        z71.a r0 = ScreenRotateContext.Companion.a(null);
        if (r0 == null) goto L8;
        c r1 = r0.getHandleRegistry();
        if (r1 == null) goto L9;
        r1.f(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterRotateInterceptor(a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ScreenRotateContext.Companion.getClass();
        z71.a r0 = ScreenRotateContext.Companion.a(null);
        if (r0 == null) goto L8;
        c r1 = r0.getHandleRegistry();
        if (r1 == null) goto L9;
        r1.g(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public DataContext initRotateContext(DataCenter r2, RoomContext r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        ScreenRotateContext r0 = new ScreenRotateContext(r3, r2);
        r0.initialize();
        return r0;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public Disposable registerOnConfigChanged(DataCenter r2, a81.b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        ConfigChangeHandler.b.getClass();
        return ConfigChangeHandler.b(r2, r3);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public com.bytedance.android.live.room.api.screenrotation.rotate.d rotateSession(DataCenter r2, RoomContext r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        ScreenRotateContext.Companion.getClass();
        z71.a r0 = ScreenRotateContext.Companion.a(r3);
        if (r0 == null) goto L7;
        com.bytedance.android.live.room.api.screenrotation.rotate.d r1 = r0.getRotateSession();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new com.bytedance.android.live.screenrotate.rotate.a(r2, r3);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterOnConfigChanged(DataCenter r2, a81.b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        ConfigChangeHandler.b.getClass();
        ConfigChangeHandler.c(r2, r3);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public <R> R useContext(RoomContext r2, DataCenter r3, Function1<? super z71.a, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        ScreenRotateContext.Companion.getClass();
        return (R) ScreenRotateContext.Companion.c(r2, r3, r4);
    }
}
