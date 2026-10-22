package kx1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.Option;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a extends FrameLayout implements c {
    public boolean a;
    public final Option b;
    public final e c;

    /* JADX INFO: renamed from: kx1.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0398a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0398a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            a r3 = this.a;
            if (r3.a == false) goto L5;
            r3.c();
            this.a.getListener().b(this.a);
            return;
        L5:
            r3.b();
            this.a.getListener().a(this.a);
        }
    }

    @Override // kx1.c
    public void b() {
        this.a = true;
    }

    @Override // kx1.c
    public void c() {
        this.a = false;
    }

    public abstract int getLayoutId();

    @Override // kx1.c
    public final String a() {
        return this.b.toastText;
    }

    @Override // kx1.c
    public String getOptionKey() {
        String r0 = this.b.key;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // kx1.c
    public Long getSubQuestionId() {
        return this.b.question;
    }

    public final e getListener() {
        return this.c;
    }

    public final Option getOption() {
        return this.b;
    }

    public a(Context r3, Option r4, e r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "option");
        Intrinsics.checkNotNullParameter(r5, "listener");
        super(r3, null, 0);
        this.b = r4;
        this.c = r5;
        setOnClickListener(new ViewOnClickListenerC0398a(this));
    }
}
