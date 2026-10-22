package com.bytedance.als.dsl;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.objectcontainer.ObjectContainer;
import com.bytedance.objectcontainer.ObjectContainerBuilder;
import com.bytedance.objectcontainer.StringName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/als/dsl/OCAdapterViewModel;", "Landroidx/lifecycle/ViewModel;", a.KEY_SHOPPING_GUIDE_NAME, "", "parentObjectContainer", "Lcom/bytedance/objectcontainer/ObjectContainer;", "config", "Lcom/bytedance/als/dsl/Config;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "(Ljava/lang/String;Lcom/bytedance/objectcontainer/ObjectContainer;Lcom/bytedance/als/dsl/Config;[Ljava/lang/StackTraceElement;)V", "container", "objectContainerBuilder", "Lcom/bytedance/objectcontainer/ObjectContainerBuilder;", "getObjectContainerBuilder", "()Lcom/bytedance/objectcontainer/ObjectContainerBuilder;", "[Ljava/lang/StackTraceElement;", "build", "get", "isCreated", "", "isCreated$als_release", "als_release"}, k = 1, mv = {1, 4, 1})
public final class OCAdapterViewModel extends ViewModel {
    private ObjectContainer container;
    private final ObjectContainerBuilder objectContainerBuilder;
    private final StackTraceElement[] stackTrace;

    public final ObjectContainer build() {
        ObjectContainerBuilder r0 = this.objectContainerBuilder;
        r0.getClass();
        ObjectContainer r1 = new ObjectContainer(r0.a, r0.b, new ObjectContainerBuilder[]{r0});
        r1.a.a();
        this.container = r1;
        return r1;
    }

    public final ObjectContainer get() {
        ObjectContainer r0 = this.container;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return build();
    }

    public final boolean isCreated$als_release() {
        if (this.container == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ObjectContainerBuilder getObjectContainerBuilder() {
        return this.objectContainerBuilder;
    }

    public OCAdapterViewModel(String r10, ObjectContainer r11, Config r12, StackTraceElement[] r13) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r12, "config");
        this.stackTrace = r13;
        if (r11 != null) goto L5;
        ObjectContainerBuilder r14 = new ObjectContainerBuilder(new StringName(r10 + " data{}"), null);
    L6:
        this.objectContainerBuilder = r14;
        return;
    L5:
        r14 = new ObjectContainerBuilder(new StringName(r10 + " data{}"), r11);
        goto L6
    }

    public /* synthetic */ OCAdapterViewModel(String r10, ObjectContainer r11, Config r12, StackTraceElement[] r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 8) == 0) goto L8;
        r13 = null;
    L8:
        this(r10, r11, r12, r13);
    }
}
