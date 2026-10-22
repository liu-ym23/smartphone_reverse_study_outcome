package kotlinx.serialization.descriptors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00122\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010&\u001a\u00020\u0017R*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR$\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_core", "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_core", "elementNames", "getElementNames$kotlinx_serialization_core", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_core", "isNullable", "isNullable$annotations", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "elementName", "descriptor", "isOptional", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<? extends Annotation> f17667b;
    private final List<String> c;
    private final Set<String> d;
    private final List<f> e;
    private final List<List<Annotation>> f;
    private final List<Boolean> g;

    public a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "serialName");
        this.f17666a = r3;
        this.f17667b = CollectionsKt.emptyList();
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.d = (Set) ZeusTransformUtils.preCheckCast(new HashSet(), Set.class, "com.obric.memorydata.plugin");
        this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.g = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void a(a r1, String r2, f r3, List r4, boolean r5, int r6, Object r7) {
        f r8 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        List<? extends Annotation> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r9 = CollectionsKt.emptyList();
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = false;
    L8:
        r1.a(r2, r8, r9, r5);
    }

    public final List<Annotation> a() {
        return this.f17667b;
    }

    public final void a(String r4, f r5, List<? extends Annotation> r6, boolean r7) {
        f r8 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elementName");
        Intrinsics.checkNotNullParameter(r8, "descriptor");
        Intrinsics.checkNotNullParameter(r9, "annotations");
        if (this.d.add(r4) == false) goto L7;
        ((Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin")).add(r4);
        ((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).add(r8);
        ((Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.memorydata.plugin")).add(r9);
        ((Collection) ZeusTransformUtils.preCheckCast(this.g, Collection.class, "com.obric.memorydata.plugin")).add(Boolean.valueOf(r7));
        return;
    L7:
        throw new IllegalArgumentException(("Element with name '" + r4 + "' is already registered").toString());
    }

    public final void a(List<? extends Annotation> r3) {
        List<? extends Annotation> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f17667b = r4;
    }

    public final List<String> b() {
        return this.c;
    }

    public final List<f> c() {
        return this.e;
    }

    public final List<List<Annotation>> d() {
        return this.f;
    }

    public final List<Boolean> e() {
        return this.g;
    }
}
