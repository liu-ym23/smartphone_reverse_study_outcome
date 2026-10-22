package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.aibeautify.CommonAiBeautifyLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.u1;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.impl.databinding.LarusLayoutCreationBottomBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import tx9.e2;
import tx9.m0;
import tx9.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001KB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\rJ$\u0010%\u001a\u00020\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010&\u001a\u0004\u0018\u00010!J\u001e\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u00132\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u001e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0011J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u000e\u00103\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\rH\u0002J$\u00106\u001a\u00020\u001f2\b\u00107\u001a\u0004\u0018\u0001082\b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u00109\u001a\u00020\u0015H\u0002J\u0012\u0010:\u001a\u00020\u001f2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u0010;\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020\u0015H\u0002J\u0010\u0010=\u001a\u0004\u0018\u00010>H\u0082@¢\u0006\u0002\u00104J\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010AJ\u0006\u0010B\u001a\u00020\rJ\b\u0010C\u001a\u00020\rH\u0002J\u001f\u0010D\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\rH\u0002¢\u0006\u0002\u0010EJ\u0012\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\u0006\u0010J\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/uaigc/creation/gallery/providers/CreationBottomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutCreationBottomBinding;", "tag", "", "creationCallback", "Lcom/larus/uaigc/creation/gallery/ICreateBottomOperation;", "currentContext", "Lcom/larus/uaigc/creation/gallery/bean/CreationBottomViewContext;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "currentIsVideo", "", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "isDownloading", "isShowAiBeauty", "initAiBeautifyListener", "", "aiImageParams", "Lcom/larus/bmhome/chat/bean/AIEditParams;", "onDownloadAction", "onShareAction", "source", "initData", "aiVideoParams", "bindDownloadData", "coroutineScope", "resourceData", "Lcom/larus/bmhome/bigimg/download/DownloadResource;", "updateCurrentCreationButtonStatus", "status", "creationId", "from", "bindData", "initPublishButton", "publishCreation", "getCreateCreationSource", "addCreation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCreationTypeString", "reportPicAddCreation", "message", "Lcom/larus/im/bean/message/Message;", "success", "reportPicClickAddCreation", "getSubType", "isByPublisher", "getPublisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "setCreationPrivacy", "private", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemName", "getCurrentStatus", "refreshButtonStatus", "(Ljava/lang/Integer;Ljava/lang/String;)V", "openPrivacyDialog", "containerView", "Landroid/view/View;", "deleteCreation", "onDestroyView", "ImageShareCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationBottomView extends ConstraintLayout {
    public static final /* synthetic */ int i = 0;
    public final LarusLayoutCreationBottomBinding a;
    public final String b;
    public rz9.d c;
    public sz9.a d;
    public final CoroutineScope e;
    public boolean f;
    public final Lazy g;
    public boolean h;

    public CreationBottomView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationBottomView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getCreateCreationSource() {
        sz9.a r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return 4;
    L10:
        return 1;
    L5:
        if (r0.i != true) goto L7;
        r1 = true;
        goto L7
    }

    private final String getCreationTypeString() {
        sz9.a r0 = this.d;
        if (r0 == null) goto L5;
        Integer r1 = r0.h;
    L6:
        if (r1 != null) goto L9;
    L10:
        if (r1 != null) goto L13;
    L15:
        if (r1 != null) goto L18;
    L20:
        return "replica";
    L18:
        if (r1.intValue() != 4) goto L20;
        return "image_edit";
    L13:
        if (r1.intValue() != 5) goto L15;
    L21:
        return "pic";
    L9:
        if (r1.intValue() == 2) goto L21;
    L5:
        r1 = null;
        goto L6
    }

    private final String getCurrentStatus() {
        CreationGalleryUtil r0 = CreationGalleryUtil.a;
        sz9.a r1 = this.d;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.m);
    L7:
        return CreationGalleryUtil.d(r2);
    L5:
        r2 = null;
        goto L7
    }

    private final l0 getLoadingDialog() {
        return (l0) this.g.getValue();
    }

    private final String getSubType() {
        sz9.a r0 = this.d;
        if (r0 == null) goto L7;
        Integer r1 = r0.h;
        if (r1 == null) goto L7;
        return zp9.y.a(r1.intValue());
    L7:
        return "";
    }

    public final boolean b6() {
        boolean r0 = z2.a.getCreationPublishConfig().b();
        FLogger.a.i(this.b, "isByPublisher enableEnterPublisher:" + r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c6() {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        Integer r3 = null;
        if (this.f == false) goto L8;
        BuildersKt.launch$default(this.e, null, null, new CreationBottomView$onDownloadAction$1(this, null), 3, null);
    L8:
        CreationGalleryUtil r2 = CreationGalleryUtil.a;
        Context r4 = getContext();
        sz9.a r5 = this.d;
        if (r5 == null) goto L11;
        n1 r7 = r5.a;
    L12:
        if (r5 == null) goto L14;
        Uri r8 = r5.b;
    L15:
        if (r5 == null) goto L17;
        Integer r9 = r5.h;
    L18:
        if (r5 == null) goto L20;
        com.larus.bmhome.bigimg.l r10 = r5.q;
    L21:
        if (r5 == null) goto L23;
        String r11 = r5.r;
    L24:
        if (r5 == null) goto L26;
        JSONObject r12 = r5.u;
    L27:
        if (r5 == null) goto L29;
        Boolean r13 = Boolean.valueOf(r5.o);
    L30:
        CoroutineScope r6 = this.e;
        sz9.a r14 = this.d;
        if (r14 == null) goto L33;
        Message r18 = r14.v;
    L34:
        if (r14 == null) goto L36;
        String r16 = r14.p;
    L37:
        if (r14 != null) goto L39;
    L41:
        boolean r22 = false;
    L42:
        if (r14 == null) goto L44;
        r3 = r14.z;
    L44:
        CreationGalleryUtil.c(r4, new sz9.c(r7, r8, r9, r10, r11, r12, r13, null, null, r16, r6, r18, null, null, null, r22, r3, 29056), this, new h(this));
        return;
    L39:
        if (r14.y != true) goto L41;
        r22 = true;
        goto L42
    L36:
        r16 = null;
        goto L37
    L33:
        r18 = null;
        goto L34
    L29:
        r13 = null;
        goto L30
    L26:
        r12 = null;
        goto L27
    L23:
        r11 = null;
        goto L24
    L20:
        r10 = null;
        goto L21
    L17:
        r9 = null;
        goto L18
    L14:
        r8 = null;
        goto L15
    L11:
        r7 = null;
        goto L12
    }

    public final String getItemName() {
        sz9.a r0 = this.d;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.m);
    L7:
        if (r1 != null) goto L10;
    L12:
        if (r1 != null) goto L15;
    L17:
        if (r1 != null) goto L20;
    L22:
        return "";
    L20:
        if (r1.intValue() != 3) goto L22;
        return "already_public";
    L15:
        if (r1.intValue() != 2) goto L17;
        return "go_public";
    L10:
        if (r1.intValue() != 1) goto L12;
        return "go_public";
    L5:
        r1 = null;
        goto L7
    }

    public static final /* synthetic */ String S5(CreationBottomView r0) {
        return r0.getCreationTypeString();
    }

    public static final /* synthetic */ String T5(CreationBottomView r0) {
        return r0.getCurrentStatus();
    }

    public static final /* synthetic */ String U5(CreationBottomView r0) {
        return r0.getSubType();
    }

    public final void Y5(sz9.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d = r4;
        this.h = false;
        nr9.g r1 = r4.s;
        if (r1 == null) goto L7;
        this.f = true;
        CoroutineScope r0 = this.e;
        com.larus.bmhome.bigimg.download.d.c r2 = new com.larus.bmhome.bigimg.download.d.c(r1);
        this.a.d.S5(r0, r2);
    L8:
        n6(r4.m, r4.p, "bindData");
        m0.c(getItemName(), getCurrentStatus(), "picture_detail", "chat_list");
        return;
    L7:
        this.f = false;
        CoroutineScope r3 = this.e;
        com.larus.bmhome.bigimg.download.d.a r5 = new com.larus.bmhome.bigimg.download.d.a(String.valueOf(r4.b));
        this.a.d.S5(r3, r5);
        goto L8
    }

    public final Object Z5(Continuation<? super PublisherCreation> r42) {
        if ((r42 instanceof CreationBottomView$getPublisherCreation$1) == false) goto L7;
        CreationBottomView$getPublisherCreation$1 r2 = (CreationBottomView$getPublisherCreation$1) r42;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        Long r7 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L27:
        UserCreationFromIM r8 = (UserCreationFromIM) r1;
        if (r8 == null) goto L30;
        PublisherCreation r9 = zp9.x.a(r8);
    L31:
        if (r9 != null) goto L37;
        sz9.a r10 = this.d;
        if (r10 == null) goto L35;
        String r11 = r10.p;
    L36:
        r9 = new PublisherCreation(r11, null, null, null, null, null, null, null, null, false, null, null, null, null, 16382, null);
        goto L37
    L35:
        r11 = null;
    L37:
        PublisherCreation r24 = r9;
        Integer r12 = r24.getCreationType();
        FLogger.a.i(this.b, "originCreationType:" + r12 + ' ');
        if (this.f == false) goto L46;
        sz9.a r13 = this.d;
        if (r13 == null) goto L52;
        nr9.g r14 = r13.s;
        if (r14 == null) goto L52;
        nr9.f r15 = r14.g;
        if (r15 == null) goto L52;
        String r16 = r15.b;
    L51:
        String r30 = r16;
    L53:
        sz9.a r17 = this.d;
        if (r17 == null) goto L58;
        Message r18 = r17.v;
        if (r18 == null) goto L58;
        String r28 = r18.getMessageId();
    L59:
        sz9.a r19 = this.d;
        if (r19 == null) goto L64;
        String r20 = r19.g;
        if (r20 == null) goto L64;
        Integer r32 = StringsKt.toIntOrNull(r20);
    L65:
        if (r12 != null) goto L70;
        sz9.a r21 = this.d;
        if (r21 == null) goto L69;
        r12 = r21.h;
        goto L70
    L69:
        Integer r26 = null;
    L71:
        sz9.a r22 = this.d;
        if (r22 == null) goto L74;
        Integer r27 = r22.n;
    L75:
        String r23 = r24.getTaskId();
        if (r23 != null) goto L79;
        r23 = "";
    L79:
        if (r23.length() == 0) goto L82;
        r6 = false;
    L82:
        if (r6 == false) goto L87;
        sz9.a r25 = this.d;
        if (r25 == null) goto L86;
        r23 = r25.f;
        goto L87
    L86:
        r23 = null;
    L87:
        String r33 = r23;
        sz9.a r29 = this.d;
        if (r29 == null) goto L92;
        String r31 = r29.w;
        if (r31 == null) goto L92;
        Long r36 = StringsKt.toLongOrNull(r31);
    L93:
        sz9.a r34 = this.d;
        if (r34 == null) goto L99;
        String r35 = r34.x;
        if (r35 == null) goto L99;
        r7 = StringsKt.toLongOrNull(r35);
    L99:
        return PublisherCreation.copy$default(r24, null, r26, r27, r28, null, r30, null, r32, r33, false, null, r36, r7, null, 9809, null);
    L92:
        r36 = null;
        goto L93
    L74:
        r27 = null;
    L70:
        r26 = r12;
    L64:
        r32 = null;
    L58:
        r28 = null;
    L52:
        r30 = null;
        goto L53
    L46:
        sz9.a r37 = this.d;
        if (r37 == null) goto L52;
        Uri r38 = r37.d;
        if (r38 == null) goto L52;
        r16 = r38.toString();
        goto L51
    L30:
        r9 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        CreationGalleryUtil r39 = CreationGalleryUtil.a;
        sz9.a r40 = this.d;
        if (r40 == null) goto L19;
        Message r41 = r40.v;
        if (r41 == null) goto L19;
        String r43 = r41.getMessageId();
    L20:
        sz9.a r44 = this.d;
        if (r44 == null) goto L23;
        String r45 = r44.e;
    L24:
        r2.label = 1;
        r1 = r39.e(r43, r45, r2);
        if (r1 != r4) goto L27;
        return r4;
    L23:
        r45 = null;
    L19:
        r43 = null;
    L7:
        r2 = new CreationBottomView$getPublisherCreation$1(this, r42);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i6(String r81) {
        Intrinsics.checkNotNullParameter(r81, "source");
        Integer r4 = null;
        if (this.f == false) goto L80;
        sz9.a r1 = this.d;
        if (r1 == null) goto L9;
        c4 r2 = r1.t;
        if (r2 == null) goto L9;
        wc9.e r6 = r2.e;
    L10:
        if (r1 == null) goto L14;
        c4 r3 = r1.t;
        if (r3 == null) goto L14;
        BotModel r7 = r3.d;
    L15:
        if (r1 == null) goto L19;
        c4 r5 = r1.t;
        if (r5 == null) goto L19;
        String r8 = r5.c;
    L20:
        LruCache r9 = ko8.a.a;
        String r10 = ko8.a.e(ko8.a.e);
        sz9.a r11 = this.d;
        if (r11 == null) goto L25;
        c4 r12 = r11.t;
        if (r12 == null) goto L25;
        String r13 = r12.a;
    L26:
        if (r11 == null) goto L30;
        c4 r14 = r11.t;
        if (r14 == null) goto L30;
        String r15 = r14.b;
    L31:
        if (r11 == null) goto L35;
        c4 r16 = r11.t;
        if (r16 == null) goto L35;
        String r36 = r16.j;
    L36:
        if (r11 == null) goto L40;
        c4 r17 = r11.t;
        if (r17 == null) goto L40;
        String r34 = r17.h;
    L41:
        if (r11 == null) goto L45;
        c4 r18 = r11.t;
        if (r18 == null) goto L45;
        Boolean r37 = r18.k;
    L46:
        if (r11 == null) goto L50;
        c4 r19 = r11.t;
        if (r19 == null) goto L50;
        Integer r35 = r19.i;
    L51:
        if (r11 == null) goto L55;
        c4 r20 = r11.t;
        if (r20 == null) goto L55;
        Message r44 = r20.l;
    L56:
        if (r11 == null) goto L58;
        String r47 = r11.p;
    L59:
        com.larus.bmhome.share.panel.h r21 = new com.larus.bmhome.share.panel.h(r6, r7, r8, "video_detail", r10, r13, r15, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r34, r35, r36, r37, null, null, null, null, null, null, r44, null, null, r47, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741572, -4356, 1023);
        CreationGalleryUtil r22 = CreationGalleryUtil.a;
        sz9.a r23 = this.d;
        if (r23 == null) goto L62;
        nr9.g r24 = r23.s;
    L63:
        if (r23 == null) goto L65;
        String r25 = r23.e;
    L66:
        CoroutineScope r26 = this.e;
        if (r23 == null) goto L69;
        Message r27 = r23.v;
    L70:
        if (r23 == null) goto L72;
        c4 r28 = r23.t;
    L73:
        if (r23 == null) goto L75;
        String r29 = r23.p;
    L76:
        if (r23 == null) goto L78;
        r4 = r23.z;
    L78:
        CreationGalleryUtil.i(new sz9.c(null, null, null, null, null, null, null, r24, r25, r29, r26, r27, r21, r28, null, false, r4, 49279), this, getLoadingDialog());
        return;
    L75:
        r29 = null;
        goto L76
    L72:
        r28 = null;
        goto L73
    L69:
        r27 = null;
        goto L70
    L65:
        r25 = null;
        goto L66
    L62:
        r24 = null;
        goto L63
    L58:
        r47 = null;
    L55:
        r44 = null;
    L50:
        r35 = null;
    L45:
        r37 = null;
    L40:
        r34 = null;
    L35:
        r36 = null;
    L30:
        r15 = null;
    L25:
        r13 = null;
    L19:
        r8 = null;
    L14:
        r7 = null;
    L9:
        r6 = null;
        goto L10
    L80:
        CreationGalleryUtil r30 = CreationGalleryUtil.a;
        Context r31 = getContext();
        sz9.a r32 = this.d;
        if (r32 == null) goto L83;
        n1 r110 = r32.a;
    L84:
        if (r32 == null) goto L86;
        Uri r111 = r32.b;
    L87:
        if (r32 == null) goto L89;
        Integer r112 = r32.h;
    L90:
        if (r32 == null) goto L92;
        com.larus.bmhome.bigimg.l r113 = r32.q;
    L93:
        if (r32 == null) goto L95;
        String r114 = r32.r;
    L96:
        if (r32 == null) goto L98;
        JSONObject r115 = r32.u;
    L99:
        if (r32 == null) goto L101;
        Boolean r116 = Boolean.valueOf(r32.o);
    L102:
        sz9.a r33 = this.d;
        if (r33 == null) goto L105;
        String r117 = r33.e;
    L106:
        CoroutineScope r38 = this.e;
        if (r33 == null) goto L109;
        Message r210 = r33.v;
    L110:
        if (r33 == null) goto L112;
        String r118 = r33.p;
    L113:
        int r39 = 0;
        if (r33 != null) goto L116;
    L118:
        boolean r211 = false;
    L119:
        if (r33 == null) goto L121;
        Integer r212 = r33.z;
    L122:
        sz9.c r40 = new sz9.c(r110, r111, r112, r113, r114, r115, r116, null, r117, r118, r38, r210, null, null, null, r211, r212, 28672);
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r40, "params");
        Intrinsics.checkNotNullParameter(this, "rootView");
        Intrinsics.checkNotNullParameter(r81, "source");
        if (Intrinsics.areEqual(r40.g, Boolean.TRUE) == false) goto L128;
        t19.s r41 = t19.s.a;
        String r42 = r31.getString(2131909395);
        if (r42 != null) goto L127;
        r42 = "";
    L127:
        r41.getClass();
        t19.s.t(r31, r42);
        return;
    L128:
        ShareServiceDelegate r43 = ShareServiceDelegate.b;
        JSONObject r45 = r40.f;
        if (r45 == null) goto L144;
        r45.put("click_method", r81);
        Integer r46 = r40.c;
        if (r46 != null) goto L134;
    L136:
        int r48 = 0;
    L137:
        r45.put("is_replica_gen", r48);
        Integer r49 = r40.c;
        if (r49 != null) goto L141;
    L143:
        r45.put("is_image_edit", r39);
        r45.put("share_content", "picture");
    L145:
        r43.w(r45);
        if (CreationGalleryUtil.j(r40.c) == false) goto L150;
        CoroutineScope r50 = r40.k;
        if (r50 == null) goto L156;
        BuildersKt.launch$default(r50, null, null, new CreationGalleryUtil$showCreationShare$1(this, r40, "share", null), 3, null);
        return;
    L156:
        return;
    L150:
        Uri r51 = r40.b;
        if (r51 == null) goto L158;
        CreationGalleryUtil.h(r51.toString(), true, r40, r31, "doShare", null);
        return;
    L158:
        return;
    L141:
        if (r49.intValue() != 4) goto L143;
        r39 = 1;
        goto L143
    L134:
        if (r46.intValue() != 3) goto L136;
        r48 = 1;
        goto L137
    L144:
        r45 = null;
        goto L145
    L121:
        r212 = null;
        goto L122
    L116:
        if (r33.y != true) goto L118;
        r211 = true;
        goto L119
    L112:
        r118 = null;
        goto L113
    L109:
        r210 = null;
        goto L110
    L105:
        r117 = null;
        goto L106
    L101:
        r116 = null;
        goto L102
    L98:
        r115 = null;
        goto L99
    L95:
        r114 = null;
        goto L96
    L92:
        r113 = null;
        goto L93
    L89:
        r112 = null;
        goto L90
    L86:
        r111 = null;
        goto L87
    L83:
        r110 = null;
        goto L84
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object R5(CreationBottomView r44, Continuation r45) {
        r44.getClass();
        if ((r45 instanceof CreationBottomView$addCreation$1) == false) goto L7;
        CreationBottomView$addCreation$1 r2 = (CreationBottomView$addCreation$1) r45;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        Continuation r14 = null;
        String r7 = "recommend_from";
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        int r5 = r2.I$0;
        zp9.a r6 = (zp9.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Continuation r24 = "";
        r7 = "recommend_from";
        String r22 = "template_rec_req_id";
        r14 = r14;
        boolean r15 = true;
    L106:
        sz9.a r8 = r44.d;
        if (r8 == null) goto L109;
        Continuation r9 = r8.v;
    L110:
        Continuation r10 = r24;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicAddCreation$1(r9, false, r10, r14), 3, null);
        zp9.a r11 = r6;
    L153:
        if (r11 != null) goto L155;
    L157:
        boolean r13 = false;
    L158:
        if (r13 == false) goto L164;
        if (r11 == null) goto L163;
        UserCreation r16 = r11.b;
        if (r16 == null) goto L163;
        Continuation r26 = r16.a;
    L165:
        sz9.a r17 = r44.d;
        if (r17 == null) goto L168;
        Continuation r27 = r17.f;
    L169:
        if (r17 == null) goto L173;
        Message r18 = r17.v;
        if (r18 == null) goto L173;
        Continuation r28 = r18.getMessageId();
    L174:
        String r29 = r44.getCreationTypeString();
        if (r5 != 2) goto L177;
        String r19 = "0";
    L178:
        String r31 = r19;
        sz9.a r20 = r44.d;
        if (r20 == null) goto L183;
        JSONObject r21 = r20.u;
        if (r21 == null) goto L183;
        Object r23 = r21.opt(r7);
    L184:
        String r32 = String.valueOf(r23);
        sz9.a r25 = r44.d;
        if (r25 == null) goto L189;
        JSONObject r30 = r25.u;
        if (r30 == null) goto L189;
        Object r33 = r30.opt("from_template_id");
    L190:
        String r34 = String.valueOf(r33);
        sz9.a r35 = r44.d;
        if (r35 == null) goto L195;
        JSONObject r36 = r35.u;
        if (r36 == null) goto L195;
        Object r37 = r36.opt("template_rec_extra");
    L196:
        String r38 = String.valueOf(r37);
        sz9.a r0 = r44.d;
        if (r0 == null) goto L201;
        JSONObject r39 = r0.u;
        if (r39 == null) goto L201;
        Object r40 = r39.opt(r22);
    L202:
        e2.a.b(new o0("picture_detail", "chat", r26, r27, r28, r29, "-1", r31, r32, r34, String.valueOf(r40), r38, null, null, null, null, null, null, 516097), r14, 3);
        return Unit.INSTANCE;
    L201:
        r40 = r14;
    L195:
        r37 = r14;
    L189:
        r33 = r14;
    L183:
        r23 = r14;
        goto L184
    L177:
        r19 = "1";
    L173:
        r28 = r14;
        goto L174
    L168:
        r27 = r14;
    L163:
        r26 = r14;
        goto L165
    L164:
        r26 = r10;
        goto L165
    L155:
        if (r11.a != r15) goto L157;
        r13 = true;
        goto L158
    L109:
        r9 = r14;
        goto L110
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r41 = r2.I$1;
        int r42 = r2.I$0;
        ResultKt.throwOnFailure(r1);
        r24 = "";
        r22 = "template_rec_req_id";
        r15 = true;
        int r43 = r41;
        r5 = r42;
    L95:
        r11 = (zp9.a) r1;
        if (r11 != null) goto L98;
    L100:
        boolean r110 = false;
    L101:
        if (r110 == true) goto L111;
        MainCoroutineDispatcher r46 = Dispatchers.getMain();
        CreationBottomView$addCreation$3 r47 = new CreationBottomView$addCreation$3(r44, r11, r14);
        r2.L$0 = r11;
        r2.I$0 = r5;
        r2.label = 4;
        if (BuildersKt.withContext(r46, r47, r2) == r12) goto L208;
        r6 = r11;
        goto L106
    L208:
        return r12;
    L111:
        r10 = r24;
        sz9.a r48 = r44.d;
        if (r48 == null) goto L114;
        Message r49 = r48.v;
    L115:
        if (r11 == null) goto L119;
        UserCreation r50 = r11.b;
        if (r50 == null) goto L119;
        String r51 = r50.a;
    L120:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicAddCreation$1(r49, r15, r51, r14), 3, null);
        t19.s r52 = t19.s.a;
        Context r53 = r44.getContext();
        Context r54 = r44.getContext();
        if (r54 == null) goto L126;
        Resources r55 = r54.getResources();
        if (r55 == null) goto L126;
        Continuation r56 = r55.getString(2131900634);
        if (r56 == null) goto L126;
    L127:
        r52.getClass();
        t19.s.p(r53, r56);
        sz9.a r57 = r44.d;
        if (r57 == null) goto L130;
        r57.c = r43;
    L130:
        if (r57 == null) goto L138;
        if (r11 == null) goto L136;
        UserCreation r58 = r11.b;
        if (r58 == null) goto L136;
        Continuation r59 = r58.a;
        if (r59 == null) goto L136;
    L137:
        Intrinsics.checkNotNullParameter(r59, "<set-?>");
        r57.p = r59;
    L136:
        r59 = r10;
    L138:
        rz9.d r60 = r44.c;
        if (r60 == null) goto L153;
        sz9.a r61 = r44.d;
        if (r61 == null) goto L143;
        Continuation r62 = r61.e;
    L144:
        if (r62 != null) goto L146;
        r62 = r10;
    L146:
        if (r11 == null) goto L151;
        UserCreation r63 = r11.b;
        if (r63 == null) goto L151;
        Continuation r64 = r63.a;
        if (r64 == null) goto L151;
    L152:
        r60.b(r62, r64, r5);
    L151:
        r64 = r10;
        goto L152
    L143:
        r62 = r14;
    L126:
        r56 = r10;
    L119:
        r51 = r14;
        goto L120
    L114:
        r49 = r14;
        goto L115
    L98:
        if (r11.a != r15) goto L100;
        r110 = true;
        goto L101
    L18:
        int r65 = r2.I$1;
        int r66 = r2.I$0;
        PublisherCreation r67 = (PublisherCreation) r2.L$0;
        ResultKt.throwOnFailure(r1);
        int r68 = r65;
        PublisherCreation r69 = r67;
        int r70 = r66;
    L46:
        sz9.a r71 = r44.d;
        if (r71 == null) goto L49;
        Continuation r72 = r71.v;
    L50:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicClickAddCreation$1(r72, r44, r14), 3, null);
        e0 r73 = e0.a;
        sz9.a r111 = r44.d;
        if (r111 == null) goto L56;
        Message r112 = r111.v;
        if (r112 == null) goto L56;
        String r113 = r112.getMessageId();
        if (r113 == null) goto L56;
    L57:
        sz9.a r114 = r44.d;
        if (r114 == null) goto L65;
        Integer r115 = r114.h;
        if (r115 == null) goto L65;
        if (r115.intValue() != 3) goto L65;
        boolean r116 = true;
    L66:
        if (r116 == false) goto L68;
        int r117 = 3;
    L80:
        sz9.a r118 = r44.d;
        if (r118 == null) goto L83;
        Continuation r119 = r118.g;
    L84:
        if (r118 == null) goto L86;
        Continuation r120 = r118.f;
    L87:
        int r121 = r44.getCreateCreationSource();
        if (r69 == null) goto L90;
        Continuation r210 = r69.getMaterialId();
    L91:
        r2.L$0 = r14;
        r2.I$0 = r70;
        r2.I$1 = r68;
        r2.label = 3;
        int r211 = r70;
        r22 = "template_rec_req_id";
        r15 = true;
        r24 = "";
        Object r74 = r73.l(r113, r117, r119, r211, r120, r121, r210, r2);
        if (r74 == r12) goto L207;
        r43 = r68;
        r1 = r74;
        r5 = r211;
        goto L95
    L207:
        return r12;
    L90:
        r210 = r14;
        goto L91
    L86:
        r120 = r14;
        goto L87
    L83:
        r119 = r14;
        goto L84
    L68:
        sz9.a r122 = r44.d;
        if (r122 == null) goto L76;
        Integer r123 = r122.h;
        if (r123 == null) goto L76;
        if (r123.intValue() != 4) goto L76;
        boolean r124 = true;
    L77:
        if (r124 == false) goto L79;
        r117 = 4;
        goto L80
    L79:
        r117 = 2;
    L76:
        r124 = false;
    L65:
        r116 = false;
    L56:
        r113 = "";
        goto L57
    L49:
        r72 = r14;
        goto L50
    L19:
        ResultKt.throwOnFailure(r1);
    L23:
        PublisherCreation r75 = (PublisherCreation) r1;
        if (r44.b6() == false) goto L42;
        new u1();
        sz9.a r76 = r44.d;
        if (r76 == null) goto L30;
        JSONObject r77 = r76.u;
        if (r77 == null) goto L30;
        Object r78 = r77.opt("recommend_from");
    L31:
        String r79 = String.valueOf(r78);
        sz9.a r80 = r44.d;
        if (r80 == null) goto L36;
        JSONObject r81 = r80.u;
        if (r81 == null) goto L36;
        Object r82 = r81.opt("template_rec_req_id");
    L37:
        u1.a(r75, new PublisherTrackParams("picture_detail", r79, String.valueOf(r82)));
        FLogger.a.i(r44.b, "addCreation gotoPublisher");
        sz9.a r83 = r44.d;
        if (r83 == null) goto L40;
        Continuation r84 = r83.v;
    L41:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicClickAddCreation$1(r84, r44, r14), 3, null);
        return Unit.INSTANCE;
    L40:
        r84 = r14;
    L36:
        r82 = r14;
    L30:
        r78 = r14;
        goto L31
    L42:
        MainCoroutineDispatcher r85 = Dispatchers.getMain();
        CreationBottomView$addCreation$2 r86 = new CreationBottomView$addCreation$2(r44, 3, r14);
        r2.L$0 = r75;
        r2.I$0 = 1;
        r2.I$1 = 3;
        r2.label = 2;
        if (BuildersKt.withContext(r85, r86, r2) == r12) goto L206;
        r69 = r75;
        r68 = 3;
        r70 = 1;
        goto L46
    L206:
        return r12;
    L20:
        ResultKt.throwOnFailure(r1);
        r2.label = 1;
        r1 = r44.Z5(r2);
        if (r1 != r12) goto L23;
        return r12;
    L7:
        r2 = new CreationBottomView$addCreation$1(r44, r45);
        goto L8
    }

    public final void k6(Integer r6, String r7) {
        FLogger r0 = FLogger.a;
        r0.i(this.b, "refreshButtonStatus " + r6 + " from:" + r7);
        if (r6 == null) goto L24;
        r6.intValue();
        int r1 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L7;
    L16:
        boolean r2 = false;
    L17:
        r0.i(this.b, "refreshButtonStatus enable " + r2);
        CreationOperateContainerView r8 = this.a.c;
        if (r2 == false) goto L20;
        r1 = r6.intValue();
    L20:
        r8.r1(r1);
        sz9.a r9 = this.d;
        if (r9 == null) goto L25;
        r9.m = r6.intValue();
        return;
    L25:
        return;
    L7:
        if (AccountService.a.isLogin().booleanValue() == false) goto L16;
        sz9.a r10 = this.d;
        r2 = true;
        if (r10 != null) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == false) goto L16;
    L11:
        if (r10.l == true) goto L13;
        r11 = true;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationBottomView(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131562790, this);
        int r6 = 2131362380;
        CommonAiBeautifyLayout r7 = ViewBindings.findChildViewById(this, 2131362380);
        if (r7 == null) goto L15;
        r6 = 2131368277;
        CreationOperateContainerView r0 = ViewBindings.findChildViewById(this, 2131368277);
        if (r0 == null) goto L15;
        r6 = 2131370179;
        CommonDownLoadLayout r1 = ViewBindings.findChildViewById(this, 2131370179);
        if (r1 == null) goto L15;
        this.a = new LarusLayoutCreationBottomBinding(this, r7, r0, r1);
        this.b = "CreationBottomView";
        this.e = CoroutineScopeKt.MainScope();
        this.g = LazyKt.lazy(new d(r3));
        e1.d(r1, new e(this));
        r0.setByPublisher(b6());
        final View r8 = r0.findViewById(2131383028);
        View r9 = r0.findViewById(2131383424);
        if (r8 == null) goto L11;
        e1.d(r8, new f(this, r8));
    L11:
        if (r9 == null) goto L16;
        e1.d(r9, new g(this));
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object V5(CreationBottomView r36, boolean r37, Continuation r38) {
        r36.getClass();
        if ((r38 instanceof CreationBottomView$setCreationPrivacy$1) == false) goto L7;
        CreationBottomView$setCreationPrivacy$1 r3 = (CreationBottomView$setCreationPrivacy$1) r38;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        String r7 = null;
        String r13 = "";
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        ResultKt.throwOnFailure(r2);
    L159:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r1 = r3.I$2;
        int r8 = r3.I$1;
        int r9 = r3.I$0;
        ResultKt.throwOnFailure(r2);
    L109:
        Pair r10 = (Pair) r2;
        if (r10 == null) goto L112;
        Boolean r11 = (Boolean) r10.getFirst();
    L114:
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L118;
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        CreationBottomView$setCreationPrivacy$3 r14 = new CreationBottomView$setCreationPrivacy$3(r36, r9, null);
        r3.label = 4;
        if (BuildersKt.withContext(r12, r14, r3) != r5) goto L159;
        return r5;
    L118:
        if (r8 != 2) goto L124;
        Context r15 = r36.getContext();
        if (r15 == null) goto L129;
        Resources r16 = r15.getResources();
        if (r16 == null) goto L129;
        String r17 = r16.getString(2131900633);
    L130:
        t19.s r18 = t19.s.a;
        Context r19 = r36.getContext();
        if (r17 != null) goto L133;
        r17 = "";
    L133:
        r18.getClass();
        t19.s.p(r19, r17);
        if (r8 != 2) goto L142;
        e0 r20 = e0.a;
        sz9.a r21 = r36.d;
        if (r21 == null) goto L138;
        String r22 = r21.p;
    L139:
        if (r22 != null) goto L141;
        r22 = "";
    L141:
        r20.X0(r22);
        goto L142
    L138:
        r22 = null;
    L142:
        sz9.a r23 = r36.d;
        if (r23 == null) goto L145;
        r23.c = r1;
    L145:
        rz9.d r0 = r36.c;
        if (r0 == null) goto L159;
        if (r23 == null) goto L149;
        String r24 = r23.p;
    L150:
        if (r24 != null) goto L152;
        r24 = "";
    L152:
        if (r23 == null) goto L154;
        r7 = r23.e;
    L154:
        if (r7 == null) goto L157;
        r13 = r7;
    L157:
        r0.a(r24, r13, r8);
        goto L159
    L149:
        r24 = null;
    L129:
        r17 = null;
        goto L130
    L124:
        Context r25 = r36.getContext();
        if (r25 == null) goto L129;
        Resources r26 = r25.getResources();
        if (r26 == null) goto L129;
        r17 = r26.getString(2131900634);
        goto L130
    L112:
        r11 = null;
        goto L114
    L18:
        r1 = r3.I$2;
        r8 = r3.I$1;
        int r110 = r3.I$0;
        boolean r111 = r3.Z$0;
        ResultKt.throwOnFailure(r2);
    L57:
        sz9.a r27 = r36.d;
        if (r27 == null) goto L60;
        String r112 = r27.p;
    L61:
        if (r27 == null) goto L63;
        String r28 = r27.f;
    L64:
        if (r27 == null) goto L68;
        Message r29 = r27.v;
        if (r29 == null) goto L68;
        String r210 = r29.getMessageId();
    L69:
        String r211 = r36.getCreationTypeString();
        if (r111 == false) goto L72;
        String r212 = "1";
    L73:
        if (r111 == false) goto L75;
        String r213 = "0";
    L76:
        sz9.a r30 = r36.d;
        if (r30 == null) goto L81;
        JSONObject r31 = r30.u;
        if (r31 == null) goto L81;
        Object r32 = r31.opt("recommend_from");
    L82:
        String r214 = String.valueOf(r32);
        sz9.a r33 = r36.d;
        if (r33 == null) goto L87;
        JSONObject r34 = r33.u;
        if (r34 == null) goto L87;
        Object r35 = r34.opt("from_template_id");
    L88:
        String r215 = String.valueOf(r35);
        sz9.a r39 = r36.d;
        if (r39 == null) goto L93;
        JSONObject r40 = r39.u;
        if (r40 == null) goto L93;
        Object r41 = r40.opt("template_rec_extra");
    L94:
        String r216 = String.valueOf(r41);
        sz9.a r42 = r36.d;
        if (r42 == null) goto L99;
        JSONObject r43 = r42.u;
        if (r43 == null) goto L99;
        Object r44 = r43.opt("template_rec_req_id");
    L100:
        e2.a.b(new o0("picture_detail", "chat", r112, r28, r210, r211, r212, r213, r214, r215, String.valueOf(r44), r216, null, null, null, null, null, null, 516097), null, 3);
        e0 r45 = e0.a;
        sz9.a r46 = r36.d;
        if (r46 == null) goto L104;
        String r47 = r46.p;
        if (r47 == null) goto L104;
    L105:
        r3.I$0 = r110;
        r3.I$1 = r8;
        r3.I$2 = r1;
        r3.label = 3;
        r2 = r45.h(r47, r8, r3);
        if (r2 == r5) goto L163;
        r9 = r110;
        goto L109
    L163:
        return r5;
    L104:
        r47 = "";
    L99:
        r44 = null;
    L93:
        r41 = null;
    L87:
        r35 = null;
    L81:
        r32 = null;
        goto L82
    L75:
        r213 = "1";
        goto L76
    L72:
        r212 = "0";
    L68:
        r210 = null;
        goto L69
    L63:
        r28 = null;
        goto L64
    L60:
        r112 = null;
        goto L61
    L19:
        u1 r48 = (u1) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L27:
        PublisherCreation r49 = (PublisherCreation) r2;
        sz9.a r50 = r36.d;
        if (r50 == null) goto L32;
        JSONObject r51 = r50.u;
        if (r51 == null) goto L32;
        Object r52 = r51.opt("recommend_from");
    L33:
        String r53 = String.valueOf(r52);
        sz9.a r54 = r36.d;
        if (r54 == null) goto L38;
        JSONObject r55 = r54.u;
        if (r55 == null) goto L38;
        Object r56 = r55.opt("template_rec_req_id");
    L39:
        PublisherTrackParams r57 = new PublisherTrackParams("picture_detail", r53, String.valueOf(r56));
        r48.getClass();
        u1.a(r49, r57);
        FLogger.a.i(r36.b, "setCreationPrivacy gotoPublisher");
        sz9.a r58 = r36.d;
        if (r58 == null) goto L42;
        Message r59 = r58.v;
    L43:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicClickAddCreation$1(r59, r36, null), 3, null);
        return Unit.INSTANCE;
    L42:
        r59 = null;
    L38:
        r56 = null;
    L32:
        r52 = null;
        goto L33
    L20:
        ResultKt.throwOnFailure(r2);
        if (r37 == false) goto L23;
    L44:
        if (r37 == false) goto L46;
        int r60 = 3;
    L47:
        if (r37 == false) goto L49;
        r8 = 2;
    L50:
        if (r37 == false) goto L52;
        int r113 = 2;
    L53:
        MainCoroutineDispatcher r114 = Dispatchers.getMain();
        CreationBottomView$setCreationPrivacy$2 r61 = new CreationBottomView$setCreationPrivacy$2(r36, r113, null);
        r3.Z$0 = r37;
        r3.I$0 = r60;
        r3.I$1 = r8;
        r3.I$2 = r113;
        r3.label = 2;
        if (BuildersKt.withContext(r114, r61, r3) == r5) goto L162;
        r111 = r37;
        r1 = r113;
        r110 = r60;
        goto L57
    L162:
        return r5;
    L52:
        r113 = 3;
        goto L53
    L49:
        r8 = 1;
        goto L50
    L46:
        r60 = 2;
        goto L47
    L23:
        if (r36.b6() == false) goto L44;
        r48 = new u1();
        r3.L$0 = r48;
        r3.label = 1;
        r2 = r36.Z5(r3);
        if (r2 != r5) goto L27;
        return r5;
    L7:
        r3 = new CreationBottomView$setCreationPrivacy$1(r36, r38);
        goto L8
    }

    public final void n6(int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "creationId");
        Intrinsics.checkNotNullParameter(r7, "from");
        FLogger.a.i(this.b, "updateCurrentCreationButtonStatus status=" + r5 + ", creationId=" + r6 + ", from=" + r7);
        sz9.a r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        e1.o(this.a.c);
        return;
    L11:
        IFlowCreationThemeConfigProvider r2 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        Integer r3 = null;
        if (r2 == null) goto L14;
        Boolean r4 = Boolean.valueOf(r2.a(this.a.c, AdaptThemeFeatureKey.CREATION_GO_PUBLISH));
    L16:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L29;
        e1.x(this.a.c);
        sz9.a r8 = this.d;
        if (r8 == null) goto L20;
        r8.m = r5;
    L20:
        if (r8 == null) goto L22;
        r8.c = r5;
    L22:
        if (r8 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r8.p = r6;
    L24:
        sz9.a r9 = this.d;
        if (r9 == null) goto L27;
        r3 = Integer.valueOf(r9.m);
    L27:
        k6(r3, r7);
        return;
    L29:
        return;
    L14:
        r4 = null;
        goto L16
    L5:
        if (r0.j == true) goto L7;
        r1 = true;
        goto L8
    }

    public /* synthetic */ CreationBottomView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
