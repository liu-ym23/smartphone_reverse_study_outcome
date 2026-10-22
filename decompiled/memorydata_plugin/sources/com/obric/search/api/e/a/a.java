package com.obric.search.api.e.a;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/search/api/remove/impl/FullTextSearchRemoveSpec;", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "schemaName", "", Constants.KEY_LIST, "", "Lcom/obric/search/api/document/intf/IDocument;", "removeAll", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getList", "()Ljava/util/List;", "getRemoveAll", "()Z", "getSchemaName", "()Ljava/lang/String;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements com.obric.search.api.e.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.obric.search.api.b.a.a> f14938b;
    private final boolean c;

    public a(String r3, List<? extends com.obric.search.api.b.a.a> r4, boolean r5) {
        List<com.obric.search.api.b.a.a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "schemaName");
        Intrinsics.checkNotNullParameter(r6, Constants.KEY_LIST);
        this.f14937a = r3;
        this.f14938b = r6;
        this.c = r5;
    }

    public /* synthetic */ a(String r2, List r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r2, r7, r4);
    }

    @Override // com.obric.search.api.e.b.a
    public String a() {
        return this.f14937a;
    }

    public final List<com.obric.search.api.b.a.a> b() {
        return this.f14938b;
    }

    public final boolean c() {
        return this.c;
    }
}
