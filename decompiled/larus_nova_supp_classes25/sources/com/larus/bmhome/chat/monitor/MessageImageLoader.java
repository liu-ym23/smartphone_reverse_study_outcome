package com.larus.bmhome.chat.monitor;

import android.net.Uri;
import bi8.e;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u009d\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n\u0018\u00010\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001fJp\u0010 \u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010!2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\"\u001a\u0004\u0018\u00010#2,\u0010$\u001a(\u0012\u0004\u0012\u00020&\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\n0%¢\u0006\u0002\b+H\u0017R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/monitor/MessageImageLoader;", "Lcom/larus/bmhome/chat/monitor/IMessageImageLoaderService;", "<init>", "()V", "service", "getService", "()Lcom/larus/bmhome/chat/monitor/IMessageImageLoaderService;", "service$delegate", "Lkotlin/Lazy;", "loadImageBySearchImageUtils", "", "messageId", "", "type", "Lcom/larus/bmhome/chat/monitor/MessageImageType;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "url", "bizTag", "resizeWidth", "", "reSizeHeight", "onSuccess", "Lkotlin/Function3;", "", "onStart", "Lkotlin/Function0;", "onFail", "Lkotlin/Function1;", "", "autoPlayAnimation", "(Ljava/lang/String;Lcom/larus/bmhome/chat/monitor/MessageImageType;Lcom/facebook/drawee/view/SimpleDraweeView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "loadImageByImageLoader", "Lcom/facebook/drawee/view/GenericDraweeView;", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageImageLoader implements IMessageImageLoaderService {
    public static final MessageImageLoader a = null;
    public static final Lazy b = null;

    private MessageImageLoader() {
    }

    static {
        a = new MessageImageLoader();
        b = LazyKt.lazy(new e());
    }

    @Override // com.larus.bmhome.chat.monitor.IMessageImageLoaderService
    public final void b(String r10, MessageImageType r11, GenericDraweeView r12, String r13, String r14, g r15, Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r16) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r16, "builder");
        IMessageImageLoaderService r1 = (IMessageImageLoaderService) b.getValue();
        if (r1 == null) goto L6;
        r1.b(r10, r11, r12, r13, r14, r15, r16);
        return;
    }

    @Override // com.larus.bmhome.chat.monitor.IMessageImageLoaderService
    public final void a(String r14, MessageImageType r15, SimpleDraweeView r16, String r17, String r18, Integer r19, Integer r20, Function3<? super Integer, ? super Integer, ? super Boolean, Unit> r21, Function0<Unit> r22, Function1<? super Throwable, Unit> r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r15, "type");
        Intrinsics.checkNotNullParameter(r16, "imageView");
        Intrinsics.checkNotNullParameter(r17, "url");
        Intrinsics.checkNotNullParameter(r18, "bizTag");
        IMessageImageLoaderService r1 = (IMessageImageLoaderService) b.getValue();
        if (r1 == null) goto L6;
        r1.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    }
}
