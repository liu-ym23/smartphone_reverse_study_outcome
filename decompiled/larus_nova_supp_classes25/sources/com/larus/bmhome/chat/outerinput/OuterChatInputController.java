package com.larus.bmhome.chat.outerinput;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class OuterChatInputController implements c {
    public static final /* synthetic */ int d = 0;
    public final Fragment a;
    public final String b;
    public OuterChatInput c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.outerinput.c
    public final boolean a() {
        boolean r1 = false;
        if ((this.a.getActivity() instanceof b) == false) goto L6;
        return false;
    L6:
        if (this.b.length() != 0) goto L8;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        FLogger.a.d("OuterChatInputController", "tab page no config");
        return false;
    L13:
        List r2 = z2.a.t0();
        List r4 = CollectionsKt.listOf(new String[]{"aweme_feed_dialog", "aweeme_feed_fragment", "aweme_feed_conversation"});
        FLogger r5 = FLogger.a;
        r5.d("OuterChatInputController", "visibleTabList:" + r2 + ", forceVisibleTabList:" + r4);
        if (r2.contains(this.b) == false) goto L16;
    L17:
        r1 = true;
    L18:
        if (r1 == true) goto L20;
        r5.d("OuterChatInputController", "no in outer chat input test");
    L20:
        return r1;
    L16:
        if (r4.contains(this.b) == false) goto L18;
    L8:
        r0 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.outerinput.c
    public final void c(String r9) {
        LifecycleOwner r0 = (LifecycleOwner) this.a.getViewLifecycleOwnerLiveData().getValue();
        if (r0 == null) goto L5;
        CoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r0);
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (a() == false) goto L12;
        FLogger.a.i("OuterChatInputController", "onRealtimeCallEntranceShow, previousPage:" + r9 + ", tabKey:" + this.b);
        BuildersKt.launch$default(r2, null, null, new OuterChatInputController$onRealtimeCallEntranceShow$1(this, null), 3, null);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public OuterChatInputController(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tabPage");
        Intrinsics.checkNotNullParameter(r3, "tabKey");
        this.a = r2;
        this.b = r3;
    }

    public static final Object d(OuterChatInputController r6, Function2 r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof OuterChatInputController$getMainBotConversationInfo$1) == false) goto L7;
        OuterChatInputController$getMainBotConversationInfo$1 r0 = (OuterChatInputController$getMainBotConversationInfo$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        ResultKt.throwOnFailure(r9);
    L37:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r7 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L32:
        wc9.e r11 = (wc9.e) r9;
    L33:
        r0.L$0 = null;
        r0.label = 3;
        if (r7.invoke(r11, r0) != r10) goto L37;
        return r10;
    L17:
        r7 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L23:
        r11 = (wc9.e) r9;
        goto L33
    L18:
        ResultKt.throwOnFailure(r9);
        if (com.larus.platform.exp.o.a() == false) goto L24;
        LocalSubConvHelper r12 = LocalSubConvHelper.a;
        String r3 = AccountService.a.getSecUserId();
        r0.L$0 = r7;
        r0.label = 1;
        r9 = r12.c(r3, null, r0);
        if (r9 != r10) goto L23;
        return r10;
    L24:
        ILaunchCacheService r13 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r13 == null) goto L29;
        r11 = r13.b();
        if (r11 == null) goto L29;
        FLogger.a.i("OuterChatInputController", "use lastCachedConversationInfo");
    L29:
        Flow r14 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        OuterChatInputController$getMainBotConversationInfo$cvs$2 r4 = new OuterChatInputController$getMainBotConversationInfo$cvs$2(null);
        r0.L$0 = r7;
        r0.label = 2;
        r9 = kotlinx.coroutines.flow.e.t(r14, r4, r0);
        if (r9 != r10) goto L32;
        return r10;
    L7:
        r0 = new OuterChatInputController$getMainBotConversationInfo$1(r6, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, com.larus.bmhome.chat.outerinput.OuterChatInput] */
    @Override // com.larus.bmhome.chat.outerinput.c
    public final void b(String r16, FrameLayout r17, boolean r18, Function1<? super Integer, Unit> r19) {
        if (r17 != 0) goto L7;
        if (r19 == null) goto L23;
        r19.invoke(0);
        return;
    L23:
        return;
    L7:
        Context r1 = this.a.getContext();
        if (r1 != null) goto L10;
        return;
    L10:
        ?? r4 = new OuterChatInput(r1);
        r17.addView(r4, new FrameLayout.LayoutParams(-1, -1));
        LifecycleOwner r2 = (LifecycleOwner) this.a.getViewLifecycleOwnerLiveData().getValue();
        if (r2 == null) goto L13;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
    L14:
        LifecycleCoroutineScope r9 = r3;
        if (r9 != null) goto L17;
    L19:
        e1.o(r17);
        if (r19 == null) goto L25;
        r19.invoke(0);
        return;
    L25:
        return;
    L17:
        if (a() == false) goto L19;
        this.c = r4;
        BuildersKt.launch$default(r9, null, null, new OuterChatInputController$setup$1(this, r17, r19, r4, r18, r16, null), 3, null);
        return;
    L13:
        r3 = null;
        goto L14
    }
}
