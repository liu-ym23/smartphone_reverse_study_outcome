package com.ss.android.lark.diskmanage.storage;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.l;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static String a(Context r6, String r7, Storage.Type r8, String... r9) {
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "bizRootDictionary");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "bizChildPath");
            Intrinsics.checkNotNullParameter(r8, IPortraitService.TYPE);
            Intrinsics.checkNotNullParameter(r9, "paths");
            int r5 = b.a;
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "bizRootDictionary");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "bizChildPath");
            Intrinsics.checkNotNullParameter(r8, IPortraitService.TYPE);
            int r10 = b.a.C0193a.a[r8.ordinal()];
            boolean r1 = true;
            if (r10 != 1) goto L5;
            String r11 = d.i(r6) + File.separator;
        L25:
            String r12 = r11 + r7;
            if (TextUtils.isEmpty(BuildConfig.FLAVOR) == true) goto L29;
            r12 = r12 + File.separator + BuildConfig.FLAVOR;
        L29:
            if (r9.length != 0) goto L31;
            boolean r13 = true;
        L33:
            if ((!r13) == true) goto L36;
            r1 = false;
        L36:
            if (r1 == false) goto L41;
            Iterator r14 = ArrayIteratorKt.iterator(r9);
        L39:
            if (r14.hasNext() == false) goto L41;
            r12 = r12 + File.separator + r14.next();
        L41:
            return r12;
        L31:
            r13 = false;
            goto L33
        L5:
            if (r10 != 2) goto L7;
            StringBuilder r15 = new StringBuilder();
            int r3 = d.a;
            Intrinsics.checkNotNullParameter(r6, "context");
            r15.append(l.a(r6));
            r15.append(File.separator);
            r11 = r15.toString();
            goto L25
        L7:
            if (r10 != 3) goto L9;
            r11 = d.j(r6) + File.separator;
            goto L25
        L9:
            if (r10 != 4) goto L11;
            StringBuilder r16 = new StringBuilder();
            int r4 = d.a;
            Intrinsics.checkNotNullParameter(r6, "context");
            File r0 = r6.getExternalFilesDir(null);
            if (r0 != null) goto L18;
            r0 = r6.getFilesDir();
        L18:
            if (r0 == null) goto L20;
            String r17 = r0.getPath();
        L21:
            r16.append(r17);
            r16.append(File.separator);
            r11 = r16.toString();
            goto L25
        L20:
            r17 = BuildConfig.FLAVOR;
            goto L21
        L11:
            if (r10 != 5) goto L14;
            r11 = d.l(r6);
            goto L25
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        new HashMap();
    }
}
