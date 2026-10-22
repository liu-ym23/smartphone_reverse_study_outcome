package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueViewV2WithClip;", "Landroid/view/View;", "", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OAvatarQueueViewV2WithClip extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f6209c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f6210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Bitmap> f6211h;

    /* JADX INFO: renamed from: com.obric.oui.avatar.OAvatarQueueViewV2WithClip$onDraw$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        AnonymousClass1(OAvatarQueueViewV2WithClip r10) {
            super(r10, OAvatarQueueViewV2WithClip.class, "inParam", "getInParam()Lcom/obric/oui/avatar/OAvatarInParam;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return OAvatarQueueViewV2WithClip.a((OAvatarQueueViewV2WithClip) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r10) {
            OAvatarQueueViewV2WithClip.b((OAvatarQueueViewV2WithClip) this.receiver, (c) r10);
        }
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        super(r10, r11, r12);
        Paint r13 = new Paint();
        r13.setAntiAlias(true);
        Unit r14 = Unit.INSTANCE;
        this.f6209c = r13;
        this.f6211h = new ArrayList();
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ c a(OAvatarQueueViewV2WithClip r10) {
        c r11 = r10.f6210g;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L5:
        return r11;
    }

    public static final /* synthetic */ void b(OAvatarQueueViewV2WithClip r10, c r11) {
        r10.f6210g = r11;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        if (this.f6210g != null) goto L6;
        return;
    L6:
        if (this.f6211h.size() > 0) goto L8;
        return;
    L8:
        c r10 = this.f6210g;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L11:
        int r12 = d.f6221a[r10.d().ordinal()];
        int r13 = 0;
        if (r12 == 1) goto L31;
        if (r12 != 2) goto L45;
        c r14 = this.f6210g;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L18:
        int r15 = r14.a().size();
    L19:
        if (r13 >= r15) goto L52;
        Bitmap r16 = this.f6211h.get(r13);
        if (r13 != 0) goto L23;
        r11.drawBitmap(r16, 0.0f, 0.0f, this.f6209c);
    L30:
        r13 = r13 + 1;
        goto L19
    L23:
        c r17 = this.f6210g;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L26:
        float r18 = r17.b().getDpValue();
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        float r20 = MathKt.roundToInt(TypedValue.applyDimension(1, r18, r19.getDisplayMetrics()));
        c r21 = this.f6210g;
        if (r21 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L29:
        r11.drawBitmap(r16, (r20 - r21.c()) * r13, 0.0f, this.f6209c);
        goto L30
    L52:
        return;
    L45:
        return;
    L31:
        c r22 = this.f6210g;
        if (r22 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L34:
        int r23 = r22.a().size();
    L35:
        if (r13 >= r23) goto L53;
        Bitmap r24 = this.f6211h.get(r13);
        c r25 = this.f6210g;
        if (r13 != 0) goto L41;
        if (r25 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L40:
        float r26 = r25.b().getDpValue();
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        r11.drawBitmap(r24, 0.0f, (MathKt.roundToInt(TypedValue.applyDimension(1, r26, r27.getDisplayMetrics())) / 2) - 1, this.f6209c);
    L44:
        r13 = r13 + 1;
        goto L35
    L41:
        if (r25 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
    L43:
        float r28 = r25.b().getDpValue();
        Resources r29 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r29, "Resources.getSystem()");
        r11.drawBitmap(r24, (MathKt.roundToInt(TypedValue.applyDimension(1, r28, r29.getDisplayMetrics())) / 2) - 1, 0.0f, this.f6209c);
        goto L44
    }
}
