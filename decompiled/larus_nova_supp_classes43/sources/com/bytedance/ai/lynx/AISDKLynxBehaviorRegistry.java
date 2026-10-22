package com.bytedance.ai.lynx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry;", "", "<init>", "()V", "TAG", "", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry$Provider;", "taggedBehaviors", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/lynx/tasm/behavior/Behavior;", "registerProvider", "", "provider", "registerBehavior", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "behavior", "tryRegisterBehavior", "", "unregisterBehavior", "unregisterProvider", "addBehaviors", "behaviors", "", "addBehavior", "getExtraBehaviors", "Provider", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AISDKLynxBehaviorRegistry {
    public static final AISDKLynxBehaviorRegistry INSTANCE = null;
    private static final String TAG = "AISDKLynxBehaviorRegistry";
    private static final CopyOnWriteArrayList<a> providers = null;
    private static final ConcurrentHashMap<String, com.lynx.tasm.behavior.a> taggedBehaviors = null;

    public interface a {
        List<com.lynx.tasm.behavior.a> a();
    }

    private AISDKLynxBehaviorRegistry() {
    }

    public static /* synthetic */ List a(List r0) {
        return addBehaviors$lambda$0(r0);
    }

    private static final List addBehaviors$lambda$0(List r0) {
        return r0;
    }

    static {
        INSTANCE = new AISDKLynxBehaviorRegistry();
        providers = new CopyOnWriteArrayList();
        taggedBehaviors = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final List<com.lynx.tasm.behavior.a> getExtraBehaviors() {
        CopyOnWriteArrayList<a> r0 = providers;
        if (r0.isEmpty() == true) goto L5;
    L8:
        ConcurrentHashMap<String, com.lynx.tasm.behavior.a> r10 = taggedBehaviors;
        ArrayList r1 = new ArrayList(r10.size() + 8);
        r1.addAll(r10.values());
        Iterator<T> r11 = r0.iterator();
    L10:
        if (r11.hasNext() == false) goto L21;
        a r12 = (a) r11.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L14
        Object r14 = Result.constructor-impl(r12.a());     // Catch: Throwable -> L14
    L16:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L20;
        com.bytedance.ai.utils.g.a.e(TAG, "provider.getBehaviors failed: " + r12, r15);
        r14 = CollectionsKt.emptyList();
    L20:
        r1.addAll((List) r14);
    L14:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L21:
        return r1;
    L5:
        if (taggedBehaviors.isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final a addBehavior(com.lynx.tasm.behavior.a r1) {
        Intrinsics.checkNotNullParameter(r1, "behavior");
        return addBehaviors(CollectionsKt.listOf(r1));
    }

    @JvmStatic
    public static final a addBehaviors(final List<? extends com.lynx.tasm.behavior.a> r1) {
        Intrinsics.checkNotNullParameter(r1, "behaviors");
        a r0 = new com.bytedance.ai.lynx.a(r1);
        registerProvider(r0);
        return r0;
    }

    @JvmStatic
    public static final void registerProvider(a r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        CopyOnWriteArrayList<a> r0 = providers;
        if (r0.contains(r10) == true) goto L6;
        r0.add(r10);
        return;
    }

    @JvmStatic
    public static final void unregisterBehavior(String r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        taggedBehaviors.remove(r1);
    }

    @JvmStatic
    public static final void unregisterProvider(a r1) {
        Intrinsics.checkNotNullParameter(r1, "provider");
        providers.remove(r1);
    }

    @JvmStatic
    public static final void registerBehavior(String r1, com.lynx.tasm.behavior.a r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, "behavior");
        taggedBehaviors.put(r1, r10);
    }

    @JvmStatic
    public static final boolean tryRegisterBehavior(String r1, com.lynx.tasm.behavior.a r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, "behavior");
        if (taggedBehaviors.putIfAbsent(r1, r10) != null) goto L5;
        return true;
    L5:
        return false;
    }
}
