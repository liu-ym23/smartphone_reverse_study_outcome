package o5a;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.lynx.clay.embedding.engine.plugins.platformview.MeasureMode;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends o5a.a {
    public boolean A;
    public boolean B;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    public class a implements TextWatcher {
        public final /* synthetic */ h a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
            this.a.z();
        }
    }

    public class b implements TextView.OnEditorActionListener {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
            if (r3 == 6) goto L14;
            if (r3 == 2) goto L14;
            if (r3 == 3) goto L14;
            if (r3 == 4) goto L14;
            if (r3 == 5) goto L14;
            if (r3 == 0) goto L14;
            return false;
        L14:
            if (this.a.c("confirm") == false) goto L19;
            HashMap r5 = new HashMap();
            r5.put("value", this.a.h.getText().toString());
            this.a.q("confirm", r5);
            return false;
        L19:
            return false;
        }
    }

    public class c implements d.a {
        public final /* synthetic */ h a;

        @Override // o5a.d.a
        public final void a() {
            h r0 = this.a;
            if (r0.B == true) goto L5;
            return;
        L5:
            r0.B = false;
            r0.e();
        }

        public c(h r1) {
            this.a = r1;
        }
    }

    public final void y() {
        if (this.h.getText().length() == 0) goto L5;
    L7:
        Layout r0 = p5a.a.a(this.h.getText(), this.h, (int) this.y);
    L8:
        this.x = Math.max(Math.min(r0.getHeight(), this.w), this.v);
        return;
    L5:
        if (this.h.getHint() == null) goto L7;
        r0 = p5a.a.a(this.h.getHint(), this.h, (int) this.y);
        goto L8
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void g() {
        super.g();
        if (this.A == false) goto L6;
        z();
        this.A = false;
        return;
    }

    @Override // o5a.a
    public final void u() {
        e();
        this.B = true;
        z();
    }

    public final void z() {
        y();
        if (Math.min((int) this.x, (int) this.u) == this.h.getHeight()) goto L6;
        e();
        return;
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final View a(Context r2) {
        super.a(r2);
        this.h.addTextChangedListener(new a(this));
        this.h.setOnEditorActionListener(new b(this));
        this.h.setOnAfterDrawListener(new c(this));
        this.h.setHorizontallyScrolling(false);
        this.h.setSingleLine(false);
        this.h.setGravity(48);
        return this.h;
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void n(String r3, Object r4) {
        if (r3.equals("min-height") == false) goto L8;
        if ((r4 instanceof Number) == false) goto L24;
        this.v = ((Number) r4).floatValue();
        this.A = true;
        return;
    L24:
        return;
    L8:
        if (r3.equals("max-height") == false) goto L13;
        if ((r4 instanceof Number) == false) goto L26;
        this.w = ((Number) r4).floatValue();
        this.A = true;
        return;
    L26:
        return;
    L13:
        if (r3.equals("maxlines") == false) goto L18;
        if ((r4 instanceof Number) == false) goto L28;
        this.h.setMaxLines(((Number) r4).intValue());
        return;
    L28:
        return;
    L18:
        if (r3.equals("line-spacing") == true) goto L20;
        super.n(r3, r4);
        return;
    L20:
        if ((r4 instanceof Number) == false) goto L30;
        this.h.setLineSpacing(((Number) r4).floatValue(), 1.0f);
        return;
    }

    public h(Context r1, int r2, String r3) {
        super(r1, r2, r3);
        this.u = Float.MAX_VALUE;
        this.v = 0.0f;
        this.w = Float.MAX_VALUE;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = false;
        this.B = false;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final n5a.h f(MeasureMode r4, int r5, MeasureMode r6, int r7) {
        float r8 = r5;
        this.y = r8;
        float r9 = r7;
        this.z = r9;
        MeasureMode r0 = MeasureMode.EXACTLY;
        if (r6 != r0) goto L7;
        if (r4 != r0) goto L7;
        this.u = Float.MAX_VALUE;
        this.B = true;
        return new n5a.h(r8, r9);
    L7:
        y();
        float r10 = this.x;
        this.z = r10;
        if (r6 != MeasureMode.UNDEFINED) goto L11;
        this.u = Float.MAX_VALUE;
    L13:
        this.B = true;
        return new n5a.h(r8, this.z);
    L11:
        if (r6 != MeasureMode.AT_MOST) goto L13;
        this.u = r9;
        this.z = Math.min(r10, r9);
        goto L13
    }
}
