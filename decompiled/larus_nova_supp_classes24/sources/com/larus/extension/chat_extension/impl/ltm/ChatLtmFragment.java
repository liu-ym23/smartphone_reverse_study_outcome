package com.larus.extension.chat_extension.impl.ltm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.extension.chat_extension.impl.databinding.LarusPageChatLtmShowBinding;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.im.service.BotChangeType;
import com.larus.im.service.y;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.v;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000f*\u0001E\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0006J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u000f\u0010-\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u001a2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002J)\u00103\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\b\u0002\u00108\u001a\u000209¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020&2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002J\b\u0010=\u001a\u00020\u001aH\u0002J\n\u0010>\u001a\u0004\u0018\u00010,H\u0002J\u000f\u0010?\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010.J\b\u0010@\u001a\u00020AH\u0002J\u000e\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001cJ\b\u0010G\u001a\u00020\u001aH\u0002J\"\u0010H\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010I\u001a\u00020&H\u0082@¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020\u001aH\u0016J\u0016\u0010L\u001a\u00020\u001a2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000601H\u0016J\n\u0010N\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010O\u001a\u00020\u0006H\u0016J\n\u0010P\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010Q\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010F¨\u0006S"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;", "<init>", "()V", "botID", "", "conversationId", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "previousPage", "binding", "Lcom/larus/extension/chat_extension/impl/databinding/LarusPageChatLtmShowBinding;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "ltmListAdapter", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmListAdapter;", "ltmViewModel", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmViewModel;", "getLtmViewModel", "()Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmViewModel;", "ltmViewModel$delegate", "Lkotlin/Lazy;", "listener", "Lcom/larus/im/service/OnBotChangedListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "autoLogEnterPage", "", "onDestroyView", "getCurrentPageName", "performBack", "leaveMethod", "showTitleBarLeftImg", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupList", "()Lkotlin/Unit;", "updateEmptyPageVisibility", "list", "", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "scrollToMatchedMemory", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "targetIndex", "", "delayMs", "", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/lang/Integer;J)V", "isEmptyMemory", "currentList", "updateList", "setupTitle", "startMoreMenu", "setupViews", "Lkotlinx/coroutines/Job;", "onResult", "bundle", "appBackGroundListener", "com/larus/extension/chat_extension/impl/ltm/ChatLtmFragment$appBackGroundListener$1", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmFragment$appBackGroundListener$1;", "clearLtmHistory", "findBotInfoByBotID", "forceNew", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addItemClick", "removeItemClick", "memoryIDS", "getBotInfo", "getConversationID", "getPreviousPage", "getCurrentPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmFragment extends TraceFragment implements j99.j {
    public static final /* synthetic */ int o = 0;
    public String e;
    public String f;
    public BotModel g;
    public String h;
    public LarusPageChatLtmShowBinding i;
    public FragmentExtKt.addOnBackPressed.callback.1 j;
    public final ChatLtmListAdapter k;
    public final Lazy l;
    public final c m;
    public final b n;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ ChatLtmFragment a;

        public final void onAppForeground() {
        }

        public final void onAllActivityDestroyed() {
            this.a.N9("kill_app");
        }

        public final void onAppBackground() {
            this.a.N9("to_background");
        }

        public b(ChatLtmFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements y {
        public final /* synthetic */ ChatLtmFragment a;

        public c(ChatLtmFragment r1) {
            this.a = r1;
        }

        public final void a(List<BotModel> r2, BotChangeType r3) {
            Intrinsics.checkNotNullParameter(r2, "changedBots");
            Intrinsics.checkNotNullParameter(r3, "changeType");
            final BotModel r4 = (BotModel) CollectionsKt.getOrNull(r2, 0);
            if (r4 == null) goto L6;
            SoftReference r5 = com.larus.utils.y.a;
            final ChatLtmFragment r6 = this.a;
            com.larus.utils.y.c(new i(r6, r4));
            return;
        }
    }

    public static final class d implements p0 {
        public final /* synthetic */ ChatLtmFragment a;
        public final /* synthetic */ List<String> b;

        public final void confirm() {
            BotModel r0 = this.a.g;
            String r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");
            r0 = null;
        L5:
            String r2 = r0.getBotId();
            String r3 = this.a.f;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        L9:
            this.a.getClass();
            String r4 = this.a.h;
            JSONObject r5 = new JSONObject();
            Intrinsics.checkNotNullParameter(r5, "params");
            if (r2 != null) goto L27;
        L14:
            if (r1 == null) goto L16;
            r5.put("conversation_id", r1);     // Catch: JSONException -> L12
        L16:
            r5.put("current_page", "memory_manage");     // Catch: JSONException -> L12
            if (r4 == null) goto L19;
            r5.put("previous_page", r4);     // Catch: JSONException -> L12
        L19:
            r5.put("type", "delete_one");     // Catch: JSONException -> L12
        L22:
            TrackParams r6 = new TrackParams().merge(r5);
            by7.a r7 = new by7.a("confirm_delete_memory");
            r7.a.merge(r6);
            r7.b();
            if (NetworkUtils.isNetworkAvailable(this.a.requireContext().getApplicationContext()) == false) goto L25;
            this.a.V90().requireDeleteLtmItem(this.b);
            return;
        L25:
            t19.s r8 = t19.s.a;
            Context r9 = this.a.getContext();
            r8.getClass();
            t19.s.b(r9, 2131906741, false);
            return;
        L12:
            e = move-exception;
            FLogger.a.e("ConfirmEventHelper", "error in ConfirmEventHelper mobConfirmDeleteMemory " + e.getLocalizedMessage());
            goto L22
        L27:
            r5.put("bot_id", r2);     // Catch: JSONException -> L12
            goto L14
        L8:
            r1 = r3;
            goto L9
        }

        public d(ChatLtmFragment r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements u {
        public e() {
        }

        public final void cancel() {
        }
    }

    public static final class f implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public f(com.larus.extension.chat_extension.impl.ltm.d r2) {
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
        return false;
    }

    @Override // j99.j
    public final String getCurrentPage() {
        return "memory_manage";
    }

    public final String k() {
        return "memory_manage";
    }

    @Override // j99.j
    public final BotModel B0() {
        BotModel r0 = this.g;
        if (r0 == null) goto L7;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        goto L7
    L8:
        return r0;
    L7:
        return null;
    }

    public final ChatLtmViewModel V90() {
        return (ChatLtmViewModel) this.l.getValue();
    }

    @Override // j99.j
    public final String getConversationID() {
        String r0 = this.f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        return null;
    L6:
        return r0;
    }

    @Override // j99.j
    public final void tY() {
        BotModel r0 = this.g;
        String r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L5:
        BotMemoryConfig r1 = r0.getBotMemoryConfig();
        if (r1 == null) goto L8;
        boolean r3 = Intrinsics.areEqual(r1.getSwitchStatus(), Boolean.TRUE);
    L9:
        if (r3 == true) goto L11;
        t19.s.a.g(getContext(), 2131908119, false);
        return;
    L11:
        if (V90().isOverCnt() == false) goto L14;
        t19.s.a.g(AppHost.a.getApplication(), 2131907366, false);
        return;
    L14:
        BotModel r4 = this.g;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L17:
        String r5 = r4.getBotId();
        String r6 = this.f;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L21:
        String r7 = this.h;
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r5 != null) goto L43;
    L26:
        if (r2 == null) goto L28;
        r8.put("conversation_id", r2);     // Catch: JSONException -> L24
    L28:
        r8.put("current_page", "memory_manage");     // Catch: JSONException -> L24
        if (r7 == null) goto L33;
        r8.put("previous_page", r7);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickCreateMemory " + e.getLocalizedMessage());
    L33:
        TrackParams r9 = new TrackParams().merge(r8);
        by7.a r10 = new by7.a("click_create_memory");
        r10.a.merge(r9);
        r10.b();
        ChatLtmInputFragment r11 = new ChatLtmInputFragment();
        FragmentManager r12 = getParentFragmentManager();
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "ChatLtmInputFragment", r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r11, r13) == true) goto L46;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L37:
        r11.show(r12, "ChatLtmInputFragment");
        return;
    L46:
        return;
    L43:
        r8.put("bot_id", r5);     // Catch: JSONException -> L24
        goto L26
    L20:
        r2 = r6;
        goto L21
    L8:
        r3 = false;
        goto L9
    }

    public ChatLtmFragment() {
        this.k = new ChatLtmListAdapter(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatLtmViewModel.class), new ChatLtmFragment$special$$inlined$activityViewModels$default$1(this), new ChatLtmFragment$special$$inlined$activityViewModels$default$2(this));
        this.m = new c(this);
        this.n = new b(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        AppHost.a.a().c(this.n);
        if (this.g == null) goto L11;
        BotServiceImpl r0 = com.larus.im.d.a();
        BotModel r2 = this.g;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r2 = null;
    L7:
        String r3 = r2.getBotId();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r0.unregisterBotChangeListener(r3, this.m);
    L11:
        FragmentExtKt.addOnBackPressed.callback.1 r1 = this.j;
        if (r1 == null) goto L14;
        r1.remove();
    L14:
        this.i = null;
    }

    @Override // j99.j
    public final String b() {
        return this.h;
    }

    @Override // j99.j
    public final void FW(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "memoryIDS");
        BotModel r0 = this.g;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L5:
        String r2 = r0.getBotId();
        String r3 = this.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L9:
        String r4 = this.h;
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r2 != null) goto L24;
    L14:
        if (r1 == null) goto L16;
        r5.put("conversation_id", r1);     // Catch: JSONException -> L12
    L16:
        r5.put("current_page", "memory_manage");     // Catch: JSONException -> L12
        if (r4 == null) goto L19;
        r5.put("previous_page", r4);     // Catch: JSONException -> L12
    L19:
        r5.put("type", "delete_one");     // Catch: JSONException -> L12
    L22:
        TrackParams r6 = new TrackParams().merge(r5);
        by7.a r7 = new by7.a("click_delete_memory");
        r7.a.merge(r6);
        r7.b();
        CommonDialog.a r9 = new CommonDialog.a();
        r9.i(getString(2131901599));
        r9.g(getString(2131901598));
        CommonDialog.a.f(r9, new d(this, r8), getString(2131900203), false, 12);
        CommonDialog.a.e(r9, new e(), getString(2131900202), 4);
        U90(r9.a(), getChildFragmentManager());
        return;
    L12:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickDeleteMemory " + e.getLocalizedMessage());
        goto L22
    L24:
        r5.put("bot_id", r2);     // Catch: JSONException -> L12
        goto L14
    L8:
        r1 = r3;
        goto L9
    }

    public final void N9(String r5) {
        Intrinsics.checkNotNullParameter(r5, "leaveMethod");
        if (this.g != null) goto L5;
        return;
    L5:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L9;
        r6.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("navigate_up_from", "memory_manage")})));
        return;
    }

    public final void W90(List<r> r5) {
        int r1 = 8;
        if (AppHost.a.isOversea() == false) goto L10;
        LarusPageChatLtmShowBinding r6 = this.i;
        if (r6 == null) goto L29;
        LinearLayout r7 = r6.b;
        if (r7 == null) goto L30;
        r7.setVisibility(8);
        return;
    L30:
        return;
    L29:
        return;
    L10:
        boolean r2 = true;
        if (r5 != null) goto L14;
    L21:
        LarusPageChatLtmShowBinding r8 = this.i;
        if (r8 == null) goto L31;
        LinearLayout r9 = r8.b;
        if (r9 == null) goto L32;
        if (r2 == false) goto L27;
        r1 = 0;
    L27:
        r9.setVisibility(r1);
        return;
    L32:
        return;
    L31:
        return;
    L14:
        if (r5.isEmpty() == true) goto L21;
        if (r5.size() == 1) goto L18;
    L20:
        r2 = false;
        goto L21
    L18:
        if (((r) ListProtector.get(r5, 0)).c != ChatLtmStatus.NO_STATUS) goto L20;
        goto L20
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FLogger.a.d("ChatLtmFragment", "Router arguments: " + this + ' ' + getArguments());
        Bundle r4 = getArguments();
        String r0 = "";
        if (r4 == null) goto L6;
        String r5 = r4.getString("chat_ltm_conversation_id", "");
        if (r5 == null) goto L6;
    L7:
        this.f = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L11;
        String r7 = r6.getString("bot_id", "");
        if (r7 == null) goto L11;
    L12:
        this.e = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L18;
        String r9 = r8.getString("chat_ltm_previous_page", "");
        if (r9 == null) goto L18;
        r0 = r9;
    L18:
        this.h = r0;
        return;
    L11:
        r7 = "";
    L6:
        r5 = "";
        goto L7
    }

    public static void U90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        AppHost.a.a().j(this.n);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new ChatLtmFragment$setupViews$1(this, null), 2, null);
        this.j = v.a(this, new com.larus.extension.chat_extension.impl.ltm.c(this));
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131563019, r8, false);
        int r11 = 2131371582;
        if (((ImageView) ViewBindings.findChildViewById(r10, 2131371582)) == null) goto L18;
        r11 = 2131371594;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131371594);
        if (r2 == null) goto L18;
        r11 = 2131371602;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131371602);
        if (r3 == null) goto L18;
        r11 = 2131379230;
        RecyclerView r4 = ViewBindings.findChildViewById(r10, 2131379230);
        if (r4 == null) goto L18;
        r11 = 2131388772;
        NovaTitleBarEx r5 = ViewBindings.findChildViewById(r10, 2131388772);
        if (r5 == null) goto L18;
        LinearLayout r12 = (LinearLayout) r10;
        this.i = new LarusPageChatLtmShowBinding(r12, r2, r3, r4, r5);
        if (r12 == null) goto L15;
        r12.setTag(2131377847, this);
        return r12;
    L15:
        return null;
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
