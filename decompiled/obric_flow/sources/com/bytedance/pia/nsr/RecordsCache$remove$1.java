package com.bytedance.pia.nsr;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "", "Lcom/bytedance/pia/nsr/i;", "kotlin.jvm.PlatformType", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RecordsCache$remove$1 extends Lambda implements Function1<Pair<? extends Long, ? extends i>, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f7168a;

    public RecordsCache$remove$1(i r5) {
        this.f7168a = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Pair<? extends Long, ? extends i> r5) {
        return Boolean.valueOf(Intrinsics.areEqual(r5.getSecond(), this.f7168a));
    }
}
