package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.config.bf;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LandscapeVideoQualityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/ui/LandscapeVideoQualityViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeVideoQualityAdapter extends RecyclerView.Adapter<LandscapeVideoQualityViewHolder> {
    public final int a;
    public final Context b;
    public final Room c;
    public final DataCenter d;
    public final Function1<String, Unit> e;
    public final Function0<Unit> f;

    public final StreamUrl z2() {
        if (RoomContext.a.c(RoomContext.Companion, this.d, 0, 2) == null) goto L20;
        nm1.m r0 = pm1.f.l();
        if (r0 == null) goto L19;
        if (r0.a(this.d) != true) goto L19;
        nm1.m r1 = pm1.f.l();
        if (r1 == null) goto L22;
        VSCameraInfo r2 = r1.K(this.d);
        if (r2 == null) goto L22;
        IBaseStreamUrl r3 = r2.streamUrl;
        if (r3 == null) goto L22;
        StreamUrl r4 = (StreamUrl) com.bytedance.android.live.base.model.m.b(r3, StreamUrl.class);
        if (r4 == null) goto L22;
        return r4;
    L22:
        return this.c.getStreamUrl();
    L19:
        return this.c.getStreamUrl();
    L20:
        return this.c.getStreamUrl();
    }

    public final int getItemCount() {
        return AudienceVideoResolutionManager.h().size();
    }

    public static final void y2(LandscapeVideoQualityAdapter r14, String r15) {
        r14.getClass();
        LiveCoreSDKData.Quality r0 = AudienceVideoResolutionManager.e();
        Object r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getName();
    L7:
        if (Intrinsics.areEqual(r15, r2) == false) goto L14;
        int r3 = AudienceVideoResolutionManager.a;
        if (AudienceVideoResolutionManager.o() == false) goto L11;
        com.bytedance.android.live.core.utils.f2.c("成功切换到" + r15, 0);
    L11:
        r14.e.invoke(r15);
        DataCenter r16 = r14.d;
        if (r16 == null) goto L97;
        r16.put("cmd_switch_resolution_success", 0);
        return;
    L97:
        return;
    L14:
        nm1.m r4 = pm1.f.l();
        if (r4 != null) goto L17;
    L25:
        Room r5 = r14.c;
    L26:
        if (r5 != null) goto L28;
    L44:
        LiveCoreSDKData.Quality r12 = null;
    L45:
        if (r5 != null) goto L47;
    L52:
        String r10 = null;
    L53:
        if (r5 != null) goto L55;
    L60:
        String r11 = null;
    L61:
        Iterator r6 = AudienceVideoResolutionManager.b.iterator();
    L63:
        if (r6.hasNext() == false) goto L71;
        Object r7 = r6.next();
        String r8 = ((LiveCoreSDKData.Quality) r7).sdkKey;
        ILivePlayerClient r9 = LivePlatformPlayerManager.f();
        if (r9 == null) goto L67;
        String r13 = r9.getCurrentResolution();
    L69:
        if (Intrinsics.areEqual(r8, r13) == false) goto L63;
        r1 = r7;
        goto L71
    L67:
        r13 = null;
    L71:
        LiveCoreSDKData.Quality r17 = (LiveCoreSDKData.Quality) r1;
        if (r17 != null) goto L74;
        r17 = AudienceVideoResolutionManager.c;
    L74:
        int r18 = AudienceVideoResolutionManager.a;
        String r19 = "auto";
        if (AudienceVideoResolutionManager.o() == false) goto L77;
        String r20 = "auto";
    L79:
        if (Intrinsics.areEqual(r15, PlayerResolution.Item.getAuto().getName()) == true) goto L82;
        r19 = "manual";
    L82:
        AudienceVideoResolutionManager.t(r15, r17, "landscape_user_select", r20, r19);
        xs2.b.a().post(new cs0.c(r15, r10, r11, r12, "landscape_user_select"));
        r14.notifyDataSetChanged();
        RoomContext r21 = RoomContext.a.c(RoomContext.Companion, r14.d, 0, 2);
        if (r21 != null) goto L85;
    L89:
        r14.e.invoke(r15);
        return;
    L85:
        if (r21.isVSRoom() != true) goto L89;
        DataCenter r22 = r14.d;
        if (r22 == null) goto L89;
        r22.put("data_target_resolution", r15);
        goto L89
    L77:
        r20 = "manual";
        goto L79
    L55:
        if (r5.isMultiPullDataValid() == false) goto L58;
        r5 = null;
    L58:
        if (r5 == null) goto L60;
        r11 = r5.getSdkParams(r15);
        goto L61
    L47:
        if (r5.isMultiPullDataValid() == true) goto L49;
        Room r23 = r5;
    L50:
        if (r23 == null) goto L52;
        r10 = r23.buildPullUrl(r15);
        goto L53
    L49:
        r23 = null;
        goto L50
    L28:
        if (r5.isMultiPullDataValid() == false) goto L30;
        Room r24 = r5;
    L31:
        if (r24 == null) goto L44;
        ArrayList r25 = AudienceVideoResolutionManager.b;
        if (r25 == null) goto L42;
        Iterator r26 = r25.iterator();
    L36:
        if (r26.hasNext() == false) goto L40;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((LiveCoreSDKData.Quality) r27).getName(), r15) == false) goto L36;
    L41:
        LiveCoreSDKData.Quality r28 = (LiveCoreSDKData.Quality) r27;
    L43:
        r12 = r28;
        goto L45
    L40:
        r27 = null;
        goto L41
    L42:
        r28 = null;
        goto L43
    L30:
        r24 = null;
        goto L31
    L17:
        if (r4.a(r14.d) != true) goto L25;
        DataCenter r29 = r14.d;
        StreamUrl r30 = r14.z2();
        RoomContext r31 = RoomContext.a.c(RoomContext.Companion, r14.d, 0, 2);
        if (r31 == null) goto L23;
        com.bytedance.live.datacontext.m r32 = r31.getCameraId();
        if (r32 == null) goto L23;
        Long r33 = (Long) r32.getValue();
    L24:
        r5 = com.bytedance.android.live.core.utils.z.a(r29, r30, r33);
    L23:
        r33 = null;
        goto L24
    L5:
        r2 = null;
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        LandscapeVideoQualityViewHolder r14 = (LandscapeVideoQualityViewHolder) r12;
        Intrinsics.checkNotNullParameter(r14, "holder");
        l5 r15 = (l5) ListProtector.get(AudienceVideoResolutionManager.h(), r13);
        LiveCoreSDKData.Quality r0 = AudienceVideoResolutionManager.c();
        if (r0 != null) goto L5;
    L6:
        StreamUrl r1 = this.c.getStreamUrl();
        if (r1 == null) goto L9;
        r1.getDefaultQuality();
    L9:
        Function1<String, Unit> r2 = new AnonymousClass1(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "onSelectListener");
        boolean r3 = false;
        CharSequence r5 = "";
        View r6 = null;
        if (r15 != null) goto L12;
    L13:
        if (r15 == null) goto L15;
        String r8 = r15.g;
    L17:
        if (Intrinsics.areEqual(r8, "fhd") == false) goto L19;
    L18:
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526)).setText("音画增强");
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784)).setText("");
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784));
    L42:
        if (r15 == null) goto L51;
        String r7 = r15.k;
        if (r7 == null) goto L51;
        if (r7.length() <= 0) goto L48;
        boolean r9 = true;
    L49:
        if (r9 != true) goto L51;
        String r10 = r15.k;
    L59:
        if (r10.length() != 0) goto L61;
        boolean r11 = true;
    L63:
        if (r11 == false) goto L65;
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131385704));
    L66:
        if (r15 == null) goto L72;
        c8 r16 = r15.i;
        if (r16 == null) goto L72;
        if (r16.a != true) goto L72;
        Integer r17 = 2131250085;
    L86:
        if (r17 == null) goto L88;
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383525));
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383525).setActualImageResource(r17.intValue());
    L89:
        if (r15 == null) goto L96;
        if (Intrinsics.areEqual(r15.e, "disable") == false) goto L94;
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526)).setAlpha(0.3f);
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526));
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784)).setAlpha(0.3f);
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784));
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131385704)).setAlpha(0.3f);
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(b7.a);
        goto L96
    L94:
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526)).setAlpha(1.0f);
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526));
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784)).setAlpha(1.0f);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131385704)).setAlpha(0.5f);
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784));
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new c7(r14, r15, r2));
    L96:
        if (r14.a.landscapeDialogUseNewStyle() == false) goto L106;
        if (r15 == null) goto L106;
        String r4 = r15.c;
        if (r4 == null) goto L106;
        if (r4.length() != 0) goto L103;
        r3 = true;
    L103:
        if (r3 != true) goto L106;
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784));
    L106:
        if (Intrinsics.areEqual(r15.e, "selected") == false) goto L108;
        r14.T3(r15);
        return;
    L108:
        int r18 = com.bytedance.android.live.core.utils.s1.h(2131108569);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526)).setTextColor(r18);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784)).setTextColor(r18);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131385704)).setTextColor(r18);
        ((RecyclerView.ViewHolder) r14).itemView.setBackgroundResource(2131249865);
        View r19 = ((RecyclerView.ViewHolder) r14).itemView;
        StringBuilder r20 = new StringBuilder();
        View r21 = ((RecyclerView.ViewHolder) r14).itemView;
        if (r21 == null) goto L111;
        View r22 = r21.findViewById(2131383526);
    L112:
        TextView r23 = (TextView) r22;
        if (r23 == null) goto L116;
        CharSequence r24 = r23.getText();
        if (r24 == null) goto L116;
    L117:
        r20.append(r24);
        View r25 = ((RecyclerView.ViewHolder) r14).itemView;
        if (r25 == null) goto L120;
        View r26 = r25.findViewById(2131381784);
    L121:
        TextView r27 = (TextView) r26;
        if (r27 == null) goto L125;
        CharSequence r28 = r27.getText();
        if (r28 == null) goto L125;
    L126:
        r20.append(r28);
        View r110 = ((RecyclerView.ViewHolder) r14).itemView;
        if (r110 == null) goto L129;
        r6 = r110.findViewById(2131385704);
    L129:
        TextView r29 = (TextView) r6;
        if (r29 == null) goto L135;
        CharSequence r111 = r29.getText();
        if (r111 == null) goto L135;
        r5 = r111;
    L135:
        r20.append(r5);
        r20.append("按钮");
        r19.setContentDescription(r20.toString());
        return;
    L125:
        r28 = "";
        goto L126
    L120:
        r26 = null;
    L116:
        r24 = "";
        goto L117
    L111:
        r22 = null;
        goto L112
    L88:
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383525));
    L72:
        if (r15 != null) goto L74;
    L84:
        r17 = null;
        goto L86
    L74:
        if (r15.f == false) goto L84;
        c8 r30 = r15.i;
        if (r30 == null) goto L84;
        if (r30.b == true) goto L84;
        if (Intrinsics.areEqual(r15.b, "uhd") == false) goto L82;
    L83:
        r17 = 2131250086;
        goto L86
    L82:
        if (Intrinsics.areEqual(r15.g, "uhd") == false) goto L84;
    L65:
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131385704));
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131385704)).setText(r10);
        goto L66
    L61:
        r11 = false;
        goto L63
    L48:
        r9 = false;
    L51:
        if (r15 == null) goto L53;
        int r31 = r15.d;
    L55:
        if (r31 <= bf.a.getValue().e()) goto L57;
        r10 = "高帧率";
        goto L59
    L57:
        r10 = "";
        goto L59
    L53:
        r31 = 0;
        goto L55
    L19:
        TextView r32 = (TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131383526);
        if (r15 == null) goto L24;
        String r33 = r15.b;
        if (r33 == null) goto L24;
    L25:
        r32.setText(r33);
        TextView r34 = (TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784);
        if (r15 == null) goto L30;
        String r35 = r15.c;
        if (r35 == null) goto L30;
    L31:
        r34.setText(r35);
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784));
        if (r14.a.landscapeDialogUseNewStyle() == false) goto L42;
        if (r15 == null) goto L42;
        String r36 = r15.c;
        if (r36 == null) goto L42;
        if (r36.length() != 0) goto L39;
        boolean r37 = true;
    L40:
        if (r37 != true) goto L42;
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r14).itemView.findViewById(2131381784));
        goto L42
    L39:
        r37 = false;
    L30:
        r35 = "";
    L24:
        r33 = "";
        goto L25
    L15:
        r8 = null;
        goto L17
    L12:
        if (Intrinsics.areEqual(r15.b, "fhd") == true) goto L18;
    L5:
        if (r0.getName() != null) goto L9;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LandscapeVideoQualityViewHolder(LayoutInflater.from(this.b).inflate(this.a, r4, false));
    }

    public LandscapeVideoQualityAdapter(Context r2, Room r3, DataCenter r4, Function1 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r5, "onSelectListener");
        Intrinsics.checkNotNullParameter(r6, "dismissAction");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        LiveCoreSDKData.Quality r7 = AudienceVideoResolutionManager.c();
        if (r7 != null) goto L5;
    L6:
        StreamUrl r8 = z2();
        if (r8 == null) goto L10;
        r8.getDefaultQuality();
    L10:
        if (((SwitchResolutionDialogConfig) com.bytedance.android.livesdk.f3.a.getValue()).landscapeDialogUseNewStyle() == false) goto L12;
        int r9 = 2131566406;
    L13:
        this.a = r9;
        return;
    L12:
        r9 = 2131566405;
        goto L13
    L5:
        if (r7.getName() != null) goto L10;
        goto L6
    }
}
