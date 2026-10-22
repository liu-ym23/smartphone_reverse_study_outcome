package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0007"}, d2 = {"mapToIdStringList", "", "", "appEntityList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "printStringArray", "array", "capabilitykit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class q {

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7604a = null;

        static {
            f7604a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CharSequence invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }
    }

    public static final List<String> a(List<? extends AppEntity> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "appEntityList");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(((AppEntity) ZeusTransformUtils.preCheckCast(r6.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L4
    L6:
        return r0;
    }

    public static final String b(List<String> r9) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "array");
        return CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, a.f7604a, 30, null);
    }
}
