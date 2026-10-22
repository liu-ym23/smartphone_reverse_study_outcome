package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.l0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageUtils;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.GetIconBackgroundApi;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TextPosterHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Function1 d;

        public a(Context r1, String r2, Function1 r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            int r0 = qo0.a.a;
            StringBuilder r1 = new StringBuilder("get icon background data success, data: ");
            if (r9 == null) goto L5;
            com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.c r2 = (com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.c) r9.data;
        L6:
            r1.append(r2);
            qo0.a.c("TextPosterHelper", r1.toString());
            int r3 = TextPosterHelper.a;
            Context r4 = this.a;
            if (r9 == null) goto L12;
            com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.c r5 = (com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.c) r9.data;
            if (r5 == null) goto L12;
            String r6 = r5.a();
            if (r6 == null) goto L12;
        L13:
            String r7 = this.b;
            if (r9 == null) goto L21;
            com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.c r10 = (com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.c) r9.data;
            if (r10 == null) goto L21;
            String r11 = r10.b();
            if (r11 == null) goto L21;
            String r12 = r11;
        L22:
            TextPosterHelper.b(r4, r6, r7, r12, this.c, this.d);
            return;
        L21:
            r12 = "";
        L12:
            r6 = "";
            goto L13
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = qo0.a.a;
            qo0.a.c("TextPosterHelper", "get icon background data fail, error: " + r4);
            Function1 r1 = this.a;
            if (r1 == null) goto L6;
            Unit r5 = (Unit) r1.invoke(r4);
            return;
        }
    }

    static {
    }

    public static String a(ProductInfo r3) {
        if (r3 == null) goto L9;
        String r1 = r3.productId;
        if (r1 == null) goto L9;
        if (r2.a(r1) != true) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L21;
        String r4 = r3.title;
        if (r4 != null) goto L18;
        return null;
    L18:
        if ((true ^ StringsKt.isBlank(r4)) == true) goto L20;
        return null;
    L20:
        return r4;
    L21:
        return null;
    L9:
        r2 = false;
        goto L11
    }

    public static Disposable c(Context r2, String r3, String r4, Function1 r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "onSuccess");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (r6 == null) goto L13;
        Unit r7 = (Unit) r6.invoke(new Throwable("title is empty"));
        return null;
    L13:
        return null;
    L11:
        Lazy r1 = LiveOpenPlatformClient.c;
        return ((GetIconBackgroundApi) LiveOpenPlatformClient.a.a().a(GetIconBackgroundApi.class)).getIconBackground(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r2, r4, r5, r6), new b(r6));
    L5:
        r0 = false;
        goto L6
    }

    public static void d(TextView r4, int r5, int r6, int r7, float[] r8) {
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        r4.setTextSize(r8[r1]);
        r4.forceLayout();
        r4.measure(View.MeasureSpec.makeMeasureSpec(r6, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION), View.MeasureSpec.makeMeasureSpec(r7, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION));
        if (r4.getLineCount() <= r5) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    }

    public static Disposable b(Context r19, String r20, String r21, String r22, final Function1 r23, final Function1 r24) {
        Intrinsics.checkNotNullParameter(r19, "context");
        String r6 = r20;
        Intrinsics.checkNotNullParameter(r6, "backgroundColor");
        Intrinsics.checkNotNullParameter(r21, "title");
        String r7 = r22;
        Intrinsics.checkNotNullParameter(r7, "titleColor");
        Intrinsics.checkNotNullParameter(r23, "onSuccess");
        if (r21.length() != 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L88;
        if (r24 == null) goto L10;
        Unit r0 = (Unit) r24.invoke(new Throwable("title is empty"));
    L10:
        return null;
    L88:
    L19:
        Integer r8 = null;
    L83:
    L28:
        Integer r9 = null;
    L29:
        if (r8 == null) goto L79;
        if (r9 == null) goto L79;
        long r11 = SystemClock.uptimeMillis();
        int r13 = UtilityKotlinExtentionsKt.i(110);
        int r10 = UtilityKotlinExtentionsKt.i(110);
        int r12 = r8.intValue();
        int r14 = UtilityKotlinExtentionsKt.i(98);
        int r15 = UtilityKotlinExtentionsKt.i(78);
        int r16 = r9.intValue();
        Bitmap r17 = Bitmap.createBitmap(r13, r10, Bitmap.Config.ARGB_8888);
        Canvas r18 = new Canvas(r17);
        r18.drawColor(r12);
        Drawable r25 = ContextCompat.getDrawable(r19, 2131243752);
        if (r25 == null) goto L34;
        r25.setBounds(new Rect(0, 0, r13, r10));
    L34:
        if (r25 == null) goto L36;
        r25.draw(r18);
    L36:
        TextView r26 = new TextView(r19);
        r26.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r26.setEllipsize(TextUtils.TruncateAt.END);
        r26.setIncludeFontPadding(false);
        r26.setMaxLines(3);
        r26.setText(r21);
        r26.setLineSpacing(UtilityKotlinExtentionsKt.h(2), 1.0f);
        r26.setShadowLayer(2.0f, 0.0f, 1.0f, ColorProtector.parseColor("#27000000"));
        r26.setTextColor(r16);
        long r27 = SystemClock.uptimeMillis();
        IHostService r1 = TTLiveSDK.hostService();
        if (r1 == null) goto L42;
        IHostLiveOpenPlatform r2 = r1.hostOpenPlatform();
        if (r2 == null) goto L42;
        Typeface r3 = r2.getDuxFontSync(r19);
        if (r3 == null) goto L42;
    L43:
        r26.setTypeface(r3);
        int r4 = qo0.a.a;
        qo0.a.c("TextPosterHelper", "get dux font duration: " + (SystemClock.uptimeMillis() - r27));
        r26.setTextSize(19.5f);
        r26.measure(View.MeasureSpec.makeMeasureSpec(r14, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION), View.MeasureSpec.makeMeasureSpec(r15, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION));
        if (r26.getLineCount() != 1) goto L47;
        d(r26, 1, r14, r15, new float[]{49.0f, 32.5f, 24.5f, 19.5f});
    L49:
        int r28 = r26.getMeasuredWidth();
        int r29 = r26.getMeasuredHeight();
        r26.layout(0, 0, r28, r29);
        r18.save();
        r18.translate((r13 - r28) / 2.0f, ((r10 - r29) - ((r15 - r29) / 2.0f)) - UtilityKotlinExtentionsKt.h(12));
        r26.draw(r18);
        r18.restore();
        qo0.a.c("TextPosterHelper", "on create text poster bitmap finished, duration: " + (SystemClock.uptimeMillis() - r11));
        int r30 = ImageUtils.a;
        Function2<String, String, Unit> r31 = new TextPosterHelper$getTextPosterUrl$3(r23);
        Function1<Throwable, Unit> r32 = new TextPosterHelper$getTextPosterUrl$4(r24);
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter("text_poster", "tag");
        Intrinsics.checkNotNullParameter(r17, "bitmap");
        Intrinsics.checkNotNullParameter(r31, "onUploadSuccess");
        long r33 = SystemClock.uptimeMillis();
        File r34 = r19.getExternalCacheDir();
        if (r34 != null) goto L52;
    L58:
        PolarisFileWrapper r35 = new PolarisFileWrapper(r34, "/miniapp_cover");
        if (r35.exists() == true) goto L61;
        r35.mkdir();
    L61:
        PolarisFileWrapper r36 = new PolarisFileWrapper(r34, "text_poster_" + System.currentTimeMillis() + ".jpeg");
        PolarisFileOutputStreamWrapper r37 = new PolarisFileOutputStreamWrapper(r36);     // Catch: Throwable -> L69 Exception -> L71
        r17.compress(Bitmap.CompressFormat.JPEG, 100, r37);     // Catch: Throwable -> L65 Exception -> L67
        l0.a(r37);
        qo0.a.c("ImageUtils", "on save image to disk finished, duration: " + (SystemClock.uptimeMillis() - r33));
        MultipartTypedOutput r38 = new MultipartTypedOutput();
        r38.addPart("file", new TypedFile("multipart/form-data", r36));
        return ImageUtils.a(r38, r31, r32);
    L67:
        e = e;
    L73:
        Unit r39 = (Unit) r32.invoke(new Throwable("write image file fail, error: " + e));     // Catch: Throwable -> L65
        l0.a(r37);
    L75:
        return null;
    L65:
        th = th;
        File r110 = r34;
    L77:
        l0.a(r110);
        throw th;
    L71:
        e = e;
        r37 = null;
    L69:
        th = th;
        r110 = null;
        goto L77
    L52:
        if (r34.exists() == true) goto L58;
        r34 = r19.getCacheDir();
        if (r34 == null) goto L58;
        if (r34.exists() == true) goto L58;
        Unit r40 = (Unit) r32.invoke(new Throwable("cache dir is invalid"));
        goto L75
    L47:
        if (r26.getLineCount() != 2) goto L49;
        d(r26, 2, r14, r15, new float[]{24.5f, 19.5f});
    L42:
        r3 = Typeface.DEFAULT;
    L79:
        if (r24 == null) goto L92;
        Unit r41 = (Unit) r24.invoke(new Throwable("background/text color is invalid"));
        return null;
    L92:
        return null;
    L21:
        if (r2.a(r22) == true) goto L24;
        r7 = null;
    L24:
        if (r7 != null) goto L26;
        r7 = "#262626";
    L26:
        r9 = Integer.valueOf(Color.parseColor(r7));     // Catch: Exception -> L28
        goto L29
    L12:
        if (r2.a(r20) == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L17;
        r6 = "#E4E4E4";
    L17:
        r8 = Integer.valueOf(Color.parseColor(r6));     // Catch: Exception -> L19
        goto L83
    L5:
        r5 = false;
        goto L7
    }
}
