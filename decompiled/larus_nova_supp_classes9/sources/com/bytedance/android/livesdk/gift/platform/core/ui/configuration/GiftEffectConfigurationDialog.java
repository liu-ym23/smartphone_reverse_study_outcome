package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/GiftEffectConfigurationDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectConfigurationDialog extends LiveDialogFragment {
    public static final /* synthetic */ int p = 0;
    public final n d;
    public GiftEffectConfigurationViewModelForAnchor e;
    public View f;
    public LinearLayout g;
    public TextView h;
    public ImageView i;
    public ListView j;
    public final float k;
    public final GiftEffectConfigurationDialog$adapter$1 l;
    public final Context m;
    public final boolean n;
    public final boolean o;

    public static final class a {
    }

    static {
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        setBottomSheetSlideProcessor(new g());
        Dialog r6 = getDialog();
        if (r6 == null) goto L7;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L7;
        r7.setGravity(80);
        r7.setLayout(-1, -1);
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        View r8 = this.f;
        if (r8 == null) goto L10;
        LinearLayout r9 = (LinearLayout) r8.findViewById(2131373692);
    L11:
        this.g = r9;
        View r10 = this.f;
        if (r10 == null) goto L14;
        TextView r11 = (TextView) r10.findViewById(2131373697);
    L15:
        this.h = r11;
        View r13 = this.f;
        if (r13 == null) goto L18;
        ImageView r14 = (ImageView) r13.findViewById(2131363762);
    L19:
        this.i = r14;
        View r15 = this.f;
        if (r15 == null) goto L22;
        ListView r16 = (ListView) r15.findViewById(2131373696);
    L23:
        this.j = r16;
        LinearLayout r17 = this.g;
        if (r17 == null) goto L26;
        a1.k(r17, (int) fm3.e.a(this.m, this.k));
        r17.setBackground(s1.m(2131250337));
    L26:
        TextView r18 = this.h;
        if (r18 == null) goto L29;
        r18.setTextColor(s1.h(2131107294));
        r18.setTextSize(0, s1.j(2131168556));
        r18.setText(2131917120);
    L29:
        ImageView r19 = this.i;
        if (r19 == null) goto L32;
        r19.setOnClickListener(new h(this));
    L32:
        ListView r20 = this.j;
        if (r20 == null) goto L36;
        r20.setDivider(null);
        r20.setClickable(false);
        r20.setOnItemClickListener(null);
        r20.setAdapter(this.l);
        return;
    L36:
        return;
    L22:
        r16 = null;
        goto L23
    L18:
        r14 = null;
        goto L19
    L14:
        r11 = null;
        goto L15
    L10:
        r9 = null;
        goto L11
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
    }

    public GiftEffectConfigurationDialog(Context r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "hostContext");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        if (r3 == false) goto L5;
        n r5 = new GiftEffectConfigurationItemForAnchor(r2);
    L6:
        this.d = r5;
        this.k = 321.0f;
        this.l = new GiftEffectConfigurationDialog$adapter$1(this);
        return;
    L5:
        r5 = new GiftEffectConfigurationItemForAudience(r2);
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        this.f = r8.inflate(2131565237, r9, false);
        if (this.n == false) goto L5;
        this.e = (GiftEffectConfigurationViewModelForAnchor) ViewModelProviders.of(this).get(GiftEffectConfigurationViewModelForAnchor.class);
    L28:
        GiftEffectConfigurationViewModelForAnchor r11 = this.e;
        if (r11 == null) goto L31;
        r11.setIsBeforeLive(this.o);
    L31:
        this.d.b(this.e);
        if (this.n == false) goto L48;
        GiftEffectConfigurationViewModelForAnchor r13 = this.e;
        if (r13 == null) goto L37;
        r13.updateStickerEffectStatus();
    L37:
        if (this.o == true) goto L41;
        GiftEffectConfigurationViewModelForAnchor r14 = this.e;
        if (r14 == null) goto L41;
        r14.getGameEffectSwitch();
    L41:
        GiftEffectConfigurationViewModelForAnchor r15 = this.e;
        if (r15 == null) goto L44;
        r15.getRoleSkillEffectSwitch();
    L44:
        GiftEffectConfigurationViewModelForAnchor r16 = this.e;
        if (r16 == null) goto L48;
        GiftEffectConfigurationViewModelForAnchor.logAnchorConfigDialogShow$default(r16, null, null, 3, null);
    L48:
        return this.f;
    L5:
        i12.e r17 = i12.o.b();
        if (r17 == null) goto L8;
        Object r18 = com.bytedance.android.scope.m.e.d(r17, i2.class);
    L9:
        i2 r19 = (i2) r18;
        int r110 = p.a;
        boolean r111 = true;
        if (r19 == null) goto L12;
        boolean r0 = i2.d();
    L13:
        if (r19 == null) goto L15;
        r111 = r19.c();
    L15:
        mz0.n r20 = new mz0.n();
        p.a(r20);
        Map r1 = r20.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        String r2 = "open";
        if (r0 == false) goto L18;
        Object r3 = "open";
    L19:
        Intrinsics.checkNotNullParameter("gift_effect_status", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.put("gift_effect_status", r3);
        if (r111 == true) goto L23;
        r2 = "close";
    L23:
        Intrinsics.checkNotNullParameter("gift_voice_status", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.put("gift_voice_status", r2);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L26;
        String r112 = "1";
    L27:
        Intrinsics.checkNotNullParameter("is_anchor", "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        r1.put("is_anchor", r112);
        cy0.e.a.getClass();
        cy0.j r113 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r114);
        ((f80.a) r114).w3("livesdk_audience_gift_effects_setting_popup_show", r20.a, r20.b);
        goto L28
    L26:
        r112 = "0";
        goto L27
    L18:
        r3 = "close";
        goto L19
    L12:
        r0 = true;
        goto L13
    L8:
        r18 = null;
        goto L9
    }
}
