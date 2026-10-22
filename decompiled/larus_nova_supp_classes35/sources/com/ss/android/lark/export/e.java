package com.ss.android.lark.export;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(Drawable r1);
    }

    static {
    }

    public e() {
    }

    public static Drawable b(Context r2, UDIcon r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != null) goto L5;
        return null;
    L5:
        String r1 = r3.getUnicode();
        if (r1 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L25;
        int r5 = edb.a.a;
        int r6 = edb.a.a(r3.getKey());
        if (r6 == 0) goto L30;
        Bitmap r7 = p.c(r2, r6);
        if (r7 != null) goto L18;
        r7 = p.c(r2, 2131255013);
    L18:
        BitmapDrawable r8 = new BitmapDrawable(r7);
        ThemeColor r9 = r3.getThemeColor();
        if (r9 == null) goto L24;
        int r10 = com.ss.android.lark.export.entity.preview.a.a(r9, UIHelper.getContext(), null);
        if (r10 == 0) goto L24;
        r8.mutate();
        r8.setTint(r10);
    L24:
        return r8;
    L30:
        return null;
    L25:
        Integer[] r11 = sbb.d.a;
        String r12 = r3.getUnicode();
        if (r12 != null) goto L29;
        r12 = BuildConfig.FLAVOR;
    L29:
        return new BitmapDrawable(sbb.d.a(r12));
    L8:
        if (r1.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public static void a(Context r12, UrlInlinePreviewEntity r13, a r14, Drawable r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, BrowserDependency.UrlClickType.INLINE);
        Intrinsics.checkNotNullParameter(r14, "callback");
        if (r13.getUseColorIcon() == true) goto L5;
        String r5 = r13.getNetIconKey();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UrlInlineIconLoaderUtil$loadInlineIconKey$1(r12, r5, r15, r14, null), 3, null);
        return;
    L5:
        UnifiedHeaderInfo r2 = r13.getHeaderInfo();
        if (r2 == null) goto L8;
        ColorIcon r3 = r2.getIcon();
    L9:
        ColorIcon r6 = r3;
        if (r6 == null) goto L12;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UrlInlineIconLoaderUtil$loadColorIcon$1(r12, r6, r15, r14, null), 3, null);
        return;
    L12:
        String r4 = r13.getNetIconKey();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UrlInlineIconLoaderUtil$loadInlineIconKey$1(r12, r4, r15, r14, null), 3, null);
        return;
    L8:
        r3 = null;
        goto L9
    }
}
