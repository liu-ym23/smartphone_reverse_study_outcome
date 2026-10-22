package sq9;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.VideoResource;
import com.larus.platform.model.creation.ResourceExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final List<ResourceExt> a(List<Resource> r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L33;
        Resource r1 = (Resource) r7.next();
        String r2 = null;
        if (r1 == null) goto L8;
        Integer r3 = r1.a;
    L9:
        if (r3 != null) goto L12;
    L18:
        if (r3 != null) goto L21;
    L29:
        if (r3 == null) goto L32;
        r3.intValue();
    L32:
        r0.add(new ResourceExt(r1, r2));
        goto L4
    L21:
        if (r3.intValue() != 2) goto L29;
        VideoResource r4 = r1.c;
        if (r4 == null) goto L32;
        ImageInfo r5 = r4.h;
        if (r5 == null) goto L32;
        Image r8 = r5.c;
        if (r8 == null) goto L32;
        r2 = r8.a;
        goto L32
    L12:
        if (r3.intValue() != 1) goto L18;
        ImageInfo r9 = r1.b;
        if (r9 == null) goto L32;
        Image r10 = r9.c;
        if (r10 == null) goto L32;
        r2 = r10.a;
        goto L32
    L8:
        r3 = null;
        goto L9
    L33:
        return r0;
    }

    public static final List<ResourceExt> b(List<Resource> r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L44;
        Resource r1 = (Resource) r8.next();
        String r2 = null;
        if (r1 == null) goto L8;
        Integer r3 = r1.a;
    L9:
        boolean r4 = true;
        if (r3 != null) goto L13;
    L19:
        if (r3 != null) goto L22;
    L30:
        if (r3 == null) goto L33;
        r3.intValue();
    L33:
        if (r1 == null) goto L40;
        Integer r5 = r1.a;
        if (r5 == null) goto L40;
        if (r5.intValue() != 3) goto L40;
    L41:
        if (r4 == true) goto L43;
        if (r2 == null) goto L4;
    L43:
        r0.add(new ResourceExt(r1, r2));
    L40:
        r4 = false;
        goto L41
    L22:
        if (r3.intValue() != 2) goto L30;
        VideoResource r6 = r1.c;
        if (r6 == null) goto L33;
        ImageInfo r9 = r6.h;
        if (r9 == null) goto L33;
        Image r10 = r9.h;
        if (r10 == null) goto L33;
        r2 = r10.a;
        goto L33
    L13:
        if (r3.intValue() != 1) goto L19;
        ImageInfo r11 = r1.b;
        if (r11 == null) goto L33;
        Image r12 = r11.h;
        if (r12 == null) goto L33;
        r2 = r12.a;
        goto L33
    L8:
        r3 = null;
        goto L9
    L44:
        return r0;
    }

    public static final List<ResourceExt> c(List<ResourceExt> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        ResourceExt r1 = (ResourceExt) r5.next();
        Resource r2 = r1.a;
        if (r2 == null) goto L8;
        boolean r3 = Intrinsics.areEqual(r2.e, Boolean.TRUE);
    L9:
        if (r3 == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        return r0;
    }

    public static final List<ResourceExt> d(UserCreation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList();
        UserCreationRefContent r6 = r5.o;
        if (r6 == null) goto L10;
        List<Resource> r7 = r6.c;
        if (r7 == null) goto L10;
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r0.add(new ResourceExt((Resource) r8.next(), null, 2));
    L10:
        return r0;
    }

    public static final String e(ResourceExt r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        Resource r4 = r3.a;
        if (r4 == null) goto L21;
        Integer r5 = r4.a;
        if (r5 == null) goto L21;
        if (r5.intValue() != 1) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L30;
        Resource r6 = r3.a;
        if (r6 == null) goto L31;
        ImageInfo r7 = r6.b;
        if (r7 == null) goto L32;
        Image r8 = r7.c;
        if (r8 != null) goto L29;
        return null;
    L29:
        return r8.a;
    L32:
        return null;
    L31:
        return null;
    L30:
        return null;
    L11:
        return r3.b;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
