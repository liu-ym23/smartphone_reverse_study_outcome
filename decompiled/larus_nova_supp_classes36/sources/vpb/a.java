package vpb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.larkicon.util.BizDomainConfig;
import com.ss.android.lark.larkicon.util.BizPathConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final int a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final Drawable e;
    public final Drawable f;
    public final Integer g;
    public final Integer h;
    public final List<xpb.b> i;
    public final List<xpb.c> j;
    public final IconScene k;
    public final Long l;

    /* JADX INFO: renamed from: vpb.a$a, reason: collision with other inner class name */
    public static final class C0337a {
        public final int a;
        public final String b;
        public Integer c;
        public Integer d;
        public Drawable e;
        public Drawable f;
        public final ArrayList<xpb.b> g;
        public final ArrayList<xpb.c> h;
        public Integer i;
        public Integer j;
        public IconScene k;
        public Long l;

        public final Flowable<Bitmap> a() {
            a r13 = new a(this.a, this.b, this.c, this.d, this.e, this.f, this.i, this.j, this.g, this.h, this.k, this.l);
            Long r0 = r13.l;
            if (r0 == null) goto L5;
            long r1 = r0.longValue();
        L6:
            d r2 = new d();
            IconScene r3 = r13.k;
            if (r3 != null) goto L9;
            r3 = IconScene.UNKNOW;
        L9:
            r2.e = r3;
            if (r13.e == null) goto L18;
            d r4 = new d();
            int r5 = ypb.b.a;
            Bitmap r6 = ypb.b.a(r13.e);
            Intrinsics.checkNotNullParameter(r6, "bitmap");
            r4.c = new wpb.c(r6);
            r13.a(r4);
            IconScene r7 = r13.k;
            if (r7 != null) goto L14;
            r7 = IconScene.UNKNOW;
        L14:
            r4.e = r7;
            wpb.e r8 = r4.c;
            if (r8 == null) goto L17;
            Flowable r9 = r8.a(r4.d).map(new e(r4));
        L19:
            Integer r10 = r13.g;
            if (r10 == null) goto L22;
            int r11 = r10.intValue();
        L23:
            Integer r12 = r13.h;
            if (r12 == null) goto L26;
            int r14 = r12.intValue();
        L27:
            int r15 = r13.a;
            if (r15 != 1) goto L30;
            String r16 = r13.b;
            Intrinsics.checkNotNullParameter(r16, "unicode");
            r2.c = new wpb.d(r16, r11, r14, r2.e);
        L46:
            r2.d = r13.f;
            r13.a(r2);
            wpb.e r17 = r2.c;
            if (r17 == null) goto L49;
            Flowable r18 = r17.a(r2.d).map(new e(r2));
        L51:
            return Flowable.merge(r9, r18).doOnComplete(new vpb.b(r13, r1)).doOnError(new c(r13, r1));
        L49:
            r18 = Flowable.empty();
            goto L51
        L30:
            if (r15 != 2) goto L32;
            String r19 = ypb.a.a;
            String r20 = r13.b;
            Intrinsics.checkNotNullParameter(r20, "path");
            StringBuilder r21 = new StringBuilder("http://");
        L42:
            e = move-exception;
            Log.e("IconConfig", "getImageDomain error " + e);
        L44:
            r21.append(ypb.a.a);
            r21.append(r20);
            String r22 = r21.toString();
            Intrinsics.checkNotNullParameter(r22, "url");
            r2.c = new wpb.a(r22, r11, r14, r2.e);
            goto L46
        L37:
            if (idb.f.a().isCurrentEnable("ccm.mobile.ark_domain") == false) goto L39;
            String r23 = ((String) ListProtector.get(jcb.b.c().b("reaction_bucket_prex"), 0)) + '/';     // Catch: Exception -> L42
        L40:
            ypb.a.a = r23;     // Catch: Exception -> L42
            goto L44
        L39:
            String r24 = SettingManager.getInstance().getString(BizDomainConfig.class);     // Catch: Exception -> L42
            r23 = new JSONObject(r24).optJSONArray("cdn").get(0) + '/' + ((BizPathConfig) SettingManager.getInstance().get(BizPathConfig.class)).a() + '/';     // Catch: Exception -> L42
            goto L40
        L32:
            if (r15 != 3) goto L46;
            String r25 = r13.b;
            Integer r26 = r13.c;
            Intrinsics.checkNotNullParameter(r25, "text");
            r2.c = new wpb.f(r25, r11, r14, r26);
            xpb.a r27 = new xpb.a(r13.d, UIUtils.dp2px(LarkContext.getApplication(), 10.0f), r13.c, 1.0f);
            Intrinsics.checkNotNullParameter(r27, "transform");
            r2.a.add(r27);
            goto L46
        L26:
            r14 = r2.f;
            goto L27
        L22:
            r11 = r2.f;
            goto L23
        L17:
            r9 = Flowable.empty();
            goto L19
        L18:
            r9 = Flowable.empty();
            goto L19
        L5:
            r1 = System.nanoTime();
            goto L6
        }

        public C0337a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "iconKey");
            this.g = new ArrayList();
            this.h = new ArrayList();
            this.k = IconScene.UNKNOW;
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a(d r5) {
        List<xpb.b> r0 = this.i;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        xpb.b r2 = (xpb.b) r1.next();
        Intrinsics.checkNotNullParameter(r2, "transform");
        r5.a.add(r2);
    L8:
        List<xpb.c> r3 = this.j;
        if (r3 == null) goto L14;
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        xpb.c r6 = (xpb.c) r4.next();
        Intrinsics.checkNotNullParameter(r6, "transform");
        r5.b.add(r6);
        goto L12
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r2, String r3, Integer r4, Integer r5, Drawable r6, Drawable r7, Integer r8, Integer r9, List<? extends xpb.b> r10, List<? extends xpb.c> r11, IconScene r12, Long r13) {
        Intrinsics.checkNotNullParameter(r3, "iconKey");
        Intrinsics.checkNotNullParameter(r12, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
