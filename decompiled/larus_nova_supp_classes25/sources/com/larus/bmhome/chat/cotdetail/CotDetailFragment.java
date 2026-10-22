package com.larus.bmhome.chat.cotdetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.d1;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.thread.GetThreadSource;
import com.larus.im.bean.thread.ThreadData;
import com.larus.im.service.x;
import com.larus.mainbot.impl.databinding.LarusPageCotDetailBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchErrorBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchLoadingBinding;
import com.larus.platform.service.o;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import ee8.f;
import ee8.g;
import ee8.h;
import ee8.i;
import ee8.p;
import java.util.concurrent.CopyOnWriteArraySet;
import kc8.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\f\u0010 \u001a\u00020\u0012*\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\u0012\u0010$\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\bH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010*\u001a\u00020'H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\bH\u0016J\u000f\u0010,\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u0010.J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J-\u00106\u001a\u00020\u00122#\u00107\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00120\u000fH\u0016J\b\u00108\u001a\u00020\u0012H\u0016J\b\u00109\u001a\u00020\u0012H\u0016J\b\u0010:\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\r\u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00120\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006<"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/CotDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "threadId", "", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "threadData", "Lcom/larus/im/bean/thread/ThreadData;", "threadDataCallbackSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "ttsStateObserver", "com/larus/bmhome/chat/cotdetail/CotDetailFragment$ttsStateObserver$1", "Lcom/larus/bmhome/chat/cotdetail/CotDetailFragment$ttsStateObserver$1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "addSpeakerView", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "attachComponent", "initData", "fetchThreadInfo", "bindToVContext", "autoLogEnterPage", "", "getCurrentPageName", "conversationId", "disableInput", "taskCardMessageId", "sourceType", "", "()Ljava/lang/Integer;", "interactionTrackContext", "Lcom/larus/bmhome/interactionpanel/InteractionTrackContext;", "showClarificationAnswerDetail", "interactionAskBlock", "Lcom/larus/im/bean/message/block/InteractionAskBlock;", "message", "Lcom/larus/im/bean/message/Message;", "getThreadData", "callback", "logEnterPage", "finish", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailFragment extends TraceFragment implements fe8.a {
    public static final /* synthetic */ int k = 0;
    public LarusPageCotDetailBinding e;
    public String f;
    public y g;
    public ThreadData h;
    public final CopyOnWriteArraySet<Function1<ThreadData, Unit>> i;
    public final c j;

    public static final class a {
    }

    public static final class b implements m {
        public final /* synthetic */ CotDetailFragment a;

        @Override // va8.m
        public final Fragment getChatFragment() {
            return null;
        }

        @Override // va8.m
        public final l iX() {
            LarusPageCotDetailBinding r0 = this.a.e;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new ee8.a(r0);
        }

        public b(CotDetailFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements n68.a {
        public c() {
        }

        public final void c(PlayStateEnum r1) {
        }

        public final void d(PlayStateEnum r1) {
        }

        public final void e(TtsErrorType r1) {
        }

        public final void a(boolean r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }

        public final void b(boolean r1, String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "cot_detail";
    }

    @Override // fe8.a
    public final String K() {
        y r0 = this.g;
        if (r0 == null) goto L7;
        Function0<String> r1 = r0.f;
        if (r1 == null) goto L7;
        return (String) r1.invoke();
    L7:
        return null;
    }

    public final void T90() {
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("message_id", Om());
        y r2 = this.g;
        String r3 = null;
        if (r2 == null) goto L7;
        Function0<String> r4 = r2.f;
        if (r4 == null) goto L7;
        String r5 = (String) r4.invoke();
    L8:
        r1.put("conversation_id", r5);
        y r6 = this.g;
        if (r6 == null) goto L15;
        Function0<BotModel> r7 = r6.l;
        if (r7 == null) goto L15;
        BotModel r8 = (BotModel) r7.invoke();
        if (r8 == null) goto L15;
        r3 = r8.getBotId();
    L15:
        r1.put("bot_id", r3);
        r1.put("current_page", "general_agent_cot_detail");
        r1.put("is_general_agent", "1");
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r1);
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void onDestroy() {
        FLogger.a.i("CotDetailFragment", "onDestroy, CotDetailFragment==========");
        AudioServiceDelegate.a.r0().k(this.j);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        String r0 = this.f;
        if (r0 == null) goto L6;
        x.a.getClass();
        x.a.a().c(r0, false);
        return;
    }

    public CotDetailFragment() {
        this.i = new CopyOnWriteArraySet();
        this.j = new c();
    }

    @Override // fe8.a
    public final Integer Jo() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.containsKey("source_type") == true) goto L8;
        return null;
    L8:
        Integer r1 = Integer.valueOf(r0.getInt("source_type", -1));
        if (r1.intValue() < 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        return null;
    L14:
        return r1;
    L11:
        r2 = false;
        goto L12
    }

    @Override // fe8.a
    public final boolean Ny() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("disable_input", false);
    }

    @Override // fe8.a
    public final String Om() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("message_id");
    }

    @Override // fe8.a
    public final void finish() {
        DialogFragment r0 = getParentFragment();
        if ((r0 instanceof DialogFragment) == false) goto L5;
        DialogFragment r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        FragmentManager r2 = r1.getChildFragmentManager();
        FLogger.a.i("CotDetailFragment", "finish, threadId=" + this.f + ", backStackCount=" + r2.getBackStackEntryCount());
        if (r2.getBackStackEntryCount() <= 0) goto L18;
        r2.popBackStack();
        return;
    L18:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L21;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        d1 r0 = AudioServiceDelegate.a.i0();
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        String r2 = r1.getString("argConversationId");
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.b(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // fe8.a
    public final w vF() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("interaction_display_type");
    L6:
        Bundle r2 = getArguments();
        if (r2 == null) goto L9;
        String r3 = r2.getString("interaction_agent_type");
    L10:
        boolean r4 = false;
        if (r1 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L25;
        if (r3 != null) goto L20;
    L21:
        r4 = true;
    L22:
        if (r4 == false) goto L25;
        return null;
    L20:
        if (StringsKt.isBlank(r3) == false) goto L22;
    L25:
        return new w(r1, r3);
    L13:
        if (StringsKt.isBlank(r1) == true) goto L16;
        r5 = false;
        goto L17
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // fe8.a
    public final String Kd() {
        return this.f;
    }

    @Override // fe8.a
    public final y ao() {
        return this.g;
    }

    @Override // fe8.a
    public final LarusPageCotDetailBinding e() {
        return this.e;
    }

    @Override // fe8.a
    public final void RG(Function1<? super ThreadData, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.i("CotDetailFragment", "getThreadData, threadId: " + this.f + ", threadData: " + this.h);
        ThreadData r0 = this.h;
        if (r0 == null) goto L5;
        r4.invoke(r0);
        return;
    L5:
        this.i.add(r4);
    }

    public final void onCreate(Bundle r20) {
        FLogger r1 = FLogger.a;
        r1.i("CotDetailFragment", "onCreate, CotDetailFragment==========");
        super.onCreate(r20);
        Bundle r3 = getArguments();
        Long r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getString("thread_id");
    L6:
        this.f = r5;
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r1.e("CotDetailFragment", "threadId is null or empty");
        finish();
    L23:
        s1a.a.g(this).n(new de8.c(getArguments(), getArguments(), true, null, null, false, null, null, null, null, false, false, null, 0, 32760), de8.c.class);
        s1a.a.g(this).c(this, fe8.a.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new f(this));
        AudioServiceDelegate.a.r0().m(this.j);
        return;
    L15:
        String r7 = this.f;
        r1.i("CotDetailFragment", "fetchThreadInfo, threadId: " + r7);
        if (r7 == null) goto L19;
        x.a.getClass();
        x.a.a().c(r7, true);
        x.a.a().a(r7, GetThreadSource.GetThreadSource_MIXED, new p(this, r7));
    L19:
        int r2 = y.J;
        y.a r8 = new y.a();
        r8.C = this;
        r8.p = new g(this);
        r8.h = new h(this);
        r8.i = new i(this);
        Bundle r9 = getArguments();
        if (r9 == null) goto L22;
        r4 = Long.valueOf(r9.getLong("unique_key", 0));
    L22:
        r8.e = r4;
        this.g = r8.a();
        goto L23
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r25, ViewGroup r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r25, "inflater");
        View r1 = r25.inflate(2131563029, r26, false);
        int r2 = 2131364480;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131364480);
        if (r7 == null) goto L127;
        r2 = 2131364488;
        BottomMenuGridLayout r8 = ViewBindings.findChildViewById(r1, 2131364488);
        if (r8 == null) goto L127;
        r2 = 2131365254;
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131365254)) == null) goto L127;
        r2 = 2131365588;
        ChatConstraintLayout r9 = ViewBindings.findChildViewById(r1, 2131365588);
        if (r9 == null) goto L127;
        r2 = 2131367987;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131367987);
        if (r10 == null) goto L127;
        ViewStub r11 = (ViewStub) ViewBindings.findChildViewById(r1, 2131367988);
        if (r11 == null) goto L125;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131375324);
        if (r12 == null) goto L124;
        ViewStub r13 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375364);
        if (r13 == null) goto L123;
        TouchInterceptingView r14 = ViewBindings.findChildViewById(r1, 2131375385);
        if (r14 != null) goto L21;
        r2 = 2131375385;
        goto L127
    L21:
        if (ViewBindings.findChildViewById(r1, 2131375556) != null) goto L23;
        r2 = 2131375556;
        goto L127
    L23:
        if (ViewBindings.findChildViewById(r1, 2131377386) == null) goto L120;
        AppCompatImageView r16 = ViewBindings.findChildViewById(r1, 2131381793);
        if (r16 == null) goto L119;
        View r6 = ViewBindings.findChildViewById(r1, 2131381799);
        if (r6 == null) goto L118;
        LarusPageDeepResearchErrorBinding r17 = LarusPageDeepResearchErrorBinding.a(r6);
        View r15 = ViewBindings.findChildViewById(r1, 2131381803);
        if (r15 == null) goto L117;
        LarusPageDeepResearchLoadingBinding r18 = LarusPageDeepResearchLoadingBinding.a(r15);
        AppCompatImageView r19 = ViewBindings.findChildViewById(r1, 2131381809);
        if (r19 == null) goto L116;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r1, 2131381811);
        if (r110 != null) goto L35;
        r2 = 2131381811;
        goto L127
    L35:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131382457)) == null) goto L114;
        FrameLayout r20 = (FrameLayout) r1;
        if (((Space) ViewBindings.findChildViewById(r1, 2131387040)) != null) goto L39;
        r2 = 2131387040;
        goto L127
    L39:
        if (((Space) ViewBindings.findChildViewById(r1, 2131387041)) != null) goto L41;
        r2 = 2131387041;
        goto L127
    L41:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131387057)) == null) goto L111;
        View r21 = ViewBindings.findChildViewById(r1, 2131387119);
        if (r21 != null) goto L45;
        r2 = 2131387119;
        goto L127
    L45:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131387487)) != null) goto L47;
        r2 = 2131387487;
        goto L127
    L47:
        if (ViewBindings.findChildViewById(r1, 2131388843) == null) goto L108;
        View r22 = ViewBindings.findChildViewById(r1, 2131388868);
        if (r22 != null) goto L51;
        r2 = 2131388868;
        goto L127
    L51:
        if (ViewBindings.findChildViewById(r1, 2131389133) != null) goto L53;
        r2 = 2131389133;
        goto L127
    L53:
        if (ViewBindings.findChildViewById(r1, 2131389273) == null) goto L105;
        this.e = new LarusPageCotDetailBinding(r20, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r110, r20, r21, r22);
        LinearLayout r3 = r18.a;
        if (r3 == null) goto L57;
        e1.x(r3);
    L57:
        LarusPageCotDetailBinding r4 = this.e;
        if (r4 == null) goto L62;
        ViewStub r5 = r4.h;
        if (r5 == null) goto L62;
        InputViewCreatorDelegate.b.a(r5, 2131375364);
    L62:
        LarusPageCotDetailBinding r23 = this.e;
        if (r23 == null) goto L67;
        ChatConstraintLayout r24 = r23.d;
        if (r24 == null) goto L67;
        View r28 = IAIChatUgcAIGCService.a.K(r24.getContext());
        r28.setId(2131387057);
        ConstraintLayout.LayoutParams r29 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r29).bottomMargin = i5.h();
        r28.setLayoutParams(r29);
        e1.o(r28);
        r24.addView(r28);
        ConstraintSet r30 = new ConstraintSet();
        r30.clone(r24);
        r30.connect(2131387057, 4, 2131375324, 4);
        r30.applyTo(r24);
    L67:
        Context r31 = getContext();
        if (r31 == null) goto L74;
        LarusPageCotDetailBinding r32 = this.e;
        if (r32 == null) goto L74;
        ChatConstraintLayout r33 = r32.d;
        if (r33 == null) goto L74;
        r33.k6(r31);
    L74:
        LarusPageCotDetailBinding r34 = this.e;
        if (r34 == null) goto L79;
        ChatConstraintLayout r35 = r34.d;
        if (r35 == null) goto L79;
        r35.U5();
    L79:
        LarusPageCotDetailBinding r36 = this.e;
        if (r36 == null) goto L88;
        ChatConstraintLayout r37 = r36.d;
        if (r37 == null) goto L88;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        if (r38 == null) goto L87;
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r38;
        r39.topMargin = 0;
        r39.bottomMargin = 0;
        r37.setLayoutParams(r39);
        goto L88
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L88:
        LarusPageCotDetailBinding r40 = this.e;
        if (r40 == null) goto L93;
        ChatConstraintLayout r41 = r40.d;
        if (r41 == null) goto L93;
        r41.setDisableTopPadding(true);
        r41.R5();
    L93:
        s1a.a.g(this).c(new b(this), m.class);
        LarusPageCotDetailBinding r42 = this.e;
        if (r42 == null) goto L98;
        ViewStub r43 = r42.f;
        if (r43 == null) goto L98;
        ILegacyChatUiServiceDelegate.b.x8(r43, 2131367988);
    L98:
        LarusPageCotDetailBinding r44 = this.e;
        if (r44 == null) goto L103;
        FrameLayout r45 = r44.o;
        if (r45 == null) goto L103;
        r45.setTag(2131377847, this);
        return r45;
    L103:
        return null;
    L105:
        r2 = 2131389273;
        goto L127
    L108:
        r2 = 2131388843;
        goto L127
    L111:
        r2 = 2131387057;
        goto L127
    L114:
        r2 = 2131382457;
        goto L127
    L116:
        r2 = 2131381809;
        goto L127
    L117:
        r2 = 2131381803;
        goto L127
    L118:
        r2 = 2131381799;
        goto L127
    L119:
        r2 = 2131381793;
        goto L127
    L120:
        r2 = 2131377386;
        goto L127
    L123:
        r2 = 2131375364;
        goto L127
    L124:
        r2 = 2131375324;
        goto L127
    L125:
        r2 = 2131367988;
    L127:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
