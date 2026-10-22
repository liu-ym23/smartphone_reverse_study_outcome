package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/markdown/custom/MenuBuilder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "items", "", "Lcom/obric/memorydata/markdown/custom/MenuBuilder$MenuItem;", "title", "", "t", "item", AnnotatedPrivateKey.LABEL, "action", "Lkotlin/Function0;", "", "show", "Lcom/obric/memorydata/markdown/custom/OMenuDialog;", "MenuItem", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f9985b;
    private String c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/markdown/custom/MenuBuilder$MenuItem;", "", AnnotatedPrivateKey.LABEL, "", "action", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getLabel", "()Ljava/lang/String;", "getAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function0<Unit> f9987b;

        public a(String r3, Function0<Unit> r4) {
            Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, AnnotatedPrivateKey.LABEL);
            Intrinsics.checkNotNullParameter(r5, "action");
            this.f9986a = r3;
            this.f9987b = r5;
        }

        public final String a() {
            return this.f9986a;
        }

        public final Function0<Unit> b() {
            return this.f9987b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9986a, r6.f9986a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9987b, r6.f9987b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9986a.hashCode() * 31) + this.f9987b.hashCode();
        }

        public String toString() {
            return "MenuItem(label=" + this.f9986a + ", action=" + this.f9987b + ')';
        }
    }

    public f(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f9984a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f9985b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private static final void a(a r0, h r1, View r2) {
        r0.b().invoke();
        r1.b();
    }

    /* JADX INFO: renamed from: lambda$niT1-NN8kGCKf_e7AStMBhmHI4Q, reason: not valid java name */
    public static /* synthetic */ void m679lambda$niT1NN8kGCKf_e7AStMBhmHI4Q(a r0, h r1, View r2) {
        a(r0, r1, r2);
    }

    public final f a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        ((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin")).c = r4;
        return (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");
    }

    public final f a(String r5, Function0<Unit> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(r7, "action");
        ((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin")).f9985b.add(new a(r5, r7));
        return (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");
    }

    public final h a() {
        final h r0 = new h(this.f9984a);
        String r1 = this.c;
        if (r1 == null) goto L5;
        r0.a(r1);
    L5:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f9985b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r3.add(((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).a());
        goto L7
    L9:
        List<String> r5 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(this.f9985b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        final a r9 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");
        r6.add(new $$Lambda$f$niT1NN8kGCKf_e7AStMBhmHI4Q(r9, r0));
        goto L11
    L13:
        r0.a(r5, CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        r0.a();
        return r0;
    }
}
