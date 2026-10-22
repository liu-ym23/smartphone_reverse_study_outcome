package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.chat.common.databinding.LarusLayoutImageNonComplianceBinding;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationAttachmentService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatMessageBgService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t1 extends h38.d {
    public static final /* synthetic */ int t = 0;
    public float a;
    public float b;
    public final Handler c;
    public final l1 d;
    public h38.c e;
    public final mt8.a f;
    public final LarusLayoutImageNonComplianceBinding g;
    public Message h;
    public boolean i;
    public ArrayList<Integer> j;
    public final Lazy k;
    public boolean l;
    public boolean m;
    public Integer n;
    public Function1<? super Message, Unit> o;
    public Function1<? super Message, Unit> p;
    public boolean q;
    public Integer r;
    public final p1 s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[INestedFileCacheManagerService.FileEvent.values().length];
            r0[INestedFileCacheManagerService.FileEvent.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[INestedFileCacheManagerService.FileEvent.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[INestedFileCacheManagerService.FileEvent.UPDATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[ResourceType.values().length];
            r1[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[ResourceType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/larus/bmhome/chat/layout/item/NestedFileView$bindData$1$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c extends TypeToken<ArrayList<Integer>> {
        public c() {
        }
    }

    static {
    }

    private final Gson getGson() {
        return (Gson) this.k.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        Message r0 = this.h;
        if (r0 == null) goto L39;
        int r1 = com.larus.utils.p0.a;
        String r2 = com.larus.utils.p0.a(r0.getLocalMessageId());
        if (r2 == null) goto L40;
        List r3 = com.larus.bmhome.chat.bean.d.f(r0).getEntities();
        boolean r4 = false;
        if (r3 == null) goto L30;
        List r5 = r3;
        if ((r5 instanceof Collection) == true) goto L13;
    L15:
        Iterator r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L27;
        Integer r7 = ((UplinkFileEntity) r6.next()).getUpLinkStatus();
        int r8 = UpLinkState.PROCESSING.getValue();
        if (r7 != null) goto L22;
    L24:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L17;
        boolean r10 = true;
    L28:
        if (r10 != true) goto L30;
        r4 = true;
        goto L30
    L22:
        if (r7.intValue() != r8) goto L24;
        r9 = true;
    L27:
        r10 = false;
        goto L28
    L13:
        if (r5.isEmpty() == false) goto L15;
    L30:
        if (r4 == false) goto L38;
        FLogger.a.i("NestedFileView", "[tryResumeUplinkProgressObserver] resume localMessageId:".concat(r2));
        com.larus.utils.y.c(new r1(r2, this));
        return;
    L38:
        return;
    L40:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        this.c.removeCallbacks(this.d);
        Message r0 = this.h;
        if (r0 == null) goto L10;
        String r1 = r0.getLocalMessageId();
        if (r1 == null) goto L11;
        String r2 = com.larus.utils.p0.a(r1);
        if (r2 == null) goto L12;
        com.larus.utils.y.c(new q1(r2, this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final Integer getBotType() {
        return this.n;
    }

    public final boolean getEnableEditVideoForSingleVideo() {
        return this.m;
    }

    public final Function1<Message, Unit> getOnEditImageBtnShown() {
        return this.o;
    }

    public final Function1<Message, Unit> getOnEditVideoBtnShown() {
        return this.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.layout.item.l1] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.larus.bmhome.chat.layout.item.p1] */
    public t1(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.c = new Handler(Looper.getMainLooper());
        this.d = new l1(this);
        mt8.a r0 = InputViewCreatorDelegate.b.e(r7);
        this.f = r0;
        this.j = new ArrayList();
        this.k = LazyKt.lazy(new m1());
        this.o = new n1();
        this.p = new o1();
        IObricChatMessageBgService r1 = (IObricChatMessageBgService) ServiceManager.get().getService(IObricChatMessageBgService.class);
        if (r1 == null) goto L5;
        r1.configNestedFileViewBackground(r0.getView());
    L5:
        LarusLayoutImageNonComplianceBinding r8 = LarusLayoutImageNonComplianceBinding.a(LayoutInflater.from(r7), this);
        this.g = r8;
        addView(r0.getView(), new ViewGroup.LayoutParams(-1, -1));
        GradientMaskView r2 = new GradientMaskView(getContext(), null, 6, 0);
        addView(r2, new ViewGroup.LayoutParams(-1, -1));
        r2.bringToFront();
        addView(r8.a, new FrameLayout.LayoutParams(-2, -2));
        this.s = new p1(this);
    }

    public static BizMergeForwardBlock b(Message r5) {
        List r0 = r5.getContentBlock();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        if (r1.isEmpty() == false) goto L8;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r1 = vd9.r.a(r5);
    L8:
        Iterator r6 = r1.iterator();
    L10:
        if (r6.hasNext() == false) goto L23;
        Object r2 = r6.next();
        Block r3 = (Block) r2;
        if (r3.getBlockType() == BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()) goto L20;
        BlockContent r4 = r3.getContent();
        if (r4 == null) goto L16;
        BizMergeForwardBlock r7 = r4.getBizMergeForwardBlock();
    L17:
        if (r7 != null) goto L20;
        boolean r8 = false;
    L21:
        if (r8 == false) goto L10;
    L24:
        Block r9 = (Block) r2;
        if (r9 == null) goto L35;
        BlockContent r10 = r9.getContent();
        if (r10 != null) goto L29;
        return null;
    L29:
        return r10.getBizMergeForwardBlock();
    L35:
        return null;
    L16:
        r7 = null;
    L20:
        r8 = true;
        goto L21
    L23:
        r2 = null;
        goto L24
    }

    public static boolean d(Message r4) {
        Map r5 = r4.getExt();
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        String r2 = PollingConfigService.a.f("lottry_image_mask_enable");
        if (com.larus.utils.o0.d(r2) == true) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r6 == false) goto L18;
        if (r3 == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L11:
        if (tx9.l3.e(r2, 1) != 1) goto L13;
        r3 = true;
        goto L14
    L5:
        if (Intrinsics.areEqual(r5.get("chat_raf_option"), "1") == false) goto L7;
        r6 = true;
        goto L8
    }

    public final ResourceBarConfig c(Message r13) {
        if (r13.getMessageStatusLocal() != 12) goto L5;
        int r6 = 0;
    L6:
        Mode r4 = Mode.SHOW;
        final BizMergeForwardBlock r1 = b(r13);
        if (r1 != null) goto L9;
        HashMap r2 = new HashMap();
    L11:
        return new ResourceBarConfig(r4, false, r6, 0, r2, MapsKt.mapOf(TuplesKt.to("key_message", r13)), 10, null);
    L9:
        r2 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ResourceType.CUSTOM.getValue()), new s1(this, r1))});
        goto L11
    L5:
        r6 = i5.h();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L4;
        Integer r0 = Integer.valueOf(r6.getActionMasked());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L24:
        this.c.removeCallbacks(this.d);
    L26:
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r6);
    L14:
        if (r0.intValue() != 2) goto L24;
        float r1 = Math.abs(r6.getX() - this.a);
        float r2 = Math.abs(r6.getY() - this.b);
        if (r1 <= 10.0f) goto L18;
    L19:
        this.c.removeCallbacks(this.d);
    L21:
        if (r1 <= r2) goto L23;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L26
    L23:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L26
    L18:
        if (r2 <= 10.0f) goto L21;
    L9:
        if (r0.intValue() != 0) goto L11;
        this.a = r6.getX();
        this.b = r6.getY();
        this.c.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L26
    L4:
        r0 = null;
        goto L6
    }

    public final void setBotType(Integer r1) {
        this.n = r1;
    }

    public final void setEnableEditVideoForSingleVideo(boolean r1) {
        this.m = r1;
    }

    public final void setOnEditImageBtnShown(Function1<? super Message, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    public final void setOnEditVideoBtnShown(Function1<? super Message, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }

    public final void setUpCompactMaxWidth(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.r = r3;
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    public void setUpEnableEditImageForSingleImg(boolean r1) {
        this.l = r1;
    }

    public void setUpImmersiveStyle(boolean r1) {
        this.q = r1;
    }

    public void setupDelegateCallback(h38.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.e = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Message r52, NestedFileContent r53, BaseResourceViewHolder.a r54) {
        Intrinsics.checkNotNullParameter(r52, "data");
        Intrinsics.checkNotNullParameter(r53, "content");
        Intrinsics.checkNotNullParameter(r54, "callback");
        this.h = r52;
        Map r0 = r52.getExt();
        int r7 = 1;
        if (r0 == null) goto L9;
        String r1 = (String) r0.get("white_tee_index_list");
        if (r1 == null) goto L9;
        if (com.larus.utils.o0.d(r1) != true) goto L9;
        boolean r2 = true;
    L10:
        this.i = r2;
        Gson r3 = getGson();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L17
        Map r10 = r52.getExt();     // Catch: Throwable -> L17
        if (r10 == null) goto L14;
        String r6 = (String) r10.get("white_tee_index_list");     // Catch: Throwable -> L17
    L15:
        Object r4 = Result.constructor-impl((ArrayList) r3.fromJson(r6, new c().getType()));     // Catch: Throwable -> L17
    L20:
        if (Result.exceptionOrNull-impl(r4) == null) goto L23;
        r4 = new ArrayList();
    L23:
        ArrayList<Integer> r5 = (ArrayList) r4;
        if (r5 != null) goto L26;
        r5 = new ArrayList();
    L26:
        this.j = r5;
        ArrayList r8 = new ArrayList();
        BizMergeForwardBlock r11 = b(r52);
        String r12 = "";
        if (r11 != null) goto L29;
        ResourceItemBean r13 = null;
    L48:
        if (r13 == null) goto L50;
        r8.add(r13);
    L50:
        List r14 = r53.getEntities();
        if (r14 == null) goto L246;
        Iterator r15 = r14.iterator();
        boolean r16 = false;
        int r17 = 0;
        int r18 = 0;
    L54:
        if (r15.hasNext() == false) goto L245;
        UplinkFileEntity r19 = (UplinkFileEntity) r15.next();
        r17 = r17 + r7;
        FLogger r110 = FLogger.a;
        r110.i("NestedFileView", "[bindData] messageStatusLocal:" + r52.getMessageStatusLocal() + ", entity:" + r19);
        if (r52.getMessageStatusLocal() != 0) goto L109;
        Integer r20 = r19.getUpLinkStatus();
        int r21 = UpLinkState.PROCESSING.getValue();
        if (r20 != null) goto L61;
    L108:
        Iterator r35 = r15;
        String r36 = r12;
        r16 = r16;
    L154:
        CreationNoWatermarkManager r22 = CreationNoWatermarkManager.a;
        if (r19 != null) goto L158;
        r22.getClass();
        UplinkFileEntity r23 = null;
    L190:
        if (r23 != null) goto L193;
        r23 = r19;
    L193:
        if (yc9.n1.d(r23) == false) goto L201;
        Image r24 = yc9.l1.c(r23);
        if (r24 == null) goto L201;
        String r25 = r19.getFileIdentifier();
        if (r25 != null) goto L199;
        r25 = r36;
    L199:
        r24.localResPath = com.larus.bmhome.chat.sendimage.e.h(r52, r25);
    L201:
        if (yc9.n1.d(r23) == false) goto L203;
    L206:
        int r26 = i5.d();
    L208:
        if (hp8.a.c(r52) == true) goto L210;
    L220:
        int r27 = i5.w0();
    L221:
        ResourceItemBean r28 = com.larus.bmhome.chat.c.a(r23, Mode.SHOW, r26, r27, 32);
        if (this.j.contains(Integer.valueOf(r17 - 1)) == false) goto L224;
        r18 = r18 + 1;
    L224:
        r28.setSubscriptIndex(r17 - r18);
        if (d(r52) == false) goto L243;
        Integer r29 = r19.getFileReviewStatus();
        int r30 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r29 != null) goto L230;
    L232:
        Integer r31 = r19.getFileReviewStatus();
        int r32 = FileReviewState.ACCESS.getValue();
        if (r31 != null) goto L236;
    L238:
        r28.setExt(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ext_spring_review_mode", Boolean.TRUE)}));
        if (r28.getStatus() == ItemStatus.INSPECT_FAILED) goto L241;
    L242:
        r16 = true;
    L244:
        r8.add(r28);
        r15 = r35;
        r12 = r36;
        r7 = 1;
        goto L54
    L241:
        if (r28.getStatus() == ItemStatus.SUCCESS) goto L243;
    L236:
        if (r31.intValue() != r32) goto L238;
        r28.setStatus(ItemStatus.SUCCESS);
        goto L238
    L230:
        if (r29.intValue() != r30) goto L232;
        r28.setStatus(ItemStatus.INSPECT_FAILED);
    L243:
        r16 = r16;
        goto L244
    L210:
        if (yc9.n1.d(r23) == false) goto L220;
        Image r33 = yc9.l1.c(r23);
        if (r33 == null) goto L214;
        ImageObj r34 = r33.imageOri;
    L215:
        if (r34 == null) goto L219;
        int r37 = r34.width;
        if (r37 <= 0) goto L219;
        r27 = (r34.height * r26) / r37;
    L219:
        r27 = (r26 * 4) / 3;
        goto L221
    L214:
        r34 = null;
        goto L215
    L203:
        if (yc9.n1.e(r23) == true) goto L206;
        r26 = i5.y();
        goto L208
    L158:
        if (r22.D() == true) goto L161;
    L189:
        r23 = r19;
        goto L190
    L161:
        if (yc9.n1.d(r19) == false) goto L174;
        UplinkEntityContent r38 = r19.getUplinkEntityContent();
        if (r38 == null) goto L189;
        Image r39 = r38.getUplinkImageInfo();
        if (r39 == null) goto L189;
        Image r40 = (Image) r22.S(r39, new String[]{r39.key, r39.identifier, r19.getFileIdentifier()}).a;
        if (r40 == null) goto L172;
        r39 = r40;
    L172:
        r23 = UplinkFileEntity.copy$default(r19, null, UplinkEntityContent.copy$default(r38, null, r39, 1, null), null, null, null, null, null, null, null, false, null, null, null, null, 16381, null);
        goto L190
    L174:
        if (yc9.n1.e(r19) == false) goto L189;
        UplinkEntityContent r41 = r19.getUplinkEntityContent();
        if (r41 == null) goto L189;
        UplinkFileInfo r310 = r41.getUplinkFileInfo();
        if (r310 == null) goto L189;
        VideoExtension r42 = r310.getVideo();
        if (r42 == null) goto L189;
        VideoExtension r43 = r22.g0(r42);
        if (r43 != null) goto L187;
        VideoExtension r45 = r42;
    L188:
        r23 = UplinkFileEntity.copy$default(r19, null, UplinkEntityContent.copy$default(r41, UplinkFileInfo.copy$default(r310, null, null, null, null, null, null, r45, null, null, null, 959, null), null, 2, null), null, null, null, null, null, null, null, false, null, null, null, null, 16381, null);
        goto L190
    L187:
        r45 = r43;
        goto L188
    L61:
        if (r20.intValue() != r21) goto L108;
        String r44 = r19.getFileIdentifier();
        if (r44 != null) goto L65;
        r44 = r12;
    L65:
        String r46 = r52.getLocalMessageId();
        if (r46 != null) goto L68;
        r46 = r12;
    L68:
        UplinkFileEntity r47 = NestedFileCacheManagerService.b.a(r46, r44);
        if (r47 != null) goto L71;
        boolean r48 = true;
    L72:
        if (r47 == null) goto L76;
        Integer r49 = r47.getUpLinkProcess();
        if (r49 == null) goto L76;
        int r50 = r49.intValue();
    L77:
        ResourceUploader r111 = ResourceUploader.a;
        r35 = r15;
        Intrinsics.checkNotNullParameter(r44, "identifier");
        ConcurrentHashMap r112 = com.larus.bmhome.upload.sdk.g.a;
        Intrinsics.checkNotNullParameter(r44, "identifier");
        if (com.larus.bmhome.upload.sdk.g.a.containsKey(r44) == false) goto L80;
    L83:
        boolean r51 = true;
    L84:
        if (r51 == false) goto L86;
    L88:
        boolean r55 = false;
    L89:
        r36 = r12;
        ye8.c r56 = ChatInputService.b.g();
        if (r55 == true) goto L92;
    L94:
        boolean r57 = false;
    L95:
        if (r48 == true) goto L101;
        if (r57 == true) goto L98;
    L100:
        boolean r58 = false;
    L102:
        r110.i("NestedFileView", "[isUploadingAlreadyFailed] alreadyFailed:" + r58 + ", " + r48 + ':' + r55 + ':' + r57 + ':' + r50);
        if (r58 == false) goto L154;
        r19.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        RepoDispatcher.a.getClass();
        ChatRepo r59 = RepoDispatcher.d;
        String r60 = r52.getLocalMessageId();
        if (r60 != null) goto L107;
        r60 = r36;
    L107:
        r59.r1(r60, new j1());
        goto L154
    L98:
        if (r50 >= 99) goto L100;
    L101:
        r58 = true;
        goto L102
    L92:
        if (r56.a(r44) != null) goto L94;
        r57 = true;
        goto L95
    L86:
        if (ICreationAttachmentService.a.O(r44) == true) goto L88;
        r55 = true;
        goto L89
    L80:
        if (com.larus.bmhome.upload.sdk.g.b.containsKey(r44) == true) goto L83;
        r51 = false;
    L76:
        r50 = 0;
        goto L77
    L71:
        r48 = false;
        goto L72
    L109:
        r35 = r15;
        r36 = r12;
        r16 = r16;
        if (r52.getMessageStatusLocal() != 14) goto L112;
    L153:
        r110.i("NestedFileView", "[bindData] SEND_COMPLIANT");
        r19.setFileReviewStatus(Integer.valueOf(FileReviewState.NOT_COMPLIANT.getValue()));
        goto L154
    L112:
        if (r52.getMessageStatus() == MessageStatus.MessageStatus_NOTCOMPLIANT) goto L153;
        if (r52.getMessageStatusLocal() != 13) goto L118;
        r19.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L154
    L118:
        if (r52.getMessageStatusLocal() != 11) goto L151;
        Map r61 = r19.getExtra();
        if (r61 == null) goto L122;
        String r62 = (String) r61.get("local_item_attachment");
    L124:
        if (Intrinsics.areEqual(r62, "1") == true) goto L149;
        String r63 = yc9.l1.h(r19);
        if (r63 != null) goto L128;
    L131:
        boolean r64 = true;
    L132:
        if (r64 == false) goto L149;
        UplinkEntityContent r65 = r19.getUplinkEntityContent();
        if (r65 == null) goto L140;
        UplinkFileInfo r66 = r65.getUplinkFileInfo();
        if (r66 == null) goto L140;
        VideoExtension r67 = r66.getVideo();
        if (r67 == null) goto L140;
        String r68 = r67.getVid();
    L141:
        if (r68 != null) goto L143;
    L146:
        boolean r69 = true;
    L147:
        if (r69 == false) goto L149;
        r19.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        goto L154
    L143:
        if (r68.length() == 0) goto L146;
        r69 = false;
    L140:
        r68 = null;
        goto L141
    L128:
        if (r63.length() == 0) goto L131;
        r64 = false;
    L149:
        r19.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L154
    L122:
        r62 = null;
        goto L124
    L151:
        if (r52.getMessageStatusLocal() != 21) goto L154;
        r19.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L154
    L245:
        String r311 = r12;
    L247:
        Map r70 = r52.getExt();
        if (r70 == null) goto L250;
        String r71 = (String) r70.get("chat_raf_option");
    L252:
        if (Intrinsics.areEqual(r71, "1") == false) goto L261;
        JSONObject r72 = new JSONObject();
        String r73 = r52.getLocalMessageId();
        if (r73 != null) goto L256;
        r73 = r311;
    L256:
        r72.put("local_message_id", r73);
        if (r16 == false) goto L259;
        String r74 = "1";
    L260:
        r72.put("has_mask", r74);
        FLogger.a.i("NestedFileView", "[bindData] hasMask = " + r16 + ", id = " + r52.getLocalMessageId());
        com.larus.platform.service.g.a.monitorEventForSlardar("image_spring_mask_show", r72, null, null);
    L263:
        if (r8.isEmpty() == true) goto L271;
        Iterator r75 = r8.iterator();
    L267:
        if (r75.hasNext() == false) goto L271;
        ResourceItemBean r76 = (ResourceItemBean) r75.next();
        if (hp8.a.b(r52) == false) goto L267;
        boolean r77 = true;
    L272:
        if (r77 == false) goto L297;
        FLogger r78 = FLogger.a;
        StringBuilder r79 = new StringBuilder("pic expired, ");
        String r80 = r52.getContent();
        if (r80 == null) goto L282;
        List r81 = hp8.a.a(r80).getEntities();
        if (r81 == null) goto L282;
        UplinkFileEntity r82 = (UplinkFileEntity) ListProtector.get(r81, 0);
        if (r82 == null) goto L282;
        ExpiredInfo r83 = r82.getExpiredInfo();
        if (r83 == null) goto L282;
        Long r84 = r83.getExpireTime();
    L283:
        r79.append(r84);
        r79.append(", ");
        String r85 = r52.getContent();
        if (r85 == null) goto L292;
        List r86 = hp8.a.a(r85).getEntities();
        if (r86 == null) goto L292;
        UplinkFileEntity r87 = (UplinkFileEntity) ListProtector.get(r86, 0);
        if (r87 == null) goto L292;
        ExpiredInfo r88 = r87.getExpiredInfo();
        if (r88 == null) goto L292;
        Long r89 = r88.getTtl();
    L293:
        r79.append(r89);
        r78.i("dora_e_pic", r79.toString());
        ResourceItemBean r90 = (ResourceItemBean) CollectionsKt.firstOrNull(r8);
        if (r90 == null) goto L297;
        r8.clear();
        r8.add(r90);
    L292:
        r89 = null;
    L282:
        r84 = null;
    L297:
        if (d(r52) == false) goto L300;
    L312:
        boolean r91 = false;
    L416:
        if (r91 == true) goto L418;
    L426:
        com.larus.utils.e1.o(this.g.a);
        com.larus.utils.e1.x(this.f.getView());
        this.f.h(c(r52), r8, r54);
        h38.c r92 = this.e;
        if (r92 == null) goto L429;
        r92.a();
    L429:
        Map r93 = r52.getExt();
        if (r93 != null) goto L432;
    L434:
        boolean r94 = false;
    L435:
        if (r94 == false) goto L462;
        ArrayList r95 = new ArrayList();
        Iterator r96 = r8.iterator();
    L438:
        if (r96.hasNext() == false) goto L443;
        Object r97 = r96.next();
        if ((!this.j.contains(Integer.valueOf(r8.indexOf((ResourceItemBean) r97)))) == false) goto L438;
        r95.add(r97);
        goto L438
    L443:
        if (r95.size() != 1) goto L445;
        ((ResourceItemBean) ListProtector.get(r95, 0)).setShowSubscriptView(false);
    L452:
        ArrayList r99 = new ArrayList();
        Iterator r100 = r8.iterator();
    L454:
        if (r100.hasNext() == false) goto L458;
        Object r101 = r100.next();
        if (this.j.contains(Integer.valueOf(r8.indexOf((ResourceItemBean) r101))) == false) goto L454;
        r99.add(r101);
        goto L454
    L458:
        Iterator r102 = r99.iterator();
    L460:
        if (r102.hasNext() == false) goto L462;
        ResourceItemBean r103 = (ResourceItemBean) r102.next();
        HashMap r104 = new HashMap();
        r104.put("ext_avatar_subscript_desc", ContextCompat.getString(getContext(), 2131908856));
        r103.setShowSubscriptView(true);
        r103.setExt(r104);
        r103.setResourceType(ResourceType.AVATAR);
        goto L460
    L445:
        Iterator r105 = r95.iterator();
        int r106 = 0;
    L447:
        if (r105.hasNext() == false) goto L452;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L451;
        CollectionsKt.throwIndexOverflow();
    L451:
        ((ResourceItemBean) r107).setShowSubscriptView(true);
        r106 = r108;
    L462:
        int r109 = r52.getMessageStatusLocal();
        if (r109 != 0) goto L465;
    L471:
        String r113 = r52.getLocalMessageId();
        if (r113 != null) goto L474;
        String r114 = r311;
    L475:
        com.larus.utils.y.c(new r1(r114, this));
        return;
    L474:
        r114 = r113;
        goto L475
    L465:
        if (r109 == 10) goto L471;
        String r115 = r52.getLocalMessageId();
        if (r115 != null) goto L469;
        String r116 = r311;
    L470:
        com.larus.utils.y.c(new q1(r116, this));
        return;
    L469:
        r116 = r115;
        goto L470
    L432:
        if (r93.containsKey(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) != true) goto L434;
        r94 = true;
        goto L435
    L418:
        if (((ResourceItemBean) ListProtector.get(r8, 0)).getStatus() != ItemStatus.INSPECT_FAILED) goto L426;
        if (((ResourceItemBean) CollectionsKt.first(r8)).getResourceType() != ResourceType.VIDEO) goto L422;
        this.g.b.setText(2131905684);
    L423:
        com.larus.utils.e1.x(this.g.a);
        com.larus.utils.e1.o(this.f.getView());
        h38.c r117 = this.e;
        if (r117 == null) goto L429;
        r117.c();
        goto L429
    L422:
        this.g.b.setText(2131906528);
        goto L423
    L300:
        if (r8.size() == 1) goto L302;
    L306:
        r91 = false;
    L307:
        if (r91 == false) goto L416;
        ResourceType r118 = ((ResourceItemBean) ListProtector.get(r8, 0)).getResourceType();
        int[] r119 = b.b;
        int r120 = r119[r118.ordinal()];
        if (r120 != 1) goto L311;
        Image r121 = ((ResourceItemBean) ListProtector.get(r8, 0)).getImage();
    L318:
        int r122 = r119[((ResourceItemBean) ListProtector.get(r8, 0)).getResourceType().ordinal()];
        if (r122 != 1) goto L321;
    L334:
        Pair r123 = null;
    L335:
        com.larus.bmhome.utils.q1 r124 = com.larus.bmhome.utils.q1.a;
        Context r125 = getContext();
        boolean r126 = this.q;
        Integer r127 = this.r;
        if (r127 == null) goto L343;
        int r128 = r127.intValue();
        ResourceBarConfig r129 = c(r52);
        Integer r130 = Integer.valueOf((r128 - r129.getMarginStart()) - r129.getMarginEnd());
        if (r130.intValue() <= 0) goto L340;
        boolean r131 = true;
    L341:
        if (r131 == false) goto L343;
    L344:
        r124.getClass();
        Pair r132 = com.larus.bmhome.utils.q1.a(r125, r121, r126, r123, r130);
        int r133 = ((Number) r132.component1()).intValue();
        int r134 = ((Number) r132.component2()).intValue();
        ((ResourceItemBean) ListProtector.get(r8, 0)).setItemWidth(r133 + i5.r0());
        ((ResourceItemBean) ListProtector.get(r8, 0)).setItemHeight(r134);
        if (this.q == false) goto L350;
        this.f.getView().setBackground(null);
        h38.c r135 = this.e;
        if (r135 == null) goto L349;
        r135.b();
    L349:
        ((ResourceItemBean) ListProtector.get(r8, 0)).setImmersiveStyle(this.q);
    L350:
        String r136 = r52.getConversationId();
        if (r136 != null) goto L354;
        r136 = r311;
    L354:
        if (com.larus.bmhome.utils.i.g(r136) == false) goto L356;
        boolean r137 = this.l;
    L372:
        if (((ResourceItemBean) ListProtector.get(r8, 0)).getResourceType() != ResourceType.IMAGE) goto L396;
        String r138 = r52.getConversationId();
        if (r138 != null) goto L377;
        r138 = r311;
    L377:
        if (com.larus.bmhome.utils.i.g(r138) == false) goto L379;
        boolean r139 = this.m;
    L394:
        if (r139 == false) goto L396;
        boolean r140 = true;
    L397:
        boolean r141 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
        ResourceItemBean r142 = (ResourceItemBean) ListProtector.get(r8, 0);
        if (r137 == true) goto L400;
    L403:
        boolean r143 = false;
    L404:
        r142.setShowEditImageBtn(r143);
        ResourceItemBean r144 = (ResourceItemBean) ListProtector.get(r8, 0);
        if (r140 == true) goto L407;
    L410:
        boolean r145 = false;
    L411:
        r144.setShowEditVideoBtn(r145);
        if (r137 == false) goto L414;
        this.o.invoke(r52);
    L414:
        if (r140 == false) goto L416;
        this.p.invoke(r52);
        goto L416
    L407:
        if (hp8.a.c(r52) == true) goto L410;
        if (r141 == true) goto L410;
        r145 = true;
        goto L411
    L400:
        if (hp8.a.c(r52) == true) goto L403;
        if (r141 == true) goto L403;
        r143 = true;
        goto L404
    L379:
        List r146 = CollectionsKt.listOf(new Integer[]{16, 4, 18});
        Map r147 = r52.getExt();
        if (r147 == null) goto L384;
        Integer r148 = ic8.j.c(r147);
        if (r148 == null) goto L384;
        int r149 = r148.intValue();
    L386:
        if (r146.contains(Integer.valueOf(r149)) == false) goto L393;
        sq9.y r150 = com.larus.platform.service.z2.a.getCreationEditControlConfig().c();
        if (r150 == null) goto L390;
        boolean r151 = Intrinsics.areEqual(r150.b(), Boolean.TRUE);
    L391:
        if (r151 == false) goto L393;
        r139 = true;
        goto L394
    L390:
        r151 = false;
    L393:
        r139 = false;
    L384:
        r149 = 0;
    L396:
        r140 = false;
        goto L397
    L356:
        List r152 = CollectionsKt.listOf(new Integer[]{16, 4, 18});
        Map r153 = r52.getExt();
        if (r153 == null) goto L361;
        Integer r154 = ic8.j.c(r153);
        if (r154 == null) goto L361;
        int r155 = r154.intValue();
    L363:
        if (r152.contains(Integer.valueOf(r155)) == false) goto L370;
        sq9.y r156 = com.larus.platform.service.z2.a.getCreationEditControlConfig().c();
        if (r156 == null) goto L367;
        boolean r157 = Intrinsics.areEqual(r156.a(), Boolean.FALSE);
    L368:
        if (r157 == true) goto L370;
        r137 = true;
        goto L372
    L367:
        r157 = false;
    L370:
        r137 = false;
    L361:
        r155 = 0;
        goto L363
    L340:
        r131 = false;
    L343:
        r130 = null;
        goto L344
    L321:
        if (r122 != 2) goto L334;
        mt8.b r158 = ((ResourceItemBean) ListProtector.get(r8, 0)).getVideo();
        if (r158 == null) goto L326;
        int r159 = r158.c;
    L327:
        mt8.b r160 = ((ResourceItemBean) ListProtector.get(r8, 0)).getVideo();
        if (r160 == null) goto L330;
        int r161 = r160.d;
    L331:
        if (r159 == 0) goto L334;
        if (r161 == 0) goto L334;
        r123 = TuplesKt.to(Integer.valueOf(r159), Integer.valueOf(r161));
        goto L335
    L330:
        r161 = 0;
        goto L331
    L326:
        r159 = 0;
        goto L327
    L311:
        if (r120 != 2) goto L312;
        mt8.b r162 = ((ResourceItemBean) ListProtector.get(r8, 0)).getVideo();
        if (r162 == null) goto L316;
        r121 = r162.a;
        goto L318
    L316:
        r121 = null;
        goto L318
    L302:
        if (CollectionsKt.listOf(new ResourceType[]{ResourceType.IMAGE, ResourceType.VIDEO}).contains(((ResourceItemBean) ListProtector.get(r8, 0)).getResourceType()) == false) goto L306;
        if (this.i == true) goto L306;
        r91 = true;
    L271:
        r77 = false;
        goto L272
    L259:
        r74 = "0";
        goto L260
    L261:
        FLogger.a.i("NestedFileView", "[bindData] isNotChatRafMsg, not to report, id = " + r52.getLocalMessageId());
        goto L263
    L250:
        r71 = null;
        goto L252
    L246:
        r311 = "";
        r16 = false;
        goto L247
    L29:
        String r163 = r11.getBrief();
        if (r163 != null) goto L32;
    L36:
        r163 = r52.getBrief();
        if (r163 != null) goto L39;
    L41:
        r163 = null;
    L42:
        if (r163 != null) goto L44;
        r163 = getContext().getString(2131900194);
    L44:
        String r164 = r163;
        String r165 = r52.getLocalMessageId();
        if (r165 != null) goto L47;
        r165 = "";
    L47:
        r13 = new ResourceItemBean("human_merge_forward_card_".concat(r165), r164, null, null, null, null, 0, null, false, ResourceType.CUSTOM, i5.y(), i5.w0(), 0, 0, false, false, false, false, 0, null, 1032700, null);
        goto L48
    L39:
        if ((!StringsKt.isBlank(r163)) == false) goto L41;
    L32:
        if ((!StringsKt.isBlank(r163)) == true) goto L35;
        r163 = null;
    L35:
        if (r163 != null) goto L44;
    L14:
        r6 = null;
    L17:
        th = move-exception;
        Result.Companion r166 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        r2 = false;
        goto L10
    }
}
