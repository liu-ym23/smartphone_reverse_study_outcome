package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/UnionLiveAvatarImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "enable", "", "setEnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveAvatarImageView extends HSImageView {
    public final Paint a;
    public boolean b;

    public UnionLiveAvatarImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UnionLiveAvatarImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super/*android.widget.ImageView*/.onDraw(r6);
        if (this.b == false) goto L6;
        float r1 = 1;
        r6.drawCircle(getWidth() + UtilityKotlinExtentionsKt.h(r1), getHeight() / 2.0f, (getWidth() / 2.0f) + UtilityKotlinExtentionsKt.h(r1), this.a);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnable(boolean r2) {
        this.b = r2;
        if (r2 == false) goto L5;
        int r3 = 2;
    L6:
        setLayerType(r3, null);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public UnionLiveAvatarImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        r5.setColor(-1);
        r5.setDither(true);
        Unit r6 = Unit.INSTANCE;
        this.a = r5;
    }

    public /* synthetic */ UnionLiveAvatarImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
