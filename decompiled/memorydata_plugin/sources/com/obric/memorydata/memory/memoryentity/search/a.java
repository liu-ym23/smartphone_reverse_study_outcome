package com.obric.memorydata.memory.memoryentity.search;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/search/IMemorySearchCallback;", "", "onSearchResult", "", "result", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "onSearchResultTypes", "types", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "onComplete", "onError", "errorCode", "", DTraitConstant.ERROR, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {
    void a();

    void a(int r1, String r2);

    void a(List<c> r1);

    void b(List<? extends MemorySearchResultCategory> r1);
}
