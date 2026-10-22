package com.bytedance.android.livesdk.interactivity.textmessage.viewholder;

import am2.x;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.q1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.config.cl0;
import com.bytedance.android.livesdk.config.w71;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.DispatchCallbackLinearLayout;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.textmessage.model.g0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.v;
import com.bytedance.android.livesdk.interactivity.textmessage.render.TextMessageSpanAction;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ac;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r52.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/textmessage/viewholder/TextMessageRenderViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "Lg52/b;", "Lg52/d;", "e", "f", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TextMessageRenderViewHolder extends MessageViewHolder implements g52.b, g52.d {
    public final TextView b;
    public final View c;
    public final d d;
    public final Function2<? super View, ? super tb2.b, Boolean> e;
    public final Function2<? super View, ? super tb2.b, Boolean> f;
    public final Function2<? super View, ? super tb2.b, Boolean> g;
    public final Function2<? super View, ? super tb2.b, Boolean> h;
    public final Function2<? super View, ? super tb2.b, Boolean> i;
    public final Function2<? super View, ? super tb2.b, Boolean> j;
    public boolean k;
    public final h l;
    public final k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> m;
    public final boolean n;
    public final e52.a o;
    public final g52.c p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TextMessageRenderViewHolder a;
        public final /* synthetic */ View.OnClickListener b;

        public a(TextMessageRenderViewHolder r1, View.OnClickListener r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            TextMessageRenderViewHolder r0 = this.a;
            Object r1 = null;
            if (r5 == null) goto L5;
            Object r2 = r5.getTag(2131389787);
        L7:
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f) == false) goto L10;
            r1 = r2;
        L10:
            r0.Z3((com.bytedance.android.livesdk.interactivity.api.entity.f) r1);
            this.b.onClick(r5);
            this.a.b4(false);
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ TextMessageRenderViewHolder a;

        public b(TextMessageRenderViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            d r0 = this.a.d;
            if (r0 == null) goto L5;
            boolean r4 = r0.onLongClick(r3);
        L6:
            this.a.b4(false);
            return r4;
        L5:
            r4 = false;
            goto L6
        }
    }

    public static final class c implements l {
        public final /* synthetic */ TextMessageRenderViewHolder a;

        public c(TextMessageRenderViewHolder r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final void a(View r7) {
            Intrinsics.checkNotNullParameter(r7, "view");
            Object r0 = r7.getTag(2131389787);
            if ((r0 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f) == true) goto L5;
            return;
        L5:
            if (w71.a() == true) goto L7;
            ((com.bytedance.android.livesdk.interactivity.api.entity.f) r0).E(this.a.p);
        L8:
            ((com.bytedance.android.livesdk.interactivity.api.entity.f) r0).F(null);
            return;
        L7:
            TextMessageRenderViewHolder r2 = this.a;
            ((com.bytedance.android.livesdk.interactivity.api.entity.f) r0).H(r7, r2.p, r2, new WeakReference(this.a.l));
            goto L8
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final boolean b(View r9, tb2.b r10, ClickableSpan r11) {
            Intrinsics.checkNotNullParameter(r9, "view");
            Intrinsics.checkNotNullParameter(r10, "action");
            Intrinsics.checkNotNullParameter(r11, "span");
            boolean r1 = false;
            if (r10 != TextMessageSpanAction.CHAT_CONTENT) goto L12;
            if (w71.a() == true) goto L71;
            Function2<? super View, ? super tb2.b, Boolean> r13 = this.a.e;
            if (r13 == null) goto L71;
            Boolean r14 = (Boolean) r13.invoke(r9, r10);
            if (r14 == null) goto L71;
            r1 = r14.booleanValue();
        L71:
            if (r1 == false) goto L75;
            Object r15 = r9.getTag(2131389787);
            if ((r15 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f) == false) goto L75;
            ((com.bytedance.android.livesdk.interactivity.api.entity.f) r15).F(r10);
        L75:
            return r1;
        L12:
            if (r10 != TextMessageSpanAction.INVITOR_NAME) goto L19;
            Function2<? super View, ? super tb2.b, Boolean> r16 = this.a.g;
            if (r16 == null) goto L71;
            Boolean r17 = (Boolean) r16.invoke(r9, r10);
            if (r17 == null) goto L71;
            r1 = r17.booleanValue();
            goto L71
        L19:
            if (r10 != TextMessageSpanAction.INVITEE_NAME) goto L26;
            Function2<? super View, ? super tb2.b, Boolean> r18 = this.a.h;
            if (r18 == null) goto L71;
            Boolean r19 = (Boolean) r18.invoke(r9, r10);
            if (r19 == null) goto L71;
            r1 = r19.booleanValue();
            goto L71
        L26:
            if ((r10 instanceof tb2.e) == false) goto L58;
            Function2<? super View, ? super tb2.b, Boolean> r110 = this.a.f;
            if (r110 == null) goto L30;
            Boolean r111 = (Boolean) r110.invoke(r9, r10);
        L30:
            int r112 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k.a;
            tb2.e r113 = (tb2.e) r10;
            Intrinsics.checkNotNullParameter(r113, "schemaAction");
            String r3 = r113.a().a;
            t42.b r5 = null;
            if (r3 != null) goto L33;
        L37:
            boolean r4 = false;
        L38:
            if (r4 == false) goto L56;
            Object r6 = r9.getTag(2131389787);
            if ((r6 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f) == true) goto L42;
            r6 = null;
        L42:
            com.bytedance.android.livesdk.interactivity.api.entity.f r7 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r6;
            if (r7 == null) goto L45;
            tlc.d r8 = r7.b;
        L46:
            tlc.d r20 = r8;
            Intrinsics.checkNotNullParameter(r113, "schemaAction");
            if (r20 == null) goto L50;
            r5 = new t42.b(Long.valueOf(r20.getMessageId()), r20.getMessageMethod());
        L50:
            StringBuilder r2 = new StringBuilder("handle schemaAction: ");
            m6 r21 = r113.a();
            r2.append("SchemaInfo(schemaUrl=" + r21.a() + ", schemaKey=" + r21.a + ')');
            com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k.a(r2.toString());
            String r23 = r113.a().a();
            if (r23 == null) goto L71;
            com.bytedance.android.live.base.model.liteinteraction.d r24 = (com.bytedance.android.live.base.model.liteinteraction.d) JsonUtil.parse(r23, com.bytedance.android.live.base.model.liteinteraction.d.class);
            if (r24 == null) goto L71;
            xs2.b.a().post(new t42.a(r5, new t42.c(r24, r113.a())));
            r1 = true;
            goto L71
        L45:
            r8 = null;
            goto L46
        L56:
            r1 = tb2.f.a(r113);
            goto L71
        L33:
            if (StringsKt.startsWith$default(r3, "light_interaction_info", false, 2, null) != true) goto L37;
            if (((Boolean) k3.a.getValue()).booleanValue() == false) goto L37;
            r4 = true;
            goto L38
        L58:
            if ((r10 instanceof tb2.g) == false) goto L65;
            Function2<? super View, ? super tb2.b, Boolean> r114 = this.a.i;
            if (r114 == null) goto L71;
            Boolean r115 = (Boolean) r114.invoke(r9, r10);
            if (r115 == null) goto L71;
            r1 = r115.booleanValue();
            goto L71
        L65:
            if ((r10 instanceof com.bytedance.android.livesdk.interactivity.textmessage.render.f) == false) goto L71;
            Function2<? super View, ? super tb2.b, Boolean> r116 = this.a.j;
            if (r116 == null) goto L71;
            Boolean r117 = (Boolean) r116.invoke(r9, r10);
            if (r117 == null) goto L71;
            r1 = r117.booleanValue();
            goto L71
        }
    }

    public static final class d implements View.OnLongClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            Object r0 = r3.getTag(2131389787);
            if ((r0 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f) == true) goto L7;
            return false;
        L7:
            return ((com.bytedance.android.livesdk.interactivity.api.entity.f) r0).G(r3.getContext());
        }
    }

    public static final class e {
    }

    public static final class f {
        public final View a;
        public final TextView b;
        public final View c;
        public final g52.a d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L14;
            f r4 = (f) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            TextView r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            View r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            g52.a r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CompositeView(rootView=" + this.a + ", textView=" + this.b + ", backgroundView=" + this.c + ", dispatchCallbackView=" + this.d + ")";
        }

        public f(View r2, NoMoreSpaceTextView r3, View r4, DispatchCallbackLinearLayout r5) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            Intrinsics.checkNotNullParameter(r3, "textView");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class g implements k.a<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> {
        public final /* synthetic */ TextMessageRenderViewHolder a;
        public final /* synthetic */ g52.e b;

        public g(TextMessageRenderViewHolder r1, g52.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
        public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3, j r4) {
            com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5 = r3;
            Intrinsics.checkNotNullParameter(r5, "message");
            Intrinsics.checkNotNullParameter(r4, "rendResult");
            if (Intrinsics.areEqual(this.a.b.getTag(2131389787), r5) == false) goto L18;
            t.a r0 = t.a;
            TextView r1 = this.a.b;
            CharSequence r2 = r4.a;
            if (r2 != null) goto L8;
            r2 = BuildConfig.FLAVOR;
        L8:
            t.b(r1, r2);
            if (r3.l(((RecyclerView.ViewHolder) this.a).itemView.getContext()) == false) goto L11;
            PublicScreenAccessibilityUtil r6 = PublicScreenAccessibilityUtil.a;
            Spannable r7 = r4.a;
            TextView r8 = this.a.b;
            r6.getClass();
            PublicScreenAccessibilityUtil.a(r7, r8, r5);
        L11:
            g52.e r9 = this.b;
            if (r9 == null) goto L14;
            r9.c(this.a.b);
        L14:
            this.a.getClass();
            if (TextMessageRenderViewHolder.a4(r5) == false) goto L19;
            TextView r10 = this.a.b;
            r10.post(new com.bytedance.android.livesdk.interactivity.textmessage.viewholder.c(r5, r10));
            return;
        L19:
            return;
        }
    }

    public static final class h implements Function1<Boolean, Boolean> {
        public final /* synthetic */ TextMessageRenderViewHolder a;

        public h(TextMessageRenderViewHolder r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            return Boolean.valueOf(this.a.Y3(r3));
        }
    }

    static {
    }

    public boolean Y3(boolean r1) {
        return false;
    }

    @Override // g52.d
    public final void d3() {
        Object r0 = this.b.getTag(2131389787);
        if ((r0 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        ALogger.d("PSAudienceOperatePanel_Log", "isTouch = " + this.k + " msg.isSelected = " + r1.h);
        if (this.k == false) goto L11;
    L14:
        X3(this.c, r1, true);
        return;
    L11:
        if (r1.h == true) goto L14;
        X3(this.c, r1, false);
    }

    public static boolean a4(com.bytedance.android.livesdk.interactivity.api.entity.f r3) {
        if (((Boolean) cl0.a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        ac r0 = r3.b;
        if ((r0 instanceof ac) == true) goto L8;
        r0 = null;
    L8:
        ac r1 = r0;
        if (r1 != null) goto L11;
        IPublicAreaCommon r2 = r3.v();
        if (r2 != null) goto L15;
    L19:
        return false;
    L15:
        if (r2.getHasTailButton() != true) goto L19;
        if (r3.E == true) goto L19;
        return true;
    L11:
        return !r1.M1();
    }

    public void Z3(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        if (r2 == null) goto L5;
        r2.D = null;
        return;
    }

    public final void b4(boolean r3) {
        ALogger.d("PSAudienceOperatePanel_Log", "isTouch = " + r3);
        this.k = r3;
        d3();
    }

    @Override // g52.b
    public final void c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        int r3 = r2.getAction();
        if (r3 != 0) goto L5;
        b4(true);
        return;
    L5:
        if (r3 != 3) goto L11;
        b4(false);
        return;
    }

    public void W3(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r13, j r14) {
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r14, "renderResult");
        String r1 = "1";
        k0 r3 = null;
        if (this.n == true) goto L6;
    L73:
        boolean r15 = this.n;
        String r0 = BuildConfig.FLAVOR;
        if (r15 == false) goto L110;
        c4 r16 = r13.b;
        if ((r16 instanceof c4) == true) goto L79;
        r16 = null;
    L79:
        c4 r17 = r16;
        if (r17 == null) goto L110;
        if (r17.getRoomMessageType() != 1) goto L110;
        j0 r18 = j0.l();
        HashMap r6 = new HashMap();
        r6.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r6.put("ecom_group_type", "live");
        o r7 = j0.l().c(x.class);
        if (r7 == null) goto L93;
        String r8 = (String) r7.getMap().get("enter_from_merge");
        if (r8 != null) goto L89;
        r8 = BuildConfig.FLAVOR;
    L89:
        String r9 = (String) r7.getMap().get("enter_method");
        if (r9 != null) goto L92;
        r9 = BuildConfig.FLAVOR;
    L92:
        String r10 = (String) r6.put("source_page", r8 + "_temai_" + r9);
    L93:
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        if (r11 == null) goto L96;
        com.bytedance.android.livesdk.chatroom.o r19 = IRoomContextService.a.a(r11, null, 0, 3);
    L97:
        if (r19 == null) goto L107;
        m r20 = r19.getRoom();
        if (r20 == null) goto L107;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L107;
        IBaseUser r23 = r21.getOwner();
        if (r23 == null) goto L107;
        if (r23.isFollowing() != true) goto L107;
    L108:
        r6.put("follow_status", r1);
        Unit r2 = Unit.INSTANCE;
        r18.sendLog("livesdk_replay_save_prompt_show", r6, new Object[0]);
    L107:
        r1 = "0";
        goto L108
    L96:
        r19 = null;
    L110:
        if (this.n == false) goto L135;
        k0 r110 = r13.b;
        if ((r110 instanceof k0) == false) goto L116;
        r3 = r110;
    L116:
        k0 r4 = r3;
        if (r4 == null) goto L136;
        q1 r111 = r4.getLandscapeAreaCommon();
        if (r111 != null) goto L122;
        return;
    L122:
        if (r111.isStarMessage() != true) goto L134;
        j0 r112 = j0.l();
        HashMap r113 = new HashMap();
        String r5 = r4.getMsgId();
        if (r5 != null) goto L126;
        r5 = BuildConfig.FLAVOR;
    L126:
        r113.put("comment_id", r5);
        q1 r24 = r4.getLandscapeAreaCommon();
        if (r24 != null) goto L129;
    L131:
        r113.put("vs_comment_type", r0);
        Unit r25 = Unit.INSTANCE;
        r112.sendLog("livesdk_vs_comment_show", r113, new Object[]{new x(), IRoom.class});
        return;
    L129:
        if (r24.isStarMessage() != true) goto L131;
        r0 = "star";
        goto L131
    L134:
        return;
    L136:
        return;
    L135:
        return;
    L6:
        if (((HashMap) r13.n).containsKey("show_tag_for_anchor_fans_icon_show_logger") == true) goto L73;
        ((HashMap) r13.n).put("show_tag_for_anchor_fans_icon_show_logger", "null");
        i r114 = r14.b;
        if (r114 == null) goto L73;
        if (r114.b == false) goto L12;
    L15:
        boolean r26 = true;
    L16:
        if (r26 == true) goto L19;
        r114 = null;
    L19:
        if (r114 == null) goto L73;
        j0 r27 = j0.l();
        HashMap r28 = new HashMap();
        IBaseUser r29 = r13.x();
        if (r29 == null) goto L24;
        String r30 = r29.getIdString();
        if (r30 == null) goto L24;
    L25:
        r28.put("user_id", r30);
        T r31 = r13.b;
        if (r31 == 0) goto L28;
        String r33 = r31.getMessageMethod();
    L30:
        if (r33 != null) goto L33;
    L53:
        String r34 = CardLockInfo.sUNKNOWN;
    L54:
        r28.put("show_type", r34);
        T r35 = r13.b;
        if (r35 == 0) goto L57;
        String r36 = r35.getMessageMethod();
    L59:
        if (Intrinsics.areEqual(r36, "WebcastRoomMessage") == false) goto L69;
        c4 r37 = r13.b;
        if ((r37 instanceof c4) == true) goto L63;
        r37 = null;
    L63:
        c4 r38 = r37;
        if (r38 == null) goto L69;
        if (r38.isGiftTypeMessage() != true) goto L69;
        r28.put("show_type", "gift");
    L69:
        if (r114.b == false) goto L71;
        Object r115 = "1";
    L72:
        r28.put("is_mutual", r115);
        Unit r116 = Unit.INSTANCE;
        r27.sendLog("livesdk_fans_tag_show", r28, new Object[0]);
        goto L73
    L71:
        r115 = "0";
        goto L72
    L57:
        r36 = null;
        goto L59
    L33:
        switch(r33.hashCode()) {
            case -1988298150: goto L51;
            case -1441604104: goto L48;
            case 41447196: goto L45;
            case 799725124: goto L42;
            case 1163169388: goto L39;
            case 2129329488: goto L36;
            default: goto L53;
        };
    L36:
        if (r33.equals("WebcastScreenChatMessage") == false) goto L53;
    L46:
        r34 = "comment";
        goto L54
    L39:
        if (r33.equals("WebcastAudioChatMessage") == false) goto L53;
    L42:
        if (r33.equals("WebcastGiftMessage") == false) goto L53;
    L49:
        r34 = "gift";
        goto L54
    L45:
        if (r33.equals("WebcastChatMessage") == false) goto L53;
    L48:
        if (r33.equals("GiftGroupMessage") == false) goto L53;
    L51:
        if (r33.equals("WebcastMemberMessage") == false) goto L53;
        r34 = "room_enter";
        goto L54
    L28:
        r33 = null;
    L24:
        r30 = "0";
        goto L25
    L12:
        if (r114.c == true) goto L15;
        r26 = false;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public void U3(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5, int r6, g52.e r7) {
        Intrinsics.checkNotNullParameter(r5, "message");
        this.b.setTag(2131389787, r5);
        this.b.setAlpha(1.0f);
        TextView r8 = this.b;
        NoMoreSpaceTextView r1 = null;
        if ((r8 instanceof NoMoreSpaceTextView) == true) goto L5;
        r8 = null;
    L5:
        NoMoreSpaceTextView r9 = (NoMoreSpaceTextView) r8;
        if (r9 == null) goto L8;
        r9.setAlwaysInvalidate(false);
    L8:
        j r10 = this.m.b(r5, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new g(this, r7));
        t.a r0 = t.a;
        TextView r2 = this.b;
        CharSequence r3 = r10.a;
        if (r3 != null) goto L12;
        r3 = BuildConfig.FLAVOR;
    L12:
        t.b(r2, r3);
        if (r3.l(((RecyclerView.ViewHolder) this).itemView.getContext()) == false) goto L15;
        PublicScreenAccessibilityUtil r4 = PublicScreenAccessibilityUtil.a;
        Spannable r11 = r10.a;
        TextView r13 = this.b;
        r4.getClass();
        PublicScreenAccessibilityUtil.a(r11, r13, r5);
    L15:
        i r14 = r10.b;
        if (r14 != null) goto L18;
    L26:
        if (r7 == null) goto L29;
        TextView r15 = this.b;
        int r16 = g52.e.j;
        r7.a(r15, true);
    L29:
        if (a4(r5) == false) goto L31;
        TextView r17 = this.b;
        r17.post(new com.bytedance.android.livesdk.interactivity.textmessage.viewholder.c(r5, r17));
    L31:
        d3();
        this.m.a(r5);
        W3(r5, r10);
        return;
    L18:
        if (r14.a != true) goto L26;
        NoMoreSpaceTextView r18 = this.b;
        if ((r18 instanceof NoMoreSpaceTextView) == false) goto L23;
        r1 = r18;
    L23:
        NoMoreSpaceTextView r19 = r1;
        if (r19 == null) goto L26;
        r19.setAlwaysInvalidate(true);
        goto L26
    }

    public void X3(final View r6, final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7, final boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "message");
        if (r6 != null) goto L5;
        return;
    L5:
        py.k r1 = null;
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.d) == false) goto L11;
        k0 r0 = ((com.bytedance.android.livesdk.interactivity.textmessage.model.d) r7).b;
        if (r0 == null) goto L20;
        py.k r2 = r0.getBackground();
    L21:
        if (r2 != null) goto L23;
    L25:
        if (r1 == null) goto L34;
        Function0<Unit> r3 = new TextMessageRenderViewHolder$loadBackground$1(this, r8, r7, r6);
        T r9 = r7.b;
        if (r9 == 0) goto L29;
        long r10 = r9.getMessageId();
    L30:
        IMiddlewareNetworkService r4 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r4 == null) goto L36;
        r4.loadNinePatchDrawable(r1, r6, RTLUtil.isAppRTL(s1.getContext()), new com.bytedance.android.livesdk.interactivity.textmessage.viewholder.b(r6, r10, r3));
        return;
    L36:
        return;
    L29:
        r10 = 0;
        goto L30
    L34:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.e(r6, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(r8, r7, this.o));
        return;
    L23:
        if ((!r2.getUrls().isEmpty()) == false) goto L25;
        r1 = r2;
    L20:
        r2 = null;
        goto L21
    L11:
        if ((r7 instanceof g0) == false) goto L16;
        h4 r5 = ((g0) r7).b;
        if (r5 == null) goto L20;
        r2 = r5.getBackground();
        goto L21
    L16:
        if ((r7 instanceof v) == false) goto L20;
        va r11 = ((v) r7).b;
        if (r11 == null) goto L20;
        r2 = r11.getBackground();
        goto L21
    }

    public /* synthetic */ TextMessageRenderViewHolder(f r7, k r8, boolean r9, e52.a r10) {
        this(r7, r8, r9, r10, null);
    }

    public TextMessageRenderViewHolder(f r2, k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r3, boolean r4, e52.a r5, g52.c r6) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "processor");
        super(r2.a);
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        TextView r7 = r2.b;
        this.b = r7;
        this.c = r2.c;
        this.l = new h(this);
        c r8 = new c(this);
        this.e = AnonymousClass3.INSTANCE;
        this.f = AnonymousClass4.INSTANCE;
        this.i = AnonymousClass5.INSTANCE;
        this.j = AnonymousClass6.INSTANCE;
        this.g = AnonymousClass7.INSTANCE;
        this.h = AnonymousClass8.INSTANCE;
        this.d = d.a;
        r7.setMovementMethod(u.a());
        r7.setHighlightColor(0);
        t.a(r7);
        r7.setOnClickListener(new a(this, r3.c(r8)));
        r7.setOnLongClickListener(new b(this));
    }
}
