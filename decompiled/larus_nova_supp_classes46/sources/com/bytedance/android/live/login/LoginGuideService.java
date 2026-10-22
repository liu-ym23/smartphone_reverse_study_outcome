package com.bytedance.android.live.login;

import am2.x;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q;
import com.bytedance.android.livesdk.config.f81;
import com.bytedance.android.livesdk.config.z81;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import cz.c;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import q61.a;
import q61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/login/LoginGuideService;", "Lcom/bytedance/android/live/room/api/login/ILoginGuideService;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentActivity;", "getFragmentActivity", "Lq61/b;", "entrance", "Landroid/app/Activity;", "topActivity", "", "toLogin", "", "intercept", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lq61/a;", "createAutoLoginGuideLauncher", "", "tag", "Ljava/lang/String;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LoginGuideService implements ILoginGuideService {
    private final String tag;

    public LoginGuideService() {
        this.tag = "LoginGuideService";
    }

    private final FragmentActivity getFragmentActivity(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Application) == false) goto L9;
        return null;
    L9:
        if ((r3 instanceof FragmentActivity) == false) goto L13;
        return (FragmentActivity) r3;
    L13:
        if ((r3 instanceof ContextWrapper) == true) goto L15;
        return null;
    L15:
        return getFragmentActivity(((ContextWrapper) r3).getBaseContext());
    }

    public a createAutoLoginGuideLauncher(DataCenter r2) {
        return new AutoLoginGuideLauncher(r2);
    }

    public boolean intercept(b r8) {
        Intrinsics.checkNotNullParameter(r8, "entrance");
        if (((z81) f81.a.getValue()).e() == true) goto L6;
        ALogger.i(this.tag, "clickJumpLoginEnable is false");
        return false;
    L6:
        FragmentActivity r0 = getFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r0 != null) goto L11;
        ALogger.i(this.tag, "topActivity is null");
        return false;
    L11:
        if (k.n(IUserService.class).user().isLogin() == false) goto L13;
    L29:
        return false;
    L13:
        if ((!Intrinsics.areEqual(r8.getScene(), c.r.c)) == false) goto L29;
        ViewModel r6 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L19;
        j r2 = r1.getAutoLoginGuideLauncher();
        if (r2 == null) goto L19;
        ViewModel r3 = (ViewModel) r2.getValue();
    L21:
        if ((r3 instanceof a) == false) goto L24;
        r6 = r3;
    L24:
        a r7 = (a) r6;
        if (r7 == null) goto L27;
        r7.notifyHasJumpedLogin();
    L27:
        toLogin(r8, r0);
        ALogger.i(this.tag, "intercept by unlogin");
        return true;
    L19:
        r3 = null;
        goto L21
    }

    private final void toLogin(b r18, Activity r19) {
        if (r19 != null) goto L5;
        return;
    L5:
        Bundle r1 = new Bundle();
        n0 r2 = u.l().c(x.class);
        if (r2 == null) goto L54;
        n0 r3 = r2;
        String r4 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("enter_from_merge");
        String r5 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("enter_method");
        String r6 = "";
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        String r7 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("action_type");
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r12 = RoomContext.a.c(r8, null, 0, 3);
        if (r12 == null) goto L18;
        m r13 = r12.getRoom();
        if (r13 == null) goto L18;
        Room r14 = (Room) r13.getValue();
    L19:
        Pair[] r15 = new Pair[5];
        boolean r16 = false;
        r15[0] = TuplesKt.to("enter_method_live", r5);
        r15[1] = TuplesKt.to("action_type_live", r7);
        if (r14 == null) goto L23;
        String r9 = String.valueOf(r14.getRoomId());
        if (r9 == null) goto L23;
    L24:
        r15[2] = TuplesKt.to("room_id_live", r9);
        if (r14 == null) goto L30;
        String r10 = r14.getOwnerUserIdString();
        if (r10 == null) goto L30;
        r6 = r10;
    L30:
        r15[3] = TuplesKt.to("anchor_id_live", r6);
        if (r14 == null) goto L34;
        String r11 = r14.isEcomCart();
        if (r11 == null) goto L34;
    L35:
        r15[4] = TuplesKt.to("is_ecom_live", r11);
        Map r17 = MapsKt.mutableMapOf(r15);
        r17.putAll(r18.getLogParams());
        RoomContext r20 = RoomContext.a.c(r8, null, 0, 3);
        if (r20 == null) goto L46;
        m r21 = r20.getRoom();
        if (r21 == null) goto L46;
        Room r22 = (Room) r21.getValue();
        if (r22 == null) goto L46;
        StreamUrl r23 = r22.getStreamUrl();
        if (r23 == null) goto L46;
        if (r23.getStreamOrientation() != 2) goto L46;
        r16 = true;
    L46:
        boolean r24 = e5.n();
        String r25 = r18.getScene().a;
        c.d r26 = c.d.c;
        if (Intrinsics.areEqual(r25, "live_definition_bubble") == false) goto L51;
        if (r16 == false) goto L51;
        if (r24 == false) goto L51;
        r17.put("enter_method", "definition_setting_icon");
    L51:
        r1.putString("track_info", q.a(r17));
        f r27 = k.n(IUserService.class).user();
        l.a r28 = new l.a();
        r28.e = r4;
        r28.f = r18.getScene().b;
        r28.h = r1;
        r27.login(r19, new l(r28)).subscribe(new h());
        return;
    L34:
        r11 = "0";
    L23:
        r9 = "";
    L18:
        r14 = null;
        goto L19
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.PageSourceFilter");
    }
}
