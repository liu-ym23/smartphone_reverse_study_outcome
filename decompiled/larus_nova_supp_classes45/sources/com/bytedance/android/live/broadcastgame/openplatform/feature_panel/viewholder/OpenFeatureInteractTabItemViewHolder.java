package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder;

import a20.e;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.config.b30;
import com.bytedance.android.livesdk.config.d30;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import e20.a;
import e20.b;
import e20.c;
import f10.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/OpenFeatureInteractTabItemViewHolder;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/AbsOpenFeatureTabListItemViewHolder;", "Lf10/f;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureInteractTabItemViewHolder extends AbsOpenFeatureTabListItemViewHolder<f> {
    public static final /* synthetic */ int p = 0;
    public final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final HSImageView d;
    public final View e;
    public final View f;
    public final View g;
    public final View h;
    public final TextView i;
    public final ImageView j;
    public final RecyclerView k;
    public ObjectAnimator l;
    public final List<TextView> m;
    public final e n;
    public final boolean o;

    public final void U3() {
        if (this.o == true) goto L5;
        return;
    L5:
        UtilityKotlinExtentionsKt.u(this.i);
        UtilityKotlinExtentionsKt.w(this.j);
        ObjectAnimator r0 = this.l;
        if (r0 != null) goto L8;
    L12:
        this.i.setClickable(false);
        this.f.setClickable(false);
        return;
    L8:
        if (r0.isRunning() == true) goto L12;
        ObjectAnimator r1 = this.l;     // Catch: Exception -> L14
        if (r1 == null) goto L12;
        r1.start();     // Catch: Exception -> L14
        goto L12
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder
    public final void T3(f r13) {
        f r14 = r13;
        Intrinsics.checkNotNullParameter(r14, "item");
        e r0 = this.n;
        int r1 = getAdapterPosition();
        this.b.setText(r14.i(false));
        GenericDraweeHierarchy r2 = this.d.getHierarchy();
        this.d.setActualImageResource(((ExtendedToolbarButton.c) r14).i);
        r2.setPlaceholderImage(((ExtendedToolbarButton.c) r14).i);
        r2.setFailureImage(((ExtendedToolbarButton.c) r14).i);
        this.i.setTag("button");
        this.d.setHierarchy(r2);
        TextView r3 = this.c;
        if (r3 == null) goto L5;
        r3.setText(r14.C);
    L5:
        List<v> r4 = r14.E;
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L19;
        UtilityKotlinExtentionsKt.t(this.k);
        Iterator r6 = ((ArrayList) this.m).iterator();
    L16:
        if (r6.hasNext() == false) goto L57;
        UtilityKotlinExtentionsKt.t((TextView) r6.next());
    L57:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.j, LiveDegradeFpsAnimator.ROTATION, new float[]{0.0f, 360.0f});
        r7.setDuration(1000);
        r7.setRepeatCount(-1);
        r7.setInterpolator(new LinearInterpolator());
        Unit r8 = Unit.INSTANCE;
        this.l = r7;
        TextView r9 = this.i;
        if (r14.u == false) goto L60;
        r9.setText("退出");
        r9.setTextColor((int) 4294847573L);
        r9.setBackground(s1.m(2131249267));
    L67:
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L72;
        n r12 = r11.getDownLoadingInteractEffectId();
        if (r12 == null) goto L72;
        String r15 = (String) r12.getValue();
    L74:
        if (Intrinsics.areEqual(r15, ((ExtendedToolbarButton.c) r14).s) == false) goto L77;
        U3();
    L88:
        if ((!((ExtendedToolbarButton.c) r14).p.isEmpty()) == true) goto L90;
    L95:
        float r16 = 1.0f;
        if (r14.j() == false) goto L98;
        this.d.setAlpha(0.64f);
        this.b.setAlpha(0.64f);
        this.e.setAlpha(0.0f);
    L99:
        View r17 = this.f;
        if (a.a[((ExtendedToolbarButton) r14).f.ordinal()] != 1) goto L103;
        r16 = 0.5f;
    L103:
        r17.setAlpha(r16);
        if (r14.u == false) goto L107;
        UtilityKotlinExtentionsKt.v(this.g, true);
        UtilityKotlinExtentionsKt.v(this.e, false);
        UtilityKotlinExtentionsKt.v(this.h, false);
    L126:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L131;
        if (r0 != null) goto L136;
    L133:
        this.f.setOnClickListener(new c(this, r0, r14, r1));
        this.i.setOnClickListener(new b(this, r0, r14, r1));
        return;
    L136:
        r0.b(((RecyclerView.ViewHolder) this).itemView, r14, r1);     // Catch: Exception -> L130
    L130:
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L133
    L131:
        if (r0 == null) goto L133;
        r0.b(((RecyclerView.ViewHolder) this).itemView, r14, r1);
        goto L133
    L107:
        if (r14.v == false) goto L110;
        UtilityKotlinExtentionsKt.v(this.h, true);
        UtilityKotlinExtentionsKt.v(this.g, false);
        UtilityKotlinExtentionsKt.v(this.e, false);
        goto L126
    L110:
        if (r14.k() == false) goto L124;
        UtilityKotlinExtentionsKt.v(this.e, true);
        UtilityKotlinExtentionsKt.v(this.g, false);
        UtilityKotlinExtentionsKt.v(this.h, false);
        String r18 = r14.h();
        if (r18 == null) goto L126;
        if (r18.length() <= 0) goto L116;
        boolean r19 = true;
    L117:
        if (r19 == true) goto L120;
        r18 = null;
    L120:
        if (r18 == null) goto L126;
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L116:
        r19 = false;
        goto L117
    L124:
        UtilityKotlinExtentionsKt.v(this.g, false);
        UtilityKotlinExtentionsKt.v(this.e, false);
        UtilityKotlinExtentionsKt.v(this.h, false);
        goto L126
    L98:
        this.d.setAlpha(1.0f);
        this.b.setAlpha(1.0f);
        this.e.setAlpha(1.0f);
        goto L99
    L90:
        if (((CharSequence) ListProtector.get(((ExtendedToolbarButton.c) r14).p, 0)).length() <= 0) goto L92;
        boolean r21 = true;
    L93:
        if (r21 == false) goto L95;
        this.d.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(((ExtendedToolbarButton.c) r14).p, 0))).build());
        goto L95
    L92:
        r21 = false;
        goto L93
    L77:
        if (this.o == false) goto L88;
        UtilityKotlinExtentionsKt.w(this.i);
        UtilityKotlinExtentionsKt.t(this.j);
        ObjectAnimator r22 = this.l;
        if (r22 != null) goto L82;
    L86:
        this.i.setClickable(true);
        this.f.setClickable(true);
        goto L88
    L82:
        if (r22.isRunning() != true) goto L86;
        ObjectAnimator r23 = this.l;     // Catch: Exception -> L135
        if (r23 == null) goto L86;
        r23.end();     // Catch: Exception -> L135
    L72:
        r15 = null;
        goto L74
    L60:
        k0 r24 = r14.F;
        if (r24 == null) goto L65;
        String r25 = r24.text;
        if (r25 == null) goto L65;
    L66:
        r9.setText(r25);
        r9.setTextColor(-1);
        r9.setBackground(s1.m(2131249268));
    L65:
        r25 = "打开";
        goto L66
    L19:
        if (((Boolean) b30.a.getValue()).booleanValue() == true) goto L27;
        this.k.setLayoutManager(new LinearLayoutManager(((RecyclerView.ViewHolder) this).itemView.getContext(), 0, false));
        if (this.k.getItemDecorationCount() > 0) goto L23;
        this.k.addItemDecoration(new OpenFeatureInteractTabItemViewHolder$bindInteractItemViewHolder$2());
    L23:
        UtilityKotlinExtentionsKt.w(this.k);
        RecyclerView r26 = this.k;
        List<v> r27 = r14.E;
        if (r27 != null) goto L26;
        r27 = CollectionsKt.emptyList();
    L26:
        r26.setAdapter(new TagViewAdapter(r27));
        goto L57
    L27:
        UtilityKotlinExtentionsKt.t(this.k);
        int r28 = ((Integer) d30.a.getValue()).intValue();
        List<v> r29 = r14.E;
        if (r29 == null) goto L30;
        int r31 = r29.size();
    L31:
        int r32 = Math.min(r28, r31);
        int r33 = 0;
    L32:
        if (r33 >= r32) goto L54;
        if (((ArrayList) this.m).size() <= r33) goto L36;
        TextView r34 = (TextView) ListProtector.get(this.m, r33);
    L37:
        List<v> r110 = r14.E;
        if (r110 == null) goto L52;
        v r111 = (v) ListProtector.get(r110, r33);
        if (r111 == null) goto L52;
        String r112 = r111.text;
        if (r112 == null) goto L52;
        if (r112.length() <= 0) goto L46;
        boolean r113 = true;
    L47:
        if (r113 == true) goto L50;
        r112 = null;
    L50:
        if (r112 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r34);
        r34.setText(r112);
    L53:
        r33 = r33 + 1;
        goto L32
    L46:
        r113 = false;
    L52:
        UtilityKotlinExtentionsKt.t(r34);
        goto L53
    L36:
        r34 = new TextView(((RecyclerView.ViewHolder) this).itemView.getContext());
        r34.setEllipsize(TextUtils.TruncateAt.END);
        r34.setMaxLines(1);
        int r114 = UtilityKotlinExtentionsKt.i(3);
        int r115 = ColorProtector.parseColor("#57F1F1F1");
        r34.setPadding(r114, 0, r114, 0);
        r34.setTextColor(r115);
        r34.setTextSize(2, 10.0f);
        r34.setBackgroundResource(2131249269);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.leftMargin = UtilityKotlinExtentionsKt.i(4);
        this.a.addView(r34, r116);
        ((ArrayList) this.m).add(r34);
        goto L37
    L54:
        int r35 = ((ArrayList) this.m).size();
    L55:
        if (r32 >= r35) goto L57;
        UtilityKotlinExtentionsKt.t((View) ListProtector.get(this.m, r32));
        r32 = r32 + 1;
        goto L55
    L30:
        r31 = 0;
        goto L31
    L8:
        if (r4.isEmpty() == true) goto L11;
        r5 = false;
        goto L13
    }

    public OpenFeatureInteractTabItemViewHolder(View r2, e r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.n = r3;
        this.o = r4;
        this.a = (LinearLayout) r2.findViewById(2131388881);
        this.b = (TextView) r2.findViewById(2131391748);
        this.c = (TextView) r2.findViewById(2131391751);
        this.d = (HSImageView) r2.findViewById(2131374757);
        this.e = r2.findViewById(2131384095);
        this.f = r2.findViewById(2131362039);
        this.g = r2.findViewById(2131369392);
        this.h = r2.findViewById(2131364174);
        this.i = (TextView) r2.findViewById(2131364602);
        this.j = (ImageView) r2.findViewById(2131378998);
        this.k = r2.findViewById(2131388128);
        this.m = new ArrayList();
    }
}
