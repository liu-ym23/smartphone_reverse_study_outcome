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
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.chat.markdown.image.MDImageScrollAdapter;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.Set;
import kc8.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001=\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]BÃ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001e\u0010\r\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e\u00122\u0010\u0012\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0013\u0012\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010H\u001a\u00020\u001bH\u0016J\u0010\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u0017H\u0016J\u0018\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020MH\u0016J\b\u0010O\u001a\u00020\u0019H\u0002J\b\u0010P\u001a\u00020\u0019H\u0002J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010J\u001a\u00020BH\u0002J\u001a\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020MH\u0002J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020BH\u0002J\u0012\u0010V\u001a\u00020\u00192\b\u0010U\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010W\u001a\u00020\u00192\b\u0010U\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010X\u001a\u00020\u00192\b\u0010U\u001a\u0004\u0018\u00010BH\u0002J\u0016\u0010Y\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\\\u0018\u00010[0ZH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR<\u0010\u0012\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010%\u001a\u0004\b>\u0010?R\"\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020;2\u0006\u0010A\u001a\u00020;@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006^"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/image/LocalImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/uaigc/chat/block/widget/IItemViewBinder;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemMarkdownCreationImageScrollBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "imageEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "videoEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "messageGetter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/larus/im/bean/message/Message;", "", "commonParamGetter", "Lkotlin/Function2;", "", "", "onItemClick", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "", "itemLongClickListenerBinder", "Landroid/view/View;", "<init>", "(Lcom/larus/uaigc/impl/databinding/LarusItemMarkdownCreationImageScrollBinding;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "loadingProgressComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageLoadingProgressComponent;", "getLoadingProgressComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageLoadingProgressComponent;", "loadingProgressComponent$delegate", "Lkotlin/Lazy;", "loadImageComponent", "Lcom/larus/uaigc/chat/markdown/image/component/LoadImageComponent;", "getLoadImageComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/LoadImageComponent;", "loadImageComponent$delegate", "imageOperatorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "getImageOperatorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "imageOperatorComponent$delegate", "imageEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "getImageEditorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "imageEditorComponent$delegate", "videoEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "getVideoEditorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "videoEditorComponent$delegate", "hasRefreshButtons", "", "imageLoadControllerListener", "com/larus/uaigc/chat/block/widget/image/LocalImageItemViewHolder$imageLoadControllerListener$2$1", "getImageLoadControllerListener", "()Lcom/larus/uaigc/chat/block/widget/image/LocalImageItemViewHolder$imageLoadControllerListener$2$1;", "imageLoadControllerListener$delegate", "value", "Lcom/larus/uaigc/chat/block/widget/LocalImageItemData;", "curBindData", "getCurBindData", "()Lcom/larus/uaigc/chat/block/widget/LocalImageItemData;", "isLoadImageFailed", "()Z", "getBinderView", "bindData", "data", "updateSize", "width", "", "height", "bindClickListener", "refreshButtons", "showLocalImage", "buildContainerResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "initShareDownloadClickAction", "imageData", "refreshImageEditBtn", "refreshCiteBtn", "refreshShareOrDownloadBtn", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LocalImageItemViewHolder extends RecyclerView.ViewHolder implements cz9.g {
    public static final /* synthetic */ int s = 0;
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
    public cz9.m q;
    public boolean r;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ LocalImageItemViewHolder a;

        public b(LocalImageItemViewHolder r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            this.a.a.j.setAlpha(1.0f);
            ((com.larus.uaigc.chat.markdown.image.component.c) this.a.j.getValue()).a(null, null);
            this.a.r = true;
        }

        public final void onIntermediateImageSet(String r2, Object r3) {
            LocalImageItemViewHolder.T3(this.a);
            super.onIntermediateImageSet(r2, (ImageInfo) r3);
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            this.a.a.j.setAlpha(1.0f);
            ((com.larus.uaigc.chat.markdown.image.component.c) this.a.j.getValue()).a(null, null);
            LocalImageItemViewHolder.T3(this.a);
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
            return "LocalImageItemViewHolder";
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

        public c(LocalImageItemViewHolder r2) {
            this.a = ((RecyclerView.ViewHolder) r2).itemView;
            this.b = r2.b;
            this.c = r2.f;
            this.d = r2.g;
        }
    }

    public static final class d implements com.larus.uaigc.chat.markdown.image.component.j {
        public final /* synthetic */ LocalImageItemViewHolder a;

        @Override // com.larus.uaigc.chat.markdown.image.component.j
        public final String getLogTag() {
            return "LocalImageItemViewHolder";
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.j
        public final String a() {
            cz9.m r0 = this.a.q;
            if (r0 == null) goto L7;
            CreationItem r1 = r0.d;
            if (r1 == null) goto L7;
            return r1.id;
        L7:
            return null;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.j
        public final Message b() {
            cz9.m r0 = this.a.q;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.e;
        }

        public d(LocalImageItemViewHolder r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // cz9.g
    public final void f() {
    }

    @Override // cz9.g
    public final View N0() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public static final void T3(final LocalImageItemViewHolder r27) {
        if (r27.o == false) goto L5;
        return;
    L5:
        if (r27.a.j.getAlpha() != 1.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L180;
        final cz9.m r2 = r27.q;
        if (r2 == null) goto L177;
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
        com.larus.platform.api.ImageInfo r16 = bz9.c.o(r15);
        if (r16 == null) goto L41;
        Image r17 = r16.a;
        if (r17 == null) goto L41;
        String r18 = bz9.a.b(r17);
        if (r18 == null) goto L41;
        BuildersKt.launch$default(r27.b, null, null, new LocalImageItemViewHolder$refreshShareOrDownloadBtn$1$3$1(r18, r3, null), 3, null);
    L41:
        LarusItemMarkdownCreationImageScrollBinding r4 = r27.a;
        CreationItem r19 = r2.d;
        if (r19 == null) goto L44;
        final com.larus.platform.api.ImageInfo r20 = bz9.c.o(r19);
    L45:
        e1.d(r4.g, new q(r27, r20, r2));
        e1.d(r4.d, new r(r27, r20, r2));
        CreationItem r21 = r2.d;
        if (r21 == null) goto L56;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Integer r22 = r21.type;
        if (r22 != null) goto L51;
    L53:
        boolean r23 = false;
    L54:
        if (r23 != true) goto L56;
        boolean r24 = true;
    L57:
        if (r24 == false) goto L59;
        e1.o(r27.a.c);
    L172:
        if (r2.k == true) goto L174;
        e1.o(r27.a.b);
        goto L177
    L174:
        r27.a.b.setVisibility(0);
        e1.d(r27.a.b, new n(r27, r2));
        goto L177
    L59:
        LarusItemMarkdownCreationImageScrollBinding r25 = r27.a;
        if (r2.k == false) goto L62;
        e1.o(r25.c);
        goto L172
    L62:
        ImageCoverEditView r26 = r25.c;
        if (r2.i == false) goto L65;
    L68:
        boolean r28 = true;
    L69:
        if (r28 == false) goto L71;
        r8 = 0;
    L71:
        r26.setVisibility(r8);
        if (r25.c.getVisibility() != 0) goto L74;
        boolean r29 = true;
    L75:
        if (r29 == false) goto L146;
        ImageView r30 = r25.g;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L145;
        ConstraintLayout.LayoutParams r32 = (ConstraintLayout.LayoutParams) r31;
        r32.setMarginStart(i5.Y());
        r30.setLayoutParams(r32);
        r25.d.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
        r25.e.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
        r25.g.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
        Message r33 = r2.e;
        if (r33 == null) goto L146;
        String r34 = r33.getMessageId();
        if (r34 == null) goto L146;
        kc8.q r35 = r27.e;
        if (r35 == null) goto L87;
        b0 r36 = r35.k;
        if (r36 == null) goto L87;
        Set r37 = r36.a();
    L88:
        if (r37 != null) goto L90;
    L92:
        boolean r38 = false;
    L93:
        if (r38 == false) goto L146;
        r37.add(r34);
        if (r2.i == false) goto L120;
        Lazy<hy9.d> r39 = MDImageScrollAdapter.MDImageScrollViewHolder.r;
        hy9.d r40 = MDImageScrollAdapter.MDImageScrollViewHolder.a.a();
        String r41 = AppHost.a.getApplication().getString(2131906324);
        com.larus.uaigc.chat.markdown.image.component.a r42 = r27.c;
        if (r42 == null) goto L99;
        String r110 = r42.L();
    L100:
        com.larus.uaigc.chat.markdown.image.component.a r43 = r27.c;
        if (r43 == null) goto L109;
        z0 r44 = r43.P();
        if (r44 == null) goto L109;
        com.larus.bmhome.actionbar.model.r r45 = r44.q;
        if (r45 == null) goto L109;
        Integer r46 = r45.a;
        if (r46 == null) goto L109;
        String r111 = r46.toString();
    L110:
        com.larus.uaigc.chat.markdown.image.component.a r47 = r27.c;
        if (r47 == null) goto L117;
        z0 r48 = r47.P();
        if (r48 == null) goto L117;
        com.larus.bmhome.actionbar.model.r r49 = r48.q;
        if (r49 == null) goto L117;
        String r112 = r49.g;
    L118:
        IAIChatControlTraceService.Companion r50 = IAIChatControlTraceService.a;
        hy9.d.a.b(r40, r41, null, null, "picture_overview", "edit_entrance", r110, null, r111, r112, r50.bb(r50.gb()), Boolean.valueOf(com.larus.im.bean.message.a.C0(r2.e)), tz9.a.a(r2.e), null, null, null, null, null, null, 1044550);
    L117:
        r112 = null;
    L109:
        r111 = null;
        goto L110
    L99:
        r110 = null;
    L120:
        if (r2.j == false) goto L146;
        Lazy<hy9.d> r51 = MDImageScrollAdapter.MDImageScrollViewHolder.r;
        hy9.d r52 = MDImageScrollAdapter.MDImageScrollViewHolder.a.a();
        String r53 = AppHost.a.getApplication().getString(2131906331);
        com.larus.uaigc.chat.markdown.image.component.a r54 = r27.c;
        if (r54 == null) goto L124;
        String r113 = r54.L();
    L125:
        com.larus.uaigc.chat.markdown.image.component.k r55 = r27.d;
        if (r55 == null) goto L134;
        z0 r56 = r55.P();
        if (r56 == null) goto L134;
        com.larus.bmhome.actionbar.model.r r57 = r56.q;
        if (r57 == null) goto L134;
        Integer r58 = r57.a;
        if (r58 == null) goto L134;
        String r114 = r58.toString();
    L135:
        com.larus.uaigc.chat.markdown.image.component.k r59 = r27.d;
        if (r59 == null) goto L142;
        z0 r60 = r59.P();
        if (r60 == null) goto L142;
        com.larus.bmhome.actionbar.model.r r61 = r60.q;
        if (r61 == null) goto L142;
        String r115 = r61.g;
    L143:
        IAIChatControlTraceService.Companion r62 = IAIChatControlTraceService.a;
        hy9.d.a.b(r52, r53, null, null, "picture_overview", "single_function", r113, null, r114, r115, r62.bb(r62.gb()), Boolean.valueOf(com.larus.im.bean.message.a.C0(r2.e)), tz9.a.a(r2.e), null, null, null, null, null, null, 1044550);
    L142:
        r115 = null;
    L134:
        r114 = null;
        goto L135
    L124:
        r113 = null;
        goto L125
    L90:
        if (r37.contains(r34) == true) goto L92;
        r38 = true;
    L87:
        r37 = null;
        goto L88
    L145:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L146:
        boolean r63 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
        ImageCoverEditView r64 = r25.c;
        if (r2.j == false) goto L157;
        Message r65 = r2.e;
        if (r65 != null) goto L151;
    L153:
        boolean r66 = false;
    L154:
        if (r66 == true) goto L157;
        if (r63 == true) goto L157;
        boolean r67 = true;
    L158:
        Boolean r68 = Boolean.valueOf(r67);
        if (r2.i == false) goto L169;
        Message r69 = r2.e;
        if (r69 != null) goto L163;
    L165:
        boolean r70 = false;
    L166:
        if (r70 == true) goto L169;
        if (r63 == true) goto L169;
        boolean r71 = true;
    L170:
        r64.a(new n0(r68, Boolean.valueOf(r71)), new y(r2, r27));
        goto L172
    L163:
        if (com.larus.im.bean.message.a.e0(r69) != true) goto L165;
        r70 = true;
    L169:
        r71 = false;
        goto L170
    L151:
        if (com.larus.im.bean.message.a.e0(r65) != true) goto L153;
        r66 = true;
    L157:
        r67 = false;
        goto L158
    L74:
        r29 = false;
        goto L75
    L65:
        if (r2.j == true) goto L68;
        r28 = false;
        goto L69
    L51:
        if (r22.intValue() != 3) goto L53;
        r23 = true;
    L56:
        r24 = false;
        goto L57
    L44:
        r20 = null;
        goto L45
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L27:
        ImageView r72 = r3.g;
        ViewGroup.LayoutParams r73 = r72.getLayoutParams();
        if (r73 == null) goto L176;
        ConstraintLayout.LayoutParams r74 = (ConstraintLayout.LayoutParams) r73;
        r74.setMarginStart(0);
        r72.setLayoutParams(r74);
        goto L31
    L176:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L18:
        r11 = 8;
        goto L19
    L14:
        r9 = 8;
    L177:
        r27.o = true;
        return;
    L180:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // cz9.g
    public final void p2(cz9.b r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        ResizeOptions r1 = null;
        if ((r15 instanceof cz9.m) == false) goto L5;
        cz9.m r16 = (cz9.m) r15;
    L6:
        if (r16 != null) goto L8;
        return;
    L8:
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
        CreationItem r2 = r16.d;
        if (r2 == null) goto L19;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Integer r3 = r2.type;
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 != true) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L54;
        e1.x(this.a.j);
        this.a.j.setAlpha(1.0f);
        ((com.larus.uaigc.chat.markdown.image.component.c) this.j.getValue()).a(null, null);
        CreationItem r6 = r16.d;
        if (r6 == null) goto L28;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        LocalImageData r7 = r6.localImage;
        if (r7 == null) goto L28;
        String r8 = bz9.c.l(r7);
        if (r8 != null) goto L29;
        r8 = bz9.c.k(r7);
    L29:
        if (r8 != null) goto L31;
    L34:
        boolean r9 = true;
    L35:
        if (r9 == false) goto L37;
        FLogger.a.i("LocalImageItemViewHolder", " bindData error local imageUrl is empty");
    L37:
        Uri r10 = com.larus.image.loader.b0.a(r8, "creation_block_image_preview", false, false, 6);
        CreationItem r11 = r16.d;
        if (r11 == null) goto L47;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        LocalImageData r12 = r11.localImage;
        if (r12 == null) goto L44;
        String r13 = bz9.c.l(r12);
        if (r13 != null) goto L45;
        r13 = bz9.c.k(r12);
    L45:
        if (r13 == null) goto L47;
        Uri r14 = com.larus.image.loader.b0.a(r13, "creation_block_image_thumb", false, false, 6);
    L48:
        com.larus.uaigc.chat.markdown.image.component.i r17 = (com.larus.uaigc.chat.markdown.image.component.i) this.k.getValue();
        SimpleDraweeView r18 = this.a.j;
        b r19 = (b) this.p.getValue();
        int r0 = r16.b;
        int r110 = r16.c;
        if (r0 <= 1) goto L53;
        if (r110 <= 1) goto L53;
        r1 = new ResizeOptions(r0, r110);
    L53:
        r17.d(r18, r14, r10, "creation_block_image_thumb", r19, r1);
        goto L54
    L44:
        r13 = null;
    L47:
        r14 = null;
        goto L48
    L31:
        if (r8.length() == 0) goto L34;
        r9 = false;
    L28:
        r8 = null;
    L54:
        final cz9.m r111 = this.q;
        if (r111 == null) goto L58;
        e1.d(((RecyclerView.ViewHolder) this).itemView, new p(this, r111));
        this.i.invoke(r111, ((RecyclerView.ViewHolder) this).itemView);
        return;
    L58:
        return;
    L14:
        if (r3.intValue() != 3) goto L16;
        r4 = true;
    L19:
        r5 = false;
        goto L20
    L5:
        r16 = null;
        goto L6
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
    public LocalImageItemViewHolder(LarusItemMarkdownCreationImageScrollBinding r2, CoroutineScope r3, com.larus.uaigc.chat.markdown.image.component.a r4, com.larus.uaigc.chat.markdown.image.component.k r5, kc8.q r6, Function1<? super Continuation<? super Message>, ? extends Object> r7, Function2<? super Message, ? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> r8, Function2<? super cz9.b, ? super iy9.b, Unit> r9, Function2<? super cz9.b, ? super View, Unit> r10) {
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
        this.j = LazyKt.lazy(r11, new s(this));
        this.k = LazyKt.lazy(r11, new t(this));
        this.l = LazyKt.lazy(r11, new u(this));
        this.m = LazyKt.lazy(r11, new v(this));
        this.n = LazyKt.lazy(r11, new w(this));
        this.p = LazyKt.lazy(r11, new x(this));
    }
}
