package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentValues;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$update$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ String[] $selectionArgs;
    final /* synthetic */ ContentValues $values;
    final /* synthetic */ String $where;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$update$1(ContentResolverTranslateEntry$Companion$InnerContentResolver r1, ContentValues r2, String r3, String[] r4) {
        this.this$0 = r1;
        this.$values = r2;
        this.$where = r3;
        this.$selectionArgs = r4;
        super(0);
    }

    public final int invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        ContentValues r1 = this.$values;
        String r2 = this.$where;
        String[] r3 = this.$selectionArgs;
        ArrayList r4 = new ArrayList();
        Object[] r5 = {null, r1, r2, r3};
        f06.b r6 = new f06.b();
        g06.a r7 = (g06.a) ApiHookConfig.b.get(240018);
        if (r7 == null) goto L5;
        f06.a[] r8 = r7.i;
    L6:
        f06.a[] r13 = r8;
        int r12 = r13.length;
        int r11 = 0;
    L8:
        if (r11 >= r12) goto L15;
        f06.a r10 = r13[r11];
        int r17 = r11;
        int r18 = r12;
        f06.a[] r19 = r13;
        f06.d r9 = r10.preInvoke(240018, "android/content/ContentResolver", "update", null, r5, "int", r6);     // Catch: Exception -> L21
        if (r9.a == true) goto L17;
        r4.add(r10);     // Catch: Exception -> L21
    L17:
        if (r9.a == true) goto L19;
        throw null;
    L19:
        return ((Integer) r9.b).intValue();
    L14:
        r11 = r17 + 1;
        r12 = r18;
        r13 = r19;
        goto L8
    L15:
        r9 = new f06.d(false, null);
        goto L17
    L5:
        r8 = ApiHookConfig.d;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1597invoke() {
        return Integer.valueOf(invoke());
    }
}
