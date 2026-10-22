package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.larkfeed.impl.gallery.h;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.flow.photoeditor.FlowPhotoEditorActivity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageDecoder;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;
import kza.e;
import kza.g;
import kza.i;
import kza.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001-\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0003MNOB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH\u0016JF\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0017H\u0016J>\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J \u0010/\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0016J\u0018\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u0002032\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u00104\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u00105\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J \u00107\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\b\u0010%\u001a\u0004\u0018\u000108H\u0086@¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u001fH\u0002J\u0016\u0010;\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010<J\b\u0010>\u001a\u00020\u001fH\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\n\u0010A\u001a\u0004\u0018\u00010BH\u0014J\u0010\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u0004\u0018\u00010JH\u0096@¢\u0006\u0002\u0010KJ\u000e\u0010L\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010KR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006P"}, d2 = {"Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView;", "Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuPreviewViewDelegate;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defaultAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "largeImageLoadController", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageLoadController;", "imageItem", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryImageItem;", "callback", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuMediaPreviewCallback;", "isEnterFullScreen", "", "isShowOtherView", "mSource", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;", "getMSource", "()Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;", "setMSource", "(Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;)V", "getView", "Landroid/view/View;", "setData", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isFullScreenMode", "source", "loadDefault", "listener", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuPreviewViewListener;", "loadLargeImage", "info", "Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;", "resource", "Landroid/graphics/Bitmap;", "flowLargeImageAbility", "com/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$flowLargeImageAbility$1", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$flowLargeImageAbility$1;", "refreshView", "forceToDefault", "setScaleForLargeImage", "view", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowSubsamplingScaleImageView;", "loadOrigin", "loadThumbnail", "isNeedShowOrigin", "loadInner", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$IFlowPreviewViewListener;", "(Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$IFlowPreviewViewListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpListener", "loadLargeImageFlow", "(Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLargeImageInner", "reset", "createScaleImageView", "Lcom/ss/android/lark/imagewidget/subsampling/SubsamplingScaleImageView;", "getSizeChangedStrategy", "Lcom/ss/android/lark/imagewidget/subsampling/SubsamplingScaleImageView$OnSizeChangedStrategy;", "startPhotoEdit", "activity", "Landroidx/fragment/app/FragmentActivity;", "reportEditImageAudit", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "getShowFile", "Ljava/io/File;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAnimatedImage", "Companion", "IFlowPreviewViewListener", "IFlowLargeImageAbility", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowLargeImageView extends LargeImageView implements i {
    public static final /* synthetic */ int o = 0;
    public CoroutineScope g;
    public FlowLargeImageLoadController h;
    public l i;
    public g j;
    public boolean k;
    public boolean l;
    public GallerySource m;
    public final c n;

    public static final class a {
    }

    public interface b {
        void onLoadFailed();

        void onLoadSuccess();
    }

    public static final class c {
        public final /* synthetic */ FlowLargeImageView a;

        public c(FlowLargeImageView r1) {
            this.a = r1;
        }

        public final void a(boolean r2) {
            g r0 = this.a.j;
            if (r0 == null) goto L5;
            r0.a(r2);
        L5:
            this.a.l = r2;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ FlowLargeImageView a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ FlowSubsamplingScaleImageView c;
        public final /* synthetic */ Ref.FloatRef d;

        public d(FlowLargeImageView r1, Object r2, FlowSubsamplingScaleImageView r3, Ref.FloatRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            l r0 = this.a.i;
            Integer r1 = null;
            if (r0 == null) goto L5;
            Object r2 = r0.e;
        L7:
            if (Intrinsics.areEqual(r2, this.b) == true) goto L19;
            StringBuilder r3 = new StringBuilder("setScaleForLargeImage, item is not same, return, before: ");
            Object r4 = this.b;
            if (r4 == null) goto L11;
            Integer r5 = Integer.valueOf(r4.hashCode());
        L12:
            r3.append(r5);
            r3.append(", now: ");
            l r6 = this.a.i;
            if (r6 == null) goto L17;
            Object r7 = r6.e;
            if (r7 == null) goto L17;
            r1 = Integer.valueOf(r7.hashCode());
        L17:
            r3.append(r1);
            Log.i("FlowPreviewImageView", r3.toString());
            return;
        L11:
            r5 = null;
            goto L12
        L19:
            int[] r8 = new int[2];
            this.a.getLocationOnScreen(r8);
            int r9 = UIHelper.getWindowWidth(this.a.getContext());
            int r10 = UIUtils.getScreenHeight(this.a.getContext());
            float r11 = this.c.getWidth() / 2.0f;
            float r12 = this.c.getHeight() / 2.0f;
            float r13 = r10;
            if ((this.c.H() * this.d.element) >= r13) goto L22;
            float r14 = this.c.I() / 2.0f;
            float r15 = this.c.H() / 2.0f;
            float r16 = (r11 - (r9 / 2.0f)) + r8[0];
            float r17 = this.d.element;
            PointF r18 = new PointF(r14 + (r16 / r17), r15 + (((r12 - (r13 / 2.0f)) + r8[1]) / r17));
        L23:
            this.c.M(this.d.element, r18);
            FlowLargeImageView r19 = this.a;
            if (r19.k == false) goto L32;
            g r20 = r19.j;
            if (r20 == null) goto L28;
            r20.b(true);
        L28:
            g r21 = this.a.j;
            if (r21 == null) goto L31;
            r21.a(false);
        L31:
            this.a.l = false;
        L32:
            FlowLargeImageView r22 = this.a;
            if (r22.l == true) goto L38;
            g r23 = r22.j;
            if (r23 == null) goto L39;
            r23.a(false);
            return;
        L39:
            return;
        L38:
            return;
        L22:
            float r24 = r11 + r8[0];
            float r25 = this.d.element;
            r18 = new PointF(r24 / r25, (r12 + r8[1]) / r25);
            goto L23
        L5:
            r2 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public FlowLargeImageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowLargeImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public View getView() {
        return this;
    }

    public final boolean b() {
        l r0 = this.i;
        if (r0 == null) goto L5;
        Object r1 = r0.e;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if ((r1 instanceof FlowPhotoItem) == false) goto L12;
        return false;
    L12:
        if ((r1 instanceof PhotoItem) == true) goto L14;
        return false;
    L14:
        if (this.h != null) goto L16;
        return false;
    L16:
        if (((PhotoItem) r1).getPhotoState().getOriginFile() != null) goto L18;
        Log.i("FlowLargeImageLoadController", "originFile is null, need show originFile");
        boolean r2 = true;
    L19:
        if (r2 != true) goto L25;
        return true;
    L25:
        return false;
    L18:
        r2 = false;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    public final Object c() {
        l r0 = this.i;
        if (r0 == null) goto L5;
        Object r2 = r0.e;
    L7:
        if (r0 == null) goto L23;
        if (r2 == null) goto L23;
        if ((r2 instanceof PhotoItem) == false) goto L17;
        File r1 = (File) ((PhotoItem) r2).getPhotoState().getShowFile().getValue();
        if (r1 == null) goto L15;
        return r1;
    L15:
        Log.e("FlowPreviewImageView", "getShowFile PhotoItem, curShowFile is null");
    L22:
        return null;
    L17:
        if ((r2 instanceof ogb.a) == false) goto L22;
        File r3 = ((ogb.a) r2).b;
        if (r3 != null) goto L21;
        Log.e("FlowPreviewImageView", "getShowFile FlowYunPanImagePhotoItem, file is null");
    L21:
        return r3;
    L23:
        Log.e("FlowPreviewImageView", "getShowFile, photoItem is null");
        return null;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView
    public SubsamplingScaleImageView.j getSizeChangedStrategy() {
        SubsamplingScaleImageView r0 = this.b;
        if ((r0 instanceof FlowSubsamplingScaleImageView) == false) goto L5;
        FlowSubsamplingScaleImageView r1 = (FlowSubsamplingScaleImageView) r0;
    L6:
        if (r1 != null) goto L10;
        return super.getSizeChangedStrategy();
    L10:
        return r1.M2;
    L5:
        r1 = null;
        goto L6
    }

    public final GallerySource getMSource() {
        return this.m;
    }

    public final void d(FragmentActivity r11) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        l r0 = this.i;
        String r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.e;
    L7:
        if (r0 == null) goto L40;
        if (r2 == null) goto L40;
        e r3 = r0.f;
        boolean r4 = true;
        if (r3 == null) goto L13;
        r3.c();
        boolean r5 = true;
    L14:
        if (r5 == true) goto L18;
        Log.e("FlowPreviewImageView", "startPhotoEdit, not support edit");
        return;
    L18:
        if ((r2 instanceof PhotoItem) == false) goto L34;
        PhotoItem r6 = (PhotoItem) r2;
        File r7 = (File) r6.getPhotoState().getShowFile().getValue();
        if (r7 != null) goto L23;
        Log.e("FlowPreviewImageView", "startPhotoEdit, curShowFile is null");
        return;
    L23:
        String r8 = com.ss.android.photoeditor.util.b.b(r11);
        int r9 = FlowPhotoEditorActivity.b;
        String r10 = r7.getAbsolutePath();
        Intrinsics.checkNotNull(r8);
        FlowPhotoEditorActivity.a.b(r11, r10, r8, com.ss.android.lark.widget.photopicker.utils.l.a(r6));
        MessageIdentity r12 = r6.getMessageIdentity();
        if (r12 == null) goto L26;
        r1 = r12.getChatId();
    L26:
        String r13 = com.ss.android.lark.widget.photopicker.utils.l.a(r6);
        if (r13.length() == 0) goto L30;
        r4 = false;
    L30:
        if (r4 == false) goto L32;
        Log.e("FlowPreviewImageView", "reportEditImageAudit, imageKey is empty");
        return;
    L32:
        ChatCoreModule.a().getAuditDependency().f(r1, r13);
        return;
    L34:
        if ((r2 instanceof ogb.a) == false) goto L38;
        CoroutineScope r14 = this.g;
        if (r14 == null) goto L44;
        BuildersKt.launch$default(r14, Dispatchers.getMain(), null, new FlowLargeImageView$startPhotoEdit$1(r11, r2, null), 2, null);
        return;
    L44:
        return;
    L38:
        Log.e("FlowPreviewImageView", "startPhotoEdit, item is error");
        return;
    L13:
        r5 = false;
    L40:
        Log.e("FlowPreviewImageView", "startPhotoEdit, imageItem is null");
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final Object g(Continuation<? super Boolean> r8) {
        if ((r8 instanceof FlowLargeImageView$isAnimatedImage$1) == false) goto L7;
        FlowLargeImageView$isAnimatedImage$1 r0 = (FlowLargeImageView$isAnimatedImage$1) r8;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L38:
        nlb.g r10 = (nlb.g) r9;
        if (r10 == null) goto L44;
        if (r10.h != true) goto L44;
        r4 = true;
    L44:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        l r11 = this.i;
        if (r11 == null) goto L17;
        Object r5 = r11.e;
    L18:
        if (r11 == null) goto L45;
        if (r5 == null) goto L45;
        if ((r5 instanceof PhotoItem) == false) goto L29;
        nlb.g r12 = this.d;
        if (r12 != null) goto L26;
        File r13 = (File) ((PhotoItem) r5).getPhotoState().getShowFile().getValue();
    L32:
        if (r13 == null) goto L34;
        VFSPath r14 = VFSFiles.b.t(r13);
        nlb.g r6 = new nlb.g();
        r6.a = r14;
        CoroutineDispatcher r15 = Dispatchers.getIO();
        FlowLargeImageView$isAnimatedImage$data$1 r7 = new FlowLargeImageView$isAnimatedImage$data$1(this, r6, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r15, r7, r0);
        if (r9 != r2) goto L38;
        return r2;
    L34:
        return Boxing.boxBoolean(false);
    L26:
        return Boxing.boxBoolean(r12.h);
    L29:
        if ((r5 instanceof ogb.a) == false) goto L31;
        r13 = ((ogb.a) r5).b;
        goto L32
    L31:
        r13 = null;
    L45:
        Log.e("FlowPreviewImageView", "isLoadFinished, photoItem is null");
        return Boxing.boxBoolean(false);
    L17:
        r5 = null;
    L7:
        r0 = new FlowLargeImageView$isAnimatedImage$1(this, r8);
        goto L8
    }

    public final void i(final com.larus.larkfeed.impl.gallery.g r3) {
        l r0 = this.i;
        if (r0 == null) goto L5;
        final Object r1 = r0.e;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        post(new FlowLargeImageView$loadDefault$1(this, r1, r3));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void j(h r9) {
        l r0 = this.i;
        if (r0 == null) goto L12;
        Object r1 = r0.e;
        if (r1 != null) goto L7;
        return;
    L7:
        if ((r1 instanceof PhotoItem) == false) goto L14;
        CoroutineScope r2 = this.g;
        if (r2 == null) goto L15;
        BuildersKt.launch$default(r2, null, null, new FlowLargeImageView$loadOrigin$1$1(this, r1, r9, null), 3, null);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView
    public final SubsamplingScaleImageView l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new FlowSubsamplingScaleImageView(getContext());
    }

    public final void setMSource(GallerySource r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void a(boolean r5, boolean r6) {
        SubsamplingScaleImageView r0 = this.b;
        if (r0 == null) goto L46;
        boolean r1 = false;
        if (r0.getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L50;
        ImageView r3 = this.a;
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L18;
        SubsamplingScaleImageView r7 = this.b;
        if (r7 != null) goto L26;
    L28:
        if (r1 == false) goto L48;
        SubsamplingScaleImageView r8 = this.b;
        if ((r8 instanceof FlowSubsamplingScaleImageView) == false) goto L32;
        FlowSubsamplingScaleImageView r9 = (FlowSubsamplingScaleImageView) r8;
    L33:
        if (r9 != null) goto L36;
        return;
    L36:
        if (this.k == r5) goto L38;
    L41:
        nlb.g r10 = r9.K2;
        if (r10 == null) goto L44;
        Log.i("FlowPreviewImageView", "refreshView, setScaleForLargeImage");
        this.l = r6;
        this.k = r5;
        z(r9, r10);
        return;
    L44:
        Log.e("FlowPreviewImageView", "refreshView, info is null");
        return;
    L38:
        if (this.l != r6) goto L41;
        Log.i("FlowPreviewImageView", "refreshView, isEnterFullScreen and isShowOtherView same");
        return;
    L32:
        r9 = null;
        goto L33
    L48:
        return;
    L26:
        if (r7.getVisibility() != 0) goto L28;
        r1 = true;
        goto L28
    L18:
        if (this.k == r5) goto L20;
    L22:
        this.k = r5;
        this.l = r6;
        return;
    L20:
        if (this.l != r6) goto L22;
        return;
    L13:
        if (r3.getVisibility() != 0) goto L15;
        r4 = true;
        goto L16
    L50:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView
    public final void q(nlb.g r5, Bitmap r6) {
        Intrinsics.checkNotNullParameter(r5, "info");
        Log.i("FlowPreviewImageView", "start load large image");
        SubsamplingScaleImageView r0 = this.b;
        if ((r0 instanceof FlowSubsamplingScaleImageView) == false) goto L5;
        FlowSubsamplingScaleImageView r1 = (FlowSubsamplingScaleImageView) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.K2 = r5;
        r1.L2 = this.n;
        boolean r2 = r5.c;
        r1.setBitmapDecoderFactory(new nlb.a(MSkiaImageDecoder.class, r5, r2));
        r1.setRegionDecoderFactory(new nlb.b(MSkiaImageRegionDecoder.class, r5, r2));
        nlb.c.i(r1, r5, r6);
        z(r1, r5);
        t(r5);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Object y(nlb.g r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof FlowLargeImageView$loadLargeImageFlow$1) == false) goto L7;
        FlowLargeImageView$loadLargeImageFlow$1 r0 = (FlowLargeImageView$loadLargeImageFlow$1) r11;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (nlb.g) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L29:
        Bitmap r13 = (Bitmap) r12;
        if (n(r10) == true) goto L33;
        q(r10, r13);
    L33:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.label = 1;
        j r14 = new j(IntrinsicsKt.intercepted(r0), 1);
        r14.C();
        long r4 = System.currentTimeMillis();
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        setScaleImageViewInfo(r10);
        int[] r5 = nlb.c.e(this.b, r10);
        Log.i("FlowPreviewImageView", "loadLargeImage, previewWidth:" + r5[0] + ", previewHeight:" + r5[1]);
        IRequestCreator r7 = ImageLoader.with(getContext()).load(r10.a.toFile());
        if (ImageUtils.f(r10.g) == true) goto L17;
    L19:
        DiskCacheStrategy r8 = DiskCacheStrategy.NONE;
    L20:
        IRequestCreator r6 = r7.diskCacheStrategy(r8).skipMemoryCache(true).placeholder(r10.b).error(null).asBitmap().override(r5[0], r5[1]);
        Iterator r9 = ((ArrayList) m(r10)).iterator();
    L22:
        if (r9.hasNext() == false) goto L24;
        r6.transform((BitmapTransformation) r9.next());
        goto L22
    L24:
        r6.into(new com.ss.android.lark.flow.chat.mediapreview.a(r4, r14));
        r12 = r14.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L27:
        if (r12 != r2) goto L29;
        return r2;
    L17:
        if (r10.i == true) goto L19;
        r8 = DiskCacheStrategy.RESULT;
    L7:
        r0 = new FlowLargeImageView$loadLargeImageFlow$1(this, r11);
        goto L8
    }

    public final void z(FlowSubsamplingScaleImageView r14, nlb.g r15) {
        int r0 = r15.e;
        int r16 = r15.f;
        int r1 = nlb.c.g(r14);
        int r2 = nlb.c.f(r14);
        float r3 = nlb.c.b(r1, r2, r0, r16);
        float r4 = nlb.c.c(r1, r2, r0, r16);
        float r5 = r1;
        float r8 = r0;
        float r7 = (r5 * 1.0f) / r8;
        float r10 = r16;
        float r9 = (r2 * 1.0f) / r10;
        float r11 = Math.min(r7, r9);
        r14.setDoubleTapZoomScale(r3);
        r14.setMaxScale(r4);
        r14.setMinimumScaleType(3);
        r14.setMinScale(r11);
        Ref.FloatRef r12 = new Ref.FloatRef();
        r12.element = r11;
        if (((r10 * 1.0f) / r8) <= 1.8777778f) goto L5;
        boolean r6 = true;
    L6:
        r14.I2 = r6;
        if (r6 == false) goto L9;
    L10:
        r12.element = Math.max(r7, r9);
    L11:
        r14.setDefaultScale(r12.element);
        if (this.k == false) goto L14;
    L17:
        l r13 = this.i;
        if (r13 == null) goto L20;
        Object r17 = r13.e;
    L21:
        r14.post(new d(this, r17, r14, r12));
    L22:
        Log.i("FlowPreviewImageView", "setScaleForLargeImage, bitmapWidth: " + r0 + ", bitmapHeight: " + r16 + ", viewWidth: " + r1 + ", viewHeight: " + r2 + ", doubleTabScale: " + r3 + ", maxScale: " + r4 + ", minScale: " + r11 + ", defaultScale: " + r12.element + ", isLong: " + r6);
        return;
    L20:
        r17 = null;
        goto L21
    L14:
        if (this.l == false) goto L17;
        r14.M(r11, new PointF(0.0f, 0.0f));
        goto L22
    L9:
        if ((r8 * r11) >= r5) goto L11;
    L5:
        r6 = false;
        goto L6
    }

    public FlowLargeImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = true;
        this.m = GallerySource.DEFAULT;
        this.n = new c(this);
    }

    public final Object x(nlb.g r7, b r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowLargeImageView$loadInner$1) == false) goto L7;
        FlowLargeImageView$loadInner$1 r0 = (FlowLargeImageView$loadInner$1) r9;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        b r11 = (b) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L46:
        if (r11 == null) goto L51;
        r11.onLoadSuccess();
    L51:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (b) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L28:
        nlb.g r12 = (nlb.g) r10;
        int r13 = r12.e;
        if (r13 <= 0) goto L48;
        int r4 = r12.f;
        if (r4 <= 0) goto L48;
        if (r12.h == true) goto L36;
    L42:
        Intrinsics.checkNotNull(r12);
        r0.L$0 = r8;
        r0.label = 2;
        if (y(r12, r0) != r2) goto L45;
        return r2;
    L45:
        r11 = r8;
        goto L46
    L36:
        if (nlb.c.h(this, r13, r4) == true) goto L42;
        p(r12);
        ImageView r14 = this.a;
        if (r14 == null) goto L40;
        r14.setOnClickListener(new com.ss.android.lark.flow.chat.mediapreview.b(this));
    L40:
        if (r8 == null) goto L51;
        r8.onLoadSuccess();
    L48:
        if (r8 == null) goto L51;
        r8.onLoadFailed();
        goto L51
    L16:
        ResultKt.throwOnFailure(r10);
        String r5 = null;
        if (r7.a.toFile().canRead() == true) goto L25;
        if (r8 == null) goto L20;
        r8.onLoadFailed();
    L20:
        StringBuilder r15 = new StringBuilder("file can not read, info: + ");
        VFSPath r16 = r7.a;
        if (r16 == null) goto L23;
        r5 = r16.getRealPath();
    L23:
        r15.append(r5);
        Log.i("FlowPreviewImageView", r15.toString());
        return Unit.INSTANCE;
    L25:
        this.d = r7;
        CoroutineDispatcher r17 = Dispatchers.getIO();
        FlowLargeImageView$loadInner$data$1 r6 = new FlowLargeImageView$loadInner$data$1(this, r7, null);
        r0.L$0 = r8;
        r0.label = 1;
        r10 = BuildersKt.withContext(r17, r6, r0);
        if (r10 != r2) goto L28;
        return r2;
    L7:
        r0 = new FlowLargeImageView$loadInner$1(this, r9);
        goto L8
    }

    public /* synthetic */ FlowLargeImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void f(Context r6, l r7, com.larus.larkfeed.impl.gallery.e r8, boolean r9, boolean r10, GallerySource r11) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r11, "source");
        if (r7 != null) goto L6;
        Log.i("FlowPreviewImageView", "imageItem is null");
        return;
    L6:
        Log.i("FlowPreviewImageView", "reset");
        CoroutineScope r0 = this.g;
        if (r0 == null) goto L9;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
    L9:
        SubsamplingScaleImageView r1 = this.b;
        if ((r1 instanceof FlowSubsamplingScaleImageView) == false) goto L12;
        FlowSubsamplingScaleImageView r3 = (FlowSubsamplingScaleImageView) r1;
    L14:
        if (r3 == null) goto L17;
        r3.K2 = null;
        r3.L2 = null;
        r3.I2 = false;
    L17:
        if (r1 == null) goto L19;
        setLoadPreviewListener(null);
        r1.setVisibility(8);
        r1.G(true);
        r1.G1 = null;
        r1.H1 = null;
        r1.L1 = null;
        r1.M1 = null;
    L19:
        ImageView r2 = this.a;
        if (r2 == null) goto L22;
        r2.setVisibility(8);
    L22:
        this.k = false;
        this.l = true;
        this.g = null;
        this.m = GallerySource.DEFAULT;
        l r4 = this.i;
        if (r4 == null) goto L25;
        Object r5 = r4.e;
    L27:
        if ((r5 instanceof ogb.a) == false) goto L29;
        ((ogb.a) r5).b = null;
    L29:
        this.i = null;
        this.j = null;
        this.d = null;
        this.m = r11;
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.h = new FlowLargeImageLoadController(r6, this, r11);
        this.i = r7;
        this.l = r10;
        this.k = r9;
        this.j = r8;
        return;
    L25:
        r5 = null;
        goto L27
    L12:
        r3 = null;
        goto L14
    }
}
