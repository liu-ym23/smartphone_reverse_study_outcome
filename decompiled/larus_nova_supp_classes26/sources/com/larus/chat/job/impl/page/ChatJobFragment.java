package com.larus.chat.job.impl.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.chat.job.impl.databinding.LarusChatJobMainFragmentBinding;
import com.larus.im.bean.job.AIJob;
import com.larus.platform.api.d1;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u001a\u001d\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020.H\u0016J\u0018\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0010H\u0016J\b\u00107\u001a\u00020\u000eH\u0002J\u001a\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@H\u0002J(\u0010A\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0010H\u0002JB\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00102\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010B\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010J\u001a\u00020\u000eH\u0002J\u0010\u0010K\u001a\u00020.2\u0006\u0010B\u001a\u00020@H\u0002J\f\u0010L\u001a\u00020@*\u00020@H\u0002J\n\u0010M\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010N\u001a\u00020,2\u0006\u0010I\u001a\u00020\u00102\n\b\u0002\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0016\u0010Q\u001a\u00020.*\u00020,2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\b\u0010R\u001a\u00020\u0010H\u0002J\n\u0010S\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010T\u001a\u0004\u0018\u00010DH\u0082@¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020.H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006X"}, d2 = {"Lcom/larus/chat/job/impl/page/ChatJobFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/IPageInputFillAbility;", "<init>", "()V", "binding", "Lcom/larus/chat/job/impl/databinding/LarusChatJobMainFragmentBinding;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "cameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "voiceInputTakeOverConfigured", "", "lastAutoRoutedVoiceInputKey", "", "inputStatusBeforeVoiceInput", "", "Ljava/lang/Integer;", "pageConfigs", "", "Lcom/larus/chat/job/impl/page/config/IChatJobPageConfig;", "pendingCronTemplateId", "currentInputContent", "inputTextChangedListener", "com/larus/chat/job/impl/page/ChatJobFragment$inputTextChangedListener$1", "Lcom/larus/chat/job/impl/page/ChatJobFragment$inputTextChangedListener$1;", "speakerStateListener", "com/larus/chat/job/impl/page/ChatJobFragment$speakerStateListener$1", "Lcom/larus/chat/job/impl/page/ChatJobFragment$speakerStateListener$1;", "listViewModel", "Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "getListViewModel", "()Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "listViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onHiddenChanged", "hidden", "onDestroyView", "fillInput", MusicAppletPage.KEY_SOURCE, "contentId", "onActionSendClicked", "onVoiceInputSuccess", ShareType.TEXT, "asrLogId", "onCameraSuccess", "outputContext", "Lcom/larus/camera/api/params/CameraOutputContext;", "onSendIntercepted", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "routeWithResolvedBotIdAsync", "sendParams", "sourceConversation", "Lcom/larus/im/bean/conversation/Conversation;", "pendingCameraResultKey", "routeToSubConversation", "context", "Landroid/content/Context;", "botId", "shouldDowngrade", "resetInputAfterAcceptedSend", "withChatJobMessageExt", "resolveBotId", "buildRouteExtraParams", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "appendSelectedProjectRouteParam", "trackingRunEnvironment", "createSourceConversation", "fetchMainConversation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyPageVisible", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobFragment extends Fragment implements d1 {
    public static final /* synthetic */ int q = 0;
    public LarusChatJobMainFragmentBinding d;
    public ICoreInputAbility e;
    public zb8.e f;
    public com.larus.bmhome.chat.component.bottom.core.speaker.l g;
    public boolean h;
    public String i;
    public Integer j;
    public final List<cz8.j> k;
    public String l;
    public String m;
    public final b n;
    public final d o;
    public final Lazy p;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.e {
        public final /* synthetic */ ChatJobFragment a;

        public b(ChatJobFragment r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r4) {
            Intrinsics.checkNotNullParameter(r4, "content");
            this.a.m = r4;
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("input text changed, contentLength=");
            r1.append(r4.length());
            r1.append(", hasPendingTemplate=");
            if (this.a.l == null) goto L5;
            boolean r5 = true;
        L6:
            r1.append(r5);
            r1.append(", lastStatus=");
            ICoreInputAbility r6 = this.a.e;
            if (r6 == null) goto L9;
            Integer r7 = Integer.valueOf(r6.Rp());
        L10:
            r1.append(r7);
            r0.i("ChatJobFragment", r1.toString());
            return;
        L9:
            r7 = null;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    public /* synthetic */ class c implements zb8.f, FunctionAdapter {
        public final /* synthetic */ ChatJobFragment a;

        public c(ChatJobFragment r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof zb8.f) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.a, ChatJobFragment.class, "onCameraSuccess", "onCameraSuccess(Lcom/larus/camera/api/params/CameraOutputContext;)Z", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final boolean a(CameraOutputContext r17) {
            Intrinsics.checkNotNullParameter(r17, "p0");
            ChatJobFragment r4 = this.a;
            int r2 = ChatJobFragment.q;
            r4.getClass();
            ConcurrentHashMap r3 = com.larus.bmhome.chat.camera.command.k.a;
            zb8.e r5 = r4.f;
            if (r5 == null) goto L5;
            SuggestedAction r6 = r5.Pc();
        L6:
            String r0 = com.larus.bmhome.chat.camera.command.k.a(r17, r6);
            wc9.e r7 = r4.S90();
            String r8 = r4.T90();
            FLogger r9 = FLogger.a;
            StringBuilder r10 = new StringBuilder("camera success intercepted, pendingResultKey=");
            r10.append(r0);
            r10.append(", botIdEmpty=");
            boolean r11 = false;
            if (r8 != null) goto L9;
        L12:
            boolean r12 = true;
        L13:
            r10.append(r12);
            r10.append(", sourceConversationId=");
            if (r7 == null) goto L16;
            String r13 = r7.a;
        L17:
            r10.append(r13);
            r9.i("ChatJobFragment", r10.toString());
            Context r14 = r4.getContext();
            if (r14 != null) goto L20;
            r9.e("ChatJobFragment", "camera success route skipped, context is null");
            com.larus.bmhome.chat.camera.command.k.b(r0);
        L29:
            return true;
        L20:
            if (r8 != null) goto L22;
        L23:
            r11 = true;
        L24:
            if (r11 == true) goto L28;
            if (r7 == null) goto L28;
            r4.U90(r14, r8, r7, null, r0, com.larus.platform.exp.o.a());
        L28:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.getViewLifecycleOwner()), null, null, new ChatJobFragment$routeWithResolvedBotIdAsync$1(r7, r4, r0, null, null), 3, null);
            goto L29
        L22:
            if (StringsKt.isBlank(r8) == false) goto L24;
        L16:
            r13 = null;
            goto L17
        L9:
            if (StringsKt.isBlank(r8) == true) goto L12;
            r12 = false;
            goto L13
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class d implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ ChatJobFragment a;

        public d(ChatJobFragment r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r11) {
            Intrinsics.checkNotNullParameter(r11, "state");
            Map r1 = null;
            Integer r2 = null;
            r1 = null;
            if (Intrinsics.areEqual(r11, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L9;
            ChatJobFragment r12 = this.a;
            r12.i = null;
            ICoreInputAbility r0 = r12.e;
            if (r0 == null) goto L7;
            r2 = Integer.valueOf(r0.Rp());
        L7:
            r12.j = r2;
            return;
        L9:
            if (Intrinsics.areEqual(r11, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a) == false) goto L11;
        L52:
            ChatJobFragment r13 = this.a;
            r13.i = null;
            r13.j = null;
            return;
        L11:
            if (Intrinsics.areEqual(r11, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == true) goto L52;
            if ((r11 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L48;
            com.larus.bmhome.chat.component.bottom.core.speaker.g.e r14 = (com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r11;
            if (r14.c == false) goto L18;
            ChatJobFragment r15 = this.a;
            r15.i = null;
            r15.j = null;
            return;
        L18:
            ChatJobFragment r3 = this.a;
            String r4 = r14.a;
            String r16 = r14.b;
            int r5 = ChatJobFragment.q;
            r3.getClass();
            String r6 = StringsKt.trim(r4).toString();
            boolean r7 = false;
            if (r6.length() != 0) goto L21;
            boolean r8 = true;
        L23:
            if (r8 == false) goto L25;
            FLogger.a.i("ChatJobFragment", "voice input success but content is blank, skip route");
            return;
        L25:
            StringBuilder r9 = new StringBuilder();
            if (r16 != null) goto L28;
            String r10 = "";
        L29:
            r9.append(r10);
            r9.append('#');
            r9.append(r6);
            String r17 = r9.toString();
            if (Intrinsics.areEqual(r3.i, r17) == false) goto L32;
            FLogger.a.i("ChatJobFragment", "voice input success already routed, skip duplicate");
            return;
        L32:
            r3.i = r17;
            r3.m = r6;
            FLogger r18 = FLogger.a;
            StringBuilder r19 = new StringBuilder("voice input success, auto route to sub conversation, contentLength=");
            r19.append(r6.length());
            r19.append(", hasAsrLogId=");
            if (r16 == null) goto L35;
            r7 = true;
        L35:
            r19.append(r7);
            r18.i("ChatJobFragment", r19.toString());
            ICoreInputAbility r20 = r3.e;
            if (r20 != null) goto L39;
            r18.e("ChatJobFragment", "voice input route skipped, coreInputAbility is null");
            return;
        L39:
            if (r16 != null) goto L41;
        L46:
            ICoreInputAbility.b.c(r20, r6, true, null, "cron_job", r1, 4);
            return;
        L41:
            if ((!StringsKt.isBlank(r16)) == true) goto L44;
            r16 = null;
        L44:
            if (r16 == null) goto L46;
            r1 = MapsKt.mapOf(TuplesKt.to("asr_log_id", r16));
            goto L46
        L28:
            r10 = r16;
            goto L29
        L21:
            r8 = false;
            goto L23
        L48:
            if ((r11 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == false) goto L51;
            return;
        L51:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final void onDestroyView() {
        FLogger.a.i("ChatJobFragment", "onDestroyView, unregister input callbacks");
        s1a.a.g(this).l(Reflection.getOrCreateKotlinClass(d1.class));
        this.l = null;
        this.m = "";
        this.i = null;
        this.j = null;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = this.g;
        if (r1 == null) goto L5;
        r1.B9(this.o);
    L5:
        this.g = null;
        zb8.e r2 = this.f;
        if (r2 == null) goto L8;
        r2.MI();
    L8:
        this.f = null;
        ICoreInputAbility r3 = this.e;
        if (r3 == null) goto L11;
        r3.Vs(this.n);
    L11:
        ICoreInputAbility r4 = this.e;
        if (r4 == null) goto L14;
        r4.iN(new f());
    L14:
        ICoreInputAbility r5 = this.e;
        if (r5 == null) goto L18;
        r5.tr(new g());
    L18:
        if (this.h == false) goto L25;
        ICoreInputAbility r6 = this.e;
        if (r6 == null) goto L24;
        CoreInputAbility r7 = r6.JO();
        if (r7 == null) goto L24;
        r7.j9();
    L24:
        this.h = false;
    L25:
        this.d = null;
        this.e = null;
        Iterator<T> r0 = this.k.iterator();
    L27:
        if (r0.hasNext() == false) goto L29;
        ((cz8.j) r0.next()).onDestroyView();
        goto L27
    L29:
        super.onDestroyView();
    }

    public ChatJobFragment() {
        this.k = CollectionsKt.listOf(new cz8.j[]{new cz8.e(), new cz8.c(), new cz8.d(), new cz8.i()});
        this.m = "";
        this.n = new b(this);
        this.o = new d(this);
        this.p = LazyKt.lazy(LazyThreadSafetyMode.NONE, new h(this));
    }

    public final wc9.e S90() {
        Bundle r0 = getArguments();
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r3 = r0.getString("chat_job_source_conversation_id");
    L6:
        if (r3 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return null;
    L14:
        Bundle r4 = getArguments();
        if (r4 == null) goto L23;
        if (r4.containsKey("chat_job_source_input_left_action_style") == true) goto L20;
        r4 = null;
    L20:
        if (r4 == null) goto L23;
        r1 = Integer.valueOf(r4.getInt("chat_job_source_input_left_action_style"));
    L23:
        return new wc9.e(r3, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, r1, null, null, 0, 0, null, null, 0, -268435458, 63);
    L8:
        if (StringsKt.isBlank(r3) == true) goto L11;
        r2 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final String T90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        String r1 = r0.getString("argBotId");
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L9;
        return null;
    L9:
        return r1;
    L10:
        return null;
    }

    public final void onResume() {
        super.onResume();
        ez8.a r0 = ez8.a.a;
        Bundle r1 = getArguments();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getString("argPreviousPage");
    L6:
        Bundle r4 = getArguments();
        if (r4 == null) goto L9;
        r2 = r4.getString("enter_method");
    L9:
        boolean r5 = !com.larus.bmhome.b0.b(this);
        r0.getClass();
        ez8.a.a(r3, r2, r5);
        View r6 = getView();
        if (r6 == null) goto L13;
        r6.post(new com.larus.chat.job.impl.page.a(this));
        return;
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean Se(String r14) {
        Intrinsics.checkNotNullParameter("scheduled_job_template", MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r14, "contentId");
        if (Intrinsics.areEqual("scheduled_job_template", "scheduled_job_template") == true) goto L6;
        FLogger.a.e("ChatJobFragment", "fillInput failed, unsupported source=scheduled_job_template");
        return false;
    L6:
        FLogger r0 = FLogger.a;
        r0.i("ChatJobFragment", "fillInput invoked, rawTemplateIdLength=" + r14.length());
        String r15 = StringsKt.trim(r14).toString();
        if (r15.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        String r5 = null;
        if (r3 == true) goto L14;
        r15 = null;
    L14:
        if (r15 != null) goto L17;
        r0.e("ChatJobFragment", "fillInput failed, normalized template id is empty");
        return false;
    L17:
        ICoreInputAbility r4 = this.e;
        if (r4 != null) goto L21;
        r0.e("ChatJobFragment", "fillInput failed, coreInputAbility is null");
        return false;
    L21:
        ez8.a r6 = ez8.a.a;
        List<i> r7 = ((y) ((ChatJobListViewModel) this.p.getValue()).getUiState().getValue()).a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r15, "templateId");
        Intrinsics.checkNotNullParameter(r7, "items");
        String r8 = StringsKt.trim(r15).toString();
        if (r8.length() <= 0) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L27;
        r5 = r8;
    L27:
        if (r5 == null) goto L33;
        Pair r10 = ez8.a.b(r7, r5);
        if (r10 != null) goto L32;
        r0.w("ChatJobTracker", "recommend click skipped, templateIdLength=" + r5.length() + " not found");
        goto L33
    L32:
        ez8.a.f("recommend_cron_job_click", ez8.a.d((AIJob) r10.component1(), r5, ((Number) r10.component2()).intValue()));
    L33:
        String r11 = ((ChatJobListViewModel) this.p.getValue()).resolveRecommendPrompt(r15);
        if (r11 != null) goto L37;
        r0.e("ChatJobFragment", "fillInput failed, prompt not found for templateId=".concat(r15));
        return false;
    L37:
        r0.i("ChatJobFragment", "fillInput resolved, templateId=" + r15 + ", promptLength=" + r11.length() + ", lastStatusBeforeSetText=" + r4.Rp());
        r4.mv("ChatJobFragment#fillInput", true);
        this.l = r15;
        this.m = r11;
        ICoreInputAbility.b.d(r4, r11, false, false, Integer.valueOf(r11.length()), Integer.valueOf(r11.length()), false, 32);
        r4.g2(3, true);
        r0.i("ChatJobFragment", "fillInput finished, lastStatusAfterSwitch=" + r4.Rp());
        return true;
    L24:
        r9 = false;
        goto L25
    L9:
        r3 = false;
        goto L10
    }

    public final void onHiddenChanged(boolean r4) {
        super.onHiddenChanged(r4);
        zb8.e r0 = this.f;
        if (r0 == null) goto L5;
        r0.kL(!r4);
    L5:
        if (r4 == true) goto L17;
        ez8.a r5 = ez8.a.a;
        Bundle r1 = getArguments();
        String r2 = null;
        if (r1 == null) goto L9;
        String r3 = r1.getString("argPreviousPage");
    L10:
        Bundle r6 = getArguments();
        if (r6 == null) goto L13;
        r2 = r6.getString("enter_method");
    L13:
        boolean r7 = !com.larus.bmhome.b0.b(this);
        r5.getClass();
        ez8.a.a(r3, r2, r7);
        View r8 = getView();
        if (r8 == null) goto L18;
        r8.post(new com.larus.chat.job.impl.page.a(this));
        return;
    L18:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        Iterator<T> r8 = this.k.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((cz8.j) r8.next()).a(this, r6);
        goto L4
    L6:
        ChatJobListViewModel r9 = (ChatJobListViewModel) this.p.getValue();
        this.e = s1a.a.g(this).getAbility(ICoreInputAbility.class);
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("onViewCreated, coreInputAbilityFound=");
        boolean r1 = false;
        if (this.e == null) goto L9;
        boolean r0 = true;
    L10:
        r11.append(r0);
        r11.append(", botIdEmpty=");
        Bundle r2 = getArguments();
        String r3 = null;
        if (r2 == null) goto L13;
        String r4 = r2.getString("argBotId");
    L14:
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        r11.append(r5);
        r11.append(", sourceConversationIdEmpty=");
        Bundle r12 = getArguments();
        if (r12 == null) goto L23;
        String r13 = r12.getString("chat_job_source_conversation_id");
    L24:
        if (r13 != null) goto L26;
    L27:
        r1 = true;
    L28:
        r11.append(r1);
        r11.append(", enterMethod=");
        Bundle r14 = getArguments();
        if (r14 == null) goto L31;
        r3 = r14.getString("enter_method");
    L31:
        r11.append(r3);
        r10.i("ChatJobFragment", r11.toString());
        ICoreInputAbility r15 = this.e;
        if (r15 == null) goto L34;
        r15.QG(this.n);
        r15.JO().z9(true);
        r15.JO().R8();
        this.h = true;
        r15.iN(new com.larus.chat.job.impl.page.b(this));
        r15.tr(new com.larus.chat.job.impl.page.c(this));
    L35:
        zb8.e r16 = s1a.a.g(this).getAbility(zb8.e.class);
        this.f = r16;
        if (r16 == null) goto L38;
        r16.mQ(new c(this), new com.larus.chat.job.impl.page.d(), new e());
    L39:
        zb8.e r17 = this.f;
        if (r17 == null) goto L42;
        r17.kL(!isHidden());
    L42:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r18 = s1a.a.g(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        this.g = r18;
        if (r18 == null) goto L45;
        r18.e8(this.o);
    L46:
        s1a.a.g(this).k(this, Reflection.getOrCreateKotlinClass(d1.class));
        return;
    L45:
        r10.e("ChatJobFragment", "IChatBottomSpeakerAbility not found");
        goto L46
    L38:
        r10.e("ChatJobFragment", "IChatCameraAbility not found");
        goto L39
    L34:
        r10.e("ChatJobFragment", "ICoreInputAbility not found");
        goto L35
    L26:
        if (StringsKt.isBlank(r13) == false) goto L28;
    L23:
        r13 = null;
        goto L24
    L16:
        if (StringsKt.isBlank(r4) == true) goto L19;
        r5 = false;
        goto L20
    L13:
        r4 = null;
        goto L14
    L9:
        r0 = false;
        goto L10
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ChatConstraintLayout r1 = r13.inflate(2131561891, r14, false);
        int r2 = 2131364464;
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131364464)) == null) goto L76;
        r2 = 2131364480;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131364480);
        if (r6 == null) goto L76;
        r2 = 2131364488;
        if (ViewBindings.findChildViewById(r1, 2131364488) == null) goto L76;
        r2 = 2131365129;
        View r7 = ViewBindings.findChildViewById(r1, 2131365129);
        if (r7 == null) goto L76;
        r2 = 2131365254;
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131365254)) == null) goto L76;
        ChatConstraintLayout r3 = r1;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131367905)) != null) goto L15;
        r2 = 2131367905;
        goto L76
    L15:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131367908)) == null) goto L73;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131375324);
        if (r8 != null) goto L19;
        r2 = 2131375324;
        goto L76
    L19:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131375364)) != null) goto L21;
        r2 = 2131375364;
        goto L76
    L21:
        if (ViewBindings.findChildViewById(r1, 2131375385) != null) goto L23;
        r2 = 2131375385;
        goto L76
    L23:
        if (ViewBindings.findChildViewById(r1, 2131375556) == null) goto L69;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131377227);
        if (r9 == null) goto L68;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131377229);
        if (r10 != null) goto L29;
        r2 = 2131377229;
        goto L76
    L29:
        if (ViewBindings.findChildViewById(r1, 2131377386) != null) goto L31;
        r2 = 2131377386;
        goto L76
    L31:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131382457)) != null) goto L33;
        r2 = 2131382457;
        goto L76
    L33:
        if (((Space) ViewBindings.findChildViewById(r1, 2131387040)) != null) goto L35;
        r2 = 2131387040;
        goto L76
    L35:
        if (((Space) ViewBindings.findChildViewById(r1, 2131387041)) != null) goto L37;
        r2 = 2131387041;
        goto L76
    L37:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131387057)) == null) goto L62;
        View r11 = ViewBindings.findChildViewById(r1, 2131387119);
        if (r11 != null) goto L41;
        r2 = 2131387119;
        goto L76
    L41:
        if (((ViewStub) ViewBindings.findChildViewById(r1, 2131387487)) != null) goto L43;
        r2 = 2131387487;
        goto L76
    L43:
        if (ViewBindings.findChildViewById(r1, 2131389133) != null) goto L45;
        r2 = 2131389133;
        goto L76
    L45:
        if (ViewBindings.findChildViewById(r1, 2131389273) == null) goto L58;
        this.d = new LarusChatJobMainFragmentBinding(r3, r6, r7, r8, r9, r10, r11);
        if (r3 == null) goto L51;
        ViewStub r4 = (ViewStub) r3.findViewById(2131375364);
        if (r4 == null) goto L51;
        InputViewCreatorDelegate.b.a(r4, 2131375364);
    L51:
        LarusChatJobMainFragmentBinding r5 = this.d;
        if (r5 == null) goto L57;
        ChatConstraintLayout r12 = r5.a;
        if (r12 == null) goto L57;
        return r12;
    L57:
        return r13.inflate(2131561891, r14, false);
    L58:
        r2 = 2131389273;
        goto L76
    L62:
        r2 = 2131387057;
        goto L76
    L68:
        r2 = 2131377227;
        goto L76
    L69:
        r2 = 2131375556;
        goto L76
    L73:
        r2 = 2131367908;
    L76:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public final void U90(Context r17, String r18, wc9.e r19, ICoreInputAbility.OnSendParams r20, String r21, boolean r22) {
        FLogger r12 = FLogger.a;
        StringBuilder r2 = new StringBuilder("gotoSubConversation start, botId=");
        r2.append(r18);
        r2.append(", sourceConversationId=");
        if (r19 == null) goto L5;
        String r5 = r19.a;
    L6:
        r2.append(r5);
        r2.append(", autoSendContentLength=");
        if (r20 == null) goto L11;
        String r6 = r20.getContent();
        if (r6 == null) goto L11;
        int r7 = r6.length();
    L12:
        r2.append(r7);
        r2.append(", hasPendingCameraResult=");
        if (r21 == null) goto L15;
        boolean r8 = true;
    L16:
        r2.append(r8);
        r12.i("ChatJobFragment", r2.toString());
        String r3 = "cloud";
        if (r20 == null) goto L47;
        String r9 = this.l;
        if (r9 == null) goto L47;
        ez8.a r10 = ez8.a.a;
        List<i> r11 = ((y) ((ChatJobListViewModel) this.p.getValue()).getUiState().getValue()).a;
        bz8.k r13 = s1a.a.g(this).getAbility(bz8.k.class);
        if (r13 == null) goto L25;
        String r14 = r13.kX();
        if (r14 == null) goto L25;
    L26:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r9, "templateId");
        Intrinsics.checkNotNullParameter(r11, "items");
        Intrinsics.checkNotNullParameter(r14, "runEnvironment");
        String r15 = StringsKt.trim(r9).toString();
        if (r15.length() <= 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == true) goto L33;
        r15 = null;
    L33:
        if (r15 == null) goto L47;
        Pair r23 = ez8.a.b(r11, r15);
        if (r23 == null) goto L38;
        AIJob r24 = (AIJob) r23.getFirst();
    L39:
        JSONObject r25 = new JSONObject().put("create_way", "template").put("scene", "moa").put("template_id", r15).put("run_env", r14);
        if (r24 == null) goto L44;
        String r26 = ez8.a.e(r24);
        if (r26 == null) goto L44;
        r25.put("repeat_type", r26);
    L44:
        Intrinsics.checkNotNull(r25);
        ez8.a.f("create_cron_job", r25);
        if (r24 != null) goto L47;
        r12.w("ChatJobTracker", "create submit missing recommendation metadata, templateIdLength=" + r15.length());
        goto L47
    L38:
        r24 = null;
        goto L39
    L29:
        r16 = false;
    L25:
        r14 = "cloud";
    L47:
        if (r20 == null) goto L49;
        ChatPageContext r27 = r20.chatPageContext;
    L50:
        bz8.k r28 = s1a.a.g(this).getAbility(bz8.k.class);
        if (r28 == null) goto L55;
        String r29 = r28.kX();
        if (r29 == null) goto L55;
        r3 = r29;
    L55:
        Serializable r30 = gz8.i.c(s1a.a.g(this).getAbility(com.larus.bmhome.instruction.g.class));
        Bundle r31 = getArguments();
        if (r31 == null) goto L58;
        Bundle r32 = new Bundle(r31);
    L59:
        r32.putString("argBotId", r18);
        r32.remove("pending_reply_mode");
        if (r30 == null) goto L62;
        r32.putSerializable("pending_reply_mode", r30);
    L62:
        r32.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(TuplesKt.to("run_env", r3))));
        bz8.k r4 = s1a.a.g(this).getAbility(bz8.k.class);
        if (r4 == null) goto L65;
        r4.mH(r32);
    L65:
        if (r27 != null) goto L68;
        r27 = (ChatPageContext) s1a.a.g(this).a(ChatPageContext.class);
    L68:
        if (r27 == null) goto L85;
        Map r33 = r27.getReqExt();
        if (r33 == null) goto L85;
        if (r33.containsKey("select_project_id") == false) goto L85;
        String r34 = (String) r33.get("select_project_id");
        if (r34 != null) goto L78;
    L81:
        boolean r35 = true;
    L82:
        if (r35 == false) goto L84;
        r32.remove("project_id");
        goto L85
    L84:
        r32.putString("project_id", r34);
        goto L85
    L78:
        if (r34.length() == 0) goto L81;
        r35 = false;
    L85:
        if (r21 == null) goto L87;
        r32.putString("KEY_CAMERA_RESULT_PENDING_SESSION_ID", r21);
    L87:
        StringBuilder r1 = new StringBuilder("gotoSubConversation params prepared, hasProjectId=");
        String r36 = r32.getString("project_id");
        if (r36 != null) goto L90;
    L93:
        boolean r37 = true;
    L94:
        r1.append(!r37);
        r12.i("ChatJobFragment", r1.toString());
        IAIChatConversationService.Companion r38 = IAIChatConversationService.a;
        if (r22 == true) goto L110;
        if (r20 == null) goto L105;
        String r39 = r20.getEnterMethod();
        if (r39 == null) goto L105;
        if ((!StringsKt.isBlank(r39)) == true) goto L104;
        r39 = null;
    L104:
        if (r39 == null) goto L105;
    L111:
        if (r20 == null) goto L114;
        String r40 = r20.getPreviousPage();
        if (r40 == null) goto L114;
    L120:
        if (r22 == true) goto L131;
        String r41 = r32.getString("project_id");
        if (r41 != null) goto L124;
    L127:
        boolean r42 = true;
    L128:
        if (r42 == false) goto L131;
        boolean r43 = false;
    L132:
        r38.b(r17, r18, r19, r39, r40, r43, r32, r20, false);
        r12.i("ChatJobFragment", "gotoSubConversation invoked");
        if (r20 == null) goto L156;
        ICoreInputAbility r44 = this.e;
        if (r44 != null) goto L138;
        r12.e("ChatJobFragment", "reset input skipped after accepted send, coreInputAbility is null");
        this.l = null;
        this.m = "";
        return;
    L138:
        if (r20.clearInputContent == true) goto L140;
        r12.i("ChatJobFragment", "reset input skipped after accepted send, clearInputContent=false");
        this.l = null;
        return;
    L140:
        int r45 = r44.Rp();
        if (r20.getTextFromAudio() == false) goto L145;
        Integer r46 = this.j;
        if (r46 == null) goto L145;
        int r47 = r46.intValue();
    L146:
        int r48 = 2;
        if (r47 == 2) goto L150;
        r48 = 1;
    L150:
        StringBuilder r49 = new StringBuilder("reset input after accepted send, contentLength=");
        r49.append(this.m.length());
        r49.append(", hasPendingTemplate=");
        if (this.l == null) goto L153;
        boolean r50 = true;
    L154:
        r49.append(r50);
        r49.append(", lastStatusBeforeReset=");
        r49.append(r45);
        r49.append(", inputStatusBeforeVoiceInput=");
        r49.append(this.j);
        r49.append(", statusAfterReset=");
        r49.append(r48);
        r12.i("ChatJobFragment", r49.toString());
        this.l = null;
        this.m = "";
        this.j = null;
        r44.mv("ChatJobFragment#acceptedSend", true);
        r44.g2(r48, true);
        r12.i("ChatJobFragment", "reset input after accepted send finished, lastStatusAfterReset=" + r44.Rp());
        return;
    L153:
        r50 = false;
    L145:
        r47 = r45;
        goto L146
    L156:
        return;
    L124:
        if (r41.length() == 0) goto L127;
        r42 = false;
    L131:
        r43 = true;
    L114:
        Bundle r51 = getArguments();
        if (r51 == null) goto L117;
        r40 = r51.getString("argPreviousPage");
    L118:
        if (r40 != null) goto L120;
        r40 = "chat_job";
        goto L120
    L117:
        r40 = null;
    L105:
        Bundle r52 = getArguments();
        if (r52 == null) goto L108;
        r39 = r52.getString("enter_method");
    L109:
        if (r39 != null) goto L111;
    L108:
        r39 = null;
    L110:
        r39 = "cron_job";
        goto L111
    L90:
        if (r36.length() == 0) goto L93;
        r37 = false;
        goto L94
    L58:
        r32 = new Bundle();
        goto L59
    L49:
        r27 = null;
        goto L50
    L15:
        r8 = false;
    L11:
        r7 = 0;
        goto L12
    L5:
        r5 = null;
        goto L6
    }
}
