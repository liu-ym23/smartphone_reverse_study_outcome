package com.bytedance.android.live.room.api.screenrotation.api;

import a81.a;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.screenrotate.ScreenRotateService")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&JA\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0012H&J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0012H&J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0014H&J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0014H&J\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\"\u001a\u00020!H&J\u001a\u0010%\u001a\u00020$2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020#H&J\u0010\u0010&\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020#H&J\u001a\u0010'\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020#H&J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020#H&J\n\u0010)\u001a\u0004\u0018\u00010\u0014H&¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/api/IScreenRotateService;", "Lcom/bytedance/android/live/room/api/screenrotation/api/IMiddlewareScreenRotateService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initRotateContext", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/d;", "rotateSession", "dc", "Lz71/a;", "rotateContext", "R", "Lkotlin/Function1;", "action", "useContext", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/a;", "rotateHandler", "Lc81/a;", "rotateInterceptor", "Lcom/bytedance/android/live/room/api/screenrotation/entrance/b;", "entranceVisibleNotify", "handler", "", "registerRotateHandler", "unregisterRotateHandler", "interceptor", "registerRotateInterceptor", "unregisterRotateInterceptor", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "rotateMonitor", "La81/a;", "configHandler", "La81/b;", "Lio/reactivex/disposables/Disposable;", "registerOnConfigChanged", "registerGlobalOnConfigChanged", "unregisterOnConfigChanged", "unregisterOnGlobalConfigChanged", "paidLiveRotateInterceptor", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IScreenRotateService extends IMiddlewareScreenRotateService {
    a configHandler();

    b entranceVisibleNotify();

    DataContext initRotateContext(DataCenter r1, RoomContext r2);

    c81.a paidLiveRotateInterceptor();

    Disposable registerGlobalOnConfigChanged(a81.b r1);

    Disposable registerOnConfigChanged(DataCenter r1, a81.b r2);

    void registerRotateHandler(com.bytedance.android.live.room.api.screenrotation.rotate.a r1);

    void registerRotateInterceptor(c81.a r1);

    z71.a rotateContext(DataCenter r1);

    com.bytedance.android.live.room.api.screenrotation.rotate.a rotateHandler();

    c81.a rotateInterceptor();

    IScreenRotateMonitor rotateMonitor(DataCenter r1);

    d rotateSession(DataCenter r1, RoomContext r2);

    void unregisterOnConfigChanged(DataCenter r1, a81.b r2);

    void unregisterOnGlobalConfigChanged(a81.b r1);

    void unregisterRotateHandler(com.bytedance.android.live.room.api.screenrotation.rotate.a r1);

    void unregisterRotateInterceptor(c81.a r1);

    <R> R useContext(RoomContext r1, DataCenter r2, Function1<? super z71.a, ? extends R> r3);
}
