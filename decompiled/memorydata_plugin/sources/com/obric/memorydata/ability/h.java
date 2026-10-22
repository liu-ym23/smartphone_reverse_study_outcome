package com.obric.memorydata.ability;

import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0019\u001a\u00020\nJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\b\u001a>\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\tj\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/ability/AbilitySubscribeInfoHandler;", "", "<init>", "()V", "TAG", "", "infoLock", "Ljava/util/concurrent/locks/ReentrantLock;", "dataIdSubscribeMap", "Ljava/util/HashMap;", "Lcom/obric/memorydata/ability/AbilityParams;", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/ability/SubscribeInfo;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "subscribeInfos", "Ljava/util/LinkedList;", AwarenessManagerImpl.ACTION_SUBSCRIBE, "subscribeRequest", "Lcom/obric/memorydata/ability/SubscribeRequest;", "abilityWrapper", "Lcom/obric/memorydata/ability/AbilityWrapper;", "unsubscribe", "getSubscribeInfoBy", "", "abilityParams", "invalidSubscribeRequest", "", "createSubscribeInfo", "getCacheSubscribeInfo", "isEquals", "subscribeInfo", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantLock f8362b = null;
    private static final HashMap<f, ArrayList<n>> c = null;
    private static final LinkedList<n> d = null;

    static {
        f8361a = new h();
        f8362b = new ReentrantLock(true);
        c = new HashMap();
        d = new LinkedList();
    }

    private h() {
    }

    private final boolean a(n r2, o r3) {
        if (Intrinsics.areEqual(r2.a(), r3.a()) == true) goto L5;
    L11:
        return false;
    L5:
        if (r2.d() != r3.d()) goto L11;
        if (r2.f() != r3.e()) goto L11;
        if (Intrinsics.areEqual(r2.b(), r3.b()) == false) goto L11;
        return true;
    }

    private final boolean a(o r7) {
        if (r7 == null) goto L4;
        k r6 = r7.b();
    L5:
        if (r6 != null) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilitySubscribeInfoHandler", "request is null or data receiver is null", null, 4, null);
        return true;
    L8:
        return false;
    L4:
        r6 = null;
        goto L5
    }

    private final n b(o r9) {
        if (r9.e() != AbilityRequestType.QUERY) goto L5;
        String r8 = r9.b().g_() + "#query";
    L7:
        return new n(r9.a(), r9.b(), r9.c(), r9.d(), r8, r9.e(), 0);
    L5:
        r8 = r9.b().g_();
        goto L7
    }

    private final n c(o r5) {
        Iterator<n> r0 = d.iterator();
        Intrinsics.checkNotNullExpressionValue(r0, "iterator(...)");
    L4:
        if (r0.hasNext() == false) goto L8;
        n r1 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r1, "next(...)");
        n r2 = (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin");
        if (a(r2, r5) == false) goto L4;
        return r2;
    L8:
        return null;
    }

    public final n a(o r5, i r6) {
        Intrinsics.checkNotNullParameter(r5, "subscribeRequest");
        Intrinsics.checkNotNullParameter(r6, "abilityWrapper");
        if (a(r5) == false) goto L6;
        return null;
    L6:
        ReentrantLock r0 = f8362b;
        r0.lock();
        n r1 = c(r5);
        if (r1 != null) goto L12;
        r1 = b(r5);
        d.add(r1);
        HashMap<f, ArrayList<n>> r4 = c;
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(r4.get(r1.a()), ArrayList.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L11;
        ArrayList r8 = new ArrayList();
        r8.add(r1);
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin")).put(r1.a(), r8);
        goto L12
    L11:
        r7.add(r1);
    L12:
        r1.a(r1.g() + 1);
        r0.unlock();
        r6.f();
        return r1;
    }

    public final List<n> a(f r3) {
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        ReentrantLock r2 = f8362b;
        r2.lock();
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(c.get(r3), ArrayList.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = new ArrayList();
    L5:
        r2.unlock();
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
    }

    public final n b(o r9, i r10) {
        Intrinsics.checkNotNullParameter(r9, "subscribeRequest");
        Intrinsics.checkNotNullParameter(r10, "abilityWrapper");
        if (a(r9) == false) goto L5;
        return null;
    L5:
        ReentrantLock r0 = f8362b;
        r0.lock();
        n r8 = c(r9);
        if (r8 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilitySubscribeInfoHandler", "unsubscribe cacheInfo is null for dataId: " + r9.d(), null, 4, null);
        r0.unlock();
        return null;
    L9:
        r8.a(r8.g() - 1);
        if (r8.g() != 0) goto L14;
        d.remove(r8);
        HashMap<f, ArrayList<n>> r11 = c;
        ArrayList r1 = (ArrayList) ZeusTransformUtils.preCheckCast(r11.get(r8.a()), ArrayList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        r1.remove(r8);
        if (r1.isEmpty() == false) goto L14;
        r11.remove(r8.a());
    L14:
        r0.unlock();
        r10.e();
        return r8;
    }
}
