package il0;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a implements IService {
    public a() {
    }

    public void broadcastAuthUtilsCheckLogin(Context r1, boolean r2, Function1<? super IBaseUser, Unit> r3, Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onAuth");
        Intrinsics.checkNotNullParameter(r4, "onError");
    }

    public void commonPopupMessageWidgetOnInRoomPushEvent(Widget r1, WeakHandler r2, Object r3, int r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "dismissBlock");
    }

    public String getSecKey() {
        return "";
    }

    public IUserRealtimeSignalFeature getUserRealtimeSignalFeature() {
        return null;
    }

    public boolean initAudioSDKPluginLoader() {
        return false;
    }

    public void openAgreeToStartLiveDialog(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "verifyParam");
    }

    public void preloadOnlineEmoji() {
    }

    public void readLocationForSaas(Context r2, Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "runAfter");
    }

    public static /* synthetic */ void broadcastAuthUtilsCheckLogin$default(a r0, Context r1, boolean r2, Function1 r3, Function1 r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.broadcastAuthUtilsCheckLogin(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: broadcastAuthUtilsCheckLogin");
    }
}
