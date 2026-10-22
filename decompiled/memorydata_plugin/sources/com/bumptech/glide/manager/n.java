package com.bumptech.glide.manager;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class n implements Handler.Callback {
    private static final a f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.i f928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f929b;
    private final ArrayMap<View, Fragment> c;
    private final i d;
    private final l e;

    public interface a {
        com.bumptech.glide.i a(com.bumptech.glide.c r1, j r2, o r3, Context r4);
    }

    static {
        f = new AnonymousClass1();
    }

    public n(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.c = new ArrayMap();
        if (r4 != null) goto L6;
        r4 = f;
    L6:
        this.f929b = r4;
        this.e = new l(r4);
        this.d = a();
    }

    private Fragment a(View r5, FragmentActivity r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r6, FragmentActivity.class, "com.obric.memorydata.plugin");
        this.c.clear();
        a(r7.getSupportFragmentManager().getFragments(), this.c);
        View r8 = r7.findViewById(R.id.content);
        Fragment r0 = null;
    L4:
        if (r5.equals(r8) == true) goto L11;
        r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.c.get(r5), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        if (ZeusTransformUtils.instanceOf(r5.getParent(), View.class) == false) goto L11;
        r5 = (View) ZeusTransformUtils.preCheckCast(r5.getParent(), View.class, "com.obric.memorydata.plugin");
    L11:
        this.c.clear();
        return r0;
    }

    private static i a() {
        if (com.bumptech.glide.load.resource.bitmap.n.f867b == false) goto L10;
        if (com.bumptech.glide.load.resource.bitmap.n.f866a == false) goto L10;
        return new h();
    L10:
        return new f();
    }

    private static void a(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return;
    L5:
        if (r3.isDestroyed() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    private static void a(Collection<Fragment> r3, Map<View, Fragment> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r7.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        if (r0.getView() == null) goto L7;
        r6.put(r0.getView(), r0);
        a(r0.getChildFragmentManager().getFragments(), r6);
        goto L7
    }

    private com.bumptech.glide.i b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (this.f928a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f928a != null) goto L8;
        com.bumptech.glide.c r0 = com.bumptech.glide.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        this.f928a = this.f929b.a(r0, new com.bumptech.glide.manager.a(), new g(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f928a;
    }

    private static Activity c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L7;
    L5:
        return (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L9;
        r3 = ZeusTransformUtils.wrapperContext(c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin");
        goto L5
    L9:
        return null;
    }

    private static boolean d(Context r2) {
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isFinishing() == false) goto L8;
        return false;
    }

    public com.bumptech.glide.i a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        if (com.bumptech.glide.util.k.b() == false) goto L19;
        if (ZeusTransformUtils.instanceOf(r5, Application.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r5, FragmentActivity.class) == false) goto L13;
        return a((FragmentActivity) ZeusTransformUtils.preCheckCast(r5, FragmentActivity.class, "com.obric.memorydata.plugin"));
    L13:
        if (ZeusTransformUtils.instanceOf(r5, ContextWrapper.class) == false) goto L19;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r5, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L19;
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r5, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L19:
        return b(r5);
    L21:
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public com.bumptech.glide.i a(View r4) {
        if (com.bumptech.glide.util.k.c() == true) goto L5;
        com.bumptech.glide.util.j.a(r4);
        com.bumptech.glide.util.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "Unable to obtain a request manager for a view without a Context");
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        if (ZeusTransformUtils.instanceOf(r0, FragmentActivity.class) == false) goto L5;
        Fragment r5 = a(r4, (FragmentActivity) ZeusTransformUtils.preCheckCast(r0, FragmentActivity.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L15;
        return a(r5);
    L15:
        return a((FragmentActivity) ZeusTransformUtils.preCheckCast(r0, FragmentActivity.class, "com.obric.memorydata.plugin"));
    L5:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
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
    public com.bumptech.glide.i a(Fragment r10) {
        com.bumptech.glide.util.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.k.c() == false) goto L7;
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L7:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L9;
        this.d.a((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"));
    L9:
        FragmentManager r7 = r10.getChildFragmentManager();
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.c r5 = com.bumptech.glide.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return this.e.a(r4, r5, r10.getLifecycle(), r7, r10.isVisible());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.Activity, android.content.Context, androidx.fragment.app.FragmentActivity] */
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
    public com.bumptech.glide.i a(FragmentActivity r9) {
        ?? r3 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r9, FragmentActivity.class, "com.obric.memorydata.plugin");
        if (com.bumptech.glide.util.k.c() == true) goto L5;
        a(r3);
        this.d.a(r3);
        boolean r7 = d(r3);
        com.bumptech.glide.c r4 = com.bumptech.glide.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return this.e.a(r3, r4, r3.getLifecycle(), r3.getSupportFragmentManager(), r7);
    L5:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Handler.Callback
    @Deprecated
    public boolean handleMessage(Message r1) {
        return false;
    }
}
