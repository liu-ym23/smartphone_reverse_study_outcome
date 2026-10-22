package fs9;

import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 {
    public static final UserCreationModel a(UserCreationModel r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        UserCreationModel r0 = UserCreationModel.a(r2, new ArrayList());
        List<UserCreation> r1 = r0.b();
        if (r1 == null) goto L9;
        List<UserCreation> r3 = r2.b();
        if (r3 == null) goto L7;
        List<UserCreation> r4 = r3;
    L8:
        r1.addAll(r4);
        goto L9
    L7:
        r4 = new ArrayList();
    L9:
        return r0;
    }

    public static final boolean b(UserCreationModel r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List<UserCreation> r5 = r4.b();
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        List<UserCreation> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L29;
        Integer r0 = ((UserCreation) r7.next()).c;
        if (r0 != null) goto L17;
    L19:
        boolean r1 = false;
    L20:
        if (r1 == false) goto L12;
        return true;
    L17:
        if (r0.intValue() != 5) goto L19;
        r1 = true;
        goto L20
    L29:
        return false;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return false;
    }

    public static final void c(UserCreationModel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List<UserCreation> r0 = r1.b();
        if (r0 == null) goto L8;
        UserCreation r2 = (UserCreation) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L8;
        String r3 = r2.a;
        if (r3 == null) goto L8;
    L9:
        r1.g(r3);
        return;
    L8:
        r3 = "";
        goto L9
    }
}
