package com.ss.android.lark.integrator.im.sticker;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import h6c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(a.class)
public class OfficeStickerDependencyImpl implements a {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.im.sticker.OfficeStickerDependencyImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements a6c.a {
        public AnonymousClass1() {
        }

        public final Map<String, c6c.a> b(Map<String, Resource> r7) {
            HashMap r0 = new HashMap();
            if (r7 == null) goto L14;
            Iterator<String> r1 = r7.keySet().iterator();
        L6:
            if (r1.hasNext() == false) goto L14;
            String r2 = r1.next();
            Resource r3 = r7.get(r2);
            if (r3 == null) goto L10;
            c6c.a r4 = new c6c.a(r3.a, r3.b);
        L11:
            if (r4 == null) goto L6;
            r0.put(r2, r4);
            goto L6
        L10:
            r4 = null;
        L14:
            return r0;
        }

        public final Map<String, c6c.a> a(String r5, List<String> r6) {
            ArrayList r0 = new ArrayList();
            Iterator<String> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L7;
            r0.add(new ResourceRequestBaseSet(r7.next(), r5, null, null));
            goto L4
        L7:
            return b(nmb.a.a().getCoreDependency().f().synGetResources(r0));
        }

        public Map<String, c6c.a> getResources(String r5, List<String> r6) {
            ArrayList r0 = new ArrayList();
            Iterator<String> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L7;
            r0.add(new ResourceRequestBaseSet(r7.next(), r5, null, null));
            goto L4
        L7:
            return b(nmb.a.a().getCoreDependency().f().getResources(r0));
        }

        public void getResources(String r5, List<String> r6, final IGetDataCallback<Map<String, c6c.a>> r7) {
            ArrayList r0 = new ArrayList();
            Iterator<String> r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            r0.add(new ResourceRequestBaseSet(r8.next(), r5, null, null));
            goto L4
        L6:
            nmb.a.a().getCoreDependency().f().getResources(r0, -99, new C01201(this, r7));
        }
    }

    public OfficeStickerDependencyImpl() {
    }

    public a6c.a getResourceDependency() {
        return new AnonymousClass1();
    }
}
