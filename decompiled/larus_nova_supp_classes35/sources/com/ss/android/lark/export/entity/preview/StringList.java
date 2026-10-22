package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/StringList;", "Ljava/io/Serializable;", "stringList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "getStringList", "()Ljava/util/List;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StringList implements Serializable {
    private final List<String> stringList;

    public final List<String> getStringList() {
        return this.stringList;
    }

    public StringList(List<String> r1) {
        this.stringList = r1;
    }
}
