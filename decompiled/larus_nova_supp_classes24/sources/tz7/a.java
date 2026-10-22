package tz7;

import com.larksuite.component.ui.avatar.AvatarModel;
import com.ss.android.lark.docs.icon.entity.IconShape;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends AvatarModel {
    public final String l;
    public final String m;
    public final IconShape n;
    public final obb.a o;

    /* JADX INFO: renamed from: tz7.a$a, reason: collision with other inner class name */
    public static final class C0129a extends AvatarModel.a<C0129a> {
        public String k;
        public String l;
        public IconShape m;
        public obb.a n;

        public C0129a() {
            this.k = "";
            this.l = "";
            this.m = IconShape.CIRCLE;
        }
    }

    public a(C0129a r5) {
        String r0 = r5.k;
        String r1 = r5.l;
        IconShape r2 = r5.m;
        obb.a r3 = r5.n;
        super(r5);
        this.l = r0;
        this.m = r1;
        this.n = r2;
        this.o = r3;
    }
}
