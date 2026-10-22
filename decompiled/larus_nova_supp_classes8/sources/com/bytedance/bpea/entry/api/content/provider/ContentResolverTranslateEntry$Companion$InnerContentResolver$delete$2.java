package com.bytedance.bpea.entry.api.content.provider;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$2(ContentResolverTranslateEntry$Companion$InnerContentResolver r1, Bundle r2) {
        this.this$0 = r1;
        this.$extras = r2;
        super(0);
    }

    public final int invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        Bundle r1 = this.$extras;
        ArrayList r2 = new ArrayList();
        Object[] r3 = {null, r1};
        f06.b r4 = new f06.b();
        g06.a r5 = (g06.a) ApiHookConfig.b.get(240019);
        if (r5 == null) goto L5;
        f06.a[] r6 = r5.i;
    L6:
        f06.a[] r11 = r6;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r17 = r9;
        int r18 = r10;
        f06.a[] r19 = r11;
        f06.d r7 = r8.preInvoke(240019, "android/content/ContentResolver", "delete", null, r3, "int", r4);     // Catch: Exception -> L21
        if (r7.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L21
    L17:
        if (r7.a == true) goto L19;
        throw null;
    L19:
        return ((Integer) r7.b).intValue();
    L14:
        r9 = r17 + 1;
        r10 = r18;
        r11 = r19;
        goto L8
    L15:
        r7 = new f06.d(false, null);
        goto L17
    L5:
        r6 = ApiHookConfig.d;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1591invoke() {
        return Integer.valueOf(invoke());
    }
}
