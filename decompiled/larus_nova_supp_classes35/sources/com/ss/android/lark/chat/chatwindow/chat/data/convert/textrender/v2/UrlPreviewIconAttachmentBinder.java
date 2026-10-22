package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.movable.attatchment.IAttachmentBinder;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ClaymoreImpl(IAttachmentBinder.class)
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001b\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u001f\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u0015*\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010$\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\f\u0010'\u001a\u00020(*\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/textrender/v2/UrlPreviewIconAttachmentBinder;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentBinder;", "<init>", "()V", "attachmentTypeId", BuildConfig.FLAVOR, "getAttachmentTypeId", "()I", "bind", BuildConfig.FLAVOR, "container", "Lcom/ss/android/lark/movable/attatchment/AttachmentView;", "info", "Lcom/ss/android/lark/movable/attatchment/AttachmentInfo;", "declareMeasureResolver", "Ljava/lang/Class;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentMeasureResolver;", "generateImageLoader", "Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;", "loadRemoteImage", "url", BuildConfig.FLAVOR, "imageView", "Landroid/widget/ImageView;", "width", "height", "createImageTarget", "com/ss/android/lark/chat/chatwindow/chat/data/convert/textrender/v2/UrlPreviewIconAttachmentBinder$createImageTarget$1", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/textrender/v2/UrlPreviewIconAttachmentBinder$createImageTarget$1;", "withoutQueryParameter", "key", "loadUdIcon", "parseUdIconData", "Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/textrender/v2/UrlPreviewIconAttachmentBinder$MarkdownUDIconData;", "applyTintColorFromKey", "applyTintColor", "tintColor", "convert2ImageInfo", "Lcom/ss/android/lark/movable/attatchment/ImageInfo;", "MarkdownUDIconData", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewIconAttachmentBinder implements IAttachmentBinder {
    private final int attachmentTypeId;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "MarkdownUDIconData(iconKey=" + this.a + ", tintColor=" + this.b + ", unicode=" + this.c + ')';
        }

        public a(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "iconKey");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends SimpleTarget<Drawable> {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ Drawable b;

        public final void onLoadFailed(Drawable r2) {
            super.onLoadFailed(r2);
            this.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.a.setImageDrawable(this.b);
        }

        public final void onResourceReady(Object r2) {
            Drawable r3 = (Drawable) r2;
            super.onResourceReady(r3);
            this.a.setImageDrawable(r3);
        }

        public b(ImageView r1, Drawable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.ss.android.lark.movable.attatchment.p {
        public final /* synthetic */ UrlPreviewIconAttachmentBinder a;

        public final boolean a() {
            return true;
        }

        public c(UrlPreviewIconAttachmentBinder r1) {
            this.a = r1;
        }

        public final void b(String r2, LKUIRoundedImageView2 r3, int r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "imageView");
            Intrinsics.checkNotNullParameter(r6, "urlType");
            if (Intrinsics.areEqual(r6, "ud_icon_key") == false) goto L7;
            UrlPreviewIconAttachmentBinder.access$loadUdIcon(this.a, r2, r3);
            return;
        L7:
            if (Intrinsics.areEqual(r6, "image_key") == false) goto L9;
            UrlPreviewIconAttachmentBinder.access$applyTintColorFromKey(this.a, r2, r3);
            r2 = UrlPreviewIconAttachmentBinder.access$withoutQueryParameter(this.a, r2, "tint_color");
        L9:
            UrlPreviewIconAttachmentBinder.access$loadRemoteImage(this.a, r2, r3, r4, r5);
        }
    }

    private final com.ss.android.lark.movable.attatchment.p generateImageLoader() {
        return new c(this);
    }

    public UrlPreviewIconAttachmentBinder() {
        int r0 = com.ss.android.lark.movable.attatchment.c.a;
        this.attachmentTypeId = com.ss.android.lark.movable.attatchment.c.d;
    }

    public Class<? extends com.ss.android.lark.movable.attatchment.i> declareMeasureResolver() {
        return com.ss.android.lark.movable.attatchment.i.class;
    }

    public int getAttachmentTypeId() {
        return this.attachmentTypeId;
    }

    private final com.ss.android.lark.movable.attatchment.k convert2ImageInfo(com.ss.android.lark.movable.attatchment.b r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Gson r1 = new Gson();     // Catch: Throwable -> L7
        String r2 = (String) r4.g.get("img");     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = BuildConfig.FLAVOR;
    L5:
        Object r3 = Result.constructor-impl((com.ss.android.lark.movable.attatchment.n) r1.fromJson(r2, com.ss.android.lark.movable.attatchment.n.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        com.ss.android.lark.movable.attatchment.n r5 = (com.ss.android.lark.movable.attatchment.n) r3;
        if (r5 != null) goto L16;
        r5 = new com.ss.android.lark.movable.attatchment.n();
    L16:
        return new com.ss.android.lark.movable.attatchment.k(r4, r5);
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private final a parseUdIconData(String r9) {
        if (r9.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L21;
        return null;
    L21:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Uri r4 = UriProtector.parse(r9);     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(new a(StringsKt.substringBefore$default(r9, "?", null, 2, null), UriProtector.getQueryParameter(r4, "tint_color"), UriProtector.getQueryParameter(r4, "unicode")));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = null;
    L17:
        a r6 = (a) r5;
        if (r6 == null) goto L20;
        return r6;
    L20:
        return new a(StringsKt.substringBefore$default(r9, "?", null, 2, null), null, null);
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r1 = false;
        goto L7
    }

    private final void applyTintColor(String r2, ImageView r3) {
        Integer r4 = com.ss.android.lark.movable.utils.g.a(r2);
        if (r4 == null) goto L5;
        r3.setColorFilter(UIUtils.getColor(r3.getContext(), r4.intValue()), PorterDuff.Mode.SRC_IN);
        return;
    L5:
        r3.clearColorFilter();
    }

    private final void applyTintColorFromKey(String r2, ImageView r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r2), "tint_color"));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r4) == false) goto L9;
        r4 = null;
    L9:
        applyTintColor((String) r4, r3);
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final b createImageTarget(ImageView r2, Drawable r3) {
        return new b(r2, r3);
    }

    private final void loadUdIcon(String r4, ImageView r5) {
        a r6 = parseUdIconData(r4);
        String r0 = null;
        if (r6 == null) goto L16;
        String r1 = r6.c;
        if (r1 == null) goto L16;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L16;
        r5.clearColorFilter();
        r5.setImageDrawable(new BitmapDrawable(r5.getContext().getResources(), sbb.d.a(r1)));
        return;
    L9:
        r2 = false;
    L16:
        int r3 = edb.a.a;
        if (r6 == null) goto L19;
        String r7 = r6.a;
    L20:
        r5.setImageResource(edb.a.a(r7));
        if (r6 == null) goto L23;
        r0 = r6.b;
    L23:
        applyTintColor(r0, r5);
        return;
    L19:
        r7 = null;
        goto L20
    }

    private final String withoutQueryParameter(String r14, String r15) {
        int r0 = StringsKt.indexOf$default(r14, '?', 0, false, 6, null);
        if (r0 >= 0) goto L5;
        return r14;
    L5:
        boolean r1 = false;
        String r2 = r14.substring(0, r0);
        List r16 = StringsKt.split$default(r14.substring(r0 + 1), new String[]{"&"}, false, 0, 6, null);
        ArrayList r4 = new ArrayList();
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L11;
        Object r3 = r17.next();
        if ((!Intrinsics.areEqual(StringsKt.substringBefore$default((String) r3, "=", null, 2, null), r15)) == false) goto L7;
        r4.add(r3);
        goto L7
    L11:
        String r18 = CollectionsKt.joinToString$default(r4, "&", null, null, 0, null, null, 62, null);
        if (r18.length() != 0) goto L14;
        r1 = true;
    L14:
        if (r1 == false) goto L17;
        return r2;
    L17:
        return r2 + '?' + r18;
    }

    public void bind(com.ss.android.lark.movable.attatchment.d r9, com.ss.android.lark.movable.attatchment.b r10) {
        Intrinsics.checkNotNullParameter(r9, "container");
        Intrinsics.checkNotNullParameter(r10, "info");
        r9.removeAllViews();
        com.ss.android.lark.movable.attatchment.n r0 = convert2ImageInfo(r10).a();
        int r4 = (int) r10.e;
        int r5 = (int) r10.f;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(r4, r5);
        com.ss.android.lark.movable.attatchment.a r1 = com.ss.android.lark.movable.attatchment.a.a;
        String r3 = r0.b();
        String r6 = r0.a();
        com.ss.android.lark.movable.attatchment.p r7 = generateImageLoader();
        r1.getClass();
        r9.addView(com.ss.android.lark.movable.attatchment.a.a(r9, r3, r4, r5, r6, r7), r11);
    }

    public static final /* synthetic */ void access$applyTintColorFromKey(UrlPreviewIconAttachmentBinder r0, String r1, ImageView r2) {
        r0.applyTintColorFromKey(r1, r2);
    }

    public static final /* synthetic */ void access$loadUdIcon(UrlPreviewIconAttachmentBinder r0, String r1, ImageView r2) {
        r0.loadUdIcon(r1, r2);
    }

    public static final /* synthetic */ String access$withoutQueryParameter(UrlPreviewIconAttachmentBinder r0, String r1, String r2) {
        return r0.withoutQueryParameter(r1, r2);
    }

    private final void loadRemoteImage(String r5, ImageView r6, int r7, int r8) {
        Context r0 = r6.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Drawable r1 = AppCompatResources.getDrawable(r6.getContext(), 2131254898);
        IRequestCreator r9 = ImageLoader.with(r0).override(r7, r8);
        if (StringsKt.startsWith$default(r5, "img_", false, 2, null) == false) goto L8;
        r9.load(new EncryptImage(r5)).error(r1).centerCrop().into(createImageTarget(r6, r1));
        return;
    L8:
        r9.load(r5).centerCrop().into(createImageTarget(r6, r1));
    }

    public static final /* synthetic */ void access$loadRemoteImage(UrlPreviewIconAttachmentBinder r0, String r1, ImageView r2, int r3, int r4) {
        r0.loadRemoteImage(r1, r2, r3, r4);
    }
}
