package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.message.i6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.input.ActivityEmojiAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.InputFunction;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.InputFunctionList;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.FrequentChatABHelper;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.h> {
    public static final a e = null;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;
    public c b;
    public final d c;
    public final InputSectionType d;

    public static final class a implements z62.h {
        public a() {
        }

        @Override // z62.h
        public final void F(int r1) {
        }

        @Override // z62.h
        public final boolean i() {
            return true;
        }

        @Override // z62.h
        public final void s(InputFunctionEnum r2) {
            Intrinsics.checkNotNullParameter(r2, "panel");
        }

        @Override // z62.h
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b z() {
            return null;
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public final HorizontalScrollView c;
        public final HorizontalScrollView d;
        public final LinearLayout e;
        public final LinearLayout f;
        public final LinearLayout g;
        public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final List<InputFunction> q;
        public final int r;
        public final int s;
        public final int t;
        public final Integer u;
        public com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f v;
        public final Set<String> w;
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g x;

        public static final void g(c r7) {
            int r0 = r7.c.getScrollX();
            int r1 = r7.c.getWidth();
            int r2 = r7.e.getChildCount();
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L18;
            View r4 = r7.e.getChildAt(r3);
            int r5 = r4.getLeft();
            if (r4.getRight() <= r0) goto L17;
            if (r5 >= (r0 + r1)) goto L17;
            Object r6 = r4.getTag();
            if (Intrinsics.areEqual(r6, "quick_interaction") == false) goto L12;
            r7.w.add("quick_interaction");
            goto L17
        L12:
            if (Intrinsics.areEqual(r6, "activityEmoji") == false) goto L15;
            r7.w.add("quick_activity");
            goto L17
        L15:
            if (Intrinsics.areEqual(r6, "quick_emoji") == false) goto L17;
            r7.w.add("quick_emoji");
        L17:
            r3 = r3 + 1;
            goto L3
        }

        public final InputFunctionEnum h(InputFunctionEnum r8) {
            List<InputFunction> r0 = this.q;
            if (r0 == null) goto L14;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L14;
            InputFunction r2 = (InputFunction) r1.next();
            if (r8.getMark() != r2.functionId) goto L6;
            int r3 = r2.type;
            InputFunctionType r4 = InputFunctionType.Common;
            if (r3 == r4.getType()) goto L13;
            r4 = InputFunctionType.Special;
        L13:
            r8.setType(r4);
            r8.setPriority(r2.priority);
        L14:
            return r8;
        }

        public c(d1 r4, View r5, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6) {
            Intrinsics.checkNotNullParameter(r5, "sectionView");
            Intrinsics.checkNotNullParameter(r6, "bridge");
            super(r5, r6);
            this.x = r6;
            this.c = (HorizontalScrollView) r5.findViewById(2131377808);
            this.d = (HorizontalScrollView) r5.findViewById(2131384622);
            this.e = (LinearLayout) r5.findViewById(2131383938);
            this.f = (LinearLayout) r5.findViewById(2131375374);
            this.g = (LinearLayout) r5.findViewById(2131375373);
            this.i = r6.i0();
            this.j = FrequentChatABHelper.a(r6);
            int r7 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.h.a;
            DataCenter r8 = r6.R();
            List<InputFunction> r0 = null;
            if (r8 == null) goto L5;
            IRoom r9 = com.bytedance.android.live.core.utils.a0.n(r8);
        L6:
            this.k = com.bytedance.android.livesdk.interactivity.publicscreen.utils.h.a(r6, r9);
            this.l = r6.j0();
            CommentFlowContext r10 = r6.S();
            if (r10 == null) goto L11;
            CommentInputConfig r11 = r10.d;
            if (r11 == null) goto L11;
            CommentInputConfig.State r13 = r11.j;
        L13:
            if (r13 != CommentInputConfig.State.ForceOpen) goto L16;
            boolean r14 = true;
        L22:
            this.m = r14;
            this.n = r6.e0();
            this.o = r6.h0();
            this.p = r6.c0();
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r15 = r4.a;
            if (r15 == null) goto L25;
            DataCenter r16 = r15.R();
        L26:
            com.bytedance.android.livesdk.interactivity.api.h r17 = com.bytedance.android.livesdk.interactivity.api.i.b(r16, 1);
            if (r17 == null) goto L33;
            com.bytedance.live.datacontext.j<InputFunctionList> r18 = r17.getInputFunctionInfo();
            if (r18 == null) goto L33;
            InputFunctionList r19 = (InputFunctionList) r18.getValue();
            if (r19 == null) goto L33;
            r0 = r19.list;
        L33:
            this.q = r0;
            this.r = com.bytedance.android.live.core.utils.s1.k(2131168801);
            this.s = UtilityKotlinExtentionsKt.i(26);
            this.t = UtilityKotlinExtentionsKt.i(20);
            this.u = (Integer) ec2.e0.a.getValue();
            this.w = new LinkedHashSet();
            return;
        L25:
            r16 = null;
            goto L26
        L16:
            if (r13 == CommentInputConfig.State.ForeClose) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r20 = r6.V();
            if (r20 == null) goto L21;
            r14 = r20.f;
        L21:
            r14 = false;
        L11:
            r13 = null;
            goto L13
        L5:
            r9 = null;
            goto L6
        }
    }

    public static final class d implements z62.h {
        public final /* synthetic */ d1 a;

        @Override // z62.h
        public final boolean i() {
            c r0 = this.a.b;
            if (r0 == null) goto L13;
            com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r1 = r0.v;
            if (r1 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 != true) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (r1.i != true) goto L9;
            r2 = true;
            goto L10
        L13:
            return false;
        }

        @Override // z62.h
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b z() {
            c r0 = this.a.b;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.h;
        }

        public d(d1 r1) {
            this.a = r1;
        }

        @Override // z62.h
        public final void F(int r7) {
            c r0 = this.a.b;
            if (r0 == null) goto L27;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r1 = r0.h;
            if (r1 == null) goto L44;
            InputFunctionEnum r2 = InputFunctionEnum.ChatInputCarrier_Audio;
            Intrinsics.checkNotNullParameter(r2, "function");
            Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r3 = r1.a.entrySet().iterator();
        L8:
            if (r3.hasNext() == false) goto L17;
            Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r4 = r3.next();
            if (r4.getKey() != r2) goto L8;
            View r5 = r4.getValue().getView();
            if (r5 == null) goto L8;
            TextView r6 = (TextView) r5.findViewById(2131367920);
            if (r6 == null) goto L16;
            r6.setBackgroundResource(r7);
        L16:
            r4.getValue().p(r1.k);
            goto L8
        L17:
            Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r8 = r1.b.entrySet().iterator();
        L19:
            if (r8.hasNext() == false) goto L45;
            Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r9 = r8.next();
            if (r9.getKey() != r2) goto L19;
            View r10 = r9.getValue().getView();
            if (r10 == null) goto L19;
            TextView r11 = (TextView) r10.findViewById(2131367920);
            if (r11 == null) goto L19;
            r11.setBackgroundResource(r7);
            goto L19
        L45:
            return;
        L44:
            return;
        }

        @Override // z62.h
        public final void s(InputFunctionEnum r4) {
            Intrinsics.checkNotNullParameter(r4, "panel");
            c r1 = this.a.b;
            if (r1 == null) goto L12;
            Intrinsics.checkNotNullParameter(r4, "panel");
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r0 = r1.h;
            if (r0 == null) goto L13;
            Intrinsics.checkNotNullParameter(r4, "symbol");
            if (r0.c(r4) != 2) goto L14;
            com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r5 = r0.d;
            if (r5 == null) goto L15;
            r5.e(0, true);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        e = new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        c r0 = this.b;
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r1 = r0.h;
        if (r1 == null) goto L14;
        r1.a.clear();
        r1.b.clear();
        ((LinkedHashMap) r1.c).clear();
        Iterator r2 = ((ArrayList) r1.e).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r2.next()).s(r1.k);
        goto L8
    L10:
        ((ArrayList) r1.e).clear();
        r1.f.clear();
        return;
    L14:
        return;
    }

    public d1() {
        this.c = new d(this);
        this.d = InputSectionType.CONTROL_PORTRAIT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r33) {
        Intrinsics.checkNotNullParameter(r33, "panelBridge");
        Activity r2 = r33.getActivity();
        if (r2 != null) goto L5;
        return null;
    L5:
        this.a = r33;
        View r3 = LayoutInflater.from(r2).inflate(2131567705, null);
        final c r10 = new c(this, r3, r33);
        r10.h = new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b(r10.x, r10.f, r10.d, r10.c);
        Context r1 = r10.x.getContext();
        int r9 = 16;
        if (r1 == null) goto L136;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r4 = r10.h;
        if (r4 == null) goto L136;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.e r5 = new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.e(r10.h(InputFunctionEnum.ChatInputCarrier_Emoji), r1, InputSectionType.EMOJI);
        r5.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(Integer.MAX_VALUE));
        Unit r6 = Unit.INSTANCE;
        r4.d(r5);
        if (r10.n == false) goto L14;
    L15:
        r4.d(new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.b(r10.h(InputFunctionEnum.ChatInputCarrier_Audio), r1, InputSectionType.AUDIO_COMPOSE));
    L17:
        if (r10.o == false) goto L19;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.i r7 = new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.i(r10.h(InputFunctionEnum.ChatInputCarrier_Highlight), r1, InputSectionType.MARK_HIGHLIGHT);
        r7.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(3910));
        r4.d(r7);
    L19:
        CommentFlowContext r8 = r10.x.S();
        if (r8 == null) goto L24;
        CommentInputConfig r11 = r8.d;
        if (r11 == null) goto L24;
        CommentInputConfig.State r13 = r11.h;
    L26:
        if (r13 != CommentInputConfig.State.ForceOpen) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == false) goto L53;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r15 = r10.x.V();
        if (r15 == null) goto L50;
        Map<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> r16 = r15.d;
        if (r16 == null) goto L50;
        Iterator<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r17 = r16.values().iterator();
    L41:
        if (r17.hasNext() == false) goto L50;
        com.bytedance.android.livesdk.interactivity.api.comment.data.f r18 = r17.next();
        if (r18 == null) goto L41;
        if (r18.type != 1) goto L41;
        if (r18.status != 1) goto L41;
        boolean r19 = true;
    L51:
        if (r19 == false) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == false) goto L57;
        r4.d(new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.d(r10.h(InputFunctionEnum.ChatInputCarrier_CustomerService), r1));
    L57:
        if (r10.i == false) goto L60;
        r4.d(new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.k(r10.h(InputFunctionEnum.ChatInputCarrier_Share), r1, InputSectionType.INTERACTIVITY_SHARE));
    L60:
        if (r10.l == false) goto L63;
        r4.d(new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.l(r10.h(InputFunctionEnum.ChatInputCarrier_Video), r1, InputSectionType.VIDEO));
    L63:
        if (r10.j == false) goto L66;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.h r21 = new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.h(r10.h(InputFunctionEnum.ChatInputCarrier_FastChat), r1, InputSectionType.FREQUENT_CHAT);
        r21.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(3170));
        Unit r23 = Unit.INSTANCE;
        r4.d(r21);
    L66:
        if (r10.m == false) goto L69;
        r4.d(new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.a(r10.h(InputFunctionEnum.ChatInputCarrier_AI), r1));
    L69:
        if (r10.k == false) goto L71;
        r4.d(new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.j(r10.h(InputFunctionEnum.ChatInputCarrier_Mention), r1));
    L71:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r24 = r10.h;
        if (r24 == null) goto L120;
        ((ArrayList) r24.e).clear();
        if (r24.b() > 3) goto L87;
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r25 = r24.a.entrySet().iterator();
    L77:
        if (r25.hasNext() == false) goto L79;
        ((ArrayList) r24.e).add(r25.next().getValue());
        goto L77
    L79:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r26 = r24.b.entrySet().iterator();
    L81:
        if (r26.hasNext() == false) goto L83;
        ((ArrayList) r24.e).add(r26.next().getValue());
        goto L81
    L83:
        CollectionsKt.reverse(r24.e);
        Iterator r27 = ((ArrayList) r24.e).iterator();
    L85:
        if (r27.hasNext() == false) goto L114;
        ((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r27.next()).m(1);
    L114:
        Iterator r28 = ((ArrayList) r24.e).iterator();
    L116:
        if (r28.hasNext() == false) goto L118;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r29 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r28.next();
        LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(-2, -2);
        r30.gravity = 16;
        r24.l.addView(r29.getView(), r30);
        r29.k(r24.k);
        goto L116
    L118:
        r24.e(false);
        goto L120
    L87:
        int r31 = r24.a.size();
        r24.b.size();
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r34 = r24.a.entrySet().iterator();
        int r110 = 0;
    L89:
        if (r34.hasNext() == false) goto L92;
        ((ArrayList) r24.e).add(r34.next().getValue());
        r110 = r110 + 1;
        if (r110 < Math.min(3 - Math.min(r24.b.size(), 1), r31)) goto L89;
    L92:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r35 = r24.b.entrySet().iterator();
        if (r35.hasNext() == false) goto L95;
        ((ArrayList) r24.e).add(r35.next().getValue());
        int r36 = 1;
    L96:
        CollectionsKt.reverse(r24.e);
        Iterator r37 = ((ArrayList) r24.e).iterator();
    L98:
        if (r37.hasNext() == false) goto L100;
        ((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r37.next()).m(1);
        goto L98
    L100:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r38 = r24.a.entrySet().iterator();
    L102:
        if (r38.hasNext() == false) goto L107;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r39 = r38.next();
        if (r110 > 0) goto L105;
        r39.getValue().m(2);
        ((ArrayList) r24.e).add(r39.getValue());
        goto L102
    L105:
        r110 = r110 - 1;
        goto L102
    L107:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r40 = r24.b.entrySet().iterator();
    L109:
        if (r40.hasNext() == false) goto L114;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r41 = r40.next();
        if (r36 > 0) goto L112;
        r41.getValue().m(2);
        ((ArrayList) r24.e).add(r41.getValue());
        goto L109
    L112:
        r36 = r36 - 1;
        goto L109
    L95:
        r36 = 0;
    L120:
        if (r4.b() <= 3) goto L136;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r43 = new com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f(InputFunctionEnum.ChatInputCarrier_Fold, r1);
        r43.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(Integer.MAX_VALUE));
        Unit r44 = Unit.INSTANCE;
        r10.v = r43;
        LinearLayout.LayoutParams r45 = new LinearLayout.LayoutParams(-2, -2);
        r45.gravity = 16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r46 = r10.v;
        if (r46 == null) goto L135;
        r4.d(r46);
        LinearLayout r47 = r10.g;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r48 = r10.v;
        if (r48 == null) goto L133;
        r47.addView(r48.getView(), r45);
        LinearLayout r49 = r10.g;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r50 = r10.v;
        if (r50 == null) goto L130;
        InputFunctionEnum r51 = r50.f;
        if (r51 == null) goto L130;
        String r53 = r51.getDesc();
    L131:
        r3.a(r49, r53);
        ViewGroup.LayoutParams r54 = r10.d.getLayoutParams();
        r54.width = r10.r * 3;
        r10.d.setLayoutParams(r54);
        com.bytedance.android.live.core.utils.a1.n(r10.d, r10.r);
    L130:
        r53 = null;
        goto L131
    L133:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.FoldBehavior");
    L135:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.FoldBehavior");
    L50:
        r19 = false;
    L53:
        r20 = false;
        goto L54
    L29:
        if (r13 != CommentInputConfig.State.ForeClose) goto L31;
        r14 = false;
        goto L33
    L31:
        Lazy r55 = PublicScreenABHelper.a;
    L24:
        r13 = null;
        goto L26
    L14:
        if (r10.p == false) goto L17;
    L136:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r56 = r10.h;
        if (r56 == null) goto L139;
        int r57 = RangesKt.coerceAtMost(r56.b(), 4);
    L140:
        final Context r58 = r10.e.getContext();
        if (r58 != null) goto L143;
        d1 r59 = this;
    L320:
        r10.x.q0(new e1(r10));
        Unit r0 = Unit.INSTANCE;
        r59.b = r10;
        return r3;
    L143:
        int r60 = (com.bytedance.android.live.core.utils.s1.y() - (r10.r * r57)) - UtilityKotlinExtentionsKt.i(10);
        ViewGroup.LayoutParams r61 = r10.c.getLayoutParams();
        r61.width = r60;
        r10.c.setLayoutParams(r61);
        List<BaseEmoji> r63 = com.bytedance.android.livesdk.interactivity.api.expression.h.b(r10.u.intValue());
        if (r10.x.d0() == false) goto L148;
        EffectiveActivityEmojiGroup r64 = com.bytedance.android.livesdk.interactivity.api.q.c();
        if (r64 == null) goto L148;
        ActivityEmojiGroup r111 = r64.getEmojiGroup();
    L149:
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = 0;
        if (r10.x.g0() == false) goto L162;
        fc2.g.a.getClass();
        if (((fc2.g) ec2.t0.a.getValue()).b() == false) goto L162;
        if (com.bytedance.android.livesdk.interactivity.api.q.k() == true) goto L162;
        i6 r65 = com.bytedance.android.livesdk.interactivity.api.q.f();
        if (r65 == null) goto L162;
        if (r65.b() != 1) goto L160;
        List r66 = r65.a();
    L161:
        List r67 = r66;
    L163:
        String r68 = BuildConfig.FLAVOR;
        if (r67 == null) goto L214;
        String r210 = com.bytedance.android.livesdk.interactivity.api.q.e();
        if (r210 != null) goto L168;
        String r211 = BuildConfig.FLAVOR;
    L170:
        if (r112.element >= r67.size()) goto L214;
        int r69 = UtilityKotlinExtentionsKt.i(r9);
        final Ref.ObjectRef r70 = new Ref.ObjectRef();
        com.bytedance.android.live.base.model.message.h r71 = (com.bytedance.android.live.base.model.message.h) ListProtector.get(r67, r112.element);
        r70.element = r71;
        if (r71.getType() != 2) goto L183;
        if (r211.length() != 0) goto L176;
        boolean r73 = true;
    L177:
        if (r73 == true) goto L181;
        String r74 = r211;
        if (Intrinsics.areEqual(r74, r68) == false) goto L185;
    L182:
        r112.element++;
        r211 = r74;
    L185:
        if (((com.bytedance.android.live.base.model.message.h) r70.element).getType() != 1) goto L187;
        String r75 = com.bytedance.android.live.core.utils.s1.B(2131916448);
    L188:
        String r76 = r75;
        int r77 = com.bytedance.android.livesdk.interactivity.api.expression.h.a;
        com.bytedance.android.live.base.model.message.h r78 = (com.bytedance.android.live.base.model.message.h) r70.element;
        View r212 = r3;
        List<BaseEmoji> r213 = r63;
        List r214 = r67;
        final String r79 = r74;
        String r215 = r68;
        ActivityEmojiGroup r216 = r111;
        String r217 = r74;
        final Ref.IntRef r80 = r112;
        Ref.IntRef r218 = r112;
        Function0<Unit> r81 = new NewPortraitControlSectionProvider$NewPortraitControlSectionController$initUIStyle$$inlined$let$lambda$1(r70, r79, r10, r80, r58);
        Intrinsics.checkNotNullParameter(r58, "context");
        Intrinsics.checkNotNullParameter(r78, "guideChat");
        Intrinsics.checkNotNullParameter(r76, "text");
        com.bytedance.android.live.core.widget.i r83 = new com.bytedance.android.live.core.widget.i(r58);
        r83.setText(r76);
        r83.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131107592));
        LinearLayout.LayoutParams r84 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.i(30));
        r84.gravity = 16;
        r83.setLayoutParams(r84);
        r83.setOnClickListener(new com.bytedance.android.livesdk.interactivity.api.expression.f(r81));
        ViewGroup.LayoutParams r85 = r83.getLayoutParams();
        if ((r85 instanceof LinearLayout.LayoutParams) == true) goto L191;
        r85 = null;
    L191:
        LinearLayout.LayoutParams r86 = (LinearLayout.LayoutParams) r85;
        if (r86 == null) goto L194;
        r86.leftMargin = r69;
    L194:
        com.bytedance.android.live.base.model.message.h r87 = (com.bytedance.android.live.base.model.message.h) r70.element;
        int r88 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
        if (r87 == null) goto L210;
        HashMap r89 = new HashMap();
        r89.put("emoji_type", "quick_interaction");
        if (r87.getType() != 1) goto L200;
        String r90 = "say_hi";
    L201:
        MiddlewareRoomContext r91 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r91 == null) goto L208;
        com.bytedance.live.datacontext.i r93 = r91.isAnchor();
        if (r93 == null) goto L208;
        if (((Boolean) r93.getValue()).booleanValue() != true) goto L208;
        String r94 = "1";
    L209:
        r89.put("is_anchor", r94);
        r89.put("quick_interaction_type", r90);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_quick_emoji_show", r89, new Object[]{am2.x.class, IRoom.class});
    L208:
        r94 = "0";
        goto L209
    L200:
        r90 = "location";
    L210:
        LinearLayout r95 = r10.e;
        if (r95 == null) goto L213;
        r95.addView(r83);
    L213:
        r218.element++;
        r83.setTag("quick_interaction");
        r112 = r218;
        r68 = r215;
        r211 = r217;
        r63 = r213;
        r3 = r212;
        r67 = r214;
        r111 = r216;
        r9 = 16;
        goto L170
    L187:
        r75 = com.bytedance.android.live.core.utils.s1.B(2131916446) + r74;
        goto L188
    L181:
        r74 = r211;
        goto L182
    L176:
        r73 = false;
        goto L177
    L183:
        r74 = r211;
        goto L185
    L168:
        r211 = r210;
    L214:
        View r219 = r3;
        List<BaseEmoji> r220 = r63;
        String r221 = r68;
        ActivityEmojiGroup r222 = r111;
        final Ref.IntRef r96 = r112;
        long r97 = 0;
        final int r98 = r96.element;
        if (r222 == null) goto L256;
        int r99 = (int) r222.getInsertEmojiNum();
    L217:
        int r100 = r96.element;
        List r101 = r222.getActivityEmojiList();
        if (r101 == null) goto L220;
        int r102 = r101.size();
    L222:
        if (r100 >= (RangesKt.coerceAtMost(r102, r99) + r98)) goto L256;
        if ((r96.element - r98) != 0) goto L226;
        int r103 = UtilityKotlinExtentionsKt.i(16);
    L227:
        int r104 = r103;
        List r105 = r222.getActivityEmojiList();
        if (r105 == null) goto L255;
        final com.bytedance.android.live.base.model.data.activityemoji.b r106 = (com.bytedance.android.live.base.model.data.activityemoji.b) ListProtector.get(r105, r96.element - r98);
        if (r106 == null) goto L255;
        int r107 = com.bytedance.android.livesdk.interactivity.api.expression.h.a;
        Function0<Unit> r108 = new NewPortraitControlSectionProvider$NewPortraitControlSectionController$initUIStyle$$inlined$let$lambda$2(r106, r10, r96, r98, r58);
        Intrinsics.checkNotNullParameter(r58, "context");
        Intrinsics.checkNotNullParameter(r106, "emoji");
        HSImageView r109 = new HSImageView(r58);
        py.k r113 = r106.getEmoji();
        if (r113 == null) goto L238;
        ImageUtil.loadImage(r109, r113, 0);
        int r114 = UtilityKotlinExtentionsKt.i(r113.getHeight()) / UtilityKotlinExtentionsKt.i(27);
        int r115 = UtilityKotlinExtentionsKt.i(r113.getWidth());
        if (r114 <= 0) goto L237;
        r115 = r115 / r114;
    L237:
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(r115, UtilityKotlinExtentionsKt.i(27));
        r116.gravity = 16;
        r109.setLayoutParams(r116);
        r109.setOnClickListener(new com.bytedance.android.livesdk.interactivity.api.expression.g(r108, r106));
        r3.a(r109, r106.getName());
    L238:
        ViewGroup.LayoutParams r117 = r109.getLayoutParams();
        if ((r117 instanceof LinearLayout.LayoutParams) == true) goto L241;
        r117 = null;
    L241:
        LinearLayout.LayoutParams r118 = (LinearLayout.LayoutParams) r117;
        if (r118 == null) goto L244;
        r118.leftMargin = r104;
    L244:
        LinearLayout r119 = r10.e;
        if (r119 == null) goto L247;
        r119.addView(r109);
    L247:
        int r120 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
        Intrinsics.checkNotNullParameter(r106, "emoji");
        HashMap r121 = new HashMap();
        String r122 = r106.getName();
        if (r122 != null) goto L250;
        r122 = r221;
    L250:
        r121.put("emoji_content", r122);
        r121.put("emoji_type", "quick_activity");
        String r123 = r106.getIdStr();
        if (r123 != null) goto L253;
        r123 = r221;
    L253:
        r121.put("emoji_id", r123);
        r121.put("emoticons_id", String.valueOf(r106.getActivityEmojiGroupId()));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_quick_emoji_show", r121, new Object[]{am2.x.class, IRoom.class});
        com.bytedance.android.livesdk.interactivity.comment.utils.a.d(r106, "quick");
        r96.element++;
        r109.setTag("activityEmoji");
    L255:
        r99 = r99;
        r97 = r97;
        goto L217
    L226:
        r103 = r10.t;
        goto L227
    L220:
        r102 = 0;
    L256:
        long r223 = r97;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L272;
        ActivityEmojiAutoTestUtil.c.getClass();
        if (ActivityEmojiAutoTestUtil.a == false) goto L272;
        if (r222 == null) goto L271;
        List r124 = r222.getActivityEmojiList();
        if (r124 == null) goto L265;
        int r125 = r124.size();
    L266:
        int r126 = RangesKt.coerceAtMost(r125, (int) r222.getInsertEmojiNum());
        List r127 = r222.getActivityEmojiList();
        if (r127 == null) goto L269;
        List r128 = CollectionsKt.take(r127, r126);
    L270:
        ActivityEmojiAutoTestUtil.a(r128, "FastArea");
        goto L272
    L269:
        r128 = null;
        goto L270
    L265:
        r125 = 0;
        goto L266
    L271:
        ActivityEmojiAutoTestUtil.a(null, "FastArea");
    L272:
        r59 = this;
        r3 = r219;
    L275:
        if (r96.element >= r220.size()) goto L319;
        if (r96.element != 0) goto L279;
        int r129 = UtilityKotlinExtentionsKt.i(16);
    L280:
        final BaseEmoji r130 = (BaseEmoji) ListProtector.get(r220, r96.element);
        int r131 = com.bytedance.android.livesdk.interactivity.api.expression.h.a;
        Function0<Unit> r132 = new NewPortraitControlSectionProvider$NewPortraitControlSectionController$initUIStyle$emojiImageView$1(r10, r130);
        Intrinsics.checkNotNullParameter(r58, "context");
        Intrinsics.checkNotNullParameter(r130, "emoji");
        HSImageView r133 = new HSImageView(r58);
        Context r134 = r58;
        r133.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (r130.getIconId() == 0) goto L285;
        r133.setImageResource(r130.getIconId());
    L290:
        r133.setOnClickListener(new com.bytedance.android.livesdk.interactivity.api.expression.e(r130, r132));
        r3.a(r133, r130.getDescription());
        int r135 = r10.s;
        LinearLayout.LayoutParams r136 = new LinearLayout.LayoutParams(r135, r135);
        r136.gravity = 16;
        r136.leftMargin = r129;
        int r137 = -1;
        if (r96.element != (r220.size() - 1)) goto L293;
        int r138 = UtilityKotlinExtentionsKt.i(16);
    L294:
        r136.rightMargin = r138;
        LinearLayout r139 = r10.e;
        if (r139 == null) goto L297;
        r139.addView(r133, r136);
    L297:
        int r140 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
        HashMap r141 = new HashMap();
        String r142 = r130.getDescription();
        if (r142 != null) goto L300;
        r142 = r221;
    L300:
        r141.put("emoji_content", r142);
        IMiddlewareUserService r143 = jc1.k.f(IMiddlewareUserService.class);
        if (r143 == null) goto L305;
        com.bytedance.android.livesdk.user.e r144 = r143.user();
        if (r144 == null) goto L305;
        IBaseUser r145 = r144.b();
    L306:
        if (r145 == null) goto L308;
        int r146 = r145.getGender();
    L309:
        if (r145 == null) goto L311;
        r137 = r145.getAgeRange();
    L311:
        r141.put("user_gender", String.valueOf(r146));
        r141.put("user_age", String.valueOf(r137));
        r141.put("user_group_id", fb2.e.a(r145));
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r147 = EmojiLocalRecentManager.a;
        String r148 = r130.getDescription();
        Intrinsics.checkNotNullParameter(r148, "desc");
        EmojiLocalRecentManager.c();
        LinkedHashMap<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r149 = EmojiLocalRecentManager.e;
        if (r149 == null) goto L314;
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r150 = r149.get(r148);
    L315:
        if (r150 == null) goto L317;
        long r224 = r150.d();
    L318:
        r141.put("recent_7d_cnt", String.valueOf(r224));
        r141.put("rank_score", String.valueOf(r130.recommendScore));
        r141.put("emoji_type", "quick_emoji");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_quick_emoji_show", r141, new Object[]{am2.x.class, IRoom.class});
        r96.element++;
        r133.setTag("quick_emoji");
        r58 = r134;
        r3 = r3;
        goto L275
    L317:
        r224 = r223;
        goto L318
    L314:
        r150 = null;
        goto L315
    L308:
        r146 = -1;
    L305:
        r145 = null;
        goto L306
    L293:
        r138 = 0;
        goto L294
    L285:
        if (r130.getDrawable() == null) goto L288;
        r133.setImageDrawable(r130.getDrawable());
        goto L290
    L288:
        if (TextUtils.isEmpty(r130.getLocalFilePath()) == true) goto L290;
        ImageLoader.bindImage(r133, "file://" + r130.getLocalFilePath());
        goto L290
    L279:
        r129 = r10.t;
        goto L280
    L319:
        r10.c.setOnTouchListener(new f1(r10));
        goto L320
    L160:
        r66 = null;
    L162:
        r67 = null;
    L148:
        r111 = null;
        goto L149
    L139:
        r57 = 0;
        goto L140
    }
}
