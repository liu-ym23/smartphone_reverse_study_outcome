package com.ss.android.lark.chat.export.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import uxb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/message/Content;", "Lcom/ss/android/lark/open/im/base/model/IContent;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "<init>", "()V", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Content implements b, Serializable, y28.b<Content> {
    public Content() {
    }

    public boolean isItemSame(Content r1) {
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return isContentSame((Content) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        return isItemSame((Content) r1);
    }

    public boolean isContentSame(Content r1) {
        return equals(r1);
    }
}
