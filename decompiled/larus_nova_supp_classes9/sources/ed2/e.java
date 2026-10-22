package ed2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.kickout.ui.BannedViewHolder;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ita.i;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ BannedViewHolder b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        final BannedViewHolder r14 = this.b;
        int r0 = this.a;
        Context r1 = r14.f;
        int r2 = i.a;
        if (NetworkUtils.isNetworkAvailable(r1) == true) goto L5;
        IESUIUtils.displayToast(r14.f, 2131916005);
    L21:
        User r15 = (User) ListProtector.get(this.b.g, this.a);
        if (r15 != null) goto L24;
        return;
    L24:
        BannedViewHolder r3 = this.b;
        r3.getClass();
        HashMap r4 = new HashMap();
        r4.put("anchor_id", String.valueOf(r3.m));
        r4.put("room_id", String.valueOf(r3.l));
        r4.put("to_user_id", r15.getIdString());
        if (n0.a(this.b.m, TTLiveSDKContext.getHostService().h().n()) == false) goto L27;
        String r16 = "anchor";
    L28:
        r4.put("user_type", r16);
        r4.put("button_type", "cancel");
        r4.put("request_page", "room");
        if (this.b.h.equals("activity_banned_talk") == false) goto L31;
        String r17 = "livesdk_anchor_mute_cancel_click";
    L32:
        u.l().sendLog(r17, r4, new Object[0]);
        return;
    L31:
        r17 = "livesdk_anchor_blocklist_cancel_click";
        goto L32
    L27:
        r16 = "user";
        goto L28
    L5:
        final User r5 = (User) ListProtector.get(r14.g, r0);
        final String r6 = r14.h;
        if (r5 == null) goto L21;
        r14.k = r5;
        String r7 = r14.f.getString(2131915447);
        if (TextUtils.isEmpty(r5.getNickName()) == false) goto L11;
        String r8 = BuildConfig.FLAVOR;
    L12:
        Context r9 = r14.f;
        if (r6.equals("activity_banned_talk") == false) goto L15;
        int r10 = 2131915448;
    L16:
        SpannableStringBuilder r11 = new SpannableStringBuilder(r7 + " " + r8 + " " + r9.getString(r10));
        r11.setSpan(new ForegroundColorSpan(r14.f.getResources().getColor(2131107115)), r7.length() + 1, (r7.length() + 1) + r8.length(), 33);
        final HashMap r18 = new HashMap();
        r18.put("anchor_id", String.valueOf(r14.m));
        r18.put("room_id", String.valueOf(r14.l));
        r18.put("user_id", r5.getIdString());
        x0.b r19 = new x0.b(r14.f, 0);
        r19.a.d = r11;
        r19.i(1, 2131915442, new b(r14, r18));
        r19.i(0, 2131915426, new c(r14, r18, r6, r5));
        r19.n();
        if (r14.h.equals("activity_banned_talk") == false) goto L19;
        String r110 = "livesdk_anchor_mute_cancel_toast_show";
    L20:
        u.l().sendLog(r110, r18, new Object[0]);
        goto L21
    L19:
        r110 = "livesdk_anchor_blacklist_cancel_toast_show";
        goto L20
    L15:
        r10 = 2131915450;
        goto L16
    L11:
        r8 = r5.getNickName();
        goto L12
    }

    public e(BannedViewHolder r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
