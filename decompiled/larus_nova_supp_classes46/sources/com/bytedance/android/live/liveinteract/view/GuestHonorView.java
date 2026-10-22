package com.bytedance.android.live.liveinteract.view;

import am2.x;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.plantform.model.GuestHonorInfo;
import com.bytedance.android.live.liveinteract.plantform.model.HonorIconContent;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/GuestHonorView;", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getLlHonorList", "()Landroid/widget/LinearLayout;", "setLlHonorList", "(Landroid/widget/LinearLayout;)V", "llHonorList", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvhHnorCount", "()Landroid/widget/TextView;", "setTvhHnorCount", "(Landroid/widget/TextView;)V", "tvhHnorCount", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "c", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getMUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setMUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "mUser", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestHonorView extends LinearLayout {
    public LinearLayout a;
    public TextView b;
    public IBaseUser c;

    public GuestHonorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GuestHonorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final LinearLayout getLlHonorList() {
        return this.a;
    }

    public final IBaseUser getMUser() {
        return this.c;
    }

    public final TextView getTvhHnorCount() {
        return this.b;
    }

    public final void setLlHonorList(LinearLayout r1) {
        this.a = r1;
    }

    public final void setMUser(IBaseUser r1) {
        this.c = r1;
    }

    public final void setTvhHnorCount(TextView r1) {
        this.b = r1;
    }

    public final void a(ContributeShowResponse.OwnerHonorInfo r9, IBaseUser r10) {
        this.c = r10;
        if (r9 != null) goto L5;
        return;
    L5:
        LinearLayout r11 = this.a;
        if (r11 == null) goto L24;
        List<GuestHonorInfo> r12 = r9.getHitGuestHonorInfoList();
        if (r12 == null) goto L24;
        if (r12.size() <= 3) goto L17;
        TextView r2 = this.b;
        if (r2 == null) goto L14;
        StringBuilder r4 = new StringBuilder();
        r4.append(r12.size() - 3);
        r4.append('+');
        r2.setText(r4.toString());
    L14:
        TextView r3 = this.b;
        if (r3 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r3);
    L17:
        int r5 = Math.min(3, r12.size());
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L24;
        HSImageView r7 = new HSImageView(getContext());
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(14), UtilityKotlinExtentionsKt.i(14));
        r8.leftMargin = UtilityKotlinExtentionsKt.i(2);
        r8.bottomMargin = UtilityKotlinExtentionsKt.i(2);
        Unit r13 = Unit.INSTANCE;
        r7.setLayoutParams(r8);
        r11.addView(r7);
        HonorIconContent r14 = ((GuestHonorInfo) ListProtector.get(r12, r6)).getIconList();
        if (r14 == null) goto L22;
        k r15 = r14.getIcon();
    L23:
        ImageLoader.bindImage(r7, r15);
        r6 = r6 + 1;
        goto L18
    L22:
        r15 = null;
    L24:
        i0 r16 = TalkRoomLogUtils.a;
        Map r17 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("request_page", "link_panel"), TuplesKt.to("user_id", jc1.k.n(IMiddlewareUserService.class).user().n())});
        TalkRoomLogUtils.c1(r17);
        j0.l().sendLog("livesdk_chatroom_audiencehornor_entrance_show", r17, new Object[]{IRoom.class, x.class});
    }

    public GuestHonorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566659, this);
        setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.i(16)));
        setGravity(16);
        setOrientation(0);
        this.a = (LinearLayout) findViewById(2131378713);
        this.b = (TextView) findViewById(2131390749);
        setOnClickListener(new a(this));
    }

    public /* synthetic */ GuestHonorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
