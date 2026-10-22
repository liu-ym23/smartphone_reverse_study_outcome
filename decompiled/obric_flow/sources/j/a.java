package j;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Paint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18215a;

    public /* synthetic */ a() {
        this.f18215a = 0;
    }

    private final void a(LocaleList r5) {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList r5) {
        switch(this.f18215a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setTextLocales(r5);
        return;
    }

    public /* synthetic */ a(int r5, int r10) {
        this.f18215a = r10;
        super(r5);
    }

    public a(PorterDuff.Mode r5) {
        this.f18215a = 0;
        super(1);
        setXfermode(new PorterDuffXfermode(r5));
    }
}
