package com.ss.android.lark.feed.app.entity;

import com.bytedance.lark.pb.feed.v1.FlagSortingRule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolderSpecialSetting;", "Ljava/io/Serializable;", "flagSortingRule", "Lcom/bytedance/lark/pb/feed/v1/FlagSortingRule;", "<init>", "(Lcom/bytedance/lark/pb/feed/v1/FlagSortingRule;)V", "getFlagSortingRule", "()Lcom/bytedance/lark/pb/feed/v1/FlagSortingRule;", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedFolderSpecialSetting implements Serializable {
    private final FlagSortingRule flagSortingRule;

    public final FlagSortingRule getFlagSortingRule() {
        return this.flagSortingRule;
    }

    public FeedFolderSpecialSetting(FlagSortingRule r2) {
        Intrinsics.checkNotNullParameter(r2, "flagSortingRule");
        this.flagSortingRule = r2;
    }
}
