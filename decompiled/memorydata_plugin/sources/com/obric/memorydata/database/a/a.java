package com.obric.memorydata.database.a;

import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"COMMON_COLUMN_NAMES", "", "", "getCOMMON_COLUMN_NAMES", "()Ljava/util/List;", "COMMON_COLUMN_NAMES$delegate", "Lkotlin/Lazy;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f8802a = null;

    static {
        f8802a = LazyKt.lazy($$Lambda$a$7tdxE7Pmnb88wRkNpIb4q4VXq8.INSTANCE);
    }

    public static final List<String> a() {
        return (List) ZeusTransformUtils.preCheckCast(f8802a.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    private static final List b() {
        return CollectionsKt.listOf(new String[]{"common1", "common2", "common3", "common4", "common5", "common6", "common7", "common8", "common9", "common10", "common11", "common12", "common13", "common14", "common15", "common16", "common17", "common18", "common19", "common20", ExtraEntity.KEY_EXTRA_1, ExtraEntity.KEY_EXTRA_2, ExtraEntity.KEY_EXTRA_3, ExtraEntity.KEY_EXTRA_4, ExtraEntity.KEY_EXTRA_5, ExtraEntity.KEY_EXTRA_6, ExtraEntity.KEY_EXTRA_7, ExtraEntity.KEY_EXTRA_8, ExtraEntity.KEY_EXTRA_9, ExtraEntity.KEY_EXTRA_10, "extra11", "extra12", "extra13", "extra14", "extra15", "extra16", "extra17", "extra18", "extra19", "extra20"});
    }

    /* JADX INFO: renamed from: lambda$7tdxE7Pmnb88wRkNpIb4q4V-Xq8, reason: not valid java name */
    public static /* synthetic */ List m530lambda$7tdxE7Pmnb88wRkNpIb4q4VXq8() {
        return b();
    }
}
