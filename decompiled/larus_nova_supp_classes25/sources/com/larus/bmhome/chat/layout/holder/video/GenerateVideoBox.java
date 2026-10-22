package com.larus.bmhome.chat.layout.holder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.n0;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.databinding.LarusVideoPreviewCardBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.larus.image.loader.b0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GenerateVideoBox extends xc8.h {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final c B;
    public Message p;
    public Message q;
    public AiGenVideoContentData r;
    public BotModel s;
    public boolean t;
    public q0.a u;
    public final GenerateVideoBox$actLifecycleObserver$1 v;
    public int w;
    public Message x;
    public final String y;
    public final LarusVideoPreviewCardBinding z;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    public static final class c implements n0 {
        public c() {
        }

        @Override // com.larus.bmhome.chat.layout.holder.image.n0
        public final void a() {
        }

        @Override // com.larus.bmhome.chat.layout.holder.image.n0
        public final void b(String r1, int r2) {
        }
    }

    static {
    }

    public final JSONObject n() {
        Message r1 = this.q;
        String r2 = null;
        if (r1 == null) goto L29;
        Map r3 = r1.getExt();
        if (r3 == null) goto L29;
        String r4 = (String) r3.get("creation_template");
        if (r4 == null) goto L29;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L23
        zd9.h r6 = zd9.h.a;     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r4) == false) goto L49;
    L10:
        Object r7 = null;
    L21:
        Object r0 = Result.constructor-impl((Map) r7);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r0) == false) goto L28;
        r0 = null;
    L28:
        Map r8 = (Map) r0;
    L30:
        JSONObject r9 = new JSONObject();
        if (r8 == null) goto L33;
        String r10 = (String) r8.get("recommend_from");
    L35:
        if (r8 == null) goto L37;
        String r11 = (String) r8.get("from_template_id");
    L39:
        if (r8 == null) goto L41;
        String r12 = (String) r8.get("template_rec_extra");
    L43:
        if (r8 == null) goto L45;
        r2 = (String) r8.get("template_rec_req_id");
    L45:
        r9.put("recommend_from", r10);
        r9.put("from_template_id", r11);
        r9.put("template_rec_req_id", r2);
        r9.put("template_rec_extra", r12);
        return r9;
    L41:
        r12 = null;
        goto L43
    L37:
        r11 = null;
        goto L39
    L33:
        r10 = null;
        goto L35
    L49:
        r6.getClass();     // Catch: Throwable -> L13
        r7 = Result.constructor-impl(zd9.h.b.fromJson(r4, new b().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r13 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L23
        if (r13 == null) goto L19;
        c0 r14 = c0.b;     // Catch: Throwable -> L23
        StringBuilder r15 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r13, "<this>");     // Catch: Throwable -> L23
        r15.append(ExceptionsKt.stackTraceToString(r13));     // Catch: Throwable -> L23
        r14.e("GsonHolder", r15.toString());     // Catch: Throwable -> L23
    L19:
        if (Result.isFailure-impl(r7) == false) goto L21;
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L23
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        r8 = null;
        goto L30
    }

    public final void q() {
        if (this.t == false) goto L5;
        return;
    L5:
        AiGenVideoContentData r0 = this.r;
        if (r0 != null) goto L8;
        return;
    L8:
        SimpleDraweeView r1 = this.z.c;
        CoverItem r2 = r0.getVideoCover();
        String r3 = null;
        if (r2 == null) goto L11;
        String r4 = ff8.b.b(r2);
    L12:
        Uri r5 = b0.a(r4, "chat.video_cover.thumb", false, false, 6);
        AiGenVideoContentData r6 = this.r;
        if (r6 == null) goto L17;
        CoverItem r7 = r6.getVideoCover();
        if (r7 == null) goto L17;
        r3 = ff8.b.a(r7);
    L17:
        o(r1, r5, b0.a(r3, "chat.video_cover", false, false, 6), this.B);
        return;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
        ComponentActivity r0 = getContext();
        if ((r0 instanceof ComponentActivity) == false) goto L5;
        ComponentActivity r1 = r0;
    L6:
        if (r1 == null) goto L11;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L12;
        r2.addObserver(this.v);
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
        r2.removeObserver(this.v);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.w;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.layout.holder.video.GenerateVideoBox$actLifecycleObserver$1] */
    public GenerateVideoBox(Context r10) {
        super(r10);
        this.v = new GenerateVideoBox$actLifecycleObserver$1(this);
        this.w = -1;
        new ResizeOptions(i5.P(), i5.P());
        this.y = "GenerateVideoBox";
        ConstraintLayout r11 = LayoutInflater.from(r10).inflate(2131563199, this, false);
        addView(r11);
        int r0 = 2131368150;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131368150);
        if (r4 == null) goto L19;
        r0 = 2131368153;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r11, 2131368153);
        if (r5 == null) goto L19;
        r0 = 2131382424;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131382424)) == null) goto L19;
        r0 = 2131384158;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131384158)) == null) goto L19;
        r0 = 2131392295;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r11, 2131392295);
        if (r6 == null) goto L19;
        r0 = 2131392296;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131392296);
        if (r7 == null) goto L19;
        r0 = 2131392301;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, 2131392301);
        if (r8 == null) goto L19;
        this.z = new LarusVideoPreviewCardBinding(r11, r4, r5, r6, r7, r8);
        this.B = new c();
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        this.w = r1;
    }

    public final void o(final SimpleDraweeView r18, final Uri r19, Uri r20, final c r21) {
        if (r19 != null) goto L7;
        if (r20 != null) goto L7;
        FLogger.a.e(this.y, "loadImage url is invalid ");
        r18.setActualImageResource(2131240764);
        return;
    L7:
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        final String r4 = y0.k(r20);
        Message r0 = this.p;
        ImageDecodeOptions r1 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        if (r19 == null) goto L10;
        final ImageRequest r2 = ImageRequestBuilder.newBuilderWithSource(r19).setImageDecodeOptions(r1).build();
    L11:
        if (r0 == null) goto L13;
        String r11 = r0.getMessageId();
    L14:
        MessageImageLoader r12 = MessageImageLoader.a;
        MessageImageType r13 = MessageImageType.VIDEO;
        if (r20 == null) goto L17;
        String r14 = r20.toString();
    L18:
        final String r8 = r11;
        IMessageImageLoaderService.a.a(r12, r11, r13, r18, r14, null, new d(r2, r18, r3, r4, this, r19, r21, r8), 48);
        return;
    L17:
        r14 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L10:
        r2 = null;
        goto L11
    }
}
