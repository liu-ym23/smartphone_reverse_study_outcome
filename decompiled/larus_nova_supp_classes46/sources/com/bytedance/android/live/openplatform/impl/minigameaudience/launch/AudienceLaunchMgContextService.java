package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import am2.n;
import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.AudienceMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.CandyToolbarContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.config.a90;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/launch/AudienceLaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/launch/LaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLaunchMgContextService extends LaunchMgContextService {
    public final String a;
    public long b;
    public CompositeDisposable c;
    public final boolean d;

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        this.b = 0;
        IHostLiveOpenPlatform r0 = TTLiveSDK.hostService().hostOpenPlatform();
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(r1.put("event", "onDestroy"));     // Catch: Throwable -> L5
    L7:
        Unit r3 = Unit.INSTANCE;
        r0.dispatchMiniGameEvent("live_room_lifecycle_event", r1);
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public AudienceLaunchMgContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = "AudienceLaunchMgContextService";
        this.d = !((Boolean) a90.a.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService
    public final Map<String, String> f(HashMap<String, String> r8) {
        Map<String, String> r9 = super.f(r8);
        fr0.b.a r0 = ((CandyToolbarContextService) getOpenPlatformContext().getService(CandyToolbarContextService.class)).b;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.i();
        if (r2 == null) goto L6;
    L7:
        r9.put("task_id", r2);
        if (r0 == null) goto L13;
        String r3 = r0.h();
        if (r3 == null) goto L13;
        r1 = r3;
    L13:
        r9.put("mp_name", r1);
        String r4 = null;
        if (r0 == null) goto L16;
        Integer r5 = Integer.valueOf(r0.e());
    L17:
        boolean r6 = true;
        if (r5 != null) goto L21;
    L23:
        if (r5 != null) goto L26;
    L28:
        r9.put("is_anchor", "0");
        r9.put("ad_id", n.f().a());
        DataCenter r7 = getOpenPlatformContext().getDataCenter();
        if (r7 == null) goto L31;
        Boolean r10 = (Boolean) r7.get("enter_from_dou_plus", Boolean.FALSE);
    L33:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L35;
        r9.put("if_dou", "1");
    L36:
        String r11 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        if ((!StringsKt.isBlank(r11)) == true) goto L40;
        r11 = null;
    L40:
        String r12 = "natural";
        if (r11 != null) goto L43;
        r11 = "natural";
    L43:
        r9.put("is_other_channel", r11);
        String r13 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        if ((!StringsKt.isBlank(r13)) == true) goto L47;
        r13 = null;
    L47:
        if (r13 == null) goto L50;
        r12 = r13;
    L50:
        r9.put("is_ad_channel", r12);
        r9.putAll(com.bytedance.android.live.openplatform.impl.base.utils.n.b());
        if (r0 == null) goto L67;
        String r14 = r0.b();
        if (r14 == null) goto L67;
        if (r14.length() <= 0) goto L57;
        boolean r15 = true;
    L58:
        if (r15 == true) goto L60;
    L62:
        r6 = false;
    L63:
        if (r6 == false) goto L65;
        r4 = r14;
    L65:
        if (r4 == null) goto L67;
        String r16 = r9.put("click_id_nature", r4);
        goto L67
    L60:
        if (r9.containsKey("clickid") == true) goto L62;
    L57:
        r15 = false;
    L67:
        AudienceMiniGameAppLogContextService r17 = (AudienceMiniGameAppLogContextService) getOpenPlatformContext().getService(AudienceMiniGameAppLogContextService.class);
        r9.putAll(r17.g());
        HashMap<String, String> r18 = r17.f();
        if (r18 == null) goto L70;
        r9.putAll(r18);
    L70:
        return r9;
    L35:
        r9.put("if_dou", "0");
        goto L36
    L31:
        r10 = null;
        goto L33
    L26:
        if (r5.intValue() != 2) goto L28;
        r9.put("game_type", "game_station");
        goto L28
    L21:
        if (r5.intValue() != 1) goto L23;
        r9.put("game_type", "micro_game");
        goto L28
    L16:
        r5 = null;
    L6:
        r2 = "";
        goto L7
    }

    public static void j(final AudienceLaunchMgContextService r3, final MountedMiniGameSource r4, final HashMap r5) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "source");
        final Function1 r1 = null;
        Function0<Unit> r0 = new AudienceLaunchMgContextService$openMiniGame$1(r3, r5, r4, r1);
        if (k.n(IUserService.class).user().isLogin() == true) goto L5;
        com.bytedance.android.livesdk.user.f r6 = k.n(IUserService.class).user();
        Context r7 = r3.getOpenPlatformContext().getContext();
        l.a r2 = new l.a();
        r2.a = s1.B(2131915990);
        r2.d = "open_platform";
        r2.c = -1;
        r3.autoDispose(r6.login(r7, new l(r2)).subscribe(new a(r3, r0), new b(r3)));
        return;
    L5:
        r0.invoke();
    }
}
