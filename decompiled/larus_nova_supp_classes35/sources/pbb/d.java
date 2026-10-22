package pbb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.larkicon.transform.ImgForegroundTransform;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import e0c.l;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Flowable c(obb.c r13) {
        Intrinsics.checkNotNullParameter(r13, "iconModel");
        boolean r2 = false;
        if (TextUtils.isEmpty(r13.a) == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L25;
        Integer r3 = r13.f;
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L13:
        if (r4 > 0) goto L15;
    L16:
        Integer r5 = r13.getType();
        if (r5 == null) goto L19;
        int r6 = r5.intValue();
    L20:
        obb.b r0 = new obb.b(r6, r13.a, r13.d, r13.f, r13.g, null, null, null, 256);
        String r7 = r13.e;
        IconShape r8 = r13.l;
        obb.a r14 = r13.m;
        if (r14 != null) goto L24;
        r14 = new obb.a();
    L24:
        return b(r0, r7, r8, r14);
    L19:
        r6 = -1;
        goto L20
    L15:
        if (mbb.c.a == true) goto L25;
    L12:
        r4 = 0;
    L25:
        int r9 = e.a;
        Intrinsics.checkNotNullParameter(r13, "iconModel");
        Integer r10 = r13.f;
        if (r10 == null) goto L28;
        int r11 = r10.intValue();
    L29:
        String r12 = r13.g;
        if (r12 != null) goto L32;
        r12 = BuildConfig.FLAVOR;
    L32:
        vpb.a.a r15 = new vpb.a.a(r11, r12);
        r15.e = r13.j;
        r15.f = r13.k;
        r15.c = r13.i;
        r15.d = r13.h;
        IconScene r16 = r13.n;
        Intrinsics.checkNotNullParameter(r16, "scene");
        r15.k = r16;
        Long r17 = r13.o;
        if (r17 == null) goto L35;
        long r18 = r17.longValue();
    L36:
        r15.l = Long.valueOf(r18);
        if (r13.l != IconShape.CIRCLE) goto L50;
        Context r19 = AppLifecycle.a.a.f();
        if (r19 != null) goto L41;
        r19 = LarkContext.getApplication();
    L41:
        int r20 = UIUtils.dp2px(r19, 24.0f);
        r15.i = Integer.valueOf(r20);
        r15.j = Integer.valueOf(r20);
        int r21 = rbb.a.a;
        Integer r22 = r13.h;
        if (r22 == null) goto L44;
        int r23 = r22.intValue();
    L46:
        if (h18.f.a(r19) == false) goto L48;
        float r24 = 0.2f;
    L49:
        xpb.a r25 = new xpb.a(Integer.valueOf(rbb.a.d(r19, r23, r24)), UIUtils.dp2px(r19, 45.0f));
        Intrinsics.checkNotNullParameter(r25, "transform");
        r15.g.add(r25);
        goto L50
    L48:
        r24 = 1.0f;
        goto L49
    L44:
        r23 = 0;
    L50:
        obb.a r110 = r13.m;
        if (r110 == null) goto L53;
        r2 = Intrinsics.areEqual(r110.a, Boolean.TRUE);
    L53:
        if (r2 == false) goto L61;
        int r111 = kac.a.b(2131256255);
        Context r26 = AppLifecycle.a.a.f();
        if (r26 != null) goto L57;
        r26 = LarkContext.getApplication();
    L57:
        Drawable r112 = AppCompatResources.getDrawable(r26, r111);
        if (r112 == null) goto L61;
        ImgForegroundTransform r27 = new ImgForegroundTransform(r112, ImgForegroundTransform.Gravity.LeftTop);
        Intrinsics.checkNotNullParameter(r27, "transform");
        r15.h.add(r27);
    L61:
        return r15.a();
    L35:
        r18 = System.nanoTime();
        goto L36
    L28:
        r11 = 0;
        goto L29
    L5:
        if (r13.b == null) goto L7;
        r1 = true;
        goto L8
    }

    public static obb.b d(obb.b r11) {
        if (mbb.c.a == false) goto L6;
        return r11;
    L6:
        return new obb.b(r11.a, r11.b, r11.c, null, null, r11.f, r11.g, r11.h, r11.i);
    }

    public static Flowable a(obb.b r7, IconShape r8, obb.a r9) {
        Intrinsics.checkNotNullParameter(r7, "meta");
        Intrinsics.checkNotNullParameter(r8, "shape");
        Intrinsics.checkNotNullParameter(r9, "container");
        String r0 = r7.b;
        com.ss.android.lark.storage.a r1 = nbb.b.a;
        if (r0 != null) goto L5;
        String r2 = BuildConfig.FLAVOR;
    L6:
        obb.b r3 = nbb.b.a(r2, r9.g);
        if (r3 == null) goto L17;
        Integer r4 = r3.f;
        int r5 = 0;
        if (r4 == null) goto L11;
        int r6 = r4.intValue();
    L12:
        Integer r10 = r7.f;
        if (r10 == null) goto L15;
        r5 = r10.intValue();
    L15:
        if (r6 < r5) goto L17;
        r7 = r3;
        goto L17
    L11:
        r6 = 0;
    L17:
        Log.i("DOCS_ICON_DocsIconManager", "downloadBitmap localMeta " + r7.getType() + ' ' + r7.d);
        Flowable<Bitmap> r11 = new f().a(d(r7), r8, r9);
        long r12 = System.nanoTime();
        qbb.c r13 = new qbb.c(null);
        Intrinsics.checkNotNullParameter(r13, "userScopeView");
        l r14 = r13.provideComponent();
        r13.e9();
        Intrinsics.checkNotNullParameter(qbb.a.class, "userScopeApi");
        return Flowable.merge(r11, ((qbb.a) k.b(r14, qbb.a.class)).a(r7).doOnError(new a(r9, r7, r12)).flatMap(new b(r0, r7, r9, r8)).onErrorResumeNext(c.a));
    L5:
        r2 = r0;
        goto L6
    }

    public static Flowable b(obb.b r5, String r6, IconShape r7, obb.a r8) {
        Intrinsics.checkNotNullParameter(r7, "shape");
        Intrinsics.checkNotNullParameter(r8, "container");
        sbb.c.a.getClass();
        obb.b r9 = sbb.c.c(r5, r6);
        com.ss.android.lark.storage.a r1 = nbb.b.a;
        if (r9 == null) goto L6;
        String r2 = r9.b;
        if (r2 == null) goto L6;
    L7:
        obb.b r3 = nbb.b.a(r2, r8.g);
        if (r3 == null) goto L21;
        int r4 = 0;
        if (r9 == null) goto L14;
        Integer r10 = r9.f;
        if (r10 == null) goto L14;
        int r11 = r10.intValue();
    L15:
        Integer r12 = r3.f;
        if (r12 == null) goto L18;
        r4 = r12.intValue();
    L18:
        if (r11 >= r4) goto L21;
        r9 = r3;
    L14:
        r11 = 0;
    L21:
        if (r5 != null) goto L25;
        if (r9 != null) goto L25;
        Log.e("DOCS_ICON_DocsIconManager", "getDocumentIcon url & meta error");
        return Flowable.error(new Exception("getDocumentIcon url & meta error"));
    L25:
        if (r9 != null) goto L31;
        Log.e("DOCS_ICON_DocsIconManager", "downloadBitmap meta null");
        if (r5 != null) goto L39;
        Flowable r13 = Flowable.error(new Exception("downloadBitmap meta null & metaInfo is null"));
        Intrinsics.checkNotNull(r13);
        return r13;
    L39:
        return a(r5, r7, r8);
    L31:
        if (r5 != null) goto L33;
        Log.i("DOCS_ICON_DocsIconManager", "loadDocumentIcon url parse error");
    L33:
        obb.b r14 = d(r9);
        Flowable<Bitmap> r15 = new f().a(r14, r7, r8);
        nbb.b.c(r9.b, r9, r8.g);
        new f();
        Intrinsics.checkNotNullParameter(r14, "meta");
        Intrinsics.checkNotNullParameter(r7, "shape");
        if (mbb.c.a == true) goto L36;
        Flowable r16 = Flowable.empty();
    L38:
        return Flowable.merge(r15, r16);
    L36:
        r16 = e.a(r14, r7, r8);
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }
}
