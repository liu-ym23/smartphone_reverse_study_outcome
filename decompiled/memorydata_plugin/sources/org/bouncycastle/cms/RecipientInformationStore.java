package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.util.Iterable;

/* JADX INFO: loaded from: classes7.dex */
public class RecipientInformationStore implements Iterable<RecipientInformation> {
    private final List all;
    private final Map table;

    public RecipientInformationStore(Collection<RecipientInformation> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        this.table = new HashMap();
        Iterator r0 = r8.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        RecipientInformation r2 = (RecipientInformation) ZeusTransformUtils.preCheckCast(r0.next(), RecipientInformation.class, "com.obric.memorydata.plugin");
        RecipientId r3 = r2.getRID();
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(this.table.get(r3), ArrayList.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r4 = new ArrayList(1);
        this.table.put(r3, r4);
    L8:
        r4.add(r2);
        goto L4
    L9:
        this.all = new ArrayList(r8);
    }

    public Collection<RecipientInformation> getRecipients() {
        return new ArrayList(this.all);
    }

    @Override // java.lang.Iterable
    public Iterator<RecipientInformation> iterator() {
        return getRecipients().iterator();
    }
}
