package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public GrowthList(int r2) {
        super(new ArrayList(r2));
    }

    public GrowthList(List<E> r3) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static <E> GrowthList<E> growthList(List<E> r2) {
        return new GrowthList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int r4, E r5) {
        int r0 = decorated().size();
        if (r4 <= r0) goto L5;
        decorated().addAll(Collections.nCopies(r4 - r0, null));
    L5:
        decorated().add(r4, r5);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int r6, Collection<? extends E> r7) {
        Collection<? extends E> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        int r0 = decorated().size();
        if (r6 <= r0) goto L5;
        decorated().addAll(Collections.nCopies(r6 - r0, null));
        boolean r1 = true;
    L7:
        if (decorated().addAll(r6, r8) == true) goto L12;
        if (r1 == false) goto L11;
        return true;
    L11:
        return false;
    L12:
        return true;
    L5:
        r1 = false;
        goto L7
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int r4, E r5) {
        int r0 = decorated().size();
        if (r4 < r0) goto L6;
        decorated().addAll(Collections.nCopies((r4 - r0) + 1, null));
    L6:
        return (E) decorated().set(r4, r5);
    }
}
