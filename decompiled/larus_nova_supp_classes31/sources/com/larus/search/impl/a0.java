package com.larus.search.impl;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 {
    public ActivityResultLauncher<Intent> a;
    public final Map<String, Boolean> b;

    public static final class a {
    }

    static {
    }

    public a0() {
        this.b = new LinkedHashMap();
    }

    public final void a(boolean r5, boolean r6, boolean r7, boolean r8) {
        ActivityResultLauncher<Intent> r0 = this.a;
        if (r0 == null) goto L21;
        Intent r1 = new Intent();
        r1.setAction("android.intent.action.GET_CONTENT");
        ArrayList r2 = new ArrayList();
        if (r7 == false) goto L7;
        r1.setType("audio/*");
        r2.add("audio/*");
    L17:
        if ((!r2.isEmpty()) == false) goto L19;
        r1.putExtra("android.intent.extra.MIME_TYPES", (String[]) r2.toArray(new String[0]));
    L19:
        r1.putExtra("android.intent.extra.ALLOW_MULTIPLE", r8);
        r1.addCategory("android.intent.category.OPENABLE");
        v19.b.a(r0, r1);
        return;
    L7:
        r1.setType("*/*");
        List<String> r9 = z2.a.getFlowMultiUploadConfig().k();
        if (r9 == null) goto L10;
        List r10 = CollectionsKt.filterNotNull(r9);
    L11:
        if (r5 == true) goto L13;
        r2.addAll(FileMimeTypeUtils.a(r10));
    L14:
        if (r6 == false) goto L17;
        r2.add("audio/*");
        goto L17
    L13:
        r2.addAll(FileMimeTypeUtils.a(r10));
        r2.add("image/*");
        goto L14
    L10:
        r10 = null;
        goto L11
    }
}
