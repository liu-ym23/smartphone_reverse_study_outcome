package com.larus.bmhome.debug;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.Query;
import com.larus.bmhome.chat.debug.databinding.LarusPageChatDebugBinding;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextDescView;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.network.bean.BizResponse;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.h2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 L2\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0002J\u0019\u0010.\u001a\u0004\u0018\u00010#2\b\u0010/\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u00101J\u0012\u00102\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J$\u00103\u001a\b\u0012\u0004\u0012\u00020\r042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\rH\u0086@¢\u0006\u0002\u00108J\u0019\u00109\u001a\u0004\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u0004\u0018\u00010#2\b\u0010=\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010>J\u000f\u0010?\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010@J\b\u0010A\u001a\u00020#H\u0002J\u001e\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020JH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\u000fR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/larus/bmhome/debug/ChatDebugFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/chat/debug/databinding/LarusPageChatDebugBinding;", "model", "Lcom/larus/bmhome/debug/ChatDebugViewModel;", "getModel", "()Lcom/larus/bmhome/debug/ChatDebugViewModel;", "model$delegate", "Lkotlin/Lazy;", "messageId", "", "getMessageId", "()Ljava/lang/String;", "messageId$delegate", "localMessageId", "getLocalMessageId", "localMessageId$delegate", "currentConversation", "Lcom/larus/im/bean/conversation/Conversation;", "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "debugServiceDefaultImpl", "Lcom/larus/platform/api/ISdkDebug;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupViews", "Lkotlinx/coroutines/Job;", "setupPrompt", "handleChatData", "chatData", "Lcom/larus/bmhome/debug/ChatDebugViewModel$ChatData;", "setupMessageInfo", "chatMessage", "Lcom/larus/im/bean/message/Message;", "(Lcom/larus/im/bean/message/Message;)Lkotlin/Unit;", "setUpAudioDebugInfo", "sendTTSFileToUserLark", "Lcom/larus/network/bean/BizResponse;", ShareType.FILE, "Ljava/io/File;", "userName", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupConversationInfo", "chatConversation", "(Lcom/larus/im/bean/conversation/Conversation;)Lkotlin/Unit;", "setupBotInfo", "chatBot", "(Lcom/larus/im/bean/bot/BotModel;)Lkotlin/Unit;", "setupOthers", "()Lkotlin/Unit;", "insertLocalCreationMockMessages", "replaceExistingBotBlockMessages", "", "conversationId", "botId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVuiInfo", "clipText", ShareType.TEXT, "", "UploadTTSApi", "Companion", "debug_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatDebugFragment extends Fragment {
    public static final /* synthetic */ int k = 0;
    public LarusPageChatDebugBinding d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public wc9.e h;
    public BotModel i;
    public final h2 j;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/debug/ChatDebugFragment$UploadTTSApi;", "", "uploadFileAndSendToUser", "Lcom/larus/network/bean/BizResponse;", "", ShareType.FILE, "Lokhttp3/MultipartBody$Part;", "userName", "(Lokhttp3/MultipartBody$Part;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debug_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UploadTTSApi {
        @Multipart
        @POST("https://cloudapi.bytedance.net/faas/services/ttk4eh/invoke/uploadFileAndSendToUser")
        Object uploadFileAndSendToUser(@Part okhttp3.k.b r1, @Query("user") String r2, Continuation<? super BizResponse<String>> r3);
    }

    public static final class a {
    }

    static {
    }

    public ChatDebugFragment() {
        final Function0<Fragment> r0 = new ChatDebugFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatDebugViewModel.class), new ChatDebugFragment$special$$inlined$viewModels$default$2(r0), new ChatDebugFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = LazyKt.lazy(new k0(this));
        this.g = LazyKt.lazy(new l0(this));
        com.larus.platform.service.g0 r1 = com.larus.platform.service.g0.a;
        h2 r2 = com.larus.platform.service.g0.r();
        if (r2 != null) goto L5;
        r2 = gp8.b.a;
    L5:
        this.j = r2;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.a.d("ChatDebugFragment", "onDestroyView: called");
        this.d = null;
        x58.a r0 = m58.h.a;
        m58.q r1 = m58.h.d;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    public final void T90(CharSequence r4) {
        ClipData r5 = ClipData.newPlainText("debug_message", r4);
        Context r0 = getContext();
        if (r0 == null) goto L9;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L7;
        r1.d0();
        i1 r2 = i1.a;
        Intrinsics.checkNotNull(r5);
        r2.i(r0, r5, "bpea-debug-tool");
    L7:
        t19.s r6 = t19.s.a;
        Context r3 = getContext();
        r6.getClass();
        t19.s.o(r3, 2131907398, false);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.larus.bmhome.view.NovaTitleBarEx] */
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        FLogger.a.d("ChatDebugFragment", "onViewCreated: called");
        LarusPageChatDebugBinding r16 = this.d;
        if (r16 == null) goto L5;
        ?? r0 = r16.M;
        NovaTitleBarEx.Y5(r0, "Debugger Tool", null, null, 6);
        NovaTitleBarEx.b6(r0, v19.c.b(2130971749, r0.getContext(), 2131241477), false, null, null, new b(this), 14);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatDebugFragment$setupViews$1(this, null), 3, null);
    }

    public final View onCreateView(LayoutInflater r54, ViewGroup r55, Bundle r56) {
        Intrinsics.checkNotNullParameter(r54, "inflater");
        FLogger.a.d("ChatDebugFragment", "onCreateView: called");
        View r0 = r54.inflate(2131563014, r55, false);
        int r1 = 2131362312;
        ItemTextDescView r5 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131362312);
        if (r5 == null) goto L115;
        r1 = 2131362313;
        ItemTextDescView r6 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131362313);
        if (r6 == null) goto L115;
        r1 = 2131363253;
        ItemTextArrow r7 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131363253);
        if (r7 == null) goto L115;
        r1 = 2131363254;
        ItemGroup r8 = (ItemGroup) ViewBindings.findChildViewById(r0, 2131363254);
        if (r8 == null) goto L115;
        r1 = 2131363257;
        ItemTextArrow r9 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131363257);
        if (r9 == null) goto L115;
        r1 = 2131363258;
        ItemTextArrow r10 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131363258);
        if (r10 == null) goto L115;
        r1 = 2131363259;
        ItemGroupTitle r11 = (ItemGroupTitle) ViewBindings.findChildViewById(r0, 2131363259);
        if (r11 == null) goto L115;
        r1 = 2131363428;
        if (((ItemGroup) ViewBindings.findChildViewById(r0, 2131363428)) == null) goto L115;
        r1 = 2131363435;
        if (((ItemGroupTitle) ViewBindings.findChildViewById(r0, 2131363435)) == null) goto L115;
        r1 = 2131364366;
        if (((ItemGroup) ViewBindings.findChildViewById(r0, 2131364366)) == null) goto L115;
        r1 = 2131364372;
        ItemTextDescView r12 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131364372);
        if (r12 == null) goto L115;
        r1 = 2131364373;
        ItemTextArrow r13 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131364373);
        if (r13 == null) goto L115;
        r1 = 2131364376;
        ItemTextDescView r14 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131364376);
        if (r14 == null) goto L115;
        r1 = 2131364377;
        ItemTextDescView r15 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131364377);
        if (r15 == null) goto L115;
        r1 = 2131364387;
        ItemTextDescView r16 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131364387);
        if (r16 == null) goto L115;
        r1 = 2131366939;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r0, 2131366939);
        if (r17 == null) goto L115;
        r1 = 2131367728;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367728);
        if (r18 == null) goto L115;
        r1 = 2131367942;
        if (((ItemGroup) ViewBindings.findChildViewById(r0, 2131367942)) == null) goto L115;
        r1 = 2131367943;
        ItemTextDescView r19 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131367943);
        if (r19 == null) goto L115;
        r1 = 2131367944;
        ItemTextArrow r20 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131367944);
        if (r20 == null) goto L115;
        r1 = 2131368911;
        ItemTextArrow r21 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131368911);
        if (r21 == null) goto L115;
        r1 = 2131375439;
        ItemTextArrow r22 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131375439);
        if (r22 == null) goto L115;
        r1 = 2131379966;
        ItemTextDescView r23 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131379966);
        if (r23 == null) goto L115;
        r1 = 2131379967;
        ItemTextArrow r24 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131379967);
        if (r24 == null) goto L115;
        r1 = 2131379974;
        ItemTextArrow r25 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131379974);
        if (r25 == null) goto L115;
        r1 = 2131379975;
        ItemTextArrow r26 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131379975);
        if (r26 == null) goto L115;
        r1 = 2131379978;
        ItemTextDescView r27 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131379978);
        if (r27 == null) goto L115;
        r1 = 2131379979;
        ItemTextDescView r28 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131379979);
        if (r28 == null) goto L115;
        r1 = 2131379982;
        ItemTextArrow r29 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131379982);
        if (r29 == null) goto L115;
        r1 = 2131379986;
        if (((ItemGroup) ViewBindings.findChildViewById(r0, 2131379986)) == null) goto L115;
        r1 = 2131379987;
        ItemTextDescView r30 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131379987);
        if (r30 == null) goto L115;
        r1 = 2131379988;
        ItemTextArrow r31 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131379988);
        if (r31 == null) goto L115;
        r1 = 2131379989;
        ItemTextDescView r32 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131379989);
        if (r32 == null) goto L115;
        r1 = 2131379990;
        ItemTextDescView r33 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131379990);
        if (r33 == null) goto L115;
        r1 = 2131380003;
        ItemTextDescView r34 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131380003);
        if (r34 == null) goto L115;
        r1 = 2131380011;
        ItemTextArrow r35 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131380011);
        if (r35 == null) goto L115;
        r1 = 2131380016;
        ItemTextArrow r36 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131380016);
        if (r36 == null) goto L115;
        r1 = 2131380020;
        ItemTextDescView r37 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131380020);
        if (r37 == null) goto L115;
        r1 = 2131383379;
        TextView r38 = (TextView) ViewBindings.findChildViewById(r0, 2131383379);
        if (r38 == null) goto L115;
        r1 = 2131383383;
        ItemTextArrow r39 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131383383);
        if (r39 == null) goto L115;
        r1 = 2131383387;
        ItemGroupTitle r40 = (ItemGroupTitle) ViewBindings.findChildViewById(r0, 2131383387);
        if (r40 == null) goto L115;
        r1 = 2131383388;
        ItemGroup r41 = (ItemGroup) ViewBindings.findChildViewById(r0, 2131383388);
        if (r41 == null) goto L115;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L115;
        r1 = 2131388772;
        NovaTitleBarEx r42 = (NovaTitleBarEx) ViewBindings.findChildViewById(r0, 2131388772);
        if (r42 == null) goto L115;
        r1 = 2131389945;
        ItemTextArrow r43 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131389945);
        if (r43 == null) goto L115;
        r1 = 2131389949;
        ItemGroup r44 = (ItemGroup) ViewBindings.findChildViewById(r0, 2131389949);
        if (r44 == null) goto L115;
        r1 = 2131389951;
        ItemTextArrow r45 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131389951);
        if (r45 == null) goto L115;
        r1 = 2131389957;
        ItemTextArrow r46 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131389957);
        if (r46 == null) goto L115;
        r1 = 2131389958;
        ItemTextArrow r47 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131389958);
        if (r47 == null) goto L115;
        r1 = 2131389959;
        ItemGroupTitle r48 = (ItemGroupTitle) ViewBindings.findChildViewById(r0, 2131389959);
        if (r48 == null) goto L115;
        r1 = 2131391765;
        if (((ItemTextToggle) ViewBindings.findChildViewById(r0, 2131391765)) == null) goto L115;
        r1 = 2131392981;
        ItemTextArrow r49 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131392981);
        if (r49 == null) goto L115;
        r1 = 2131392983;
        ItemTextDescView r50 = (ItemTextDescView) ViewBindings.findChildViewById(r0, 2131392983);
        if (r50 == null) goto L115;
        r1 = 2131392984;
        ItemTextArrow r51 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131392984);
        if (r51 == null) goto L115;
        r1 = 2131393159;
        TextView r52 = (TextView) ViewBindings.findChildViewById(r0, 2131393159);
        if (r52 == null) goto L115;
        LinearLayout r2 = (LinearLayout) r0;
        this.d = new LarusPageChatDebugBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
        return r2;
    L115:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public static final Object S90(ChatDebugFragment r239, String r240, String r241, Continuation r242) {
        r239.getClass();
        if ((r242 instanceof ChatDebugFragment$replaceExistingBotBlockMessages$1) == false) goto L7;
        ChatDebugFragment$replaceExistingBotBlockMessages$1 r1 = (ChatDebugFragment$replaceExistingBotBlockMessages$1) r242;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        List r5 = (List) r1.L$1;
        String r6 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L21:
        ArrayList r7 = new ArrayList();
        Iterator r8 = ((Iterable) r0).iterator();
    L23:
        if (r8.hasNext() == false) goto L66;
        Object r9 = r8.next();
        Message r10 = (Message) r9;
        if (r10.getUserType() == 2) goto L27;
    L63:
        boolean r11 = false;
    L64:
        if (r11 == false) goto L23;
        r7.add(r9);
        goto L23
    L27:
        if (Intrinsics.areEqual(r10.getSenderId(), r6) == false) goto L63;
        if (r10.getContentType() != 9999) goto L63;
        if (r10.isNewBlockType() == false) goto L63;
        List r12 = r10.getContentBlock();
        if (r12 == null) goto L52;
        List r13 = r12;
        if ((r13 instanceof Collection) == true) goto L37;
    L39:
        Iterator r14 = r13.iterator();
    L41:
        if (r14.hasNext() == false) goto L48;
        if (((Block) r14.next()).getBlockType() != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L45;
        boolean r15 = true;
    L46:
        if (r15 == false) goto L41;
        boolean r16 = true;
    L50:
        if (r16 != true) goto L52;
        boolean r17 = true;
    L53:
        if (r17 == false) goto L63;
        String r18 = r10.getMessageId();
        if (r18 != null) goto L57;
    L60:
        boolean r19 = true;
    L61:
        if (r19 == true) goto L63;
        r11 = true;
        goto L64
    L57:
        if (StringsKt.isBlank(r18) == true) goto L60;
        r19 = false;
        goto L61
    L45:
        r15 = false;
    L48:
        r16 = false;
        goto L50
    L37:
        if (r13.isEmpty() == false) goto L39;
    L52:
        r17 = false;
        goto L53
    L66:
        List r20 = CollectionsKt.sortedWith(r7, new m0());
        if (r20.isEmpty() == true) goto L102;
        Iterator r21 = CollectionsKt.zip(CollectionsKt.take(r20, r5.size()), r5).iterator();
    L71:
        if (r21.hasNext() == false) goto L86;
        Pair r22 = (Pair) r21.next();
        Message r23 = (Message) r22.component1();
        final Block r24 = (Block) r22.component2();
        String r25 = r23.getLocalMessageId();
        if (r25 == null) goto L81;
        if ((!StringsKt.isBlank(r25)) == true) goto L78;
        r25 = null;
    L78:
        if (r25 == null) goto L81;
    L84:
        com.larus.im.d.e().x(r25, new j0(r24), null);
    L81:
        r25 = r23.getMessageId();
        if (r25 != null) goto L84;
        r25 = "";
        goto L84
    L86:
        return Boxing.boxInt(Math.min(r20.size(), r5.size()));
    L102:
        return Boxing.boxInt(0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        int r26 = o0.a;
        BlockType r27 = BlockType.BLOCK_TYPE_CREATION;
        List r28 = CollectionsKt.listOf(new Block[]{new Block(r27.getValue(), "mock_local_creation_images_block", null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new CreationBlock(CollectionsKt.listOf(new CreationItem[]{o0.b("mock_local_image_1", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783437666678.png"), o0.b("mock_local_image_2", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783491257849.png"), o0.b("mock_local_image_3", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783491268108.png"), o0.b("mock_local_image_4", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783491268948.png"), o0.b("mock_local_image_5", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783491278054.png")}), "local_shell_mock"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777217, -1, 31, null), true, null, null, null, 228, null), new Block(r27.getValue(), "mock_local_creation_video_block", null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new CreationBlock(CollectionsKt.listOf(o0.c()), "local_shell_mock"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777217, -1, 31, null), true, null, null, null, 228, null), new Block(r27.getValue(), "mock_local_creation_mixed_block", null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new CreationBlock(CollectionsKt.listOf(new CreationItem[]{o0.c(), o0.b("mock_local_image_1", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783437666678.png"), o0.b("mock_local_image_2", "/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783491257849.png")}), "local_shell_mock"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777217, -1, 31, null), true, null, null, null, 228, null)});
        if (r28.isEmpty() == true) goto L101;
        IChatRepoService r29 = RepoDispatcherDelegate.b.e();
        r1.L$0 = r241;
        r1.L$1 = r28;
        r1.label = 1;
        Object r30 = r29.o1(r240, 100, r1);
        if (r30 == r3) goto L103;
        r5 = r28;
        r0 = r30;
        r6 = r241;
        goto L21
    L103:
        return r3;
    L101:
        return Boxing.boxInt(0);
    L7:
        r1 = new ChatDebugFragment$replaceExistingBotBlockMessages$1(r239, r242);
        goto L8
    }
}
