package com.ttnet.org.chromium.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class UnownedUserDataKey<T extends UnownedUserData> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NonNull
    private final Class<T> mClazz;
    private final Set<UnownedUserDataHost> mWeakHostAttachments;

    static {
    }

    public UnownedUserDataKey(@NonNull Class<T> r10) {
        this.mWeakHostAttachments = Collections.newSetFromMap(new WeakHashMap());
        this.mClazz = r10;
    }

    private void assertNoDestroyedAttachments() {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L12;
        Iterator<UnownedUserDataHost> r10 = this.mWeakHostAttachments.iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        if (r10.next().isDestroyed() == false) goto L6;
        throw new IllegalStateException();
    L16:
        return;
    }

    private void removeHostAttachment(UnownedUserDataHost r10) {
        r10.remove(this);
        this.mWeakHostAttachments.remove(r10);
    }

    public final void attachToHost(@NonNull UnownedUserDataHost r10, @NonNull T r11) {
        Objects.requireNonNull(r11);
        r10.set(this, r11);
        if (isAttachedToHost(r10) == true) goto L6;
        this.mWeakHostAttachments.add(r10);
        return;
    }

    public final void detachFromAllHosts(@NonNull T r10) {
        assertNoDestroyedAttachments();
        Iterator r11 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        UnownedUserDataHost r12 = (UnownedUserDataHost) r11.next();
        if (r10.equals(r12.get(this)) == false) goto L4;
        removeHostAttachment(r12);
        goto L4
    }

    public final void detachFromHost(@NonNull UnownedUserDataHost r10) {
        assertNoDestroyedAttachments();
        Iterator r11 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        UnownedUserDataHost r12 = (UnownedUserDataHost) r11.next();
        if (r10.equals(r12) == false) goto L4;
        removeHostAttachment(r12);
        goto L4
    }

    @VisibleForTesting(otherwise = 2)
    int getHostAttachmentCount(@NonNull T r10) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r11 = this.mWeakHostAttachments.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r10.equals(r11.next().get(this)) == false) goto L4;
        r12 = r12 + 1;
        goto L4
    L8:
        return r12;
    }

    @NonNull
    final Class<T> getValueClass() {
        return this.mClazz;
    }

    public final boolean isAttachedToAnyHost(@NonNull T r10) {
        if (getHostAttachmentCount(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAttachedToHost(@NonNull UnownedUserDataHost r10) {
        if (retrieveDataFromHost(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public final T retrieveDataFromHost(@NonNull UnownedUserDataHost r10) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r11 = this.mWeakHostAttachments.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r10.equals(r11.next()) == false) goto L4;
        return (T) r10.get(this);
    L9:
        return null;
    }
}
