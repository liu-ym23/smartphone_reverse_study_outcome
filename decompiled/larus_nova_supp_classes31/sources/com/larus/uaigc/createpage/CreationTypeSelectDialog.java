package com.larus.uaigc.createpage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.uaigc.impl.databinding.LarusDialogCreationTypeSelectBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014J\n\u0010!\u001a\u00020\u001c*\u00020\u0014J\u0018\u0010(\u001a\u00020\u001c2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u001a\u0010*\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J-\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00101J\n\u00102\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u0016\u00104\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\tH\u0082@¢\u0006\u0002\u00105J4\u00106\u001a\u00020\u001c2$\u00107\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;08H\u0082@¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020\rH\u0002J\b\u0010>\u001a\u00020\u001cH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/uaigc/createpage/CreationTypeSelectDialog;", "Landroidx/fragment/app/Fragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusDialogCreationTypeSelectBinding;", "supportInstructionItem", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "conversationId", "", "cellTraced", "", "traceMap", "", "", "currentChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "zoomOutAnimation", "", "view", "scaleSize", "", "zoomInAnimation", "bounceWhenPressedItem", "imageCreate", "Lcom/larus/uaigc/createpage/CreationTypeItemView;", "avatarCreate", "musicCreate", "videoCreate", "botCreate", "updateCreationTypeList", "list", "onViewCreated", "initViewClickListener", "goToBotCreate", "handleClickAction", "id", "item", "selectInstructionType", "(ILcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Integer;)V", "getCurBottomTabMainBotFrag", "setupDialogWindow", "handleOpenSchema", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needOpenNewChatPageOnSend", "onResume", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationTypeSelectDialog extends Fragment implements by7.e {
    public static final /* synthetic */ int n = 0;
    public LarusDialogCreationTypeSelectBinding d;
    public List<com.larus.bmhome.actionbar.model.z0> e;
    public String f;
    public boolean g;
    public final Map<String, Integer> h;
    public CreationTypeItemView i;
    public CreationTypeItemView j;
    public CreationTypeItemView k;
    public CreationTypeItemView l;
    public CreationTypeItemView m;

    public static final class a {
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ CreationTypeSelectDialog a;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getChatType() {
            return "default";
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            Bundle r0 = this.a.getArguments();
            if (r0 == null) goto L6;
            String r1 = r0.getString("current_page");
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public final String getBotId() {
            com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L7;
            LaunchInfo r1 = r0.a;
            if (r1 == null) goto L7;
            return r1.W();
        L7:
            return null;
        }

        public final String getEnterMethod() {
            if (z2.a.f1().f() == false) goto L5;
            return "create_button_panel";
        L5:
            return "5tab_create_pannel";
        }

        public b(CreationTypeSelectDialog r1) {
            this.a = r1;
        }
    }

    public static final class c implements zs8.a {
        public final /* synthetic */ CreationTypeSelectDialog a;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getChatType() {
            return "default";
        }

        public final String getClickFrom() {
            return "ai_generate_feed_image";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            Bundle r0 = this.a.getArguments();
            if (r0 == null) goto L6;
            String r1 = r0.getString("current_page");
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public final String getBotId() {
            com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L7;
            LaunchInfo r1 = r0.a;
            if (r1 == null) goto L7;
            return r1.W();
        L7:
            return null;
        }

        public final String getEnterMethod() {
            if (z2.a.f1().f() == false) goto L5;
            return "create_button_panel";
        L5:
            return "5tab_create_pannel";
        }

        public c(CreationTypeSelectDialog r1) {
            this.a = r1;
        }
    }

    public static final class d implements zs8.a {
        public d() {
        }

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getEnterMethod() {
            if (z2.a.f1().f() == false) goto L5;
            return "create_button_panel";
        L5:
            return "5tab_create_pannel";
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.CreationTypeSelectDialog$onCreateView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.CreationTypeSelectDialog$onCreateView$1", f = "CreationTypeSelectDialog.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationTypeSelectDialog this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.CreationTypeSelectDialog$onCreateView$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.uaigc.createpage.CreationTypeSelectDialog$onCreateView$1$1", f = "CreationTypeSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00381 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CreationTypeSelectDialog this$0;

            public C00381(CreationTypeSelectDialog r1, Continuation<? super C00381> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00381 r0 = new C00381(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((wc9.e) r1, (Continuation) r2);
            }

            public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r2);
                wc9.e r3 = (wc9.e) this.L$0;
                CreationTypeSelectDialog r0 = this.this$0;
                if (r3 == null) goto L8;
                String r4 = r3.a;
                if (r4 == null) goto L8;
            L9:
                r0.f = r4;
                return Unit.INSTANCE;
            L8:
                r4 = "";
                goto L9
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(CreationTypeSelectDialog r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CreationTypeSelectDialog r6 = this.this$0;
            C00381 r2 = new C00381(r6, null);
            this.label = 1;
            int r3 = CreationTypeSelectDialog.n;
            if (r6.W90(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final Fragment V90() {
        if (z2.a.enableChatWithTab() == true) goto L5;
        return null;
    L5:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L8;
        r0.f0();
        Fragment r1 = com.larus.home.impl.sdk.i.a.a();
    L9:
        if (r1 == null) goto L15;
        t1a.b r2 = s1a.a.g(r1);
        if (r2 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y r3 = r2.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r3 == null) goto L15;
        String r4 = r3.getBotId();
    L16:
        com.larus.bmhome.chat.api.e0 r5 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r5 == null) goto L21;
        LaunchInfo r6 = r5.a;
        if (r6 == null) goto L21;
        String r7 = r6.W();
    L23:
        if (Intrinsics.areEqual(r4, r7) == false) goto L25;
        return r1;
    L25:
        return null;
    L21:
        r7 = null;
    L15:
        r4 = null;
        goto L16
    L8:
        r1 = null;
        goto L9
    }

    public CreationTypeSelectDialog() {
        this.f = "";
        this.h = new LinkedHashMap();
    }

    public final ChatPageContext U90() {
        Fragment r0 = V90();
        if (r0 == null) goto L9;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L9;
        ChatPageContext r2 = r1.a(ChatPageContext.class);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return s1a.a.g(this).a(ChatPageContext.class);
    }

    public final boolean Y90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.getBoolean("open_new_chat_page_on_send", true);
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final void onResume() {
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T90(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final CreationTypeItemView r1 = (CreationTypeItemView) r3;
        r3.setOnTouchListener(new b1(this, r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.view.View, android.view.ViewGroup, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r3v29, types: [android.view.View, android.view.ViewGroup, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.view.View, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r4v31, types: [android.view.View, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r4v47, types: [android.view.View, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r8v13, types: [android.view.View, android.view.ViewGroup, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r8v18, types: [android.view.View, com.larus.uaigc.createpage.CreationTypeItemView] */
    /* JADX WARN: Type inference failed for: r9v56, types: [android.view.View, com.larus.uaigc.createpage.CreationTypeItemView] */
    public final void Z90(List<com.larus.bmhome.actionbar.model.z0> r25) {
        if (this.g == false) goto L6;
        FLogger.a.i("CreationTypeSelectDialog", "updateCreationTypeList cellTraced is true return");
        return;
    L6:
        FLogger.a.i("CreationTypeSelectDialog", "updateCreationTypeList cellTraced is false");
        LarusDialogCreationTypeSelectBinding r1 = this.d;
        if (r1 == null) goto L11;
        LinearLayout r2 = r1.b;
        if (r2 == null) goto L11;
        r2.removeAllViews();
        Unit r3 = Unit.INSTANCE;
    L11:
        z2 r4 = z2.a;
        int r5 = 4;
        String r13 = "";
        if (r4.f1().f() == false) goto L352;
        List r6 = r4.f1().a();
        if (r6 == null) goto L485;
        Iterator r7 = r6.iterator();
        int r8 = 0;
        int r14 = 0;
    L17:
        if (r7.hasNext() == false) goto L351;
        Object r15 = r7.next();
        int r16 = r8 + 1;
        if (r8 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        sq9.x r17 = (sq9.x) r15;
        if (r17.b() != r5) goto L122;
        if (r25 == null) goto L40;
        Iterator<T> r9 = r25.iterator();
    L26:
        if (r9.hasNext() == false) goto L38;
        Object r18 = r9.next();
        com.larus.bmhome.actionbar.model.r r11 = ((com.larus.bmhome.actionbar.model.z0) r18).q;
        if (r11 == null) goto L35;
        Integer r12 = r11.a;
        if (r12 == null) goto L35;
        if (r12.intValue() != 28) goto L35;
        boolean r19 = true;
    L36:
        if (r19 == false) goto L26;
    L39:
        com.larus.bmhome.actionbar.model.z0 r10 = (com.larus.bmhome.actionbar.model.z0) r18;
    L41:
        if (r25 == null) goto L59;
        Iterator<T> r110 = r25.iterator();
    L44:
        if (r110.hasNext() == false) goto L57;
        Object r111 = r110.next();
        com.larus.bmhome.actionbar.model.r r112 = ((com.larus.bmhome.actionbar.model.z0) r111).q;
        if (r112 == null) goto L53;
        Integer r113 = r112.a;
        if (r113 == null) goto L53;
        if (r113.intValue() != r5) goto L53;
        boolean r114 = true;
    L54:
        if (r114 == false) goto L44;
    L58:
        com.larus.bmhome.actionbar.model.z0 r115 = (com.larus.bmhome.actionbar.model.z0) r111;
    L60:
        if (r10 != null) goto L62;
        com.larus.bmhome.actionbar.model.z0 r116 = r115;
    L63:
        if (r116 == null) goto L122;
        if (rs8.a.a() == false) goto L122;
        if (this.g == true) goto L122;
        r14 = r14 + 1;
        Integer r20 = Integer.valueOf(r14);
        Bundle r21 = getArguments();
        if (r21 == null) goto L72;
        String r22 = r21.getString("current_page");
        if (r22 == null) goto L72;
    L73:
        nz9.c.d(r20, r22, "image", "create_button_panel", 48);
        this.h.put("image", Integer.valueOf(r14));
        Context r23 = getContext();
        if (r23 == null) goto L119;
        ?? r24 = new CreationTypeItemView(r23, null);
        String r26 = r17.c();
        if (r26 != null) goto L78;
    L84:
        boolean r27 = false;
    L85:
        if (r27 == false) goto L89;
        String r28 = r17.c();
        if (r28 == null) goto L109;
    L110:
        sq9.v r29 = r17.a();
        if (r29 == null) goto L113;
        String r30 = r29.a();
    L114:
        r24.S5(r28, String.valueOf(r30));
        LarusDialogCreationTypeSelectBinding r31 = this.d;
        CreationTypeItemView r32 = r24;
        if (r31 == null) goto L120;
        LinearLayout r33 = r31.b;
        r32 = r24;
        if (r33 == 0) goto L120;
        LinearLayout.LayoutParams r34 = new LinearLayout.LayoutParams(-1, -1);
        r34.leftMargin = i5.q();
        r34.rightMargin = i5.q();
        r34.topMargin = i5.h();
        Unit r35 = Unit.INSTANCE;
        r33.addView(r24, r34);
        r32 = r24;
    L120:
        this.i = r32;
        goto L122
    L113:
        r30 = null;
    L109:
        r28 = "";
        goto L110
    L89:
        if (r115 == null) goto L99;
        String r36 = r115.e;
        if (r36 == null) goto L99;
        if (r36.length() <= 0) goto L95;
        boolean r37 = true;
    L97:
        if (r37 != true) goto L99;
        boolean r38 = true;
    L100:
        if (r38 == false) goto L104;
        r28 = r115.e;
        if (r28 != null) goto L110;
    L104:
        if (r10 == null) goto L107;
        r28 = r10.e;
        if (r28 != null) goto L110;
    L107:
        r28 = r116.e;
        if (r28 != null) goto L110;
    L95:
        r37 = false;
    L99:
        r38 = false;
        goto L100
    L78:
        if (r26.length() <= 0) goto L80;
        boolean r39 = true;
    L82:
        if (r39 != true) goto L84;
        r27 = true;
        goto L85
    L80:
        r39 = false;
        goto L82
    L119:
        r32 = 0;
    L72:
        r22 = "";
        goto L73
    L62:
        r116 = r10;
    L53:
        r114 = false;
        goto L54
    L57:
        r111 = null;
        goto L58
    L59:
        r115 = null;
    L35:
        r19 = false;
        goto L36
    L38:
        r18 = null;
        goto L39
    L40:
        r10 = null;
    L122:
        if (r17.b() != 11) goto L182;
        if (r25 == null) goto L140;
        Iterator<T> r40 = r25.iterator();
    L126:
        if (r40.hasNext() == false) goto L138;
        Object r41 = r40.next();
        com.larus.bmhome.actionbar.model.r r42 = ((com.larus.bmhome.actionbar.model.z0) r41).q;
        if (r42 == null) goto L135;
        Integer r43 = r42.a;
        if (r43 == null) goto L135;
        if (r43.intValue() != 11) goto L135;
        boolean r44 = true;
    L136:
        if (r44 == false) goto L126;
    L139:
        com.larus.bmhome.actionbar.model.z0 r45 = (com.larus.bmhome.actionbar.model.z0) r41;
    L141:
        if (r45 == null) goto L182;
        if (rs8.a.a() == false) goto L182;
        if (this.g == true) goto L182;
        r14 = r14 + 1;
        Integer r46 = Integer.valueOf(r14);
        Bundle r47 = getArguments();
        if (r47 == null) goto L150;
        String r48 = r47.getString("current_page");
        if (r48 == null) goto L150;
    L151:
        nz9.c.d(r46, r48, "avatar", "create_button_panel", 48);
        this.h.put("avatar", Integer.valueOf(r14));
        Context r49 = getContext();
        if (r49 == null) goto L179;
        ?? r50 = new CreationTypeItemView(r49, null);
        String r51 = r17.c();
        if (r51 != null) goto L156;
    L162:
        boolean r52 = false;
    L163:
        if (r52 == false) goto L167;
        String r53 = r17.c();
        if (r53 == null) goto L169;
    L170:
        sq9.v r54 = r17.a();
        if (r54 == null) goto L173;
        String r55 = r54.a();
    L174:
        r50.S5(r53, String.valueOf(r55));
        LarusDialogCreationTypeSelectBinding r56 = this.d;
        CreationTypeItemView r57 = r50;
        if (r56 == null) goto L180;
        LinearLayout r58 = r56.b;
        r57 = r50;
        if (r58 == 0) goto L180;
        LinearLayout.LayoutParams r59 = new LinearLayout.LayoutParams(-1, -1);
        r59.leftMargin = i5.q();
        r59.rightMargin = i5.q();
        r59.topMargin = i5.h();
        Unit r60 = Unit.INSTANCE;
        r58.addView(r50, r59);
        r57 = r50;
    L180:
        this.j = r57;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationTypeSelectDialog$updateCreationTypeList$1$3(this, null), 3, null);
        goto L182
    L173:
        r55 = null;
    L169:
        r53 = "";
        goto L170
    L167:
        r53 = r45.e;
        if (r53 != null) goto L170;
    L156:
        if (r51.length() <= 0) goto L158;
        boolean r61 = true;
    L160:
        if (r61 != true) goto L162;
        r52 = true;
        goto L163
    L158:
        r61 = false;
        goto L160
    L179:
        r57 = 0;
    L150:
        r48 = "";
    L135:
        r44 = false;
        goto L136
    L138:
        r41 = null;
        goto L139
    L140:
        r45 = null;
    L182:
        if (r17.b() != 1) goto L238;
        if (r25 == null) goto L200;
        Iterator<T> r62 = r25.iterator();
    L186:
        if (r62.hasNext() == false) goto L198;
        Object r63 = r62.next();
        com.larus.bmhome.actionbar.model.r r64 = ((com.larus.bmhome.actionbar.model.z0) r63).q;
        if (r64 == null) goto L195;
        Integer r65 = r64.a;
        if (r65 == null) goto L195;
        if (r65.intValue() != 1) goto L195;
        boolean r66 = true;
    L196:
        if (r66 == false) goto L186;
    L199:
        com.larus.bmhome.actionbar.model.z0 r67 = (com.larus.bmhome.actionbar.model.z0) r63;
    L201:
        if (r67 == null) goto L238;
        if (rs8.a.a() == false) goto L238;
        if (this.g == true) goto L238;
        r14 = r14 + 1;
        Integer r68 = Integer.valueOf(r14);
        Bundle r69 = getArguments();
        if (r69 == null) goto L210;
        String r70 = r69.getString("current_page");
        if (r70 == null) goto L210;
    L211:
        nz9.c.d(r68, r70, "music", "create_button_panel", 48);
        this.h.put("music", Integer.valueOf(r14));
        Context r71 = getContext();
        if (r71 == null) goto L235;
        ?? r72 = new CreationTypeItemView(r71, null);
        String r73 = r17.c();
        if (r73 != null) goto L216;
    L218:
        boolean r74 = false;
    L219:
        if (r74 == false) goto L223;
        String r75 = r17.c();
        if (r75 == null) goto L225;
    L226:
        sq9.v r76 = r17.a();
        if (r76 == null) goto L229;
        String r77 = r76.a();
    L230:
        r72.S5(r75, String.valueOf(r77));
        LarusDialogCreationTypeSelectBinding r78 = this.d;
        CreationTypeItemView r79 = r72;
        if (r78 == null) goto L236;
        LinearLayout r80 = r78.b;
        r79 = r72;
        if (r80 == 0) goto L236;
        LinearLayout.LayoutParams r81 = new LinearLayout.LayoutParams(-1, -1);
        r81.leftMargin = i5.q();
        r81.rightMargin = i5.q();
        r81.topMargin = i5.h();
        Unit r82 = Unit.INSTANCE;
        r80.addView(r72, r81);
        r79 = r72;
    L236:
        this.k = r79;
        goto L238
    L229:
        r77 = null;
    L225:
        r75 = "";
        goto L226
    L223:
        r75 = r67.e;
        if (r75 != null) goto L226;
    L216:
        if (com.larus.utils.o0.d(r73) != true) goto L218;
        r74 = true;
        goto L219
    L235:
        r79 = 0;
    L210:
        r70 = "";
    L195:
        r66 = false;
        goto L196
    L198:
        r63 = null;
        goto L199
    L200:
        r67 = null;
    L238:
        if (r17.b() != 18) goto L350;
        if (r25 == null) goto L257;
        Iterator<T> r83 = r25.iterator();
    L242:
        if (r83.hasNext() == false) goto L255;
        Object r84 = r83.next();
        com.larus.bmhome.actionbar.model.r r85 = ((com.larus.bmhome.actionbar.model.z0) r84).q;
        if (r85 == null) goto L252;
        Integer r86 = r85.a;
        if (r86 == null) goto L252;
        if (r86.intValue() != 28) goto L252;
        boolean r87 = true;
    L253:
        if (r87 == false) goto L242;
    L256:
        com.larus.bmhome.actionbar.model.z0 r88 = (com.larus.bmhome.actionbar.model.z0) r84;
    L258:
        if (r25 == null) goto L275;
        Iterator<T> r89 = r25.iterator();
    L261:
        if (r89.hasNext() == false) goto L273;
        Object r90 = r89.next();
        com.larus.bmhome.actionbar.model.r r117 = ((com.larus.bmhome.actionbar.model.z0) r90).q;
        if (r117 == null) goto L270;
        Integer r118 = r117.a;
        if (r118 == null) goto L270;
        if (r118.intValue() != 18) goto L270;
        boolean r119 = true;
    L271:
        if (r119 == false) goto L261;
    L274:
        com.larus.bmhome.actionbar.model.z0 r91 = (com.larus.bmhome.actionbar.model.z0) r90;
    L276:
        if (r88 != null) goto L295;
        if (r25 == null) goto L294;
        Iterator<T> r92 = r25.iterator();
    L280:
        if (r92.hasNext() == false) goto L292;
        Object r120 = r92.next();
        com.larus.bmhome.actionbar.model.r r121 = ((com.larus.bmhome.actionbar.model.z0) r120).q;
        if (r121 == null) goto L289;
        Integer r122 = r121.a;
        if (r122 == null) goto L289;
        if (r122.intValue() != 18) goto L289;
        boolean r123 = true;
    L290:
        if (r123 == false) goto L280;
    L293:
        com.larus.bmhome.actionbar.model.z0 r93 = (com.larus.bmhome.actionbar.model.z0) r120;
    L296:
        if (r93 == null) goto L350;
        if (rs8.a.a() == false) goto L350;
        if (this.g == true) goto L350;
        r14 = r14 + 1;
        Integer r94 = Integer.valueOf(r14);
        Bundle r95 = getArguments();
        if (r95 == null) goto L305;
        String r96 = r95.getString("current_page");
        if (r96 == null) goto L305;
    L306:
        nz9.c.d(r94, r96, "video", "create_button_panel", 48);
        this.h.put("video", Integer.valueOf(r14));
        Context r97 = getContext();
        if (r97 == null) goto L348;
        ?? r98 = new CreationTypeItemView(r97, null);
        String r99 = r17.c();
        if (r99 != null) goto L311;
    L317:
        boolean r100 = false;
    L318:
        if (r100 == false) goto L320;
        String r101 = r17.c();
    L337:
        if (r101 != null) goto L339;
        r101 = "";
    L339:
        sq9.v r102 = r17.a();
        if (r102 == null) goto L342;
        String r103 = r102.a();
    L343:
        r98.S5(r101, String.valueOf(r103));
        LarusDialogCreationTypeSelectBinding r104 = this.d;
        CreationTypeItemView r105 = r98;
        if (r104 == null) goto L349;
        LinearLayout r106 = r104.b;
        r105 = r98;
        if (r106 == 0) goto L349;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-1, -1);
        r107.leftMargin = i5.q();
        r107.rightMargin = i5.q();
        r107.topMargin = i5.h();
        Unit r108 = Unit.INSTANCE;
        r106.addView(r98, r107);
        r105 = r98;
    L349:
        this.l = r105;
        goto L350
    L342:
        r103 = null;
        goto L343
    L320:
        if (r91 == null) goto L330;
        String r109 = r91.e;
        if (r109 == null) goto L330;
        if (r109.length() <= 0) goto L326;
        boolean r124 = true;
    L328:
        if (r124 != true) goto L330;
        boolean r125 = true;
    L331:
        if (r125 == false) goto L333;
        r101 = r91.e;
        goto L337
    L333:
        if (r88 == null) goto L336;
        r101 = r88.e;
        if (r101 != null) goto L337;
    L336:
        r101 = "";
        goto L337
    L326:
        r124 = false;
    L330:
        r125 = false;
        goto L331
    L311:
        if (r99.length() <= 0) goto L313;
        boolean r126 = true;
    L315:
        if (r126 != true) goto L317;
        r100 = true;
        goto L318
    L313:
        r126 = false;
        goto L315
    L348:
        r105 = 0;
    L305:
        r96 = "";
    L289:
        r123 = false;
        goto L290
    L292:
        r120 = null;
        goto L293
    L294:
        r93 = null;
        goto L296
    L295:
        r93 = r88;
    L270:
        r119 = false;
        goto L271
    L273:
        r90 = null;
        goto L274
    L275:
        r91 = null;
    L252:
        r87 = false;
        goto L253
    L255:
        r84 = null;
        goto L256
    L257:
        r88 = null;
    L350:
        r8 = r16;
        r5 = 4;
        goto L17
    L351:
        Unit r127 = Unit.INSTANCE;
    L485:
        this.g = true;
        ConstraintLayout r128 = this.i;
        if (r128 == null) goto L488;
        T90(r128);
        Unit r129 = Unit.INSTANCE;
    L488:
        ConstraintLayout r130 = this.j;
        if (r130 == null) goto L491;
        T90(r130);
        Unit r131 = Unit.INSTANCE;
    L491:
        ConstraintLayout r132 = this.k;
        if (r132 == null) goto L494;
        T90(r132);
        Unit r133 = Unit.INSTANCE;
    L494:
        ConstraintLayout r134 = this.m;
        if (r134 == null) goto L497;
        T90(r134);
        Unit r135 = Unit.INSTANCE;
    L497:
        ConstraintLayout r136 = this.l;
        if (r136 == null) goto L554;
        T90(r136);
        Unit r137 = Unit.INSTANCE;
        return;
    L554:
        return;
    L352:
        if (r25 == null) goto L370;
        Iterator<T> r138 = r25.iterator();
    L355:
        if (r138.hasNext() == false) goto L368;
        Object r139 = r138.next();
        com.larus.bmhome.actionbar.model.r r140 = ((com.larus.bmhome.actionbar.model.z0) r139).q;
        if (r140 == null) goto L365;
        Integer r141 = r140.a;
        if (r141 == null) goto L365;
        if (r141.intValue() != 4) goto L365;
        boolean r142 = true;
    L366:
        if (r142 == false) goto L355;
    L369:
        com.larus.bmhome.actionbar.model.z0 r143 = (com.larus.bmhome.actionbar.model.z0) r139;
    L372:
        if (this.g == true) goto L387;
        Bundle r144 = getArguments();
        if (r144 == null) goto L377;
        String r145 = r144.getString("current_page");
        if (r145 == null) goto L377;
    L378:
        nz9.c.d(1, r145, "bot", null, 56);
        Context r146 = getContext();
        if (r146 == null) goto L385;
        ?? r147 = new CreationTypeItemView(r146, null);
        r147.R5(r146.getString(2131901108), v19.c.b(2130970987, r147.getContext(), 2131240242));
        LarusDialogCreationTypeSelectBinding r148 = this.d;
        CreationTypeItemView r149 = r147;
        if (r148 == null) goto L386;
        LinearLayout r150 = r148.b;
        r149 = r147;
        if (r150 == 0) goto L386;
        LinearLayout.LayoutParams r151 = new LinearLayout.LayoutParams(-1, -1);
        r151.leftMargin = i5.q();
        r151.rightMargin = i5.q();
        r151.topMargin = i5.h();
        Unit r152 = Unit.INSTANCE;
        r150.addView(r147, r151);
        r149 = r147;
    L386:
        this.m = r149;
        goto L387
    L385:
        r149 = 0;
    L377:
        r145 = "";
    L387:
        this.h.put("bot", 1);
        int r153 = 2;
        if (r143 != null) goto L390;
    L407:
        if (r25 == null) goto L425;
        Iterator<T> r154 = r25.iterator();
    L410:
        if (r154.hasNext() == false) goto L423;
        Object r155 = r154.next();
        com.larus.bmhome.actionbar.model.r r156 = ((com.larus.bmhome.actionbar.model.z0) r155).q;
        if (r156 == null) goto L420;
        Integer r157 = r156.a;
        if (r157 == null) goto L420;
        if (r157.intValue() != 11) goto L420;
        boolean r158 = true;
    L421:
        if (r158 == false) goto L410;
    L424:
        com.larus.bmhome.actionbar.model.z0 r159 = (com.larus.bmhome.actionbar.model.z0) r155;
    L426:
        if (r159 != null) goto L428;
    L445:
        if (r25 == null) goto L462;
        Iterator<T> r160 = r25.iterator();
    L448:
        if (r160.hasNext() == false) goto L460;
        Object r161 = r160.next();
        com.larus.bmhome.actionbar.model.r r162 = ((com.larus.bmhome.actionbar.model.z0) r161).q;
        if (r162 == null) goto L457;
        Integer r163 = r162.a;
        if (r163 == null) goto L457;
        if (r163.intValue() != 1) goto L457;
        boolean r164 = true;
    L458:
        if (r164 == false) goto L448;
    L461:
        com.larus.bmhome.actionbar.model.z0 r165 = (com.larus.bmhome.actionbar.model.z0) r161;
    L463:
        if (r165 != null) goto L465;
    L484:
        Unit r166 = Unit.INSTANCE;
        goto L485
    L465:
        if (rs8.a.a() == false) goto L484;
        if (this.g == true) goto L484;
        Integer r167 = Integer.valueOf(r153);
        Bundle r168 = getArguments();
        if (r168 == null) goto L474;
        String r169 = r168.getString("current_page");
        if (r169 == null) goto L474;
        r13 = r169;
    L474:
        nz9.c.d(r167, r13, "music", null, 56);
        this.h.put("music", Integer.valueOf(r153));
        Context r170 = getContext();
        if (r170 == null) goto L482;
        ?? r171 = new CreationTypeItemView(r170, null);
        r171.R5(String.valueOf(r165.e), 2131240251);
        LarusDialogCreationTypeSelectBinding r172 = this.d;
        if (r172 == null) goto L481;
        LinearLayout r173 = r172.b;
        if (r173 == 0) goto L481;
        LinearLayout.LayoutParams r174 = new LinearLayout.LayoutParams(-1, -1);
        r174.leftMargin = i5.q();
        r174.rightMargin = i5.q();
        r174.topMargin = i5.h();
        Unit r175 = Unit.INSTANCE;
        r173.addView(r171, r174);
    L481:
        CreationTypeItemView r176 = r171;
    L483:
        this.k = r176;
        goto L484
    L482:
        r176 = 0;
    L457:
        r164 = false;
        goto L458
    L460:
        r161 = null;
        goto L461
    L462:
        r165 = null;
        goto L463
    L428:
        if (rs8.a.a() == false) goto L445;
        if (this.g == true) goto L445;
        Integer r177 = Integer.valueOf(r153);
        Bundle r178 = getArguments();
        if (r178 == null) goto L435;
        String r179 = r178.getString("current_page");
        if (r179 == null) goto L435;
    L436:
        nz9.c.d(r177, r179, "avatar", null, 56);
        int r180 = r153 + 1;
        this.h.put("avatar", Integer.valueOf(r153));
        Context r181 = getContext();
        if (r181 == null) goto L443;
        ?? r182 = new CreationTypeItemView(r181, null);
        r182.R5(String.valueOf(r159.e), v19.c.b(2130970985, r182.getContext(), 2131240236));
        LarusDialogCreationTypeSelectBinding r183 = this.d;
        CreationTypeItemView r184 = r182;
        if (r183 == null) goto L444;
        LinearLayout r185 = r183.b;
        r184 = r182;
        if (r185 == 0) goto L444;
        LinearLayout.LayoutParams r186 = new LinearLayout.LayoutParams(-1, -1);
        r186.leftMargin = i5.q();
        r186.rightMargin = i5.q();
        r186.topMargin = i5.h();
        Unit r187 = Unit.INSTANCE;
        r185.addView(r182, r186);
        r184 = r182;
    L444:
        this.j = r184;
        r153 = r180;
        goto L445
    L443:
        r184 = 0;
    L435:
        r179 = "";
    L420:
        r158 = false;
        goto L421
    L423:
        r155 = null;
        goto L424
    L425:
        r159 = null;
        goto L426
    L390:
        if (rs8.a.a() == false) goto L407;
        if (this.g == true) goto L407;
        Bundle r188 = getArguments();
        if (r188 == null) goto L397;
        String r189 = r188.getString("current_page");
        if (r189 == null) goto L397;
    L398:
        nz9.c.d(2, r189, "image", null, 56);
        this.h.put("image", 2);
        Context r190 = getContext();
        if (r190 == null) goto L405;
        ?? r191 = new CreationTypeItemView(r190, null);
        r191.R5(String.valueOf(r143.e), v19.c.b(2130970989, r191.getContext(), 2131240248));
        LarusDialogCreationTypeSelectBinding r192 = this.d;
        CreationTypeItemView r193 = r191;
        if (r192 == null) goto L406;
        LinearLayout r194 = r192.b;
        r193 = r191;
        if (r194 == 0) goto L406;
        LinearLayout.LayoutParams r195 = new LinearLayout.LayoutParams(-1, -1);
        r195.leftMargin = i5.q();
        r195.rightMargin = i5.q();
        r195.topMargin = i5.h();
        Unit r196 = Unit.INSTANCE;
        r194.addView(r191, r195);
        r193 = r191;
    L406:
        this.i = r193;
        r153 = 3;
        goto L407
    L405:
        r193 = 0;
    L397:
        r189 = "";
    L365:
        r142 = false;
        goto L366
    L368:
        r139 = null;
        goto L369
    L370:
        r143 = null;
        goto L372
    }

    public final Object W90(Function2<? super wc9.e, ? super Continuation<? super Unit>, ? extends Object> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof CreationTypeSelectDialog$getMainBotConversationInfo$1) == false) goto L7;
        CreationTypeSelectDialog$getMainBotConversationInfo$1 r0 = (CreationTypeSelectDialog$getMainBotConversationInfo$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        wc9.e r10 = (wc9.e) r9;
    L25:
        r0.L$0 = null;
        r0.label = 2;
        if (r7.invoke(r10, r0) != r2) goto L29;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        ILaunchCacheService r11 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r11 == null) goto L21;
        r10 = r11.b();
        if (r10 != null) goto L25;
    L21:
        Flow r12 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        CreationTypeSelectDialog$getMainBotConversationInfo$cvs$2 r4 = new CreationTypeSelectDialog$getMainBotConversationInfo$cvs$2(null);
        r0.L$0 = r7;
        r0.label = 1;
        r9 = kotlinx.coroutines.flow.e.t(r12, r4, r0);
        if (r9 != r2) goto L24;
        return r2;
    L7:
        r0 = new CreationTypeSelectDialog$getMainBotConversationInfo$1(this, r8);
        goto L8
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        ConstraintLayout r10 = this.m;
        if (r10 == null) goto L5;
        e1.d(r10, new v0(this));
    L5:
        List<com.larus.bmhome.actionbar.model.z0> r11 = this.e;
        final com.larus.bmhome.actionbar.model.z0 r2 = null;
        Object r3 = null;
        if (r11 == null) goto L23;
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L21;
        Object r4 = r12.next();
        com.larus.bmhome.actionbar.model.r r5 = ((com.larus.bmhome.actionbar.model.z0) r4).q;
        if (r5 == null) goto L18;
        Integer r6 = r5.a;
        if (r6 == null) goto L18;
        if (r6.intValue() != 28) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L9;
    L22:
        com.larus.bmhome.actionbar.model.z0 r13 = (com.larus.bmhome.actionbar.model.z0) r4;
    L24:
        if (r13 != null) goto L44;
        List<com.larus.bmhome.actionbar.model.z0> r14 = this.e;
        if (r14 == null) goto L43;
        Iterator<T> r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L41;
        Object r16 = r15.next();
        com.larus.bmhome.actionbar.model.r r17 = ((com.larus.bmhome.actionbar.model.z0) r16).q;
        if (r17 == null) goto L38;
        Integer r18 = r17.a;
        if (r18 == null) goto L38;
        if (r18.intValue() != 4) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == false) goto L29;
    L42:
        final com.larus.bmhome.actionbar.model.z0 r20 = (com.larus.bmhome.actionbar.model.z0) r16;
    L45:
        ConstraintLayout r21 = this.i;
        if (r21 == null) goto L48;
        e1.d(r21, new w0(this, r20));
    L48:
        ConstraintLayout r22 = this.j;
        if (r22 == null) goto L51;
        e1.d(r22, new x0(this));
    L51:
        ConstraintLayout r23 = this.k;
        if (r23 == null) goto L54;
        e1.d(r23, new y0(this));
    L54:
        if (r13 != null) goto L72;
        List<com.larus.bmhome.actionbar.model.z0> r24 = this.e;
        if (r24 == null) goto L73;
        Iterator<T> r25 = r24.iterator();
    L59:
        if (r25.hasNext() == false) goto L71;
        Object r26 = r25.next();
        com.larus.bmhome.actionbar.model.r r27 = ((com.larus.bmhome.actionbar.model.z0) r26).q;
        if (r27 == null) goto L68;
        Integer r28 = r27.a;
        if (r28 == null) goto L68;
        if (r28.intValue() != 18) goto L68;
        boolean r29 = true;
    L69:
        if (r29 == false) goto L59;
        r3 = r26;
    L68:
        r29 = false;
    L71:
        r2 = (com.larus.bmhome.actionbar.model.z0) r3;
    L73:
        ConstraintLayout r30 = this.l;
        if (r30 == null) goto L76;
        e1.d(r30, new z0(this, r2));
    L76:
        LarusDialogCreationTypeSelectBinding r31 = this.d;
        if (r31 == null) goto L81;
        ChatConstraintLayout r32 = r31.a;
        if (r32 == null) goto L81;
        e1.d(r32, new a1(this));
    L81:
        FragmentActivity r33 = requireActivity();
        if (r33 == null) goto L98;
        Window r34 = r33.getWindow();
        if (r34 == null) goto L98;
        WindowManager.LayoutParams r35 = r34.getAttributes();
        r34.setLayout(-1, -1);
        r34.setBackgroundDrawable(new ColorDrawable(0));
        r34.clearFlags(2);
        View r36 = r34.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L91;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r37 = ThreadMethodProxy.currentThread();
        if (r37 == com.larus.home.impl.utils.c.a) goto L91;
        com.larus.home.impl.utils.c.a(r37, "getDecorView");
    L91:
        r36.setPadding(0, 0, 0, 0);
        int r38 = Build.VERSION.SDK_INT;
        if (r38 < 29) goto L94;
        r34.setNavigationBarContrastEnforced(false);
    L94:
        r34.addFlags(Integer.MIN_VALUE);
        if (r38 <= 28) goto L98;
        r35.layoutInDisplayCutoutMode = 1;
    L98:
        if (z2.a.h3() == true) goto L118;
        ConstraintLayout r39 = this.m;
        if (r39 == null) goto L119;
        r39.setVisibility(8);
        return;
    L119:
        return;
    L118:
        return;
    L72:
        r2 = r13;
    L38:
        r19 = false;
        goto L39
    L41:
        r16 = null;
        goto L42
    L43:
        r20 = null;
        goto L45
    L44:
        r20 = r13;
    L18:
        r7 = false;
        goto L19
    L21:
        r4 = null;
        goto L22
    L23:
        r13 = null;
        goto L24
    }

    public static final Object S90(CreationTypeSelectDialog r9, com.larus.bmhome.actionbar.model.z0 r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof CreationTypeSelectDialog$handleOpenSchema$1) == false) goto L7;
        CreationTypeSelectDialog$handleOpenSchema$1 r0 = (CreationTypeSelectDialog$handleOpenSchema$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r13 = (Ref.ObjectRef) r0.L$2;
        String r14 = (String) r0.L$1;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) r0.L$0;
        ResultKt.throwOnFailure(r12);
        String r15 = r14;
        r10 = r4;
    L26:
        com.larus.bmhome.actionbar.model.e0 r5 = r10.m;
        if (r5 == null) goto L36;
        String r6 = r5.a;
        if (r6 == null) goto L36;
        FLogger.a.i("CreationTypeSelectDialog", "[handleOpenSchema] schemaUrl=".concat(r6));
        Bundle r16 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat"), TuplesKt.to("enter_method", "create_button_panel"), TuplesKt.to("conversation_id", r13.element), TuplesKt.to("argConversationId", r13.element), TuplesKt.to("bot_id", r15), TuplesKt.to("need_router_to_chat", Boxing.boxBoolean(true))});
        MainCoroutineDispatcher r17 = Dispatchers.getMain().getImmediate();
        CreationTypeSelectDialog$handleOpenSchema$3 r7 = new CreationTypeSelectDialog$handleOpenSchema$3(r6, r10, r16, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r17, r7, r0) != r2) goto L37;
        return r2;
    L36:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r12);
        com.larus.bmhome.chat.api.e0 r18 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r18 == null) goto L21;
        LaunchInfo r19 = r18.a;
        if (r19 == null) goto L21;
        r15 = r19.W();
    L22:
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = "";
        CreationTypeSelectDialog$handleOpenSchema$2 r20 = new CreationTypeSelectDialog$handleOpenSchema$2(r8, null);
        r0.L$0 = r10;
        r0.L$1 = r15;
        r0.L$2 = r8;
        r0.label = 1;
        if (r9.W90(r20, r0) == r2) goto L38;
        r13 = r8;
        goto L26
    L38:
        return r2;
    L21:
        r15 = null;
    L7:
        r0 = new CreationTypeSelectDialog$handleOpenSchema$1(r9, r11);
        goto L8
    }

    public final void X90(int r60, com.larus.bmhome.actionbar.model.z0 r61, Integer r62) {
        String r3 = null;
        String r5 = "";
        if (r60 != 2131364359) goto L46;
        m3 r1 = m3.a;
        Bundle r2 = getArguments();
        if (r2 == null) goto L8;
        String r4 = r2.getString("current_page");
        if (r4 == null) goto L8;
    L9:
        nq9.c r6 = r1.i(r4, "5tab_create_pannel");
        if (r6 == null) goto L12;
        String r7 = r6.b;
    L13:
        if (r6 == null) goto L15;
        r3 = r6.a;
    L15:
        Bundle r8 = getArguments();
        if (r8 == null) goto L21;
        String r9 = r8.getString("current_page");
        if (r9 == null) goto L21;
        String r16 = r9;
    L22:
        Bundle r10 = getArguments();
        if (r10 == null) goto L28;
        String r11 = r10.getString("previous_page");
        if (r11 == null) goto L28;
        String r17 = r11;
    L29:
        tx9.c0.l(r16, r17, null, "5tab_create_pannel", r7, null, null, null, null, 1993);
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 != null) goto L32;
    L157:
        boolean r15 = false;
    L185:
        if (r15 == true) goto L187;
    L188:
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L193;
        r13.finish();
        return;
    L193:
        return;
    L187:
        if (Y90() == true) goto L188;
        return;
    L32:
        if (r12.a == null) goto L157;
        com.bytedance.router.i r14 = SmartRouter.buildRoute(getContext(), m3.f);
        Pair[] r18 = new Pair[5];
        Bundle r19 = getArguments();
        if (r19 == null) goto L37;
        String r110 = r19.getString("current_page");
        if (r110 == null) goto L37;
    L38:
        r18[0] = TuplesKt.to("enter_from", r110);
        r18[1] = TuplesKt.to("enter_method", "5tab_create_pannel");
        Bundle r20 = getArguments();
        if (r20 == null) goto L44;
        String r21 = r20.getString("current_page");
        if (r21 == null) goto L44;
        r5 = r21;
    L44:
        r18[2] = TuplesKt.to("previous_page", r5);
        r18[3] = TuplesKt.to("create_way", r7);
        r18[4] = TuplesKt.to("creation_id", r3);
        r14.c.putExtras(com.larus.utils.f.c(r18));
        r14.d = 2130772400;
        r14.e = 2130772399;
        r14.d();
    L37:
        r110 = "";
    L28:
        r17 = "";
    L21:
        r16 = "";
        goto L22
    L12:
        r7 = null;
    L8:
        r4 = "";
        goto L9
    L46:
        if (r60 != 2131380489) goto L89;
        Fragment r22 = V90();
        if (r22 == null) goto L53;
        if (r61 == null) goto L53;
        com.larus.bmhome.instruction.g r23 = s1a.a.g(r22).getAbility(com.larus.bmhome.instruction.g.class);
        if (r23 == null) goto L157;
        r23.j90(r61);
    L53:
        if (r61 == null) goto L60;
        Integer r24 = r61.g;
        int r25 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r24 == null) goto L60;
        if (r24.intValue() != r25) goto L60;
        boolean r26 = true;
    L61:
        if (r26 == false) goto L65;
        LifecycleCoroutineScope r27 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r27 == null) goto L157;
        BuildersKt.launch$default(r27, Dispatchers.getMain().getImmediate(), null, new CreationTypeSelectDialog$handleClickAction$1(this, r61, null), 2, null);
        goto L157
    L65:
        s0 r54 = s0.a;
        FragmentActivity r55 = requireActivity();
        if (r61 != null) goto L68;
        return;
    L68:
        String r28 = this.f;
        com.larus.bmhome.chat.api.e0 r29 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r29 == null) goto L73;
        LaunchInfo r30 = r29.a;
        if (r30 == null) goto L73;
        r3 = r30.W();
    L73:
        String r31 = r3;
        Bundle r32 = getArguments();
        if (r32 == null) goto L79;
        String r33 = r32.getString("current_page");
        if (r33 == null) goto L79;
        String r111 = r33;
    L80:
        Bundle r34 = getArguments();
        if (r34 == null) goto L86;
        String r35 = r34.getString("current_page");
        if (r35 == null) goto L86;
        String r112 = r35;
    L87:
        ny9.b r57 = new ny9.b(true, r55, r61, new ChatParam(r28, r31, r111, r112, "default", 224), Y90(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, new b(this), null, null, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, U90(), null, null, null, null, false, -2097184, 258047);
        r54.getClass();
        s0.d(r57);
    L184:
        r15 = true;
    L86:
        r112 = "";
    L79:
        r111 = "";
    L60:
        r26 = false;
        goto L61
    L89:
        if (r60 == 2131374976) goto L93;
        if (r60 == 2131363655) goto L93;
        if (r60 != 2131392292) goto L157;
    L93:
        Fragment r36 = V90();
        if (r36 == null) goto L99;
        if (r61 == null) goto L99;
        com.larus.bmhome.instruction.g r37 = s1a.a.g(r36).getAbility(com.larus.bmhome.instruction.g.class);
        if (r37 == null) goto L157;
        r37.j90(r61);
    L99:
        if (r61 == null) goto L106;
        Integer r38 = r61.g;
        int r39 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r38 == null) goto L106;
        if (r38.intValue() != r39) goto L106;
        boolean r113 = true;
    L107:
        if (r113 == false) goto L111;
        LifecycleCoroutineScope r40 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r40 == null) goto L157;
        BuildersKt.launch$default(r40, Dispatchers.getMain().getImmediate(), null, new CreationTypeSelectDialog$handleClickAction$3(this, r61, null), 2, null);
        goto L157
    L111:
        if (r61 == null) goto L118;
        com.larus.bmhome.actionbar.model.r r41 = r61.q;
        if (r41 == null) goto L118;
        if (r41.f() != true) goto L118;
        boolean r42 = true;
    L119:
        if (r42 == false) goto L158;
        if (r60 == 2131363655) goto L122;
    L123:
        com.larus.bmhome.actionbar.model.r r43 = r61.q;
        if (r43 == null) goto L131;
        Integer r44 = r43.a;
        if (r44 == null) goto L131;
        if (r44.intValue() != 28) goto L131;
        boolean r45 = true;
    L132:
        FragmentActivity r56 = getActivity();
        if (r56 == null) goto L157;
        View r46 = getView();
        if (r46 == null) goto L137;
        e1.o(r46);
    L137:
        s0 r58 = s0.a;
        String r47 = this.f;
        com.larus.bmhome.chat.api.e0 r48 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r48 == null) goto L142;
        LaunchInfo r49 = r48.a;
        if (r49 == null) goto L142;
        r3 = r49.W();
    L142:
        String r50 = r3;
        Bundle r51 = getArguments();
        if (r51 == null) goto L148;
        String r52 = r51.getString("current_page");
        if (r52 == null) goto L148;
        String r114 = r52;
    L149:
        Bundle r53 = getArguments();
        if (r53 == null) goto L155;
        String r59 = r53.getString("current_page");
        if (r59 == null) goto L155;
        String r115 = r59;
    L156:
        ChatParam r510 = new ChatParam(r47, r50, r114, r115, "default", 224);
        boolean r310 = !z2.a.f1().f();
        ny9.b r511 = new ny9.b(r45, r56, r61, r510, Y90(), false, null, null, null, null, null, null, null, r62, null, null, null, null, null, false, false, new c(this), null, null, false, null, null, null, r310, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, U90(), null, null, null, null, false, -270540832, 258047);
        r58.getClass();
        s0.d(r511);
    L155:
        r115 = "";
    L148:
        r114 = "";
    L131:
        r45 = false;
        goto L132
    L122:
        if (z2.a.f1().f() == false) goto L123;
    L158:
        View r63 = getView();
        if (r63 == null) goto L161;
        e1.o(r63);
    L161:
        s0 r512 = s0.a;
        FragmentActivity r513 = requireActivity();
        if (r61 != null) goto L164;
        return;
    L164:
        String r64 = this.f;
        com.larus.bmhome.chat.api.e0 r65 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r65 == null) goto L169;
        LaunchInfo r66 = r65.a;
        if (r66 == null) goto L169;
        r3 = r66.W();
    L169:
        String r67 = r3;
        Bundle r68 = getArguments();
        if (r68 == null) goto L175;
        String r69 = r68.getString("current_page");
        if (r69 == null) goto L175;
        String r116 = r69;
    L176:
        Bundle r70 = getArguments();
        if (r70 == null) goto L182;
        String r71 = r70.getString("current_page");
        if (r71 == null) goto L182;
        String r117 = r71;
    L183:
        ny9.b r514 = new ny9.b(true, r513, r61, new ChatParam(r64, r67, r116, r117, "default", 224), Y90(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, new d(), null, null, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, U90(), null, null, null, null, false, -2097184, 258047);
        r512.getClass();
        s0.d(r514);
    L182:
        r117 = "";
    L175:
        r116 = "";
    L118:
        r42 = false;
    L106:
        r113 = false;
        goto L107
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ChatConstraintLayout r11 = r8.inflate(2131562054, r9, false);
        int r12 = 2131368276;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131368276);
        if (r13 == null) goto L37;
        r12 = 2131384822;
        if (ViewBindings.findChildViewById(r11, 2131384822) == null) goto L37;
        this.d = new LarusDialogCreationTypeSelectBinding(r11, r13);
        com.larus.bmhome.chat.api.e0 r14 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r14 == null) goto L11;
        LaunchInfo r15 = r14.a;
        if (r15 == null) goto L11;
        String r16 = r15.W();
    L12:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        this.e = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r16);
        if (z2.a.f1().f() == true) goto L15;
        ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).d(LifecycleOwnerKt.getLifecycleScope(this), r16, new u0(this));
    L15:
        Z90(this.e);
        LarusDialogCreationTypeSelectBinding r17 = this.d;
        if (r17 == null) goto L20;
        LinearLayout r18 = r17.b;
        if (r18 == null) goto L20;
        r18.setBackgroundResource(2131243390);
    L20:
        LarusDialogCreationTypeSelectBinding r19 = this.d;
        if (r19 == null) goto L25;
        LinearLayout r20 = r19.b;
        if (r20 == null) goto L25;
        r20.setPadding(0, i5.q(), 0, i5.q());
    L25:
        Context r21 = getContext();
        if (r21 == null) goto L32;
        LarusDialogCreationTypeSelectBinding r110 = this.d;
        if (r110 == null) goto L32;
        ChatConstraintLayout r111 = r110.a;
        if (r111 == null) goto L32;
        r111.k6(r21);
    L32:
        LarusDialogCreationTypeSelectBinding r22 = this.d;
        if (r22 != null) goto L35;
        return null;
    L35:
        return r22.a;
    L11:
        r16 = null;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
