package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/view/StrokeColorTextView;", "Lcom/bytedance/android/livesdk/chatroom/ui/StrokeTextView;", BuildConfig.FLAVOR, "color", BuildConfig.FLAVOR, "setTextColor", "setStrokeColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StrokeColorTextView extends StrokeTextView {
    public LinearGradient f;
    public LinearGradient g;

    public StrokeColorTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StrokeColorTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setStrokeColor(int r2) {
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int r3) {
        this.f = null;
        getPaint().setShader(null);
        super/*android.widget.TextView*/.setTextColor(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(int r10, int r11) {
        this.f = new LinearGradient(0.0f, 1.0f, getPaint().measureText(getText(), 0, getText().length()), 1.0f, r10, r11, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(int[] r10, float[] r11) {
        Intrinsics.checkNotNullParameter(r10, "intArray");
        Intrinsics.checkNotNullParameter(r11, "position");
        this.f = new LinearGradient(0.0f, 0.0f, getPaint().measureText(getText(), 0, getText().length()), 0.0f, r10, r11, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f);
        invalidate();
    }

    public StrokeColorTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ StrokeColorTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
