package com.obric.memorydata.screencapture.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0015\u001a\u00020\u0014H\u0002J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/ViewTreeCacheManager;", "", "<init>", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/screencapture/accessibility/ViewTreeCacheManager$CachedViewTree;", "CACHE_MAX_EXPIRE_MS", "", "getViewTree", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "cacheValidDuration", "visibleOnly", "", "removeCache", "", "cleanExpired", "summary", "CachedViewTree", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f12788b = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/ViewTreeCacheManager$CachedViewTree;", "", "viewTreeNodes", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "timestamp", "", "<init>", "(Ljava/util/List;J)V", "getViewTreeNodes", "()Ljava/util/List;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<ViewTreeNode> f12789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12790b;

        public a(List<ViewTreeNode> r3, long r4) {
            List<ViewTreeNode> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "viewTreeNodes");
            this.f12789a = r5;
            this.f12790b = r4;
        }

        public final List<ViewTreeNode> a() {
            return this.f12789a;
        }

        public final long b() {
            return this.f12790b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12789a, r8.f12789a) == true) goto L12;
            return false;
        L12:
            if (this.f12790b == r8.f12790b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12789a.hashCode() * 31) + Long.hashCode(this.f12790b);
        }

        public String toString() {
            return "CachedViewTree(viewTreeNodes=" + this.f12789a + ", timestamp=" + this.f12790b + ')';
        }
    }

    static {
        f12787a = new f();
        f12788b = new ConcurrentHashMap();
    }

    private f() {
    }

    public static /* synthetic */ List a(f r0, AccessibilityNodeInfo r1, long r2, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = true;
    L6:
        return r0.a(r1, r2, r4);
    }

    private final void a() {
        long r0 = System.currentTimeMillis();
        Iterator<Map.Entry<String, a>> r6 = f12788b.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        if (Math.abs(r0 - ((a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), a.class, "com.obric.memorydata.plugin")).b()) < 60000) goto L4;
        r6.remove();
        goto L4
    }

    private final String b(AccessibilityNodeInfo r4) {
        StringBuilder r3 = new StringBuilder().append("rootPkg=").append(r4.getPackageName()).append(" rootCls=").append(r4.getClassName()).append(" rootVisible=").append(r4.isVisibleToUser()).append(" rootChildren=").append(r4.getChildCount()).append(" rootText=");
        CharSequence r0 = r4.getText();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        StringBuilder r5 = r3.append(!r2).append(" rootDesc=");
        CharSequence r6 = r4.getContentDescription();
        if (r6 != null) goto L12;
    L13:
        r1 = true;
    L15:
        return r5.append(!r1).toString();
    L12:
        if (r6.length() != 0) goto L15;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final List<ViewTreeNode> a(AccessibilityNodeInfo r12, long r13, boolean r15) {
        if (r12 == null) goto L4;
        a();
        String r0 = Integer.toHexString(r12.hashCode()) + '_' + r15;
        long r1 = System.currentTimeMillis();
        ConcurrentHashMap<String, a> r3 = f12788b;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.get(r0), a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
    L10:
        long r14 = System.currentTimeMillis();
        List<ViewTreeNode> r5 = com.obric.memorydata.screencapture.a.b.f12768a.a(r12, r15);
        RunLog.INSTANCE.debug("ViewTreeCacheManager", "viewtree result cache=miss visibleOnly=" + r15 + " nodes=" + r5.size() + " costMs=" + (System.currentTimeMillis() - r14) + ' ' + b(r12));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r0, new a(r5, r1));
    L14:
        return r5;
    L8:
        if (Math.abs(r1 - r4.b()) >= r13) goto L10;
        RunLog.INSTANCE.debug("ViewTreeCacheManager", "viewtree result cache=hit visibleOnly=" + r15 + " nodes=" + r4.a().size() + ' ' + b(r12));
        return r4.a();
    L4:
        return CollectionsKt.emptyList();
    }

    public final void a(AccessibilityNodeInfo r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r5 = Integer.toHexString(r6.hashCode());
        Iterator r7 = ((Map) ZeusTransformUtils.preCheckCast(f12788b, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        if (StringsKt.startsWith$default(r0, r5, false, 2, null) == false) goto L6;
        r7.remove();
        goto L6
    }
}
