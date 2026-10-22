package com.larksuite.component.card.component.udicon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.card.component.image.UniversalCardRoundedImageView;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.card.utils.CardImageRender;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import idb.f;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\r\b\u0016\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002./B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0014J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J,\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\u0012H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u00060"}, d2 = {"Lcom/larksuite/component/card/component/udicon/UniversalCardUDIconUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/image/UniversalCardRoundedImageView;", "Lcom/larksuite/component/card/component/image/UniversalCardRoundedImageView$OnSizeChangeListener;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "tag", "", "imageRequest", "Lcom/larksuite/component/card/component/udicon/UniversalCardUDIconUI$ImageRequest;", "mImageLoadListener", "com/larksuite/component/card/component/udicon/UniversalCardUDIconUI$mImageLoadListener$1", "Lcom/larksuite/component/card/component/udicon/UniversalCardUDIconUI$mImageLoadListener$1;", "createView", "Landroid/content/Context;", "onSizeChange", "", "w", "", "h", "oldw", "oldh", "setOnClickListener", "imageView", "setUDIconContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "getImageRequest", "udIconContent", "Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "loadImage", "setIconRes", "udIconResId", "color", "customColor", "isColorfulIcon", "", "getColorResIdByToken", "clearView", "getJsonAttachment", "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "udIconContentProps", "cardShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "Companion", "ImageRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UniversalCardUDIconUI extends LynxUI<UniversalCardRoundedImageView> implements UniversalCardRoundedImageView.a {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public b b;
    public final c c;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final ResourceCleanScene b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            ResourceCleanScene r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ImageRequest(key=" + this.a + ", resourceCleanScene=" + this.b + ')';
        }

        public b(String r2, ResourceCleanScene r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements ListenerParams.b {
        public final /* synthetic */ UniversalCardUDIconUI a;

        public c(UniversalCardUDIconUI r1) {
            this.a = r1;
        }

        public final void a(Exception r3) {
            int r4 = UniversalCardMonitorUtils.a;
            com.larksuite.component.card.monitor.c r5 = com.larksuite.component.card.monitor.c.b;
            String r0 = ((OPMonitorCode) r5).message;
            Intrinsics.checkNotNullParameter(r5, "code");
            Intrinsics.checkNotNullParameter(r0, "errorMsg");
            fyb.e r1 = com.larksuite.component.card.monitor.b.a;
            com.larksuite.component.card.monitor.b.c.a(r5).setErrorMessage(r0).flush();
        }

        public final void b(Object r2, Object r3, DataSource r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            if ((r3 instanceof EncryptImage) == true) goto L5;
            return;
        L5:
            if ((r2 instanceof ukb.a) == false) goto L9;
            String r6 = this.a.a;
            StringBuilder r7 = new StringBuilder("onResourceReady key is ");
            r7.append(((EncryptImage) r3).getEncryptKey());
            r7.append(", resource  ");
            ukb.a r8 = (ukb.a) r2;
            r7.append(r8.getIntrinsicWidth());
            r7.append('x');
            r7.append(r8.getIntrinsicHeight());
            r7.append(", view width ");
            r7.append(((UniversalCardRoundedImageView) UniversalCardUDIconUI.N(this.a)).getMeasuredWidth());
            Log.d(r6, r7.toString());
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ UniversalCardUDIconUI a;
        public final /* synthetic */ int b;
        public final /* synthetic */ UDIconContentProps c;
        public final /* synthetic */ Ref.BooleanRef d;

        public d(UniversalCardUDIconUI r1, int r2, UDIconContentProps r3, Ref.BooleanRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UniversalCardUDIconUI.O(this.a, this.b, this.c.getColor(), this.c.getCustomColor(), this.d.element);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ UniversalCardUDIconUI a;
        public final /* synthetic */ b b;

        public e(UniversalCardUDIconUI r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UniversalCardUDIconUI r0 = this.a;     // Catch: Throwable -> L4
            b r1 = this.b;     // Catch: Throwable -> L4
            int r2 = UniversalCardUDIconUI.d;     // Catch: Throwable -> L4
            r0.Q(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void P() {
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setImageDrawable(null);
        if (f.a().isEnable("universalcard.ud_icon.tint_mode.fix") == true) goto L5;
        ((UniversalCardRoundedImageView) ((LynxUI) this).mView).setImageTintMode(null);
    L5:
        ImageLoader.clear(((LynxUI) this).mView);
    }

    public UniversalCardUDIconUI(LynxContext r1) {
        super(r1);
        this.a = "cardUdIconUi";
        this.c = new c(this);
    }

    public static final /* synthetic */ LynxContext M(UniversalCardUDIconUI r0) {
        return ((LynxBaseUI) r0).mContext;
    }

    public static final /* synthetic */ View N(UniversalCardUDIconUI r0) {
        return ((LynxUI) r0).mView;
    }

    public final void Q(b r5) {
        final String r0 = r5.a;
        int r1 = CardImageRender.a;
        CardImageRender.c(CardImageRender.b(((UniversalCardRoundedImageView) ((LynxUI) this).mView).getContext(), (ImageView) ((LynxUI) this).mView, r5.b), getWidth(), getHeight(), new UniversalCardUDIconUI$loadImage$1(this, r0));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, android.widget.ImageView, com.larksuite.component.card.component.image.UniversalCardRoundedImageView, java.lang.Object] */
    public final View createView(Context r2) {
        ?? r0 = new UniversalCardRoundedImageView(r2);
        Intrinsics.checkNotNullParameter(r0, "imageView");
        r0.setOnLongClickListener(new com.larksuite.component.card.component.udicon.b(this, r0));
        r0.setOnSizeChangedListener(this);
        return r0;
    }

    @LynxProp(name = "props")
    public final void setUDIconContent(ReadableMap r11) {
        TraceEvent.beginSection("UniversalCardUDIconUI.setUDIconContent");
        if (r11 != null) goto L6;
        Log.i(this.a, "props null");
        P();
        return;
    L6:
        Intrinsics.checkNotNullParameter(r11, "readableMap");
        UDIconContentProps r1 = new UDIconContentProps(r11.getString("token"), r11.getString("color"), r11.getString("customColor"), r11.getString("imageID"), r11.getBoolean("isTranslateElement", false), Integer.valueOf(r11.getInt("iconSize", 0)));
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r12 = r1.getToken();
        if (r12 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == false) goto L23;
        String r14 = r1.getImageId();
        if (r14 != null) goto L17;
    L20:
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        boolean r16 = true;
    L24:
        if (r16 == false) goto L27;
        Log.i(this.a, "props isInvalid");
        P();
        return;
    L27:
        Ref.BooleanRef r17 = new Ref.BooleanRef();
        ResourceCleanScene r4 = null;
        if (r1.getToken() == null) goto L30;
        r17.element = StringsKt.endsWith$default(r1.getToken(), "colorful", false, 2, null);
    L30:
        int r3 = com.larksuite.component.card.utils.d.a;
        int r5 = com.larksuite.component.card.utils.d.a(r1.getToken(), getLynxContext().getContext());
        if (r5 == 0) goto L33;
        ThreadUtils.runOnUIThread(new d(this, r5, r1, r17));
    L59:
        TraceEvent.endSection("UniversalCardUDIconUI.setUDIconContent");
        return;
    L33:
        Object r19 = getLynxContext().getSharedData("card_share_data");
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
        com.larksuite.component.card.cardcontainer.c r110 = (com.larksuite.component.card.cardcontainer.c) r19;
        if (r1.isTranslateElement() == false) goto L39;
        CardContent r111 = r110.b.getTranslateContent();
        if (r111 == null) goto L38;
        CardAttachment r112 = r111.getAttachment();
    L40:
        if (r112 == null) goto L44;
        HashMap<String, RichTextElement.ImageProperty> r113 = r112.getImages();
        if (r113 == null) goto L44;
        RichTextElement.ImageProperty r114 = r113.get(r1.getImageId());
    L45:
        if (r114 == null) goto L47;
        r4 = r114.getResourceCleanScene();
    L47:
        if (r114 == null) goto L53;
        CardDataUtils.a.getClass();
        Image r115 = CardDataUtils.d(r114, 1);
        if (r115 == null) goto L54;
        String r116 = r115.getKey();
        if (r116 == null) goto L54;
    L55:
        b r2 = new b(r116, r4);
        this.b = r2;
        if (TextUtils.isEmpty(r2.a) == true) goto L58;
        ThreadUtils.runOnUIThread(new e(this, r2));
        goto L59
    L58:
        P();
    L54:
        r116 = "";
        goto L55
    L53:
        P();
        Log.e(this.a, "imageProperty null " + r1.getImageId());
    L44:
        r114 = null;
        goto L45
    L38:
        r112 = null;
        goto L40
    L39:
        r112 = r110.b.getCardContent().getAttachment();
        goto L40
    L17:
        if (r14.length() == 0) goto L20;
        r15 = false;
    L23:
        r16 = false;
        goto L24
    L9:
        if (r12.length() == 0) goto L12;
        r13 = false;
        goto L13
    }

    @Override // com.larksuite.component.card.component.image.UniversalCardRoundedImageView.a
    public final void I(int r1, int r2) {
        if (r1 == 0) goto L11;
        if (r2 == 0) goto L14;
        b r3 = this.b;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.b == null) goto L13;
        Q(r3);
        return;
    L13:
        return;
    L14:
        return;
    }

    public static final void O(UniversalCardUDIconUI r6, int r7, String r8, String r9, boolean r10) {
        Log.d(r6.a, "token color name:" + r8);
        if (r10 == false) goto L5;
        Drawable r11 = UDIconUtils.getIconDrawable(((LynxBaseUI) r6).mContext, r7);
    L25:
        ((UniversalCardRoundedImageView) ((LynxUI) r6).mView).setImageDrawable(r11);
        return;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L7;
        r11 = UDIconUtils.getIconDrawable(((LynxBaseUI) r6).mContext, r7, ColorProtector.parseColor(r9));
        goto L25
    L7:
        if (r8 == null) goto L23;
        int r12 = com.larksuite.component.card.utils.d.a;
        Intrinsics.checkNotNullParameter(r8, "udColor");
        if (Intrinsics.areEqual(r8, "icon-disabled") == false) goto L11;
        r8 = "icon-disable";
    L11:
        String r0 = r8;
        int r13 = UDColorUtils.getColorIdByToken(((LynxBaseUI) r6).mContext, r0);
        if (r13 == 0) goto L14;
    L17:
        if (r13 != 0) goto L19;
        Drawable r14 = UDIconUtils.getIconDrawable(((LynxBaseUI) r6).mContext, r7);
    L20:
        if (r14 == null) goto L23;
        r11 = r14;
        goto L25
    L19:
        r14 = UDIconUtils.getIconDrawable(((LynxBaseUI) r6).mContext, r7, ((LynxBaseUI) r6).mContext.getResources().getColor(r13));
        goto L20
    L14:
        if (StringsKt.startsWith$default(r0, "ud_", false, 2, null) == true) goto L17;
        r13 = UDColorUtils.getColorIdByToken(((LynxBaseUI) r6).mContext, "ud_" + StringsKt.replace$default(r0, "-", "_", false, 4, null));
    L23:
        r11 = UDIconUtils.getIconDrawable(((LynxBaseUI) r6).mContext, r7);
        goto L25
    }
}
