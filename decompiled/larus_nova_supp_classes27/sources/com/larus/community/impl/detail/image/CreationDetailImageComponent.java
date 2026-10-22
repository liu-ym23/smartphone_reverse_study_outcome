package com.larus.community.impl.detail.image;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.common.apphost.AppHost;
import com.larus.community.impl.detail.c0;
import com.larus.community.impl.detail.f0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.IBachService;
import com.larus.platform.api.creation.PreLoadScene;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 42\u00060\u0001j\u0002`\u00022\u00020\u0003:\u00014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0007H\u0002J \u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0082@¢\u0006\u0002\u00103R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationDetailImageComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "<init>", "()V", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "Lkotlin/Lazy;", "creationDetailBottomToolsAbility", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "getCreationDetailBottomToolsAbility", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "creationDetailBottomToolsAbility$delegate", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "creationDetailFragmentAbility", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "getCreationDetailFragmentAbility", "()Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "creationDetailFragmentAbility$delegate", "digitalAvatarBachAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "onAttach", "", "onDestroy", "getImageView", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "containerView", "Lcom/larus/community/impl/detail/image/CreationDetailImageView;", "bindView", "creationDetailImageView", "initObserver", "creation", "detectCreationImage", "getBitmapFromRemoteUrl", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailImageComponent extends ComponentFeature implements d {
    public static final /* synthetic */ int n = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public zp9.i l;
    public CreationDetailImageView m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.community.impl.detail.image.d
    public final CreationZoomableDraweeView Jp() {
        CreationDetailImageView r0 = this.m;
        if ((r0 instanceof CreationDetailImageView) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getImageView();
    }

    public final void onDestroy() {
        zp9.i r0 = this.l;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, d.class);
        if (z2.a.enableClientAvatarDetectAlgorithm() == false) goto L19;
        IBachService r0 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r0 == null) goto L7;
        zp9.i r1 = r0.a();
    L8:
        this.l = r1;
        IBachService r2 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r2 == null) goto L13;
        MutableLiveData r3 = r2.b();
        if (r3 == null) goto L13;
        boolean r4 = Intrinsics.areEqual(r3.getValue(), Boolean.TRUE);
    L14:
        if (r4 == true) goto L20;
        IBachService r5 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r5 == null) goto L21;
        r5.c(PreLoadScene.DIGITAL_AVTAR);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r4 = false;
        goto L14
    L7:
        r1 = null;
        goto L8
    }

    public CreationDetailImageComponent() {
        this.h = LazyKt.lazy(new e(this));
        this.i = LazyKt.lazy(new f(this));
        this.j = LazyKt.lazy(new g(this));
        this.k = LazyKt.lazy(new h(this));
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, android.view.ViewGroup, com.larus.community.impl.detail.image.CreationDetailImageView] */
    public final void L2(UserCreation r14) {
        String r0 = r14.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L80:
        ConstraintLayout r15 = this.m;
        if (r15 == null) goto L90;
        e1.o(r15);
        return;
    L90:
        return;
    L10:
        if (CollectionsKt.listOf(new Integer[]{2, 5, 3, 4}).contains(Integer.valueOf(r14.b)) == false) goto L80;
        final ?? r3 = this.m;
        if (r3 == 0) goto L86;
        e1.x(r3);
        c0 r4 = (c0) this.k.getValue();
        if (r4 != null) goto L16;
    L18:
        r1 = false;
    L19:
        Intrinsics.checkNotNullParameter(r14, "userCreation");
        String r5 = null;
        if (r1 == false) goto L38;
        Image r6 = r14.i();
        if (r6 == null) goto L24;
        Long r7 = Long.valueOf(r6.c);
    L25:
        Image r8 = r14.i();
        if (r8 == null) goto L28;
        Long r9 = Long.valueOf(r8.d);
    L29:
        Pair r10 = new Pair(r7, r9);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(Float.valueOf(((Number) r10.first).floatValue() / ((Number) r10.second).longValue()));     // Catch: Throwable -> L32
    L34:
        Float r13 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r12) == false) goto L37;
        r12 = r13;
    L37:
        float r16 = ((Number) r12).floatValue();
        int r17 = f0.a;
        r3.a.b.getLayoutParams().height = f0.a(r3.getContext(), r16);
        r3.a.b.requestLayout();
    L39:
        Intrinsics.checkNotNullParameter(r14, "userCreation");
        Image r18 = r14.i();
        if (r18 == null) goto L42;
        String r20 = r18.a;
    L43:
        Uri r21 = b0.a(r20, "community_creation_detail_preview", false, false, 6);
        z2 r22 = z2.a;
        if (r22.creationFeedThumbRatioLimit43() == true) goto L46;
    L48:
        Uri r23 = b0.a(r14.r(), "community_creation_detail_thumb", false, false, 6);
    L49:
        if (r21 == null) goto L54;
        if (r23 == null) goto L52;
        final ImageRequest r24 = ImageRequestBuilder.newBuilderWithSource(r23).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build()).build();
    L53:
        r3.a.c.setTag(2131377234, r21);
        ImageLoaderKt.x(r3.a.c, r21, null, null, new l(r24, r3), 6);
        r3.a.c.setOnLongClickListener(new m(r3));
        r3.a.c.setOnDoubleTapListener(new o(r3));
        goto L54
    L52:
        r24 = null;
    L54:
        Function0<Unit> r25 = new i(this);
        Function0<Unit> r26 = new j(this);
        r3.b = r25;
        r3.c = null;
        r3.d = r26;
        if (r22.enableClientAvatarDetectAlgorithm() == true) goto L57;
        return;
    L57:
        if (r14.b == 3) goto L74;
        CreationDynamicInfo r27 = r14.h;
        if (r27 == null) goto L63;
        TplInfo r28 = r27.e;
        if (r28 == null) goto L63;
        String r30 = r28.a;
    L65:
        if (Intrinsics.areEqual(r30, "ai_replica") == true) goto L74;
        CreationDynamicInfo r31 = r14.h;
        if (r31 == null) goto L71;
        TplInfo r32 = r31.e;
        if (r32 == null) goto L71;
        String r33 = r32.a;
    L73:
        if (Intrinsics.areEqual(r33, "menu") == true) goto L74;
        return;
    L71:
        r33 = null;
    L63:
        r30 = null;
    L74:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CreationDetailImageComponent$detectCreationImage$1(r14, this, null), 2, null);
        FLogger r34 = FLogger.a;
        StringBuilder r35 = new StringBuilder("detectCreationImage, userCreationType:");
        r35.append(r14.b);
        r35.append(", tplType:");
        CreationDynamicInfo r110 = r14.h;
        if (r110 == null) goto L79;
        TplInfo r111 = r110.e;
        if (r111 == null) goto L79;
        r5 = r111.a;
    L79:
        r35.append(r5);
        r34.i("CreationDetailImageComponent", r35.toString());
        return;
    L46:
        if (AppHost.a.isOversea() == true) goto L48;
        r23 = b0.a(r14.s(), "community_creation_detail_thumb", false, false, 6);
        goto L49
    L42:
        r20 = null;
    L32:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L28:
        r9 = null;
        goto L29
    L24:
        r7 = null;
        goto L25
    L38:
        r3.a.b.getLayoutParams().height = (int) RangesKt.coerceAtMost(c7.b(600), RangesKt.coerceAtMost(r3.f * 0.7f, (r3.e * 4.0f) / 3));
        r3.a.b.requestLayout();
        goto L39
    L16:
        if (r4.ak() != true) goto L18;
    L86:
        return;
    L5:
        if (o0.d(r0) != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.community.impl.detail.image.d
    public final void P9(CreationDetailImageView r9) {
        Intrinsics.checkNotNullParameter(r9, "creationDetailImageView");
        this.m = r9;
        if (r9 == 0) goto L5;
        e1.o(r9);
    L5:
        j29.c r10 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r10 == null) goto L8;
        UserCreation r11 = r10.a;
    L9:
        if (r11 == null) goto L15;
        CreationDetailImageView r1 = this.m;
        if (r1 == null) goto L13;
        L2(r11);
    L14:
        if (r1 == null) goto L15;
        return;
    L13:
        r1 = null;
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailImageComponent$initObserver$1(this, null), 3, null);
        Unit r12 = Unit.INSTANCE;
        return;
    L8:
        r11 = null;
        goto L9
    }

    public static final Object F2(CreationDetailImageComponent r4, String r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof CreationDetailImageComponent$getBitmapFromRemoteUrl$1) == false) goto L7;
        CreationDetailImageComponent$getBitmapFromRemoteUrl$1 r0 = (CreationDetailImageComponent$getBitmapFromRemoteUrl$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Bitmap r9 = (Bitmap) r7;
        if (r9 == null) goto L20;
        return r9;
    L20:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        CreationDetailImageComponent$getBitmapFromRemoteUrl$bitmap$1 r3 = new CreationDetailImageComponent$getBitmapFromRemoteUrl$bitmap$1(r5, null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r10, r3, r0);
        if (r7 != r8) goto L17;
        return r8;
    L7:
        r0 = new CreationDetailImageComponent$getBitmapFromRemoteUrl$1(r4, r6);
        goto L8
    }
}
