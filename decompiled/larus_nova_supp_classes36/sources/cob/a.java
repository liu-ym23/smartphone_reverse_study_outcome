package cob;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0<Unit> a;

    public a(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.invoke();
    }
}
