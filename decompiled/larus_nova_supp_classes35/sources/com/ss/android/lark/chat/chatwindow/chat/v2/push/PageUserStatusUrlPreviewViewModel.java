package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import androidx.lifecycle.ViewModel;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.n1;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.utils.ApiUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0016\u0010\u001a\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0014R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PageUserStatusUrlPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/chatpreview/ISignUrlPreviewPushListener;", "<init>", "()V", "previewApi", "Lcom/ss/android/lark/biz/im/api/ChatPreviewApi;", "kotlin.jvm.PlatformType", "sources", "Ljava/util/LinkedHashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PageUserStatusUrlPreviewViewModel$StatusSource;", "registerSource", BuildConfig.FLAVOR, "sourceKey", "scene", "Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$UrlAnalysisScene;", "provider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PageUserStatusUrlPreviewViewModel$SnapshotProvider;", "listener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PageUserStatusUrlPreviewViewModel$StatusChangeListener;", "unregisterSource", "onPushSignUrlPreview", "entriesList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "handlePush", "onCleared", "SnapshotProvider", "StatusChangeListener", "StatusSource", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageUserStatusUrlPreviewViewModel extends ViewModel implements d7b.a {
    private final com.ss.android.lark.biz.im.api.e previewApi;
    private final LinkedHashMap<Object, c> sources;

    public interface a {
        Collection<n1> a();
    }

    public interface b {
        void a(Set<String> r1);
    }

    public static final class c {
        public final ChatHitPointExtraParams.UrlAnalysisScene a;
        public final a b;
        public final b c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "StatusSource(scene=" + this.a + ", provider=" + this.b + ", listener=" + this.c + ')';
        }

        public c(ChatHitPointExtraParams.UrlAnalysisScene r2, a r3, b r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "provider");
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PageUserStatusUrlPreviewViewModel a;
        public final /* synthetic */ List<UrlPreViewEntries> b;

        public d(PageUserStatusUrlPreviewViewModel r1, List<UrlPreViewEntries> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PageUserStatusUrlPreviewViewModel.access$handlePush(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void onCleared() {
        this.sources.clear();
        this.previewApi.d(this);
    }

    public PageUserStatusUrlPreviewViewModel() {
        com.ss.android.lark.biz.im.api.e r0 = ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatPreviewApi();
        this.previewApi = r0;
        this.sources = new LinkedHashMap();
        r0.c(this);
    }

    private final void handlePush(List<UrlPreViewEntries> r12) {
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r12.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        UrlPreViewEntries r2 = (UrlPreViewEntries) r0.next();
        String r3 = r2.getSourceId();
        if (r3 != null) goto L8;
        Triple r4 = null;
    L13:
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L8:
        String r5 = r2.getSourceTextMD5();
        Long r6 = r2.getPrivateDescriptionId();
        if (r6 == null) goto L11;
        long r7 = r6.longValue();
    L12:
        r4 = new Triple(r3, r5, Long.valueOf(r7));
        goto L13
    L11:
        r7 = 0;
        goto L12
    L15:
        final Set r8 = CollectionsKt.toSet(r1);
        Iterator r9 = CollectionsKt.toList(this.sources.values()).iterator();
    L17:
        if (r9.hasNext() == false) goto L29;
        c r10 = (c) r9.next();
        List r11 = SequencesKt.toList(SequencesKt.filter(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(r10.b.a()), PageUserStatusUrlPreviewViewModel$handlePush$1$matchedSnapshots$1.INSTANCE), PageUserStatusUrlPreviewViewModel$handlePush$1$matchedSnapshots$2.INSTANCE), new PageUserStatusUrlPreviewViewModel$handlePush$1$matchedSnapshots$3(r8)));
        if (r11.isEmpty() == true) goto L17;
        int r13 = UserStatusParseUrlPreViewUtils.a;
        List r14 = r11;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        n1 r17 = (n1) r16.next();
        r15.add(new UserStatusParseUrlPreViewUtils.b(r17.a, r17.b, r17.c, r17.d));
        goto L22
    L24:
        UserStatusParseUrlPreViewUtils.c(r12, r15, r10.a, ChatHitPointExtraParams.DataSource.FROM_SDK_PUSH);
        b r18 = r10.c;
        LinkedHashSet r19 = new LinkedHashSet();
        Iterator r20 = r14.iterator();
    L26:
        if (r20.hasNext() == false) goto L28;
        r19.add(((n1) r20.next()).b);
        goto L26
    L28:
        r18.a(r19);
        goto L17
    }

    @Override // d7b.a
    public void onPushSignUrlPreview(List<UrlPreViewEntries> r2) {
        Intrinsics.checkNotNullParameter(r2, "entriesList");
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        UICallbackExecutor.execute(new d(this, r2));
    }

    public final void unregisterSource(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceKey");
        this.sources.remove(r2);
    }

    public static final /* synthetic */ void access$handlePush(PageUserStatusUrlPreviewViewModel r0, List r1) {
        r0.handlePush(r1);
    }

    public final void registerSource(Object r3, ChatHitPointExtraParams.UrlAnalysisScene r4, a r5, b r6) {
        Intrinsics.checkNotNullParameter(r3, "sourceKey");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "provider");
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.sources.put(r3, new c(r4, r5, r6));
    }
}
