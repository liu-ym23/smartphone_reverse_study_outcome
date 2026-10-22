package ag8;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.chat.c5;
import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ SimpleDraweeView a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ SendImageCell e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;

    public /* synthetic */ a(ImageViewWithLastMotion r1, Pair r2, boolean r3, String r4, SendImageCell r5, boolean r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r12, Object r13) {
        SimpleDraweeView r0 = this.a;
        Pair r1 = this.b;
        final boolean r3 = this.c;
        String r4 = this.d;
        final SendImageCell r10 = this.e;
        boolean r6 = this.f;
        final String r2 = this.g;
        PipelineDraweeControllerBuilder r14 = (PipelineDraweeControllerBuilder) r12;
        Uri r15 = (Uri) r13;
        int r5 = SendImageCell.t;
        Intrinsics.checkNotNullParameter(r14, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r15, "it");
        r14.setOldController(r0.getController());
        r14.setTapToRetryEnabled(false);
        r14.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r15).setLocalThumbnailPreviewsEnabled(true).setResizeOptions(new ResizeOptions(((Number) r1.getFirst()).intValue(), ((Number) r1.getSecond()).intValue())).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).setDecodePreviewFrame(true).build()).build());
        r14.setControllerListener(new c5(r3, r4, r10.f, r6, AttachmentAreaType.SINGLE_ATTACHMENT, r10.q, new g(r3, r10, r2)));
        r14.setImageOriginListener(new h(r10));
        return Unit.INSTANCE;
    }
}
