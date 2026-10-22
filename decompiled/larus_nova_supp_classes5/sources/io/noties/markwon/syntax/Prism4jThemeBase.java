package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import etc.d;
import gtc.g;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class Prism4jThemeBase implements d {
    public final ColorHashMap a;

    public static class ColorHashMap extends HashMap<String, a> {
        public ColorHashMap() {
        }

        public ColorHashMap add(int r4, String... r5) {
            a r0 = new a(r4);
            int r6 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L5;
            put(r5[r1], r0);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public ColorHashMap add(int r2, String r3) {
            put(r3, new a(r2));
            return this;
        }

        public ColorHashMap add(int r2, String r3, String r4) {
            a r0 = new a(r2);
            put(r3, r0);
            put(r4, r0);
            return this;
        }

        public ColorHashMap add(int r2, String r3, String r4, String r5) {
            a r0 = new a(r2);
            put(r3, r0);
            put(r4, r0);
            put(r5, r0);
            return this;
        }
    }

    public static class a {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }
    }

    public abstract void d(String r1, String r2, String r3, int r4, SpannableStringBuilder r5, int r6, int r7);

    public Prism4jThemeBase() {
        this.a = new ColorHashMap().add(-9404272, new String[]{"comment", "prolog", "doctype", "cdata"}).add(-6710887, "punctuation").add(-6750123, new String[]{"property", "tag", "boolean", "number", "constant", "symbol", "deleted"}).add(-10053376, new String[]{"selector", "attr-name", "string", "char", "builtin", "inserted"}).add(-6656454, "operator", "entity", "url").add(-16746582, "atrule", "attr-value", EffectConfiguration.KEY_SEARCH_KEYWORD).add(-2274712, "function", "class-name").add(-1140480, "regex", "important", "variable");
    }

    public static boolean e(String r0, String r1, String r2) {
        if (r0.equals(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r0.equals(r2) == true) goto L8;
        return false;
    }

    @Override // etc.d
    public final void b(String r9, g.d r10, SpannableStringBuilder r11, int r12, int r13) {
        String r2 = r10.type();
        String r3 = r10.alias();
        a r14 = this.a.get(r2);
        if (r14 != null) goto L6;
        if (r3 == null) goto L6;
        r14 = this.a.get(r3);
    L6:
        if (r14 == null) goto L8;
        int r4 = r14.a;
    L9:
        if (r4 == 0) goto L12;
        d(r9, r2, r3, r4, r11, r12, r13);
        return;
    L12:
        return;
    L8:
        r4 = 0;
        goto L9
    }
}
