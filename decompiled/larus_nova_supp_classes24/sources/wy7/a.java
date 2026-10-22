package wy7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.avatar.f;
import com.larksuite.component.card.component.personlist.detail.PersonListAdapter;
import com.larksuite.component.card.component.personlist.detail.PersonListFragment;
import com.larksuite.component.card.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements f {
    public final /* synthetic */ PersonListFragment a;

    public a(PersonListFragment r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.f
    public final void a(Map<String, c> r10) {
        Intrinsics.checkNotNullParameter(r10, "userMap");
        PersonListAdapter r0 = this.a.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "personMap");
        Iterator r2 = ((ArrayList) r0.a).iterator();
        int r4 = 0;
    L7:
        if (r2.hasNext() == false) goto L54;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        PersonInfo r7 = (PersonInfo) r5;
        if (k.b(r7.getId()) == false) goto L53;
        if (r10.containsKey(r7.getId()) == false) goto L53;
        String r8 = r7.getAvatarKey();
        boolean r9 = true;
        if (r8 != null) goto L18;
    L21:
        boolean r11 = true;
    L22:
        if (r11 == false) goto L34;
        c r12 = r10.get(r7.getId());
        if (r12 == null) goto L26;
        String r13 = r12.a;
    L28:
        if (k.b(r13) == false) goto L34;
        c r14 = r10.get(r7.getId());
        if (r14 == null) goto L32;
        String r15 = r14.a;
    L33:
        r7.setAvatarKey(r15);
        goto L34
    L32:
        r15 = null;
        goto L33
    L26:
        r13 = null;
    L34:
        String r16 = r7.getContent();
        if (r16 != null) goto L37;
    L40:
        if (r9 == false) goto L52;
        c r17 = r10.get(r7.getId());
        if (r17 == null) goto L44;
        String r19 = r17.b;
    L46:
        if (k.b(r19) == false) goto L52;
        c r20 = r10.get(r7.getId());
        if (r20 == null) goto L50;
        String r21 = r20.b;
    L51:
        r7.setContent(r21);
        goto L52
    L50:
        r21 = null;
        goto L51
    L44:
        r19 = null;
    L52:
        ListProtector.set(r0.a, r4, r7);
        r0.notifyItemChanged(r4);
        goto L53
    L37:
        if (r16.length() == 0) goto L40;
        r9 = false;
        goto L40
    L18:
        if (r8.length() == 0) goto L21;
        r11 = false;
    L53:
        r4 = r6;
        goto L7
    }
}
