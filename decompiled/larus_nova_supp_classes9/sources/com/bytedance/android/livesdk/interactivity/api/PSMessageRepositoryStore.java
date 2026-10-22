package com.bytedance.android.livesdk.interactivity.api;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0014R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PSMessageRepositoryStore;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/m;", "repository", BuildConfig.FLAVOR, "add", "remove", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/i;", "messageModel", "insertMessage", "deleteMessage", "modifyMessage", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$MessageModelType;", "type", BuildConfig.FLAVOR, "findMessageByType", BuildConfig.FLAVOR, "msgMethod", "checkAndRegisterMessageListener", "onCleared", "repositories", "Ljava/util/List;", BuildConfig.FLAVOR, "isCleared", "Z", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSMessageRepositoryStore extends ViewModel implements m {
    private boolean isCleared;
    private final List<m> repositories;

    public void onCleared() {
        this.isCleared = true;
        this.repositories.clear();
    }

    public PSMessageRepositoryStore() {
        this.repositories = new ArrayList();
    }

    public final void add(m r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        if (this.isCleared == false) goto L6;
        return;
    L6:
        if (this.repositories.contains(r2) == false) goto L8;
        return;
    L8:
        this.repositories.add(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public void checkAndRegisterMessageListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgMethod");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.repositories.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((m) r0.next()).checkAndRegisterMessageListener(r3);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public void deleteMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3) {
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.repositories.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((m) r0.next()).deleteMessage(r3);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public List<com.bytedance.android.livesdk.interactivity.api.publicscreen.i> findMessageByType(PublicScreenConfig$MessageModelType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        if (this.isCleared == false) goto L5;
        return null;
    L5:
        m r0 = (m) CollectionsKt.firstOrNull(this.repositories);
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.findMessageByType(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public void insertMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3) {
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.repositories.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((m) r0.next()).insertMessage(r3);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public void modifyMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3) {
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.repositories.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((m) r0.next()).modifyMessage(r3);
        goto L7
    }

    public final void remove(m r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        this.repositories.remove(r2);
    }
}
