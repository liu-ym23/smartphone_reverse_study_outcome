package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.gv0;
import com.bytedance.android.livesdk.config.tg;
import com.bytedance.android.livesdk.config.vr;
import com.bytedance.android.livesdk.utils.HTSLiveMaskBrightnessMode;
import com.bytedance.android.livesdk.utils.z3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ShadowServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShadowServiceWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public View a;
    public View b;
    public int c;
    public int d;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observe("cmd_pk_state_change", this);
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r1 = ho1.a.i(getComponentContext());
        Drawable r2 = null;
        if (r1 == null) goto L8;
        View r3 = r1.Wn();
    L9:
        this.a = r3;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = ho1.a.i(getComponentContext());
        if (r4 == null) goto L12;
        View r5 = r4.fj();
    L13:
        this.b = r5;
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L16;
    L20:
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r6 != null) goto L23;
    L30:
        if (r6 == null) goto L37;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L37;
        Room r8 = (Room) r7.getValue();
        if (r8 == null) goto L37;
        String r9 = r8.getOwnerUserIdString();
        if (r9 == null) goto L37;
    L38:
        IFeatureService r10 = jc1.k.f(IFeatureService.class);
        float r11 = 0.0f;
        if (r10 == null) goto L45;
        z90.a r12 = r10.getFeatureManager();
        if (r12 == null) goto L45;
        Float r13 = (Float) r12.b("brightness_avg_5min", r9, Float.valueOf(0.0f));
        if (r13 == null) goto L45;
        float r14 = r13.floatValue();
    L46:
        float r15 = 1.0f;
        if (vr.a.getValue().booleanValue() == true) goto L49;
    L79:
        View r16 = this.a;
        if (r16 != null) goto L82;
        return;
    L82:
        if (this.b == null) goto L98;
        Intrinsics.checkNotNull(r16);
        View r17 = this.b;
        Intrinsics.checkNotNull(r17);
        Drawable r18 = r16.getBackground();
        if ((r18 instanceof GradientDrawable) == true) goto L86;
        r18 = null;
    L86:
        GradientDrawable r19 = (GradientDrawable) r18;
        if (r19 == null) goto L89;
        r19.setColors(new int[]{Color.argb(MathKt.roundToInt((gv0.a.getValue().floatValue() * 255) * r15), 0, 0, 0), Color.argb(0, 0, 0, 0)});
    L89:
        Drawable r20 = r17.getBackground();
        if ((r20 instanceof GradientDrawable) == false) goto L93;
        r2 = r20;
    L93:
        GradientDrawable r21 = (GradientDrawable) r2;
        if (r21 == null) goto L99;
        r21.setColors(new int[]{Color.argb(0, 0, 0, 0), Color.argb(MathKt.roundToInt((tg.a.getValue().floatValue() * 255) * r15), 0, 0, 0)});
        return;
    L99:
        return;
    L98:
        return;
    L49:
        if (r14 <= 0.0f) goto L79;
        Map r22 = z3.b();
        if (r22 == null) goto L58;
        Object r23 = r22.get("mode");
        if ((r23 instanceof Number) == true) goto L55;
        r23 = null;
    L55:
        Number r24 = (Number) r23;
        if (r24 == null) goto L58;
        int r25 = r24.intValue();
    L59:
        float r26 = r14 / 255.0f;
        if (r25 == HTSLiveMaskBrightnessMode.None.getValue()) goto L79;
        if (r25 == HTSLiveMaskBrightnessMode.Min.getValue()) goto L65;
        float r27 = 1.0f;
    L72:
        Map r28 = z3.b();
        if (r28 == null) goto L75;
        r11 = z3.a(r28, "min_alpha", 0.0f);
    L75:
        Map r29 = z3.b();
        if (r29 == null) goto L78;
        r15 = z3.a(r29, "max_alpha", 1.0f);
    L78:
        r15 = RangesKt.coerceIn(r27, r11, r15);
        goto L79
    L65:
        if (r26 > 0) goto L67;
        r27 = 0.0f;
        goto L72
    L67:
        Map r30 = z3.b();
        float r31 = 4.5f;
        if (r30 == null) goto L70;
        r31 = z3.a(r30, "target_contrast", 4.5f);
    L70:
        r27 = RangesKt.coerceIn((((0.05f + r26) * r31) - 1.05f) / (r31 * r26), 0.0f, 1.0f);
    L58:
        r25 = 0;
    L45:
        r14 = 0.0f;
    L37:
        r9 = "";
        goto L38
    L23:
        if (r6.isVSRoom() == true) goto L30;
        View r32 = this.a;
        if (r32 == null) goto L27;
        r32.setVisibility(0);
    L27:
        View r33 = this.b;
        if (r33 == null) goto L30;
        r33.setVisibility(0);
        goto L30
    L16:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L20;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L20;
        UIUtils.updateLayoutMargin(this.a, -3, -StatusBarUtil.getStatusBarHeight(getContext()), -3, -3);
        goto L20
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public ShadowServiceWidget() {
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L104;
        if (r7 == null) goto L9;
        String r1 = r7.getKey();
    L10:
        if (r1 == null) goto L105;
        int r2 = r1.hashCode();
        if (r2 == (-1540323875)) goto L52;
        if (r2 == (-1091008631)) goto L18;
        return;
    L18:
        if (r1.equals("cmd_multi_state_change") == false) goto L87;
        zg1.z0 r3 = (zg1.z0) r7.getData();
        if (r3 != null) goto L22;
    L39:
        zg1.z0 r8 = (zg1.z0) r7.getData();
        if (r8 != null) goto L42;
        return;
    L42:
        if (r8.a == 2) goto L44;
        return;
    L44:
        if (bg1.a() == false) goto L93;
        View r9 = this.a;
        if (r9 == null) goto L48;
        r9.setVisibility(this.c);
    L48:
        View r10 = this.b;
        if (r10 == null) goto L94;
        r10.setVisibility(this.d);
        return;
    L94:
        return;
    L93:
        return;
    L22:
        if (r3.a != 1) goto L39;
        View r11 = this.a;
        if (r11 == null) goto L26;
        int r12 = r11.getVisibility();
    L27:
        this.c = r12;
        View r13 = this.b;
        if (r13 == null) goto L30;
        int r14 = r13.getVisibility();
    L31:
        this.d = r14;
        if (bg1.a() == false) goto L88;
        View r15 = this.a;
        if (r15 == null) goto L36;
        r15.setVisibility(4);
    L36:
        View r16 = this.b;
        if (r16 == null) goto L89;
        r16.setVisibility(4);
        return;
    L89:
        return;
    L88:
        return;
    L30:
        r14 = 4;
        goto L31
    L26:
        r12 = 4;
        goto L27
    L87:
        return;
    L52:
        if (r1.equals("cmd_pk_state_change") == false) goto L96;
        zg1.z0 r4 = (zg1.z0) r7.getData();
        if (r4 != null) goto L56;
    L73:
        zg1.z0 r17 = (zg1.z0) r7.getData();
        if (r17 != null) goto L76;
        return;
    L76:
        if (r17.a == 1) goto L78;
        return;
    L78:
        if (bg1.a() == false) goto L102;
        View r18 = this.a;
        if (r18 == null) goto L82;
        r18.setVisibility(this.c);
    L82:
        View r19 = this.b;
        if (r19 == null) goto L103;
        r19.setVisibility(this.d);
        return;
    L103:
        return;
    L102:
        return;
    L56:
        if (r4.a != 0) goto L73;
        View r20 = this.a;
        if (r20 == null) goto L60;
        int r21 = r20.getVisibility();
    L61:
        this.c = r21;
        View r22 = this.b;
        if (r22 == null) goto L64;
        int r23 = r22.getVisibility();
    L65:
        this.d = r23;
        if (bg1.a() == false) goto L97;
        View r24 = this.a;
        if (r24 == null) goto L70;
        r24.setVisibility(4);
    L70:
        View r25 = this.b;
        if (r25 == null) goto L98;
        r25.setVisibility(4);
        return;
    L98:
        return;
    L97:
        return;
    L64:
        r23 = 4;
        goto L65
    L60:
        r21 = 4;
        goto L61
    L96:
        return;
    L105:
        return;
    L9:
        r1 = null;
        goto L10
    }
}
