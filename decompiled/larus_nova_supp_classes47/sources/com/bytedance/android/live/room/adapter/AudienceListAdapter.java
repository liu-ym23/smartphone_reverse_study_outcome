package com.bytedance.android.live.room.adapter;

import am2.z;
import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.FitTextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.util.AudienceInflateUtil;
import com.bytedance.android.live.room.util.AudienceViewInfo;
import com.bytedance.android.live.room.widget.NoTouchRecyclerView;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.utils.q;
import com.bytedance.android.livesdk.config.nn0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ev1.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import py.d;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class AudienceListAdapter extends AbsAudienceListAdapter<AudienceViewHolder> {
    public DataCenter a;
    public boolean b;
    public final Context c;
    public b d;
    public final a e;
    public final List<x71.a> f;
    public boolean g;
    public final RecyclerView h;

    public class a implements View.OnClickListener {
        public final /* synthetic */ AudienceListAdapter a;

        public a(AudienceListAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            if (r7.getTag() != null) goto L5;
            return;
        L5:
            if ((r7.getTag() instanceof x71.a) == false) goto L55;
            IRoomContextService r0 = k.f(IRoomContextService.class);
            if (r0 == null) goto L19;
            r r1 = r0.getRoomExpService(this.a.a, 0);
            if (r1 == null) goto L19;
            n r2 = r1.G();
            if (r2 == null) goto L19;
            if (r2.getValue() == null) goto L19;
            if (((Boolean) r2.getValue()).booleanValue() != true) goto L19;
            ALogger.i("AudienceListAdapter", "主播昵称正在临态模式展示，在线人数头像不可点击");
            return;
        L19:
            AudienceListAdapter r3 = this.a;
            if (r3.d == null) goto L26;
            if (p.b(r3.a) == false) goto L26;
            this.a.d.onShow();
            return;
        L26:
            if (this.a.g == false) goto L28;
            HashMap r4 = new HashMap();
            r4.put("event_belong", "live_take");
            r4.put("event_type", "click");
            r4.put("event_page", "live_take_detail");
            r4.put("path", "top_online_pic");
            j0.l().sendLog("pm_live_take_anchor_c_audience", r4, new Object[]{new z()});
        L28:
            DataCenter r5 = this.a.a;
            if (r5 == null) goto L35;
            IRoom r6 = (IRoom) r5.get("data_room", null);
            if (r6 == null) goto L35;
            if (r6.isKoiRoom() == false) goto L35;
            return;
        L35:
            DataCenter r8 = this.a.a;
            if (r8 == null) goto L43;
            IRoom r9 = (IRoom) r8.get("data_room", null);
            if (r9 == null) goto L43;
            if (r9.isStar() == false) goto L43;
            Logger.d("AudienceListAdapter", "skip user profile event in star room.");
            return;
        L43:
            x71.a r10 = (x71.a) r7.getTag();
            if (r10.c == false) goto L47;
            f2.c(s1.B(2131920734), 0);
            return;
        L47:
            UserProfileEvent r12 = new UserProfileEvent(r10.a.getIdString());
            r12.mSource = "top_single_room_rank";
            r12.setClickUserPosition("top_single_room_rank");
            r12.order = r10.b;
            if (r10.a.getBorder() != null) goto L50;
        L52:
            xs2.b.a().post(r12);
            return;
        L50:
            if (r10.a.getBorder().getDressId() == null) goto L52;
            r12.wearId = r10.a.getBorder().getDressId();
            goto L52
        }
    }

    public interface b {
        void onShow();
    }

    public final long getItemId(int r3) {
        return r3;
    }

    public final int getItemCount() {
        return ((ArrayList) this.f).size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r20, final int r22) {
        final AudienceViewHolder r2 = (AudienceViewHolder) r20;
        x71.a r3 = (x71.a) ListProtector.get(this.f, r22);
        r2.getClass();
        r2.a = this.h;
        a r4 = this.e;
        DataCenter r5 = this.a;
        if (r3 != null) goto L5;
    L119:
        ALogger.i("updateWatchUser bind null", "rankItem : " + r3);
        return;
    L5:
        if (r3.a == null) goto L119;
        if (r3.c == false) goto L10;
        ALogger.i("AudienceViewHolder", "user is hidden, rankItem : " + r3);
    L10:
        HSImageView r6 = r2.c;
        if (r6 == null) goto L15;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L15;
        r7.height = s1.f(26.0f);
        r7.width = s1.f(26.0f);
        r2.c.requestLayout();
    L15:
        IBaseUser r8 = r3.a;
        if (r3.c == false) goto L19;
        ImageLoader.bindImage(r2.c, (String) nn0.a.getValue());
    L31:
        HSImageView r9 = r2.d;
        if (r9 == null) goto L36;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L36;
        r10.height = s1.f(32.0f);
        r10.width = s1.f(32.0f);
        r2.d.requestLayout();
    L36:
        IBaseUser r12 = r3.a;
        if (r12.getBorder() == null) goto L43;
        com.bytedance.android.live.profit.dress.a r13 = (com.bytedance.android.live.profit.dress.a) c.a().getDressData(r12.getBorder().getDressId(), 11, "AudienceViewHolder: bind");
        if (r13 == null) goto L41;
        py.k r14 = r13.b;
    L42:
        py.k r15 = r14;
    L45:
        if (r3.c == true) goto L50;
        if (r15 == null) goto L50;
        if (CollectionUtils.isEmpty(r15.getUrls()) == true) goto L50;
        r2.d.setVisibility(0);
        int r16 = s1.f(51.0f);
        ImageLoader.bindImage(r2.d, r15, null, r16, r16, null, null, true);
    L51:
        IBaseUser r17 = r3.a;
        o r18 = o3.f();
        if (r18 == null) goto L54;
        boolean r19 = r18.isAnchor().booleanValue();
    L56:
        if (r19 == true) goto L58;
    L69:
        String r110 = "";
    L71:
        if (TextUtils.isEmpty(r110) == false) goto L73;
    L97:
        r2.f.setVisibility(8);
        d r23 = r17.getUserHonor();
        if (r23 != null) goto L100;
    L102:
        AudienceViewHolder r111 = null;
        r2.e.setVisibility(8);
    L104:
        if (TextUtils.isEmpty(r17.getNickName()) == true) goto L106;
        r3.a(r2.b, String.format("%s%s", new Object[]{s1.B(2131920713), r17.getNickName()}));
    L106:
        r2.b.setTag(r3);
        r2.b.setOnClickListener(r4);
        UIUtils.setViewVisibility(r2.e, 8);
        String r24 = r3.a.getNickName();
        kz.a r25 = kz.b.a;
        if (r25 != null) goto L109;
    L111:
        r3.a(r2.b, r24);
        if (r2.a != null) goto L114;
        return;
    L114:
        if (p.b(r5) == false) goto L122;
        if (r22 < 1) goto L117;
        RecyclerView r26 = r2.a;
        final AudienceViewHolder r112 = (AudienceViewHolder) r26.getChildViewHolder(r26.getChildAt(r22 - 1));
    L118:
        ((RecyclerView.ViewHolder) r2).itemView.post(new y51.a(r2, r22, r112));
        return;
    L117:
        r112 = r111;
        goto L118
    L122:
        return;
    L109:
        if (r25.a() == false) goto L111;
        r24 = "观众头像" + (r2.getAdapterPosition() + 1) + "，按钮";
        goto L111
    L100:
        if (r23.getLevel() <= 0) goto L102;
        r2.e.setVisibility(0);
        r111 = null;
        ImageUtil.loadImage(r2.e, r23.getLiveIcon(), s1.f(28.0f), s1.f(28.0f), null);
        goto L104
    L73:
        if (q.a() == false) goto L97;
        FitTextView r27 = r2.f;
        float r113 = s1.f(20.0f);
        float r28 = s1.f(32.0f);
        float r114 = s1.f(9.0f);
        if (r27 != null) goto L77;
        r113 = 0.0f;
    L85:
        r27.setWidth((int) r113);
        r2.f.setText(r110, TextView.BufferType.NORMAL);
        int r29 = r3.b;
        if (r29 == 1) goto L92;
        if (r29 == 2) goto L91;
        if (r29 == 3) goto L90;
        int r30 = 2131248868;
    L93:
        r2.f.setBackgroundResource(r30);
        r2.f.setVisibility(0);
        r2.e.setVisibility(8);
        if (TextUtils.isEmpty(r17.getNickName()) == true) goto L96;
        r3.a(r2.b, String.format("%s%s%s%s", new Object[]{s1.B(2131920713), r17.getNickName(), r110, s1.B(2131914465)}));
    L96:
        r111 = null;
        goto L106
    L90:
        r30 = 2131248867;
        goto L93
    L91:
        r30 = 2131248866;
        goto L93
    L92:
        r30 = 2131248865;
        goto L93
    L77:
        TextPaint r115 = r27.getPaint();
        r115.setTextSize(r114);
        float r116 = (r115.measureText(r110) + r27.getPaddingLeft()) + r27.getPaddingRight();
        if (r116 > r28) goto L82;
        r28 = r116;
    L82:
        if (r28 < r113) goto L85;
        r113 = r28;
        goto L85
    L58:
        if (TextUtils.isEmpty(r3.d) == true) goto L69;
        if (r17 != null) goto L61;
    L65:
        boolean r117 = false;
    L66:
        if (r117 == true) goto L68;
        r110 = "***";
        goto L71
    L68:
        r110 = r3.d;
        goto L71
    L61:
        if (r17.isVcdContentAuthorized() == false) goto L63;
    L64:
        r117 = true;
        goto L66
    L63:
        if (r17.isVcdRelationAuthorized() == false) goto L65;
    L54:
        r19 = false;
    L50:
        r2.d.setVisibility(8);
        goto L51
    L41:
        r14 = r12.getBorder().getDefaultIcon();
        goto L42
    L43:
        r15 = null;
        goto L45
    L19:
        if (r8.getAvatarThumbKt() != null) goto L21;
    L27:
        int r32 = s1.f(12.0f);
        HSImageView r33 = r2.c;
        if (((Boolean) j40.k.a.getValue()).booleanValue() == false) goto L30;
        ImageLoader.bindDrawableResource(r33, 2131251889, r32, r32);
        goto L31
    L30:
        ImageUtil.loadRoundResource(r33, 2131251889, r32, r32);
        goto L31
    L21:
        if (CollectionUtils.isEmpty(r8.getAvatarThumbKt().getUrls()) == true) goto L27;
        HSImageView r34 = r2.c;
        py.k r35 = r8.getAvatarThumbKt();
        int r118 = s1.f(28.0f);
        int r119 = s1.f(28.0f);
        if (((Boolean) j40.k.a.getValue()).booleanValue() == false) goto L26;
        ImageLoader.bindImage(r34, r35, 2131251889, r118, r119);
        goto L31
    L26:
        a1.x(r34, r35, r118, r119, 2131251889);
        goto L31
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Activity r4 = ContextUtil.contextToActivity(this.c);
        if (this.b == false) goto L5;
        View r5 = AudienceInflateUtil.a(AudienceViewInfo.TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE, r4, r2);
    L7:
        return new AudienceViewHolder(r5);
    L5:
        r5 = AudienceInflateUtil.a(AudienceViewInfo.TTLIVE_VIEW_AUDIENCE_LIST_ITEM, r4, r2);
        goto L7
    }

    public AudienceListAdapter(Context r2, DataCenter r3, NoTouchRecyclerView r4) {
        this.e = new a(this);
        this.f = new ArrayList();
        this.a = r3;
        this.h = r4;
        this.c = r2;
    }
}
