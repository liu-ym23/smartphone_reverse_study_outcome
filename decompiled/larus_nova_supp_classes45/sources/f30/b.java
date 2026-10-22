package f30;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.GetUserInfoResultModel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.HostUserDetail;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getUserInfo")
public final class b extends v1<JsonObject, GetUserInfoResultModel> {
    public b() {
    }

    public final void invoke(Object r9, CallContext r11) {
        JsonObject r12 = (JsonObject) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        JsonElement r13 = r12.get("through_aweme");
        boolean r14 = true;
        if (r13 == null) goto L5;
        boolean r15 = r13.getAsBoolean();
    L6:
        String r2 = null;
        if (r15 == false) goto L109;
        IMiddlewareUserService r16 = k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L11;
        e r17 = r16.user();
    L12:
        GetUserInfoResultModel r3 = new GetUserInfoResultModel();
        if (r17 == null) goto L15;
        Boolean r4 = Boolean.valueOf(r17.isLogin());
    L16:
        r3.c(r4);
        if (r17 == null) goto L19;
        IBaseUser r18 = r17.b();
    L21:
        if (Intrinsics.areEqual(r3.a(), Boolean.TRUE) == false) goto L108;
        GetUserInfoResultModel.a r5 = new GetUserInfoResultModel.a();
        if (r18 == null) goto L25;
        String r6 = String.valueOf(r18.getShortId());
    L26:
        r5.e(r6);
        if (r18 == null) goto L29;
        String r7 = r18.getIdString();
    L30:
        r5.f(r7);
        if (r18 == null) goto L33;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        String r8 = r18.getCastSecUid();
    L34:
        r5.d(r8);
        if (r18 == null) goto L37;
        String r19 = r18.getNickName();
    L38:
        r5.c(r19);
        if (r18 == null) goto L43;
        py.k r21 = r18.getAvatarThumbKt();
        if (r21 == null) goto L43;
        List<String> r22 = r21.getUrls();
    L44:
        List<String> r23 = r22;
        if (r23 != null) goto L47;
    L50:
        boolean r24 = true;
    L51:
        if (r24 == true) goto L58;
        if (r18 == null) goto L107;
        py.k r25 = r18.getAvatarThumbKt();
        if (r25 == null) goto L107;
        List<String> r26 = r25.getUrls();
        if (r26 == null) goto L107;
        r2 = (String) CollectionsKt.first(r26);
    L107:
        r5.a(r2);
        r5.b(Boolean.FALSE);
        Unit r27 = Unit.INSTANCE;
        r3.e(r5);
        goto L108
    L58:
        if (r18 == null) goto L62;
        py.k r28 = r18.getAvatarMedium();
        if (r28 == null) goto L62;
        List<String> r29 = r28.getUrls();
    L63:
        List<String> r31 = r29;
        if (r31 != null) goto L66;
    L69:
        boolean r32 = true;
    L70:
        if (r32 == true) goto L77;
        if (r18 == null) goto L107;
        py.k r33 = r18.getAvatarMedium();
        if (r33 == null) goto L107;
        List<String> r34 = r33.getUrls();
        if (r34 == null) goto L107;
        r2 = (String) CollectionsKt.first(r34);
        goto L107
    L77:
        if (r18 == null) goto L79;
        String r35 = r18.getAvatarUrl();
    L80:
        if (r35 != null) goto L82;
    L85:
        boolean r36 = true;
    L86:
        if (r36 == true) goto L89;
        if (r18 == null) goto L107;
        r2 = r18.getAvatarUrl();
        goto L107
    L89:
        if (r18 == null) goto L93;
        py.k r37 = r18.getAvatarLarge();
        if (r37 == null) goto L93;
        List<String> r38 = r37.getUrls();
    L94:
        List<String> r39 = r38;
        if (r39 != null) goto L97;
    L100:
        if (r14 == true) goto L107;
        if (r18 == null) goto L107;
        py.k r41 = r18.getAvatarLarge();
        if (r41 == null) goto L107;
        List<String> r42 = r41.getUrls();
        if (r42 == null) goto L107;
        r2 = (String) CollectionsKt.first(r42);
        goto L107
    L97:
        if (r39.isEmpty() == true) goto L100;
        r14 = false;
    L93:
        r38 = null;
        goto L94
    L82:
        if (r35.length() == 0) goto L85;
        r36 = false;
        goto L86
    L79:
        r35 = null;
        goto L80
    L66:
        if (r31.isEmpty() == true) goto L69;
        r32 = false;
    L62:
        r29 = null;
        goto L63
    L47:
        if (r23.isEmpty() == true) goto L50;
        r24 = false;
    L43:
        r22 = null;
        goto L44
    L37:
        r19 = null;
        goto L38
    L33:
        r8 = null;
        goto L34
    L29:
        r7 = null;
        goto L30
    L25:
        r6 = null;
    L108:
        r3.b(GetUserInfoResultModel.Code.Success);
        r3.d("SUCCESS");
        finishWithResult(r3);
        return;
    L19:
        r18 = null;
        goto L21
    L15:
        r4 = null;
        goto L16
    L11:
        r17 = null;
        goto L12
    L109:
        GetUserInfoResultModel r43 = new GetUserInfoResultModel();
        if (TTMiddlewareLiveSDK.hostMiddlewareService().user().hostUserId() != 0) goto L113;
        r14 = false;
    L113:
        r43.c(Boolean.valueOf(r14));
        HostUserDetail r110 = TTMiddlewareLiveSDK.hostMiddlewareService().user().hostUserDetail();
        if (Intrinsics.areEqual(r43.a(), Boolean.TRUE) == false) goto L139;
        GetUserInfoResultModel.a r0 = new GetUserInfoResultModel.a();
        if (r110 == null) goto L120;
        String r44 = r110.shortId;
        if (r44 == null) goto L120;
    L121:
        r0.e(r44);
        if (r110 == null) goto L126;
        String r45 = r110.id;
        if (r45 == null) goto L126;
    L127:
        r0.f(r45);
        if (r110 == null) goto L130;
        String r46 = r110.secUid;
    L131:
        r0.d(r46);
        if (r110 == null) goto L134;
        String r47 = r110.nickName;
    L135:
        r0.c(r47);
        if (r110 == null) goto L138;
        r2 = r110.avatarURL;
    L138:
        r0.a(r2);
        r0.b(Boolean.FALSE);
        Unit r111 = Unit.INSTANCE;
        r43.e(r0);
        goto L139
    L134:
        r47 = null;
        goto L135
    L130:
        r46 = null;
    L126:
        r45 = null;
    L120:
        r44 = null;
    L139:
        r43.b(GetUserInfoResultModel.Code.Success);
        r43.d("SUCCESS");
        finishWithResult(r43);
        return;
    L5:
        r15 = true;
        goto L6
    }
}
