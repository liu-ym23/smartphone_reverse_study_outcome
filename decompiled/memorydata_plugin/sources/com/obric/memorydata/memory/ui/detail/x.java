package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailGlobalBinding;
import com.obric.memorydata.memory.ui.list.MemorySourceFilter;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\b&\u0018\u0000 \u0015*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0015B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00130\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0016R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lcom/obric/memorydata/memory/ui/data/MemoryItemViewHolder;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "bindCapsule", "", "item", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "showCalendar", "", "keyInfoMap", "", "", "", "showAnimation", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class x<T extends ViewBinding> extends com.obric.memorydata.memory.ui.data.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10883b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f10884a;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ \u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "createCardViewHolder", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailBinding;", "parent", "Landroid/view/ViewGroup;", "createGlobalViewHolder", "Lcom/obric/memorydata/memory/ui/detail/GlobalMemoryViewHolder;", "onSendCapsuleEvent", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "", "extractAppAndPkgName", "Lkotlin/Pair;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final f a(ViewGroup r3, Function1<? super u.a, Unit> r4) {
            Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r2, "onSendCapsuleEvent");
            ItemMemoryDetailGlobalBinding r5 = ItemMemoryDetailGlobalBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
            Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
            return new f(r5, r2);
        }

        public final x<ItemMemoryDetailBinding> a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            ItemMemoryDetailBinding r2 = ItemMemoryDetailBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
            Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
            return (x) ZeusTransformUtils.preCheckCast(new d(r2), x.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final Pair<String, String> a(MemoryEntity r3) {
            Intrinsics.checkNotNullParameter(r3, "memoryEntity");
            if (r3.getProductType() != 20) goto L7;
            return TuplesKt.to(MemorySourceFilter.Companion.a(r3.getProductType(), r3.getSourceAppName()), r3.getSourcePackageName());
        L7:
            if (r3.getSourceAppName() == null) goto L11;
            String r2 = r3.getSourceAppName();
            String r4 = r3.getSourcePackageName();
        L27:
            return TuplesKt.to(r2, r4);
        L11:
            if (ZeusTransformUtils.instanceOf(r3, CollectContentMemoryEntity.class) == false) goto L14;
            r2 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getAppName();
            r4 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getAppPkgName();
            goto L27
        L14:
            if (ZeusTransformUtils.instanceOf(r3, CollectStoreMemoryEntity.class) == false) goto L17;
            r2 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAppName();
            r4 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAppPkgName();
            goto L27
        L17:
            if (com.obric.memorydata.database.model.e.f9611a.a(r3.getProductType()) == true) goto L26;
            if (r3.getProductType() == 11) goto L26;
            if (r3.getProductType() != 1002) goto L28;
            r2 = at.a(ZeusTransformUtils.mapRes(R.string.memory_card_memory_source_app_oauto, TypedValues.Custom.S_STRING, "memory_card_memory_source_app_oauto"));
            r4 = "com.larus.nova";
            goto L27
        L28:
            return TuplesKt.to(null, null);
        L26:
            return TuplesKt.to(at.a(com.obric.memorydata.memory.ui.i.f10968a.a(r3.getProductType()).a()), null);
        }
    }

    static {
        f10883b = new a(null);
    }

    public x(T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r3, ViewBinding.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "binding");
        View r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        super(r0);
        this.f10884a = r4;
    }

    @JvmStatic
    public static final Pair<String, String> a(MemoryEntity r1) {
        return f10883b.a(r1);
    }

    public static /* synthetic */ void a(x r2, com.obric.memorydata.memory.ui.data.a r3, boolean r4, Map r5, boolean r6, int r7, Object r8) {
        Map<String, ? extends List<String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
        if ((r7 & 2) == 0) goto L8;
        r4 = false;
    L8:
        if ((r7 & 4) == 0) goto L11;
        r9 = MapsKt.emptyMap();
    L11:
        if ((r7 & 8) == 0) goto L13;
        r6 = false;
    L13:
        r2.a(r3, r4, r9, r6);
        return;
    L16:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindCapsule");
    }

    public void a(com.obric.memorydata.memory.ui.data.a r1, boolean r2, Map<String, ? extends List<String>> r3, boolean r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r0, "keyInfoMap");
    }

    public final T c() {
        return this.f10884a;
    }
}
