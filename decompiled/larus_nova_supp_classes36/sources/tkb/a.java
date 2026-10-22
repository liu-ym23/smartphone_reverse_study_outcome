package tkb;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import com.ss.android.lark.image.compose.common.CirclePlaceholderPainter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final CirclePlaceholderPainter a(Composer r9) {
        r9.startReplaceGroup(-129572758);
        long r7 = ColorKt.Color(4292927712L);
        boolean r2 = false;
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-129572758, 0, -1, "com.ss.android.lark.image.compose.common.rememberCirclePlaceholderPainter (CirclePlaceholderPainter.kt:69)");
    L5:
        r9.startReplaceGroup(-1746271574);
        if (r9.changed(r7) == true) goto L8;
        boolean r0 = false;
    L10:
        if (r9.changed(0.0f) == true) goto L12;
        boolean r3 = false;
    L13:
        boolean r1 = r0 | r3;
        if (r9.changed(r7) == false) goto L17;
        r2 = true;
    L17:
        boolean r4 = r1 | r2;
        Object r5 = r9.rememberedValue();
        if (r4 == false) goto L20;
    L21:
        r5 = new CirclePlaceholderPainter(r7, 0.0f, r7);
        r9.updateRememberedValue(r5);
    L22:
        CirclePlaceholderPainter r6 = (CirclePlaceholderPainter) r5;
        r9.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventEnd();
    L25:
        r9.endReplaceGroup();
        return r6;
    L20:
        if (r5 != Composer.Companion.getEmpty()) goto L22;
    L12:
        r3 = true;
        goto L13
    L8:
        r0 = true;
        goto L10
    }
}
