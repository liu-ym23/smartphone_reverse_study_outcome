package com.larus.bmhome.chat.monitor;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.monitor.CommonUIMessageImageType;
import com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService;
import com.larus.common_ui.video.j;
import com.larus.image.loader.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Ja\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001d\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0002\b\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/monitor/CommonUIMessageImageLoaderImpl;", "Lcom/larus/bmhome/monitor/ICommonUIMessageImageLoaderService;", "<init>", "()V", "loadImageByImageLoader", "", "messageId", "", "type", "Lcom/larus/bmhome/monitor/CommonUIMessageImageType;", "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", "url", "bizTag", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ExtensionFunctionType;", "getMessageImageType", "Lcom/larus/bmhome/chat/monitor/MessageImageType;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CommonUIMessageImageLoaderImpl implements ICommonUIMessageImageLoaderService {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommonUIMessageImageType.values().length];
            r0[CommonUIMessageImageType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommonUIMessageImageType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public CommonUIMessageImageLoaderImpl() {
    }

    public final void a(String r10, CommonUIMessageImageType r11, SimpleDraweeView r12, String r13, String r14, g r15, j r16) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r16, "builder");
        MessageImageLoader r0 = MessageImageLoader.a;
        int r1 = a.a[r11.ordinal()];
        if (r1 != 1) goto L5;
        MessageImageType r2 = MessageImageType.IMAGE;
    L10:
        r0.b(r10, r2, r12, r13, r14, r15, r16);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = MessageImageType.VIDEO;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
