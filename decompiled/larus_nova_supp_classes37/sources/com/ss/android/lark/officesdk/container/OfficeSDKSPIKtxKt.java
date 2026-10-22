package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.picker.base.view.ItemViewType;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"spiByDwarf", "T", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent;", "clazz", "Ljava/lang/Class;", "(Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent;Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;", "(Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;Ljava/lang/Class;)Ljava/lang/Object;", "officesdk-core_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKSPIKtxKt {
    public static final <T> T spiByDwarf(OfficeSDKGlobalComponent r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) ((DwarfSPIEntryPoint) EntryPoints.get(r1, DwarfSPIEntryPoint.class)).dwarfSPI().get(r2);
    }

    public static final <T> T spiByDwarf(OfficeSDKUserComponent r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) ((DwarfSPIEntryPoint) EntryPoints.get(r1, DwarfSPIEntryPoint.class)).dwarfSPI().get(r2);
    }
}
