package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\r\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/internal/OfficeSDKProvider;", "", "<init>", "()V", "instance", "Lcom/ss/android/lark/officesdk/internal/IOfficeSDKInternal;", "getInstance", "reset", "", "reset$officesdk_core_release", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKProvider {
    public static final OfficeSDKProvider INSTANCE = null;
    private static volatile a instance;

    static {
        INSTANCE = new OfficeSDKProvider();
    }

    private OfficeSDKProvider() {
    }

    public final void reset$officesdk_core_release() {
        monitor-enter(this);
        instance = null;     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final a getInstance() {
        a r0 = instance;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = instance;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = new f();     // Catch: Throwable -> L10
        instance = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }
}
