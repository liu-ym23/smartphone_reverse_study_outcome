package com.xiphias.browser.scanner.b;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.xiphias.browser.scanner.ScannerMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/xiphias/browser/scanner/feature/VisionFeatureProvider;", "", "cleanupExpired", "", "context", "Landroid/content/Context;", "decode", "Landroid/graphics/Bitmap;", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "createLaunch", "Lcom/xiphias/browser/scanner/feature/VisionLaunch;", "bitmap", "mode", "Lcom/xiphias/browser/scanner/ScannerMode;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {
    Bitmap a(ContentResolver r1, Uri r2);

    c a(Context r1, Bitmap r2, ScannerMode r3);
}
