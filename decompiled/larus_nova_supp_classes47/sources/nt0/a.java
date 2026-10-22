package nt0;

import am2.n;
import am2.x;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.GroupInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WallBg;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.d;
import com.bytedance.android.live.profile.ui.base.e;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.live.profile.ui.base.a {
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public View e;
    public TextView f;
    public HSImageView g;
    public HSImageView h;
    public final h i;

    /* JADX INFO: renamed from: nt0.a$a, reason: collision with other inner class name */
    public static final class C0278a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeView(this.b);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.a, com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.LocalLifeGroupShop.INSTANCE;
    }

    public a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.i = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(d r3) {
        ALogger.i("ProfileLocalLifeGroupShopComponent", "ProfileLocalLifeGroupShopComponent initView");
        if (ProfilePreInflateUtil.a() == false) goto L5;
        e r4 = (e) r3;
        View r5 = r4.b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_LOCAL_LIFE, true);
    L6:
        if (r5 == null) goto L14;
        this.b = (ViewGroup) r5.findViewById(2131384813);
        TextView r0 = (TextView) r5.findViewById(2131386263);
        this.c = r0;
        if (r0 == null) goto L12;
        TextPaint r1 = r0.getPaint();
        if (r1 == null) goto L12;
        r1.setFakeBoldText(true);
    L12:
        this.d = (TextView) r5.findViewById(2131386243);
        this.e = r5.findViewById(2131386226);
        this.f = (TextView) r5.findViewById(2131386275);
        this.g = r5.findViewById(2131384545);
        this.h = r5.findViewById(2131386245);
        return;
    L14:
        return;
    L5:
        r5 = ((e) r3).f(2131567207, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r9, "user");
        Intrinsics.checkNotNullParameter(r9, "user");
        Intrinsics.checkNotNullParameter(r9, "user");
        if (i.k(this.i) == true) goto L89;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from", "livebroadcasting");
        r0.put("enter_method", "personal_card");
        GroupInfo r2 = r9.groupInfo;
        boolean r3 = true;
        String r4 = DataType.FALSE;
        if (r2 != null) goto L7;
    L9:
        Object r5 = DataType.TRUE;
    L10:
        r0.put("showcase_type", r5);
        IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
        List r7 = null;
        if (r6 == null) goto L15;
        com.bytedance.android.livesdk.user.e r8 = r6.user();
        if (r8 == null) goto L15;
        String r10 = r8.n();
    L17:
        if (Intrinsics.areEqual(r10, this.i.getRoom().getOwnerUserIdStr()) == false) goto L19;
        r4 = DataType.TRUE;
    L19:
        r0.put("is_anchor", r4);
        j0.l().h("life_showcase_entrance_show", r0, new Object[]{IRoom.class, x.class});
        GroupInfo r1 = r9.groupInfo;
        if (r1 == null) goto L24;
        GroupInfo.GroupHeaderInfo r12 = r1.getGroupHeaderInfo();
        if (r12 == null) goto L24;
        r7 = r12.getIcons();
    L24:
        List r13 = r7;
        if (r13 != null) goto L27;
    L30:
        if (r3 == true) goto L89;
        LinkedHashMap r14 = new LinkedHashMap();
        Map r15 = j0.l().c(x.class).getMap();
        String r16 = "";
        if (r15 == null) goto L36;
        String r17 = (String) r15.get("enter_from_merge");
        if (r17 == null) goto L36;
    L37:
        r14.put("enter_from_merge", r17);
        if (r15 == null) goto L41;
        String r18 = (String) r15.get("enter_method");
        if (r18 == null) goto L41;
    L42:
        r14.put("enter_method", r18);
        if (r15 == null) goto L46;
        String r19 = (String) r15.get("action_type");
        if (r19 == null) goto L46;
    L47:
        r14.put("action_type", r19);
        if (r15 == null) goto L51;
        String r20 = (String) r15.get("video_id");
        if (r20 == null) goto L51;
    L52:
        r14.put("video_id", r20);
        Map r22 = j0.l().c(IRoom.class).getMap();
        if (r22 == null) goto L56;
        String r23 = (String) r22.get("anchor_id");
        if (r23 == null) goto L56;
    L57:
        r14.put("anchor_id", r23);
        if (r22 == null) goto L61;
        String r24 = (String) r22.get("room_id");
        if (r24 == null) goto L61;
    L62:
        r14.put("room_id", r24);
        if (r22 == null) goto L66;
        String r25 = (String) r22.get("request_id");
        if (r25 == null) goto L66;
    L67:
        r14.put("request_id", r25);
        if (r22 == null) goto L71;
        String r26 = (String) r22.get("log_pb");
        if (r26 == null) goto L71;
    L72:
        r14.put("log_pb", r26);
        if (r22 == null) goto L76;
        String r27 = (String) r22.get("is_life");
        if (r27 == null) goto L76;
    L77:
        r14.put("is_life", r27);
        Map r28 = j0.l().c(n.class).getMap();
        if (r28 == null) goto L83;
        String r29 = (String) r28.get("is_other_channel");
        if (r29 == null) goto L83;
        r16 = r29;
    L83:
        r14.put("is_other_channel", r16);
        GroupInfo r30 = r9.groupInfo;
        if (r30 == null) goto L88;
        Map r32 = r30.getBuryPoint();
        if (r32 == null) goto L88;
        r14.putAll(r32);
    L88:
        os0.b.c().getIHostLiveLocalLife().d(r14);
    L76:
        r27 = "";
    L71:
        r26 = "";
    L66:
        r25 = "";
    L61:
        r24 = "";
    L56:
        r23 = "";
    L51:
        r20 = "";
    L46:
        r19 = "";
    L41:
        r18 = "";
    L36:
        r17 = "";
        goto L37
    L27:
        if (r13.isEmpty() == true) goto L30;
        r3 = false;
    L15:
        r10 = null;
        goto L17
    L7:
        if (r2.getGroupType() != 1) goto L9;
        r5 = DataType.FALSE;
    L89:
        this.i.recordBusinessShow(TrackArea.BottomOperatingArea, "local_life");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r9, "user");
        GroupInfo r10 = r9.groupInfo;
        if (r10 != null) goto L5;
        ALogger.e("ProfileLocalLifeGroupShopComponent", "ProfileLocalLifeGroupShopComponent bindUserData, but groupInfo is null");
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        WallBg r1 = r10.getGroupWallBg();
        boolean r2 = true;
        List r4 = null;
        if (r1 == null) goto L43;
        String r5 = r1.getGradientStart();
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L43;
        String r7 = r1.getGradientEnd();
        if (r7 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r8 == true) goto L43;
        int r12 = Color.parseColor(r1.getGradientEnd());     // Catch: Exception -> L41
        int r3 = Color.parseColor(r1.getGradientEnd());     // Catch: Exception -> L41
        ViewGroup r13 = this.b;     // Catch: Exception -> L41
        if (r13 == null) goto L30;
        Drawable r14 = r13.getBackground();     // Catch: Exception -> L41
    L32:
        if ((r14 instanceof GradientDrawable) == true) goto L34;
        r14 = null;
    L34:
        GradientDrawable r15 = (GradientDrawable) r14;     // Catch: Exception -> L41
        if (r15 == null) goto L43;
        r15.mutate();     // Catch: Exception -> L41
        r15.setShape(0);     // Catch: Exception -> L41
        r15.setGradientType(0);     // Catch: Exception -> L41
        r15.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L41
        r15.setColors(new int[]{r12, r3});     // Catch: Exception -> L41
        ViewGroup r16 = this.b;     // Catch: Exception -> L41
        if (r16 == null) goto L43;
        r16.setBackground(r15);     // Catch: Exception -> L41
        goto L43
    L30:
        r14 = null;
    L41:
        e = move-exception;
        ALogger.e("ProfileLocalLifeGroupShopComponent", "paint background error: " + e.getMessage());
        goto L43
    L21:
        if (r7.length() == 0) goto L24;
        r8 = false;
        goto L25
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
    L43:
        WallBg r0 = r10.getGroupWallBg();
        if (r0 == null) goto L58;
        py.k r17 = r0.getIcon();
        if (r17 == null) goto L58;
        HSImageView r18 = this.g;
        if (r18 == null) goto L51;
        r18.setVisibility(0);
    L51:
        HSImageView r19 = this.g;
        if (r19 == null) goto L54;
        a1.p(r19, UtilityKotlinExtentionsKt.i(r17.getWidth()));
    L54:
        HSImageView r20 = this.g;
        if (r20 == null) goto L57;
        a1.k(r20, UtilityKotlinExtentionsKt.i(r17.getHeight()));
    L57:
        ImageLoader.bindImage(this.g, r17);
    L58:
        GroupInfo.GroupHeaderInfo r22 = r10.getGroupHeaderInfo();
        if (r22 == null) goto L84;
        TextView r23 = this.c;
        if (r23 == null) goto L64;
        r23.setText(r22.getName());
    L64:
        TextView r24 = this.d;
        if (r24 == null) goto L67;
        r24.setText(r22.getGoods());
    L67:
        String r25 = r22.getSale();
        if (r25 != null) goto L70;
    L73:
        boolean r26 = true;
    L74:
        if (r26 == true) goto L84;
        View r27 = this.e;
        if (r27 == null) goto L78;
        r27.setVisibility(0);
    L78:
        TextView r28 = this.f;
        if (r28 == null) goto L81;
        r28.setVisibility(0);
    L81:
        TextView r29 = this.f;
        if (r29 == null) goto L84;
        r29.setText(r22.getSale());
        goto L84
    L70:
        if (r25.length() == 0) goto L73;
        r26 = false;
    L84:
        int r30 = m.a;
        m.e(this.c, r10.getTitleColor());
        ViewGroup r32 = this.b;
        if (r32 == null) goto L87;
        View r33 = r32.findViewById(2131386274);
    L88:
        m.e(r33, r10.getTitleColor());
        ViewGroup r34 = this.b;
        if (r34 == null) goto L91;
        View r35 = r34.findViewById(2131386246);
    L92:
        m.e(r35, r10.getContentColor());
        ViewGroup r36 = this.b;
        if (r36 == null) goto L95;
        r36.setOnClickListener(new b(this, r10));
    L95:
        GroupInfo.GroupHeaderInfo r37 = r10.getGroupHeaderInfo();
        if (r37 == null) goto L98;
        r4 = r37.getIcons();
    L98:
        List r38 = r4;
        if (r38 != null) goto L101;
    L104:
        if (r2 == false) goto L108;
        HSImageView r39 = this.h;
        if (r39 == null) goto L115;
        r39.setVisibility(8);
        return;
    L115:
        return;
    L108:
        HSImageView r40 = this.h;
        if (r40 == null) goto L111;
        r40.setVisibility(0);
    L111:
        ImageLoader.bindImage(this.h, (py.k) ListProtector.get(r4, 0));
        return;
    L101:
        if (r38.isEmpty() == true) goto L104;
        r2 = false;
        goto L104
    L91:
        r35 = null;
        goto L92
    L87:
        r33 = null;
        goto L88
    }

    @Override // com.bytedance.android.live.profile.ui.base.a, com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ViewGroup r0 = this.b;
        if (r0 == null) goto L5;
        r0.setBackgroundResource(2131249489);
    L5:
        HSImageView r1 = this.g;
        if (r1 == null) goto L8;
        m.b(r1);
    L8:
        HSImageView r2 = this.g;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        View r4 = this.e;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
    L14:
        TextView r5 = this.f;
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        g(r3);
    }

    public final void j(GroupInfo r10, Uri.Builder r12) {
        boolean r3 = true;
        if (r10.getGroupType() != 1) goto L35;
        IMiddlewareHostAction r13 = k.f(IMiddlewareHostAction.class);
        if (r13 == null) goto L7;
        String r14 = r13.getNativeItem("spu_detail_list_sort");
    L9:
        if (r14 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L33;
        return;
    L33:
        String r15 = new JSONObject(r14).optString(this.i.getTargetUser().baseProfileInfo.getIdStr(), "");     // Catch: Exception -> L30
        if (r15 != null) goto L20;
    L23:
        if (r3 == false) goto L25;
        return;
    L25:
        JSONObject r4 = new JSONObject(r15);     // Catch: Exception -> L30
        if (System.currentTimeMillis() <= CastLongProtector.parseLong(r4.optString("expire", DataType.FALSE))) goto L28;
        return;
    L28:
        r12.appendQueryParameter("spu_list_order_by", r4.optString("spu_list_order_by", ""));     // Catch: Exception -> L30
        r12.appendQueryParameter("spu_list_order_type", r4.optString("spu_list_order_type", ""));     // Catch: Exception -> L30
        return;
    L20:
        if (r15.length() == 0) goto L23;
        r3 = false;
    L30:
        e = move-exception;
        SafetyGuard.a(null, e, "ProfileLocalLifeGroupShopComponent: parse sort info error");
        return;
    L11:
        if (r14.length() == 0) goto L14;
        r6 = false;
        goto L15
    L7:
        r14 = null;
        goto L9
    }
}
