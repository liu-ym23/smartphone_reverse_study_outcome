package com.lynx.markdown;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MarkdownMeasurer {

    public static final class MeasureResult {
        private final float mHeight;
        private final List<String> mLines;
        private final float mWidth;

        public int getLineCount() {
            return this.mLines.size();
        }

        public float getHeight() {
            return this.mHeight;
        }

        public List<String> getLines() {
            return this.mLines;
        }

        public float getWidth() {
            return this.mWidth;
        }

        private MeasureResult(float r1, float r2, String[] r3) {
            this.mWidth = r1;
            this.mHeight = r2;
            this.mLines = Collections.unmodifiableList(Arrays.asList(r3));
        }

        public /* synthetic */ MeasureResult(float r1, float r2, String[] r3, a r4) {
            this(r1, r2, r3);
        }
    }

    public static /* synthetic */ class a {
    }

    private MarkdownMeasurer() {
    }

    private static native byte[] nativeMeasure(String r0, byte[] r1, float r2, int r3, float r4);

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_markdown_MarkdownMeasurer_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static MeasureResult measure(String r6, HashMap<String, Object> r7, float r8, int r9) {
        if (Float.isNaN(r8) == true) goto L47;
        if (Float.isInfinite(r8) == true) goto L47;
        if (r8 < 0.0f) goto L47;
        Markdown.ensureInitialized();
        g r0 = new g();
        r0.b(r7);     // Catch: IOException -> L43
        float r10 = INVOKEVIRTUAL_com_lynx_markdown_MarkdownMeasurer_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density;
        if (r6 != null) goto L48;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        j r11 = new j(new ByteArrayInputStream(nativeMeasure(r6, r0.a.toByteArray(), r8, r9, r10)));     // Catch: IOException -> L40
        float r12 = r11.readFloat();     // Catch: Throwable -> L32
        float r13 = r11.readFloat();     // Catch: Throwable -> L32
        int r14 = r11.readInt();     // Catch: Throwable -> L32
        if (r14 < 0) goto L31;
        String[] r1 = new String[r14];     // Catch: Throwable -> L32
        int r2 = 0;
    L18:
        if (r2 >= r14) goto L27;
        int r3 = r11.readInt();     // Catch: Throwable -> L32
        if (r3 < 0) goto L26;
        if (r3 != 0) goto L23;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        r1[r2] = r4;     // Catch: Throwable -> L32
        r2 = r2 + 1;     // Catch: Throwable -> L32
        goto L18
    L23:
        byte[] r5 = new byte[r3];     // Catch: Throwable -> L32
        r11.readFully(r5);     // Catch: Throwable -> L32
        r4 = new String(r5, StandardCharsets.UTF_8);     // Catch: Throwable -> L32
        goto L24
    L26:
        throw new IOException("Invalid string length");     // Catch: Throwable -> L32
    L27:
        MeasureResult r15 = new MeasureResult(r12, r13, r1, null);     // Catch: Throwable -> L32
        r11.close();     // Catch: IOException -> L40
        return r15;
    L31:
        throw new IOException("Invalid Markdown measure line count");     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L37
    L39:
        throw th;     // Catch: IOException -> L40
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L40
    L40:
        e = move-exception;
        throw new IllegalStateException("Failed to read Markdown measure result", e);
    L43:
        e = move-exception;
        throw new IllegalStateException("Failed to serialize Markdown style", e);
    L47:
        throw new IllegalArgumentException("maxWidth must be finite and non-negative");
    }
}
