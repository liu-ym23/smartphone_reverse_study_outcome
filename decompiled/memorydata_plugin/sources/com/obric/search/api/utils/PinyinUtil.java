package com.obric.search.api.utils;

import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0086 ¨\u0006\b"}, d2 = {"Lcom/obric/search/api/utils/PinyinUtil;", "", "()V", "getPinyinByUnicode", "", "", "unicode", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PinyinUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PinyinUtil f14957a = null;

    static {
        f14957a = new PinyinUtil();
        SQLiteFts5Extension.f14967a.a();
    }

    private PinyinUtil() {
    }

    public final native List<String> getPinyinByUnicode(int r1);
}
