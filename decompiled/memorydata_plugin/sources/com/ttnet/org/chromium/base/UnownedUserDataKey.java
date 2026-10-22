package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class UnownedUserDataKey<T extends UnownedUserData> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Class<T> mClazz;
    private final Set<UnownedUserDataHost> mWeakHostAttachments;

    static {
    }

    public UnownedUserDataKey(Class<T> r2) {
        this.mWeakHostAttachments = Collections.newSetFromMap(new WeakHashMap());
        this.mClazz = r2;
    }

    private void assertNoDestroyedAttachments() {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L11;
        Iterator<UnownedUserDataHost> r3 = this.mWeakHostAttachments.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        if (((UnownedUserDataHost) ZeusTransformUtils.preCheckCast(r3.next(), UnownedUserDataHost.class, "com.obric.memorydata.plugin")).isDestroyed() == false) goto L6;
        throw new IllegalStateException();
    L15:
        return;
    }

    private void removeHostAttachment(UnownedUserDataHost r1) {
        r1.remove(this);
        this.mWeakHostAttachments.remove(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void attachToHost(UnownedUserDataHost r3, T r4) {
        UnownedUserData r5 = (UnownedUserData) ZeusTransformUtils.wrapperContextForParams(r4, UnownedUserData.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5);
        r3.set(this, r5);
        if (isAttachedToHost(r3) == true) goto L6;
        this.mWeakHostAttachments.add(r3);
        return;
    }

    public final void detachFromAllHosts(T r5) {
        UnownedUserData r6 = (UnownedUserData) ZeusTransformUtils.wrapperContextForParams(r5, UnownedUserData.class, "com.obric.memorydata.plugin");
        assertNoDestroyedAttachments();
        Iterator r0 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UnownedUserDataHost r2 = (UnownedUserDataHost) ZeusTransformUtils.preCheckCast(r0.next(), UnownedUserDataHost.class, "com.obric.memorydata.plugin");
        if (r6.equals(r2.get(this)) == false) goto L4;
        removeHostAttachment(r2);
        goto L4
    }

    public final void detachFromHost(UnownedUserDataHost r5) {
        assertNoDestroyedAttachments();
        Iterator r0 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UnownedUserDataHost r1 = (UnownedUserDataHost) ZeusTransformUtils.preCheckCast(r0.next(), UnownedUserDataHost.class, "com.obric.memorydata.plugin");
        if (r5.equals(r1) == false) goto L4;
        removeHostAttachment(r1);
        goto L4
    }

    int getHostAttachmentCount(T r6) {
        UnownedUserData r7 = (UnownedUserData) ZeusTransformUtils.wrapperContextForParams(r6, UnownedUserData.class, "com.obric.memorydata.plugin");
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r0 = this.mWeakHostAttachments.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r7.equals(((UnownedUserDataHost) ZeusTransformUtils.preCheckCast(r0.next(), UnownedUserDataHost.class, "com.obric.memorydata.plugin")).get(this)) == false) goto L4;
        r2 = r2 + 1;
        goto L4
    L8:
        return r2;
    }

    final Class<T> getValueClass() {
        return this.mClazz;
    }

    public final boolean isAttachedToAnyHost(T r3) {
        if (getHostAttachmentCount((UnownedUserData) ZeusTransformUtils.wrapperContextForParams(r3, UnownedUserData.class, "com.obric.memorydata.plugin")) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAttachedToHost(UnownedUserDataHost r1) {
        if (retrieveDataFromHost(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final T retrieveDataFromHost(UnownedUserDataHost r5) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r0 = this.mWeakHostAttachments.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r5.equals((UnownedUserDataHost) ZeusTransformUtils.preCheckCast(r0.next(), UnownedUserDataHost.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return (T) r5.get(this);
    L9:
        return null;
    }
}
