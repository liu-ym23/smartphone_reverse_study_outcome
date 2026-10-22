package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Prism4jThemeBase implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ColorHashMap f16681a;

    protected static class ColorHashMap extends HashMap<String, a> {
        public ColorHashMap() {
        }

        public ColorHashMap add(int r1, String r2) {
            put(r2, a.a(r1));
            return this;
        }

        public ColorHashMap add(int r1, String r2, String r3) {
            a r4 = a.a(r1);
            put(r2, r4);
            put(r3, r4);
            return this;
        }

        public ColorHashMap add(int r1, String r2, String r3, String r4) {
            a r5 = a.a(r1);
            put(r2, r5);
            put(r3, r5);
            put(r4, r5);
            return this;
        }

        public ColorHashMap add(int r4, String... r5) {
            a r6 = a.a(r4);
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            put(r5[r1], r6);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }
    }

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final int f16682a;

        public a(int r1) {
            this.f16682a = r1;
        }

        public static a a(int r1) {
            return new a(r1);
        }
    }

    public Prism4jThemeBase() {
        this.f16681a = c();
    }

    public static int a(float r1, int r2) {
        return a((int) ((r1 * 255.0f) + 0.5f), r2);
    }

    public static int a(int r1, int r2) {
        int r3 = r1 << 24;
        return r3 | (r2 & ViewCompat.MEASURED_SIZE_MASK);
    }

    public static boolean a(String r0, String r1, String r2) {
        if (r0.equals(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r0.equals(r2) == true) goto L8;
        return false;
    }

    @Override // io.noties.markwon.syntax.d
    public void a(String r9, io.noties.a.h.d r10, SpannableStringBuilder r11, int r12, int r13) {
        io.noties.a.h.d r14 = (io.noties.a.h.d) ZeusTransformUtils.wrapperContextForParams(r10, io.noties.a.h.d.class, "com.obric.memorydata.plugin");
        String r2 = r14.c();
        String r3 = r14.e();
        int r4 = b(r9, r2, r3);
        if (r4 == 0) goto L6;
        a(r9, r2, r3, r4, r11, r12, r13);
        return;
    }

    public void a(String r1, String r2, String r3, int r4, SpannableStringBuilder r5, int r6, int r7) {
        r5.setSpan(new ForegroundColorSpan(r4), r6, r7, 33);
    }

    public int b(String r2, String r3, String r4) {
        a r5 = (a) ZeusTransformUtils.preCheckCast(this.f16681a.get(r3), a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        if (r4 == null) goto L6;
        r5 = (a) ZeusTransformUtils.preCheckCast(this.f16681a.get(r4), a.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L10;
        return 0;
    L10:
        return r5.f16682a;
    }

    public abstract ColorHashMap c();
}
