package com.bytedance.android.anniex.lite.config;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.lite.c;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import q26.k;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt36/j;", "invoke", "()Lt36/j;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LitePageConfig$schemaModelUnion$2 extends Lambda implements Function0<j> {
    final /* synthetic */ String $bid;
    final /* synthetic */ k $uiShowConfig;
    final /* synthetic */ Uri $uri;

    public LitePageConfig$schemaModelUnion$2(String r1, Uri r10, k r11) {
        this.$bid = r1;
        this.$uri = r10;
        this.$uiShowConfig = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final j m222invoke() {
        LruCache<String, AnnieXWebModel> r0 = c.a;
        return c.a(this.$bid, this.$uri, this.$uiShowConfig.b);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m222invoke();
    }
}
