package obb;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int p = 0;
    public String a;
    public Integer b;
    public final String c;
    public String d;
    public final String e;
    public Integer f;
    public String g;
    public final Integer h;
    public final Integer i;
    public final Drawable j;
    public final Drawable k;
    public final IconShape l;
    public final obb.a m;
    public final IconScene n;
    public Long o;

    public static final class a {
        public final String a;
        public final Integer b;
        public String c;
        public final String d;
        public final Integer e;
        public final String f;
        public Integer g;
        public Integer h;
        public Drawable i;
        public Drawable j;
        public IconShape k;
        public obb.a l;
        public IconScene m;

        public a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "iconKey");
            this.k = IconShape.SQUARE;
            this.m = IconScene.UNKNOW;
            this.e = Integer.valueOf(r2);
            this.f = r3;
        }

        public a(String r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "token");
            this.k = IconShape.SQUARE;
            this.m = IconScene.UNKNOW;
            this.a = r2;
            this.b = Integer.valueOf(r3);
            this.d = r4;
        }
    }

    public static final class b {
        public static a a(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "iconKey");
            return new a(r1, r2);
        }
    }

    static {
    }

    public final String a() {
        return this.a + '-' + this.b + '-' + this.f + '-' + this.g;
    }

    public final Integer getType() {
        return this.b;
    }

    public c(a r14) {
        Intrinsics.checkNotNullParameter(r14, "builder");
        String r0 = r14.a;
        Integer r1 = r14.b;
        String r2 = r14.c;
        String r3 = r14.d;
        Integer r4 = r14.e;
        String r5 = r14.f;
        Integer r6 = r14.g;
        Integer r7 = r14.h;
        Drawable r8 = r14.i;
        Drawable r9 = r14.j;
        IconShape r10 = r14.k;
        obb.a r11 = r14.l;
        IconScene r15 = r14.m;
        Intrinsics.checkNotNullParameter(r10, "iconShape");
        Intrinsics.checkNotNullParameter(r15, "scene");
        this.a = r0;
        this.b = r1;
        this.c = r2;
        UserSession r12 = null;
        this.d = null;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r15;
        this.o = null;
        boolean r16 = TextUtils.isEmpty(r3);
        int r13 = 0;
        String r17 = BuildConfig.FLAVOR;
        if (r16 == true) goto L7;
        sbb.c.a.getClass();
        if (sbb.c.c(null, r3) == null) goto L7;
        obb.b r18 = sbb.c.c(null, r3);
    L28:
        if (r18 == null) goto L48;
        com.ss.android.lark.storage.a r19 = nbb.b.a;
        String r20 = r18.b;
        if (r20 == null) goto L33;
        r17 = r20;
    L33:
        if (r11 == null) goto L35;
        r12 = r11.g;
    L35:
        obb.b r21 = nbb.b.a(r17, r12);
        if (r21 == null) goto L46;
        Integer r22 = r18.f;
        if (r22 == null) goto L40;
        int r23 = r22.intValue();
    L41:
        Integer r24 = r21.f;
        if (r24 == null) goto L44;
        r13 = r24.intValue();
    L44:
        if (r23 >= r13) goto L46;
        r18 = r21;
        goto L46
    L40:
        r23 = 0;
    L46:
        this.a = r18.b;
        this.b = Integer.valueOf(r18.getType());
        this.f = r18.d;
        this.g = r18.e;
        this.d = r18.c;
        return;
    L48:
        return;
    L7:
        if (r2 == null) goto L20;
        boolean r25 = true;
        if (r2.length() <= 0) goto L11;
        boolean r110 = true;
    L12:
        if (r110 == true) goto L15;
        r25 = false;
    L15:
        if (r25 == false) goto L20;
        sbb.c.a.getClass();
        if (sbb.c.e(r2) == null) goto L20;
        r18 = sbb.c.e(r2);
        goto L28
    L11:
        r110 = false;
    L20:
        if (TextUtils.isEmpty(this.a) == true) goto L27;
        Integer r111 = this.b;
        if (r111 == null) goto L27;
        sbb.c r26 = sbb.c.a;
        String r27 = this.a;
        if (r27 != null) goto L26;
        r27 = BuildConfig.FLAVOR;
    L26:
        int r112 = r111.intValue();
        r26.getClass();
        r18 = sbb.c.a(r27, r112);
    L27:
        r18 = null;
        goto L28
    }
}
