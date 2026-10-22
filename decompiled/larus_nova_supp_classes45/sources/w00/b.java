package w00;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.LiveBroadcastBaseClientCopy;
import com.bytedance.android.live.broadcast.LiveCameraResManager;
import com.bytedance.android.live.broadcast.api.BroadcastRoomApi;
import com.bytedance.android.live.broadcast.dialog.PosterGenerateDialog;
import com.bytedance.android.live.broadcast.g;
import com.bytedance.android.live.broadcast.i;
import com.bytedance.android.live.broadcast.perftools.BroadcastKevaHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.config.qe0;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.broadcast.LiveBroadcastHashTagUpdateParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.android.scope.o;
import com.bytedance.keva.Keva;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import nz.h;
import org.json.JSONObject;
import py.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements o, g00.c {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "roomUpdateInfoResultResponse");
            return Integer.valueOf(((BaseResponse) r3).statusCode);
        }
    }

    public b() {
    }

    public final void onStop() {
    }

    @Override // g00.c
    public final String getLiveCoreVersion() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        if (r0 == null) goto L6;
        String r1 = r0.getVersion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // g00.c
    public final boolean hasPoiPermission() {
        IUserService r0 = k.f(IUserService.class);
        Boolean r1 = null;
        if (r0 == null) goto L7;
        f r2 = r0.user();
        if (r2 == null) goto L7;
        IUser r3 = r2.b();
    L8:
        boolean r4 = false;
        if ((r3 instanceof User) == true) goto L11;
        return false;
    L11:
        if (r3.getPoiInfo() == null) goto L21;
        q r5 = r3.getPoiInfo();
        if (r5 == null) goto L15;
        Boolean r6 = Boolean.valueOf(r5.isPoiPermission());
    L17:
        if (r6.booleanValue() == false) goto L21;
        if (r3.getSecret() == 1) goto L21;
        r4 = true;
        goto L21
    L15:
        r6 = null;
    L21:
        if (r4 == true) goto L33;
        if (r3.getPoiInfo() == null) goto L33;
        q r7 = r3.getPoiInfo();
        if (r7 == null) goto L28;
        r1 = Boolean.valueOf(r7.isFollowPermission());
    L28:
        if (r1.booleanValue() == false) goto L33;
        if (r3.getSecret() == 1) goto L33;
        return true;
    L33:
        return r4;
    L7:
        r3 = null;
        goto L8
    }

    @Override // g00.c, nz.t
    public final void init() {
        ALogger.i("BroadcastGlobalScope", "GlobalBroadcastShared.init");
        if (i.d == null) goto L5;
    L14:
        i r0 = i.d;
        r0.getClass();
        if (((Boolean) qe0.a.getValue()).booleanValue() == true) goto L54;
        ALogger.e("LiveBroadcastContext", "LibraryLoader.setupLibraryLoader");     // Catch: Throwable -> L38
        i.b();     // Catch: Throwable -> L38
        if (k.f(IHostAction.class).isLiveInPluginMode() == true) goto L36;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L38
        ILiveWrappedLivePusher.a.b().getLibraryLoader();     // Catch: Throwable -> L38
        throw null;     // Catch: Throwable -> L38
    L36:
        ALogger.e("LiveBroadcastContext", "EarlyAVLog.setEarlyLogPrint");     // Catch: Throwable -> L38
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L38
        ILiveWrappedLivePusher.a.b().getEarlyAVLog();     // Catch: Throwable -> L38
        throw null;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ALogger.e("LiveBroadcastContext", th);
        if (r0.b == true) goto L59;
        LiveEffectContextFactoryDelegate$Type r1 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        List<String> r2 = LiveEffectContext.h;
        LiveEffectContext r3 = LiveEffectContext.a.a(r1);
        com.bytedance.android.live.effect.api.c r4 = r0.a();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "service");
        r3.c().b(r4);
        NewPluginType r5 = NewPluginType.LiveResource;
        r5.load(r0.getContext(), true);
        LiveSdkApiForSaaS.Companion.getClass();
        LiveSdkApiForSaaS.a.a().initAudioSDKPluginLoader();
        r5.load(r0.a, true);     // Catch: Throwable -> L45
    L47:
        r0.b = true;
        return;
    L45:
        th = move-exception;
        th.printStackTrace();
        goto L47
    L59:
        return;
    L54:
    L25:
        th = move-exception;
        ALogger.e("LiveBroadcastContext", th);
        ((LinkedHashMap) i.e).clear();
        LiveEffectContextFactoryDelegate$Type r6 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        List<String> r7 = LiveEffectContext.h;
        LiveEffectContext r8 = LiveEffectContext.a.a(r6);
        com.bytedance.android.live.effect.api.c r9 = r0.a();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "service");
        r8.c().b(r9);
        NewPluginType.LiveResource.load(r0.getContext(), true);     // Catch: Throwable -> L29
        LiveSdkApiForSaaS.Companion.getClass();     // Catch: Throwable -> L29
        LiveSdkApiForSaaS.a.a().initAudioSDKPluginLoader();     // Catch: Throwable -> L29
    L31:
        LiveCameraResManager.INST.loadResources();
        r0.b = true;
        return;
    L29:
        th = move-exception;
        ALogger.e("LiveBroadcastContext", th);
        goto L31
    L17:
        if (r0.b == false) goto L19;
        ALogger.e("LiveBroadcastContext", "initV2: has init,skip");     // Catch: Throwable -> L25
        return;
    L19:
        i.b();     // Catch: Throwable -> L25
        ALogger.e("LiveBroadcastContext", "start initV2");     // Catch: Throwable -> L25
        if (k.f(IHostAction.class).isLiveInPluginMode() == true) goto L23;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L25
        ILiveWrappedLivePusher.a.b().getLibraryLoader();     // Catch: Throwable -> L25
        new ArrayList();     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L23:
        ALogger.e("LiveBroadcastContext", "EarlyAVLog.setEarlyLogPrint");     // Catch: Throwable -> L25
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L25
        ILiveWrappedLivePusher.a.b().getEarlyAVLog();     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L5:
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i.d != null) goto L9;
        i.d = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void onStart() {
        ALogger.i("BroadcastGlobalScope", "GlobalBroadcastShared.onStart");
    }

    @Override // nz.t
    public final boolean isOpen() {
        return NewBroadcastSharedConfig.a().booleanValue();
    }

    @Override // g00.c
    public final h getBroadcastBubbleManager() {
        return g.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g00.c
    public final void savePerfKeva(JSONObject r5) {
        Keva r0 = BroadcastKevaHelper.a;
        Intrinsics.checkNotNullParameter("performance_key", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        String r6 = r5.toString();
        Intrinsics.checkNotNullParameter("performance_key", "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        if ((r6 instanceof String) == false) goto L6;
        BroadcastKevaHelper.a.storeString("performance_key", r6);
        return;
    L6:
        if ((r6 instanceof Integer) == false) goto L9;
        BroadcastKevaHelper.a.storeInt("performance_key", ((Number) r6).intValue());
        return;
    L9:
        if ((r6 instanceof Boolean) == false) goto L12;
        BroadcastKevaHelper.a.storeBoolean("performance_key", ((Boolean) r6).booleanValue());
        return;
    L12:
        if ((r6 instanceof Float) == false) goto L15;
        BroadcastKevaHelper.a.storeFloat("performance_key", ((Number) r6).floatValue());
        return;
    L15:
        if ((r6 instanceof Long) == false) goto L18;
        BroadcastKevaHelper.a.storeLong("performance_key", ((Number) r6).longValue());
        return;
    L18:
        if ((r6 instanceof Set) == false) goto L20;
        BroadcastKevaHelper.a.storeStringSet("performance_key", (Set) r6);
        return;
    L20:
        BroadcastKevaHelper.a.storeString("performance_key", r6.toString());
    }

    @Override // g00.c
    public final Observable<Integer> updateBroadcastRoomHashTag(LiveBroadcastHashTagUpdateParams r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Lazy r0 = LiveBroadcastBaseClientCopy.a;
        return ((BroadcastRoomApi) LiveBroadcastBaseClientCopy.a(BroadcastRoomApi.class)).updateRoomHashTag(r11.getRoomId(), r11.getOldHashTagId(), r11.getNewHashTagId(), r11.getNewHashTagName()).map(a.a);
    }

    @Override // g00.c
    public final z00.k a(Fragment r2, Room r3) {
        Intrinsics.checkNotNullParameter(r2, "mFragment");
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.PAGE.ROOM);
        return new z00.k(r2, r3);
    }

    @Override // g00.c
    public final void openPosterGenerateDialog(Context r3, AnchorColumnPosterInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "posterInfo");
        int r1 = PosterGenerateDialog.h;
        Intrinsics.checkNotNullParameter(r4, "posterInfo");
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof FragmentActivity) == false) goto L17;
        PosterGenerateDialog r0 = new PosterGenerateDialog();
        r0.e = r4;
        FragmentManager r5 = ((FragmentActivity) r3).getSupportFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "PosterGenerateDialog", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r0, r6) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        r0.show(r5, "PosterGenerateDialog");
        return;
    L18:
        return;
    }
}
