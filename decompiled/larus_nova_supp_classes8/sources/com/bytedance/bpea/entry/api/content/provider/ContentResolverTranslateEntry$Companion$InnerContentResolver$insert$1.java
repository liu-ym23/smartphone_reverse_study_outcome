package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$insert$1 extends Lambda implements Function0<Uri> {
    final /* synthetic */ ContentValues $values;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$insert$1(ContentResolverTranslateEntry$Companion$InnerContentResolver r1, ContentValues r2) {
        this.this$0 = r1;
        this.$values = r2;
        super(0);
    }

    public final Uri invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        ContentValues r1 = this.$values;
        ArrayList r2 = new ArrayList();
        Object[] r3 = {null, r1};
        f06.b r4 = new f06.b();
        g06.a r5 = (g06.a) ApiHookConfig.b.get(240017);
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
        f06.d r7 = r8.preInvoke(240017, "android/content/ContentResolver", "insert", null, r3, "android.net.Uri", r4);     // Catch: Exception -> L21
        if (r7.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L21
    L17:
        if (r7.a == true) goto L19;
        throw null;
    L19:
        return (Uri) r7.b;
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
    public /* bridge */ /* synthetic */ Object m1592invoke() {
        return invoke();
    }
}
