package com.larus.canvas.feature.component.logic;

import androidx.collection.LruCache;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.canvas.feature.component.logic.bean.ImageSaveStatus;
import com.larus.canvas.feature.component.resultdisplay.image.CanvasSaveActionPlacement;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.service.bean.AIBeautify;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasGenerateData;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010.\u001a\u00020)H\u0016J\b\u0010/\u001a\u00020)H\u0016J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0012\u00102\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00103\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J \u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0016J\u0014\u00108\u001a\u0004\u0018\u00010\u00072\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0014\u0010;\u001a\u0004\u0018\u00010:2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010<\u001a\u00020)H\u0002J\u0012\u0010=\u001a\u00020)2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u001a\u0010@\u001a\u00020)2\u0006\u0010>\u001a\u00020:2\b\b\u0001\u0010A\u001a\u00020+H\u0002J/\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020:2\b\u0010A\u001a\u0004\u0018\u00010+2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u0004\u0018\u00010\u00072\u0006\u0010C\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020)H\u0002J\b\u0010I\u001a\u00020)H\u0002J\u0010\u0010J\u001a\u00020)2\u0006\u0010>\u001a\u00020:H\u0002R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R*\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020)\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/canvas/feature/component/logic/CanvasImageOperatorComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "<init>", "()V", "urlLocalIdMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "imageDownloadUrlCache", "isSharing", "", "genImagePlannerAbility", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "getGenImagePlannerAbility", "()Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "genImagePlannerAbility$delegate", "Lkotlin/Lazy;", "canvasTitleAbility", "Lcom/larus/canvas/feature/component/title/ITitleAbility;", "getCanvasTitleAbility", "()Lcom/larus/canvas/feature/component/title/ITitleAbility;", "canvasTitleAbility$delegate", "imagePagerAbility", "Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "getImagePagerAbility", "()Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "imagePagerAbility$delegate", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "hostUiPolicy", "Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "hostUiPolicy$delegate", "downloadImageCallback", "Lkotlin/Function3;", "", "", "curPage", "", "prefetchedIdLruCache", "Landroidx/collection/LruCache;", "onAttach", "onStart", "onCreateNewPage", "localId", "canSaveImage", "saveImage", "shareImage", "enterMethod", "clickMethod", "currentPage", "getImageEditFunctionId", "targetTaskItem", "Lcom/larus/canvas/feature/component/logic/bean/GenImageTaskItem;", "getTargetTask", "bindObservers", "handlePageChanged", "curPageInfo", "Lcom/larus/canvas/feature/component/logic/bean/ITaskItem;", "refreshSaveBtn", "saveStatus", "canDownloadImage", "taskItem", "requireLoaded", "allowSavedStatus", "(Lcom/larus/canvas/feature/component/logic/bean/GenImageTaskItem;Ljava/lang/Integer;ZZ)Z", "getAvailableDownloadUrl", "refreshSaveActionForOriginalPage", "refreshImageOverlaySaveAction", "prefetchBitmaps", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasImageOperatorComponent extends ComponentFeature implements o2 {
    public static final /* synthetic */ int s = 0;
    public final HashMap<String, String> h;
    public final HashMap<String, String> i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final k p;
    public int q;
    public final LruCache<String, Boolean> r;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.canvas.feature.component.logic.o2
    public final void n80(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localId");
    }

    public final n2 L2() {
        return (n2) this.k.getValue();
    }

    public final CanvasHostUiPolicy N2() {
        return (CanvasHostUiPolicy) this.o.getValue();
    }

    public final void U2() {
        com.larus.canvas.feature.component.resultdisplay.image.r r0 = (com.larus.canvas.feature.component.resultdisplay.image.r) this.m.getValue();
        if (r0 == null) goto L6;
        r0.N50(new b(this));
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, o2.class);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.canvas.feature.component.logic.k] */
    public CanvasImageOperatorComponent() {
        this.h = new HashMap();
        this.i = new HashMap();
        this.k = LazyKt.lazy(new f(this));
        this.l = LazyKt.lazy(new g(this));
        this.m = LazyKt.lazy(new h(this));
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.n = LazyKt.lazy(r0, new i(this));
        this.o = LazyKt.lazy(r0, new j(this));
        this.p = new k(this);
        this.r = new LruCache(10);
    }

    public final void onStart() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasImageOperatorComponent$bindObservers$1(this, null), 3, null);
    }

    public final ky8.f P2(String r3) {
        if (r3 != null) goto L15;
        n2 r4 = L2();
        if (r4 == null) goto L11;
        kotlinx.coroutines.flow.b1 r5 = r4.tx();
        if (r5 == null) goto L11;
        Pair r6 = (Pair) r5.getValue();
        if (r6 == null) goto L11;
        ky8.h r7 = (ky8.h) r6.getSecond();
    L13:
        if ((r7 instanceof ky8.f) == true) goto L20;
        return null;
    L20:
        return (ky8.f) r7;
    L11:
        r7 = null;
        goto L13
    L15:
        n2 r1 = L2();
        if (r1 != null) goto L18;
        return null;
    L18:
        return r1.O30(r3);
    }

    @Override // com.larus.canvas.feature.component.logic.o2
    public final void RI(String r12) {
        ky8.f r1 = P2(r12);
        if (r1 != null) goto L6;
        return;
    L6:
        if (yp(r12) == true) goto L8;
        return;
    L8:
        String r13 = r1.g();
        if (r13 == null) goto L11;
        this.i.put(r1.a, r13);
    L12:
        String r2 = r13;
        if (r2 == null) goto L19;
        String r4 = r1.a;
        n2 r14 = L2();
        if (r14 == null) goto L17;
        r14.cc(r4, 1);
    L17:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasImageOperatorComponent$saveImage$1$1(r1, r2, this, r4, null), 3, null);
        return;
    L19:
        return;
    L11:
        r13 = this.i.get(r1.a);
        goto L12
    }

    @Override // com.larus.canvas.feature.component.logic.o2
    public final boolean yp(String r6) {
        ky8.f r0 = P2(r6);
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        Integer r2 = Integer.valueOf(r0.g);
        if (r6 != null) goto L18;
        if (N2().a == false) goto L10;
        CanvasSaveActionPlacement r7 = CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START;
    L12:
        if (r7 != CanvasSaveActionPlacement.TITLE_RIGHT) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L18;
        r1 = true;
        goto L18
    L14:
        r8 = false;
        goto L15
    L10:
        r7 = CanvasSaveActionPlacement.TITLE_RIGHT;
    L18:
        return F2(r0, r2, r1, N2().a());
    }

    public final void X2(ky8.f r7, @ImageSaveStatus int r8) {
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L6;
        com.larus.canvas.feature.component.title.k r9 = (com.larus.canvas.feature.component.title.k) this.l.getValue();
        if (r9 == null) goto L17;
        r9.N50(new com.larus.canvas.feature.component.logic.a());
    L17:
        U2();
        return;
    L6:
        if (r8 != 2) goto L8;
        com.larus.canvas.feature.component.title.k r10 = (com.larus.canvas.feature.component.title.k) this.l.getValue();
        if (r10 == null) goto L13;
        r10.N50(new d(this));
    L13:
        U2();
        return;
    L8:
        if (r8 == 3) goto L18;
        return;
    L18:
        final boolean r0 = F2(r7, Integer.valueOf(r8), true, false);
        boolean r11 = F2(r7, Integer.valueOf(r8), false, N2().a());
        com.larus.canvas.feature.component.title.k r1 = (com.larus.canvas.feature.component.title.k) this.l.getValue();
        if (r1 == null) goto L21;
        r1.N50(new c(this, r0));
    L21:
        U2();
        if (r11 == true) goto L24;
        return;
    L24:
        if (this.r.get(r7.a) != null) goto L30;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CanvasImageOperatorComponent$prefetchBitmaps$1(r7, this, null), 2, null);
        return;
    }

    @Override // com.larus.canvas.feature.component.logic.o2
    public final void OX(String r82, String r83, String r84) {
        Intrinsics.checkNotNullParameter(r82, "enterMethod");
        Intrinsics.checkNotNullParameter(r83, "clickMethod");
        Intrinsics.checkNotNullParameter(r84, "currentPage");
        if (this.j == false) goto L6;
        FLogger.a.i("CanvasImageOperatorComponent", "doShareImage return because isSharing is true");
        return;
    L6:
        n2 r1 = L2();
        if (r1 == null) goto L13;
        kotlinx.coroutines.flow.b1 r2 = r1.tx();
        if (r2 == null) goto L13;
        Pair r3 = (Pair) r2.getValue();
        if (r3 == null) goto L13;
        ky8.h r4 = (ky8.h) r3.getSecond();
    L15:
        if ((r4 instanceof ky8.f) == false) goto L17;
        ky8.f r5 = (ky8.f) r4;
    L18:
        if (r5 != null) goto L21;
        return;
    L21:
        if (r5.l() == true) goto L24;
        FLogger.a.e("CanvasImageOperatorComponent", "doShareImage error because task status is not success");
        return;
    L24:
        this.j = true;
        my8.q r6 = (my8.q) this.n.getValue();
        if (r6 == null) goto L27;
        String r27 = r6.b();
    L28:
        UserCreationFromIM r7 = r5.f();
        if (r7 == null) goto L36;
        Integer r8 = r7.getCreationType();
        if (r8 == null) goto L36;
        if (r8.intValue() != 4) goto L36;
        int r28 = 1;
    L37:
        String r31 = String.valueOf(r5.d());
        if (r5.c() == null) goto L58;
        AIBeautify r9 = r5.c();
        if (r9 == null) goto L43;
        boolean r10 = Intrinsics.areEqual(r9.isExpand, Boolean.TRUE);
    L44:
        if (r10 == false) goto L46;
        String r11 = "2";
    L59:
        String r50 = String.valueOf(r11);
        String r32 = r5.j();
        String r45 = AccountService.a.getUserId();
        String r47 = r5.e();
        my8.q r12 = (my8.q) this.n.getValue();
        if (r12 == null) goto L62;
        String r78 = r12.d();
    L63:
        n2 r13 = L2();
        if (r13 == null) goto L70;
        kotlinx.coroutines.flow.b1 r14 = r13.tx();
        if (r14 == null) goto L70;
        Pair r15 = (Pair) r14.getValue();
        if (r15 == null) goto L70;
        Integer r79 = (Integer) r15.getFirst();
    L71:
        Boolean r34 = Boolean.FALSE;
        com.larus.bmhome.share.panel.h r80 = new com.larus.bmhome.share.panel.h(null, null, r78, r84, "self_created", r27, r47, null, null, false, null, null, null, null, null, null, null, null, r34, null, null, null, null, null, r45, r31, null, null, r32, r79, "pure", r34, Boolean.TRUE, "click_download", null, null, null, null, null, null, null, null, r83, "image_generate_canvas", r82, Integer.valueOf(r28), "bot", r50, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 871364359, -516112, 1023);
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r16 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r16 == null) goto L157;
        FragmentManager r17 = r16.getSupportFragmentManager();
        if (r17 == null) goto L157;
        ImageData r18 = r5.h();
        String r19 = r5.i();
        String r20 = "";
        if (r19 != null) goto L78;
        String r53 = "";
    L79:
        List<CanvasBlock> r21 = r5.b;
        if (r21 == null) goto L88;
        CanvasBlock r22 = (CanvasBlock) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L88;
        CanvasImageBlock r23 = r22.content;
        if (r23 == null) goto L88;
        CanvasGenerateData r24 = r23.generateData;
        if (r24 == null) goto L88;
        List<ImageObj> r25 = r24.refImages;
    L89:
        IFlowSdkDepend r26 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r26 == null) goto L157;
        r26.r0();
        com.larus.home.impl.sdk.e2 r29 = com.larus.home.impl.sdk.e2.a;
        if (r18 == null) goto L96;
        ImageObj r30 = r18.imageOrigin;
        if (r30 == null) goto L96;
        String r33 = r30.url;
    L97:
        if (r33 != null) goto L99;
        String r54 = "";
    L100:
        if (r18 == null) goto L104;
        ImageObj r35 = r18.imageOriRaw;
        if (r35 == null) goto L104;
        String r36 = r35.url;
    L105:
        if (r36 == null) goto L109;
        r20 = r36;
    L109:
        if (r20.length() != 0) goto L111;
        boolean r110 = true;
    L112:
        if (r110 == false) goto L118;
        if (r18 == null) goto L117;
        ImageObj r37 = r18.imageThumbRaw;
        if (r37 == null) goto L117;
        r20 = r37.url;
    L117:
        String r55 = null;
    L119:
        if (r25 != null) goto L121;
    L123:
        boolean r111 = false;
    L124:
        if (r111 == false) goto L126;
        String r56 = ((ImageObj) CollectionsKt.first(r25)).url;
    L127:
        ShareScene r59 = ShareScene.IMAGE_VIEWER_REPORT;
        long r38 = -1;
        if (r18 == null) goto L132;
        ImageObj r39 = r18.imageOrigin;
        if (r39 == null) goto L132;
        long r62 = r39.height;
    L133:
        if (r18 == null) goto L137;
        ImageObj r40 = r18.imageOrigin;
        if (r40 == null) goto L137;
        r38 = r40.width;
    L137:
        long r60 = r38;
        Continuation r41 = null;
        sq9.i r42 = new sq9.i(ShareChannel.SHARE, null, null, 4);
        Map r65 = IUgcAIGCService.a.L(r5.f(), null);
        List<CanvasBlock> r43 = r5.b;
        if (r43 == null) goto L146;
        CanvasBlock r44 = (CanvasBlock) CollectionsKt.firstOrNull(r43);
        if (r44 == null) goto L146;
        CanvasImageBlock r46 = r44.content;
        if (r46 == null) goto L146;
        CanvasInfo r48 = r46.canvasInfo;
        if (r48 == null) goto L146;
        Integer r68 = r48.taskType;
    L147:
        if (r18 == null) goto L152;
        String r49 = r18.imageUri;
        if (r49 == null) goto L152;
    L154:
        String r70 = r49;
    L156:
        r29.Z0(r17, new sq9.j(null, r53, r54, r55, r56, null, r80, r59, r60, r62, r42, r65, 0, null, r68, null, r70, 45089));
    L158:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasImageOperatorComponent$shareImage$2(this, r41), 3, null);
        return;
    L152:
        if (r18 == null) goto L155;
        r49 = r18.key;
        goto L154
    L155:
        r70 = null;
    L146:
        r68 = null;
    L132:
        r62 = -1;
        goto L133
    L126:
        r56 = null;
        goto L127
    L121:
        if (r25.size() != 1) goto L123;
        r111 = true;
    L118:
        r55 = r20;
        goto L119
    L111:
        r110 = false;
    L104:
        r36 = null;
        goto L105
    L99:
        r54 = r33;
    L96:
        r33 = null;
    L88:
        r25 = null;
        goto L89
    L78:
        r53 = r19;
    L157:
        r41 = null;
    L70:
        r79 = null;
        goto L71
    L62:
        r78 = null;
        goto L63
    L46:
        AIBeautify r51 = r5.c();
        if (r51 == null) goto L49;
        boolean r52 = Intrinsics.areEqual(r51.isErase, Boolean.TRUE);
    L50:
        if (r52 == false) goto L52;
        r11 = "3";
        goto L59
    L52:
        AIBeautify r57 = r5.c();
        if (r57 == null) goto L55;
        boolean r58 = Intrinsics.areEqual(r57.isQualityImprove, Boolean.TRUE);
    L56:
        if (r58 == false) goto L58;
        r11 = "1";
        goto L59
    L55:
        r58 = false;
        goto L56
    L49:
        r52 = false;
        goto L50
    L43:
        r10 = false;
    L58:
        r11 = null;
    L36:
        r28 = 0;
        goto L37
    L27:
        r27 = null;
        goto L28
    L17:
        r5 = null;
    L13:
        r4 = null;
        goto L15
    }

    public final boolean F2(ky8.f r4, Integer r5, boolean r6, boolean r7) {
        if (r4.l() == false) goto L23;
        String r0 = r4.g();
        if (r0 == null) goto L7;
        this.i.put(r4.a, r0);
    L8:
        if (r0 == null) goto L23;
        if (r6 == true) goto L11;
    L12:
        if (r7 == true) goto L18;
        if (r5 == null) goto L18;
        if (r5.intValue() == 2) goto L23;
    L18:
        if (r5 != null) goto L21;
        return true;
    L21:
        if (r5.intValue() == 1) goto L23;
        return true;
    L11:
        if (r4.f == false) goto L23;
    L7:
        r0 = this.i.get(r4.a);
    L23:
        return false;
    }
}
