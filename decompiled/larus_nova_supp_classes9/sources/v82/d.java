package v82;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkedUserInfo;
import com.bytedance.android.livesdk.chatroom.interact.model.RivalExtraInfo;
import com.bytedance.android.livesdk.chatroom.interact.model.w;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkUserViewHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends me.drakeet.multitype.b<a, MediaAnchorLinkUserViewHolder> {
    public final t82.c b;

    public static final class a {
        public Room a;
        public Map<Long, RivalExtraInfo> b;
        public int c;

        public a() {
        }
    }

    public d(t82.c r2) {
        Intrinsics.checkNotNullParameter(r2, "mListener");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r10, Object r11) {
        final MediaAnchorLinkUserViewHolder r13 = (MediaAnchorLinkUserViewHolder) r10;
        a r14 = (a) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r14, "item");
        final Room r0 = r14.a;
        Map<Long, RivalExtraInfo> r1 = r14.b;
        int r15 = r14.c;
        r13.getClass();
        if (r0 == null) goto L118;
        User r2 = r0.getBaseOwner();
        if (r2 == null) goto L119;
        r13.j = r0;
        r13.h = r15;
        if (r1 == null) goto L11;
        final RivalExtraInfo r16 = r1.get(Long.valueOf(r0.getId()));
    L12:
        ArrayList r3 = new ArrayList();
        if (r16 != null) goto L15;
    L24:
        boolean r4 = false;
        if (k.f(IRoomService.class).getCurrentRoom() == null) goto L31;
        long r5 = k.f(IRoomService.class).getCurrentRoom().getId();
        if (r1 == null) goto L31;
        RivalExtraInfo r6 = r1.get(Long.valueOf(r5));
        if (r6 == null) goto L31;
        final int r7 = r6.getAnchorLayer();
    L32:
        a1.x(r13.a, r2.getAvatarThumb(), r13.a.getWidth(), r13.a.getHeight(), 2131250965);
        r13.c.setText(r2.getNickName());
        if (r0.isMediaRoom() == false) goto L42;
        r13.b.setVisibility(8);
        if (r2.getMAuthenticationInfo() == null) goto L40;
        r13.d.setVisibility(0);
        r13.e.setVisibility(0);
        ImageLoader.bindImage(r13.d, r2.getMAuthenticationInfo().getAuthenticationBadge());
        if (TextUtils.isEmpty(r2.getMAuthenticationInfo().getEnterpriseVerifyReason()) == true) goto L39;
        r13.e.setText(r2.getMAuthenticationInfo().getEnterpriseVerifyReason());
    L62:
        View.OnClickListener r8 = new e(r13, r0, r16, r7);
        r13.f.setOnClickListener(r8);
        if (r16 != null) goto L65;
    L107:
        r13.f.setBackgroundResource(2131249510);
        r13.f.setText(2131920255);
        r13.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        return;
    L65:
        if (r16.getAnchorLinkmicUserSettings() == null) goto L107;
        if (r16.getAnchorLinkmicUserSettings().isIsTurnOn() == false) goto L107;
        if (r0.getLinkMicInfo() == null) goto L71;
        r13.f.setBackgroundResource(2131249510);
        r13.f.setText(2131920294);
        r13.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
    L101:
        if (r0.getLinkerDetail() != null) goto L103;
        return;
    L103:
        if (r0.getLinkerDetail().getPlayModes() != null) goto L105;
        return;
    L105:
        if (r0.getLinkerDetail().getPlayModes().contains(3L) == false) goto L116;
        r13.f.setBackgroundResource(2131249510);
        r13.f.setText(2131920236);
        r13.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        return;
    L116:
        return;
    L71:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r9 = r13.i;
        if (r9 == null) goto L81;
        if (r9.Np().d().size() <= 1) goto L81;
        if (r13.T3((User) r0.getBaseOwner()) == true) goto L81;
        if (r16.getAnchorLinkmicUserSettings().isAcceptMultiAnchorLink() == true) goto L81;
        r13.f.setBackgroundResource(2131249510);
        r13.f.setText(2131920302);
        r13.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
    L81:
        if (r0.getLinkMap() == null) goto L97;
        if (r0.getLinkMap().isEmpty() == true) goto L97;
        if (r0.getLinkMap().containsKey(String.valueOf(4)) == false) goto L90;
        if (r0.getLinkMap().size() == 1) goto L97;
    L90:
        if (r0.getLinkMap().containsKey(String.valueOf(17)) == false) goto L92;
    L95:
        r13.f.setBackgroundResource(2131249510);
        r13.f.setText(2131920294);
        r13.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        goto L101
    L92:
        if (r0.getLinkMap().containsKey(String.valueOf(7)) == true) goto L95;
        if (r0.getLinkMap().containsKey(String.valueOf(8)) == false) goto L101;
    L97:
        if (r13.T3((User) r0.getBaseOwner()) == false) goto L99;
        r13.f.setBackgroundResource(2131249505);
        r13.f.setText(2131920238);
        r13.f.setTextColor(-16777216);
        goto L101
    L99:
        r13.f.setBackgroundResource(2131249507);
        r13.f.setText(2131920248);
        r13.f.setTextColor(-1);
        goto L101
    L39:
        r13.e.setText(r2.getMAuthenticationInfo().getCustomVerify());
        goto L62
    L40:
        r13.d.setVisibility(8);
        r13.e.setVisibility(8);
        goto L62
    L42:
        if (r2.getGender() != 1) goto L45;
        r13.b.setImageResource(2131250688);
        r13.b.setVisibility(0);
    L48:
        r13.d.setImageResource(2131250806);
        r13.e.setVisibility(0);
        r13.d.setVisibility(0);
        if (r16 != null) goto L51;
    L59:
        if (r4 == false) goto L61;
        r13.e.setText(r16.getText());
        goto L62
    L61:
        r13.e.setText(s1.B(2131920251));
        goto L62
    L51:
        if (r16.getText_type() != RivalExtraInfo.TextType.Distance.ordinal()) goto L53;
    L54:
        String r17 = r16.text;
        if (r17 == null) goto L59;
        if (r17.length() <= 0) goto L59;
        r4 = true;
        goto L59
    L53:
        if (r16.getText_type() != RivalExtraInfo.TextType.DistanceCity.ordinal()) goto L59;
    L45:
        if (r2.getGender() != 2) goto L47;
        r13.b.setImageResource(2131250687);
        r13.b.setVisibility(0);
        goto L48
    L47:
        r13.b.setVisibility(8);
    L31:
        r7 = 0;
        goto L32
    L15:
        if (r16.getLinkerInfo() == null) goto L24;
        if (Lists.isEmpty(r16.getLinkerInfo().getLinkedUserInfos()) == true) goto L24;
        Iterator r18 = r16.getLinkerInfo().getLinkedUserInfos().iterator();
    L20:
        if (r18.hasNext() == false) goto L24;
        LinkedUserInfo r19 = (w) r18.next();
        if (n0.a(r19.getUserIdStr(), r2.getIdStr()) == true) goto L20;
        r3.add(r19);
        goto L20
    L11:
        r16 = null;
        goto L12
    L119:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new MediaAnchorLinkUserViewHolder(r4.inflate(2131566911, r5, false), this.b);
    }
}
