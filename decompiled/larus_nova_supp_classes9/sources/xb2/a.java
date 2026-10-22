package xb2;

import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;
import tb2.g;
import wb2.h;
import wb2.i;
import wb2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e {

    /* JADX INFO: renamed from: xb2.a$a, reason: collision with other inner class name */
    public static final class C0297a implements tb2.e {
        public final /* synthetic */ tb2.b a;

        public C0297a(tb2.b r1) {
            this.a = r1;
        }

        @Override // tb2.e
        public final m6 a() {
            return ((tb2.e) this.a).a();
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.e
    public final List<CharacterStyle> a(c r3, Drawable r4) {
        Intrinsics.checkNotNullParameter(r3, "renderPiece");
        tb2.b r5 = r3.getClickAction();
        if (r5 == null) goto L12;
        ArrayList r6 = new ArrayList();
        if ((r5 instanceof tb2.e) == false) goto L8;
        r6.add(new i(new C0297a(r5)));
    L11:
        return r6;
    L8:
        if ((r5 instanceof g) == false) goto L10;
        r6.add(new k((g) r5));
        goto L11
    L10:
        r6.add(new h(r5));
        goto L11
    L12:
        return null;
    }
}
