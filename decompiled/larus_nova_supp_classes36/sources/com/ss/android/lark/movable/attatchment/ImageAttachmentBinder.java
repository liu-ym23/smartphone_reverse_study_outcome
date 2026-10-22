package com.ss.android.lark.movable.attatchment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.google.gson.Gson;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(IAttachmentBinder.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageAttachmentBinder;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentBinder;", "<init>", "()V", "attachmentTypeId", "", "getAttachmentTypeId", "()I", "declareMeasureResolver", "Ljava/lang/Class;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentMeasureResolver;", "bind", "", "container", "Lcom/ss/android/lark/movable/attatchment/AttachmentView;", "info", "Lcom/ss/android/lark/movable/attatchment/AttachmentInfo;", "convert2ImageInfo", "Lcom/ss/android/lark/movable/attatchment/ImageInfo;", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageAttachmentBinder implements IAttachmentBinder {
    public static final a Companion = null;
    private static final String TAG = "ImageAttachmentBinder";
    private final int attachmentTypeId;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ n b;
        public final /* synthetic */ com.ss.android.lark.movable.attatchment.b c;

        public b(d r1, n r2, com.ss.android.lark.movable.attatchment.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.ss.android.lark.movable.b r0 = this.a.getMovableEventClickListener();
            if (r0 == null) goto L7;
            Intrinsics.checkNotNull(r4);
            boolean r1 = true;
            if (r0.c(r4, this.b.b(), this.c) != true) goto L7;
        L8:
            if (r1 == true) goto L14;
            lsb.b.a.getClass();
            lsb.b r2 = (lsb.b) ClaymoreServiceLoader.loadFirstOrNull(lsb.b.class);
            if (r2 != null) goto L12;
            Log.i(ImageAttachmentBinder.TAG, "image preview ignored: no IMovableImagePreviewer impl");
            return;
        L12:
            Intrinsics.checkNotNull(r4);
            this.b.getClass();
            r2.a();
            return;
        L14:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    public ImageAttachmentBinder() {
        int r0 = c.a;
        this.attachmentTypeId = c.b;
    }

    public Class<? extends i> declareMeasureResolver() {
        return ImageMeasureResolver.class;
    }

    @Override // com.ss.android.lark.movable.attatchment.IAttachmentBinder
    public int getAttachmentTypeId() {
        return this.attachmentTypeId;
    }

    private final k convert2ImageInfo(com.ss.android.lark.movable.attatchment.b r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Gson r1 = new Gson();     // Catch: Throwable -> L7
        String r2 = r4.g.get("img");     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Object r3 = Result.constructor-impl((n) r1.fromJson(r2, n.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        n r5 = (n) r3;
        if (r5 != null) goto L16;
        r5 = new n();
    L16:
        return new k(r4, r5);
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.ss.android.lark.movable.attatchment.IAttachmentBinder
    public void bind(d r9, com.ss.android.lark.movable.attatchment.b r10) {
        Intrinsics.checkNotNullParameter(r9, "container");
        Intrinsics.checkNotNullParameter(r10, "info");
        r9.removeAllViews();
        n r0 = convert2ImageInfo(r10).a();
        int r1 = o.a;
        o.a r2 = o.a(r9.getContext(), (int) r10.e, (int) r10.f, TAG);
        int r5 = r2.a;
        int r6 = r2.b;
        ViewGroup.LayoutParams r3 = new FrameLayout.LayoutParams(r5, r6);
        LKUIRoundedImageView2 r4 = com.ss.android.lark.movable.attatchment.a.b(com.ss.android.lark.movable.attatchment.a.a, r9, r0.b(), r5, r6, r0.a());
        String r7 = r0.a();
        if (Intrinsics.areEqual(r7, "image_key") == false) goto L6;
        b r8 = new b(r9, r0, r10);
    L9:
        if (r8 == null) goto L11;
        r4.setOnClickListener(r8);
    L12:
        r9.addView(r4, r3);
        return;
    L11:
        r4.setOnClickListener(null);
        r4.setClickable(false);
        goto L12
    L6:
        if (Intrinsics.areEqual(r7, "ud_icon_key") == false) goto L8;
        int r11 = q.d;
        q.a.a(r0.b());
    L8:
        r8 = null;
        goto L9
    }
}
