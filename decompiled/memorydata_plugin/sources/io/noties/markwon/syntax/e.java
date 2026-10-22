package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import io.noties.markwon.core.spans.i;
import io.noties.markwon.core.spans.r;

/* JADX INFO: loaded from: classes6.dex */
public class e extends Prism4jThemeBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16689a;

    public e(int r1) {
        this.f16689a = r1;
    }

    public static e a(int r1) {
        return new e(r1);
    }

    @Override // io.noties.markwon.syntax.d
    public int a() {
        return this.f16689a;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public void a(String r15, String r16, String r17, int r18, SpannableStringBuilder r19, int r20, int r21) {
        if ("css".equals(r15) == false) goto L9;
        if (a(TypedValues.Custom.S_STRING, r16, r17) == false) goto L9;
        super.a(r15, r16, r17, -6656454, r19, r20, r21);
        r19.setSpan(new BackgroundColorSpan(-2130706433), r20, r21, 33);
        return;
    L9:
        if (a("namespace", r16, r17) == false) goto L11;
        int r4 = a(0.7f, r18);
    L12:
        super.a(r15, r16, r17, r4, r19, r20, r21);
        if (a("important", r16, r17) == false) goto L15;
    L16:
        r19.setSpan(new r(), r20, r21, 33);
    L18:
        if (a("italic", r16, r17) == false) goto L21;
        r19.setSpan(new i(), r20, r21, 33);
        return;
    L21:
        return;
    L15:
        if (a("bold", r16, r17) == false) goto L18;
    L11:
        r4 = r18;
        goto L12
    }

    @Override // io.noties.markwon.syntax.d
    public int b() {
        return -587202560;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public Prism4jThemeBase.ColorHashMap c() {
        return new Prism4jThemeBase.ColorHashMap().add(-9404272, new String[]{"comment", "prolog", "doctype", "cdata"}).add(-6710887, "punctuation").add(-6750123, new String[]{"property", LocationMonitorConst.TAG, TypedValues.Custom.S_BOOLEAN, "number", "constant", "symbol", "deleted"}).add(-10053376, new String[]{"selector", "attr-name", TypedValues.Custom.S_STRING, "char", "builtin", "inserted"}).add(-6656454, "operator", "entity", "url").add(-16746582, "atrule", "attr-value", "keyword").add(-2274712, "function", "class-name").add(-1140480, "regex", "important", "variable");
    }
}
