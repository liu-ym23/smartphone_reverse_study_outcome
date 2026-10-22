package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.picker.base.view.ItemViewType;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponentManagerImpl;", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponentManager;", "builder", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent$OfficeSDKGlobalComponentBuilder;", "<init>", "(Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent$OfficeSDKGlobalComponentBuilder;)V", "component", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent;", "componentLock", "", "generatedComponent", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKGlobalComponentManagerImpl implements OfficeSDKGlobalComponentManager {
    private final OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder builder;
    private volatile OfficeSDKGlobalComponent component;
    private final Object componentLock;

    public OfficeSDKGlobalComponent generatedComponent() {
        if (this.component != null) goto L15;
        Object r0 = this.componentLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.component != null) goto L9;
        this.component = this.builder.build();     // Catch: Throwable -> L12
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    L15:
        OfficeSDKGlobalComponent r2 = this.component;
        if (r2 == null) goto L19;
        return r2;
    L19:
        throw new IllegalArgumentException("OfficeSDKGlobalComponent always not null after double check.".toString());
    }

    /* JADX INFO: renamed from: generatedComponent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m36generatedComponent() {
        return generatedComponent();
    }

    @Inject
    public OfficeSDKGlobalComponentManagerImpl(OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.builder = r2;
        this.componentLock = new Object();
    }
}
