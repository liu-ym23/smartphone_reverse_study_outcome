package com.larksuite.component.blockit.props;

import android.app.Application;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import com.larksuite.component.blockit.entity.ItemTags;
import com.larksuite.component.blockit.entity.TagInstance;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public final d a;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ i c;

        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7, types: [android.widget.TextView, com.larksuite.component.blockit.props.PropsView] */
        public final void a() {
            d r0 = this.c.a;
            WeakReference r1 = (WeakReference) ((ConcurrentHashMap) r0.a).get(this.a);
            if (r1 == null) goto L5;
            ?? r2 = (PropsView) r1.get();
        L6:
            if (r2 == 0) goto L8;
            r2.setText(c.a(this.b, r2.e));
            r2.setMovementMethod(LinkMovementMethod.getInstance());
        L8:
            d r3 = this.c.a;
            List r4 = (List) ((ConcurrentHashMap) r3.b).get(this.a);
            if (CollectionUtils.isEmpty(r4) == true) goto L14;
            Iterator r5 = r4.iterator();
        L12:
            if (r5.hasNext() == false) goto L16;
            com.larksuite.component.blockit.props.a r6 = (com.larksuite.component.blockit.props.a) r5.next();
            this.b.size();
            r6.a();
            ((SpannableStringBuilder) c.a(this.b, null)).toString();
            r6.b();
            goto L12
        L16:
            return;
        L14:
            return;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(i r1, String r2, List r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public static final i a = null;

        static {
            a = new i();
        }
    }

    public i() {
        this.a = new d();
    }

    public final void a(final String r7, Map<String, ItemTags> r8) {
        final Application r0 = LarkContext.getApplication();
        if (z.e(r0) == false) goto L6;
        final Future<?> r1 = CoreThreadPool.getDefault().getFixedThreadPool().submit(new g(this, r0, r7));
        CoreThreadPool.getBackgroundHandler().postDelayed(new h(r1), 5000);
    L6:
        ArrayList r2 = new ArrayList();
        Iterator<ItemTags> r9 = r8.values().iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        ItemTags r3 = r9.next();
        if (TextUtils.equals(r7, r3.uniqId) == false) goto L8;
        Iterator<TagInstance> r4 = r3.tags.iterator();
    L13:
        if (r4.hasNext() == false) goto L8;
        TagInstance r5 = r4.next();
        TagInstance.BasicTagInfo r6 = r5.tagInfo;
        r2.add(new f(r6.name, r5.appLink, r6.tagId));
        goto L13
    L15:
        UICallbackExecutor.execute(new a(this, r7, r2));
    }
}
