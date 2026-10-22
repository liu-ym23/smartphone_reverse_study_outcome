package com.larus.search.impl.global;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.utils.a4;
import com.larus.business.search.impl.databinding.LarusFragmentGlobalSearchBinding;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.search.impl.common.ConversationRepoManager;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ic8.l0;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import tx9.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class GlobalSearchFragment$eventHelper$1 implements SearchResultItemView.b {
    public final /* synthetic */ GlobalSearchFragment a;

    public static final class a implements com.larus.common_ui.dialog.u {
        public a() {
        }

        public final void cancel() {
        }
    }

    public GlobalSearchFragment$eventHelper$1(GlobalSearchFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.search.impl.global.view.SearchResultItemView.b
    public final void a(RecommendBot r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new GlobalSearchFragment$eventHelper$1$onBotAdd$1(this.a, r8, r9, null), 3, null);
    }

    @Override // com.larus.search.impl.global.view.SearchResultItemView.b
    public final void b(final RecommendBot r23, final int r24) {
        Intrinsics.checkNotNullParameter(r23, "data");
        GlobalSearchFragment r2 = this.a;
        r2.p.a(r2.h);
        CommonDialog.a r3 = new CommonDialog.a();
        r3.i(this.a.getString(2131900768));
        r3.g(this.a.getString(2131900204));
        final GlobalSearchFragment r4 = this.a;
        boolean r6 = false;
        CommonDialog.a.f(r3, new GlobalSearchFragment$eventHelper$1$onBotRemove$1(r4, r23, r24), r4.getString(2131900203), false, 12);
        CommonDialog.a.e(r3, new a(), this.a.getString(2131900202), 4);
        CommonDialog r5 = r3.a();
        FragmentManager r7 = this.a.getChildFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        String r9 = null;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, null, r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r5, r8) == false) goto L40;
    L7:
        a4.a.getClass();
        a4.a(a4.b);
        GlobalSearchFragment r10 = this.a;
        r10.getClass();
        if (AudioServiceDelegate.a.B(r23.o(), r23.r(), r23.c0()) == null) goto L11;
        r6 = true;
    L11:
        if (r6 == false) goto L13;
        String r18 = "1";
    L14:
        String r11 = r23.o();
        SearchMobParam r12 = r23.b;
        if (r12 == null) goto L17;
        String r15 = r12.c;
    L18:
        if (r12 == null) goto L20;
        String r16 = r12.d;
    L21:
        if (r12 == null) goto L23;
        String r17 = r12.e;
    L24:
        if (r12 == null) goto L26;
        String r13 = r12.f;
    L28:
        if (o0.d(r23.e()) == false) goto L30;
        String r14 = "1";
    L31:
        RecommendFrom r1 = r23.a;
        if (r1 == null) goto L34;
        String r19 = r1.b;
    L35:
        if (r1 == null) goto L37;
        r9 = r1.a;
    L37:
        w3.a(r11, "click_check", null, r14, null, r13, r9, r19, r15, r16, r17, r18, null, r10, 99444);
        return;
    L34:
        r19 = null;
        goto L35
    L30:
        r14 = "0";
        goto L31
    L26:
        r13 = null;
        goto L28
    L23:
        r17 = null;
        goto L24
    L20:
        r16 = null;
        goto L21
    L17:
        r15 = null;
        goto L18
    L13:
        r18 = "0";
        goto L14
    L40:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L6:
        r5.show(r7, null);
        goto L7
    }

    @Override // com.larus.search.impl.global.view.SearchResultItemView.b
    public final void c(RecommendBot r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new GlobalSearchFragment$eventHelper$1$onUpdateCreateScene$1(this.a, r8, r9, null), 3, null);
    }

    @Override // com.larus.search.impl.global.view.SearchResultItemView.b
    public final void d(RecommendBot r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "data");
        GlobalSearchFragment r0 = this.a;
        r0.p.a(r0.h);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new GlobalSearchFragment$eventHelper$1$onBotClick$1(this, r11, this.a, r12, null), 3, null);
    }

    public static final Object e(GlobalSearchFragment$eventHelper$1 r9, RecommendBot r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof GlobalSearchFragment$eventHelper$1$checkAndCreateLocalConversation$1) == false) goto L7;
        GlobalSearchFragment$eventHelper$1$checkAndCreateLocalConversation$1 r0 = (GlobalSearchFragment$eventHelper$1$checkAndCreateLocalConversation$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = false;
        String r4 = "";
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L77:
        String r14 = (String) r12;
    L79:
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        wc9.e r15 = (wc9.e) r0.L$1;
        RecommendBot r5 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L64:
        if (r15 == null) goto L70;
        Integer r16 = r15.t;
        if (r16 == null) goto L72;
        if (r16.intValue() == 2) goto L70;
    L72:
        if (o0.d(r5.E()) == false) goto L74;
        r14 = r5.E();
        goto L79
    L74:
        ConversationRepoManager r17 = ConversationRepoManager.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        r12 = r17.b(r5, r0);
        if (r12 != r13) goto L77;
        return r13;
    L70:
        r5.G0(null);
        goto L72
    L18:
        r10 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        r5 = r10;
        r15 = (wc9.e) r12;
        if (r15 == null) goto L60;
        Integer r18 = r15.f;
        if (r18 == null) goto L60;
        if (r18.intValue() != 1) goto L60;
        r3 = true;
    L60:
        if (r3 == false) goto L64;
        ConversationRepoManager r19 = ConversationRepoManager.a;
        String r20 = r15.a;
        r0.L$0 = r5;
        r0.L$1 = r15;
        r0.label = 3;
        if (ConversationRepoManager.g(r20, r5, r0) != r13) goto L64;
        return r13;
    L20:
        r10 = (RecommendBot) r0.L$1;
        RecommendBot r6 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L44:
        r10.G0((String) r12);
        r10 = r6;
    L45:
        ConversationRepoManager r21 = ConversationRepoManager.a;
        String r22 = r10.o();
        if (r22 == null) goto L49;
        r4 = r22;
    L49:
        r0.L$0 = r10;
        r0.L$1 = null;
        r0.label = 2;
        r12 = ConversationRepoManager.c(r4, r0);
        if (r12 != r13) goto L19;
        return r13;
    L21:
        ResultKt.throwOnFailure(r12);
        if (r10.j0() == false) goto L34;
        String r23 = r10.E();
        if (r23 != null) goto L26;
    L29:
        boolean r24 = true;
    L30:
        if (r24 == true) goto L37;
        int r25 = wf9.a.a;
        if (wf9.a.a(r10.E()) == false) goto L34;
    L37:
        ConversationRepoManager r26 = ConversationRepoManager.a;
        String r27 = r10.o();
        if (r27 != null) goto L40;
        r27 = "";
    L40:
        r0.L$0 = r10;
        r0.L$1 = r10;
        r0.label = 1;
        r12 = ConversationRepoManager.d(r27, r0);
        if (r12 == r13) goto L80;
        r6 = r10;
        goto L44
    L80:
        return r13;
    L26:
        if (r23.length() == 0) goto L29;
        r24 = false;
    L34:
        if (r10.j0() == true) goto L45;
        int r28 = wf9.a.a;
        if (wf9.a.a(r10.E()) == true) goto L45;
    L7:
        r0 = new GlobalSearchFragment$eventHelper$1$checkAndCreateLocalConversation$1(r9, r11);
        goto L8
    }

    public static void f(GlobalSearchFragment$eventHelper$1 r28, RecommendBot r29, String r30, int r31) {
        LarusFragmentGlobalSearchBinding r1 = r28.a.e;
        if (r1 == null) goto L8;
        SearchBar r2 = r1.c;
        if (r2 == null) goto L8;
        ViewExtKt.g(r2);
    L8:
        if (AudioServiceDelegate.a.B(r29.o(), r29.r(), r29.c0()) == null) goto L10;
        String r5 = String.valueOf(r31 + 1);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r28.a), null, null, new GlobalSearchFragment$eventHelper$1$directToRealtimeCall$1(r28.a, r30, "", r29, r5, null), 3, null);
        return;
    L10:
        ConversationPage r3 = r29.F();
        if (r3 == null) goto L13;
        List r4 = r3.getPageList();
    L15:
        if (l0.b(r4) == false) goto L25;
        com.bytedance.router.i r6 = SmartRouter.buildRoute(r28.a.getContext(), "//flow/chat_page_double_tab");
        Pair[] r14 = new Pair[14];
        r14[0] = TuplesKt.to("argPreviousPage", r28.a.k());
        r14[1] = TuplesKt.to("argConversationId", r30);
        r14[2] = TuplesKt.to("argClickEnterFrom", "");
        r14[3] = TuplesKt.to("enter_method", "click_chat");
        r14[4] = TuplesKt.to("argBotPosition", String.valueOf(r31 + 1));
        r14[5] = TuplesKt.to("argBotRecommendFrom", r29.a);
        r14[6] = TuplesKt.to("enter_from", "bot_search");
        r14[7] = TuplesKt.to("navigate_up_from", r28.a.k());
        int r7 = f5.a;
        ConversationPage r8 = r29.F();
        if (r8 == null) goto L19;
        Integer r9 = r8.getDefaultStatus();
    L20:
        r14[8] = TuplesKt.to("default_tab", Integer.valueOf(f5.a(r9)));
        r14[9] = TuplesKt.to("conversation_page", r29.F());
        r14[10] = TuplesKt.to("is_create_sub_conversation", Boolean.FALSE);
        SearchMobParam r10 = r29.b;
        if (r10 == null) goto L23;
        GlobalSearchFragment r11 = r28.a;
        r10.a = r11.h;
        r10.b = r11.i;
        Unit r12 = Unit.INSTANCE;
        SearchMobParam r13 = r10;
    L24:
        r14[11] = TuplesKt.to("argSearchMobParam", r13);
        r14[12] = TuplesKt.to("recommend_bot_mob_segment", r29.I0(""));
        r14[13] = TuplesKt.to("argBotId", r29.o());
        Bundle r15 = com.larus.utils.f.c(r14);
        by7.h.k(r15, r28.a);
        r6.c.putExtras(r15);
        r6.d();
        return;
    L23:
        r13 = null;
        goto L24
    L19:
        r9 = null;
        goto L20
    L25:
        com.bytedance.router.i r16 = SmartRouter.buildRoute(r28.a.getContext(), "//flow/chat_page");
        Pair[] r17 = new Pair[14];
        r17[0] = TuplesKt.to("argPreviousPage", r28.a.k());
        r17[1] = TuplesKt.to("argConversationId", r30);
        r17[2] = TuplesKt.to("argClickEnterFrom", "");
        r17[3] = TuplesKt.to("argCvsBgImgUrl", r29.e());
        r17[4] = TuplesKt.to("argCvsBgImgColor", r29.a());
        r17[5] = TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r29.c()));
        r17[6] = TuplesKt.to("enter_method", "click_chat");
        r17[7] = TuplesKt.to("argBotRecommendFrom", r29.a);
        r17[8] = TuplesKt.to("argBotPosition", String.valueOf(r31 + 1));
        r17[9] = TuplesKt.to("enter_from", "bot_search");
        r17[10] = TuplesKt.to("navigate_up_from", r28.a.k());
        r17[11] = TuplesKt.to("recommend_bot_mob_segment", r29.I0(""));
        SearchMobParam r18 = r29.b;
        if (r18 == null) goto L28;
        GlobalSearchFragment r19 = r28.a;
        r18.a = r19.h;
        r18.b = r19.i;
        Unit r20 = Unit.INSTANCE;
    L29:
        r17[12] = TuplesKt.to("argSearchMobParam", r18);
        r17[13] = TuplesKt.to("argBotId", r29.o());
        Bundle r21 = com.larus.utils.f.c(r17);
        by7.h.k(r21, r28.a);
        r16.c.putExtras(r21);
        r16.d();
        GlobalSearchFragment r0 = r28.a;
        Job r22 = r0.r;
        if (r22 == null) goto L32;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
    L32:
        r0.r = null;
        com.larus.im.service.o r23 = (com.larus.im.service.o) r0.q.getValue();
        GlobalSearchFragment$botUpdateListener$1 r24 = r0.t;
        r23.unregisterBotChangeListener(r24.a, r24);
        if (r0.e == null) goto L39;
        r0.r = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0.getViewLifecycleOwner()), null, null, new GlobalSearchFragment$observeBotChange$1(r0, r29, null), 3, null);
        return;
    L39:
        return;
    L28:
        r18 = null;
        goto L29
    L13:
        r4 = null;
        goto L15
    }
}
