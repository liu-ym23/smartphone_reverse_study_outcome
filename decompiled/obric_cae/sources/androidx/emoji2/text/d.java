package androidx.emoji2.text;

import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f1743b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f1744a;

    static {
        f1743b = new ThreadLocal();
    }

    public d() {
        TextPaint r8 = new TextPaint();
        this.f1744a = r8;
        r8.setTextSize(10.0f);
    }
}
