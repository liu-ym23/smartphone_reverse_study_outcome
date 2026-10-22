package com.ss.android.lark.chat.entity.doubao;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/doubao/DoubaoImageSet;", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "<init>", "()V", "id", BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "doubaoContent", BuildConfig.FLAVOR, "getDoubaoContent", "()Ljava/lang/Object;", "setDoubaoContent", "(Ljava/lang/Object;)V", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoImageSet extends ImageSet {
    private Object doubaoContent;
    private String id;

    public DoubaoImageSet() {
    }

    public final Object getDoubaoContent() {
        return this.doubaoContent;
    }

    public final String getId() {
        return this.id;
    }

    public final void setDoubaoContent(Object r1) {
        this.doubaoContent = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }
}
