package com.tom_roush.pdfbox.pdmodel;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class PDPageContentStream implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f16139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16140b;

    public static final enum AppendMode extends Enum<AppendMode> {
        private static final /* synthetic */ AppendMode[] $VALUES = null;
        public static final AppendMode APPEND = null;
        public static final AppendMode OVERWRITE = null;
        public static final AppendMode PREPEND = null;

        static {
            AppendMode r0 = new AppendMode("OVERWRITE", 0);
            OVERWRITE = r0;
            AppendMode r1 = new AppendMode("APPEND", 1);
            APPEND = r1;
            AppendMode r3 = new AppendMode("PREPEND", 2);
            PREPEND = r3;
            $VALUES = new AppendMode[]{r0, r1, r3};
        }

        private AppendMode(String r1, int r2) {
            super(r1, r2);
        }

        public static AppendMode valueOf(String r2) {
            return (AppendMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppendMode.class, r2), AppendMode.class, "com.obric.memorydata.plugin");
        }

        public static AppendMode[] values() {
            return (AppendMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppendMode[].class, "com.obric.memorydata.plugin");
        }

        public boolean isOverwrite() {
            if (this != OVERWRITE) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPrepend() {
            if (this != PREPEND) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f16140b == false) goto L5;
        Log.w("PdfBox-Android", "You did not call endText(), some viewers won't display your text");
    L5:
        OutputStream r0 = this.f16139a;
        if (r0 == null) goto L9;
        r0.close();
        this.f16139a = null;
        return;
    }
}
