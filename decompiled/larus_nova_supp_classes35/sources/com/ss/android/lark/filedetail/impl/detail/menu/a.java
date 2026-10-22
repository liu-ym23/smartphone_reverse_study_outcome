package com.ss.android.lark.filedetail.impl.detail.menu;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final hfb.b.d a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.menu.a$a, reason: collision with other inner class name */
    public static final class C0206a {
        public final Context a;
        public final OpenFileInfo b;

        public final Context getContext() {
            return this.a;
        }

        public C0206a(Context r2, OpenFileInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a = r2;
            this.b = r3;
        }
    }

    public a() {
    }

    static {
        com.ss.android.lark.storage.a r0 = FileDetailModule.a;
        hfb.b r1 = FileDetailModule.a.a();
        if (r1 == null) goto L5;
        hfb.b.d r2 = r1.getChatDependency();
    L6:
        a = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(Context r10, OpenFileInfo r11) {
        String r0 = r11.mMessageId;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return;
    L12:
        if (r11.mFileContent != null) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r11.originMergeForwardId) == false) goto L17;
        String r3 = r11.mMessageId;
    L18:
        String r9 = r3;
        if (r9 != null) goto L21;
    L22:
        r1 = true;
    L23:
        if (r1 == false) goto L25;
        Log.e("FileDetailActivity", "forward messageId is invalid!");
        return;
    L25:
        int r4 = com.ss.android.lark.filedetail.impl.detail.templatefactory.b.a;
        com.ss.android.lark.filedetail.impl.detail.templatefactory.b.a(r10, r11.mFileContent.getKey(), r11.mFileContent.getName(), r11.mFileContent.getSize(), false, r9);
        return;
    L21:
        if (r9.length() != 0) goto L23;
    L17:
        r3 = r11.originMergeForwardId;
        goto L18
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
