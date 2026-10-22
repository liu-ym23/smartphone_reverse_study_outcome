package com.ss.android.lark.inline.ai.creationai.editor;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ CreationAIEditorWebview a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public h(CreationAIEditorWebview r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = "0,16,0,16";
        this.d = r3;
    }

    public final void accept(Object r5) {
        String r6 = MSkiaImageRegionDecoder.FILE_PREFIX + ((String) r5);
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        Locale r1 = com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        if (r1 != null) goto L5;
        r1 = Locale.ENGLISH;
    L5:
        String r7 = r6 + "?locale=" + (r1.getLanguage() + '-' + r1.getCountry());
        vlb.a r2 = this.a.P;
        if (r2 == null) goto L14;
        FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L14;
        if (h18.f.a(r3) == false) goto L12;
        String r4 = "dark";
    L13:
        r7 = r7 + "&theme=" + r4;
        goto L14
    L12:
        r4 = "light";
    L14:
        String r8 = this.b;
        if (r8 == null) goto L17;
        r7 = r7 + "&bgColor=" + r8;
    L17:
        String r9 = this.c;
        if (r9 == null) goto L20;
        r7 = r7 + "&padding=" + r9;
    L20:
        String r10 = this.d;
        if (r10 == null) goto L23;
        r7 = r7 + "&mode=" + r10;
    L23:
        Log.i(this.a.getMTag(), "loadTemplate  loader = " + r7);
        a r11 = this.a.O;
        if (r11 == null) goto L26;
        System.currentTimeMillis();
        r11.e.postDelayed(r11.h, 10000);
    L26:
        this.a.loadUrl(r7);
    }
}
