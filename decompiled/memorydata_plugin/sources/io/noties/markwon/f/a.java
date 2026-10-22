package io.noties.markwon.f;

import android.os.Build;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lio/noties/markwon/span/SpanCompat;", "", "()V", "newLineBackgroundSpan", "Landroid/text/style/LineBackgroundSpan;", TypedValues.Custom.S_COLOR, "", "newLineHeightSpan", "Landroid/text/style/LineHeightSpan;", "height", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16541a = null;

    static {
        f16541a = new a();
    }

    private a() {
    }

    public final LineBackgroundSpan a(int r3) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        Object r2 = new LineBackgroundSpan.Standard(r3);
    L7:
        return (LineBackgroundSpan) ZeusTransformUtils.preCheckCast(r2, LineBackgroundSpan.class, "com.obric.memorydata.plugin");
    L5:
        r2 = new b(r3);
        goto L7
    }

    public final LineHeightSpan b(int r3) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        Object r2 = new LineHeightSpan.Standard(r3);
    L7:
        return (LineHeightSpan) ZeusTransformUtils.preCheckCast(r2, LineHeightSpan.class, "com.obric.memorydata.plugin");
    L5:
        r2 = new c(r3);
        goto L7
    }
}
