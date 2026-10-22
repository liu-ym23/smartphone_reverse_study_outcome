package com.bytedance.bpea.entry.api.content.provider;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$query$3 extends Lambda implements Function0<Cursor> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ String[] $projection;
    final /* synthetic */ Bundle $queryArgs;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$query$3(ContentResolverTranslateEntry$Companion$InnerContentResolver r1, String[] r2, Bundle r3, CancellationSignal r4) {
        this.this$0 = r1;
        this.$projection = r2;
        this.$queryArgs = r3;
        this.$cancellationSignal = r4;
        super(0);
    }

    public final Cursor invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        String[] r0 = this.$projection;
        Bundle r1 = this.$queryArgs;
        CancellationSignal r2 = this.$cancellationSignal;
        f06.c r11 = new f06.c();
        Object[] r12 = {null, r0, r1, r2};
        f06.b r3 = new f06.b();
        f06.d r4 = r11.b(240004, "android/content/ContentResolver", "query", null, r12, "android.database.Cursor", r3);
        if (r4.a == false) goto L6;
        r11.a(240004, "android/content/ContentResolver", "query", null, r12, null, r3, false);
        return (Cursor) r4.b;
    L6:
        throw null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1596invoke() {
        return invoke();
    }
}
