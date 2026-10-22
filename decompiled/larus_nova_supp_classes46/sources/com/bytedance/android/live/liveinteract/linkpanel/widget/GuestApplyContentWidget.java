package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.IncreasePriceApplyDialog;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.config.w71;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/GuestApplyContentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lvlc/l;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestApplyContentWidget extends LiveWidget implements vlc.l {
    public WidgetManager a;
    public BannerWidget b;
    public RecyclerView c;
    public FrameLayout d;
    public TextView e;
    public HSImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public boolean l;
    public boolean m;
    public int n;
    public final MultiTypeAdapter o;
    public final CompositeDisposable p;
    public final GuestApplyViewModel q;
    public final IRoom r;
    public final xf0.a s;

    public static final class a implements Runnable {
        public final /* synthetic */ GuestApplyContentWidget a;

        public a(GuestApplyContentWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GuestApplyContentWidget r0 = this.a;     // Catch: Throwable -> L8
            if (((Widget) r0).contentView == null) goto L11;
            WidgetManager r1 = r0.a;     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.load(2131372686, r0.b);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ GuestApplyContentWidget a;

        public b(GuestApplyContentWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r21) {
            n0 r1 = (n0) r21;
            String r3 = "-";
            if (r1 == null) goto L287;
            GuestApplyContentWidget r4 = this.a;
            r4.getClass();
            IBaseUser r5 = r1.getUserFlex();
            if (r5 == null) goto L7;
            py.k r7 = r5.getAvatarThumbKt();
        L8:
            PipelineDraweeControllerBuilder r8 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r7, -1)).setAutoPlayAnimations(false);
            HSImageView r9 = r4.f;
            if (r9 == null) goto L11;
            DraweeController r10 = r9.getController();
        L12:
            AbstractDraweeController r11 = r8.setOldController(r10).build();
            HSImageView r12 = r4.f;
            if (r12 == null) goto L15;
            r12.setController(r11);
        L15:
            TextView r13 = r4.g;
            if (r13 == null) goto L21;
            if (r5 == null) goto L19;
            String r6 = r5.getNickName();
        L20:
            r13.setText(r6);
            goto L21
        L19:
            r6 = null;
        L21:
            String r14 = "line_up";
            String r15 = "0";
            if (hd0.c.f().j() == false) goto L253;
            int r2 = r4.zq(r1);
            if (r2 != 0) goto L26;
            r2 = (int) r1.getOffset();
        L26:
            TextView r16 = r4.e;
            if (r16 == null) goto L35;
            if (r2 < 1000) goto L30;
            String r17 = "999+";
        L34:
            r16.setText(r17);
            goto L35
        L30:
            if (r2 == 0) goto L33;
            r3 = String.valueOf(r2);
        L33:
            r17 = r3;
        L35:
            TextView r18 = r4.h;
            if (r18 == null) goto L39;
            r18.setVisibility(0);
        L39:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(r4.r) == true) goto L41;
        L118:
            r14 = "line_up";
            TextView r19 = r4.i;
            if (r19 == null) goto L121;
            UtilityKotlinExtentionsKt.w(r19);
        L121:
            TextView r20 = r4.j;
            if (r20 == null) goto L124;
            UtilityKotlinExtentionsKt.w(r20);
        L124:
            TextView r22 = r4.k;
            if (r22 == null) goto L127;
            UtilityKotlinExtentionsKt.w(r22);
        L127:
            Integer r23 = (Integer) b6.B.getValue();
            boolean r24 = w71.a();
            if (r24 == false) goto L149;
            if (r23 == null) goto L149;
            if (r23.intValue() != 41) goto L149;
            TextView r25 = r4.h;
            if (r25 == null) goto L189;
            String r26 = r1.getFanTicket();
            if (r26 != null) goto L138;
        L141:
            boolean r27 = true;
        L142:
            if (r27 == false) goto L144;
            String r28 = s1.C(2131922631, new Object[]{0});
        L148:
            r25.setText(r28);
            goto L189
        L144:
            Object[] r29 = new Object[1];
            String r30 = r1.getFanTicket();
            if (r30 != null) goto L147;
            r30 = "0";
        L147:
            r29[0] = Integer.valueOf(CastIntegerProtector.parseInt(r30));
            r28 = s1.C(2131922631, r29);
            goto L148
        L138:
            if (StringsKt.isBlank(r26) == true) goto L141;
            r27 = false;
        L189:
            TextView r31 = r4.i;
            if (r31 == null) goto L192;
            r31.setBackgroundResource(2131249467);
        L192:
            TextView r32 = r4.i;
            if (r32 == null) goto L196;
            r32.setClickable(true);
        L196:
            if (r1.getPaidAmount() > 0) goto L198;
        L229:
            String r33 = r14;
            r4.l = false;
            TextView r34 = r4.i;
            if (r34 == null) goto L232;
            r34.setText(s1.B(2131917774));
        L232:
            TextView r35 = r4.j;
            if (r35 == null) goto L235;
            UtilityKotlinExtentionsKt.w(r35);
        L235:
            TextView r36 = r4.k;
            if (r36 == null) goto L239;
            UtilityKotlinExtentionsKt.w(r36);
        L239:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() != 4) goto L241;
            boolean r37 = true;
        L242:
            if (r37 == false) goto L252;
            TextView r38 = r4.i;
            if (r38 == null) goto L246;
            UtilityKotlinExtentionsKt.u(r38);
        L246:
            TextView r39 = r4.j;
            if (r39 == null) goto L249;
            UtilityKotlinExtentionsKt.u(r39);
        L249:
            TextView r40 = r4.k;
            if (r40 == null) goto L252;
            UtilityKotlinExtentionsKt.u(r40);
        L252:
            tc0.c.h().P = r1;
        L260:
            if (this.a.m == false) goto L262;
            return;
        L262:
            if (hd0.c.f().j() == true) goto L264;
            return;
        L264:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(this.a.r) == false) goto L301;
            this.a.getClass();
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L302;
            GuestApplyContentWidget r41 = this.a;
            r41.m = true;
            GuestApplyViewModel r42 = r41.q;
            if (r42 != null) goto L270;
            return;
        L270:
            if (r42.getLineUp() == null) goto L304;
            IRoom r43 = this.a.r;
            if (r43 == null) goto L275;
            String r44 = r43.getOwnerUserIdString();
            if (r44 == null) goto L275;
        L276:
            IRoom r45 = this.a.r;
            if (r45 == null) goto L279;
            Long r46 = Long.valueOf(r45.getId());
        L280:
            String r47 = String.valueOf(r46);
            Intrinsics.checkNotNullParameter(r44, "anchorId");
            Intrinsics.checkNotNullParameter(r47, "roomId");
            LinkedHashMap r48 = new LinkedHashMap();
            com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r48);
            com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r48, null, 6);
            l0.e(r48);
            r48.put("anchor_id", r44);
            r48.put("room_id", r47);
            r48.put("play_mode", com.bytedance.android.live.liveinteract.linkpanel.util.w.c());
            r48.put("time", String.valueOf(com.bytedance.android.live.liveinteract.linkpanel.util.w.b()));
            r48.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.linkpanel.util.w.a()));
            n0 r49 = tc0.c.h().P;
            if (r49 == null) goto L286;
            String r50 = String.valueOf(r49.getOffset());
            if (r50 == null) goto L286;
            r15 = r50;
        L286:
            r48.put(r33, r15);
            j0.l().sendLog("livesdk_guest_connection_rechargeble_premium_icon", r48, new Object[]{IRoom.class, am2.x.class});
            return;
        L279:
            r46 = null;
        L275:
            r44 = "";
            goto L276
        L304:
            return;
        L302:
            return;
        L301:
            return;
        L241:
            r37 = false;
            goto L242
        L198:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.z() == true) goto L229;
            TextView r51 = r4.i;
            if (r51 == null) goto L202;
            r51.setText(s1.B(2131919171));
        L202:
            TextView r52 = r4.j;
            if (r52 == null) goto L205;
            UtilityKotlinExtentionsKt.t(r52);
        L205:
            TextView r53 = r4.k;
            if (r53 == null) goto L208;
            UtilityKotlinExtentionsKt.t(r53);
        L208:
            TextView r54 = r4.i;
            if (r54 == null) goto L211;
            r54.setClickable(false);
        L211:
            TextView r55 = r4.i;
            if (r55 == null) goto L215;
            r55.setBackgroundResource(2131249221);
        L215:
            if (r4.l == false) goto L216;
        L117:
            r33 = r14;
            goto L252
        L216:
            r4.l = true;
            long r56 = r4.xq();
            GuestApplyViewModel r57 = r4.q;
            if (r57 == null) goto L223;
            LiveData<n0> r58 = r57.getUserWaitingData();
            if (r58 == null) goto L223;
            n0 r59 = (n0) r58.getValue();
            if (r59 == null) goto L223;
            long r60 = r59.getPaidAmount();
        L224:
            LinkedHashMap r61 = new LinkedHashMap();
            com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r61);
            com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r61, null, 6);
            l0.e(r61);
            r33 = r14;
            r61.put(r33, String.valueOf(r56));
            if (r60 <= 0) goto L227;
            String r62 = "priority";
        L228:
            r61.put("user_tab", r62);
            r61.put("function_type2", "live");
            j0.l().sendLog("livesdk_audience_connection_priority_button_show", r61, new Object[]{IRoom.class});
            goto L252
        L227:
            r62 = "normal";
        L223:
            r60 = 0;
        L149:
            if (r24 == false) goto L179;
            if (r23 == null) goto L179;
            if (r23.intValue() != 42) goto L179;
            String r63 = r1.getFanTicket();
            if (r63 != null) goto L157;
        L160:
            boolean r65 = true;
        L161:
            if (r65 == false) goto L163;
            boolean r66 = true;
            String r67 = s1.C(2131922631, new Object[]{0});
        L168:
            if (r1.isAddPrice() != r66) goto L170;
            Long r68 = Long.valueOf(r1.getAddPriceTime());
        L171:
            TextView r69 = r4.h;
            if (r69 == null) goto L189;
            StringBuilder r110 = new StringBuilder();
            Context r111 = s1.getContext();
            if (r68 == null) goto L176;
            long r70 = r68.longValue();
        L177:
            r110.append(GuestApplyContentWidget.yq(r1, com.bytedance.android.live.liveinteract.linkpanel.util.o.e(r111, r70, tc0.c.h().Q * ((long) 1000))));
            r110.append(" | ");
            r110.append(r67);
            r69.setText(r110.toString());
            goto L189
        L176:
            r70 = 0;
            goto L177
        L170:
            r68 = Long.valueOf(r1.getModifyTime() * ((long) 1000));
            goto L171
        L163:
            r66 = true;
            Object[] r71 = new Object[1];
            String r72 = r1.getFanTicket();
            if (r72 != null) goto L166;
            r72 = "0";
        L166:
            r71[0] = Integer.valueOf(CastIntegerProtector.parseInt(r72));
            r67 = s1.C(2131922631, r71);
            goto L168
        L157:
            if (StringsKt.isBlank(r63) == true) goto L160;
            r65 = false;
        L179:
            if (r1.isAddPrice() != true) goto L181;
            Long r73 = Long.valueOf(r1.getAddPriceTime());
        L182:
            TextView r74 = r4.h;
            if (r74 == null) goto L189;
            Context r75 = s1.getContext();
            if (r73 == null) goto L187;
            long r76 = r73.longValue();
        L188:
            r74.setText(GuestApplyContentWidget.yq(r1, com.bytedance.android.live.liveinteract.linkpanel.util.o.e(r75, r76, tc0.c.h().Q * ((long) 1000))));
            goto L189
        L187:
            r76 = 0;
            goto L188
        L181:
            r73 = Long.valueOf(r1.getModifyTime() * ((long) 1000));
            goto L182
        L41:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L118;
            TextView r77 = r4.i;
            if (r77 == null) goto L46;
            UtilityKotlinExtentionsKt.w(r77);
        L46:
            if (r1.isAddPrice() != true) goto L60;
            TextView r78 = r4.h;
            if (r78 == null) goto L51;
            r78.setText(com.bytedance.android.live.liveinteract.linkpanel.util.o.f(s1.getContext(), r1.getAddPriceTime(), tc0.c.h().Q * ((long) 1000)));
        L51:
            TextView r79 = r4.i;
            if (r79 == null) goto L54;
            r79.setBackgroundResource(2131249221);
        L54:
            TextView r80 = r4.i;
            if (r80 == null) goto L57;
            r80.setClickable(false);
        L57:
            TextView r81 = r4.i;
            if (r81 == null) goto L117;
            r81.setText(s1.B(2131919307));
            goto L117
        L60:
            r14 = "line_up";
            Integer r82 = (Integer) b6.B.getValue();
            if (r82 != null) goto L64;
        L81:
            TextView r83 = r4.h;
            if (r83 == null) goto L84;
            long r112 = 1000;
            r83.setText(com.bytedance.android.live.liveinteract.linkpanel.util.o.e(s1.getContext(), r1.getModifyTime() * r112, tc0.c.h().Q * r112));
            r4 = r4;
        L84:
            GuestApplyViewModel r84 = r4.q;
            if (r84 == null) goto L96;
            LiveData<List<Object>> r85 = r84.getWaitingListData();
            if (r85 == null) goto L96;
            List r86 = (List) r85.getValue();
            if (r86 == null) goto L96;
            Iterator<T> r87 = r86.iterator();
            int r88 = 0;
        L92:
            if (r87.hasNext() == false) goto L98;
            if ((r87.next() instanceof n0) == false) goto L92;
            r88 = r88 + 1;
        L98:
            if (r88 <= 1) goto L108;
            TextView r89 = r4.i;
            if (r89 == null) goto L102;
            r89.setBackgroundResource(2131249467);
        L102:
            TextView r90 = r4.i;
            if (r90 == null) goto L105;
            r90.setClickable(true);
        L105:
            TextView r91 = r4.i;
            if (r91 == null) goto L117;
            r91.setText(s1.B(2131919314));
            goto L117
        L108:
            TextView r92 = r4.i;
            if (r92 == null) goto L111;
            r92.setBackgroundResource(2131249221);
        L111:
            TextView r93 = r4.i;
            if (r93 == null) goto L114;
            r93.setClickable(false);
        L114:
            TextView r94 = r4.i;
            if (r94 == null) goto L117;
            r94.setText(s1.B(2131919314));
        L96:
            r88 = 0;
            goto L98
        L64:
            if (r82.intValue() != 41) goto L81;
            TextView r95 = r4.h;
            if (r95 == null) goto L84;
            String r96 = r1.getFanTicket();
            if (r96 != null) goto L70;
        L73:
            boolean r97 = true;
        L74:
            if (r97 == false) goto L76;
            String r98 = s1.C(2131922631, new Object[]{0});
        L80:
            r95.setText(r98);
            goto L84
        L76:
            Object[] r99 = new Object[1];
            String r100 = r1.getFanTicket();
            if (r100 != null) goto L79;
            r100 = "0";
        L79:
            r99[0] = Integer.valueOf(CastIntegerProtector.parseInt(r100));
            r98 = s1.C(2131922631, r99);
            goto L80
        L70:
            if (StringsKt.isBlank(r96) == true) goto L73;
            r97 = false;
            goto L74
        L253:
            r33 = "line_up";
            TextView r101 = r4.e;
            if (r101 == null) goto L256;
            r101.setText("-");
        L256:
            TextView r102 = r4.h;
            if (r102 == null) goto L260;
            r102.setVisibility(8);
            goto L260
        L11:
            r10 = null;
            goto L12
        L7:
            r7 = null;
            goto L8
        L287:
            SimpleDateFormat r103 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
            TextView r104 = this.a.e;
            if (r104 == null) goto L290;
            r104.setText("-");
        L290:
            TextView r105 = this.a.h;
            if (r105 == null) goto L306;
            r105.setVisibility(8);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ GuestApplyContentWidget a;

        public c(GuestApplyContentWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            List r6 = (List) r5;
            GuestApplyContentWidget r0 = this.a;
            if (r6 == null) goto L46;
            r0.getClass();
            if (r6.isEmpty() == false) goto L9;
            FrameLayout r2 = r0.d;
            if (r2 == null) goto L15;
            r2.setVisibility(0);
        L15:
            r0.o.a = r6;
            RecyclerView r1 = r0.c;
            if (r1 != null) goto L18;
        L24:
            t61 r3 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
            if (r3 != null) goto L27;
        L31:
            new Handler(Looper.getMainLooper()).post(new com.bytedance.android.live.liveinteract.linkpanel.widget.f(r0, r6));
        L32:
            Map<String, cm2.a> r4 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
            if (com.bytedance.android.live.liveinteract.linkpanel.util.p.a("apply_panel") == true) goto L53;
            com.bytedance.android.live.liveinteract.linkpanel.util.p.i("apply_panel");
            RecyclerView r7 = r0.c;
            if (r7 == null) goto L41;
            RecyclerView.Adapter r8 = r7.getAdapter();
            if (r8 == null) goto L41;
            if (r8.getItemCount() != 0) goto L41;
            com.bytedance.android.live.liveinteract.linkpanel.util.p.e("apply_panel");
            return;
        L41:
            RecyclerView r9 = r0.c;
            if (r9 == null) goto L55;
            ViewTreeObserver r10 = r9.getViewTreeObserver();
            if (r10 == null) goto L56;
            r10.addOnGlobalLayoutListener(new g(r0, r6));
            return;
        L56:
            return;
        L55:
            return;
        L53:
            return;
        L27:
            if (u61.c(r3) != true) goto L31;
            View r11 = ((Widget) r0).contentView;
            if (r11 == null) goto L32;
            r11.post(new com.bytedance.android.live.liveinteract.linkpanel.widget.e(r0, r6));
            goto L32
        L18:
            if (r1.isComputingLayout() == true) goto L24;
            RecyclerView r12 = r0.c;
            if (r12 == null) goto L24;
            if (r12.getScrollState() != 0) goto L24;
            r0.o.notifyDataSetChanged();
            goto L32
        L9:
            FrameLayout r13 = r0.d;
            if (r13 == null) goto L12;
            r13.setVisibility(8);
        L12:
            RecyclerView r14 = r0.c;
            if (r14 == null) goto L15;
            r14.setVisibility(0);
            goto L15
        L46:
            FrameLayout r15 = r0.d;
            if (r15 == null) goto L49;
            r15.setVisibility(0);
        L49:
            RecyclerView r16 = r0.c;
            if (r16 == null) goto L58;
            r16.setVisibility(4);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ GuestApplyContentWidget a;

        public d(GuestApplyContentWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            int r5 = GuestApplyContentWidget.wq(this.a);
            if (hd0.c.f().j() == false) goto L13;
            GuestApplyContentWidget r0 = this.a;
            Context r1 = ((Widget) r0).context;
            if (r1 == null) goto L11;
            int r2 = IncreasePriceApplyDialog.g;
            GuestApplyViewModel r3 = r0.q;
            Intrinsics.checkNotNullParameter(r1, "context");
            IncreasePriceApplyDialog r6 = new IncreasePriceApplyDialog(r1, r5, r3);
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r6);
            goto L11
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L10:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
        L11:
            ALogger.i("GuestApplyDialog", "audience clicks the increase price button");
        L15:
            MultiLinkEventModule r7 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
            com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a(((Integer) ((ge1.a) hd0.c.f()).b).intValue(), r5);
            return;
        L13:
            if (hd0.c.f().g() == false) goto L15;
            f2.b(2131915053, 0);
            goto L15
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ GuestApplyContentWidget a;

        public e(GuestApplyContentWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            gd0.m r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r2 == null) goto L5;
            ((LinkPanelTransitService) r2).k();
        L5:
            this.a.s.dismiss();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ GuestApplyContentWidget a;

        public f(GuestApplyContentWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GuestApplyViewModel r4 = this.a.q;
            if (r4 == null) goto L22;
            LiveData<n0> r5 = r4.getUserWaitingData();
            if (r5 == null) goto L23;
            n0 r6 = (n0) r5.getValue();
            if (r6 == null) goto L24;
            IBaseUser r7 = r6.getUserFlex();
            if (r7 == null) goto L25;
            GuestApplyViewModel r0 = this.a.q;
            if (r0 == null) goto L20;
            LiveData<n0> r1 = r0.getUserWaitingData();
            if (r1 == null) goto L20;
            n0 r2 = (n0) r1.getValue();
            if (r2 == null) goto L20;
            if (r2.isAnonymous() != true) goto L20;
            ALogger.i("GuestApplyDialog", "click on the anonymous user avatar for apply , do not pull up the profile card");
            f2.c(s1.B(2131918948), 0);
            return;
        L20:
            xs2.b.a().post(new UserProfileEvent(r7));
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.widget.GuestApplyContentWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass3(GuestApplyContentWidget r8) {
            super(1, r8, GuestApplyContentWidget.class, "paidQueueTabChanged", "paidQueueTabChanged(I)V", 0);
        }

        public final void invoke(int r11) {
            GuestApplyContentWidget r0 = (GuestApplyContentWidget) ((CallableReference) this).receiver;
            r0.n = r11;
            GuestApplyViewModel r1 = r0.q;
            if (r1 == null) goto L5;
            GuestApplyViewModel.fetchList$default(r1, true, r0.r, null, r11, 0, true, 20, null);
        L5:
            ALogger.d("GuestApplyDialog", "paidQueueTabChanged, tabIndex: " + r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    public final int getLayoutId() {
        return 2131565482;
    }

    public final long xq() {
        if (this.n != WaitingListType.NORMAL.ordinal()) goto L21;
        GuestApplyViewModel r0 = this.q;
        if (r0 == null) goto L21;
        LiveData<n0> r1 = r0.getUserWaitingData();
        if (r1 == null) goto L21;
        n0 r2 = (n0) r1.getValue();
        if (r2 == null) goto L21;
        if (r2.getPaidAmount() != 0) goto L21;
        GuestApplyViewModel r3 = this.q;
        if (r3 == null) goto L40;
        LiveData<n0> r4 = r3.getUserWaitingData();
        if (r4 == null) goto L41;
        n0 r5 = (n0) r4.getValue();
        if (r5 != null) goto L19;
        return 0;
    L19:
        return r5.getOffset();
    L41:
        return 0;
    L40:
        return 0;
    L21:
        if (this.n != WaitingListType.PAID.ordinal()) goto L43;
        GuestApplyViewModel r6 = this.q;
        if (r6 == null) goto L29;
        LiveData<n0> r7 = r6.getUserWaitingData();
        if (r7 == null) goto L29;
        n0 r8 = (n0) r7.getValue();
        if (r8 == null) goto L29;
        long r9 = r8.getPaidAmount();
    L31:
        if (r9 <= 0) goto L44;
        GuestApplyViewModel r10 = this.q;
        if (r10 == null) goto L45;
        LiveData<n0> r11 = r10.getUserWaitingData();
        if (r11 == null) goto L46;
        n0 r12 = (n0) r11.getValue();
        if (r12 != null) goto L39;
        return 0;
    L39:
        return r12.getOffset();
    L46:
        return 0;
    L45:
        return 0;
    L44:
        return 0;
    L29:
        r9 = 0;
        goto L31
    L43:
        return 0;
    }

    public final void onCreate() {
        super.onCreate();
        FragmentActivity r0 = getContext();
        if (r0 == null) goto L129;
        this.a = WidgetManager.of(r0, ((Widget) this).contentView);
        this.b = new BannerWidget(this.r);
        t61 r1 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r1 != null) goto L7;
    L15:
        WidgetManager r2 = this.a;
        if (r2 == null) goto L18;
        r2.load(2131372686, this.b);
    L18:
        this.c = ((Widget) this).contentView.findViewById(2131392990);
        this.d = (FrameLayout) ((Widget) this).contentView.findViewById(2131392989);
        this.e = (TextView) ((Widget) this).contentView.findViewById(2131390468);
        this.f = ((Widget) this).contentView.findViewById(2131376019);
        this.g = (TextView) ((Widget) this).contentView.findViewById(2131391677);
        this.h = (TextView) ((Widget) this).contentView.findViewById(2131391674);
        this.i = (TextView) ((Widget) this).contentView.findViewById(2131381471);
        this.j = (TextView) ((Widget) this).contentView.findViewById(2131368841);
        this.k = (TextView) ((Widget) this).contentView.findViewById(2131368842);
        com.bytedance.android.livesdk.chatroom.t r3 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r3 == null) goto L25;
        com.bytedance.live.datacontext.j r4 = r3.getMessageManager();
        if (r4 == null) goto L25;
        vlc.d r5 = (vlc.d) r4.getValue();
        if (r5 == null) goto L25;
        r5.addMessageListener(MessageType.LINKER.getKey(), this);
    L25:
        cj0.b r6 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
        if (r6 == null) goto L30;
        NextLiveData<cj0.k> r7 = r6.c();
        if (r7 == null) goto L30;
        cj0.k r8 = (cj0.k) r7.getValue();
    L31:
        if (r8 != null) goto L33;
    L39:
        cj0.a r9 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r9 == null) goto L48;
        com.bytedance.live.datacontext.m<Integer> r10 = r9.getPaidQueueState();
        if (r10 == null) goto L48;
        Observable r11 = r10.a();
        if (r11 == null) goto L48;
        Disposable r12 = r11.subscribe(new com.bytedance.android.live.liveinteract.linkpanel.widget.d(this));
        if (r12 == null) goto L48;
        RxUtilKt.c(r12, this.p);
    L48:
        this.o.z2(n0.class, new zf0.j(new AnonymousClass2(this)));
        this.o.z2(zf0.m.a.class, new zf0.m(null, null));
        this.o.z2(zf0.d.class, new zf0.k());
        this.o.z2(zf0.f.a.class, new zf0.f(new AnonymousClass3(this), null, 4));
        this.o.z2(zf0.e.a.class, new zf0.e());
        GuestApplyViewModel r13 = this.q;
        if (r13 == null) goto L53;
        LiveData<n0> r14 = r13.getUserWaitingData();
        if (r14 == null) goto L53;
        r14.observe(this, new b(this));
    L53:
        GuestApplyViewModel r15 = this.q;
        if (r15 == null) goto L58;
        MutableLiveData<Boolean> r16 = r15.getAddPriceState();
        if (r16 == null) goto L58;
        r16.observe(this, new h(this));
    L58:
        GuestApplyViewModel r17 = this.q;
        if (r17 == null) goto L63;
        MutableLiveData<Integer> r18 = r17.getWaitingListType();
        if (r18 == null) goto L63;
        r18.observe(this, new i(this));
    L63:
        GuestApplyViewModel r19 = this.q;
        if (r19 == null) goto L68;
        LiveData<List<Object>> r20 = r19.getWaitingListData();
        if (r20 == null) goto L68;
        r20.observe(this, new c(this));
    L68:
        RecyclerView r21 = this.c;
        if (r21 == null) goto L71;
        r21.setAdapter(this.o);
        r21.setLayoutManager(new LinearLayoutManager(r21.getContext()));
        r21.addOnScrollListener(new GuestApplyContentWidget$onCreate$$inlined$apply$lambda$1(this));
    L71:
        TextView r22 = this.i;
        if (r22 == null) goto L74;
        UtilityKotlinExtentionsKt.u(r22);
    L74:
        TextView r23 = this.j;
        if (r23 == null) goto L77;
        UtilityKotlinExtentionsKt.u(r23);
    L77:
        TextView r24 = this.k;
        if (r24 == null) goto L81;
        UtilityKotlinExtentionsKt.u(r24);
    L81:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(this.r) == true) goto L83;
    L96:
        TextView r25 = this.i;
        if (r25 == null) goto L99;
        r25.setBackgroundResource(2131249467);
    L99:
        TextView r26 = this.i;
        if (r26 == null) goto L102;
        r26.setClickable(true);
    L102:
        TextView r27 = this.i;
        if (r27 == null) goto L105;
        r27.setText(s1.B(2131917774));
    L105:
        TextView r28 = this.i;
        if (r28 == null) goto L108;
        r28.setOnClickListener(new e(this));
    L108:
        HSImageView r29 = this.f;
        if (r29 == null) goto L111;
        r29.setOnClickListener(new f(this));
    L111:
        t61 r30 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r30 != null) goto L114;
    L115:
        GuestApplyViewModel r31 = this.q;
        if (r31 == null) goto L118;
        GuestApplyViewModel.fetchList$default(r31, true, this.r, null, this.n, 0, false, 52, null);
    L118:
        cj0.a r32 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r32 == null) goto L130;
        com.bytedance.live.datacontext.m<Boolean> r33 = r32.getRefreshWaitingUserList();
        if (r33 == null) goto L131;
        Observable r34 = r33.a();
        if (r34 == null) goto L132;
        Disposable r35 = r34.subscribe(new j(this));
        if (r35 == null) goto L133;
        RxUtilKt.c(r35, this.p);
        return;
    L133:
        return;
    L132:
        return;
    L131:
        return;
    L130:
        return;
    L114:
        if (u61.a(r30) == true) goto L118;
    L83:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L96;
        TextView r36 = this.i;
        if (r36 == null) goto L87;
        r36.setBackgroundResource(2131249467);
    L87:
        TextView r37 = this.i;
        if (r37 == null) goto L90;
        r37.setClickable(true);
    L90:
        TextView r38 = this.i;
        if (r38 == null) goto L93;
        r38.setText(s1.B(2131919314));
    L93:
        TextView r39 = this.i;
        if (r39 == null) goto L108;
        r39.setOnClickListener(new d(this));
        goto L108
    L33:
        if (((Boolean) vm2.d.v1.getValue(null, vm2.d.a[123(0x7b, float:1.72E-43)])).booleanValue() == false) goto L39;
        cj0.b r40 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
        if (r40 == null) goto L39;
        NextLiveData<cj0.k> r41 = r40.c();
        if (r41 == null) goto L39;
        r41.observe(this, new com.bytedance.android.live.liveinteract.linkpanel.widget.c(this));
    L30:
        r8 = null;
        goto L31
    L7:
        if (u61.a(r1) != true) goto L15;
        View r42 = ((Widget) this).contentView;
        if (r42 == null) goto L18;
        a r43 = new a(this);
        t61 r44 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r44 == null) goto L13;
        long r45 = r44.a3();
    L14:
        r42.postDelayed(r43, r45);
        goto L18
    L13:
        r45 = 1000;
        goto L14
    L129:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void onDestroy() {
        super.onDestroy();
        this.l = false;
        GuestApplyViewModel r0 = this.q;
        if (r0 == null) goto L7;
        LiveData<List<Object>> r1 = r0.getWaitingListData();
        if (r1 == null) goto L7;
        r1.removeObservers(this);
    L7:
        com.bytedance.android.livesdk.chatroom.t r2 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.j r3 = r2.getMessageManager();
        if (r3 == null) goto L14;
        vlc.d r4 = (vlc.d) r3.getValue();
        if (r4 == null) goto L14;
        r4.removeMessageListener(this);
    L14:
        this.p.clear();
        t61 r5 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r5 != null) goto L17;
        return;
    L17:
        if (u61.c(r5) != true) goto L27;
        WidgetManager r6 = this.a;
        if (r6 == null) goto L21;
        r6.unload(this.b);
    L21:
        WidgetManager r7 = this.a;
        if (r7 == null) goto L24;
        r7.contentView = null;
    L24:
        this.a = null;
        this.b = null;
        return;
    }

    public final void onResume() {
        super.onResume();
        Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.c("apply_panel");
    }

    public static final int wq(GuestApplyContentWidget r0) {
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(r0.r) == true) goto L5;
    L7:
        return 0;
    L5:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L7;
        return 1;
    }

    public final void onMessage(tlc.d r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof h1) == true) goto L7;
        return;
    L7:
        if (((h1) r11).getMType() != 55) goto L15;
        GuestApplyViewModel r1 = this.q;
        if (r1 == null) goto L14;
        GuestApplyViewModel.fetchList$default(r1, true, this.r, null, this.n, 0, false, 52, null);
        return;
    L14:
        return;
    }

    public final int zq(n0 r8) {
        ArrayList r0 = new ArrayList();
        GuestApplyViewModel r1 = this.q;
        if (r1 == null) goto L14;
        List<n0> r2 = r1.getMWaitingUserList();
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        vh7.c r4 = jm2.a.d((n0) r3.next());
        if (r4 == null) goto L13;
        r0.add((n0) r4);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.IWaitingListUser");
    L14:
        Iterator r5 = r0.iterator();
        int r6 = 0;
    L16:
        if (r5.hasNext() == false) goto L43;
        n0 r7 = (n0) r5.next();
        IBaseUser r9 = r7.getUserFlex();
        String r10 = null;
        if (r9 == null) goto L20;
        String r11 = r9.getIdString();
    L21:
        IBaseUser r12 = r8.getUserFlex();
        if (r12 == null) goto L25;
        r10 = r12.getIdString();
    L25:
        if (Intrinsics.areEqual(r11, r10) == false) goto L33;
        IBaseUser r13 = r7.getUserFlex();
        if (r13 == null) goto L33;
        String r14 = r13.getIdString();
        if (r14 == null) goto L33;
        if (r2.a(r14) != true) goto L33;
        return r6 + 1;
    L33:
        r6 = r6 + 1;
        goto L16
    L20:
        r11 = null;
        goto L21
    L43:
        return 0;
    }

    public static String yq(n0 r4, String r5) {
        if (r4 == null) goto L5;
        long r2 = r4.getPaidAmount();
    L7:
        if (r2 > 0) goto L9;
        return r5;
    L9:
        return s1.C(2131921202, new Object[]{Long.valueOf(r2)}) + ' ' + r5;
    L5:
        r2 = 0;
        goto L7
    }

    public GuestApplyContentWidget(GuestApplyViewModel r2, IRoom r3, xf0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "guestApply");
        this.q = r2;
        this.r = r3;
        this.s = r4;
        this.n = WaitingListType.UNKNOWN.ordinal();
        this.o = new MultiTypeAdapter();
        this.p = new CompositeDisposable();
    }
}
