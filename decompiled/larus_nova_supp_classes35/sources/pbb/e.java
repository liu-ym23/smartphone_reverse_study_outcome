package pbb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.larkicon.transform.ImgForegroundTransform;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Flowable a(obb.b r5, IconShape r6, obb.a r7) {
        Intrinsics.checkNotNullParameter(r5, "meta");
        Intrinsics.checkNotNullParameter(r6, "shape");
        String r0 = r5.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L64;
        Integer r3 = r5.d;
        if (r3 == null) goto L64;
        int r4 = r3.intValue();
        String r8 = r5.e;
        if (r8 != null) goto L16;
        r8 = BuildConfig.FLAVOR;
    L16:
        vpb.a.a r9 = new vpb.a.a(r4, r8);
        if (r7 == null) goto L20;
        IconScene r10 = r7.e;
        if (r10 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r10, "scene");
        r9.k = r10;
        if (r7 == null) goto L26;
        Long r11 = r7.f;
        if (r11 == null) goto L26;
        long r12 = r11.longValue();
    L27:
        r9.l = Long.valueOf(r12);
        if (r7 == null) goto L30;
        Integer r13 = r7.c;
    L31:
        if (r13 == null) goto L37;
        Context r14 = AppLifecycle.a.a.f();
        if (r14 != null) goto L35;
        r14 = LarkContext.getApplication();
    L35:
        r9.f = AppCompatResources.getDrawable(r14, kac.a.b(r13.intValue()));
    L37:
        if (r6 == IconShape.CIRCLE) goto L39;
    L52:
        if (r7 == null) goto L54;
        r1 = Intrinsics.areEqual(r7.a, Boolean.TRUE);
    L54:
        if (r1 == false) goto L62;
        int r15 = kac.a.b(2131256255);
        Context r16 = AppLifecycle.a.a.f();
        if (r16 != null) goto L58;
        r16 = LarkContext.getApplication();
    L58:
        Drawable r17 = AppCompatResources.getDrawable(r16, r15);
        if (r17 == null) goto L62;
        ImgForegroundTransform r18 = new ImgForegroundTransform(r17, ImgForegroundTransform.Gravity.LeftTop);
        Intrinsics.checkNotNullParameter(r18, "transform");
        r9.h.add(r18);
    L62:
        return r9.a();
    L39:
        if (r5.getType() != sbb.e.l.b) goto L41;
        int r19 = rbb.b.b(r5.c);
    L42:
        Context r20 = AppLifecycle.a.a.f();
        if (r20 != null) goto L45;
        r20 = LarkContext.getApplication();
    L45:
        int r21 = UIUtils.dp2px(r20, 24.0f);
        r9.i = Integer.valueOf(r21);
        r9.j = Integer.valueOf(r21);
        int r22 = rbb.a.a;
        if (h18.f.a(r20) == true) goto L48;
    L50:
        float r23 = 1.0f;
    L51:
        xpb.a r24 = new xpb.a(Integer.valueOf(rbb.a.d(r20, r19, r23)), UIUtils.dp2px(r20, 45.0f));
        Intrinsics.checkNotNullParameter(r24, "transform");
        r9.g.add(r24);
        goto L52
    L48:
        if (kac.a.a() == true) goto L50;
        r23 = 0.2f;
        goto L51
    L41:
        r19 = rbb.b.a(r5.getType(), null);
        goto L42
    L30:
        r13 = null;
    L26:
        r12 = System.nanoTime();
    L20:
        r10 = IconScene.UNKNOW;
    L64:
        return Flowable.empty();
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
