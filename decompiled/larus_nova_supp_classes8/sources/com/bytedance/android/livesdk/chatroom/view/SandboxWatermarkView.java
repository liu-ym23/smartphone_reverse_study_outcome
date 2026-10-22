package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/SandboxWatermarkView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SandboxWatermarkView extends View {
    public final String a;
    public final float b;
    public final TextPaint c;

    public SandboxWatermarkView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SandboxWatermarkView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        int r0 = getWidth();
        int r1 = getHeight();
        if (r0 <= 0) goto L12;
        if (r1 <= 0) goto L15;
        float r3 = 4;
        float r2 = r0 / r3;
        float r4 = (r2 / r3) * 5;
        int r5 = (int) ((r1 / r4) + 2);
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L16;
        int r7 = 0;
    L9:
        if (r7 >= 4) goto L11;
        r11.save();
        r11.translate(r7 * r2, r6 * r4);
        r11.rotate(this.b, 0.0f, 0.0f);
        r11.drawText(this.a, 0.0f, 0.0f, this.c);
        r11.restore();
        r7 = r7 + 1;
        goto L9
    L11:
        r6 = r6 + 1;
        goto L7
    L16:
        return;
    L15:
        return;
    }

    public SandboxWatermarkView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "Sandbox 沙盒直播间";
        float r5 = s1.f(14.0f);
        this.b = -25.0f;
        TextPaint r6 = new TextPaint();
        r6.setColor(-16777216);
        r6.setAlpha(20);
        r6.setTextSize(r5);
        Unit r7 = Unit.INSTANCE;
        this.c = r6;
    }

    public /* synthetic */ SandboxWatermarkView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
