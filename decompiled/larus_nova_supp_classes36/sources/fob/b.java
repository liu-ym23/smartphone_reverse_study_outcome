package fob;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import androidx.appcompat.widget.AppCompatEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.at.EditTextSpanHolder;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.b;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b<T extends hob.b> implements com.ss.android.lark.keyboard.edittext2.widget.f, com.ss.android.lark.keyboard.edittext2.edittors.at.d {
    public final /* synthetic */ EditTextSpanHolder a;

    public final void a(Function1<? super FunctionEditText, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.a.a(r2);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a.c(r2);
    }

    public Object e() {
        return null;
    }

    public b() {
        this.a = new EditTextSpanHolder("AnchorEditor");
    }

    public final Pair<Integer, Integer> b(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "editable");
        return TuplesKt.to(Integer.valueOf(r2.getSpanStart(this)), Integer.valueOf(r2.getSpanEnd(this)));
    }

    public final void f(Editable r6, SpannableStringBuilder r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "editable");
        Intrinsics.checkNotNullParameter(r7, "target");
        Pair<Integer, Integer> r1 = b(r6);
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        if (r2 == (-1)) goto L7;
        if (r3 == (-1)) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == true) goto L16;
        Intrinsics.checkNotNullParameter(r6, "editable");
        r6.removeSpan(this);
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r6, r2, r3);
        if (r8 == false) goto L12;
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r7, 0, r7.length());
    L12:
        r6.replace(r2, r3, r7);
        Object r9 = e();
        if (r9 == null) goto L17;
        r6.removeSpan(r9);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r4 = true;
        goto L8
    }

    public final void d(SpannableStringBuilder r2, hob.b r3, int r4, RichTextElement r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r5, "element");
        Map<String, String> r0 = r3.b;
        if (r0 == null) goto L5;
        r5.getStyle().putAll(r0);
    L5:
        Map<String, String> r6 = r3.b;
        AppCompatEditText r7 = this.a.b;
        if (r7 == null) goto L8;
        Context r8 = r7.getContext();
    L9:
        com.ss.android.lark.keyboard.edittext2.edittors.richText.c.b(r2, 0, r4, r6, r8);
        return;
    L8:
        r8 = null;
        goto L9
    }
}
