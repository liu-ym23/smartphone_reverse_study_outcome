package com.obric.memorydata.memory.ui.list;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchCallback;", "Lcom/obric/memorydata/memory/memoryentity/search/IMemorySearchCallback;", "cache", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/SearchResultCache;)V", "onSearchResult", "", "result", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "onSearchResultTypes", "types", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "onComplete", "onError", "errorCode", "", DTraitConstant.ERROR, "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bg implements com.obric.memorydata.memory.memoryentity.search.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f11235b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchCallback$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11234a = new a(null);
    }

    public bg(bh r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        this.f11235b = r2;
    }

    @Override // com.obric.memorydata.memory.memoryentity.search.a
    public void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SearchCallback", "onComplete, size: " + this.f11235b.d(), false, 4, null);
        this.f11235b.c();
    }

    @Override // com.obric.memorydata.memory.memoryentity.search.a
    public void a(int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, DTraitConstant.ERROR);
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SearchCallback", "onError, errorCode: " + r8 + ", errorMsg: " + r9, null, 4, null);
        this.f11235b.a(r8, r9);
    }

    @Override // com.obric.memorydata.memory.memoryentity.search.a
    public void a(List<com.obric.memorydata.memory.memoryentity.search.c> r8) {
        List<com.obric.memorydata.memory.memoryentity.search.c> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "result");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SearchCallback", "onSearchResult, size: " + r9.size(), false, 4, null);
        this.f11235b.a(r9);
    }

    @Override // com.obric.memorydata.memory.memoryentity.search.a
    public void b(List<? extends MemorySearchResultCategory> r8) {
        List<? extends MemorySearchResultCategory> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "types");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SearchCallback", "onSearchResultTypes, size: " + r9.size(), false, 4, null);
        this.f11235b.b(r9);
    }
}
