package kotlinx.serialization.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0004J\u0014\u0010\u000e\u001a\u00020\u0002*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0004¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "()V", "composeName", "parentName", "childName", "elementName", "desc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "nested", "nestedName", "getTag", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class be extends cc<String> {
    public be() {
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "nestedName");
        String r0 = (String) ZeusTransformUtils.preCheckCast(v_(), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return a(r0, r4);
    }

    public String a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "parentName");
        Intrinsics.checkNotNullParameter(r3, "childName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return r3;
    L9:
        return r2 + '.' + r3;
    L5:
        r1 = false;
        goto L6
    }

    public final String k(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return a(l(r5, r4));
    }

    public String l(kotlinx.serialization.descriptors.f r2, int r3) {
        kotlinx.serialization.descriptors.f r1 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "desc");
        return r1.c(r3);
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ String m(kotlinx.serialization.descriptors.f r3, int r4) {
        return k((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), r4);
    }
}
