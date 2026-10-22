package com.bytedance.bpea.entry.api.content.provider;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ String[] $selectionArgs;
    final /* synthetic */ String $where;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$1(ContentResolverTranslateEntry$Companion$InnerContentResolver r1, String r2, String[] r3) {
        this.this$0 = r1;
        this.$where = r2;
        this.$selectionArgs = r3;
        super(0);
    }

    public final int invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        String r1 = this.$where;
        String[] r2 = this.$selectionArgs;
        ArrayList r3 = new ArrayList();
        Object[] r4 = {null, r1, r2};
        f06.b r5 = new f06.b();
        g06.a r6 = (g06.a) ApiHookConfig.b.get(240019);
        if (r6 == null) goto L5;
        f06.a[] r7 = r6.i;
    L6:
        f06.a[] r12 = r7;
        int r11 = r12.length;
        int r10 = 0;
    L8:
        if (r10 >= r11) goto L15;
        f06.a r9 = r12[r10];
        int r17 = r10;
        int r18 = r11;
        f06.a[] r19 = r12;
        f06.d r8 = r9.preInvoke(240019, "android/content/ContentResolver", "delete", null, r4, "int", r5);     // Catch: Exception -> L21
        if (r8.a == true) goto L17;
        r3.add(r9);     // Catch: Exception -> L21
    L17:
        if (r8.a == true) goto L19;
        throw null;
    L19:
        return ((Integer) r8.b).intValue();
    L14:
        r10 = r17 + 1;
        r11 = r18;
        r12 = r19;
        goto L8
    L15:
        r8 = new f06.d(false, null);
        goto L17
    L5:
        r7 = ApiHookConfig.d;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1590invoke() {
        return Integer.valueOf(invoke());
    }
}
