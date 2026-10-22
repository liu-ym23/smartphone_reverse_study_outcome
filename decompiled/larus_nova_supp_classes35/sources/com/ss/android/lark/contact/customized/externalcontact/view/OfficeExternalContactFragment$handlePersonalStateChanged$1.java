package com.ss.android.lark.contact.customized.externalcontact.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeExternalContactFragment$handlePersonalStateChanged$1 extends FunctionReferenceImpl implements Function1<List<? extends mtb.b>, Unit> {
    public OfficeExternalContactFragment$handlePersonalStateChanged$1(Object r8) {
        super(1, r8, OfficeExternalContactFragment.class, "showDoubaoContacts", "showDoubaoContacts(Ljava/util/List;)V", 0);
    }

    public final void invoke(List<? extends mtb.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        OfficeExternalContactFragment r0 = (OfficeExternalContactFragment) ((CallableReference) this).receiver;
        int r1 = OfficeExternalContactFragment.r;
        r0.getClass();
        if (r3.isEmpty() == false) goto L5;
        r0.ba0();
        r0.da0(CollectionsKt.emptyList());
        return;
    L5:
        r0.ca0();
        r0.da0(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((List) r1);
        return Unit.INSTANCE;
    }
}
