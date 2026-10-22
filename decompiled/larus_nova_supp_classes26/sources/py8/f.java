package py8;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends e {
    @Override // py8.d, py8.b
    public final List<String> e() {
        List<AssociationInfo> r0 = this.a.getMyAssociations();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((AssociationInfo) r3).getDeviceMacAddress() == null) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        r5.add(String.valueOf(((AssociationInfo) r6.next()).getDeviceMacAddress()));
        goto L13
    L15:
        return r5;
    }

    public f(CompanionDeviceManager r2) {
        Intrinsics.checkNotNullParameter(r2, "companionDeviceManager");
        super(r2);
    }

    @Override // py8.d, py8.b
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "macAddress");
        Iterator<T> r0 = this.a.getMyAssociations().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (StringsKt.equals(r5, String.valueOf(((AssociationInfo) r1).getDeviceMacAddress()), true) == false) goto L4;
    L9:
        AssociationInfo r2 = (AssociationInfo) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        this.a.disassociate(r2.getId());
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // py8.d, py8.b
    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "macAddress");
        List<AssociationInfo> r0 = this.a.getMyAssociations();
        FLogger.a.d("flow_cdm", "[hasAssociated] " + r0);
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (StringsKt.equals(r5, String.valueOf(((AssociationInfo) r2).getDeviceMacAddress()), true) == false) goto L4;
    L10:
        if (((AssociationInfo) r2) != null) goto L17;
        return false;
    L17:
        return true;
    L8:
        r2 = null;
        goto L10
    }
}
