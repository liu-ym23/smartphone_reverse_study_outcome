package com.ss.android.lark.officesdk.container;

import android.app.Application;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.picker.base.view.ItemViewType;
import e0c.k;
import e0c.l;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentManagerImpl;", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentManager;", "application", "Landroid/app/Application;", "userSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "builder", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentBuilder;", "<init>", "(Landroid/app/Application;Lcom/ss/android/lark/passportc/entity/UserSession;Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentBuilder;)V", "component", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;", "componentLock", "", "userComponent", "Lcom/ss/android/lark/passportc/dwarf/UserComponent;", "generatedComponent", "findComponent", "Companion", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKUserComponentManagerImpl implements OfficeSDKUserComponentManager {
    public static final Companion Companion = null;
    private static final String TAG = "OfficeSDKUserMgr";
    private final Application application;
    private final OfficeSDKUserComponentBuilder builder;
    private volatile OfficeSDKUserComponent component;
    private final Object componentLock;
    private final l userComponent;
    private final UserSession userSession;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentManagerImpl$Companion;", "", "<init>", "()V", "TAG", "", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager
    public OfficeSDKUserComponent generatedComponent() {
        if (this.component != null) goto L16;
        Object r0 = this.componentLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.component != null) goto L9;
        this.component = this.builder.userSession(this.userSession).build();     // Catch: Throwable -> L12
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    L16:
        return this.component;
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager
    public OfficeSDKUserComponent findComponent() {
        return this.component;
    }

    @Inject
    public OfficeSDKUserComponentManagerImpl(Application r2, UserSession r3, OfficeSDKUserComponentBuilder r4) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r3, "userSession");
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.application = r2;
        this.userSession = r3;
        this.builder = r4;
        this.componentLock = new Object();
        this.userComponent = ((v) k.a(r2, v.class)).c(r3);
    }
}
