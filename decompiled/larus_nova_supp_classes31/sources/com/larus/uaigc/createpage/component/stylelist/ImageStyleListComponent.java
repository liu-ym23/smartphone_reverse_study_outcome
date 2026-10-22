package com.larus.uaigc.createpage.component.stylelist;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;
import ny9.s;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 12\u00060\u0001j\u0002`\u00022\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0016\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\f\u0010(\u001a\u00020\u000e*\u00020)H\u0002J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u0004\u0018\u00010\u000b2\u0006\u0010.\u001a\u00020/H\u0082@¢\u0006\u0002\u00100R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleListComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/uaigc/createpage/component/stylelist/IImageStyleListAbility;", "<init>", "()V", "isImageListShowLoading", "", "isFetchingImageStyleList", "isShowingTxt2ImageStyleList", "cachedImageStyleData", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendResponse;", "prevTxt2ImageStyleList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "Lkotlin/Lazy;", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "onAttach", "", "onCreate", "refreshImageStyleList", "fromRemote", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindObservers", "preloadImageStyleListImage", "preloadImageStyleList", "toActionBarInstructionOption", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyle;", "buildImageStylePlaceholderList", "count", "", "fetchImageStyleListFromRemote", "languageCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageStyleListComponent extends ComponentFeature implements com.larus.uaigc.createpage.component.stylelist.a {
    public static final /* synthetic */ int p = 0;
    public boolean h;
    public boolean i;
    public boolean j;
    public ImageStyleRecommendApi.ImageStyleRecommendResponse k;
    public List<w> l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    public final ys8.a L2() {
        return (ys8.a) this.n.getValue();
    }

    public ImageStyleListComponent() {
        this.j = true;
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new e(this));
        this.o = LazyKt.lazy(new f(this));
    }

    public final void onCreate() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageStyleListComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageStyleListComponent$preloadImageStyleList$1(this, null), 3, null);
    }

    public final void y2() {
        s1a.d.a(this).c(this, com.larus.uaigc.createpage.component.stylelist.a.class);
    }

    public static w P2(ImageStyleRecommendApi.ImageStyle r9) {
        Long r1 = r9.getId();
        g1 r4 = r9.getIcon();
        return new w(r1, r9.getDisplayText(), r9.getMessageText(), r4, 2, null, null, 8388436);
    }

    public final Object F2(String r6, Continuation<? super ImageStyleRecommendApi.ImageStyleRecommendResponse> r7) {
        if ((r7 instanceof ImageStyleListComponent$fetchImageStyleListFromRemote$1) == false) goto L7;
        ImageStyleListComponent$fetchImageStyleListFromRemote$1 r0 = (ImageStyleListComponent$fetchImageStyleListFromRemote$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == false) goto L32;
        dm9.a.b r10 = r9;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r11 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r10.a.getData();
        if (r11 == null) goto L22;
        List<ImageStyleRecommendApi.ImageStyle> r12 = r11.getStyleList();
    L23:
        List<ImageStyleRecommendApi.ImageStyle> r13 = r12;
        if (r13 != null) goto L26;
    L29:
        if (r4 == false) goto L42;
        FLogger.a.e("ImageStyleListComponent", "fetchImageStyleListFromRemote success but return empty list");
        return null;
    L42:
        return (ImageStyleRecommendApi.ImageStyleRecommendResponse) r10.a.getData();
    L26:
        if (r13.isEmpty() == true) goto L29;
        r4 = false;
        goto L29
    L22:
        r12 = null;
        goto L23
    L32:
        FLogger r14 = FLogger.a;
        StringBuilder r5 = new StringBuilder("fetchImageStyleListFromRemote failed, msg: ");
        if ((r9 instanceof dm9.a.a) == false) goto L35;
        dm9.a.a r15 = (dm9.a.a) r9;
    L36:
        if (r15 == null) goto L38;
        String r16 = r15.b;
    L39:
        r5.append(r16);
        r5.append('}');
        r14.e("ImageStyleListComponent", r5.toString());
        return null;
    L38:
        r16 = null;
        goto L39
    L35:
        r15 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ImageStyleRecommendApi.a r17 = ImageStyleRecommendApi.a;
        ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1 r18 = new ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1(r6, null);
        r0.label = 1;
        r17.getClass();
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new ImageStyleRecommendApi$Companion$safeCall$2(r18, null), r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ImageStyleListComponent$fetchImageStyleListFromRemote$1(this, r7);
        goto L8
    }

    public final Object N2(boolean r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof ImageStyleListComponent$refreshImageStyleList$1) == false) goto L7;
        ImageStyleListComponent$refreshImageStyleList$1 r0 = (ImageStyleListComponent$refreshImageStyleList$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r5 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r14 = r0.Z$0;
        ImageStyleListComponent r4 = (ImageStyleListComponent) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L52:
        ImageStyleRecommendApi.ImageStyleRecommendResponse r17 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r16;
    L54:
        r4.k = r17;
        this.i = false;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r7 = this.k;
        if (r7 == null) goto L61;
        List<ImageStyleRecommendApi.ImageStyle> r8 = r7.getStyleList();
        if (r8 == null) goto L61;
        List r9 = CollectionsKt.take(r8, 5);
        if (r9 == null) goto L61;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ImageStyleListComponent$preloadImageStyleListImage$1$1(r9, null), 2, null);
    L61:
        if (r14 == true) goto L63;
    L64:
        sy9.a r10 = (sy9.a) this.m.getValue();
        if (r10 == null) goto L69;
        i1<sy9.b> r11 = r10.getUiState();
        if (r11 == null) goto L69;
        sy9.b r12 = (sy9.b) r11.getValue();
    L71:
        if ((r12 instanceof sy9.b.e) == true) goto L81;
    L72:
        sy9.a r13 = (sy9.a) this.m.getValue();
        if (r13 == null) goto L77;
        i1<sy9.b> r18 = r13.getUiState();
        if (r18 == null) goto L77;
        sy9.b r19 = (sy9.b) r18.getValue();
    L79:
        if ((r19 instanceof sy9.b.c) == true) goto L81;
    L142:
        return Unit.INSTANCE;
    L77:
        r19 = null;
    L81:
        if (this.h == false) goto L83;
    L84:
        this.h = false;
        List<w> r20 = this.l;
        if (r20 != null) goto L90;
        ys8.a r21 = L2();
        if (r21 == null) goto L89;
        r20 = r21.getCurImageList();
        goto L90
    L89:
        r20 = null;
    L90:
        this.l = r20;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r22 = this.k;
        if (r22 == null) goto L134;
        List<ImageStyleRecommendApi.ImageStyle> r23 = r22.getStyleList();
        if (r23 == null) goto L134;
        ArrayList r24 = new ArrayList();
        Iterator<T> r25 = r23.iterator();
    L96:
        if (r25.hasNext() == false) goto L103;
        ImageStyleRecommendApi.ImageStyle r26 = (ImageStyleRecommendApi.ImageStyle) r25.next();
        if (r26 == null) goto L100;
        w r27 = P2(r26);
    L101:
        if (r27 == null) goto L96;
        r24.add(r27);
        goto L96
    L100:
        r27 = null;
        goto L101
    L103:
        if (r14 == true) goto L130;
        s r110 = (s) this.o.getValue();
        if (r110 != null) goto L107;
    L109:
        boolean r111 = false;
    L110:
        if (r111 == false) goto L130;
        ys8.a r112 = L2();
        if (r112 == null) goto L130;
        Long r113 = r112.getDefaultSelectedImageStyleId();
        if (r113 == null) goto L130;
        long r28 = r113.longValue();
        Iterator r114 = r24.iterator();
    L117:
        if (r114.hasNext() == false) goto L127;
        Object r29 = r114.next();
        Long r30 = ((w) r29).a;
        if (r30 != null) goto L122;
    L124:
        boolean r31 = false;
    L125:
        if (r31 == false) goto L117;
        r5 = r29;
        goto L127
    L122:
        if (r30.longValue() != r28) goto L124;
        r31 = true;
    L127:
        w r32 = (w) r5;
        if (r32 == null) goto L130;
        r32.s = Boxing.boxInt(1);
        goto L130
    L107:
        if (r110.D() != true) goto L109;
        r111 = true;
    L130:
        ys8.a r115 = L2();
        if (r115 == null) goto L133;
        r115.refreshImageListSelectorWithMore(r24);
    L133:
        Keva r116 = c.a;
        c.a(this.k, r6);
    L140:
        this.j = false;
    L134:
        ys8.a r117 = L2();
        if (r117 == null) goto L140;
        List<w> r33 = this.l;
        if (r33 != null) goto L139;
        r33 = CollectionsKt.emptyList();
    L139:
        r117.refreshImageListSelectorWithMore(r33);
        goto L140
    L83:
        if (this.j == false) goto L142;
    L69:
        r12 = null;
        goto L71
    L63:
        if (this.h == false) goto L72;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = r0.Z$0;
        r4 = (ImageStyleListComponent) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L22:
        r17 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r16;
        goto L54
    L16:
        ResultKt.throwOnFailure(r16);
        this.i = true;
        String r118 = IAIChatUgcAIGCService.a.K0();
        if (r14 == false) goto L23;
        r0.L$0 = r118;
        r0.L$1 = this;
        r0.Z$0 = r14;
        r0.label = 1;
        Object r34 = F2(r118, r0);
        if (r34 != r2) goto L21;
        return r2;
    L21:
        r4 = this;
        r6 = r118;
        r16 = r34;
        goto L22
    L23:
        Keva r35 = c.a;
        Intrinsics.checkNotNullParameter(r118, "languageCode");
        FLogger.a.i("ImageStyleListCache", "getImageStyleList");
        String r36 = c.a.getString("image_style_list_resp_" + r118, "");
        if (r36 != null) goto L143;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r37 = null;
    L47:
        if (r37 != null) goto L53;
        r0.L$0 = r118;
        r0.L$1 = this;
        r0.Z$0 = r14;
        r0.label = 2;
        Object r38 = F2(r118, r0);
        if (r38 != r2) goto L51;
        return r2;
    L51:
        r4 = this;
        r6 = r118;
        r16 = r38;
        goto L52
    L53:
        r4 = this;
        r6 = r118;
        r17 = r37;
        goto L54
    L143:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L40
        h r40 = h.a;     // Catch: Throwable -> L40
        if (StringsKt.isBlank(r36) == false) goto L145;
    L37:
        Object r41 = null;
    L38:
        Object r42 = Result.constructor-impl((ImageStyleRecommendApi.ImageStyleRecommendResponse) r41);     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r42) == false) goto L45;
        r42 = null;
    L45:
        r37 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r42;
        goto L47
    L145:
        r40.getClass();     // Catch: Throwable -> L30
        r41 = Result.constructor-impl(h.b.fromJson(r36, new b().getType()));     // Catch: Throwable -> L30
    L32:
        Throwable r43 = Result.exceptionOrNull-impl(r41);     // Catch: Throwable -> L40
        if (r43 == null) goto L36;
        c0 r44 = c0.b;     // Catch: Throwable -> L40
        StringBuilder r119 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r43, "<this>");     // Catch: Throwable -> L40
        r119.append(ExceptionsKt.stackTraceToString(r43));     // Catch: Throwable -> L40
        r44.e("GsonHolder", r119.toString());     // Catch: Throwable -> L40
    L36:
        if (Result.isFailure-impl(r41) == false) goto L38;
    L30:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L40
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ImageStyleListComponent$refreshImageStyleList$1(this, r15);
        goto L8
    }
}
