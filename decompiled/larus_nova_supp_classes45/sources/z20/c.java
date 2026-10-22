package z20;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends Dialog {
    public Button a;
    public Button b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(2131565488);
        setCanceledOnTouchOutside(false);
        this.a = (Button) findViewById(2131377737);
        this.b = (Button) findViewById(2131384558);
        Button r3 = this.a;
        if (r3 == null) goto L5;
        r3.setOnClickListener(new a(this));
    L5:
        Button r4 = this.b;
        if (r4 == null) goto L9;
        r4.setOnClickListener(new b(this));
        return;
    }

    public c(Context r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954683);
        this.c = r3;
        this.d = r4;
    }
}
