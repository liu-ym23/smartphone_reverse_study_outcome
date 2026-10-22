package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroid/content/ContentProviderResult;", "kotlin.jvm.PlatformType", "invoke", "()[Landroid/content/ContentProviderResult;"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class ContentResolverEntry$Companion$applyBatch$1 extends Lambda implements Function0<ContentProviderResult[]> {
    final /* synthetic */ String $authority;
    final /* synthetic */ ArrayList $operations;
    final /* synthetic */ ContentResolver $this_applyBatch;

    public ContentResolverEntry$Companion$applyBatch$1(ContentResolver r1, String r2, ArrayList r3) {
        this.$this_applyBatch = r1;
        this.$authority = r2;
        this.$operations = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ContentProviderResult[] m1579invoke() {
        return this.$this_applyBatch.applyBatch(this.$authority, this.$operations);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1579invoke();
    }
}
