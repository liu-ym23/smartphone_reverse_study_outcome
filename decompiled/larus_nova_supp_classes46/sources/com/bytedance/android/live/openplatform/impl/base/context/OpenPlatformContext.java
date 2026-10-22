package com.bytedance.android.live.openplatform.impl.base.context;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.impl.base.utils.a;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.disposables.Disposable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import ro0.b;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u00103\u001a\u000202\u0012\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J%\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\r*\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\r\u0010\u0018\u001a\u00020\u0005*\u00020\u0015H\u0096\u0001R$\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00108\u001a\u0004\u0018\u0001078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020<8&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010>¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Lro0/a;", "manager", "", "onMessageManagerInitialized", "Landroidx/lifecycle/Lifecycle$Event;", "event", "dispatchLifecycleEvent", "onCreate", "onDestroy", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "T", "Ljava/lang/Class;", "serviceClass", "getService", "(Ljava/lang/Class;)Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "", "serviceMap", "Ljava/util/Map;", "Landroidx/lifecycle/LifecycleRegistry;", "_lifecycle$delegate", "Lkotlin/Lazy;", "get_lifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "_lifecycle", "", "roomId", "J", "getRoomId", "()J", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", PbRequest.SwitchType.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "messageManager", "Lro0/a;", "getMessageManager", "()Lro0/a;", "setMessageManager", "(Lro0/a;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "", "isAnchor", "()Z", "isInLive", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformContext implements LifecycleOwnerCompat {
    private final /* synthetic */ a $$delegate_0;
    private final Lazy _lifecycle$delegate;
    private final Context context;
    private final DataCenter dataCenter;
    private ro0.a messageManager;
    private final Room room;
    private final long roomId;
    private final Map<Class<?>, OpenPlatformContextService> serviceMap;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private final LifecycleRegistry get_lifecycle() {
        return (LifecycleRegistry) this._lifecycle$delegate.getValue();
    }

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public abstract boolean isAnchor();

    public abstract boolean isInLive();

    public void onCreate() {
    }

    public void onMessageManagerInitialized(ro0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.$$delegate_0.c(r2);
    }

    public Lifecycle getLifecycleCompat() {
        return get_lifecycle();
    }

    public void onDestroy() {
        dispose();
        this.serviceMap.clear();
        ro0.a r0 = this.messageManager;
        if (r0 == null) goto L17;
        Iterator<b<?>> r1 = r0.a.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        b<?> r2 = r1.next();
        r2.c.b();
        d r3 = r0.b;
        if (r3 == null) goto L6;
        r3.removeMessageListener(r2.a);
        goto L6
    L10:
        r0.a.clear();
        return;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final ro0.a getMessageManager() {
        return this.messageManager;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_openplatform_impl_base_context_OpenPlatformContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final void dispatchLifecycleEvent(Lifecycle.Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        get_lifecycle().handleLifecycleEvent(r2);
        if (r2 != Lifecycle.Event.ON_CREATE) goto L6;
        onCreate();
    L6:
        if (r2 != Lifecycle.Event.ON_DESTROY) goto L9;
        onDestroy();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Class, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Class] */
    public final <T extends OpenPlatformContextService> T getService(Class<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "serviceClass");
        Map<Class<?>, OpenPlatformContextService> r0 = this.serviceMap;
        monitor-enter(r0);
        Annotation[] r1 = r6.getAnnotations();     // Catch: Throwable -> L32
        int r2 = r1.length;     // Catch: Throwable -> L32
    L5:
        r2 = r2 - 1;     // Catch: Throwable -> L32
        if (r2 < 0) goto L10;
        Annotation r3 = r1[r2];     // Catch: Throwable -> L32
        if ((r3 instanceof ContextServiceImpl) == false) goto L5;
    L11:
        if (r3 != null) goto L13;
    L22:
        T r4 = (T) this.serviceMap.get(r6);     // Catch: Throwable -> L32
        if (r4 != null) goto L28;
        Object r5 = r6.getConstructor(new Class[]{OpenPlatformContext.class}).newInstance(new Object[]{this});     // Catch: Throwable -> L32
        if (r5 == null) goto L31;
        r4 = (T) r5;     // Catch: Throwable -> L32
        this.serviceMap.put((Class<?>) r6, r4);     // Catch: Throwable -> L32
        r4.init$liveopenplatform_impl_saasRelease();     // Catch: Throwable -> L32
        goto L28
    L31:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L32
    L28:
        monitor-exit(r0);
        return r4;
    L13:
        if ((r3 instanceof ContextServiceImpl) == false) goto L22;
        if (isAnchor() == true) goto L17;
        String r7 = ((ContextServiceImpl) r3).audienceService();     // Catch: Throwable -> L32
    L21:
        r6 = (Class<T>) INVOKESTATIC_com_bytedance_android_live_openplatform_impl_base_context_OpenPlatformContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r7);
        goto L22
    L17:
        if (isInLive() == false) goto L19;
        r7 = ((ContextServiceImpl) r3).liveAnchorService();     // Catch: Throwable -> L32
        goto L21
    L19:
        r7 = ((ContextServiceImpl) r3).previewAnchorService();     // Catch: Throwable -> L32
        goto L21
    L10:
        r3 = null;
    L32:
        th = move-exception;
        throw th;
    }

    public final void setMessageManager(ro0.a r1) {
        this.messageManager = r1;
    }

    public OpenPlatformContext(Context r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.$$delegate_0 = new a();
        this.context = r6;
        this.dataCenter = r7;
        this.serviceMap = new HashMap();
        this._lifecycle$delegate = LazyKt.lazy(new OpenPlatformContext$_lifecycle$2(this));
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r3 = RoomContext.a.c(r8, r7, 0, 2);
        if (r3 == null) goto L9;
        m r4 = r3.getRoom();
        if (r4 == null) goto L9;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L9;
        long r9 = r5.getRoomId();
    L10:
        this.roomId = r9;
        RoomContext r10 = RoomContext.a.c(r8, r7, 0, 2);
        if (r10 == null) goto L15;
        m r11 = r10.getRoom();
        if (r11 == null) goto L15;
        Room r12 = (Room) r11.getValue();
    L16:
        this.room = r12;
        RoomContext r13 = RoomContext.a.c(r8, r7, 0, 2);
        if (r13 == null) goto L22;
        j r14 = r13.getMessageManager();
        if (r14 == null) goto L23;
        r14.c(new AnonymousClass1(this));
        return;
    L23:
        return;
    L22:
        return;
    L15:
        r12 = null;
    L9:
        r9 = 0;
        goto L10
    }
}
