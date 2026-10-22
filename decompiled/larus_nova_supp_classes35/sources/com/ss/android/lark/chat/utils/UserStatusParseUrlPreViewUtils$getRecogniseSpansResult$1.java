package com.ss.android.lark.chat.utils;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntry;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/utils/UserStatusParseUrlPreViewUtils$getRecogniseSpansResult$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chat/preview/entity/UrlPreviewResponse;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserStatusParseUrlPreViewUtils$getRecogniseSpansResult$1 implements IGetDataCallback<UrlPreviewResponse> {
    final /* synthetic */ hpc.a $callback;
    final /* synthetic */ String $description;
    final /* synthetic */ Long $privateDescriptionId;
    final /* synthetic */ ChatHitPointExtraParams.UrlAnalysisScene $scene;
    final /* synthetic */ String $sourceId;
    final /* synthetic */ String $textMd5;

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        this.$callback.a(null, null);
    }

    public void onSuccess(UrlPreviewResponse r14) {
        Intrinsics.checkNotNullParameter(r14, Keys.API_RETURN_KEY_DATA);
        if (r14.getNetCostMs() <= 0) goto L5;
        ChatHitPointExtraParams.DataSource r0 = ChatHitPointExtraParams.DataSource.FROM_SERVER;
    L6:
        int r1 = UserStatusParseUrlPreViewUtils.a;
        Map r2 = UserStatusParseUrlPreViewUtils.c(r14.getUrlPreViewEntries(), CollectionsKt.listOf(new UserStatusParseUrlPreViewUtils.b(this.$description, this.$sourceId, this.$textMd5, this.$privateDescriptionId)), this.$scene, r0);
        ArrayList<UrlPreViewEntries> r15 = r14.getUrlPreViewEntries();
        String r3 = this.$description;
        String r4 = this.$sourceId;
        Long r5 = this.$privateDescriptionId;
        HashMap r6 = null;
        if (r3 == null) goto L46;
        HashMap r7 = new HashMap();
        byte[] r8 = r3.getBytes(Charsets.UTF_8);
        RecogniseSpansResult r9 = com.ss.android.lark.widget.span.f0.a.a.a(k6b.c.a(r4, r3, r5));
        if (r9 == null) goto L46;
        List r10 = r9.getUrlSpanInfos();
        Iterator<T> r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L45;
        UrlPreViewEntries r11 = (UrlPreViewEntries) r16.next();
        if (Intrinsics.areEqual(r11.getSourceId(), r4) == false) goto L14;
        Iterator<T> r12 = r11.getEntryList().iterator();
    L19:
        if (r12.hasNext() == false) goto L14;
        UrlPreViewEntry r13 = (UrlPreViewEntry) r12.next();
        if (r13.getOffset() > 0) goto L23;
        int r17 = 0;
    L28:
        Intrinsics.checkNotNull(r10);
        Iterator r18 = r10.iterator();
    L30:
        if (r18.hasNext() == false) goto L37;
        Object r19 = r18.next();
        if (((SpanInfo) ((UrlInfo) r19)).start != r17) goto L34;
        boolean r110 = true;
    L35:
        if (r110 == false) goto L30;
    L38:
        UrlInfo r111 = (UrlInfo) r19;
        if (r111 == null) goto L19;
        String r20 = r111.href;
        if (r20 != null) goto L44;
        r20 = BuildConfig.FLAVOR;
    L44:
        r7.put(r20, r13.getPreviewId());
        goto L19
    L34:
        r110 = false;
        goto L35
    L37:
        r19 = null;
        goto L38
    L23:
        if (r13.getOffset() <= r8.length) goto L25;
        int r21 = r8.length;
    L26:
        r17 = new String(ArraysKt.copyOfRange(r8, 0, r21), Charsets.UTF_8).length();
        goto L28
    L25:
        r21 = r13.getOffset();
        goto L26
    L45:
        r6 = r7;
    L46:
        this.$callback.a(r2, r6);
        return;
    L5:
        r0 = ChatHitPointExtraParams.DataSource.FROM_SDK;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((UrlPreviewResponse) r1);
    }

    public UserStatusParseUrlPreViewUtils$getRecogniseSpansResult$1(String r1, String r2, String r3, Long r4, ChatHitPointExtraParams.UrlAnalysisScene r5, hpc.a r6) {
        this.$description = r1;
        this.$sourceId = r2;
        this.$textMd5 = r3;
        this.$privateDescriptionId = r4;
        this.$scene = r5;
        this.$callback = r6;
    }
}
