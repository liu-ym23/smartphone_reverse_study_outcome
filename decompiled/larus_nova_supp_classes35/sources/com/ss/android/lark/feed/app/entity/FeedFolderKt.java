package com.ss.android.lark.feed.app.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getRuleForFolder", "Lcom/ss/android/lark/feed/app/entity/FeedFolder$AdditionRule;", BuildConfig.FLAVOR, "folderId", BuildConfig.FLAVOR, "feed-export_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FeedFolderKt {
    public static final FeedFolder.AdditionRule getRuleForFolder(List<FeedFolder.AdditionRule> r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        if (((FeedFolder.AdditionRule) r0).getFolderId() != r5) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L13:
        return (FeedFolder.AdditionRule) r0;
    L8:
        r1 = false;
        goto L9
    L11:
        r0 = null;
        goto L13
    }
}
