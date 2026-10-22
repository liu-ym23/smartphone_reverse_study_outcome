package com.bytedance.ai.view.popup.params;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/view/popup/params/AppletPopupSchemaParam;", "Lcom/bytedance/ai/view/popup/params/AbsAppletPopupSchemaParam;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppletPopupSchemaParam extends AbsAppletPopupSchemaParam {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f2907z;

    public AppletPopupSchemaParam() {
        this.f2907z = 300;
    }

    public static boolean b(Context r5) {
        if (r5 == null) goto L12;
        Resources r10 = r5.getResources();
        if (r10 == null) goto L12;
        Configuration r11 = r10.getConfiguration();
        if (r11 == null) goto L12;
        if (r11.orientation != 2) goto L12;
        return true;
    L12:
        return false;
    }

    public final String a(Context r5) {
        String r10 = this.f2887a;
        b(r5);
        return r10;
    }
}
