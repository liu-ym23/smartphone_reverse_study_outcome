package kb2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends kk6.a<jb2.c> {

    /* JADX INFO: renamed from: kb2.a$a, reason: collision with other inner class name */
    public static final class C0243a {
    }

    static {
    }

    public a() {
    }

    public final String e(ek6.d r2) {
        jb2.c r3 = (jb2.c) r2;
        Intrinsics.checkNotNullParameter(r3, "content");
        String r4 = kk6.a.h(r3);
        if (TextUtils.equals(r4, "$") == false) goto L6;
        return "**";
    L6:
        return r4;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.text.style.ReplacementSpan, pb2.a] */
    public final void a(ik6.b r3, ek6.d r4, ek6.b r5, Drawable r6) {
        jb2.c r7 = (jb2.c) r4;
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r7, "content");
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        Intrinsics.checkNotNullParameter(r6, "drawable");
        ?? r8 = new pb2.a(r6);
        ImageStyle r0 = r7.e;
        if (r0 != null) goto L5;
        r0 = kk6.a.a;
    L5:
        r8.g(r0, r6.getIntrinsicWidth(), r6.getIntrinsicHeight());
        r8.m = r7.g;
        r3.b(r7, r8);
    }
}
