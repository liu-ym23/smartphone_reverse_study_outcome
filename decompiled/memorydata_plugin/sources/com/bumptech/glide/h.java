package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class h<TranscodeType> extends com.bumptech.glide.request.a<h<TranscodeType>> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.bumptech.glide.request.f f557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f558b;
    private final i c;
    private final Class<TranscodeType> d;
    private final c e;
    private final e f;
    private j<?, ? super TranscodeType> g;
    private Object h;
    private List<com.bumptech.glide.request.e<TranscodeType>> i;
    private h<TranscodeType> j;
    private h<TranscodeType> k;
    private Float l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* JADX INFO: renamed from: com.bumptech.glide.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f559a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f560b = null;

        static {
            int[] r0 = new int[Priority.values().length];
            f560b = r0;
            r0[Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L34:
            f560b[Priority.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L44:
            f560b[Priority.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            f560b[Priority.IMMEDIATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r4 = new int[ImageView.ScaleType.values().length];
            f559a = r4;
            r4[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L36:
            f559a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L42:
            f559a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L48:
            f559a[ImageView.ScaleType.FIT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L32:
            f559a[ImageView.ScaleType.FIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L40:
            f559a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L52:
            f559a[ImageView.ScaleType.CENTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L38:
            f559a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        f557a = (com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(new com.bumptech.glide.request.f().a(com.bumptech.glide.load.engine.h.c), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin")).a(Priority.LOW), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin")).b(true), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin");
    }

    public h(c r3, i r4, Class<TranscodeType> r5, Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.m = true;
        this.e = r3;
        this.c = r4;
        this.d = r5;
        this.f558b = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.g = r4.b(r5);
        this.f = (e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.d(), "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin");
        a(r4.i());
        a(r4.j());
    }

    private h<TranscodeType> a(Uri r2, h<TranscodeType> r3) {
        if (r2 != null) goto L4;
    L8:
        return r3;
    L4:
        if ("android.resource".equals(r2.getScheme()) == false) goto L8;
        return a(r3);
    }

    private h<TranscodeType> a(h<TranscodeType> r3) {
        return (h) ZeusTransformUtils.preCheckCast(((h) ZeusTransformUtils.preCheckCast(r3.a(this.f558b.getTheme()), h.class, "com.obric.memorydata.plugin")).a(com.bumptech.glide.e.a.a(this.f558b)), h.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private <Y extends com.bumptech.glide.request.a.e<TranscodeType>> Y a(Y r3, com.bumptech.glide.request.e<TranscodeType> r4, com.bumptech.glide.request.a<?> r5, Executor r6) {
        Y r7 = (Y) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.e<TranscodeType> r8 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.util.j.a(r7);
        if (this.n == false) goto L15;
        com.bumptech.glide.request.d r10 = b(r7, r8, r5, r9);
        com.bumptech.glide.request.d r11 = r7.b();
        if (r10.a(r11) == true) goto L7;
    L12:
        this.c.a(r7);
        r7.a(r10);
        this.c.a(r7, r10);
        return r7;
    L7:
        if (a(r5, r11) == true) goto L12;
        if (((com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r11), com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin")).d() == true) goto L11;
        r11.a();
    L11:
        return r7;
    L15:
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.d a(Object r17, com.bumptech.glide.request.a.e<TranscodeType> r18, com.bumptech.glide.request.e<TranscodeType> r19, RequestCoordinator r20, j<?, ? super TranscodeType> r21, Priority r22, int r23, int r24, com.bumptech.glide.request.a<?> r25, Executor r26) {
        com.bumptech.glide.request.a.e<TranscodeType> r12 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r18, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.e<TranscodeType> r13 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r19, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin");
        RequestCoordinator r0 = (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r20, RequestCoordinator.class, "com.obric.memorydata.plugin");
        Executor r14 = (Executor) ZeusTransformUtils.wrapperContextForParams(r26, Executor.class, "com.obric.memorydata.plugin");
        if (this.k == null) goto L5;
        RequestCoordinator r4 = new com.bumptech.glide.request.b(r17, r0);
        RequestCoordinator r10 = r4;
    L6:
        com.bumptech.glide.request.b r15 = r10;
        com.bumptech.glide.request.d r1 = b(r17, r12, r13, r4, r21, r22, r23, r24, r25, r14);
        if (r15 != 0) goto L9;
        return r1;
    L9:
        int r2 = this.k.w();
        int r3 = this.k.y();
        if (k.a(r23, r24) == true) goto L12;
    L14:
        int r11 = r3;
        h<TranscodeType> r5 = this.k;
        r15.a(r1, r5.a(r17, r12, r13, r15, r5.g, r5.v(), r2, r11, this.k, r14));
        return r15;
    L12:
        if (this.k.x() == true) goto L14;
        r2 = r25.w();
        r3 = r25.y();
        goto L14
    L5:
        r4 = r0;
        r10 = null;
        goto L6
    }

    private com.bumptech.glide.request.d a(Object r20, com.bumptech.glide.request.a.e<TranscodeType> r21, com.bumptech.glide.request.e<TranscodeType> r22, com.bumptech.glide.request.a<?> r23, RequestCoordinator r24, j<?, ? super TranscodeType> r25, Priority r26, int r27, int r28, Executor r29) {
        com.bumptech.glide.request.a.e r12 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r21, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.e r13 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r22, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin");
        RequestCoordinator r15 = (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r24, RequestCoordinator.class, "com.obric.memorydata.plugin");
        Executor r18 = (Executor) ZeusTransformUtils.wrapperContextForParams(r29, Executor.class, "com.obric.memorydata.plugin");
        Context r3 = this.f558b;
        e r4 = this.f;
        return SingleRequest.a(r3, r4, r20, this.h, this.d, r23, r27, r28, r26, r12, r13, this.i, r15, r4.c(), r25.b(), r18);
    }

    private void a(List<com.bumptech.glide.request.e<Object>> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        a((com.bumptech.glide.request.e) ZeusTransformUtils.preCheckCast(r5.next(), com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private boolean a(com.bumptech.glide.request.a<?> r2, com.bumptech.glide.request.d r3) {
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        if (r2.s() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.e() == false) goto L7;
        return true;
    }

    private Priority b(Priority r3) {
        int r4 = AnonymousClass1.f560b[r3.ordinal()];
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L14;
        if (r4 == 4) goto L14;
        throw new IllegalArgumentException("unknown priority: " + v());
    L14:
        return Priority.IMMEDIATE;
    L16:
        return Priority.HIGH;
    L18:
        return Priority.NORMAL;
    }

    private h<TranscodeType> b(Object r2) {
        if (f() == true) goto L5;
        this.h = r2;
        this.n = true;
        return (h) ZeusTransformUtils.preCheckCast(e(), h.class, "com.obric.memorydata.plugin");
    L5:
        return a().b(r2);
    }

    private com.bumptech.glide.request.d b(com.bumptech.glide.request.a.e<TranscodeType> r14, com.bumptech.glide.request.e<TranscodeType> r15, com.bumptech.glide.request.a<?> r16, Executor r17) {
        com.bumptech.glide.request.a.e<TranscodeType> r4 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r14, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.e<TranscodeType> r5 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r15, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin");
        Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r17, Executor.class, "com.obric.memorydata.plugin");
        return a(new Object(), r4, r5, null, this.g, r16.v(), r16.w(), r16.y(), r16, r12);
    }

    private com.bumptech.glide.request.d b(Object r22, com.bumptech.glide.request.a.e<TranscodeType> r23, com.bumptech.glide.request.e<TranscodeType> r24, RequestCoordinator r25, j<?, ? super TranscodeType> r26, Priority r27, int r28, int r29, com.bumptech.glide.request.a<?> r30, Executor r31) {
        com.bumptech.glide.request.a.e<TranscodeType> r14 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r23, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.e<TranscodeType> r15 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r24, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin");
        RequestCoordinator r5 = (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r25, RequestCoordinator.class, "com.obric.memorydata.plugin");
        Executor r16 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        h<TranscodeType> r0 = this.j;
        if (r0 == null) goto L24;
        if (this.o == true) goto L22;
        j<?, ? super TranscodeType> r1 = r0.g;
        if (r0.m == false) goto L9;
        j<?, ? super TranscodeType> r17 = r26;
    L11:
        if (r0.u() == false) goto L13;
        Priority r2 = this.j.v();
    L14:
        Priority r18 = r2;
        int r3 = this.j.w();
        int r4 = this.j.y();
        if (k.a(r28, r29) == true) goto L17;
    L19:
        com.bumptech.glide.request.h r10 = new com.bumptech.glide.request.h(r22, r5);
        com.bumptech.glide.request.d r11 = a(r22, r14, r15, r30, r10, r26, r27, r28, r29, r16);
        this.o = true;
        h<TranscodeType> r9 = this.j;
        j<?, ? super TranscodeType> r6 = r17;
        com.bumptech.glide.request.d r7 = r9.a(r22, r14, r15, r10, r6, r18, r3, r4, r9, r16);
        this.o = false;
        r10.a(r11, r7);
        return r10;
    L17:
        if (this.j.x() == true) goto L19;
        r3 = r30.w();
        r4 = r30.y();
        goto L19
    L13:
        r2 = b(r27);
        goto L14
    L9:
        r17 = r1;
        goto L11
    L22:
        throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    L24:
        if (this.l == null) goto L28;
        com.bumptech.glide.request.h r12 = new com.bumptech.glide.request.h(r22, r5);
        r12.a(a(r22, r14, r15, r30, r12, r26, r27, r28, r29, r16), a(r22, r14, r15, r30.b().a(this.l.floatValue()), r12, r26, b(r27), r28, r29, r16));
        return r12;
    L28:
        return a(r22, r14, r15, r30, r5, r26, r27, r28, r29, r16);
    }

    public h<TranscodeType> a() {
        h<TranscodeType> r2 = (h) ZeusTransformUtils.preCheckCast(super.b(), h.class, "com.obric.memorydata.plugin");
        r2.g = r2.g.a();
        if (r2.i == null) goto L5;
        r2.i = new ArrayList(r2.i);
    L5:
        h<TranscodeType> r0 = r2.j;
        if (r0 == null) goto L8;
        r2.j = r0.a();
    L8:
        h<TranscodeType> r1 = r2.k;
        if (r1 == null) goto L11;
        r2.k = r1.a();
    L11:
        return r2;
    }

    public h<TranscodeType> a(Uri r2) {
        return a(r2, b(r2));
    }

    public h<TranscodeType> a(com.bumptech.glide.request.a<?> r2) {
        com.bumptech.glide.util.j.a(r2);
        return (h) ZeusTransformUtils.preCheckCast(super.b(r2), h.class, "com.obric.memorydata.plugin");
    }

    public h<TranscodeType> a(com.bumptech.glide.request.e<TranscodeType> r3) {
        com.bumptech.glide.request.e<TranscodeType> r4 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin");
        if (f() == true) goto L5;
        if (r4 == null) goto L12;
        if (this.i != null) goto L10;
        this.i = new ArrayList();
    L10:
        this.i.add(r4);
    L12:
        return (h) ZeusTransformUtils.preCheckCast(e(), h.class, "com.obric.memorydata.plugin");
    L5:
        return a().a(r4);
    }

    public h<TranscodeType> a(Object r1) {
        return b(r1);
    }

    public <Y extends com.bumptech.glide.request.a.e<TranscodeType>> Y a(Y r3) {
        return (Y) a((com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin"), null, com.bumptech.glide.util.d.a());
    }

    <Y extends com.bumptech.glide.request.a.e<TranscodeType>> Y a(Y r3, com.bumptech.glide.request.e<TranscodeType> r4, Executor r5) {
        return (Y) a((com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin"), this, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b() {
        return a();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(com.bumptech.glide.request.a r1) {
        return a(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // com.bumptech.glide.request.a
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, h.class) == false) goto L26;
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin");
        if (super.equals(r5) == true) goto L7;
        return false;
    L7:
        if (Objects.equals(this.d, r5.d) == true) goto L9;
        return false;
    L9:
        if (this.g.equals(r5.g) == true) goto L11;
        return false;
    L11:
        if (Objects.equals(this.h, r5.h) == true) goto L13;
        return false;
    L13:
        if (Objects.equals(this.i, r5.i) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(this.j, r5.j) == true) goto L17;
        return false;
    L17:
        if (Objects.equals(this.k, r5.k) == true) goto L19;
        return false;
    L19:
        if (Objects.equals(this.l, r5.l) == true) goto L21;
        return false;
    L21:
        if (this.m == r5.m) goto L23;
        return false;
    L23:
        if (this.n != r5.n) goto L36;
        return true;
    L36:
        return false;
    L26:
        return false;
    }

    @Override // com.bumptech.glide.request.a
    public int hashCode() {
        int r0 = super.hashCode();
        int r1 = k.a(this.d, r0);
        int r2 = k.a(this.g, r1);
        int r3 = k.a(this.h, r2);
        int r4 = k.a(this.i, r3);
        int r5 = k.a(this.j, r4);
        int r6 = k.a(this.k, r5);
        int r7 = k.a(this.l, r6);
        int r8 = k.a(this.m, r7);
        return k.a(this.n, r8);
    }
}
