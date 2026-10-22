package com.larus.bmhome.block.newheader.foldcontainer;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import kb8.n;
import lb8.h;
import nb8.l;
import tk8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r4, int r5, int r6) {
            r4.a(r5, r6, new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        }
    }

    void a(int r1, int r2, Interpolator r3);

    void b(String r1);

    void c();

    h d();

    n e();

    f f();

    l g();

    void h(st8.a r1, CustomMarkdownTextView r2);

    com.larus.bmhome.chat.standarduikit.vlm.view.b i();
}
