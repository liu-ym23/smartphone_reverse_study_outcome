package com.larus.bmhome.bot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusPageServiceBotSettingBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020%H\u0016J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0016J\u000f\u00105\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00106J\u000f\u0010\t\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020%H\u0002J\b\u00108\u001a\u00020%H\u0002J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0002J\u0018\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020%2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002J\u0018\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020%2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010M\u001a\u00020)2\u0006\u0010J\u001a\u00020NH\u0002J,\u0010O\u001a\u00020%2\u0006\u0010J\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00072\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020%0SH\u0002J\u0018\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/bmhome/bot/ServiceBotSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusPageServiceBotSettingBinding;", "isSubPage", "", "()Z", "showMoreMenu", "getShowMoreMenu", "pageTitle", "", "getPageTitle", "()Ljava/lang/String;", "conversationId", "getConversationId", "botId", "getBotId", "supplierId", "getSupplierId", "botSettingViewModel", "Lcom/larus/bmhome/bot/BotSettingViewModel;", "getBotSettingViewModel", "()Lcom/larus/bmhome/bot/BotSettingViewModel;", "botSettingViewModel$delegate", "Lkotlin/Lazy;", "settingViewModel", "Lcom/larus/bmhome/bot/ServiceBotSettingViewModel;", "getSettingViewModel", "()Lcom/larus/bmhome/bot/ServiceBotSettingViewModel;", "settingViewModel$delegate", "trace", "Lcom/larus/bmhome/bot/BotSettingTrace;", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "", "params", "Lcom/ixigua/lib/track/TrackParams;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "setupTitleBar", "()Lkotlin/Unit;", "clearHistory", "performBack", "initObserver", "initSettingObserver", "findConversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "cvsId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderBlocks", "blocks", "", "Lcom/larus/bmhome/bot/ServiceBotSettingBlock;", "createCategoryTitle", ChatDraftItem.TYPE_TEXT, "isFirst", "createSpacer", "height", "", "createSupplierItem", "item", "Lcom/larus/bmhome/bot/ServiceBotSettingItem$SupplierItem;", "openSupplierPage", "createToggleItem", "Lcom/larus/bmhome/bot/ServiceBotSettingItem$ToggleItem;", "bindToggle", "Lcom/larus/bmhome/bot/view/ServiceBotSettingFrescoToggleView;", "checked", "onChanged", "Lkotlin/Function1;", "revertToggle", "itemId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ServiceBotSettingFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusPageServiceBotSettingBinding e;
    public final Lazy f;
    public final Lazy g;
    public final com.larus.bmhome.bot.b h;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "bot_setting";
    }

    public final ServiceBotSettingViewModel W90() {
        return (ServiceBotSettingViewModel) this.g.getValue();
    }

    public final void onPause() {
        FLogger.a.i("ServiceBotSettingFragment", "onPause isSubPage=" + Y90() + " botId=" + getBotId() + " supplierId=" + X90());
        if (Y90() == false) goto L5;
        W90().flushDetailToFullCache$impl_mainlandRelease();
    L5:
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public ServiceBotSettingFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotSettingViewModel.class), new ServiceBotSettingFragment$special$$inlined$activityViewModels$default$1(this), new ServiceBotSettingFragment$special$$inlined$activityViewModels$default$2(this));
        final Function0<Fragment> r0 = new ServiceBotSettingFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServiceBotSettingViewModel.class), new ServiceBotSettingFragment$special$$inlined$viewModels$default$2(r0), new ServiceBotSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = new com.larus.bmhome.bot.b();
    }

    public final String V90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_service_bot_setting_title");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_service_bot_supplier_id");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean Y90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("arg_service_bot_setting_is_sub_page", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String getBotId() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_service_bot_id");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getConversationId() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_service_bot_conversation_id");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onResume() {
        super.onResume();
        FLogger.a.i("ServiceBotSettingFragment", "onResume isSubPage=" + Y90() + " botId=" + getBotId() + " supplierId=" + X90());
        if (Y90() == true) goto L6;
        W90().refreshFromFullCache$impl_mainlandRelease();
        return;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        int r1 = e6.a;
        String r2 = getBotId();
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r2, "botId");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r3.put("bot_id", r2);
    L8:
        r3.put("bot_type", 4);
        r3.put("chat_type", "notice");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusPageServiceBotSettingBinding r13 = this.e;
        if (r13 == null) goto L14;
        NovaTitleBarEx.Y5(r13.d, V90(), null, null, 6);
        NovaTitleBarEx.b6(r13.d, v19.c.b(2130971749, requireContext(), 2131241477), false, null, getString(2131898805), new v5(this), 6);
        Bundle r14 = getArguments();
        boolean r0 = true;
        if (r14 == null) goto L8;
        r0 = r14.getBoolean("arg_service_bot_setting_show_menu", true ^ Y90());
    L11:
        if (r0 == false) goto L13;
        NovaTitleBarEx.i6(r13.d, v19.c.b(2130971662, requireContext(), 2131240955), null, getString(2131898833), new w5(this), 6);
    L13:
        Unit r15 = Unit.INSTANCE;
        goto L14
    L8:
        if (Y90() == false) goto L11;
        r0 = false;
    L14:
        ((BotSettingViewModel) this.f.getValue()).getChatHistoryClearSuccess().observe(getViewLifecycleOwner(), new b(new u5(this)));
        W90().getUiState().observe(getViewLifecycleOwner(), new b(new s5(this)));
        W90().getEvent().observe(getViewLifecycleOwner(), new b(new t5(this)));
        W90().loadSettings(getBotId(), getConversationId(), X90(), V90(), Y90());
    }

    public static final Object U90(ServiceBotSettingFragment r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof ServiceBotSettingFragment$findConversationInfo$1) == false) goto L7;
        ServiceBotSettingFragment$findConversationInfo$1 r0 = (ServiceBotSettingFragment$findConversationInfo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ServiceBotSettingFragment$findConversationInfo$1 r5 = r0;
        Object r10 = r5.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r5.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L17:
        wc9.e r12 = (wc9.e) r10;
        if (r12 == null) goto L20;
        FLogger.a.d("ServiceBotSettingFragment", "Found conversation info: " + r12);
    L22:
        return r12;
    L20:
        r12 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        RepoDispatcher.a.getClass();
        ConversationRepo r13 = RepoDispatcher.f;
        r5.label = 1;
        r10 = IConversationRepoService$a.c(r13, r8, false, null, r5, 6);
        if (r10 != r11) goto L17;
        return r11;
    L7:
        r0 = new ServiceBotSettingFragment$findConversationInfo$1(r7, r9);
        goto L8
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131563067, r4, false);
        int r7 = 2131367771;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131367771);
        if (r8 == null) goto L14;
        r7 = 2131385238;
        NestedScrollView r0 = ViewBindings.findChildViewById(r6, 2131385238);
        if (r0 == null) goto L14;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L14;
        LinearLayout r9 = (LinearLayout) r6;
        this.e = new LarusPageServiceBotSettingBinding(r9, r8, r0, r1);
        if (r9 == null) goto L12;
        return r9;
    L12:
        return new View(requireContext());
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
