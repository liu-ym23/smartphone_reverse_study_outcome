package com.larus.bmhome.chat.helper;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.platform.service.m3;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationFragmentAbilityImpl implements com.larus.bmhome.chat.api.v {

    public static final class a {
    }

    static {
    }

    public ConversationFragmentAbilityImpl() {
    }

    @Override // com.larus.bmhome.chat.api.v
    public final void b(RecyclerView r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (r4 != null) goto L6;
        FLogger.a.i("DouBaoConversationFgtAbility", "attachFeedFpsTracer skip: recyclerView is null, scene=" + r5);
        return;
    L6:
        final et3.c r0 = new et3.c(r5, false, null);
        r0.b(new g0(r5));
        r4.addOnScrollListener(new ConversationFragmentAbilityImpl$attachFeedFpsTracer$1(r0));
    }

    @Override // com.larus.bmhome.chat.api.v
    public final void a(Context r11, String r12, by7.e r13) {
        Intrinsics.checkNotNullParameter("chat_list", "currentPageName");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L19;
        nq9.c r1 = m3.a.i("chat_list", r12);
        if (r1 == null) goto L9;
        String r4 = r1.b;
    L10:
        if (r1 == null) goto L12;
        String r5 = r1.a;
    L13:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r11, m3.f);
        Bundle r3 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat_list"), TuplesKt.to("previous_page", "chat_list"), TuplesKt.to("enter_method", r12), TuplesKt.to("create_way", r4), TuplesKt.to("creation_id", r5)});
        if (r13 == null) goto L16;
        by7.h.k(r3, r13);
    L16:
        r2.c.putExtras(r3);
        r2.d = 2130772400;
        r2.e = 2130772399;
        r2.d();
        tx9.c0.l(null, null, null, r12, r4, r5, null, null, r13, 911);
        return;
    L12:
        r5 = null;
        goto L13
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.larus.bmhome.chat.api.v
    public final void c(Fragment r12, by7.e r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "fragment");
        Intrinsics.checkNotNullParameter(r14, "previousPage");
        LiveData r15 = r12.getViewLifecycleOwnerLiveData();
        wc9.e r4 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r4 == null) goto L10;
        String r2 = r4.a;
        LifecycleOwner r16 = (LifecycleOwner) r15.getValue();
        if (r16 == null) goto L11;
        LifecycleCoroutineScope r17 = LifecycleOwnerKt.getLifecycleScope(r16);
        if (r17 == null) goto L12;
        BuildersKt.launch$default(r17, null, null, new ConversationFragmentAbilityImpl$startCreateConversation$1$1$1(r2, r12, r4, r13, null), 3, null);
        return;
    L12:
        return;
    L11:
        return;
    }
}
