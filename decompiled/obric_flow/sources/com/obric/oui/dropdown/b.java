package com.obric.oui.dropdown;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends ObservableProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ODropdownTrigger f13194a;

    public b(ODropdownTrigger r5) {
        Boolean r10 = Boolean.FALSE;
        this.f13194a = r5;
        super(r10);
    }

    @Override // kotlin.properties.ObservableProperty
    public final void afterChange(KProperty r5, Object r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "property");
        boolean r12 = ((Boolean) r11).booleanValue();
        if (((Boolean) r10).booleanValue() == r12) goto L11;
        ODropdownTrigger r13 = this.f13194a;
        if (r12 == false) goto L8;
        r13.f13191m.setImageResource(r13.f13189k);
        r13.setBackgroundColor(r13.f13187i);
        return;
    L8:
        r13.f13191m.setImageResource(r13.f13188j);
        r13.setBackgroundColor(r13.f13186h);
        return;
    }
}
