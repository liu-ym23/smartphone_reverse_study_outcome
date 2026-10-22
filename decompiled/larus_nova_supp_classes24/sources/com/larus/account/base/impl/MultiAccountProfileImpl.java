package com.larus.account.base.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.base.api.IMultiAccountProfileService;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/account/base/impl/MultiAccountProfileImpl;", "Lcom/larus/account/base/api/IMultiAccountProfileService;", "<init>", "()V", "subscriptionIdentityBadge", "", "getSubscriptionIdentityBadge", "()Ljava/lang/String;", "subscriptionIdentityBadge$delegate", "Lkotlin/Lazy;", "buildIdentitySegments", "tenantName", "hasActiveSubscription", "", "activeSubscriptionDisplayName", "mode", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MultiAccountProfileImpl implements IMultiAccountProfileService {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public MultiAccountProfileImpl() {
        this.a = LazyKt.lazy(new t());
    }

    @Override // com.larus.account.base.api.IMultiAccountProfileService
    public final String a(String r10, Boolean r11, String r12, Integer r13) {
        List r0 = CollectionsKt.createListBuilder();
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L11;
        if (o0.d(r12) == false) goto L7;
        r0.add(r12);
        goto L11
    L7:
        String r14 = (String) this.a.getValue();
        if (r14 == null) goto L11;
        r0.add(r14);
    L11:
        if (r10 != null) goto L13;
    L18:
        List r15 = CollectionsKt.build(r0);
        if (r13 != null) goto L22;
    L24:
        if (r13 == null) goto L30;
        if (r13.intValue() != 2) goto L30;
        return CollectionsKt.joinToString$default(r15, " · ", null, null, 0, null, null, 62, null);
    L30:
        return CollectionsKt.joinToString$default(r15, "，", null, null, 0, null, null, 62, null);
    L22:
        if (r13.intValue() != 1) goto L24;
        return CollectionsKt.joinToString$default(r15, "，", null, null, 0, null, null, 62, null);
    L13:
        if ((!StringsKt.isBlank(r10)) == true) goto L16;
        r10 = null;
    L16:
        if (r10 == null) goto L18;
        r0.add(r10);
        goto L18
    }
}
