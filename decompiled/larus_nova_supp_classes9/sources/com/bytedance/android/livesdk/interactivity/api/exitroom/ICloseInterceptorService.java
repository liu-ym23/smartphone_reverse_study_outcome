package com.bytedance.android.livesdk.interactivity.api.exitroom;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import m32.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016JF\u0010\u0018\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/exitroom/ICloseInterceptorService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "ctx", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Landroid/os/Bundle;", "extra", BuildConfig.FLAVOR, "Lkf1/a;", "provideCloseRoomInterceptors", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/lang/Runnable;", "afterInterceptRunnable", "Lm32/a;", "interceptor", "Lcom/bytedance/android/live/room/l;", "roomLogger", "Lkotlin/Function0;", BuildConfig.FLAVOR, "openDrawerAction", BuildConfig.FLAVOR, "showNewVerRoomQuitDialog", "createNewQuitRoomShowInterceptor", BuildConfig.FLAVOR, "cleanUgCouponInfo", "Lm32/b;", "createQuitRoomGuideController", "Companion", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICloseInterceptorService extends IService {
    public static final a Companion = null;
    public static final String TAG_QUIT_DIALOG = "AbsInteractionFragment_QuitDialog";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    List<Long> cleanUgCouponInfo();

    m32.a createNewQuitRoomShowInterceptor();

    b createQuitRoomGuideController();

    List<kf1.a> provideCloseRoomInterceptors(Context r1, Room r2, Bundle r3);

    boolean showNewVerRoomQuitDialog(Context r1, DataCenter r2, Runnable r3, m32.a r4, l r5, Function0<Unit> r6);
}
