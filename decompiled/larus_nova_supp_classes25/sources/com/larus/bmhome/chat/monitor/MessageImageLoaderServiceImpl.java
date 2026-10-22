package com.larus.bmhome.chat.monitor;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.SystemClock;
import bi8.f;
import bi8.h;
import bi8.i;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.ability.MessageMonitorItemType;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.t;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.image.loader.g;
import com.larus.platform.api.f2;
import com.larus.utils.y0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oi8.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u009d\u0001\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2 \u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u001aJp\u0010\u001b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2,\u0010\u001f\u001a(\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0002\b&H\u0016J\u001e\u0010'\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/monitor/MessageImageLoaderServiceImpl;", "Lcom/larus/bmhome/chat/monitor/IMessageImageLoaderService;", "<init>", "()V", "loadImageBySearchImageUtils", "", "messageId", "", "type", "Lcom/larus/bmhome/chat/monitor/MessageImageType;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "url", "bizTag", "resizeWidth", "", "reSizeHeight", "onSuccess", "Lkotlin/Function3;", "", "onStart", "Lkotlin/Function0;", "onFail", "Lkotlin/Function1;", "", "autoPlayAnimation", "(Ljava/lang/String;Lcom/larus/bmhome/chat/monitor/MessageImageType;Lcom/facebook/drawee/view/SimpleDraweeView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "loadImageByImageLoader", "Lcom/facebook/drawee/view/GenericDraweeView;", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "createMessageCacheExtra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageImageLoaderServiceImpl implements IMessageImageLoaderService {

    public static final class a implements ControllerListener<Object> {
        public final /* synthetic */ ControllerListener<? super ImageInfo> a;
        public final /* synthetic */ long b;
        public final /* synthetic */ t c;
        public final /* synthetic */ String d;
        public final /* synthetic */ MessageImageType e;
        public final /* synthetic */ String f;
        public final /* synthetic */ MessageMonitorItemType g;

        public final void onRelease(String r2) {
            ControllerListener<? super ImageInfo> r0 = this.a;
            if (r0 == null) goto L6;
            r0.onRelease(r2);
            return;
        }

        public final void onFailure(String r9, Throwable r10) {
            long r0 = SystemClock.elapsedRealtime() - this.b;
            t r2 = this.c;
            String r3 = this.d;
            if (this.e != MessageImageType.VIDEO) goto L5;
            ContainerExceptionType r4 = ContainerExceptionType.FAILED_VIDEO;
        L6:
            JSONObject r5 = new JSONObject();
            r5.put("url", this.f);
            r5.put("render_duration", r0);
            if (r10 == null) goto L9;
            String r1 = r10.getMessage();
        L10:
            r5.put("exception", String.valueOf(r1));
            Unit r6 = Unit.INSTANCE;
            t.a.a(r2, r3, r4, null, r5);
            ControllerListener<? super ImageInfo> r7 = this.a;
            if (r7 == null) goto L14;
            r7.onFailure(r9, r10);
            return;
        L14:
            return;
        L9:
            r1 = null;
            goto L10
        L5:
            r4 = ContainerExceptionType.FAILED_IMAGE;
            goto L6
        }

        public final void onIntermediateImageFailed(String r2, Throwable r3) {
            ControllerListener<? super ImageInfo> r0 = this.a;
            if (r0 == null) goto L6;
            r0.onIntermediateImageFailed(r2, r3);
            return;
        }

        public final void onIntermediateImageSet(String r3, Object r4) {
            ControllerListener<? super ImageInfo> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if ((r4 instanceof ImageInfo) == false) goto L7;
            ImageInfo r5 = (ImageInfo) r4;
        L8:
            r0.onIntermediateImageSet(r3, r5);
            return;
        L7:
            r5 = null;
            goto L8
        }

        public final void onSubmit(String r2, Object r3) {
            ControllerListener<? super ImageInfo> r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSubmit(r2, r3);
            return;
        }

        public final void onFinalImageSet(String r12, Object r13, Animatable r14) {
            if (r13 == null) goto L10;
            long r0 = SystemClock.elapsedRealtime() - this.b;
            if (r0 <= this.c.c(this.g)) goto L10;
            t r5 = this.c;
            String r6 = this.d;
            if (this.e != MessageImageType.VIDEO) goto L8;
            ContainerExceptionType r2 = ContainerExceptionType.TIMEOUT_VIDEO;
        L9:
            ContainerExceptionType r7 = r2;
            JSONObject r9 = new JSONObject();
            r9.put("url", this.f);
            r9.put("render_duration", r0);
            Unit r3 = Unit.INSTANCE;
            r5.a(r6, r7, null, r9, Long.valueOf(r0));
            goto L10
        L8:
            r2 = ContainerExceptionType.TIMEOUT_IMAGE;
        L10:
            ControllerListener<? super ImageInfo> r1 = this.a;
            if (r1 != null) goto L13;
            return;
        L13:
            if ((r13 instanceof ImageInfo) == false) goto L15;
            ImageInfo r15 = (ImageInfo) r13;
        L16:
            r1.onFinalImageSet(r12, r15, r14);
            return;
        L15:
            r15 = null;
            goto L16
        }

        public a(ControllerListener<? super ImageInfo> r1, long r2, t r4, String r5, MessageImageType r6, String r7, MessageMonitorItemType r8) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public MessageImageLoaderServiceImpl() {
    }

    public static g c(String r1, String r2) {
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return null;
    L11:
        if (y0.e(r2) == true) goto L13;
        return null;
    L13:
        if (f2.a.n() == true) goto L16;
        return null;
    L16:
        return b0.d("im_fresco_cache", true);
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r3 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [bi8.h, kotlin.jvm.functions.Function2] */
    @Override // com.larus.bmhome.chat.monitor.IMessageImageLoaderService
    public final void b(final String r15, final MessageImageType r16, GenericDraweeView r17, final String r18, String r19, g r20, final Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r21) {
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r21, "builder");
        if (r17 != null) goto L5;
        return;
    L5:
        final ?? r1 = new h(r21);
        g r0 = c(r15, r18);
        if (r0 != null) goto L8;
        g r12 = r20;
    L9:
        final t r4 = ILegacyChatUiServiceDelegate.b.V8();
        if (r16 != MessageImageType.VIDEO) goto L12;
        MessageMonitorItemType r2 = MessageMonitorItemType.VIDEO;
    L13:
        final MessageMonitorItemType r8 = r2;
        boolean r3 = false;
        if (r15 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L29;
        if (r4 != null) goto L23;
    L25:
        if (r3 == false) goto L29;
        r4.e(r15, r8);
        final long r6 = SystemClock.elapsedRealtime();
        ImageLoaderKt.v(r17, r18, r19, r12, new i(r1, r6, r4, r15, r16, r18, r8));
        return;
    L23:
        if (r4.d(r8) == true) goto L25;
        r3 = true;
    L29:
        ImageLoaderKt.v(r17, r18, r19, r12, r1);
        return;
    L16:
        if (StringsKt.isBlank(r15) == true) goto L19;
        r5 = false;
        goto L20
    L12:
        r2 = MessageMonitorItemType.IMAGE;
        goto L13
    L8:
        r12 = r0;
        goto L9
    }

    @Override // com.larus.bmhome.chat.monitor.IMessageImageLoaderService
    public final void a(final String r20, final MessageImageType r21, SimpleDraweeView r22, final String r23, String r24, Integer r25, Integer r26, final Function3<? super Integer, ? super Integer, ? super Boolean, Unit> r27, Function0<Unit> r28, final Function1<? super Throwable, Unit> r29, boolean r30) {
        Intrinsics.checkNotNullParameter(r21, "type");
        Intrinsics.checkNotNullParameter(r22, "imageView");
        Intrinsics.checkNotNullParameter(r23, "url");
        Intrinsics.checkNotNullParameter(r24, "bizTag");
        g r14 = c(r20, r23);
        final t r15 = ILegacyChatUiServiceDelegate.b.V8();
        if (r21 != MessageImageType.VIDEO) goto L5;
        MessageMonitorItemType r0 = MessageMonitorItemType.VIDEO;
    L6:
        final MessageMonitorItemType r4 = r0;
        boolean r1 = false;
        if (r20 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L22;
        if (r15 != null) goto L16;
    L18:
        if (r1 == false) goto L22;
        r15.e(r20, r4);
        final long r16 = SystemClock.elapsedRealtime();
        int r3 = j.a;
        j.a(r22, r23, r24, r25, r26, new f(r16, r15, r4, r20, r21, r27, r23), r28, new bi8.g(r16, r15, r20, r21, r29, r23), r30, r14);
        return;
    L16:
        if (r15.d(r4) == true) goto L18;
        r1 = true;
    L22:
        int r5 = j.a;
        j.a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r14);
        return;
    L9:
        if (StringsKt.isBlank(r20) == true) goto L12;
        r2 = false;
        goto L13
    L5:
        r0 = MessageMonitorItemType.IMAGE;
        goto L6
    }
}
