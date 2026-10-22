package com.larus.uaigc.chat.block.widget.image;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.bmhome.chat.layout.widget.n0;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.service.m3;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.chat.markdown.image.MDImageScrollAdapter;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kc8.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001=\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0001pBÃ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001e\u0010\r\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e\u00122\u0010\u0012\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0013\u0012\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010N\u001a\u00020\u001bH\u0016J\u0010\u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u0017H\u0016J\u0018\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020SH\u0016J\b\u0010U\u001a\u00020\u0019H\u0002J\b\u0010V\u001a\u00020\u0019H\u0002J\u0018\u0010W\u001a\u00020\u00192\u0006\u0010P\u001a\u00020B2\u0006\u0010X\u001a\u00020;H\u0002J\u0010\u0010Y\u001a\u00020;2\u0006\u0010P\u001a\u00020BH\u0002J\u0018\u0010Z\u001a\u00020\u00192\u0006\u0010P\u001a\u00020B2\u0006\u0010[\u001a\u00020;H\u0002J\u000e\u0010\\\u001a\u0004\u0018\u00010\u0015*\u00020BH\u0002J\f\u0010]\u001a\u00020\u0015*\u00020BH\u0002J\u000e\u0010^\u001a\u0004\u0018\u00010_*\u00020BH\u0002J\u0018\u0010`\u001a\u00020\u0015*\u00020B2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010_H\u0002J\u001a\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020SH\u0002J\u0012\u0010d\u001a\u00020\u00192\b\u0010P\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020BH\u0002J\u0012\u0010g\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010h\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010i\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010j\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u0017H\u0002J\b\u0010k\u001a\u00020\u0019H\u0002J\u0016\u0010l\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020o\u0018\u00010n0mH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR<\u0010\u0012\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010%\u001a\u0004\b>\u0010?R\"\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020;2\u0006\u0010A\u001a\u00020;@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00150IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00150IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020M0LX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/image/ImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/uaigc/chat/block/widget/IItemViewBinder;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemMarkdownCreationImageScrollBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "imageEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "videoEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "messageGetter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/larus/im/bean/message/Message;", "", "commonParamGetter", "Lkotlin/Function2;", "", "", "onItemClick", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "", "itemLongClickListenerBinder", "Landroid/view/View;", "<init>", "(Lcom/larus/uaigc/impl/databinding/LarusItemMarkdownCreationImageScrollBinding;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "loadingProgressComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageLoadingProgressComponent;", "getLoadingProgressComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageLoadingProgressComponent;", "loadingProgressComponent$delegate", "Lkotlin/Lazy;", "loadImageComponent", "Lcom/larus/uaigc/chat/markdown/image/component/LoadImageComponent;", "getLoadImageComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/LoadImageComponent;", "loadImageComponent$delegate", "imageOperatorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "getImageOperatorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "imageOperatorComponent$delegate", "imageEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "getImageEditorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "imageEditorComponent$delegate", "videoEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "getVideoEditorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "videoEditorComponent$delegate", "hasRefreshButtons", "", "imageLoadControllerListener", "com/larus/uaigc/chat/block/widget/image/ImageItemViewHolder$imageLoadControllerListener$2$1", "getImageLoadControllerListener", "()Lcom/larus/uaigc/chat/block/widget/image/ImageItemViewHolder$imageLoadControllerListener$2$1;", "imageLoadControllerListener$delegate", "value", "Lcom/larus/uaigc/chat/block/widget/ImageItemData;", "curBindData", "getCurBindData", "()Lcom/larus/uaigc/chat/block/widget/ImageItemData;", "isLoadImageFailed", "()Z", "pendingNoWatermarkImageKeys", "", "keepLoadingUntilImageLoadedKeys", "fallbackNoWatermarkImageTimes", "", "", "getBinderView", "bindData", "data", "updateSize", "width", "", "height", "bindClickListener", "refreshButtons", "showGeneratedImage", "isPreLoading", "shouldHoldNoWatermarkImage", "requestNoWatermarkImage", "keepProgressLoading", "noWatermarkImageKey", "imageLoadKey", "resolveDisplayImageInfo", "Lcom/larus/platform/api/ImageInfo;", "resolveDisplayPreviewUrl", "imageInfo", "buildContainerResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "refreshTips", "initShareDownloadClickAction", "imageData", "refreshImageEditBtn", "refreshCiteBtn", "refreshShareOrDownloadBtn", "showProgressLoading", "showNoWatermarkPlaceholder", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageItemViewHolder extends RecyclerView.ViewHolder implements cz9.g {
    public static final /* synthetic */ int v = 0;
    public final LarusItemMarkdownCreationImageScrollBinding a;
    public final CoroutineScope b;
    public final com.larus.uaigc.chat.markdown.image.component.a c;
    public final com.larus.uaigc.chat.markdown.image.component.k d;
    public final kc8.q e;
    public final Function1<Continuation<? super Message>, Object> f;
    public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> g;
    public final Function2<cz9.b, iy9.b, Unit> h;
    public final Function2<cz9.b, View, Unit> i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public final Lazy p;
    public cz9.h q;
    public boolean r;
    public final Set<String> s;
    public final Set<String> t;
    public final Map<String, Long> u;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ ImageItemViewHolder a;

        public b(ImageItemViewHolder r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            this.a.a.j.setAlpha(1.0f);
            this.a.U3().a(null, null);
            this.a.r = true;
        }

        public final void onIntermediateImageSet(String r2, Object r3) {
            ImageItemViewHolder.T3(this.a);
            super.onIntermediateImageSet(r2, (ImageInfo) r3);
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            this.a.a.j.setAlpha(1.0f);
            this.a.U3().a(null, null);
            ImageItemViewHolder.T3(this.a);
            super.onFinalImageSet(r3, (ImageInfo) r4, r5);
            this.a.r = false;
        }
    }

    public static final class c implements com.larus.uaigc.chat.markdown.image.component.d {
        public final View a;
        public final CoroutineScope b;
        public final Function1<Continuation<? super Message>, Object> c;
        public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> d;

        @Override // com.larus.uaigc.chat.markdown.image.component.d
        public final String getLogTag() {
            return "ImageItemViewHolder";
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.d
        public final View a() {
            return this.a;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.d
        public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> b() {
            return this.d;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.d
        public final Function1<Continuation<? super Message>, Object> c() {
            return this.c;
        }

        public c(ImageItemViewHolder r2) {
            this.a = ((RecyclerView.ViewHolder) r2).itemView;
            this.b = r2.b;
            this.c = r2.f;
            this.d = r2.g;
        }
    }

    public static final class d implements com.larus.uaigc.chat.markdown.image.component.j {
        public final /* synthetic */ ImageItemViewHolder a;

        @Override // com.larus.uaigc.chat.markdown.image.component.j
        public final String getLogTag() {
            return "ImageItemViewHolder";
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.j
        public final String a() {
            cz9.h r0 = this.a.q;
            if (r0 == null) goto L7;
            CreationItem r1 = r0.d;
            if (r1 == null) goto L7;
            return r1.id;
        L7:
            return null;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.j
        public final Message b() {
            cz9.h r0 = this.a.q;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.e;
        }

        public d(ImageItemViewHolder r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // cz9.g
    public final void f() {
    }

    public final com.larus.uaigc.chat.markdown.image.component.c U3() {
        return (com.larus.uaigc.chat.markdown.image.component.c) this.j.getValue();
    }

    @Override // cz9.g
    public final View N0() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public static final void T3(final ImageItemViewHolder r27) {
        if (r27.o == false) goto L5;
        return;
    L5:
        if (r27.a.j.getAlpha() != 1.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L174;
        final cz9.h r2 = r27.q;
        if (r2 == null) goto L171;
        LarusItemMarkdownCreationImageScrollBinding r3 = r27.a;
        boolean r5 = r2.h;
        boolean r6 = r2.g;
        ImageView r7 = r3.g;
        int r8 = 8;
        if (r5 == false) goto L14;
        int r9 = 0;
    L15:
        r7.setVisibility(r9);
        ImageView r10 = r3.d;
        if (r6 == false) goto L18;
        int r11 = 0;
    L19:
        r10.setVisibility(r11);
        if (r6 == true) goto L27;
        if (r5 == false) goto L27;
        ImageView r12 = r3.g;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L26;
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;
        r14.setMarginStart(i5.Y());
        r12.setLayoutParams(r14);
    L31:
        if (r6 == false) goto L41;
        CreationItem r15 = r2.d;
        if (r15 == null) goto L41;
        ImageData r16 = r15.image;
        if (r16 == null) goto L41;
        ImageObj r17 = r16.imageOrigin;
        if (r17 == null) goto L41;
        String r18 = r17.url;
        if (r18 == null) goto L41;
        BuildersKt.launch$default(r27.b, null, null, new ImageItemViewHolder$refreshShareOrDownloadBtn$1$3$1(r18, r3, null), 3, null);
    L41:
        LarusItemMarkdownCreationImageScrollBinding r4 = r27.a;
        e1.d(r4.g, new com.larus.uaigc.chat.block.widget.image.c(r27, r2));
        e1.d(r4.d, new com.larus.uaigc.chat.block.widget.image.d(r27, r2));
        CreationItem r19 = r2.d;
        if (r19 == null) goto L53;
        ImageData r20 = r19.image;
        if (r20 == null) goto L53;
        String r21 = r20.tips;
        if (r21 == null) goto L53;
        if (r21.length() <= 0) goto L50;
        boolean r22 = true;
    L51:
        if (r22 == false) goto L53;
        e1.x(r27.a.h);
        r27.a.i.setText(r21);
        goto L53
    L50:
        r22 = false;
    L53:
        LarusItemMarkdownCreationImageScrollBinding r23 = r27.a;
        if (r2.k == false) goto L56;
        e1.o(r23.c);
    L166:
        if (r2.k == true) goto L168;
        e1.o(r27.a.b);
        goto L171
    L168:
        r27.a.b.setVisibility(0);
        e1.d(r27.a.b, new com.larus.uaigc.chat.block.widget.image.a(r27, r2));
        goto L171
    L56:
        ImageCoverEditView r24 = r23.c;
        if (r2.i == false) goto L59;
    L62:
        boolean r25 = true;
    L63:
        if (r25 == false) goto L65;
        r8 = 0;
    L65:
        r24.setVisibility(r8);
        if (r23.c.getVisibility() != 0) goto L68;
        boolean r26 = true;
    L69:
        if (r26 == false) goto L140;
        ImageView r28 = r23.g;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if (r29 == null) goto L139;
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
        r30.setMarginStart(i5.Y());
        r28.setLayoutParams(r30);
        r23.d.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
        r23.e.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
        r23.g.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
        Message r31 = r2.e;
        if (r31 == null) goto L140;
        String r32 = r31.getMessageId();
        if (r32 == null) goto L140;
        kc8.q r33 = r27.e;
        if (r33 == null) goto L81;
        b0 r34 = r33.k;
        if (r34 == null) goto L81;
        Set r35 = r34.a();
    L82:
        if (r35 != null) goto L84;
    L86:
        boolean r36 = false;
    L87:
        if (r36 == false) goto L140;
        r35.add(r32);
        if (r2.i == false) goto L114;
        Lazy<hy9.d> r37 = MDImageScrollAdapter.MDImageScrollViewHolder.r;
        hy9.d r38 = MDImageScrollAdapter.MDImageScrollViewHolder.a.a();
        String r39 = AppHost.a.getApplication().getString(2131906324);
        com.larus.uaigc.chat.markdown.image.component.a r40 = r27.c;
        if (r40 == null) goto L93;
        String r110 = r40.L();
    L94:
        com.larus.uaigc.chat.markdown.image.component.a r41 = r27.c;
        if (r41 == null) goto L103;
        z0 r42 = r41.P();
        if (r42 == null) goto L103;
        com.larus.bmhome.actionbar.model.r r43 = r42.q;
        if (r43 == null) goto L103;
        Integer r44 = r43.a;
        if (r44 == null) goto L103;
        String r111 = r44.toString();
    L104:
        com.larus.uaigc.chat.markdown.image.component.a r45 = r27.c;
        if (r45 == null) goto L111;
        z0 r46 = r45.P();
        if (r46 == null) goto L111;
        com.larus.bmhome.actionbar.model.r r47 = r46.q;
        if (r47 == null) goto L111;
        String r112 = r47.g;
    L112:
        IAIChatControlTraceService.Companion r48 = IAIChatControlTraceService.a;
        hy9.d.a.b(r38, r39, null, null, "picture_overview", "edit_entrance", r110, null, r111, r112, r48.bb(r48.gb()), Boolean.valueOf(com.larus.im.bean.message.a.C0(r2.e)), tz9.a.a(r2.e), null, null, null, null, null, null, 1044550);
    L111:
        r112 = null;
    L103:
        r111 = null;
        goto L104
    L93:
        r110 = null;
    L114:
        if (r2.j == false) goto L140;
        Lazy<hy9.d> r49 = MDImageScrollAdapter.MDImageScrollViewHolder.r;
        hy9.d r50 = MDImageScrollAdapter.MDImageScrollViewHolder.a.a();
        String r51 = AppHost.a.getApplication().getString(2131906331);
        com.larus.uaigc.chat.markdown.image.component.a r52 = r27.c;
        if (r52 == null) goto L118;
        String r113 = r52.L();
    L119:
        com.larus.uaigc.chat.markdown.image.component.k r53 = r27.d;
        if (r53 == null) goto L128;
        z0 r54 = r53.P();
        if (r54 == null) goto L128;
        com.larus.bmhome.actionbar.model.r r55 = r54.q;
        if (r55 == null) goto L128;
        Integer r56 = r55.a;
        if (r56 == null) goto L128;
        String r114 = r56.toString();
    L129:
        com.larus.uaigc.chat.markdown.image.component.k r57 = r27.d;
        if (r57 == null) goto L136;
        z0 r58 = r57.P();
        if (r58 == null) goto L136;
        com.larus.bmhome.actionbar.model.r r59 = r58.q;
        if (r59 == null) goto L136;
        String r115 = r59.g;
    L137:
        IAIChatControlTraceService.Companion r60 = IAIChatControlTraceService.a;
        hy9.d.a.b(r50, r51, null, null, "picture_overview", "single_function", r113, null, r114, r115, r60.bb(r60.gb()), Boolean.valueOf(com.larus.im.bean.message.a.C0(r2.e)), tz9.a.a(r2.e), null, null, null, null, null, null, 1044550);
    L136:
        r115 = null;
    L128:
        r114 = null;
        goto L129
    L118:
        r113 = null;
        goto L119
    L84:
        if (r35.contains(r32) == true) goto L86;
        r36 = true;
    L81:
        r35 = null;
        goto L82
    L139:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L140:
        boolean r61 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
        ImageCoverEditView r62 = r23.c;
        if (r2.j == false) goto L151;
        Message r63 = r2.e;
        if (r63 != null) goto L145;
    L147:
        boolean r64 = false;
    L148:
        if (r64 == true) goto L151;
        if (r61 == true) goto L151;
        boolean r65 = true;
    L152:
        Boolean r66 = Boolean.valueOf(r65);
        if (r2.i == false) goto L163;
        Message r67 = r2.e;
        if (r67 != null) goto L157;
    L159:
        boolean r68 = false;
    L160:
        if (r68 == true) goto L163;
        if (r61 == true) goto L163;
        boolean r69 = true;
    L164:
        r62.a(new n0(r66, Boolean.valueOf(r69)), new l(r2, r27));
        goto L166
    L157:
        if (com.larus.im.bean.message.a.e0(r67) != true) goto L159;
        r68 = true;
    L163:
        r69 = false;
        goto L164
    L145:
        if (com.larus.im.bean.message.a.e0(r63) != true) goto L147;
        r64 = true;
    L151:
        r65 = false;
        goto L152
    L68:
        r26 = false;
        goto L69
    L59:
        if (r2.j == true) goto L62;
        r25 = false;
        goto L63
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L27:
        ImageView r70 = r3.g;
        ViewGroup.LayoutParams r71 = r70.getLayoutParams();
        if (r71 == null) goto L170;
        ConstraintLayout.LayoutParams r72 = (ConstraintLayout.LayoutParams) r71;
        r72.setMarginStart(0);
        r70.setLayoutParams(r72);
        goto L31
    L170:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L18:
        r11 = 8;
        goto L19
    L14:
        r9 = 8;
    L171:
        r27.o = true;
        return;
    L174:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static String V3(cz9.h r9) {
        String[] r0 = new String[3];
        Message r1 = r9.e;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getMessageId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0[0] = r3;
        CreationItem r5 = r9.d;
        if (r5 == null) goto L12;
        r2 = r5.id;
    L12:
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r0[1] = r2;
        String r10 = W3(r9);
        if (r10 == null) goto L18;
        r4 = r10;
    L18:
        r0[2] = r4;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), "#", null, null, 0, null, null, 62, null);
    L5:
        r3 = null;
        goto L6
    }

    public static String W3(cz9.h r1) {
        CreationItem r2 = r1.d;
        if (r2 == null) goto L8;
        ImageData r0 = r2.image;
        if (r0 == null) goto L8;
        String r3 = r0.imageUri;
        if (r3 == null) goto L8;
        return r3;
    L8:
        if (r2 == null) goto L12;
        ImageData r4 = r2.image;
        if (r4 == null) goto L12;
        return r4.key;
    L12:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.larus.platform.api.ImageInfo X3(cz9.h r5) {
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        String r1 = W3(r5);
        CreationItem r2 = r5.d;
        if (r2 == null) goto L7;
        ImageData r4 = r2.image;
        if (r4 == null) goto L7;
        com.larus.platform.api.ImageInfo r3 = bz9.a.j(r4, r2.genDetail);
    L8:
        com.larus.platform.api.ImageInfo r6 = (com.larus.platform.api.ImageInfo) r0.U(r1, r3, true).a;
        if (r6 != null) goto L16;
        CreationItem r7 = r5.d;
        if (r7 == null) goto L17;
        ImageData r8 = r7.image;
        if (r8 != null) goto L19;
        return null;
    L19:
        return bz9.a.j(r8, r7.genDetail);
    L17:
        return null;
    L16:
        return r6;
    L7:
        r3 = null;
        goto L8
    }

    public final void Z3(cz9.h r4) {
        e1.o(this.a.j);
        com.larus.uaigc.chat.markdown.image.component.c r0 = U3();
        CreationItem r1 = r4.d;
        if (r1 == null) goto L5;
        String r2 = r1.id;
    L6:
        r0.a(r2, r4.e);
        Message r3 = r4.e;
        if (r3 == null) goto L18;
        CreationItem r5 = r4.d;
        if (r5 == null) goto L19;
        String r6 = r5.id;
        if (r6 == null) goto L20;
        nq9.f r7 = m3.a.o();
        if (r7 == null) goto L21;
        OldUgcGenImgPerfMonitor r8 = r7.a(true);
        if (r8 == null) goto L22;
        r8.e(r3, r6);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // cz9.g
    public final void p2(cz9.b r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        String r1 = null;
        if ((r15 instanceof cz9.h) == false) goto L5;
        cz9.h r16 = (cz9.h) r15;
    L6:
        if (r16 != null) goto L8;
        return;
    L8:
        cz9.h r0 = this.q;
        if (r0 == null) goto L13;
        CreationItem r2 = r0.d;
        if (r2 == null) goto L13;
        String r3 = r2.id;
    L14:
        CreationItem r4 = r16.d;
        if (r4 == null) goto L17;
        String r5 = r4.id;
    L19:
        if (Intrinsics.areEqual(r3, r5) == false) goto L35;
        cz9.h r6 = this.q;
        if (r6 == null) goto L32;
        CreationItem r7 = r6.d;
        if (r7 == null) goto L32;
        ImageData r8 = r7.image;
        if (r8 == null) goto L32;
        Integer r9 = r8.status;
        if (r9 == null) goto L32;
        if (r9.intValue() != 1) goto L32;
        boolean r10 = true;
    L33:
        if (r10 == false) goto L35;
        boolean r11 = true;
    L36:
        this.q = r16;
        this.r = false;
        this.o = false;
        e1.o(this.a.h);
        e1.o(this.a.g);
        e1.o(this.a.d);
        e1.o(this.a.e);
        e1.o(this.a.b);
        e1.o(this.a.c);
        updateSize(r16.b, r16.c);
        CreationItem r12 = r16.d;
        if (r12 == null) goto L41;
        ImageData r13 = r12.image;
        if (r13 == null) goto L41;
        Integer r14 = r13.status;
    L42:
        if (r14 != null) goto L45;
    L47:
        if (r14 != null) goto L50;
    L146:
        final cz9.h r17 = this.q;
        if (r17 == null) goto L150;
        e1.d(((RecyclerView.ViewHolder) this).itemView, new e(this, r17));
        this.i.invoke(r17, ((RecyclerView.ViewHolder) this).itemView);
        return;
    L150:
        return;
    L50:
        if (r14.intValue() != 2) goto L146;
        String r18 = W3(r16);
        if (r18 != null) goto L54;
    L65:
        boolean r19 = false;
    L67:
        if (r19 == false) goto L90;
        if (r11 == false) goto L70;
        Z3(r16);
    L71:
        String r20 = W3(r16);
        if (r20 == null) goto L146;
        if ((true ^ StringsKt.isBlank(r20)) == false) goto L76;
        String r21 = r20;
    L77:
        if (r21 == null) goto L146;
        if (this.s.add(r21) == false) goto L146;
        Message r22 = r16.e;
        if (r22 == null) goto L85;
        String r23 = r22.getMessageId();
    L86:
        CreationItem r110 = r16.d;
        if (r110 == null) goto L89;
        r1 = r110.id;
    L89:
        BuildersKt.launch$default(this.b, null, null, new ImageItemViewHolder$requestNoWatermarkImage$1(this, r21, r23, r1, r11, null), 3, null);
        goto L146
    L85:
        r23 = null;
        goto L86
    L76:
        r21 = null;
        goto L77
    L70:
        e1.x(this.a.j);
        this.a.j.setAlpha(1.0f);
        ImageLoaderKt.b(this.a.j);
        LarusItemMarkdownCreationImageScrollBinding r24 = this.a;
        r24.j.setBackgroundColor(ContextCompat.getColor(r24.a.getContext(), v19.c.b(2130972086, this.a.a.getContext(), 2131103159)));
        U3().a(null, null);
        goto L71
    L90:
        if (r11 == false) goto L92;
    L95:
        boolean r25 = true;
    L96:
        e1.x(this.a.j);
        if (r25 == false) goto L99;
        this.a.j.setAlpha(0.0f);
    L100:
        com.larus.platform.api.ImageInfo r26 = X3(r16);
        String r27 = Y3(r16, r26);
        if (r27.length() != 0) goto L103;
        boolean r28 = true;
    L104:
        if (r28 == false) goto L106;
        FLogger.a.i("ImageItemViewHolder", " bindData error imageUrl is empty");
    L106:
        Uri r111 = com.larus.image.loader.b0.a(r27, "creation_block_image_preview", false, false, 6);
        if (r26 == null) goto L111;
        Image r29 = r26.b;
        if (r29 == null) goto L111;
        String r30 = bz9.a.b(r29);
    L112:
        String r31 = "";
        if (r30 != null) goto L116;
        r30 = "";
    L116:
        if (r30.length() != 0) goto L118;
        boolean r32 = true;
    L119:
        if (r32 == false) goto L131;
        CreationItem r33 = r16.d;
        if (r33 == null) goto L125;
        ImageData r34 = r33.image;
        if (r34 == null) goto L125;
        String r35 = bz9.a.c(r34);
    L126:
        if (r35 == null) goto L129;
        r31 = r35;
    L129:
        r30 = r31;
    L125:
        r35 = null;
    L131:
        if (r30.length() <= 0) goto L133;
        boolean r36 = true;
    L134:
        if (r36 == true) goto L137;
        r30 = null;
    L137:
        if (r30 == null) goto L139;
        Uri r37 = com.larus.image.loader.b0.a(r30, "creation_block_image_thumb", false, false, 6);
    L140:
        com.larus.uaigc.chat.markdown.image.component.i r38 = (com.larus.uaigc.chat.markdown.image.component.i) this.k.getValue();
        SimpleDraweeView r39 = this.a.j;
        b r112 = (b) this.p.getValue();
        int r40 = r16.b;
        int r113 = r16.c;
        if (r40 <= 1) goto L145;
        if (r113 <= 1) goto L145;
        r1 = new ResizeOptions(r40, r113);
    L145:
        r38.d(r39, r37, r111, "creation_block_image_thumb", r112, r1);
        goto L146
    L139:
        r37 = null;
        goto L140
    L133:
        r36 = false;
        goto L134
    L118:
        r32 = false;
    L111:
        r30 = null;
        goto L112
    L103:
        r28 = false;
        goto L104
    L99:
        this.a.j.setAlpha(1.0f);
        U3().a(null, null);
        goto L100
    L92:
        if (this.t.remove(V3(r16)) == true) goto L95;
        r25 = false;
        goto L96
    L54:
        if ((!StringsKt.isBlank(r18)) == true) goto L57;
        r18 = null;
    L57:
        if (r18 == null) goto L65;
        Long r41 = (Long) ((LinkedHashMap) this.u).get(r18);
        if (r41 != null) goto L62;
    L64:
        r19 = CreationNoWatermarkManager.a.k0(r18);
        goto L67
    L62:
        if ((System.currentTimeMillis() - r41.longValue()) >= 10000) goto L64;
    L45:
        if (r14.intValue() != 1) goto L47;
        Z3(r16);
    L41:
        r14 = null;
    L32:
        r10 = false;
    L35:
        r11 = false;
        goto L36
    L17:
        r5 = null;
    L13:
        r3 = null;
        goto L14
    L5:
        r16 = null;
        goto L6
    }

    public static String Y3(cz9.h r6, com.larus.platform.api.ImageInfo r7) {
        String r0 = null;
        if (r7 == null) goto L7;
        Image r1 = r7.c;
        if (r1 == null) goto L7;
        String r2 = bz9.a.b(r1);
    L8:
        String r3 = "";
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        boolean r4 = false;
        if (r2.length() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L24;
        if (r7 == null) goto L20;
        Image r8 = r7.b;
        if (r8 == null) goto L20;
        r2 = bz9.a.b(r8);
    L21:
        if (r2 != null) goto L24;
        r2 = "";
    L20:
        r2 = null;
    L24:
        if (r2.length() != 0) goto L26;
        r4 = true;
    L26:
        if (r4 == false) goto L37;
        CreationItem r9 = r6.d;
        if (r9 == null) goto L32;
        ImageData r10 = r9.image;
        if (r10 == null) goto L32;
        r0 = bz9.a.c(r10);
    L32:
        if (r0 == null) goto L36;
        r3 = r0;
    L36:
        return r3;
    L37:
        return r2;
    L14:
        r5 = false;
    L7:
        r2 = null;
        goto L8
    }

    @Override // cz9.g
    public final void updateSize(int r3, int r4) {
        ConstraintLayout r0 = this.a.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        r1.width = r3;
        r1.height = r4;
        r0.setLayoutParams(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageItemViewHolder(LarusItemMarkdownCreationImageScrollBinding r2, CoroutineScope r3, com.larus.uaigc.chat.markdown.image.component.a r4, com.larus.uaigc.chat.markdown.image.component.k r5, kc8.q r6, Function1<? super Continuation<? super Message>, ? extends Object> r7, Function2<? super Message, ? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> r8, Function2<? super cz9.b, ? super iy9.b, Unit> r9, Function2<? super cz9.b, ? super View, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r7, "messageGetter");
        Intrinsics.checkNotNullParameter(r8, "commonParamGetter");
        Intrinsics.checkNotNullParameter(r9, "onItemClick");
        Intrinsics.checkNotNullParameter(r10, "itemLongClickListenerBinder");
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
        LazyThreadSafetyMode r11 = LazyThreadSafetyMode.NONE;
        this.j = LazyKt.lazy(r11, new f(this));
        this.k = LazyKt.lazy(r11, new g(this));
        this.l = LazyKt.lazy(r11, new h(this));
        this.m = LazyKt.lazy(r11, new i(this));
        this.n = LazyKt.lazy(r11, new j(this));
        this.p = LazyKt.lazy(r11, new k(this));
        this.s = new LinkedHashSet();
        this.t = new LinkedHashSet();
        this.u = new LinkedHashMap();
    }
}
