package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J(\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J4\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002J\u001c\u0010!\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueViewV2WithClip;", "Landroid/view/View;", "Lcom/obric/oui/avatar/IOAvatarQueueViewV2WithClipOperation;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "inParam", "Lcom/obric/oui/avatar/OAvatarInParam;", "mAvatarBitmapQueue", "", "Landroid/graphics/Bitmap;", "mPaint", "Landroid/graphics/Paint;", "convertBitmap2Circle", "avatarSize", "originBitmap", "convertBitmap2CircleClip", "overLapSizeDp", "shape", "Lcom/obric/oui/avatar/OAvatarQueueShape;", "convertBitmapWithTransBorder", "clipType", CommonConsts.APM_INNER_EVENT_COST_INIT, "", AutoTestConstant.PARAM, "onDraw", "canvas", "Landroid/graphics/Canvas;", "recycleAvatarQueueBitmap", "clip", "toCircle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueViewV2WithClip extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f13311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.avatar.a f13312b;
    private List<Bitmap> c;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13313a = null;

        static {
            int[] r0 = new int[OAvatarQueueShape.values().length];
            r0[OAvatarQueueShape.Group.ordinal()] = 1;
            r0[OAvatarQueueShape.Queue.ordinal()] = 2;
            f13313a = r0;
        }
    }

    public OAvatarQueueViewV2WithClip(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "ctx");
        this(r1, null, 0, 6, null);
    }

    public OAvatarQueueViewV2WithClip(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this(r3, r4, 0, 4, null);
    }

    public OAvatarQueueViewV2WithClip(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "ctx");
        super(r6, r7, r5);
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        this.f13311a = r8;
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        if (this.f13312b != null) goto L6;
        return;
    L6:
        if (this.c.size() > 0) goto L8;
        return;
    L8:
        com.obric.oui.avatar.a r0 = this.f13312b;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r0 = null;
    L11:
        int r1 = a.f13313a[r0.b().ordinal()];
        int r3 = 0;
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L47;
        com.obric.oui.avatar.a r2 = this.f13312b;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r2 = null;
    L18:
        int r4 = r2.c().size();
    L19:
        if (r3 >= r4) goto L54;
        int r5 = r3 + 1;
        List<Bitmap> r6 = this.c;
        if (r3 != 0) goto L23;
        r12.drawBitmap((Bitmap) ZeusTransformUtils.preCheckCast(r6.get(r3), Bitmap.class, "com.obric.memorydata.plugin"), 0.0f, 0.0f, this.f13311a);
    L30:
        r3 = r5;
        goto L19
    L23:
        Bitmap r7 = (Bitmap) ZeusTransformUtils.preCheckCast(r6.get(r3), Bitmap.class, "com.obric.memorydata.plugin");
        View r8 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.avatar.a r9 = this.f13312b;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r9 = null;
    L26:
        float r10 = h.b(r8, r9.a().getDpValue());
        View r11 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.avatar.a r13 = this.f13312b;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r13 = null;
    L29:
        r12.drawBitmap(r7, (r10 - h.b(r11, r13.d())) * r3, 0.0f, this.f13311a);
        goto L30
    L54:
        return;
    L47:
        return;
    L31:
        com.obric.oui.avatar.a r14 = this.f13312b;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r14 = null;
    L34:
        int r15 = r14.c().size();
    L35:
        if (r3 >= r15) goto L55;
        int r16 = r3 + 1;
        List<Bitmap> r17 = this.c;
        if (r3 != 0) goto L42;
        Bitmap r18 = (Bitmap) ZeusTransformUtils.preCheckCast(r17.get(r3), Bitmap.class, "com.obric.memorydata.plugin");
        View r19 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.avatar.a r110 = this.f13312b;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r110 = null;
    L41:
        r12.drawBitmap(r18, 0.0f, (h.b(r19, r110.a().getDpValue()) / 2) - 1, this.f13311a);
    L46:
        r3 = r16;
        goto L35
    L42:
        Bitmap r20 = (Bitmap) ZeusTransformUtils.preCheckCast(r17.get(r3), Bitmap.class, "com.obric.memorydata.plugin");
        View r21 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.avatar.a r111 = this.f13312b;
        if (r111 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r111 = null;
    L45:
        r12.drawBitmap(r20, (h.b(r21, r111.a().getDpValue()) / 2) - 1, 0.0f, this.f13311a);
        goto L46
    }
}
