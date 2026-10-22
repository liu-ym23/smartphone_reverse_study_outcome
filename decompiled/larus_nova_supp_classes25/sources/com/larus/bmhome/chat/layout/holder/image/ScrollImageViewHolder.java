package com.larus.bmhome.chat.layout.holder.image;

import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.bmhome.chat.layout.holder.progressloading.SketchLoadingController;
import com.larus.bmhome.databinding.LarusImageScrollItemBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationShareService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001$\u0018\u0000 E2\u00020\u0001:\u0001EB\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012 \u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000e\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\nJ\u0016\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001fJ\u0010\u00106\u001a\u0002002\u0006\u00101\u001a\u00020\u001cH\u0002J\u0012\u00107\u001a\u0002002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u00108\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020=H\u0082@¢\u0006\u0002\u0010>J4\u0010?\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\u00112\u0006\u0010@\u001a\u00020A2\u0006\u00101\u001a\u00020\u001c2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH\u0082@¢\u0006\u0002\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)¨\u0006F"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusImageScrollItemBinding;", "loadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/SketchLoadingController;", "loadImageAction", "Lcom/larus/bmhome/chat/layout/holder/image/ILoadImageAction;", "isReloadGetter", "Lkotlin/Function0;", "", "progressGetter", "Lcom/larus/bmhome/chat/layout/holder/image/IProgressGetter;", "eventParamsGetter", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "", "", "coroutineScopeGetter", "Lkotlinx/coroutines/CoroutineScope;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "<init>", "(Lcom/larus/bmhome/databinding/LarusImageScrollItemBinding;Lcom/larus/bmhome/chat/layout/holder/progressloading/SketchLoadingController;Lcom/larus/bmhome/chat/layout/holder/image/ILoadImageAction;Lkotlin/jvm/functions/Function0;Lcom/larus/bmhome/chat/layout/holder/image/IProgressGetter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/api/MessageAdapter;)V", "imageData", "Lcom/larus/bmhome/chat/layout/holder/image/ImageItemDataWithTemplate;", "message", "imageIndex", "", "Ljava/lang/Integer;", "isSharing", "isLongPicShare", "imageLoadResultListener", "com/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder$imageLoadResultListener$1", "Lcom/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder$imageLoadResultListener$1;", "loadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "getLoadingProgressComponent", "()Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "loadingProgressComponent$delegate", "Lkotlin/Lazy;", "buildCreatePageChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "openNewChatPage", "bindData", "", "data", "position", "refreshSize", "width", "height", "initShareDownloadClickAction", "refreshShareOrDownloadBtn", "doSaveImage", "imageUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doShareImage", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "commonReportParams", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;Lcom/larus/bmhome/chat/layout/holder/image/ImageItemDataWithTemplate;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ScrollImageViewHolder extends RecyclerView.ViewHolder {
    public static final Lazy<Boolean> q = null;
    public static final Lazy<Boolean> r = null;
    public final LarusImageScrollItemBinding a;
    public final SketchLoadingController b;
    public final g0 c;
    public final Function0<Boolean> d;
    public final h0 e;
    public final Function1<Message, Map<String, Object>> f;
    public final Function0<CoroutineScope> g;
    public final BotModel h;
    public final com.larus.bmhome.chat.api.q0 i;
    public m0 j;
    public Message k;
    public Integer l;
    public boolean m;
    public boolean n;
    public final k1 o;
    public final Lazy p;

    public static final class a {
    }

    static {
        q = LazyKt.lazy(new b1());
        r = LazyKt.lazy(new c1());
    }

    public static final ChatParam T3(ScrollImageViewHolder r8, boolean r9, BotModel r10) {
        r8.getClass();
        if (r9 == false) goto L10;
        wc9.e r11 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r11 == null) goto L7;
        String r12 = r11.a;
    L8:
        if (r12 != null) goto L17;
        r12 = "";
    L17:
        String r1 = r12;
    L19:
        if (r9 == false) goto L25;
        com.larus.bmhome.chat.api.e0 r13 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r13 == null) goto L28;
        LaunchInfo r14 = r13.a;
        if (r14 == null) goto L28;
        String r15 = r14.W();
    L27:
        String r2 = r15;
    L30:
        return new ChatParam(r1, r2, null, null, null, 252);
    L28:
        r2 = null;
        goto L30
    L25:
        if (r10 == null) goto L28;
        r15 = r10.getBotId();
        goto L27
    L7:
        r12 = null;
        goto L8
    L10:
        com.larus.bmhome.chat.api.q0 r16 = r8.i;
        if (r16 == null) goto L18;
        com.larus.bmhome.chat.api.n0 r17 = r16.M7();
        if (r17 == null) goto L18;
        com.larus.bmhome.chat.component.cvs.y r18 = (com.larus.bmhome.chat.component.cvs.y) r17.invoke();
        if (r18 == null) goto L18;
        r12 = r18.Y1();
    L18:
        r1 = null;
        goto L19
    }

    public static final Object U3(final ScrollImageViewHolder r11, String r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof ScrollImageViewHolder$doSaveImage$1) == false) goto L7;
        ScrollImageViewHolder$doSaveImage$1 r0 = (ScrollImageViewHolder$doSaveImage$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L12:
        String r5 = r12;
        if (((Boolean) r14).booleanValue() == false) goto L76;
        ICreationMetadataService.Companion r15 = ICreationMetadataService.a;
        Message r16 = r11.k;
        m0 r4 = r11.j;
        if (r4 == null) goto L47;
        String r6 = r4.e;
    L48:
        UserCreationFromIM r17 = r15.I(r16, r6, String.valueOf(r11.l));
        m0 r7 = r11.j;
        if (r7 == null) goto L51;
        String r8 = r7.e;
    L52:
        Map r9 = r15.L(r17, r8);
        Message r18 = r11.k;
        m0 r10 = r11.j;
        if (r10 == null) goto L55;
        String r19 = r10.e;
    L56:
        final UserCreationFromIM r110 = r15.I(r18, r19, String.valueOf(r11.l));
        Message r111 = r11.k;
        if (r111 == null) goto L66;
        String r112 = ap8.a.b(r111);
        if (r112 == null) goto L66;
        if ((!StringsKt.isBlank(r112)) == true) goto L64;
        r112 = null;
    L64:
        if (r112 == null) goto L66;
    L67:
        IFlowSdkDepend r20 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r20 == null) goto L74;
        r20.D0();
        com.larus.home.impl.sdk.b1 r21 = com.larus.home.impl.sdk.b1.a;
        r21.c("chat_thumbnail_download");
        if (r5 != null) goto L72;
        String r22 = "";
    L73:
        r21.d(r22);
        goto L74
    L72:
        r22 = r5;
    L74:
        ImageDownloadLoadingMgr r23 = ImageDownloadLoadingMgr.a;
        ImageDownloadLoadingMgr.b(r5, r9, new ScrollImageViewHolder$doSaveImage$3(r110, r11, null), new f1(r11, r110), true, new ScrollImageViewHolder$doSaveImage$5(r5, r112, null));
    L66:
        r112 = "creation_image";
        goto L67
    L55:
        r19 = null;
        goto L56
    L51:
        r8 = null;
        goto L52
    L47:
        r6 = null;
    L76:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        if (r12 != null) goto L18;
    L21:
        boolean r113 = true;
    L23:
        if (r113 == false) goto L25;
        FLogger.a.e("ScrollImageViewHolder", "doSaveImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L25:
        FragmentActivity r114 = ((RecyclerView.ViewHolder) r11).itemView.getContext();
        if ((r114 instanceof FragmentActivity) == false) goto L28;
        FragmentActivity r115 = r114;
    L29:
        if (r115 != null) goto L31;
        FLogger.a.e("ScrollImageViewHolder", "no activity");
        return Unit.INSTANCE;
    L31:
        r0.L$0 = r12;
        r0.label = 1;
        SafeContinuation r24 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        if (Build.VERSION.SDK_INT <= 29) goto L34;
    L36:
        Result.Companion r116 = Result.Companion;
        r24.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
    L37:
        r14 = r24.getOrThrow();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L40:
        if (r14 != r2) goto L12;
        return r2;
    L34:
        if (ContextCompat.checkSelfPermission(r115, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L36;
        i2.b.a(r115, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new j1(r24));
        goto L37
    L28:
        r115 = null;
        goto L29
    L18:
        if (r12.length() == 0) goto L21;
        r113 = false;
    L7:
        r0 = new ScrollImageViewHolder$doSaveImage$1(r11, r13);
        goto L8
    }

    public static final Object V3(ScrollImageViewHolder r35, String r36, df8.a r37, m0 r38, JSONObject r39, Continuation r40) {
        r35.getClass();
        if ((r40 instanceof ScrollImageViewHolder$doShareImage$1) == false) goto L7;
        ScrollImageViewHolder$doShareImage$1 r2 = (ScrollImageViewHolder$doShareImage$1) r40;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ScrollImageViewHolder$doShareImage$1 r9 = r2;
        Object r1 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r9.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L97:
        r35.m = false;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r36 != null) goto L17;
    L20:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        FLogger.a.e("ScrollImageViewHolder", "doShareImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L25:
        if (r35.m == false) goto L27;
        FLogger.a.i("ScrollImageViewHolder", "doShareImage return because isSharing is true");
        return Unit.INSTANCE;
    L27:
        r35.m = true;
        ky9.b r6 = ICreationReportService.a.j().e();
        ImageShareClickMethod r7 = ImageShareClickMethod.OverviewClick;
        String r8 = ap8.a.b(r38.a);
        if (r8 == null) goto L30;
        Integer r11 = Boxing.boxInt(ap8.a.d(r8));
    L31:
        com.larus.bmhome.share.panel.h r21 = r6.c(r7, r37, r11, r39, r38.a);
        z2 r12 = z2.a;
        v1 r13 = r12.getCreationShareSettings().a();
        if (r13 != null) goto L34;
    L36:
        boolean r14 = false;
    L37:
        if (r14 == false) goto L93;
        v1 r15 = r12.getCreationShareSettings().a();
        if (r15 != null) goto L41;
    L43:
        boolean r16 = false;
    L45:
        if (r16 == false) goto L50;
        if (Intrinsics.areEqual(ap8.a.b(r38.a), "avatar_image") == false) goto L53;
    L54:
        boolean r17 = false;
    L55:
        if (r17 == false) goto L93;
        FragmentActivity r18 = ((RecyclerView.ViewHolder) r35).itemView.getContext();
        if ((r18 instanceof FragmentActivity) == false) goto L59;
        FragmentActivity r19 = r18;
    L60:
        if (r19 == null) goto L94;
        FragmentManager r20 = r19.getSupportFragmentManager();
        if (r20 == null) goto L94;
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L94;
        r22.r0();
        e2 r23 = e2.a;
        ImageEntity r24 = r37.b.getPreviewImage();
        if (r24 == null) goto L68;
        String r25 = r24.getUrl();
    L69:
        String r110 = String.valueOf(r25);
        ImageEntity r26 = r37.b.getImageOrigin();
        if (r26 == null) goto L72;
        String r27 = r26.getUrl();
    L73:
        String r111 = String.valueOf(r27);
        ImageEntity r28 = r37.b.getRawImage();
        if (r28 == null) goto L76;
        String r112 = r28.getUrl();
    L78:
        if (ap8.a.c(r38.a) == true) goto L83;
        ImageEntity r29 = r37.b.getRefImage();
        if (r29 == null) goto L83;
        String r113 = r29.getUrl();
    L84:
        ShareScene r210 = ShareScene.IMAGE_VIEWER_REPORT;
        ImageEntity r30 = r37.b.getImageOrigin();
        if (r30 == null) goto L87;
        long r211 = r30.getHeight();
    L88:
        ImageEntity r31 = r37.b.getImageOrigin();
        if (r31 == null) goto L91;
        long r212 = r31.getWidth();
    L92:
        sq9.i r32 = new sq9.i("share", r38.a.getMessageId(), null, 4);
        ICreationMetadataService.Companion r33 = ICreationMetadataService.a;
        r23.Z0(r20, new sq9.j(null, r110, r111, r112, r113, null, r21, r210, r212, r211, r32, r33.L(r33.I(r35.k, r38.e, String.valueOf(r37.a)), null), 0, null, null, null, null, 127009));
        goto L94
    L91:
        r212 = -1;
        goto L92
    L87:
        r211 = -1;
    L83:
        r113 = null;
        goto L84
    L76:
        r112 = null;
        goto L78
    L72:
        r27 = null;
        goto L73
    L68:
        r25 = null;
    L94:
        r9.label = 1;
        if (DelayKt.delay(500, r9) != r10) goto L97;
        return r10;
    L59:
        r19 = null;
    L53:
        r17 = true;
        goto L55
    L50:
        if (Intrinsics.areEqual(ap8.a.b(r38.a), "avatar_image") == true) goto L54;
        if (Intrinsics.areEqual(ap8.a.b(r38.a), "image") == true) goto L54;
    L41:
        if (r15.f() != true) goto L43;
        r16 = true;
    L93:
        ICreationShareService.a.a(ICreationShareService.a, ((RecyclerView.ViewHolder) r35).itemView.getContext(), r36, ShareScene.IMAGE_VIEWER, null, r21, null, ICreationMetadataService.a.I(r35.k, r38.e, String.valueOf(r37.a)), null, null, 904);
        goto L94
    L34:
        if (r13.e() != true) goto L36;
        r14 = true;
        goto L37
    L30:
        r11 = null;
        goto L31
    L17:
        if (r36.length() == 0) goto L20;
        r5 = false;
    L7:
        r2 = new ScrollImageViewHolder$doShareImage$1(r35, r40);
        goto L8
    }

    public ScrollImageViewHolder(LarusImageScrollItemBinding r2, SketchLoadingController r3, g0 r4, q0 r5, h0 r6, Function1 r7, Function0 r8, BotModel r9, com.larus.bmhome.chat.api.q0 r10) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "loadingController");
        Intrinsics.checkNotNullParameter(r4, "loadImageAction");
        Intrinsics.checkNotNullParameter(r5, "isReloadGetter");
        Intrinsics.checkNotNullParameter(r6, "progressGetter");
        Intrinsics.checkNotNullParameter(r7, "eventParamsGetter");
        Intrinsics.checkNotNullParameter(r8, "coroutineScopeGetter");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.o = new k1(this);
        this.p = LazyKt.lazy(LazyThreadSafetyMode.NONE, new g1(this));
    }
}
