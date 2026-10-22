package com.bytedance.android.livesdk.drawer.drawerlynx;

import com.bytedance.android.live.browser.jsbridge.base.CommunityDrawerUnfollowResultModel;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdk.user.n;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import w20.c0;
import w20.j8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends c0<j8, CommunityDrawerUnfollowResultModel> {
    public Disposable a;
    public final /* synthetic */ LiveDrawerLynxCard b;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public d(LiveDrawerLynxCard r1) {
        this.b = r1;
    }

    public final void invoke(Object r14, CallContext r15) {
        j8 r16 = (j8) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "cxt");
        n.c r17 = new n.c();
        ContextUtil.contextToActivity(this.b.getContext());
        Integer r0 = r16.d();
        if (r0 == null) goto L5;
        r0.intValue();
    L5:
        String r1 = r16.e();
        if (r1 == null) goto L8;
        long r3 = CastLongProtector.parseLong(r1);
    L9:
        n.c r18 = r17.f(r3).c(r16.f()).e(j.b(LiveFollowScene.LIVE_DRAWER));
        r18.getClass();
        n r2 = new n(r18);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        Disposable r4 = null;
        r19.element = null;
        j8.a r5 = r16.a();
        if (r5 == null) goto L22;
        String r6 = r5.a();
        if (r6 == null) goto L22;
        JSONObject r7 = new JSONObject(r6);
        String r8 = r7.optString("item_id", "");
        String r9 = r16.e();
        if (r9 != null) goto L16;
        String r10 = "";
    L17:
        String r11 = String.valueOf(r7.optLong("episode_id", 0));
        String r12 = r7.optString("season_id", "");
        JSONObject r13 = r7.optJSONObject("mod");
        if (r13 == null) goto L20;
        int r110 = r13.optInt("episode_stage");
    L21:
        r19.element = new LiveVSLog(r8, r10, r11, r12, r110, 8112);
        goto L22
    L20:
        r110 = 0;
        goto L21
    L16:
        r10 = r9;
    L22:
        IUserService r20 = k.f(IUserService.class);
        if (r20 == null) goto L33;
        f r21 = r20.user();
        if (r21 == null) goto L33;
        Observable r22 = r21.G(r2);
        if (r22 == null) goto L33;
        Observable r23 = r22.subscribeOn(Schedulers.io());
        if (r23 == null) goto L33;
        Observable r24 = r23.observeOn(AndroidSchedulers.mainThread());
        if (r24 == null) goto L33;
        r4 = r24.subscribe(new b(this, r16, r19), new c(this));
    L33:
        this.a = r4;
        return;
    L8:
        r3 = 0;
        goto L9
    }
}
