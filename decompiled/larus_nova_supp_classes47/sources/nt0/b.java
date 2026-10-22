package nt0;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.GroupInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qs0.p;
import qs0.q;
import rs0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends vt0.b {
    public final /* synthetic */ a d;
    public final /* synthetic */ GroupInfo e;

    @Override // vt0.b
    public final void a(View r18) {
        ALogger.i("ProfileLocalLifeGroupShopComponent", "ProfileLocalLifeGroupShopComponent onClick");
        boolean r3 = false;
        String r5 = null;
        if (i.k(this.d.i) == true) goto L20;
        a r0 = this.d;
        NewProfileUser r6 = r0.i.getTargetUser();
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("enter_from", "livebroadcasting");
        r7.put("enter_method", "personal_card");
        GroupInfo r8 = r6.groupInfo;
        String r9 = DataType.FALSE;
        if (r8 != null) goto L7;
    L9:
        Object r10 = DataType.TRUE;
    L10:
        r7.put("showcase_type", r10);
        IMiddlewareUserService r12 = k.f(IMiddlewareUserService.class);
        if (r12 == null) goto L15;
        e r13 = r12.user();
        if (r13 == null) goto L15;
        String r14 = r13.n();
    L17:
        if (Intrinsics.areEqual(r14, r0.i.getRoom().getOwnerUserIdStr()) == false) goto L19;
        r9 = DataType.TRUE;
    L19:
        r7.put("is_anchor", r9);
        j0.l().h("life_showcase_entrance_click", r7, new Object[]{IRoom.class, x.class});
    L15:
        r14 = null;
        goto L17
    L7:
        if (r8.getGroupType() != 1) goto L9;
        r10 = DataType.FALSE;
    L20:
        this.d.i.recordBusinessClick("local_life", null);
        a r15 = this.d;
        GroupInfo.GroupHeaderInfo r1 = this.e.getGroupHeaderInfo();
        if (r1 == null) goto L23;
        String r16 = r1.getUrl();
    L24:
        GroupInfo r17 = this.e;
        r15.getClass();
        if (r16 != null) goto L27;
    L30:
        boolean r2 = true;
    L31:
        if (r2 == false) goto L123;
    L101:
        if (r5 != null) goto L103;
        return;
    L103:
        ViewGroup r4 = this.d.b;
        if (r4 == null) goto L125;
        Context r19 = r4.getContext();
        if (r19 != null) goto L109;
        return;
    L109:
        if (i.k(this.d.i) == true) goto L111;
    L113:
        Activity r20 = ContextUtil.contextToActivity(r19);
        if (r20 == null) goto L118;
        q r22 = os0.b.c().getILiveVideoFloatWindowService();
        if (r22 == null) goto L118;
        p r23 = new p();
        Intrinsics.checkNotNullParameter("life_showcase", "<set-?>");
        r23.a = "life_showcase";
        Unit r24 = Unit.INSTANCE;
        r22.b(r20, r23);
    L118:
        IBaseLiveActionHandler r25 = k.f(IBaseLiveActionHandler.class);
        if (r25 == null) goto L121;
        r25.handle(r19, r5);
    L121:
        this.d.i.dismiss();
        return;
    L111:
        if (((Boolean) o.a.getValue()).booleanValue() == true) goto L113;
    L125:
        return;
    L123:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L35
        Object r27 = Result.constructor-impl(UriProtector.parse(r16));     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r27) == false) goto L40;
        r27 = null;
    L40:
        Uri r28 = (Uri) r27;
        if (r28 == null) goto L101;
        if (Intrinsics.areEqual(r28.getHost(), "lynxview") == false) goto L69;
        JSONObject r29 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r30 = j0.l().c(x.class);
        if (r30 == null) goto L51;
        Map r32 = r30.getMap();
        if (r32 == null) goto L51;
        String r33 = (String) r32.get("enter_from_merge");
        if (r33 == null) goto L51;
    L52:
        if (r30 == null) goto L57;
        Map r34 = r30.getMap();
        if (r34 == null) goto L57;
        String r35 = (String) r34.get("enter_method");
        if (r35 == null) goto L57;
    L58:
        if (r30 == null) goto L63;
        Map r36 = r30.getMap();
        if (r36 == null) goto L63;
        String r37 = (String) r36.get("action_type");
        if (r37 == null) goto L63;
    L64:
        String r110 = r15.i.getRoom().getOwnerUserIdStr();
        String r111 = r15.i.getRoom().getRequestId();
        if (r111 != null) goto L67;
        r111 = "";
    L67:
        r29.put("enter_from_merge", r33);
        r29.put("enter_method", r35);
        r29.put("action_type", r37);
        r29.put("anchor_id", r110);
        r29.put("request_id", r111);
        Uri.Builder r38 = i2.e(UriProtector.parse(r16), "common_extra").buildUpon().appendQueryParameter("common_extra", r29.toString());
        r15.j(r17, r38);
        r5 = r38.build().toString();
    L63:
        r37 = "";
    L57:
        r35 = "";
    L51:
        r33 = "";
        goto L52
    L69:
        if (r16 != null) goto L71;
    L72:
        r3 = true;
    L73:
        if (r3 == true) goto L101;
        String r39 = UriProtector.getQueryParameter(UriProtector.parse(r16), "url");
        if (r39 == null) goto L101;
        JSONObject r40 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r42 = j0.l().c(x.class);
        if (r42 == null) goto L84;
        Map r112 = r42.getMap();
        if (r112 == null) goto L84;
        String r113 = (String) r112.get("enter_from_merge");
        if (r113 == null) goto L84;
    L85:
        if (r42 == null) goto L90;
        Map r114 = r42.getMap();
        if (r114 == null) goto L90;
        String r115 = (String) r114.get("enter_method");
        if (r115 == null) goto L90;
    L91:
        if (r42 == null) goto L96;
        Map r43 = r42.getMap();
        if (r43 == null) goto L96;
        String r44 = (String) r43.get("action_type");
        if (r44 == null) goto L96;
    L97:
        String r45 = r15.i.getRoom().getOwnerUserIdStr().toString();
        String r46 = r15.i.getRoom().getRequestId();
        if (r46 != null) goto L100;
        r46 = "";
    L100:
        r40.put("enter_from_merge", r113);
        r40.put("enter_method", r115);
        r40.put("action_type", r44);
        r40.put("anchor_id", r45);
        r40.put("request_id", r46);
        Uri.Builder r47 = i2.e(UriProtector.parse(r39), "common_extra").buildUpon().appendQueryParameter("common_extra", r40.toString());
        r15.j(r17, r47);
        r5 = i2.e(UriProtector.parse(r16), "url").buildUpon().appendQueryParameter("url", r47.build().toString()).build().toString();
    L96:
        r44 = "";
    L90:
        r115 = "";
    L84:
        r113 = "";
        goto L85
    L71:
        if (r16.length() != 0) goto L73;
    L35:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L27:
        if (r16.length() == 0) goto L30;
        r2 = false;
        goto L31
    L23:
        r16 = null;
        goto L24
    }

    public b(a r1, GroupInfo r2) {
        this.d = r1;
        this.e = r2;
    }
}
