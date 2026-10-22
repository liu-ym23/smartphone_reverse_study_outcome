package y31;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKRivalsSearchViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.m0;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q extends me.drakeet.multitype.b<a, PKRivalsSearchViewHolder> {
    public final com.bytedance.android.live.revlink.impl.pk.utils.m b;
    public final x31.g c;
    public final DataCenter d;

    public static final class a {
        public x8 a;
        public String b;
        public m0 c;

        public a() {
            this.b = "";
        }
    }

    public final void g(RecyclerView.ViewHolder r2) {
        PKRivalsSearchViewHolder r3 = (PKRivalsSearchViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.m.c = 0;
    }

    public final void b(RecyclerView.ViewHolder r22, Object r23) {
        PKRivalsSearchViewHolder r0 = (PKRivalsSearchViewHolder) r22;
        a r1 = (a) r23;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r1, "item");
        x8 r2 = r1.a;
        String r3 = r1.b;
        m0 r4 = r1.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "activityName");
        if (r2 == null) goto L114;
        r0.l = 5;
        r0.n = r2;
        r0.o = false;
        r0.p = 0;
        a1.x(r0.a, r2.getAvatarThumb(), r0.a.getWidth(), r0.a.getHeight(), 2131250965);
        r0.e.setText(r2.getNickName());
        KmpEnv r5 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L8;
        r0.f.setText(s1.C(2131921543, new Object[]{r2.getDisplayId()}));
        r0.f.setVisibility(0);
    L9:
        r0.g.setText(s1.C(2131921544, new Object[]{IESUIUtils.getDisplayCount(r2.getFansNum(), "w")}));
        if (r2.getRoomId() == 0) goto L13;
        r0.c.setVisibility(0);
        r0.d.setVisibility(0);
        r0.d.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build());
        r0.b.setVisibility(8);
    L17:
        if (r0.T3(r2.getUserId()) == false) goto L19;
        r0.i.setImageResource(2131249714);
        r0.j.setText(2131914739);
        r0.j.setTextColor(ColorProtector.parseColor("#161823"));
    L21:
        if (r2.getRoomId() != 0) goto L24;
        r0.h.setVisibility(4);
        r0.k.setText(2131917949);
        r0.k.setVisibility(0);
    L31:
        if (TextUtils.equals(iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b()), r2.getUserId()) == false) goto L33;
        r0.h.setVisibility(8);
        r0.k.setText(2131917948);
        r0.k.setVisibility(0);
    L33:
        ViewGroup.LayoutParams r7 = r0.h.getLayoutParams();
        r7.width = s1.f(64.0f);
        r0.h.setLayoutParams(r7);
        ArrayList r15 = new ArrayList();
        if (r3.length() != 0) goto L36;
        boolean r6 = true;
    L37:
        com.bytedance.android.livesdk.link.model.p r8 = null;
        if (r6 == true) goto L81;
        if (r2.getActivityUser() == null) goto L81;
        n0 r9 = r2.getActivityUser();
        Intrinsics.checkNotNull(r9);
        List r10 = r9.getLabelList();
        Intrinsics.checkNotNull(r10);
        r15.addAll(r10);
        n0 r12 = r2.getActivityUser();
        Intrinsics.checkNotNull(r12);
        if (r12.isValid() == true) goto L44;
    L46:
        n0 r13 = r2.getActivityUser();
        Intrinsics.checkNotNull(r13);
        if (r13.isValid() == true) goto L49;
    L79:
        r0.h.setVisibility(4);
        r0.k.setVisibility(0);
        TextView r14 = r0.k;
        n0 r16 = r2.getActivityUser();
        Intrinsics.checkNotNull(r16);
        r14.setText(r16.getReasonMessage());
        goto L81
    L49:
        if (r2.getRoomId() == 0) goto L79;
        r0.h.setVisibility(0);
        if (r4 == null) goto L81;
        if (r4.getInviteButtonText().length() != 0) goto L55;
        boolean r17 = true;
    L56:
        if (r17 == true) goto L59;
        ViewGroup.LayoutParams r18 = r0.h.getLayoutParams();
        r18.width = s1.f(80.0f);
        r0.h.setLayoutParams(r18);
        r0.j.setText(r4.getInviteButtonText());
    L59:
        if (r4.getInviteButtonImage() == null) goto L78;
        py.k r19 = r4.getInviteButtonImage();
        if (r19 == null) goto L63;
        List r20 = r19.getUrls();
    L64:
        if (r20 == null) goto L78;
        py.k r24 = r4.getInviteButtonImage();
        if (r24 == null) goto L78;
        List r25 = r24.getUrls();
        if (r25 == null) goto L78;
        if ((!r25.isEmpty()) != true) goto L78;
        HSImageView r26 = r0.i;
        py.k r27 = r4.getInviteButtonImage();
        if (r27 == null) goto L76;
        List r28 = r27.getUrls();
        if (r28 == null) goto L76;
        String r29 = (String) ListProtector.get(r28, 0);
    L77:
        ImageLoader.bindImage(r26, r29);
    L76:
        r29 = null;
        goto L77
    L63:
        r20 = null;
    L78:
        r0.o = true;
        goto L81
    L55:
        r17 = false;
        goto L56
    L44:
        if (r2.getRoomId() != 0) goto L46;
        r0.h.setVisibility(4);
        r0.k.setText(2131917949);
        r0.k.setVisibility(0);
    L81:
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L113;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r30 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r30 == null) goto L85;
        i11.b r32 = r30.getLinkUserCenter();
    L86:
        if (r32 == null) goto L113;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r33 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r33 == null) goto L114;
        i11.b r34 = r33.getLinkUserCenter();
        if (r34 == null) goto L114;
        List<com.bytedance.android.livesdk.link.model.p> r35 = r34.d();
        String r36 = r2.getUserId();
        if (r35 == null) goto L104;
        Iterator<com.bytedance.android.livesdk.link.model.p> r37 = r35.iterator();
    L97:
        if (r37.hasNext() == false) goto L104;
        com.bytedance.android.livesdk.link.model.p r38 = r37.next();
        IBaseUser r39 = r38.getUser();
        if (r39 == null) goto L104;
        if (TextUtils.equals(iz.a.a(r39), r36) == false) goto L97;
        r8 = r38;
    L104:
        if (r8 == null) goto L113;
        if (r8.getStatus() != 2) goto L109;
        r0.h.setVisibility(4);
        r0.k.setVisibility(0);
        r0.k.setText(2131914731);
        goto L113
    L109:
        if (r8.getStatus() != 1) goto L113;
        if (r0.T3(r2.getUserId()) == true) goto L113;
        r0.h.setVisibility(4);
        r0.k.setVisibility(0);
        r0.k.setText(2131914827);
        goto L113
    L85:
        r32 = null;
    L113:
        List r40 = r2.getTags();
        Intrinsics.checkNotNull(r40);
        r15.addAll(r40);
        r0.m.setOldTag(true);
        PkTagsContainerView.f(r0.m, r15, false, null, 9, "", 32);
        r0.h.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.s(r0, r2));
        goto L114
    L36:
        r6 = false;
        goto L37
    L24:
        if (r2.getLinkStatus() != 2) goto L26;
    L29:
        r0.h.setVisibility(0);
        r0.h.setAlpha(0.5f);
        r0.k.setVisibility(8);
        goto L31
    L26:
        if (r2.getLinkStatus() == 1) goto L29;
        r0.h.setVisibility(0);
        r0.h.setAlpha(1.0f);
        r0.k.setVisibility(8);
        r0.o = true;
        goto L31
    L19:
        r0.i.setImageResource(2131249467);
        r0.j.setText(2131919636);
        r0.j.setTextColor(ColorProtector.parseColor("#ffffff"));
        goto L21
    L13:
        if (StringUtils.isEmpty(r2.getCustomVerify()) == true) goto L15;
        r0.c.setVisibility(8);
        r0.d.setVisibility(8);
        r0.b.setVisibility(0);
        goto L17
    L15:
        r0.c.setVisibility(8);
        r0.d.setVisibility(8);
        r0.b.setVisibility(8);
        goto L17
    L8:
        r0.f.setVisibility(8);
    L114:
        com.bytedance.android.live.revlink.impl.pk.utils.m r42 = this.b;
        if (r42 == null) goto L122;
        r42.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKRivalsSearchViewHolder(r4.inflate(2131566365, r5, false), this.c, this.d);
    }

    public q(com.bytedance.android.live.revlink.impl.pk.utils.m r2, x31.g r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
