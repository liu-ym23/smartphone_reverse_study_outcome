package com.larus.bmhome.chat.monitor;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J©\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0018Jt\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2,\u0010\u001d\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0002\b$H'¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/monitor/IMessageImageLoaderService;", "", "loadImageBySearchImageUtils", "", "messageId", "", "type", "Lcom/larus/bmhome/chat/monitor/MessageImageType;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "url", "bizTag", "resizeWidth", "", "reSizeHeight", "onSuccess", "Lkotlin/Function3;", "", "onStart", "Lkotlin/Function0;", "onFail", "Lkotlin/Function1;", "", "autoPlayAnimation", "(Ljava/lang/String;Lcom/larus/bmhome/chat/monitor/MessageImageType;Lcom/facebook/drawee/view/SimpleDraweeView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "loadImageByImageLoader", "Lcom/facebook/drawee/view/GenericDraweeView;", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IMessageImageLoaderService {

    public static final class a {
        public static /* synthetic */ void a(MessageImageLoader r8, String r9, MessageImageType r10, GenericDraweeView r11, String r12, String r13, Function2 r14, int r15) {
            if ((r15 & 16) == 0) goto L5;
            r13 = null;
        L5:
            r8.b(r9, r10, r11, r12, r13, null, r14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(MessageImageLoader r15, String r16, MessageImageType r17, SimpleDraweeView r18, String r19, String r20, Integer r21, Integer r22, Function3 r23, Function0 r24, Function1 r25, boolean r26, int r27) {
            if ((r27 & 32) == 0) goto L5;
            Integer r9 = null;
        L7:
            if ((r27 & 64) == 0) goto L9;
            Integer r10 = null;
        L11:
            if ((r27 & 128) == 0) goto L13;
            Function3 r11 = null;
        L15:
            if ((r27 & 256) == 0) goto L17;
            Function0 r12 = null;
        L19:
            if ((r27 & 512) == 0) goto L21;
            Function1 r13 = null;
        L23:
            if ((r27 & 1024) == 0) goto L25;
            boolean r14 = false;
        L26:
            r15.a(r16, r17, r18, r19, r20, r9, r10, r11, r12, r13, r14);
            return;
        L25:
            r14 = r26;
            goto L26
        L21:
            r13 = r25;
            goto L23
        L17:
            r12 = r24;
            goto L19
        L13:
            r11 = r23;
            goto L15
        L9:
            r10 = r22;
            goto L11
        L5:
            r9 = r21;
            goto L7
        }
    }

    void a(String r1, MessageImageType r2, SimpleDraweeView r3, String r4, String r5, Integer r6, Integer r7, Function3<? super Integer, ? super Integer, ? super Boolean, Unit> r8, Function0<Unit> r9, Function1<? super Throwable, Unit> r10, boolean r11);

    void b(String r1, MessageImageType r2, GenericDraweeView r3, String r4, String r5, g r6, Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r7);
}
