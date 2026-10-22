package com.ss.android.lark.feed.app.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/DigestElement;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "<init>", "()V", "Lcom/ss/android/lark/feed/app/entity/EmojiProperty;", "Lcom/ss/android/lark/feed/app/entity/TextProperty;", "Lcom/ss/android/lark/feed/app/entity/TextWithEmojiProperty;", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DigestElement implements b<DigestElement>, Serializable {
    private DigestElement() {
    }

    public /* synthetic */ DigestElement(DefaultConstructorMarker r1) {
        this();
    }

    public abstract /* synthetic */ boolean isContentSame(b r1);

    public abstract /* synthetic */ boolean isItemSame(b r1);
}
