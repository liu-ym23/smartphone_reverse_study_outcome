package c7b;

import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chatbase.view.post.PostChatView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PostChatView b;

    public final void a() {
        boolean r1 = true;
        int r2 = 0;
        if (this.a == false) goto L11;
        if (this.b.d.getVisibility() == 0) goto L7;
    L14:
        if (r1 == true) goto L16;
        return;
    L16:
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this.b);
        if (this.a == false) goto L19;
        int r3 = 0;
    L20:
        r0.setVisibility(2131382826, r3);
        if (this.a == true) goto L23;
    L25:
        r2 = 8;
    L26:
        r0.setVisibility(2131382827, r2);
        r0.applyTo(this.b);
        return;
    L23:
        if (this.b.w == false) goto L25;
    L19:
        r3 = 8;
        goto L20
    L7:
        if (this.b.e.getVisibility() != 0) goto L14;
    L9:
        r1 = false;
        goto L14
    L11:
        if (this.b.d.getVisibility() != 8) goto L14;
        if (this.b.e.getVisibility() == 8) goto L9;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(PostChatView r1, boolean r2) {
        this.b = r1;
        this.a = r2;
    }
}
