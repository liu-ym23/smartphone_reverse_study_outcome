package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.base.BaseUiVM;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019R)\u0010\u001c\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0019¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementBasicVM;", "Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/base/BaseUiVM;", "", "firstLineDesc", "secondLineDesc", "", "updateAccessibilityDesc", "Lz91/a;", "action", "reduce", "Lcom/bytedance/live/datacontext/k;", "showProfile$delegate", "Lcom/bytedance/live/datacontext/p;", "getShowProfile", "()Lcom/bytedance/live/datacontext/k;", "showProfile", "Lcom/bytedance/live/datacontext/n;", "containerContentDescription$delegate", "getContainerContentDescription", "()Lcom/bytedance/live/datacontext/n;", "containerContentDescription", "Lcom/bytedance/live/datacontext/m;", "Lg91/a;", "_anchorContentDesc$delegate", "get_anchorContentDesc", "()Lcom/bytedance/live/datacontext/m;", "_anchorContentDesc", "Lcom/bytedance/android/live/core/utils/IReadonlyNonNull;", "anchorContentDesc", "Lcom/bytedance/live/datacontext/m;", "getAnchorContentDesc", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ElementBasicVM extends BaseUiVM {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p _anchorContentDesc$delegate;
    private final m<? extends g91.a> anchorContentDesc;
    private final p containerContentDescription$delegate;
    private final p showProfile$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ElementBasicVM.class, "showProfile", "getShowProfile()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(ElementBasicVM.class, "containerContentDescription", "getContainerContentDescription()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ElementBasicVM.class, "_anchorContentDesc", "get_anchorContentDesc()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    private final m<g91.a> get_anchorContentDesc() {
        return (m) this._anchorContentDesc$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<String> getContainerContentDescription() {
        return (n) this.containerContentDescription$delegate.a(this, $$delegatedProperties[1]);
    }

    public final k<Unit> getShowProfile() {
        return (k) this.showProfile$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.viewmodel.base.BaseUiVM
    public void reduce(z91.a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public ElementBasicVM() {
        this.showProfile$delegate = e.b(this);
        this.containerContentDescription$delegate = q.c(this);
        this._anchorContentDesc$delegate = q.d(this, new g91.a());
        this.anchorContentDesc = get_anchorContentDesc();
    }

    public final m<? extends g91.a> getAnchorContentDesc() {
        return this.anchorContentDesc;
    }

    public final void updateAccessibilityDesc(String r7, String r8) {
        g91.a r0 = (g91.a) get_anchorContentDesc().getValue();
        boolean r3 = true;
        if (r7 != null) goto L5;
    L13:
        if (r8 != null) goto L15;
    L23:
        get_anchorContentDesc().setValue(r0);
        return;
    L15:
        if (r8.length() > 0) goto L18;
        r3 = false;
    L18:
        if (r3 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L23;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r0.b = r8;
        goto L23
    L5:
        if (r7.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.a = r7;
        goto L13
    L7:
        r5 = false;
        goto L8
    }

    public static /* synthetic */ void updateAccessibilityDesc$default(ElementBasicVM r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        r1.updateAccessibilityDesc(r2, r3);
    }
}
