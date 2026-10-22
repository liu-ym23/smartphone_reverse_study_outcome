package com.larus.bmhome.view.actionbar.custom;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.ContinueCallConf;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.chat.tips.GuideTipsDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.instruction.InstructionInputComponent;
import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.instruction.core.model.CustomMenuJumpType;
import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.a4;
import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import com.larus.bmhome.view.actionbar.api.IActionBarFilterProvider;
import com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2;
import com.larus.bmhome.view.actionbar.bot.ActionBarDialogFragment;
import com.larus.bmhome.view.actionbar.custom.actionbarpanel.CustomActionBarPanelAdapterImpl;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.menu.CreateMenuV2;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.commercemembership.api.ICommerceMembershipService$b;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_res.common_ui.databinding.LarusLayoutGradientMaskBinding;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.im.bean.bot.BotModel;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.mainbot.api.miniartifact.MiniArtifactListPageParams;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.b3;
import com.larus.platform.service.d3;
import com.larus.platform.service.i3;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import com.obric.assistant.spi.actionbar.ObricActionBarTrackServiceDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tx9.s3;
import v19.e6;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CustomActionBar {
    public static final /* synthetic */ int c0 = 0;
    public int A;
    public aq8.e B;
    public boolean C;
    public boolean D;
    public final n E;
    public com.larus.bmhome.actionbar.model.z0 F;
    public LifecycleCoroutineScope G;
    public WeakReference<CreateMenu> H;
    public ActionBarShowFrom I;
    public boolean J;
    public vp8.k K;
    public boolean L;
    public boolean M;
    public int N;
    public View O;
    public com.larus.bmhome.instruction.a2 P;
    public CopyOnWriteArrayList<ss8.e> Q;
    public List<? extends ss8.e> R;
    public Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> S;
    public List<com.larus.bmhome.actionbar.model.z0> T;
    public int U;
    public boolean V;
    public boolean W;
    public final e X;
    public final d Y;
    public final c Z;
    public final ViewGroup a;
    public long a0;
    public final String b;
    public Function0<? extends Pair<Boolean, ? extends ActionBarShowFrom>> b0;
    public final boolean c;
    public final ICoreInputAbility d;
    public final com.larus.bmhome.chat.component.fastsend.e0 e;
    public final boolean f;
    public final List<String> g;
    public ChatParam h;
    public InstructionInputComponent i;
    public Boolean j;
    public Boolean k;
    public String l;
    public wc9.e m;
    public BotModel n;
    public CustomActionBarViewModel o;
    public boolean p;
    public boolean q;
    public RecyclerView r;
    public CustomActionBarAdapter s;
    public CustomActionBarPanelAdapterImpl t;
    public final Lazy u;
    public final Lazy v;
    public InstructionEditorViewModel w;
    public boolean x;
    public boolean y;
    public final u z;

    public static final class a {
        public final ChatParam a;
        public final LifecycleCoroutineScope b;
        public final wc9.e c;
        public final BotModel d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            ChatParam r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            LifecycleCoroutineScope r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            wc9.e r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            BotModel r10 = this.d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "CacheFastRenderContext(chatParam=" + this.a + ", lifecycleScope=" + this.b + ", conversation=" + this.c + ", botModel=" + this.d + ')';
        }

        public a(ChatParam r1, LifecycleCoroutineScope r2, wc9.e r3, BotModel r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b {
        public static String a() {
            if (AppHost.a.isOversea() == false) goto L5;
            AppLocaleUtils.a.getClass();
            Locale r0 = AppLocaleUtils.c();
        L6:
            String r1 = com.larus.utils.b0.a;
            Intrinsics.checkNotNull(r0);
            return com.larus.utils.b0.c(r0);
        L5:
            r0 = Locale.CHINA;
            goto L6
        }
    }

    public static final class c implements com.larus.bmhome.chat.a {
        public final /* synthetic */ CustomActionBar a;

        public final void a() {
            CustomActionBar r0 = this.a;
            LifecycleCoroutineScope r1 = r0.G;
            if (r1 == null) goto L7;
            CustomActionBarViewModel r2 = r0.o;
            if (r2 == null) goto L7;
            r2.updateConfigFromRemote(r1);
        L7:
            ICreationAvatarService.a.F();
        }

        public c(CustomActionBar r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.larus.bmhome.instruction.e {
        public final /* synthetic */ CustomActionBar a;

        public d(CustomActionBar r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.instruction.e
        public final boolean a(com.larus.bmhome.actionbar.model.b2 r2) {
            Intrinsics.checkNotNullParameter(r2, "switchItem");
            CustomActionBarViewModel r0 = this.a.o;
            if (r0 == null) goto L11;
            ModelItemIdentity r3 = r2.b();
            if (r3 == null) goto L7;
            String r4 = r3.getKey();
        L8:
            Pair<Boolean, String> r5 = r0.getCotExceedQuotaConfig(r4);
            if (r5 == null) goto L11;
            return ((Boolean) r5.getFirst()).booleanValue();
        L7:
            r4 = null;
        L11:
            return true;
        }

        @Override // com.larus.bmhome.instruction.e
        public final void b(com.larus.bmhome.actionbar.model.z0 r2, List<com.larus.bmhome.actionbar.model.b2> r3) {
            Intrinsics.checkNotNullParameter(r3, "switchItems");
            if (r2 != null) goto L5;
            return;
        L5:
            CustomActionBarViewModel r0 = this.a.o;
            if (r0 == null) goto L9;
            r0.checkAndUpdateMenuHasRedDot(String.valueOf(r2.a), r3);
            return;
        }

        public final void c(com.larus.bmhome.actionbar.model.z0 r7, com.larus.bmhome.actionbar.model.b2 r8) {
            Intrinsics.checkNotNullParameter(r8, "switchItem");
            ModelItemIdentity r0 = r8.b();
            CustomActionBarViewModel r1 = this.a.o;
            if (r1 == null) goto L18;
            Long r9 = r7.a;
            long r2 = 0;
            if (r9 == null) goto L7;
            long r4 = r9.longValue();
        L8:
            String r10 = String.valueOf(r4);
            if (r0 == null) goto L12;
            String r3 = r0.getKey();
            if (r3 == null) goto L12;
        L13:
            Long r11 = r8.i;
            if (r11 == null) goto L16;
            r2 = r11.longValue();
        L16:
            r1.reportMenuRedDotExposure(r10, r3, r2);
            return;
        L12:
            r3 = TriggerSendLoading.NO_LOADING;
            goto L13
        L7:
            r4 = 0;
            goto L8
        }
    }

    public static final class e implements t1 {
        public final /* synthetic */ CustomActionBar a;

        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final String a() {
            BotModel r0 = this.a.n;
            if (r0 == null) goto L5;
            String r1 = r0.getName();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final LifecycleCoroutineScope e() {
            InstructionInputComponent r0 = this.a.i;
            if (r0 == null) goto L7;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(r0, r0);
            if (r1 == null) goto L7;
            return LifecycleOwnerKt.getLifecycleScope(r1);
        L7:
            return null;
        }

        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final int f() {
            RecyclerView r0 = this.a.r;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getScrollState();
        }

        public e(CustomActionBar r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final kotlinx.coroutines.flow.i1<Boolean> c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "itemId");
            CustomActionBarViewModel r0 = this.a.o;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getActionBarLoadingStatusFlow(r2);
        }

        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final ReplyOption g(com.larus.bmhome.actionbar.model.z0 r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            com.larus.bmhome.actionbar.model.p0 r0 = r3.o;
            if (r0 == null) goto L10;
            Integer r1 = r0.a;
            int r2 = ActiveSwitchType.DEEPTHINK.getValue();
            if (r1 == null) goto L10;
            if (r1.intValue() != r2) goto L10;
            boolean r4 = true;
        L12:
            if (r4 == false) goto L17;
            InstructionInputComponent r5 = this.a.i;
            if (r5 == null) goto L16;
            final ReplyOption r6 = r5.Fe(r3);
        L18:
            com.larus.bmhome.instruction.w1.a("CustomActionBar", new m1(r6));
            return r6;
        L16:
            Object r7 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
            r6 = com.larus.bmhome.view.actionbar.custom.cache.e.b(ReplyOption.Companion, wa8.t0.a, null, null);
            goto L18
        L17:
            Object r8 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
            r6 = com.larus.bmhome.view.actionbar.custom.cache.e.b(ReplyOption.Companion, wa8.t0.a, null, null);
        L10:
            r4 = false;
            goto L12
        }

        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final void d(View r9, ImageView r10, TextView r11, com.larus.bmhome.actionbar.model.z0 r12) {
            Intrinsics.checkNotNullParameter(r9, "root");
            Intrinsics.checkNotNullParameter(r10, "icon");
            Intrinsics.checkNotNullParameter(r11, "nameView");
            CopyOnWriteArraySet<rs8.f> r3 = s1.a;
            Intrinsics.checkNotNullParameter(r9, "root");
            Intrinsics.checkNotNullParameter(r10, "icon");
            Intrinsics.checkNotNullParameter(r11, "nameView");
            Intrinsics.checkNotNullParameter(this, "customActionBarHolderCallback");
            Iterator<rs8.f> r0 = s1.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().D(r9, r10, r11, r12, this);
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v57, types: [int] */
        /* JADX WARN: Type inference failed for: r3v59 */
        /* JADX WARN: Type inference failed for: r3v65 */
        @Override // com.larus.bmhome.view.actionbar.custom.t1
        public final void b(final com.larus.bmhome.actionbar.model.z0 r140, final int r141, final Boolean r142, final View r143, final boolean r144, aq8.e r145) {
            Intrinsics.checkNotNullParameter(r140, "item");
            wa8.n1 r2 = this.a.g();
            final com.larus.bmhome.actionbar.model.z0 r7 = this.a.o(r140);
            ChatRenderTrace r3 = ChatRenderTrace.b;
            wc9.e r4 = this.a.m;
            Context r6 = null;
            if (r4 == null) goto L5;
            String r5 = r4.a;
        L6:
            String r8 = String.valueOf(r5);
            Long r11 = r7.a;
            if (r11 == null) goto L9;
            long r12 = r11.longValue();
        L10:
            String r13 = String.valueOf(r7.A);
            r3.getClass();
            Intrinsics.checkNotNullParameter(r8, "cvsId");
            Intrinsics.checkNotNullParameter(r13, "recommendRequestID");
            Intrinsics.checkNotNullParameter("chat_action_bar", "actionbarRecommendFrom");
            ChatRenderTrace.p.put(r8, new Triple(Long.valueOf(r12), r13, "chat_action_bar"));
            ChatControlTrace r9 = ChatControlTrace.b;
            wc9.e r10 = this.a.m;
            if (r10 == null) goto L13;
            String r14 = r10.a;
        L14:
            r9.sb(String.valueOf(r14), "action_bar");
            if (r7.F == false) goto L45;
            CustomActionBar r15 = this.a;
            if (r144 == false) goto L23;
            if (r15.M == false) goto L21;
            String r16 = ActionBarShowFrom.PLUS_PANNEL_SLIDE.getType();
        L26:
            String r17 = r16;
            if (r142 != null) goto L29;
            ?? r18 = -1;
        L30:
            Integer r19 = Integer.valueOf(r18);
            Long r110 = Long.valueOf(r141);
            Boolean r111 = Boolean.valueOf(r7.y);
            if (r144 == false) goto L36;
            if (r2 == null) goto L34;
            int r20 = r2.getSpanCount();
        L35:
            int r21 = (r141 % r20) + 1;
        L37:
            Integer r112 = Integer.valueOf(r21);
            if (r144 == false) goto L43;
            if (r2 == null) goto L41;
            int r22 = r2.getSpanCount();
        L42:
            int r23 = (r141 / r22) + 1;
        L44:
            int r24 = 1;
            r15.Q(r7, "click_action_bar_button", r17, r19, r110, r111, r112, Integer.valueOf(r23));
        L46:
            com.larus.bmhome.actionbar.model.p0 r25 = r140.o;
            boolean r113 = false;
            if (r25 == null) goto L51;
            com.larus.bmhome.actionbar.model.o0 r26 = r25.g;
            if (r26 == null) goto L51;
            boolean r27 = Intrinsics.areEqual(r26.a, Boolean.TRUE);
        L53:
            if (r27 == false) goto L56;
            FLogger.a.i("CustomActionBar", "action bar click disabled " + r140.a + ' ' + r140.b);
            return;
        L56:
            com.larus.bmhome.actionbar.model.d r28 = r140.J;
            if (r28 == null) goto L64;
            Integer r29 = r28.a;
            if (r29 == null) goto L64;
            if (r29.intValue() != r24) goto L64;
            boolean r30 = true;
        L65:
            if (r30 == false) goto L77;
            FLogger.a.i("CustomActionBar", "server degrade item click " + r140.a + ' ' + r140.b + ' ' + r140.J);
            com.larus.bmhome.actionbar.model.d r31 = r140.J;
            if (r31 == null) goto L74;
            String r32 = r31.b;
            if (r32 == null) goto L74;
            t19.s r33 = t19.s.a;
            if (r143 == null) goto L73;
            r6 = r143.getContext();
        L73:
            t19.s.j(r33, r6, r32, null, false, 28);
        L74:
            s3.a("abar_server_" + r140.a);
            return;
        L77:
            if (Intrinsics.areEqual(PollingConfigService.a.f("abar_hid_" + r140.a), "1") == false) goto L95;
            FLogger.a.i("CustomActionBar", "hidden item click " + r140.a + ' ' + r140.b);
            FlowDowngradeToastConfig r34 = com.larus.platform.service.z2.a.getFlowDowngradeToastConfig();
            if (r34 == null) goto L81;
            String r35 = r34.getTrafficDegradationFeatureDisableCn();
        L82:
            t19.s r114 = t19.s.a;
            if (r143 == null) goto L85;
            r6 = r143.getContext();
        L85:
            Context r115 = r6;
            if (r35 != null) goto L88;
        L89:
            r113 = true;
        L90:
            if (r113 == false) goto L92;
            r35 = AppHost.a.getApplication().getString(2131910602);
        L92:
            String r116 = r35;
            Intrinsics.checkNotNull(r116);
            t19.s.j(r114, r115, r116, null, false, 28);
            s3.a("abar_hid_" + r140.a);
            return;
        L88:
            if (r35.length() != 0) goto L90;
        L81:
            r35 = null;
            goto L82
        L95:
            if (AccountService.a.isLogin().booleanValue() == false) goto L97;
        L120:
            boolean r36 = false;
        L121:
            if (r36 == false) goto L141;
            com.larus.bmhome.actionbar.model.p0 r37 = r140.o;
            if (r37 == null) goto L130;
            Integer r38 = r37.a;
            int r117 = ActiveSwitchType.DEEPTHINK.getValue();
            if (r38 == null) goto L130;
            if (r38.intValue() != r117) goto L130;
            boolean r39 = true;
        L131:
            if (r39 == true) goto L141;
            IFlowSdkDepend r40 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r40 == null) goto L137;
            r40.getAccountService();
            if (com.larus.home.impl.sdk.d.a.M() != r24) goto L137;
            boolean r41 = true;
        L138:
            if (r41 == true) goto L141;
            FLogger.a.i("CustomActionBar", "checkTouristActionBarDisable return");
            com.larus.utils.t0.c(new n1(r7));
            return;
        L137:
            r41 = false;
        L130:
            r39 = false;
        L141:
            this.a.getClass();
            if (CustomActionBar.d(r7) == false) goto L144;
            return;
        L144:
            com.larus.bmhome.actionbar.model.p0 r42 = r140.o;
            if (r42 == null) goto L152;
            Integer r43 = r42.a;
            int r44 = ActiveSwitchType.DEEPTHINK.getValue();
            if (r43 == null) goto L152;
            if (r43.intValue() != r44) goto L152;
            boolean r45 = true;
        L153:
            if (r45 == false) goto L193;
            if (AppHost.a.isPlugin() == false) goto L161;
            Integer r46 = r140.g;
            int r47 = ActionBarExecutionType.SWITCH_STATUS.getValue();
            if (r46 == null) goto L193;
            if (r46.intValue() != r47) goto L193;
        L161:
            com.larus.bmhome.actionbar.model.p0 r48 = r140.o;
            if (r48 == null) goto L166;
            com.larus.bmhome.actionbar.model.a2 r49 = r48.d();
            if (r49 == null) goto L166;
            ArrayList r50 = r49.a;
        L167:
            if (r50 != null) goto L169;
        L172:
            boolean r51 = true;
        L173:
            if (r51 == true) goto L179;
            if (r143 == null) goto L179;
            this.a.L(r7, r141, r143, r144);
            CustomActionBarViewModel r1 = this.a.o;
            if (r1 == null) goto L482;
            r1.updateOnItemClick(r7.a);
            return;
        L482:
            return;
        L179:
            InstructionInputComponent r52 = this.a.i;
            if (r52 == null) goto L182;
            com.larus.bmhome.instruction.g.a.b(r52, r140, null, false, 6);
        L182:
            a4.a.getClass();
            a4.a(a4.b / ((long) 3));
            CustomActionBarAdapter r53 = this.a.s;
            if (r53 == null) goto L186;
            r53.notifyItemChanged(r141);
        L186:
            if (Intrinsics.areEqual(r142, Boolean.TRUE) == false) goto L193;
            t19.s r54 = t19.s.a;
            if (r143 == null) goto L190;
            Context r55 = r143.getContext();
        L191:
            r54.getClass();
            t19.s.o(r55, 2131901496, false);
            goto L193
        L190:
            r55 = null;
            goto L191
        L169:
            if (r50.isEmpty() == true) goto L172;
            r51 = false;
        L166:
            r50 = null;
        L193:
            Integer r56 = r140.g;
            int r57 = ActionBarExecutionType.USER_SEND_MSG.getValue();
            String r118 = "<this>";
            if (r56 != null) goto L197;
        L299:
            com.larus.bmhome.actionbar.model.z0 r119 = null;
            Integer r58 = r7.f;
            int r59 = ActionBarDisplayType.MENU.getValue();
            if (r58 != null) goto L303;
        L411:
            com.larus.bmhome.actionbar.model.z0 r146 = r7;
            String r410 = "<this>";
            boolean r120 = true;
            CustomActionBar.q(this.a, r146, r142, r145, 1, r143, null, 64);
        L412:
            if (r144 == false) goto L466;
            InstructionInputComponent r60 = this.a.i;
            String r61 = r410;
            if (r60 == null) goto L423;
            Intrinsics.checkNotNullParameter(r60, r61);
            Fragment r62 = com.larus.ui.arch.component.internal.attach.a.b(r60, r60);
            if (r62 == null) goto L423;
            t1a.b r63 = s1a.a.g(r62);
            if (r63 == null) goto L423;
            ICoreInputAbility r64 = r63.getAbility(ICoreInputAbility.class);
            if (r64 == null) goto L423;
            r64.C1(false, false, "");
        L423:
            String r121 = ActionBarShowFrom.PLUS_PANNEL.getType();
            CustomActionBarPanelAdapterImpl r65 = this.a.t;
            if (r65 == null) goto L435;
            List r66 = r65.getCurrentList();
            if (r66 == null) goto L435;
            Iterator r67 = r66.iterator();
        L429:
            if (r67.hasNext() == false) goto L433;
            Object r68 = r67.next();
            if (((com.larus.bmhome.actionbar.model.z0) r68).y == false) goto L429;
        L434:
            com.larus.bmhome.actionbar.model.z0 r69 = (com.larus.bmhome.actionbar.model.z0) r68;
        L436:
            if (r69 != null) goto L439;
            r120 = false;
        L439:
            CustomActionBar r70 = this.a;
            String r71 = r70.l;
            CustomActionBarViewModel r72 = r70.o;
            if (r72 == null) goto L442;
            com.larus.bmhome.actionbar.model.z0 r122 = r72.getRequestLogId();
        L443:
            wc9.e r73 = this.a.m;
            if (r73 == null) goto L448;
            String r74 = r73.a;
            if (r74 == null) goto L448;
            com.larus.bmhome.actionbar.model.z0 r210 = Long.valueOf(com.larus.bmhome.view.actionbar.bot.k.a(r74));
        L449:
            InstructionInputComponent r75 = this.a.i;
            if (r75 == null) goto L458;
            Intrinsics.checkNotNullParameter(r75, r61);
            Fragment r76 = com.larus.ui.arch.component.internal.attach.a.b(r75, r75);
            if (r76 == null) goto L458;
            t1a.b r77 = s1a.a.g(r76);
            if (r77 == null) goto L458;
            de8.c r78 = r77.f(de8.c.class);
            if (r78 == null) goto L458;
            com.larus.bmhome.actionbar.model.z0 r211 = r78.p();
        L459:
            com.larus.bmhome.actionbar.model.r r79 = r146.q;
            if (r79 == null) goto L464;
            Integer r80 = r79.a;
            if (r80 == null) goto L464;
            int r123 = r80.intValue();
        L465:
            tx9.b.h(r121, Boolean.valueOf(r120), r71, r122, r210, r211, "click_action_bar", String.valueOf(r123), Long.valueOf(System.currentTimeMillis() - this.a.a0));
        L467:
            CustomActionBarViewModel r81 = this.a.o;
            if (r81 == null) goto L488;
            r81.updateOnItemClick(r146.a);
            return;
        L488:
            return;
        L464:
            r123 = 0;
        L458:
            r211 = r119;
        L448:
            r210 = r119;
            goto L449
        L442:
            r122 = r119;
            goto L443
        L433:
            r68 = r119;
        L435:
            r69 = r119;
            goto L436
        L466:
            r146 = r146;
            goto L467
        L303:
            if (r58.intValue() != r59) goto L411;
            if (Intrinsics.areEqual(r7.b, "coco_download") == true) goto L411;
            if (r143 == null) goto L410;
            final CustomActionBar r124 = this.a;
            r124.getClass();
            ArrayList r82 = new ArrayList();
            com.larus.bmhome.actionbar.model.r r83 = r7.q;
            if (r83 == null) goto L401;
            com.larus.bmhome.actionbar.model.y r84 = r83.i;
            if (r84 == null) goto L401;
            ArrayList r85 = r84.a;
            if (r85 == null) goto L401;
            Iterator r86 = r85.iterator();
            int r87 = 0;
        L315:
            if (r86.hasNext() == false) goto L401;
            Object r88 = r86.next();
            int r89 = r87 + 1;
            if (r87 >= 0) goto L319;
            CollectionsKt.throwIndexOverflow();
        L319:
            com.larus.bmhome.actionbar.model.z0 r90 = (com.larus.bmhome.actionbar.model.z0) r88;
            if (Intrinsics.areEqual(r90.s, Boolean.TRUE) == true) goto L322;
        L324:
            IFlowSdkDepend r91 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r91 == null) goto L327;
            r91.y();
            com.larus.home.impl.sdk.t1 r125 = com.larus.home.impl.sdk.t1.a;
        L328:
            if (r125 != null) goto L330;
        L332:
            boolean r92 = false;
        L333:
            if (r92 == false) goto L341;
            if (r125 != null) goto L336;
        L338:
            boolean r126 = false;
        L339:
            if (r126 == false) goto L341;
            boolean r127 = true;
        L342:
            String r93 = r90.b;
            if (Intrinsics.areEqual(r93, "coco_ai_simul_interpret") == false) goto L346;
        L360:
            if (r127 == false) goto L366;
            String r94 = r90.e;
            if (r94 == null) goto L364;
            int r510 = r94.hashCode();
        L365:
            com.larus.bmhome.view.screenmenu.l0 r95 = new com.larus.bmhome.view.screenmenu.l0(r510, 2131907302, null, null, null, 2131102650, null, 2131242863, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127);
        L378:
            r82.add(r95);
            String r96 = r124.l;
            InstructionInputComponent r97 = r124.i;
            if (r97 == null) goto L381;
            Intrinsics.checkNotNullParameter(r97, r118);
            Fragment r128 = com.larus.ui.arch.component.internal.attach.a.b(r97, r97);
        L383:
            if ((r128 instanceof ChatFragment) == false) goto L385;
            ChatFragment r129 = (ChatFragment) r128;
        L387:
            if (r129 == null) goto L389;
            String r130 = ChatControlTrace.b.h(r129.getChatUniqueKey());
        L390:
            com.larus.bmhome.actionbar.model.r r98 = r7.q;
            if (r98 == null) goto L393;
            String r131 = r98.g;
        L394:
            if (r98 == null) goto L398;
            Integer r99 = r98.a;
            if (r99 == null) goto L398;
            int r100 = r99.intValue();
        L399:
            tx9.b.f(r96, r130, r131, String.valueOf(r100), r7.b, "", null, r90.e, "", 0, 0, Integer.valueOf(r89), null, null, null, null, null, null, null, null, null, null, 8384576);
        L400:
            r86 = r86;
            r87 = r89;
            r118 = r118;
            r24 = 1;
        L398:
            r100 = 0;
            goto L399
        L393:
            r131 = null;
            goto L394
        L389:
            r130 = null;
            goto L390
        L385:
            r129 = null;
            goto L387
        L381:
            r128 = null;
            goto L383
        L364:
            r510 = 0;
            goto L365
        L366:
            String r101 = r90.e;
            if (r101 == null) goto L369;
            int r910 = r101.hashCode();
        L370:
            String r102 = r90.e;
            com.larus.bmhome.actionbar.model.g1 r103 = r90.c;
            if (r103 == null) goto L376;
            String r104 = r103.b;
            if (r104 == null) goto L376;
            String r107 = r104;
        L377:
            r95 = new com.larus.bmhome.view.screenmenu.l0(r910, 0, r102, null, null, null, null, null, r107, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -262, 127);
        L376:
            r107 = "";
            goto L377
        L369:
            r910 = 0;
            goto L370
        L346:
            if (Intrinsics.areEqual(r93, "coco_record") == false) goto L351;
            if (r92 == false) goto L350;
            if (r127 == false) goto L358;
        L359:
            r127 = false;
        L358:
            r127 = true;
            goto L360
        L350:
            r127 = AudioServiceDelegate.a.P().g();
            goto L360
        L351:
            Integer r105 = r90.g;
            int r106 = ActionBarExecutionType.RECORD.getValue();
            if (r105 == null) goto L359;
            if (r105.intValue() != r106) goto L359;
            if (AudioServiceDelegate.a.P().g() == false) goto L359;
        L336:
            if (r125.j() != r24) goto L338;
            r126 = true;
        L341:
            r127 = false;
            goto L342
        L330:
            if (r125.y0() != r24) goto L332;
            r92 = true;
            goto L333
        L327:
            r125 = null;
            goto L328
        L322:
            if (i3.a.f() == false) goto L324;
        L401:
            r410 = r118;
            if (r82.isEmpty() == true) goto L409;
            InstructionInputComponent r108 = r124.i;
            if (r108 == null) goto L409;
            Context r109 = r108.getContext();
            if (r109 == null) goto L409;
            r120 = true;
            r119 = null;
            r146 = r7;
            View r132 = CreateMenu.f(new CreateMenu(r109), r82, 0, false, null, null, null, null, new a1(r7, r143, r124, r142, r144, r141), 510);
            CustomActionBar.e(r124, r143, r132, null, 12).v(r143, r124.l(r143, r132, r124.J(r141, r144)), i5.E());
        L409:
            r146 = r7;
            r120 = true;
            r119 = null;
            goto L412
        L410:
            r146 = r7;
            r410 = "<this>";
            r120 = true;
            goto L412
        L197:
            if (r56.intValue() != r57) goto L299;
            com.larus.bmhome.actionbar.model.n0 r133 = r140.l;
            if (r133 == null) goto L201;
            ArrayList r134 = r133.b;
        L202:
            if (r134 != null) goto L204;
        L207:
            boolean r135 = true;
        L208:
            if (r135 == true) goto L299;
            if (r143 == null) goto L299;
            final CustomActionBar r136 = this.a;
            InstructionInputComponent r137 = r136.i;
            if (r137 == null) goto L215;
            Context r138 = r137.getContext();
            if (r138 == null) goto L215;
            boolean r139 = v19.h.a;
            boolean r147 = v19.h.b(r138);
        L216:
            ArrayList r148 = new ArrayList();
            com.larus.bmhome.actionbar.model.n0 r149 = r140.l;
            if (r149 == null) goto L285;
            ArrayList r150 = r149.b;
            if (r150 == null) goto L285;
            Iterator r151 = r150.iterator();
            int r152 = 0;
        L222:
            if (r151.hasNext() == false) goto L285;
            Object r153 = r151.next();
            int r154 = r152 + 1;
            if (r152 >= 0) goto L226;
            CollectionsKt.throwIndexOverflow();
        L226:
            com.larus.bmhome.actionbar.model.x1 r155 = (com.larus.bmhome.actionbar.model.x1) r153;
            if (r155 == null) goto L486;
            String r156 = r155.a;
            if (r156 == null) goto L487;
            if (r147 == false) goto L236;
            boolean r1410 = r147;
            com.larus.bmhome.actionbar.model.g1 r157 = r155.e;
            if (r157 != null) goto L238;
        L239:
            String r212 = null;
        L240:
            r148.add(new com.larus.bmhome.view.screenmenu.l0(r152, 0, r156, null, null, null, null, null, r212, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -262, 127));
            String r158 = r136.l;
            wc9.e r159 = r136.m;
            if (r159 == null) goto L245;
            String r160 = r159.a;
            if (r160 == null) goto L245;
            Long r213 = Long.valueOf(com.larus.bmhome.view.actionbar.bot.k.a(r160));
        L246:
            InstructionInputComponent r161 = r136.i;
            if (r161 == null) goto L249;
            Intrinsics.checkNotNullParameter(r161, "<this>");
            Fragment r162 = com.larus.ui.arch.component.internal.attach.a.b(r161, r161);
        L251:
            if ((r162 instanceof ChatFragment) == false) goto L253;
            ChatFragment r163 = (ChatFragment) r162;
        L254:
            Iterator r1411 = r151;
            if (r163 == null) goto L257;
            String r164 = ChatControlTrace.b.h(r163.getChatUniqueKey());
        L258:
            com.larus.bmhome.actionbar.model.r r165 = r140.q;
            if (r165 == null) goto L261;
            String r166 = r165.g;
        L262:
            if (r165 == null) goto L266;
            Integer r167 = r165.a;
            if (r167 == null) goto L266;
            int r168 = r167.intValue();
        L267:
            String r169 = String.valueOf(r168);
            String r170 = r140.b;
            String r171 = r155.a;
            IFlowSdkDepend r172 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r172 == null) goto L270;
            r172.N();
            String r310 = com.larus.home.impl.sdk.n1.a.i();
        L271:
            IFlowSdkDepend r173 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r173 == null) goto L274;
            r173.N();
            String r311 = com.larus.home.impl.sdk.n1.a.c(null);
        L275:
            IFlowSdkDepend r174 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r174 == null) goto L278;
            r174.N();
            String r312 = com.larus.home.impl.sdk.n1.a.d(null);
        L279:
            IFlowSdkDepend r175 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r175 == null) goto L282;
            r175.N();
            Integer r313 = com.larus.home.impl.sdk.n1.a.e(null);
        L283:
            tx9.b.f(r158, r164, r166, r169, r170, "", null, r171, "", 0, 0, Integer.valueOf(r152), null, r213, null, r310, r311, r312, r313, "ai_doc_detail", null, null, 6344768);
            r147 = r1410;
            r151 = r1411;
            r152 = r154;
            goto L222
        L282:
            r313 = null;
            goto L283
        L278:
            r312 = null;
            goto L279
        L274:
            r311 = null;
            goto L275
        L270:
            r310 = null;
        L266:
            r168 = 0;
            goto L267
        L261:
            r166 = null;
            goto L262
        L257:
            r164 = null;
            goto L258
        L253:
            r163 = null;
            goto L254
        L249:
            r162 = null;
        L245:
            r213 = null;
        L238:
            r212 = r157.b;
            goto L240
        L236:
            r1410 = r147;
            r157 = r155.d;
            if (r157 == null) goto L239;
        L487:
            return;
        L486:
            return;
        L285:
            if (r148.isEmpty() == true) goto L485;
            InstructionInputComponent r176 = r136.i;
            if (r176 == null) goto L483;
            Context r177 = r176.getContext();
            if (r177 == null) goto L484;
            View r178 = CreateMenu.f(new CreateMenu(r177), r148, 0, false, null, null, null, null, new r0(r140, r143, r136), 510);
            Balloon r179 = CustomActionBar.e(r136, r143, r178, null, 8);
            ViewGroup.LayoutParams r180 = r178.getLayoutParams();
            if ((r180 instanceof ViewGroup.MarginLayoutParams) == false) goto L294;
            ViewGroup.MarginLayoutParams r181 = (ViewGroup.MarginLayoutParams) r180;
        L295:
            if (r181 == null) goto L297;
            r181.setMarginEnd(-i5.E());
        L297:
            r179.v(r143, r136.l(r143, r178, r136.J(r141, r144)), i5.E());
            return;
        L294:
            r181 = null;
            goto L295
        L484:
            return;
        L483:
            return;
        L485:
            return;
        L215:
            r147 = false;
            goto L216
        L204:
            if (r134.isEmpty() == true) goto L207;
            r135 = false;
            goto L208
        L201:
            r134 = null;
        L152:
            r45 = false;
            goto L153
        L97:
            if (i3.a.i() == false) goto L120;
            Integer r182 = r7.g;
            int r183 = ActionBarExecutionType.RECORD.getValue();
            if (r182 == null) goto L106;
            if (r182.intValue() != r183) goto L106;
        L104:
            r36 = true;
        L106:
            if (com.larus.platform.service.z2.a.disableTouristActionBarCreation() == false) goto L120;
            Integer[] r184 = new Integer[7];
            r184[0] = Integer.valueOf(r24);
            r184[r24] = 4;
            r184[2] = 11;
            r184[3] = 16;
            r184[4] = 18;
            r184[5] = 24;
            r184[6] = 28;
            com.larus.bmhome.actionbar.model.r r185 = r7.q;
            if (r185 == null) goto L110;
            Integer r186 = r185.a;
        L112:
            if (ArraysKt.contains(r184, r186) == true) goto L104;
            Integer[] r187 = new Integer[2];
            r187[0] = 30;
            r187[r24] = 34;
            com.larus.bmhome.actionbar.model.r r188 = r7.q;
            if (r188 == null) goto L116;
            Integer r189 = r188.a;
        L118:
            if (ArraysKt.contains(r187, r189) == false) goto L120;
        L116:
            r189 = null;
            goto L118
        L110:
            r186 = null;
        L64:
            r30 = false;
        L51:
            r27 = false;
            goto L53
        L41:
            r22 = 3;
            goto L42
        L43:
            r23 = r141 + 1;
            goto L44
        L34:
            r20 = 3;
            goto L35
        L36:
            r21 = 1;
            goto L37
        L29:
            r18 = r142.booleanValue();
            goto L30
        L21:
            r16 = ActionBarShowFrom.PLUS_PANNEL.getType();
            goto L26
        L23:
            if (r15.L == false) goto L25;
            r16 = ActionBarShowFrom.SLIDE.getType();
            goto L26
        L25:
            r16 = ActionBarShowFrom.DIRECT_SHOW.getType();
            goto L26
        L45:
            r24 = 1;
            goto L46
        L13:
            r14 = null;
            goto L14
        L9:
            r12 = 0;
            goto L10
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((IActionBarSegmentV2) r1).getPriority()), Integer.valueOf(((IActionBarSegmentV2) r2).getPriority()));
        }
    }

    public static final class g implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public g(Function1 r2) {
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

    public final void D() {
        CustomActionBarAdapter r0 = this.s;
        int r1 = -1;
        if (r0 == null) goto L30;
        List r2 = r0.getCurrentList();
        if (r2 == null) goto L30;
        Iterator r3 = r2.iterator();
        boolean r4 = false;
        int r5 = 0;
    L8:
        if (r3.hasNext() == false) goto L21;
        com.larus.bmhome.actionbar.model.p0 r6 = ((com.larus.bmhome.actionbar.model.z0) r3.next()).o;
        if (r6 == null) goto L17;
        Integer r7 = r6.a;
        int r8 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r7 == null) goto L17;
        if (r7.intValue() != r8) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L22;
        r5 = r5 + 1;
    L22:
        Integer r10 = Integer.valueOf(r5);
        if (r10.intValue() < 0) goto L25;
        r4 = true;
    L25:
        if (r4 == true) goto L28;
        r10 = null;
    L28:
        if (r10 == null) goto L30;
        r1 = r10.intValue();
    L33:
        if (r1 < 0) goto L40;
        CustomActionBarAdapter r11 = this.s;
        if (r11 == null) goto L41;
        r11.notifyItemChanged(r1);
        return;
    L41:
        return;
    L40:
        return;
    L17:
        r9 = false;
        goto L18
    L21:
        r5 = -1;
    L30:
        CustomActionBarViewModel r12 = this.o;
        if (r12 == null) goto L33;
        r1 = r12.getDeepThinkPosition();
        goto L33
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.view.actionbar.custom.v] */
    public final void I() {
        FLogger r0 = FLogger.a;
        r0.i("CustomActionBar", "setUpRecyclerView");
        if (this.s == null) goto L5;
        return;
    L5:
        RecyclerView r2 = this.r;
        View r3 = null;
        if (r2 == null) goto L8;
        r2.setItemAnimator(null);
    L8:
        RecyclerView r4 = this.r;
        if (r4 == null) goto L11;
        r4.setLayoutManager(new RightLayoutManager(AppHost.a.getApplication()));
    L11:
        ChatParam r7 = this.h;
        e r8 = this.X;
        boolean r9 = this.c;
        List r5 = this.Q;
        if (r5 != null) goto L15;
        r5 = new ArrayList();
    L15:
        CustomActionBarAdapter r6 = new CustomActionBarAdapter(r7, r8, r9, r5, this.E, new v(this), 32);
        this.s = r6;
        RecyclerView r10 = this.r;
        if (r10 == null) goto L18;
        r10.setAdapter(r6);
    L18:
        RecyclerView r11 = this.r;
        if (r11 == null) goto L21;
        r11.addItemDecoration(new CustomActionBar$setUpRecyclerView$2());
    L21:
        RecyclerView r12 = this.r;
        if (r12 == null) goto L24;
        y6.f(r12, new w(this), null, 0.1f, new x(this), 53);
    L24:
        GradientMaskView r13 = this.a;
        if ((r13 instanceof GradientMaskView) == false) goto L27;
        GradientMaskView r14 = r13;
    L28:
        if (r14 == null) goto L34;
        LarusLayoutGradientMaskBinding r15 = r14.a;
        if (r15 == null) goto L34;
        View r16 = r15.b;
        if (r16 == null) goto L34;
        r16.setVisibility(8);
    L34:
        RecyclerView r17 = this.r;
        if (r17 == null) goto L37;
        RecyclerView.LayoutManager r18 = r17.getLayoutManager();
    L39:
        if ((r18 instanceof LinearLayoutManager) == false) goto L41;
        final LinearLayoutManager r19 = (LinearLayoutManager) r18;
    L42:
        RecyclerView r20 = this.r;
        if (r20 == null) goto L45;
        r20.addOnScrollListener(new CustomActionBar$setUpRecyclerView$5(this, r19));
    L45:
        r0.i("CustomActionBar", "setActionBarPanelView");
        if (this.t != null) goto L80;
        this.t = new CustomActionBarPanelAdapterImpl(this.h, this.X);
        InstructionInputComponent r1 = this.i;
        if (r1 == null) goto L61;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r21 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if (r21 == null) goto L61;
        FragmentActivity r22 = r21.getActivity();
        if (r22 == null) goto L61;
        Window r23 = r22.getWindow();
        if (r23 == null) goto L61;
        r3 = r23.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L61;
        r0.i("DecorViewLancet", "getDecorView");
        Thread r24 = ThreadMethodProxy.currentThread();
        if (r24 == com.larus.home.impl.utils.c.a) goto L61;
        com.larus.home.impl.utils.c.a(r24, "getDecorView");
    L61:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r25 = (ViewGroup) r3;
        View r26 = new View(r25.getContext());
        r26.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r26.setBackgroundColor(0);
        com.larus.utils.e1.o(r26);
        r26.setOnTouchListener(new c1(this));
        this.O = r26;
        r25.addView(r26);
        final CustomActionBarPanelAdapterImpl r27 = this.t;
        if (r27 == null) goto L68;
        final wa8.n1 r28 = g();
        if (r28 == null) goto L66;
        r28.a(r27);
    L66:
        if (r28 == null) goto L68;
        r28.setCallback(new CustomActionBar$setActionBarPanelView$1$1(this, r28, r27));
    L68:
        final wa8.n1 r29 = g();
        if (r29 == null) goto L73;
        RecyclerView r30 = r29.getRecyclerView();
        if (r30 == null) goto L73;
        y6.f(r30, new y0(this), null, 0.1f, new z0(this, r29), 53);
    L73:
        if (r29 == null) goto L78;
        RecyclerView r31 = r29.getRecyclerView();
        if (r31 == null) goto L79;
        r31.addOnScrollListener(new CustomActionBar$setActionBarPanelView$4(this));
        return;
    L79:
        return;
    L78:
        return;
    L80:
        return;
    L41:
        r19 = null;
        goto L42
    L37:
        r18 = null;
        goto L39
    L27:
        r14 = null;
        goto L28
    }

    public final void S() {
        FLogger.a.i("CustomActionBar", "triggerUpdateVisibility");
        X(true, Boolean.FALSE);
    }

    public final wa8.n1 g() {
        InstructionInputComponent r0 = this.i;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(r0, r0);
        if (r1 == null) goto L13;
        t1a.b r2 = s1a.a.g(r1);
        if (r2 == null) goto L13;
        va8.o r3 = r2.getAbility(va8.o.class);
        if (r3 == null) goto L13;
        va8.b r4 = r3.rX();
        if (r4 == null) goto L13;
        View r5 = r4.l;
    L15:
        if ((r5 instanceof wa8.n1) == true) goto L17;
        return null;
    L17:
        return (wa8.n1) r5;
    L13:
        r5 = null;
        goto L15
    }

    public final boolean m() {
        return ((Boolean) this.v.getValue()).booleanValue();
    }

    public final List<com.larus.bmhome.actionbar.model.z0> n() {
        CustomActionBarViewModel r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return CustomActionBarViewModel.getCacheConfig$default(r0, b.a(), null, null, null, 14, null);
    }

    public static aq8.e A(String r15) {
        if (r15 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        String r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        Uri r16 = UriProtector.parse(r15);
        if (r16 == null) goto L14;
        String r2 = UriProtector.getQueryParameter(r16, "is_from_push");
    L15:
        boolean r3 = Intrinsics.areEqual(r2, "true");
        if (r16 == null) goto L18;
        String r4 = UriProtector.getQueryParameter(r16, "is_from_outer");
    L19:
        boolean r5 = Intrinsics.areEqual(r4, "true");
        LinkedHashMap r8 = new LinkedHashMap();
        if (r5 == true) goto L22;
        if (r3 == true) goto L22;
    L27:
        if (r3 == false) goto L29;
        r1 = "push";
    L32:
        return new aq8.e(null, null, null, null, r8, false, r1, null, null, null, 943);
    L29:
        if (r5 == false) goto L32;
        r1 = "deep_link";
    L22:
        String r17 = com.larus.bmhome.creative.utils.a.a(r16);
        if (r17 != null) goto L25;
        r17 = "";
    L25:
        r8.put("outer_link_source", r17);
        goto L27
    L18:
        r4 = null;
        goto L19
    L14:
        r2 = null;
        goto L15
    L4:
        if (r15.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void B(com.larus.bmhome.actionbar.model.z0 r1) {
        if (r1 == null) goto L11;
        com.larus.bmhome.actionbar.model.r r2 = r1.q;
        if (r2 == null) goto L11;
        Integer r3 = r2.a;
        if (r3 == null) goto L11;
        if (r3.intValue() != 28) goto L11;
        boolean r4 = true;
    L13:
        if (com.larus.platform.service.z2.a.enableAICreationApplet() == false) goto L17;
        if (r4 == false) goto L18;
        ICreationWorkflowService.a.X();
        return;
    L18:
        return;
    L17:
        return;
    L11:
        r4 = false;
        goto L13
    }

    public static boolean K(com.larus.bmhome.actionbar.model.z0 r3) {
        com.larus.platform.service.z2 r0 = com.larus.platform.service.z2.a;
        if (r0.enableCreationActionbarConfig() == true) goto L5;
        return false;
    L5:
        if (r0.enableAddAlbumCreationInput() == false) goto L23;
        com.larus.bmhome.actionbar.model.r r4 = r3.q;
        if (r4 == null) goto L18;
        com.larus.bmhome.actionbar.model.j1 r5 = r4.e;
        if (r5 == null) goto L18;
        String r6 = r5.u;
        if (r6 == null) goto L18;
        if (r6.length() <= 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 != true) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L24;
        return true;
    L24:
        return false;
    L15:
        r7 = false;
    L18:
        r8 = false;
        goto L19
    L23:
        return false;
    }

    public static void V(RecyclerView r4) {
        FLogger.a.d("CustomActionBar", "tryShowTip");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getScrollState() != 0) goto L26;
        LinearLayoutManager r0 = r4.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r1 = r0;
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = r1.findLastVisibleItemPosition();
        if (r2 > r3) goto L25;
    L15:
        RecyclerView.ViewHolder r5 = r4.findViewHolderForAdapterPosition(r2);
        if (r5 != null) goto L19;
    L21:
        if (r2 == r3) goto L27;
        r2 = r2 + 1;
        goto L15
    L27:
        return;
    L19:
        if ((r5 instanceof CustomActionBarNormalHolder) == false) goto L21;
        ((CustomActionBarNormalHolder) r5).a4();
        goto L21
    L25:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public static void Z(View r2) {
        nda.d.a().pa();
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (ChatWindowServiceDelegate.b.d(r2.getContext()) == false) goto L10;
        int r3 = i5.v();
    L11:
        r1.setMarginStart(-r3);
        return;
    L10:
        r3 = i5.C();
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static com.larus.bmhome.view.screenmenu.l0 b(uz8.e r46) {
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("buildMembershipActionBarMenuItem isEnabled: ");
        if (r46 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r46.isEnabled);
    L6:
        r2.append(r4);
        r1.i("CustomActionBar", r2.toString());
        boolean r3 = false;
        if (r46 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == true) goto L14;
        return null;
    L14:
        String r8 = r46.title;
        String r6 = r46.clickUrl;
        if (r8 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L52;
        if (r6 != null) goto L24;
    L25:
        r3 = true;
    L26:
        if (r3 == true) goto L52;
        MenuItemType r30 = MenuItemType.BUTTON;
        uz8.a r9 = r46.backgroundColor;
        if (r9 == null) goto L31;
        String r15 = r9.darkMode;
    L32:
        if (r9 == null) goto L34;
        String r10 = r9.lightMode;
    L35:
        com.larus.bmhome.view.screenmenu.m0 r11 = new com.larus.bmhome.view.screenmenu.m0(r15, r10);
        uz8.a r16 = r46.textColor;
        if (r16 == null) goto L38;
        String r12 = r16.darkMode;
    L39:
        if (r16 == null) goto L41;
        String r17 = r16.lightMode;
    L42:
        com.larus.bmhome.view.screenmenu.m0 r13 = new com.larus.bmhome.view.screenmenu.m0(r12, r17);
        uz8.a r0 = r46.pressColor;
        if (r0 == null) goto L45;
        String r18 = r0.darkMode;
    L46:
        if (r0 == null) goto L48;
        String r14 = r0.lightMode;
    L50:
        return new com.larus.bmhome.view.screenmenu.l0(-2147483548, 0, r8, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, r30, r11, r13, new com.larus.bmhome.view.screenmenu.m0(r18, r14), r6, null, null, null, null, null, null, null, null, false, -1040187398, 127);
    L48:
        r14 = null;
        goto L50
    L45:
        r18 = null;
        goto L46
    L41:
        r17 = null;
        goto L42
    L38:
        r12 = null;
        goto L39
    L34:
        r10 = null;
        goto L35
    L31:
        r15 = null;
        goto L32
    L24:
        if (r6.length() != 0) goto L26;
    L52:
        return null;
    L17:
        if (r8.length() == 0) goto L20;
        r7 = false;
        goto L21
    L9:
        if (r46.isEnabled != true) goto L11;
        r5 = true;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public static boolean d(com.larus.bmhome.actionbar.model.z0 r3) {
        if (AppHost.a.isOversea() == false) goto L7;
        if (Intrinsics.areEqual(r3.b, "coco_fifa_world_cup") == true) goto L7;
    L11:
        if (AccountService.a.isLogin().booleanValue() == true) goto L13;
        com.larus.utils.t0.c(new a0());
        boolean r4 = true;
    L14:
        if (r4 == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        r4 = false;
    L7:
        if (Intrinsics.areEqual(r3.b, "coco_spring_festival_2025") == true) goto L11;
        if (Intrinsics.areEqual(r3.b, "coco_spring_greeting_2025") == true) goto L11;
        return false;
    }

    public static List i(List r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        com.larus.bmhome.actionbar.model.z0 r2 = (com.larus.bmhome.actionbar.model.z0) r1;
        if (Intrinsics.areEqual(r2.b, "coco_bot_like") == false) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2.b, "coco_bot_comment") == true) goto L11;
        r3 = false;
        goto L12
    L14:
        return r0;
    }

    public static int w(View r2) {
        if (r2.getMeasuredWidth() > 0) goto L6;
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L6:
        return r2.getMeasuredWidth();
    }

    public final void C(int r2) {
        this.U = r2;
        if (r2 <= 0) goto L11;
        Function0<? extends Pair<Boolean, ? extends ActionBarShowFrom>> r3 = this.b0;
        if (r3 == null) goto L9;
        Pair r4 = (Pair) r3.invoke();
        if (r4 == null) goto L9;
        boolean r5 = ((Boolean) r4.getFirst()).booleanValue();
    L10:
        X(r5, Boolean.FALSE);
        return;
    L9:
        r5 = false;
        goto L10
    L11:
        t("refreshActionBarVisiable itemSize=0");
    }

    public final void G(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        com.larus.utils.e1.o(r0);
    L5:
        com.larus.bmhome.instruction.w1.a("CustomActionBar", new p(r2));
    }

    public final void H(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        ICoreInputAbility r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L22;
        ViewGroup r3 = this.a;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
    L18:
        ViewGroup r6 = this.a;
        if (r6 == null) goto L43;
        com.larus.utils.e1.o(r6);
        return;
    L43:
        return;
    L17:
        if (Intrinsics.areEqual(this.k, Boolean.TRUE) == true) goto L22;
    L12:
        if (ViewExtKt.h(r3) != true) goto L14;
        r4 = true;
    L22:
        ICoreInputAbility r7 = this.d;
        if (r7 == null) goto L29;
        z8.a r8 = r7.Jd();
        if (r8 == null) goto L29;
        if (r8.r != true) goto L29;
        r1 = true;
    L29:
        if (r1 == false) goto L35;
        ViewGroup r9 = this.a;
        if (r9 == null) goto L44;
        com.larus.utils.e1.o(r9);
        return;
    L44:
        return;
    L35:
        if (this.U > 0) goto L38;
        t("setActionBarContainerVisible:".concat(r5));
        com.larus.bmhome.instruction.w1.a("CustomActionBar", new q(r5));
        return;
    L38:
        ViewGroup r10 = this.a;
        if (r10 == null) goto L41;
        com.larus.utils.e1.x(r10);
    L41:
        com.larus.bmhome.instruction.w1.a("CustomActionBar", new r(r5));
        return;
    L5:
        if (r0.c2() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Deprecated(message = "do not use, use custom segment by refresh")
    public final void N(boolean r6) {
        FLogger.a.i("CustomActionBar", this + ", submitCurrentList");
        List<com.larus.bmhome.actionbar.model.z0> r0 = null;
        if (r6 == false) goto L7;
        CustomActionBarAdapter r7 = this.s;
        if (r7 == null) goto L12;
        List<com.larus.bmhome.actionbar.model.z0> r8 = r7.getCurrentList();
    L13:
        boolean r1 = false;
        if (r8 == null) goto L18;
        List<com.larus.bmhome.actionbar.model.z0> r3 = i(r8);
        P(T(r3), true, false, null);
        if ((!((ArrayList) r3).isEmpty()) == false) goto L18;
        X(true, Boolean.TRUE);
    L18:
        InstructionInputComponent r4 = this.i;
        if (r4 == null) goto L23;
        t1a.b r5 = s1a.d.a(r4);
        if (r5 == null) goto L23;
        com.larus.bmhome.chat.model.n r9 = (com.larus.bmhome.chat.model.n) r5.a(com.larus.bmhome.chat.model.n.class);
    L24:
        if (r9 != null) goto L26;
    L28:
        if (r1 == false) goto L45;
        List<com.larus.bmhome.actionbar.model.z0> r2 = this.T;
        if (r2 != null) goto L41;
        CustomActionBarViewModel r10 = this.o;
        if (r10 == null) goto L36;
        LiveData<List<com.larus.bmhome.actionbar.model.z0>> r11 = r10.getActionBarConfList();
        if (r11 == null) goto L36;
        r0 = (List) r11.getValue();
    L36:
        if (r0 != null) goto L40;
        r0 = n();
        if (r0 != null) goto L40;
    L42:
        if (r8 == null) goto L46;
        U(r9, i(r8));
        return;
    L46:
        return;
    L40:
        r8 = r0;
        goto L42
    L41:
        r8 = r2;
        goto L42
    L45:
        return;
    L26:
        if (r9.d != true) goto L28;
        r1 = true;
    L23:
        r9 = null;
    L12:
        r8 = null;
        goto L13
    L7:
        CustomActionBarViewModel r12 = this.o;
        if (r12 == null) goto L12;
        LiveData<List<com.larus.bmhome.actionbar.model.z0>> r13 = r12.getActionBarConfList();
        if (r13 == null) goto L12;
        r8 = (List) r13.getValue();
        goto L13
    }

    public final List<com.larus.bmhome.actionbar.model.z0> T(List<com.larus.bmhome.actionbar.model.z0> r9) {
        VoiceCallServiceDelegate r0 = VoiceCallServiceDelegate.a;
        BotModel r1 = this.n;
        wc9.e r2 = this.m;
        if (r2 == null) goto L6;
        String r3 = r2.a;
        if (r3 == null) goto L6;
    L7:
        boolean r4 = IVoiceCallService.a.a(r0, r1, r3, true, 8);
        if (r4 == false) goto L11;
        r4 = !r0.q("voice_call", "action_bar", true);
    L11:
        if (r0.q("video_call", "action_bar", true) == false) goto L20;
        ArrayList r5 = new ArrayList();
        Iterator r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L18;
        Object r6 = r10.next();
        if ((!Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r6).b, "coco_call_video")) == false) goto L14;
        r5.add(r6);
        goto L14
    L18:
        r9 = r5;
    L20:
        if (r4 == false) goto L45;
        int r7 = com.larus.bmhome.utils.r.a;
        LaunchInfo r8 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r8 == null) goto L24;
        ContinueCallConf r11 = r8.E();
    L25:
        if (r11 == null) goto L27;
        boolean r12 = r11.a();
    L28:
        if (r12 == true) goto L81;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r9.iterator();
    L32:
        if (r14.hasNext() == false) goto L65;
        Object r15 = r14.next();
        com.larus.bmhome.actionbar.model.r r16 = ((com.larus.bmhome.actionbar.model.z0) r15).q;
        if (r16 == null) goto L41;
        Integer r17 = r16.a;
        if (r17 == null) goto L41;
        if (r17.intValue() != 19) goto L41;
        boolean r18 = true;
    L43:
        if ((!r18) == false) goto L32;
        r13.add(r15);
    L41:
        r18 = false;
    L65:
        return r13;
    L81:
        return r9;
    L27:
        r12 = false;
        goto L28
    L24:
        r11 = null;
        goto L25
    L45:
        r13 = new ArrayList();
        Iterator r19 = r9.iterator();
    L47:
        if (r19.hasNext() == false) goto L65;
        Object r20 = r19.next();
        com.larus.bmhome.actionbar.model.z0 r21 = (com.larus.bmhome.actionbar.model.z0) r20;
        if (Intrinsics.areEqual(r21.b, "coco_call") == true) goto L61;
        com.larus.bmhome.actionbar.model.r r22 = r21.q;
        if (r22 == null) goto L58;
        Integer r23 = r22.a;
        if (r23 == null) goto L58;
        if (r23.intValue() != 19) goto L58;
        boolean r24 = true;
    L59:
        if (r24 == true) goto L61;
        boolean r25 = true;
    L62:
        if (r25 == false) goto L47;
        r13.add(r20);
    L58:
        r24 = false;
    L61:
        r25 = false;
    L6:
        r3 = "";
        goto L7
    }

    public final void W(boolean r6) {
        FLogger.a.i("CustomActionBar", "updateCoordinatorShow, visible=" + r6);
        if (r6 == true) goto L6;
        G("updateCoordinatorShow gone");
        return;
    L6:
        InstructionInputComponent r7 = this.i;
        List r0 = null;
        if (r7 == null) goto L13;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Fragment r8 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7);
        if (r8 == null) goto L13;
        t1a.b r9 = s1a.a.g(r8);
        if (r9 == null) goto L13;
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r10 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) r9.getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
    L14:
        boolean r1 = false;
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == true) goto L22;
        this.j = null;
        ViewGroup r12 = this.a;
        if (r12 != null) goto L46;
    L48:
        boolean r13 = false;
    L49:
        if (r13 == false) goto L51;
        X(false, Boolean.FALSE);
        return;
    L51:
        CustomActionBarAdapter r14 = this.s;
        if (r14 == null) goto L54;
        r0 = r14.getCurrentList();
    L54:
        List r2 = r0;
        if (r2 != null) goto L57;
    L58:
        r1 = true;
    L59:
        if (r1 == true) goto L66;
        X(true, Boolean.FALSE);
        return;
    L66:
        return;
    L57:
        if (r2.isEmpty() == false) goto L59;
    L46:
        if (ViewExtKt.h(r12) != true) goto L48;
        r13 = true;
        goto L49
    L22:
        if (this.j != null) goto L31;
        int r15 = ra9.a.a;
        ac8.i r16 = new ac8.i(0);
        AtomicReference r3 = ga9.a.a;
        ga9.e.a.getClass();
        int r17 = ((ac8.i) ga9.e.a(ga9.a.c("mobile_action_bar_plus_panel_visibility_by_mode", ga9.e.c(r16)), ac8.i.class, r16)).a();
        InstructionInputComponent r4 = this.i;
        if (r4 == null) goto L28;
        ReplyOption r5 = r4.Ql();
        if (r5 == null) goto L28;
        Object r18 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        int r19 = com.larus.bmhome.view.actionbar.custom.cache.e.c(r5);
    L29:
        this.j = Boolean.valueOf(ac8.a.a(r17, r19, 3, true));
    L28:
        r19 = AgentMode.UNKNOWN.getValue();
    L31:
        if (Intrinsics.areEqual(this.j, Boolean.TRUE) == false) goto L42;
        CustomActionBarAdapter r20 = this.s;
        if (r20 == null) goto L35;
        r0 = r20.getCurrentList();
    L35:
        List r21 = r0;
        if (r21 != null) goto L38;
    L39:
        r1 = true;
    L40:
        if (r1 == true) goto L62;
        X(true, Boolean.FALSE);
        return;
    L62:
        return;
    L38:
        if (r21.isEmpty() == false) goto L40;
    L42:
        X(false, Boolean.FALSE);
        return;
    L17:
        if (r10.sL() != true) goto L19;
        r11 = true;
    L13:
        r10 = null;
        goto L14
    }

    public final com.larus.bmhome.actionbar.model.z0 o(com.larus.bmhome.actionbar.model.z0 r18) {
        if (this.J == false) goto L16;
        com.larus.bmhome.actionbar.model.r r2 = r18.q;
        if (r2 == null) goto L12;
        Integer r3 = r2.a;
        if (r3 == null) goto L12;
        if (r3.intValue() != 11) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L18;
        return r18;
    L18:
        return com.larus.bmhome.actionbar.model.z0.a(r18, null, null, null, null, null, Integer.valueOf(ActionBarExecutionType.OPEN_BY_SCHEMA.getValue()), new com.larus.bmhome.actionbar.model.e0("//flow/create_digital_avatar", 2), null, null, null, null, null, false, -4161);
    L12:
        r4 = false;
        goto L13
    L16:
        return r18;
    }

    public final void t(final String r2) {
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        com.larus.utils.e1.o(r0);
    L5:
        RecyclerView r1 = this.r;
        if (r1 == null) goto L8;
        com.larus.utils.e1.o(r1);
    L8:
        wa8.n1 r3 = g();
        if (r3 == null) goto L13;
        View r4 = r3.getView();
        if (r4 == null) goto L13;
        com.larus.utils.e1.o(r4);
    L13:
        com.larus.bmhome.instruction.w1.a("CustomActionBar", new k0(r2));
    }

    public final boolean x(com.larus.bmhome.actionbar.model.z0 r5) {
        if (ws8.a.a(r5) == false) goto L14;
        GuideTipsDelegate r0 = GuideTipsDelegate.b;
        if (r0.c(r0.h(r5)) == true) goto L12;
        n r2 = this.E;
        Boolean r6 = r2.a.get(Integer.valueOf(r0.h(r5)));
        if (r6 == null) goto L9;
        boolean r7 = r6.booleanValue();
    L10:
        FLogger.a.d("ActionBarShowTipCache", r2.hashCode() + ",isTipTypeShow:" + r7);
        if (r7 == true) goto L12;
        return false;
    L9:
        r7 = false;
    L12:
        return true;
    L14:
        return false;
    }

    public static void z(String r16, String r17) {
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r0 = ICommerceMembershipService.a.a();
        String r1 = null;
        if (r0 == null) goto L5;
        uz8.c r2 = r0.z(r16);
    L6:
        ICommerceMembershipService r3 = ICommerceMembershipService.a.a();
        if (r3 == null) goto L31;
        if (r2 == null) goto L10;
        String r4 = r2.a;
    L12:
        if (com.larus.utils.o0.d(r4) == false) goto L16;
        if (r2 == null) goto L15;
        String r5 = r2.a;
    L18:
        if (r2 == null) goto L20;
        String r6 = r2.b;
    L21:
        if (r2 == null) goto L23;
        String r7 = r2.c;
    L24:
        if (r2 == null) goto L26;
        String r8 = r2.d;
    L27:
        if (r2 == null) goto L29;
        r1 = r2.f;
    L29:
        ICommerceMembershipService$b.b(r3, r5, "chat", r6, r7, r8, r1, r17, null, null, null, null, null, 3968);
        return;
    L26:
        r8 = null;
        goto L27
    L23:
        r7 = null;
        goto L24
    L20:
        r6 = null;
        goto L21
    L15:
        r5 = null;
        goto L18
    L16:
        r5 = "answer_mode";
        goto L18
    L10:
        r4 = null;
        goto L12
    L31:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean J(int r3, boolean r4) {
        if (r3 != 0) goto L20;
        if (r4 == true) goto L24;
        InstructionInputComponent r5 = this.i;
        xe8.a r6 = null;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Fragment r7 = com.larus.ui.arch.component.internal.attach.a.b(r5, r5);
    L11:
        if ((r7 instanceof xe8.a) == false) goto L13;
        r6 = (xe8.a) r7;
    L13:
        if (r6 == null) goto L21;
        ChatBubbleParams r8 = r6.Mz();
        if (r8 != null) goto L17;
        return false;
    L17:
        if (r8.b != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L9:
        r7 = null;
        goto L11
    L24:
        return false;
    L20:
        return false;
    }

    public final void U(com.larus.bmhome.chat.model.n r34, final List<com.larus.bmhome.actionbar.model.z0> r35) {
        if (d3.a.e() == false) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        FLogger.a.i("CustomActionBar", "skip instruction draft restore in sheet detail");
        return;
    L13:
        InstructionInputComponent r1 = this.i;
        Object r13 = null;
        if (r1 == null) goto L22;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if (r2 == null) goto L22;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L22;
        ChatPageContext r4 = r3.a(ChatPageContext.class);
        if (r4 == null) goto L22;
        String r5 = r4.getConversationMode();
    L23:
        if (r5 == null) goto L32;
        if (r34 == null) goto L26;
        String r6 = r34.c;
    L27:
        if (r6 == null) goto L32;
        if (Intrinsics.areEqual(r5, r34.c) == true) goto L32;
        FLogger.a.i("CustomActionBar", "skip stale instruction draft restore activeMode=" + r5 + " draftMode=" + r34.c);
        return;
    L26:
        r6 = null;
    L32:
        com.larus.bmhome.instruction.w1.a("CustomActionBar", new k1(r35));
        if (r34 == null) goto L35;
        ChatDraftItem r7 = r34.x();
    L36:
        if (r7 != null) goto L38;
    L40:
        boolean r8 = false;
    L41:
        if (r8 == false) goto L171;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L47
        ouc.v r10 = xt7.d.b;     // Catch: Throwable -> L47
        juc.c r11 = com.larus.bmhome.actionbar.model.r.Companion.serializer();     // Catch: Throwable -> L47
        String r12 = r7.getContent();     // Catch: Throwable -> L47
        if (r12 != null) goto L45;
        r12 = "";
    L45:
        Object r14 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) r10.c(r11, r12));     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r14) == false) goto L52;
        r14 = null;
    L52:
        com.larus.bmhome.actionbar.model.r r15 = (com.larus.bmhome.actionbar.model.r) r14;
        if (r15 == null) goto L57;
        Integer r16 = r15.a;
        if (r16 == null) goto L57;
        int r17 = r16.intValue();
    L58:
        FLogger.a.i("CustomActionBar", "tryOpenInstructionEditorByDraft, instructionType=" + r17);
        if (r17 == 0) goto L172;
        if (r15 == null) goto L64;
        com.larus.bmhome.actionbar.model.j1 r18 = r15.e;
        if (r18 == null) goto L64;
        Integer r19 = r18.j;
    L65:
        if (r19 == null) goto L112;
        Iterator<T> r20 = r35.iterator();
    L68:
        if (r20.hasNext() == false) goto L78;
        Object r21 = r20.next();
        Integer r22 = ((com.larus.bmhome.actionbar.model.z0) r21).g;
        int r23 = ActionBarExecutionType.GENERATE_PODCAST.getValue();
        if (r22 != null) goto L73;
    L75:
        boolean r24 = false;
    L76:
        if (r24 == false) goto L68;
    L79:
        com.larus.bmhome.actionbar.model.z0 r25 = (com.larus.bmhome.actionbar.model.z0) r21;
        if (r25 != null) goto L82;
        com.larus.bmhome.actionbar.model.z0 r26 = null;
    L128:
        if (r26 == null) goto L134;
        r(this, r26, r15, 3, null, null, null, 56);
        ActionBarShowFrom r27 = this.I;
        if (r27 == null) goto L132;
        String r28 = r27.getType();
    L133:
        Q(r26, "auto_show", r28, null, null, null, null, null);
        goto L134
    L132:
        r28 = null;
    L134:
        int r29 = od8.h0.a;
        if (od8.h0.f(Integer.valueOf(r17)) == false) goto L137;
    L138:
        Iterator r30 = r34.p.iterator();
    L140:
        if (r30.hasNext() == false) goto L145;
        Object r31 = r30.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r31).getType(), "nested_file") == false) goto L140;
        r13 = r31;
    L145:
        if (((ChatDraftItem) r13) == null) goto L174;
        InstructionInputComponent r32 = this.i;
        if (r32 == null) goto L175;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r33 = r32.f70();
        if (r33 == null) goto L151;
        r33.Pq(true);
    L151:
        bc8.a r36 = (bc8.a) r32.P.getValue();
        if (r36 == null) goto L176;
        r36.mX();
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L137:
        if (od8.h0.i(Integer.valueOf(r17)) == true) goto L138;
        return;
    L82:
        com.larus.bmhome.actionbar.model.b1 r37 = r25.w;
        if (r37 == null) goto L111;
        List r38 = r37.a;
        if (r38 == null) goto L111;
        Iterator r39 = r38.iterator();
    L88:
        if (r39.hasNext() == false) goto L96;
        Object r40 = r39.next();
        Integer r41 = ((com.larus.bmhome.actionbar.model.c1) r40).e;
        com.larus.bmhome.actionbar.model.j1 r42 = r15.e;
        if (r42 == null) goto L92;
        Integer r43 = r42.j;
    L94:
        if (Intrinsics.areEqual(r41, r43) == false) goto L88;
    L97:
        com.larus.bmhome.actionbar.model.c1 r44 = (com.larus.bmhome.actionbar.model.c1) r40;
        if (r44 == null) goto L111;
        String r45 = r25.b;
        Long r46 = r25.a;
        com.larus.bmhome.actionbar.model.h1 r47 = r44.g;
        CustomMenuJumpType r48 = CustomMenuJumpType.PARSE_LINK;
        com.larus.bmhome.actionbar.model.r r210 = new com.larus.bmhome.actionbar.model.r(25, null, r47, new com.larus.bmhome.actionbar.model.j1(Integer.valueOf(r48.getValue()), 16776703), null, null, null, null, 4074);
        com.larus.bmhome.actionbar.model.h1 r49 = r44.g;
        if (r49 == null) goto L103;
        String r211 = r49.f;
    L104:
        if (r49 == null) goto L106;
        com.larus.bmhome.actionbar.model.g1 r110 = r49.d;
    L107:
        if (r49 == null) goto L109;
        com.larus.bmhome.actionbar.model.g1 r111 = r49.e;
    L110:
        com.larus.bmhome.actionbar.model.z0 r50 = new com.larus.bmhome.actionbar.model.z0(r46, r45, r110, r111, r211, null, null, null, null, null, r210, null, false, MapsKt.mapOf(TuplesKt.to("generate_podcast_scene", String.valueOf(r48.getValue()))), null, -65568, 13);
    L127:
        r26 = r50;
        goto L128
    L109:
        r111 = null;
        goto L110
    L106:
        r110 = null;
        goto L107
    L103:
        r211 = null;
        goto L104
    L92:
        r43 = null;
        goto L94
    L96:
        r40 = null;
    L111:
        r50 = null;
        goto L127
    L73:
        if (r22.intValue() != r23) goto L75;
        r24 = true;
        goto L76
    L78:
        r21 = null;
        goto L79
    L112:
        Iterator<T> r51 = r35.iterator();
    L114:
        if (r51.hasNext() == false) goto L125;
        Object r52 = r51.next();
        com.larus.bmhome.actionbar.model.r r53 = ((com.larus.bmhome.actionbar.model.z0) r52).q;
        if (r53 == null) goto L118;
        Integer r54 = r53.a;
    L119:
        if (r15 == null) goto L121;
        Integer r55 = r15.a;
    L123:
        if (Intrinsics.areEqual(r54, r55) == false) goto L114;
    L126:
        r50 = (com.larus.bmhome.actionbar.model.z0) r52;
        goto L127
    L121:
        r55 = null;
        goto L123
    L118:
        r54 = null;
        goto L119
    L125:
        r52 = null;
    L64:
        r19 = null;
        goto L65
    L172:
        return;
    L57:
        r17 = 0;
    L47:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L171:
        return;
    L38:
        if (com.larus.bmhome.chat.model.z.a(r7) != true) goto L40;
        r8 = true;
        goto L41
    L35:
        r7 = null;
    L22:
        r5 = null;
        goto L23
    L5:
        if (b3.a.a() == true) goto L8;
        r0 = false;
        goto L10
    }

    public final void X(boolean r17, Boolean r18) {
        InstructionInputComponent r2 = this.i;
        ActionBarShowFrom r9 = null;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Fragment r3 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2);
        if (r3 == null) goto L9;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L9;
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r5 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) r4.getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
    L10:
        boolean r6 = false;
        boolean r7 = true;
        if (r5 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L18;
    L23:
        Function0<? extends Pair<Boolean, ? extends ActionBarShowFrom>> r10 = this.b0;
        if (r10 == null) goto L26;
        Pair r11 = (Pair) r10.invoke();
    L27:
        InstructionInputComponent r12 = this.i;
        if (r12 == null) goto L34;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Fragment r13 = com.larus.ui.arch.component.internal.attach.a.b(r12, r12);
        if (r13 == null) goto L34;
        t1a.b r14 = s1a.a.g(r13);
        if (r14 == null) goto L34;
        ICoreInputAbility r15 = (ICoreInputAbility) r14.getAbility(ICoreInputAbility.class);
    L35:
        InstructionInputComponent r16 = this.i;
        if (r16 == null) goto L42;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Fragment r19 = com.larus.ui.arch.component.internal.attach.a.b(r16, r16);
        if (r19 == null) goto L42;
        t1a.b r20 = s1a.a.g(r19);
        if (r20 == null) goto L42;
        va8.o r21 = (va8.o) r20.getAbility(va8.o.class);
    L43:
        InstructionInputComponent r22 = this.i;
        if (r22 == null) goto L50;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Fragment r23 = com.larus.ui.arch.component.internal.attach.a.b(r22, r22);
        if (r23 == null) goto L50;
        t1a.b r24 = s1a.a.g(r23);
        if (r24 == null) goto L50;
        com.larus.bmhome.chat.component.bottom.voice.a r25 = (com.larus.bmhome.chat.component.bottom.voice.a) r24.getAbility(com.larus.bmhome.chat.component.bottom.voice.a.class);
    L51:
        InstructionInputComponent r110 = this.i;
        if (r110 == null) goto L62;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Fragment r111 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110);
        if (r111 == null) goto L62;
        t1a.b r112 = s1a.a.g(r111);
        if (r112 == null) goto L62;
        va8.f0 r113 = r112.getAbility(va8.f0.class);
        if (r113 == null) goto L62;
        if (r113.R() != true) goto L62;
        boolean r114 = true;
    L63:
        if (r114 == false) goto L77;
        InstructionInputComponent r115 = this.i;
        if (r115 == null) goto L75;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        Fragment r116 = com.larus.ui.arch.component.internal.attach.a.b(r115, r115);
        if (r116 == null) goto L75;
        t1a.b r117 = s1a.a.g(r116);
        if (r117 == null) goto L75;
        va8.g0 r118 = r117.getAbility(va8.g0.class);
        if (r118 == null) goto L75;
        if (r118.E2() != true) goto L75;
        boolean r119 = true;
    L76:
        if (r119 == true) goto L77;
    L91:
        boolean r120 = false;
    L92:
        if (r11 == null) goto L94;
        boolean r121 = ((Boolean) r11.getFirst()).booleanValue();
    L95:
        FLogger r122 = FLogger.a;
        StringBuilder r123 = new StringBuilder("updateCoordinatorShowImpl, show(");
        r123.append(r17);
        r123.append("), canShow(");
        r123.append(r121);
        r123.append("), from(");
        if (r11 == null) goto L98;
        ActionBarShowFrom r124 = (ActionBarShowFrom) r11.getSecond();
    L99:
        r123.append(r124);
        r123.append(", isRemote = ");
        r123.append(r18);
        r123.append(')');
        r122.i("CustomActionBar", r123.toString());
        if (r25 != null) goto L102;
    L104:
        boolean r26 = false;
    L105:
        if (r26 == true) goto L107;
    L109:
        boolean r27 = false;
    L111:
        if (this.U <= 0) goto L113;
        boolean r125 = true;
    L114:
        if (r125 == false) goto L116;
    L119:
        boolean r126 = true;
    L121:
        if (r120 == false) goto L166;
        RecyclerView r1 = this.r;
        if (r1 != null) goto L125;
    L127:
        boolean r28 = false;
    L128:
        if (r28 == false) goto L166;
        if (r17 == false) goto L166;
        if (r121 == false) goto L166;
        if (r126 == false) goto L166;
        if (r27 == true) goto L166;
        InstructionInputComponent r29 = this.i;
        if (r29 == null) goto L144;
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Fragment r30 = com.larus.ui.arch.component.internal.attach.a.b(r29, r29);
        if (r30 == null) goto L144;
        t1a.b r31 = s1a.a.g(r30);
        if (r31 == null) goto L144;
        u7 r32 = r31.getAbility(u7.class);
        if (r32 == null) goto L144;
        if (r32.Hl() != true) goto L144;
        r6 = true;
    L144:
        if (r6 == false) goto L163;
        RecyclerView r33 = this.r;
        if (r33 == null) goto L148;
        com.larus.utils.e1.x(r33);
    L148:
        InstructionInputComponent r34 = this.i;
        if (r34 == null) goto L159;
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Fragment r35 = com.larus.ui.arch.component.internal.attach.a.b(r34, r34);
        if (r35 == null) goto L159;
        t1a.b r36 = s1a.a.g(r35);
        if (r36 == null) goto L159;
        com.larus.bmhome.double_post.drag_panel.l0 r37 = r36.getAbility(com.larus.bmhome.double_post.drag_panel.l0.class);
        if (r37 == null) goto L159;
        Boolean r38 = r37.YN();
        if (r38 == null) goto L159;
        r7 = r38.booleanValue();
    L159:
        if (r7 == false) goto L161;
        H("isChatAwemeFeedImmerseMode intercept show");
        return;
    L161:
        G("isChatAwemeFeedImmerseMode intercept gone");
        return;
    L163:
        H("updateCoordinatorShowImpl");
        RecyclerView r39 = this.r;
        if (r39 == null) goto L218;
        com.larus.utils.e1.x(r39);
    L218:
        if (r11 == null) goto L220;
        r9 = (ActionBarShowFrom) r11.getSecond();
    L220:
        if (r9 == null) goto L226;
        this.I = r9;
        return;
    L226:
        return;
    L125:
        if (ViewExtKt.h(r1) == true) goto L127;
        r28 = true;
    L166:
        Boolean r40 = this.k;
        if (r40 == null) goto L169;
        boolean r41 = r40.booleanValue();
    L175:
        if (r41 == false) goto L194;
        if (r121 == false) goto L194;
        if (r15 != null) goto L179;
    L181:
        boolean r42 = false;
    L182:
        if (r42 == true) goto L194;
        if (r21 != null) goto L185;
    L187:
        if (r6 == false) goto L194;
        if (r126 == false) goto L194;
        if (r120 == false) goto L194;
        H("updateCoordinatorShowImpl actionBarAlwaysOnTop");
        RecyclerView r43 = this.r;
        if (r43 == null) goto L218;
        com.larus.utils.e1.x(r43);
        goto L218
    L185:
        if (r21.n5() != true) goto L187;
        r6 = true;
        goto L187
    L179:
        if (r15.Rp() != 4) goto L181;
        r42 = true;
    L194:
        if (this.V == false) goto L200;
        if (r120 == false) goto L200;
        if (r126 == false) goto L200;
        H("updateCoordinatorShowImpl fromRefresh");
        RecyclerView r44 = this.r;
        if (r44 == null) goto L218;
        com.larus.utils.e1.x(r44);
    L200:
        IObricChatUIService r45 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r45 == null) goto L215;
        RecyclerView r46 = this.r;
        if (r46 == null) goto L205;
        Boolean r47 = Boolean.valueOf(ViewExtKt.h(r46));
    L206:
        Boolean r48 = Boolean.valueOf(r45.q(r120, r47, r17, r121, r126, ce8.c.a(), r27));
        if (r48.booleanValue() == true) goto L210;
        r48 = null;
    L210:
        if (r48 == null) goto L215;
        r48.booleanValue();
        H("updateCoordinatorShowImpl");
        RecyclerView r49 = this.r;
        if (r49 == null) goto L225;
        com.larus.utils.e1.x(r49);
        return;
    L225:
        return;
    L205:
        r47 = null;
    L215:
        G("updateCoordinatorShowImpl");
        RecyclerView r50 = this.r;
        if (r50 == null) goto L218;
        com.larus.utils.e1.o(r50);
        goto L218
    L169:
        InstructionInputComponent r51 = this.i;
        if (r51 != null) goto L172;
    L174:
        r41 = false;
        goto L175
    L172:
        if (r51.eB() != true) goto L174;
        r41 = true;
        goto L175
    L116:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == true) goto L119;
        r126 = false;
        goto L121
    L113:
        r125 = false;
        goto L114
    L107:
        if (com.larus.bmhome.utils.i.f(this.m) == true) goto L109;
        r27 = true;
        goto L111
    L102:
        if (r25.DG() != true) goto L104;
        r26 = true;
        goto L105
    L98:
        r124 = null;
        goto L99
    L94:
        r121 = true;
    L75:
        r119 = false;
    L77:
        InstructionInputComponent r127 = this.i;
        if (r127 == null) goto L88;
        Intrinsics.checkNotNullParameter(r127, "<this>");
        Fragment r128 = com.larus.ui.arch.component.internal.attach.a.b(r127, r127);
        if (r128 == null) goto L88;
        t1a.b r129 = s1a.a.g(r128);
        if (r129 == null) goto L88;
        ew8.a r130 = r129.getAbility(ew8.a.class);
        if (r130 == null) goto L88;
        if (r130.E2() == true) goto L88;
        boolean r131 = true;
    L89:
        if (r131 == true) goto L91;
        r120 = true;
    L88:
        r131 = false;
    L62:
        r114 = false;
    L50:
        r25 = null;
    L42:
        r21 = null;
    L34:
        r15 = null;
        goto L35
    L26:
        r11 = null;
        goto L27
    L18:
        if (Intrinsics.areEqual(this.j, Boolean.FALSE) == false) goto L23;
        G("updateCoordinatorShowImpl plus panel latch false");
        RecyclerView r52 = this.r;
        if (r52 == null) goto L223;
        com.larus.utils.e1.o(r52);
        return;
    L223:
        return;
    L13:
        if (r5.sL() != true) goto L15;
        r8 = true;
    L9:
        r5 = null;
        goto L10
    }

    public final void c(ModelItemIdentity r7, Function1<? super Boolean, Unit> r8) {
        InstructionInputComponent r0 = this.i;
        Object r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.z0 r2 = r0.un(ActiveSwitchType.DEEPTHINK, null);
    L6:
        boolean r3 = false;
        if (r2 == null) goto L16;
        com.larus.bmhome.actionbar.model.p0 r4 = r2.o;
        if (r4 == null) goto L16;
        Integer r5 = r4.a;
        int r6 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r5 == null) goto L16;
        if (r5.intValue() != r6) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L54;
        if (r7 != null) goto L23;
        InstructionInputComponent r10 = this.i;
        if (r10 == null) goto L22;
        r7 = r10.Fe(r2).getModel();
        goto L23
    L22:
        r7 = null;
    L23:
        com.larus.bmhome.actionbar.model.p0 r11 = r2.o;
        if (r11 == null) goto L28;
        com.larus.bmhome.actionbar.model.a2 r12 = r11.d();
        if (r12 == null) goto L28;
        ArrayList r13 = r12.a;
    L29:
        if (r13 != null) goto L31;
    L34:
        boolean r14 = true;
    L35:
        if (r14 == true) goto L37;
        Iterator r15 = r13.iterator();
    L43:
        if (r15.hasNext() == false) goto L47;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.b2) r16).b(), r7) == false) goto L43;
        r1 = r16;
    L47:
        if (r1 == null) goto L49;
    L48:
        r3 = true;
    L49:
        r8.invoke(Boolean.valueOf(r3));
        return;
    L37:
        if (Intrinsics.areEqual(r7, wa8.t0.a) == true) goto L48;
        if (Intrinsics.areEqual(r7, wa8.t0.b) == false) goto L49;
    L31:
        if (r13.isEmpty() == true) goto L34;
        r14 = false;
    L28:
        r13 = null;
        goto L29
    L54:
        return;
    L16:
        r9 = false;
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public final void h(View r2, View r3) {
        if (r2 != null) goto L4;
    L6:
        com.larus.bmhome.view.screenmenu.d r4 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r3);
        return;
    L4:
        if (m() == false) goto L6;
        com.larus.bmhome.view.screenmenu.d r5 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r2);
    }

    public static int p(View r2, View r3, int r4) {
        int r5 = w(r3);
        if (r5 > 0) goto L5;
    L12:
        return r4;
    L5:
        if (r2.getWidth() <= 0) goto L12;
        int r1 = 1;
        if (r2.getResources().getConfiguration().getLayoutDirection() != 1) goto L11;
        r1 = -1;
    L11:
        return r1 * (((r2.getMeasuredWidth() / 2) - (r5 / 2)) + r4);
    }

    public final void E(boolean r18, boolean r19, Function0<Unit> r20) {
        List<com.larus.bmhome.actionbar.model.z0> r2 = this.T;
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        InstructionInputComponent r3 = this.i;
        if (r3 == null) goto L10;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Fragment r4 = com.larus.ui.arch.component.internal.attach.a.b(r3, r3);
        if (r4 == null) goto L10;
        Context r5 = r4.getContext();
    L11:
        InstructionInputComponent r6 = this.i;
        if (r6 == null) goto L16;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Fragment r7 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6);
        if (r7 == null) goto L16;
        t1a.b r8 = s1a.a.g(r7);
    L17:
        wc9.e r9 = this.m;
        BotModel r10 = this.n;
        if (r8 == null) goto L22;
        va8.r r11 = r8.getAbility(va8.r.class);
        if (r11 == null) goto L22;
        String r12 = r11.WE();
    L23:
        boolean r13 = Intrinsics.areEqual(r12, "doc_ai_edit");
        ChatParam r14 = this.h;
        if (r14 == null) goto L27;
        String r15 = r14.e;
        if (r15 == null) goto L27;
    L39:
        if (Intrinsics.areEqual(r15, "default") == false) goto L41;
    L42:
        if (r13 == true) goto L44;
        boolean r16 = true;
    L45:
        if (r16 == true) goto L52;
        if (r5 == null) goto L51;
        if (r8 == null) goto L51;
        if (r10 == null) goto L51;
        if (r9 != null) goto L52;
    L51:
        boolean r17 = false;
    L53:
        if (r19 == false) goto L70;
        boolean r110 = this.y;
        this.y = true;
        if (r17 == true) goto L383;
    L57:
        CopyOnWriteArraySet<rs8.f> r111 = s1.a;     // Catch: Throwable -> L67
        ChatParam r112 = this.h;     // Catch: Throwable -> L67
        if (r112 == null) goto L60;
        String r113 = r112.e;     // Catch: Throwable -> L67
    L61:
        Intrinsics.checkNotNullParameter(r2, "itemList");     // Catch: Throwable -> L67
        Iterator<rs8.f> r114 = s1.a.iterator();     // Catch: Throwable -> L67
    L62:
        if (r114.hasNext() == false) goto L66;
        r114.next().t1(r2, r9, r10, r113);     // Catch: Throwable -> L67
        goto L62
    L66:
        this.y = r110;
    L67:
        th = move-exception;
        this.y = r110;
        throw th;
    L60:
        r113 = null;
        goto L61
    L383:
        c(null, new j1(this));     // Catch: Throwable -> L67
    L70:
        if (r16 == false) goto L259;
        CopyOnWriteArrayList<ss8.e> r21 = this.Q;
        if (r21 == null) goto L74;
        CollectionsKt.removeAll(r21, new y());
    L74:
        CopyOnWriteArrayList<ss8.e> r22 = this.Q;
        if (r22 == null) goto L77;
        r22.addAll(this.R);
    L77:
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("DEFAULT branch entered. customSegmentFactory size=");
        CopyOnWriteArrayList<ss8.e> r115 = this.Q;
        if (r115 == null) goto L80;
        Integer r116 = Integer.valueOf(r115.size());
    L81:
        r24.append(r116);
        r24.append(", customSegmentFactoryEx size=");
        r24.append(this.R.size());
        r23.i("CustomActionBar", r24.toString());
        StringBuilder r25 = new StringBuilder("customSegmentFactoryEx classes: ");
        List<? extends ss8.e> r117 = this.R;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r26 = r117.iterator();
    L83:
        if (r26.hasNext() == false) goto L85;
        r118.add(((ss8.e) r26.next()).getClass().getSimpleName());
        goto L83
    L85:
        r25.append(r118);
        r23.i("CustomActionBar", r25.toString());
        FLogger r27 = FLogger.a;
        StringBuilder r28 = new StringBuilder("customSegmentFactory classes: ");
        CopyOnWriteArrayList<ss8.e> r29 = this.Q;
        if (r29 == null) goto L91;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator<ss8.e> r30 = r29.iterator();
    L89:
        if (r30.hasNext() == false) goto L92;
        r119.add(r30.next().getClass().getSimpleName());
    L92:
        r28.append(r119);
        r27.i("CustomActionBar", r28.toString());
        ArrayList r31 = new ArrayList();
        CopyOnWriteArrayList<ss8.e> r32 = this.Q;
        if (r32 == null) goto L114;
        ArrayList r33 = new ArrayList();
        Iterator<ss8.e> r34 = r32.iterator();
    L96:
        if (r34.hasNext() == false) goto L100;
        ss8.e r120 = r34.next();
        if ((r120 instanceof IActionBarSegmentV2) == false) goto L96;
        r33.add(r120);
        goto L96
    L100:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r33.iterator();
    L102:
        if (r36.hasNext() == false) goto L111;
        Object r121 = r36.next();
        IActionBarSegmentV2 r122 = (IActionBarSegmentV2) r121;
        if (this.R.contains(r122) == false) goto L106;
    L108:
        boolean r123 = false;
    L109:
        if (r123 == false) goto L102;
        r35.add(r121);
        goto L102
    L106:
        if (r122.isEnabled() == false) goto L108;
        r123 = true;
        goto L109
    L111:
        List r37 = CollectionsKt.sortedWith(r35, new f());
        if (r37 == null) goto L114;
    L115:
        FLogger r38 = FLogger.a;
        StringBuilder r124 = new StringBuilder("v2Segments found: ");
        r124.append(r37.size());
        r124.append(", ids=");
        List r39 = r37;
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
        Iterator r126 = r39.iterator();
    L117:
        if (r126.hasNext() == false) goto L119;
        IActionBarSegmentV2 r127 = (IActionBarSegmentV2) r126.next();
        r125.add(r127.c() + "(pos=" + r127.getPosition() + ')');
        goto L117
    L119:
        r124.append(r125);
        r38.i("CustomActionBar", r124.toString());
        ArrayList r40 = new ArrayList();
        Iterator r128 = r39.iterator();
    L121:
        if (r128.hasNext() == false) goto L128;
        Object r129 = r128.next();
        if (((IActionBarSegmentV2) r129).getPosition() != IActionBarSegmentV2.Position.BEFORE_DEFAULT) goto L125;
        boolean r130 = true;
    L126:
        if (r130 == false) goto L121;
        r40.add(r129);
        goto L121
    L125:
        r130 = false;
        goto L126
    L128:
        Iterator r41 = r40.iterator();
    L130:
        if (r41.hasNext() == false) goto L136;
        IActionBarSegmentV2 r131 = (IActionBarSegmentV2) r41.next();
        if (r10 == null) goto L130;
        if (r9 == null) goto L130;
        FLogger.a.i("CustomActionBar", "DEFAULT branch: BEFORE_DEFAULT segment=" + r131.c());
        r31.addAll(r131.b(r10, r9));
        goto L130
    L136:
        Iterator<T> r42 = this.R.iterator();
    L138:
        if (r42.hasNext() == false) goto L146;
        ss8.e r132 = (ss8.e) r42.next();
        if (r10 == null) goto L138;
        if (r9 == null) goto L138;
        CopyOnWriteArraySet<rs8.f> r133 = s1.a;
        Intrinsics.checkNotNullParameter(r132, "segment");
        if (ObricActionBarSendServiceDelegate.b.b(r132) == false) goto L138;
        r31.addAll(r132.b(r10, r9));
        goto L138
    L146:
        r31.addAll(r2);
        FLogger.a.i("CustomActionBar", "After default+remote, list size=" + r31.size());
        ArrayList r43 = new ArrayList();
        Iterator r44 = r39.iterator();
    L148:
        if (r44.hasNext() == false) goto L155;
        Object r45 = r44.next();
        if (((IActionBarSegmentV2) r45).getPosition() != IActionBarSegmentV2.Position.AFTER_DEFAULT) goto L152;
        boolean r134 = true;
    L153:
        if (r134 == false) goto L148;
        r43.add(r45);
        goto L148
    L152:
        r134 = false;
        goto L153
    L155:
        Iterator r46 = r43.iterator();
    L157:
        if (r46.hasNext() == false) goto L163;
        IActionBarSegmentV2 r47 = (IActionBarSegmentV2) r46.next();
        if (r10 == null) goto L157;
        if (r9 == null) goto L157;
        FLogger.a.i("CustomActionBar", "DEFAULT branch: AFTER_DEFAULT segment=" + r47.c());
        r31.addAll(r47.b(r10, r9));
        goto L157
    L163:
        Iterator<T> r48 = this.R.iterator();
    L165:
        if (r48.hasNext() == false) goto L173;
        ss8.e r49 = (ss8.e) r48.next();
        if (r10 == null) goto L165;
        if (r9 == null) goto L165;
        CopyOnWriteArraySet<rs8.f> r50 = s1.a;
        Intrinsics.checkNotNullParameter(r49, "segment");
        if (ObricActionBarSendServiceDelegate.b.b(r49) == true) goto L165;
        r31.addAll(r49.b(r10, r9));
        goto L165
    L173:
        FLogger r51 = FLogger.a;
        StringBuilder r52 = new StringBuilder("Final list size=");
        r52.append(r31.size());
        r52.append(", first5Keys=");
        List r53 = CollectionsKt.take(r31, 5);
        ArrayList r54 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));
        Iterator r55 = r53.iterator();
    L175:
        if (r55.hasNext() == false) goto L177;
        r54.add(((com.larus.bmhome.actionbar.model.z0) r55.next()).b);
        goto L175
    L177:
        r52.append(r54);
        r52.append(", last3Keys=");
        List r56 = CollectionsKt.takeLast(r31, 3);
        ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r56, 10));
        Iterator r58 = r56.iterator();
    L179:
        if (r58.hasNext() == false) goto L181;
        r57.add(((com.larus.bmhome.actionbar.model.z0) r58.next()).b);
        goto L179
    L181:
        r52.append(r57);
        r51.i("CustomActionBar", r52.toString());
        InstructionInputComponent r59 = this.i;
        if (r59 == null) goto L186;
        Intrinsics.checkNotNullParameter(r59, "<this>");
        Fragment r60 = com.larus.ui.arch.component.internal.attach.a.b(r59, r59);
        if (r60 == null) goto L186;
        FragmentActivity r61 = r60.getActivity();
    L187:
        IObricChatUIService r62 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r62 != null) goto L190;
    L192:
        boolean r63 = false;
    L193:
        if (r63 == false) goto L282;
        Set r64 = r62.P(r61);
        if (r64 == null) goto L197;
        FLogger.a.i("CustomActionBar", "itemConfig: " + r64);
        Set r65 = CollectionsKt.toMutableSet(r64);
    L198:
        if (r65 != null) goto L200;
    L202:
        boolean r66 = false;
    L203:
        if (r66 == false) goto L228;
        InstructionInputComponent r67 = this.i;
        if (r67 == null) goto L211;
        Intrinsics.checkNotNullParameter(r67, "<this>");
        Fragment r68 = com.larus.ui.arch.component.internal.attach.a.b(r67, r67);
        if (r68 == null) goto L211;
        t1a.b r69 = s1a.a.g(r68);
        if (r69 == null) goto L211;
        be8.a r70 = (be8.a) r69.getAbility(be8.a.class);
    L212:
        if (r70 == null) goto L218;
        be8.c r71 = r70.YF();
        if (r71 == null) goto L218;
        List r72 = r71.b;
        if (r72 == null) goto L218;
        int r73 = r72.size();
    L219:
        int r74 = 0;
    L220:
        if (r74 >= r73) goto L222;
        r65.add(String.valueOf(((long) r74) - 92100));
        r74 = r74 + 1;
        goto L220
    L222:
        Iterator r75 = r31.iterator();
    L224:
        if (r75.hasNext() == false) goto L228;
        com.larus.bmhome.actionbar.model.z0 r76 = (com.larus.bmhome.actionbar.model.z0) r75.next();
        int r77 = be8.g.a;
        if (be8.g.a(r76.b) == false) goto L224;
        r65.add(String.valueOf(r76.a));
    L218:
        r73 = 0;
    L211:
        r70 = null;
    L228:
        Iterator r78 = r31.iterator();
    L230:
        if (r78.hasNext() == false) goto L242;
        Object r79 = r78.next();
        com.larus.bmhome.actionbar.model.p0 r80 = ((com.larus.bmhome.actionbar.model.z0) r79).o;
        if (r80 == null) goto L239;
        Integer r81 = r80.a;
        int r82 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r81 == null) goto L239;
        if (r81.intValue() != r82) goto L239;
        boolean r83 = true;
    L240:
        if (r83 == false) goto L230;
    L243:
        com.larus.bmhome.actionbar.model.z0 r84 = (com.larus.bmhome.actionbar.model.z0) r79;
        if (r65 == null) goto L282;
        ObricTaskSkillDelegate r85 = ObricTaskSkillDelegate.b;
        if (r84 == null) goto L251;
        InstructionInputComponent r86 = this.i;
        if (r86 == null) goto L251;
        ModelItemIdentity r87 = r86.Fe(r84).getModel();
    L252:
        r85.k(r65, r87);
        ArrayList r88 = new ArrayList();
        Iterator r89 = r31.iterator();
    L254:
        if (r89.hasNext() == false) goto L258;
        Object r90 = r89.next();
        if (r65.contains(String.valueOf(((com.larus.bmhome.actionbar.model.z0) r90).a)) == false) goto L254;
        r88.add(r90);
        goto L254
    L258:
        r31 = r88;
    L251:
        r87 = null;
    L239:
        r83 = false;
        goto L240
    L242:
        r79 = null;
        goto L243
    L200:
        if (r65.contains("-92001") != true) goto L202;
        r66 = true;
        goto L203
    L197:
        r65 = null;
    L282:
        if (r8 == null) goto L288;
        be8.a r91 = r8.getAbility(be8.a.class);
        if (r91 == null) goto L288;
        MutableLiveData r92 = r91.Zo();
        if (r92 == null) goto L288;
        boolean r93 = Intrinsics.areEqual(r92.getValue(), Boolean.TRUE);
    L289:
        this.D = r93;
        if (r8 == null) goto L296;
        be8.a r94 = r8.getAbility(be8.a.class);
        if (r94 == null) goto L296;
        if (r94.YD() != true) goto L296;
        boolean r95 = true;
    L297:
        if (r95 == true) goto L299;
    L301:
        boolean r96 = false;
    L302:
        this.C = r96;
        Object r97 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        FLogger.a.d("ActionBarMenuSwitchHelper", "set localPcModeLocked: " + r96);
        if (r96 == com.larus.bmhome.view.actionbar.custom.cache.e.e) goto L306;
        com.larus.bmhome.view.actionbar.custom.cache.e.e = r96;
    L306:
        CopyOnWriteArrayList<IActionBarFilter> r98 = com.larus.bmhome.view.actionbar.api.a.a;
        List<com.larus.bmhome.actionbar.model.z0> r99 = T(r31);
        ss8.d r100 = new ss8.d(this.D, MapsKt.mapOf(TuplesKt.to("action_bar_scope_id", this.b)), 15);
        Intrinsics.checkNotNullParameter(r99, "items");
        Intrinsics.checkNotNullParameter(r100, "context");
        ArrayList r101 = new ArrayList();
        Set r102 = ServiceManager.get().getServices(IActionBarFilterProvider.class, true);     // Catch: Exception -> L314
        if (r102 == null) goto L315;
        Iterator r103 = r102.iterator();     // Catch: Exception -> L314
    L311:
        if (r103.hasNext() == false) goto L315;
        r101.addAll(((IActionBarFilterProvider) r103.next()).a());     // Catch: Exception -> L314
    L315:
        r101.addAll(com.larus.bmhome.view.actionbar.api.a.a);
        List r104 = CollectionsKt.sortedWith(r101, new ss8.c());
        if (r104.isEmpty() == true) goto L372;
        List r105 = r104;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L320:
        if (r107.hasNext() == false) goto L327;
        Object r108 = r107.next();
        if (((IActionBarFilter) r108).getMode() != IActionBarFilter.FilterMode.BLACKLIST) goto L324;
        boolean r109 = true;
    L325:
        if (r109 == false) goto L320;
        r106.add(r108);
        goto L320
    L324:
        r109 = false;
        goto L325
    L327:
        ArrayList r135 = new ArrayList();
        Iterator r136 = r105.iterator();
    L329:
        if (r136.hasNext() == false) goto L337;
        Object r137 = r136.next();
        if (((IActionBarFilter) r137).getMode() != IActionBarFilter.FilterMode.WHITELIST) goto L333;
        boolean r138 = true;
    L334:
        if (r138 == false) goto L329;
        r135.add(r137);
        goto L329
    L333:
        r138 = false;
        goto L334
    L337:
        if ((!r135.isEmpty()) == false) goto L355;
        ArrayList r139 = new ArrayList();
        Iterator r140 = r99.iterator();
    L340:
        if (r140.hasNext() == false) goto L353;
        Object r141 = r140.next();
        com.larus.bmhome.actionbar.model.z0 r142 = (com.larus.bmhome.actionbar.model.z0) r141;
        if (r135.isEmpty() == true) goto L350;
        Iterator r143 = r135.iterator();
    L346:
        if (r143.hasNext() == false) goto L350;
        if ((!((IActionBarFilter) r143.next()).a(r142, r100)) == false) goto L346;
        boolean r144 = true;
    L351:
        if (r144 == false) goto L340;
        r139.add(r141);
    L350:
        r144 = false;
        goto L351
    L353:
        r99 = r139;
    L355:
        if ((!r106.isEmpty()) == false) goto L372;
        ArrayList r145 = new ArrayList();
        Iterator r146 = r99.iterator();
    L358:
        if (r146.hasNext() == false) goto L371;
        Object r147 = r146.next();
        com.larus.bmhome.actionbar.model.z0 r148 = (com.larus.bmhome.actionbar.model.z0) r147;
        if (r106.isEmpty() == true) goto L368;
        Iterator r149 = r106.iterator();
    L364:
        if (r149.hasNext() == false) goto L368;
        if (((IActionBarFilter) r149.next()).a(r148, r100) == false) goto L364;
        boolean r150 = false;
    L369:
        if (r150 == false) goto L358;
        r145.add(r147);
    L368:
        r150 = true;
        goto L369
    L371:
        r99 = r145;
    L372:
        List<com.larus.bmhome.actionbar.model.z0> r151 = i(r99);
        IObricChatUIService r152 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r152 == null) goto L379;
        List<com.larus.bmhome.actionbar.model.z0> r153 = r152.l(r151);
        if (r153 == null) goto L379;
        r151 = r153;
    L379:
        P(r151, r18, r19, r20);
        if ((!r151.isEmpty()) == false) goto L499;
        X(true, Boolean.TRUE);
        return;
    L499:
        return;
    L299:
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L301;
        r96 = true;
    L296:
        r95 = false;
    L288:
        r93 = false;
        goto L289
    L190:
        if (r62.s(r61) != true) goto L192;
        r63 = true;
    L186:
        r61 = null;
    L114:
        r37 = CollectionsKt.emptyList();
        goto L115
    L91:
        r119 = null;
        goto L92
    L80:
        r116 = null;
        goto L81
    L259:
        if (r5 == null) goto L496;
        if (r8 == null) goto L497;
        if (r10 == null) goto L498;
        if (r9 == null) goto L500;
        r31 = new ArrayList();
        CopyOnWriteArrayList<ss8.e> r154 = this.Q;
        if (r154 == null) goto L271;
        Iterator<ss8.e> r155 = r154.iterator();
    L268:
        if (r155.hasNext() == false) goto L270;
        r31.addAll(r155.next().b(r10, r9));
        goto L268
    L270:
        Unit r156 = Unit.INSTANCE;
    L271:
        Iterator r157 = r31.iterator();
    L273:
        if (r157.hasNext() == false) goto L275;
        ((com.larus.bmhome.actionbar.model.z0) r157.next()).C = true;
        goto L273
    L275:
        ArrayList r158 = new ArrayList();
        Iterator<T> r159 = r2.iterator();
    L277:
        if (r159.hasNext() == false) goto L281;
        Object r160 = r159.next();
        if ((!((com.larus.bmhome.actionbar.model.z0) r160).C) == false) goto L277;
        r158.add(r160);
        goto L277
    L281:
        r31.addAll(r158);
        goto L282
    L500:
        return;
    L498:
        return;
    L497:
        return;
    L496:
        return;
    L52:
        r17 = true;
    L44:
        r16 = false;
        goto L45
    L41:
        if (Intrinsics.areEqual(r15, "default_new") == false) goto L44;
    L27:
        ChatControlTrace r161 = ChatControlTrace.b;
        if (r9 == null) goto L30;
        Integer r162 = r9.v;
    L31:
        if (r10 == null) goto L33;
        Integer r163 = r10.getBotType();
    L34:
        if (r10 == null) goto L36;
        boolean r164 = ce8.a.a(r10);
    L37:
        r15 = r161.g(r162, r163, r164);
        goto L39
    L36:
        r164 = false;
        goto L37
    L33:
        r163 = null;
        goto L34
    L30:
        r162 = null;
    L22:
        r12 = null;
    L16:
        r8 = null;
    L10:
        r5 = null;
        goto L11
    }

    public final Balloon f(View r13, View r14, Function0<Unit> r15) {
        ViewGroup r0 = this.a;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (ViewExtKt.h(r0) != true) goto L7;
    L9:
        if (nda.d.a().la() == true) goto L15;
        if (r2 == false) goto L14;
        return com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r13, r14, false, null, null, null, r15, 56);
    L14:
        return e(this, r13, r14, r15, 4);
    L15:
        if (r2 == false) goto L17;
        final boolean r5 = false;
    L19:
        return com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r13, r14, r5, null, new d1(r5), null, r15, 40);
    L17:
        r5 = nda.d.a().sa();
    L7:
        r2 = false;
        goto L9
    }

    public final int k(View r5, View r6, View r7) {
        int r0 = w(r7);
        if (r0 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (r5.getWidth() <= 0) goto L9;
        int[] r3 = new int[2];
        r5.getLocationOnScreen(r3);
        return j(r3[0] + (r5.getWidth() / 2), r6, r7, r0);
    }

    public final int l(View r4, View r5, boolean r6) {
        if (r6 == true) goto L5;
        return 0;
    L5:
        int r7 = w(r5);
        if (r7 > 0) goto L8;
    L12:
        return 0;
    L8:
        if (r4.getWidth() <= 0) goto L12;
        int[] r2 = new int[2];
        r4.getLocationOnScreen(r2);
        return j(r2[0] + (r4.getWidth() / 2), r4, r5, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void F(CustomActionBar r1, boolean r2, Function0 r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r1.E(r2, false, r3);
    }

    public static void O(CustomActionBar r6, List r7, m0 r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        boolean r0 = true;
    L6:
        String r2 = null;
        if ((r9 & 4) == 0) goto L9;
        r8 = null;
    L9:
        r6.T = r7;
        CopyOnWriteArraySet<rs8.f> r10 = s1.a;
        wc9.e r11 = r6.m;
        BotModel r3 = r6.n;
        ChatParam r4 = r6.h;
        if (r4 == null) goto L12;
        r2 = r4.e;
    L12:
        Intrinsics.checkNotNullParameter(r7, "itemList");
        Iterator<rs8.f> r5 = s1.a.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        r5.next().R0(r7, r11, r3, r2);
        goto L14
    L16:
        Object r12 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        com.larus.bmhome.view.actionbar.custom.cache.e.j(r7);
        r6.E(r0, true, r8);
        InstructionInputComponent r13 = r6.i;
        if (r13 == null) goto L21;
        Intrinsics.checkNotNullParameter(r7, "config");
        r13.V0.postValue(r7);
        return;
    L21:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ void R(CustomActionBar r9, com.larus.bmhome.actionbar.model.z0 r10, String r11, String r12) {
        r9.Q(r10, r11, r12, null, null, null, null, null);
    }

    public static final void u(CustomActionBar r4, BaseContentWidget r5, com.larus.bmhome.chat.model.n r6, List<com.larus.bmhome.actionbar.model.z0> r7) {
        FLogger.a.i("CustomActionBar", "initBar, actionBarCofList form Local v2, size=" + r7.size() + ", initInstructionType=" + r4.A);
        String r1 = null;
        O(r4, r7, null, 6);
        ViewGroup r0 = r4.a;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
    L12:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        de8.c r8 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r5, r5)).a(de8.c.class);
        if (r4.A != 0) goto L25;
        if (r8 == null) goto L18;
        Bundle r9 = r8.b;
        if (r9 == null) goto L18;
        r1 = r9.getString("input_text");
    L18:
        if (r1 != null) goto L20;
    L21:
        r2 = true;
    L22:
        if (r2 == false) goto L26;
        r4.U(r6, r7);
        return;
    L26:
        return;
    L20:
        if (r1.length() != 0) goto L22;
    L25:
        return;
    L10:
        if ((!r7.isEmpty()) == false) goto L12;
        r4.X(true, Boolean.FALSE);
        goto L12
    L5:
        if (ViewExtKt.h(r0) == true) goto L7;
        r3 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.bmhome.view.actionbar.custom.x0] */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.larus.bmhome.view.actionbar.custom.c0] */
    /* JADX WARN: Type inference failed for: r18v1, types: [com.larus.bmhome.view.actionbar.custom.v0] */
    public final void L(final com.larus.bmhome.actionbar.model.z0 r58, final int r59, final View r60, final boolean r61) {
        if (r58 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.actionbar.model.p0 r0 = r58.o;
        boolean r15 = false;
        if (r0 == null) goto L8;
        boolean r1 = Intrinsics.areEqual(r0.n, Boolean.TRUE);
    L10:
        if (r1 == true) goto L13;
        Pair<Boolean, String> r2 = null;
    L56:
        if (r15 == false) goto L58;
        return;
    L58:
        final ArrayList r10 = new ArrayList();
        com.larus.bmhome.actionbar.model.p0 r3 = r58.o;
        if (r3 == null) goto L88;
        com.larus.bmhome.actionbar.model.a2 r4 = r3.d();
        if (r4 == null) goto L88;
        Pair<Boolean, String> r5 = r4.a;
        if (r5 == null) goto L88;
        CopyOnWriteArraySet<rs8.f> r6 = s1.a;
        wc9.e r7 = this.m;
        if (r7 == null) goto L67;
        Pair<Boolean, String> r13 = r7.a;
    L68:
        Intrinsics.checkNotNullParameter(r5, "menuItems");
        Iterator<rs8.f> r8 = s1.a.iterator();
    L70:
        if (r8.hasNext() == false) goto L73;
        r8.next().F(r13, r5);
        goto L70
    L73:
        if (this.C == false) goto L87;
        Pair<Boolean, String> r9 = new ArrayList();
        Iterator r11 = r5.iterator();
    L76:
        if (r11.hasNext() == false) goto L86;
        Object r12 = r11.next();
        Integer r14 = ((com.larus.bmhome.actionbar.model.b2) r12).l;
        int r16 = AgentMode.MOA.getValue();
        if (r14 != null) goto L81;
    L83:
        boolean r17 = false;
    L84:
        if (r17 == false) goto L76;
        r9.add(r12);
        goto L76
    L81:
        if (r14.intValue() != r16) goto L83;
        r17 = true;
        goto L84
    L86:
        r5 = r9;
    L87:
        final Pair<Boolean, String> r18 = r5;
    L89:
        CustomActionBarViewModel r19 = this.o;
        if (r19 == null) goto L92;
        r19.checkAndUpdateMenuHasRedDot(String.valueOf(r58.a), r18);
    L92:
        if (r18 == null) goto L248;
        Iterator r20 = r18.iterator();
        int r110 = 0;
    L95:
        if (r20.hasNext() == false) goto L248;
        Object r21 = r20.next();
        int r52 = r110 + 1;
        if (r110 >= 0) goto L99;
        CollectionsKt.throwIndexOverflow();
    L99:
        com.larus.bmhome.actionbar.model.b2 r22 = (com.larus.bmhome.actionbar.model.b2) r21;
        ModelItemIdentity r53 = r22.b();
        if (r53 != null) goto L102;
        Iterator r56 = r20;
    L247:
        r110 = r52;
        r20 = r56;
        r2 = null;
        goto L95
    L102:
        CustomActionBarViewModel r111 = this.o;
        if (r111 == null) goto L105;
        Pair<Boolean, String> r112 = r111.getCotExceedQuotaConfig(r53.getKey());
    L106:
        Object r113 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        List r114 = r22.j;
        long r54 = 0;
        if (r114 == null) goto L144;
        Iterator r115 = r114.iterator();
    L110:
        if (r115.hasNext() == false) goto L142;
        Object r116 = r115.next();
        com.larus.bmhome.actionbar.model.c2 r117 = (com.larus.bmhome.actionbar.model.c2) r116;
        if (r117 == null) goto L114;
        Pair<Boolean, String> r118 = r117.getType();
    L115:
        if (r118 != null) goto L118;
    L132:
        r56 = r20;
        if (r118 != null) goto L136;
    L138:
        boolean r119 = false;
    L139:
        if (r119 == true) goto L143;
        r20 = r56;
        r2 = null;
    L143:
        com.larus.bmhome.actionbar.model.c2 r23 = (com.larus.bmhome.actionbar.model.c2) r116;
    L145:
        if (r23 == null) goto L152;
        String r24 = r23.b;
        com.larus.bmhome.actionbar.model.g1 r25 = r23.c;
        if (r25 == null) goto L149;
        String r26 = r25.b;
    L150:
        Pair r27 = TuplesKt.to(r24, r26);
        String r28 = null;
    L156:
        String r29 = (String) r27.component1();
        String r30 = (String) r27.component2();
        String r120 = ObricTaskSkillDelegate.b.a(r28, r53.getKey(), "mode", false);
        if (r120 != null) goto L159;
        String r32 = r29;
    L160:
        if (r120 == null) goto L162;
        String r33 = null;
    L163:
        String r121 = r22.b;
        if (r112 != null) goto L166;
    L168:
        boolean r31 = false;
    L169:
        if (r31 == false) goto L185;
        ViewGroup r34 = this.a;
        if (r34 == null) goto L184;
        Context r35 = r34.getContext();
        if (r35 == null) goto L184;
        Resources r36 = r35.getResources();
        if (r36 == null) goto L177;
        Integer r37 = Integer.valueOf(r36.getIdentifier("larus_" + ((String) r112.getSecond()), "string", r35.getPackageName()));
    L178:
        if (r37 != null) goto L180;
    L182:
        String r38 = r35.getString(2131905578);
    L183:
        if (r38 == null) goto L184;
    L186:
        String r39 = r38;
        List r40 = r22.j;
        if (r40 == null) goto L204;
        Iterator r41 = r40.iterator();
    L190:
        if (r41.hasNext() == false) goto L200;
        Object r42 = r41.next();
        Integer r43 = ((com.larus.bmhome.actionbar.model.c2) r42).getType();
        if (r43 != null) goto L195;
    L197:
        boolean r44 = false;
    L198:
        if (r44 == false) goto L190;
    L201:
        com.larus.bmhome.actionbar.model.c2 r45 = (com.larus.bmhome.actionbar.model.c2) r42;
        if (r45 == null) goto L204;
        String r310 = r45.b;
    L205:
        com.larus.bmhome.actionbar.model.g1 r46 = r22.c;
        if (r46 == null) goto L209;
        String r47 = r46.b;
        if (r47 == null) goto L209;
    L210:
        String r210 = r47;
        InstructionInputComponent r48 = this.i;
        if (r48 == null) goto L213;
        ModelItemIdentity r49 = r48.Fe(r58).getModel();
    L215:
        if (Intrinsics.areEqual(r49, r22.b()) == false) goto L220;
        if (r60 == null) goto L218;
        Context r50 = r60.getContext();
    L219:
        Integer r211 = Integer.valueOf(v19.c.b(2130971676, r50, 2131241038));
    L221:
        if (r112 == null) goto L223;
        boolean r212 = ((Boolean) r112.getFirst()).booleanValue();
    L224:
        r10.add(new com.larus.bmhome.view.screenmenu.l0(r110, 0, r121, null, null, null, null, null, r210, false, false, null, r211, null, r212, false, null, null, null, r39, r32, r33, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -15765766, 127));
        CustomActionBarViewModel r51 = this.o;
        String r55 = TriggerSendLoading.NO_LOADING;
        if (r51 == null) goto L237;
        Long r57 = r58.a;
        if (r57 == null) goto L229;
        long r122 = r57.longValue();
    L230:
        String r62 = String.valueOf(r122);
        String r123 = r53.getKey();
        if (r123 != null) goto L233;
        r123 = TriggerSendLoading.NO_LOADING;
    L233:
        Long r124 = r22.i;
        if (r124 == null) goto L236;
        r54 = r124.longValue();
    L236:
        r51.reportMenuRedDotExposure(r62, r123, r54);
        goto L237
    L229:
        r122 = 0;
    L237:
        if (r23 == null) goto L247;
        com.larus.bmhome.actionbar.model.z1 r63 = r22.n;
        if (r63 == null) goto L241;
        String r125 = r63.a;
    L242:
        String r64 = r53.getKey();
        if (r64 == null) goto L246;
        r55 = r64;
    L246:
        z(r125, r55);
        goto L247
    L241:
        r125 = null;
        goto L242
    L223:
        r212 = true;
        goto L224
    L218:
        r50 = null;
        goto L219
    L220:
        r211 = null;
        goto L221
    L213:
        r49 = null;
    L209:
        r47 = "";
        goto L210
    L195:
        if (r43.intValue() != 2) goto L197;
        r44 = true;
        goto L198
    L200:
        r42 = null;
    L204:
        r310 = null;
        goto L205
    L180:
        if (r37.intValue() == 0) goto L182;
        r38 = r35.getResources().getString(r37.intValue());
        goto L183
    L177:
        r37 = null;
    L184:
        r38 = r22.g;
        goto L186
    L185:
        r38 = r22.g;
        goto L186
    L166:
        if (((Boolean) r112.getFirst()).booleanValue() == true) goto L168;
        r31 = true;
        goto L169
    L162:
        r33 = r30;
        goto L163
    L159:
        r32 = r120;
        goto L160
    L149:
        r26 = null;
        goto L150
    L152:
        if (r22.u == false) goto L154;
        String r65 = wa8.n0.a();
    L155:
        r28 = null;
        r27 = TuplesKt.to(r65, null);
        goto L156
    L154:
        r65 = null;
        goto L155
    L136:
        if (r118.intValue() != 5) goto L138;
        r119 = true;
        goto L139
    L118:
        if (r118.intValue() != 6) goto L132;
        Long r66 = r117.g;
        if (r66 == null) goto L122;
        long r67 = r66.longValue();
    L124:
        if (r67 <= 0) goto L129;
        r56 = r20;
        if ((AppHost.a.getAppClock().currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY)) < r67) goto L130;
        r119 = false;
    L131:
        FLogger.a.i("ActionBarMenuSwitchHelper", "getFirstValidTag, expireTime: " + r67 + ", result: " + r119);
    L130:
        r119 = true;
        goto L131
    L129:
        r56 = r20;
        goto L130
    L122:
        r67 = 0;
        goto L124
    L114:
        r118 = r2;
        goto L115
    L142:
        r56 = r20;
        r116 = null;
        goto L143
    L144:
        r56 = r20;
        r23 = null;
        goto L145
    L105:
        r112 = r2;
    L248:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r68 = ICommerceMembershipService.a.a();
        if (r68 == null) goto L253;
        uz8.f r69 = r68.y();
        if (r69 == null) goto L253;
        uz8.e r126 = r69.actionBar;
    L254:
        com.larus.bmhome.view.screenmenu.l0 r70 = b(r126);
        if (r70 != null) goto L257;
        View r71 = null;
    L274:
        if (r10.isEmpty() == false) goto L277;
        return;
    L277:
        if (m() == false) goto L283;
        com.larus.bmhome.chat.component.fastsend.e0 r72 = this.e;
        if (r72 == null) goto L283;
        com.larus.platform.api.a0 r73 = r72.WW();
        if (r73 == null) goto L283;
        final View r127 = r73.Yz();
    L284:
        InstructionInputComponent r74 = this.i;
        if (r74 == null) goto L317;
        final Context r75 = r74.getContext();
        if (r75 == null) goto L318;
        CreateMenu r128 = new CreateMenu(r75);
        this.H = new WeakReference(r128);
        Integer r213 = Integer.valueOf(i5.F());
        Integer r214 = Integer.valueOf(i5.R());
        CreateMenu.a.C0051a r129 = new CreateMenu.a.C0051a(i5.q(), i5.q(), i5.m(), i5.m(), i5.q(), i5.q(), i5.m(), 0, i5.j0(), 0, 640);
        ?? r130 = new c0(r60, this, r127, r18);
        final Pair<Boolean, String> r76 = r18;
        final View r77 = r127;
        final View r78 = CreateMenu.f(r128, r10, 0, false, r213, r214, r129, r130, new d0(r10, r76, this, r77, r60, r58, r59, r75), 30);
        h(r127, r60);
        final boolean r79 = J(r59, r61);
        if (r127 != null) goto L291;
    L293:
        Balloon r131 = f(r60, r78, new q0());
        Z(r78);
        a(r131, r60, r60, r78, r79, false);
        r131.v(r60, l(r60, r78, r79), i5.E());
        return;
    L291:
        if (m() == false) goto L293;
        final View r80 = r127;
        r127.post(new p0(r80, this, r60, r78, r79));
        return;
    L318:
        return;
    L317:
        return;
    L283:
        r127 = r71;
        goto L284
    L257:
        if (r10.isEmpty() == true) goto L268;
        Iterator r81 = r10.iterator();
    L261:
        if (r81.hasNext() == false) goto L268;
        if (((com.larus.bmhome.view.screenmenu.l0) r81.next()).a != r70.a) goto L265;
        boolean r132 = true;
    L266:
        if (r132 == false) goto L261;
        boolean r133 = false;
    L269:
        if (r133 == false) goto L271;
        r10.add(r70);
    L271:
        r71 = null;
        z(r70.D, null);
        FLogger.a.i("CustomActionBar", "showSwitchSecondMenu showMembershipEntry");
        goto L274
    L265:
        r132 = false;
    L268:
        r133 = true;
    L253:
        r126 = null;
        goto L254
    L67:
        r13 = r2;
    L88:
        r18 = r2;
        goto L89
    L13:
        if (m() == false) goto L19;
        com.larus.bmhome.chat.component.fastsend.e0 r82 = this.e;
        if (r82 == null) goto L19;
        com.larus.platform.api.a0 r83 = r82.WW();
        if (r83 == null) goto L19;
        View r84 = r83.Yz();
    L20:
        if (r84 != null) goto L22;
    L28:
        final View r134 = r60;
    L29:
        InstructionInputComponent r85 = this.i;
        if (r85 == null) goto L36;
        Intrinsics.checkNotNullParameter(r85, "<this>");
        Fragment r86 = com.larus.ui.arch.component.internal.attach.a.b(r85, r85);
        if (r86 == null) goto L36;
        t1a.b r87 = s1a.a.g(r86);
        if (r87 == null) goto L36;
        di8.c r135 = (di8.c) r87.getAbility(di8.c.class);
    L37:
        InstructionInputComponent r88 = this.i;
        if (r88 == null) goto L40;
        ReplyOption r136 = r88.Fe(r58);
    L41:
        if (r135 == null) goto L54;
        NestedMenuScene r137 = NestedMenuScene.ACTION_BAR;
        int r138 = r59 + 1;
        int r215 = i5.R();
        nda.d.a().pa();
        ViewGroup r89 = this.a;
        if (r89 != null) goto L45;
    L47:
        boolean r90 = false;
    L48:
        if (r90 == false) goto L50;
        Boolean r311 = Boolean.FALSE;
    L51:
        final View r91 = r134;
        r2 = null;
        if (r135.FI(r137, r60, r60, r91, r58, new di8.o0(false, false, null, false, null, 0, r215, true, new s0(), null, new t0(r91, r60, this, r59, r61), new u0(r134, r60), null, null, false, false, null, Integer.valueOf(r138), r311, 8165375), r136, new v0(), new x0(this, r60, r58, r59)) != true) goto L55;
        r15 = true;
    L55:
        r15 = false;
        goto L56
    L50:
        r311 = null;
        goto L51
    L45:
        if (ViewExtKt.h(r89) != true) goto L47;
        r90 = true;
        goto L48
    L54:
        r2 = null;
        goto L55
    L40:
        r136 = null;
    L36:
        r135 = null;
        goto L37
    L22:
        if (r84.isAttachedToWindow() == true) goto L25;
        r84 = null;
    L25:
        if (r84 == null) goto L28;
        r134 = r84;
    L19:
        r84 = null;
        goto L20
    L8:
        r1 = false;
        goto L10
    }

    public final boolean M(com.larus.bmhome.chat.model.n r11, InstructionInputComponent r12, String r13, Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> r14) {
        boolean r1 = false;
        if (this.T == null) goto L6;
        return false;
    L6:
        if (this.m != null) goto L8;
    L48:
        return false;
    L8:
        if (this.n == null) goto L48;
        CustomActionBarViewModel r2 = this.o;
        String r0 = null;
        if (r2 == null) goto L17;
        List<com.larus.bmhome.actionbar.model.z0> r15 = CustomActionBarViewModel.getCacheConfig$default(r2, b.a(), null, r13, r14, 2, null);
        if (r15 == null) goto L17;
        if ((!r15.isEmpty()) == false) goto L17;
    L18:
        List<com.larus.bmhome.actionbar.model.z0> r16 = r15;
        if (r16 != null) goto L21;
    L24:
        boolean r17 = true;
    L25:
        if (r17 == false) goto L27;
        return false;
    L27:
        O(this, r15, null, 6);
        ViewGroup r18 = this.a;
        if (r18 != null) goto L30;
    L32:
        boolean r19 = false;
    L33:
        if (r19 == false) goto L35;
        X(true, Boolean.FALSE);
    L35:
        Intrinsics.checkNotNullParameter(r12, "<this>");
        de8.c r110 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r12, r12)).a(de8.c.class);
        if (this.A != 0) goto L47;
        if (r110 == null) goto L41;
        Bundle r111 = r110.b;
        if (r111 == null) goto L41;
        r0 = r111.getString("input_text");
    L41:
        if (r0 != null) goto L43;
    L44:
        r1 = true;
    L45:
        if (r1 == false) goto L47;
        U(r11, r15);
        goto L47
    L43:
        if (r0.length() != 0) goto L45;
    L47:
        return true;
    L30:
        if (ViewExtKt.h(r18) == true) goto L32;
        r19 = true;
        goto L33
    L21:
        if (r16.isEmpty() == true) goto L24;
        r17 = false;
    L17:
        r15 = null;
        goto L18
    }

    @Deprecated(message = "do not use, use submitListBySave")
    public final void P(List<com.larus.bmhome.actionbar.model.z0> r10, boolean r11, boolean r12, final Function0<Unit> r13) {
        List r0 = (List) this.u.getValue();
        if (r0 == null) goto L24;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L24;
        jq9.j r2 = (jq9.j) r1.next();
        Iterator<T> r3 = r10.iterator();
    L9:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();
        com.larus.bmhome.actionbar.model.r r5 = ((com.larus.bmhome.actionbar.model.z0) r4).q;
        if (r5 == null) goto L13;
        Integer r6 = r5.a;
    L14:
        if (r2 == null) goto L16;
        Integer r7 = r2.a;
    L18:
        if (Intrinsics.areEqual(r6, r7) == false) goto L9;
    L21:
        com.larus.bmhome.actionbar.model.z0 r8 = (com.larus.bmhome.actionbar.model.z0) r4;
        if (r8 == null) goto L6;
        r8.B = r2;
        goto L6
    L16:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L20:
        r4 = null;
    L24:
        if (r12 == true) goto L26;
        c(null, new h1(this));
    L26:
        int r14 = r10.size();
        List r9 = i(r10);
        ArrayList r15 = new ArrayList();
        Iterator r16 = ((ArrayList) r9).iterator();
    L27:
        boolean r17 = true;
        boolean r18 = false;
        if (r16.hasNext() == false) goto L41;
        Object r19 = r16.next();
        com.larus.bmhome.actionbar.model.z0 r20 = (com.larus.bmhome.actionbar.model.z0) r19;
        if (Intrinsics.areEqual(r20.r, Boolean.TRUE) == false) goto L32;
    L38:
        r17 = false;
    L39:
        if (r17 == false) goto L27;
        r15.add(r19);
        goto L27
    L32:
        if (rs8.a.a() == true) goto L36;
        if (r20.C == false) goto L38;
    L36:
        if (CollectionsKt.contains(this.g, r20.b) == true) goto L38;
    L41:
        int r21 = r15.size();
        this.U = r21;
        C(r21);
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("submitList, oldSize:");
        r23.append(r14);
        r23.append(" oldItems = ");
        List<com.larus.bmhome.actionbar.model.z0> r110 = r10;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L43:
        if (r112.hasNext() == false) goto L45;
        r111.add(((com.larus.bmhome.actionbar.model.z0) r112.next()).b);
        goto L43
    L45:
        r23.append(r111);
        r22.i("CustomActionBar", r23.toString());
        FLogger r113 = FLogger.a;
        StringBuilder r24 = new StringBuilder("submitList, newSize:");
        r24.append(r21);
        r24.append(" newItems = ");
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r26 = r15.iterator();
    L47:
        if (r26.hasNext() == false) goto L49;
        r25.add(((com.larus.bmhome.actionbar.model.z0) r26.next()).b);
        goto L47
    L49:
        r24.append(r25);
        r113.i("CustomActionBar", r24.toString());
        CustomActionBarAdapter r114 = this.s;
        if (r114 != null) goto L52;
    L54:
        boolean r115 = false;
    L55:
        if (r115 == true) goto L58;
        if (r11 == false) goto L58;
        final boolean r116 = true;
    L59:
        CustomActionBarAdapter r117 = this.s;
        if (r117 == null) goto L62;
        r117.submitList(r15, new i1(r116, this, r13));
    L62:
        CustomActionBarPanelAdapterImpl r118 = this.t;
        if (r118 == null) goto L85;
        InstructionInputComponent r119 = this.i;
        if (r119 == null) goto L73;
        Intrinsics.checkNotNullParameter(r119, "<this>");
        Fragment r120 = com.larus.ui.arch.component.internal.attach.a.b(r119, r119);
        if (r120 == null) goto L73;
        t1a.b r121 = s1a.a.g(r120);
        if (r121 == null) goto L73;
        com.larus.bmhome.chat.component.immerse.a r122 = r121.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r122 == null) goto L73;
        r18 = r122.ui();
    L73:
        if (r18 == true) goto L75;
    L82:
        ArrayList r123 = r15;
    L83:
        r118.submitList(T(T(r123)));
        goto L85
    L75:
        if (com.larus.platform.service.z2.a.V1() == false) goto L82;
        List r124 = CollectionsKt.toMutableList(r15);
        r123 = new ArrayList();
        Iterator r125 = r124.iterator();
    L78:
        if (r125.hasNext() == false) goto L83;
        Object r126 = r125.next();
        if ((!Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r126).b, "coco_message_history")) == false) goto L78;
        r123.add(r126);
    L85:
        if ((!r15.isEmpty()) == false) goto L115;
        com.larus.bmhome.instruction.a2 r127 = this.P;
        if (r127 == null) goto L91;
        long r128 = SystemClock.elapsedRealtime();
        if (r127.f != 0) goto L91;
        r127.f = r128;
    L91:
        IAppLaunchReporter r129 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r129 == null) goto L116;
        r129.b("chat_action_bar_show", null);
        return;
    L116:
        return;
    L115:
        return;
    L58:
        r116 = false;
        goto L59
    L52:
        if (r114.getItemCount() != r21) goto L54;
        r115 = true;
        goto L55
    }

    public final int j(int r6, View r7, View r8, int r9) {
        ViewGroup r0 = this.a;
        ViewGroup.MarginLayoutParams r1 = null;
        int r2 = 0;
        if (r0 != null) goto L5;
    L15:
        int[] r3 = new int[2];
        r7.getLocationOnScreen(r3);
        int r10 = r3[0];
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r1 = (ViewGroup.MarginLayoutParams) r4;
    L18:
        if (r1 == null) goto L21;
        r2 = r1.getMarginStart();
    L21:
        return ((r10 - (r2 + r8.getPaddingStart())) + (r9 / 2)) - r6;
    L5:
        if (r0.isAttachedToWindow() == true) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
        r7 = r0;
        goto L15
    L7:
        if (r0.getWidth() <= 0) goto L9;
        r5 = true;
        goto L10
    }

    public final void s(com.larus.bmhome.actionbar.model.z0 r35, int r36, aq8.e r37, Bundle r38) {
        Boolean r4 = null;
        boolean r5 = false;
        if (K(r35) == true) goto L111;
    L98:
        if (r5 == false) goto L100;
        return;
    L100:
        vp8.k r0 = this.K;
        if (r0 == null) goto L104;
        r4 = Boolean.valueOf(r0.c(r35));
    L104:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L106;
        return;
    L106:
        r(this, r35, null, r36, null, r37, r38, 8);
        return;
    L111:
        com.larus.bmhome.actionbar.model.r r3 = r35.q;     // Catch: Throwable -> L96
        if (r3 == null) goto L98;
        com.larus.bmhome.actionbar.model.j1 r6 = r3.e;     // Catch: Throwable -> L96
        if (r6 == null) goto L98;
        String r14 = r6.u;     // Catch: Throwable -> L96
        if (r14 == null) goto L98;
        InstructionInputComponent r7 = this.i;     // Catch: Throwable -> L96
        if (r7 == null) goto L20;
        Intrinsics.checkNotNullParameter(r7, "<this>");     // Catch: Throwable -> L96
        Fragment r8 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7);     // Catch: Throwable -> L96
        if (r8 == null) goto L20;
        t1a.b r9 = s1a.a.g(r8);     // Catch: Throwable -> L96
        if (r9 == null) goto L20;
        com.larus.bmhome.instruction.h r10 = r9.getAbility(com.larus.bmhome.instruction.h.class);     // Catch: Throwable -> L96
        if (r10 == null) goto L20;
        com.larus.bmhome.instruction.f r11 = r10.EI();     // Catch: Throwable -> L96
    L21:
        Uri r12 = UriProtector.parse(r14);     // Catch: Throwable -> L96
        if (r11 == null) goto L95;
        aq8.e r13 = new aq8.e(null, null, null, UriProtector.getQueryParameter(r12, "instruction_default_params"), null, false, null, null, null, null, 1015);     // Catch: Throwable -> L96
        String r15 = UriProtector.getQueryParameter(r12, "actionbar_instruction_type");     // Catch: Throwable -> L96
        if (r15 == null) goto L28;
        Integer r16 = StringsKt.toIntOrNull(r15);     // Catch: Throwable -> L96
        if (r16 == null) goto L28;
        int r17 = r16.intValue();     // Catch: Throwable -> L96
    L29:
        String r18 = UriProtector.getQueryParameter(r12, "enter_method");     // Catch: Throwable -> L96
        String r19 = UriProtector.getQueryParameter(r12, "menu_instruction_type");     // Catch: Throwable -> L96
        if (r19 == null) goto L34;
        Integer r20 = StringsKt.toIntOrNull(r19);     // Catch: Throwable -> L96
        if (r20 == null) goto L34;
        int r21 = r20.intValue();     // Catch: Throwable -> L96
    L35:
        String r22 = UriProtector.getQueryParameter(r12, "feed_landing_tab");     // Catch: Throwable -> L96
        boolean r23 = Intrinsics.areEqual(UriProtector.getQueryParameter(r12, "open_album"), "1");     // Catch: Throwable -> L96
        boolean r24 = Intrinsics.areEqual(UriProtector.getQueryParameter(r12, "album_direct_send"), "1");     // Catch: Throwable -> L96
        boolean r25 = Intrinsics.areEqual(UriProtector.getQueryParameter(r12, "album_multi_select"), "1");     // Catch: Throwable -> L96
        String r1 = UriProtector.getQueryParameter(r12, "max_image");     // Catch: Throwable -> L96
        if (r1 == null) goto L40;
        Integer r2 = StringsKt.toIntOrNull(r1);     // Catch: Throwable -> L96
        if (r2 == null) goto L40;
        int r26 = r2.intValue();     // Catch: Throwable -> L96
    L41:
        String r27 = UriProtector.getQueryParameter(r12, "prompt");     // Catch: Throwable -> L96
        if (r12 != null) goto L109;
    L62:
        Pair r28 = null;
    L63:
        ChatParam r29 = this.h;     // Catch: Throwable -> L96
        if (r29 == null) goto L73;
        String r30 = r29.a;     // Catch: Throwable -> L96
        if (r30 == null) goto L73;
        if (r30.length() <= 0) goto L70;
        boolean r31 = true;
    L71:
        if (r31 == false) goto L73;
    L74:
        CustomActionBarViewModel r32 = this.o;     // Catch: Throwable -> L96
        if (r32 == null) goto L84;
        String r33 = r32.getConversationId();     // Catch: Throwable -> L96
        if (r33 == null) goto L84;
        if (r33.length() <= 0) goto L81;
        boolean r34 = true;
    L82:
        if (r34 == false) goto L84;
    L86:
        if (com.larus.im.j.f(r30) == false) goto L91;
        if (r33 == null) goto L91;
        if (com.larus.im.j.f(r33) == true) goto L91;
    L92:
        String r210 = r33;
    L94:
        r11.b(new com.larus.bmhome.instruction.n(InstructionHandlerType.SCHEMA_INTERCEPT, r13, false, r14, new com.larus.bmhome.instruction.a(r17, r18, null, null, true, r21, r22, r23, r24, r25, r26, r27, r28, r210, 4108), 4));     // Catch: Throwable -> L96
    L91:
        if (r30 == null) goto L92;
        r210 = r30;
        goto L94
    L81:
        r34 = false;
    L84:
        r33 = null;
        goto L86
    L70:
        r31 = false;
    L73:
        r30 = null;
        goto L74
    L109:
        String r211 = UriProtector.getQueryParameter(r12, "prompt");     // Catch: Exception -> L108 Throwable -> L96
        String r39 = UriProtector.getQueryParameter(r12, "selected_prompt");     // Catch: Exception -> L108 Throwable -> L96
        if (r211 != null) goto L47;
    L50:
        boolean r40 = true;
    L51:
        if (r40 == true) goto L62;
        if (r39 != null) goto L54;
    L57:
        boolean r41 = true;
    L58:
        if (r41 == true) goto L62;
        int r42 = StringsKt.indexOf$default(r211, r39, 0, false, 6, null);     // Catch: Exception -> L108 Throwable -> L96
        r28 = TuplesKt.to(Integer.valueOf(r42), Integer.valueOf(r39.length() + r42));     // Catch: Exception -> L108 Throwable -> L96
        goto L63
    L54:
        if (r39.length() == 0) goto L57;
        r41 = false;
        goto L58
    L47:
        if (r211.length() == 0) goto L50;
        r40 = false;
    L40:
        r26 = 0;
    L34:
        r21 = 0;
    L28:
        r17 = 0;
    L95:
        r5 = true;
    L20:
        r11 = null;
    L96:
        th = move-exception;
        FLogger.a.e("CustomActionBar", "check schema err! msg=" + th.getMessage());
        goto L98
    }

    public final void v(com.larus.bmhome.chat.model.n r22, InstructionInputComponent r23, String r24, Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> r25) {
        String r1 = null;
        List r2 = null;
        r1 = null;
        boolean r3 = false;
        if (com.larus.platform.service.z2.a.p2() == false) goto L16;
        CustomActionBarViewModel r8 = this.o;
        if (r8 != null) goto L7;
    L9:
        if (r3 == false) goto L15;
        CustomActionBarViewModel r9 = this.o;
        if (r9 == null) goto L13;
        r2 = CustomActionBarViewModel.getCacheConfig$default(r9, b.a(), null, r24, r25, 2, null);
    L13:
        if (r2 == null) goto L52;
        u(this, r23, r22, r2);
        return;
    L52:
        return;
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r23), Dispatchers.getIO(), null, new CustomActionBar$loadCacheV2$2(this, r24, r25, r23, r22, null), 2, null);
        return;
    L7:
        if (CustomActionBarViewModel.hasMemoryCache$default(r8, b.a(), null, r24, 2, null) != true) goto L9;
        r3 = true;
        goto L9
    L16:
        CustomActionBarViewModel r14 = this.o;
        if (r14 == null) goto L19;
        List<com.larus.bmhome.actionbar.model.z0> r0 = CustomActionBarViewModel.getCacheConfig$default(r14, b.a(), null, r24, r25, 2, null);
    L20:
        if (r0 == null) goto L55;
        FLogger.a.i("CustomActionBar", "initBar, actionBarCofList form Local, size=" + r0.size() + ", initInstructionType=" + this.A);
        O(this, r0, null, 6);
        ViewGroup r4 = this.a;
        if (r4 != null) goto L24;
    L26:
        boolean r5 = false;
    L27:
        if (r5 == true) goto L29;
    L31:
        InstructionInputComponent r6 = this.i;
        if (r6 == null) goto L38;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Fragment r7 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6);
        if (r7 == null) goto L38;
        t1a.b r10 = s1a.a.g(r7);
        if (r10 == null) goto L38;
        de8.c r11 = (de8.c) r10.a(de8.c.class);
    L40:
        if (this.A != 0) goto L56;
        if (r11 == null) goto L45;
        Bundle r12 = r11.b;
        if (r12 == null) goto L45;
        r1 = r12.getString("input_text");
    L45:
        if (r1 != null) goto L47;
    L48:
        r3 = true;
    L49:
        if (r3 == false) goto L57;
        U(r22, r0);
        return;
    L57:
        return;
    L47:
        if (r1.length() != 0) goto L49;
    L56:
        return;
    L38:
        r11 = null;
        goto L40
    L29:
        if ((!r0.isEmpty()) == false) goto L31;
        X(true, Boolean.FALSE);
        goto L31
    L24:
        if (ViewExtKt.h(r4) == true) goto L26;
        r5 = true;
        goto L27
    L55:
        return;
    L19:
        r0 = null;
        goto L20
    }

    public static Balloon e(CustomActionBar r14, View r15, View r16, Function0 r17, int r18) {
        if ((r18 & 4) == 0) goto L5;
        boolean r0 = true;
    L6:
        xe8.a r4 = null;
        if ((r18 & 8) == 0) goto L9;
        Function0 r12 = null;
    L10:
        r14.getClass();
        com.larus.bmhome.view.screenmenu.d r5 = com.larus.bmhome.view.screenmenu.d.a;
        if (r0 == true) goto L28;
        InstructionInputComponent r1 = r14.i;
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
    L17:
        if ((r2 instanceof xe8.a) == false) goto L19;
        r4 = (xe8.a) r2;
    L19:
        if (r4 == null) goto L25;
        ChatBubbleParams r3 = r4.Mz();
        if (r3 == null) goto L25;
        if (r3.b != true) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == true) goto L28;
    L30:
        boolean r8 = false;
    L32:
        return com.larus.bmhome.view.screenmenu.d.a(r5, r15, r16, r8, null, null, null, r12, 56);
    L25:
        r6 = false;
        goto L26
    L15:
        r2 = null;
    L28:
        if (nda.d.a().sa() == false) goto L30;
        r8 = true;
        goto L32
    L9:
        r12 = r17;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.view.actionbar.custom.f] */
    public final void y(final com.larus.bmhome.actionbar.model.z0 r56, aq8.e r57, int r58, View r59, Bundle r60) {
        FLogger.a.d("CustomActionBar", "onCustomActionBarClick, type=" + r56.g);
        wc9.e r1 = this.m;
        boolean r2 = true;
        Integer r4 = null;
        String r5 = null;
        if (r1 == null) goto L14;
        String r3 = r1.a;
        if (r3 == null) goto L14;
        if ((!StringsKt.isBlank(r3)) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L14;
        int r6 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        BubbleBannerDismissReason r7 = BubbleBannerDismissReason.ACTION_BAR_ITEM_CLICK;
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "reason");
        IBubbleBannerRuntimeService r8 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r8 == null) goto L14;
        r8.m(r3, r7);
    L14:
        ViewGroup r9 = this.a;
        if (r9 == null) goto L19;
        Context r10 = r9.getContext();
        if (r10 == null) goto L19;
        LocalBroadcastManager.getInstance(r10).sendBroadcast(new Intent("chat.actionbar.ACTION_BAR_ITEM_CLICKED"));
    L19:
        CopyOnWriteArraySet<rs8.f> r11 = s1.a;
        Intrinsics.checkNotNullParameter(r56, "item");
        Iterator<rs8.f> r12 = s1.a.iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        r12.next().l0(r56, r59);
        goto L21
    L23:
        int r13 = 0;
        boolean r14 = false;
        boolean r15 = false;
        if (r59 == null) goto L56;
        RecyclerView r16 = r59.getParent();
        if ((r16 instanceof RecyclerView) == false) goto L28;
        RecyclerView r17 = r16;
    L29:
        if (r17 == null) goto L36;
        Integer r18 = Integer.valueOf(r17.getChildAdapterPosition(r59));
        if (r18.intValue() == (-1)) goto L33;
        boolean r19 = true;
    L34:
        if (r19 == false) goto L36;
    L37:
        if (r17 == null) goto L39;
        RecyclerView.LayoutManager r20 = r17.getLayoutManager();
    L41:
        if ((r20 instanceof GridLayoutManager) == false) goto L43;
        GridLayoutManager r21 = (GridLayoutManager) r20;
    L44:
        if (r21 == null) goto L46;
        Integer r22 = Integer.valueOf(r21.getSpanCount());
    L47:
        if (r18 == null) goto L54;
        int r23 = r18.intValue();
        if (r22 != null) goto L51;
    L53:
        Integer r24 = Integer.valueOf(r23 + 1);
    L55:
        Map r25 = wa8.c0.a;
        wa8.c0.a(r56.H, ActionBarItemLocation.PRIMARY_BAR, r24);
        goto L56
    L51:
        if (r22.intValue() <= 0) goto L53;
        r23 = r23 % r22.intValue();
        goto L53
    L54:
        r24 = null;
        goto L55
    L46:
        r22 = null;
        goto L47
    L43:
        r21 = null;
        goto L44
    L39:
        r20 = null;
        goto L41
    L33:
        r19 = false;
    L36:
        r18 = null;
        goto L37
    L28:
        r17 = null;
    L56:
        Integer r26 = r56.g;
        int r27 = ActionBarExecutionType.MSG_TEMPLATE.getValue();
        if (r26 != null) goto L60;
    L81:
        int r28 = ActionBarExecutionType.INSTRUCTION.getValue();
        if (r26 != null) goto L85;
    L159:
        int r110 = ActionBarExecutionType.BOT_SEND_MSG.getValue();
        if (r26 != null) goto L163;
    L170:
        int r111 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r26 != null) goto L174;
    L194:
        int r29 = ActionBarExecutionType.OPEN_CAMERA.getValue();
        if (r26 != null) goto L198;
    L208:
        int r30 = ActionBarExecutionType.GENERATE_PODCAST.getValue();
        if (r26 != null) goto L212;
        return;
    L212:
        if (r26.intValue() != r30) goto L307;
        if (r59 != null) goto L215;
        return;
    L215:
        int r31 = i.a;
        InstructionInputComponent r32 = this.i;
        if (r32 == null) goto L222;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        Fragment r33 = com.larus.ui.arch.component.internal.attach.a.b(r32, r32);
        if (r33 == null) goto L222;
        t1a.b r34 = s1a.a.g(r33);
        if (r34 == null) goto L222;
        ICoreInputAbility r112 = (ICoreInputAbility) r34.getAbility(ICoreInputAbility.class);
    L223:
        InstructionEditorViewModel r113 = this.w;
        String r114 = this.l;
        wc9.e r35 = this.m;
        if (r35 == null) goto L228;
        String r36 = r35.a;
        if (r36 == null) goto L228;
        Long r115 = Long.valueOf(com.larus.bmhome.view.actionbar.bot.k.a(r36));
    L229:
        InstructionInputComponent r37 = this.i;
        if (r37 == null) goto L232;
        Intrinsics.checkNotNullParameter(r37, "<this>");
        Fragment r38 = com.larus.ui.arch.component.internal.attach.a.b(r37, r37);
    L234:
        if ((r38 instanceof ChatFragment) == false) goto L236;
        ChatFragment r39 = (ChatFragment) r38;
    L237:
        if (r39 == null) goto L239;
        String r116 = ChatControlTrace.b.h(r39.getChatUniqueKey());
    L240:
        final z2 r40 = new z2(r112, r113, r56, r59, r114, r115, r116);
        Intrinsics.checkNotNullParameter(r40, "podcastContext");
        FLogger.a.i("ActionBarPodcastHandler", "handleGeneratePodcast...");
        com.larus.bmhome.actionbar.model.z0 r0 = r40.c;
        ArrayList r41 = new ArrayList();
        boolean r42 = v19.h.a;
        boolean r43 = v19.h.b(AppHost.a.getApplication());
        com.larus.bmhome.actionbar.model.b1 r44 = r0.w;
        if (r44 == null) goto L264;
        List r45 = r44.a;
        if (r45 == null) goto L264;
        Iterator r46 = r45.iterator();
        int r47 = 0;
    L246:
        if (r46.hasNext() == false) goto L264;
        Object r117 = r46.next();
        int r118 = r47 + 1;
        if (r47 >= 0) goto L250;
        CollectionsKt.throwIndexOverflow();
    L250:
        com.larus.bmhome.actionbar.model.c1 r119 = (com.larus.bmhome.actionbar.model.c1) r117;
        Long r48 = r119.a;
        if (r48 == null) goto L262;
        int r120 = (int) r48.longValue();
        String r121 = r119.d;
        if (r43 == false) goto L257;
        com.larus.bmhome.actionbar.model.g1 r122 = r119.c;
        if (r122 != null) goto L259;
    L260:
        String r210 = null;
    L261:
        r41.add(new com.larus.bmhome.view.screenmenu.l0(r120, 0, r121, null, null, null, null, null, r210, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -262, 127));
    L259:
        r210 = r122.b;
        goto L261
    L257:
        r122 = r119.b;
        if (r122 == null) goto L260;
    L262:
        r47 = r118;
    L264:
        if (r41.isEmpty() == false) goto L266;
        FLogger.a.i("ActionBarPodcastHandler", "handleGeneratePodcast: menuList is empty");
        return;
    L266:
        ICoreInputAbility r49 = r40.a;
        if (r49 == null) goto L269;
        r49.C1(false, true, "");
    L269:
        final ?? r50 = new com.larus.bmhome.view.actionbar.custom.f(r40);
        Context r51 = r40.d.getContext();
        if (r51 == null) goto L309;
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r40.d, CreateMenu.f(new CreateMenu(r51), r41, 0, false, null, null, null, null, new com.larus.bmhome.view.actionbar.custom.g(r40, r50), 510), false, null, null, null, null, 124).v(r40.d, 0, i5.E());
        Iterator r52 = r41.iterator();
    L273:
        if (r52.hasNext() == false) goto L312;
        Object r53 = r52.next();
        int r54 = r13 + 1;
        if (r13 >= 0) goto L277;
        CollectionsKt.throwIndexOverflow();
    L277:
        com.larus.bmhome.view.screenmenu.l0 r55 = (com.larus.bmhome.view.screenmenu.l0) r53;
        com.larus.bmhome.actionbar.model.z0 r61 = r40.c;
        String r123 = r61.b;
        Long r62 = r61.a;
        String r124 = String.valueOf(r55.a);
        String r63 = r55.c;
        tx9.b.f(r40.e, r40.g, null, null, r123, null, null, r63, r124, null, 1, Integer.valueOf(r54), r62, r40.f, null, null, null, null, null, null, null, null, 8372844);
        r13 = r54;
        goto L273
    L312:
        return;
    L309:
        return;
    L239:
        r116 = null;
        goto L240
    L236:
        r39 = null;
        goto L237
    L232:
        r38 = null;
    L228:
        r115 = null;
    L222:
        r112 = null;
        goto L223
    L307:
        return;
    L198:
        if (r26.intValue() != r29) goto L208;
        InstructionInputComponent r64 = this.i;
        if (r64 == null) goto L302;
        Intrinsics.checkNotNullParameter(r64, "<this>");
        Fragment r65 = com.larus.ui.arch.component.internal.attach.a.b(r64, r64);
        if (r65 == null) goto L303;
        t1a.b r66 = s1a.a.g(r65);
        if (r66 == null) goto L304;
        ICoreInputAbility r67 = r66.getAbility(ICoreInputAbility.class);
        if (r67 == null) goto L305;
        r67.zk("input_left_icon");
        return;
    L305:
        return;
    L304:
        return;
    L303:
        return;
    L302:
        return;
    L174:
        if (r26.intValue() != r111) goto L194;
        com.larus.bmhome.actionbar.model.r r68 = r56.q;
        if (r68 == null) goto L183;
        Integer r69 = r68.a;
        if (r69 == null) goto L183;
        if (r69.intValue() != 11) goto L183;
    L184:
        if (r2 == false) goto L297;
        com.larus.bmhome.actionbar.model.r r70 = r56.q;
        if (r70 == null) goto L188;
        r15 = Intrinsics.areEqual(r70.j, Boolean.TRUE);
    L188:
        if (r15 == false) goto L298;
        InstructionInputComponent r71 = this.i;
        if (r71 == null) goto L299;
        LifecycleCoroutineScope r72 = LifecycleOwnerKt.getLifecycleScope(r71);
        if (r72 == null) goto L300;
        BuildersKt.launch$default(r72, null, null, new CustomActionBar$onCustomActionBarClick$7(r56, this, r58, r57, r60, null), 3, null);
        return;
    L300:
        return;
    L299:
        return;
    L298:
        return;
    L297:
        return;
    L183:
        r2 = false;
        goto L184
    L163:
        if (r26.intValue() != r110) goto L170;
        com.larus.bmhome.actionbar.model.z0 r73 = this.F;
        if (r73 == null) goto L169;
        CustomActionBarViewModel r74 = this.o;
        if (r74 == null) goto L169;
        r74.saveActionBarNewRank(r73);
    L169:
        this.F = null;
        return;
    L85:
        if (r26.intValue() != r28) goto L159;
        com.larus.bmhome.actionbar.model.r r75 = r56.q;
        if (r75 == null) goto L94;
        Integer r76 = r75.a;
        if (r76 == null) goto L94;
        if (r76.intValue() != 28) goto L94;
        boolean r77 = true;
    L95:
        if (r77 == false) goto L101;
        InstructionInputComponent r78 = this.i;
        if (r78 == null) goto L292;
        LifecycleCoroutineScope r79 = LifecycleOwnerKt.getLifecycleScope(r78);
        if (r79 == null) goto L293;
        BuildersKt.launch$default(r79, null, null, new CustomActionBar$onCustomActionBarClick$5(this, r56, r58, r57, r60, null), 3, null);
        return;
    L293:
        return;
    L292:
        return;
    L101:
        InstructionInputComponent r80 = this.i;
        if (r80 == null) goto L104;
        CoroutineScope r81 = LifecycleOwnerKt.getLifecycleScope(r80);
    L105:
        com.larus.bmhome.actionbar.model.r r82 = r56.q;
        if (r82 != null) goto L108;
    L110:
        boolean r83 = false;
    L111:
        boolean r84 = K(r56);
        if (r83 == true) goto L115;
        if (r84 == true) goto L115;
    L154:
        if (r14 == false) goto L158;
        if (r81 == null) goto L158;
        BuildersKt.launch$default(r81, null, null, new CustomActionBar$onCustomActionBarClick$6(this, r56, r58, r57, r60, null), 3, null);
        return;
    L158:
        s(r56, r58, r57, r60);
        return;
    L115:
        com.larus.bmhome.actionbar.model.r r85 = r56.q;
        if (r85 == null) goto L137;
        com.larus.bmhome.actionbar.model.j1 r86 = r85.e;
        if (r86 == null) goto L137;
        String r87 = r86.u;
        if (r87 == null) goto L137;
        if (r84 == true) goto L124;
        r87 = null;
    L124:
        if (r87 == null) goto L137;
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L131
        String r89 = UriProtector.getQueryParameter(UriProtector.parse(r87), "actionbar_instruction_type");     // Catch: Throwable -> L131
        if (r89 == null) goto L128;
        Integer r90 = StringsKt.toIntOrNull(r89);     // Catch: Throwable -> L131
    L129:
        Object r91 = Result.constructor-impl(r90);     // Catch: Throwable -> L131
    L134:
        if (Result.isFailure-impl(r91) == false) goto L136;
        r91 = null;
    L136:
        Integer r92 = (Integer) r91;
    L138:
        if (r92 != null) goto L142;
        com.larus.bmhome.actionbar.model.r r93 = r56.q;
        if (r93 == null) goto L143;
        r4 = r93.a;
    L143:
        if (r4 != null) goto L146;
    L147:
        if (r4 != null) goto L150;
    L152:
        r2 = false;
    L153:
        r14 = r2;
        goto L154
    L150:
        if (r4.intValue() != 24) goto L152;
    L146:
        if (r4.intValue() == 18) goto L153;
    L142:
        r4 = r92;
        goto L143
    L128:
        r90 = null;
    L131:
        th = move-exception;
        Result.Companion r94 = Result.Companion;
        r91 = Result.constructor-impl(ResultKt.createFailure(th));
    L137:
        r92 = null;
        goto L138
    L108:
        if (r82.f() != true) goto L110;
        r83 = true;
        goto L111
    L104:
        r81 = null;
    L94:
        r77 = false;
        goto L95
    L60:
        if (r26.intValue() != r27) goto L81;
        ActionBarDialogFragment r95 = new ActionBarDialogFragment();
        InstructionInputComponent r96 = this.i;
        if (r96 == null) goto L66;
        FragmentActivity r97 = s1a.a.getActivity(r96);
        if (r97 == null) goto L66;
        FragmentManager r98 = r97.getSupportFragmentManager();
    L67:
        Bundle r99 = com.larus.utils.f.c(new Pair[0]);
        wc9.e r100 = this.m;
        if (r100 == null) goto L70;
        String r101 = r100.a;
    L71:
        r99.putString("key_conversation_id", r101);
        r99.putParcelable("key_chat_param", this.h);
        CustomActionBarViewModel r102 = this.o;
        if (r102 == null) goto L74;
        r5 = r102.getBotLanguageCode();
    L74:
        r99.putString("key_language", r5);
        r95.setArguments(r99);
        Function1<? super String, Unit> r103 = new e0(this, r56);
        Intrinsics.checkNotNullParameter(r103, "callback");
        r95.m = r103;
        if (r98 == null) goto L278;
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r95, "draggableDialog", r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r98, r95, r104) == true) goto L310;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L279
    L80:
        r95.show(r98, "draggableDialog");
        return;
    L310:
        return;
    L278:
        return;
    L70:
        r101 = null;
    L66:
        r98 = null;
        goto L67
    }

    public final void a(final Balloon r11, final View r12, final View r13, final View r14, final boolean r15, final boolean r16) {
        Object r0 = r14.findViewById(2131392492);
        if ((r0 instanceof CreateMenuV2) == false) goto L5;
        CreateMenuV2 r1 = (CreateMenuV2) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setOnMenuSizeChangedListener(new e1(r11, r12, r13, this, r16, r15, r14));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void q(CustomActionBar r11, com.larus.bmhome.actionbar.model.z0 r12, Boolean r13, aq8.e r14, int r15, View r16, String r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        Boolean r7 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        aq8.e r2 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        View r4 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        String r9 = null;
    L18:
        r11.F = r12;
        r11.y(r12, r2, r15, r4, null);
        CustomActionBarViewModel r3 = r11.o;
        if (r3 == null) goto L22;
        CustomActionBarViewModel.executeOnClickAction$default(r3, r11.i, r12, r7, false, null, r9, 8, null);
        return;
    L22:
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r4 = r16;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r7 = r13;
        goto L7
    }

    public static void r(CustomActionBar r58, com.larus.bmhome.actionbar.model.z0 r59, com.larus.bmhome.actionbar.model.r r60, int r61, String r62, aq8.e r63, Bundle r64, int r65) {
        if ((r65 & 8) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r65 & 16) == 0) goto L9;
        aq8.e r5 = null;
    L11:
        if ((r65 & 32) == 0) goto L13;
        Bundle r6 = null;
    L14:
        r58.getClass();
        if (r4 != null) goto L17;
    L20:
        boolean r8 = true;
    L22:
        if (r8 == false) goto L147;
        com.larus.bmhome.actionbar.model.r r9 = r59.q;
        if (r9 != null) goto L26;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L147;
        InstructionInputComponent r11 = r58.i;
        if (r11 == null) goto L147;
        FragmentActivity r12 = s1a.a.getActivity(r11);
        if (r12 == null) goto L147;
        FLogger.a.d("CustomActionBar", "handleInstructionNeedEnterIndependentPage, type=" + r59.g + ", action_key=" + r59.b);
        com.larus.bmhome.actionbar.model.r r7 = r59.q;
        if (r7 == null) goto L42;
        Integer r13 = r7.a;
        if (r13 == null) goto L42;
        if (r13.intValue() != 31) goto L42;
        boolean r14 = true;
    L44:
        if (r14 == true) goto L46;
        com.larus.bmhome.actionbar.model.r r15 = r59.q;
        if (r15 == null) goto L60;
        Integer r16 = r15.a;
        if (r16 == null) goto L60;
        if (r16.intValue() != 28) goto L60;
        boolean r17 = true;
    L62:
        if (com.larus.platform.service.z2.a.creationFeedEntranceReverse() == false) goto L65;
        if (r17 == false) goto L65;
        boolean r50 = true;
    L66:
        String r18 = "1";
        if (r50 == true) goto L83;
        com.larus.bmhome.actionbar.model.r r19 = r59.q;
        if (r19 == null) goto L73;
        com.larus.bmhome.actionbar.model.j1 r110 = r19.e;
        if (r110 == null) goto L73;
        String r111 = r110.n;
    L75:
        if (Intrinsics.areEqual(r111, "1") == true) goto L83;
        com.larus.bmhome.actionbar.model.r r112 = r59.q;
        if (r112 == null) goto L79;
        boolean r113 = Intrinsics.areEqual(r112.h, Boolean.FALSE);
    L80:
        if (r113 == true) goto L83;
        boolean r22 = false;
    L84:
        ICreationWorkflowService.Companion r114 = ICreationWorkflowService.a;
        Lazy r115 = com.larus.im.j.a;
        ChatParam r116 = r58.h;
        if (r116 == null) goto L87;
        String r117 = r116.a;
    L89:
        if (com.larus.im.j.f(r117) == false) goto L104;
        CustomActionBarViewModel r118 = r58.o;
        if (r118 == null) goto L93;
        String r119 = r118.getConversationId();
    L95:
        if (com.larus.im.j.f(r119) == true) goto L104;
        ChatParam r120 = r58.h;
        if (r120 == null) goto L103;
        CustomActionBarViewModel r121 = r58.o;
        if (r121 == null) goto L101;
        String r122 = r121.getConversationId();
    L102:
        ChatParam r123 = ChatParam.a(r120, r122, null, null, 254);
    L105:
        ChatParam r24 = r123;
    L106:
        if (r5 == null) goto L108;
        String r26 = r5.a;
    L109:
        o1 r124 = new o1(r5, r58, r59);
        if (r5 == null) goto L112;
        Map<String, String> r27 = r5.e;
    L113:
        if (r5 == null) goto L115;
        Integer r28 = r5.b;
    L116:
        if (r5 == null) goto L118;
        Integer r45 = r5.c;
    L119:
        InstructionInputComponent r125 = r58.i;
        if (r125 == null) goto L126;
        Intrinsics.checkNotNullParameter(r125, "<this>");
        Fragment r126 = com.larus.ui.arch.component.internal.attach.a.b(r125, r125);
        if (r126 == null) goto L126;
        t1a.b r127 = s1a.a.g(r126);
        if (r127 == null) goto L126;
        ChatPageContext r46 = (ChatPageContext) r127.a(ChatPageContext.class);
    L127:
        Pair[] r20 = new Pair[2];
        if (r5 == null) goto L130;
        String r21 = r5.d;
    L131:
        r20[0] = TuplesKt.to("actionbar_instruction_default_params", r21);
        if (r59.y == true) goto L135;
        r18 = TriggerSendLoading.NO_LOADING;
    L135:
        r20[1] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(TuplesKt.to("red_dot", r18))));
        Bundle r1 = com.larus.utils.f.c(r20);
        if (r17 == false) goto L138;
        r1.putString("recent_enter_feed_from", "action_bar");
    L138:
        InstructionInputComponent r23 = r58.i;
        if (r23 == null) goto L141;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Fragment r47 = com.larus.ui.arch.component.internal.attach.a.b(r23, r23);
    L142:
        InstructionInputComponent r0 = r58.i;
        if (r0 == null) goto L145;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Fragment r53 = com.larus.ui.arch.component.internal.attach.a.b(r0, r0);
    L146:
        r114.f0(new ny9.b(r22, r12, r59, r24, false, false, null, r26, null, null, null, null, null, null, null, null, null, null, null, false, false, r124, null, r1, false, r27, r28, r45, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, r46, r47, r53, null, null, r50, -245366928, 102399));
        return;
    L145:
        r53 = null;
        goto L146
    L141:
        r47 = null;
        goto L142
    L130:
        r21 = null;
    L126:
        r46 = null;
        goto L127
    L118:
        r45 = null;
        goto L119
    L115:
        r28 = null;
        goto L116
    L112:
        r27 = null;
        goto L113
    L108:
        r26 = null;
        goto L109
    L101:
        r122 = null;
        goto L102
    L103:
        r24 = null;
        goto L106
    L93:
        r119 = null;
    L104:
        r123 = r58.h;
        goto L105
    L87:
        r117 = null;
        goto L89
    L79:
        r113 = false;
    L73:
        r111 = null;
    L83:
        r22 = true;
    L65:
        r50 = false;
    L60:
        r17 = false;
        goto L62
    L46:
        if (AccountService.a.isLogin().booleanValue() == true) goto L48;
        com.larus.utils.t0.c(new a0());
        boolean r2 = true;
    L49:
        if (r2 == true) goto L164;
        IFlowMainBot.a.s8(new ik9.c(r12, new MiniArtifactListPageParams(Boolean.TRUE, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("previous_page", "chat"), TuplesKt.to("enter_method", "chat_action_bar"), TuplesKt.to("action_bar_template_id", r59.a)}))));
        return;
    L164:
        return;
    L48:
        r2 = false;
    L42:
        r14 = false;
        goto L44
    L26:
        if (r9.f() != true) goto L28;
        r10 = true;
    L147:
        FLogger.a.d("CustomActionBar", "handleInstructionForm, type=" + r59.g + ", action_key=" + r59.b + ", openFrom=" + r61);
        Integer r3 = r59.g;
        int r25 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r3 != null) goto L151;
    L155:
        InstructionEditorViewModel r29 = r58.w;
        if (r29 == null) goto L163;
        com.larus.bmhome.view.actionbar.edit.c.a.a(r29, r59, r60, r61, r4, r5, null, null, 96);
        return;
    L163:
        return;
    L151:
        if (r3.intValue() != r25) goto L155;
        CustomActionBarViewModel r30 = r58.o;
        if (r30 == null) goto L161;
        CustomActionBarViewModel.executeOnClickAction$default(r30, r58.i, r59, Boolean.FALSE, false, r6, null, 40, null);
        return;
    L161:
        return;
    L17:
        if (r4.length() == 0) goto L20;
        r8 = false;
        goto L22
    L13:
        r6 = r64;
        goto L14
    L9:
        r5 = r63;
        goto L11
    L5:
        r4 = r62;
        goto L7
    }

    public final void Q(com.larus.bmhome.actionbar.model.z0 r37, String r38, String r39, Integer r40, Long r41, Boolean r42, Integer r43, Integer r44) {
        if (Intrinsics.areEqual(r37.b, ObricActionBarTrackServiceDelegate.b.p()) == false) goto L8;
        if (ObricFeatureServiceDelegate.b.a() == false) goto L8;
        return;
    L8:
        if (r41 != null) goto L11;
    L23:
        int r4 = 0;
    L24:
        Map r5 = IAIChatRenderTraceService.a.i();
        if (r5 == null) goto L34;
        String r6 = (String) r5.get("key_current_page");
        if (r6 == null) goto L34;
        if (com.larus.utils.o0.d(r6) == true) goto L32;
        r6 = null;
    L32:
        if (r6 == null) goto L34;
    L35:
        String r7 = r6;
        String r8 = this.l;
        wc9.e r9 = this.m;
        if (r9 == null) goto L40;
        String r10 = r9.a;
        if (r10 == null) goto L40;
        Long r11 = Long.valueOf(com.larus.bmhome.view.actionbar.bot.k.a(r10));
    L41:
        InstructionInputComponent r12 = this.i;
        if (r12 == null) goto L44;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Fragment r13 = com.larus.ui.arch.component.internal.attach.a.b(r12, r12);
    L46:
        if ((r13 instanceof ChatFragment) == false) goto L48;
        ChatFragment r14 = (ChatFragment) r13;
    L49:
        if (r14 == null) goto L51;
        String r15 = ChatControlTrace.b.h(r14.getChatUniqueKey());
    L52:
        com.larus.bmhome.actionbar.model.r r16 = r37.q;
        if (r16 == null) goto L57;
        Integer r17 = r16.a;
        if (r17 == null) goto L57;
        int r18 = r17.intValue();
    L58:
        String r19 = r37.b;
        com.larus.bmhome.actionbar.model.e0 r20 = r37.m;
        if (r20 == null) goto L61;
        String r110 = r20.a;
    L62:
        RecyclerView r21 = this.r;
        if (r21 == null) goto L65;
        by7.e r111 = by7.h.g(r21);
    L66:
        com.larus.bmhome.actionbar.model.r r22 = r37.q;
        if (r22 == null) goto L69;
        String r112 = r22.g;
    L70:
        if (r22 == null) goto L76;
        Integer r23 = r22.a;
        if (r23 == null) goto L76;
        if (od8.h0.d(r23) != true) goto L76;
        boolean r24 = true;
    L77:
        if (r24 == false) goto L79;
        String r32 = e6.a.b();
    L80:
        Integer r25 = r37.g;
        int r113 = ActionBarExecutionType.INSTRUCTION.getValue();
        if (r25 == null) goto L96;
        if (r25.intValue() != r113) goto L96;
        com.larus.bmhome.actionbar.model.r r26 = r37.q;
        if (r26 == null) goto L93;
        Integer r27 = r26.a;
        if (r27 == null) goto L93;
        if (r27.intValue() != 12) goto L93;
        boolean r28 = true;
    L94:
        if (r28 == false) goto L96;
    L97:
        boolean r114 = true;
    L99:
        Long r29 = r37.a;
        String r1 = r37.A;
        boolean r210 = i3.a.f();
        RecyclerView r2 = this.r;
        if (r2 != null) goto L102;
    L104:
        int r3 = 0;
    L105:
        IFlowSdkDepend r30 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r30 == null) goto L108;
        r30.N();
        String r211 = com.larus.home.impl.sdk.n1.a.i();
    L109:
        IFlowSdkDepend r31 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r31 == null) goto L112;
        r31.N();
        String r212 = com.larus.home.impl.sdk.n1.a.c(null);
    L113:
        IFlowSdkDepend r33 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r33 == null) goto L116;
        r33.N();
        String r34 = com.larus.home.impl.sdk.n1.a.d(null);
    L117:
        IFlowSdkDepend r35 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r35 == null) goto L120;
        r35.N();
        Integer r36 = com.larus.home.impl.sdk.n1.a.e(null);
    L121:
        tx9.b.b(r8, r41, r11, r7, "instruction", r15, r1, Integer.valueOf(r18), r19, r40, r110, r111, r112, r39, r38, Boolean.valueOf(r114), r42, r43, r44, r29, "chat_action_bar", r210, Integer.valueOf(r3), Integer.valueOf(r4), r211, r212, r34, r36, r32, null, 17088, 2);
        return;
    L120:
        r36 = null;
        goto L121
    L116:
        r34 = null;
        goto L117
    L112:
        r212 = null;
        goto L113
    L108:
        r211 = null;
        goto L109
    L102:
        if (ViewExtKt.h(r2) != true) goto L104;
        r3 = 1;
    L93:
        r28 = false;
    L96:
        if (ICreationAvatarService.a.v() == true) goto L97;
        r114 = false;
        goto L99
    L79:
        r32 = null;
    L76:
        r24 = false;
        goto L77
    L69:
        r112 = null;
        goto L70
    L65:
        r111 = null;
        goto L66
    L61:
        r110 = null;
    L57:
        r18 = 0;
        goto L58
    L51:
        r15 = null;
        goto L52
    L48:
        r14 = null;
        goto L49
    L44:
        r13 = null;
    L40:
        r11 = null;
    L34:
        r6 = "";
        goto L35
    L11:
        if (r41.longValue() != 0) goto L23;
        com.larus.bmhome.actionbar.model.p0 r45 = r37.o;
        if (r45 == null) goto L20;
        Integer r46 = r45.a;
        int r47 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r46 == null) goto L20;
        if (r46.intValue() != r47) goto L20;
        boolean r48 = true;
    L21:
        if (r48 == false) goto L23;
        r4 = 1;
    L20:
        r48 = false;
        goto L21
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.bmhome.view.actionbar.custom.u] */
    public CustomActionBar(ViewGroup r1, String r2, boolean r3, RecommendFrom r4, String r5, ICoreInputAbility r6, com.larus.bmhome.chat.component.fastsend.e0 r7, boolean r8, List<String> r9) {
        Intrinsics.checkNotNullParameter(r2, "actionBarScopeId");
        Intrinsics.checkNotNullParameter(r9, "blockedActionBarKeys");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.u = LazyKt.lazy(new s());
        this.v = LazyKt.lazy(new t());
        this.z = new u(this);
        this.E = new n();
        this.N = -1;
        this.R = CollectionsKt.emptyList();
        this.W = true;
        this.X = new e(this);
        this.Y = new d(this);
        this.Z = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean Y(CustomActionBar r32, int r33, com.larus.bmhome.actionbar.model.r r34, List r35, int r36, String r37, aq8.e r38, String r39, String r40, int r41) {
        Object r4 = null;
        if ((r41 & 16) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r41 & 32) == 0) goto L9;
        aq8.e r10 = null;
    L11:
        if ((r41 & 64) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r41 & 128) == 0) goto L17;
        String r2 = null;
    L18:
        Intrinsics.checkNotNullParameter(r35, "cache");
        if (r33 != 0) goto L22;
        FLogger.a.e("CustomActionBar", "message is not created by custom action bar");
        return false;
    L22:
        if (r33 != 25) goto L76;
        Iterator r0 = r35.iterator();
    L25:
        if (r0.hasNext() == false) goto L29;
        Object r6 = r0.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r6).b, r3) == false) goto L25;
    L30:
        com.larus.bmhome.actionbar.model.z0 r7 = (com.larus.bmhome.actionbar.model.z0) r6;
        if (r7 != null) goto L104;
    L91:
        com.larus.bmhome.actionbar.model.z0 r8 = r4;
        if (r8 != 0) goto L95;
        return false;
    L95:
        if (r33 != 11) goto L102;
        Integer r1 = r8.g;
        int r5 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r1 == null) goto L102;
        if (r1.intValue() != r5) goto L102;
        return false;
    L102:
        r(r32, r8, r34, r36, r9, r10, null, 32);
        return true;
    L104:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L39
        if (r2 == null) goto L36;
        Integer r12 = Integer.valueOf(CastIntegerProtector.parseInt(r2));     // Catch: Throwable -> L39
    L37:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r13) == false) goto L44;
        r13 = null;
    L44:
        Integer r14 = (Integer) r13;
        if (r14 == null) goto L91;
        int r15 = r14.intValue();
        com.larus.bmhome.actionbar.model.b1 r16 = r7.w;
        if (r16 == null) goto L91;
        List r17 = r16.a;
        if (r17 == null) goto L91;
        Iterator r18 = r17.iterator();
    L52:
        if (r18.hasNext() == false) goto L62;
        Object r19 = r18.next();
        Integer r20 = ((com.larus.bmhome.actionbar.model.c1) r19).e;
        if (r20 != null) goto L57;
    L59:
        boolean r21 = false;
    L60:
        if (r21 == false) goto L52;
    L63:
        com.larus.bmhome.actionbar.model.c1 r22 = (com.larus.bmhome.actionbar.model.c1) r19;
        if (r22 == null) goto L91;
        String r23 = r7.b;
        Long r110 = r7.a;
        com.larus.bmhome.actionbar.model.r r24 = new com.larus.bmhome.actionbar.model.r(Integer.valueOf(r33), null, r22.g, new com.larus.bmhome.actionbar.model.j1(Integer.valueOf(r15), 16776703), null, null, null, null, 4074);
        com.larus.bmhome.actionbar.model.h1 r25 = r22.g;
        if (r25 == null) goto L69;
        String r111 = r25.f;
    L70:
        if (r25 == null) goto L72;
        com.larus.bmhome.actionbar.model.g1 r112 = r25.d;
    L73:
        if (r25 == null) goto L75;
        r4 = r25.e;
    L75:
        r4 = new com.larus.bmhome.actionbar.model.z0(r110, r23, r112, r4, r111, null, null, null, null, null, r24, null, false, MapsKt.mapOf(TuplesKt.to("generate_podcast_scene", String.valueOf(r15))), null, -65568, 13);
        goto L91
    L72:
        r112 = null;
        goto L73
    L69:
        r111 = null;
        goto L70
    L57:
        if (r20.intValue() != r15) goto L59;
        r21 = true;
        goto L60
    L62:
        r19 = null;
        goto L63
    L36:
        r12 = null;
    L39:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L29:
        r6 = null;
        goto L30
    L76:
        Iterator r27 = r35.iterator();
    L78:
        if (r27.hasNext() == false) goto L90;
        Object r28 = r27.next();
        com.larus.bmhome.actionbar.model.r r29 = ((com.larus.bmhome.actionbar.model.z0) r28).q;
        if (r29 == null) goto L87;
        Integer r30 = r29.a;
        if (r30 == null) goto L87;
        if (r30.intValue() != r33) goto L87;
        boolean r31 = true;
    L88:
        if (r31 == false) goto L78;
        r4 = r28;
    L87:
        r31 = false;
    L90:
        r4 = (com.larus.bmhome.actionbar.model.z0) r4;
        goto L91
    L17:
        r2 = r40;
        goto L18
    L13:
        r3 = r39;
        goto L15
    L9:
        r10 = r38;
        goto L11
    L5:
        r9 = r37;
        goto L7
    }
}
