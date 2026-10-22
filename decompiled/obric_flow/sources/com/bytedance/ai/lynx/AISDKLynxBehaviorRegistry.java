package com.bytedance.ai.lynx;

import androidx.annotation.Keep;
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
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\bJ\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry;", "", "<init>", "()V", "Lcom/bytedance/ai/lynx/b;", "provider", "", "registerProvider", "(Lcom/bytedance/ai/lynx/b;)V", "", "tag", "Lcom/lynx/tasm/behavior/a;", "behavior", "registerBehavior", "(Ljava/lang/String;Lcom/lynx/tasm/behavior/a;)V", "", "tryRegisterBehavior", "(Ljava/lang/String;Lcom/lynx/tasm/behavior/a;)Z", "unregisterBehavior", "(Ljava/lang/String;)V", "unregisterProvider", "", "behaviors", "addBehaviors", "(Ljava/util/List;)Lcom/bytedance/ai/lynx/b;", "addBehavior", "(Lcom/lynx/tasm/behavior/a;)Lcom/bytedance/ai/lynx/b;", "getExtraBehaviors", "()Ljava/util/List;", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "taggedBehaviors", "Ljava/util/concurrent/ConcurrentHashMap;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAISDKLynxBehaviorRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AISDKLynxBehaviorRegistry.kt\ncom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1863#2:103\n1864#2:105\n1#3:104\n*S KotlinDebug\n*F\n+ 1 AISDKLynxBehaviorRegistry.kt\ncom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry\n*L\n92#1:103\n92#1:105\n*E\n"})
public final class AISDKLynxBehaviorRegistry {
    public static final AISDKLynxBehaviorRegistry INSTANCE = null;
    private static final String TAG = "AISDKLynxBehaviorRegistry";
    private static final CopyOnWriteArrayList<b> providers = null;
    private static final ConcurrentHashMap<String, com.lynx.tasm.behavior.a> taggedBehaviors = null;

    static {
        INSTANCE = new AISDKLynxBehaviorRegistry();
        providers = new CopyOnWriteArrayList();
        taggedBehaviors = new ConcurrentHashMap();
    }

    private AISDKLynxBehaviorRegistry() {
    }

    @JvmStatic
    public static final b addBehavior(com.lynx.tasm.behavior.a r5) {
        Intrinsics.checkNotNullParameter(r5, "behavior");
        return addBehaviors(CollectionsKt.listOf(r5));
    }

    @JvmStatic
    public static final b addBehaviors(List<? extends com.lynx.tasm.behavior.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "behaviors");
        a r10 = new a(r5);
        registerProvider(r10);
        return r10;
    }

    private static final List addBehaviors$lambda$0(List r5) {
        return r5;
    }

    @JvmStatic
    public static final List<com.lynx.tasm.behavior.a> getExtraBehaviors() {
        CopyOnWriteArrayList<b> r5 = providers;
        if (r5.isEmpty() == true) goto L5;
    L8:
        ConcurrentHashMap<String, com.lynx.tasm.behavior.a> r10 = taggedBehaviors;
        ArrayList r11 = new ArrayList(r10.size() + 8);
        r11.addAll(r10.values());
        Iterator<T> r12 = r5.iterator();
    L10:
        if (r12.hasNext() == false) goto L24;
        b r13 = (b) r12.next();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L14
        Object r15 = Result.m124constructorimpl(addBehaviors$lambda$0(((a) r13).f2173a));     // Catch: Throwable -> L14
    L16:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L23;
        String r17 = "provider.getBehaviors failed: " + r13;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L22;
        r18.e(TAG, r17, r16);
    L22:
        r15 = CollectionsKt.emptyList();
    L23:
        r11.addAll((List) r15);
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L16
    L24:
        return r11;
    L5:
        if (taggedBehaviors.isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final void registerBehavior(String r5, com.lynx.tasm.behavior.a r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "behavior");
        taggedBehaviors.put(r5, r10);
    }

    @JvmStatic
    public static final void registerProvider(b r5) {
        Intrinsics.checkNotNullParameter(r5, "provider");
        CopyOnWriteArrayList<b> r10 = providers;
        if (r10.contains(r5) == true) goto L6;
        r10.add(r5);
        return;
    }

    @JvmStatic
    public static final boolean tryRegisterBehavior(String r5, com.lynx.tasm.behavior.a r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "behavior");
        if (taggedBehaviors.putIfAbsent(r5, r10) != null) goto L6;
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final void unregisterBehavior(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        taggedBehaviors.remove(r5);
    }

    @JvmStatic
    public static final void unregisterProvider(b r5) {
        Intrinsics.checkNotNullParameter(r5, "provider");
        providers.remove(r5);
    }
}
