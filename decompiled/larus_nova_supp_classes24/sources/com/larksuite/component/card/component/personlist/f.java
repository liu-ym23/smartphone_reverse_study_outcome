package com.larksuite.component.card.component.personlist;

import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements com.larksuite.component.card.component.personlist.avatar.f {
    public final /* synthetic */ PersonListLynxUI a;

    public static final class a implements com.larksuite.component.card.component.personlist.avatar.b {
        public final /* synthetic */ PersonListLynxUI a;

        @Override // com.larksuite.component.card.component.personlist.avatar.b
        public final void a() {
            AppCompatTextView r0 = (PersonListTextView) PersonListLynxUI.M(this.a);
            if (r0 == null) goto L6;
            r0.postInvalidate();
            return;
        }

        public a(PersonListLynxUI r1) {
            this.a = r1;
        }
    }

    public f(PersonListLynxUI r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.f
    public final void a(Map<String, wy7.c> r5) {
        Intrinsics.checkNotNullParameter(r5, "userMap");
        Iterator<Map.Entry<String, wy7.c>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        wy7.c r0 = r6.next().getValue();
        if (r0 == null) goto L8;
        String r1 = r0.a;
    L9:
        if (r1 == null) goto L4;
        Lazy<SimpleUserLoader> r2 = SimpleUserLoader.d;
        SimpleUserLoader.a.a().c(r0.a, new a(this.a));
        goto L4
    L8:
        r1 = null;
        goto L9
    }
}
