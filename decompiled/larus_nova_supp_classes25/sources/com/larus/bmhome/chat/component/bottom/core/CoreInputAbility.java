package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.a9;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.o4;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.taskskill.SkillComponent;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.bmhome.utils.RegisterHelper;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.chatinput.ChatMessageModifyTitleView;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.common.apphost.AppHost;
import com.larus.extension.diversion.api.HostDiversionServiceDelegate;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.conversation.InputLeftButtonStyle;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.api.creation.AudioResource;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.action.PromptReplacementCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionType;
import com.larus.platform.model.chat.MessageModifyStyle;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.spi.actionbar.ObricActionBarTrackServiceDelegate;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;
import zb8.e$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CoreInputAbility<T extends ComponentFeature & a9> implements ICoreInputAbility, va8.n, z8 {
    public static final String U = null;
    public final List<ICoreInputAbility.e> A;
    public final List<ICoreInputAbility.d> B;
    public final List<ICoreInputAbility.c> C;
    public boolean D;
    public ICoreInputAbility.f E;
    public final Lazy F;
    public boolean G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public boolean O;
    public Function1<? super Boolean, Unit> P;
    public boolean Q;
    public Boolean R;
    public boolean S;
    public Function0<Boolean> T;
    public final T a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final com.larus.ui.arch.vm.internal.l e;
    public final a9 f;
    public final Fragment g;
    public final Context h;
    public final Lazy i;
    public Function1<? super ICoreInputAbility.OnSendParams, Boolean> j;
    public z0 k;
    public Function2<? super Boolean, ? super Boolean, Unit> l;
    public Function2<? super Integer, ? super String, Unit> m;
    public Function5<? super MessageModifyMode, ? super String, ? super AttachmentInfo, ? super NestedFileContent, ? super String, Unit> n;
    public Function0<Unit> o;
    public Function1<? super String, Unit> p;
    public long q;
    public boolean r;
    public View.OnFocusChangeListener s;
    public boolean t;
    public Integer u;
    public Boolean v;
    public Boolean w;
    public Boolean x;
    public ICoreInputAbility.e y;
    public Function0<Boolean> z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[IAsrDirectFillAbility.DirectFillStatus.values().length];
            r0[IAsrDirectFillAbility.DirectFillStatus.FillBackClickSend.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[IAsrDirectFillAbility.DirectFillStatus.FillBackEdit.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[IAsrDirectFillAbility.DirectFillStatus.FillBackClear.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[MessageModifyStyle.values().length];
            r1[MessageModifyStyle.SMALL_BOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[MessageModifyStyle.FULL_BOX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class c implements zs8.a {
        public final /* synthetic */ com.larus.bmhome.actionbar.model.z0 a;
        public final /* synthetic */ CoreInputAbility<T> b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
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

        public final String getEnterMethod() {
            return "re_edit";
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

        public final String getBotId() {
            return this.b.getBotId();
        }

        public final String getChatType() {
            wc9.e r0 = this.b.h();
            if (r0 != null) goto L7;
            return null;
        L7:
            return ic8.n.f(r0);
        }

        public final String getClickFrom() {
            com.larus.bmhome.actionbar.model.r r0 = this.a.q;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0.b();
        }

        public c(com.larus.bmhome.actionbar.model.z0 r1, CoreInputAbility<T> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/larus/bmhome/chat/component/bottom/core/CoreInputAbility$startModify$whiteTeeIndexList$1$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class d extends TypeToken<ArrayList<Integer>> {
        public d() {
        }
    }

    @Override // va8.n
    public final void hideKeyboard() {
        qp(false);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void j9() {
        this.v = null;
        this.w = null;
        this.x = null;
        this.u = null;
        F().updateTakeOverConfig(new h1());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void uG() {
        this.P = null;
    }

    static {
        if (AppHost.a.isOversea() == false) goto L5;
        String r0 = "7241547611541340167";
    L6:
        U = r0;
        return;
    L5:
        r0 = "7234781073513644036";
        goto L6
    }

    public final y8 A() {
        return (y8) this.b.getValue();
    }

    public final boolean B() {
        return ((Boolean) this.I.getValue()).booleanValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Ba() {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        qp(false);
        C1(false, false, "");
    }

    public final rp8.d C() {
        return s1a.d.a(this.a).a(rp8.d.class);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean EK() {
        return !((com.larus.platform.model.chat.b) this.d.getValue()).b();
    }

    public final CoreInputViewModel F() {
        return (CoreInputViewModel) this.e.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void I40() {
        HashMap r2 = new HashMap();
        xe8.a r0 = this.g;
        if ((r0 instanceof xe8.a) == false) goto L5;
        r2.put("chat_key", Long.valueOf(r0.getChatUniqueKey()));
    L5:
        r2.put("click_from", "one_more_qa_take_photos");
        if (Build.VERSION.SDK_INT > 33) goto L8;
        FLogger.a.i("CoreInputAbility", "[hideImeBeforeStartCameraIfNeeded] hide ime before start camera");
        qp(true);
    L8:
        zb8.e r1 = A().P8();
        if (r1 == null) goto L12;
        e$a.b(r1, "edu_photo_search", r2, null, null, null, false, 124);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean J8() {
        return this.f.J8();
    }

    public final boolean K0() {
        boolean r0 = this.f.n5();
        if (e0() == true) goto L5;
        if (r0 == false) goto L9;
    L14:
        return false;
    L9:
        if (this.f.u7().length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return true;
    L11:
        r1 = false;
        goto L12
    L5:
        if (this.f.u7().length() != 0) goto L14;
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final com.larus.bmhome.chat.component.bottom.multimodal.sender.f Lk() {
        return new com.larus.bmhome.chat.component.bottom.multimodal.sender.f();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final String N5() {
        return this.f.u7();
    }

    public final void Q() {
        FLogger.a.i("CoreInputAbility", "[initSendFunction]");
        this.k = new z0(this);
        this.G = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean Q2() {
        return this.f.Q2();
    }

    public final boolean U() {
        int r0 = c9.a;
        rp8.a r1 = u();
        if (r1 == null) goto L5;
        Boolean r2 = r1.a;
    L7:
        return c9.a(r2, this.x, !F().takeOverConfig().v);
    L5:
        r2 = null;
        goto L7
    }

    public final boolean V() {
        boolean r2 = false;
        if (com.larus.platform.service.k2.a.e() == true) goto L7;
        FLogger.a.d("CoreInputAbility", "isAlwaysShowCameraActionEntrance setting isAttachmentLeftCameraEnabled=false");
        return false;
    L7:
        if (gj() == true) goto L10;
        FLogger.a.d("CoreInputAbility", "isAlwaysShowCameraActionEntrance isImageSupportMultiTake=false");
        return false;
    L10:
        int r0 = F().getActionShown();
        dr9.d r3 = s1a.d.a(this.a).a(dr9.d.class);
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L18;
    L22:
        boolean r5 = false;
    L23:
        if (r0 == 1) goto L28;
        if (r5 == true) goto L28;
        FLogger.a.d("CoreInputAbility", "isAlwaysShowCameraActionEntrance actionShown=" + r0);
        return false;
    L28:
        if (b0() == true) goto L31;
        FLogger.a.d("CoreInputAbility", "isAlwaysShowCameraActionEntrance isShowingAttachPanel=false");
        return false;
    L31:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r1 = A().f70();
        Object r6 = null;
        if (r1 == null) goto L34;
        List<UplinkFileEntity> r7 = r1.q1();
    L35:
        if (r7 == null) goto L49;
        Iterator<T> r8 = r7.iterator();
    L38:
        if (r8.hasNext() == false) goto L48;
        Object r9 = r8.next();
        UplinkFileEntity r10 = (UplinkFileEntity) r9;
        if (yc9.n1.d(r10) == false) goto L42;
    L45:
        boolean r11 = true;
    L46:
        if (r11 == false) goto L38;
        r6 = r9;
        goto L48
    L42:
        if (yc9.n1.e(r10) == true) goto L45;
        r11 = false;
    L48:
        r6 = (UplinkFileEntity) r6;
    L49:
        if (r6 != null) goto L57;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r12 = A().f70();
        if (r12 != null) goto L53;
    L55:
        boolean r13 = false;
    L56:
        if (r13 == true) goto L57;
    L58:
        FLogger.a.d("CoreInputAbility", "isAlwaysShowCameraActionEntrance hasAttachment=" + r2);
        return r2;
    L53:
        if (r12.XT() != true) goto L55;
        r13 = true;
    L57:
        r2 = true;
        goto L58
    L34:
        r7 = null;
        goto L35
    L18:
        if (c1() == false) goto L22;
        if (Intrinsics.areEqual(EW(), "inject_input_photo_picker") == false) goto L22;
        r5 = true;
        goto L23
    L13:
        if (r3.a != true) goto L15;
        r4 = true;
        goto L16
    }

    public final boolean X() {
        com.larus.bmhome.auth.c1 r0 = (com.larus.bmhome.auth.c1) AuthModelDelegate.b.a().getValue();
        if (r0 == null) goto L8;
        com.larus.bmhome.auth.h0 r1 = (com.larus.bmhome.auth.h0) r0.d;
        if (r1 == null) goto L8;
        String r2 = r1.b();
        if (r2 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r2, getBotId()) == false) goto L12;
    L15:
        boolean r3 = true;
    L16:
        com.larus.platform.service.z2 r4 = com.larus.platform.service.z2.a;
        if (r4.X().a() == false) goto L20;
        if (r3 == false) goto L20;
        boolean r5 = true;
    L22:
        if (r4.X().b() == false) goto L25;
        if (r3 == true) goto L25;
        boolean r6 = true;
    L26:
        if (r5 == true) goto L31;
        if (r6 == true) goto L32;
        return false;
    L32:
        return true;
    L31:
        return true;
    L25:
        r6 = false;
    L20:
        r5 = false;
        goto L22
    L12:
        if (com.larus.bmhome.utils.i.g(v()) == true) goto L15;
        r3 = false;
    L8:
        r2 = U;
        goto L10
    }

    public final boolean Y() {
        int r0 = c9.a;
        rp8.d r1 = C();
        if (r1 == null) goto L5;
        Boolean r2 = r1.a;
    L7:
        return c9.a(r2, this.w, !F().takeOverConfig().c);
    L5:
        r2 = null;
        goto L7
    }

    public final boolean Z() {
        int r0 = c9.a;
        rp8.d r1 = C();
        if (r1 == null) goto L5;
        Boolean r2 = r1.b;
    L7:
        return c9.a(r2, this.v, !F().takeOverConfig().f);
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean b9() {
        return this.f.b9();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean c2() {
        return this.f.c2();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void cp() {
        if (this.R != null) goto L6;
        return;
    L6:
        if (com.larus.platform.service.z2.a.enableRealtimeCallDowngrade() == true) goto L8;
        return;
    L8:
        boolean r3 = true;
        boolean r0 = VoiceCallServiceDelegate.a.q("voice_call", "plus_panel", true);
        if (r0 == this.Q) goto L18;
        this.Q = r0;
        if (Intrinsics.areEqual(this.R, Boolean.FALSE) == false) goto L13;
    L15:
        r3 = false;
    L16:
        R0(r3);
        return;
    L13:
        if (this.Q == true) goto L15;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean d9() {
        return this.f.d9();
    }

    public final boolean e0() {
        int r0 = c9.a;
        rp8.a r1 = u();
        if (r1 == null) goto L5;
        Boolean r2 = r1.c;
    L7:
        return c9.a(r2, null, ((Boolean) this.i.getValue()).booleanValue());
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void eo() {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (z0() == false) goto L56;
        com.larus.bmhome.instruction.g r0 = A().vc();
        if (r0 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L23;
        ys8.a r3 = A().DC();
        if (r3 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == true) goto L23;
        boolean r5 = false;
    L24:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r6 = A().f70();
        if (r6 == null) goto L27;
        r6.qe();
    L27:
        if (r5 == true) goto L29;
    L55:
        FLogger.a.i("CoreInputAbility", "[checkSendActionEnable] isInstructionOpen enableSend:" + r1);
        this.f.lh(r1);
        return;
    L29:
        if (this.f.Qu() == false) goto L55;
        com.larus.bmhome.instruction.g r7 = A().vc();
        if (r7 == null) goto L33;
        boolean r8 = r7.i3();
    L36:
        Boolean r9 = Boolean.valueOf(r8);
    L39:
        if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L55;
        Function0<Boolean> r10 = this.T;
        if (r10 != null) goto L43;
    L47:
        com.larus.bmhome.instruction.g r11 = A().vc();
        if (r11 != null) goto L50;
    L52:
        boolean r12 = false;
    L53:
        if (r12 == true) goto L55;
        r1 = true;
        goto L55
    L50:
        if (r11.P0() != true) goto L52;
        r12 = true;
        goto L53
    L43:
        if (((Boolean) r10.invoke()).booleanValue() != true) goto L45;
        boolean r13 = true;
    L46:
        if (r13 == false) goto L55;
    L45:
        r13 = false;
        goto L46
    L33:
        ys8.a r14 = A().DC();
        if (r14 == null) goto L37;
        r8 = r14.i3();
        goto L36
    L37:
        r9 = null;
        goto L39
    L17:
        if (r3.w4() != true) goto L19;
        r4 = true;
    L23:
        r5 = true;
        goto L24
    L10:
        if (r0.w4() != true) goto L12;
        r2 = true;
        goto L13
    L56:
        com.larus.bmhome.chat.component.bottom.reference.a r15 = A().g5();
        if (r15 != null) goto L59;
    L61:
        boolean r16 = false;
    L62:
        if (r16 == false) goto L71;
        com.larus.bmhome.chat.component.bottom.reference.a r17 = A().g5();
        if (r17 != null) goto L66;
    L68:
        boolean r18 = !r1;
        FLogger.a.i("CoreInputAbility", "[checkSendActionEnable] hasReferenceMsg enableSend:" + r18);
        this.f.lh(r18);
        return;
    L66:
        if (r17.VM() == true) goto L68;
        r1 = true;
        goto L68
    L71:
        return;
    L59:
        if (r15.i9() != true) goto L61;
        r16 = true;
        goto L62
    }

    public final boolean i() {
        IObricChatUIService r0 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return true;
    L10:
        com.larus.bmhome.instruction.g r2 = A().vc();
        if (r2 == null) goto L13;
        Integer r3 = Integer.valueOf(r2.Q1());
    L17:
        if (r3 != null) goto L20;
        return false;
    L20:
        if (r3.intValue() != 1) goto L23;
        return true;
    L23:
        return false;
    L13:
        ys8.a r4 = A().DC();
        if (r4 == null) goto L16;
        r3 = Integer.valueOf(r4.Q1());
        goto L17
    L16:
        r3 = null;
        goto L17
    L5:
        if (r0.r() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean l6() {
        return this.f.l6();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean lF() {
        return ((com.larus.platform.model.chat.b) this.d.getValue()).a();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean m9() {
        return this.f.m9();
    }

    public final void n0() {
        Iterator r0 = CollectionsKt.toList(this.B).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ICoreInputAbility.d) r0.next()).c();
        goto L4
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void o40() {
        FLogger.a.i("CoreInputAbility", "resetStatus");
        F().resetInputStatus();
    }

    public final void p0() {
        Iterator r0 = CollectionsKt.toList(this.B).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ICoreInputAbility.d) r0.next()).a();
        goto L4
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final g9.c q20() {
        return new g9.c(this.f.Dl());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void s9() {
        this.w = Boolean.TRUE;
        F().updateTakeOverConfig(new e1());
    }

    public final rp8.a u() {
        return s1a.d.a(this.a).a(rp8.a.class);
    }

    public final void v0() {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        if (F().getCurrentInputStatus() != 4) goto L64;
        com.larus.bmhome.instruction.g r0 = A().vc();
        boolean r2 = true;
        boolean r3 = false;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L22;
        com.larus.bmhome.instruction.g r4 = A().vc();
        if (r4 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == true) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L25;
        return;
    L25:
        boolean r7 = l(this.f.J8());
        if (this.f.u7().length() <= 0) goto L28;
        boolean r8 = true;
    L29:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r9 = A().f70();
        if (r9 != null) goto L32;
    L34:
        boolean r10 = false;
    L36:
        if (((com.larus.platform.model.chat.f0) this.c.getValue()).a != MessageModifyStyle.SMALL_BOX) goto L38;
        this.f.pQ(r7);
        this.f.lE(false);
    L45:
        a9 r11 = this.f;
        r11.FZ(4, r11.n5());
        Dr(r7);
        if (l(l0()) == false) goto L55;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r12 = A().f70();
        if (r12 != null) goto L50;
    L52:
        boolean r13 = false;
    L53:
        if (r13 == false) goto L55;
    L56:
        if (r2 == true) goto L58;
    L60:
        r3 = r2;
    L61:
        this.f.BF(r3);
        return;
    L58:
        if (c1() == false) goto L60;
    L50:
        if (r12.isVisible() == true) goto L52;
        r13 = true;
    L55:
        r2 = false;
        goto L56
    L38:
        this.f.pQ(true);
        this.f.lE(false);
        if (r8 == true) goto L43;
        if (r10 == true) goto L43;
        boolean r14 = false;
    L44:
        this.f.ZD(r14);
    L43:
        r14 = true;
        goto L44
    L32:
        if (r9.isVisible() != true) goto L34;
        r10 = true;
        goto L36
    L28:
        r8 = false;
        goto L29
    L17:
        if (r4.Q1() != 8) goto L19;
        r5 = true;
    L22:
        r6 = false;
        goto L23
    L10:
        if (r0.z0() != true) goto L12;
        r1 = true;
        goto L13
    }

    @Override // va8.n
    public final boolean w() {
        return this.f.w();
    }

    public final void x0() {
        if (((com.larus.platform.model.chat.f0) this.c.getValue()).a != MessageModifyStyle.FULL_BOX) goto L8;
        this.f.kU();
        this.f.ZD(false);
        oaa.a r0 = (oaa.a) this.K.getValue();
        if (r0 == null) goto L9;
        r0.gF(false, null);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void zi() {
        if (this.f.Mb() == false) goto L6;
        return;
    L6:
        if (A().f1().C() == false) goto L12;
        int r0 = com.larus.bmhome.chat.immerse.k0.a;
        Integer r1 = A().f1().m();
        if (r1 == null) goto L10;
        int r2 = r1.intValue();
    L11:
        int r3 = com.larus.bmhome.chat.immerse.k0.a(r2, 0.1f, 0.35f);
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(0);
        r4.setCornerRadius(v19.c7.b(16));
        r4.setColor(r3);
        this.f.m80(r4, r3);
        return;
    L10:
        r2 = 0;
        goto L11
    L12:
        this.f.Hs(v19.c7.b(16), v19.c.b(2130970534, null, 2131102545));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean Bd() {
        return F().getState().getEnableRealtimeCall();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean CS() {
        return l0();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean E50() {
        return F().showBottomMenu();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final String EW() {
        Bundle r0 = A().f1().a;
        if (r0 == null) goto L6;
        String r1 = r0.getString("inject_input_scene");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final MessageModifyMode FF() {
        return F().getModifyMode();
    }

    public final void I() {
        if (F().getModifyMode() != null) goto L7;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = A().f70();
        if (r0 == null) goto L7;
        r0.Es(false);
    L7:
        this.f.NI(false);
        this.f.ty(false);
        if (((com.larus.platform.model.chat.f0) this.c.getValue()).a != MessageModifyStyle.FULL_BOX) goto L11;
        this.f.ZD(false);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final CoreInputAbility JO() {
        F().updateTakeOverConfig(new t0());
        return this;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final z8.a Jd() {
        z8.a r1 = F().takeOverConfig();
        Boolean r2 = this.w;
        if (r2 != null) goto L11;
        rp8.d r3 = C();
        if (r3 == null) goto L8;
        r2 = r3.a;
    L9:
        if (r2 != null) goto L11;
        return r1;
    L8:
        r2 = null;
    L11:
        return z8.a.a(r1, false, false, !r2.booleanValue(), null, false, false, null, null, false, false, null, null, null, false, null, false, false, false, false, false, false, false, false, null, 16777211);
    }

    public final void N() {
        if (Z() == true) goto L5;
        this.f.r8(false, null);
        return;
    L5:
        z8.e r0 = F().takeOverConfig().g;
        if (r0 != null) goto L8;
        r0 = new z8.e(new CoreInputAbility$initInputPopupMenuAction$action$1(this), new CoreInputAbility$initInputPopupMenuAction$action$2(this));
    L8:
        this.f.r8(true, r0);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean Pi() {
        return F().isSupportMixTake();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void R8() {
        F().updateTakeOverConfig(new i0());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Rk() {
        com.larus.bmhome.instruction.g r0 = A().vc();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        com.larus.bmhome.instruction.g r3 = A().vc();
        CharSequence r4 = null;
        if (r3 == null) goto L22;
        if (r2 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L22;
        String r5 = r3.Un();
        if (r5 == null) goto L22;
        if (r5.length() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
    L23:
        if (r2 == false) goto L32;
        if (r5 != null) goto L32;
        rp8.d r7 = C();
        if (r7 == null) goto L28;
        CharSequence r8 = r7.f;
    L29:
        if (r8 != null) goto L32;
        return;
    L28:
        r8 = null;
    L32:
        if (com.larus.platform.service.z2.a.m3() == true) goto L34;
    L37:
        boolean r9 = true;
    L38:
        int r10 = c9.a;
        if (r9 == true) goto L49;
        CharSequence r11 = F().getCustomHint();
        if (r11 == null) goto L49;
        if (r11.length() <= 0) goto L46;
        boolean r12 = true;
    L47:
        if (r12 == false) goto L49;
    L50:
        if (r9 == true) goto L55;
        rp8.d r13 = C();
        if (r13 == null) goto L55;
        CharSequence r14 = r13.f;
    L56:
        IChatDoubleTabAbility r15 = A().wh();
        if (r15 == null) goto L67;
        String r16 = r15.y00();
        if (r16 == null) goto L67;
        if (r16.length() <= 0) goto L63;
        r1 = true;
    L63:
        if (r1 == false) goto L65;
        r4 = r16;
    L65:
        if (r4 == null) goto L67;
    L68:
        Intrinsics.checkNotNullParameter(r4, "fallbackHint");
        CharSequence r17 = r5;
        if (r5 != null) goto L75;
        if (r11 != null) goto L74;
        if (r14 != null) goto L73;
        r17 = r4;
        goto L75
    L73:
        r17 = r14;
        goto L75
    L74:
        r17 = r11;
    L75:
        y0(c(r17));
        return;
    L67:
        r4 = F().getBaseFallbackText$impl_mainlandRelease(AppHost.a.getApplication(), v(), w());
    L55:
        r14 = null;
        goto L56
    L46:
        r12 = false;
    L49:
        r11 = null;
        goto L50
    L34:
        if (IAIChatService.a.n8() == true) goto L37;
        r9 = false;
        goto L38
    L19:
        r6 = false;
    L22:
        r5 = null;
        goto L23
    L5:
        if (r0.z0() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final int Rp() {
        return F().getCurrentInputStatus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void V40() {
        A().cr();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean Wz() {
        if (lF() == false) goto L5;
    L8:
        return true;
    L5:
        if (EK() == false) goto L8;
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void X8() {
        F().updateTakeOverConfig(new v0());
    }

    public final boolean b0() {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = A().f70();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVisible();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean c1() {
        Bundle r0 = A().f1().a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("inject_input", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void c9() {
        rp8.a r0 = u();
        if (r0 == null) goto L5;
        Boolean r1 = r0.a;
    L7:
        if (r1 == null) goto L9;
        boolean r2 = true;
    L10:
        this.x = false;
        F().updateTakeOverConfig(new x0());
        if (r2 == false) goto L14;
        rE();
        return;
    L14:
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final boolean d() {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = A().f70();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.iJ() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void e9() {
        F().updateTakeOverConfig(new k1());
    }

    public final boolean f() {
        com.larus.bmhome.chat.component.cvs.y r0 = A().u0();
        if (r0 == null) goto L14;
        String r1 = r0.Y1();
        if (r1 == null) goto L14;
        if (r1.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L14;
    L16:
        if (B0(h()) == null) goto L19;
        return true;
    L19:
        if (ObricChatUIDelegate.b.d() == false) goto L21;
        return true;
    L21:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L24;
        r2.C0();
        hc9.d r4 = hc9.d.a;
    L24:
        return false;
    L9:
        r3 = false;
    L14:
        A().f1().g();
        goto L16
    }

    public final String getBotId() {
        com.larus.bmhome.chat.component.cvs.y r0 = A().u0();
        if (r0 == null) goto L6;
        String r1 = r0.getBotId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean gj() {
        return F().isImageSupportMultiTake();
    }

    public final wc9.e h() {
        wc9.e r0 = F().takeOverConfig().x;
        if (r0 != null) goto L9;
        com.larus.bmhome.chat.component.cvs.y r1 = A().u0();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.h();
    L9:
        return r0;
    }

    public final void k0() {
        F().setVoiceMixInput(true);
    }

    public final boolean k5() {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = A().f70();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        com.larus.bmhome.instruction.g r2 = A().vc();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r2.k5() != true) goto L14;
        r3 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r0.isVisible() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean l0() {
        if (c1() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f.Q2() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f.mM() == false) goto L9;
        goto L8
    }

    public final boolean n() {
        com.larus.bmhome.chat.component.bottom.reference.a r0 = A().g5();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        com.larus.bmhome.chat.component.bottom.reference.a r3 = A().g5();
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r1 == false) goto L19;
        if (r4 == true) goto L20;
        return false;
    L20:
        return true;
    L19:
        return true;
    L11:
        if (r3.LX() != true) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r0.i9() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void p() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        a9$a.a(this.f, new f2(this));
        return;
    L7:
        if (this.f.n5() == false) goto L10;
        this.f.ra();
        return;
    }

    public final BotModel q() {
        com.larus.bmhome.chat.component.cvs.y r0 = A().u0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void r9() {
        F().updateTakeOverConfig(new y0());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void rE() {
        com.larus.bmhome.instruction.g r0 = A().vc();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.Q1());
    L6:
        boolean r2 = false;
        if (od8.h0.a(r1) == true) goto L14;
        if (r1 != null) goto L11;
    L13:
        boolean r3 = false;
    L15:
        boolean r4 = n();
        boolean r5 = K0();
        int r6 = F().getCurrentInputStatus();
        if (r6 == 1) goto L33;
        if (r6 == 2) goto L30;
        if (r6 != 3) goto L22;
        if (r3 == false) goto L27;
    L37:
        r2 = true;
    L38:
        Dr(r2);
        return;
    L27:
        if (this.f.J8() == false) goto L38;
    L22:
        if (r6 != 4) goto L37;
        r2 = l(this.f.J8());
        goto L38
    L30:
        if (d() == true) goto L38;
    L33:
        if (d() == true) goto L36;
        if (r5 == false) goto L36;
        if (r4 == true) goto L37;
    L36:
        if (r3 == false) goto L38;
    L11:
        if (r1.intValue() != 8) goto L13;
    L14:
        r3 = true;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final com.larus.bmhome.chat.model.b0 tO() {
        return A().u5();
    }

    public final String v() {
        wc9.e r0 = F().takeOverConfig().x;
        if (r0 == null) goto L6;
        String r1 = r0.a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        com.larus.bmhome.chat.component.cvs.y r2 = A().u0();
        if (r2 != null) goto L12;
        return "";
    L12:
        return r2.Y1();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void w8() {
        F().updateTakeOverConfig(new r());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean wy() {
        if (F().isSupportMultiAudioTake() == false) goto L13;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        r0.getAccountService();
        if (com.larus.home.impl.sdk.d.a.a() != true) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        return true;
    L14:
        return false;
    L9:
        r1 = false;
        goto L10
    L13:
        return false;
    }

    public final String y() {
        Bundle r0 = A().f1().b;
        if (r0 == null) goto L5;
        String r1 = r0.getString("argBotId", "");
    L7:
        if (com.larus.utils.o0.d(r1) == false) goto L10;
        return r1;
    L10:
        return getBotId();
    L5:
        r1 = null;
        goto L7
    }

    public final boolean z0() {
        com.larus.bmhome.instruction.g r0 = A().vc();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        ys8.a r2 = A().DC();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r2.z0() != true) goto L14;
        r3 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r0.z0() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void zM() {
        boolean r0 = n();
        int r1 = F().getCurrentInputStatus();
        boolean r2 = true;
        boolean r3 = false;
        if (r1 != 1) goto L5;
        if (r0 == false) goto L41;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r4 = A().f70();
        if (r4 != null) goto L34;
    L36:
        boolean r5 = false;
    L37:
        if (r5 == false) goto L39;
    L42:
        if (r2 == true) goto L44;
    L46:
        r3 = r2;
    L47:
        this.f.BF(r3);
        return;
    L44:
        if (c1() == false) goto L46;
    L39:
        if (l0() == false) goto L41;
    L34:
        if (r4.isVisible() == true) goto L36;
        r5 = true;
    L41:
        r2 = false;
        goto L42
    L5:
        if (r1 == 2) goto L26;
        if (r1 != 3) goto L9;
        if (r0 == false) goto L41;
        if (l0() == false) goto L41;
    L9:
        if (r1 != 4) goto L42;
        if (l(l0()) == false) goto L41;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r6 = A().f70();
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L41;
    L16:
        if (r6.isVisible() == true) goto L18;
        r7 = true;
        goto L19
    L26:
        if (d() == true) goto L41;
        if (Jd().d.get(2) != null) goto L41;
        goto L41
    }

    public CoreInputAbility(CoreInputComponent r8) {
        Intrinsics.checkNotNullParameter(r8, "component");
        this.a = r8;
        this.b = LazyKt.lazy(new z(this));
        this.c = LazyKt.lazy(new l0());
        this.d = LazyKt.lazy(new m0());
        this.e = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CoreInputViewModel.class), Reflection.getOrCreateKotlinClass(CoreInputComponentState.class), new i2(r8), new j2(r8), k2.a);
        this.f = r8;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        this.g = com.larus.ui.arch.component.internal.attach.a.b(r8, r8);
        this.h = r8.getContext();
        this.i = LazyKt.lazy(new n0());
        this.j = new o0();
        this.l = new p0();
        this.m = new q0();
        this.n = new r0();
        this.o = new s0();
        this.p = new u0();
        this.s = new a0();
        this.y = new h2();
        this.z = new b0();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.F = LazyKt.lazy(new c0());
        this.H = LazyKt.lazy(new d0());
        this.I = LazyKt.lazy(new e0());
        this.J = LazyKt.lazy(new f0());
        this.K = LazyKt.lazy(new g0(this));
        this.L = LazyKt.lazy(new h0(this));
        this.M = LazyKt.lazy(new j0(this));
        this.N = LazyKt.lazy(new k0(this));
    }

    public static CharSequence c(CharSequence r4) {
        if (AppHost.a.getApplication().getResources().getConfiguration().screenWidthDp <= 360) goto L5;
        return r4;
    L5:
        if (StringsKt.endsWith$default(r4, "...", false, 2, null) == true) goto L7;
        return r4;
    L7:
        return r4.subSequence(0, r4.length() - 3);
    }

    public final Integer B0(wc9.e r6) {
        Bundle r0 = A().f1().b;
        String r1 = null;
        if (r0 != null) goto L5;
    L10:
        Integer r2 = null;
    L11:
        String r3 = v();
        int r4 = 0;
        if (r3.length() <= 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        r1 = r3;
    L17:
        if (r1 != null) goto L19;
        r1 = A().f1().g();
    L19:
        Lazy r7 = f9.a;
        if (r2 == null) goto L23;
        r4 = r2.intValue();
    L23:
        return f9.b(r6, r1, Integer.valueOf(r4));
    L14:
        r5 = false;
        goto L15
    L5:
        if (r0.containsKey("argBotConversationType") == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r2 = Integer.valueOf(r0.getInt("argBotConversationType"));
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void C8(final boolean r3) {
        F().updateTakeOverConfig(new f1(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean CD(boolean r2) {
        return F().enableSendFileMenu(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Dh(Function1<? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        ComponentViewModel.onEach$default(F(), CoreInputAbility$registerBottomMenuStatusCallback$1$1.INSTANCE, null, new CoreInputAbility$registerBottomMenuStatusCallback$1$2(r8, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Dn(ICoreInputAbility.f r4) {
        Intrinsics.checkNotNullParameter(r4, "mentionConfig");
        boolean r0 = !Intrinsics.areEqual(this.E, r4);
        if (this.D == false) goto L7;
        if (r0 == true) goto L7;
        boolean r1 = false;
    L8:
        this.E = r4;
        if (r1 == true) goto L11;
        return;
    L11:
        this.D = true;
        this.f.vJ(true, r4);
        return;
    L7:
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Dr(boolean r10) {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        rp8.a r0 = u();
        String r1 = null;
        if (r0 == null) goto L8;
        Boolean r2 = r0.a;
    L10:
        if (r2 == null) goto L12;
    L15:
        int r3 = 0;
        if (U() == true) goto L20;
        F().updateActionShownStatus(0);
        this.f.k3(false);
        return;
    L20:
        if (V() == false) goto L24;
        if (r10 == true) goto L24;
        FLogger.a.i("CoreInputAbility", "setActionEntranceVisible isAlwaysShowCameraActionEntrance=true");
        return;
    L24:
        int r4 = c9.a;
        rp8.a r5 = u();
        if (r5 == null) goto L27;
        Integer r6 = r5.b;
    L28:
        Integer r7 = this.u;
        int r8 = F().getState().getIndicatedActionEntrance();
        if (r7 == null) goto L31;
        r8 = r7.intValue();
    L33:
        int r9 = com.larus.platform.service.z2.a.getVoiceMixInputScene();
        FLogger r11 = FLogger.a;
        r11.i("CoreInputAbility", "[setActionEntranceVisible] visible:" + r10 + ", indicatedAction:" + r8 + ", voiceInputScene:" + r9);
        com.larus.bmhome.chat.component.bottom.voice.a r12 = (com.larus.bmhome.chat.component.bottom.voice.a) this.L.getValue();
        boolean r13 = true;
        if (r12 != null) goto L36;
    L38:
        boolean r14 = false;
    L39:
        if (r14 == false) goto L41;
    L46:
        if (r10 == false) goto L50;
        if (r8 == 0) goto L50;
        F().updateActionShownStatus(r8);
        this.f.LP(r8);
        return;
    L50:
        zb8.e r15 = A().P8();
        if (r15 != null) goto L53;
    L55:
        boolean r16 = false;
    L56:
        com.larus.bmhome.instruction.g r17 = A().vc();
        if (r17 != null) goto L59;
    L61:
        boolean r18 = false;
    L62:
        if (r16 == true) goto L81;
        if (r18 == true) goto L81;
        com.larus.bmhome.instruction.g r19 = A().vc();
        if (r19 != null) goto L67;
    L69:
        boolean r20 = false;
    L70:
        if (r20 == true) goto L81;
        if (r10 == true) goto L76;
        F().updateActionShownStatus(0);
        this.f.k3(false);
        return;
    L76:
        if (q() == null) goto L78;
    L80:
        int r21 = CoreInputViewModel.getActionShownByConf$default(F(), false, 1, null);
    L82:
        StringBuilder r22 = new StringBuilder("[setActionEntranceVisible] 2 visible:");
        r22.append(r10);
        r22.append(", actionShown:");
        r22.append(r21);
        r22.append(", botName:");
        BotModel r23 = q();
        if (r23 == null) goto L85;
        r1 = r23.getName();
    L85:
        r22.append(r1);
        r22.append(", cacheBottomLeftInputAction=");
        r22.append(f());
        r11.i("CoreInputAbility", r22.toString());
        com.larus.bmhome.instruction.g r24 = A().vc();
        if (r24 != null) goto L88;
    L90:
        boolean r25 = false;
    L91:
        if (r21 != 1) goto L103;
        if (r25 == false) goto L103;
        if (r18 == true) goto L103;
        com.larus.bmhome.instruction.g r26 = A().vc();
        if (r26 != null) goto L97;
    L99:
        r13 = false;
    L100:
        if (r13 == true) goto L103;
        F().updateActionShownStatus(0);
        this.f.k3(false);
        return;
    L97:
        if (r26.Xl() != true) goto L99;
    L103:
        CoreInputViewModel r27 = F();
        if (r10 == false) goto L106;
        int r28 = r21;
    L107:
        r27.updateActionShownStatus(r28);
        if (r10 == false) goto L110;
        r3 = r21;
    L110:
        this.f.LP(r3);
        return;
    L106:
        r28 = 0;
        goto L107
    L88:
        if (r24.z0() != true) goto L90;
        r25 = true;
        goto L91
    L78:
        if (f() == true) goto L80;
        r21 = 0;
        goto L82
    L67:
        if (r19.Xl() != true) goto L69;
        r20 = true;
    L81:
        r21 = 1;
        goto L82
    L59:
        if (r17.HM() != true) goto L61;
        r18 = true;
        goto L62
    L53:
        if (r15.bM() != true) goto L55;
        r16 = true;
        goto L56
    L41:
        if (K0() == true) goto L46;
        if (this.f.J8() == true) goto L46;
        F().updateActionShownStatus(0);
        this.f.k3(false);
        return;
    L36:
        if (r12.OL() != true) goto L38;
        r14 = true;
        goto L39
    L31:
        if (r6 == null) goto L33;
        r8 = r6.intValue();
        goto L33
    L27:
        r6 = null;
        goto L28
    L12:
        if (F().takeOverConfig().u == false) goto L15;
        FLogger.a.i("CoreInputAbility", "[setActionEntranceVisible] ignored because visibility is taken over, visible:" + r10);
        return;
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void E0(ICoreInputAbility.OnSendParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        n0();     // Catch: IllegalStateException -> L14
        if (this.G == true) goto L7;
    L8:
        FLogger.a.e("CoreInputAbility", "[doSend] onSend function is null, try init");     // Catch: IllegalStateException -> L14
        Q();     // Catch: IllegalStateException -> L14
        tx9.c0.A("not_init");     // Catch: IllegalStateException -> L14
    L9:
        z0 r0 = this.k;     // Catch: IllegalStateException -> L14
        if (r0 == null) goto L12;
        r0.invoke(r4, new g2());     // Catch: IllegalStateException -> L14
        return;
    L12:
        FLogger.a.e("CoreInputAbility", "[doSend] onSend function is still null");     // Catch: IllegalStateException -> L14
        tx9.c0.A("init_failed");     // Catch: IllegalStateException -> L14
        return;
    L7:
        if (this.k != null) goto L9;
    L14:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "doSend state error");
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Fz(ICoreInputAbility.c r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        if (((ArrayList) this.C).contains(r2) == true) goto L6;
        ((ArrayList) this.C).add(r2);
        return;
    }

    public final void G(Integer r13) {
        IAIChatControlTraceService.Companion r0 = IAIChatControlTraceService.a;
        r0.sb(v(), "album_input_left_icon");
        BotModel r1 = q();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getBotId();
    L6:
        wc9.e r5 = h();
        if (r5 == null) goto L9;
        String r6 = ic8.n.f(r5);
    L10:
        com.larus.bmhome.chat.component.bottom.reference.a r8 = A().g5();
        if (r8 == null) goto L13;
        String r9 = r8.wf();
    L14:
        com.larus.bmhome.chat.component.bottom.reference.a r10 = A().g5();
        if (r10 == null) goto L19;
        ReferenceInfo r11 = r10.T6();
        if (r11 == null) goto L19;
        r2 = r11.referencedMessageId;
    L19:
        IAIChatControlTraceService.a.a(r0, r3, "input_left_icon", 0, r6, null, null, r9, r2, 48);
        com.larus.bmhome.chat.component.bottom.multimodal.g r4 = A().r5();
        if (r4 != null) goto L22;
        return;
    L22:
        if (r13 == null) goto L24;
        int r14 = r13.intValue();
    L25:
        com.larus.bmhome.chat.component.bottom.multimodal.f1.a r7 = new com.larus.bmhome.chat.component.bottom.multimodal.f1.a(false, r14, 1);
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r12 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ChatInputActionEntranceAlbum, false);
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("upload_file_click_from", "input_left_icon");
        Unit r16 = Unit.INSTANCE;
        r4.n90(new com.larus.bmhome.chat.component.bottom.multimodal.e1(r7, r12, null, r15, 4));
        return;
    L24:
        r14 = 0;
        goto L25
    L13:
        r9 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void JJ(wc9.e r2) {
        F().updateSendConversation(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Jc(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        rp8.d r0 = C();
        if (r0 == null) goto L5;
        CharSequence r1 = r0.f;
    L6:
        if (r1 == null) goto L8;
        Rk();
        return;
    L8:
        M5(ws(r2, v()));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Jm(ICoreInputAbility.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.B).add(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void M5(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        CharSequence r3 = c(r2);
        if (F().takeOverConfig().e == false) goto L6;
        y0(r3);
        return;
    L6:
        rp8.d r0 = C();
        if (r0 == null) goto L9;
        CharSequence r1 = r0.f;
    L10:
        if (r1 == null) goto L12;
        F().setCustomHint(r3);
        Rk();
        return;
    L12:
        y0(r3);
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void O0(boolean r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("viewmodel ");
        r1.append(F());
        r1.append(", bot name: ");
        BotModel r2 = F().getBotModel();
        if (r2 == null) goto L5;
        String r3 = r2.getName();
    L6:
        r1.append(r3);
        r1.append(" [tryShowActionSpeech] isUpdateRealtime");
        r0.i("CoreInputAbility", r1.toString());
        a9 r5 = this.f;
        int r6 = com.larus.bmhome.utils.r.a;
        if (com.larus.bmhome.utils.r.a(s1a.a.g(this.g)).d == true) goto L9;
    L12:
        boolean r7 = false;
    L13:
        r5.sz(r7);
        return;
    L9:
        if (lW(F().getBotModel(), v()) == false) goto L12;
        if (r4 == false) goto L12;
        r7 = true;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void PZ(final wc9.e r3) {
        F().updateTakeOverConfig(new com.larus.bmhome.chat.component.bottom.core.b(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Q8(String r2) {
        this.f.Q8(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void QG(ICoreInputAbility.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.A).add(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean Qd(boolean r2) {
        return F().enableSendImageMenu(r2);
    }

    public final void R0(boolean r4) {
        FLogger.a.i("CoreInputAbility", "[updateActionEntranceRealtimeCallVisibility] visible:" + r4);
        F().getActionsVisible().put(4, Boolean.valueOf(r4));
        rE();
    }

    public final boolean S(Function1<? super ICoreInputAbility.e, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        return ((Boolean) r2.invoke(this.y)).booleanValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void S8(final boolean r3) {
        F().updateTakeOverConfig(new f(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean SE(String r2) {
        return Intrinsics.areEqual(r2, U);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void SV(Integer r6) {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        if (r6 == null) goto L7;
        int r7 = r6.intValue();
    L8:
        boolean r1 = true;
        if (r7 == 1) goto L11;
    L16:
        int r2 = r7;
    L17:
        FLogger.a.i("CoreInputAbility", "[reapplyInputStatus] base:" + r7 + ", resolved:" + r2);
        g2(r2, false);
        return;
    L11:
        if (this.f.u7().length() > 0) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L16;
        r2 = 3;
        goto L17
    L7:
        r7 = F().getCurrentInputStatus();
        goto L8
    }

    public final void T0(BotModel r10) {
        wc9.e r0 = h();
        Integer r1 = B0(r0);
        boolean r2 = F().hasActionBarConfig();
        boolean r4 = true;
        if (r0 != null) goto L21;
        Bundle r6 = A().f1().b;
        if (r6 == null) goto L7;
        Serializable r7 = r6.getSerializable("conversation_page");
    L9:
        if ((r7 instanceof ConversationPage) == false) goto L11;
        ConversationPage r8 = (ConversationPage) r7;
    L12:
        if (r8 == null) goto L14;
        boolean r9 = Intrinsics.areEqual(r8.getShowActionBar(), Boolean.TRUE);
    L15:
        if (r9 == false) goto L18;
        if (r2 == false) goto L18;
        Integer r3 = Integer.valueOf(InputLeftButtonStyle.ButtonStyle_Instruction.getValue());
    L46:
        F().setLeftActionStyle(r3, com.larus.bmhome.utils.i.f(r0));
        if (r1 == null) goto L58;
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("[MainConversationInputFallback] apply resolvedStyle=");
        r12.append(r1);
        r12.append(" finalStyle=");
        r12.append(r3);
        r12.append(" actionShown=");
        r12.append(CoreInputViewModel.getActionShownByConf$default(F(), false, 1, null));
        r12.append(" conversationPresent=");
        if (r0 == null) goto L51;
        boolean r5 = true;
    L52:
        r12.append(r5);
        r12.append(" botPresent=");
        if (r10 == null) goto L55;
        boolean r13 = true;
    L56:
        r12.append(r13);
        r11.i("CoreInputAbility", r12.toString());
        goto L58
    L55:
        r13 = false;
        goto L56
    L51:
        r5 = false;
    L58:
        if (o4.a() == false) goto L60;
    L63:
        boolean r14 = true;
    L65:
        if (CoreInputViewModel.isActionShowFile$default(F(), false, 1, null) == false) goto L67;
    L70:
        if (r14 == true) goto L72;
        if (r4 == true) goto L72;
        return;
    L72:
        F().updateActionsVisible();
        zM();
        rE();
        return;
    L67:
        if (CoreInputViewModel.isActionShowImgOrCamera$default(F(), false, 1, null) == true) goto L70;
        r4 = false;
        goto L70
    L60:
        if (FeatureKitDelegate.b.m0().b() == true) goto L63;
        r14 = false;
    L18:
        if (r1 != null) goto L20;
        r3 = F().getLefBottomCacheByConversation(v());
        goto L46
    L20:
        r3 = r1;
        goto L46
    L14:
        r9 = false;
        goto L15
    L11:
        r8 = null;
        goto L12
    L7:
        r7 = null;
        goto L9
    L21:
        if (r10 == null) goto L25;
        ConversationPage r15 = r10.getConversationPage();
        if (r15 == null) goto L25;
        boolean r16 = Intrinsics.areEqual(r15.getShowActionBar(), Boolean.TRUE);
    L26:
        if (r16 == false) goto L29;
        if (r2 == false) goto L29;
        r3 = Integer.valueOf(InputLeftButtonStyle.ButtonStyle_Instruction.getValue());
    L45:
        F().updateLefBottomCacheByConversation(r0.a, r3);
    L29:
        Lazy r17 = com.larus.im.j.a;
        boolean r18 = com.larus.im.j.f(r0.a);
        if (com.larus.platform.service.z2.a.enableLeftActionCameraShow() == false) goto L35;
        if (r18 == true) goto L33;
    L39:
        boolean r19 = false;
    L40:
        if (r1 != null) goto L44;
        if (r19 == false) goto L43;
        r3 = null;
        goto L45
    L43:
        r3 = r0.C;
        goto L45
    L44:
        r3 = r1;
        goto L45
    L33:
        if (com.larus.bmhome.utils.i.f(r0) == true) goto L39;
    L38:
        r19 = true;
        goto L40
    L35:
        if (r18 == false) goto L39;
        if (ic8.n.D(r0) == false) goto L39;
    L25:
        r16 = false;
        goto L26
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Vs(ICoreInputAbility.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.A).remove(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void W8(final z8.c r3) {
        F().updateTakeOverConfig(new u(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void XG(ICoreInputAbility.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.B).remove(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void YT(ICoreInputAbility.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.y = r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Yk(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        y0(c(r2));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void a9(final boolean r3) {
        F().updateTakeOverConfig(new y(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void aR(String r12) {
        Intrinsics.checkNotNullParameter(r12, "content");
        boolean r1 = false;
        if (r12.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        ICoreInputAbility.b.d(this, r12, false, false, null, null, false, 60);
        if (z0() == true) goto L10;
    L14:
        g2(3, true);
    L15:
        com.larus.bmhome.instruction.g r13 = A().vc();
        if (r13 == null) goto L18;
        r13.BP();
        goto L18
    L10:
        if (r12.length() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L14;
        g2(1, true);
    L18:
        Rk();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void f40(SkillComponent.l r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.C).remove(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void f9(final boolean r3) {
        F().updateTakeOverConfig(new com.larus.bmhome.chat.component.bottom.core.c(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean fa(be8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "skill");
        return this.f.fa(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void g9(final Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "eventInfo");
        F().updateTakeOverConfig(new m1(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void gX(boolean r4) {
        FLogger.a.i("CoreInputAbility", "[setSpeakTouchEnabled] enabled:" + r4);
        com.larus.asr.e2 r0 = A().Vl();
        if (r0 == null) goto L5;
        r0.nR(r4);
    L5:
        this.f.Mk(r4);
        this.f.d60(1.0f);
        this.f.NH();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void iN(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickActionSend");
        this.z = r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final CoreInputAbility kO(final z8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        F().updateTakeOverConfig(new o(r3));
        return this;
    }

    public final boolean l(boolean r4) {
        if (this.f.u7().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        if (r4 == true) goto L10;
        boolean r5 = false;
    L11:
        if (r5 == true) goto L13;
    L15:
        return false;
    L13:
        if (n() == false) goto L15;
        return true;
    L10:
        r5 = true;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void l9(final z8.b r3) {
        F().updateTakeOverConfig(new com.larus.bmhome.chat.component.bottom.core.d(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void m1(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.f.m1(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean m2(String r7) {
        Intrinsics.checkNotNullParameter(r7, "asrResult");
        if (this.f.Mb() == false) goto L6;
        return false;
    L6:
        if (StringsKt.isBlank(r7) == false) goto L8;
    L18:
        return false;
    L8:
        if (l6() == false) goto L18;
        String r0 = this.f.u7();
        if (r0.length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        return false;
    L16:
        FLogger.a.i("CoreInputAbility", "[appendAsrResultIfVoiceRetained] append asr result to existing text");
        qB(r0 + r7, false, false, true);
        return true;
    L13:
        r2 = false;
        goto L14
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void n9(final boolean r3) {
        F().updateTakeOverConfig(new s(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void oz(boolean r3) {
        this.f.B10(r3, this.E);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void p80(boolean r2) {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        qp(false);
    L7:
        this.f.fH();
        paa.c r3 = (paa.c) this.N.getValue();
        if (r3 == null) goto L11;
        r3.CZ();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void pS(Function0<Boolean> r1) {
        this.T = r1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void qp(boolean r4) {
        FLogger.a.i("CoreInputAbility", "hideIme: ");
        this.f.o7(r4);
        com.larus.bmhome.chat.component.bottom.reference.a r5 = A().g5();
        if (r5 == null) goto L5;
        r5.mE();
    L5:
        p();
        com.larus.bmhome.instruction.g r6 = A().vc();
        if (r6 == null) goto L8;
        r6.T1();
    L8:
        ys8.a r7 = A().DC();
        if (r7 == null) goto L12;
        r7.T1();
        return;
    }

    public final ChatPageContext r(ICoreInputAbility.OnSendParams r2) {
        if (r2 == null) goto L6;
        ChatPageContext r3 = r2.chatPageContext;
        if (r3 == null) goto L6;
        return r3;
    L6:
        return (ChatPageContext) s1a.d.a(this.a).a(ChatPageContext.class);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void r7(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.r7(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void s20(int r2) {
        this.u = Integer.valueOf(r2);
        F().indicateActionEntrance(r2);
        rE();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void s3(long r2) {
        com.larus.asr.e2 r0 = A().Vl();
        if (r0 == null) goto L6;
        r0.s3(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void sQ(com.larus.bmhome.chat.component.title.f0 r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        ComponentViewModel.onEach$default(F(), CoreInputAbility$observeOnEnableRealTimeCallChanged$1.INSTANCE, null, new CoreInputAbility$observeOnEnableRealTimeCallChanged$2(r8, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void setEnabled(boolean r7) {
        FLogger.a.i("CoreInputAbility", "[setEnabled] enabled:" + r7);
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        if (r7 == false) goto L15;
        com.larus.bmhome.instruction.g r2 = A().vc();
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        return;
    L10:
        if (r2.P0() != true) goto L12;
        r3 = true;
    L15:
        if (r7 == true) goto L17;
    L19:
        this.f.t30(r7);
        this.f.w20(r7);
        a9 r4 = this.f;
        float r5 = 1.0f;
        if (r7 == false) goto L22;
        float r6 = 1.0f;
    L23:
        r4.bP(r6);
        this.f.DV(r7);
        a9 r8 = this.f;
        if (r7 == false) goto L26;
        float r9 = 1.0f;
    L27:
        r8.d60(r9);
        this.f.p40(r7);
        this.f.gy(r7);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r10 = A().f70();
        if (r10 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == false) goto L42;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r12 = A().f70();
        if (r12 != null) goto L37;
    L39:
        r0 = false;
    L40:
        if (r0 == false) goto L42;
        this.f.lh(r7);
        goto L42
    L37:
        if (r12.VS() != true) goto L39;
    L42:
        this.f.oJ(r7);
        a9 r1 = this.f;
        if (r7 == true) goto L46;
        r5 = 0.3f;
    L46:
        r1.qu(r5);
        this.f.d10(r7);
        if (r7 == true) goto L49;
        this.f.w20(false);
        qp(false);
    L49:
        eo();
        return;
    L30:
        if (r10.isVisible() != true) goto L32;
        r11 = true;
        goto L33
    L26:
        r9 = 0.3f;
        goto L27
    L22:
        r6 = 0.4f;
        goto L23
    L17:
        if (com.larus.platform.service.i3.a.a() == false) goto L19;
    }

    public final void t0(String r39) {
        Intrinsics.checkNotNullParameter(r39, "clickFrom");
        com.larus.bmhome.instruction.g r0 = A().vc();
        boolean r33 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        com.larus.bmhome.instruction.g r2 = A().vc();
        if (r2 == null) goto L21;
        r2.LW();
    L21:
        com.larus.bmhome.instruction.g r3 = A().vc();
        if (r3 == null) goto L24;
        List r4 = r3.tq();
    L25:
        Map r5 = IAIChatRenderTraceService.a.i();
        if (r5 == null) goto L37;
        String r6 = (String) r5.get("key_current_page");
        if (r6 != null) goto L30;
    L35:
        r6 = "";
    L36:
        String r7 = r6;
    L38:
        BotModel r8 = q();
        if (r8 == null) goto L41;
        String r9 = r8.getBotId();
    L42:
        Long r10 = StringsKt.toLongOrNull(v());
        LruCache r11 = ko8.a.a;
        wc9.e r12 = h();
        if (r12 == null) goto L45;
        Integer r13 = r12.v;
    L46:
        BotModel r14 = q();
        if (r14 == null) goto L49;
        Integer r15 = r14.getBotType();
    L50:
        BotModel r16 = q();
        if (r16 == null) goto L55;
        BotCreatorInfo r17 = r16.getBotCreatorInfo();
        if (r17 == null) goto L55;
        String r18 = r17.getId();
    L56:
        String r19 = ko8.a.f(r13, r15, Intrinsics.areEqual(r18, AccountService.a.getUserId()));
        if (r4 == null) goto L65;
        com.larus.bmhome.actionbar.model.z0 r20 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r4);
        if (r20 == null) goto L65;
        com.larus.bmhome.actionbar.model.r r21 = r20.q;
        if (r21 == null) goto L65;
        Integer r22 = r21.a;
        if (r22 == null) goto L65;
        int r23 = r22.intValue();
    L66:
        if (r4 == null) goto L70;
        com.larus.bmhome.actionbar.model.z0 r24 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r4);
        if (r24 == null) goto L70;
        String r25 = r24.b;
    L71:
        if (r4 == null) goto L77;
        com.larus.bmhome.actionbar.model.z0 r26 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r4);
        if (r26 == null) goto L77;
        com.larus.bmhome.actionbar.model.r r27 = r26.q;
        if (r27 == null) goto L77;
        String r35 = r27.g;
    L78:
        if (r4 == null) goto L82;
        com.larus.bmhome.actionbar.model.z0 r28 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r4);
        if (r28 == null) goto L82;
        Long r36 = r28.a;
    L83:
        if (r4 == null) goto L87;
        com.larus.bmhome.actionbar.model.z0 r29 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r4);
        if (r29 == null) goto L87;
        String r37 = r29.A;
    L88:
        String r30 = r9;
        String r31 = r37;
        tx9.b.b(r30, null, r10, r7, "instruction", r19, r31, Integer.valueOf(r23), r25, null, null, null, r35, "show_edit_button", r39, null, null, null, 1, r36, "chat_action_bar", com.larus.platform.service.i3.a.f(), null, null, null, null, null, null, null, null, -63376702, 3);
        if (r1 == true) goto L111;
        com.larus.bmhome.instruction.h r32 = A().yJ();
        if (r32 == null) goto L96;
        String r34 = y();
        if (r34 != null) goto L95;
        r34 = "";
    L95:
        com.larus.bmhome.actionbar.model.z0 r38 = r32.Kp(r34);
    L97:
        if (r38 == null) goto L112;
        com.larus.bmhome.instruction.g r40 = A().vc();
        if (r40 == null) goto L104;
        if (r40.Ty() != true) goto L104;
        r33 = true;
    L104:
        if (r33 == false) goto L106;
        int r110 = 4;
    L107:
        com.larus.bmhome.instruction.h r41 = A().yJ();
        if (r41 == null) goto L113;
        com.larus.bmhome.instruction.h.a.a(r41, r38, r110, null, 24);
        return;
    L113:
        return;
    L106:
        r110 = 1;
        goto L107
    L112:
        return;
    L96:
        r38 = null;
        goto L97
    L111:
        return;
    L87:
        r37 = null;
    L82:
        r36 = null;
    L77:
        r35 = null;
    L70:
        r25 = null;
    L65:
        r23 = 0;
    L55:
        r18 = null;
        goto L56
    L49:
        r15 = null;
        goto L50
    L45:
        r13 = null;
        goto L46
    L41:
        r9 = null;
        goto L42
    L30:
        if (com.larus.utils.o0.d(r6) == true) goto L33;
        r6 = null;
    L33:
        if (r6 == null) goto L35;
    L37:
        r7 = "";
        goto L38
    L24:
        r4 = null;
        goto L25
    L12:
        com.larus.bmhome.instruction.g r42 = A().vc();
        if (r42 != null) goto L15;
    L17:
        boolean r43 = false;
    L18:
        if (r43 == false) goto L21;
        FLogger.a.i("CoreInputAbility", "instruction input already open do nothing");
        return;
    L15:
        if (r42.z0() != true) goto L17;
        r43 = true;
        goto L18
    L5:
        if (r0.rA() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void t9(final z8.d r3) {
        F().updateTakeOverConfig(new t(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void tr(Function1<? super ICoreInputAbility.OnSendParams, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.j = r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void uh(int r2) {
        if (r2 == 0) goto L4;
        return;
    L4:
        if (Rp() != 4) goto L8;
        this.o.invoke();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void uq(boolean r4) {
        FLogger.a.i("CoreInputAbility", "[setBottomMenuEntranceVisible] visible:" + r4);
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        this.t = !r4;
        if (r4 == false) goto L8;
    L11:
        zM();
        return;
    L8:
        if (F().showBottomMenu() == false) goto L11;
        C1(false, true, "config");
        this.f.Nv(false);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void uw(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.P = r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void v6(Function2<? super Integer, ? super Long, Unit> r2) {
        this.f.v6(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void v9(final Function0<Boolean> r3) {
        F().updateTakeOverConfig(new v(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void w9(final boolean r3) {
        F().updateTakeOverConfig(new p(r3));
    }

    public final void y0(CharSequence r2) {
        if (this.f.u7().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.f.xP();
        this.f.bm(r2);
    L8:
        F().updateInputTextHint(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void z9(final boolean r3) {
        F().updateTakeOverConfig(new w(r3));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void zk(String r19) {
        Intrinsics.checkNotNullParameter(r19, "clickFrom");
        LruCache r2 = ko8.a.a;
        IAIChatControlTraceService.a.xb().put(v(), r19);
        com.larus.bmhome.actionbar.model.z0 r7 = null;
        if (Intrinsics.areEqual(r19, "input_left_icon") == false) goto L18;
        if (c1() == false) goto L15;
        Bundle r3 = A().f1().a;
        String r8 = "";
        if (r3 == null) goto L13;
        String r4 = r3.getString("inject_input_scene", "");
        if (r4 == null) goto L13;
        r8 = r4;
    L13:
        if (Intrinsics.areEqual(r8, "inject_input_photo_picker") == false) goto L15;
    L16:
        String r10 = r8;
        FLogger r5 = FLogger.a;
        r5.i("CoreInputAbility", "[tryToCameraPage] clickFrom:" + r19 + ", scene:" + r10);
        Bundle r9 = A().f1().a;
        if (r9 == null) goto L62;
        String r11 = r9.getString("inject_input_album_node_id");
        if (r11 == null) goto L62;
        if (kq9.b.c(r11) == false) goto L62;
    L63:
        if (r11 != null) goto L65;
    L70:
        CameraResultRoute r13 = null;
    L71:
        HashMap r12 = new HashMap();
        xe8.a r14 = this.g;
        if ((r14 instanceof xe8.a) == false) goto L75;
        r12.put("chat_key", Long.valueOf(r14.getChatUniqueKey()));
    L77:
        r12.put("click_from", r19);
        if (r11 != null) goto L80;
    L82:
        com.larus.bmhome.instruction.g r15 = A().vc();
        if (r15 == null) goto L85;
        r7 = r15.yF();
    L85:
        if (r7 == null) goto L89;
        Integer r16 = r7.g;
        if (r16 == null) goto L89;
        r12.put("action_bar_template_id", String.valueOf(r16.intValue()));
    L89:
        if (r7 == null) goto L95;
        com.larus.bmhome.actionbar.model.r r17 = r7.q;
        if (r17 == null) goto L95;
        String r18 = r17.g;
        if (r18 == null) goto L95;
        r12.put("action_bar_template_type", r18);
    L95:
        if (r7 == null) goto L99;
        String r20 = r7.b;
        if (r20 == null) goto L99;
        r12.put("action_bar_key", r20);
    L99:
        if (r7 == null) goto L114;
        com.larus.bmhome.actionbar.model.r r21 = r7.q;
        if (r21 == null) goto L114;
        Integer r22 = r21.a;
        if (r22 == null) goto L114;
        int r23 = r22.intValue();
        r12.put("action_bar_instruction_type", Integer.valueOf(r23));
        int r24 = od8.h0.a;
        if (od8.h0.f(Integer.valueOf(r23)) == false) goto L107;
    L108:
        com.larus.bmhome.instruction.g r25 = A().vc();
        if (r25 == null) goto L114;
        String r26 = r25.gm();
        if (r26 == null) goto L114;
        r12.put("action_bar_instruction_items_template", r26);
        goto L114
    L107:
        if (od8.h0.i(Integer.valueOf(r23)) == true) goto L108;
    L114:
        if (Build.VERSION.SDK_INT > 33) goto L116;
        r5.i("CoreInputAbility", "[hideImeBeforeStartCameraIfNeeded] hide ime before start camera");
        qp(true);
    L116:
        zb8.e r27 = A().P8();
        if (r27 != null) goto L119;
        return;
    L119:
        if (Intrinsics.areEqual(r19, "input_left_icon") == true) goto L121;
    L125:
        boolean r110 = false;
    L126:
        e$a.b(r27, r10, r12, null, r13, null, r110, 44);
        return;
    L121:
        if (c1() == true) goto L123;
    L124:
        r110 = true;
        goto L126
    L123:
        if (Intrinsics.areEqual(EW(), "inject_input_photo_picker") == false) goto L125;
    L80:
        if (uy8.b.c() == false) goto L82;
        r12.put("CAMERA_RETURN_ALBUM_NODE_ID", r11);
        goto L82
    L75:
        if ((r14 instanceof op8.g) == false) goto L77;
        r12.put("chat_key", Long.valueOf(((op8.g) r14).getChatUniqueKey()));
        goto L77
    L65:
        if (uy8.b.c() == false) goto L67;
        String r111 = r11;
    L68:
        if (r111 == null) goto L70;
        r13 = new CameraResultRoute(r111, CameraResultRoute.Delivery.CONFIRM_TO_OWNER);
        goto L71
    L67:
        r111 = null;
    L62:
        r11 = null;
    L15:
        r8 = "common_input";
        goto L16
    L18:
        if (Intrinsics.areEqual(r19, "chat_action_bar") == false) goto L54;
        com.larus.bmhome.instruction.g r6 = A().vc();
        if (r6 == null) goto L22;
        Integer r28 = Integer.valueOf(r6.Q1());
    L23:
        int r29 = od8.h0.a;
        if (r28 != null) goto L27;
    L29:
        boolean r30 = false;
    L30:
        if (r30 == false) goto L33;
        r8 = "health_report";
        goto L16
    L33:
        if (od8.h0.d(r28) == false) goto L35;
        r8 = "edu_photo_search";
        goto L16
    L35:
        if (r28 != null) goto L38;
    L40:
        boolean r31 = false;
    L41:
        if (r31 == false) goto L43;
        r8 = "edu_article_correct";
        goto L16
    L43:
        if (r28 != null) goto L46;
    L48:
        boolean r32 = false;
    L49:
        if (r32 == false) goto L52;
        r8 = "edu_calculation_correct";
        goto L16
    L52:
        if (od8.h0.b(r28) == false) goto L54;
        r8 = "edu_homework_correct";
        goto L16
    L46:
        if (r28.intValue() != 13) goto L48;
        r32 = true;
        goto L49
    L38:
        if (r28.intValue() != 12) goto L40;
        r31 = true;
        goto L41
    L27:
        if (r28.intValue() != 14) goto L29;
        r30 = true;
        goto L30
    L22:
        r28 = null;
    L54:
        r8 = "default";
        goto L16
    }

    public static Image D(Message r3, List r4) {
        String r1 = null;
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{4, 16, 18, 24}), ic8.j.b(r3)) == true) goto L5;
        return null;
    L5:
        Message r5 = com.larus.bmhome.chat.adapter.f0.b(r3, r4);
        if (r5 != null) goto L9;
        return null;
    L9:
        if (r5.getContentType() == 6) goto L11;
        return null;
    L11:
        List r6 = com.larus.bmhome.chat.bean.d.g(r5).imageList;
        if (r6 == null) goto L20;
        Image r7 = (Image) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L21;
        Map r8 = r5.getBusinessExt();
        if (r8 == null) goto L18;
        r1 = (String) r8.get("send_image_local_path");
    L18:
        r7.localResPath = r1;
        return r7;
    L21:
        return null;
    L20:
        return null;
    }

    public static void H0(String r2, String r3) {
        if (com.larus.utils.o0.d(r2) == false) goto L10;
        IAIChatControlTraceService.Companion r0 = IAIChatControlTraceService.a;
        if (Intrinsics.areEqual(r2, IAIChatRenderTraceService.a.f(r3)) == false) goto L7;
        String r4 = "use_template";
    L8:
        IAIChatControlTraceService.a.e(r0, r4);
        return;
    L7:
        r4 = "change_template";
        goto L8
    }

    public final boolean A0(boolean r4, boolean r5) {
        int r0 = c9.a;
        rp8.d r1 = C();
        Boolean r2 = null;
        if (r1 == null) goto L5;
        Boolean r3 = r1.d;
    L7:
        if (this.t == true) goto L9;
        if (r5 == true) goto L9;
    L10:
        Boolean r6 = Boolean.FALSE;
        if (Intrinsics.areEqual(r3, r6) == false) goto L13;
    L16:
        return false;
    L13:
        if (Intrinsics.areEqual(r2, r6) == true) goto L16;
        if (r4 == false) goto L16;
        return true;
    L9:
        r2 = Boolean.FALSE;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public final String E(String r6, String r7) {
        com.larus.bmhome.chat.component.bottom.voice.a r0 = A().Zd();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = null;
        if (r2 == false) goto L22;
        com.larus.bmhome.chat.component.bottom.voice.a r4 = A().Zd();
        if (r4 == null) goto L22;
        com.larus.bmhome.chat.component.bottom.voice.service.h r5 = r4.Hw();
        if (r5 == null) goto L22;
        if ((!r5.b) == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L22;
        CharSequence r8 = r5.a;
        if (r8 == null) goto L22;
        String r9 = r8.toString();
    L23:
        if (r9 != null) goto L26;
        if (r6 != null) goto L28;
        r6 = r7;
    L28:
        if (F().takeOverConfig().q == false) goto L30;
        return r6;
    L30:
        com.larus.bmhome.instruction.g r10 = A().vc();
        if (r10 == null) goto L42;
        String r11 = r10.kb(r6);
        if (r11 != null) goto L35;
        return r6;
    L35:
        if (r11.length() <= 0) goto L37;
        r1 = true;
    L37:
        if (r1 == false) goto L39;
        r3 = r11;
    L39:
        if (r3 != null) goto L41;
        return r6;
    L41:
        return r3;
    L42:
        return r6;
    L26:
        r6 = r9;
    L22:
        r9 = null;
        goto L23
    L5:
        if (r0.DG() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void M0(String r4, boolean r5) {
        this.S = r5;
        boolean r1 = true;
        g2(4, true);
        this.S = false;
        this.f.u40(r4);
        if (r5 == false) goto L11;
        com.larus.bmhome.instruction.g r6 = A().vc();
        if (r6 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == true) goto L11;
        return;
    L7:
        if (r6.HM() != true) goto L9;
    L11:
        this.f.S9(200, new d1(this));
    }

    @Deprecated(message = "暂时收敛在CoreInputAbility")
    public final void N0(int r14, boolean r15) {
        FLogger r0 = FLogger.a;
        r0.i("CoreInputAbility", "switchCoreInputStatus: " + r14 + ", saveStatus:" + r15);
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        oaa.a r1 = (oaa.a) this.K.getValue();
        if (r1 == null) goto L9;
        r1.pM(r14);
    L9:
        if (r14 == 4) goto L16;
        if (r15 == false) goto L16;
        CoreInputViewModel r16 = F();
        if (r14 != 2) goto L14;
        int r5 = 2;
    L15:
        r16.updateSavedStatus(r5);
        goto L16
    L14:
        r5 = 1;
    L16:
        g9.a r17 = F().takeOverConfig().d.get(Integer.valueOf(r14));
        boolean r6 = false;
        if (r17 == null) goto L19;
        g9.b r7 = this.f.Dl();
        Intrinsics.checkNotNullParameter(r7, "finder");
        boolean r18 = ((Boolean) r17.a.invoke(new g9.c(r7))).booleanValue();
    L25:
        if (r18 == false) goto L27;
        return;
    L27:
        a9 r19 = this.f;
        r19.FZ(r14, r19.n5());
        if (r14 == 3) goto L37;
        if (r14 == 4) goto L32;
    L36:
        boolean r8 = false;
    L38:
        this.f.Kf(r8);
        if (EK() == false) goto L41;
    L44:
        boolean r9 = true;
    L45:
        Integer r10 = null;
        if (lF() == true) goto L55;
        com.larus.bmhome.chat.component.bottom.reference.a r11 = A().g5();
        if (r11 == null) goto L50;
        String r12 = r11.vS();
    L52:
        if (Intrinsics.areEqual(r12, "auto_cite") == false) goto L55;
        r9 = false;
        goto L55
    L50:
        r12 = null;
    L55:
        if (r14 == 1) goto L349;
        float r13 = 1.0f;
        if (r14 == 2) goto L219;
        if (r14 == 3) goto L162;
        if (r14 != 4) goto L442;
        r0.i("CoreInputAbility", "READY_TO_MODIFY");
        if (this.S == true) goto L70;
        com.larus.bmhome.instruction.g r110 = A().vc();
        if (r110 != null) goto L66;
    L68:
        boolean r111 = false;
    L69:
        if (r111 == true) goto L70;
    L96:
        int r112 = b.b[((com.larus.platform.model.chat.f0) this.c.getValue()).a.ordinal()];
        if (r112 == 1) goto L131;
        if (r112 != 2) goto L130;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r113 = A().f70();
        if (r113 == null) goto L102;
        r113.Es(true);
    L102:
        this.f.NI(false);
        this.f.ty(false);
        this.f.pQ(true);
        this.f.BF(false);
        this.f.k3(false);
        this.f.lE(false);
        this.f.wp(false);
        this.f.ZD(true);
        ChatMessageModifyTitleView r114 = new ChatMessageModifyTitleView(this.h, null, 6, 0);
        r114.setOnCloseListener(new h(this));
        Drawable r115 = ResourcesCompat.getDrawable(r114.getContext().getResources(), v19.c.b(2130970553, r114.getContext(), 2131238608), r114.getContext().getTheme());
        if (r115 == null) goto L113;
        Drawable r116 = r115.mutate();
        if (r116 == null) goto L113;
        if (A().f1().C() == false) goto L114;
        int r2 = com.larus.bmhome.chat.immerse.k0.a;
        Integer r3 = A().f1().m();
        if (r3 == null) goto L111;
        int r4 = r3.intValue();
    L112:
        r116.setTint(com.larus.bmhome.chat.immerse.k0.a(r4, 0.1f, 0.35f));
        goto L114
    L111:
        r4 = 0;
    L114:
        r114.setBackground(r116);
        this.f.Ca(r114, 2131365564);
        oaa.a r117 = (oaa.a) this.K.getValue();
        if (r117 == null) goto L118;
        r117.gF(true, r114);
    L118:
        if (A().f1().C() == false) goto L128;
        Drawable r118 = ResourcesCompat.getDrawable(this.h.getResources(), v19.c.b(2130970690, this.h, 2131239155), null);
        if (r118 == null) goto L135;
        Drawable r119 = r118.mutate();
        if (r119 == null) goto L135;
        int r120 = com.larus.bmhome.chat.immerse.k0.a;
        Integer r121 = A().f1().m();
        if (r121 == null) goto L126;
        int r122 = r121.intValue();
    L127:
        int r123 = com.larus.bmhome.chat.immerse.k0.a(r122, 0.1f, 0.35f);
        r119.setTint(r123);
        this.f.m80(r119, r123);
        goto L135
    L126:
        r122 = 0;
    L135:
        y0(c(this.h.getString(2131909200)));
    L136:
        this.f.Y4(1.0f);
        this.f.cB();
        this.f.SW(true);
        this.f.sz(false);
        Dr(false);
        com.larus.bmhome.chat.component.bottom.reference.a r124 = A().g5();
        if (r124 == null) goto L139;
        r124.Ek(false);
    L139:
        v0();
        com.larus.bmhome.instruction.g r125 = A().vc();
        if (r125 != null) goto L142;
    L144:
        boolean r126 = false;
    L145:
        if (r126 == false) goto L149;
        com.larus.bmhome.instruction.g r127 = A().vc();
        if (r127 == null) goto L149;
        r127.vW(false);
    L149:
        maa.e r128 = A().C9();
        if (r128 != null) goto L152;
    L154:
        boolean r129 = false;
    L155:
        if (r129 == false) goto L159;
        maa.e r130 = A().C9();
        if (r130 == null) goto L159;
        maa.e.a.a(r130, null, null, false, 7);
    L159:
        IObricContinuousTalkService r131 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r131 == null) goto L442;
        r131.g(s1a.d.a(this.a));
        goto L442
    L152:
        if (r128.x3() != true) goto L154;
        r129 = true;
        goto L155
    L142:
        if (r125.eB() != true) goto L144;
        r126 = true;
        goto L145
    L128:
        this.f.p9(v19.c.b(2130970690, this.h, 2131239155));
    L113:
        r116 = null;
        goto L114
    L130:
        throw new NoWhenBranchMatchedException();
    L131:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r132 = A().f70();
        if (r132 == null) goto L134;
        r132.Es(true);
    L134:
        this.f.NI(true);
        this.f.ty(true);
        this.f.pQ(false);
        this.f.Kf(false);
        this.f.lE(true);
        this.f.ZD(false);
        goto L135
    L66:
        if (r110.z0() != true) goto L68;
        r111 = true;
    L70:
        com.larus.bmhome.instruction.g r133 = A().vc();
        if (r133 != null) goto L73;
    L75:
        boolean r134 = false;
    L76:
        if (r134 == true) goto L96;
        this.f.NI(false);
        this.f.ty(false);
        x0();
        this.f.pQ(true);
        this.f.lE(true);
        this.f.wp(false);
        a9 r135 = this.f;
        if (i() == false) goto L94;
        com.larus.bmhome.instruction.g r136 = A().vc();
        if (r136 != null) goto L82;
    L84:
        boolean r137 = false;
    L85:
        if (r137 == false) goto L94;
        com.larus.bmhome.instruction.g r138 = A().vc();
        if (r138 != null) goto L89;
    L91:
        boolean r139 = false;
    L92:
        if (r139 == false) goto L94;
        boolean r140 = true;
    L95:
        r135.iO(r140);
        goto L136
    L89:
        if (r138.X1() != 2) goto L91;
        r139 = true;
        goto L92
    L82:
        if (r136.P0() == true) goto L84;
        r137 = true;
    L94:
        r140 = false;
        goto L95
    L73:
        if (r133.Q1() != 8) goto L75;
        r134 = true;
    L442:
        this.f.Sq(!z0(), true);
        return;
    L162:
        com.larus.bmhome.instruction.g r141 = A().vc();
        if (r141 != null) goto L165;
    L167:
        boolean r142 = false;
    L168:
        r0.i("CoreInputAbility", "READY_TO_SEND,isOpenedHasImgAttachInstruct:" + r142);
        I();
        this.f.pQ(true);
        this.f.wp(false);
        this.f.lE(true);
        this.f.Y4(1.0f);
        eo();
        a9 r143 = this.f;
        if (l0() == true) goto L171;
    L173:
        boolean r144 = false;
    L174:
        r143.BF(r144);
        this.f.sz(false);
        this.f.cB();
        this.f.SW(true);
        com.larus.bmhome.instruction.g r145 = A().vc();
        if (r145 == null) goto L178;
        r10 = Integer.valueOf(r145.Q1());
    L178:
        if (od8.h0.a(r10) == false) goto L180;
    L189:
        boolean r146 = true;
    L190:
        if (r146 == false) goto L192;
    L195:
        boolean r147 = true;
    L196:
        Dr(r147);
        com.larus.bmhome.chat.component.bottom.reference.a r148 = A().g5();
        if (r148 != null) goto L199;
    L201:
        boolean r149 = false;
    L202:
        if (r149 == true) goto L212;
        com.larus.bmhome.chat.component.bottom.reference.a r150 = A().g5();
        if (r150 != null) goto L206;
    L208:
        boolean r151 = false;
    L209:
        if (r151 == true) goto L212;
        boolean r152 = false;
    L213:
        com.larus.bmhome.chat.component.bottom.reference.a r153 = A().g5();
        if (r153 == null) goto L442;
        if (r152 == false) goto L218;
        if (r9 == false) goto L218;
        r6 = true;
    L218:
        r153.Ek(r6);
        goto L442
    L206:
        if (r150.GD() != true) goto L208;
        r151 = true;
    L212:
        r152 = true;
        goto L213
    L199:
        if (r148.i9() != true) goto L201;
        r149 = true;
        goto L202
    L192:
        if (this.f.J8() == true) goto L195;
        r147 = false;
        goto L196
    L180:
        if (od8.h0.f(r10) == true) goto L189;
        if (od8.h0.i(r10) == true) goto L189;
        if (r10 != null) goto L186;
    L188:
        r146 = false;
        goto L190
    L186:
        if (r10.intValue() != 8) goto L188;
    L171:
        if (n() == false) goto L173;
        r144 = true;
        goto L174
    L165:
        if (r141.Wa() != true) goto L167;
        r142 = true;
        goto L168
    L219:
        r0.i("CoreInputAbility", "READY_TO_SPEAK");
        I();
        this.f.pQ(true);
        this.f.wp(true);
        com.larus.bmhome.instruction.g r154 = A().vc();
        if (r154 != null) goto L222;
    L224:
        boolean r155 = false;
    L225:
        O0(r155);
        boolean r156 = d();
        com.larus.bmhome.instruction.g r20 = A().vc();
        if (r20 != null) goto L228;
    L230:
        boolean r21 = false;
    L231:
        com.larus.bmhome.instruction.g r22 = A().vc();
        if (r22 != null) goto L234;
    L236:
        boolean r23 = false;
    L237:
        boolean r24 = !r23;
        List r157 = CollectionsKt.listOf(new Integer[]{8, 30, 34});
        com.larus.bmhome.instruction.g r25 = A().vc();
        if (r25 == null) goto L240;
        Integer r26 = Integer.valueOf(r25.Q1());
    L241:
        boolean r158 = CollectionsKt.contains(r157, r26);
        if (r21 == false) goto L250;
        if (r156 == false) goto L250;
        if (r24 == true) goto L248;
        if (r158 == true) goto L248;
        boolean r27 = false;
    L249:
        r0.i("CoreInputAbility", "[setActionSendOnReadyToSpeak] visibility:" + r27 + ", hasInstructionUploadedImage:" + r24 + ", inInstructionWithAttachment:" + r158);
    L251:
        this.f.lE(r27);
        if (r156 == false) goto L264;
        com.larus.bmhome.instruction.g r159 = A().vc();
        if (r159 != null) goto L256;
    L258:
        boolean r160 = false;
    L259:
        if (r21 == false) goto L263;
        if (r160 == true) goto L263;
        if (r158 == true) goto L263;
        r13 = 0.3f;
    L263:
        r0.i("CoreInputAbility", "[setActionSendOnReadyToSpeak] alpha:" + r13);
        this.f.Y4(r13);
        goto L264
    L256:
        if (r159.fu() != true) goto L258;
        r160 = true;
    L264:
        this.f.BF(!d());
        if (d() == true) goto L267;
    L269:
        this.f.iO(false);
        this.f.os();
        this.f.SW(false);
        com.larus.bmhome.instruction.g r161 = A().vc();
        if (r161 != null) goto L272;
    L274:
        boolean r162 = false;
    L275:
        com.larus.bmhome.instruction.g r163 = A().vc();
        if (r163 == null) goto L278;
        r10 = Integer.valueOf(r163.Q1());
    L278:
        com.larus.bmhome.chat.component.bottom.reference.a r164 = A().g5();
        if (r164 != null) goto L281;
    L283:
        boolean r165 = false;
    L284:
        if (r165 == true) goto L294;
        com.larus.bmhome.chat.component.bottom.reference.a r166 = A().g5();
        if (r166 != null) goto L288;
    L290:
        boolean r167 = false;
    L291:
        if (r167 == true) goto L294;
        boolean r168 = false;
    L295:
        boolean r28 = n();
        if (r162 == true) goto L298;
    L302:
        boolean r29 = false;
    L303:
        if (r29 == true) goto L318;
        if (r28 == false) goto L313;
        if (b0() == true) goto L313;
        if (r162 == false) goto L318;
        if (r10 == null) goto L313;
        if (r10.intValue() == 8) goto L318;
    L313:
        if (V() == true) goto L315;
        this.f.k3(false);
    L315:
        this.f.Nv(false);
        com.larus.bmhome.instruction.g r169 = A().vc();
        if (r169 == null) goto L332;
        r169.T40(false);
    L332:
        if (r168 == false) goto L338;
        if (r9 == false) goto L338;
        com.larus.bmhome.instruction.g r170 = A().vc();
        if (r170 == null) goto L338;
        r170.T40(false);
    L338:
        if (d() == true) goto L340;
        if (r28 == false) goto L340;
    L341:
        boolean r171 = true;
    L343:
        Dr(r171);
        com.larus.bmhome.chat.component.bottom.reference.a r172 = A().g5();
        if (r172 == null) goto L442;
        if (r168 == false) goto L348;
        if (r9 == false) goto L348;
        r6 = true;
    L348:
        r172.Ek(r6);
    L340:
        if (r29 == true) goto L341;
        r171 = false;
    L318:
        if (r29 == false) goto L322;
        com.larus.bmhome.instruction.g r173 = A().vc();
        if (r173 == null) goto L332;
        r173.T40(false);
        goto L332
    L322:
        com.larus.bmhome.chat.component.list.u7 r174 = A().u3();
        if (r174 != null) goto L325;
    L327:
        boolean r175 = false;
    L328:
        if (r175 == true) goto L332;
        com.larus.bmhome.instruction.g r176 = A().vc();
        if (r176 == null) goto L332;
        r176.T40(true);
        goto L332
    L325:
        if (r174.Hl() != true) goto L327;
        r175 = true;
        goto L328
    L298:
        if (od8.h0.f(r10) == false) goto L300;
    L301:
        r29 = true;
        goto L303
    L300:
        if (od8.h0.i(r10) == false) goto L302;
    L288:
        if (r166.GD() != true) goto L290;
        r167 = true;
    L294:
        r168 = true;
        goto L295
    L281:
        if (r164.i9() != true) goto L283;
        r165 = true;
        goto L284
    L272:
        if (r161.z0() != true) goto L274;
        r162 = true;
        goto L275
    L267:
        if (com.larus.platform.exp.g.a() == true) goto L269;
        C1(false, true, "");
    L248:
        r27 = true;
    L250:
        r0.i("CoreInputAbility", "[setActionSendOnReadyToSpeak] hide send, inAttachmentMode:false");
        r27 = r156;
        goto L251
    L240:
        r26 = null;
        goto L241
    L234:
        if (r22.bd() != 0) goto L236;
        r23 = true;
        goto L237
    L228:
        if (r20.z0() != true) goto L230;
        r21 = true;
        goto L231
    L222:
        if (r154.z0() == true) goto L224;
        r155 = true;
        goto L225
    L349:
        r0.i("CoreInputAbility", "READY_TO_INPUT");
        boolean r177 = n();
        com.larus.bmhome.chat.component.bottom.reference.a r178 = A().g5();
        if (r178 != null) goto L352;
    L354:
        boolean r179 = false;
    L355:
        if (r179 == true) goto L365;
        com.larus.bmhome.chat.component.bottom.reference.a r180 = A().g5();
        if (r180 != null) goto L359;
    L361:
        boolean r181 = false;
    L362:
        if (r181 == true) goto L365;
        boolean r182 = false;
    L366:
        I();
        this.f.pQ(true);
        this.f.wp(false);
        if (c1() == false) goto L376;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r30 = A().f70();
        if (r30 != null) goto L371;
    L373:
        boolean r31 = false;
    L374:
        if (r31 == false) goto L376;
        this.f.lE(true);
    L377:
        this.f.sz(false);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r32 = A().f70();
        if (r32 != null) goto L380;
    L382:
        boolean r33 = false;
    L383:
        a9 r34 = this.f;
        if (r177 == false) goto L389;
        if (r33 == true) goto L387;
    L388:
        boolean r35 = true;
    L390:
        r34.BF(r35);
        a9 r36 = this.f;
        if (z0() == true) goto L393;
    L417:
        boolean r37 = false;
    L418:
        r36.iO(r37);
        this.f.cB();
        this.f.SW(true);
        if (r177 == false) goto L421;
        boolean r183 = K0();
    L422:
        Dr(r183);
        com.larus.bmhome.chat.component.bottom.reference.a r184 = A().g5();
        if (r184 == null) goto L429;
        if (r182 == false) goto L427;
        if (r9 == false) goto L427;
        boolean r185 = true;
    L428:
        r184.Ek(r185);
    L427:
        r185 = false;
    L429:
        maa.e r186 = A().C9();
        if (r186 != null) goto L432;
    L434:
        boolean r187 = false;
    L435:
        if (r187 == false) goto L439;
        maa.e r188 = A().C9();
        if (r188 == null) goto L439;
        maa.e.a.a(r188, null, null, false, 7);
    L439:
        IObricContinuousTalkService r189 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r189 == null) goto L442;
        r189.g(s1a.d.a(this.a));
        goto L442
    L432:
        if (r186.x3() != true) goto L434;
        r187 = true;
        goto L435
    L421:
        r183 = false;
        goto L422
    L393:
        if (i() == false) goto L417;
        com.larus.bmhome.instruction.g r38 = A().vc();
        if (r38 == null) goto L397;
        boolean r39 = r38.P0();
    L400:
        Boolean r40 = Boolean.valueOf(r39);
    L403:
        if (Intrinsics.areEqual(r40, Boolean.FALSE) == false) goto L417;
        com.larus.bmhome.instruction.g r41 = A().vc();
        if (r41 == null) goto L407;
        int r42 = r41.X1();
    L410:
        Integer r43 = Integer.valueOf(r42);
    L412:
        if (r43 == null) goto L417;
        if (r43.intValue() != 2) goto L417;
        r37 = true;
        goto L418
    L407:
        ys8.a r44 = A().DC();
        if (r44 == null) goto L411;
        r42 = r44.X1();
        goto L410
    L411:
        r43 = null;
        goto L412
    L397:
        ys8.a r45 = A().DC();
        if (r45 == null) goto L401;
        r39 = r45.P0();
        goto L400
    L401:
        r40 = null;
        goto L403
    L387:
        if (l0() == true) goto L388;
    L389:
        r35 = false;
        goto L390
    L380:
        if (r32.isVisible() != true) goto L382;
        r33 = true;
        goto L383
    L371:
        if (r30.isVisible() != true) goto L373;
        r31 = true;
    L376:
        this.f.lE(false);
        goto L377
    L359:
        if (r180.GD() != true) goto L361;
        r181 = true;
    L365:
        r182 = true;
        goto L366
    L352:
        if (r178.i9() != true) goto L354;
        r179 = true;
        goto L355
    L41:
        if (lF() == false) goto L44;
        r9 = false;
        goto L45
    L32:
        if (((com.larus.platform.model.chat.f0) this.c.getValue()).a != MessageModifyStyle.FULL_BOX) goto L36;
        if (this.f.Qm() == false) goto L36;
        r8 = true;
        goto L38
    L37:
        r8 = this.f.Qm();
        goto L38
    L19:
        oaa.a r190 = (oaa.a) this.K.getValue();
        if (r190 != null) goto L22;
    L24:
        r18 = false;
        goto L25
    L22:
        if (r190.H8(r14) != true) goto L24;
        r18 = true;
        goto L25
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Uu(String r1, boolean r2) {
        if (r2 == false) goto L5;
        F().setCustomHint(null);
        Rk();
        return;
    L5:
        if (r1 == null) goto L8;
        F().setCustomHint(r1);
        M5(r1);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void WM(boolean r12, boolean r13) {
        F().updateModifyMode(null);
        F().updateModifyingMessage(null);
        x0();
        zi();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = A().f70();
        if (r0 == null) goto L5;
        r0.Es(false);
    L5:
        Jc(this.h);
        boolean r1 = true;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        ILegacyChatUiServiceDelegate r4 = ILegacyChatUiServiceDelegate.b;     // Catch: Throwable -> L12
        if (this.g.getViewLifecycleOwner().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L9;
        boolean r5 = true;
    L10:
        r4.T8(r5);     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L17;
        FLogger.a.e("CoreInputAbility", "[finishModify] musicPlayerPausing, " + r7);
    L17:
        com.larus.bmhome.chat.component.list.u7 r8 = A().u3();
        if (r8 == null) goto L24;
        MessageAdapter r9 = r8.MF();
        if (r9 == null) goto L24;
        if (r9.s0() != true) goto L24;
    L25:
        if (r1 == false) goto L49;
        com.larus.bmhome.chat.component.list.u7 r2 = A().u3();
        if (r2 == null) goto L31;
        MessageAdapter r10 = r2.MF();
        if (r10 == null) goto L31;
        com.larus.bmhome.chat.adapter.h0.g(r10, null);
    L31:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r11 = A().f70();
        if (r11 == null) goto L34;
        com.larus.bmhome.chat.component.bottom.attachment.g1.a.a(r11, null, 7);
    L34:
        String r14 = this.f.u7();
        if (r12 == false) goto L37;
        qp(false);
        a9$a.a(this.f, new i(this));
    L38:
        com.larus.bmhome.chat.component.list.u7 r15 = A().u3();
        if (r15 == null) goto L41;
        r15.tJ(false);
    L41:
        if (r13 == false) goto L45;
        com.larus.bmhome.instruction.g r16 = A().vc();
        if (r16 == null) goto L50;
        r16.A1();
        return;
    L50:
        return;
    L45:
        ICoreInputAbility.b.d(this, r14, false, false, null, null, false, 62);
        return;
    L37:
        a9$a.a(this.f, new j(this));
        goto L38
    L49:
        return;
    L24:
        r1 = false;
        goto L25
    L9:
        r5 = false;
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void eQ(EditPos r9, BotModel r10) {
        Intrinsics.checkNotNullParameter(r9, "editPos");
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        F().setConversationTypeAndBot(3, q());
        T0(r10);
        if (this.O == false) goto L8;
        boolean r0 = true;
    L14:
        this.O = r0;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(F()), null, null, new CoreInputAbility$updateInputEntrances$1(r9, this, r10, null), 3, null);
        return;
    L8:
        if (r10 == null) goto L12;
        Map r1 = r10.getExtra();
        if (r1 == null) goto L12;
        String r2 = (String) r1.get("enable_call_left");
    L13:
        r0 = Intrinsics.areEqual(r2, "1");
    L12:
        r2 = null;
        goto L13
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void g2(int r4, boolean r5) {
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        FLogger.a.i("CoreInputAbility", "switchStatus: " + r4 + ", saveStatus: " + r5);
        F().switchInputStatus(r4, r5);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final boolean lW(BotModel r4, String r5) {
        if (r4 == null) goto L6;
        if (r5 == null) goto L6;
        boolean r6 = ILegacyChatUiServiceDelegate.b.y8(r4, r5, true, false);
        F().updateEnableRealtimeCall(r5, r6);
        return r6;
    L6:
        return F().getEnableRealtimeCallCache(r5);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void mv(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "from");
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = A().f70();
        if (r0 == null) goto L8;
        String r1 = r0.uM();
    L9:
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("resetInputContext, from=");
        r3.append(r6);
        r3.append(", lastStatus=");
        r3.append(Rp());
        r3.append(", instructionOpen=");
        com.larus.bmhome.instruction.g r4 = A().vc();
        if (r4 == null) goto L14;
        Boolean r5 = Boolean.valueOf(r4.z0());
    L15:
        r3.append(r5);
        r3.append(", attachmentVisible=");
        com.larus.bmhome.chat.component.bottom.attachment.g1 r8 = A().f70();
        if (r8 == null) goto L18;
        Boolean r9 = Boolean.valueOf(r8.isVisible());
    L19:
        r3.append(r9);
        r3.append(", attachmentCount=");
        com.larus.bmhome.chat.component.bottom.attachment.g1 r10 = A().f70();
        if (r10 == null) goto L22;
        Integer r11 = Integer.valueOf(com.larus.bmhome.chat.component.bottom.attachment.g1.a.b(r10));
    L23:
        r3.append(r11);
        r3.append(", attachmentLocalMsgIdEmpty=");
        r3.append(StringsKt.isBlank(r1));
        r3.append(", hasReferenceMsg=");
        com.larus.bmhome.chat.component.bottom.reference.a r12 = A().g5();
        if (r12 == null) goto L26;
        Boolean r13 = Boolean.valueOf(r12.i9());
    L27:
        r3.append(r13);
        r3.append(", showBottomMenu=");
        r3.append(F().showBottomMenu());
        r2.i("CoreInputAbility", r3.toString());
        p80(false);
        C1(false, true, r6);
        com.larus.bmhome.instruction.g r14 = A().vc();
        if (r14 == null) goto L30;
        r14.A1();
    L30:
        ci8.d r15 = ci8.e.a(this.g);
        if (r15 == null) goto L33;
        r15.f0(PageType.Chat.getType());
    L33:
        IChatDoubleTabAbility r16 = A().wh();
        if (r16 == null) goto L36;
        r16.f0(0);
    L36:
        com.larus.bmhome.chat.component.bottom.reference.a r17 = A().g5();
        if (r17 == null) goto L45;
        if (r17.i9() == true) goto L42;
        r17 = null;
    L42:
        if (r17 == null) goto L45;
        r17.sZ();
    L45:
        if ((!StringsKt.isBlank(r1)) == true) goto L48;
        r1 = null;
    L48:
        if (r1 == null) goto L52;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r18 = A().f70();
        if (r18 == null) goto L52;
        r18.b2(r1);
    L52:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r19 = A().f70();
        if (r19 == null) goto L55;
        r19.dP();
    L55:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r20 = A().f70();
        if (r20 == null) goto L58;
        r20.W0();
    L58:
        bc8.a r21 = A().aE();
        if (r21 == null) goto L61;
        r21.mX();
    L61:
        if (r7 == false) goto L66;
        com.larus.bmhome.chat.model.j1 r22 = A().Y3();
        if (r22 == null) goto L67;
        r22.l(null);
        return;
    L67:
        return;
    L66:
        return;
    L26:
        r13 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = null;
        goto L19
    L14:
        r5 = null;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    public final void q0(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "clickFrom");
        z8.c r0 = F().takeOverConfig().h;
        if (r0 == null) goto L5;
        Function2<? super Integer, ? super String, Unit> r1 = r0.a;
    L6:
        if (r1 == null) goto L11;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        r1.invoke(Integer.valueOf(r4), r2);
        return;
    L9:
        r4 = F().getActionShown();
        goto L10
    L11:
        Function2<? super Integer, ? super String, Unit> r5 = this.m;
        if (r3 == null) goto L14;
        int r6 = r3.intValue();
    L15:
        r5.invoke(Integer.valueOf(r6), r2);
        return;
    L14:
        r6 = F().getActionShown();
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void r8(final boolean r3, final z8.e r4) {
        this.v = Boolean.valueOf(r3);
        F().updateTakeOverConfig(new g(r3, r4));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void tw(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        if (r5 == true) goto L10;
    L5:
        this.f.u40(r4);     // Catch: Exception -> L7
        this.f.v3(r4.length());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e("CoreInputAbility", "onExceptionOccur monitor err", e);
        return;
    L10:
        this.f.S9(200, new q(this));     // Catch: Exception -> L7
        goto L5
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.component.bottom.core.e2] */
    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void uU(com.larus.bmhome.chat.component.list.h1 r3, final com.larus.bmhome.chat.component.list.i1 r4) {
        Intrinsics.checkNotNullParameter(r3, "onShowMob");
        Intrinsics.checkNotNullParameter(r4, "onClickMob");
        this.f.GK(r3, new e2(this, r4));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final CharSequence ws(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IChatDoubleTabAbility r0 = A().wh();
        if (r0 == null) goto L16;
        String r1 = r0.y00();
        if (r1 == null) goto L16;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L16;
        return r1;
    L9:
        r2 = false;
    L16:
        return F().getFallbackText(r3, r4, w());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.z8
    public final void y9(final int r3, final g9.a r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        F().updateTakeOverConfig(new g1(r3, r4));
    }

    public static Pair H(SuggestedAction r6, String r7, String r8) {
        String r0 = null;
        if (r6 == null) goto L41;
        if (r7 == null) goto L19;
        IAIChatControlTraceService.Companion r4 = IAIChatControlTraceService.a;
        Map r5 = r6.getEventExtra();
        if (r5 == null) goto L9;
        String r9 = (String) r5.get("onboarding_item_id");
    L10:
        r4.qb(r7, r9);
        Map r10 = r6.getEventExtra();
        if (r10 == null) goto L13;
        String r11 = (String) r10.get("item_type");
    L14:
        r4.Ga(r7, r11);
        Map r12 = r6.getEventExtra();
        if (r12 == null) goto L17;
        String r13 = (String) r12.get("reco_request_id");
    L18:
        r4.Oa(r7, r13);
        goto L19
    L17:
        r13 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = null;
    L19:
        IAIChatControlTraceService.Companion r14 = IAIChatControlTraceService.a;
        Map r15 = r6.getEventExtra();
        if (r15 == null) goto L22;
        String r3 = (String) r15.get("onboarding_item_id");
    L23:
        r14.qb(r8, r3);
        Map r16 = r6.getEventExtra();
        if (r16 == null) goto L26;
        String r2 = (String) r16.get("item_type");
    L27:
        r14.Ga(r8, r2);
        Map r17 = r6.getEventExtra();
        if (r17 == null) goto L30;
        String r1 = (String) r17.get("reco_request_id");
    L31:
        r14.Oa(r8, r1);
        Map r18 = r6.getEventExtra();
        if (r18 == null) goto L34;
        String r19 = (String) r18.get("sug_scene");
    L35:
        Map r20 = r6.getEventExtra();
        if (r20 == null) goto L39;
        r0 = (String) r20.get("scene");
    L39:
        return TuplesKt.to(r19, r0);
    L34:
        r19 = null;
        goto L35
    L30:
        r1 = null;
        goto L31
    L26:
        r2 = null;
        goto L27
    L22:
        r3 = null;
        goto L23
    L41:
        return TuplesKt.to(null, null);
    }

    public static final Object b(CoreInputAbility r13, Message r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof CoreInputAbility$getModifyHistoryAttachments$1) == false) goto L7;
        CoreInputAbility$getModifyHistoryAttachments$1 r0 = (CoreInputAbility$getModifyHistoryAttachments$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        boolean r18 = r0.Z$0;
        String r19 = (String) r0.L$2;
        List r3 = (List) r0.L$1;
        Message r4 = (Message) r0.L$0;
        ResultKt.throwOnFailure(r16);
        String r5 = r19;
        List r110 = r3;
    L42:
        List r111 = (List) r16;
        if (r18 == false) goto L49;
        ArrayList r6 = new ArrayList();
        Iterator r112 = r111.iterator();
    L46:
        if (r112.hasNext() == false) goto L48;
        Message r7 = (Message) r112.next();
        ic8.u.a.getClass();
        CollectionsKt.addAll(r6, ic8.u.a(r7));
        goto L46
    L48:
        Boxing.boxBoolean(r110.addAll(r6));
    L64:
        FLogger r113 = FLogger.a;
        StringBuilder r8 = new StringBuilder("[getModifyHistoryAttachments] relatedMsgList=");
        List r114 = r111;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r115 = r114.iterator();
    L66:
        if (r115.hasNext() == false) goto L68;
        Message r10 = (Message) r115.next();
        r9.add(r10.getMessageId() + '_' + r10.getContentType());
        goto L66
    L68:
        r8.append(r9);
        r8.append(" historyEntities=");
        r8.append(r110.size());
        r8.append(" contentType=");
        r8.append(r4.getContentType());
        r8.append(" collectionId=");
        r8.append(r5);
        r113.i("CoreInputAbility", r8.toString());
        Object r116 = r110;
    L74:
        return r116;
    L49:
        ArrayList r11 = new ArrayList();
        Iterator r117 = r111.iterator();
    L51:
        if (r117.hasNext() == false) goto L60;
        Object r12 = r117.next();
        Message r20 = (Message) r12;
        if (r20.getContentType() == 800) goto L55;
    L57:
        boolean r21 = false;
    L58:
        if (r21 == false) goto L51;
        r11.add(r12);
        goto L51
    L55:
        if (Intrinsics.areEqual(r20.getBizContentType(), "flow_nested") == false) goto L57;
        r21 = true;
        goto L58
    L60:
        Iterator r118 = r11.iterator();
    L62:
        if (r118.hasNext() == false) goto L64;
        Message r22 = (Message) r118.next();
        ic8.u.a.getClass();
        r110.addAll(ic8.u.a(r22));
        goto L62
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r119 = (String) r0.L$2;
        List r120 = (List) r0.L$1;
        Message r23 = (Message) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r5 = r119;
        r14 = r23;
        List r121 = r120;
    L73:
        FLogger.a.i("CoreInputAbility", "[getModifyHistoryAttachments] size=" + r121.size() + " msg=" + r14.getMessageId() + '_' + r14.getContentType() + " collectionId=" + r5);
        r116 = r121;
        goto L74
    L16:
        ResultKt.throwOnFailure(r16);
        ic8.u.a.getClass();
        List r122 = CollectionsKt.toMutableList(ic8.u.a(r14));
        Map r24 = r14.getExt();
        if (r24 == null) goto L19;
        r5 = (String) r24.get("collection_id");
    L20:
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        boolean r25 = com.larus.platform.service.z2.a.attachmentEditConfig().getBlockAttachmentReeditFix();
        if (r14.getContentType() == 1) goto L31;
        if (r25 == true) goto L26;
    L30:
        boolean r26 = false;
    L33:
        if ((!r122.isEmpty()) == true) goto L69;
        if (r26 == false) goto L69;
        if (StringsKt.isBlank(r5) == true) goto L69;
        IChatRepoService r27 = zh8.a.a;
        r0.L$0 = r14;
        r0.L$1 = r122;
        r0.L$2 = r5;
        r0.Z$0 = r25;
        r0.label = 2;
        Object r28 = r27.z1(r14, r0);
        r116 = r17;
        if (r28 == r17) goto L74;
        r110 = r122;
        r16 = r28;
        r4 = r14;
        r18 = r25;
    L69:
        r0.L$0 = r14;
        r0.L$1 = r122;
        r0.L$2 = r5;
        r0.label = 1;
        r116 = r17;
        if (DelayKt.delay(20, r0) == r17) goto L74;
        r121 = r122;
        goto L73
    L26:
        if (r14.getContentType() != 9999) goto L30;
        if (com.larus.bmhome.chat.bean.d.H(r14) == null) goto L30;
    L31:
        r26 = true;
        goto L33
    L19:
        r5 = null;
    L7:
        r0 = new CoreInputAbility$getModifyHistoryAttachments$1(r13, r15);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void BU(boolean r4, final boolean r5, final String r6) {
        Intrinsics.checkNotNullParameter(r6, "clickFrom");
        if (this.f.Mb() == false) goto L5;
        return;
    L5:
        FLogger.a.i("CoreInputAbility", "[onClickActionInput] fromOutChatInput" + r4 + ", showIme:" + r5 + ", clickFrom:" + r6);
        if (k5() == false) goto L8;
    L14:
        g2(3, true);
    L15:
        this.f.w20(false);
        if (this.f.Qu() == false) goto L18;
        this.f.lh(true);
    L18:
        this.f.Th(null);
        if (r4 == false) goto L21;
        long r0 = 500;
    L22:
        this.f.S9(r0, new p1(this, r5, r6));
        return;
    L21:
        r0 = 200;
        goto L22
    L8:
        if (this.f.u7().length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        g2(1, true);
        goto L15
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void C1(boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        if (this.f.Mb() == false) goto L6;
        return;
    L6:
        if (F().showBottomMenu() != r4) goto L8;
        return;
    L8:
        FLogger.a.i("CoreInputAbility", "switchMenuEntranceStatus newStatus:" + r4);
        if (A().r5() != null) goto L11;
        return;
    L11:
        e r0 = new e(r4, this, r5, r6);
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r7 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(this.a).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r7 == null) goto L14;
        r7.v80(r0);
        return;
    L14:
        r0.invoke();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Kh(String r8, Function0<Unit> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "from");
        FLogger r0 = FLogger.a;
        r0.i("CoreInputAbility", "showIme: from=" + r8);
        ConversationPage r3 = null;
        boolean r4 = false;
        if (Intrinsics.areEqual(r8, "subConversation") == false) goto L13;
        Bundle r1 = A().f1().b;
        if (r1 == null) goto L7;
        String r2 = r1.getString("open_method", null);
    L9:
        if (Intrinsics.areEqual(r2, "cold_start_preference_new_chat") == false) goto L13;
        if (B0(h()) == null) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L18;
        r0.i("CoreInputAbility", "[MainConversationInputFallback] intercept cold start auto ime");
        return;
    L18:
        if (w() == false) goto L20;
        return;
    L20:
        IChatDoubleTabAbility r6 = A().wh();
        if (r6 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L39;
        Bundle r11 = A().f1().b;
        if (r11 == null) goto L30;
        Serializable r12 = r11.getSerializable("conversation_page");
    L32:
        if ((r12 instanceof ConversationPage) == false) goto L34;
        r3 = (ConversationPage) r12;
    L34:
        if (r3 == null) goto L36;
        boolean r13 = Intrinsics.areEqual(r3.getShowTmplInputBox(), Boolean.TRUE);
    L37:
        if (r13 == true) goto L39;
    L54:
        r0.i("CoreInputAbility", "intercept show ime");
        return;
    L36:
        r13 = false;
        goto L37
    L30:
        r12 = null;
    L39:
        if (c1() == true) goto L41;
    L44:
        com.larus.bmhome.chat.component.fastsend.e0 r14 = A().I50();
        if (r14 != null) goto L47;
    L49:
        if (r4 == true) goto L51;
    L55:
        this.f.F10(r9, r10);
        return;
    L51:
        if (Intrinsics.areEqual(r8, "attachmentAreaShownThenShowIme") == false) goto L55;
        if (com.larus.platform.exp.g.a() == false) goto L55;
    L47:
        if (r14.IZ() != true) goto L49;
        r4 = true;
        goto L49
    L41:
        if (Intrinsics.areEqual(EW(), "inject_input_photo_picker") == false) goto L44;
        if (Intrinsics.areEqual(r8, "onClickActionInput") == false) goto L54;
    L23:
        if (r6.ar() != 1) goto L25;
        r7 = true;
        goto L26
    L7:
        r2 = null;
    L13:
        r5 = false;
        goto L14
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void Wy(String r10, long r11, Boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "toStatus");
        z8.d r1 = F().takeOverConfig().m;
        if (r1 == null) goto L7;
        Function1<String, Boolean> r2 = r1.a;
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.invoke(r10);
    L7:
        Map<String, String> r4 = F().takeOverConfig().k;
        LruCache r5 = ko8.a.a;
        String r6 = r4.get("take_over_chat_key");
        if (r6 == null) goto L12;
        Long r7 = StringsKt.toLongOrNull(r6);
        if (r7 == null) goto L12;
        r11 = r7.longValue();
    L12:
        long r8 = r11;
        String r9 = r4.get("take_over_current_page");
        Intrinsics.checkNotNullParameter(r10, "toStatus");
        IAIChatControlTraceService.a.Zb(r10, null, r8, r9, r13);
    }

    public final void o(String r3, boolean r4, Function0<Unit> r5) {
        if (r4 == false) goto L6;
        HostDiversionServiceDelegate r6 = HostDiversionServiceDelegate.b;
        if (r6 == null) goto L8;
        Context r7 = this.a.getContext();
        JSONObject r0 = new JSONObject();
        r0.put("open_window_from", r3);
        Unit r8 = Unit.INSTANCE;
        r6.a(r7, r0);
        return;
    L8:
        return;
    L6:
        r5.invoke();
    }

    public final void r0(AttachmentInfo r11, NestedFileContent r12, String r13) {
        if (com.larus.platform.exp.g.a() == false) goto L5;
        C1(false, true, "modify_send");
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.g), null, null, new CoreInputAbility$onClickModifySend$1(this, r11, r12, r13, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void F5(nr9.g r76, String r77, Map<String, String> r78, Map<String, String> r79) {
        Intrinsics.checkNotNullParameter(r76, "videoPlayData");
        Intrinsics.checkNotNullParameter(r77, ChatDraftItem.TYPE_TEXT);
        if (r76.a == null) goto L121;
        com.larus.bmhome.instruction.g r4 = A().vc();
        if (r4 == null) goto L8;
        Map r12 = r4.nK(null);
    L9:
        String r26 = "click_chat";
        String r29 = "router_auto_send";
        String r2 = E(null, r77);
        Iterator r5 = ((ArrayList) this.C).iterator();
        String r7 = r2;
    L11:
        if (r5.hasNext() == false) goto L13;
        r7 = ((ICoreInputAbility.c) r5.next()).b(r7);
        goto L11
    L13:
        String r8 = this.f.Jn().toString();
        if (r79 == null) goto L16;
        String r15 = r79.get("enter_method");
    L17:
        UplinkFileEntity[] r6 = new UplinkFileEntity[1];
        int r9 = UplinkEntityType.EntityTypeFile.getValue();
        int r10 = UpLinkState.SUCCESS.getValue();
        int r11 = FileParseState.SUCCESS.getValue();
        int r13 = FileReviewState.ACCESS.getValue();
        String r3 = r76.f;
        if (r3 != null) goto L20;
        r3 = "video/mp4";
    L20:
        String r55 = r3;
        String r14 = r76.a;
        int r16 = FileType.FileTypeVideo.getValue();
        String r17 = r76.i;
        Map r27 = r12;
        String r18 = r76.c;
        nr9.f r19 = r76.g;
        if (r19 == null) goto L23;
        String r110 = r19.b;
    L24:
        if (r19 == null) goto L28;
        Integer r20 = r19.e;
        if (r20 == null) goto L28;
        int r111 = r20.intValue();
    L29:
        nr9.f r21 = r76.g;
        if (r21 == null) goto L34;
        Integer r22 = r21.d;
        if (r22 == null) goto L34;
        int r23 = r22.intValue();
    L35:
        Image r63 = new Image("", null, null, new ImageObj(r110, r111, r23, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16342, null);
        nr9.f r24 = r76.g;
        if (r24 == null) goto L40;
        Integer r25 = r24.e;
        if (r25 == null) goto L40;
        int r28 = r25.intValue();
    L41:
        nr9.f r30 = r76.g;
        if (r30 == null) goto L46;
        Integer r31 = r30.d;
        if (r31 == null) goto L46;
        int r32 = r31.intValue();
    L47:
        String r0 = r76.a;
        String r210 = r15;
        Double r112 = r76.e;
        if (r112 == null) goto L50;
        double r113 = r112.doubleValue();
    L51:
        UplinkEntityContent r114 = new UplinkEntityContent(new UplinkFileInfo("", r14, "", Integer.valueOf(r16), null, r17, new VideoExtension(r0, null, r63, null, r18, null, Float.valueOf((float) r113), Integer.valueOf(r32), Integer.valueOf(r28), null, 554, null), r55, null, null, 512, null), null, 2, null);
        boolean r33 = false;
        r6[0] = new UplinkFileEntity(Integer.valueOf(r9), r114, "", null, Integer.valueOf(r13), Integer.valueOf(r11), 100, Integer.valueOf(r10), null, false, null, null, null, null, 16136, null);
        CustomMultiAttachmentInfo r34 = new CustomMultiAttachmentInfo("album", r210, new NestedFileContent(CollectionsKt.mutableListOf(r6), null, false, null, 14, null), false, false, false, false, null, 248, null);
        com.larus.bmhome.instruction.g r1 = A().vc();
        if (r1 == null) goto L54;
        int r115 = r1.Q1();
    L56:
        if (F().getModifyMode() != MessageModifyMode.MODIFY_TO_REGENERATE) goto L58;
        boolean r116 = true;
    L59:
        Boolean r35 = (Boolean) this.f.zr();
        if (r35 == null) goto L62;
        boolean r211 = r35.booleanValue();
    L63:
        com.larus.bmhome.chat.component.bottom.reference.a r36 = A().g5();
        if (r36 == null) goto L66;
        String r212 = r36.vS();
    L67:
        com.larus.bmhome.instruction.g r37 = A().vc();
        String r38 = "";
        if (r37 == null) goto L73;
        String r39 = r37.c0();
        if (r39 == null) goto L73;
        String r213 = r39;
    L74:
        String r40 = r7;
        ICoreInputAbility.OnSendParams r41 = new ICoreInputAbility.OnSendParams(r40, r8, null, null, null, r27, null, null, r115, false, null, false, r116, r211, r212, r213, null, null, false, r26, r78, null, r29, null, null, null, r34, null, null, r(null), null, null, null, -609811264, 1, null);
        F().setVoiceMixInput(false);
        if (((Boolean) this.j.invoke(r41)).booleanValue() == false) goto L78;
        FLogger.a.i("CoreInputAbility", "[doSendMessage] intercepted by onActionSendClickListener");
        return;
    L78:
        if (this.G == true) goto L80;
    L81:
        FLogger.a.e("CoreInputAbility", "[doSendMessage] onSend function is null, try init");
        Q();
        tx9.c0.A("not_init");
    L82:
        z0 r42 = this.k;
        if (r42 == null) goto L85;
        r42.invoke(r41, new j1(this));
    L86:
        com.larus.bmhome.instruction.g r43 = A().vc();
        if (r43 == null) goto L89;
        Integer r44 = Integer.valueOf(r43.Q1());
    L91:
        if (od8.h0.c(r44) == true) goto L93;
    L97:
        String r45 = r76.i;
        if (r45 == null) goto L102;
        r38 = r45;
    L102:
        if (r38.length() <= 0) goto L104;
        r33 = true;
    L104:
        if (r33 == false) goto L108;
        com.larus.bmhome.chat.component.bottom.reference.a r46 = A().g5();
        if (r46 == null) goto L108;
        r46.sZ();
    L108:
        com.larus.bmhome.instruction.g r47 = A().vc();
        if (r47 == null) goto L114;
        com.larus.bmhome.chat.model.b0 r48 = A().u5();
        if (r48 == null) goto L113;
        r47.FC(r48);
    L113:
        r47.FP();
        r47.cO();
    L114:
        IChatDoubleTabAbility r49 = A().wh();
        if (r49 == null) goto L120;
        r49.Ui();
        return;
    L120:
        return;
    L93:
        if (ILegacyChatUiServiceDelegate.b.D8(v()) == false) goto L97;
        com.larus.bmhome.instruction.g r50 = A().vc();
        if (r50 == null) goto L97;
        r50.A1();
        goto L97
    L89:
        r44 = null;
        goto L91
    L85:
        FLogger.a.e("CoreInputAbility", "[doSendMessage] onSend function is still null");
        tx9.c0.A("init_failed");
        goto L86
    L80:
        if (this.k != null) goto L82;
    L73:
        r213 = "";
        goto L74
    L66:
        r212 = null;
        goto L67
    L62:
        r211 = false;
        goto L63
    L58:
        r116 = false;
        goto L59
    L54:
        r115 = 0;
        goto L56
    L50:
        r113 = 0.0d;
    L46:
        r32 = 0;
    L40:
        r28 = 0;
    L34:
        r23 = 0;
    L28:
        r111 = 0;
        goto L29
    L23:
        r110 = null;
        goto L24
    L16:
        r15 = null;
        goto L17
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void jm(wq8.b r44, Message r45, boolean r46, MessageModifyMode r47) {
        Intrinsics.checkNotNullParameter(r44, "adapter");
        Intrinsics.checkNotNullParameter(r45, "message");
        Intrinsics.checkNotNullParameter(r47, "modifyMode");
        if (ILegacyChatUiServiceDelegate.b.p8() == false) goto L6;
        t19.s.a.g(AppHost.a.getApplication(), 2131901014, false);
        return;
    L6:
        boolean r7 = com.larus.bmhome.chat.adapter.h0.b(r45, r44.W());
        if (ic8.j.k(r45) == false) goto L15;
        Intrinsics.checkNotNullParameter(r45, "<this>");
        Map r2 = r45.getExt();
        if (r2 == null) goto L11;
        String r3 = (String) r2.get("white_tee_index_list");
    L13:
        if (com.larus.utils.o0.d(r3) == false) goto L15;
        boolean r4 = true;
    L16:
        String r14 = "";
        if (ic8.j.i(r45) == false) goto L254;
        if (ic8.j.k(r45) == false) goto L21;
        if (r4 == false) goto L254;
    L21:
        com.larus.bmhome.instruction.g r10 = A().vc();
        if (r10 == null) goto L24;
        List r11 = r10.tq();
    L25:
        Integer r18 = ic8.j.b(r45);
        if (r18 != null) goto L29;
    L30:
        if (r18 != null) goto L33;
    L35:
        if (r11 == null) goto L66;
        Iterator r5 = r11.iterator();
    L38:
        if (r5.hasNext() == false) goto L47;
        Object r12 = r5.next();
        com.larus.bmhome.actionbar.model.r r13 = ((com.larus.bmhome.actionbar.model.z0) r12).q;
        if (r13 == null) goto L42;
        Integer r15 = r13.a;
    L44:
        if (Intrinsics.areEqual(r15, ic8.j.b(r45)) == false) goto L38;
    L48:
        com.larus.bmhome.actionbar.model.z0 r6 = (com.larus.bmhome.actionbar.model.z0) r12;
    L67:
        if (r6 == null) goto L73;
        com.larus.bmhome.actionbar.model.r r8 = r6.q;
        if (r8 == null) goto L73;
        if (r8.f() != true) goto L73;
        boolean r9 = true;
    L74:
        if (r9 == false) goto L254;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L80;
        r0.H();
        if (com.larus.home.impl.sdk.l1.a.c() != true) goto L80;
        boolean r1 = true;
    L81:
        IUgcAIGCService r16 = (IUgcAIGCService) ServiceManager.get().getService(IUgcAIGCService.class);
        if (r16 == null) goto L84;
        com.larus.uaigc.api.a r17 = r16.G();
    L85:
        Map r19 = r45.getExt();
        if (r19 == null) goto L88;
        String r110 = (String) r19.get("white_tee_index_list");
    L90:
        if (com.larus.utils.o0.d(r110) == false) goto L102;
        if (r1 == true) goto L102;
        if (r17 == null) goto L102;
        FLogger.a.i("CoreInputAbility", "startModify instruction msg, enter avatar creation");
        Pair[] r20 = new Pair[8];
        r20[0] = TuplesKt.to("argConversationId", v());
        r20[1] = TuplesKt.to("is_from_template", "0");
        r20[2] = TuplesKt.to("enter_method", "re_edit");
        com.larus.bmhome.actionbar.model.r r21 = r6.q;
        if (r21 == null) goto L96;
        r14 = r21.b();
    L96:
        r20[3] = TuplesKt.to("click_from", r14);
        r20[4] = TuplesKt.to("previous_page", "chat");
        r20[5] = TuplesKt.to("bot_id", getBotId());
        wc9.e r22 = h();
        if (r22 == null) goto L99;
        String r23 = ic8.n.f(r22);
    L100:
        r20[6] = TuplesKt.to("chat_type", r23);
        r20[7] = TuplesKt.to("enter_create_from", "from_msg_reedit");
        Bundle r24 = com.larus.utils.f.c(r20);
        com.bytedance.router.i r25 = SmartRouter.buildRoute(this.h, "//flow/create_digital_avatar");
        r25.c.putExtras(r24);
        r25.d();
        return;
    L99:
        r23 = null;
    L102:
        com.larus.bmhome.actionbar.model.r r26 = r6.q;
        if (r26 == null) goto L110;
        Integer r27 = r26.a;
        if (r27 == null) goto L110;
        if (r27.intValue() != 28) goto L110;
        boolean r28 = true;
    L111:
        boolean r29 = com.larus.platform.service.z2.a.enableMixSkillReeditHalfScreen();
        if (r28 == false) goto L115;
        if (r29 == false) goto L115;
        boolean r210 = true;
    L116:
        Gson r30 = (Gson) this.H.getValue();
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L123
        Map r32 = r45.getExt();     // Catch: Throwable -> L123
        if (r32 == null) goto L120;
        String r33 = (String) r32.get("white_tee_index_list");     // Catch: Throwable -> L123
    L121:
        Object r34 = Result.constructor-impl((ArrayList) r30.fromJson(r33, new d().getType()));     // Catch: Throwable -> L123
    L126:
        if (Result.isFailure-impl(r34) == false) goto L128;
        r34 = null;
    L128:
        ArrayList r35 = (ArrayList) r34;
        if (r35 != null) goto L131;
        r35 = new ArrayList();
    L131:
        ArrayList r36 = r35;
        FragmentActivity r211 = this.g.getActivity();
        if (r211 == null) goto L248;
        Image r212 = D(r45, r44.getCurrentList());
        List r37 = CollectionsKt.listOfNotNull(new Message[]{r45, com.larus.bmhome.chat.adapter.f0.b(r45, r44.getCurrentList())});
        HashSet r38 = new HashSet();
        ArrayList r39 = new ArrayList();
        Iterator r40 = r37.iterator();
    L135:
        if (r40.hasNext() == false) goto L139;
        Object r41 = r40.next();
        if (r38.add(((Message) r41).getLocalMessageId()) == false) goto L135;
        r39.add(r41);
        goto L135
    L139:
        ic8.u r42 = ic8.u.a;
        ArrayList r43 = new ArrayList();
        Iterator r48 = r39.iterator();
    L141:
        if (r48.hasNext() == false) goto L143;
        Message r49 = (Message) r48.next();
        r42.getClass();
        CollectionsKt.addAll(r43, ic8.u.a(r49));
        goto L141
    L143:
        ArrayList r50 = new ArrayList();
        Iterator r51 = r43.iterator();
    L145:
        if (r51.hasNext() == false) goto L149;
        Object r52 = r51.next();
        if (yc9.n1.a((UplinkFileEntity) r52) == false) goto L145;
        r50.add(r52);
        goto L145
    L149:
        HashSet r53 = new HashSet();
        ArrayList r54 = new ArrayList();
        Iterator r55 = r50.iterator();
    L151:
        if (r55.hasNext() == false) goto L177;
        Object r56 = r55.next();
        String r111 = (UplinkFileEntity) r56;
        String r112 = r111.getFileIdentifier();
        if (r112 != null) goto L155;
    L160:
        UplinkEntityContent r113 = r111.getUplinkEntityContent();
        if (r113 == null) goto L171;
        UplinkFileInfo r114 = r113.getUplinkFileInfo();
        if (r114 == null) goto L171;
        VideoExtension r115 = r114.getVideo();
        if (r115 == null) goto L171;
        r112 = r115.getVid();
        if (r112 == null) goto L171;
        if ((!StringsKt.isBlank(r112)) == false) goto L171;
    L172:
        if (r112 == null) goto L175;
    L173:
        r111 = r112;
    L175:
        if (r53.add(r111) == false) goto L151;
        r54.add(r56);
    L171:
        r112 = null;
        goto L172
    L155:
        if ((!StringsKt.isBlank(r112)) == true) goto L158;
        r112 = null;
    L158:
        if (r112 == null) goto L160;
    L177:
        ArrayList r57 = new ArrayList();
        Iterator r58 = r54.iterator();
    L179:
        if (r58.hasNext() == false) goto L216;
        UplinkEntityContent r59 = ((UplinkFileEntity) r58.next()).getUplinkEntityContent();
        if (r59 == null) goto L212;
        UplinkFileInfo r60 = r59.getUplinkFileInfo();
        if (r60 == null) goto L212;
        VideoExtension r61 = r60.getVideo();
        if (r61 == null) goto L188;
        String r310 = r61.getVid();
    L189:
        if (r61 == null) goto L198;
        String r116 = r61.getFormat();
        if (r116 == null) goto L198;
        if ((!StringsKt.isBlank(r116)) == true) goto L196;
        r116 = null;
    L196:
        if (r116 == null) goto L198;
        String r117 = r116;
    L204:
        String r311 = r117;
    L206:
        if (r61 == null) goto L210;
        Float r62 = r61.getDuration();
        if (r62 == null) goto L210;
        Double r312 = Double.valueOf(r62.floatValue());
    L211:
        ResourceExt r63 = new ResourceExt(new Resource(3, null, new AudioResource(r310, r311, r312, r60.getFileName(), 2), 22), null, 2);
    L213:
        if (r63 == null) goto L179;
        r57.add(r63);
    L210:
        r312 = null;
    L198:
        String r118 = r60.getFileName();
        if (r118 == null) goto L205;
        r117 = StringsKt.substringAfterLast(r118, '.', "");
        if (r117 == null) goto L205;
        if ((!StringsKt.isBlank(r117)) == true) goto L204;
    L205:
        r311 = null;
        goto L206
    L188:
        r310 = null;
    L212:
        r63 = null;
        goto L213
    L216:
        c r64 = new c(r6, this);
        if (r4 == false) goto L224;
        Map r65 = r45.getExt();
        if (r65 == null) goto L222;
        String r66 = (String) r65.get("pocket_map");
        if (r66 == null) goto L222;
    L223:
        Map r313 = MapsKt.mapOf(TuplesKt.to("pocket_map", r66));
    L225:
        com.larus.bmhome.instruction.g r67 = A().vc();
        if (r67 == null) goto L228;
        r67.SU(true);
        Unit r68 = Unit.INSTANCE;
    L228:
        ICreationPageService r213 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
        if (r213 == null) goto L248;
        ChatParam r214 = new ChatParam(v(), getBotId(), null, null, null, 252);
        Map r69 = r45.getExt();
        if (r69 == null) goto L233;
        String r215 = (String) r69.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
    L234:
        com.larus.bmhome.actionbar.model.r r70 = com.larus.bmhome.actionbar.util.h.a(r45);
        if (r70 == null) goto L242;
        com.larus.bmhome.actionbar.model.h1 r71 = r70.c;
        if (r71 == null) goto L242;
        String r72 = r71.b;
        if (r72 == null) goto L242;
        String r216 = r72;
    L243:
        Bundle r314 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "send_img_edit")});
        by7.e r73 = this.g;
        if ((r73 instanceof by7.e) == false) goto L246;
        by7.e r315 = r73;
        ICoreInputAbility.OnSendParams r74 = null;
    L247:
        ICreationPageService.b.a(r213, r210, r211, r6, r214, false, r215, r216, r212, r57, r36, true, r64, r315, r314, r313, r(r74), this.g, 16386336);
        Unit r75 = Unit.INSTANCE;
        goto L248
    L246:
        r74 = null;
        r315 = null;
    L242:
        r216 = "";
        goto L243
    L233:
        r215 = null;
    L222:
        r66 = "";
        goto L223
    L224:
        r313 = null;
    L248:
        if (r46 == false) goto L250;
        String r76 = "long_press";
    L251:
        LruCache r77 = ko8.a.a;
        long r78 = de8.d.a(A().f1());
        Intrinsics.checkNotNullParameter(r45, "msg");
        Intrinsics.checkNotNullParameter(r76, "type");
        IAIChatControlTraceService.a.Pb(r45, r76, r78, r7);
        return;
    L250:
        r76 = "click";
        goto L251
    L120:
        r33 = null;
    L123:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L115:
        r210 = false;
    L110:
        r28 = false;
        goto L111
    L88:
        r110 = null;
        goto L90
    L84:
        r17 = null;
    L80:
        r1 = false;
    L73:
        r9 = false;
        goto L74
    L42:
        r15 = null;
        goto L44
    L47:
        r12 = null;
    L66:
        r6 = null;
        goto L67
    L33:
        if (r18.intValue() != 16) goto L35;
    L49:
        if (r11 == null) goto L66;
        Iterator r80 = r11.iterator();
    L52:
        if (r80.hasNext() == false) goto L64;
        Object r81 = r80.next();
        com.larus.bmhome.actionbar.model.r r119 = ((com.larus.bmhome.actionbar.model.z0) r81).q;
        if (r119 == null) goto L61;
        Integer r120 = r119.a;
        if (r120 == null) goto L61;
        if (r120.intValue() != 16) goto L61;
        boolean r121 = true;
    L62:
        if (r121 == false) goto L52;
    L65:
        r6 = (com.larus.bmhome.actionbar.model.z0) r81;
    L61:
        r121 = false;
        goto L62
    L64:
        r81 = null;
        goto L65
    L29:
        if (r18.intValue() == 4) goto L49;
    L24:
        r11 = null;
    L254:
        if (com.larus.bmhome.chat.adapter.h0.a(r45, r44.W()) == true) goto L256;
        return;
    L256:
        if (com.larus.bmhome.chat.adapter.h0.g(r44, r45) == false) goto L439;
        IAIChatControlTraceService.a.Ja(r45.getMessageId());
        F().updateModifyMode(r47);
        bc8.a r82 = A().aE();
        if (r82 == null) goto L260;
        r82.mX();
        Unit r83 = Unit.INSTANCE;
    L260:
        F().updateModifyingMessage(r45);
        com.larus.bmhome.chat.component.bottom.multimodal.latest.a r84 = A().KN();
        if (r84 == null) goto L263;
        r84.g0("CoreInputAbility#startModify");
        Unit r85 = Unit.INSTANCE;
    L263:
        com.larus.bmhome.chat.component.bottom.reference.a r86 = A().g5();
        if (r86 != null) goto L266;
    L269:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r87 = A().f70();
        if (r87 == null) goto L272;
        String r88 = r87.uM();
    L273:
        if (r88 != null) goto L276;
        r88 = "";
    L276:
        if ((!StringsKt.isBlank(r88)) == false) goto L280;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r89 = A().f70();
        if (r89 == null) goto L280;
        r89.b2(r88);
        Unit r90 = Unit.INSTANCE;
    L280:
        Integer r91 = com.larus.platform.service.z2.a.attachmentEditConfig().getReeditWithAttachment();
        if (r91 != null) goto L284;
    L291:
        com.larus.bmhome.chat.component.list.u7 r92 = A().u3();
        if (r92 == null) goto L294;
        r92.tJ(true);
        Unit r93 = Unit.INSTANCE;
    L294:
        C1(false, true, "");
        com.larus.bmhome.chat.component.list.u7 r94 = A().u3();
        if (r94 == null) goto L298;
        r94.P80();
        Unit r95 = Unit.INSTANCE;
    L298:
        if (ic8.j.i(r45) == true) goto L300;
    L346:
        String r96 = com.larus.bmhome.chat.bean.d.H(r45);
        if (r96 != null) goto L349;
        r96 = "";
    L349:
        Map r97 = r45.getExt();
        if (r97 == null) goto L352;
        String r122 = (String) r97.get("collection_id");
    L353:
        if (r122 != null) goto L355;
        r122 = "";
    L355:
        com.larus.bmhome.chat.component.list.u7 r99 = A().u3();
        if (r99 == null) goto L376;
        List r100 = r99.zj();
        if (r100 == null) goto L376;
        Iterator r101 = r100.iterator();
    L361:
        if (r101.hasNext() == false) goto L374;
        Object r102 = r101.next();
        Message r103 = (Message) r102;
        if (r103.getContentType() != 1) goto L371;
        Map r104 = r103.getExt();
        if (r104 == null) goto L367;
        String r105 = (String) r104.get("collection_id");
    L369:
        if (Intrinsics.areEqual(r105, r122) == false) goto L371;
        boolean r106 = true;
    L372:
        if (r106 == false) goto L361;
        Object r123 = r102;
    L375:
        Message r124 = (Message) r123;
    L377:
        if (r124 == null) goto L384;
        String r107 = com.larus.bmhome.chat.bean.d.H(r124);
        if (r107 == null) goto L382;
        r14 = r107;
    L382:
        Unit r108 = Unit.INSTANCE;
        r96 = r14;
    L384:
        if (CoreInputViewModel.getActionShownByConf$default(F(), false, 1, null) != 5) goto L388;
        com.larus.bmhome.instruction.g r109 = A().vc();
        if (r109 == null) goto L388;
        r109.VQ(r96);
        Unit r125 = Unit.INSTANCE;
    L388:
        M0(r96, false);
    L389:
        com.larus.bmhome.chat.model.j1 r126 = A().Y3();
        if (r126 == null) goto L392;
        r126.q();
        Unit r127 = Unit.INSTANCE;
    L392:
        gd8.g r128 = A().h2();
        if (r128 == null) goto L395;
        r128.mh(v(), "start_modify", OmniBreakReason.OmniBreakReason_EDIT_MSG);
        Unit r129 = Unit.INSTANCE;
    L395:
        if (r46 == false) goto L397;
        String r130 = "long_press";
    L398:
        com.larus.bmhome.chat.component.bottom.p1 r131 = A().cr();
        if (r131 == null) goto L403;
        View r132 = r131.bo();
        if (r132 == null) goto L403;
        r132.setTag(r130);
        Unit r133 = Unit.INSTANCE;
    L403:
        String r134 = this.f.u7();
        LruCache r135 = ko8.a.a;
        IAIChatControlTraceService.Companion r136 = IAIChatControlTraceService.a;
        com.larus.bmhome.chat.trace.m r137 = r136.getTraceInfo();
        r137.getClass();
        Intrinsics.checkNotNullParameter(r134, "<set-?>");
        r137.a = r134;
        long r138 = de8.d.a(A().f1());
        Intrinsics.checkNotNullParameter(r45, "msg");
        Intrinsics.checkNotNullParameter(r130, "type");
        r136.Pb(r45, r130, r138, r7);
        ILegacyChatUiServiceDelegate.b.T8(true);
        return;
    L397:
        r130 = "click";
        goto L398
    L367:
        r105 = null;
    L371:
        r106 = false;
        goto L372
    L374:
        r123 = null;
    L376:
        r124 = null;
        goto L377
    L352:
        r122 = null;
        goto L353
    L300:
        if (ic8.j.k(r45) == true) goto L346;
        if (A().vc() == null) goto L346;
        com.larus.bmhome.instruction.g r139 = A().vc();
        if (r139 != null) goto L306;
    L308:
        boolean r140 = false;
    L309:
        if (r140 == true) goto L346;
        com.larus.bmhome.instruction.g r141 = A().vc();
        if (r141 == null) goto L313;
        List r217 = r141.tq();
    L314:
        com.larus.bmhome.instruction.g r142 = A().vc();
        if (r142 == null) goto L328;
        List r218 = r142.tq();
        if (r218 == null) goto L328;
        Image r316 = D(r45, r44.getCurrentList());
        com.larus.bmhome.instruction.g r219 = A().vc();
        if (r219 == null) goto L325;
        com.larus.bmhome.actionbar.model.r r220 = com.larus.bmhome.actionbar.util.h.a(r45);
        String r221 = com.larus.bmhome.chat.bean.d.i(r45);
        Map r143 = r45.getExt();
        if (r143 == null) goto L323;
        String r222 = (String) r143.get("action_bar_option_id");
    L324:
        Boolean r144 = Boolean.valueOf(r219.qf(r220, r221, r222, r218, r316));
    L326:
        if (r144 == null) goto L328;
        boolean r145 = r144.booleanValue();
    L329:
        if (r217 == null) goto L337;
        Image r223 = D(r45, r44.getCurrentList());
        com.larus.bmhome.instruction.g r224 = A().vc();
        if (r224 == null) goto L337;
        com.larus.bmhome.actionbar.model.r r225 = com.larus.bmhome.actionbar.util.h.a(r45);
        String r226 = com.larus.bmhome.chat.bean.d.i(r45);
        Map r146 = r45.getExt();
        if (r146 == null) goto L335;
        String r227 = (String) r146.get("action_bar_option_id");
    L336:
        r224.qf(r225, r226, r227, r217, r223);
        goto L337
    L335:
        r227 = null;
    L337:
        com.larus.bmhome.actionbar.model.r r147 = com.larus.bmhome.actionbar.util.h.a(r45);
        if (r147 == null) goto L345;
        com.larus.bmhome.actionbar.model.h1 r148 = r147.c;
        if (r148 == null) goto L345;
        String r149 = r148.b;
        if (r149 == null) goto L345;
        r14 = r149;
    L345:
        M0(r14, r145);
        goto L389
    L323:
        r222 = null;
        goto L324
    L325:
        r144 = null;
    L328:
        r145 = false;
        goto L329
    L313:
        r217 = null;
        goto L314
    L306:
        if (r139.Q1() != 8) goto L308;
        r140 = true;
        goto L309
    L284:
        if (r91.intValue() != 1) goto L291;
        if (ic8.j.i(r45) == true) goto L291;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r150 = A().f70();
        if (r150 == null) goto L290;
        r150.Es(true);
        Unit r151 = Unit.INSTANCE;
    L290:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.g), null, null, new CoreInputAbility$startModify$3(this, r45, null), 3, null);
        goto L291
    L272:
        r88 = null;
        goto L273
    L266:
        if (r86.i9() == false) goto L268;
        r86.sZ();
    L268:
        Unit r152 = Unit.INSTANCE;
        goto L269
    L439:
        return;
    L11:
        r3 = null;
    L15:
        r4 = false;
        goto L16
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void qB(CharSequence r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        if (r5 == false) goto L6;
        this.f.qW();
    L6:
        if (r6 == false) goto L8;
        g2(1, true);
        this.f.S9(200, new a2(this));
    L8:
        boolean r8 = this.r;
        if (r7 == true) goto L23;
        this.r = true;
    L23:
        this.f.u40(r4);     // Catch: Throwable -> L18
        this.r = r8;
        this.f.v3(r4.length());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.a.e("CoreInputAbility", "setSelection crash:" + e);
        return;
    L18:
        th = move-exception;
        this.r = r8;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.larus.bmhome.chat.component.bottom.core.k] */
    public final void J0(CharSequence r5, boolean r6, boolean r7, final Integer r8, final Integer r9) {
        if (r6 == true) goto L37;
    L8:
        final ?? r10 = new k(this, r8, r9);
        if (r8 == null) goto L21;
        if (r9 == null) goto L21;
        if (r8.intValue() > r5.length()) goto L21;
        if (r8.intValue() < 0) goto L21;
        if (r9.intValue() > r5.length()) goto L21;
        if (r9.intValue() < 0) goto L21;
        boolean r11 = false;
    L22:
        if (r7 == false) goto L27;
        g2(1, true);
        if (r11 == false) goto L26;
        this.f.S9(200, new l(this));
        goto L27
    L26:
        this.f.S9(200, new n(r10, this));
    L27:
        this.f.u40(r5);
        if (r11 == true) goto L35;
        r10.run();
        return;
    L35:
        this.f.v3(r5.length());     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        FLogger.a.e("CoreInputAbility", "setSelection crash:" + e);
        return;
    L21:
        r11 = true;
        goto L22
    L37:
        this.f.qW();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.a.e("CoreInputAbility", "requestEditFocus failed:" + e);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void SK(String r18, boolean r19, SuggestedAction r20, String r21, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r18, "content");
        if (r19 == false) goto L6;
        if (r20 != null) goto L6;
        boolean r12 = true;
    L7:
        t(this, r18, r19, null, r20, r21, null, r22, null, null, null, r12, 0, false, 7072);
        return;
    L6:
        r12 = false;
        goto L7
    }

    public final void G0(String r31, ICoreInputAbility.OnSendParams r32, String r33, Map<String, String> r34, String r35, String r36) {
        ArrayList r5 = new ArrayList();
        Map r4 = com.larus.utils.h.c(r34, new Pair[0]);
        r4.put("content_source", "upload");
        SuggestedAction r0 = r32.getSuggestedAction();
        if (r0 == null) goto L216;
        Map r1 = r0.getMsgExt();
        if (r1 == null) goto L216;
        r4.putAll(r1);
    L216:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L87
        if (IBachDetectCenterAbility.a.b() == false) goto L85;
        CustomMultiAttachmentInfo r3 = r32.getCustomMultiAttachment();     // Catch: Throwable -> L87
        if (r3 == null) goto L82;
        NestedFileContent r6 = r3.getNestedFileContent();     // Catch: Throwable -> L87
        if (r6 == null) goto L82;
        List r7 = r6.getEntities();     // Catch: Throwable -> L87
        if (r7 == null) goto L82;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L87
        boolean r9 = false;
    L18:
        if (r8.hasNext() == false) goto L83;
        UplinkFileEntity r10 = (UplinkFileEntity) r8.next();     // Catch: Throwable -> L87
        Integer r11 = r10.getEntityType();     // Catch: Throwable -> L87
        int r12 = UplinkEntityType.EntityTypeImage.getValue();     // Catch: Throwable -> L87
        if (r11 == null) goto L18;
        if (r11.intValue() != r12) goto L18;
        UplinkEntityContent r13 = r10.getUplinkEntityContent();     // Catch: Throwable -> L87
        if (r13 == null) goto L32;
        Image r14 = r13.getUplinkImageInfo();     // Catch: Throwable -> L87
        if (r14 == null) goto L32;
        ImageObj r15 = r14.imageOri;     // Catch: Throwable -> L87
        if (r15 == null) goto L32;
        String r16 = r15.url;     // Catch: Throwable -> L87
    L33:
        UplinkEntityContent r17 = r10.getUplinkEntityContent();     // Catch: Throwable -> L87
        if (r17 == null) goto L38;
        Image r18 = r17.getUplinkImageInfo();     // Catch: Throwable -> L87
        if (r18 == null) goto L38;
        String r19 = r18.localResPath;     // Catch: Throwable -> L87
    L40:
        if (com.larus.utils.o0.d(r16) == true) goto L41;
        if (com.larus.utils.o0.d(r19) == true) goto L68;
        r19 = null;
    L68:
        if (r19 == null) goto L18;
        PolarisFileWrapper r20 = new PolarisFileWrapper(r19);     // Catch: Throwable -> L87
        if (r20.exists() == false) goto L18;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L73
        Object r22 = Result.constructor-impl(Uri.fromFile(r20));     // Catch: Throwable -> L73
    L76:
        if (Result.isSuccess-impl(r22) == false) goto L18;
        Uri r23 = (Uri) r22;     // Catch: Throwable -> L87
        IBachDetectCenterAbility.Companion r24 = IBachDetectCenterAbility.a;     // Catch: Throwable -> L87
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L87
        Boolean r25 = r24.c(r23, true);     // Catch: Throwable -> L87
        if (r25 == null) goto L18;
        if (r25.booleanValue() == false) goto L18;
    L81:
        r9 = true;
    L73:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L87
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L87
        goto L76
    L41:
        Uri r27 = com.larus.utils.y0.j(r16);     // Catch: Throwable -> L87
        if (r27 == null) goto L18;
        if (Intrinsics.areEqual(IBachDetectCenterAbility.a.c(r27, true), Boolean.TRUE) == true) goto L81;
        if (com.larus.utils.o0.d(r19) == true) goto L50;
        r19 = null;
    L50:
        if (r19 == null) goto L18;
        PolarisFileWrapper r28 = new PolarisFileWrapper(r19);     // Catch: Throwable -> L87
        if (r28.exists() == false) goto L18;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L55
        Object r30 = Result.constructor-impl(Uri.fromFile(r28));     // Catch: Throwable -> L55
    L58:
        if (Result.isSuccess-impl(r30) == false) goto L18;
        Uri r37 = (Uri) r30;     // Catch: Throwable -> L87
        IBachDetectCenterAbility.Companion r38 = IBachDetectCenterAbility.a;     // Catch: Throwable -> L87
        Intrinsics.checkNotNull(r37);     // Catch: Throwable -> L87
        Boolean r39 = r38.c(r37, true);     // Catch: Throwable -> L87
        if (r39 == null) goto L18;
        if (r39.booleanValue() == false) goto L18;
    L55:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L87
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L87
    L38:
        r19 = null;
    L32:
        r16 = null;
    L83:
        if (r9 == false) goto L85;
        r4.put(IAIChatUgcAIGCService.a.F0(), "1");     // Catch: Throwable -> L87
    L82:
        r9 = false;
    L85:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L87
    L89:
        LinkedHashMap r41 = new LinkedHashMap();
        FlowDriveFileSendInfo r42 = r32.getDriveFileSendInfo();
        if (r42 == null) goto L107;
        JSONObject r43 = new JSONObject();
        String r44 = r42.getCollectionId();
        if (r44 == null) goto L94;
        r43.put("collection_id", r44);
    L94:
        String r45 = r42.getCollectionName();
        if (r45 == null) goto L97;
        r43.put("collection_name", r45);
    L97:
        String r46 = r42.getContentType();
        if (r46 == null) goto L100;
        r43.put("content_type", r46);
    L100:
        String r47 = r42.getContentSecType();
        if (r47 == null) goto L104;
        r43.put("content_sec_type", r47);
    L104:
        if (r43.length() <= 0) goto L107;
        r41.put("drive_file_send_info", r43.toString());
    L107:
        if ((!r41.isEmpty()) == false) goto L109;
        LinkedHashMap r110 = r41;
    L110:
        CustomMultiAttachmentInfo r48 = r32.getCustomMultiAttachment();
        if (r48 == null) goto L191;
        NestedFileContent r49 = r48.getNestedFileContent();
        if (r49 == null) goto L191;
        yc9.v0.g(r49);
        if (yc9.v0.h(r49) <= 0) goto L191;
        if (r35 != null) goto L118;
        int r50 = wf9.b.a;
        String r210 = com.flow.kmp.common.util.i.a();
    L119:
        r5.add(new ai8.f(r49, r210, null, r32.getReferenceInfo(), r4, r110, false, null, r(r32), r32.fileForceTraceMap, 196));
        String r51 = getBotId();
        String r52 = v();
        List r53 = r49.getEntities();
        if (r53 == null) goto L191;
        Iterator r54 = r53.iterator();
    L123:
        if (r54.hasNext() == false) goto L191;
        UplinkFileEntity r55 = (UplinkFileEntity) r54.next();
        UplinkEntityContent r56 = r55.getUplinkEntityContent();
        if (r56 == null) goto L129;
        Image r57 = r56.getUplinkImageInfo();
        if (r57 == null) goto L129;
        String r211 = r57.key;
    L130:
        if (r211 == null) goto L123;
        if (yc9.n1.d(r55) == false) goto L123;
        Integer r58 = r55.getFileReviewStatus();
        int r59 = FileReviewState.ACCESS.getValue();
        if (r58 == null) goto L138;
        if (r58.intValue() == r59) goto L123;
    L138:
        CustomMultiAttachmentInfo r60 = r32.getCustomMultiAttachment();
        if (r60 == null) goto L144;
        if (r60.getOverrideSinceId() != true) goto L144;
        boolean r111 = true;
    L145:
        if (r111 == false) goto L147;
        String r61 = FlowResourceScene.SpringMainVenue.getSceneIDForDoubao();
    L148:
        String r212 = r61;
        String r112 = r55.getFileIdentifier();
        FLogger.a.i("CoreInputAbility", "[sendMultiAttachmentsWithoutCache] identifier = " + r112);
        String r62 = r55.getInstantUploadInfoJson();
        if (r62 != null) goto L151;
    L167:
        ResourceUploadInstantInfo r213 = null;
    L168:
        String r63 = yc9.l1.g(r55);
        if (r63 != null) goto L171;
    L174:
        boolean r113 = true;
    L175:
        if (r113 == true) goto L180;
        if (r213 == null) goto L178;
        boolean r64 = Intrinsics.areEqual(r213.getPreQueryHit(), Boolean.TRUE);
    L179:
        if (r64 == false) goto L123;
    L178:
        r64 = false;
    L180:
        int r65 = RegisterHelper.a;
        UplinkEntityContent r66 = r55.getUplinkEntityContent();
        if (r66 == null) goto L183;
        Image r214 = r66.getUplinkImageInfo();
    L184:
        wc9.e r67 = h();
        if (r67 == null) goto L187;
        String r215 = r67.B;
    L188:
        RegisterHelper.b(r210, r51, r52, r211, r212, r112, r213, r214, r215);
        goto L123
    L187:
        r215 = null;
        goto L188
    L183:
        r214 = null;
        goto L184
    L171:
        if (r63.length() == 0) goto L174;
        r113 = false;
        goto L175
    L151:
        if (r62.length() <= 0) goto L153;
        boolean r114 = true;
    L154:
        if (r114 == true) goto L157;
        r62 = null;
    L157:
        if (r62 == null) goto L167;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L161
        Object r68 = Result.constructor-impl((ResourceUploadInstantInfo) new Gson().fromJson(r62, ResourceUploadInstantInfo.class));     // Catch: Throwable -> L161
    L164:
        if (Result.isFailure-impl(r68) == false) goto L166;
        r68 = null;
    L166:
        r213 = (ResourceUploadInstantInfo) r68;
    L161:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L164
    L153:
        r114 = false;
        goto L154
    L147:
        r61 = "";
    L144:
        r111 = false;
    L129:
        r211 = null;
        goto L130
    L118:
        r210 = r35;
    L191:
        if (r31.length() <= 0) goto L193;
        boolean r69 = true;
    L194:
        if (r69 == true) goto L196;
    L200:
        ConcurrentHashMap r70 = ko8.b.a;
        String r71 = r32.getCreationSendTraceId();
        ArrayList r72 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r73 = r5.iterator();
    L202:
        if (r73.hasNext() == false) goto L204;
        r72.add(((ic8.w) r73.next()).b());
        goto L202
    L204:
        ko8.b.b(r71, r72);
        gd8.g r74 = A().h2();
        if (r74 == null) goto L265;
        wc9.e r75 = h();
        CustomMultiAttachmentInfo r76 = r32.getCustomMultiAttachment();
        if (r76 == null) goto L209;
        String r77 = r76.getFromScene();
    L210:
        gd8.g.a.a(r74, r75, r33, r5, r77, null, r32.getSendClickTimestamp(), 16);
        return;
    L209:
        r77 = null;
        goto L210
    L265:
        return;
    L196:
        if (r36 != null) goto L198;
        int r78 = wf9.b.a;
        String r79 = com.flow.kmp.common.util.i.a();
    L199:
        r5.add(new ai8.h(r31, r79, null, r32.getReferenceInfo(), r4, r110, false, false, r(r32), r32.textForceTraceMap, 196));
        goto L200
    L198:
        r79 = r36;
        goto L199
    L193:
        r69 = false;
        goto L194
    L109:
        r110 = null;
    L87:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L89
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void M50(CharSequence r2, boolean r3, boolean r4, Integer r5, Integer r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        boolean r0 = this.r;
        if (r7 == true) goto L11;
        this.r = true;
    L11:
        J0(r2, r3, r4, r5, r6);     // Catch: Throwable -> L8
        this.r = r0;
        return;
    L8:
        th = move-exception;
        this.r = r0;
        throw th;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility
    public final void bu(String r17, SuggestedAction r18, String r19, Map r20, Map r21, Map r22) {
        Intrinsics.checkNotNullParameter(r17, "content");
        t(this, r17, false, null, r18, r19, null, r20, null, r21, r22, true, 0, false, 6308);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void t(final CoreInputAbility r47, String r48, boolean r49, AttachmentInfo r50, SuggestedAction r51, String r52, ReferenceInfo r53, Map r54, MultiAttachmentInfo r55, Map r56, Map r57, boolean r58, long r59, boolean r61, int r62) {
        if ((r62 & 4) == 0) goto L5;
        AttachmentInfo r3 = null;
    L7:
        if ((r62 & 8) == 0) goto L9;
        SuggestedAction r24 = null;
    L11:
        if ((r62 & 16) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r62 & 32) == 0) goto L17;
        ReferenceInfo r5 = null;
    L19:
        if ((r62 & 64) == 0) goto L21;
        Map r6 = null;
    L23:
        if ((r62 & 128) == 0) goto L25;
        MultiAttachmentInfo r7 = null;
    L27:
        if ((r62 & 256) == 0) goto L29;
        Map r33 = null;
    L31:
        if ((r62 & 512) == 0) goto L33;
        Map r34 = null;
    L35:
        if ((r62 & 1024) == 0) goto L37;
        boolean r8 = false;
    L39:
        if ((r62 & 2048) == 0) goto L41;
        long r11 = System.currentTimeMillis();
    L43:
        if ((r62 & 4096) == 0) goto L45;
        boolean r2 = false;
    L46:
        r47.getClass();
        Intrinsics.checkNotNullParameter(r48, "content");
        r47.n0();
        FLogger r13 = FLogger.a;
        r13.i("CoreInputAbility", "[doSendMessage] scene:" + r4);
        com.larus.bmhome.instruction.g r9 = r47.A().vc();
        if (r9 == null) goto L49;
        AttachmentInfo r10 = r9.n4();
    L51:
        if (r10 == null) goto L53;
        boolean r12 = true;
    L54:
        com.larus.bmhome.instruction.g r17 = r47.A().vc();
        if (r17 == null) goto L58;
        AttachmentInfo r18 = r17.n4();
        if (r18 == null) goto L58;
    L59:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r19 = r47.A().f70();
        if (r19 != null) goto L62;
    L64:
        boolean r14 = false;
    L65:
        com.larus.bmhome.chat.component.bottom.reference.a r110 = r47.A().g5();
        if (r110 == null) goto L68;
        String r39 = r110.TL();
    L69:
        com.larus.bmhome.instruction.g r15 = r47.A().vc();
        if (r15 == null) goto L74;
        long r510 = r11;
        boolean r16 = true;
        if (r15.x(r48) != true) goto L75;
        boolean r40 = true;
    L76:
        com.larus.bmhome.chat.component.bottom.reference.a r111 = r47.A().g5();
        if (r111 != null) goto L79;
    L81:
        boolean r112 = false;
    L82:
        com.larus.bmhome.instruction.g r113 = r47.A().vc();
        if (r113 == null) goto L85;
        Map r114 = r113.nK(r48);
    L86:
        com.larus.bmhome.chat.component.bottom.reference.a r115 = r47.A().g5();
        if (r115 == null) goto L89;
        String r116 = r115.vS();
    L90:
        if (r24 == null) goto L94;
        PromptReplacementCfg r117 = r24.getPromptReplacementCfg();
        if (r117 == null) goto L94;
        String r118 = r117.getReplacementKey();
    L96:
        if (r118 == null) goto L101;
        if (r112 == false) goto L99;
        String r119 = "cite_suggest";
    L100:
        MultiAttachmentInfo r511 = r7;
        Map r512 = r114;
    L116:
        IAsrDirectFillAbility r20 = (IAsrDirectFillAbility) r47.M.getValue();
        if (r20 == null) goto L119;
        IAsrDirectFillAbility.DirectFillStatus r21 = r20.VY();
    L121:
        if (com.larus.utils.o0.d(r4) == true) goto L136;
        if (r49 == true) goto L135;
        if (r112 == false) goto L130;
        if (Intrinsics.areEqual(r119, "cite_suggest") == false) goto L130;
        String r25 = "cite_suggest";
    L138:
        if (r47.c1() == true) goto L140;
    L152:
        bs8.n r22 = null;
    L153:
        String r23 = r47.E(r39, r48);
        Iterator r120 = ((ArrayList) r47.C).iterator();
    L155:
        if (r120.hasNext() == false) goto L157;
        r23 = ((ICoreInputAbility.c) r120.next()).b(r23);
        goto L155
    L157:
        if (r22 == null) goto L160;
        String r1 = r22.a(r23);
        if (r1 == null) goto L160;
    L161:
        if (r8 == false) goto L166;
        if (r14 == false) goto L166;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r26 = r47.A().f70();
        if (r26 == null) goto L166;
        Map<String, String> r27 = r26.xt();
    L167:
        if (r27 == null) goto L172;
        if (r6 != null) goto L171;
        r6 = MapsKt.emptyMap();
    L171:
        r6 = MapsKt.toMutableMap(r6);
        r6.putAll(r27);
    L172:
        if (r22 != null) goto L174;
    L183:
        if (r2 == false) goto L187;
        if (r6 != null) goto L186;
        r6 = MapsKt.emptyMap();
    L186:
        Map r28 = MapsKt.plus(r6, TuplesKt.to("resourcemention", "1"));
    L188:
        if (r27 != null) goto L190;
    L194:
        if (r112 == false) goto L196;
        String r29 = "";
    L197:
        if (r12 == true) goto L201;
        if (r3 != null) goto L201;
        AttachmentInfo r30 = null;
    L202:
        if (r511 != null) goto L218;
        if (r14 == false) goto L217;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r31 = r47.A().f70();
        if (r31 == null) goto L207;
        String r32 = r31.Wv();
    L208:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r35 = r47.A().f70();
        if (r35 == null) goto L211;
        String r36 = r35.ZO();
    L212:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r37 = r47.A().f70();
        if (r37 == null) goto L215;
        String r38 = r37.aj();
    L216:
        MultiAttachmentInfo r41 = new MultiAttachmentInfo(r32, r36, r38);
    L219:
        if (r5 != 0) goto L227;
        com.larus.bmhome.chat.component.bottom.reference.a r42 = r47.A().g5();
        if (r42 == null) goto L223;
        ReferenceInfo r43 = r42.T6();
    L224:
        if (r43 != null) goto L226;
        r43 = ObricActionBarTrackServiceDelegate.b.r();
    L226:
        ReferenceInfo r44 = r43;
    L228:
        com.larus.bmhome.instruction.g r45 = r47.A().vc();
        if (r45 == null) goto L231;
        int r121 = r45.Q1();
    L232:
        if (r40 == false) goto L234;
        String r122 = "client_language_interception";
    L236:
        if (r47.F().getModifyMode() != MessageModifyMode.MODIFY_TO_REGENERATE) goto L238;
        boolean r123 = true;
    L239:
        Boolean r46 = (Boolean) r47.f.zr();
        if (r46 == null) goto L242;
        boolean r124 = r46.booleanValue();
    L243:
        com.larus.bmhome.chat.component.bottom.reference.a r60 = r47.A().g5();
        if (r60 == null) goto L246;
        String r210 = r60.vS();
    L247:
        boolean r63 = r47.F().getVoiceMixInput();
        com.larus.bmhome.instruction.g r64 = r47.A().vc();
        if (r64 == null) goto L253;
        String r65 = r64.c0();
        if (r65 == null) goto L253;
        String r310 = r65;
    L254:
        ChatPageContext r311 = r47.r(null);
        String r66 = r1;
        String r67 = r39;
        String r410 = r119;
        Object[] r125 = 0 == true ? 1 : 0;
        ICoreInputAbility.OnSendParams r68 = new ICoreInputAbility.OnSendParams(r66, r29, r30, r41, r44, r512, null, r125, r121, r40, r122, r49, r123, r124, r210, r310, 0 == true ? 1 : 0, null, false, r410, r28, r24, r25, null, null, Boolean.valueOf(r63), null, null, null, r311, r33, r34, Long.valueOf(r510), 495386816, 0, null);
        r47.F().setVoiceMixInput(false);
        if (((Boolean) r47.j.invoke(r68)).booleanValue() == false) goto L258;
        r13.i("CoreInputAbility", "[doSendMessage] intercepted by onActionSendClickListener");
        return;
    L258:
        if (r47.G == true) goto L260;
    L261:
        r13.e("CoreInputAbility", "[doSendMessage] onSend function is null, try init");
        r47.Q();
        tx9.c0.A("not_init");
    L262:
        z0 r69 = r47.k;
        if (r69 == null) goto L265;
        r69.invoke(r68, new m(r47));
    L266:
        com.larus.bmhome.instruction.g r70 = r47.A().vc();
        if (r70 == null) goto L269;
        Integer r126 = Integer.valueOf(r70.Q1());
    L271:
        if (od8.h0.c(r126) == true) goto L273;
    L277:
        if (r40 == false) goto L280;
        return;
    L280:
        if (r48.length() <= 0) goto L282;
        boolean r127 = true;
    L283:
        if (r127 == true) goto L285;
        if (r67 != null) goto L285;
    L288:
        com.larus.bmhome.instruction.g r71 = r47.A().vc();
        if (r71 == null) goto L294;
        com.larus.bmhome.chat.model.b0 r72 = r47.A().u5();
        if (r72 == null) goto L293;
        r71.FC(r72);
    L293:
        r71.FP();
        r71.cO();
    L294:
        IChatDoubleTabAbility r0 = r47.A().wh();
        if (r0 == null) goto L300;
        r0.Ui();
        return;
    L300:
        return;
    L285:
        com.larus.bmhome.chat.component.bottom.reference.a r73 = r47.A().g5();
        if (r73 == null) goto L288;
        r73.sZ();
        goto L288
    L282:
        r127 = false;
        goto L283
    L273:
        if (ILegacyChatUiServiceDelegate.b.D8(r47.v()) == false) goto L277;
        com.larus.bmhome.instruction.g r74 = r47.A().vc();
        if (r74 == null) goto L277;
        r74.A1();
        goto L277
    L269:
        r126 = null;
        goto L271
    L265:
        r13.e("CoreInputAbility", "[doSendMessage] onSend function is still null");
        tx9.c0.A("init_failed");
        goto L266
    L260:
        if (r47.k != null) goto L262;
    L253:
        r310 = "";
        goto L254
    L246:
        r210 = null;
        goto L247
    L242:
        r124 = false;
        goto L243
    L238:
        r123 = false;
        goto L239
    L234:
        r122 = "";
        goto L236
    L231:
        r121 = 0;
        goto L232
    L223:
        r43 = null;
        goto L224
    L227:
        r44 = r5;
        goto L228
    L215:
        r38 = null;
        goto L216
    L211:
        r36 = null;
        goto L212
    L207:
        r32 = null;
        goto L208
    L217:
        r41 = null;
        goto L219
    L218:
        r41 = r511;
    L201:
        r30 = r18;
        goto L202
    L196:
        r29 = r47.f.Jn().toString();
        goto L197
    L190:
        if (r49 == false) goto L192;
        String r75 = "voice";
    L193:
        r13.i("CoreInputAbility", "[doSendMessage] append album education ext, sendType=".concat(r75));
        goto L194
    L192:
        r75 = "keyboard";
        goto L193
    L187:
        r28 = r6;
        goto L188
    L174:
        if (r22.b.isEmpty() == false) goto L176;
        Map r76 = r6;
    L180:
        if (r76 == null) goto L183;
        r6 = r76;
        goto L183
    L176:
        if (r6 != null) goto L178;
        Map r77 = MapsKt.emptyMap();
    L179:
        r76 = MapsKt.toMutableMap(r77);
        r76.putAll(r22.b);
        goto L180
    L178:
        r77 = r6;
    L166:
        r27 = null;
    L160:
        r1 = r23;
        goto L161
    L140:
        if (Intrinsics.areEqual(r47.EW(), "inject_input_photo_picker") == false) goto L152;
        if (r24 != null) goto L143;
    L144:
        SkillServiceDelegate r78 = SkillServiceDelegate.a;
        wc9.e r79 = r47.h();
        com.larus.bmhome.instruction.g r80 = r47.A().vc();
        if (r80 == null) goto L150;
        if (r80.yW() != true) goto L150;
        boolean r81 = true;
    L151:
        r22 = r78.h(r79, r81);
    L150:
        r81 = false;
        goto L151
    L143:
        if (r24.getSuggestedActionType() != SuggestedActionType.MessageWithPromptReplacement.getValue()) goto L152;
    L130:
        if (r21 == IAsrDirectFillAbility.DirectFillStatus.FillBackClickSend) goto L135;
        if (r21 == IAsrDirectFillAbility.DirectFillStatus.FillBackEdit) goto L135;
        r25 = "";
    L135:
        r4 = "speak";
    L136:
        r25 = r4;
        goto L138
    L119:
        r21 = null;
        goto L121
    L99:
        r119 = "input_attachment_sug";
        goto L100
    L101:
        if (r114 == null) goto L105;
        r511 = r7;
        r512 = r114;
        if ((!r114.isEmpty()) != true) goto L106;
        boolean r82 = true;
    L107:
        if (r82 == false) goto L109;
        String r83 = "click_action_bar";
    L114:
        r119 = r83;
        goto L116
    L109:
        if (r112 == true) goto L111;
        r119 = "";
        goto L116
    L111:
        if (Intrinsics.areEqual(r116, "auto_cite") == false) goto L113;
        r83 = "choose_text_auto_cite";
        goto L114
    L113:
        r83 = "click_chat";
    L106:
        r82 = false;
        goto L107
    L105:
        r511 = r7;
        r512 = r114;
    L94:
        r118 = null;
        goto L96
    L89:
        r116 = null;
        goto L90
    L85:
        r114 = null;
        goto L86
    L79:
        if (r111.i9() != r16) goto L81;
        r112 = true;
    L75:
        r40 = false;
        goto L76
    L74:
        r510 = r11;
        r16 = true;
        goto L75
    L68:
        r39 = null;
        goto L69
    L62:
        if (r19.isVisible() != true) goto L64;
        r14 = true;
    L58:
        r18 = r3;
        goto L59
    L53:
        r12 = false;
        goto L54
    L49:
        r10 = null;
        goto L51
    L45:
        r2 = r61;
        goto L46
    L41:
        r11 = r59;
        goto L43
    L37:
        r8 = r58;
        goto L39
    L33:
        r34 = r57;
        goto L35
    L29:
        r33 = r56;
        goto L31
    L25:
        r7 = r55;
        goto L27
    L21:
        r6 = r54;
        goto L23
    L17:
        r5 = r53;
        goto L19
    L13:
        r4 = r52;
        goto L15
    L9:
        r24 = r51;
        goto L11
    L5:
        r3 = r50;
        goto L7
    }
}
