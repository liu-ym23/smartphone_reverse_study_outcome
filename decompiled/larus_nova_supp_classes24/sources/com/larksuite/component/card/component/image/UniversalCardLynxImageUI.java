package com.larksuite.component.card.component.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.settings.MsgCardImgMemoryOptConfig;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.card.utils.CardImageRender;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u001e\b\u0016\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002STB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020!H\u0014J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u001c2\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020\u001cH\u0002J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0017J\u0012\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/H\u0017J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020#H\u0016J\u0006\u00106\u001a\u00020#J\b\u00107\u001a\u00020#H\u0002J\u001a\u00108\u001a\u0004\u0018\u0001092\u0006\u00103\u001a\u0002042\u0006\u0010:\u001a\u00020;H\u0002J\u0012\u0010<\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020\u000fH\u0016J \u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016J \u0010H\u001a\u00020I2\u0006\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020)2\u0006\u0010E\u001a\u00020\u0015H\u0016J\u0010\u0010J\u001a\u00020#2\u0006\u0010E\u001a\u00020\u0015H\u0016J\u0010\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020)H\u0016J\b\u0010M\u001a\u00020#H\u0002J(\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020)H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006U"}, d2 = {"Lcom/larksuite/component/card/component/image/UniversalCardLynxImageUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/image/UniversalCardRoundedImageView;", "Lcom/larksuite/component/card/component/image/UniversalCardRoundedImageView$OnSizeChangeListener;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "mOriginImage", "Lcom/ss/android/lark/widget/richtext/Image;", "getMOriginImage", "()Lcom/ss/android/lark/widget/richtext/Image;", "setMOriginImage", "(Lcom/ss/android/lark/widget/richtext/Image;)V", "mCanPreview", "", "getMCanPreview", "()Z", "setMCanPreview", "(Z)V", "mImageRequest", "Lcom/larksuite/component/card/component/image/UniversalCardLynxImageUI$ImageRequest;", "getMImageRequest", "()Lcom/larksuite/component/card/component/image/UniversalCardLynxImageUI$ImageRequest;", "setMImageRequest", "(Lcom/larksuite/component/card/component/image/UniversalCardLynxImageUI$ImageRequest;)V", "previewImages", "", "", "mImageLoadListener", "com/larksuite/component/card/component/image/UniversalCardLynxImageUI$mImageLoadListener$1", "Lcom/larksuite/component/card/component/image/UniversalCardLynxImageUI$mImageLoadListener$1;", "createView", "Landroid/content/Context;", "setImageRes", "", "resId", "tintColor", "cropType", "Lcom/larksuite/component/card/component/image/CropType;", "getDrawableFromMap", "", "setPreviewImages", "images", "Lcom/lynx/react/bridge/ReadableArray;", "setImageContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "setImageTintMode", "isImageTransparent", "setImageClick", "imageContentProps", "Lcom/larksuite/component/card/component/image/ImageContentProps;", "disablePreview", "clearView", "resetImageRenderState", "getJsonAttachment", "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "cardShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "dispatchTouch", "ev", "Landroid/view/MotionEvent;", "dispatchEvent", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "handleLongImage", "showTag", "loadImageNew", "imageRequest", "targetW", "targetH", "monitorRequestListener", "Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$MonitorRequestListener;", "reportEvent", "onBorderRadiusUpdated", "index", "updateRadius", "onSizeChange", "w", "h", "oldw", "oldh", "Companion", "ImageRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UniversalCardLynxImageUI extends LynxUI<UniversalCardRoundedImageView> implements UniversalCardRoundedImageView.a {
    public static final /* synthetic */ int f = 0;
    public Image a;
    public boolean b;
    public b c;
    public final List<String> d;
    public final d e;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;
        public final ResourceCleanScene f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.c) * 31) + this.d) * 31;
            String r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            ResourceCleanScene r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ImageRequest(key=" + this.a + ", cropType=" + this.b + ", originWidth=" + this.c + ", originHeight=" + this.d + ", loadingStyle=" + this.e + ", resourceCleanScene=" + this.f + ')';
        }

        public b(String r2, String r3, int r4, int r5, String r6, ResourceCleanScene r7) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CropType.values().length];
            r0[CropType.LEFT_TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CropType.STRETCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CropType.CROP_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d implements ListenerParams.b {
        public final /* synthetic */ UniversalCardLynxImageUI a;

        public d(UniversalCardLynxImageUI r1) {
            this.a = r1;
        }

        public final void a(Exception r2) {
            fyb.e r3 = com.larksuite.component.card.monitor.b.a;
            com.larksuite.component.card.monitor.c r4 = com.larksuite.component.card.monitor.c.b;
            com.larksuite.component.card.monitor.b r0 = com.larksuite.component.card.monitor.b.c.a(r4);
            r0.setErrorMessage(((OPMonitorCode) r4).message);
            r0.flush();
        }

        public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "dataSource");
            if ((r2 instanceof EncryptImage) == true) goto L5;
            return;
        L5:
            if ((r1 instanceof ukb.a) == false) goto L9;
            StringBuilder r5 = new StringBuilder("onResourceReady key is ");
            r5.append(((EncryptImage) r2).getEncryptKey());
            r5.append(", resource  ");
            ukb.a r6 = (ukb.a) r1;
            r5.append(r6.getIntrinsicWidth());
            r5.append('x');
            r5.append(r6.getIntrinsicHeight());
            r5.append(", view width ");
            r5.append(((UniversalCardRoundedImageView) UniversalCardLynxImageUI.M(this.a)).getMeasuredWidth());
            Log.d("UniversalCardLynxImageUI", r5.toString());
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ com.larksuite.component.card.component.image.a a;
        public final /* synthetic */ UniversalCardLynxImageUI b;
        public final /* synthetic */ CropType c;

        public e(com.larksuite.component.card.component.image.a r1, UniversalCardLynxImageUI r2, CropType r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = this.a.j();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            UniversalCardLynxImageUI r1 = this.b;     // Catch: Throwable -> L6
            com.larksuite.component.card.component.image.a r2 = this.a;     // Catch: Throwable -> L6
            CropType r3 = this.c;     // Catch: Throwable -> L6
            r1.U(r0, r2.k(), r3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.ImageView, com.larksuite.component.card.component.image.UniversalCardRoundedImageView] */
    public final void P() {
        this.b = false;
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setOnClickListener(null);
        this.a = null;
        this.c = null;
        T();
        ?? r0 = (UniversalCardRoundedImageView) ((LynxUI) this).mView;
        r0.d = null;
        r0.invalidate();
    }

    public final void T() {
        ImageLoader.clear(((LynxUI) this).mView);
        Object r0 = ((LynxUI) this).mView;
        ((UniversalCardRoundedImageView) r0).g = 0;
        ((UniversalCardRoundedImageView) r0).setImageDrawable(new ColorDrawable(0));
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setImageMatrix(new Matrix());
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public UniversalCardLynxImageUI(LynxContext r1) {
        super(r1);
        this.d = new ArrayList();
        this.e = new d(this);
    }

    public static final /* synthetic */ View M(UniversalCardLynxImageUI r0) {
        return ((LynxUI) r0).mView;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.ImageView, com.larksuite.component.card.component.image.UniversalCardRoundedImageView] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.widget.ImageView, com.larksuite.component.card.component.image.UniversalCardRoundedImageView] */
    public final void R(boolean r6) {
        if (r6 == false) goto L4;
        ?? r7 = (UniversalCardRoundedImageView) ((LynxUI) this).mView;
        r7.e = r7.getContext().getString(2131891989);
        Paint r0 = new Paint();
        r7.b = r0;
        r0.setTextSize(UIUtils.sp2px(r7.getContext(), 10.0f));
        r7.b.setColor(UIUtils.getColor(r7.getContext(), 2131106521));
        r7.d = new Rect();
        Paint r1 = r7.b;
        String r2 = r7.e;
        r1.getTextBounds(r2, 0, r2.length(), r7.d);
        Paint r3 = r7.b;
        r7.f = Math.abs(r3.ascent() + r3.descent()) / 2.0f;
        Paint r4 = new Paint();
        r7.c = r4;
        r4.setColor(UIUtils.getColor(r7.getContext(), 2131106511));
        r7.j(r7.getWidth(), r7.getHeight());
        r7.invalidate();
        return;
    L4:
        ?? r8 = (UniversalCardRoundedImageView) ((LynxUI) this).mView;
        r8.d = null;
        r8.invalidate();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.ImageView, com.larksuite.component.card.component.image.UniversalCardRoundedImageView] */
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ?? r0 = new UniversalCardRoundedImageView(r2);
        r0.setOnLongClickListener(new com.larksuite.component.card.component.image.c(this, r0));
        r0.setOnSizeChangedListener(this);
        return r0;
    }

    public final boolean dispatchEvent(LynxEventDetail r3) {
        if (((UniversalCardRoundedImageView) ((LynxUI) this).mView) == null) goto L14;
        if (r3 == null) goto L6;
        String r0 = r3.a.getName();
    L8:
        if (TextUtils.equals(r0, "tap") == false) goto L14;
        if (this.b == false) goto L14;
        return true;
    L6:
        r0 = null;
    L14:
        return super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.dispatchEvent(r3);
    }

    public final boolean dispatchTouch(MotionEvent r3) {
        if (this.b == false) goto L9;
        if (r3 == null) goto L9;
        if (r3.getAction() != 1) goto L9;
        recognizeGesturere();
    L9:
        return super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.dispatchTouch(r3);
    }

    public final void onBorderRadiusUpdated(int r4) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onBorderRadiusUpdated(r4);
        com.lynx.tasm.behavior.ui.utils.a r5 = getBackgroundManager();
        if (r5 == null) goto L7;
        BorderRadius r6 = r5.m();
        if (r6 == null) goto L7;
        float[] r7 = r6.a();
    L8:
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.length != 0) goto L12;
        boolean r0 = true;
    L14:
        if ((!r0) == false) goto L18;
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setRadius(r7[0]);
        return;
    L18:
        return;
    L12:
        r0 = false;
    L7:
        r7 = null;
        goto L8
    }

    @LynxProp(name = "props")
    public void setImageContent(ReadableMap r24) {
        TraceEvent.beginSection("UniversalCardLynxImageUI.setImageContent");
        if (r24 != null) goto L6;
        Log.i("UniversalCardLynxImageUI", "props null");
        P();
        return;
    L6:
        Intrinsics.checkNotNullParameter(r24, "readableMap");
        boolean r5 = false;
        final com.larksuite.component.card.component.image.a r6 = new com.larksuite.component.card.component.image.a(r24.getString("image_id"), r24.getString("res_id"), r24.getString("tint_color"), r24.getString("crop_type"), r24.getBoolean("isTranslateElement", false), r24.getBoolean("forcePreview", false), Integer.valueOf(r24.getInt("originWidth", 0)), Integer.valueOf(r24.getInt("originHeight", 0)), r24.getBoolean("disableLongImageTag", true), r24.getBoolean("transparent", true), r24.getBoolean("disableTap", true), r24.getString("loadingStyle"), r24.getBoolean("preview", false));
        Log.d("UniversalCardLynxImageUI", "setImageContent, " + r6.e());
        Intrinsics.checkNotNullParameter(r6, "<this>");
        String r0 = r6.j();
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L23;
        String r2 = r6.e();
        if (r2 != null) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L28;
        Log.i("UniversalCardLynxImageUI", "props isInvalid");
        P();
        return;
    L28:
        if (k.b(r6.j()) == false) goto L40;
        String r7 = r6.a();
        if (r7 != null) goto L32;
    L33:
        r5 = true;
    L34:
        if (r5 == false) goto L87;
        CropType r8 = CropType.CROP_CENTER;
    L39:
        ThreadUtils.runOnUIThread(new e(r6, this, r8));
    L85:
        TraceEvent.endSection("UniversalCardLynxImageUI.setImageContent");
        return;
    L87:
        r8 = CropType.valueOf(r7);     // Catch: Exception -> L38
    L38:
        r8 = CropType.CROP_CENTER;
        goto L39
    L32:
        if (r7.length() != 0) goto L34;
    L40:
        Object r9 = getLynxContext().getSharedData("card_share_data");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
        CardAttachment r10 = Q(r6, (com.larksuite.component.card.cardcontainer.c) r9);
        if (r10 == null) goto L45;
        HashMap<String, RichTextElement.ImageProperty> r11 = r10.getImages();
        if (r11 == null) goto L45;
        final RichTextElement.ImageProperty r12 = r11.get(r6.e());
    L46:
        if (r12 != null) goto L49;
        P();
        Log.e("UniversalCardLynxImageUI", "imageProperty null " + r6.e());
        return;
    L49:
        CardDataUtils r13 = CardDataUtils.a;
        LynxContext r14 = ((LynxBaseUI) this).mContext;
        MsgCardImgMemoryOptConfig r15 = (MsgCardImgMemoryOptConfig) SettingManager.getInstance().get(MsgCardImgMemoryOptConfig.class);
        DevicePerfUtils.a r16 = DevicePerfUtils.e();
        String r17 = Build.MODEL;
        List<String> r19 = r15.whiteList;
        if (r19 != null) goto L52;
    L54:
        List<String> r110 = r15.blackList;
        if (r110 != null) goto L57;
    L59:
        if (r16 == null) goto L65;
        if (r16.e >= r15.minOverallScore) goto L65;
        Log.i("UniversalCardUtil", "enableThumbImage: true, device score < minOverallScore");
    L63:
        boolean r20 = true;
    L69:
        if (r20 == false) goto L71;
        int r21 = 2;
    L72:
        r13.getClass();
        final Image r22 = CardDataUtils.d(r12, r21);
        this.a = CardDataUtils.d(r12, 0);
        int r23 = CardImageRender.a;
        final com.suite.lark.platform.component.widgetrenderinterceptor.a r111 = CardImageRender.b(((UniversalCardRoundedImageView) getView()).getContext(), (ImageView) getView(), r12.getResourceCleanScene());
        if (r22 == null) goto L75;
        final boolean r112 = !r6.b();
        boolean r113 = true;
        boolean r114 = false;
        ThreadUtils.runOnUIThread(new UniversalCardLynxImageUI$setImageContent$1$2(r22, r6, r12, this, r111, r112));
    L77:
        if (r6.i() == false) goto L79;
    L84:
        this.b = r113;
        CardImageRender.a(r111, new UniversalCardLynxImageUI$setImageContent$1$3$1(this, r6));
        goto L85
    L79:
        if (r6.d() == true) goto L84;
        if (r6.c() == false) goto L84;
        this.b = r114;
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setOnClickListener(null);
        goto L85
    L75:
        r113 = true;
        r114 = false;
        P();
        goto L77
    L71:
        r21 = 1;
    L65:
        if (UIHelper.getWindowWidth(r14) >= r15.maxScreenWidthForThumb) goto L67;
        r20 = true;
    L68:
        Log.i("UniversalCardUtil", "enableThumbImage:" + r20 + ", screen with compare finish");
        goto L69
    L67:
        r20 = false;
        goto L68
    L57:
        if (r110.contains(r17) == false) goto L59;
        Log.i("UniversalCardUtil", "enableThumbImage: false, device is in blacklist");
        r20 = false;
        goto L69
    L52:
        if (r19.contains(r17) == false) goto L54;
        Log.i("UniversalCardUtil", "enableThumbImage: true, device is in whitelist");
    L45:
        r12 = null;
        goto L46
    L17:
        if (r2.length() == 0) goto L20;
        r3 = false;
    L23:
        r4 = false;
        goto L24
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    }

    @LynxProp(name = "previewImages")
    public void setPreviewImages(ReadableArray r11) {
        ArrayList r9 = new ArrayList();
        if (r11 == null) goto L10;
        int r0 = r11.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L10;
        String r2 = r11.getString(r1);
        if (r2 == null) goto L9;
        r9.add(r2);
    L9:
        r1 = r1 + 1;
    L10:
        Log.d("UniversalCardLynxImageUI", "setPreviewImages, " + CollectionsKt.joinToString$default(r9, null, null, null, 0, null, null, 63, null));
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(r9);
    }

    public static final void N(UniversalCardLynxImageUI r2, com.larksuite.component.card.component.image.a r3) {
        ((UniversalCardRoundedImageView) ((LynxUI) r2).mView).setOnClickListener(new com.larksuite.component.card.component.image.d(r2, r3));
    }

    public static final void O(UniversalCardLynxImageUI r2, boolean r3) {
        if (r3 == false) goto L4;
        ((UniversalCardRoundedImageView) ((LynxUI) r2).mView).setImageTintList(null);
        ((UniversalCardRoundedImageView) ((LynxUI) r2).mView).setImageTintMode(null);
        return;
    L4:
        ColorStateList r4 = UDColorUtils.getColorStateList(((LynxBaseUI) r2).mContext, 2131101951);
        ((UniversalCardRoundedImageView) ((LynxUI) r2).mView).setImageTintMode(PorterDuff.Mode.SRC_OVER);
        ((UniversalCardRoundedImageView) ((LynxUI) r2).mView).setImageTintList(r4);
    }

    @Override // com.larksuite.component.card.component.image.UniversalCardRoundedImageView.a
    public final void I(final int r5, final int r6) {
        if (r5 == 0) goto L9;
        if (r6 == 0) goto L11;
        final b r0 = this.c;
        if (r0 == null) goto L10;
        T();
        int r1 = CardImageRender.a;
        CardImageRender.c(CardImageRender.b(((UniversalCardRoundedImageView) getView()).getContext(), (ImageView) getView(), r0.f), r5, r6, new UniversalCardLynxImageUI$onSizeChange$1$1(this, r0, r5, r6));
        return;
    L10:
        return;
    L11:
        return;
    }

    public final CardAttachment Q(com.larksuite.component.card.component.image.a r1, com.larksuite.component.card.cardcontainer.c r2) {
        if (r1.m() == false) goto L9;
        CardContent r3 = r2.b.getTranslateContent();
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.getAttachment();
    L9:
        return r2.b.getCardContent().getAttachment();
    }

    public final void S(b r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "imageRequest");
        if (r7 == 0) goto L40;
        if (r8 == 0) goto L40;
        Log.d("UniversalCardLynxImageUI", "targetW = " + r7 + " targetH = " + r8);
        if (TextUtils.isEmpty(r6.a) == true) goto L38;
        IRequestCreator r1 = ImageLoader.with(((LynxBaseUI) this).mContext).override(r7, r8).load(new EncryptImage(r6.a));
        String r2 = r6.b;
        if (r2 == null) goto L32;
        int r3 = r2.hashCode();
        if (r3 == (-1881872635)) goto L26;
        if (r3 == (-1364013995)) goto L22;
        if (r3 != 1104318730) goto L32;
        if (r2.equals("aspect_fill") == false) goto L32;
        r1.fitCenter();
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.FIT_CENTER);
    L34:
        if (y0.a("laser", r6.e) == false) goto L36;
        r1.placeholder(2131231233);
    L37:
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).g = r7;
        IRequestCreator r4 = r1.dontAnimate(false);
        Intrinsics.checkNotNullParameter(r6, "imageRequest");
        ListenerParams.a r5 = new ListenerParams.a();
        r5.c(ListenerParams.FromType.CARD);
        r5.c = r7;
        r5.d = r8;
        r5.h = this.e;
        r5.o = r6.a;
        r4.listener(new PerfLoadPicMonitor.MonitorRequestListener(r5.b())).error(2131232485).into((ImageView) ((LynxUI) this).mView);
        return;
    L36:
        r1.placeholder(2131232531);
        goto L37
    L22:
        if (r2.equals("center") == false) goto L32;
        r1.override(r6.c, r6.d);
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.CENTER);
        goto L34
    L26:
        if (r2.equals("stretch") == false) goto L32;
        if ((r7 / r8) >= (r6.c / r6.d)) goto L31;
        r1.centerCrop();
    L31:
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.MATRIX);
    L32:
        r1.centerCrop();
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L34
    L38:
        Intrinsics.checkNotNullParameter(r6, "imageRequest");
        fyb.e r9 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(com.larksuite.component.card.monitor.c.a).addTag("UniversalCardLynxImageUI").flush();
        Log.e("UniversalCardLynxImageUI", "local url in rich text render! token: " + r6.a);
        return;
    L40:
        Log.d("UniversalCardLynxImageUI", "Loading image size 0 ,wait on size change");
    }

    public final void U(String r5, String r6, CropType r7) {
        Intrinsics.checkNotNullParameter(r5, "resId");
        int r1 = -1;
        switch(r5.hashCode()) {
            case -2125429965: goto L62;
            case -1727580755: goto L58;
            case -1482607618: goto L54;
            case -1182079653: goto L50;
            case -1176629883: goto L46;
            case -1015746476: goto L42;
            case -666946518: goto L38;
            case -154350177: goto L34;
            case 938701424: goto L30;
            case 950887542: goto L26;
            case 1237613497: goto L22;
            case 1428070857: goto L18;
            case 1452187563: goto L14;
            case 1955805502: goto L10;
            case 2093040139: goto L6;
            default: goto L65;
        };
    L65:
        int r0 = -1;
    L66:
        if (r0 != (-1)) goto L69;
        r0 = ((LynxBaseUI) this).mContext.getResources().getIdentifier(r5, "drawable", ((LynxBaseUI) this).mContext.getPackageName());
    L69:
        if (k.b(r6) == false) goto L71;
        int r8 = ColorProtector.parseColor(r6);
        Drawable r9 = UDIconUtils.getIconDrawable(((LynxBaseUI) this).mContext, r0, r8);
    L72:
        if (r7 == null) goto L76;
        r1 = c.a[r7.ordinal()];
    L76:
        if (r1 != 1) goto L78;
    L83:
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.MATRIX);
    L84:
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setImageDrawable(r9);
        return;
    L78:
        if (r1 == 2) goto L83;
        if (r1 != 3) goto L84;
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setScaleType(ImageView.ScaleType.CENTER_CROP);
        goto L84
    L71:
        r9 = UDIconUtils.getIconDrawable(((LynxBaseUI) this).mContext, r0);
        goto L72
    L6:
        if (r5.equals("ud_illustration_empty_neutral_search_failed") == false) goto L65;
        r0 = 2131238164;
        goto L66
    L10:
        if (r5.equals("icon_up_bold_outlined") == false) goto L65;
        r0 = 2131256076;
        goto L66
    L14:
        if (r5.equals("icon_right_outlined") == false) goto L65;
        r0 = 2131255566;
        goto L66
    L18:
        if (r5.equals("ud_icon_down_outlined") == false) goto L65;
        r0 = 2131254261;
        goto L66
    L22:
        if (r5.equals("illustration_empty_neutral_to_be_upgraded") == false) goto L65;
        r0 = 2131238165;
        goto L66
    L26:
        if (r5.equals("ud_icon_more_outlined") == false) goto L65;
        r0 = 2131255147;
        goto L66
    L30:
        if (r5.equals("ud_icon_up_outlined") == false) goto L65;
        r0 = 2131256084;
        goto L66
    L34:
        if (r5.equals("illustration_empty_neutral_404") == false) goto L65;
        r0 = 2131238145;
        goto L66
    L38:
        if (r5.equals("icon_left_bold_outlined") == false) goto L65;
        r0 = 2131254996;
        goto L66
    L42:
        if (r5.equals("icon_left_outlined") == false) goto L65;
        r0 = 2131254998;
        goto L66
    L46:
        if (r5.equals("icon_down_bold_outlined") == false) goto L65;
        r0 = 2131254256;
        goto L66
    L50:
        if (r5.equals("ud_icon_loading_outlined") == false) goto L65;
        r0 = 2131255040;
        goto L66
    L54:
        if (r5.equals("ud_icon_time_outlined") == false) goto L65;
        r0 = 2131256006;
        goto L66
    L58:
        if (r5.equals("ud_icon_calendar_outlined") == false) goto L65;
        r0 = 2131253990;
        goto L66
    L62:
        if (r5.equals("icon_right_bold_outlined") == false) goto L65;
        r0 = 2131255563;
        goto L66
    }
}
