package f0a;

import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AudioResource;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.VideoResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<a> a(UserCreationRefContent r14, boolean r15) {
        if (r14 == null) goto L92;
        List<Resource> r16 = r14.c;
        if (r16 == null) goto L92;
        ArrayList r0 = new ArrayList();
        Iterator<T> r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L98;
        Resource r1 = (Resource) r17.next();
        Object r2 = null;
        if (r1 != null) goto L12;
    L89:
        if (r2 == null) goto L7;
        r0.add(r2);
        goto L7
    L12:
        if (r15 == false) goto L57;
        Integer r6 = r1.a;
        if (r6 != null) goto L17;
    L32:
        if (r6 != null) goto L35;
    L39:
        if (r6 == null) goto L89;
        if (r6.intValue() != 1) goto L89;
        if (Intrinsics.areEqual(r1.e, Boolean.TRUE) == false) goto L46;
        ResourceType r4 = ResourceType.AVATAR;
    L47:
        ResourceType r7 = r4;
        ImageInfo r3 = r1.b;
        if (r3 == null) goto L53;
        Image r5 = r3.c;
        if (r5 == null) goto L53;
        Image r8 = r5;
    L56:
        Object r9 = new a(r7, r8, null, null, 12);
    L68:
        r2 = r9;
    L53:
        if (r3 == null) goto L55;
        r2 = r3.a;
    L55:
        r8 = r2;
        goto L56
    L46:
        r4 = ResourceType.IMAGE;
        goto L47
    L35:
        if (r6.intValue() != 3) goto L39;
        AudioResource r11 = r1.d;
        if (r11 == null) goto L89;
        Object r10 = new a(ResourceType.AUDIO, null, null, r11, 4);
    L76:
        r2 = r10;
        goto L89
    L17:
        if (r6.intValue() != 2) goto L32;
        ResourceType r12 = ResourceType.VIDEO;
        VideoResource r13 = r1.c;
        if (r13 == null) goto L26;
        ImageInfo r18 = r13.h;
        if (r18 == null) goto L26;
        Image r19 = r18.c;
        if (r19 == null) goto L26;
        Image r110 = r19;
    L31:
        r9 = new a(r12, r110, r13, null, 8);
    L26:
        if (r13 == null) goto L30;
        ImageInfo r20 = r13.h;
        if (r20 == null) goto L30;
        r2 = r20.a;
    L30:
        r110 = r2;
        goto L31
    L57:
        Integer r21 = r1.a;
        if (r21 != null) goto L61;
    L69:
        if (r21 != null) goto L72;
    L77:
        if (r21 == null) goto L89;
        if (r21.intValue() != 1) goto L89;
        if (Intrinsics.areEqual(r1.e, Boolean.TRUE) == false) goto L84;
        ResourceType r22 = ResourceType.AVATAR;
    L85:
        ResourceType r23 = r22;
        ImageInfo r24 = r1.b;
        if (r24 == null) goto L88;
        r2 = r24.h;
    L88:
        r9 = new a(r23, r2, null, null, 12);
        goto L68
    L84:
        r22 = ResourceType.IMAGE;
        goto L85
    L72:
        if (r21.intValue() != 3) goto L77;
        AudioResource r111 = r1.d;
        if (r111 == null) goto L89;
        r10 = new a(ResourceType.AUDIO, null, null, r111, 4);
        goto L76
    L61:
        if (r21.intValue() != 2) goto L69;
        ResourceType r25 = ResourceType.VIDEO;
        VideoResource r26 = r1.c;
        if (r26 == null) goto L67;
        ImageInfo r27 = r26.h;
        if (r27 == null) goto L67;
        r2 = r27.h;
    L67:
        r9 = new a(r25, r2, null, null, 12);
        goto L68
    L98:
        return r0;
    L92:
        return CollectionsKt.emptyList();
    }
}
