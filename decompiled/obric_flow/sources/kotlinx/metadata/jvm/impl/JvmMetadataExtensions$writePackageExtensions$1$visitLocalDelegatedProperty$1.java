package kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import au.l;
import au.n;
import bu.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.metadata.internal.metadata.ProtoBuf$Property;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lau/n;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lau/n;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class JvmMetadataExtensions$writePackageExtensions$1$visitLocalDelegatedProperty$1 extends Lambda implements Function1<n, Unit> {
    final /* synthetic */ l $proto;

    public JvmMetadataExtensions$writePackageExtensions$1$visitLocalDelegatedProperty$1(l r5) {
        this.$proto = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(n r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(n r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        l r10 = this.$proto;
        q r11 = i.f999b;
        ProtoBuf$Property r12 = r5.h();
        if (r12.isInitialized() == false) goto L7;
        r10.f(r11, r12);
        return;
    L7:
        throw new UninitializedMessageException(r12);
    }
}
