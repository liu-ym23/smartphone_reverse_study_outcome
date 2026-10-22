package kb2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import jb2.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends kk6.a<e> {
    public c() {
    }

    public final String e(ek6.d r2) {
        e r3 = (e) r2;
        Intrinsics.checkNotNullParameter(r3, "content");
        String r4 = kk6.a.h(r3);
        if (TextUtils.equals(r4, "$") == false) goto L6;
        return "**";
    L6:
        return r4;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [android.text.style.CharacterStyle, pb2.a, pb2.b] */
    public final void a(ik6.b r14, ek6.d r15, ek6.b r16, Drawable r17) {
        e r1 = (e) r15;
        Intrinsics.checkNotNullParameter(r14, "editor");
        Intrinsics.checkNotNullParameter(r1, "content");
        Intrinsics.checkNotNullParameter(r16, "resourceInfo");
        Intrinsics.checkNotNullParameter(r17, "drawable");
        int r2 = r1.getType();
        float r5 = 0.5f;
        if (r2 != 1) goto L5;
        float r7 = 0.57f;
        float r8 = 0.5f;
        float r9 = 0.5f;
        boolean r10 = true;
        int r11 = 4;
    L16:
        ?? r3 = new pb2.b(r17, r1.e, r1.f, r7, r8, r9, r10, r11);
        ImageStyle r4 = ((fk6.a) r1).b;
        if (r4 != null) goto L19;
        r4 = kk6.a.a;
    L19:
        r3.g(r4, r17.getIntrinsicWidth(), r17.getIntrinsicHeight());
        r3.m = r1.g;
        r14.a(r1, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r5 = 0.47f;
        float r6 = 0.47f;
        float r13 = 0.6f;
    L14:
        r7 = r6;
        r9 = r13;
        r8 = r5;
        r10 = false;
        r11 = 0;
        goto L16
    L7:
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L11;
        r6 = 0.54f;
    L12:
        r13 = 0.5f;
    L11:
        r6 = 0.5f;
        goto L12
    }
}
