package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/enteranim/view/UserSpecialEntryView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserSpecialEntryView extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public final SimpleDraweeView a;
    public final TextView b;
    public final View c;
    public final View d;
    public final HSImageView e;
    public int f;
    public final b g;

    public static final class a {
    }

    public static final class b implements ControllerListener<ImageInfo> {
        public final /* synthetic */ UserSpecialEntryView a;

        public final void onFailure(String r1, Throwable r2) {
        }

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r2) {
        }

        public b(UserSpecialEntryView r1) {
            this.a = r1;
        }

        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
            ImageInfo r3 = (ImageInfo) r2;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            ImageInfo r5 = (ImageInfo) r3;
            if (r5 == null) goto L5;
            int r6 = r5.getWidth();
            int r7 = r5.getHeight();
        L6:
            if (r6 <= 0) goto L8;
            if (r7 <= 0) goto L8;
        L9:
            float r8 = s1.f(32.0f) / r7;
            int r9 = UserSpecialEntryView.h;
            UserSpecialEntryView r10 = this.a;
            int r11 = MathKt.roundToInt(r6 * r8);
            if (r10 == null) goto L16;
            ViewGroup.LayoutParams r13 = r10.getLayoutParams();
            if (r13 == null) goto L14;
            r13.width = r11;
        L14:
            r10.requestLayout();
            return;
        L16:
            return;
        L8:
            ALogger.e("UserSpecialEntryView", "Invalid image info received: (w=" + r6 + ",h=" + r7 + ')');
            r6 = 540;
            r7 = 32;
            goto L9
        L5:
            r6 = 0;
            r7 = 0;
            goto L6
        }
    }

    static {
    }

    public UserSpecialEntryView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(k32.a r8, yb2.a r9) {
        Intrinsics.checkNotNullParameter(r8, "message");
        Intrinsics.checkNotNullParameter(r9, "colorConfig");
        va.a r0 = r8.k;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        va.a r2 = r8.k;
        Object r3 = null;
        if (r2 == null) goto L13;
        k r4 = r2.getTextIcon();
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        va.a r5 = r8.k;
        if (r5 == null) goto L21;
        k r6 = r5.getTextIcon();
        if (r6 == null) goto L21;
        int r7 = t72.a.a;
        String r10 = t72.a.C0283a.a(r6);
    L22:
        if (r10 != null) goto L24;
    L27:
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
        return;
    L30:
        AbstractDraweeController r13 = Fresco.newDraweeControllerBuilder().setUri(r10).setAutoPlayAnimations(true).setControllerListener(this.g).build();
        SimpleDraweeView r14 = this.a;
        if (r14 == null) goto L33;
        r14.setController(r13);
    L33:
        va.a r15 = r8.k;
        if (r15 == null) goto L36;
        a5 r16 = r15.getText();
    L37:
        if (r16 == null) goto L39;
        Spannable r17 = sb2.a.g(r16.getDefaultPattern(), r16, r9).a;
    L40:
        TextView r18 = this.b;
        if (r18 == null) goto L43;
        r18.setText(r17);
    L43:
        va.a r19 = r8.k;
        if (r19 == null) goto L46;
        int r20 = r19.getStayTime();
    L47:
        this.f = r20;
        UserSpecialEntryView$setupUi$iconInPiece$1 r21 = UserSpecialEntryView$setupUi$iconInPiece$1.INSTANCE;
        if (r16 == null) goto L63;
        List r23 = r16.getPieces();
        if (r23 == null) goto L63;
        Iterator r24 = r23.iterator();
    L53:
        if (r24.hasNext() == false) goto L62;
        Object r25 = r24.next();
        c5 r26 = (c5) r25;
        if (r26.getType() == PieceType.USER.getPieceType()) goto L57;
    L59:
        boolean r27 = false;
    L60:
        if (r27 == false) goto L53;
        r3 = r25;
        goto L62
    L57:
        if (r21.invoke(r26) == null) goto L59;
        r27 = true;
    L62:
        r3 = (c5) r3;
    L63:
        k r28 = (k) r21.invoke(r3);
        if (r28 == null) goto L68;
        HSImageView r29 = this.e;
        if (r29 == null) goto L77;
        ImageLoader.bindImage(r29, r28);
        return;
    L77:
        return;
    L68:
        HSImageView r30 = this.e;
        if (r30 == null) goto L79;
        r30.setVisibility(8);
        return;
    L79:
        return;
    L46:
        r20 = 0;
        goto L47
    L39:
        r17 = null;
        goto L40
    L36:
        r16 = null;
        goto L37
    L24:
        if (r10.length() == 0) goto L27;
        r11 = false;
    L21:
        r10 = null;
        goto L22
    L13:
        r4 = null;
        goto L14
    L5:
        if (r0.getType() != 3) goto L7;
        r1 = true;
        goto L8
    }

    public UserSpecialEntryView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567914, this);
        this.a = findViewById(2131363922);
        this.c = findViewById(2131363951);
        this.d = findViewById(2131363936);
        this.b = (TextView) findViewById(2131363955);
        this.e = findViewById(2131363958);
        this.g = new b(this);
    }
}
