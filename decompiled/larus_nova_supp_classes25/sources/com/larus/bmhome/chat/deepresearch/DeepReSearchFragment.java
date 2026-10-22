package com.larus.bmhome.chat.deepresearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import ce8.d;
import ce8.o;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.component.j0;
import com.larus.bmhome.chat.deepresearch.component.k0;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchErrorBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchLoadingBinding;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.io.Serializable;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import ne8.b;
import ne8.c;
import ne8.e;
import ne8.f;
import ne8.g;
import ne8.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\b\u00101\u001a\u00020\u001dH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepReSearchFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchFragmentAbility;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageDeepResearchBinding;", "pageResumeTimeStamp", "", "deepReSearchParam", "Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "titleAbility", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchTitleAbility;", "getTitleAbility", "()Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchTitleAbility;", "titleAbility$delegate", "Lkotlin/Lazy;", "contentAbility", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchContentAbility;", "getContentAbility", "()Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchContentAbility;", "contentAbility$delegate", "autoLogEnterPage", "", "getCurrentPageName", "", "isActivityReused", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "utilAbility", "Lcom/larus/bmhome/chat/component/util/UtilAbility;", "bindToVContext", "attachComponent", "onDestroy", "setupTitleBarAction", "logEnterPage", "onStop", "onResume", "logLeavePage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepReSearchFragment extends TraceFragment implements k0 {
    public static final /* synthetic */ int k = 0;
    public LarusPageDeepResearchBinding e;
    public long f;
    public final DeepReSearchParam g;
    public final Lazy h;
    public final Lazy i;
    public final o j;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(h r2) {
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

    public final boolean S90() {
        return false;
    }

    public final void T90() {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", k());
        DeepReSearchActivity r2 = requireActivity();
        DeepReSearchActivity r4 = null;
        if ((r2 instanceof DeepReSearchActivity) == false) goto L5;
        DeepReSearchActivity r3 = r2;
    L6:
        boolean r5 = false;
        if (r3 == null) goto L9;
        boolean r6 = r3.h;
    L11:
        if (r6 == true) goto L13;
        String r7 = this.g.k;
        if (o0.d(r7) == true) goto L20;
        r7 = null;
    L20:
        if (r7 != null) goto L22;
        r7 = "chat";
    L22:
        r1.put("previous_page", r7);
        r1.put("conversation_id", this.g.c);
        BotModel r8 = this.g.g;
        if (r8 == null) goto L25;
        String r9 = r8.getBotId();
    L26:
        r1.put("bot_id", r9);
        FragmentActivity r10 = requireActivity();
        if ((r10 instanceof DeepReSearchActivity) == false) goto L29;
        r4 = (DeepReSearchActivity) r10;
    L29:
        if (r4 == null) goto L31;
        r5 = r4.h;
    L31:
        if (r5 == false) goto L33;
        String r11 = "banner";
    L34:
        r1.put("enter_method", r11);
        r1.put("message_id", this.g.b);
        r1.put("dr_process_detail", this.g.j);
        r1.put("deep_research_id", this.g.l);
        Unit r12 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r1);
        return;
    L33:
        r11 = this.g.d;
        goto L34
    L25:
        r9 = null;
        goto L26
    L13:
        if (Intrinsics.areEqual(this.g.i, Boolean.TRUE) == false) goto L15;
        r7 = "dr_report_detail";
        goto L22
    L15:
        r7 = "dr_process_detail";
        goto L22
    L9:
        r6 = false;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.k0
    public final String k() {
        if (Intrinsics.areEqual(this.g.i, Boolean.TRUE) == false) goto L5;
        return "dr_process_detail";
    L5:
        return "dr_report_detail";
    }

    public DeepReSearchFragment() {
        this.g = new DeepReSearchParam(0);
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.j = new o();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        o r0 = this.j;
        r0.a.shutdown();
        r0.b.close();
    }

    public final void onResume() {
        super.onResume();
        this.f = System.currentTimeMillis();
        T90();
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", k());
        String r2 = this.g.k;
        String r4 = null;
        if (o0.d(r2) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        r2 = "chat";
    L8:
        r1.put("previous_page", r2);
        r1.put("conversation_id", this.g.c);
        BotModel r3 = this.g.g;
        if (r3 == null) goto L11;
        r4 = r3.getBotId();
    L11:
        r1.put("bot_id", r4);
        r1.put("enter_method", this.g.d);
        r1.put("message_id", this.g.b);
        r1.put("deep_research_id", this.g.l);
        r1.put("stay_duration", System.currentTimeMillis() - this.f);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("leave_deep_research_page", r1);
        IChatRepoService r6 = zh8.a.a;
        zh8.a.a.getReceiver().c().i6("DeepSearchFragment onStop", true);
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.k0
    public final LarusPageDeepResearchBinding e() {
        return this.e;
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        DeepReSearchParam r9 = this.g;
        Bundle r0 = getArguments();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getString("deep_research_resource_id", "");
        if (r2 == null) goto L6;
    L7:
        r9.a = r2;
        Bundle r3 = getArguments();
        if (r3 == null) goto L11;
        String r4 = r3.getString("deep_research_mob_research_id", "");
        if (r4 == null) goto L11;
    L12:
        r9.l = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L16;
        String r6 = r5.getString("deep_research_message_id", "");
        if (r6 == null) goto L16;
    L17:
        r9.b = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L21;
        String r10 = r7.getString("deep_research_conversation_id", "");
        if (r10 == null) goto L21;
    L22:
        r9.c = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L25;
        Boolean r12 = Boolean.valueOf(r11.getBoolean("is_collection_mode", false));
    L26:
        r9.e = r12;
        Bundle r13 = getArguments();
        Message r14 = null;
        if (r13 == null) goto L29;
        Serializable r15 = r13.getSerializable("deep_research_bot_model");
    L31:
        if ((r15 instanceof BotModel) == false) goto L33;
        BotModel r16 = (BotModel) r15;
    L34:
        r9.g = r16;
        Bundle r17 = getArguments();
        if (r17 == null) goto L37;
        Serializable r18 = r17.getSerializable("deep_research_message");
    L39:
        if ((r18 instanceof Message) == false) goto L41;
        r14 = (Message) r18;
    L41:
        r9.f = r14;
        Bundle r19 = getArguments();
        long r20 = 0;
        if (r19 == null) goto L44;
        r20 = r19.getLong("deep_research_unique_chat_key", 0);
    L44:
        r9.h = Long.valueOf(r20);
        Bundle r21 = getArguments();
        if (r21 == null) goto L47;
        Boolean r22 = Boolean.valueOf(r21.getBoolean("deep_research_is_process_resource", false));
    L48:
        r9.i = r22;
        Bundle r23 = getArguments();
        if (r23 == null) goto L52;
        String r24 = r23.getString("deep_research_process_detail", "");
        if (r24 == null) goto L52;
    L53:
        r9.j = r24;
        Bundle r25 = getArguments();
        if (r25 == null) goto L57;
        String r26 = r25.getString("deep_research_enter_method", "");
        if (r26 == null) goto L57;
    L58:
        r9.d = r26;
        Bundle r27 = getArguments();
        if (r27 == null) goto L64;
        String r28 = r27.getString("deep_research_previous_page", "");
        if (r28 == null) goto L64;
        r1 = r28;
    L64:
        r9.k = r1;
        s1a.a.g(this).c(this, k0.class);
        s1a.a.g(this).n(this.g, DeepReSearchParam.class);
        t1a.b r29 = s1a.a.g(this);
        z2 r30 = z2.a;
        r29.n(new e5(r30.enableMdWidgetsMixedArrangement(), r30.enableDataTagOptimize(), r30.enableTypingAsyncOptimize(), r30.enableTrackerOptimize(), r30.getMarkdownTableRenderConfig().c()), e5.class);
        s1a.a.g(this).c(this.j, d.class);
        k1a.b.a(this, new ne8.a(this));
        return;
    L57:
        r26 = "";
    L52:
        r24 = "";
        goto L53
    L47:
        r22 = Boolean.FALSE;
        goto L48
    L37:
        r18 = null;
        goto L39
    L33:
        r16 = null;
        goto L34
    L29:
        r15 = null;
        goto L31
    L25:
        r12 = Boolean.FALSE;
    L21:
        r10 = "";
    L16:
        r6 = "";
    L11:
        r4 = "";
    L6:
        r2 = "";
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ne8.h] */
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        LarusPageDeepResearchBinding r5 = this.e;
        if (r5 == null) goto L37;
        e1.d(r5.e, new ne8.d(this));
        e1.d(r5.h, new e(this));
        e1.d(r5.f, new f(this));
        e1.d(r5.d, new g(this));
        if (Intrinsics.areEqual(this.g.i, Boolean.TRUE) == false) goto L21;
        LarusPageDeepResearchBinding r6 = this.e;
        if (r6 == null) goto L11;
        AppCompatImageView r7 = r6.e;
        if (r7 == null) goto L11;
        r7.setVisibility(8);
    L11:
        LarusPageDeepResearchBinding r8 = this.e;
        if (r8 == null) goto L16;
        AppCompatImageView r9 = r8.f;
        if (r9 == null) goto L16;
        r9.setVisibility(8);
    L16:
        j0 r10 = (j0) this.i.getValue();
        if (r10 == null) goto L38;
        MutableLiveData r11 = r10.ow();
        if (r11 == null) goto L39;
        r11.observe(getViewLifecycleOwner(), new a(new h(this)));
        return;
    L39:
        return;
    L38:
        return;
    L21:
        LarusPageDeepResearchBinding r12 = this.e;
        if (r12 == null) goto L26;
        AppCompatImageView r13 = r12.e;
        if (r13 == null) goto L26;
        r13.setVisibility(0);
    L26:
        LarusPageDeepResearchBinding r14 = this.e;
        if (r14 == null) goto L31;
        AppCompatImageView r15 = r14.f;
        if (r15 == null) goto L31;
        r15.setVisibility(8);
    L31:
        LarusPageDeepResearchBinding r16 = this.e;
        if (r16 == null) goto L41;
        AppCompatImageView r17 = r16.h;
        if (r17 == null) goto L42;
        r17.setVisibility(0);
        return;
    L42:
        return;
    L41:
        return;
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        ChatConstraintLayout r1 = r18.inflate(2131563032, r19, false);
        int r2 = 2131368707;
        View r3 = ViewBindings.findChildViewById(r1, 2131368707);
        if (r3 == null) goto L35;
        LarusPageDeepResearchErrorBinding r6 = LarusPageDeepResearchErrorBinding.a(r3);
        r2 = 2131368714;
        View r4 = ViewBindings.findChildViewById(r1, 2131368714);
        if (r4 == null) goto L35;
        LarusPageDeepResearchLoadingBinding r7 = LarusPageDeepResearchLoadingBinding.a(r4);
        r2 = 2131368715;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r1, 2131368715);
        if (r8 == null) goto L35;
        r2 = 2131368716;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r1, 2131368716);
        if (r9 == null) goto L35;
        r2 = 2131368717;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r1, 2131368717);
        if (r10 == null) goto L35;
        r2 = 2131368718;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r1, 2131368718);
        if (r11 == null) goto L35;
        r2 = 2131368719;
        AppCompatImageView r12 = ViewBindings.findChildViewById(r1, 2131368719);
        if (r12 == null) goto L35;
        r2 = 2131368720;
        AppCompatImageView r13 = ViewBindings.findChildViewById(r1, 2131368720);
        if (r13 == null) goto L35;
        r2 = 2131368721;
        ProgressBar r14 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131368721);
        if (r14 == null) goto L35;
        ChatConstraintLayout r5 = r1;
        r2 = 2131368725;
        if (((RelativeLayout) ViewBindings.findChildViewById(r1, 2131368725)) == null) goto L35;
        r2 = 2131384402;
        ViewStub r15 = (ViewStub) ViewBindings.findChildViewById(r1, 2131384402);
        if (r15 == null) goto L35;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131384403);
        if (r16 == null) goto L33;
        this.e = new LarusPageDeepResearchBinding(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        ILegacyChatUiServiceDelegate.b.x8(r15, 2131384402);
        LarusPageDeepResearchBinding r17 = this.e;
        if (r17 == null) goto L31;
        ChatConstraintLayout r21 = r17.a;
        if (r21 == null) goto L31;
        r21.setTag(2131377847, this);
        return r21;
    L31:
        return null;
    L33:
        r2 = 2131384403;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
