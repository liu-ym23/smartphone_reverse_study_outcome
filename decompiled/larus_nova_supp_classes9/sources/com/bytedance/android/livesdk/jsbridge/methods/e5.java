package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.HostFollowParams;
import com.bytedance.android.livehostapi.platform.depend.user.IFollowCallback;
import com.bytedance.android.livesdk.config.u30;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "userAction")
public final class e5 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public Disposable a;

    public class a implements IFollowCallback {
        public final /* synthetic */ e5 a;

        public a(e5 r1) {
            this.a = r1;
        }

        public final void onCancel(Throwable r2) {
            this.a.finishWithFailure(r2);
        }

        public final void onSuccess(int r1) {
            this.a.finishWithSuccess();
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public e5() {
    }

    public static void j(e5 r3, Throwable r4) {
        r3.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("code", 0);     // Catch: JSONException -> L16
        if ((r4 instanceof ApiException) == false) goto L12;
        r0.put("error_code", ((ApiException) r4).getErrorCode());     // Catch: JSONException -> L16
        if ((r4 instanceof ApiServerException) == false) goto L9;
        r0.put("message", ((ApiServerException) r4).getErrorMsg());     // Catch: JSONException -> L16
        r0.put("prompts", ((ApiServerException) r4).getPrompt());     // Catch: JSONException -> L16
    L9:
        if (((Boolean) u30.a.getValue()).booleanValue() == false) goto L12;
        r3.finishWithResult(r0);     // Catch: JSONException -> L16
        return;
    L12:
        if (((Boolean) u30.a.getValue()).booleanValue() == false) goto L14;
        r3.finishWithFailure();     // Catch: JSONException -> L16
        return;
    L14:
        r3.finishWithResult(r0);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.bytedance.android.livesdk.jsbridge.methods.w4] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.bytedance.android.livesdk.jsbridge.methods.v4] */
    public final void invoke(JSONObject r26, CallContext r27) throws Exception {
        String r2 = r26.optString("type");
        JSONObject r4 = r26.optJSONObject("args");
        if (r4 == null) goto L77;
    L5:
        com.bytedance.apm.util.j.b(r4, new JSONObject(r26.optString("dsl_extra_params")));     // Catch: Throwable -> L7
    L8:
        final JSONObject r3 = r4;
        if (r3 != null) goto L12;
        finishWithFailure();
        return;
    L12:
        Boolean r0 = Boolean.valueOf(r26.optBoolean("through_aweme", true));
        long r17 = 0;
        if (TextUtils.equals("follow", r2) == false) goto L41;
        if (r0.booleanValue() == false) goto L38;
        Context r5 = r27.getContext();
        String r1 = r27.b;
        int r6 = com.bytedance.android.live.base.model.user.n0.a;
        String r8 = com.bytedance.android.live.base.model.user.o0.a.e(com.bytedance.android.live.base.model.user.o0.a, r3, "user_id");
        r17 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r3, "room_id"));     // Catch: Exception -> L19
    L21:
        long r20 = r17;
        String r7 = r3.optString("enter_from", "search_result");
        String r9 = r3.optString("source", "recommend");
        String r10 = r3.optString("from_label");
        String r11 = r3.optString("url");
        String r13 = r3.optString("sec_user_id");
        HashMap r14 = new HashMap();
        Iterator<String> r15 = r3.keys();
    L23:
        if (r15.hasNext() == false) goto L27;
        String r16 = r15.next();
        if (r16 == null) goto L23;
        r14.put(r16, r3.optString(r16));
        r15 = r15;
        goto L23
    L27:
        if (r1 == null) goto L29;
        r14.put("web_page_source", r1);
    L29:
        String r18 = r3.optString("follow_scene", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r18) == false) goto L71;
    L37:
        FollowPair r19 = new FollowPair();
        r19.setType(IFollowPair.Type.FromWeb);
        r19.setUserId(r8);
        r19.setSecUserId(r13);
        r19.setRoomId(r20);
        r19.setUrl(r11);
        r19.setFromLabel(r10);
        r19.setFollow(true);
        r19.setExtraParams(r14);
        k(r19, r5, r7, r9);
    L89:
        return;
    L71:
        HashMap r21 = com.bytedance.android.livesdk.user.j.a(CastIntegerProtector.parseInt(r18));     // Catch: Exception -> L35
        if (r21 == null) goto L37;
        r14.putAll(r21);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        SafetyGuard.a(null, e, null);
    L19:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r23 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r24 = e.getStackTrace();
        r23.getClass();
        com.bytedance.android.live.core.log.g.m(5, r24);
        goto L21
    L38:
        l(r3, r27.getContext(), 1);
        goto L89
    L41:
        if (TextUtils.equals("unfollow", r2) == true) goto L43;
        finishWithFailure();
        return;
    L43:
        if (r0.booleanValue() == false) goto L66;
        final Context r25 = r27.getContext();
        String r28 = r27.b;
        final String r110 = r3.optString("enter_from", "search_result");
        final String r111 = r3.optString("enter_from", "recommend");
        int r29 = com.bytedance.android.live.base.model.user.n0.a;
        final String r210 = com.bytedance.android.live.base.model.user.o0.a.e(com.bytedance.android.live.base.model.user.o0.a, r3, "user_id");
        final long r30 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r3, "room_id"));     // Catch: Exception -> L47
    L49:
        final String r211 = r3.optString("from_label", BuildConfig.FLAVOR);
        final String r31 = r3.optString("url", BuildConfig.FLAVOR);
        final String r33 = r3.optString("sec_user_id");
        final HashMap r112 = new HashMap();
        Iterator<String> r34 = r3.keys();
    L51:
        if (r34.hasNext() == false) goto L55;
        String r35 = r34.next();
        if (r35 == null) goto L51;
        r112.put(r35, r3.optString(r35));
        goto L51
    L55:
        if (r28 == null) goto L57;
        r112.put("web_page_source", r28);
    L57:
        String r36 = r3.optString("follow_scene", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r36) == false) goto L69;
    L65:
        com.bytedance.android.livesdk.user.f r113 = jc1.k.f(IUserService.class).user();
        com.bytedance.android.live.core.utils.s1.B(2131916248);
        r113.C(new v4(this, r3, r210, r30, r33, r31, r211, r112, r25, r110, r111), r25, r211, r210, new w4(this));
        return;
    L69:
        HashMap r37 = com.bytedance.android.livesdk.user.j.a(CastIntegerProtector.parseInt(r36));     // Catch: Exception -> L63
        if (r37 == null) goto L65;
        r112.putAll(r37);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        SafetyGuard.a(null, e, null);
    L47:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r38 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r39 = e.getStackTrace();
        r38.getClass();
        com.bytedance.android.live.core.log.g.m(5, r39);
        r30 = 0;
        goto L49
    L66:
        l(r3, r27.getContext(), 0);
        return;
    L7:
        ALogger.i("JSB-userAction", "parse args error.");
        goto L8
    L77:
        r4 = new JSONObject(r26.optString("args"));     // Catch: Throwable -> L7
        goto L5
    }

    public final /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r2) throws Exception {
        invoke((JSONObject) r1, r2);
    }

    public final void l(JSONObject r2, Context r3, int r4) {
        if ((r3 instanceof FragmentActivity) == false) goto L6;
        FragmentActivity r5 = (FragmentActivity) r3;
    L10:
        HostFollowParams r0 = new HostFollowParams();
        r0.followStatus = r4;
        r0.targetUid = r2.optString("user_id");
        r0.fromLabel = r2.optString("from_label");
        TTLiveSDK.hostService().user().hostUserFollow(r5, r0, new a(this));
        return;
    L6:
        if ((r3 instanceof ContextWrapper) == false) goto L13;
        ContextWrapper r6 = (ContextWrapper) r3;
        if ((r6.getBaseContext() instanceof FragmentActivity) == false) goto L13;
        r5 = r6.getBaseContext();
    L13:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    }

    public final void k(final FollowPair r9, final Context r10, final String r11, final String r13) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (jc1.k.f(IUserService.class).user().isLogin() == true) goto L10;
        if ((r10 instanceof FragmentActivity) == false) goto L17;
        com.bytedance.android.livesdk.user.f r1 = jc1.k.f(IUserService.class).user();
        com.bytedance.android.livesdk.user.l.a r2 = new com.bytedance.android.livesdk.user.l.a();
        r2.a = com.bytedance.android.live.core.utils.s1.B(2131920130);
        r2.c = -1;
        r2.e = r11;
        r2.d = r13;
        r2.g = "follow";
        this.a = r1.login((FragmentActivity) r10, new com.bytedance.android.livesdk.user.l(r2)).subscribe(new x4(this, r9, r10, r11, r13), new y4(this));
        return;
    L17:
        return;
    L10:
        if (r9.isFollow() == false) goto L13;
        this.a = jc1.k.f(IInternalFollowTool.class).makeFollowByRoom(r10, jc1.k.f(IRoomService.class).getCurrentRoom(), new z4(r9)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a5(this), new b5(this));
        return;
    L13:
        if ((r10 instanceof Activity) == true) goto L15;
        return;
    L15:
        Activity r0 = (Activity) r10;
        this.a = jc1.k.f(IInternalFollowTool.class).makeUnFollowByRoom(r0, jc1.k.f(IRoomService.class).getCurrentRoom(), new c5(r9, r10)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d5(this), new b5(this));
    }
}
