package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.FrequentChatABHelper;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FrequentCommentSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<FrequentChatController, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public FrequentChatController c;
    public View d;

    public final class FrequentChatController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j implements FrequentChatPresenter.a {
        public final RecyclerView c;
        public final TextView d;
        public final View e;
        public final View f;
        public final View g;
        public final FrequentChatPresenter h;
        public final CardView i;
        public final View j;
        public final TextView k;
        public final TextView l;
        public final TextView m;
        public final /* synthetic */ FrequentCommentSectionProvider n;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ FrequentChatController a;

            public a(FrequentChatController r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.h.d0();
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter.a
        public final void Cg() {
            this.d.setText(com.bytedance.android.live.core.utils.s1.C(2131897041, new Object[]{String.valueOf(this.h.c0()), String.valueOf(this.h.j)}));
            h();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter.a
        public final void Ih() {
            this.h.e0(FrequentChatShowMode.READ);
            Cg();
            UtilityKotlinExtentionsKt.w(this.i);
            com.bytedance.android.live.core.utils.a1.k(this.c, -2);
            UtilityKotlinExtentionsKt.w(this.c);
            UtilityKotlinExtentionsKt.t(this.f);
            UtilityKotlinExtentionsKt.t(this.m);
            UtilityKotlinExtentionsKt.w(this.k);
            UtilityKotlinExtentionsKt.w(this.l);
            if (this.h.c0() <= 0) goto L5;
            UtilityKotlinExtentionsKt.t(this.e);
        L7:
            if (this.h.c0() != 0) goto L9;
            int r0 = com.bytedance.android.live.liveinteract.f.a(2131107021, FrequentCommentSectionProvider$FrequentChatController$updateBtnColor$color$1.INSTANCE);
        L10:
            this.k.setTextColor(r0);
            this.l.setTextColor(r0);
            if (this.h.c0() <= 0) goto L13;
            this.k.setOnClickListener(new b0(this));
            this.l.setOnClickListener(new c0(this));
            return;
        L13:
            this.k.setOnClickListener(null);
            this.l.setOnClickListener(null);
            return;
        L9:
            r0 = com.bytedance.android.live.liveinteract.f.a(2131107010, FrequentCommentSectionProvider$FrequentChatController$updateBtnColor$color$2.INSTANCE);
            goto L10
        L5:
            UtilityKotlinExtentionsKt.w(this.e);
            goto L7
        }

        public final void h() {
            if (this.c.computeVerticalScrollOffset() <= 0) goto L5;
            this.i.setCardElevation(20.0f);
            int r0 = InteractivityOpt.b(2131109391, FrequentCommentSectionProvider$FrequentChatController$updateHeaderElevationAndColor$color$1.INSTANCE);
            this.i.setCardBackgroundColor(r0);
            return;
        L5:
            this.i.setCardElevation(0.0f);
            int r1 = InteractivityOpt.b(2131107055, FrequentCommentSectionProvider$FrequentChatController$updateHeaderElevationAndColor$color$2.INSTANCE);
            this.i.setCardBackgroundColor(r1);
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter.a
        public final void iP() {
            UtilityKotlinExtentionsKt.t(this.c);
            UtilityKotlinExtentionsKt.t(this.i);
            UtilityKotlinExtentionsKt.t(this.c);
            UtilityKotlinExtentionsKt.w(this.f);
            this.g.setOnClickListener(new a(this));
        }

        public static final void g(FrequentChatController r2, FrequentChatShowMode r3) {
            r2.getClass();
            if (r3 != FrequentChatShowMode.READ) goto L6;
            r2.h.f0();
            return;
        L6:
            if (r3 != FrequentChatShowMode.SORT) goto L8;
            com.bytedance.android.live.core.utils.a1.k(r2.c, -1);
        L8:
            UtilityKotlinExtentionsKt.t(r2.l);
            UtilityKotlinExtentionsKt.t(r2.k);
            UtilityKotlinExtentionsKt.w(r2.m);
            r2.m.setOnClickListener(new a0(r2));
            r2.h.e0(r3);
        }

        public FrequentChatController(FrequentCommentSectionProvider r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.n = r2;
            super(r3, r4);
            this.c = r3.findViewById(2131373305);
            this.d = (TextView) r3.findViewById(2131373308);
            this.e = r3.findViewById(2131373304);
            View r5 = r3.findViewById(2131373301);
            this.f = r5;
            this.g = r5.findViewById(2131373309);
            this.h = new FrequentChatPresenter();
            this.i = r3.findViewById(2131373303);
            View r6 = r3.findViewById(2131373302);
            this.j = r6;
            this.k = (TextView) r6.findViewById(2131373306);
            this.l = (TextView) r6.findViewById(2131373307);
            this.m = (TextView) r6.findViewById(2131371425);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        FrequentChatController r0 = this.c;
        if (r0 == null) goto L6;
        FrequentChatPresenter r1 = r0.h;
        int r2 = ((ArrayList) r1.c).size();
        r1.b.clear();
        ((ArrayList) r1.c).clear();
        r1.d.notifyItemRangeRemoved(0, r2);
        UtilityKotlinExtentionsKt.t(r0.i);
        UtilityKotlinExtentionsKt.t(r0.c);
        UtilityKotlinExtentionsKt.t(r0.e);
        UtilityKotlinExtentionsKt.t(r0.f);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        FrequentChatController r0 = this.c;
        if (r0 == null) goto L6;
        FrequentChatPresenter r1 = r0.h;
        int r2 = ((ArrayList) r1.c).size();
        r1.b.clear();
        ((ArrayList) r1.c).clear();
        r1.d.notifyItemRangeRemoved(0, r2);
        FrequentChatPresenter r3 = r0.h;
        RecyclerView r4 = r0.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "view");
        r3.e.attachToRecyclerView(null);
        r4.setAdapter(null);
        r0.h.detachView();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.d;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 == null) goto L12;
        int r3 = r2.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r3);
        goto L14
    L12:
        r3 = 0;
        goto L13
    L7:
        if (r1.W() != 0) goto L9;
        int r4 = InputPanelSectionContainer.m;
        r3 = InputPanelSectionContainer.m;
    L14:
        FrequentChatController r5 = this.c;
        if (r5 == null) goto L18;
        r5.h.d0();
        return;
    }

    public FrequentCommentSectionProvider() {
        this.a = InputSectionType.FREQUENT_CHAT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9) {
        Intrinsics.checkNotNullParameter(r9, "panelBridge");
        Activity r0 = r9.getActivity();
        Context r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r9;
        View r2 = LayoutInflater.from(r0).inflate(2131567711, null);
        this.d = r2;
        final FrequentChatController r3 = new FrequentChatController(this, r2, r9);
        FrequentChatPresenter r10 = r3.h;
        r10.getClass();
        ((q46.b) r10).a = r3;
        r10.h = r3.b;
        FrequentChatPresenter r11 = r3.h;
        RecyclerView r4 = r3.c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r4, "view");
        r11.e.attachToRecyclerView(r4);
        r4.setAdapter(r11.d);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r13 = r3.n.b;
        if (r13 == null) goto L8;
        DataCenter r14 = r13.R();
    L9:
        com.bytedance.android.livesdk.interactivity.api.h r15 = com.bytedance.android.livesdk.interactivity.api.i.b(r14, 1);
        if (r15 == null) goto L14;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g> r16 = r15.getFrequentChatInfo();
        if (r16 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g r17 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g) r16.getValue();
    L15:
        Lazy r5 = FrequentChatABHelper.a;
        String r6 = ((ss1.d) r5.getValue()).introTitle;
        if (r6 != null) goto L18;
        r6 = com.bytedance.android.live.core.utils.s1.B(2131916736);
    L18:
        String r7 = ((ss1.d) r5.getValue()).anchorAndAdminIntroText;
        if (r7 != null) goto L21;
        r7 = com.bytedance.android.live.core.utils.s1.C(2131916735, new Object[]{com.bytedance.android.live.core.utils.s1.B(2131916734)});
    L21:
        if (r17 == null) goto L40;
        String r8 = r17.title;
        if (r8 != null) goto L25;
    L28:
        boolean r18 = true;
    L29:
        if (r18 == true) goto L31;
        r6 = r17.title;
    L31:
        String r19 = r17.text;
        if (r19 != null) goto L34;
    L37:
        boolean r20 = true;
    L38:
        if (r20 == true) goto L40;
        r7 = r17.text;
        goto L40
    L34:
        if (StringsKt.isBlank(r19) == true) goto L37;
        r20 = false;
        goto L38
    L25:
        if (StringsKt.isBlank(r8) == true) goto L28;
        r18 = false;
    L40:
        ((TextView) r3.e.findViewById(2131388772)).setText(r6);
        ((TextView) r3.e.findViewById(2131368847)).setText(r7);
        RecyclerView r21 = r3.c;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r23 = r3.n.b;
        if (r23 == null) goto L43;
        r1 = r23.getContext();
    L43:
        r21.setLayoutManager(new LinearLayoutManager(r1, 1, false));
        RecyclerView.ItemAnimator r24 = r3.c.getItemAnimator();
        if (r24 == null) goto L46;
        r24.setMoveDuration(100);
        r24.setAddDuration(0);
        r24.setChangeDuration(0);
        r24.setRemoveDuration(0);
    L46:
        r3.c.addItemDecoration(new SpaceItemDecoration(1, com.bytedance.android.live.core.utils.s1.f(12.0f), true));
        r3.c.addOnScrollListener(new FrequentCommentSectionProvider$FrequentChatController$init$2(r3));
        Unit r25 = Unit.INSTANCE;
        this.c = r3;
        return r2;
    L14:
        r17 = null;
        goto L15
    L8:
        r14 = null;
        goto L9
    }
}
