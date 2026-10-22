package com.larus.search.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J(\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/search/impl/LarkAvatarView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/larus/extension/aggregate_search_ui/api/ILarkAvatarView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentKey", "Lkotlin/Pair;", "", "clipPath", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "clearDrawable", "", "bind", "avatarKey", "entityId", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LarkAvatarView extends AppCompatImageView implements ILarkAvatarView {
    public Pair<String, String> a;
    public final Path b;
    public final RectF c;

    public static final class a {
    }

    static {
    }

    public LarkAvatarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LarkAvatarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void clearDrawable() {
        setImageDrawable(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        if (getWidth() > 0) goto L5;
    L7:
        super/*android.widget.ImageView*/.onDraw(r3);
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        int r0 = r3.save();
        r3.clipPath(this.b);
        super/*android.widget.ImageView*/.onDraw(r3);
        r3.restoreToCount(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bind(final String r6, final String r7) {
        Intrinsics.checkNotNullParameter(r6, "avatarKey");
        Intrinsics.checkNotNullParameter(r7, "entityId");
        cza.a r1 = null;
        if (StringsKt.isBlank(r6) == false) goto L6;
        this.a = null;
        setImageDrawable(null);
        return;
    L6:
        final Pair<String, String> r0 = TuplesKt.to(r6, r7);
        if (Intrinsics.areEqual(this.a, r0) == true) goto L9;
    L11:
        this.a = r0;
        setImageDrawable(null);
        Object r2 = xp9.o.a;
        if ((r2 instanceof OfficeSDKUserApi) == false) goto L14;
        OfficeSDKUserApi r3 = (OfficeSDKUserApi) r2;
    L15:
        if (r3 == null) goto L19;
        aza.d r4 = r3.getService(aza.d.class);
        if (r4 == null) goto L19;
        r1 = r4.getAvatarService();
    L19:
        if (r1 != null) goto L22;
        FLogger.a.w("LarkAvatarView", "OfficeSDK avatarService is null, userApi=" + xp9.o.a);
        return;
    L22:
        r1.a(getContext(), new cza.b(r6, r7), new AnonymousClass1(this, r0, r6, r7));
        return;
    L14:
        r3 = null;
        goto L15
    L9:
        if (getDrawable() == null) goto L11;
    }

    public LarkAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new Path();
        this.c = new RectF();
    }

    public /* synthetic */ LarkAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        this.c.set(0.0f, 0.0f, r1, r2);
        this.b.reset();
        this.b.addOval(this.c, Path.Direction.CW);
    }
}
