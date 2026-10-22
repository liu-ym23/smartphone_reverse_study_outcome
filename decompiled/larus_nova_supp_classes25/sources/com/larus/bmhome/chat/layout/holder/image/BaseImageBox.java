package com.larus.bmhome.chat.layout.holder.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.platform.service.e2;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class BaseImageBox extends com.larus.bmhome.chat.layout.item.k implements by7.e, g0, j19.e, com.larus.bmhome.bigimg.e, h0 {
    public final Map<String, String> A;
    public Message B;
    public Job C;
    public long D;
    public final r E;
    public ResizeOptions r;
    public List<ImageItem> s;
    public List<ImageItem> t;
    public List<ImageItem> u;
    public List<TemplateInfo.TemplateInfo> v;
    public int w;
    public final Map<Integer, df8.c> x;
    public final f0 y;
    public final BaseImageBox$actLifecycleObserver$1 z;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ n0 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ BaseImageBox e;
        public final /* synthetic */ Uri f;
        public final /* synthetic */ Uri g;
        public final /* synthetic */ Message h;
        public final /* synthetic */ Ref.BooleanRef i;
        public final /* synthetic */ boolean j;

        public final void onFailure(String r12, Throwable r13) {
            n0 r0 = this.a;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            String r1 = this.d;
            boolean r2 = false;
            if (r1 != null) goto L8;
        L11:
            boolean r3 = true;
        L12:
            if (r3 == true) goto L14;
            this.e.getFailedIndexAndUrl().put(Integer.valueOf(this.c), new df8.c(this.f, this.g));
            FLogger.a.e(this.e.getLogTag(), "[image_load_failed]:" + this.d, r13);
        L14:
            Message r4 = this.h;
            if (r4 == null) goto L20;
            String r5 = r4.getLocalMessageId();
            if (r5 == null) goto L20;
            int r6 = this.c;
            Message r7 = this.h;
            String r8 = this.d;
            boolean r9 = this.j;
            int r10 = com.larus.bmhome.chat.trace.multimodal.a.a;
            com.larus.bmhome.chat.trace.multimodal.a.a(r5 + r6, r7.getMessageId(), "[image_load_failed]: err:" + r13, r8, "text_to_image", true, MapsKt.mapOf(TuplesKt.to("extra_is_reload", Integer.valueOf(r9 ? 1 : 0))));
        L20:
            if (this.i.element == true) goto L30;
            Message r14 = this.e.B;
            if (r14 == null) goto L30;
            Message r11 = this.h;
            int r15 = this.c;
            nq9.f r16 = m3.a.o();
            if (r16 == null) goto L30;
            if (r11 == null) goto L27;
            r2 = com.larus.bmhome.chat.bean.d.a0(r11);
        L27:
            OldUgcGenImgPerfMonitor r17 = r16.a(r2);
            if (r17 == null) goto L30;
            r17.f(r14, String.valueOf(r15));
        L30:
            f0 r18 = this.e.y;
            Message r19 = this.h;
            r18.getClass();
            if (r19 == null) goto L35;
            r18.a.remove(f0.a(r19, r12));
            return;
        L35:
            return;
        L8:
            if (r1.length() == 0) goto L11;
            r3 = false;
            goto L12
        }

        public final void onIntermediateImageSet(String r11, Object r12) {
            ImageInfo r0 = (ImageInfo) r12;
            FLogger r1 = FLogger.a;
            String r3 = this.e.getLogTag();
            StringBuilder r4 = new StringBuilder("[onIntermediateImageSet]:");
            r4.append(this.f);
            r4.append("   ");
            r4.append(r11);
            r4.append(' ');
            String r6 = null;
            if (r0 == null) goto L7;
            ImageFormat r7 = r0.getImageFormat();
            if (r7 == null) goto L7;
            String r8 = r7.getFileExtension();
        L8:
            r4.append(r8);
            r4.append(' ');
            r1.i(r3, r4.toString());
            super.onIntermediateImageSet(r11, r0);
            n0 r2 = this.a;
            if (r2 == null) goto L12;
            r2.b(this.b, this.c);
        L12:
            if (this.i.element == true) goto L30;
            Message r5 = this.e.B;
            if (r5 == null) goto L23;
            Message r9 = this.h;
            int r10 = this.c;
            nq9.f r13 = m3.a.o();
            if (r13 == null) goto L23;
            if (r9 == null) goto L19;
            boolean r14 = com.larus.bmhome.chat.bean.d.a0(r9);
        L20:
            OldUgcGenImgPerfMonitor r15 = r13.a(r14);
            if (r15 == null) goto L23;
            r15.b(r5, String.valueOf(r10));
            goto L23
        L19:
            r14 = false;
        L23:
            f0 r16 = this.e.y;
            Message r17 = this.h;
            Uri r18 = this.f;
            if (r0 == null) goto L28;
            ImageFormat r19 = r0.getImageFormat();
            if (r19 == null) goto L28;
            r6 = r19.getFileExtension();
        L28:
            r16.b(r17, r11, false, r18, true, r6, this.e instanceof a1, this.c);
            return;
        L30:
            return;
        L7:
            r8 = null;
            goto L8
        }

        public final void onSubmit(String r12, Object r13) {
            super.onSubmit(r12, r13);
            Message r14 = this.h;
            if (r14 == null) goto L6;
            int r0 = this.c;
            int r1 = MultimodalSendCostTrace.a;
            MultimodalSendCostTrace.b(r14.getLocalMessageId() + r0, r14.getLocalMessageId(), r14.getConversationId(), null, AttachmentAreaType.NO_CLEAR, null, null, null);
        L6:
            if (this.i.element == true) goto L22;
            Message r15 = this.e.B;
            if (r15 == null) goto L17;
            Message r2 = this.h;
            int r3 = this.c;
            nq9.f r4 = m3.a.o();
            if (r4 == null) goto L17;
            if (r2 == null) goto L13;
            boolean r5 = com.larus.bmhome.chat.bean.d.a0(r2);
        L14:
            OldUgcGenImgPerfMonitor r6 = r4.a(r5);
            if (r6 == null) goto L17;
            r6.g(r15, String.valueOf(r3));
            goto L17
        L13:
            r5 = false;
        L17:
            f0 r16 = this.e.y;
            Message r7 = this.h;
            r16.getClass();
            if (r7 == null) goto L23;
            r16.a.put(f0.a(r7, r12), Long.valueOf(System.currentTimeMillis()));
            return;
        L23:
            return;
        }

        public final void onFinalImageSet(String r18, Object r19, Animatable r20) {
            ImageInfo r1 = (ImageInfo) r19;
            FLogger r2 = FLogger.a;
            String r3 = this.e.getLogTag();
            StringBuilder r4 = new StringBuilder("[onFinalImageSet]:");
            r4.append(this.d);
            r4.append("   ");
            r4.append(r18);
            r4.append("  ");
            if (r1 == null) goto L7;
            ImageFormat r6 = r1.getImageFormat();
            if (r6 == null) goto L7;
            String r7 = r6.getFileExtension();
        L8:
            r4.append(r7);
            r4.append(' ');
            r2.i(r3, r4.toString());
            super.onFinalImageSet(r18, r1, r20);
            n0 r5 = this.a;
            if (r5 == null) goto L12;
            r5.b(this.b, this.c);
        L12:
            if (this.i.element == true) goto L35;
            Message r8 = this.h;
            if (r8 == null) goto L18;
            String r9 = r8.getLocalMessageId();
            if (r9 == null) goto L18;
            int r10 = this.c;
            String r12 = this.d;
            Message r11 = this.h;
            boolean r13 = this.j;
            int r14 = MultimodalSendCostTrace.a;
            MultimodalSendCostTrace.e(r9 + r10, r12, r11.getMessageId(), "text_to_image", true, MapsKt.mapOf(TuplesKt.to("extra_is_reload", Integer.valueOf(r13 ? 1 : 0))));
        L18:
            Message r15 = this.e.B;
            if (r15 == null) goto L28;
            Message r16 = this.h;
            int r17 = this.c;
            nq9.f r21 = m3.a.o();
            if (r21 == null) goto L28;
            if (r16 == null) goto L24;
            boolean r22 = com.larus.bmhome.chat.bean.d.a0(r16);
        L25:
            OldUgcGenImgPerfMonitor r23 = r21.a(r22);
            if (r23 == null) goto L28;
            r23.b(r15, String.valueOf(r17));
            goto L28
        L24:
            r22 = false;
        L28:
            f0 r24 = this.e.y;
            Message r25 = this.h;
            boolean r26 = this.i.element;
            Uri r27 = this.g;
            if (r1 == null) goto L33;
            ImageFormat r28 = r1.getImageFormat();
            if (r28 == null) goto L33;
            String r29 = r28.getFileExtension();
        L34:
            r24.b(r25, r18, r26, r27, false, r29, this.e instanceof a1, this.c);
        L33:
            r29 = null;
        L35:
            f0 r30 = this.e.y;
            Message r31 = this.h;
            r30.getClass();
            if (r31 == null) goto L40;
            r30.a.remove(f0.a(r31, r18));
            return;
        L40:
            return;
        L7:
            r7 = null;
            goto L8
        }

        public a(n0 r1, String r2, int r3, String r4, BaseImageBox r5, Uri r6, Uri r7, Message r8, Ref.BooleanRef r9, boolean r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public abstract ViewGroup getImageParentScrollView();

    public abstract List<ImageView> getImageViewList();

    public abstract String getLogTag();

    public abstract TextView getRegenerateBtn();

    public abstract void r(ImageContentData r1, Message r2, BotModel r3, com.larus.bmhome.chat.api.q0 r4, CoroutineScope r5, Function1<? super Message, ? extends Map<String, ? extends Object>> r6);

    public abstract void x();

    public final boolean u() {
        return Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.g0
    public ResizeOptions getImageSize() {
        return getImageSizeOption();
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.h0
    public Integer getLoadingProgress() {
        return getCurrentLoadingProgress();
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        x();
        ComponentActivity r0 = getContext();
        if ((r0 instanceof ComponentActivity) == false) goto L5;
        ComponentActivity r1 = r0;
    L6:
        if (r1 == null) goto L11;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L12;
        r2.addObserver(this.z);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ComponentActivity r0 = getContext();
        if ((r0 instanceof ComponentActivity) == false) goto L5;
        ComponentActivity r1 = r0;
    L6:
        if (r1 == null) goto L11;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L12;
        r2.removeObserver(this.z);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final List<ImageItem> getBigDisplayImageList() {
        return this.u;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.w;
    }

    public final List<ImageItem> getChatDisplayImageList() {
        return this.t;
    }

    public final Map<Integer, df8.c> getFailedIndexAndUrl() {
        return this.x;
    }

    public final Function1<Integer, TemplateInfo.TemplateInfo> getGetTemplateByIndex() {
        return this.E;
    }

    public ResizeOptions getImageSizeOption() {
        return this.r;
    }

    public final List<ImageItem> getOriginImageList() {
        return this.s;
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.larus.bmhome.chat.layout.holder.image.BaseImageBox$actLifecycleObserver$1] */
    public BaseImageBox(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.r = new ResizeOptions(i5.B(), i5.B());
        this.t = CollectionsKt.emptyList();
        this.u = CollectionsKt.emptyList();
        this.w = -1;
        this.x = new LinkedHashMap();
        this.y = new f0();
        this.z = new BaseImageBox$actLifecycleObserver$1(this);
        this.A = new LinkedHashMap();
        this.E = new r(this);
    }

    public static boolean w(Message r1) {
        if (com.larus.bmhome.chat.bean.d.y(r1) == false) goto L5;
    L14:
        return true;
    L5:
        if (com.larus.bmhome.chat.bean.d.v(r1) == true) goto L14;
        Map r2 = r1.getBusinessExt();
        if (r2 == null) goto L9;
        String r3 = (String) r2.get("message_case_mode");
    L11:
        if (Intrinsics.areEqual(r3, "1") == true) goto L14;
        return false;
    L9:
        r3 = null;
        goto L11
    }

    public final void setBigDisplayImageList(List<ImageItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.u = r2;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        this.w = r1;
    }

    public final void setChatDisplayImageList(List<ImageItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.t = r2;
    }

    public void setImageSizeOption(ResizeOptions r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
    }

    public final void setOriginImageList(List<ImageItem> r1) {
        this.s = r1;
    }

    public final int y(int r6) {
        if (this.u.size() == this.t.size()) goto L20;
        ImageItem r7 = (ImageItem) CollectionsKt.getOrNull(this.t, r6);
        Iterator<ImageItem> r0 = this.u.iterator();
        int r2 = 0;
    L7:
        if (r0.hasNext() == false) goto L15;
        ImageItem r3 = r0.next();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r7 != null) goto L11;
        boolean r4 = false;
    L12:
        if (r4 == true) goto L19;
        r2 = r2 + 1;
        goto L7
    L19:
        return r2;
    L11:
        r4 = Intrinsics.areEqual(r3.getKey(), r7.getKey());
        goto L12
    L15:
        return -1;
    L20:
        return r6;
    }

    public final int z(int r6) {
        if (this.u.size() == this.t.size()) goto L20;
        ImageItem r7 = (ImageItem) CollectionsKt.getOrNull(this.u, r6);
        Iterator<ImageItem> r0 = this.t.iterator();
        int r2 = 0;
    L7:
        if (r0.hasNext() == false) goto L15;
        ImageItem r3 = r0.next();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r7 != null) goto L11;
        boolean r4 = false;
    L12:
        if (r4 == true) goto L19;
        r2 = r2 + 1;
        goto L7
    L19:
        return r2;
    L11:
        r4 = Intrinsics.areEqual(r3.getKey(), r7.getKey());
        goto L12
    L15:
        return -1;
    L20:
        return r6;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r3, boolean r4) {
        if (e2.a.isPad() == false) goto L9;
        setMaxWidth(getContext().getResources().getDimensionPixelSize(v19.c.b(2130971486, getContext(), 2131167341)));
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if (r5 == null) goto L8;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
        ((ViewGroup.MarginLayoutParams) r6).width = getMaxWidth();
        setLayoutParams(r6);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L9:
        super.l(r3, r4);
    }

    @Override // com.larus.bmhome.chat.layout.item.k
    public void n(Message r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        FLogger.a.i(getLogTag(), "bindLoadingData msg is feelyImgMessage? " + com.larus.bmhome.chat.bean.d.y(r5) + " ; isMsgLatest is last");
        if (r6 == true) goto L7;
    L12:
        TextView r7 = getRegenerateBtn();
        if (r7 == null) goto L18;
        com.larus.utils.e1.o(r7);
        return;
    L18:
        return;
    L7:
        if (w(r5) == true) goto L12;
        TextView r8 = getRegenerateBtn();
        if (r8 == null) goto L16;
        com.larus.utils.e1.q(r8);
        return;
    }

    public final void t(i0 r5, Message r6) {
        Intrinsics.checkNotNullParameter(r5, "regenerateAction");
        Intrinsics.checkNotNullParameter(r6, "msg");
        FLogger.a.i(getLogTag(), "hideRegenerateBtn msg is last? " + r5.c(r6));
        if (r5.c(r6) == true) goto L5;
    L10:
        TextView r7 = getRegenerateBtn();
        if (r7 == null) goto L16;
        com.larus.utils.e1.o(r7);
        return;
    L16:
        return;
    L5:
        if (w(r6) == true) goto L10;
        TextView r8 = getRegenerateBtn();
        if (r8 == null) goto L14;
        com.larus.utils.e1.q(r8);
        return;
    }

    public static ChatParam s(boolean r8, String r9, String r10) {
        if (r8 == false) goto L10;
        wc9.e r11 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r11 == null) goto L7;
        r10 = r11.a;
    L8:
        if (r10 != null) goto L10;
        r10 = "";
        goto L10
    L7:
        r10 = null;
    L10:
        String r1 = r10;
        if (r8 == false) goto L18;
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L17;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L17;
        r9 = r13.W();
    L17:
        String r2 = null;
    L20:
        return new ChatParam(r1, r2, null, null, null, 252);
    L18:
        r2 = r9;
        goto L20
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.g0
    public final void a(final SimpleDraweeView r23, final Uri r24, final Uri r25, final int r26, final boolean r27, final n0 r28) {
        Intrinsics.checkNotNullParameter(r23, "imageView");
        if (r24 != null) goto L7;
        if (r25 != null) goto L7;
        FLogger.a.e(getLogTag(), "loadImage url is invalid ");
        r23.setActualImageResource(2131240764);
        return;
    L7:
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        final String r9 = com.larus.utils.y0.k(r25);
        final Message r12 = this.B;
        if ((this instanceof k0) == true) goto L10;
    L15:
        this.A.put(String.valueOf(r26), r9);
        final com.larus.platform.model.chat.n r3 = z2.a.getCreationPreviewPerformanceOptConfig();
        ImageDecodeOptions r0 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        if (r24 == null) goto L21;
        ImageRequestBuilder r1 = ImageRequestBuilder.newBuilderWithSource(r24).setImageDecodeOptions(r0);
        if (r3.e == false) goto L20;
        r1.setResizeOptions(getImageSizeOption());
    L20:
        ImageRequest r2 = r1.build();
    L22:
        if (r12 == null) goto L24;
        String r16 = r12.getMessageId();
    L25:
        MessageImageLoader r17 = MessageImageLoader.a;
        MessageImageType r18 = MessageImageType.IMAGE;
        if (r25 == null) goto L28;
        String r19 = r25.toString();
    L29:
        final ImageRequest r4 = r2;
        final String r7 = r16;
        IMessageImageLoaderService.a.a(r17, r16, r18, r23, r19, null, new com.larus.bmhome.chat.layout.holder.image.a(r4, r23, r3, this, r5, r28, r7, r26, r9, r24, r25, r12, r27), 48);
        return;
    L28:
        r19 = null;
        goto L29
    L24:
        r16 = null;
        goto L25
    L21:
        r2 = null;
        goto L22
    L10:
        if (Intrinsics.areEqual(r9, ((LinkedHashMap) this.A).get(String.valueOf(r26))) == false) goto L15;
        if (r25 == null) goto L15;
        if (r27 == true) goto L15;
        FLogger.a.i(((k0) this).getLogTag(), "loadImage, uri no change");
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.g0
    public final void e(final SimpleDraweeView r17, final ImageItem r18, final TemplateInfo.TemplateInfo r19, String r20, String r21, final int r22, final BotModel r23, final com.larus.bmhome.chat.api.q0 r24, final CoroutineScope r25, final Function1 r26) {
        Intrinsics.checkNotNullParameter(r17, "imageView");
        Intrinsics.checkNotNullParameter(r21, "downloadUrl");
        final Message r10 = this.B;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r18 != null) goto L8;
    L18:
        r17.setOnClickListener(null);
        r17.setOnLongClickListener(null);
        return;
    L8:
        if (com.larus.utils.o0.d(r20) == false) goto L18;
        com.larus.utils.e1.d(r17, new s(this, r24, r25, r10, r23, r19, r22, r17, r26, r18));
        TemplateInfo.TemplateInfo r0 = (TemplateInfo.TemplateInfo) this.E.invoke(Integer.valueOf(r22));
        if (r26 == null) goto L12;
        Map r9 = (Map) r26.invoke(r10);
    L13:
        df8.a r5 = new df8.a(r22, r18, r0, r9);
        if (r24 == null) goto L16;
        com.larus.bmhome.chat.api.q0.a r4 = r24.getProvider();
    L17:
        ViewGroup r6 = getImageParentScrollView();
        JSONObject r8 = new JSONObject();
        r8.putOpt("position", Integer.valueOf(r22 + 1));
        com.larus.bmhome.chat.layout.holder.helper.b1.a(new p0(r10, r24, r4, r5, r6, new com.larus.bmhome.chat.layout.holder.helper.f("creativity_answer_action", new com.larus.bmhome.chat.layout.holder.helper.u0()), r8), r17);
        return;
    L16:
        r4 = null;
        goto L17
    L12:
        r9 = null;
        goto L13
    }

    public final void q(final Message r15, Message r16, wc9.e r17, final BotModel r18, Boolean r19, Boolean r20, com.larus.bmhome.chat.api.q0 r21, final ImageContentData r22, final i0 r23, CoroutineScope r24, Function1<? super Message, ? extends Map<String, ? extends Object>> r25) {
        Intrinsics.checkNotNullParameter(r15, "data");
        Intrinsics.checkNotNullParameter(r22, "imageDataContent");
        Intrinsics.checkNotNullParameter(r23, "regenerateAction");
        this.B = r15;
        String r0 = com.larus.bmhome.chat.bean.d.x(r15).getTemplateData();
        String r13 = null;
        if (r0 != null) goto L101;
    L9:
        List<TemplateInfo.TemplateInfo> r1 = null;
    L10:
        this.v = r1;
        r(r22, r15, r18, r21, r24, r25);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        com.larus.bmhome.actionbar.model.r r2 = com.larus.bmhome.actionbar.util.h.a(r15);
        if (r2 == null) goto L15;
        com.larus.bmhome.actionbar.model.j1 r3 = r2.e;
        if (r3 == null) goto L15;
        r13 = r3.e;
    L15:
        final boolean r4 = Intrinsics.areEqual(r13, "1");
        FLogger r5 = FLogger.a;
        r5.i(getLogTag(), "setupActionBarForCell msg is isServerLoading? " + com.larus.im.bean.message.a.r0(r15));
        if (com.larus.bmhome.chat.bean.d.y(r15) == false) goto L18;
        r5.i(getLogTag(), "setupActionBarForCell msg is feelyImgMessage? " + com.larus.bmhome.chat.bean.d.y(r15));
        t(r23, r15);
        return;
    L18:
        Boolean r14 = Boolean.TRUE;
        boolean r6 = false;
        if (Intrinsics.areEqual(r19, r14) == true) goto L21;
    L31:
        if (r4 == true) goto L33;
    L99:
        r5.i(getLogTag(), "setupActionBarForCell msg is isMsgLatest? " + r23.c(r15));
        t(r23, r15);
        return;
    L33:
        if (r23.c(r15) == false) goto L99;
    L35:
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        if (r4 == false) goto L41;
        TextView r8 = getRegenerateBtn();
        if (r8 == null) goto L85;
        r8.setText(getContext().getString(2131907672));
    L85:
        TextView r9 = getRegenerateBtn();
        if (r9 == null) goto L88;
        com.larus.utils.e1.x(r9);
    L88:
        TextView r10 = getRegenerateBtn();
        if (r10 == null) goto L92;
        com.larus.utils.e1.d(r10, new l(r4, r23, r15, r22, r7, r18));
    L92:
        if (Intrinsics.areEqual(r20, r14) == false) goto L96;
        TextView r11 = getRegenerateBtn();
        if (r11 == null) goto L105;
        r11.setAlpha(0.3f);
        return;
    L105:
        return;
    L96:
        TextView r12 = getRegenerateBtn();
        if (r12 == null) goto L107;
        r12.setAlpha(1.0f);
        return;
    L107:
        return;
    L41:
        if (z2.a.h1().b == false) goto L82;
        if (r16 != null) goto L44;
    L46:
        boolean r26 = false;
    L47:
        if (r26 == false) goto L82;
        Integer r27 = ic8.j.b(r16);
        if (r27 != null) goto L52;
    L53:
        Integer r28 = ic8.j.b(r16);
        if (r28 != null) goto L57;
    L58:
        Integer r29 = ic8.j.b(r16);
        if (r29 != null) goto L62;
    L63:
        Integer r30 = ic8.j.b(r16);
        if (r30 != null) goto L67;
    L68:
        String r31 = com.larus.im.bean.message.a.g(r16);
        if (r31 != null) goto L71;
    L72:
        r6 = true;
    L73:
        if (r6 == false) goto L82;
    L75:
        if (ic8.j.a(r15.getExt()) == true) goto L82;
        if (r23.b(r16) == true) goto L79;
        r5.i(getLogTag(), "modifyTargetMsg is null so make regenerateBtn gone ");
        t(r23, r15);
        return;
    L79:
        r7.element = r16;
        TextView r32 = getRegenerateBtn();
        if (r32 == null) goto L85;
        r32.setText(getContext().getString(2131906089));
        goto L85
    L71:
        if (r31.length() != 0) goto L73;
    L67:
        if (r30.intValue() == 28) goto L75;
    L62:
        if (r29.intValue() == 11) goto L75;
    L57:
        if (r28.intValue() == 16) goto L75;
    L52:
        if (r27.intValue() == 4) goto L75;
    L44:
        if (r16.getContentType() != 1) goto L46;
        r26 = true;
    L82:
        TextView r33 = getRegenerateBtn();
        if (r33 == null) goto L85;
        r33.setText(getContext().getString(2131906069));
        goto L85
    L21:
        if (com.larus.bmhome.chat.bean.d.z0(r15) == true) goto L31;
        if (r17 != null) goto L24;
    L26:
        boolean r34 = false;
    L27:
        if (r34 == true) goto L31;
        if (r16 == null) goto L31;
        if (com.larus.im.bean.message.a.r0(r15) == false) goto L35;
    L24:
        if (ic8.n.d(r17) != true) goto L26;
        r34 = true;
        goto L27
    L101:
        r1 = (List) new Gson().fromJson(r0, new z().getType());     // Catch: Exception -> L7
    L7:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L9
    }
}
