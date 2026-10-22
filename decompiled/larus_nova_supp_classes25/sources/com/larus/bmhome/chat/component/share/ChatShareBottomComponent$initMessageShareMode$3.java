package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import ci8.d;
import ci8.e;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.list.pipeline.direct_add.UserActiveDeleteTipHelper;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusPageChatBottomShareBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.i;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;
import ry8.b;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareMode$3", f = "ChatShareBottomComponent.kt", i = {}, l = {668}, m = "invokeSuspend", n = {}, s = {})
public final class ChatShareBottomComponent$initMessageShareMode$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatShareBottomComponent a;

        public a(ChatShareBottomComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r27v0 */
        /* JADX WARN: Type inference failed for: r27v1 */
        /* JADX WARN: Type inference failed for: r27v10 */
        /* JADX WARN: Type inference failed for: r27v11 */
        /* JADX WARN: Type inference failed for: r27v12 */
        /* JADX WARN: Type inference failed for: r27v13 */
        /* JADX WARN: Type inference failed for: r27v14 */
        /* JADX WARN: Type inference failed for: r27v2 */
        /* JADX WARN: Type inference failed for: r27v3 */
        /* JADX WARN: Type inference failed for: r27v4 */
        /* JADX WARN: Type inference failed for: r27v5 */
        /* JADX WARN: Type inference failed for: r27v6 */
        /* JADX WARN: Type inference failed for: r27v7 */
        /* JADX WARN: Type inference failed for: r27v8 */
        /* JADX WARN: Type inference failed for: r27v9 */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.component.share.n0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v17, types: [xi8.a] */
        /* JADX WARN: Type inference failed for: r3v56, types: [com.larus.bmhome.chat.component.share.n0] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4 */
        public final Object emit(Object r42, Continuation r43) {
            rr8.a r1 = (rr8.a) r42;
            final ChatShareBottomComponent r2 = this.a;
            ?? r3 = new n0(r2);
            final IChatMessageShareAbility$ActionType r4 = r1.b;
            Boolean r5 = r1.a;
            if (r5 == null) goto L5;
            boolean r6 = r5.booleanValue();
        L6:
            final Map r7 = r1.c;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "action");
            Intrinsics.checkNotNullParameter(r3, "onCloseClick");
            IChatMessageShareAbility$ActionType r8 = IChatMessageShareAbility$ActionType.SHARE;
            if (r4 == r8) goto L9;
        L11:
            boolean r10 = false;
        L12:
            String r12 = "0";
            if (r6 == false) goto L76;
            if (r10 == true) goto L16;
            ?? r27 = r3;
            final LarusPageChatBottomShareBinding r9 = r2.n;
            ?? r28 = r27;
            if (r9 != null) goto L40;
        L67:
            LarusPageChatBottomShareBinding r11 = r2.n;
            ?? r29 = r28;
            if (r11 == null) goto L77;
            if (r10 == false) goto L71;
            r11.h.setVisibility(8);
            r11.k.setVisibility(0);
            r29 = r28;
            goto L77
        L71:
            r11.h.setVisibility(0);
            if (r4 == r8) goto L74;
            int r13 = -2;
            r11.h.getLayoutParams().height = -2;
            r11.b.setVisibility(8);
            r11.c.setVisibility(8);
        L75:
            r11.k.setVisibility(8);
            ?? r210 = r28;
        L78:
            b r14 = (b) r2.y.getValue();
            if (r14 == null) goto L81;
            r14.hz();
        L81:
            p1 r15 = (p1) r2.v.getValue();
            if (r15 == null) goto L84;
            r15.cb(false);
        L84:
            Intrinsics.checkNotNullParameter(r2, "<this>");
            com.larus.bmhome.a0 r16 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(r2, r2));
            if (r16 == null) goto L87;
            r16.ED(!r6, "select mode");
        L87:
            Intrinsics.checkNotNullParameter(r2, "<this>");
            d r17 = e.a(com.larus.ui.arch.component.internal.attach.a.b(r2, r2));
            if (r17 == null) goto L90;
            r17.hp(!r6);
        L90:
            LarusPageChatBottomShareBinding r18 = r2.n;
            if (r18 == null) goto L195;
            if (r6 == false) goto L171;
            ViewGroup.LayoutParams r19 = r18.a.getLayoutParams();
            if (r19 == null) goto L105;
            Intrinsics.checkNotNullParameter(r2, "<this>");
            if (com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getActivity() == null) goto L105;
            if (r10 == false) goto L100;
        L104:
            r19.height = r13;
            goto L105
        L100:
            if (z2.a.enableChatWithTab() == false) goto L102;
            r13 = i5.y0(2131166745);
            goto L104
        L102:
            if (r4 != r8) goto L104;
            r13 = i5.y0(2131166697);
        L105:
            r18.a.setVisibility(0);
            com.larus.bmhome.share.panel.a r20 = r2.q;
            if (r20 == null) goto L108;
            r20.setVisibility(0);
        L108:
            View r21 = r18.a.findViewById(2131380978);
            if (r4 != r8) goto L111;
            int r110 = 8;
        L112:
            r21.setVisibility(r110);
            com.larus.bmhome.chat.component.immerse.a r22 = (com.larus.bmhome.chat.component.immerse.a) r2.C.getValue();
            if (r22 == null) goto L115;
            r22.UP();
        L115:
            r2.k4();
            if (r8 != r4) goto L181;
            if (r7 == null) goto L119;
            Object r23 = r7.get("EXT_KEY_CLICK_FROM");
        L121:
            if ((r23 instanceof String) == false) goto L123;
            String r24 = (String) r23;
        L124:
            if (r24 != null) goto L126;
            r24 = "share_panel";
        L126:
            String r31 = r24;
            Message r25 = r2.e4().getOriginSelectMessage();
            ChatShareBottomComponent$a r26 = ChatShareBottomComponent.H3(r25);
            ShareServiceDelegate r211 = ShareServiceDelegate.b;
            boolean r212 = r2.f1().z();
            ChatControlTrace r30 = ChatControlTrace.b;
            wc9.e r32 = r2.h();
            if (r32 == null) goto L129;
            Integer r33 = r32.v;
        L130:
            String r34 = r30.g(r33, r2.V3(), r2.Q3());
            String r35 = r2.X3();
            if (r25 == null) goto L134;
            String r36 = r25.getMessageId();
            if (r36 == null) goto L134;
        L135:
            String r37 = r36;
            if (z2.a.longPressShowMultiSelect() == false) goto L138;
            String r38 = "multiple_choose";
        L139:
            String r39 = r38;
            if (r7 == null) goto L142;
            Object r40 = r7.get("EXT_KEY_IS_BUTTON_ADD_TEXT");
        L144:
            if ((r40 instanceof Integer) == false) goto L146;
            Integer r310 = (Integer) r40;
        L147:
            if (r25 != null) goto L149;
        L151:
            boolean r41 = false;
        L152:
            if (r41 == false) goto L154;
            String r44 = "user";
        L155:
            String r311 = r44;
            if (r25 == null) goto L158;
            String r312 = com.larus.bmhome.chat.bean.d.u(r25);
        L159:
            Intrinsics.checkNotNullParameter(r2, "<this>");
            by7.e r45 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2);
            Intrinsics.checkNotNull(r45, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
            by7.e r313 = r45;
            JSONObject r46 = new JSONObject();
            if (r2.l4() == false) goto L162;
            r12 = "1";
        L162:
            r46.put("is_ai_podcast", r12);
            r46.putOpt("page_token", r26.e);
            r46.putOpt("artifact_meta_id", r26.a);
            r46.putOpt("resource_type", r26.b);
            r46.putOpt("artifact_type", r26.b);
            r46.putOpt("resource_id", r26.e);
            r46.putOpt("base_id", r26.d);
            r46.putOpt("canvas_type", r26.f);
            r46.putOpt("current_page", "chat");
            if (r25 == null) goto L167;
            IFlowSdkDepend r47 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r47 == null) goto L167;
            r47.h();
            r46.putOpt("spreadsheet_id", SdkSheetsServiceImpl.a.d(r25));
        L167:
            if (r25 == null) goto L169;
            boolean r314 = com.larus.im.bean.message.a.g0(r25);
        L170:
            r211.e(r212, r34, r31, r35, r37, r39, r310, r311, r312, r313, r314, r46);
            goto L181
        L169:
            r314 = false;
            goto L170
        L158:
            r312 = null;
            goto L159
        L154:
            r44 = "bot";
            goto L155
        L149:
            if (com.larus.bmhome.chat.bean.d.G0(r25) != true) goto L151;
            r41 = true;
            goto L152
        L146:
            r310 = null;
            goto L147
        L142:
            r40 = null;
            goto L144
        L138:
            r38 = "share";
        L134:
            r36 = "";
            goto L135
        L129:
            r33 = null;
            goto L130
        L123:
            r24 = null;
            goto L124
        L119:
            r23 = null;
        L181:
            if (r2.L == true) goto L195;
            u7 r48 = r2.Z3();
            if (r48 == null) goto L185;
            MessageAdapter r49 = r48.MF();
        L187:
            if ((r49 instanceof MessageAdapter) == false) goto L189;
            MessageAdapter r111 = r49;
        L190:
            if (r111 == null) goto L192;
            com.larus.utils.t0.e(new com.larus.bmhome.chat.adapter.x(r111));
            goto L195
        L192:
            if (r49 == null) goto L195;
            r49.notifyDataSetChanged();
            goto L195
        L189:
            r111 = null;
            goto L190
        L185:
            r49 = null;
            goto L187
        L111:
            r110 = 0;
            goto L112
        L171:
            r18.a.setVisibility(8);
            com.larus.bmhome.share.panel.a r50 = r2.q;
            if (r50 == null) goto L174;
            r50.setVisibility(8);
        L174:
            com.larus.bmhome.chat.component.immerse.a r51 = (com.larus.bmhome.chat.component.immerse.a) r2.C.getValue();
            if (r51 == null) goto L177;
            r51.x90();
        L177:
            ChatShareBottomComponent$registerShareModeBackPressCallback$1 r52 = r2.J;
            if (r52 == null) goto L181;
            r52.remove();
        L195:
            Fragment r53 = s1a.a.c(this.a).getParentFragment();
            ?? r213 = r210;
        L196:
            if (r53 == null) goto L206;
            if ((r53 instanceof xi8.a) == false) goto L204;
            ?? r54 = (xi8.a) r53;
            Boolean r55 = r1.a;
            if (r55 == null) goto L202;
            boolean r56 = r55.booleanValue();
        L203:
            r54.NK(r56, r213);
        L205:
            r53 = r53.getParentFragment();
            r213 = r213;
            goto L196
        L202:
            r56 = false;
            goto L203
        L204:
            r213 = r213;
            goto L205
        L206:
            Iterator r57 = ((ArrayList) this.a.Q).iterator();
        L208:
            if (r57.hasNext() == false) goto L215;
            hca.e r58 = (hca.e) r57.next();
            Boolean r59 = r1.a;
            if (r59 == null) goto L212;
            boolean r60 = r59.booleanValue();
        L213:
            r58.onSelectModeChanged(r60);
            goto L208
        L212:
            r60 = false;
            goto L213
        L215:
            return Unit.INSTANCE;
        L74:
            r13 = -2;
        L77:
            r13 = -2;
            r210 = r29;
            goto L78
        L40:
            if (r4 != IChatMessageShareAbility$ActionType.DELETE) goto L44;
            int r61 = UserActiveDeleteTipHelper.a;
            int r62 = ra9.a.a;
            if (Intrinsics.areEqual(ga9.a.e("delete_msg_tip_display", "0"), "2") == false) goto L44;
            Button r63 = r9.g;
            Context r64 = r63.getContext();
            Intrinsics.checkNotNullParameter(r64, "context");
            r63.setText(r64.getString(2131908926));
        L52:
            com.larus.utils.e1.d(r9.g, new q(r4, r2, r7));
            com.larus.utils.e1.d(r9.d, new r(r9));
            if (r2.f1().z() == false) goto L55;
            r9.g.setTextColor(ContextCompat.getColor(r2.getContext(), 2131103292));
            r9.g.setBackgroundResource(2131239600);
            r9.e.setBackgroundResource(2131242060);
            r9.d.setTextColor(ContextCompat.getColor(r2.getContext(), 2131106539));
        L62:
            z2 r65 = z2.a;
            if (r65.getShareConfig().d() == false) goto L65;
            r9.b.setVisibility(8);
            r9.c.setVisibility(0);
        L66:
            r2.e4().getShareMegNum().observe(r2, new ChatShareBottomComponent$g(new s(r2)));
            r28 = r27;
            goto L67
        L65:
            r9.b.setVisibility(0);
            r9.c.setVisibility(8);
            r9.e.setChecked(r65.getShareConfig().u());
            goto L66
        L55:
            r9.g.setTextColor(ContextCompat.getColor(r2.getContext(), 2131103298));
            Button r66 = r9.g;
            if (r66 == null) goto L58;
            r66.setBackgroundResource(c.b(2130970803, r66.getContext(), 2131239598));
        L58:
            AppCompatCheckBox r67 = r9.e;
            if (r67 == null) goto L61;
            r67.setBackgroundResource(c.b(2130971849, r67.getContext(), 2131242058));
        L61:
            r9.d.setTextColor(ContextCompat.getColor(r2.getContext(), c.b(2130972081, r2.getContext(), 2131103143)));
        L44:
            Button r68 = r9.g;
            int r69 = ChatShareBottomComponent$d.a[r4.ordinal()];
            if (r69 != 1) goto L47;
            int r70 = 2131900900;
        L51:
            r68.setText(r70);
            goto L52
        L47:
            if (r69 == 2) goto L49;
            r70 = 2131900868;
            goto L51
        L49:
            r70 = 2131907182;
            goto L51
        L16:
            if (r2.q != null) goto L36;
            LarusPageChatBottomShareBinding r112 = r2.n;
            if (r112 == null) goto L36;
            ShareServiceDelegate r113 = ShareServiceDelegate.b;
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Context r114 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getContext();
            if (r2.q4() == false) goto L24;
            ShareScene r115 = ShareScene.OFFICE_SHARE_CHAT;
        L27:
            boolean r214 = r2.f1().C();
            boolean r215 = i.f(r2.h());
            h r216 = r2.D3();
            o0 r71 = new o0(r2);
            Intrinsics.checkNotNullParameter(r2, "<this>");
            by7.e r116 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2);
            if ((r116 instanceof by7.e) == false) goto L30;
            by7.e r217 = r116;
        L32:
            if (sr8.c.a() == true) goto L34;
            List r218 = null;
        L35:
            View r72 = r113.q(r114, r115, null, r214, r215, r216, r71, null, r217, r218);
            r2.q = r72;
            r112.j.addView(r72);
            LiveData<Integer> r73 = r2.e4().getShareMegNum();
            Intrinsics.checkNotNullParameter(r2, "<this>");
            r73.observe(com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getViewLifecycleOwner(), new ChatShareBottomComponent$g(new t(r2)));
            r28 = r3;
            goto L67
        L34:
            r218 = CollectionsKt.listOf(new jr9.a("ccm_share", null, 14));
            goto L35
        L30:
            r217 = null;
            goto L32
        L24:
            if (z2.a.getShareConfig().n() == false) goto L26;
            r115 = ShareScene.MESSAGES_LINK_IMAGE;
            goto L27
        L26:
            r115 = ShareScene.MESSAGES_LINK;
        L36:
            r28 = r3;
            goto L67
        L76:
            r29 = r3;
            goto L77
        L9:
            if (Intrinsics.areEqual(z2.a.getShareConfig().o(), Boolean.TRUE) == false) goto L11;
            r10 = true;
            goto L12
        L5:
            r6 = false;
            goto L6
        }
    }

    public ChatShareBottomComponent$initMessageShareMode$3(ChatShareBottomComponent r1, Continuation<? super ChatShareBottomComponent$initMessageShareMode$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatShareBottomComponent$initMessageShareMode$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ChatShareBottomComponent r6 = this.this$0;
        int r2 = ChatShareBottomComponent.R;
        kotlinx.coroutines.flow.i1<rr8.a> r7 = r6.e4().getShareModeFlow();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
