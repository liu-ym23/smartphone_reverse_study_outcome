package com.ss.android.lark.integrator.im.impl.preview;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponents;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.ext.UrlPreviewEntityExt;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Context a;
    public final LifecycleOwner b;

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.im.impl.preview.a$a, reason: collision with other inner class name */
    public static final class C0119a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UrlPreviewCardType.values().length];
            r0[UrlPreviewCardType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[UrlPreviewCardType.COMPACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements t6c.d.b {
        public c() {
        }

        public final void a() {
        }

        public final void b(q6c.c r2) {
            Intrinsics.checkNotNullParameter(r2, "component");
        }
    }

    static {
    }

    public a(Context r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
    }

    public final t6c.d a(UrlCardPreviewEntity r13, UrlPreviewCardType r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "entity");
        Intrinsics.checkNotNullParameter(r14, "cardType");
        if (r15 > 0) goto L5;
        return null;
    L5:
        UrlInlinePreviewEntity r1 = r13.getInlineEntity();
        URLPreviewParams.a r2 = new URLPreviewParams.a();
        r2.a = r1.getPreviewId();
        boolean r5 = true;
        r2.b = StringsKt.startsWith(r1.getPreviewId(), "urlPreview", true);
        Url r3 = r1.getUrl();
        if (r3 == null) goto L8;
        String r4 = r3.getUrl();
    L9:
        r2.c = r4;
        r2.h = r1.getSourceId();
        UrlInlinePreviewEntity.AppInfo r6 = r1.getAppInfo();
        if (r6 == null) goto L12;
        Long r7 = r6.getAppId();
    L13:
        r2.i = r7;
        UrlInlinePreviewEntity.AppInfo r8 = r1.getAppInfo();
        if (r8 == null) goto L16;
        Long r9 = r8.getSceneType();
    L17:
        r2.j = r9;
        r1.getTitle();
        Intrinsics.checkNotNullParameter(URLPreviewParams.SourceType.MyAIDialog, "sourceType");
        r2.n = true;
        r2.o = true;
        vcb.d r10 = new vcb.d(this.a, this.b, new URLPreviewParams(r2));
        com.ss.android.lark.chat.preview.creator.a r11 = new com.ss.android.lark.chat.preview.creator.a(r10, null);
        int r12 = b.a[r14.ordinal()];
        if (r12 != 1) goto L20;
        UrlPreviewEntityExt r16 = r13.getInlineEntity().getExt();
        if (r16 == null) goto L33;
        UrlPreviewEntityExt.UrlPreviewComponentRootDisplayVariant r17 = r16.getRootIdVariant();
        if (r17 == null) goto L33;
        String r18 = r17.getDefaultRootId();
    L34:
        UrlPreviewBody r19 = r13.getPreviewBody();
        if (r19 == null) goto L43;
        UrlPreviewComponents r20 = r19.getUrlPreviewComponents();
        if (r20 == null) goto L43;
        List r21 = r20.getRootIds();
        if (r21 == null) goto L43;
        if (CollectionsKt.contains(r21, r18) != true) goto L43;
        boolean r22 = true;
    L44:
        if (r22 == false) goto L46;
    L45:
        String r23 = r18;
    L54:
        if (r23 == null) goto L79;
        Intrinsics.checkNotNullParameter(r23, "rootId");
        if (r23.length() == 0) goto L59;
        r5 = false;
    L59:
        if (r5 == true) goto L72;
        UrlPreviewBody r110 = r13.getPreviewBody();
        if (r110 == null) goto L72;
        UrlPreviewComponents r24 = r110.getUrlPreviewComponents();
        if (r24 == null) goto L72;
        if (r24.getRootIds().contains(r23) == true) goto L70;
        Log.e("[URLPreview] TangramCreator", "rootId is not declared in urlPreviewComponents");
        goto L72
    L70:
        Map r111 = r110.getActions();
        UrlPreviewState.Type.a r25 = UrlPreviewState.Type.Companion;
        q6c.b r26 = com.ss.android.lark.chat.preview.creator.a.e(r11, r23, r24.getElements(), r111, r110);
        if (r26 == null) goto L72;
        r11.b(r26, r23, r24.getElements(), r111, r110);
    L74:
        if (r26 == null) goto L76;
    L86:
        if (r26 != null) goto L88;
        return null;
    L88:
        t6c.d r112 = new t6c.d(r26, new c(), UIHelper.px2dp(r15));
        bdb.a.a r113 = new bdb.a.a();
        r113.c = new vcb.c(r112);
        r10.e = new bdb.a(r113);
        return r112;
    L76:
        if (r14 != UrlPreviewCardType.COMPACT) goto L79;
    L72:
        r26 = null;
    L79:
        if (r14 != UrlPreviewCardType.DEFAULT) goto L85;
        UrlPreviewBody r114 = r13.getPreviewBody();
        if (r114 == null) goto L83;
        String r115 = r114.getCurrentStateId();
    L84:
        r26 = r11.c(r13, r115);
        goto L86
    L83:
        r115 = null;
        goto L84
    L85:
        Log.e("OfficeUrlPreviewCardRenderer", "compact preview root is missing");
        r26 = null;
        goto L86
    L46:
        UrlPreviewBody r27 = r13.getPreviewBody();
        if (r27 == null) goto L53;
        UrlPreviewComponents r28 = r27.getUrlPreviewComponents();
        if (r28 == null) goto L53;
        List r29 = r28.getRootIds();
        if (r29 == null) goto L53;
        r18 = (String) CollectionsKt.getOrNull(r29, 0);
    L53:
        r23 = null;
    L43:
        r22 = false;
    L33:
        r18 = null;
        goto L34
    L20:
        if (r12 != 2) goto L27;
        UrlPreviewEntityExt r30 = r13.getInlineEntity().getExt();
        if (r30 == null) goto L33;
        UrlPreviewEntityExt.UrlPreviewComponentRootDisplayVariant r31 = r30.getRootIdVariant();
        if (r31 == null) goto L33;
        r18 = r31.getCompactRootId();
        goto L34
    L27:
        throw new NoWhenBranchMatchedException();
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }
}
