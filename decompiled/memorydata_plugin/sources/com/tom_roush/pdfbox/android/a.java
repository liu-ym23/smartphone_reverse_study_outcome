package com.tom_roush.pdfbox.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AssetManager f16075a;

    static {
    }

    public static InputStream a(String r2) {
        if (f16075a != null) goto L6;
        Log.e("PdfBox-Android", "PDFBoxResourceLoader is not initialized, call PDFBoxResourceLoader.init() before use");
    L6:
        return f16075a.open(r2);
    }

    public static void a(Context r2) {
        f16075a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getAssets();
    }

    public static boolean a() {
        if (f16075a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
