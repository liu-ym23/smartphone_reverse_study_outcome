package com.larus.bmhome.chat.deepsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import ce8.o;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepsearch.component.p;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusPageDeepSearchBinding;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0013\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/bmhome/chat/deepsearch/DeepSearchFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchFragmentAbility;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageDeepSearchBinding;", "pageCreateTimeStamp", "", "totalTime", "deepSearchParam", "Lcom/larus/bmhome/chat/deepsearch/DeepSearchParam;", "titleAbility", "Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchTitleAbility;", "getTitleAbility", "()Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchTitleAbility;", "titleAbility$delegate", "Lkotlin/Lazy;", "backgroundListener", "com/larus/bmhome/chat/deepsearch/DeepSearchFragment$backgroundListener$1", "Lcom/larus/bmhome/chat/deepsearch/DeepSearchFragment$backgroundListener$1;", "autoLogEnterPage", "", "getCurrentPageName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "utilAbility", "Lcom/larus/bmhome/chat/component/util/UtilAbility;", "bindToVContext", "attachComponent", "onDestroy", "registerBackgroundListener", "enable", "setupTitleBarAction", "logEnterPage", "logLeavePage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepSearchFragment extends TraceFragment implements p {
    public static final /* synthetic */ int l = 0;
    public LarusPageDeepSearchBinding e;
    public long f;
    public long g;
    public final DeepSearchParam h;
    public final Lazy i;
    public final a j;
    public final o k;

    public static final class a implements f09.a.b {
        public final /* synthetic */ DeepSearchFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            DeepSearchFragment r0 = this.a;
            long r1 = r0.g;
            long r3 = System.currentTimeMillis();
            DeepSearchFragment r5 = this.a;
            r0.g = r1 + (r3 - r5.f);
            r5.f = System.currentTimeMillis();
        }

        public final void onAppForeground() {
            DeepSearchFragment r0 = this.a;
            r0.f = System.currentTimeMillis();
        }

        public a(DeepSearchFragment r1) {
            this.a = r1;
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "deep_search_page";
    }

    public final void T90() {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "deep_search_page");
        r1.put("previous_page", "chat");
        r1.put("conversation_id", this.h.c);
        r1.put("bot_id", this.h.d);
        r1.put("enter_method", this.h.e);
        r1.put("message_id", this.h.b);
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r1);
    }

    public DeepSearchFragment() {
        this.h = new DeepSearchParam(0);
        this.i = LazyKt.lazy(new com.larus.bmhome.chat.deepsearch.a(this));
        this.j = new a(this);
        this.k = new o();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "deep_search_page");
        r1.put("previous_page", "chat");
        r1.put("conversation_id", this.h.c);
        r1.put("bot_id", this.h.d);
        r1.put("enter_method", this.h.e);
        r1.put("message_id", this.h.b);
        AppHost.Companion r2 = AppHost.a;
        if (r2.a().isAppBackground() == false) goto L5;
        long r3 = this.g;
    L6:
        r1.put("page_stay_duration", r3);
        Unit r4 = Unit.INSTANCE;
        r0.reportEvent("leave_page", r1);
        r2.a().c(this.j);
        o r5 = this.k;
        r5.a.shutdown();
        r5.b.close();
        return;
    L5:
        r3 = (System.currentTimeMillis() - this.f) + this.g;
        goto L6
    }

    @Override // com.larus.bmhome.chat.deepsearch.component.p
    public final LarusPageDeepSearchBinding e() {
        return this.e;
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.f = System.currentTimeMillis();
        DeepSearchParam r9 = this.h;
        Bundle r0 = getArguments();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getString("deep_search_message_id", "");
        if (r2 == null) goto L6;
    L7:
        r9.a = r2;
        Bundle r3 = getArguments();
        if (r3 == null) goto L11;
        String r4 = r3.getString("deep_search_from_id", "");
        if (r4 == null) goto L11;
    L12:
        r9.b = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L16;
        String r6 = r5.getString("argConversationId", "");
        if (r6 == null) goto L16;
    L17:
        r9.c = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L21;
        String r10 = r7.getString("bot_id", "");
        if (r10 == null) goto L21;
    L22:
        r9.d = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L28;
        String r12 = r11.getString("enter_from", "");
        if (r12 == null) goto L28;
        r1 = r12;
    L28:
        r9.e = r1;
        Bundle r13 = getArguments();
        if (r13 == null) goto L31;
        Boolean r14 = Boolean.valueOf(r13.getBoolean("is_collection_mode", false));
    L32:
        r9.f = r14;
        Bundle r15 = getArguments();
        Message r16 = null;
        if (r15 == null) goto L35;
        Serializable r17 = r15.getSerializable("collection_message");
    L37:
        if ((r17 instanceof Message) == false) goto L39;
        r16 = (Message) r17;
    L39:
        r9.g = r16;
        s1a.a.g(this).c(this, p.class);
        s1a.a.g(this).n(this.h, DeepSearchParam.class);
        t1a.b r18 = s1a.a.g(this);
        z2 r19 = z2.a;
        r18.n(new e5(r19.enableMdWidgetsMixedArrangement(), r19.enableDataTagOptimize(), r19.enableTypingAsyncOptimize(), r19.enableTrackerOptimize(), r19.getMarkdownTableRenderConfig().c()), e5.class);
        s1a.a.g(this).c(this.k, ce8.d.class);
        k1a.b.a(this, new b(this));
        AppHost.a.a().j(this.j);
        return;
    L35:
        r17 = null;
        goto L37
    L31:
        r14 = Boolean.FALSE;
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

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        LarusPageDeepSearchBinding r4 = this.e;
        if (r4 == null) goto L8;
        r4.d.setOnClickListener(new c(this));
        r4.c.setOnClickListener(new d(this));
        r4.b.setOnClickListener(new e(this));
        if (Intrinsics.areEqual(this.h.f, Boolean.TRUE) == false) goto L9;
        r4.c.setVisibility(8);
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ChatConstraintLayout r11 = r8.inflate(2131563035, r9, false);
        int r12 = 2131368729;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r11, 2131368729);
        if (r2 == null) goto L25;
        r12 = 2131368730;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r11, 2131368730);
        if (r3 == null) goto L25;
        r12 = 2131368731;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r11, 2131368731);
        if (r4 == null) goto L25;
        r12 = 2131368732;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131368732);
        if (r5 == null) goto L25;
        ChatConstraintLayout r13 = r11;
        if (((RelativeLayout) ViewBindings.findChildViewById(r11, 2131368734)) != null) goto L13;
        r12 = 2131368734;
        goto L25
    L13:
        if (((ViewStub) ViewBindings.findChildViewById(r11, 2131379994)) == null) goto L22;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131379995);
        if (r6 == null) goto L21;
        this.e = new LarusPageDeepSearchBinding(r13, r2, r3, r4, r5, r6);
        if (r13 == null) goto L19;
        r13.setTag(2131377847, this);
        return r13;
    L19:
        return null;
    L21:
        r12 = 2131379995;
        goto L25
    L22:
        r12 = 2131379994;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
